package com.google.android.gms.ads.nonagon.devicetier;

import com.google.android.gms.internal.ads.zzcns;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zza implements zzimu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzind f70606a;

    private zza(zzind zzindVar) {
        this.f70606a = zzindVar;
    }

    public static zza a(zzind zzindVar) {
        return new zza(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new DeviceTierManager(((zzcns) this.f70606a).zza());
    }
}
