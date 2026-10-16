package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyx implements zzbe {
    private static final zziv.zza zza = zziv.zza.zza;
    private static final Collection<Integer> zzb = Arrays.asList(64);
    private static final byte[] zzc = new byte[16];
    private static final ThreadLocal<Cipher> zzd = new zzza();
    private final zzsq zze;
    private final byte[] zzf;
    private final byte[] zzg;

    private zzyx(byte[] bArr, zzaaj zzaajVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (zzb.contains(Integer.valueOf(bArr.length))) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.zzf = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.zze = zzzz.zza(zzso.zza(zzsr.zza(bArrCopyOfRange.length), zzaal.zza(bArrCopyOfRange, zzbf.zza())));
            this.zzg = zzaajVar.zzb();
            return;
        }
        throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
    }

    public static zzbe zza(zzja zzjaVar) throws GeneralSecurityException {
        return new zzyx(zzjaVar.zzf().zza(zzbf.zza()), zzjaVar.zze());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrZza;
        int length = bArr.length;
        byte[] bArr3 = this.zzg;
        if (length >= bArr3.length + 16) {
            if (zzqn.zza(bArr3, bArr)) {
                Cipher cipher = zzd.get();
                byte[] bArr4 = this.zzg;
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, bArr4.length, bArr4.length + 16);
                byte[] bArr5 = (byte[]) bArrCopyOfRange.clone();
                bArr5[8] = (byte) (bArr5[8] & Ascii.DEL);
                bArr5[12] = (byte) (bArr5[12] & Ascii.DEL);
                cipher.init(2, new SecretKeySpec(this.zzf, "AES"), new IvParameterSpec(bArr5));
                int length2 = this.zzg.length + 16;
                int length3 = bArr.length - length2;
                byte[] bArrDoFinal = cipher.doFinal(bArr, length2, length3);
                if (length3 == 0 && bArrDoFinal == null && zzaaf.zza()) {
                    bArrDoFinal = new byte[0];
                }
                byte[][] bArr6 = {bArr2, bArrDoFinal};
                byte[] bArrZza2 = this.zze.zza(zzc, 16);
                for (int i3 = 0; i3 <= 0; i3++) {
                    byte[] bArr7 = bArr6[i3];
                    if (bArr7 == null) {
                        bArr7 = new byte[0];
                    }
                    bArrZza2 = zzyz.zza(zzsf.zzb(bArrZza2), this.zze.zza(bArr7, 16));
                }
                byte[] bArr8 = bArr6[1];
                if (bArr8.length >= 16) {
                    if (bArr8.length >= bArrZza2.length) {
                        int length4 = bArr8.length - bArrZza2.length;
                        bArrZza = Arrays.copyOf(bArr8, bArr8.length);
                        for (int i4 = 0; i4 < bArrZza2.length; i4++) {
                            int i5 = length4 + i4;
                            bArrZza[i5] = (byte) (bArrZza[i5] ^ bArrZza2[i4]);
                        }
                    } else {
                        throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                    }
                } else {
                    bArrZza = zzyz.zza(zzsf.zza(bArr8), zzsf.zzb(bArrZza2));
                }
                if (MessageDigest.isEqual(bArrCopyOfRange, this.zze.zza(bArrZza, 16))) {
                    return bArrDoFinal;
                }
                throw new AEADBadTagException("Integrity check failed.");
            }
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
