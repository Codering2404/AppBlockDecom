package com.google.android.libraries.places.internal;

import com.google.common.math.LongMath;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbud {
    public static List a(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
    }

    public static List b(Map map, String str) {
        List listA = a(map, str);
        if (listA == null) {
            return null;
        }
        j(listA);
        return listA;
    }

    public static List c(Map map, String str) {
        List listA = a(map, str);
        if (listA == null) {
            return null;
        }
        for (int i3 = 0; i3 < listA.size(); i3++) {
            if (!(listA.get(i3) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", listA.get(i3), Integer.valueOf(i3), listA));
            }
        }
        return listA;
    }

    public static Map d(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
    }

    public static Double e(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' in '%s' is not a number", obj, str, map));
        }
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a double", obj, str));
        }
    }

    public static Integer f(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof Double)) {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
        }
        Double d3 = (Double) obj;
        int iIntValue = d3.intValue();
        if (iIntValue == d3.doubleValue()) {
            return Integer.valueOf(iIntValue);
        }
        new StringBuilder(String.valueOf(d3).length() + 31);
        throw new ClassCastException("Number expected to be integer: ".concat(String.valueOf(d3)));
    }

    public static String g(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
    }

    public static Long h(Map map, String str) {
        boolean z2;
        int iCharAt;
        String strG = g(map, str);
        if (strG == null) {
            return null;
        }
        try {
            if (strG.isEmpty() || strG.charAt(strG.length() - 1) != 's') {
                throw new ParseException("Invalid duration string: ".concat(strG), 0);
            }
            if (strG.charAt(0) == '-') {
                strG = strG.substring(1);
                z2 = true;
            } else {
                z2 = false;
            }
            String strSubstring = strG.substring(0, strG.length() - 1);
            String strSubstring2 = "";
            int iIndexOf = strSubstring.indexOf(46);
            if (iIndexOf != -1) {
                strSubstring2 = strSubstring.substring(iIndexOf + 1);
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            long jA = Long.parseLong(strSubstring);
            if (strSubstring2.isEmpty()) {
                iCharAt = 0;
            } else {
                iCharAt = 0;
                for (int i3 = 0; i3 < 9; i3++) {
                    iCharAt *= 10;
                    if (i3 < strSubstring2.length()) {
                        if (strSubstring2.charAt(i3) < '0' || strSubstring2.charAt(i3) > '9') {
                            throw new ParseException("Invalid nanoseconds.", 0);
                        }
                        iCharAt += strSubstring2.charAt(i3) - '0';
                    }
                }
            }
            if (jA < 0) {
                throw new ParseException("Invalid duration string: ".concat(strG), 0);
            }
            if (z2) {
                jA = -jA;
                iCharAt = -iCharAt;
            }
            if (iCharAt <= -1000000000 || iCharAt >= 1000000000) {
                try {
                    jA = LongMath.a(jA, iCharAt / 1000000000);
                    iCharAt %= 1000000000;
                } catch (IllegalArgumentException unused) {
                    throw new ParseException("Duration value is out of range.", 0);
                }
            }
            if (jA > 0 && iCharAt < 0) {
                iCharAt += 1000000000;
                jA--;
            }
            if (jA < 0 && iCharAt > 0) {
                iCharAt -= 1000000000;
                jA++;
            }
            if (jA < -315576000000L || jA > 315576000000L) {
                throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(jA), Integer.valueOf(iCharAt)));
            }
            long nanos = TimeUnit.SECONDS.toNanos(jA);
            long j3 = iCharAt;
            long j4 = nanos + j3;
            if (!(((nanos ^ j4) >= 0) | ((j3 ^ nanos) < 0))) {
                j4 = ((j4 >>> 63) ^ 1) + Long.MAX_VALUE;
            }
            return Long.valueOf(j4);
        } catch (ParseException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static Boolean i(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, str, map));
    }

    public static List j(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!(list.get(i3) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i3), Integer.valueOf(i3), list));
            }
        }
        return list;
    }
}
