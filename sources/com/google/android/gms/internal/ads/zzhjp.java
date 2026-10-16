package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzhjp {
    int[] zza;
    private final int zzb;

    public zzhjp(byte[] bArr, int i3) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzhjn.zzd(bArr);
        this.zzb = i3;
    }

    abstract int[] zza(int[] iArr, int i3);

    abstract int zzb();

    public final byte[] zzc(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length != zzb()) {
            int iZzb = zzb();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzb).length() + 36);
            sb.append("The nonce length (in bytes) must be ");
            sb.append(iZzb);
            throw new GeneralSecurityException(sb.toString());
        }
        int iRemaining = byteBuffer.remaining();
        int i3 = iRemaining / 64;
        for (int i4 = 0; i4 < i3 + 1; i4++) {
            ByteBuffer byteBufferZzd = zzd(bArr, this.zzb + i4);
            if (i4 == i3) {
                zzhzl.zzc(byteBufferAllocate, byteBuffer, byteBufferZzd, iRemaining % 64);
            } else {
                zzhzl.zzc(byteBufferAllocate, byteBuffer, byteBufferZzd, 64);
            }
        }
        return byteBufferAllocate.array();
    }

    final ByteBuffer zzd(byte[] bArr, int i3) {
        int[] iArrZza = zza(zzhjn.zzd(bArr), i3);
        int[] iArr = (int[]) iArrZza.clone();
        zzhjn.zzb(iArr);
        for (int i4 = 0; i4 < 16; i4++) {
            iArrZza[i4] = iArrZza[i4] + iArr[i4];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZza, 0, 16);
        return byteBufferOrder;
    }
}
