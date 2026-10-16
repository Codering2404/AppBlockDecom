package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzcas implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcat f77347a;

    /* synthetic */ zzcas(zzcat zzcatVar, byte[] bArr) {
        Objects.requireNonNull(zzcatVar);
        this.f77347a = zzcatVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f77347a.k() == null) {
                throw new IOException("Unable to perform write due to unavailable sink.");
            }
            a();
        } catch (Exception e3) {
            this.f77347a.f().d(e3);
        }
    }
}
