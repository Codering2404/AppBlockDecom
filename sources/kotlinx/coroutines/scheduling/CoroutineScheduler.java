package kotlinx.coroutines.scheduling;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

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
public final class CoroutineScheduler implements Executor, Closeable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f142511i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f142512j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f142513k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142514l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Symbol f142515m = new Symbol("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f142516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f142517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f142518c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f142519d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GlobalQueue f142520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GlobalQueue f142521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ResizableAtomicArray f142522h;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f142523a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.f142535c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.f142534b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.f142533a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.f142536d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.f142537f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f142523a = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WorkerState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final WorkerState f142533a = new WorkerState("CPU_ACQUIRED", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final WorkerState f142534b = new WorkerState("BLOCKING", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final WorkerState f142535c = new WorkerState("PARKING", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final WorkerState f142536d = new WorkerState("DORMANT", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final WorkerState f142537f = new WorkerState("TERMINATED", 4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ WorkerState[] f142538g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f142539h;

        static {
            WorkerState[] workerStateArrA = a();
            f142538g = workerStateArrA;
            f142539h = EnumEntriesKt.a(workerStateArrA);
        }

        private WorkerState(String str, int i3) {
        }

        private static final /* synthetic */ WorkerState[] a() {
            return new WorkerState[]{f142533a, f142534b, f142535c, f142536d, f142537f};
        }

        public static WorkerState valueOf(String str) {
            return (WorkerState) Enum.valueOf(WorkerState.class, str);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) f142538g.clone();
        }
    }

    public CoroutineScheduler(int i3, int i4, long j3, String str) {
        this.f142516a = i3;
        this.f142517b = i4;
        this.f142518c = j3;
        this.f142519d = str;
        if (i3 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i3 + " should be at least 1").toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should be greater than or equals to core pool size " + i3).toString());
        }
        if (i4 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j3 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j3 + " must be positive").toString());
        }
        this.f142520f = new GlobalQueue();
        this.f142521g = new GlobalQueue();
        this.f142522h = new ResizableAtomicArray((i3 + 1) * 2);
        this.controlState$volatile = ((long) i3) << 42;
        this._isTerminated$volatile = 0;
    }

    private final Worker C() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f142512j;
        while (true) {
            long j3 = atomicLongFieldUpdater.get(this);
            Worker worker = (Worker) this.f142522h.b((int) (2097151 & j3));
            if (worker == null) {
                return null;
            }
            long j4 = (2097152 + j3) & (-2097152);
            int iZ = z(worker);
            if (iZ >= 0 && f142512j.compareAndSet(this, j3, ((long) iZ) | j4)) {
                worker.o(f142515m);
                return worker;
            }
        }
    }

    private final void M(long j3, boolean z2) {
        if (z2 || g0() || V(j3)) {
            return;
        }
        g0();
    }

    private final Task O(Worker worker, Task task, boolean z2) {
        WorkerState workerState;
        if (worker == null || (workerState = worker.f142527c) == WorkerState.f142537f) {
            return task;
        }
        if (!task.f142550b && workerState == WorkerState.f142534b) {
            return task;
        }
        worker.f142531h = true;
        return worker.f142525a.a(task, z2);
    }

    private final boolean V(long j3) {
        if (RangesKt.f(((int) (2097151 & j3)) - ((int) ((j3 & 4398044413952L) >> 21)), 0) < this.f142516a) {
            int iC = c();
            if (iC == 1 && this.f142516a > 1) {
                c();
            }
            if (iC > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean b(Task task) {
        return task.f142550b ? this.f142521g.a(task) : this.f142520f.a(task);
    }

    private final int c() {
        synchronized (this.f142522h) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j3 = f142513k.get(this);
                int i3 = (int) (j3 & 2097151);
                int iF = RangesKt.f(i3 - ((int) ((j3 & 4398044413952L) >> 21)), 0);
                if (iF >= this.f142516a) {
                    return 0;
                }
                if (i3 >= this.f142517b) {
                    return 0;
                }
                int i4 = ((int) (l().get(this) & 2097151)) + 1;
                if (i4 <= 0 || this.f142522h.b(i4) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                Worker worker = new Worker(this, i4);
                this.f142522h.c(i4, worker);
                if (i4 != ((int) (2097151 & f142513k.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i5 = iF + 1;
                worker.start();
                return i5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* synthetic */ boolean e0(CoroutineScheduler coroutineScheduler, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = f142513k.get(coroutineScheduler);
        }
        return coroutineScheduler.V(j3);
    }

    private final boolean g0() {
        Worker workerC;
        do {
            workerC = C();
            if (workerC == null) {
                return false;
            }
        } while (!Worker.f142524j.compareAndSet(workerC, -1, 0));
        LockSupport.unpark(workerC);
        return true;
    }

    private final Worker i() {
        Thread threadCurrentThread = Thread.currentThread();
        Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public static /* synthetic */ void k(CoroutineScheduler coroutineScheduler, Runnable runnable, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        coroutineScheduler.j(runnable, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater l() {
        return f142513k;
    }

    private final int z(Worker worker) {
        Object objG = worker.g();
        while (objG != f142515m) {
            if (objG == null) {
                return 0;
            }
            Worker worker2 = (Worker) objG;
            int iF = worker2.f();
            if (iF != 0) {
                return iF;
            }
            objG = worker2.g();
        }
        return -1;
    }

    public final boolean F(Worker worker) {
        long j3;
        int iF;
        if (worker.g() != f142515m) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f142512j;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            iF = worker.f();
            worker.o(this.f142522h.b((int) (2097151 & j3)));
        } while (!f142512j.compareAndSet(this, j3, ((2097152 + j3) & (-2097152)) | ((long) iF)));
        return true;
    }

    public final void J(Worker worker, int i3, int i4) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f142512j;
        while (true) {
            long j3 = atomicLongFieldUpdater.get(this);
            int iZ = (int) (2097151 & j3);
            long j4 = (2097152 + j3) & (-2097152);
            if (iZ == i3) {
                iZ = i4 == 0 ? z(worker) : i4;
            }
            if (iZ >= 0) {
                if (f142512j.compareAndSet(this, j3, j4 | ((long) iZ))) {
                    return;
                }
            }
        }
    }

    public final void K(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
                if (abstractTimeSource != null) {
                    abstractTimeSource.e();
                }
            } finally {
                AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.f140870a;
                if (abstractTimeSource2 != null) {
                    abstractTimeSource2.e();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void L(long r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = r()
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Ld
            return
        Ld:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = r7.i()
            kotlinx.coroutines.internal.ResizableAtomicArray r1 = r7.f142522h
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = a()     // Catch: java.lang.Throwable -> L8f
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L8f
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r3 = (int) r3
            monitor-exit(r1)
            if (r2 > r3) goto L4d
            r1 = r2
        L25:
            kotlinx.coroutines.internal.ResizableAtomicArray r4 = r7.f142522h
            java.lang.Object r4 = r4.b(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r4
            if (r4 == r0) goto L48
        L32:
            java.lang.Thread$State r5 = r4.getState()
            java.lang.Thread$State r6 = java.lang.Thread.State.TERMINATED
            if (r5 == r6) goto L41
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r8)
            goto L32
        L41:
            kotlinx.coroutines.scheduling.WorkQueue r4 = r4.f142525a
            kotlinx.coroutines.scheduling.GlobalQueue r5 = r7.f142521g
            r4.j(r5)
        L48:
            if (r1 == r3) goto L4d
            int r1 = r1 + 1
            goto L25
        L4d:
            kotlinx.coroutines.scheduling.GlobalQueue r8 = r7.f142521g
            r8.b()
            kotlinx.coroutines.scheduling.GlobalQueue r8 = r7.f142520f
            r8.b()
        L57:
            if (r0 == 0) goto L5f
            kotlinx.coroutines.scheduling.Task r8 = r0.e(r2)
            if (r8 != 0) goto L8b
        L5f:
            kotlinx.coroutines.scheduling.GlobalQueue r8 = r7.f142520f
            java.lang.Object r8 = r8.e()
            kotlinx.coroutines.scheduling.Task r8 = (kotlinx.coroutines.scheduling.Task) r8
            if (r8 != 0) goto L8b
            kotlinx.coroutines.scheduling.GlobalQueue r8 = r7.f142521g
            java.lang.Object r8 = r8.e()
            kotlinx.coroutines.scheduling.Task r8 = (kotlinx.coroutines.scheduling.Task) r8
            if (r8 != 0) goto L8b
            if (r0 == 0) goto L7a
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r8 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.f142537f
            r0.r(r8)
        L7a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = m()
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = l()
            r8.set(r7, r0)
            return
        L8b:
            r7.K(r8)
            goto L57
        L8f:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.L(long):void");
    }

    public final void N() {
        if (g0() || e0(this, 0L, 1, null)) {
            return;
        }
        g0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        L(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        k(this, runnable, false, false, 6, null);
    }

    public final Task f(Runnable runnable, boolean z2) {
        long jA = TasksKt.f142557f.a();
        if (!(runnable instanceof Task)) {
            return TasksKt.b(runnable, jA, z2);
        }
        Task task = (Task) runnable;
        task.f142549a = jA;
        task.f142550b = z2;
        return task;
    }

    public final boolean isTerminated() {
        return f142514l.get(this) != 0;
    }

    public final void j(Runnable runnable, boolean z2, boolean z3) {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
        if (abstractTimeSource != null) {
            abstractTimeSource.d();
        }
        Task taskF = f(runnable, z2);
        boolean z4 = taskF.f142550b;
        long jAddAndGet = z4 ? f142513k.addAndGet(this, 2097152L) : 0L;
        Worker workerI = i();
        Task taskO = O(workerI, taskF, z3);
        if (taskO != null && !b(taskO)) {
            throw new RejectedExecutionException(this.f142519d + " was terminated");
        }
        boolean z5 = z3 && workerI != null;
        if (z4) {
            M(jAddAndGet, z5);
        } else {
            if (z5) {
                return;
            }
            N();
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f142522h.a();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < iA; i8++) {
            Worker worker = (Worker) this.f142522h.b(i8);
            if (worker != null) {
                int i9 = worker.f142525a.i();
                int i10 = WhenMappings.f142523a[worker.f142527c.ordinal()];
                if (i10 == 1) {
                    i5++;
                } else if (i10 == 2) {
                    i4++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i9);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i10 == 3) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i9);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i10 == 4) {
                    i6++;
                    if (i9 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i9);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (i10 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i7++;
                }
            }
        }
        long j3 = f142513k.get(this);
        return this.f142519d + '@' + DebugStringsKt.b(this) + "[Pool Size {core = " + this.f142516a + ", max = " + this.f142517b + "}, Worker States {CPU = " + i3 + ", blocking = " + i4 + ", parked = " + i5 + ", dormant = " + i6 + ", terminated = " + i7 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f142520f.c() + ", global blocking queue size = " + this.f142521g.c() + ", Control State {created workers= " + ((int) (2097151 & j3)) + ", blocking tasks = " + ((int) ((4398044413952L & j3) >> 21)) + ", CPUs acquired = " + (this.f142516a - ((int) ((9223367638808264704L & j3) >> 42))) + "}]";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class Worker extends Thread {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f142524j = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WorkQueue f142525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Ref.ObjectRef f142526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WorkerState f142527c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f142528d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f142529f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f142530g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f142531h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        private Worker() {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.f142525a = new WorkQueue();
            this.f142526b = new Ref.ObjectRef();
            this.f142527c = WorkerState.f142536d;
            this.nextParkedWorker = CoroutineScheduler.f142515m;
            int iNanoTime = (int) System.nanoTime();
            this.f142530g = iNanoTime == 0 ? 42 : iNanoTime;
        }

        private final void b(Task task) {
            this.f142528d = 0L;
            if (this.f142527c == WorkerState.f142535c) {
                this.f142527c = WorkerState.f142534b;
            }
            if (!task.f142550b) {
                CoroutineScheduler.this.K(task);
                return;
            }
            if (r(WorkerState.f142534b)) {
                CoroutineScheduler.this.N();
            }
            CoroutineScheduler.this.K(task);
            CoroutineScheduler.l().addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.f142527c != WorkerState.f142537f) {
                this.f142527c = WorkerState.f142536d;
            }
        }

        private final Task c(boolean z2) {
            Task taskL;
            Task taskL2;
            if (z2) {
                boolean z3 = j(CoroutineScheduler.this.f142516a * 2) == 0;
                if (z3 && (taskL2 = l()) != null) {
                    return taskL2;
                }
                Task taskK = this.f142525a.k();
                if (taskK != null) {
                    return taskK;
                }
                if (!z3 && (taskL = l()) != null) {
                    return taskL;
                }
            } else {
                Task taskL3 = l();
                if (taskL3 != null) {
                    return taskL3;
                }
            }
            return s(3);
        }

        private final Task d() {
            Task taskL = this.f142525a.l();
            if (taskL != null) {
                return taskL;
            }
            Task task = (Task) CoroutineScheduler.this.f142521g.e();
            return task == null ? s(1) : task;
        }

        private final boolean i() {
            return this.nextParkedWorker != CoroutineScheduler.f142515m;
        }

        private final void k() {
            if (this.f142528d == 0) {
                this.f142528d = System.nanoTime() + CoroutineScheduler.this.f142518c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f142518c);
            if (System.nanoTime() - this.f142528d >= 0) {
                this.f142528d = 0L;
                t();
            }
        }

        private final Task l() {
            if (j(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.f142520f.e();
                return task != null ? task : (Task) CoroutineScheduler.this.f142521g.e();
            }
            Task task2 = (Task) CoroutineScheduler.this.f142521g.e();
            return task2 != null ? task2 : (Task) CoroutineScheduler.this.f142520f.e();
        }

        private final void m() {
            loop0: while (true) {
                boolean z2 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f142527c != WorkerState.f142537f) {
                    Task taskE = e(this.f142531h);
                    if (taskE != null) {
                        this.f142529f = 0L;
                        b(taskE);
                    } else {
                        this.f142531h = false;
                        if (this.f142529f == 0) {
                            q();
                        } else if (z2) {
                            r(WorkerState.f142535c);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f142529f);
                            this.f142529f = 0L;
                        } else {
                            z2 = true;
                        }
                    }
                }
                break loop0;
            }
            r(WorkerState.f142537f);
        }

        private final boolean p() {
            long j3;
            if (this.f142527c == WorkerState.f142533a) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater atomicLongFieldUpdaterL = CoroutineScheduler.l();
            do {
                j3 = atomicLongFieldUpdaterL.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j3) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.l().compareAndSet(coroutineScheduler, j3, j3 - 4398046511104L));
            this.f142527c = WorkerState.f142533a;
            return true;
        }

        private final void q() {
            if (!i()) {
                CoroutineScheduler.this.F(this);
                return;
            }
            f142524j.set(this, -1);
            while (i() && f142524j.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.f142527c != WorkerState.f142537f) {
                r(WorkerState.f142535c);
                Thread.interrupted();
                k();
            }
        }

        private final Task s(int i3) {
            int i4 = (int) (CoroutineScheduler.l().get(CoroutineScheduler.this) & 2097151);
            if (i4 < 2) {
                return null;
            }
            int iJ = j(i4);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long jMin = Long.MAX_VALUE;
            for (int i5 = 0; i5 < i4; i5++) {
                iJ++;
                if (iJ > i4) {
                    iJ = 1;
                }
                Worker worker = (Worker) coroutineScheduler.f142522h.b(iJ);
                if (worker != null && worker != this) {
                    long jR = worker.f142525a.r(i3, this.f142526b);
                    if (jR == -1) {
                        Ref.ObjectRef objectRef = this.f142526b;
                        Task task = (Task) objectRef.f140144a;
                        objectRef.f140144a = null;
                        return task;
                    }
                    if (jR > 0) {
                        jMin = Math.min(jMin, jR);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f142529f = jMin;
            return null;
        }

        private final void t() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f142522h) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.l().get(coroutineScheduler) & 2097151)) <= coroutineScheduler.f142516a) {
                        return;
                    }
                    if (f142524j.compareAndSet(this, -1, 1)) {
                        int i3 = this.indexInArray;
                        n(0);
                        coroutineScheduler.J(this, i3, 0);
                        int andDecrement = (int) (CoroutineScheduler.l().getAndDecrement(coroutineScheduler) & 2097151);
                        if (andDecrement != i3) {
                            Object objB = coroutineScheduler.f142522h.b(andDecrement);
                            Intrinsics.checkNotNull(objB);
                            Worker worker = (Worker) objB;
                            coroutineScheduler.f142522h.c(i3, worker);
                            worker.n(i3);
                            coroutineScheduler.J(worker, andDecrement, i3);
                        }
                        coroutineScheduler.f142522h.c(andDecrement, null);
                        Unit unit = Unit.f139807a;
                        this.f142527c = WorkerState.f142537f;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Task e(boolean z2) {
            return p() ? c(z2) : d();
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final int j(int i3) {
            int i4 = this.f142530g;
            int i5 = i4 ^ (i4 << 13);
            int i6 = i5 ^ (i5 >> 17);
            int i7 = i6 ^ (i6 << 5);
            this.f142530g = i7;
            int i8 = i3 - 1;
            return (i8 & i3) == 0 ? i7 & i8 : (i7 & Api.BaseClientBuilder.API_PRIORITY_OTHER) % i3;
        }

        public final void n(int i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f142519d);
            sb.append("-worker-");
            sb.append(i3 == 0 ? "TERMINATED" : String.valueOf(i3));
            setName(sb.toString());
            this.indexInArray = i3;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean r(WorkerState workerState) {
            WorkerState workerState2 = this.f142527c;
            boolean z2 = workerState2 == WorkerState.f142533a;
            if (z2) {
                CoroutineScheduler.l().addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f142527c = workerState;
            }
            return z2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i3) {
            this();
            n(i3);
        }
    }
}
