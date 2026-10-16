package com.google.gson.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JavaVersion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f90354a = a();

    private static int a() {
        return c(System.getProperty("java.version"));
    }

    private static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < str.length(); i3++) {
                char cCharAt = str.charAt(i3);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static int c(String str) {
        int iE = e(str);
        if (iE == -1) {
            iE = b(str);
        }
        if (iE == -1) {
            return 6;
        }
        return iE;
    }

    public static boolean d() {
        return f90354a >= 9;
    }

    private static int e(String str) {
        try {
            String[] strArrSplit = str.split("[._]");
            int i3 = Integer.parseInt(strArrSplit[0]);
            return (i3 != 1 || strArrSplit.length <= 1) ? i3 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
