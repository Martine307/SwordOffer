package xiaozhaoti;

import java.util.Arrays;

public class Act {
    private static boolean[] x;
    private static int[] y;

    public static class ACs implements Comparable<ACs>{

        private int startTime;//开始时间
        private int endTime;//结束时间
        private String name;//活动名称

        public ACs(int startTime, int endTime,String name) {
            super();
            this.startTime = startTime;
            this.endTime = endTime;
            this.name = name;
        }

        public ACs() {
            super();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        /**
         * 实现对活动排序的接口
         */
        @Override
        public int compareTo(ACs o) {
            // TODO Auto-generated method stub
            return this.endTime - o.endTime;
        }

    }

    private static void GreedySeletor(int n,ACs[] s,boolean[] a) {
        a[1] = true;
        int j = 1;
        for(int i = 2;i<=n;i++) {
            if(s[i].getStartTime() >= s[j].getEndTime()) {
                a[i] = true;
                j = i;
            }
            else {
                a[i] = false;
            }
        }
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        x = new boolean[7];
        x[0] = false;
        ACs a0 = new ACs();
        ACs a1 = new ACs(1,4,"活动一");
        ACs a2 = new ACs(3,5,"活动二");
        ACs a3 = new ACs(0,6,"活动三");
        ACs a4 = new ACs(3,8,"活动四");
        ACs a5 = new ACs(5,7,"活动五");
        ACs a6 = new ACs(5,9,"活动六");


        ACs[] A = new ACs[7];
        A[0] = a0;
        A[1] = a1;
        A[2] = a2;
        A[3] = a3;
        A[4] = a4;
        A[5] = a5;
        A[6] = a6;

        Arrays.sort(A);

        GreedySeletor(6,A,x);

        for(int i = 1;i<=6;i++) {
            if(x[i] == true) {
                System.out.println(A[i].getName());
            }
        }
    }
}