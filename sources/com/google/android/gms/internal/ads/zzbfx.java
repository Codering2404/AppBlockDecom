package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbfx extends zzbfs {
    private MessageDigest zzb;

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final byte[] zza(String str) {
        byte[] bArr;
        byte[] bArrArray;
        String[] strArrSplit = str.split(" ");
        int length = strArrSplit.length;
        int i3 = 4;
        if (length == 1) {
            int iZza = zzbfw.zza(strArrSplit[0]);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.putInt(iZza);
            bArrArray = byteBufferAllocate.array();
        } else {
            if (length < 5) {
                bArr = new byte[length + length];
                for (int i4 = 0; i4 < strArrSplit.length; i4++) {
                    int iZza2 = zzbfw.zza(strArrSplit[i4]);
                    int i5 = (iZza2 >> 16) ^ ((char) iZza2);
                    byte b3 = (byte) i5;
                    byte b4 = (byte) (i5 >> 8);
                    int i6 = i4 + i4;
                    bArr[i6] = new byte[]{b3, b4}[0];
                    bArr[i6 + 1] = b4;
                }
            } else {
                bArr = new byte[length];
                for (int i7 = 0; i7 < strArrSplit.length; i7++) {
                    int iZza3 = zzbfw.zza(strArrSplit[i7]);
                    bArr[i7] = (byte) ((iZza3 >> 24) ^ (((iZza3 & 255) ^ ((iZza3 >> 8) & 255)) ^ ((iZza3 >> 16) & 255)));
                }
            }
            bArrArray = bArr;
        }
        this.zzb = zzb();
        synchronized (this.zza) {
            try {
                MessageDigest messageDigest = this.zzb;
                if (messageDigest == null) {
                    return new byte[0];
                }
                messageDigest.reset();
                this.zzb.update(bArrArray);
                byte[] bArrDigest = this.zzb.digest();
                int length2 = bArrDigest.length;
                if (length2 <= 4) {
                    i3 = length2;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArrDigest, 0, bArr2, 0, i3);
                return bArr2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
