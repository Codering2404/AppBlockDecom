package com.google.zxing.common;

import com.facebook.stetho.common.Utf8Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum CharacterSetECI {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, Utf8Charset.NAME),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");

    private static final Map E = new HashMap();
    private static final Map F = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f91812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f91813b;

    static {
        for (CharacterSetECI characterSetECI : values()) {
            for (int i3 : characterSetECI.f91812a) {
                E.put(Integer.valueOf(i3), characterSetECI);
            }
            F.put(characterSetECI.name(), characterSetECI);
            for (String str : characterSetECI.f91813b) {
                F.put(str, characterSetECI);
            }
        }
    }

    CharacterSetECI(int i3) {
        this(new int[]{i3}, new String[0]);
    }

    public static CharacterSetECI a(String str) {
        return (CharacterSetECI) F.get(str);
    }

    public int b() {
        return this.f91812a[0];
    }

    CharacterSetECI(int i3, String... strArr) {
        this.f91812a = new int[]{i3};
        this.f91813b = strArr;
    }

    CharacterSetECI(int[] iArr, String... strArr) {
        this.f91812a = iArr;
        this.f91813b = strArr;
    }
}
