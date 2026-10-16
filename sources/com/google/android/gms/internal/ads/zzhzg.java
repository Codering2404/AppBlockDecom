package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhzg implements zzhdi {
    private static final ThreadLocal zza = new zzhzf();
    private final byte[] zzb;
    private final zzhqd zzc;
    private final SecretKeySpec zzd;
    private final int zze;

    private zzhzg(byte[] bArr, int i3, byte[] bArr2) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i3 != 12 && i3 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zze = i3;
        int length = bArr.length;
        zziax.zza(length);
        this.zzd = new SecretKeySpec(bArr, "AES");
        this.zzc = zziam.zzb(zzhqb.zzc(zzhqc.zzb(length), zzibb.zza(bArr, zzhdo.zza())));
        this.zzb = bArr2;
    }

    public static zzhdi zzb(zzhfi zzhfiVar) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        zzhfiVar.zzf();
        return new zzhzg(zzhfiVar.zze().zzc(zzhdo.zza()), zzhfiVar.zzf().zzd(), zzhfiVar.zzc().zzc());
    }

    private final byte[] zzc(int i3, byte[] bArr, int i4, int i5) throws GeneralSecurityException {
        byte[] bArr2 = new byte[i5 + 16];
        bArr2[15] = (byte) i3;
        System.arraycopy(bArr, i4, bArr2, 16, i5);
        return this.zzc.zza(bArr2, 16);
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr.length;
        int length2 = bArr3.length;
        int i3 = this.zze;
        int i4 = ((length - length2) - i3) - 16;
        if (i4 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzhnz.zze(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrZzc = zzc(0, bArr, length2, i3);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrZzc2 = zzc(1, bArr2, 0, bArr2.length);
        byte[] bArrZzc3 = zzc(2, bArr, length2 + i3, i4);
        int i5 = length - 16;
        byte b3 = 0;
        for (int i6 = 0; i6 < 16; i6++) {
            b3 = (byte) (b3 | (((bArr[i5 + i6] ^ bArrZzc2[i6]) ^ bArrZzc[i6]) ^ bArrZzc3[i6]));
        }
        if (b3 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, this.zzd, new IvParameterSpec(bArrZzc));
        return cipher.doFinal(bArr, bArr3.length + i3, i4);
    }
}
