package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfm {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;

    @Nullable
    private Integer zzc = null;
    private zzhfn zzd = zzhfn.zzc;

    private zzhfm() {
    }

    public final zzhfm zza(int i3) throws GeneralSecurityException {
        if (i3 != 16 && i3 != 24 && i3 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i3)));
        }
        this.zza = Integer.valueOf(i3);
        return this;
    }

    public final zzhfm zzb(int i3) throws GeneralSecurityException {
        if (i3 != 12 && i3 != 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i3)));
        }
        this.zzb = Integer.valueOf(i3);
        return this;
    }

    public final zzhfm zzc(int i3) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzhfm zzd(zzhfn zzhfnVar) {
        this.zzd = zzhfnVar;
        return this;
    }

    public final zzhfo zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        int iIntValue2 = this.zzb.intValue();
        this.zzc.getClass();
        return new zzhfo(iIntValue, iIntValue2, 16, this.zzd, null);
    }

    /* synthetic */ zzhfm(byte[] bArr) {
    }
}
