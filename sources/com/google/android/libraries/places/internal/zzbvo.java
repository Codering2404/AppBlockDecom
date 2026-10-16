package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbvp f76961a;

    zzbvo(zzbvp zzbvpVar) {
        Objects.requireNonNull(zzbvpVar);
        this.f76961a = zzbvpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76961a.f76967f.a(zzbvr.f76979h0);
    }
}
