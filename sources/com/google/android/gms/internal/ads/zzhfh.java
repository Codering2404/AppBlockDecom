package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfh {

    @Nullable
    private zzhfo zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzhfh() {
    }

    public final zzhfh zza(zzhfo zzhfoVar) {
        this.zza = zzhfoVar;
        return this;
    }

    public final zzhfh zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhfh zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhfi zzd() throws GeneralSecurityException {
        zzibb zzibbVar;
        zziaz zziazVarZzb;
        zzhfo zzhfoVar = this.zza;
        if (zzhfoVar == null || (zzibbVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhfoVar.zzc() != zzibbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhfoVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zze() == zzhfn.zzc) {
            zziazVarZzb = zzhms.zza;
        } else if (this.zza.zze() == zzhfn.zzb) {
            zziazVarZzb = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzhfn.zza) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
            }
            zziazVarZzb = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhfi(this.zza, this.zzb, zziazVarZzb, this.zzc, null);
    }

    /* synthetic */ zzhfh(byte[] bArr) {
    }
}
