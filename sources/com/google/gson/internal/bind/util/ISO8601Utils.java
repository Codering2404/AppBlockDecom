package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ISO8601Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f90524a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i3, char c3) {
        return i3 < str.length() && str.charAt(i3) == c3;
    }

    public static String b(Date date) {
        return c(date, false, f90524a);
    }

    public static String c(Date date, boolean z2, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z2 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        e(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        e(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        e(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        e(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        e(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        e(sb, gregorianCalendar.get(13), 2);
        if (z2) {
            sb.append('.');
            e(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i3 = offset / 60000;
            int iAbs = Math.abs(i3 / 60);
            int iAbs2 = Math.abs(i3 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            e(sb, iAbs, 2);
            sb.append(':');
            e(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int d(String str, int i3) {
        while (i3 < str.length()) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                return i3;
            }
            i3++;
        }
        return str.length();
    }

    private static void e(StringBuilder sb, int i3, int i4) {
        String string = Integer.toString(i3);
        for (int length = i4 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00e2 A[Catch: IllegalArgumentException -> 0x004e, NumberFormatException -> 0x0051, IndexOutOfBoundsException -> 0x0054, TryCatch #2 {IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:23:0x005e, B:25:0x006e, B:26:0x0070, B:28:0x007c, B:29:0x007f, B:31:0x0085, B:35:0x008f, B:40:0x009f, B:42:0x00a7, B:53:0x00dc, B:55:0x00e2, B:57:0x00e8, B:81:0x0195, B:61:0x00f2, B:62:0x010d, B:63:0x010e, B:67:0x012a, B:69:0x0137, B:72:0x0140, B:74:0x015f, B:77:0x016e, B:78:0x0190, B:80:0x0193, B:66:0x0119, B:83:0x01c6, B:84:0x01cd, B:46:0x00bf, B:47:0x00c2), top: B:95:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c6 A[Catch: IllegalArgumentException -> 0x004e, NumberFormatException -> 0x0051, IndexOutOfBoundsException -> 0x0054, TryCatch #2 {IndexOutOfBoundsException -> 0x0054, NumberFormatException -> 0x0051, IllegalArgumentException -> 0x004e, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:23:0x005e, B:25:0x006e, B:26:0x0070, B:28:0x007c, B:29:0x007f, B:31:0x0085, B:35:0x008f, B:40:0x009f, B:42:0x00a7, B:53:0x00dc, B:55:0x00e2, B:57:0x00e8, B:81:0x0195, B:61:0x00f2, B:62:0x010d, B:63:0x010e, B:67:0x012a, B:69:0x0137, B:72:0x0140, B:74:0x015f, B:77:0x016e, B:78:0x0190, B:80:0x0193, B:66:0x0119, B:83:0x01c6, B:84:0x01cd, B:46:0x00bf, B:47:0x00c2), top: B:95:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date f(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.f(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int g(String str, int i3, int i4) {
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
