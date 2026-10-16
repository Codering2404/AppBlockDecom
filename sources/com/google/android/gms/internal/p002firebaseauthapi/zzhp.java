package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhp {
    private static final int[] zza = zza(new byte[]{101, Framer.EXIT_FRAME_PREFIX, 112, 97, 110, 100, 32, 51, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 98, 121, 116, 101, 32, 107});

    private static int zza(int i3, int i4) {
        return (i3 >>> (-i4)) | (i3 << i4);
    }

    static int[] zzb(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        zza(iArr3, iArr);
        iArr3[12] = iArr2[0];
        iArr3[13] = iArr2[1];
        iArr3[14] = iArr2[2];
        iArr3[15] = iArr2[3];
        zza(iArr3);
        iArr3[4] = iArr3[12];
        iArr3[5] = iArr3[13];
        iArr3[6] = iArr3[14];
        iArr3[7] = iArr3[15];
        return Arrays.copyOf(iArr3, 8);
    }

    private static void zza(int[] iArr, int i3, int i4, int i5, int i6) {
        int i7 = iArr[i3] + iArr[i4];
        iArr[i3] = i7;
        int iZza = zza(i7 ^ iArr[i6], 16);
        iArr[i6] = iZza;
        int i8 = iArr[i5] + iZza;
        iArr[i5] = i8;
        int iZza2 = zza(iArr[i4] ^ i8, 12);
        iArr[i4] = iZza2;
        int i9 = iArr[i3] + iZza2;
        iArr[i3] = i9;
        int iZza3 = zza(iArr[i6] ^ i9, 8);
        iArr[i6] = iZza3;
        int i10 = iArr[i5] + iZza3;
        iArr[i5] = i10;
        iArr[i4] = zza(iArr[i4] ^ i10, 7);
    }

    static void zza(int[] iArr, int[] iArr2) {
        int[] iArr3 = zza;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    static void zza(int[] iArr) {
        for (int i3 = 0; i3 < 10; i3++) {
            zza(iArr, 0, 4, 8, 12);
            zza(iArr, 1, 5, 9, 13);
            zza(iArr, 2, 6, 10, 14);
            zza(iArr, 3, 7, 11, 15);
            zza(iArr, 0, 5, 10, 15);
            zza(iArr, 1, 6, 11, 12);
            zza(iArr, 2, 7, 8, 13);
            zza(iArr, 3, 4, 9, 14);
        }
    }

    static byte[] zza(byte[] bArr, byte[] bArr2) {
        int[] iArrZzb = zzb(zza(bArr), zza(bArr2));
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(iArrZzb.length << 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZzb);
        return byteBufferOrder.array();
    }

    static int[] zza(byte[] bArr) {
        if (bArr.length % 4 == 0) {
            IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
            int[] iArr = new int[intBufferAsIntBuffer.remaining()];
            intBufferAsIntBuffer.get(iArr);
            return iArr;
        }
        throw new IllegalArgumentException("invalid input length");
    }
}
