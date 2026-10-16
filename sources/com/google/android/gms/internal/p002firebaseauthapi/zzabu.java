package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzabu implements zzafv<zzajd> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzaar zzb;

    zzabu(zzaar zzaarVar, zzael zzaelVar) {
        this.zza = zzaelVar;
        Objects.requireNonNull(zzaarVar);
        this.zzb = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zza.zza(zzao.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzajd zzajdVar) {
        zzajd zzajdVar2 = zzajdVar;
        if (!zzajdVar2.zzl()) {
            zzaar.zza(this.zzb, zzajdVar2, this.zza, this);
        } else {
            this.zza.zza(new zzaas(zzajdVar2.zzf(), zzajdVar2.zzk(), zzajdVar2.zzb()));
        }
    }
}
