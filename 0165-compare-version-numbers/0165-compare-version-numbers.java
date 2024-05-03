class Solution {
    public int compareVersion(String version1, String version2) {
        int size1 = version1.length(), size2 = version2.length();
        for (int i = 0, j = 0, n, m; i < size1 || j < size2; i++, j++) {
            n = 0;
            m = 0;
            while (i < size1 && version1.charAt(i) != '.')
                n = n * 10 + (version1.charAt(i++) - '0');
            while (j < size2 && version2.charAt(j) != '.')
                m = m * 10 + (version2.charAt(j++) - '0');
            if (n < m)
                return -1;
            else if (n > m)
                return 1;
        }
        return 0;
    }
}