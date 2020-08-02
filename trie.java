public class trie {
    public static class Node {
        Node[] childs;
        int WordEnd = 0;
        String wordF = "";

        Node() {
            childs = new Node[26];
            WordEnd = 0;
            wordF = "";
        }
    }

    static Node root = null;

    public static void main(String[] args) {
        root = new Node();
        insert("abcd");
    }

    public static void insert(String word) {
        Node curr = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i); // word[i];
            int idx = ch - 'a';
            if (curr.childs[idx] == null)
                curr.childs[idx] = new Node();
            curr = curr.childs[idx];
        }
        curr.WordEnd++;
        curr.wordF = word;
    }

    public static boolean search(String word) {
        Node curr = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i); // word[i];
            int idx = ch - 'a';
            curr = curr.childs[idx];
            if (curr == null)
                return false;
        }
        if (curr.WordEnd > 0)
            return true;
        return false;
    }

    public static boolean startsWith(String str) {
        Node curr = root;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i); // word[i];
            int idx = ch - 'a';
            curr = curr.childs[idx];
            if (curr == null)
                return false;
        }
        return true;
    }
}