package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzabk implements zzafv<zzaip> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzafs zzb;
    private final /* synthetic */ zzaar zzc;

    zzabk(zzaar zzaarVar, zzael zzaelVar, zzafs zzafsVar) {
        this.zza = zzaelVar;
        this.zzb = zzafsVar;
        Objects.requireNonNull(zzaarVar);
        this.zzc = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zzb.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzaip zzaipVar) {
        zzaip zzaipVar2 = zzaipVar;
        this.zzc.zza(new zzahv(zzaipVar2.zzc(), zzaipVar2.zzb(), Long.valueOf(zzaipVar2.zza()), "Bearer"), null, "password", Boolean.FALSE, null, this.zza, this);
    }
}
