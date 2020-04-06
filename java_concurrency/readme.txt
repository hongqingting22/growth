线程生命周期
    调用start()-->runnable  可运行状态
    runnable <----> running  cpu时间片调度
    running  ---->blocked   锁被占用，obj.wait(),condition.await(),yeild()后都会进入阻塞状态
    blocked ---->runnable   阻塞结束进入可运行状态
    terminated 终止状态

一个线程的start方法只能被调用一次