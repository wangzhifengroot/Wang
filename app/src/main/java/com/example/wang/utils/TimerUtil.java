package com.example.wang.utils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 时间工具类
 * 创建人：v_wangzhifeng01
 * 创建时间：2019-07-04
 */
public class TimerUtil {
    private static TimerUtil mTimerUtil;
    private static Timer mTimer;
    private static TimerTask mTimerTask;
    private static Task mTask;

    private TimerUtil() {

    }

    public static TimerUtil getInstance() {
        if (mTimerUtil == null) {
            synchronized (TimerUtil.class) {
                if (mTimerUtil == null) {
                    mTimerUtil = new TimerUtil();

                }
            }
        }
        return mTimerUtil;
    }

    /**
     * 计时器
     * 创建一个计时器，每隔几秒执行一次任务
     *
     * @param delay  延迟的时间
     * @param period 周期时间
     * @param task   任务接口
     */

    public static void timer(int delay, int period, final Task task) {
        reset();
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                task.task();
            }
        };
        mTimer.schedule(mTimerTask, delay, period);

    }

    /**
     * 倒计时
     * 创建一个倒计时，执行到时间结束，执行任务
     *
     * @param delay 倒计时的时间
     * @param task  任务接口
     */

    public static void countDown(int delay, final Task task) {
        reset();
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                task.task();
            }
        };
        mTimer.schedule(mTimerTask, delay, 0);
    }

    public static void reset() {
        mTimer = null;
        mTimerTask = null;
    }

}
