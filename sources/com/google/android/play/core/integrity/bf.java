package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class bf extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f83009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f83010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f83011c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bf(bn bnVar, TaskCompletionSource taskCompletionSource, int i3, long j3, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f83011c = bnVar;
        this.f83009a = j3;
        this.f83010b = taskCompletionSource2;
    }

    @Override // com.google.android.play.integrity.internal.t
    protected final void b() {
        if (bn.k(this.f83011c)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f83011c;
            ((com.google.android.play.integrity.internal.i) bnVar.f83031a.e()).G3(bn.b(bnVar, this.f83009a, 0), new bl(this.f83011c, this.f83010b));
        } catch (RemoteException e3) {
            this.f83011c.f83032b.c(e3, "warmUpIntegrityToken(%s)", Long.valueOf(this.f83009a));
            this.f83010b.trySetException(new StandardIntegrityException(-100, e3));
        }
    }
}
