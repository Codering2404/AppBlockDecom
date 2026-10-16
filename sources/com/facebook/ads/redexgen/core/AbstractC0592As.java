package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.google.common.primitives.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.As, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC0592As extends AbstractC2268re {
    public static byte[] A00;
    public static String[] A01 = {"siq85GDJwTeYE", "hCeAcOWL38esGxpCGhAcOByVvpt4rkG9", "m2sukptzj10OlAU9Tp5GtC3mJBPhtf8e", "xjjTaPx7kc7NMEZNqBPsTeRSC2dGu2kw", "w", "lzhISLab9GK0zTqogctfE75BYP1X9oPw", "tkIGufAtpO8Bl63czpB", ""};

    public static String A08(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = bArrCopyOfRange[i6] ^ i5;
            if (A01[7].length() != 0) {
                throw new RuntimeException();
            }
            A01[7] = "";
            bArrCopyOfRange[i6] = (byte) (i7 ^ 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A00 = new byte[]{44, Ascii.SYN, Ascii.ETB, 67, Ascii.FF, 5, 67, 17, 2, Ascii.CR, 4, 6, 89, 67, 70, Ascii.DLE, 126, 122, 125, 51, 59, 54, 96, 58, 51, 126, 102, 96, 103, 51, 113, 118, 51, Ascii.DEL, 118, 96, 96, 51, 103, 123, 114, 125, 51, 124, 97, 51, 118, 98, 102, 114, Ascii.DEL, 51, 103, 124, 51, 126, 114, 107, 51, 59, 54, 96, 58};
    }

    static {
        A0A();
    }

    public static int A00(int value) {
        return value;
    }

    public static int A01(int value, int min, int max) {
        AbstractC1878ki.A0G(min <= max, A08(16, 47, 91), min, max);
        return Math.min(Math.max(value, min), max);
    }

    public static int A02(long value) {
        int i3 = (int) value;
        AbstractC1878ki.A0H(((long) i3) == value, A08(0, 16, 43), value);
        return i3;
    }

    public static int A03(long value) {
        if (value <= 2147483647L) {
            if (value < -2147483648L) {
                return Integer.MIN_VALUE;
            }
            return (int) value;
        }
        if (A01[7].length() != 0) {
            throw new RuntimeException();
        }
        A01[1] = "nVSCb9uBdS4Z5srNqmAxsZ9hxFd1bctQ";
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int A04(int[] array, int target, int start, int end) {
        while (start < end) {
            int i3 = array[start];
            if (i3 == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int A05(int[] array, int target, int start, int end) {
        for (int i3 = end - 1; i3 >= start; i3--) {
            int i4 = array[i3];
            if (i4 == target) {
                return i3;
            }
        }
        return -1;
    }

    public static List<Integer> A09(int... backingArray) {
        if (backingArray.length == 0) {
            return Collections.emptyList();
        }
        return new C2269rf(backingArray);
    }

    public static int[] A0B(Collection<? extends Number> collection) {
        if (collection instanceof C2269rf) {
            return ((C2269rf) collection).A05();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        int len = A01[1].charAt(22);
        if (len == 108) {
            throw new RuntimeException();
        }
        A01[1] = "hGECTcBTlZrQNB5F5BgF8ddu5i2bV8V4";
        for (int i3 = 0; i3 < length; i3++) {
            int len2 = ((Number) AbstractC1878ki.A04(array[i3])).intValue();
            iArr[i3] = len2;
        }
        return iArr;
    }
}
