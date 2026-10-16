package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzefg;
import com.google.android.gms.internal.ads.zzfoa;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbb implements zzimu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzind f70705a;

    private zzbb(zzind zzindVar, zzind zzindVar2) {
        this.f70705a = zzindVar2;
    }

    public static zzbb b(zzind zzindVar, zzind zzindVar2) {
        return new zzbb(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzba zzb() {
        return new zzba(zzfoa.zzc(), ((zzefg) this.f70705a).zzb());
    }
}
