package mao.t1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project name(项目名称)：java并发编程_多把锁
 * Package(包名): mao.t1
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/5
 * Time(创建时间)： 10:58
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    /**
     * 锁
     */
    private static final Object lock = new Object();

    private static final Logger log = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (lock)
                {
                    log.debug("线程t1获取到锁");
                    log.debug("t1休眠3秒");
                    try
                    {
                        Thread.sleep(3000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    log.debug("t1运行");
                    log.debug("t1释放锁");
                }
            }
        }, "t1").start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (lock)
                {
                    log.debug("线程t2获取到锁");
                    log.debug("t2休眠2秒");
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    log.debug("t2运行");
                    log.debug("t2释放锁");
                }
            }
        }, "t2").start();
    }
}
