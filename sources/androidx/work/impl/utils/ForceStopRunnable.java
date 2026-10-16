package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.UserManagerCompat;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ForceStopRunnable implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f55145f = Logger.i("ForceStopRunnable");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f55146g = TimeUnit.DAYS.toMillis(3650);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f55147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WorkManagerImpl f55148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PreferenceUtils f55149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f55150d = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f55151a = Logger.i("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            Logger.e().j(f55151a, "Rescheduling alarm that keeps track of force-stops.");
            ForceStopRunnable.g(context);
        }
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.f55147a = context.getApplicationContext();
        this.f55148b = workManagerImpl;
        this.f55149c = workManagerImpl.s();
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i3) {
        return PendingIntent.getBroadcast(context, -1, c(context), i3);
    }

    static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent pendingIntentD = d(context, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
        long jCurrentTimeMillis = System.currentTimeMillis() + f55146g;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, pendingIntentD);
        }
    }

    public boolean a() {
        boolean zI = SystemJobScheduler.i(this.f55147a, this.f55148b.w());
        WorkDatabase workDatabaseW = this.f55148b.w();
        WorkSpecDao workSpecDaoT = workDatabaseW.t();
        WorkProgressDao workProgressDaoS = workDatabaseW.s();
        workDatabaseW.beginTransaction();
        try {
            List<WorkSpec> listY = workSpecDaoT.y();
            boolean z2 = (listY == null || listY.isEmpty()) ? false : true;
            if (z2) {
                for (WorkSpec workSpec : listY) {
                    workSpecDaoT.v(WorkInfo.State.ENQUEUED, workSpec.f55013a);
                    workSpecDaoT.a(workSpec.f55013a, -512);
                    workSpecDaoT.s(workSpec.f55013a, -1L);
                }
            }
            workProgressDaoS.b();
            workDatabaseW.setTransactionSuccessful();
            workDatabaseW.endTransaction();
            return z2 || zI;
        } catch (Throwable th) {
            workDatabaseW.endTransaction();
            throw th;
        }
    }

    public void b() {
        boolean zA = a();
        if (h()) {
            Logger.e().a(f55145f, "Rescheduling Workers.");
            this.f55148b.z();
            this.f55148b.s().g(false);
        } else if (e()) {
            Logger.e().a(f55145f, "Application was force-stopped, rescheduling.");
            this.f55148b.z();
            this.f55149c.f(this.f55148b.p().a().currentTimeMillis());
        } else if (zA) {
            Logger.e().a(f55145f, "Found unfinished work, scheduling it.");
            Schedulers.f(this.f55148b.p(), this.f55148b.w(), this.f55148b.u());
        }
    }

    public boolean e() {
        try {
            int i3 = Build.VERSION.SDK_INT;
            PendingIntent pendingIntentD = d(this.f55147a, i3 >= 31 ? 570425344 : 536870912);
            if (i3 >= 30) {
                if (pendingIntentD != null) {
                    pendingIntentD.cancel();
                }
                List historicalProcessExitReasons = ((ActivityManager) this.f55147a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    long jB = this.f55149c.b();
                    for (int i4 = 0; i4 < historicalProcessExitReasons.size(); i4++) {
                        ApplicationExitInfo applicationExitInfoA = b.a(historicalProcessExitReasons.get(i4));
                        if (applicationExitInfoA.getReason() == 10 && applicationExitInfoA.getTimestamp() >= jB) {
                            return true;
                        }
                    }
                }
            } else if (pendingIntentD == null) {
                g(this.f55147a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e3) {
            e = e3;
            Logger.e().l(f55145f, "Ignoring exception", e);
            return true;
        } catch (SecurityException e4) {
            e = e4;
            Logger.e().l(f55145f, "Ignoring exception", e);
            return true;
        }
    }

    public boolean f() {
        Configuration configurationP = this.f55148b.p();
        if (TextUtils.isEmpty(configurationP.c())) {
            Logger.e().a(f55145f, "The default process name was not specified.");
            return true;
        }
        boolean zB = ProcessUtils.b(this.f55147a, configurationP);
        Logger.e().a(f55145f, "Is default app process = " + zB);
        return zB;
    }

    public boolean h() {
        return this.f55148b.s().c();
    }

    public void i(long j3) {
        try {
            Thread.sleep(j3);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        try {
            if (f()) {
                while (true) {
                    try {
                        WorkDatabasePathHelper.d(this.f55147a);
                        Logger.e().a(f55145f, "Performing cleanup operations.");
                        try {
                            b();
                            break;
                        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e3) {
                            i3 = this.f55150d + 1;
                            this.f55150d = i3;
                            if (i3 >= 3) {
                                String str = UserManagerCompat.a(this.f55147a) ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                                Logger loggerE = Logger.e();
                                String str2 = f55145f;
                                loggerE.d(str2, str, e3);
                                IllegalStateException illegalStateException = new IllegalStateException(str, e3);
                                Consumer consumerE = this.f55148b.p().e();
                                if (consumerE == null) {
                                    throw illegalStateException;
                                }
                                Logger.e().b(str2, "Routing exception to the specified exception handler", illegalStateException);
                                consumerE.accept(illegalStateException);
                            } else {
                                Logger.e().b(f55145f, "Retrying after " + (((long) i3) * 300), e3);
                                i(((long) this.f55150d) * 300);
                            }
                        }
                        Logger.e().b(f55145f, "Retrying after " + (((long) i3) * 300), e3);
                        i(((long) this.f55150d) * 300);
                    } catch (SQLiteException e4) {
                        Logger.e().c(f55145f, "Unexpected SQLite exception during migrations");
                        IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e4);
                        Consumer consumerE2 = this.f55148b.p().e();
                        if (consumerE2 == null) {
                            throw illegalStateException2;
                        }
                        consumerE2.accept(illegalStateException2);
                    }
                }
            }
        } finally {
            this.f55148b.y();
        }
    }
}
