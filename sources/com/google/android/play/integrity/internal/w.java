package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class w extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f83192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ t f83193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ae f83194i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    w(ae aeVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, t tVar) {
        super(taskCompletionSource);
        this.f83194i = aeVar;
        this.f83192g = taskCompletionSource2;
        this.f83193h = tVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        synchronized (this.f83194i.f83169f) {
            try {
                ae.o(this.f83194i, this.f83192g);
                if (this.f83194i.f83175l.getAndIncrement() > 0) {
                    this.f83194i.f83165b.d("Already connected to the service.", new Object[0]);
                }
                ae.q(this.f83194i, this.f83193h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
