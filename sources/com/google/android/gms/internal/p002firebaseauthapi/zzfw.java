package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfz;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfw extends zzcw {
    private final zzfz zza;
    private final zzaal zzb;
    private final zzaaj zzc;

    @Nullable
    private final Integer zzd;

    private zzfw(zzfz zzfzVar, zzaal zzaalVar, zzaaj zzaajVar, @Nullable Integer num) {
        this.zza = zzfzVar;
        this.zzb = zzaalVar;
        this.zzc = zzaajVar;
        this.zzd = num;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcw, com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final /* synthetic */ zzcb zza() {
        return (zzfz) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcw
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzcy zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcw
    public final zzaaj zzd() {
        return this.zzc;
    }

    public final zzaal zze() {
        return this.zzb;
    }

    public static zzfw zza(zzfz zzfzVar, zzaal zzaalVar, @Nullable Integer num) throws GeneralSecurityException {
        zzaaj zzaajVarZzb;
        zzfz.zza zzaVarZzc = zzfzVar.zzc();
        zzfz.zza zzaVar = zzfz.zza.zzb;
        if (zzaVarZzc != zzaVar && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzfzVar.zzc()) + " the value of idRequirement must be non-null");
        }
        if (zzfzVar.zzc() == zzaVar && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzaalVar.zza() != 32) {
            throw new GeneralSecurityException("XAesGcmKey key must be constructed with key of length 32 bytes, not " + zzaalVar.zza());
        }
        if (zzfzVar.zzc() == zzaVar) {
            zzaajVarZzb = zzpe.zza;
        } else {
            if (zzfzVar.zzc() != zzfz.zza.zza) {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zzfzVar.zzc()));
            }
            zzaajVarZzb = zzpe.zzb(num.intValue());
        }
        return new zzfw(zzfzVar, zzaalVar, zzaajVarZzb, num);
    }
}
