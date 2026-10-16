package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CancelWorkRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OperationImpl f55133a = new OperationImpl();

    /* JADX INFO: renamed from: androidx.work.impl.utils.CancelWorkRunnable$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 extends CancelWorkRunnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorkManagerImpl f55141b;

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        void h() {
            WorkDatabase workDatabaseW = this.f55141b.w();
            workDatabaseW.beginTransaction();
            try {
                Iterator it = workDatabaseW.t().z().iterator();
                while (it.hasNext()) {
                    a(this.f55141b, (String) it.next());
                }
                new PreferenceUtils(this.f55141b.w()).e(this.f55141b.p().a().currentTimeMillis());
                workDatabaseW.setTransactionSuccessful();
                workDatabaseW.endTransaction();
            } catch (Throwable th) {
                workDatabaseW.endTransaction();
                throw th;
            }
        }
    }

    public static CancelWorkRunnable b(final UUID uuid, final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.1
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            void h() {
                WorkDatabase workDatabaseW = workManagerImpl.w();
                workDatabaseW.beginTransaction();
                try {
                    a(workManagerImpl, uuid.toString());
                    workDatabaseW.setTransactionSuccessful();
                    workDatabaseW.endTransaction();
                    g(workManagerImpl);
                } catch (Throwable th) {
                    workDatabaseW.endTransaction();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable c(final String str, final WorkManagerImpl workManagerImpl, final boolean z2) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.3
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            void h() {
                WorkDatabase workDatabaseW = workManagerImpl.w();
                workDatabaseW.beginTransaction();
                try {
                    Iterator it = workDatabaseW.t().i(str).iterator();
                    while (it.hasNext()) {
                        a(workManagerImpl, (String) it.next());
                    }
                    workDatabaseW.setTransactionSuccessful();
                    workDatabaseW.endTransaction();
                    if (z2) {
                        g(workManagerImpl);
                    }
                } catch (Throwable th) {
                    workDatabaseW.endTransaction();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable d(final String str, final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.2
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            void h() {
                WorkDatabase workDatabaseW = workManagerImpl.w();
                workDatabaseW.beginTransaction();
                try {
                    Iterator it = workDatabaseW.t().n(str).iterator();
                    while (it.hasNext()) {
                        a(workManagerImpl, (String) it.next());
                    }
                    workDatabaseW.setTransactionSuccessful();
                    workDatabaseW.endTransaction();
                    g(workManagerImpl);
                } catch (Throwable th) {
                    workDatabaseW.endTransaction();
                    throw th;
                }
            }
        };
    }

    private void f(WorkDatabase workDatabase, String str) {
        WorkSpecDao workSpecDaoT = workDatabase.t();
        DependencyDao dependencyDaoN = workDatabase.n();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State stateK = workSpecDaoT.k(str2);
            if (stateK != WorkInfo.State.SUCCEEDED && stateK != WorkInfo.State.FAILED) {
                workSpecDaoT.m(str2);
            }
            linkedList.addAll(dependencyDaoN.b(str2));
        }
    }

    void a(WorkManagerImpl workManagerImpl, String str) {
        f(workManagerImpl.w(), str);
        workManagerImpl.t().q(str, 1);
        Iterator it = workManagerImpl.u().iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).a(str);
        }
    }

    public Operation e() {
        return this.f55133a;
    }

    void g(WorkManagerImpl workManagerImpl) {
        Schedulers.f(workManagerImpl.p(), workManagerImpl.w(), workManagerImpl.u());
    }

    abstract void h();

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
            this.f55133a.a(Operation.f54551a);
        } catch (Throwable th) {
            this.f55133a.a(new Operation.State.FAILURE(th));
        }
    }
}
