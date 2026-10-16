package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyz {
    public static final void zza(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i3) {
        if (i3 < 0 || byteBuffer2.remaining() < i3 || byteBuffer3.remaining() < i3 || byteBuffer.remaining() < i3) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static byte[] zza(byte[]... bArr) throws GeneralSecurityException {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            if (length <= Api.BaseClientBuilder.API_PRIORITY_OTHER - bArr2.length) {
                length += bArr2.length;
            } else {
                throw new GeneralSecurityException("exceeded size limit");
            }
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    public static final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return zza(bArr, 0, bArr2, 0, bArr.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final byte[] zza(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        if (i5 >= 0 && bArr.length - i5 >= i3 && bArr2.length - i5 >= 0) {
            byte[] bArr3 = new byte[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                bArr3[i6] = (byte) (bArr[i6 + i3] ^ bArr2[i6]);
            }
            return bArr3;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }
}
