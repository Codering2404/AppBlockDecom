package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f71869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f71870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzc f71871c;

    zzb(zzc zzcVar, LifecycleCallback lifecycleCallback, String str) {
        this.f71869a = lifecycleCallback;
        this.f71870b = str;
        Objects.requireNonNull(zzcVar);
        this.f71871c = zzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        zzc zzcVar = this.f71871c;
        if (zzcVar.k() > 0) {
            LifecycleCallback lifecycleCallback = this.f71869a;
            if (zzcVar.l() != null) {
                bundle = zzcVar.l().getBundle(this.f71870b);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (zzcVar.k() >= 2) {
            this.f71869a.onStart();
        }
        if (zzcVar.k() >= 3) {
            this.f71869a.onResume();
        }
        if (zzcVar.k() >= 4) {
            this.f71869a.onStop();
        }
        if (zzcVar.k() >= 5) {
            this.f71869a.onDestroy();
        }
    }
}
