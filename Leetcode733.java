public class Leetcode733 {

    public int[][] floodFill(
            int[][] image,
            int sr,
            int sc,
            int color
    ) {

        
        int originalColor = image[sr][sc];

        if (color == originalColor) {
            return image;
        }


        dfs(image, sr, sc, color, originalColor);

        return image;
    }

    private void dfs(
            int[][] image,
            int i,
            int j,
            int color,
            int originalColor
    ) {

        int m = image.length;
        int n = image[0].length;

        if (i < 0 || j < 0
                || i >= m || j >= n
                || image[i][j] != originalColor) {

            return;
        }

        image[i][j] = color;

  
        dfs(image, i + 1, j, color, originalColor);
        dfs(image, i - 1, j, color, originalColor);
        dfs(image, i, j + 1, color, originalColor);
        dfs(image, i, j - 1, color, originalColor);
    }
}