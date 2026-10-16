package com.google.android.gms.internal.ads;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhgq implements zzhdi {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = new byte[0];
    private static final Set zze;
    private final String zzc;
    private final zzhdi zzd;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zze = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    zzhgq(zzhst zzhstVar, zzhdi zzhdiVar) throws GeneralSecurityException {
        if (zze.contains(zzhstVar.zza())) {
            this.zzc = zzhstVar.zza();
            zzhss zzhssVarZzg = zzhst.zzg(zzhstVar);
            zzhssVarZzg.zzc(zzhtm.RAW);
            zzhen.zzb(((zzhst) zzhssVarZzg.zzbu()).zzaN());
            this.zzd = zzhdiVar;
            return;
        }
        String strZza = zzhstVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 67);
        sb.append("Unsupported DEK key type: ");
        sb.append(strZza);
        sb.append(". Only Tink AEAD key types are supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i3 = byteBufferWrap.getInt();
            if (i3 <= 0 || i3 > 4096 || i3 > bArr.length - 4) {
                throw new GeneralSecurityException("length of encrypted DEK too large");
            }
            byte[] bArr3 = new byte[i3];
            byteBufferWrap.get(bArr3, 0, i3);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            byte[] bArrZza = this.zzd.zza(bArr3, zzb);
            String str = this.zzc;
            zzida zzidaVar = zzida.zza;
            return ((zzhdi) zzhmo.zza().zzd(zzhmr.zza().zzg(zzhnm.zza(str, zzida.zzt(bArrZza, 0, bArrZza.length), zzhsp.SYMMETRIC, zzhtm.RAW, null), zzhdo.zza()), zzhdi.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e4) {
            e = e4;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e5) {
            e = e5;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
