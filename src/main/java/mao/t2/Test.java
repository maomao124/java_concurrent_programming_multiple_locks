package mao.t2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project name(项目名称)：java并发编程_多把锁
 * Package(包名): mao.t2
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/5
 * Time(创建时间)： 11:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{

    /**
     * lock1
     */
    private static final Object lock1 = new Object();

    /**
     * lock2
     */
    private static final Object lock2 = new Object();

    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (lock1)
                {
                    log.debug("线程t1获取到锁1");
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
                    log.debug("t1释放锁1");
                }
            }
        }, "t1").start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (lock2)
                {
                    log.debug("线程t2获取到锁2");
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
                    log.debug("t2释放锁2");
                }
            }
        }, "t2").start();
    }
}
