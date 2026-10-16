package com.google.android.gms.ads.preload;

import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zze;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zza extends zzcd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreloadCallbackV2 f70819a;

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void b5(String str, zzdx zzdxVar) {
        this.f70819a.b(str, ResponseInfo.e(zzdxVar));
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void p3(String str, zze zzeVar) {
        this.f70819a.a(str, zzeVar.N());
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void zzf(String str) {
        this.f70819a.c(str);
    }
}
