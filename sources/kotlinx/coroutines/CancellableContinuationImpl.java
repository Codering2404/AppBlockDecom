package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

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
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f140893g = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f140894h = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f140895i = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Continuation f140896d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineContext f140897f;

    public CancellableContinuationImpl(Continuation continuation, int i3) {
        super(i3);
        this.f140896d = continuation;
        this.f140897f = continuation.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = Active.f140871a;
    }

    private final DisposableHandle D() {
        Job job = (Job) getContext().get(Job.v8);
        if (job == null) {
            return null;
        }
        DisposableHandle disposableHandleO = JobKt__JobKt.o(job, false, new ChildContinuation(this), 1, null);
        androidx.concurrent.futures.a.a(f140895i, this, null, disposableHandleO);
        return disposableHandleO;
    }

    private final void E(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f140894h;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof Active) {
                if (androidx.concurrent.futures.a.a(f140894h, this, obj2, obj)) {
                    return;
                }
            } else if ((obj2 instanceof CancelHandler) || (obj2 instanceof Segment)) {
                J(obj, obj2);
            } else {
                if (obj2 instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj2;
                    if (!completedExceptionally.c()) {
                        J(obj, obj2);
                    }
                    if (obj2 instanceof CancelledContinuation) {
                        Throwable th = completedExceptionally.f140908a;
                        if (obj instanceof CancelHandler) {
                            j((CancelHandler) obj, th);
                            return;
                        } else {
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            l((Segment) obj, th);
                            return;
                        }
                    }
                    return;
                }
                if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (completedContinuation.f140903b != null) {
                        J(obj, obj2);
                    }
                    if (obj instanceof Segment) {
                        return;
                    }
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    CancelHandler cancelHandler = (CancelHandler) obj;
                    if (completedContinuation.c()) {
                        j(cancelHandler, completedContinuation.f140906e);
                        return;
                    } else {
                        if (androidx.concurrent.futures.a.a(f140894h, this, obj2, CompletedContinuation.b(completedContinuation, null, cancelHandler, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (obj instanceof Segment) {
                        return;
                    }
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (androidx.concurrent.futures.a.a(f140894h, this, obj2, new CompletedContinuation(obj2, (CancelHandler) obj, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    private final boolean G() {
        if (!DispatchedTaskKt.c(this.f140933c)) {
            return false;
        }
        Continuation continuation = this.f140896d;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) continuation).n();
    }

    private final void J(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Function1 function1, Throwable th, Object obj, CoroutineContext coroutineContext) {
        function1.invoke(th);
        return Unit.f139807a;
    }

    public static /* synthetic */ void S(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i3, Function3 function3, int i4, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i4 & 4) != 0) {
            function3 = null;
        }
        cancellableContinuationImpl.P(obj, i3, function3);
    }

    private final Object T(NotCompleted notCompleted, Object obj, int i3, Function3 function3, Object obj2) {
        if (obj instanceof CompletedExceptionally) {
            return obj;
        }
        if ((DispatchedTaskKt.b(i3) || obj2 != null) && !(function3 == null && !(notCompleted instanceof CancelHandler) && obj2 == null)) {
            return new CompletedContinuation(obj, notCompleted instanceof CancelHandler ? (CancelHandler) notCompleted : null, function3, obj2, null, 16, null);
        }
        return obj;
    }

    private final boolean U() {
        int i3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f140893g;
        do {
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f140893g.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
        return true;
    }

    private final Symbol V(Object obj, Object obj2, Function3 function3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f140894h;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof NotCompleted)) {
                Object obj4 = obj2;
                if ((obj3 instanceof CompletedContinuation) && obj4 != null && ((CompletedContinuation) obj3).f140905d == obj4) {
                    return CancellableContinuationImplKt.f140898a;
                }
                return null;
            }
            Object obj5 = obj;
            Object obj6 = obj2;
            Function3 function32 = function3;
            if (androidx.concurrent.futures.a.a(f140894h, this, obj3, T((NotCompleted) obj3, obj5, this.f140933c, function32, obj6))) {
                q();
                return CancellableContinuationImplKt.f140898a;
            }
            obj = obj5;
            function3 = function32;
            obj2 = obj6;
        }
    }

    private final boolean W() {
        int i3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f140893g;
        do {
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f140893g.compareAndSet(this, i3, 536870912 + (536870911 & i3)));
        return true;
    }

    private final Void i(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void l(Segment segment, Throwable th) {
        int i3 = f140893g.get(this) & 536870911;
        if (i3 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            segment.s(i3, th, getContext());
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean n(Throwable th) {
        if (!G()) {
            return false;
        }
        Continuation continuation = this.f140896d;
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) continuation).o(th);
    }

    private final void q() {
        if (G()) {
            return;
        }
        o();
    }

    private final void r(int i3) {
        if (U()) {
            return;
        }
        DispatchedTaskKt.a(this, i3);
    }

    private final DisposableHandle t() {
        return (DisposableHandle) f140895i.get(this);
    }

    private final String y() {
        Object objW = w();
        return objW instanceof NotCompleted ? "Active" : objW instanceof CancelledContinuation ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
    }

    public void C() {
        DisposableHandle disposableHandleD = D();
        if (disposableHandleD != null && isCompleted()) {
            disposableHandleD.dispose();
            f140895i.set(this, NonDisposableHandle.f141004a);
        }
    }

    public final void F(CancelHandler cancelHandler) {
        E(cancelHandler);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void H(Object obj, Function3 function3) {
        P(obj, this.f140933c, function3);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void I(CoroutineDispatcher coroutineDispatcher, Object obj) {
        Continuation continuation = this.f140896d;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        S(this, obj, (dispatchedContinuation != null ? dispatchedContinuation.f142434d : null) == coroutineDispatcher ? 4 : this.f140933c, null, 4, null);
    }

    protected String K() {
        return "CancellableContinuation";
    }

    public final void L(Throwable th) {
        if (n(th)) {
            return;
        }
        cancel(th);
        q();
    }

    public final void M() {
        Throwable thR;
        Continuation continuation = this.f140896d;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation == null || (thR = dispatchedContinuation.r(this)) == null) {
            return;
        }
        o();
        cancel(thR);
    }

    public final boolean N() {
        Object obj = f140894h.get(this);
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).f140905d != null) {
            o();
            return false;
        }
        f140893g.set(this, 536870911);
        f140894h.set(this, Active.f140871a);
        return true;
    }

    public final void P(Object obj, int i3, Function3 function3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f140894h;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof NotCompleted)) {
                Object obj3 = obj;
                Function3 function32 = function3;
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.e()) {
                        if (function32 != null) {
                            k(function32, cancelledContinuation.f140908a, obj3);
                            return;
                        }
                        return;
                    }
                }
                i(obj3);
                throw new KotlinNothingValueException();
            }
            Object obj4 = obj;
            int i4 = i3;
            Function3 function33 = function3;
            if (androidx.concurrent.futures.a.a(f140894h, this, obj2, T((NotCompleted) obj2, obj4, i4, function33, null))) {
                q();
                r(i4);
                return;
            } else {
                obj = obj4;
                i3 = i4;
                function3 = function33;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object Q(Object obj, Object obj2, Function3 function3) {
        return V(obj, obj2, function3);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void R(Object obj) {
        r(this.f140933c);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void a(Object obj, Throwable th) {
        Throwable th2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f140894h;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof CompletedExceptionally) {
                return;
            }
            if (obj2 instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                if (completedContinuation.c()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                Throwable th3 = th;
                th2 = th3;
                if (androidx.concurrent.futures.a.a(f140894h, this, obj2, CompletedContinuation.b(completedContinuation, null, null, null, null, th3, 15, null))) {
                    completedContinuation.d(this, th2);
                    return;
                }
            } else {
                th2 = th;
                if (androidx.concurrent.futures.a.a(f140894h, this, obj2, new CompletedContinuation(obj2, null, null, null, th2, 14, null))) {
                    return;
                }
            }
            th = th2;
        }
    }

    @Override // kotlinx.coroutines.Waiter
    public void b(Segment segment, int i3) {
        int i4;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f140893g;
        do {
            i4 = atomicIntegerFieldUpdater.get(this);
            if ((i4 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, ((i4 >> 29) << 29) + i3));
        E(segment);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation c() {
        return this.f140896d;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f140894h;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
        } while (!androidx.concurrent.futures.a.a(f140894h, this, obj, new CancelledContinuation(this, th, (obj instanceof CancelHandler) || (obj instanceof Segment))));
        NotCompleted notCompleted = (NotCompleted) obj;
        if (notCompleted instanceof CancelHandler) {
            j((CancelHandler) obj, th);
        } else if (notCompleted instanceof Segment) {
            l((Segment) obj, th);
        }
        q();
        r(this.f140933c);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object e(Object obj) {
        return obj instanceof CompletedContinuation ? ((CompletedContinuation) obj).f140902a : obj;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object g() {
        return w();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f140896d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f140897f;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return w() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(w() instanceof NotCompleted);
    }

    public final void j(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.c(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(Function3 function3, Throwable th, Object obj) {
        try {
            function3.invoke(th, obj, getContext());
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void m(Function1 function1) {
        CancellableContinuationKt.c(this, new CancelHandler.UserSupplied(function1));
    }

    public final void o() {
        DisposableHandle disposableHandleT = t();
        if (disposableHandleT == null) {
            return;
        }
        disposableHandleT.dispose();
        f140895i.set(this, NonDisposableHandle.f141004a);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object p(Throwable th) {
        return V(new CompletedExceptionally(th, false, 2, null), null, null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        S(this, CompletionStateKt.c(obj, this), this.f140933c, null, 4, null);
    }

    public Throwable s(Job job) {
        return job.getCancellationException();
    }

    public String toString() {
        return K() + '(' + DebugStringsKt.c(this.f140896d) + "){" + y() + "}@" + DebugStringsKt.b(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void u(CoroutineDispatcher coroutineDispatcher, Throwable th) {
        Continuation continuation = this.f140896d;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        S(this, new CompletedExceptionally(th, false, 2, null), (dispatchedContinuation != null ? dispatchedContinuation.f142434d : null) == coroutineDispatcher ? 4 : this.f140933c, null, 4, null);
    }

    public final Object v() {
        Job job;
        boolean zG = G();
        if (W()) {
            if (t() == null) {
                D();
            }
            if (zG) {
                M();
            }
            return IntrinsicsKt.f();
        }
        if (zG) {
            M();
        }
        Object objW = w();
        if (objW instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) objW).f140908a;
        }
        if (!DispatchedTaskKt.b(this.f140933c) || (job = (Job) getContext().get(Job.v8)) == null || job.isActive()) {
            return e(objW);
        }
        CancellationException cancellationException = job.getCancellationException();
        a(objW, cancellationException);
        throw cancellationException;
    }

    public final Object w() {
        return f140894h.get(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void x(Object obj, final Function1 function1) {
        P(obj, this.f140933c, function1 != null ? new Function3() { // from class: kotlinx.coroutines.a
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return CancellableContinuationImpl.O(function1, (Throwable) obj2, obj3, (CoroutineContext) obj4);
            }
        } : null);
    }
}
