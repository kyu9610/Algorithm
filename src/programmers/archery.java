package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2020 카카오 블라인드 - 양궁대회
public class archery {
    private static int[] aInfo; // 어피치가 맞힌 과녁 정보
    private static int[] lInfo; // 라이언이 맞힌 과녁 정보
    private static int[] maxLInfo; // 점수차이가 최대일때의 라이언이 맞힌 과녁 정보
    private static int maxDepth; // 최대 깊이(n);
    private static int maxScoreDiff = 0; // 최대 점수 차이
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 화살의 개수 입력
        System.out.print("화살의 개수 : ");
        maxDepth = Integer.parseInt(br.readLine());
        // 어피치가 맞힌 과녁 점수의 개수 입력
        System.out.print("어피치가 맞힌 과녁 점수의 개수 : ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        aInfo = new int[11];
        for(int i=0;i<11;i++){
            aInfo[i] = Integer.parseInt(st.nextToken());
        }

        solution(maxDepth,aInfo);
    }

    public static int[] solution(int maxDepth,int[] aInfo){
        lInfo = new int[11];
        dfs(0,lInfo,-1);
        if(maxScoreDiff > 0){
            for(int i=0;i<11;i++) System.out.print(maxLInfo[i] + " ");
            return maxLInfo;
        }else{
            System.out.println("-1");
            return new int[]{-1};
        }
    }

    private static void dfs(int depth,int[] lInfo,int idx){
        if(maxDepth == depth){
            int lScore = 0;
            int aScore = 0;

            for(int i=0;i<11;i++){
                if(lInfo[i] > aInfo[i]) lScore += 10-i;
                else if(aInfo[i] != 0) aScore += 10-i;
            }

            int scoreDiff = lScore - aScore;
            if(scoreDiff > maxScoreDiff){
                maxScoreDiff = scoreDiff;
                maxLInfo = lInfo;
            }else if(maxScoreDiff > 0 && scoreDiff == maxScoreDiff){
                for(int i=10;i>=0;i--){
                    if(lInfo[i] > maxLInfo[i]){
                        maxScoreDiff = scoreDiff;
                        maxLInfo = lInfo;
                    }else if(maxLInfo[i] > lInfo[i]){
                        return;
                    }
                }
            }
            return;
        }

        for(int i=idx+1;i<11;i++){
            int[] nextLInfo = new int[11];
            for (int j = 0; j < 11; j++) {
                nextLInfo[j] = lInfo[j];
            }

            if (i == 10) {
                nextLInfo[i] += maxDepth - depth;
                dfs(maxDepth, nextLInfo, i);
            } else if (maxDepth - depth > aInfo[i]) {
                nextLInfo[i] += aInfo[i] + 1;
                dfs(depth + aInfo[i] + 1, nextLInfo, i);
            }
        }
    }
}
