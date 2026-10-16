package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1126Vt {
    A03,
    A04;

    public static byte[] A00;
    public static String[] A01 = {"muyYqE", "E9PpaFAJE9Hnt4d", "ghgofcX6zvMHlgudfTaqS8Nc5lCgt2E9", "YIYOJOVvACGtG0gL9GV7SlNTtBEERz", "JgOQfSPAOiHiw6Rg9nCac4dnqR1hKwEe", "B0OWkxWZ1EYllgtprLWqObgHiHWKfwuG", "4mHTrr1U8XEd9q", "nBr2KfKPMHO8Xb5ORNsKNBZ88yN02YcX"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[4].charAt(4) != strArr[2].charAt(4)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "ButKfEyieReZO2wb3N14oIodeWUfkj1h";
            strArr2[2] = "KKvBf6HmkOg9UJ27XgqfLe6TaNBCJiNp";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 22);
            i6++;
        }
    }

    public static void A01() {
        A00 = new byte[]{88, 85, 111, 110, 111, 100};
    }

    static {
        A01();
    }
}
