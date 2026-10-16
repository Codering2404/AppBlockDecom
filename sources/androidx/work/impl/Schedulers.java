package androidx.work.impl;

import android.content.Context;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Schedulers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f54649a = Logger.i("Schedulers");

    public static /* synthetic */ void b(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).a(workGenerationalId.b());
        }
        f(configuration, workDatabase, list);
    }

    static Scheduler c(Context context, WorkDatabase workDatabase, Configuration configuration) {
        SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workDatabase, configuration);
        PackageManagerHelper.c(context, SystemJobService.class, true);
        Logger.e().a(f54649a, "Created SystemJobScheduler and enabled SystemJobService");
        return systemJobScheduler;
    }

    private static void d(WorkSpecDao workSpecDao, Clock clock, List list) {
        if (list.size() > 0) {
            long jCurrentTimeMillis = clock.currentTimeMillis();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                workSpecDao.s(((WorkSpec) it.next()).f55013a, jCurrentTimeMillis);
            }
        }
    }

    public static void e(final List list, Processor processor, final Executor executor, final WorkDatabase workDatabase, final Configuration configuration) {
        processor.e(new ExecutionListener() { // from class: androidx.work.impl.d
            @Override // androidx.work.impl.ExecutionListener
            public final void c(WorkGenerationalId workGenerationalId, boolean z2) {
                executor.execute(new Runnable() { // from class: androidx.work.impl.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        Schedulers.b(list, workGenerationalId, configuration, workDatabase);
                    }
                });
            }
        });
    }

    public static void f(Configuration configuration, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        WorkSpecDao workSpecDaoT = workDatabase.t();
        workDatabase.beginTransaction();
        try {
            List listB = workSpecDaoT.B();
            d(workSpecDaoT, configuration.a(), listB);
            List listU = workSpecDaoT.u(configuration.h());
            d(workSpecDaoT, configuration.a(), listU);
            if (listB != null) {
                listU.addAll(listB);
            }
            List listQ = workSpecDaoT.q(200);
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (listU.size() > 0) {
                WorkSpec[] workSpecArr = (WorkSpec[]) listU.toArray(new WorkSpec[listU.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Scheduler scheduler = (Scheduler) it.next();
                    if (scheduler.d()) {
                        scheduler.b(workSpecArr);
                    }
                }
            }
            if (listQ.size() > 0) {
                WorkSpec[] workSpecArr2 = (WorkSpec[]) listQ.toArray(new WorkSpec[listQ.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Scheduler scheduler2 = (Scheduler) it2.next();
                    if (!scheduler2.d()) {
                        scheduler2.b(workSpecArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
