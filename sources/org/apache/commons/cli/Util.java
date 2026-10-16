package org.apache.commons.cli;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class Util {
    static String a(String str) {
        if (str.startsWith("\"")) {
            str = str.substring(1, str.length());
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }

    static String b(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith("--") ? str.substring(2, str.length()) : str.startsWith("-") ? str.substring(1, str.length()) : str;
    }
}
