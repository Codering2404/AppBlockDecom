package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzen extends zzca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreloadCallback f69907a;

    @Override // com.google.android.gms.ads.internal.client.zzcb
    public final void J(zzfp zzfpVar) {
        PreloadConfiguration preloadConfigurationC = com.google.android.gms.ads.internal.util.client.zzf.C(zzfpVar);
        if (preloadConfigurationC != null) {
            this.f69907a.b(preloadConfigurationC);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcb
    public final void Q0(zzfp zzfpVar) {
        PreloadConfiguration preloadConfigurationC = com.google.android.gms.ads.internal.util.client.zzf.C(zzfpVar);
        if (preloadConfigurationC != null) {
            this.f69907a.a(preloadConfigurationC);
        }
    }
}
