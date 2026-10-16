package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzabs implements zzafv<zzahv> {
    final /* synthetic */ zzaar zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzael zzd;

    zzabs(zzaar zzaarVar, String str, String str2, zzael zzaelVar) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzaelVar;
        Objects.requireNonNull(zzaarVar);
        this.zza = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zzd.zza(zzao.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahv zzahvVar) {
        this.zza.zza.zza(new zzaji(zzahvVar.zzc(), this.zzb, this.zzc), new zzabr(this, this.zzd));
    }
}
