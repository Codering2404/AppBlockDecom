package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlz implements zzmc {
    private final String zza;

    zzlz(String str) {
        this.zza = str;
    }

    final int zza() throws GeneralSecurityException {
        return Mac.getInstance(this.zza).getMacLength();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmc
    public final byte[] zzb() throws GeneralSecurityException {
        String str = this.zza;
        str.getClass();
        switch (str) {
            case "HmacSha256":
                return zzmk.zzf;
            case "HmacSha384":
                return zzmk.zzg;
            case "HmacSha512":
                return zzmk.zzh;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2, int i3) throws GeneralSecurityException {
        Mac macZza = zzzj.zzb.zza(this.zza);
        if (i3 > macZza.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i3];
        macZza.init(new SecretKeySpec(bArr, this.zza));
        byte[] bArrDoFinal = new byte[0];
        int i4 = 1;
        int length = 0;
        while (true) {
            macZza.update(bArrDoFinal);
            macZza.update(bArr2);
            macZza.update((byte) i4);
            bArrDoFinal = macZza.doFinal();
            if (bArrDoFinal.length + length >= i3) {
                System.arraycopy(bArrDoFinal, 0, bArr3, length, i3 - length);
                return bArr3;
            }
            System.arraycopy(bArrDoFinal, 0, bArr3, length, bArrDoFinal.length);
            length += bArrDoFinal.length;
            i4++;
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Mac macZza = zzzj.zzb.zza(this.zza);
        if (bArr2 != null && bArr2.length != 0) {
            macZza.init(new SecretKeySpec(bArr2, this.zza));
        } else {
            macZza.init(new SecretKeySpec(new byte[macZza.getMacLength()], this.zza));
        }
        return macZza.doFinal(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i3) throws GeneralSecurityException {
        return zza(zza(zzmk.zza(str, bArr2, bArr4), null), zzmk.zza(str2, bArr3, bArr4, i3), i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmc
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i3) throws GeneralSecurityException {
        return zza(bArr, zzmk.zza(str, bArr2, bArr3, i3), i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmc
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException {
        return zza(zzmk.zza(str, bArr2, bArr3), bArr);
    }
}
