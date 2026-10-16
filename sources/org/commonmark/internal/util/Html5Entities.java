package org.commonmark.internal.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Html5Entities {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f145509a = b();

    public static String a(String str) {
        int i3;
        if (str.startsWith("&") && str.endsWith(";")) {
            String strSubstring = str.substring(1, str.length() - 1);
            if (strSubstring.startsWith("#")) {
                String strSubstring2 = strSubstring.substring(1);
                if (strSubstring2.startsWith("x") || strSubstring2.startsWith("X")) {
                    strSubstring2 = strSubstring2.substring(1);
                    i3 = 16;
                } else {
                    i3 = 10;
                }
                try {
                    int i4 = Integer.parseInt(strSubstring2, i3);
                    return i4 == 0 ? "�" : new String(Character.toChars(i4));
                } catch (IllegalArgumentException unused) {
                    return "�";
                }
            }
            String str2 = (String) f145509a.get(strSubstring);
            if (str2 != null) {
                return str2;
            }
        }
        return str;
    }

    private static Map b() {
        HashMap map = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Html5Entities.class.getResourceAsStream("/org/commonmark/internal/util/entities.properties"), StandardCharsets.UTF_8));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        map.put("NewLine", "\n");
                        return map;
                    }
                    if (line.length() != 0) {
                        int iIndexOf = line.indexOf("=");
                        map.put(line.substring(0, iIndexOf), line.substring(iIndexOf + 1));
                    }
                } finally {
                }
            }
        } catch (IOException e3) {
            throw new IllegalStateException("Failed reading data for HTML named character references", e3);
        }
    }
}
