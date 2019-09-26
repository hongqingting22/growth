package bridge.impl;

import bridge.Soft;

public class WeChatSoft extends Soft {

    public WeChatSoft(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("打开聊天窗口");
    }

}
