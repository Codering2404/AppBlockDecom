package com.facebook.ads.redexgen.core;

import com.google.android.gms.common.api.Api;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@DoNotMock
public abstract class AbstractC2090oN<E> {
    public static byte[] A00;

    static {
        A05();
    }

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{71, 69, 74, 74, 75, 80, 4, 87, 80, 75, 86, 65, 4, 73, 75, 86, 65, 4, 80, 76, 69, 74, 4, 109, 74, 80, 65, 67, 65, 86, 10, 105, 101, 124, 123, 114, 101, 104, 113, 97, 4, 65, 72, 65, 73, 65, 74, 80, 87};
    }

    public static int A03(int oldCapacity, int minCapacity) {
        if (minCapacity >= 0) {
            if (minCapacity <= oldCapacity) {
                return oldCapacity;
            }
            int newCapacity = (oldCapacity >> 1) + oldCapacity + 1;
            if (newCapacity < minCapacity) {
                newCapacity = Integer.highestOneBit(minCapacity - 1) << 1;
            }
            if (newCapacity < 0) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            return newCapacity;
        }
        throw new IllegalArgumentException(A04(0, 49, 3));
    }
}
