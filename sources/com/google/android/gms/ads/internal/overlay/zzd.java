package com.google.android.gms.ads.internal.overlay;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzd implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzm f70085a;

    zzd(zzm zzmVar) {
        Objects.requireNonNull(zzmVar);
        this.f70085a = zzmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzm zzmVar = this.f70085a;
        zzmVar.f70120w = 2;
        zzmVar.f70099a.finish();
    }
}
