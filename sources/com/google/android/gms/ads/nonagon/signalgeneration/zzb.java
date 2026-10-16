package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcns;
import com.google.android.gms.internal.ads.zzcoi;
import com.google.android.gms.internal.ads.zzcrb;
import com.google.android.gms.internal.ads.zzexr;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb implements zzimu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzind f70701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzind f70702b;

    private zzb(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.f70701a = zzindVar;
        this.f70702b = zzindVar4;
    }

    public static zzb a(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzb(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zza(((zzcns) this.f70701a).zza(), zzcrb.zza(), zzexr.zzc(), ((zzcoi) this.f70702b).zza());
    }
}
