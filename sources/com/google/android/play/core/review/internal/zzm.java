package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzm extends zzj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f83115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzj f83116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzt f83117d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzm(zzt zztVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzj zzjVar) {
        super(taskCompletionSource);
        this.f83115b = taskCompletionSource2;
        this.f83116c = zzjVar;
        this.f83117d = zztVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void a() {
        synchronized (this.f83117d.f83129f) {
            try {
                zzt.n(this.f83117d, this.f83115b);
                if (this.f83117d.f83134k.getAndIncrement() > 0) {
                    this.f83117d.f83125b.c("Already connected to the service.", new Object[0]);
                }
                zzt.p(this.f83117d, this.f83116c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
