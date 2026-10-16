package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdzg;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs implements zzimu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzind f70783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzind f70784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzind f70785c;

    private zzs(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.f70783a = zzindVar;
        this.f70784b = zzindVar2;
        this.f70785c = zzindVar3;
    }

    public static zzs a(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzs(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzr((zzdzg) this.f70783a.zzb(), (zzq) this.f70784b.zzb(), (String) this.f70785c.zzb());
    }
}
