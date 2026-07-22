Array.prototype.last = function() {

    if (this.length === 0) {
        return -1;
    }

    let lastElement = -1;

    for (let i = 0; i < this.length; i++) {
        lastElement = this[i];
    }

    return lastElement;
};