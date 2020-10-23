package de.ad.sudoku;

import de.ad.sudoku.Grid.Cell;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BacktrackingAlgorithm {	
    
    public static void main(String[] args) throws IOException {
     BacktrackingAlgorithm solver = new BacktrackingAlgorithm();
     //solver.bestCase();

	 
	 //solver.bestCase();
	// solver.averageCase();
	 solver.worstCase();



}
    private void bestCase() throws IOException {
        BacktrackingAlgorithm solver = new BacktrackingAlgorithm();
		mydata datas = new mydata();
		String csvFile = "/Users/Dylan/Documents/AAAProject/bestcase.csv";
		FileWriter writer = new FileWriter(csvFile);
        int[][] board  = new int [9][9] ;  

        
        for (int n=1; n<=27 ; n++) {
            Generator generator = new Generator() ; 
        	Grid grid  = generator.generate(n) ; 
            int size = grid.getSize() ;
  	        for(int i=0;i<size;i++) {
	    	  for (int j=0; j<size;j++) {
	    		  Cell cell = grid.getCell(i, j);
	    		  board[i][j] = cell.getValue() ; 
	    	  }
	      }

            
            double startTime = System.nanoTime();
            solver.solve(board);
            double endTime = System.nanoTime(); 
   		    double totalTime = endTime-startTime ; 
   		    double timeinSeconds = totalTime/1000000;
   		    
   		    datas.setdata(n, timeinSeconds);
            

        	
        }
        CSVUtils.writeLine(writer, Arrays.asList("Number of Empty Cells", "Time"));
	     for(int i=0 ; i<datas.inputs.size();i++) {
	     CSVUtils.writeLine(writer, Arrays.asList(datas.getInput().get(i).toString(), datas.getTime().get(i).toString()));
	     }
	     writer.flush();
	     writer.close();
        
      	
    }
    private void averageCase() throws IOException {
        BacktrackingAlgorithm solver = new BacktrackingAlgorithm();
		mydata datas = new mydata();
		String csvFile = "/Users/Dylan/Documents/AAAProject/averagecase.csv";
		FileWriter writer = new FileWriter(csvFile);
        int[][] board  = new int [9][9] ;  

        
        for (int n=27; n<=54 ; n++) {
            Generator generator = new Generator() ; 
        	Grid grid  = generator.generate(n) ; 
            int size = grid.getSize() ;
  	        for(int i=0;i<size;i++) {
	    	  for (int j=0; j<size;j++) {
	    		  Cell cell = grid.getCell(i, j);
	    		  board[i][j] = cell.getValue() ; 
	    	  }
	      }

            
            double startTime = System.nanoTime();
            solver.solve(board);
            double endTime = System.nanoTime(); 
   		    double totalTime = endTime-startTime ; 
   		    double timeinSeconds = totalTime/1000000;
   		    
   		    datas.setdata(n, timeinSeconds);
            

        	
        }
        CSVUtils.writeLine(writer, Arrays.asList("Number of Empty Cells", "Time"));
	     for(int i=0 ; i<datas.inputs.size();i++) {
	     CSVUtils.writeLine(writer, Arrays.asList(datas.getInput().get(i).toString(), datas.getTime().get(i).toString()));
	     }
	     writer.flush();
	     writer.close();
        
      	
    }
    private void worstCase() throws IOException {
        BacktrackingAlgorithm solver = new BacktrackingAlgorithm();
		mydata datas = new mydata();
		String csvFile = "/Users/Dylan/Documents/AAAProject/worstcase.csv";
		FileWriter writer = new FileWriter(csvFile);
        int[][] board  = new int [9][9] ;  

        
        for (int n=54; n<=81 ; n++) {
            Generator generator = new Generator() ; 
        	Grid grid  = generator.generate(n) ; 
            int size = grid.getSize() ;
  	        for(int i=0;i<size;i++) {
	    	  for (int j=0; j<size;j++) {
	    		  Cell cell = grid.getCell(i, j);
	    		  board[i][j] = cell.getValue() ; 
	    	  }
	        }

            
            double startTime = System.nanoTime();
            solver.solve(board);
            double endTime = System.nanoTime(); 
   		    double totalTime = endTime-startTime ; 
   		    double timeinSeconds = totalTime/1000000;
   		    
   		    datas.setdata(n, timeinSeconds);
            

        	
        }
        CSVUtils.writeLine(writer, Arrays.asList("Number of Empty Cells", "Time"));
	     for(int i=0 ; i<datas.inputs.size();i++) {
	     CSVUtils.writeLine(writer, Arrays.asList(datas.getInput().get(i).toString(), datas.getTime().get(i).toString()));
	     }
	     writer.flush();
	     writer.close();
        
      	
    }


     
    private boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column,k) && solve(board)) {
                            return true;
                        }
                        board[row][column] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int column , int num) {
 
    	
    	for (int i = 0; i<9 ; i++) {
    	     //check the rows
    		if (board[row][i]==num && (i!=column)) {
    			return false ; 
    			
    		}
    		
    		//check columns
    		if (board[i][column]==num && (i!=row)) {
    			return false ; 
    		}
    	}
    	//check sub-grids(3x3)
    	
    	int xStart = (row/3) * 3 ; 
    	int yStart = (column/3) * 3 ; 
    	
    	int xEnd = xStart + 3;
    	int yEnd = yStart + 3;
    	
    	for (int i = xStart; i<xEnd ;i++) {
    		for (int j = yStart; j<yEnd ;j++) {
    			if (board[i][j]==num && (i!=row && j!=column)) {
    				return false ; 
    			}
    			
    		}
    	}
    	return true ; 
    	
    	
    }
    


}

