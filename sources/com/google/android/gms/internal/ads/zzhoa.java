package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhoa {

    @Nullable
    private zzhoi zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzhoa() {
    }

    public final zzhoa zza(zzhoi zzhoiVar) {
        this.zza = zzhoiVar;
        return this;
    }

    public final zzhoa zzb(zzibb zzibbVar) throws GeneralSecurityException {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhoa zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhob zzd() throws GeneralSecurityException {
        zzibb zzibbVar;
        zziaz zziazVarZza;
        zzhoi zzhoiVar = this.zza;
        if (zzhoiVar == null || (zzibbVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhoiVar.zzc() != zzibbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhoiVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzhoh.zzd) {
            zziazVarZza = zzhms.zza;
        } else if (this.zza.zzf() == zzhoh.zzc || this.zza.zzf() == zzhoh.zzb) {
            zziazVarZza = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzhoh.zza) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
            }
            zziazVarZza = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhob(this.zza, this.zzb, zziazVarZza, this.zzc, null);
    }

    /* synthetic */ zzhoa(byte[] bArr) {
    }
}
