package DepthFirstSearch;

import java.util.Arrays;

public class WordSearchInGrid {
	
	int[][] dirs = {
	        {0, 1},
	        {1, 0},
	        {0, -1},
	        {-1, 0}
	    };
	    
	    private boolean isWordPossible(char[][] grid, int x, int y, String word, String currentWord) {
	        if(currentWord.equals(word))
	            return true;
	        if(!word.contains(currentWord) || (x >= grid.length || y >= grid[0].length || x < 0 || y < 0))
	            return false;
	        boolean ans = false;
	        String newCurrentWord = currentWord+grid[x][y];
	        char t = grid[x][y];
	        grid[x][y] = '-';
	        for(int[] dir : dirs) {
	            ans = ans || isWordPossible(grid, x+dir[0], y+dir[1], word, newCurrentWord);
	            if(ans)
	                return true;
	        }
	        grid[x][y] = t;
	        return false;
	    }
	    
	    public boolean exist(char[][] grid, String word) {
	        int rows = grid.length;
	        int cols = grid[0].length;
	        
	        char[][] temp = new char[grid.length][];
	        
	        for(int i=0; i<grid.length; i++) {
	            temp[i] = Arrays.copyOf(grid[i], grid[i].length);
	        }
	        
	        for(int i=0; i<rows; i++) {
	            for(int j=0; j<cols; j++) {
	                if(isWordPossible(grid, i, j, word, ""))
	                    return true;
	                else {
	                    for(int k=0; k<temp.length; k++) {
	                        grid[k] = Arrays.copyOf(temp[k], temp[k].length);
	                    }
	                }
	            }
	        }
	        return false;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
