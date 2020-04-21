synchronized
    对象调用的wait方法，线程会进入阻塞状态，会进入对象的wait set中；
    线程被notify后，不一定立即得到执行；
    线程从wait set中被唤醒的顺序不一定是FIFO；
    对象调用wait方法后，会在wait set中抢占锁资源，但是抢到锁之后不是从头执行synchronized代码块；
