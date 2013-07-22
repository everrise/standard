package jp.co.everrise.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日付関連のユーティリティ
 * 
 */
public abstract class ErDateUtil{

    private static final long ONE_DATE = 24 * 60 * 60 * 1000;

    private static ThreadLocal<Calendar> calendar = new ThreadLocal<Calendar>(){
        @Override
        protected Calendar initialValue(){
            return Calendar.getInstance();
        }
    };

    /**
     * {@link Date}オブジェクトを生成します.<br>
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @param day
     *            日
     * @return {@link Date}オブジェクト
     */
    public static Date date(int year, int month, int day){
        return new Date(time(year, month, day, 0, 0, 0, 0));
    }

    /**
     * {@link Date}オブジェクトを生成します.<br>
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @param day
     *            日
     * @param hour
     *            時
     * @param minute
     *            分
     * @param second
     *            秒
     * @return {@link Date}オブジェクト
     */
    public static Date datetime(int year, int month, int day, int hour, int minute, int second){
        return new Date(time(year, month, day, hour, minute, second, 0));
    }

    /**
     * {@link Date}オブジェクトを生成します.<br>
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @param day
     *            日
     * @param hour
     *            時
     * @param minute
     *            分
     * @param second
     *            秒
     * @param millis
     *            ミリ秒
     * @return {@link Date}オブジェクト
     */
    public static Date datetime(int year, int month, int day, int hour, int minute, int second, int millis){
        return new Date(time(year, month, day, hour, minute, second, millis));
    }

    /**
     * {@link java.sql.Date}オブジェクトを返します.<br>
     * 
     * @param date
     *            {@link Date}オブジェクト
     * @return {@link java.sql.Date}オブジェクト
     */
    public static java.sql.Date sqlDate(Date date){
        if(date == null){
            return null;
        }
        Calendar cal = calendar.get();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    /**
     * {@link java.sql.Time}オブジェクトを返します.<br>
     * 
     * @param date
     *            {@link Date}オブジェクト
     * @return {@link java.sql.Time}オブジェクト
     */
    public static Time sqlTime(Date date){
        if(date == null){
            return null;
        }
        Calendar cal = calendar.get();
        cal.setTime(date);
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);
        return new Time(cal.getTimeInMillis());
    }

    /**
     * {@link Timestamp}オブジェクトを返します.<br>
     * 
     * @param date
     *            {@link Date}オブジェクト
     * @param nanos
     *            ナノ秒
     * @return {@link Timestamp}オブジェクト
     */
    public static Timestamp timestamp(Date date, int nanos){
        if(date == null){
            return null;
        }
        Timestamp timestamp = new Timestamp(date.getTime());
        timestamp.setNanos(nanos);
        return timestamp;
    }

    /**
     * 1970/1/1 00:00:00.000 GMT からのミリ秒を返します.<br>
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @param day
     *            日
     * @param hour
     *            時
     * @param minute
     *            分
     * @param second
     *            秒
     * @param millis
     *            ミリ秒
     * @return 1970/1/1 00:00:00.000 GMT からのミリ秒
     */
    protected static long time(int year, int month, int day, int hour, int minute, int second, int millis){
        Calendar cal = calendar.get();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, millis);
        return cal.getTimeInMillis();
    }

    /**
     * 現在ミリ秒を返します.<br>
     * 
     * @return 現在ミリ秒
     */
    protected static final long nowTime(){
        return System.currentTimeMillis();
    }

    /**
     * タイムゾーンオフセットを取得
     * 
     * @return デフォルトタイムゾーンのオフセット値
     */
    protected static final int getTimeZoneOffset(){
        return TimeZone.getDefault().getRawOffset();
    }

    /**
     * 現在時刻
     * 
     * @return 現在日時の{@link Date}オブジェクト
     */
    public static Date now(){
        return new Date(nowTime());
    }

    /**
     * 当日を返します.<br>
     * 時刻が 00:00:00.000 の {@link Date} を取得します。
     * 
     * @return 当日の{@link Date}オブジェクト
     */
    public static Date today(){
        return new Date((nowTime() / ONE_DATE) * ONE_DATE - getTimeZoneOffset());
    }

    /**
     * 年月を返します.<br>
     * ex. 2012/05/10 12:34:56.789 -> 2012/05/01 00:00:00.000
     * 
     * @param date
     *            元となる{@link Date}オブジェクト
     * @return 年月の{@link Date}オブジェクト
     */
    public static Date month(Date date){
        if(date == null){
            return null;
        }
        Calendar cal = calendar.get();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 年月日を返します.<br>
     * ex. 2012/05/10 12:34:56.789 -> 2012/05/10 00:00:00.000
     * 
     * @param date
     *            元となる{@link Date}オブジェクト
     * @return 年月日の{@link Date}オブジェクト
     */
    public static Date date(Date date){
        if(date == null){
            return null;
        }
        return new Date((date.getTime() / ONE_DATE) * ONE_DATE - getTimeZoneOffset());
    }

    /**
     * 最終時刻を返します.<br>
     * ex. 2012/05/10 12:34:56.789 -> 2012/05/10 23:59:59.999
     * 
     * @param date
     *            元となる{@link Date}オブジェクト
     * @return 最終時刻の{@link Date}オブジェクト
     */
    public static Date endOfDate(Date date){
        if(date == null){
            return null;
        }
        Calendar cal = calendar.get();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 今月末を返します.<br>
     * 
     * @return 今月末の{@link Date}オブジェクト
     */
    public static Date endOfMonth(){
        return endOfMonth(now());
    }

    /**
     * 月末を返します.<br>
     * ex. 2012/05/10 12:34:56.789 -> 2012/05/31 00:00:00.000
     * 
     * @param date
     *            元となる{@link Date}オブジェクト
     * @return 月末の{@link Date}オブジェクト
     */
    public static Date endOfMonth(Date date){
        if(date == null){
            return null;
        }
        Calendar cal = calendar.get();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 日を加算します.<br>
     * 
     * @param date
     *            元となる{@link Date}オブジェクト
     * @param days
     *            加算する日数
     * @return 加算後の{@link Date}オブジェクト
     */
    public static Date addDays(Date date, int days){
        if(date == null){
            return null;
        }
        return new Date(date.getTime() + ONE_DATE * days);
    }

    /**
     * 月を加算します.<br>
     * 
     * @param date
     *            元となる{@link Date}オブジェクト
     * @param months
     *            加算する月数
     * @return 加算後の{@link Date}オブジェクト
     */
    public static Date addMonths(Date date, int months){
        if(date == null){
            return null;
        }
        Calendar cal = calendar.get();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }
}
