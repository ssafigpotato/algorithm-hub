import java.util.*;

public class Main {
    static class Status implements Comparable<Status> {
        int id; // 사람 ID
        int mileage; // 마일리지

        Status(int id, int mileage) {
            this.id = id;
            this.mileage = mileage;
        }

        @Override
        public int compareTo(Status o) {
            // 마일리지 내림차순 정렬, 같은 경우 ID 오름차순
            if (this.mileage == o.mileage) {
                return Integer.compare(this.id, o.id);
            }
            return Integer.compare(o.mileage, this.mileage);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 과목 수
        int M = sc.nextInt(); // 총 마일리지
        List<Integer> list = new ArrayList<>(); // 최소 마일리지 저장 리스트

        for (int i = 1; i <= N; i++) {
            PriorityQueue<Status> pq = new PriorityQueue<>(); // 과목별 PriorityQueue 생성
            int P = sc.nextInt(); // 신청한 사람 수
            int L = sc.nextInt(); // 수강 인원

            for (int j = 1; j <= P; j++) {
                int m = sc.nextInt();
                pq.add(new Status(j, m));
            }

            if (P >= L) {
                for (int l = 0; l < L - 1; l++) {
                    pq.poll(); // 상위 L-1명 제외
                }
                list.add(pq.poll().mileage); // 최소 마일리지 저장
            } else {
                list.add(1); // 신청 인원이 부족하면 1만 필요
            }
        }

        // 오름차순 정렬
        Collections.sort(list);

        int sum = 0;
        int cnt = 0;

        // 가능한 과목 개수 계산
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if (sum > M) break;
            cnt++;
        }

        System.out.println(cnt); // 결과 출력
    }
}
