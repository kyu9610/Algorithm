package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 2018 카카오 블라인드 - [1차] 추석 트래픽
public class traffic {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("input lines count : ");
        int n = Integer.parseInt(br.readLine());

        String[] lines = new String[n];
        for(int i=0;i<n;i++){
            System.out.print("input lines : ");
            lines[i] = br.readLine();
        }

        solution(lines);
    }

    private static int solution(String[] lines){
        int answer = 0;
        int[] startTimes = new int[lines.length]; // 시작 시간을 모은 배열 생성
        int[] endTimes = new int[lines.length]; // 끝 시간을 모은 배열 생성

        getTimes(lines,startTimes,endTimes); // 시간을 밀리초로 변환하여 저장

        for(int i=0;i<lines.length;i++){
            int cnt = 0;
            int startSection = startTimes[i];
            int endSection = startSection + 1000;

            for(int j=0;j<lines.length;j++){
                // window 안에 포함되어있는 경우
                if(startTimes[j] >= startSection && startTimes[j] < endSection){
                    cnt++;
                }else if(endTimes[j] >= startSection && endTimes[j] < endSection){
                    cnt++;
                }else if(startTimes[j] <= startSection && endTimes[j] >= endSection){
                    cnt++;
                }
            }

            answer = cnt > answer ? cnt : answer;
        }


        System.out.println(answer);
        return answer;
    }

    private static void getTimes(String[] lines,int[] startTimes,int[] endTimes){
        for(int i=0;i<lines.length;i++){
            String[] log = lines[i].split(" ");
            String[] responesTime = log[1].split(":");
            int proceesingTime = (int)(Double.parseDouble(log[2].substring(0,log[2].length()-1)) * 1000);
            int startTime = 0;
            int endTime = 0;

            endTime += Integer.parseInt(responesTime[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(responesTime[1]) * 60 * 1000;
            endTime += Double.parseDouble(responesTime[2]) * 1000;

            startTime = endTime - proceesingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}
