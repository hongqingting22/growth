public class YoungGCTest {

    /**
     * JVM配置
     * 模拟ygc
     * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760
     * -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails
     * -XX:+PrintGCTimeStamps -Xloggc:gc.log
     * 新生代5M 最大新生代5M,初始堆空间10M,最大堆空间10M，大对象10M，ParNew+CMS,打印GC日志，GC时间，gc.log日志文件
     * @param args
     */
    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024];
        bytes = new byte[1024*1024];
        bytes = new byte[1024*1024];
        bytes = null;
        byte[] b2 = new byte[2*1024 *1024];
    }
}
