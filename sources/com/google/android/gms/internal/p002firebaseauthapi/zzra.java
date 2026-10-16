package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzrh;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzra extends zzrk {
    private final zzrh zza;
    private final zzaal zzb;
    private final zzaaj zzc;

    @Nullable
    private final Integer zzd;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class zza {

        @Nullable
        private zzrh zza;

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

        public final zza zza(zzrh zzrhVar) {
            this.zza = zzrhVar;
            return this;
        }

        public final zzra zza() throws GeneralSecurityException {
            zzaaj zzaajVarZza;
            zzrh zzrhVar = this.zza;
            if (zzrhVar != null && this.zzb != null) {
                if (zzrhVar.zzc() == this.zzb.zza()) {
                    if (this.zza.zza() && this.zzc == null) {
                        throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                    }
                    if (!this.zza.zza() && this.zzc != null) {
                        throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                    }
                    if (this.zza.zzf() == zzrh.zzc.zzd) {
                        zzaajVarZza = zzpe.zza;
                    } else if (this.zza.zzf() != zzrh.zzc.zzc && this.zza.zzf() != zzrh.zzc.zzb) {
                        if (this.zza.zzf() == zzrh.zzc.zza) {
                            zzaajVarZza = zzpe.zzb(this.zzc.intValue());
                        } else {
                            throw new IllegalStateException("Unknown HmacParameters.Variant: " + String.valueOf(this.zza.zzf()));
                        }
                    } else {
                        zzaajVarZza = zzpe.zza(this.zzc.intValue());
                    }
                    return new zzra(this.zza, this.zzb, zzaajVarZza, this.zzc);
                }
                throw new GeneralSecurityException("Key size mismatch");
            }
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
    }

    public static zza zzc() {
        return new zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzrk, com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final /* synthetic */ zzcb zza() {
        return (zzrh) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzrk
    /* JADX INFO: renamed from: zzd */
    public final /* synthetic */ zzrn zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzrk
    public final zzaaj zze() {
        return this.zzc;
    }

    public final zzaal zzf() {
        return this.zzb;
    }

    private zzra(zzrh zzrhVar, zzaal zzaalVar, zzaaj zzaajVar, @Nullable Integer num) {
        this.zza = zzrhVar;
        this.zzb = zzaalVar;
        this.zzc = zzaajVar;
        this.zzd = num;
    }
}
