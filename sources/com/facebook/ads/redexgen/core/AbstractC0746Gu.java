package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0746Gu {
    public static byte[] A00;
    public static String[] A01 = {"xbfghvjfzJvhku5N8OELiq204nVuVPFf", "QHdNkhaNqF6P8ZoHbM5E7ac9pSEOFT0I", "gTrjGkh7SJSYjcOCOWWCub6Uckq9Yltj", "B1r", "bt5fTN19iCcMkB3LBJCDNqZ6iO4ZjItL", "3vLSrbB7SQdOWYeFWsx", "mXdQOoT87saNovPMynKxKkWZ", "FMZbalTyTizDclIiFtsmYNu0onhdvCq9"};
    public static final int[] A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C0745Gt A04(com.facebook.ads.redexgen.core.C04544u r12) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC0746Gu.A04(com.facebook.ads.redexgen.X.4u):com.facebook.ads.redexgen.X.Gt");
    }

    public static String A05(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = bArrCopyOfRange[i6];
            if (A01[7].charAt(26) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "ZZS15YLfqnGzRKQmbGGBAS62S7daT6Pr";
            strArr[0] = "wbQ3s0ZhLtikxP7PtpYOpvXFjSSpaatC";
            bArrCopyOfRange[i6] = (byte) ((b3 - i5) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{-121, -101, -118, -113, -107, 85, -121, -119, 90};
    }

    static {
        A06();
        A02 = new int[]{AdError.CACHE_ERROR_CODE, AdError.SERVER_ERROR_CODE, 1920, 1601, 1600, AdError.NO_FILL_ERROR_CODE, 1000, 960, 800, 800, 480, RCHTTPStatusCodes.BAD_REQUEST, RCHTTPStatusCodes.BAD_REQUEST, 2048};
    }

    public static int A00(C04544u c04544u, int i3) {
        int i4 = 0;
        while (true) {
            int value = c04544u.A04(i3);
            int i5 = i4 + value;
            if (!c04544u.A0H()) {
                return i5;
            }
            i4 = (i5 + 1) << i3;
        }
    }

    public static int A01(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return A04(new C04544u(bArr)).A03;
    }

    public static int A02(byte[] bArr, int i3) {
        if (bArr.length < 7) {
            return -1;
        }
        int headerSize = bArr[2];
        int i4 = (headerSize & 255) << 8;
        int headerSize2 = bArr[3];
        int i5 = i4 | (headerSize2 & 255);
        int frameSize = 2 + 2;
        if (i5 == 65535) {
            int headerSize3 = bArr[4];
            int i6 = (headerSize3 & 255) << 16;
            int headerSize4 = bArr[5];
            int i7 = i6 | ((headerSize4 & 255) << 8);
            int headerSize5 = bArr[6];
            i5 = i7 | (headerSize5 & 255);
            frameSize += 3;
        }
        if (i3 == 44097) {
            frameSize += 2;
        }
        int i8 = i5 + frameSize;
        String[] strArr = A01;
        String str = strArr[1];
        String str2 = strArr[4];
        int iCharAt = str.charAt(27);
        int headerSize6 = str2.charAt(27);
        if (iCharAt == headerSize6) {
            throw new RuntimeException();
        }
        A01[7] = "5dLepgbvmcODZNjBgadRz1gh8sb0vEN9";
        return i8;
    }

    public static C2208qI A03(C04554v c04554v, String str, String str2, DrmInitData drmInitData) {
        c04554v.A0g(1);
        return new C03992p().A0y(str).A11(A05(0, 9, 31)).A0b(2).A0m(((c04554v.A0I() & 32) >> 5) == 1 ? 48000 : 44100).A0u(drmInitData).A10(str2).A14();
    }

    public static void A07(int i3, C04554v c04554v) {
        c04554v.A0d(7);
        byte[] bArrA0l = c04554v.A0l();
        bArrA0l[0] = -84;
        bArrA0l[1] = 64;
        bArrA0l[2] = -1;
        bArrA0l[3] = -1;
        bArrA0l[4] = (byte) ((i3 >> 16) & 255);
        bArrA0l[5] = (byte) ((i3 >> 8) & 255);
        bArrA0l[6] = (byte) (i3 & 255);
    }
}
