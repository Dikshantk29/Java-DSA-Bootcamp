public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        /* 1 -> 2 -> 3 -> 4
         -> 8 -> 12 -> 16 -> 
         15 -> 14 -> 13 -> 9 -> 
         5 -> 6 -> 7 -> 11 -> 10 */
        spiralPrint(arr);
    }

    static void spiralPrint(int[][] arr) {
        int top =0;
        int bottom = arr.length - 1;
        int left  = 0;
        int right = arr[0].length -1;
    
        while(top <= bottom && left <= right){
        
            //left to right 
            for(int i = left; i<= right ;i++){
                System.out.print(arr[top][i]+ " ");
            }
            top++;

            //top to bottom 
            for(int j=top ;j<= bottom;j++){
                System.out.print(arr[j][right]+" ");
            }
            right--;

            //right to left 
            while(top<= bottom){
                for(int k=right;k>= left;k--){
                    System.out.print(arr[bottom][k]+" ");
                }
                bottom--;

            }
            //bottom to top
            while(left <= right){
                for(int l=bottom;l>= top;l--){
                    System.out.print(arr[l][left]+" ");
                }
                left++;
            }
        }
        
        System.out.println();
    }
}
