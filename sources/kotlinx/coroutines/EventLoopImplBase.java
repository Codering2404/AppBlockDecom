package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

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
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f140945f = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f140946g = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f140947h = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class DelayedResumeTask extends DelayedTask {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CancellableContinuation f140948c;

        public DelayedResumeTask(long j3, CancellableContinuation cancellableContinuation) {
            super(j3);
            this.f140948c = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f140948c.I(EventLoopImplBase.this, Unit.f139807a);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.f140948c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DelayedRunnableTask extends DelayedTask {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f140950c;

        public DelayedRunnableTask(long j3, Runnable runnable) {
            super(j3);
            this.f140950c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f140950c.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.f140950c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f140951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f140952b = -1;

        public DelayedTask(long j3) {
            this.f140951a = j3;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void a(ThreadSafeHeap threadSafeHeap) {
            if (this._heap == EventLoop_commonKt.f140954a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = threadSafeHeap;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap c() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(DelayedTask delayedTask) {
            long j3 = this.f140951a - delayedTask.f140951a;
            if (j3 > 0) {
                return 1;
            }
            return j3 < 0 ? -1 : 0;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == EventLoop_commonKt.f140954a) {
                        return;
                    }
                    DelayedTaskQueue delayedTaskQueue = obj instanceof DelayedTaskQueue ? (DelayedTaskQueue) obj : null;
                    if (delayedTaskQueue != null) {
                        delayedTaskQueue.h(this);
                    }
                    this._heap = EventLoop_commonKt.f140954a;
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final int e(long j3, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            synchronized (this) {
                if (this._heap == EventLoop_commonKt.f140954a) {
                    return 2;
                }
                synchronized (delayedTaskQueue) {
                    try {
                        DelayedTask delayedTask = (DelayedTask) delayedTaskQueue.b();
                        if (eventLoopImplBase.isCompleted()) {
                            return 1;
                        }
                        if (delayedTask == null) {
                            delayedTaskQueue.f140953c = j3;
                        } else {
                            long j4 = delayedTask.f140951a;
                            if (j4 - j3 < 0) {
                                j3 = j4;
                            }
                            if (j3 - delayedTaskQueue.f140953c > 0) {
                                delayedTaskQueue.f140953c = j3;
                            }
                        }
                        long j5 = this.f140951a;
                        long j6 = delayedTaskQueue.f140953c;
                        if (j5 - j6 < 0) {
                            this.f140951a = j6;
                        }
                        delayedTaskQueue.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean f(long j3) {
            return j3 - this.f140951a >= 0;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.f140952b;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i3) {
            this.f140952b = i3;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f140951a + ']';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f140953c;

        public DelayedTaskQueue(long j3) {
            this.f140953c = j3;
        }
    }

    private final void L1() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f140945f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f140945f, this, null, EventLoop_commonKt.f140955b)) {
                    return;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore) obj).d();
                return;
            } else {
                if (obj == EventLoop_commonKt.f140955b) {
                    return;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable");
                lockFreeTaskQueueCore.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f140945f, this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            }
        }
    }

    private final Runnable Q1() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f140945f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeTaskQueueCore) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object objM = lockFreeTaskQueueCore.m();
                if (objM != LockFreeTaskQueueCore.f142463h) {
                    return (Runnable) objM;
                }
                androidx.concurrent.futures.a.a(f140945f, this, obj, lockFreeTaskQueueCore.l());
            } else {
                if (obj == EventLoop_commonKt.f140955b) {
                    return null;
                }
                if (androidx.concurrent.futures.a.a(f140945f, this, obj, null)) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final void S1() {
        ThreadSafeHeapNode threadSafeHeapNodeI;
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f140946g.get(this);
        if (delayedTaskQueue == null || delayedTaskQueue.e()) {
            return;
        }
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
        long jA = abstractTimeSource != null ? abstractTimeSource.a() : System.nanoTime();
        do {
            synchronized (delayedTaskQueue) {
                try {
                    ThreadSafeHeapNode threadSafeHeapNodeB = delayedTaskQueue.b();
                    if (threadSafeHeapNodeB != null) {
                        DelayedTask delayedTask = (DelayedTask) threadSafeHeapNodeB;
                        threadSafeHeapNodeI = delayedTask.f(jA) ? T1(delayedTask) : false ? delayedTaskQueue.i(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (((DelayedTask) threadSafeHeapNodeI) != null);
    }

    private final boolean T1(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f140945f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f140945f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int iA = lockFreeTaskQueueCore.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    androidx.concurrent.futures.a.a(f140945f, this, obj, lockFreeTaskQueueCore.l());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == EventLoop_commonKt.f140955b) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable");
                lockFreeTaskQueueCore2.a((Runnable) obj);
                lockFreeTaskQueueCore2.a(runnable);
                if (androidx.concurrent.futures.a.a(f140945f, this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    private final void g2() {
        DelayedTask delayedTask;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
        long jA = abstractTimeSource != null ? abstractTimeSource.a() : System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f140946g.get(this);
            if (delayedTaskQueue == null || (delayedTask = (DelayedTask) delayedTaskQueue.j()) == null) {
                return;
            } else {
                B1(jA, delayedTask);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        return f140947h.get(this) != 0;
    }

    private final int m2(long j3, DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f140946g.get(this);
        if (delayedTaskQueue == null) {
            androidx.concurrent.futures.a.a(f140946g, this, null, new DelayedTaskQueue(j3));
            Object obj = f140946g.get(this);
            Intrinsics.checkNotNull(obj);
            delayedTaskQueue = (DelayedTaskQueue) obj;
        }
        return delayedTask.e(j3, delayedTaskQueue, this);
    }

    private final void o2(boolean z2) {
        f140947h.set(this, z2 ? 1 : 0);
    }

    private final boolean r2(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f140946g.get(this);
        return (delayedTaskQueue != null ? (DelayedTask) delayedTaskQueue.f() : null) == delayedTask;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void M(CoroutineContext coroutineContext, Runnable runnable) {
        R1(runnable);
    }

    public void R1(Runnable runnable) {
        S1();
        if (T1(runnable)) {
            I1();
        } else {
            DefaultExecutor.f140926i.R1(runnable);
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    protected long X0() {
        DelayedTask delayedTask;
        if (super.X0() == 0) {
            return 0L;
        }
        Object obj = f140945f.get(this);
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                return obj == EventLoop_commonKt.f140955b ? Long.MAX_VALUE : 0L;
            }
            if (!((LockFreeTaskQueueCore) obj).j()) {
                return 0L;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f140946g.get(this);
        if (delayedTaskQueue == null || (delayedTask = (DelayedTask) delayedTaskQueue.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j3 = delayedTask.f140951a;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
        return RangesKt.g(j3 - (abstractTimeSource != null ? abstractTimeSource.a() : System.nanoTime()), 0L);
    }

    protected boolean c2() {
        if (!o1()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f140946g.get(this);
        if (delayedTaskQueue != null && !delayedTaskQueue.e()) {
            return false;
        }
        Object obj = f140945f.get(this);
        if (obj == null) {
            return true;
        }
        return obj instanceof LockFreeTaskQueueCore ? ((LockFreeTaskQueueCore) obj).j() : obj == EventLoop_commonKt.f140955b;
    }

    protected final void h2() {
        f140945f.set(this, null);
        f140946g.set(this, null);
    }

    @Override // kotlinx.coroutines.Delay
    public void i(long j3, CancellableContinuation cancellableContinuation) {
        long jD = EventLoop_commonKt.d(j3);
        if (jD < 4611686018427387903L) {
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
            long jA = abstractTimeSource != null ? abstractTimeSource.a() : System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(jD + jA, cancellableContinuation);
            k2(jA, delayedResumeTask);
            CancellableContinuationKt.a(cancellableContinuation, delayedResumeTask);
        }
    }

    public final void k2(long j3, DelayedTask delayedTask) {
        int iM2 = m2(j3, delayedTask);
        if (iM2 == 0) {
            if (r2(delayedTask)) {
                I1();
            }
        } else if (iM2 == 1) {
            B1(j3, delayedTask);
        } else if (iM2 != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    public DisposableHandle m(long j3, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.a(this, j3, runnable, coroutineContext);
    }

    protected final DisposableHandle n2(long j3, Runnable runnable) {
        long jD = EventLoop_commonKt.d(j3);
        if (jD >= 4611686018427387903L) {
            return NonDisposableHandle.f141004a;
        }
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
        long jA = abstractTimeSource != null ? abstractTimeSource.a() : System.nanoTime();
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(jD + jA, runnable);
        k2(jA, delayedRunnableTask);
        return delayedRunnableTask;
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadLocalEventLoop.f141011a.c();
        o2(true);
        L1();
        while (t1() <= 0) {
        }
        g2();
    }

    @Override // kotlinx.coroutines.EventLoop
    public long t1() {
        if (u1()) {
            return 0L;
        }
        S1();
        Runnable runnableQ1 = Q1();
        if (runnableQ1 == null) {
            return X0();
        }
        runnableQ1.run();
        return 0L;
    }
}
