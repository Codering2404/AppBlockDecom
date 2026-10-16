package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class bg extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f83012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f83013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f83014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f83015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f83016e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bg(bn bnVar, TaskCompletionSource taskCompletionSource, int i3, String str, long j3, long j4, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f83016e = bnVar;
        this.f83012a = str;
        this.f83013b = j3;
        this.f83014c = j4;
        this.f83015d = taskCompletionSource2;
    }

    @Override // com.google.android.play.integrity.internal.t
    protected final void b() {
        if (bn.k(this.f83016e)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f83016e;
            ((com.google.android.play.integrity.internal.i) bnVar.f83031a.e()).j4(bn.a(bnVar, this.f83012a, this.f83013b, this.f83014c, 0), new bk(this.f83016e, this.f83015d, this.f83013b));
        } catch (RemoteException e3) {
            this.f83016e.f83032b.c(e3, "requestExpressIntegrityToken(%s, %s)", this.f83012a, Long.valueOf(this.f83013b));
            this.f83015d.trySetException(new StandardIntegrityException(-100, e3));
        }
    }
}
