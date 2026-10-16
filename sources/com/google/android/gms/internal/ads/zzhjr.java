package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzhjr {
    private final zzhjp zza;
    private final zzhjp zzb;

    public zzhjr(byte[] bArr) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.zza = zza(bArr, 1);
        this.zzb = zza(bArr, 0);
    }

    abstract zzhjp zza(byte[] bArr, int i3) throws InvalidKeyException;

    public final byte[] zzb(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int iPosition = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            byte[] bArr4 = new byte[32];
            this.zzb.zzd(bArr, 0).get(bArr4);
            int length = bArr2.length;
            int i3 = length & 15;
            int i4 = i3 == 0 ? length : (length + 16) - i3;
            int iRemaining = byteBuffer.remaining();
            int i5 = iRemaining % 16;
            int i6 = (i5 == 0 ? iRemaining : (iRemaining + 16) - i5) + i4;
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(i6 + 16).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put(bArr2);
            byteBufferOrder.position(i4);
            byteBufferOrder.put(byteBuffer);
            byteBufferOrder.position(i6);
            byteBufferOrder.putLong(length);
            byteBufferOrder.putLong(iRemaining);
            if (!MessageDigest.isEqual(zzhjv.zza(bArr4, byteBufferOrder.array()), bArr3)) {
                throw new GeneralSecurityException("invalid MAC");
            }
            byteBuffer.position(iPosition);
            return this.zza.zzc(bArr, byteBuffer);
        } catch (GeneralSecurityException e3) {
            throw new AEADBadTagException(e3.toString());
        }
    }
}
