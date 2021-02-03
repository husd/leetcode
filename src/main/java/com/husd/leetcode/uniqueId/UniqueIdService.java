package com.husd.leetcode.uniqueId;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 生成1个全局唯一的自增ID，依靠的是redis的increby
 * 同时在内存里弄个缓存。
 * <p>
 * 这个是一个很简单的版本。
 * <p>
 * 不用考虑
 *
 * @author hushengdong
 */
public class UniqueIdService {

    private static final String BATCH_NO_KEY = "redis:key:pre";

    // private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private AtomicLong MAX_NUM = new AtomicLong(0);
    private AtomicLong CURRENT_NUM = new AtomicLong(0);

    private final long STEP = 1000;

    public synchronized long incrementId(String key) {

        if (CURRENT_NUM.get() <= 0) {
            CURRENT_NUM = new AtomicLong(getFromRedis(key));
            MAX_NUM = new AtomicLong(CURRENT_NUM.get() + STEP);
        }
        if (CURRENT_NUM.get() >= MAX_NUM.get()) {
            CURRENT_NUM = new AtomicLong(getFromRedis(key));
            MAX_NUM = new AtomicLong(CURRENT_NUM.get() + STEP);
        }
        return CURRENT_NUM.incrementAndGet();
    }

    private long getFromRedis(String today) {

        String key = BATCH_NO_KEY + today;
        // long id = gcache.incrBy(key, STEP);
        long id = 10;
        // logger.info("自增ID 新的ID: {} ", id);
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        // gcache.expireAt(key, milliSecond);
        return id;
    }
}
