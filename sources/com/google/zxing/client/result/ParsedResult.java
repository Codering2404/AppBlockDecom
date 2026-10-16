package com.google.zxing.client.result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ParsedResult {
    public static void b(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public static void c(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                b(str, sb);
            }
        }
    }

    public abstract String a();

    public final String toString() {
        return a();
    }
}
