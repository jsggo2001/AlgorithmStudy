package ssafyClass.permutationCombination;

public class PermutationByFor {

    public static void main(String[] args) {
        //3p3
        int n = 3;
        //첫수 뽑기
        for (int i = 1; i < n + 1; i++){
            // 기존수와 중복 체크
            //두번째수 뽑기
            for(int j = 1; j < n + 1; j ++) {
                //기존 수와 중복 체크
                if (i == j) continue;
                System.out.println(i + ", " + j);
            }
        }
    }
}
