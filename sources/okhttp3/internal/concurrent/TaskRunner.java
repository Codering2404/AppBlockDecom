package okhttp3.internal.concurrent;

import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class TaskRunner {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f144397h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final TaskRunner f144398i = new TaskRunner(new RealBackend(Util.N(Intrinsics.stringPlus(Util.f144282i, " TaskRunner"), true)));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Logger f144399j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Backend f144400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f144401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f144402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f144403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f144404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f144405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f144406g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Backend {
        void a(TaskRunner taskRunner);

        long b();

        void c(TaskRunner taskRunner, long j3);

        void execute(Runnable runnable);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger a() {
            return TaskRunner.f144399j;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RealBackend implements Backend {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f144407a;

        public RealBackend(ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.f144407a = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void a(TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public long b() {
            return System.nanoTime();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void c(TaskRunner taskRunner, long j3) throws InterruptedException {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            long j4 = j3 / 1000000;
            long j5 = j3 - (1000000 * j4);
            if (j4 > 0 || j3 > 0) {
                taskRunner.wait(j4, (int) j5);
            }
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.f144407a.execute(runnable);
        }
    }

    static {
        Logger logger = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(TaskRunner::class.java.name)");
        f144399j = logger;
    }

    public TaskRunner(Backend backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.f144400a = backend;
        this.f144401b = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
        this.f144404e = new ArrayList();
        this.f144405f = new ArrayList();
        this.f144406g = new Runnable() { // from class: okhttp3.internal.concurrent.TaskRunner$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                Task taskD;
                long jB;
                while (true) {
                    TaskRunner taskRunner = this.f144408a;
                    synchronized (taskRunner) {
                        taskD = taskRunner.d();
                    }
                    if (taskD == null) {
                        return;
                    }
                    TaskQueue taskQueueD = taskD.d();
                    Intrinsics.checkNotNull(taskQueueD);
                    TaskRunner taskRunner2 = this.f144408a;
                    boolean zIsLoggable = TaskRunner.f144397h.a().isLoggable(Level.FINE);
                    if (zIsLoggable) {
                        jB = taskQueueD.h().g().b();
                        TaskLoggerKt.c(taskD, taskQueueD, "starting");
                    } else {
                        jB = -1;
                    }
                    try {
                        try {
                            taskRunner2.j(taskD);
                            Unit unit = Unit.f139807a;
                            if (zIsLoggable) {
                                TaskLoggerKt.c(taskD, taskQueueD, Intrinsics.stringPlus("finished run in ", TaskLoggerKt.b(taskQueueD.h().g().b() - jB)));
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        if (zIsLoggable) {
                            TaskLoggerKt.c(taskD, taskQueueD, Intrinsics.stringPlus("failed a run in ", TaskLoggerKt.b(taskQueueD.h().g().b() - jB)));
                        }
                        throw th;
                    }
                }
            }
        };
    }

    private final void c(Task task, long j3) {
        if (Util.f144281h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        TaskQueue taskQueueD = task.d();
        Intrinsics.checkNotNull(taskQueueD);
        if (taskQueueD.c() != task) {
            throw new IllegalStateException("Check failed.");
        }
        boolean zD = taskQueueD.d();
        taskQueueD.m(false);
        taskQueueD.l(null);
        this.f144404e.remove(taskQueueD);
        if (j3 != -1 && !zD && !taskQueueD.g()) {
            taskQueueD.k(task, j3, true);
        }
        if (taskQueueD.e().isEmpty()) {
            return;
        }
        this.f144405f.add(taskQueueD);
    }

    private final void e(Task task) {
        if (Util.f144281h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        task.g(-1L);
        TaskQueue taskQueueD = task.d();
        Intrinsics.checkNotNull(taskQueueD);
        taskQueueD.e().remove(task);
        this.f144405f.remove(taskQueueD);
        taskQueueD.l(task);
        this.f144404e.add(taskQueueD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Task task) {
        if (Util.f144281h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(task.b());
        try {
            long jF = task.f();
            synchronized (this) {
                c(task, jF);
                Unit unit = Unit.f139807a;
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th) {
            synchronized (this) {
                c(task, -1L);
                Unit unit2 = Unit.f139807a;
                threadCurrentThread.setName(name);
                throw th;
            }
        }
    }

    public final Task d() {
        boolean z2;
        if (Util.f144281h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        while (!this.f144405f.isEmpty()) {
            long jB = this.f144400a.b();
            Iterator it = this.f144405f.iterator();
            long jMin = Long.MAX_VALUE;
            Task task = null;
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                Task task2 = (Task) ((TaskQueue) it.next()).e().get(0);
                long jMax = Math.max(0L, task2.c() - jB);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (task != null) {
                        z2 = true;
                        break;
                    }
                    task = task2;
                }
            }
            if (task != null) {
                e(task);
                if (z2 || (!this.f144402c && !this.f144405f.isEmpty())) {
                    this.f144400a.execute(this.f144406g);
                }
                return task;
            }
            if (this.f144402c) {
                if (jMin < this.f144403d - jB) {
                    this.f144400a.a(this);
                }
                return null;
            }
            this.f144402c = true;
            this.f144403d = jB + jMin;
            try {
                try {
                    this.f144400a.c(this, jMin);
                } catch (InterruptedException unused) {
                    f();
                }
            } finally {
                this.f144402c = false;
            }
        }
        return null;
    }

    public final void f() {
        int size = this.f144404e.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                ((TaskQueue) this.f144404e.get(size)).b();
                if (i3 < 0) {
                    break;
                } else {
                    size = i3;
                }
            }
        }
        int size2 = this.f144405f.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i4 = size2 - 1;
            TaskQueue taskQueue = (TaskQueue) this.f144405f.get(size2);
            taskQueue.b();
            if (taskQueue.e().isEmpty()) {
                this.f144405f.remove(size2);
            }
            if (i4 < 0) {
                return;
            } else {
                size2 = i4;
            }
        }
    }

    public final Backend g() {
        return this.f144400a;
    }

    public final void h(TaskQueue taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        if (Util.f144281h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (taskQueue.c() == null) {
            if (taskQueue.e().isEmpty()) {
                this.f144405f.remove(taskQueue);
            } else {
                Util.c(this.f144405f, taskQueue);
            }
        }
        if (this.f144402c) {
            this.f144400a.a(this);
        } else {
            this.f144400a.execute(this.f144406g);
        }
    }

    public final TaskQueue i() {
        int i3;
        synchronized (this) {
            i3 = this.f144401b;
            this.f144401b = i3 + 1;
        }
        return new TaskQueue(this, Intrinsics.stringPlus("Q", Integer.valueOf(i3)));
    }
}
