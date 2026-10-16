package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzabv implements zzafv<zzagy> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzabw zzb;

    zzabv(zzabw zzabwVar, zzael zzaelVar) {
        this.zza = zzaelVar;
        Objects.requireNonNull(zzabwVar);
        this.zzb = zzabwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zza.zza(zzao.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzagy zzagyVar) {
        zzagy zzagyVar2 = zzagyVar;
        this.zzb.zza.zza(new zzahv(zzagyVar2.zzb(), zzagyVar2.zza(), Long.valueOf(zzahx.zza(zzagyVar2.zza())), "Bearer"), null, null, Boolean.FALSE, null, this.zza, this);
    }
}
