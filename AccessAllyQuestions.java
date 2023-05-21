//import javax.swing.text.StyledEditorKit;

public class AccessAllyQuestions {
    public static void main(String[] args){
        System.out.println(problem1(180));
        int[] arr1 = {5,5,3,1,2,11,5,12};
        int[] arr2 = {2,4,9,2,3,9,7,3};
        System.out.println(problem2(arr1, arr2));
    }
    public static int problem1(int num){
        int arr[] = {1,2,0,0};
        int count = 0;
        for(int i = 0; i < num; i++){
            addTime(arr);
            // System.out.print(arr[0]);
            // System.out.print(arr[1]);
            // System.out.print(arr[2]);
            // System.out.print(arr[3]);
            // System.out.println();
            if(arr[0] == 0){
                int dif1 = arr[1] - arr[2];
                int dif2 = arr[2] - arr[3];
                if(dif1 == dif2){
                    count++;
                    System.out.print(arr[0]);
                    System.out.print(arr[1]);
                    System.out.print(arr[2]);
                    System.out.print(arr[3]);
                    System.out.println();
                }
            }
            else{
                int dif1 = arr[0] - arr[1];
                int dif2 = arr[1] - arr[2];
                int dif3 = arr[2] - arr[3];
                if(dif1 == dif2 && dif2 == dif3){
                    count++;
                    System.out.print(arr[0]);
                    System.out.print(arr[1]);
                    System.out.print(arr[2]);
                    System.out.print(arr[3]);
                    System.out.println();
                }
            }
        }
        return count;
    }
    public static int[] addTime(int[] arr){
        Boolean add3 = false;
        Boolean add2 = false;
        if(arr[3] == 9){
            arr[3] = 0;
            add3 = true;
        }
        else arr[3] = arr[3] + 1;
        if(add3){
            if(arr[2] == 5){
                arr[2] = 0;
                add2 = true;
            }
            else arr[2] = arr[2] + 1;
        }
        if(add2){
            if(arr[1] == 2 && arr[0] == 1){
                arr[0] = 0;
                arr[1] = 1;
            }
            else if(arr[1] == 9){
                arr[1] = 0;
                arr[0] = 1;
            }
            else arr[1] = arr[1] + 1;
        }
        return arr;
    }


    public static int problem2(int[] available, int[] needed){
        //for reference {O-, O+, A-, A+, B-, B+, AB-, AB+}
        int count = 0;
        // O- 
        if(available[0] > needed[0]){
            count += needed[0];
            available[0] = available[0] - needed[0];
        }
        else{
            count += available[0];
            available[0] = 0;
        }
        // O+
        if(available[1] > needed[1]){
            count += needed[1];
            available[1] = available[1] - needed[1];
        }
        else{
            count += available[1];
            available[1] = 0;
        }
        // A-
        if(available[2] > needed[2]){
            count += needed[2];
            available[2] = available[2] - needed[2];
        }
        else{
            //from A-
            needed[2] = needed[2] - available[2];
            count += available[2];
            available[2] = 0;
            //from O-
            if(available[0] > needed[2]){
                count += needed[2];
                available[0] = available[0] - needed[2];
            }
            else{
                count += available[0];
                available[0] = 0;
            }
        }
        // A+
        if(available[3] > needed[3]){
            count += needed[3];
            available[3] = available[3] - needed[3];
        }
        else{
            //from A+
            needed[3] = needed[3] - available[3];
            count += available[3];
            available[3] = 0;
            //from O+
            if(available[1] > needed[3]){
                count += needed[3];
                available[1] = available[1] - needed[3];
            }
            else{
                count += available[1];
                available[1] = 0;
            }
        }
        // B-
        if(available[4] > needed[4]){
            count += needed[4];
            available[4] = available[4] - needed[4];
        }
        else{
            //from B-
            needed[4] = needed[4] - available[4];
            count += available[4];
            available[4] = 0;
            //from O-
            if(available[0] > needed[4]){
                count += needed[4];
                available[0] = available[0] - needed[4];
            }
            else{
                count += available[0];
                available[0] = 0;
            }
        }
        // B+
        if(available[5] > needed[5]){
            count += needed[5];
            available[5] = available[5] - needed[5];
        }
        else{
            //from B+
            needed[5] = needed[5] - available[5];
            count += available[5];
            available[5] = 0;
            //from O+
            if(available[1] > needed[5]){
                count += needed[5];
                available[1] = available[1] - needed[5];
            }
            else{
                count += available[1];
                available[1] = 0;
            }
        }
        // AB-
        if(available[6] > needed[6]){
            count += needed[6];
            available[6] = available[6] - needed[6];
        }
        else{
            //from AB-
            needed[6] = needed[6] - available[6];
            count += available[6];
            available[6] = 0;
            //from O-
            if(available[0] > needed[6]){
                count += needed[6];
                available[0] = available[0] - needed[6];
            }
            else{
                count += available[0];
                needed[6] = needed[6] - available[0];
                available[0] = 0;
            }
            //from A-
            if(available[2] > needed[6]){
                count += needed[6];
                available[2] = available[2] - needed[6];
            }
            else{
                count += available[2];
                needed[6] = needed[6] - available[2];
                available[2] = 0;
            }
            // from B-
            if(available[4] > needed[6]){
                count += needed[6];
                available[4] = available[4] - needed[6];
            }
            else{
                count += available[4];
                needed[6] = needed[6] - available[4];
                available[4] = 0;
            }
        }
        // AB+
        if(available[6] > needed[6]){
            count += needed[6];
            available[6] = available[6] - needed[6];
        }
        else{
            //from AB+
            needed[7] = needed[7] - available[7];
            count += available[7];
            available[7] = 0;
            //from O+
            if(available[1] > needed[7]){
                count += needed[7];
                available[1] = available[1] - needed[7];
            }
            else{
                count += available[1];
                needed[7] = needed[7] - available[1];
                available[1] = 0;
            }
            //from A+
            if(available[3] > needed[7]){
                count += needed[7];
                available[3] = available[3] - needed[7];
            }
            else{
                count += available[3];
                needed[7] = needed[7] - available[3];
                available[3] = 0;
            }
            // from B+
            if(available[5] > needed[7]){
                count += needed[7];
                available[5] = available[5] - needed[7];
            }
            else{
                count += available[5];
                needed[7] = needed[7] - available[5];
                available[5] = 0;
            }
        }
        return count;
    }
}
