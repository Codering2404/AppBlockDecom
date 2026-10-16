package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcns;
import com.google.android.gms.internal.ads.zzdzq;
import com.google.android.gms.internal.ads.zzfoa;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzm implements zzimu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzind f70761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzind f70762b;

    private zzm(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.f70761a = zzindVar;
        this.f70762b = zzindVar2;
    }

    public static zzm a(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzm(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzj(((zzcns) this.f70761a).zza(), (zzdzq) this.f70762b.zzb(), zzfoa.zzc());
    }
}
