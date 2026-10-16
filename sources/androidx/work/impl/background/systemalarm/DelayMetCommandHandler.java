package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DelayMetCommandHandler implements OnConstraintsStateChangedListener, WorkTimer.TimeLimitExceededListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f54795p = Logger.i("DelayMetCommandHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f54796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f54797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WorkGenerationalId f54798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SystemAlarmDispatcher f54799d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WorkConstraintsTracker f54800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f54801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f54802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f54803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Executor f54804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PowerManager.WakeLock f54805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f54806l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final StartStopToken f54807m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CoroutineDispatcher f54808n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile Job f54809o;

    DelayMetCommandHandler(Context context, int i3, SystemAlarmDispatcher systemAlarmDispatcher, StartStopToken startStopToken) {
        this.f54796a = context;
        this.f54797b = i3;
        this.f54799d = systemAlarmDispatcher;
        this.f54798c = startStopToken.a();
        this.f54807m = startStopToken;
        Trackers trackersV = systemAlarmDispatcher.g().v();
        this.f54803i = systemAlarmDispatcher.f().c();
        this.f54804j = systemAlarmDispatcher.f().a();
        this.f54808n = systemAlarmDispatcher.f().b();
        this.f54800f = new WorkConstraintsTracker(trackersV);
        this.f54806l = false;
        this.f54802h = 0;
        this.f54801g = new Object();
    }

    private void d() {
        synchronized (this.f54801g) {
            try {
                if (this.f54809o != null) {
                    this.f54809o.cancel((CancellationException) null);
                }
                this.f54799d.h().b(this.f54798c);
                PowerManager.WakeLock wakeLock = this.f54805k;
                if (wakeLock != null && wakeLock.isHeld()) {
                    Logger.e().a(f54795p, "Releasing wakelock " + this.f54805k + "for WorkSpec " + this.f54798c);
                    this.f54805k.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f54802h != 0) {
            Logger.e().a(f54795p, "Already started work for " + this.f54798c);
            return;
        }
        this.f54802h = 1;
        Logger.e().a(f54795p, "onAllConstraintsMet for " + this.f54798c);
        if (this.f54799d.e().o(this.f54807m)) {
            this.f54799d.h().a(this.f54798c, 600000L, this);
        } else {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String strB = this.f54798c.b();
        if (this.f54802h >= 2) {
            Logger.e().a(f54795p, "Already stopped work for " + strB);
            return;
        }
        this.f54802h = 2;
        Logger loggerE = Logger.e();
        String str = f54795p;
        loggerE.a(str, "Stopping work for WorkSpec " + strB);
        this.f54804j.execute(new SystemAlarmDispatcher.AddRunnable(this.f54799d, CommandHandler.f(this.f54796a, this.f54798c), this.f54797b));
        if (!this.f54799d.e().k(this.f54798c.b())) {
            Logger.e().a(str, "Processor does not have WorkSpec " + strB + ". No need to reschedule");
            return;
        }
        Logger.e().a(str, "WorkSpec " + strB + " needs to be rescheduled");
        this.f54804j.execute(new SystemAlarmDispatcher.AddRunnable(this.f54799d, CommandHandler.e(this.f54796a, this.f54798c), this.f54797b));
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public void a(WorkGenerationalId workGenerationalId) {
        Logger.e().a(f54795p, "Exceeded time limits on execution for " + workGenerationalId);
        this.f54803i.execute(new a(this));
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public void e(WorkSpec workSpec, ConstraintsState constraintsState) {
        if (constraintsState instanceof ConstraintsState.ConstraintsMet) {
            this.f54803i.execute(new b(this));
        } else {
            this.f54803i.execute(new a(this));
        }
    }

    void f() {
        String strB = this.f54798c.b();
        this.f54805k = WakeLocks.b(this.f54796a, strB + " (" + this.f54797b + ")");
        Logger loggerE = Logger.e();
        String str = f54795p;
        loggerE.a(str, "Acquiring wakelock " + this.f54805k + "for WorkSpec " + strB);
        this.f54805k.acquire();
        WorkSpec workSpecL = this.f54799d.g().w().t().l(strB);
        if (workSpecL == null) {
            this.f54803i.execute(new a(this));
            return;
        }
        boolean zK = workSpecL.k();
        this.f54806l = zK;
        if (zK) {
            this.f54809o = WorkConstraintsTrackerKt.b(this.f54800f, workSpecL, this.f54808n, this);
            return;
        }
        Logger.e().a(str, "No constraints for " + strB);
        this.f54803i.execute(new b(this));
    }

    void g(boolean z2) {
        Logger.e().a(f54795p, "onExecuted " + this.f54798c + ", " + z2);
        d();
        if (z2) {
            this.f54804j.execute(new SystemAlarmDispatcher.AddRunnable(this.f54799d, CommandHandler.e(this.f54796a, this.f54798c), this.f54797b));
        }
        if (this.f54806l) {
            this.f54804j.execute(new SystemAlarmDispatcher.AddRunnable(this.f54799d, CommandHandler.a(this.f54796a), this.f54797b));
        }
    }
}
