package com.google.android.gms.internal.ads;

import androidx.appcompat.app.jE.vxrlPPpdv;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhol {

    @Nullable
    private zzhov zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzhol() {
    }

    public final zzhol zza(zzhov zzhovVar) {
        this.zza = zzhovVar;
        return this;
    }

    public final zzhol zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhol zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    /* synthetic */ zzhol(byte[] bArr) {
    }

    public final zzhom zzd() throws GeneralSecurityException {
        zzibb zzibbVar;
        zziaz zziazVarZza;
        zzhov zzhovVar = this.zza;
        if (zzhovVar == null || (zzibbVar = this.zzb) == null) {
            throw new GeneralSecurityException(vxrlPPpdv.dTcxOfkcUzf);
        }
        if (zzhovVar.zzc() != zzibbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhovVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzhou.zzd) {
            zziazVarZza = zzhms.zza;
        } else if (this.zza.zzf() == zzhou.zzc || this.zza.zzf() == zzhou.zzb) {
            zziazVarZza = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzhou.zza) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
            }
            zziazVarZza = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhom(this.zza, this.zzb, zziazVarZza, this.zzc, null);
    }
}
