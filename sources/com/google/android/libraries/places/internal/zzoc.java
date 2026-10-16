package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzoc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Task f78305a;

    /* synthetic */ zzoc(byte[] bArr) {
    }

    public abstract CancellationTokenSource a();

    public final Task b() {
        return this.f78305a;
    }

    public final void c(Task task) {
        this.f78305a = task;
    }
}
