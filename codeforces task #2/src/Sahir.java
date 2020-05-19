import java.util.Scanner;

public class Sahir {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        int stages= scanner.nextInt();
        int rooms = scanner.nextInt();
        int leftMost[]= new int [stages];
        int rightMost[]=new int [stages];
        int oldLeft[]= new int [stages];
        int oldRight[]=new int [stages];
        int leftHead[]= new int[stages];
        int rightHead[]= new int[stages];

        int unic[][] = new int[stages][rooms+2];
        String temp = scanner.nextLine();
        boolean takeLeft = false;
        boolean upMost = true;
        int stageLimit = 0;
        for(int i = 0 ; i < stages; i++ ){

            temp = scanner.nextLine();
            takeLeft = true;
            for(int j = 0 ; j < rooms+2; j++){
                unic[stages - i - 1][j] = temp.charAt(j) - '0';
                if (takeLeft && unic[stages - 1 - i][j] == 1){
                    if(upMost){
                        stageLimit = stages - 1 - i;
                    }
                    upMost = false;

                    leftMost[stages - 1 - i] = j;
                    takeLeft = false;
                }
                if(unic[stages - 1 - i][j] == 1){
                    rightMost[stages - 1 - i] = j;
                }
            }
        }

        leftHead[0] = rightMost[0] * 2;
        rightHead[0] = rooms + 1;
        oldRight[0] = rightHead[0];
        for(int i = 1; i < stageLimit + 1; i++){
            if(leftMost[i] == 0){
                leftMost[i] = rooms + 1;
            }
            leftHead[i] = leftHead[i - 1] + 1;
            rightHead[i] = rightHead[i - 1] + 1;
            oldLeft[i] = leftHead[i];
            oldRight[i] = rightHead[i];
            leftHead[i] = Math.min(leftHead[i] + rightMost[i] * 2, rightHead[i]+rooms+1);
            rightHead[i] = Math.min(rightHead[i] + (rooms+1-leftMost[i]) * 2, oldLeft[i] + rooms + 1);
        }

        System.out.println(Math.min(oldLeft[stageLimit] + rightMost[stageLimit], oldRight[stageLimit] + (rooms + 1 - leftMost[stageLimit])));
    }
}
