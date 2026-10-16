package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhzu implements zzhdi {
    private final zziak zza;
    private final zzheg zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzhzu(zziak zziakVar, zzheg zzhegVar, int i3, byte[] bArr) {
        this.zza = zziakVar;
        this.zzb = zzhegVar;
        this.zzc = i3;
        this.zzd = bArr;
    }

    public static zzhdi zzb(zzhey zzheyVar) throws GeneralSecurityException {
        zzhze zzhzeVar = new zzhze(zzheyVar.zze().zzc(zzhdo.zza()), zzheyVar.zzg().zzf());
        String strValueOf = String.valueOf(zzheyVar.zzg().zzh());
        return new zzhzu(zzhzeVar, new zziap(new zziao("HMAC".concat(strValueOf), new SecretKeySpec(zzheyVar.zzf().zzc(zzhdo.zza()), "HMAC")), zzheyVar.zzg().zze()), zzheyVar.zzg().zze(), zzheyVar.zzc().zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int length = bArr.length;
        int i3 = this.zzc;
        int length2 = bArr3.length;
        if (length < i3 + length2) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!zzhnz.zze(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        int i4 = length - i3;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length2, i4);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i4, length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrCopyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        if (MessageDigest.isEqual(((zziap) this.zzb).zzc(zzhzl.zza(bArr2, bArrCopyOfRange, bArrCopyOf)), bArrCopyOfRange2)) {
            return this.zza.zza(bArrCopyOfRange);
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
