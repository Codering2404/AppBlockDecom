package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class EnqueueRunnable implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f55142c = Logger.i("EnqueueRunnable");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WorkContinuationImpl f55143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OperationImpl f55144b;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this(workContinuationImpl, new OperationImpl());
    }

    private static boolean b(WorkContinuationImpl workContinuationImpl) {
        boolean zC = c(workContinuationImpl.g(), workContinuationImpl.f(), (String[]) WorkContinuationImpl.l(workContinuationImpl).toArray(new String[0]), workContinuationImpl.d(), workContinuationImpl.b());
        workContinuationImpl.k();
        return zC;
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(androidx.work.impl.WorkManagerImpl r18, java.util.List r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.c(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean e(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> listE = workContinuationImpl.e();
        boolean zE = false;
        if (listE != null) {
            for (WorkContinuationImpl workContinuationImpl2 : listE) {
                if (workContinuationImpl2.j()) {
                    Logger.e().k(f55142c, "Already enqueued work ids (" + TextUtils.join(", ", workContinuationImpl2.c()) + ")");
                } else {
                    zE |= e(workContinuationImpl2);
                }
            }
        }
        return b(workContinuationImpl) | zE;
    }

    public boolean a() {
        WorkManagerImpl workManagerImplG = this.f55143a.g();
        WorkDatabase workDatabaseW = workManagerImplG.w();
        workDatabaseW.beginTransaction();
        try {
            EnqueueUtilsKt.a(workDatabaseW, workManagerImplG.p(), this.f55143a);
            boolean zE = e(this.f55143a);
            workDatabaseW.setTransactionSuccessful();
            return zE;
        } finally {
            workDatabaseW.endTransaction();
        }
    }

    public Operation d() {
        return this.f55144b;
    }

    public void f() {
        WorkManagerImpl workManagerImplG = this.f55143a.g();
        Schedulers.f(workManagerImplG.p(), workManagerImplG.w(), workManagerImplG.u());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f55143a.h()) {
                throw new IllegalStateException("WorkContinuation has cycles (" + this.f55143a + ")");
            }
            if (a()) {
                PackageManagerHelper.c(this.f55143a.g().o(), RescheduleReceiver.class, true);
                f();
            }
            this.f55144b.a(Operation.f54551a);
        } catch (Throwable th) {
            this.f55144b.a(new Operation.State.FAILURE(th));
        }
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl, OperationImpl operationImpl) {
        this.f55143a = workContinuationImpl;
        this.f55144b = operationImpl;
    }
}
