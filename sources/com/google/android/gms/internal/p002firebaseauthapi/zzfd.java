package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfc;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfd extends zzcw {
    private final zzfc zza;
    private final zzaaj zzb;

    @Nullable
    private final Integer zzc;

    private zzfd(zzfc zzfcVar, zzaaj zzaajVar, @Nullable Integer num) {
        this.zza = zzfcVar;
        this.zzb = zzaajVar;
        this.zzc = num;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcw, com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final /* synthetic */ zzcb zza() {
        return (zzfc) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final Integer zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcw
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzcy zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcw
    public final zzaaj zzd() {
        return this.zzb;
    }

    public static zzfd zza(zzfc zzfcVar, @Nullable Integer num) throws GeneralSecurityException {
        zzaaj zzaajVarZzb;
        if (zzfcVar.zzc() == zzfc.zzc.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzaajVarZzb = zzpe.zza;
        } else {
            if (zzfcVar.zzc() != zzfc.zzc.zza) {
                throw new GeneralSecurityException("Unknown Variant: " + String.valueOf(zzfcVar.zzc()));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzaajVarZzb = zzpe.zzb(num.intValue());
        }
        return new zzfd(zzfcVar, zzaajVarZzb, num);
    }
}
