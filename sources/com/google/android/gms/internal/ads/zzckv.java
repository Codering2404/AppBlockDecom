package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzckv implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzcdn zza;
    final /* synthetic */ zzclf zzb;

    zzckv(zzclf zzclfVar, zzcdn zzcdnVar) {
        this.zza = zzcdnVar;
        Objects.requireNonNull(zzclfVar);
        this.zzb = zzclfVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzZ(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
