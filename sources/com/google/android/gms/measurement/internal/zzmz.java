package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ComponentName f74292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zznf f74293b;

    zzmz(zznf zznfVar, ComponentName componentName) {
        this.f74292a = componentName;
        Objects.requireNonNull(zznfVar);
        this.f74293b = zznfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74293b.f74305c.K(this.f74292a);
    }
}
