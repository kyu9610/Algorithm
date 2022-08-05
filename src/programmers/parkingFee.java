package programmers;


import java.util.*;

public class parkingFee {
    public static void main(String[] args){
        int[] answer = new int[3];
        answer = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        for(int i=0;i<3;i++){
            System.out.print(answer[i] + " ");
        }
        System.out.println();
        answer = new int[2];
        answer = solution(new int[]{120, 0, 60, 591},new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"});
        for(int i=0;i<2;i++){
            System.out.print(answer[i] + " ");
        }
        System.out.println( );
        answer = new int[1];
        answer = solution(new int[]{1, 461, 1, 10},new String[]{"00:00 1234 IN"});
        for(int i=0;i<1;i++){
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] solution(int[] fees,String[] records){
        int lastTime = getTime("23:59");
        // 현재 주차중인 차
        Map<String,Integer> parking = new HashMap<>();
        // 누적 주차 시간
        Map<String,Integer> times = new HashMap<>();
        // 차량 리스트
        List<String> cars = new ArrayList<>();

        for(String record : records){
            String[] rc = record.split(" ");
            int time = getTime(rc[0]);
            String car = rc[1];

            // 새로운 차가 들어왔을 경우
            if(!cars.contains(car)){
                cars.add(car);
                times.put(car,0);
            }

            if(parking.containsKey(car)){
                times.put(car,times.get(car) + (time - parking.get(car)));
                parking.remove(car);
            }else{
                parking.put(car,time);
            }
        }

        int[] ret = new int[cars.size()];
        Collections.sort(cars);

        for(int i=0;i<cars.size();i++){
            ret[i] = fees[1];
            String car = cars.get(i);
            int time = times.get(car) - fees[0];

            if(parking.containsKey(car)) time += (lastTime - parking.get(car));
            if(time > 0) ret[i] += (Math.ceil(time/(fees[2] * 1.0))*fees[3]);
        }

        return ret;
    }

    // 시간을 반환하는 함수 생성
    private static int getTime(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
