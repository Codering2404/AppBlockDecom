package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.selects.SelectInstance;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class SemaphoreAndMutexImpl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142650c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "head$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f142651d = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142652f = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "tail$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f142653g = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142654h = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f142655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3 f142656b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public SemaphoreAndMutexImpl(int i3, int i4) {
        this.f142655a = i3;
        if (i3 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i3).toString());
        }
        if (i4 < 0 || i4 > i3) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i3).toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head$volatile = semaphoreSegment;
        this.tail$volatile = semaphoreSegment;
        this._availablePermits$volatile = i3 - i4;
        this.f142656b = new Function3() { // from class: kotlinx.coroutines.sync.e
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SemaphoreAndMutexImpl.t(this.f142677a, (Throwable) obj, (Unit) obj2, (CoroutineContext) obj3);
            }
        };
    }

    private final Object j(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImplB = CancellableContinuationKt.b(IntrinsicsKt.c(continuation));
        try {
            if (!k(cancellableContinuationImplB)) {
                h(cancellableContinuationImplB);
            }
            Object objV = cancellableContinuationImplB.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
        } catch (Throwable th) {
            cancellableContinuationImplB.M();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(Waiter waiter) {
        Object objC;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) f142652f.get(this);
        long andIncrement = f142653g.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.f142657a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f142652f;
        long j3 = andIncrement / ((long) SemaphoreKt.f142664f);
        loop0: while (true) {
            objC = ConcurrentLinkedListKt.c(semaphoreSegment, j3, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (!SegmentOrClosed.e(objC)) {
                Segment segmentC = SegmentOrClosed.c(objC);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f142482c >= segmentC.f142482c) {
                        break loop0;
                    }
                    if (!segmentC.u()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, segment, segmentC)) {
                        if (segment.p()) {
                            segment.n();
                        }
                    } else if (segmentC.p()) {
                        segmentC.n();
                    }
                }
            } else {
                break;
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.c(objC);
        int i3 = (int) (andIncrement % ((long) SemaphoreKt.f142664f));
        if (kotlinx.coroutines.channels.d.a(semaphoreSegment2.v(), i3, null, waiter)) {
            waiter.b(semaphoreSegment2, i3);
            return true;
        }
        if (!kotlinx.coroutines.channels.d.a(semaphoreSegment2.v(), i3, SemaphoreKt.f142660b, SemaphoreKt.f142661c)) {
            return false;
        }
        if (waiter instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((CancellableContinuation) waiter).H(Unit.f139807a, this.f142656b);
        } else {
            if (!(waiter instanceof SelectInstance)) {
                throw new IllegalStateException(("unexpected: " + waiter).toString());
            }
            ((SelectInstance) waiter).d(Unit.f139807a);
        }
        return true;
    }

    private final void l() {
        int i3;
        do {
            i3 = f142654h.get(this);
            if (i3 <= this.f142655a) {
                return;
            }
        } while (!f142654h.compareAndSet(this, i3, this.f142655a));
    }

    private final int m() {
        int andDecrement;
        do {
            andDecrement = f142654h.getAndDecrement(this);
        } while (andDecrement > this.f142655a);
        return andDecrement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(SemaphoreAndMutexImpl semaphoreAndMutexImpl, Throwable th, Unit unit, CoroutineContext coroutineContext) {
        semaphoreAndMutexImpl.release();
        return Unit.f139807a;
    }

    private final boolean v(Object obj) {
        if (!(obj instanceof CancellableContinuation)) {
            if (obj instanceof SelectInstance) {
                return ((SelectInstance) obj).f(this, Unit.f139807a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
        Object objQ = cancellableContinuation.Q(Unit.f139807a, null, this.f142656b);
        if (objQ == null) {
            return false;
        }
        cancellableContinuation.R(objQ);
        return true;
    }

    private final boolean w() {
        Object objC;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) f142650c.get(this);
        long andIncrement = f142651d.getAndIncrement(this);
        long j3 = andIncrement / ((long) SemaphoreKt.f142664f);
        SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.f142658a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f142650c;
        loop0: while (true) {
            objC = ConcurrentLinkedListKt.c(semaphoreSegment, j3, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (SegmentOrClosed.e(objC)) {
                break;
            }
            Segment segmentC = SegmentOrClosed.c(objC);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.f142482c >= segmentC.f142482c) {
                    break loop0;
                }
                if (!segmentC.u()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, segment, segmentC)) {
                    if (segment.p()) {
                        segment.n();
                    }
                } else if (segmentC.p()) {
                    segmentC.n();
                }
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.c(objC);
        semaphoreSegment2.b();
        if (semaphoreSegment2.f142482c > j3) {
            return false;
        }
        int i3 = (int) (andIncrement % ((long) SemaphoreKt.f142664f));
        Object andSet = semaphoreSegment2.v().getAndSet(i3, SemaphoreKt.f142660b);
        if (andSet != null) {
            if (andSet == SemaphoreKt.f142663e) {
                return false;
            }
            return v(andSet);
        }
        int i4 = SemaphoreKt.f142659a;
        for (int i5 = 0; i5 < i4; i5++) {
            if (semaphoreSegment2.v().get(i3) == SemaphoreKt.f142661c) {
                return true;
            }
        }
        return !kotlinx.coroutines.channels.d.a(semaphoreSegment2.v(), i3, SemaphoreKt.f142660b, SemaphoreKt.f142662d);
    }

    public final int a() {
        return Math.max(f142654h.get(this), 0);
    }

    public final Object d(Continuation continuation) {
        if (m() > 0) {
            return Unit.f139807a;
        }
        Object objJ = j(continuation);
        return objJ == IntrinsicsKt.f() ? objJ : Unit.f139807a;
    }

    protected final void h(CancellableContinuation cancellableContinuation) {
        while (m() <= 0) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (k((Waiter) cancellableContinuation)) {
                return;
            }
        }
        cancellableContinuation.H(Unit.f139807a, this.f142656b);
    }

    public final void release() {
        do {
            int andIncrement = f142654h.getAndIncrement(this);
            if (andIncrement >= this.f142655a) {
                l();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f142655a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!w());
    }

    protected final void s(SelectInstance selectInstance, Object obj) {
        while (m() <= 0) {
            Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (k((Waiter) selectInstance)) {
                return;
            }
        }
        selectInstance.d(Unit.f139807a);
    }

    public final boolean u() {
        while (true) {
            int i3 = f142654h.get(this);
            if (i3 > this.f142655a) {
                l();
            } else {
                if (i3 <= 0) {
                    return false;
                }
                if (f142654h.compareAndSet(this, i3, i3 - 1)) {
                    return true;
                }
            }
        }
    }
}
