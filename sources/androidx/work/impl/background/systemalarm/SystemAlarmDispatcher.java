package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SystemAlarmDispatcher implements ExecutionListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final String f54811m = Logger.i("SystemAlarmDispatcher");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f54812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TaskExecutor f54813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WorkTimer f54814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Processor f54815d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WorkManagerImpl f54816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final CommandHandler f54817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final List f54818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Intent f54819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CommandsCompletedListener f54820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private StartStopTokens f54821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final WorkLauncher f54822l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AddRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SystemAlarmDispatcher f54824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Intent f54825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f54826c;

        AddRunnable(SystemAlarmDispatcher systemAlarmDispatcher, Intent intent, int i3) {
            this.f54824a = systemAlarmDispatcher;
            this.f54825b = intent;
            this.f54826c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f54824a.a(this.f54825b, this.f54826c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface CommandsCompletedListener {
        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DequeueAndCheckForCompletion implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SystemAlarmDispatcher f54827a;

        DequeueAndCheckForCompletion(SystemAlarmDispatcher systemAlarmDispatcher) {
            this.f54827a = systemAlarmDispatcher;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f54827a.d();
        }
    }

    SystemAlarmDispatcher(Context context) {
        this(context, null, null, null);
    }

    private void b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    private boolean j(String str) {
        b();
        synchronized (this.f54818h) {
            try {
                Iterator it = this.f54818h.iterator();
                while (it.hasNext()) {
                    if (str.equals(((Intent) it.next()).getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void l() {
        b();
        PowerManager.WakeLock wakeLockB = WakeLocks.b(this.f54812a, "ProcessCommand");
        try {
            wakeLockB.acquire();
            this.f54816f.x().d(new Runnable() { // from class: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    Executor executorA;
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    synchronized (SystemAlarmDispatcher.this.f54818h) {
                        SystemAlarmDispatcher systemAlarmDispatcher = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher.f54819i = (Intent) systemAlarmDispatcher.f54818h.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.f54819i;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.f54819i.getIntExtra("KEY_START_ID", 0);
                        Logger loggerE = Logger.e();
                        String str = SystemAlarmDispatcher.f54811m;
                        loggerE.a(str, "Processing command " + SystemAlarmDispatcher.this.f54819i + ", " + intExtra);
                        PowerManager.WakeLock wakeLockB2 = WakeLocks.b(SystemAlarmDispatcher.this.f54812a, action + " (" + intExtra + ")");
                        try {
                            Logger.e().a(str, "Acquiring operation wake lock (" + action + ") " + wakeLockB2);
                            wakeLockB2.acquire();
                            SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher2.f54817g.p(systemAlarmDispatcher2.f54819i, intExtra, systemAlarmDispatcher2);
                            Logger.e().a(str, "Releasing operation wake lock (" + action + ") " + wakeLockB2);
                            wakeLockB2.release();
                            executorA = SystemAlarmDispatcher.this.f54813b.a();
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this);
                        } catch (Throwable th) {
                            try {
                                Logger loggerE2 = Logger.e();
                                String str2 = SystemAlarmDispatcher.f54811m;
                                loggerE2.d(str2, "Unexpected error in onHandleIntent", th);
                                Logger.e().a(str2, "Releasing operation wake lock (" + action + ") " + wakeLockB2);
                                wakeLockB2.release();
                                executorA = SystemAlarmDispatcher.this.f54813b.a();
                                dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this);
                            } catch (Throwable th2) {
                                Logger.e().a(SystemAlarmDispatcher.f54811m, "Releasing operation wake lock (" + action + ") " + wakeLockB2);
                                wakeLockB2.release();
                                SystemAlarmDispatcher.this.f54813b.a().execute(new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this));
                                throw th2;
                            }
                        }
                        executorA.execute(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            wakeLockB.release();
        }
    }

    public boolean a(Intent intent, int i3) {
        Logger loggerE = Logger.e();
        String str = f54811m;
        loggerE.a(str, "Adding command " + intent + " (" + i3 + ")");
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.e().k(str, "Unknown command. Ignoring");
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && j("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i3);
        synchronized (this.f54818h) {
            try {
                boolean zIsEmpty = this.f54818h.isEmpty();
                this.f54818h.add(intent);
                if (zIsEmpty) {
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void c(WorkGenerationalId workGenerationalId, boolean z2) {
        this.f54813b.a().execute(new AddRunnable(this, CommandHandler.d(this.f54812a, workGenerationalId, z2), 0));
    }

    void d() {
        Logger loggerE = Logger.e();
        String str = f54811m;
        loggerE.a(str, "Checking if commands are complete.");
        b();
        synchronized (this.f54818h) {
            try {
                if (this.f54819i != null) {
                    Logger.e().a(str, "Removing command " + this.f54819i);
                    if (!((Intent) this.f54818h.remove(0)).equals(this.f54819i)) {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                    this.f54819i = null;
                }
                SerialExecutor serialExecutorC = this.f54813b.c();
                if (!this.f54817g.o() && this.f54818h.isEmpty() && !serialExecutorC.U0()) {
                    Logger.e().a(str, "No more commands & intents.");
                    CommandsCompletedListener commandsCompletedListener = this.f54820j;
                    if (commandsCompletedListener != null) {
                        commandsCompletedListener.b();
                    }
                } else if (!this.f54818h.isEmpty()) {
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    Processor e() {
        return this.f54815d;
    }

    TaskExecutor f() {
        return this.f54813b;
    }

    WorkManagerImpl g() {
        return this.f54816f;
    }

    WorkTimer h() {
        return this.f54814c;
    }

    WorkLauncher i() {
        return this.f54822l;
    }

    void k() {
        Logger.e().a(f54811m, "Destroying SystemAlarmDispatcher");
        this.f54815d.m(this);
        this.f54820j = null;
    }

    void m(CommandsCompletedListener commandsCompletedListener) {
        if (this.f54820j != null) {
            Logger.e().c(f54811m, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            this.f54820j = commandsCompletedListener;
        }
    }

    SystemAlarmDispatcher(Context context, Processor processor, WorkManagerImpl workManagerImpl, WorkLauncher workLauncher) {
        Context applicationContext = context.getApplicationContext();
        this.f54812a = applicationContext;
        this.f54821k = new StartStopTokens();
        workManagerImpl = workManagerImpl == null ? WorkManagerImpl.r(context) : workManagerImpl;
        this.f54816f = workManagerImpl;
        this.f54817g = new CommandHandler(applicationContext, workManagerImpl.p().a(), this.f54821k);
        this.f54814c = new WorkTimer(workManagerImpl.p().k());
        processor = processor == null ? workManagerImpl.t() : processor;
        this.f54815d = processor;
        TaskExecutor taskExecutorX = workManagerImpl.x();
        this.f54813b = taskExecutorX;
        this.f54822l = workLauncher == null ? new WorkLauncherImpl(processor, taskExecutorX) : workLauncher;
        processor.e(this);
        this.f54818h = new ArrayList();
        this.f54819i = null;
    }
}
