package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class mockExam {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            answers[i] = Integer.parseInt(st.nextToken());
        }

        solution(answers);
    }

    private static ArrayList<Integer> solution(int[] answers){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];

        for(int i=0;i<answers.length;i++){
            if(answers[i] == a[i%a.length]){
                score[0]++;
            }
            if(answers[i] == b[i%b.length]){
                score[1]++;
            }
            if(answers[i] == c[i%c.length]){
                score[2]++;
            }
        }

        int maxScore = Math.max(score[0],Math.max(score[1],score[2]));
        for(int i=0;i<3;i++){
            if(maxScore == score[i]){
                answer.add(i+1);
            }
        }

        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i));
        }
        return answer;
    }
}
