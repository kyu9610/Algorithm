package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 2018 카카오 블라인드 - [3차] 파일명 정렬
public class fileSort {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("input file count : ");
        int fileCount = Integer.parseInt(br.readLine());

        System.out.print("input file name : ");
        String[] files = new String[fileCount];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<fileCount;i++){
            files[i] = st.nextToken();
        }

        solution(files);
    }

    private static String[] solution(String[] files){
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] file1 = detach(s1);
                String[] file2 = detach(s2);

                int headValue = file1[0].compareTo(file2[0]);

                if(headValue == 0){
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);

                    return num1 - num2;
                }else{
                    return headValue;
                }
            }
        });

        for(int i=0;i<files.length;i++){
            System.out.print(files[i] + " ");
        }
        return files;
    }

    private static String[] detach(String str){
        String head = "";
        String number = "";
        String tail = "";

        int idx = 0;
        for( ;idx<str.length();idx++){
            char ch = str.charAt(idx);
            if(ch >='0' && ch <= '9') break;
            head += ch;
        }

        for( ;idx<str.length();idx++){
            char ch = str.charAt(idx);
            if(!(ch >='0' && ch <= '9')) break;
            number += ch;
        }

        for( ;idx<str.length();idx++){
            char ch = str.charAt(idx);
            tail += ch;
        }

        String[] file = {head.toLowerCase(),number,tail};

        return file;
    }
}
