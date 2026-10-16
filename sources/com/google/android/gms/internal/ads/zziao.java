package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziao implements zzhqd {
    private final ThreadLocal zza;
    private final String zzb;
    private final Key zzc;
    private final int zzd;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public zziao(String str, Key key) throws GeneralSecurityException {
        int i3;
        zzian zzianVar = new zzian(this);
        this.zza = zzianVar;
        if (!zzhkr.zza(2)) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzb = str;
        this.zzc = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        switch (str.hashCode()) {
            case -1823053428:
                if (str.equals("HMACSHA1")) {
                    i3 = 20;
                    this.zzd = i3;
                    zzianVar.get();
                    return;
                }
                break;
            case 392315023:
                if (str.equals("HMACSHA224")) {
                    i3 = 28;
                    this.zzd = i3;
                    zzianVar.get();
                    return;
                }
                break;
            case 392315118:
                if (str.equals("HMACSHA256")) {
                    i3 = 32;
                    this.zzd = i3;
                    zzianVar.get();
                    return;
                }
                break;
            case 392316170:
                if (str.equals("HMACSHA384")) {
                    i3 = 48;
                    this.zzd = i3;
                    zzianVar.get();
                    return;
                }
                break;
            case 392317873:
                if (str.equals("HMACSHA512")) {
                    i3 = 64;
                    this.zzd = i3;
                    zzianVar.get();
                    return;
                }
                break;
        }
        throw new NoSuchAlgorithmException("unknown Hmac algorithm: ".concat(str));
    }

    @Override // com.google.android.gms.internal.ads.zzhqd
    public final byte[] zza(byte[] bArr, int i3) throws GeneralSecurityException {
        if (i3 > this.zzd) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ThreadLocal threadLocal = this.zza;
        ((Mac) threadLocal.get()).update(bArr);
        return Arrays.copyOf(((Mac) threadLocal.get()).doFinal(), i3);
    }

    final /* synthetic */ String zzb() {
        return this.zzb;
    }

    final /* synthetic */ Key zzc() {
        return this.zzc;
    }
}
