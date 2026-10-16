package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SystemForegroundDispatcher implements OnConstraintsStateChangedListener, ExecutionListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final String f54925l = Logger.i("SystemFgDispatcher");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f54926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WorkManagerImpl f54927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskExecutor f54928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f54929d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    WorkGenerationalId f54930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Map f54931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map f54932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Map f54933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final WorkConstraintsTracker f54934j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Callback f54935k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Callback {
        void a(int i3, Notification notification);

        void c(int i3, int i4, Notification notification);

        void d(int i3);

        void stop();
    }

    SystemForegroundDispatcher(Context context) {
        this.f54926a = context;
        WorkManagerImpl workManagerImplR = WorkManagerImpl.r(context);
        this.f54927b = workManagerImplR;
        this.f54928c = workManagerImplR.x();
        this.f54930f = null;
        this.f54931g = new LinkedHashMap();
        this.f54933i = new HashMap();
        this.f54932h = new HashMap();
        this.f54934j = new WorkConstraintsTracker(this.f54927b.v());
        this.f54927b.t().e(this);
    }

    public static Intent d(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.a());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.b());
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.b());
        intent.putExtra("KEY_GENERATION", workGenerationalId.a());
        return intent;
    }

    public static Intent f(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.b());
        intent.putExtra("KEY_GENERATION", workGenerationalId.a());
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.a());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.b());
        return intent;
    }

    public static Intent g(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void h(Intent intent) {
        Logger.e().f(f54925l, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.f54927b.m(UUID.fromString(stringExtra));
    }

    private void i(Intent intent) {
        int iA = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        WorkGenerationalId workGenerationalId = new WorkGenerationalId(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger.e().a(f54925l, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
        if (notification == null || this.f54935k == null) {
            return;
        }
        this.f54931g.put(workGenerationalId, new ForegroundInfo(intExtra, notification, intExtra2));
        if (this.f54930f == null) {
            this.f54930f = workGenerationalId;
            this.f54935k.c(intExtra, intExtra2, notification);
            return;
        }
        this.f54935k.a(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = this.f54931g.entrySet().iterator();
        while (it.hasNext()) {
            iA |= ((ForegroundInfo) ((Map.Entry) it.next()).getValue()).a();
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) this.f54931g.get(this.f54930f);
        if (foregroundInfo != null) {
            this.f54935k.c(foregroundInfo.c(), iA, foregroundInfo.b());
        }
    }

    private void j(Intent intent) {
        Logger.e().f(f54925l, "Started foreground service " + intent);
        final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        this.f54928c.d(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundDispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                WorkSpec workSpecG = SystemForegroundDispatcher.this.f54927b.t().g(stringExtra);
                if (workSpecG == null || !workSpecG.k()) {
                    return;
                }
                synchronized (SystemForegroundDispatcher.this.f54929d) {
                    SystemForegroundDispatcher.this.f54932h.put(WorkSpecKt.a(workSpecG), workSpecG);
                    SystemForegroundDispatcher systemForegroundDispatcher = SystemForegroundDispatcher.this;
                    SystemForegroundDispatcher.this.f54933i.put(WorkSpecKt.a(workSpecG), WorkConstraintsTrackerKt.b(systemForegroundDispatcher.f54934j, workSpecG, systemForegroundDispatcher.f54928c.b(), SystemForegroundDispatcher.this));
                }
            }
        });
    }

    @Override // androidx.work.impl.ExecutionListener
    public void c(WorkGenerationalId workGenerationalId, boolean z2) {
        Map.Entry entry;
        synchronized (this.f54929d) {
            try {
                Job job = ((WorkSpec) this.f54932h.remove(workGenerationalId)) != null ? (Job) this.f54933i.remove(workGenerationalId) : null;
                if (job != null) {
                    job.cancel((CancellationException) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) this.f54931g.remove(workGenerationalId);
        if (workGenerationalId.equals(this.f54930f)) {
            if (this.f54931g.size() > 0) {
                Iterator it = this.f54931g.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.f54930f = (WorkGenerationalId) entry.getKey();
                if (this.f54935k != null) {
                    ForegroundInfo foregroundInfo2 = (ForegroundInfo) entry.getValue();
                    this.f54935k.c(foregroundInfo2.c(), foregroundInfo2.a(), foregroundInfo2.b());
                    this.f54935k.d(foregroundInfo2.c());
                }
            } else {
                this.f54930f = null;
            }
        }
        Callback callback = this.f54935k;
        if (foregroundInfo == null || callback == null) {
            return;
        }
        Logger.e().a(f54925l, "Removing Notification (id: " + foregroundInfo.c() + ", workSpecId: " + workGenerationalId + ", notificationType: " + foregroundInfo.a());
        callback.d(foregroundInfo.c());
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public void e(WorkSpec workSpec, ConstraintsState constraintsState) {
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            String str = workSpec.f55013a;
            Logger.e().a(f54925l, "Constraints unmet for WorkSpec " + str);
            this.f54927b.B(WorkSpecKt.a(workSpec));
        }
    }

    void k(Intent intent) {
        Logger.e().f(f54925l, "Stopping foreground service");
        Callback callback = this.f54935k;
        if (callback != null) {
            callback.stop();
        }
    }

    void l() {
        this.f54935k = null;
        synchronized (this.f54929d) {
            try {
                Iterator it = this.f54933i.values().iterator();
                while (it.hasNext()) {
                    ((Job) it.next()).cancel((CancellationException) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f54927b.t().m(this);
    }

    void m(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            j(intent);
            i(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            i(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            h(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            k(intent);
        }
    }

    void n(Callback callback) {
        if (this.f54935k != null) {
            Logger.e().c(f54925l, "A callback already exists.");
        } else {
            this.f54935k = callback;
        }
    }
}
