package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbuv implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbwo f76928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f76929b;

    zzbuv(zzbwo zzbwoVar) {
        this.f76928a = (zzbwo) Preconditions.u(zzbwoVar, "executorPool");
    }

    final synchronized Executor a() {
        try {
            if (this.f76929b == null) {
                this.f76929b = (Executor) Preconditions.v((Executor) this.f76928a.zza(), "%s.getObject()", this.f76929b);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f76929b;
    }

    final synchronized void b() {
        Executor executor = this.f76929b;
        if (executor != null) {
            this.f76928a.zzb(executor);
            this.f76929b = null;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        a().execute(runnable);
    }
}
