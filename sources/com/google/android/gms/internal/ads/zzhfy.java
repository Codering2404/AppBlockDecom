package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfy {

    @Nullable
    private zzhgg zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzhfy() {
    }

    public final zzhfy zza(zzhgg zzhggVar) {
        this.zza = zzhggVar;
        return this;
    }

    public final zzhfy zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhfy zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhfz zzd() throws GeneralSecurityException {
        zzibb zzibbVar;
        zziaz zziazVarZzb;
        zzhgg zzhggVar = this.zza;
        if (zzhggVar == null || (zzibbVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhggVar.zzc() != zzibbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhggVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzhgf.zzc) {
            zziazVarZzb = zzhms.zza;
        } else if (this.zza.zzd() == zzhgf.zzb) {
            zziazVarZzb = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzhgf.zza) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            zziazVarZzb = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhfz(this.zza, this.zzb, zziazVarZzb, this.zzc, null);
    }

    /* synthetic */ zzhfy(byte[] bArr) {
    }
}
