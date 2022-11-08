public class sudoku_solver_backtracking {



        public static boolean isSafe(int[][] sudoku, int row, int col, int number){
            for(int i=0;i<sudoku.length;i++){
                if(sudoku[i][col] == number ){
                    return false;
                }
                if(sudoku[row][i]== number ){
                    return false;
                }

            }
            // grid
            int sr=(row/3 )* 3;
            int sc=(col/3 )* 3;

            for(int i=sr; i<sr+3;i++){
                for(int j=sc;j<sc+3;j++){
                    if(sudoku[i][j]==number){
                        return false;
                    }
                }
            }
            return true;

        }// check weather input number is safe or not
        public static boolean check(int[][] sudoku, int row, int col){
            if(row == sudoku.length){
                return  true;
            }
            int nrow = 0;
            int ncol = 0;
            if(col != sudoku.length-1){
                nrow = row;
                ncol = col + 1;
            }
            else{
                nrow = row + 1;
                ncol = 0 ;
            }
            if(sudoku[row][col] != 0){
                if(check(sudoku,nrow, ncol)){
                    return true;
                }
            }
            else{
                for(int i=1;i<=9;i++){
                    if(isSafe(sudoku, row, col,i)){
                        sudoku[row][col]=i;
                        if(check(sudoku,nrow,ncol)){
                            return true;
                        }
                        else {
                            sudoku[row][col] = 0;
                        }
                    }
                }
            }
            return false;

        }

        public static void main(String[] args) {
            int[][] sudoku = new int[][]{
                    {5, 3, 0, 0, 7, 0, 0, 0, 0},
                    {6, 0, 0, 1, 9, 5, 0, 0, 0},
                    {0, 9, 8, 0, 0, 0, 0, 6, 0},
                    {8, 0, 0, 0, 6, 0, 0, 0, 3},
                    {4, 0, 0, 8, 0, 3, 0, 0, 1},
                    {7, 0, 0, 0, 2, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 2, 8, 0},
                    {0, 0, 0, 4, 1, 9, 0, 0, 5},
                    {0, 0, 0, 0, 8, 0, 0, 7, 9}};
            System.out.println("<<<<<<<<<<<<<<<<<______________________INPUT_SUDOKU____________________>>>>>>>>>>");
            for(int i=0;i<9;i++){
                System.out.print("[");
                for(int j=0;j<8;j++){
                    System.out.print(sudoku[i][j]+",");
                }
                System.out.print(sudoku[i][8]+"]");
                System.out.println(" ");
            }

            check(sudoku,0,0);

            System.out.println("<<<<<<<<<<<<<<<<<______________________OUTPUT_SUDOKU____________________>>>>>>>>>>");
            for(int i1=0;i1<9;i1++){
                System.out.print("[");
                for(int j1=0;j1<8;j1++){
                    System.out.print(sudoku[i1][j1]+",");
                }
                System.out.print(sudoku[i1][8]+"]");
                System.out.println(" ");
            }


        }


}
