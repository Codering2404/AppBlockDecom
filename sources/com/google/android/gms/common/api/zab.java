package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zab implements PendingResult.StatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Batch f71877a;

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        synchronized (this.f71877a.f71492e) {
            try {
                if (this.f71877a.isCanceled()) {
                    return;
                }
                if (status.C()) {
                    this.f71877a.f71490c = true;
                } else if (!status.w0()) {
                    this.f71877a.f71489b = true;
                }
                Batch batch = this.f71877a;
                batch.f71488a--;
                Batch batch2 = this.f71877a;
                if (batch2.f71488a == 0) {
                    if (batch2.f71490c) {
                        super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                    } else {
                        Status status2 = batch2.f71489b ? new Status(13) : Status.f71537g;
                        Batch batch3 = this.f71877a;
                        batch3.setResult(new BatchResult(status2, batch3.f71491d));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
