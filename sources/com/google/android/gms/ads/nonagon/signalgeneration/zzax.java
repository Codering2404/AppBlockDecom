package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdkq;
import com.google.android.gms.internal.ads.zzfoa;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzax implements zzimu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzind f70695a;

    private zzax(zzind zzindVar, zzind zzindVar2) {
        this.f70695a = zzindVar;
    }

    public static zzax a(zzind zzindVar, zzind zzindVar2) {
        return new zzax(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzr) this.f70695a.zzb(), zzfoa.zzc());
    }
}
