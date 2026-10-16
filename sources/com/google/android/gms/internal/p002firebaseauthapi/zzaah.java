package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.exoplayer2.common.base.Ascii;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaah {
    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 32);
        bArrCopyOf[0] = (byte) (bArrCopyOf[0] & 248);
        byte b3 = (byte) (bArrCopyOf[31] & Ascii.DEL);
        bArrCopyOf[31] = b3;
        bArrCopyOf[31] = (byte) (b3 | 64);
        zzng.zza(jArr, bArrCopyOf, bArr2);
        return zznm.zzc(jArr);
    }

    public static byte[] zza() {
        byte[] bArrZza = zzqd.zza(32);
        bArrZza[0] = (byte) (bArrZza[0] | 7);
        byte b3 = (byte) (bArrZza[31] & 63);
        bArrZza[31] = b3;
        bArrZza[31] = (byte) (b3 | 128);
        return bArrZza;
    }

    public static byte[] zza(byte[] bArr) throws InvalidKeyException {
        if (bArr.length == 32) {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            return zza(bArr, bArr2);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
