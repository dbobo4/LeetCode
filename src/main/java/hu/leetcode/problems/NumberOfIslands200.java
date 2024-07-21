package hu.leetcode.problems;

public class NumberOfIslands200 {
    public static void main(String[] args) {

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0', '1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0', '1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1', '1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0', '1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0', '1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1', '1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0', '1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0', '1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1', '1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1', '1', '1', '0', '0', '0'}
        };

        int numberOfIslands1 = numIslands(grid1);
        int numberOfIslands2 = numIslands(grid2);

        System.out.println(numberOfIslands1);
        System.out.println();
        drawIslands(grid1);

        System.out.println("---------------------------");

        System.out.println(numberOfIslands2);
        System.out.println();
        drawIslands(grid2);


    }

    private static int numIslands(char[][] grid) {
        char[][] copiedGrid = copyGrid(grid);

        int result = 0;
        for (int i = 0; i < copiedGrid.length; i++) {
            for (int j = 0; j < copiedGrid[i].length; j++) {
                if (copiedGrid[i][j] == '1') {
                    findGridAndEraseFromExistence(copiedGrid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void findGridAndEraseFromExistence(char[][] copiedGrid, int i, int j) {
        copiedGrid[i][j] = '0';
        launchRecursiveFunctionToVerticalAndHorizontal(copiedGrid, i, j);
    }

    private static void launchRecursiveFunctionToVerticalAndHorizontal(char[][] copiedGrid, int i, int j) {
        for (int k = i - 1; k < i + 2; k++) {
            for (int l = j - 1; l < j + 2; l++) {
                if (!((k == i && l == j)
                        || (k == i - 1 && l == j - 1)
                        || (k == i - 1 && l == j + 1)
                        || (k == i + 1 && l == j - 1)
                        || (k == i + 1 && l == j + 1))) {
                    if (isSearchableGrid(copiedGrid, k, l)) {
                        findGridAndEraseFromExistence(copiedGrid, k, l);
                    }
                }
            }
        }
    }

    private static boolean isSearchableGrid(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0') {
            return false;
        }
        return true;
    }

    private static char[][] copyGrid(char[][] grid) {
        char[][] copiedGrid = new char[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                copiedGrid[i][j] = grid[i][j];
            }
        }
        return copiedGrid;
    }

    private static void drawIslands(char[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
