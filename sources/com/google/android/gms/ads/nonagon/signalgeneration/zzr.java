package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdlk;
import com.google.android.gms.internal.ads.zzdzg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzr implements zzdlk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzdzg f70780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzq f70781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f70782c;

    public zzr(zzdzg zzdzgVar, zzq zzqVar, String str) {
        this.f70780a = zzdzgVar;
        this.f70781b = zzqVar;
        this.f70782c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zzd(zzbc zzbcVar) {
        if (zzbcVar == null) {
            return;
        }
        this.f70781b.a(this.f70782c, zzbcVar.f70707b, this.f70780a);
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zze(String str) {
    }
}
