线性表的特征：
    1.第一个数据元素没有前驱，这个数据元素称为头结点；
    2.最后一个数据元素没有后继，称为尾结点；
    3.其他元素有且只有一个前驱和一个后继

java中ArrayList
    1.数组实现 Object[] elementData;
    2.扩容
            minCapacity = size + 1;
            newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            如果原始长度为0，则扩容为1；
            如果原始长度为1，则扩容为2；
            正常扩容原始长度的一半；
    3.实现了Iterable接口，实现了遍历元素的内部类

链表
    物理存储上非连续

java中的LinkedList
    双向链表实现  Node{item,pre,next}