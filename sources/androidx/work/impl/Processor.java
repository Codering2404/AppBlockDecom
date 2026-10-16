package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Processor implements ForegroundProcessor {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f54636l = Logger.i("Processor");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f54638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Configuration f54639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TaskExecutor f54640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WorkDatabase f54641e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map f54643g = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map f54642f = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Set f54645i = new HashSet();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f54646j = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PowerManager.WakeLock f54637a = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f54647k = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map f54644h = new HashMap();

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        this.f54638b = context;
        this.f54639c = configuration;
        this.f54640d = taskExecutor;
        this.f54641e = workDatabase;
    }

    public static /* synthetic */ WorkSpec b(Processor processor, ArrayList arrayList, String str) {
        arrayList.addAll(processor.f54641e.u().a(str));
        return processor.f54641e.t().l(str);
    }

    public static /* synthetic */ void c(Processor processor, WorkGenerationalId workGenerationalId, boolean z2) {
        synchronized (processor.f54647k) {
            try {
                Iterator it = processor.f54646j.iterator();
                while (it.hasNext()) {
                    ((ExecutionListener) it.next()).c(workGenerationalId, z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(Processor processor, ListenableFuture listenableFuture, WorkerWrapper workerWrapper) {
        boolean zBooleanValue;
        processor.getClass();
        try {
            zBooleanValue = ((Boolean) listenableFuture.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            zBooleanValue = true;
        }
        processor.l(workerWrapper, zBooleanValue);
    }

    private WorkerWrapper f(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.f54642f.remove(str);
        boolean z2 = workerWrapper != null;
        if (!z2) {
            workerWrapper = (WorkerWrapper) this.f54643g.remove(str);
        }
        this.f54644h.remove(str);
        if (z2) {
            r();
        }
        return workerWrapper;
    }

    private WorkerWrapper h(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.f54642f.get(str);
        return workerWrapper == null ? (WorkerWrapper) this.f54643g.get(str) : workerWrapper;
    }

    private static boolean i(String str, WorkerWrapper workerWrapper, int i3) {
        if (workerWrapper == null) {
            Logger.e().a(f54636l, "WorkerWrapper could not be found for " + str);
            return false;
        }
        workerWrapper.g(i3);
        Logger.e().a(f54636l, "WorkerWrapper interrupted for " + str);
        return true;
    }

    private void l(WorkerWrapper workerWrapper, boolean z2) {
        synchronized (this.f54647k) {
            try {
                WorkGenerationalId workGenerationalIdD = workerWrapper.d();
                String strB = workGenerationalIdD.b();
                if (h(strB) == workerWrapper) {
                    f(strB);
                }
                Logger.e().a(f54636l, getClass().getSimpleName() + " " + strB + " executed; reschedule = " + z2);
                Iterator it = this.f54646j.iterator();
                while (it.hasNext()) {
                    ((ExecutionListener) it.next()).c(workGenerationalIdD, z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void n(final WorkGenerationalId workGenerationalId, final boolean z2) {
        this.f54640d.a().execute(new Runnable() { // from class: androidx.work.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                Processor.c(this.f54850a, workGenerationalId, z2);
            }
        });
    }

    private void r() {
        synchronized (this.f54647k) {
            try {
                if (this.f54642f.isEmpty()) {
                    try {
                        this.f54638b.startService(SystemForegroundDispatcher.g(this.f54638b));
                    } catch (Throwable th) {
                        Logger.e().d(f54636l, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.f54637a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.f54637a = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void a(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.f54647k) {
            try {
                Logger.e().f(f54636l, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper workerWrapper = (WorkerWrapper) this.f54643g.remove(str);
                if (workerWrapper != null) {
                    if (this.f54637a == null) {
                        PowerManager.WakeLock wakeLockB = WakeLocks.b(this.f54638b, "ProcessorForegroundLck");
                        this.f54637a = wakeLockB;
                        wakeLockB.acquire();
                    }
                    this.f54642f.put(str, workerWrapper);
                    ContextCompat.startForegroundService(this.f54638b, SystemForegroundDispatcher.f(this.f54638b, workerWrapper.d(), foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(ExecutionListener executionListener) {
        synchronized (this.f54647k) {
            this.f54646j.add(executionListener);
        }
    }

    public WorkSpec g(String str) {
        synchronized (this.f54647k) {
            try {
                WorkerWrapper workerWrapperH = h(str);
                if (workerWrapperH == null) {
                    return null;
                }
                return workerWrapperH.e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean j(String str) {
        boolean zContains;
        synchronized (this.f54647k) {
            zContains = this.f54645i.contains(str);
        }
        return zContains;
    }

    public boolean k(String str) {
        boolean z2;
        synchronized (this.f54647k) {
            z2 = h(str) != null;
        }
        return z2;
    }

    public void m(ExecutionListener executionListener) {
        synchronized (this.f54647k) {
            this.f54646j.remove(executionListener);
        }
    }

    public boolean o(StartStopToken startStopToken) {
        return p(startStopToken, null);
    }

    public boolean p(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) throws Throwable {
        Throwable th;
        WorkGenerationalId workGenerationalIdA = startStopToken.a();
        final String strB = workGenerationalIdA.b();
        final ArrayList arrayList = new ArrayList();
        WorkSpec workSpec = (WorkSpec) this.f54641e.runInTransaction(new Callable() { // from class: androidx.work.impl.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Processor.b(this.f54739a, arrayList, strB);
            }
        });
        if (workSpec == null) {
            Logger.e().k(f54636l, "Didn't find WorkSpec for id " + workGenerationalIdA);
            n(workGenerationalIdA, false);
            return false;
        }
        synchronized (this.f54647k) {
            try {
                try {
                    try {
                        if (k(strB)) {
                            Set set = (Set) this.f54644h.get(strB);
                            if (((StartStopToken) set.iterator().next()).a().a() == workGenerationalIdA.a()) {
                                set.add(startStopToken);
                                Logger.e().a(f54636l, "Work " + workGenerationalIdA + " is already enqueued for processing");
                            } else {
                                n(workGenerationalIdA, false);
                            }
                            return false;
                        }
                        if (workSpec.f() != workGenerationalIdA.a()) {
                            n(workGenerationalIdA, false);
                            return false;
                        }
                        final WorkerWrapper workerWrapperB = new WorkerWrapper.Builder(this.f54638b, this.f54639c, this.f54640d, this, this.f54641e, workSpec, arrayList).c(runtimeExtras).b();
                        final ListenableFuture listenableFutureC = workerWrapperB.c();
                        listenableFutureC.addListener(new Runnable() { // from class: androidx.work.impl.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                Processor.d(this.f54742a, listenableFutureC, workerWrapperB);
                            }
                        }, this.f54640d.a());
                        this.f54643g.put(strB, workerWrapperB);
                        HashSet hashSet = new HashSet();
                        hashSet.add(startStopToken);
                        this.f54644h.put(strB, hashSet);
                        this.f54640d.c().execute(workerWrapperB);
                        Logger.e().a(f54636l, getClass().getSimpleName() + ": processing " + workGenerationalIdA);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
            th = th;
            throw th;
        }
    }

    public boolean q(String str, int i3) {
        WorkerWrapper workerWrapperF;
        synchronized (this.f54647k) {
            Logger.e().a(f54636l, "Processor cancelling " + str);
            this.f54645i.add(str);
            workerWrapperF = f(str);
        }
        return i(str, workerWrapperF, i3);
    }

    public boolean s(StartStopToken startStopToken, int i3) {
        WorkerWrapper workerWrapperF;
        String strB = startStopToken.a().b();
        synchronized (this.f54647k) {
            workerWrapperF = f(strB);
        }
        return i(strB, workerWrapperF, i3);
    }

    public boolean t(StartStopToken startStopToken, int i3) {
        String strB = startStopToken.a().b();
        synchronized (this.f54647k) {
            try {
                if (this.f54642f.get(strB) == null) {
                    Set set = (Set) this.f54644h.get(strB);
                    if (set != null && set.contains(startStopToken)) {
                        return i(strB, f(strB), i3);
                    }
                    return false;
                }
                Logger.e().a(f54636l, "Ignored stopWork. WorkerWrapper " + strB + " is in foreground");
                return false;
            } finally {
            }
        }
    }
}
