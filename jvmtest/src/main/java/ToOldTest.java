public class ToOldTest {

    /**
     * -XX:NewSize=10485760 -XX:MaxNewSize=10485760
     * -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520
     * -XX:PretenureSizeThreshold=10485760
     * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
     * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc1.log
     * @param args
     */
    public static void main(String[] args) {
        byte[] bytes = new byte[2*1024 * 1024];
        bytes = new byte[2*1024*1024];
        bytes = new byte[2*1024*1024];
        bytes = null;
        byte[] b2 = new byte[128 *1024];
        byte[] b3 = new byte[2*1024 * 1024];
        b3 = new byte[2*1024*1024];
        b3 = new byte[2*1024*1024];
        b3 = null;
        byte[] b4 = new byte[2*1024 * 1024];
    }
}
