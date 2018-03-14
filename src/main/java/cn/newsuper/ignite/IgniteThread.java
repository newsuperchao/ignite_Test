package cn.newsuper.ignite;

import org.apache.ignite.IgniteCache;

/**
 * Created by Administrator on 2018\3\14 0014.
 */
public class IgniteThread implements Runnable {
    private boolean startFlag=true;
    private IgniteCache<String,String> cache;
    private int test_rows ;
    private int thread_num;

    IgniteThread(boolean startFlag, IgniteCache<String, String> cache) {
        this.startFlag = startFlag;
        this.cache = cache;
    }

    public void run() {
        for (int i = 0;i < test_rows/thread_num;){
            if(this.startFlag){
                cache.get(Integer.toString(i));
            }else{
                cache.put(Integer.toString(i),"aa"+i);
            }
        }
    }
}
