//有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。 
//
// 你也被给予三个整数 sr , sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。 
//
// 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对
//应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。 
//
// 最后返回 经过上色渲染后的图像 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
//输出: [[2,2,2],[2,2,0],[2,0,1]]
//解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
//注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
// 
//
// 示例 2: 
//
// 
//输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
//输出: [[2,2,2],[2,2,2]]
// 
//
// 
//
// 提示: 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 50 
// 0 <= image[i][j], newColor < 2¹⁶ 
// 0 <= sr < m 
// 0 <= sc < n 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 417 👎 0

/**
 * 图像渲染
 * @author Yuanzhi
 * @date 2023-02-12 23:25:25
 */
public class FloodFill{
	 public static void main(String[] args) {
	 	 Solution solution = new FloodFill().new Solution();
         System.out.println("hiw");
     }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    private int colNum = 0;
    private int rowNum = 0;

    private int oldColor = 0;

    private boolean[][] used;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // dfs深度优先搜索
        System.out.println("hiw");

        oldColor = image[sr][sc];
        colNum = image[0].length;
        rowNum = image.length;

        used = new boolean[rowNum][colNum];
        for(int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++) {
                System.out.println(used[i][j]);
            }
        }
        dfs(image, sr, sc, color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color) {

        // 到达边界，返回
        if (sr >= rowNum) return;
        if (sc >= colNum) return;

        // 如果发现和初识像素点值一样，染色
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = color;

            // 染色后，从四个方向上dfs
            dfs(image, sr - 1, sc, color); // 上
            dfs(image, sr + 1, sc, color); // 下
            dfs(image, sr, sc - 1, color); // 左
            dfs(image, sr, sc + 1, color); // 右
        }

        // 如果当前点和初始像素点不一样，终止搜索
        return ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
