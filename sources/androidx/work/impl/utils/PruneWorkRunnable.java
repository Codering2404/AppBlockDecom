package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PruneWorkRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WorkManagerImpl f55163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OperationImpl f55164b;

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f55163a.w().t().d();
            this.f55164b.a(Operation.f54551a);
        } catch (Throwable th) {
            this.f55164b.a(new Operation.State.FAILURE(th));
        }
    }
}
