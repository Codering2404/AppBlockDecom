package com.google.android.libraries.places.internal;

import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbrk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InputStream f76718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbrt f76719b;

    zzbrk(zzbrt zzbrtVar, InputStream inputStream) {
        this.f76718a = inputStream;
        Objects.requireNonNull(zzbrtVar);
        this.f76719b = zzbrtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76719b.o().f(this.f76718a);
    }
}
