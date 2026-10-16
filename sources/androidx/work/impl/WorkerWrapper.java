package androidx.work.impl;

import android.content.Context;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkerWrapper implements Runnable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final String f54707t = Logger.i("WorkerWrapper");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f54708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f54709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WorkerParameters.RuntimeExtras f54710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    WorkSpec f54711d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ListenableWorker f54712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    TaskExecutor f54713g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Configuration f54715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Clock f54716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ForegroundProcessor f54717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private WorkDatabase f54718l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private WorkSpecDao f54719m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private DependencyDao f54720n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f54721o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f54722p;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ListenableWorker.Result f54714h = ListenableWorker.Result.a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    SettableFuture f54723q = SettableFuture.s();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final SettableFuture f54724r = SettableFuture.s();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile int f54725s = -256;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f54730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ListenableWorker f54731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ForegroundProcessor f54732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TaskExecutor f54733d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Configuration f54734e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        WorkDatabase f54735f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        WorkSpec f54736g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final List f54737h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        WorkerParameters.RuntimeExtras f54738i = new WorkerParameters.RuntimeExtras();

        public Builder(Context context, Configuration configuration, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, WorkSpec workSpec, List list) {
            this.f54730a = context.getApplicationContext();
            this.f54733d = taskExecutor;
            this.f54732c = foregroundProcessor;
            this.f54734e = configuration;
            this.f54735f = workDatabase;
            this.f54736g = workSpec;
            this.f54737h = list;
        }

        public WorkerWrapper b() {
            return new WorkerWrapper(this);
        }

        public Builder c(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.f54738i = runtimeExtras;
            }
            return this;
        }
    }

    WorkerWrapper(Builder builder) {
        this.f54708a = builder.f54730a;
        this.f54713g = builder.f54733d;
        this.f54717k = builder.f54732c;
        WorkSpec workSpec = builder.f54736g;
        this.f54711d = workSpec;
        this.f54709b = workSpec.f55013a;
        this.f54710c = builder.f54738i;
        this.f54712f = builder.f54731b;
        Configuration configuration = builder.f54734e;
        this.f54715i = configuration;
        this.f54716j = configuration.a();
        WorkDatabase workDatabase = builder.f54735f;
        this.f54718l = workDatabase;
        this.f54719m = workDatabase.t();
        this.f54720n = this.f54718l.n();
        this.f54721o = builder.f54737h;
    }

    public static /* synthetic */ void a(WorkerWrapper workerWrapper, ListenableFuture listenableFuture) {
        if (workerWrapper.f54724r.isCancelled()) {
            listenableFuture.cancel(true);
        }
    }

    private String b(List list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f54709b);
        sb.append(", tags={ ");
        Iterator it = list.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    private void f(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.e().f(f54707t, "Worker result SUCCESS for " + this.f54722p);
            if (this.f54711d.m()) {
                k();
                return;
            } else {
                p();
                return;
            }
        }
        if (result instanceof ListenableWorker.Result.Retry) {
            Logger.e().f(f54707t, "Worker result RETRY for " + this.f54722p);
            j();
            return;
        }
        Logger.e().f(f54707t, "Worker result FAILURE for " + this.f54722p);
        if (this.f54711d.m()) {
            k();
        } else {
            o();
        }
    }

    private void h(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f54719m.k(str2) != WorkInfo.State.CANCELLED) {
                this.f54719m.v(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.f54720n.b(str2));
        }
    }

    private void j() {
        this.f54718l.beginTransaction();
        try {
            this.f54719m.v(WorkInfo.State.ENQUEUED, this.f54709b);
            this.f54719m.x(this.f54709b, this.f54716j.currentTimeMillis());
            this.f54719m.H(this.f54709b, this.f54711d.h());
            this.f54719m.s(this.f54709b, -1L);
            this.f54718l.setTransactionSuccessful();
        } finally {
            this.f54718l.endTransaction();
            l(true);
        }
    }

    private void k() {
        this.f54718l.beginTransaction();
        try {
            this.f54719m.x(this.f54709b, this.f54716j.currentTimeMillis());
            this.f54719m.v(WorkInfo.State.ENQUEUED, this.f54709b);
            this.f54719m.C(this.f54709b);
            this.f54719m.H(this.f54709b, this.f54711d.h());
            this.f54719m.e(this.f54709b);
            this.f54719m.s(this.f54709b, -1L);
            this.f54718l.setTransactionSuccessful();
        } finally {
            this.f54718l.endTransaction();
            l(false);
        }
    }

    private void l(boolean z2) {
        this.f54718l.beginTransaction();
        try {
            if (!this.f54718l.t().A()) {
                PackageManagerHelper.c(this.f54708a, RescheduleReceiver.class, false);
            }
            if (z2) {
                this.f54719m.v(WorkInfo.State.ENQUEUED, this.f54709b);
                this.f54719m.a(this.f54709b, this.f54725s);
                this.f54719m.s(this.f54709b, -1L);
            }
            this.f54718l.setTransactionSuccessful();
            this.f54718l.endTransaction();
            this.f54723q.o(Boolean.valueOf(z2));
        } catch (Throwable th) {
            this.f54718l.endTransaction();
            throw th;
        }
    }

    private void m() {
        WorkInfo.State stateK = this.f54719m.k(this.f54709b);
        if (stateK == WorkInfo.State.RUNNING) {
            Logger.e().a(f54707t, "Status for " + this.f54709b + " is RUNNING; not doing any work and rescheduling for later execution");
            l(true);
            return;
        }
        Logger.e().a(f54707t, "Status for " + this.f54709b + " is " + stateK + " ; not doing any work");
        l(false);
    }

    private void n() {
        Data dataA;
        if (q()) {
            return;
        }
        this.f54718l.beginTransaction();
        try {
            WorkSpec workSpec = this.f54711d;
            if (workSpec.f55014b != WorkInfo.State.ENQUEUED) {
                m();
                this.f54718l.setTransactionSuccessful();
                Logger.e().a(f54707t, this.f54711d.f55015c + " is not in ENQUEUED state. Nothing more to do");
                return;
            }
            if ((workSpec.m() || this.f54711d.l()) && this.f54716j.currentTimeMillis() < this.f54711d.c()) {
                Logger.e().a(f54707t, String.format("Delaying execution for %s because it is being executed before schedule.", this.f54711d.f55015c));
                l(true);
                this.f54718l.setTransactionSuccessful();
                return;
            }
            this.f54718l.setTransactionSuccessful();
            this.f54718l.endTransaction();
            if (this.f54711d.m()) {
                dataA = this.f54711d.f55017e;
            } else {
                InputMerger inputMergerB = this.f54715i.f().b(this.f54711d.f55016d);
                if (inputMergerB == null) {
                    Logger.e().c(f54707t, "Could not create Input Merger " + this.f54711d.f55016d);
                    o();
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f54711d.f55017e);
                arrayList.addAll(this.f54719m.o(this.f54709b));
                dataA = inputMergerB.a(arrayList);
            }
            Data data = dataA;
            UUID uuidFromString = UUID.fromString(this.f54709b);
            List list = this.f54721o;
            WorkerParameters.RuntimeExtras runtimeExtras = this.f54710c;
            WorkSpec workSpec2 = this.f54711d;
            WorkerParameters workerParameters = new WorkerParameters(uuidFromString, data, list, runtimeExtras, workSpec2.f55023k, workSpec2.f(), this.f54715i.d(), this.f54713g, this.f54715i.n(), new WorkProgressUpdater(this.f54718l, this.f54713g), new WorkForegroundUpdater(this.f54718l, this.f54717k, this.f54713g));
            if (this.f54712f == null) {
                this.f54712f = this.f54715i.n().b(this.f54708a, this.f54711d.f55015c, workerParameters);
            }
            ListenableWorker listenableWorker = this.f54712f;
            if (listenableWorker == null) {
                Logger.e().c(f54707t, "Could not create Worker " + this.f54711d.f55015c);
                o();
                return;
            }
            if (listenableWorker.isUsed()) {
                Logger.e().c(f54707t, "Received an already-used Worker " + this.f54711d.f55015c + "; Worker Factory should return new instances");
                o();
                return;
            }
            this.f54712f.setUsed();
            if (!r()) {
                m();
                return;
            }
            if (q()) {
                return;
            }
            WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.f54708a, this.f54711d, this.f54712f, workerParameters.b(), this.f54713g);
            this.f54713g.a().execute(workForegroundRunnable);
            final ListenableFuture listenableFutureB = workForegroundRunnable.b();
            this.f54724r.addListener(new Runnable() { // from class: androidx.work.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    WorkerWrapper.a(this.f54965a, listenableFutureB);
                }
            }, new SynchronousExecutor());
            listenableFutureB.addListener(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (WorkerWrapper.this.f54724r.isCancelled()) {
                        return;
                    }
                    try {
                        listenableFutureB.get();
                        Logger.e().a(WorkerWrapper.f54707t, "Starting work for " + WorkerWrapper.this.f54711d.f55015c);
                        WorkerWrapper workerWrapper = WorkerWrapper.this;
                        workerWrapper.f54724r.q(workerWrapper.f54712f.startWork());
                    } catch (Throwable th) {
                        WorkerWrapper.this.f54724r.p(th);
                    }
                }
            }, this.f54713g.a());
            final String str = this.f54722p;
            this.f54724r.addListener(new Runnable() { // from class: androidx.work.impl.WorkerWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            ListenableWorker.Result result = (ListenableWorker.Result) WorkerWrapper.this.f54724r.get();
                            if (result == null) {
                                Logger.e().c(WorkerWrapper.f54707t, WorkerWrapper.this.f54711d.f55015c + " returned a null result. Treating it as a failure.");
                            } else {
                                Logger.e().a(WorkerWrapper.f54707t, WorkerWrapper.this.f54711d.f55015c + " returned a " + result + ".");
                                WorkerWrapper.this.f54714h = result;
                            }
                            WorkerWrapper.this.i();
                        } catch (InterruptedException e3) {
                            e = e3;
                            Logger.e().d(WorkerWrapper.f54707t, str + " failed because it threw an exception/error", e);
                            WorkerWrapper.this.i();
                        } catch (CancellationException e4) {
                            Logger.e().g(WorkerWrapper.f54707t, str + " was cancelled", e4);
                            WorkerWrapper.this.i();
                        } catch (ExecutionException e5) {
                            e = e5;
                            Logger.e().d(WorkerWrapper.f54707t, str + " failed because it threw an exception/error", e);
                            WorkerWrapper.this.i();
                        }
                    } catch (Throwable th) {
                        WorkerWrapper.this.i();
                        throw th;
                    }
                }
            }, this.f54713g.c());
        } finally {
            this.f54718l.endTransaction();
        }
    }

    private void p() {
        this.f54718l.beginTransaction();
        try {
            this.f54719m.v(WorkInfo.State.SUCCEEDED, this.f54709b);
            this.f54719m.w(this.f54709b, ((ListenableWorker.Result.Success) this.f54714h).e());
            long jCurrentTimeMillis = this.f54716j.currentTimeMillis();
            for (String str : this.f54720n.b(this.f54709b)) {
                if (this.f54719m.k(str) == WorkInfo.State.BLOCKED && this.f54720n.c(str)) {
                    Logger.e().f(f54707t, "Setting status to enqueued for " + str);
                    this.f54719m.v(WorkInfo.State.ENQUEUED, str);
                    this.f54719m.x(str, jCurrentTimeMillis);
                }
            }
            this.f54718l.setTransactionSuccessful();
            this.f54718l.endTransaction();
            l(false);
        } catch (Throwable th) {
            this.f54718l.endTransaction();
            l(false);
            throw th;
        }
    }

    private boolean q() {
        if (this.f54725s == -256) {
            return false;
        }
        Logger.e().a(f54707t, "Work interrupted for " + this.f54722p);
        if (this.f54719m.k(this.f54709b) == null) {
            l(false);
        } else {
            l(!r0.b());
        }
        return true;
    }

    private boolean r() {
        boolean z2;
        this.f54718l.beginTransaction();
        try {
            if (this.f54719m.k(this.f54709b) == WorkInfo.State.ENQUEUED) {
                this.f54719m.v(WorkInfo.State.RUNNING, this.f54709b);
                this.f54719m.F(this.f54709b);
                this.f54719m.a(this.f54709b, -256);
                z2 = true;
            } else {
                z2 = false;
            }
            this.f54718l.setTransactionSuccessful();
            this.f54718l.endTransaction();
            return z2;
        } catch (Throwable th) {
            this.f54718l.endTransaction();
            throw th;
        }
    }

    public ListenableFuture c() {
        return this.f54723q;
    }

    public WorkGenerationalId d() {
        return WorkSpecKt.a(this.f54711d);
    }

    public WorkSpec e() {
        return this.f54711d;
    }

    public void g(int i3) {
        this.f54725s = i3;
        q();
        this.f54724r.cancel(true);
        if (this.f54712f != null && this.f54724r.isCancelled()) {
            this.f54712f.stop(i3);
            return;
        }
        Logger.e().a(f54707t, "WorkSpec " + this.f54711d + " is already done. Not interrupting.");
    }

    void i() {
        if (q()) {
            return;
        }
        this.f54718l.beginTransaction();
        try {
            WorkInfo.State stateK = this.f54719m.k(this.f54709b);
            this.f54718l.s().c(this.f54709b);
            if (stateK == null) {
                l(false);
            } else if (stateK == WorkInfo.State.RUNNING) {
                f(this.f54714h);
            } else if (!stateK.b()) {
                this.f54725s = -512;
                j();
            }
            this.f54718l.setTransactionSuccessful();
            this.f54718l.endTransaction();
        } catch (Throwable th) {
            this.f54718l.endTransaction();
            throw th;
        }
    }

    void o() {
        this.f54718l.beginTransaction();
        try {
            h(this.f54709b);
            Data dataE = ((ListenableWorker.Result.Failure) this.f54714h).e();
            this.f54719m.H(this.f54709b, this.f54711d.h());
            this.f54719m.w(this.f54709b, dataE);
            this.f54718l.setTransactionSuccessful();
        } finally {
            this.f54718l.endTransaction();
            l(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f54722p = b(this.f54721o);
        n();
    }
}
