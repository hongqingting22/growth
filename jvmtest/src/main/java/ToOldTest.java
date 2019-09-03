public class ToOldTest {

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
