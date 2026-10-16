package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzdj;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzau extends zzdj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f70247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzax f70248b;

    zzau(zzax zzaxVar, Context context) {
        this.f70247a = context;
        Objects.requireNonNull(zzaxVar);
        this.f70248b = zzaxVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdk
    public final void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar == null) {
            return;
        }
        this.f70248b.n(this.f70247a, zzeVar.f69852b, true, true);
    }
}
