package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

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
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142433i = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineDispatcher f142434d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Continuation f142435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f142436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f142437h;

    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(-1);
        this.f142434d = coroutineDispatcher;
        this.f142435f = continuation;
        this.f142436g = DispatchedContinuationKt.f142438a;
        this.f142437h = ThreadContextKt.g(getContext());
    }

    private final CancellableContinuationImpl k() {
        Object obj = f142433i.get(this);
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object g() {
        Object obj = this.f142436g;
        this.f142436g = DispatchedContinuationKt.f142438a;
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f142435f;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f142435f.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h() {
        while (f142433i.get(this) == DispatchedContinuationKt.f142439b) {
        }
    }

    public final CancellableContinuationImpl i() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f142433i;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f142433i.set(this, DispatchedContinuationKt.f142439b);
                return null;
            }
            if (obj instanceof CancellableContinuationImpl) {
                if (androidx.concurrent.futures.a.a(f142433i, this, obj, DispatchedContinuationKt.f142439b)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != DispatchedContinuationKt.f142439b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void j(CoroutineContext coroutineContext, Object obj) {
        this.f142436g = obj;
        this.f140933c = 1;
        this.f142434d.O(coroutineContext, this);
    }

    public final boolean n() {
        return f142433i.get(this) != null;
    }

    public final boolean o(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f142433i;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = DispatchedContinuationKt.f142439b;
            if (Intrinsics.areEqual(obj, symbol)) {
                if (androidx.concurrent.futures.a.a(f142433i, this, symbol, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.a.a(f142433i, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void q() {
        h();
        CancellableContinuationImpl cancellableContinuationImplK = k();
        if (cancellableContinuationImplK != null) {
            cancellableContinuationImplK.o();
        }
    }

    public final Throwable r(CancellableContinuation cancellableContinuation) {
        Symbol symbol;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f142433i;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            symbol = DispatchedContinuationKt.f142439b;
            if (obj != symbol) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.a.a(f142433i, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(f142433i, this, symbol, cancellableContinuation));
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        Object objB = CompletionStateKt.b(obj);
        if (this.f142434d.e0(getContext())) {
            this.f142436g = objB;
            this.f140933c = 0;
            this.f142434d.M(getContext(), this);
            return;
        }
        EventLoop eventLoopB = ThreadLocalEventLoop.f141011a.b();
        if (eventLoopB.i1()) {
            this.f142436g = objB;
            this.f140933c = 0;
            eventLoopB.R0(this);
            return;
        }
        eventLoopB.a1(true);
        try {
            CoroutineContext context = getContext();
            Object objI = ThreadContextKt.i(context, this.f142437h);
            try {
                this.f142435f.resumeWith(obj);
                Unit unit = Unit.f139807a;
                while (eventLoopB.u1()) {
                }
            } finally {
                ThreadContextKt.f(context, objI);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f142434d + ", " + DebugStringsKt.c(this.f142435f) + ']';
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Continuation c() {
        return this;
    }
}
