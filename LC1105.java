package leetcode;

import java.util.Arrays;

public class LC1105 {
    public static void main(String[] args) {
//        int[][] books = {{1,1}, {2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}; 4
//        int[][] books = {{1,3}, {2,4}, {3,2}};    6
        int[][] books = {{7,3},{8,7},{2,7},{2,5}};
        int shelfWidth = 10;
        System.out.println( arrangeBooks(books, shelfWidth));
    }

    private static int arrangeBooks(int[][] books, int maxShelfWidth) {
        int[] minHeights = new int[books.length + 1];

        for (int bookIndex = 1; bookIndex <= books.length; bookIndex++) {
            minHeights[bookIndex] = Integer.MAX_VALUE;
            int currentShelfHeight = 0;
            int currentShelfWidth = 0;

            for (int lastBook = bookIndex - 1; lastBook >= 0; lastBook--) {
                int currentBookThickness = books[lastBook][0];
                int currentBookHeight = books[lastBook][1];

                if (currentShelfWidth + currentBookThickness > maxShelfWidth) {
                    break;
                }

                currentShelfWidth += currentBookThickness;
                currentShelfHeight = Math.max(currentShelfHeight, currentBookHeight);

                int currentArrangementHeight = minHeights[lastBook] + currentShelfHeight;
                minHeights[bookIndex] = Math.min(minHeights[bookIndex], currentArrangementHeight);
            }
        }

        return minHeights[books.length];
    }

    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] minHeight = new int[n+1];
        Arrays.fill(minHeight, Integer.MAX_VALUE);
        minHeight[0] = books[0][1];

        for (int currentBook = 1; currentBook <= n; currentBook++) {
            int currentShelfHeight = books[currentBook][0];
            int currentShelfWidth = books[currentBook][1];

            for (int lastBook = currentBook-1; lastBook >= 0 ; lastBook++) {
                int lastBookWidth = books[lastBook][0];
                int lastBookHeight = books[lastBook][1];

                if (currentShelfWidth + lastBookWidth > shelfWidth ){
                    break;
                }

                currentShelfWidth += lastBookWidth;
                currentShelfHeight = Math.max(currentShelfHeight, lastBookHeight);

                int currentHeightArrangement = minHeight[lastBookHeight] + currentShelfHeight;
                minHeight[currentBook] = Math.min(currentHeightArrangement, minHeight[currentBook]);
            }
        }

        return minHeight[n];
    }
}
