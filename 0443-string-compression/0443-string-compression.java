class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0; // where we write compressed chars

        for (int i = 0; i < n;) {
            char current = chars[i];
            int count = 0;

            // count consecutive chars
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            // write the char
            chars[index++] = current;

            // if count > 1, write the digits
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; // return new length
    }
}