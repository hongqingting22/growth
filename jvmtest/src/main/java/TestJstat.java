public class TestJstat {

    /**
     * -XX:NewSize=104857600 -XX:MaxNewSize=104857600
     * -XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200
     * -XX:PretenureSizeThreshold=3145728
     * -XX:MaxTenuringThreshold=15
     * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc2.log
     * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
     * -XX:SurvivorRatio=8
     *
     * 等价于
     * -Xms200M -Xmx200M -Xmn100M 	-XX:PretenureSizeThreshold=3M
     *
     * jstat可以分析出
     * 1.每秒产生的对象大小
     * 2.YGC频率
     * 3.YGC后多少对象进入Sur0
     * 4.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)  throws Exception{
        Thread.sleep(30000);
        while (true){
            loadData();
        }

    }

    /**
     * 每秒钟产生50个100K的数据，且无引用（模拟每秒钟产生5M数据）
     *
     * Eden区80M  ，每秒5M，15秒后，yGC
     * 之后都是15秒YGC
     * @throws Exception
     */
    public static void loadData() throws Exception{
        byte[] data = null;
        for(int i = 1; i<=50;i++){
            data = new byte[100 * 1024];
        }
        data = null;
        Thread.sleep(1000);
    }
}
