package app.tarot.be.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class CommonUtil {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object instance) {
        if (instance == null) return null;
        try {
            return mapper.writeValueAsString(instance);
        } catch (JsonProcessingException e) {
            log.warn(ExceptionUtils.getStackTrace(e));
            return instance.toString();
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) throws IOException {
        if (CommonUtil.isNullOrEmpty(json)) {
            return null;
        }

        return mapper.readValue(json, clazz);
    }

    public static <T> List<T> jsonToList(String json, TypeReference<List<T>> type) throws IOException {
        if (CommonUtil.isNullOrEmpty(json)) {
            return null;
        }
        return mapper.readValue(json, type);
    }

    public static <T> String[] toArray(List<T> list, Function<T, String> function) {
        if (isEmpty(list))
            return new String[0];
        var arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = function.apply(list.get(i));
        }
        return arr;
    }

    /***
     * Convert Date to String with format
     * @param date
     * @param format (ex: yyyyMMdd)
     * @return String date
     */
    public static String getDateString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /***
     * Convert Date to String with format
     * @param instant
     * @param format (ex: yyyyMMdd)
     * @return String date
     */
    public static String getDateString(Instant instant, String format) {
        if (isEmpty(instant)) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(Date.from(instant));
    }

    /***
     * Convert Date to String with format
     * @param date
     * @param oldFormat (ex: yyyyMMdd)
     * @param newFormat (ex: yyyy/MM/dd)
     * @return String date
     */
    public static String getDateString(String date, String oldFormat, String newFormat) throws ParseException {
        if (isEmpty(date))
            return date;
        SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
        SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);
        return sdf2.format(sdf.parse(date));
    }

    /***
     * Convert Date to String with format
     * @param time
     * @param format (ex: yyyyMMdd)
     * @return String date
     */
    public static String getDateString(Long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(time);
    }

    /***
     * Convert LocalDateTime to String with format
     * @param date
     * @param format (ex: yyyyMMdd)
     * @return String date
     */
    public static String getDateString(LocalDateTime date, String format) {
        var dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(date);
    }

    /***
     * Convert LocalDate to String with format
     * @param date
     * @param format (ex: yyyyMMdd)
     * @return String date
     */
    public static String getDateString(LocalDate date, String format) {
        var dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(date);
    }

    /***
     * Convert String to Date with format
     * @param date
     * @param format (ex: yyyyMMdd)
     * @return String date
     */
    public static Date formatStringToDate(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    /***
     * Convert String to LocalDate with format
     * @param date
     * @param format (ex: yyyyMMdd)
     * @return String date
     */
    public static LocalDate formatStringToLocalDate(String date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, formatter);
    }
    /***
     * Check string null or empty
     * @param str
     * @return boolean, NULL or Empty is true.
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str);
    }

    /***
     * Check string[] null or empty
     * @param str
     * @return boolean, NULL or Empty is true.
     */
    public static boolean isNullOrEmpty(String[] str) {
        return str == null || str.length == 0;
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNotEmpty(String[] array) {
        return !isNullOrEmpty(array);
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    public static boolean isNotEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    public static <T> boolean isEmpty(T obj) {
        if (obj == null) return true;
        if (obj instanceof Collection)
            return ((Collection<?>) obj).size() == 0;
        return "".equals(obj);
    }

    public static <T> boolean isNotEmpty(T obj) {
        return !isEmpty(obj);
    }

    public static <T> T getOrElse(T value, T other) {
        return isEmpty(value) ? other : value;
    }

    public static String formatNumber(String numberString) {
        if (isEmpty(numberString))
            return numberString;
        var number = Double.parseDouble(numberString);
        return DECIMAL_FORMAT.format(number);
    }

    public static String formatNumber(int number) {
        return DECIMAL_FORMAT.format((double) number);
    }

    public static String formatNumber(long number) {
        return DECIMAL_FORMAT.format((double) number);
    }

    public static double formatDouble(double value) {
        String formattedValue = DECIMAL_FORMAT.format(value);
        return Double.parseDouble(formattedValue);
    }

    public static String formatNumber(double number) {
        return DECIMAL_FORMAT.format(number);
    }

    public static String formatRate(String number) {
        if (CommonUtil.isNullOrEmpty(number))
            return "0.0";
        if (number.contains("."))
            return number;
        return number + ".0";
    }


    public static String generatePassword() {
        final String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String s2 = "abcdefghijklmnopqrstuvwxyz";
        final String s3 = "0123456789";
        final String s4 = "!@#&$";
        final String chars = s1 + s2 + s3 + s4;

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        sb.append(s1.charAt(random.nextInt(s1.length())));
        sb.append(s2.charAt(random.nextInt(s2.length())));
        sb.append(s3.charAt(random.nextInt(s3.length())));
        sb.append(s4.charAt(random.nextInt(s4.length())));

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public static Long convertStringToLong(String number) {
        try {
            if (Objects.equals(number, "") || number == null) return null;
            return Long.parseLong(number);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static Integer convertStringToInteger(String number) {
        try {
            if (Objects.equals(number, "") || number == null) return null;
            return Integer.valueOf(number);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static Instant convertDate(String collaborationStartDate) {
        Date date;
        Instant instant;
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String stringDate;
            if (collaborationStartDate == null || collaborationStartDate.equals("")) {
                stringDate = dateFormatter.format(new Date().getTime());
            } else {
                stringDate = collaborationStartDate + " " + new SimpleDateFormat("HH:mm:ss").format(new Date().getTime());
            }
            date = dateFormatter.parse(stringDate);
            instant = date.toInstant();
        } catch (Exception e) {
            return null;
        }
        return instant;
    }

    public static Date stampTimeToDate(Long stampTime) {
        if (stampTime == null) return null;
        return new Date(stampTime);
    }

    public static Instant stampTimeToInstant(Long stampTime) {
        if (isEmpty(stampTime) || (stampTime == 0)) return null;
        return stampTimeToDate(stampTime).toInstant();
    }

    public static Set<String> findDuplicate(List<?> list) {
        Set<String> setCheck = new HashSet<>();
        Set<String> setToReturn = new HashSet<>();
        if (isNotEmpty(list)) {
            for (var item : list) {
                if (!setCheck.add(String.valueOf(item))) {
                    setToReturn.add(String.valueOf(item));
                }
            }
        }
        return setToReturn;
    }

    public static Set<?> findNotExist(List<?> listContainer, List<?> listItem) {
        Set<?> listReturn = new HashSet<>(listContainer);
        listItem.forEach(listReturn::remove);
        return listReturn;
    }

    public static List<String> findNotExistString(List<String> listContainer, List<String> listItem) {
        List<String> listReturn = new ArrayList<>(listContainer);
        listReturn.removeAll(listItem);
        return listReturn;
    }

    public static List<Long> findNotExistLong(List<Long> listContainer, List<Long> listItem) {
        List<Long> listReturn = new ArrayList<>(listContainer);
        listReturn.removeAll(listItem);
        return listReturn;
    }

    public static boolean isLessThanOrEqual(Instant instant1, Instant instant2) {
        return instant1.isBefore(instant2) || instant1.equals(instant2);
    }

    public static boolean isGreaterThanOrEqual(Instant instant1, Instant instant2) {
        return instant1.isAfter(instant2) || instant1.equals(instant2);
    }


    public static <T> List<T> sortListByComparators(List<T> list, Comparator<T> comparatorFirst, Comparator<T> comparatorSecond) {
        if (isEmpty(list)) return list;
        return list.stream().sorted(comparatorFirst.thenComparing(comparatorSecond)).collect(Collectors.toList());
    }

    public static <T> List<T> sortListByModifiedAtDesc(List<T> list, Function<T, Long> function) {
        if (isEmpty(list)) return list;
        return list.stream().sorted(
                (o1, o2) ->
                {
                    var x = function.apply(o1);
                    var y = function.apply(o2);
                    return (int) (x - y);
                }
        ).collect(Collectors.toList());
    }

    public static <T> HashMap<T, Integer> informationBasedOnStatus(List<Integer> list, List<T> data) {
        HashMap<T, Integer> mapByStatus = new HashMap<T, Integer>();
        for (var value : data) {
            mapByStatus.put(value, 0);
        }
        if (CommonUtil.isNotEmpty(list)) {
            for (var number : list) {
                mapByStatus.forEach((key, values) -> {
                    if (Objects.equals(number, key)) {
                        mapByStatus.computeIfPresent(key, (k, v) -> v + 1);
                    }
                });
            }
        }
        return mapByStatus;
    }

    public static List<Integer> getNumberDayInMonth(Integer month, Integer year) {
        List<Integer> listMonth = new ArrayList<>();
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        for (int i = 1; i <= daysInMonth; i++) {
            listMonth.add(i);
        }
        return listMonth;
    }

    public static String getStringJson(String s) {
        if (CommonUtil.isEmpty(s)) return "";
        return s.replaceAll("[^a-zA_Z,-0-9]", "").replaceAll(",", ", ");
    }

    public static String getBigDecimal(BigDecimal value) {
        if (CommonUtil.isEmpty(value)) {
            return null;
        } else {
            return value.setScale(2, RoundingMode.HALF_UP).toString();
        }
    }



    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static String trimString(String value) {
        if (isEmpty(value)) return null;
        return value.trim();
    }

}