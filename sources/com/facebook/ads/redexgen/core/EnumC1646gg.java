package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class EnumC1646gg {
    public static byte[] A01;
    public static String[] A02 = {"4MR", "ox3", "IUsSI7rcrCx1ERgKd0rYF5wqQshT9MFY", "XMpLbdKCI8ptDt9BVBTjCKDwrbbZ39Yk", "reDnu4iC6gOf", "58W6JAylc1sA", "T5hdxNMEH3a8tXz2YdYKh9bF2ZTD6zRG", "CM8HCV1eVyulF3snUIL5CjajvzNLA86A"};
    public static final /* synthetic */ EnumC1646gg[] A03;
    public static final EnumC1646gg A04;
    public static final EnumC1646gg A05;
    public String A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[5].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "zM61rMpjrvDScug74JUjCxPutIg5FxhC";
            strArr2[7] = "TMGBJitMUu1pxt90KbWrvOLR2BVfJ6J0";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 11);
            i6++;
        }
    }

    public static void A01() {
        A01 = new byte[]{-86, -83, -80, -80, -104, -109, -121, -124, -105, -120, -116, -113, -110, -110, -88, -93, -105, -108, -89, -104};
    }

    static {
        A01();
        A04 = new EnumC1646gg(A00(0, 4, 89), 0, A00(10, 4, 27));
        A05 = new EnumC1646gg(A00(4, 6, 56), 1, A00(14, 6, 40));
        A03 = A02();
    }

    public EnumC1646gg(String str, int i3, String str2) {
        this.A00 = str2;
    }

    public static /* synthetic */ EnumC1646gg[] A02() {
        EnumC1646gg[] enumC1646ggArr = new EnumC1646gg[2];
        enumC1646ggArr[0] = A04;
        EnumC1646gg enumC1646gg = A05;
        String[] strArr = A02;
        if (strArr[5].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        A02[2] = "lJSENTz9psORZi9A2zDcPU2PQxg7yytN";
        enumC1646ggArr[1] = enumC1646gg;
        return enumC1646ggArr;
    }

    public final String A03() {
        return this.A00;
    }

    public static EnumC1646gg valueOf(String str) {
        return (EnumC1646gg) Enum.valueOf(EnumC1646gg.class, str);
    }

    public static EnumC1646gg[] values() {
        return (EnumC1646gg[]) A03.clone();
    }
}
