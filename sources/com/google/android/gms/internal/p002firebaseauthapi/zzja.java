package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjf;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzja extends zzjk {
    private final zzjf zza;
    private final zzaal zzb;
    private final zzaaj zzc;

    @Nullable
    private final Integer zzd;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class zza {

        @Nullable
        private zzjf zza;

        @Nullable
        private zzaal zzb;

        @Nullable
        private Integer zzc;

        public final zza zza(@Nullable Integer num) {
            this.zzc = num;
            return this;
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzaal zzaalVar) {
            this.zzb = zzaalVar;
            return this;
        }

        public final zza zza(zzjf zzjfVar) {
            this.zza = zzjfVar;
            return this;
        }

        public final zzja zza() throws GeneralSecurityException {
            zzaaj zzaajVarZzb;
            zzjf zzjfVar = this.zza;
            if (zzjfVar != null && this.zzb != null) {
                if (zzjfVar.zzb() == this.zzb.zza()) {
                    if (this.zza.zza() && this.zzc == null) {
                        throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                    }
                    if (!this.zza.zza() && this.zzc != null) {
                        throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                    }
                    if (this.zza.zzd() == zzjf.zza.zzc) {
                        zzaajVarZzb = zzpe.zza;
                    } else if (this.zza.zzd() == zzjf.zza.zzb) {
                        zzaajVarZzb = zzpe.zza(this.zzc.intValue());
                    } else if (this.zza.zzd() == zzjf.zza.zza) {
                        zzaajVarZzb = zzpe.zzb(this.zzc.intValue());
                    } else {
                        throw new IllegalStateException("Unknown AesSivParameters.Variant: " + String.valueOf(this.zza.zzd()));
                    }
                    return new zzja(this.zza, this.zzb, zzaajVarZzb, this.zzc);
                }
                throw new GeneralSecurityException("Key size mismatch");
            }
            throw new IllegalArgumentException("Cannot build without parameters and/or key material");
        }
    }

    public static zza zzc() {
        return new zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjk, com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final /* synthetic */ zzcb zza() {
        return (zzjf) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjk
    /* JADX INFO: renamed from: zzd */
    public final /* synthetic */ zzjj zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjk
    public final zzaaj zze() {
        return this.zzc;
    }

    public final zzaal zzf() {
        return this.zzb;
    }

    private zzja(zzjf zzjfVar, zzaal zzaalVar, zzaaj zzaajVar, @Nullable Integer num) {
        this.zza = zzjfVar;
        this.zzb = zzaalVar;
        this.zzc = zzaajVar;
        this.zzd = num;
    }
}
