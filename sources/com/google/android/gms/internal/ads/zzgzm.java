package com.google.android.gms.internal.ads;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgzm {
    public static final /* synthetic */ int zza = 0;

    static {
        new zzgzk();
    }

    public static byte[] zza(InputStream inputStream) throws IOException {
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iHighestOneBit = Integer.highestOneBit(0);
        int iMin = Math.min(Utility.DEFAULT_STREAM_BUFFER_SIZE, Math.max(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, iHighestOneBit + iHighestOneBit));
        int i3 = 0;
        while (i3 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i3);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i4 = 0;
            while (i4 < iMin2) {
                int i5 = inputStream.read(bArr, i4, iMin2 - i4);
                if (i5 == -1) {
                    return zzc(arrayDeque, i3);
                }
                i4 += i5;
                i3 += i5;
            }
            iMin = zzhah.zzb(((long) iMin) * ((long) (iMin < 4096 ? 4 : 2)));
        }
        if (inputStream.read() == -1) {
            return zzc(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static InputStream zzb(InputStream inputStream, long j3) {
        return new zzgzl(inputStream, j3);
    }

    private static byte[] zzc(Queue queue, int i3) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        int length = bArr.length;
        if (length == i3) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
        int i4 = i3 - length;
        while (i4 > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(i4, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i3 - i4, iMin);
            i4 -= iMin;
        }
        return bArrCopyOf;
    }
}
