class EventEmitter {

    constructor() {
        this.events = {};
    }

    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {

        if (!this.events[eventName]) {
            this.events[eventName] = [];
        }

        this.events[eventName].push(callback);

        return {
            unsubscribe: () => {

                const callbacks = this.events[eventName];

                const index = callbacks.indexOf(callback);

                if (index !== -1) {
                    callbacks.splice(index, 1);
                }
            }
        };
    }

    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args) {

        if (!this.events[eventName]) {
            return [];
        }

        let result = [];

        for (let callback of this.events[eventName]) {
            result.push(callback(...args));
        }

        return result;
    }
}