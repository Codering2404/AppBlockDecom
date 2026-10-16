package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.common.Constants;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Iso8601Utils {
    private static final String GMT_ID = "GMT";
    private static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone(GMT_ID);

    private static boolean checkOffset(String str, int i3, char c3) {
        return i3 < str.length() && str.charAt(i3) == c3;
    }

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(24);
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        sb.append('.');
        padInt(sb, gregorianCalendar.get(14), 3);
        sb.append('Z');
        return sb.toString();
    }

    private static int indexOfNonDigit(String str, int i3) {
        while (i3 < str.length()) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                return i3;
            }
            i3++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i3, int i4) {
        String string = Integer.toString(i3);
        for (int length = i4 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    public static Date parse(String str) {
        int i3;
        int i4;
        int iPow;
        int i5;
        int i6;
        TimeZone timeZone;
        char cCharAt;
        try {
            int i7 = parseInt(str, 0, 4);
            int i8 = checkOffset(str, 4, '-') ? 5 : 4;
            int i9 = i8 + 2;
            int i10 = parseInt(str, i8, i9);
            if (checkOffset(str, i9, '-')) {
                i9 = i8 + 3;
            }
            int i11 = i9 + 2;
            int i12 = parseInt(str, i9, i11);
            boolean zCheckOffset = checkOffset(str, i11, 'T');
            if (!zCheckOffset && str.length() <= i11) {
                return new GregorianCalendar(i7, i10 - 1, i12).getTime();
            }
            if (zCheckOffset) {
                int i13 = i9 + 5;
                int i14 = parseInt(str, i9 + 3, i13);
                if (checkOffset(str, i13, ':')) {
                    i13 = i9 + 6;
                }
                int i15 = i13 + 2;
                i6 = parseInt(str, i13, i15);
                if (checkOffset(str, i15, ':')) {
                    i15 = i13 + 3;
                }
                if (str.length() <= i15 || (cCharAt = str.charAt(i15)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i3 = i7;
                    i4 = i14;
                    i11 = i15;
                    iPow = 0;
                    i5 = 0;
                } else {
                    int i16 = i15 + 2;
                    i5 = parseInt(str, i15, i16);
                    if (i5 > 59 && i5 < 63) {
                        i5 = 59;
                    }
                    if (checkOffset(str, i16, '.')) {
                        int iIndexOfNonDigit = indexOfNonDigit(str, i15 + 4);
                        i3 = i7;
                        iPow = (int) (Math.pow(10.0d, 3 - (r5 - r9)) * ((double) parseInt(str, i15 + 3, Math.min(iIndexOfNonDigit, i15 + 6))));
                        i4 = i14;
                        i11 = iIndexOfNonDigit;
                    } else {
                        i3 = i7;
                        i4 = i14;
                        i11 = i16;
                        iPow = 0;
                    }
                }
            } else {
                i3 = i7;
                i4 = 0;
                iPow = 0;
                i5 = 0;
                i6 = 0;
            }
            if (str.length() <= i11) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 == 'Z') {
                timeZone = TIMEZONE_Z;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i11);
                if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                    timeZone = TIMEZONE_Z;
                } else {
                    String str2 = GMT_ID + strSubstring;
                    TimeZone timeZone2 = TimeZone.getTimeZone(str2);
                    String id = timeZone2.getID();
                    if (!id.equals(str2) && !id.replace(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "").equals(str2)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i10 - 1);
            gregorianCalendar.set(5, i12);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i5);
            gregorianCalendar.set(14, iPow);
            return gregorianCalendar.getTime();
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw new SerializationException("Not an RFC 3339 date: " + str, e);
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
            throw new SerializationException("Not an RFC 3339 date: " + str, e);
        }
    }

    private static int parseInt(String str, int i3, int i4) throws NumberFormatException {
        int i5;
        int i6;
        if (i3 < 0 || i4 > str.length() || i3 > i4) {
            throw new NumberFormatException(str);
        }
        if (i3 < i4) {
            i6 = i3 + 1;
            int iDigit = Character.digit(str.charAt(i3), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i3, i4));
            }
            i5 = -iDigit;
        } else {
            i5 = 0;
            i6 = i3;
        }
        while (i6 < i4) {
            int i7 = i6 + 1;
            int iDigit2 = Character.digit(str.charAt(i6), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i3, i4));
            }
            i5 = (i5 * 10) - iDigit2;
            i6 = i7;
        }
        return -i5;
    }
}
