package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class Alarms {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f54776a = Logger.i("Alarms");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api19Impl {
        static void a(AlarmManager alarmManager, int i3, long j3, PendingIntent pendingIntent) {
            alarmManager.setExact(i3, j3, pendingIntent);
        }
    }

    public static void a(Context context, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId) {
        SystemIdInfoDao systemIdInfoDaoQ = workDatabase.q();
        SystemIdInfo systemIdInfoB = systemIdInfoDaoQ.b(workGenerationalId);
        if (systemIdInfoB != null) {
            b(context, workGenerationalId, systemIdInfoB.f54986c);
            Logger.e().a(f54776a, "Removing SystemIdInfo for workSpecId (" + workGenerationalId + ")");
            systemIdInfoDaoQ.d(workGenerationalId);
        }
    }

    private static void b(Context context, WorkGenerationalId workGenerationalId, int i3) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i3, CommandHandler.b(context, workGenerationalId), 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        Logger.e().a(f54776a, "Cancelling existing alarm with (workSpecId, systemId) (" + workGenerationalId + ", " + i3 + ")");
        alarmManager.cancel(service);
    }

    public static void c(Context context, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId, long j3) {
        SystemIdInfoDao systemIdInfoDaoQ = workDatabase.q();
        SystemIdInfo systemIdInfoB = systemIdInfoDaoQ.b(workGenerationalId);
        if (systemIdInfoB != null) {
            b(context, workGenerationalId, systemIdInfoB.f54986c);
            d(context, workGenerationalId, systemIdInfoB.f54986c, j3);
        } else {
            int iC = new IdGenerator(workDatabase).c();
            systemIdInfoDaoQ.f(SystemIdInfoKt.a(workGenerationalId, iC));
            d(context, workGenerationalId, iC, j3);
        }
    }

    private static void d(Context context, WorkGenerationalId workGenerationalId, int i3, long j3) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i3, CommandHandler.b(context, workGenerationalId), 201326592);
        if (alarmManager != null) {
            Api19Impl.a(alarmManager, 0, j3, service);
        }
    }
}
