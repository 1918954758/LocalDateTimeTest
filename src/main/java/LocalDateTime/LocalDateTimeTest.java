package LocalDateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @ClassName LocalDateTimeTest
 * @Discription LocalDateTime测试
 * @Author 子辰
 * @Date 2020/11/16 16:43
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
        //Instant instant = Instant.now();
        //获取LocalDateTime实例
        LocalDateTime localDateTime = LocalDateTime.now();
        //
        System.out.println(localDateTime);
        //年
        System.out.println(localDateTime.getYear());
        //月
        System.out.println(localDateTime.getMonthValue());
        //System.out.println(localDateTime.getDayOfWeek());
        //日
        System.out.println(localDateTime.getDayOfMonth());
        //年月日
        System.out.println(localDateTime.getYear() + "/" + localDateTime.getMonthValue() + "/" + localDateTime.getDayOfMonth());
        //秒
        System.out.println(localDateTime.getSecond());
        //毫秒
        System.out.println("毫秒" + localDateTime.getNano());

        // 当地 年-月-日 ， 时:分:秒(xx.xxx)
        System.out.println(localDateTime.toLocalDate() + " , " + localDateTime.toLocalTime());

        System.out.println("==================================");

        // 增加一年
        System.out.println(localDateTime.plusYears(1).getYear());
        // fixme  localDateTime.plus(1, ChronoUnit.YEARS)
        System.out.println(localDateTime.plus(1, ChronoUnit.YEARS));
        // 减少一年
        System.out.println(localDateTime.minusYears(1).getYear());
        // 增加一月
        System.out.println(localDateTime.plusMonths(1).getMonthValue());
        // 减少一月
        System.out.println(localDateTime.minusMonths(1).getMonthValue());
        // 增加一天
        System.out.println(localDateTime.plusDays(1).getDayOfMonth());
        // 减少一天
        System.out.println(localDateTime.minusDays(1).getDayOfMonth());

        // 修改年为 2019
        System.out.println(localDateTime.withYear(2019).getYear());
        // 修改月为 10月
        System.out.println(localDateTime.withMonth(10).getMonthValue());
        // 修改日为 10号
        System.out.println(localDateTime.withDayOfYear(10).getDayOfMonth());


        System.out.println("===========================================");
        // 格式化时间
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);

        // 自定义格式化时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String s3 = localDate.format(dateTimeFormatter);
        System.out.println(s3);

        // 解析时间
        LocalDate localDate1 = LocalDate.parse("20190910", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate localDate2 = LocalDate.parse("2019-09-10", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localDate1);
        System.out.println(localDate2);

        /**
         * LocalDateTime获取毫秒数
         */
        //获取秒数
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        //获取毫秒数
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(System.currentTimeMillis());
        System.out.println(milliSecond);

        /**
         * LocalDateTime与String互转
         */
        //时间转字符串格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        System.out.println(dateTime);
        //字符串转时间
        String dateTimeStr = "2018-07-28 14:11:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTimeStr, df);
        System.out.println(localDateTime1);

        /**
         * Date与LocalDateTime互转
         */
        // Date -> LocalDateTime
        System.out.println("new Date(): " + new Date());
        System.out.println("LocalDateTime : " + dateConvertToLocalDateTime(new Date()));
        // LocalDateTime -> Date
        System.out.println("LocalDateTime : " + localDateTime1);
        System.out.println("Date : " +localDateTimeConvertToDate(localDateTime1));

        System.out.println("===========================");
        /**
         * 获取当前时间，转成字符串型 2020-11-16 20:23:02
         */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createTime = LocalDateTime.now(ZoneOffset.of("+8")).format(dtf);
        System.out.println(createTime);

    }

    //将java.util.Date 转换为java8 的java.time.LocalDateTime,默认时区为东8区
    public static LocalDateTime dateConvertToLocalDateTime(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }


    //将java8 的 java.time.LocalDateTime 转换为 java.util.Date，默认时区为东8区
    public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));

    }
}
