package xiao.offer2;

/*
 * 
 * nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]

Return 4
The longest increasing path is [3, 4, 5, 6].
*/
public class LongestIncrementPath {
	//四个方向
    private int[] ro = {-1, 1, 0, 0};
    private int[] co = {0, 0, -1, 1};
    private int find(int[][] matrix, boolean[][] visited, int[][] path, int row, int col) {
        if (visited[row][col]) return path[row][col];
        path[row][col] = 1;
        for(int i=0; i<4; i++) {
            int r = row + ro[i];
            int c = col + co[i];
            if (r>=0 && r<matrix.length && c>=0 && c<matrix[r].length && matrix[row][col] > matrix[r][c]) {
                path[row][col] = Math.max(path[row][col], find(matrix, visited, path, r, c)+1);
            }
        }
        visited[row][col] = true;
        return path[row][col];
    }
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] path = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                max = Math.max(max, find(matrix, visited, path, i, j));
            }
        }
        return max;
    }
}