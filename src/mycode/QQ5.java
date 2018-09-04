package mycode;


	import java.util.Arrays;
	import java.util.Comparator;
	import java.util.Scanner;
	 
	public class QQ5 {	
	 
	    static class Pair {
	        int time;
	        int diff;
	 
	        public Pair(int time, int diff) {
	            this.time = time;
	            this.diff = diff;
	        }
	    }
	 
	    public static void main(String[] args) {
	 
	        Scanner sc = new Scanner(System.in);
	        while (sc.hasNext()) {
	            int machineNum = sc.nextInt();
	            int taskNum = sc.nextInt();
	            Pair[] machines = new Pair[machineNum];
	            Pair[] tasks = new Pair[taskNum];
	            for (int i = 0; i < machineNum; i++) {
	                machines[i] = new Pair(sc.nextInt(), sc.nextInt());
	            }
	            for (int i = 0; i < taskNum; i++) {
	                tasks[i] = new Pair(sc.nextInt(), sc.nextInt());
	            }
	            Comparator<Pair> cmp = new Comparator<Pair>() {
	 
	            	@Override
	                public int compare(Pair p1, Pair p2) {
	                    if (p1.time == p2.time) {
	                        return p2.diff - p1.diff;
	                    } else {
	                        return p2.time - p1.time;
	                    }
	                }
	 
	            };
	            Arrays.sort(machines, cmp);
	            Arrays.sort(tasks, cmp);
	            long sum = 0;
	            int count = 0;
	            int j = 0;
	            int[] dp = new int[101];
	            for (int i = 0; i < taskNum; i++) {
	            	//对于队列中未处理的最大任务，先确定有哪些机器满足时间要求
	                //注意：时间上，满足任务i的机器j，也会满足i+1。
	                while (j < machineNum && machines[j].time >= tasks[i].time) {
	                    dp[machines[j].diff]++;
	                    j++;
	                }
	              //在满足时间要求的机器中，选择满足等级要求的最低等级的机器，但不用确定具体是哪个机器
	                for (int k = tasks[i].diff; k < 101; k++) {
	                    if (dp[k] != 0) {
	                        dp[k]--;
	                        sum += 200 * tasks[i].time + 3 * tasks[i].diff;
	                        count++;
	                        break;
	                    }
	                }
	            }
	            System.out.println(count + " " + sum);
	        }
	        sc.close();
	 
	    }
	 
	}

