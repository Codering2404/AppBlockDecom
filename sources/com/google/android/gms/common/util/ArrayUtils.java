package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ArrayUtils {
    public static boolean a(int[] iArr, int i3) {
        if (iArr != null) {
            for (int i4 : iArr) {
                if (i4 == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(Object[] objArr, Object obj) {
        int length = objArr != null ? objArr.length : 0;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (!Objects.b(objArr[i3], obj)) {
                i3++;
            } else if (i3 >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void c(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(dArr[i3]);
        }
    }

    public static void d(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(fArr[i3]);
        }
    }

    public static void e(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(iArr[i3]);
        }
    }

    public static void f(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(jArr[i3]);
        }
    }

    public static void g(StringBuilder sb, Object[] objArr) {
        int length = objArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(objArr[i3]);
        }
    }

    public static void h(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(zArr[i3]);
        }
    }

    public static void i(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i3]);
            sb.append("\"");
        }
    }
}
