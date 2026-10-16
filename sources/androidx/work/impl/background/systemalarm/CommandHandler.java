package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CommandHandler implements ExecutionListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f54777g = Logger.i("CommandHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f54778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f54779b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f54780c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Clock f54781d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StartStopTokens f54782f;

    CommandHandler(Context context, Clock clock, StartStopTokens startStopTokens) {
        this.f54778a = context;
        this.f54781d = clock;
        this.f54782f = startStopTokens;
    }

    static Intent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent b(Context context, WorkGenerationalId workGenerationalId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        return r(intent, workGenerationalId);
    }

    static Intent d(Context context, WorkGenerationalId workGenerationalId, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z2);
        return r(intent, workGenerationalId);
    }

    static Intent e(Context context, WorkGenerationalId workGenerationalId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        return r(intent, workGenerationalId);
    }

    static Intent f(Context context, WorkGenerationalId workGenerationalId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        return r(intent, workGenerationalId);
    }

    static Intent g(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void h(Intent intent, int i3, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.e().a(f54777g, "Handling constraints changed " + intent);
        new ConstraintsCommandHandler(this.f54778a, this.f54781d, i3, systemAlarmDispatcher).a();
    }

    private void i(Intent intent, int i3, SystemAlarmDispatcher systemAlarmDispatcher) {
        synchronized (this.f54780c) {
            try {
                WorkGenerationalId workGenerationalIdQ = q(intent);
                Logger loggerE = Logger.e();
                String str = f54777g;
                loggerE.a(str, "Handing delay met for " + workGenerationalIdQ);
                if (this.f54779b.containsKey(workGenerationalIdQ)) {
                    Logger.e().a(str, "WorkSpec " + workGenerationalIdQ + " is is already being handled for ACTION_DELAY_MET");
                } else {
                    DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.f54778a, i3, systemAlarmDispatcher, this.f54782f.d(workGenerationalIdQ));
                    this.f54779b.put(workGenerationalIdQ, delayMetCommandHandler);
                    delayMetCommandHandler.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(Intent intent, int i3) {
        WorkGenerationalId workGenerationalIdQ = q(intent);
        boolean z2 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
        Logger.e().a(f54777g, "Handling onExecutionCompleted " + intent + ", " + i3);
        c(workGenerationalIdQ, z2);
    }

    private void k(Intent intent, int i3, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.e().a(f54777g, "Handling reschedule " + intent + ", " + i3);
        systemAlarmDispatcher.g().z();
    }

    private void l(Intent intent, int i3, SystemAlarmDispatcher systemAlarmDispatcher) {
        WorkGenerationalId workGenerationalIdQ = q(intent);
        Logger loggerE = Logger.e();
        String str = f54777g;
        loggerE.a(str, "Handling schedule work for " + workGenerationalIdQ);
        WorkDatabase workDatabaseW = systemAlarmDispatcher.g().w();
        workDatabaseW.beginTransaction();
        try {
            WorkSpec workSpecL = workDatabaseW.t().l(workGenerationalIdQ.b());
            if (workSpecL == null) {
                Logger.e().k(str, "Skipping scheduling " + workGenerationalIdQ + " because it's no longer in the DB");
                return;
            }
            if (workSpecL.f55014b.b()) {
                Logger.e().k(str, "Skipping scheduling " + workGenerationalIdQ + "because it is finished.");
                return;
            }
            long jC = workSpecL.c();
            if (workSpecL.k()) {
                Logger.e().a(str, "Opportunistically setting an alarm for " + workGenerationalIdQ + "at " + jC);
                Alarms.c(this.f54778a, workDatabaseW, workGenerationalIdQ, jC);
                systemAlarmDispatcher.f().a().execute(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, a(this.f54778a), i3));
            } else {
                Logger.e().a(str, "Setting up Alarms for " + workGenerationalIdQ + "at " + jC);
                Alarms.c(this.f54778a, workDatabaseW, workGenerationalIdQ, jC);
            }
            workDatabaseW.setTransactionSuccessful();
        } finally {
            workDatabaseW.endTransaction();
        }
    }

    private void m(Intent intent, SystemAlarmDispatcher systemAlarmDispatcher) {
        List<StartStopToken> listC;
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        if (extras.containsKey("KEY_WORKSPEC_GENERATION")) {
            int i3 = extras.getInt("KEY_WORKSPEC_GENERATION");
            listC = new ArrayList(1);
            StartStopToken startStopTokenB = this.f54782f.b(new WorkGenerationalId(string, i3));
            if (startStopTokenB != null) {
                listC.add(startStopTokenB);
            }
        } else {
            listC = this.f54782f.c(string);
        }
        for (StartStopToken startStopToken : listC) {
            Logger.e().a(f54777g, "Handing stopWork work for " + string);
            systemAlarmDispatcher.i().e(startStopToken);
            Alarms.a(this.f54778a, systemAlarmDispatcher.g().w(), startStopToken.a());
            systemAlarmDispatcher.c(startStopToken.a(), false);
        }
    }

    private static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    static WorkGenerationalId q(Intent intent) {
        return new WorkGenerationalId(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    private static Intent r(Intent intent, WorkGenerationalId workGenerationalId) {
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.b());
        intent.putExtra("KEY_WORKSPEC_GENERATION", workGenerationalId.a());
        return intent;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void c(WorkGenerationalId workGenerationalId, boolean z2) {
        synchronized (this.f54780c) {
            try {
                DelayMetCommandHandler delayMetCommandHandler = (DelayMetCommandHandler) this.f54779b.remove(workGenerationalId);
                this.f54782f.b(workGenerationalId);
                if (delayMetCommandHandler != null) {
                    delayMetCommandHandler.g(z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean o() {
        boolean z2;
        synchronized (this.f54780c) {
            z2 = !this.f54779b.isEmpty();
        }
        return z2;
    }

    void p(Intent intent, int i3, SystemAlarmDispatcher systemAlarmDispatcher) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i3, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i3, systemAlarmDispatcher);
            return;
        }
        if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            Logger.e().c(f54777g, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i3, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i3, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i3);
            return;
        }
        Logger.e().k(f54777g, "Ignoring intent " + intent);
    }
}
