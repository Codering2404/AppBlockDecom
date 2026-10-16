package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhzl {
    public static byte[] zza(byte[]... bArr) throws GeneralSecurityException {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= bArr.length) {
                byte[] bArr2 = new byte[i4];
                int i5 = 0;
                for (byte[] bArr3 : bArr) {
                    int length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i5, length);
                    i5 += length;
                }
                return bArr2;
            }
            int length2 = bArr[i3].length;
            if (i4 > Api.BaseClientBuilder.API_PRIORITY_OTHER - length2) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i4 += length2;
            i3++;
        }
    }

    public static final byte[] zzb(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        if (bArr.length - 16 < i3) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[16];
        for (int i6 = 0; i6 < 16; i6++) {
            bArr3[i6] = (byte) (bArr[i6 + i3] ^ bArr2[i6]);
        }
        return bArr3;
    }

    public static final void zzc(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i3) {
        if (i3 < 0 || byteBuffer2.remaining() < i3 || byteBuffer3.remaining() < i3 || byteBuffer.remaining() < i3) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }
}
