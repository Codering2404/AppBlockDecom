package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzei extends zzaz {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzek f69887c;

    zzei(zzek zzekVar) {
        Objects.requireNonNull(zzekVar);
        this.f69887c = zzekVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzaz, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        zzek zzekVar = this.f69887c;
        zzekVar.e().b(zzekVar.D());
        super.onAdFailedToLoad(loadAdError);
    }

    @Override // com.google.android.gms.ads.internal.client.zzaz, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        zzek zzekVar = this.f69887c;
        zzekVar.e().b(zzekVar.D());
        super.onAdLoaded();
    }
}
