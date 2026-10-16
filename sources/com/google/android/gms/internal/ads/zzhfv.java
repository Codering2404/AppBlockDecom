package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfv {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;

    @Nullable
    private Integer zzc = null;
    private zzhfw zzd = zzhfw.zzc;

    private zzhfv() {
    }

    public final zzhfv zza(int i3) throws GeneralSecurityException {
        if (i3 != 16 && i3 != 24 && i3 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i3)));
        }
        this.zza = Integer.valueOf(i3);
        return this;
    }

    public final zzhfv zzb(int i3) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzhfv zzc(int i3) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzhfv zzd(zzhfw zzhfwVar) {
        this.zzd = zzhfwVar;
        return this;
    }

    public final zzhfx zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        this.zzb.getClass();
        this.zzc.getClass();
        return new zzhfx(iIntValue, 12, 16, this.zzd, null);
    }

    /* synthetic */ zzhfv(byte[] bArr) {
    }
}
