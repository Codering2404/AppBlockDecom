package com.google.android.libraries.places.internal;

import com.facebook.appevents.AppEventsConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzur {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Locale f78663a = Locale.ROOT;

    public static String a(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            if (obj.getClass().isArray()) {
                return obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : Arrays.toString((Object[]) obj);
            }
            String string = obj.toString();
            return string != null ? string : f(obj, "toString() returned null");
        } catch (RuntimeException e3) {
            return e(obj, e3);
        }
    }

    public static void b(Formattable formattable, StringBuilder sb, zzuk zzukVar) {
        int iJ = zzukVar.j();
        int i3 = iJ & 162;
        if (i3 != 0) {
            i3 = ((iJ & 32) != 0 ? 1 : 0) | ((iJ & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 2 : 0) | ((iJ & 2) != 0 ? 4 : 0);
        }
        int length = sb.length();
        Formatter formatter = new Formatter(sb, f78663a);
        try {
            formattable.formatTo(formatter, i3, zzukVar.f(), zzukVar.g());
        } catch (RuntimeException e3) {
            sb.setLength(length);
            try {
                formatter.out().append(e(formattable, e3));
            } catch (IOException unused) {
            }
        }
    }

    static void c(StringBuilder sb, Number number, zzuk zzukVar) {
        boolean zK = zzukVar.k();
        long jLongValue = number.longValue();
        if (number instanceof Long) {
            d(sb, jLongValue, zK);
            return;
        }
        if (number instanceof Integer) {
            d(sb, jLongValue & 4294967295L, zK);
            return;
        }
        if (number instanceof Byte) {
            d(sb, jLongValue & 255, zK);
            return;
        }
        if (number instanceof Short) {
            d(sb, jLongValue & 65535, zK);
        } else {
            if (!(number instanceof BigInteger)) {
                throw new IllegalStateException("unsupported number type: ".concat(String.valueOf(number.getClass())));
            }
            String string = ((BigInteger) number).toString(16);
            if (zK) {
                string = string.toUpperCase(f78663a);
            }
            sb.append(string);
        }
    }

    private static void d(StringBuilder sb, long j3, boolean z2) {
        if (j3 == 0) {
            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            return;
        }
        String str = true != z2 ? "0123456789abcdef" : "0123456789ABCDEF";
        for (int iNumberOfLeadingZeros = (63 - Long.numberOfLeadingZeros(j3)) & (-4); iNumberOfLeadingZeros >= 0; iNumberOfLeadingZeros -= 4) {
            sb.append(str.charAt((int) ((j3 >>> iNumberOfLeadingZeros) & 15)));
        }
    }

    private static String e(Object obj, RuntimeException runtimeException) {
        String simpleName;
        try {
            simpleName = runtimeException.toString();
        } catch (RuntimeException e3) {
            simpleName = e3.getClass().getSimpleName();
        }
        return f(obj, simpleName);
    }

    private static String f(Object obj, String str) {
        String name = obj.getClass().getName();
        int iIdentityHashCode = System.identityHashCode(obj);
        int length = name.length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(iIdentityHashCode).length() + 2 + String.valueOf(str).length() + 1);
        sb.append("{");
        sb.append(name);
        sb.append("@");
        sb.append(iIdentityHashCode);
        sb.append(": ");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
