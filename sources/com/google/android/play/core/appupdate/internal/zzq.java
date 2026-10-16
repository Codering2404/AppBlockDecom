package com.google.android.play.core.appupdate.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzq extends zzn {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f82873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzn f82874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzx f82875d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzq(zzx zzxVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzn zznVar) {
        super(taskCompletionSource);
        this.f82875d = zzxVar;
        this.f82873b = taskCompletionSource2;
        this.f82874c = zznVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        synchronized (this.f82875d.f82887f) {
            try {
                zzx.n(this.f82875d, this.f82873b);
                if (this.f82875d.f82892k.getAndIncrement() > 0) {
                    this.f82875d.f82883b.d("Already connected to the service.", new Object[0]);
                }
                zzx.p(this.f82875d, this.f82874c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
