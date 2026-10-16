package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhge {

    @Nullable
    private Integer zza = null;
    private zzhgf zzb = zzhgf.zzc;

    private zzhge() {
    }

    public final zzhge zza(int i3) throws GeneralSecurityException {
        if (i3 != 16 && i3 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i3)));
        }
        this.zza = Integer.valueOf(i3);
        return this;
    }

    public final zzhge zzb(zzhgf zzhgfVar) {
        this.zzb = zzhgfVar;
        return this;
    }

    public final zzhgg zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb != null) {
            return new zzhgg(num.intValue(), this.zzb, null);
        }
        throw new GeneralSecurityException("Variant is not set");
    }

    /* synthetic */ zzhge(byte[] bArr) {
    }
}
