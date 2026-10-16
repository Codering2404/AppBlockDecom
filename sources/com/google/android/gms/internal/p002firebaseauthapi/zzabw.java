package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzabw implements zzafv<zzahv> {
    final /* synthetic */ zzaar zza;
    private final /* synthetic */ zzagz zzb;
    private final /* synthetic */ zzael zzc;

    zzabw(zzaar zzaarVar, zzagz zzagzVar, zzael zzaelVar) {
        this.zzb = zzagzVar;
        this.zzc = zzaelVar;
        Objects.requireNonNull(zzaarVar);
        this.zza = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zzc.zza(zzao.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahv zzahvVar) {
        this.zzb.zza(zzahvVar.zzc());
        this.zza.zza.zza(this.zzb, new zzabv(this, this.zzc));
    }
}
