public class L002 {
    public static void main(String[] args) {
        System.out.println(floodfill(0, 0, 3, 3, new int[4][4], ""));
    }

    public static int mazepath_HV(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        if (sr + 1 <= er)
            count += mazepath_HV(sr + 1, sc, er, ec, ans + "H");
        if (sc + 1 <= ec)
            count += mazepath_HV(sr, sc + 1, er, ec, ans + "V");
        return count;
    }

    public static int mazepath_HVD(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        if (sr + 1 <= er)
            count += mazepath_HVD(sr + 1, sc, er, ec, ans + "H");
        if (sc + 1 <= ec)
            count += mazepath_HVD(sr, sc + 1, er, ec, ans + "V");
        if (sc + 1 <= ec && sr + 1 <= er)
            count += mazepath_HVD(sr + 1, sc + 1, er, ec, ans + "D");

        return count;
    }

    static int[][] dir = { { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public static int floodfill(int sr, int sc, int er, int ec, int[][] board, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }
        board[sr][sc] = 2;
        int count = 0;
        for (int i = 0; i < dir.length; i++) {
            int newrow = sr + dir[i][0];
            int newcol = sc + dir[i][1];
            if (isValid(newrow, newcol, board)) {
                count += floodfill(newrow, newcol, er, ec, board, ans + "d" + i);
            }
        }

        board[sr][sc] = 0;
        return count;
    }

    public static boolean isValid(int r, int c, int[][] board) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == 2)
            return false;
        return true;
    }

    public static int permutation1D(boolean[] boxes, int qpsf, int tnq, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;

        for (int i = 0; i < boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i] = true;
                count += permutation1D(boxes, qpsf + 1, tnq, ans + "b" + i + "q" + qpsf);
                boxes[i] = false;
            }
        }
        return count;
    }

    public static int combination1D(boolean[] boxes, int qpsf, int tnq, int idx, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;

        for (int i = idx; i < boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i] = true;
                count += combination1D(boxes, qpsf + 1, tnq, i + 1, ans + "b" + i + "q" + qpsf);
                boxes[i] = false;
            }
        }
        return count;
    }

    public static int nqueen(boolean[][] boxes, int qpsf, int tnq, int idx, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;

        for (int i = idx; i < boxes.length * boxes[0].length; i++) {
            int row = i / boxes[0].length;
            int col = i % boxes[0].length;
            if (isValid_(row, col, boxes)) {
                boxes[row][col] = true;
                count += nqueen(boxes, qpsf + 1, tnq, i + 1, ans + "b" + i + "q" + qpsf);
                boxes[row][col] = false;
            }
        }
        return count;
    }

    public static boolean isValid_(int r, int c, boolean[][] boxes) {
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        for (int i = 0; i < dir.length; i++) {
            for (int rad = 1; rad <= boxes.length; rad++) {
                int newrow = r + rad * dir[i][0];
                int newcol = c + rad * dir[i][1];
                if (newcol >= 0 && newrow >= 0 && newrow < boxes.length && newcol < boxes[0].length) {
                    if (boxes[newrow][newcol])
                        return false;
                } else
                    break;
            }
        }
        return true;
    }
}