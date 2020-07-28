package com.luban.RedisLock;

public interface Lock {
    void lock();

    boolean tryLock();

    void unlock();
}
