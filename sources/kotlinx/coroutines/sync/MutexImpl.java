package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.sync.MutexImpl;

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
public class MutexImpl extends SemaphoreAndMutexImpl implements Mutex {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142633j = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Function3 f142634i;
    private volatile /* synthetic */ Object owner$volatile;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, Waiter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CancellableContinuationImpl f142635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f142636b;

        public CancellableContinuationWithOwner(CancellableContinuationImpl cancellableContinuationImpl, Object obj) {
            this.f142635a = cancellableContinuationImpl;
            this.f142636b = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(MutexImpl mutexImpl, CancellableContinuationWithOwner cancellableContinuationWithOwner, Throwable th) {
            mutexImpl.i(cancellableContinuationWithOwner.f142636b);
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit i(MutexImpl mutexImpl, CancellableContinuationWithOwner cancellableContinuationWithOwner, Throwable th, Unit unit, CoroutineContext coroutineContext) {
            MutexImpl.A().set(mutexImpl, cancellableContinuationWithOwner.f142636b);
            mutexImpl.i(cancellableContinuationWithOwner.f142636b);
            return Unit.f139807a;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void R(Object obj) {
            this.f142635a.R(obj);
        }

        @Override // kotlinx.coroutines.Waiter
        public void b(Segment segment, int i3) {
            this.f142635a.b(segment, i3);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean cancel(Throwable th) {
            return this.f142635a.cancel(th);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void x(Unit unit, Function1 function1) {
            this.f142635a.x(unit, function1);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void H(Unit unit, Function3 function3) {
            MutexImpl.A().set(MutexImpl.this, this.f142636b);
            CancellableContinuationImpl cancellableContinuationImpl = this.f142635a;
            final MutexImpl mutexImpl = MutexImpl.this;
            cancellableContinuationImpl.x(unit, new Function1() { // from class: kotlinx.coroutines.sync.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MutexImpl.CancellableContinuationWithOwner.f(mutexImpl, this, (Throwable) obj);
                }
            });
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void I(CoroutineDispatcher coroutineDispatcher, Unit unit) {
            this.f142635a.I(coroutineDispatcher, unit);
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f142635a.getContext();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object Q(Unit unit, Object obj, Function3 function3) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Object objQ = this.f142635a.Q(unit, obj, new Function3() { // from class: kotlinx.coroutines.sync.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return MutexImpl.CancellableContinuationWithOwner.i(mutexImpl, this, (Throwable) obj2, (Unit) obj3, (CoroutineContext) obj4);
                }
            });
            if (objQ != null) {
                MutexImpl.A().set(MutexImpl.this, this.f142636b);
            }
            return objQ;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isActive() {
            return this.f142635a.isActive();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCompleted() {
            return this.f142635a.isCompleted();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void m(Function1 function1) {
            this.f142635a.m(function1);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public Object p(Throwable th) {
            return this.f142635a.p(th);
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            this.f142635a.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void u(CoroutineDispatcher coroutineDispatcher, Throwable th) {
            this.f142635a.u(coroutineDispatcher, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class SelectInstanceWithOwner<Q> implements SelectInstanceInternal<Q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SelectInstanceInternal f142638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f142639b;

        public SelectInstanceWithOwner(SelectInstanceInternal selectInstanceInternal, Object obj) {
            this.f142638a = selectInstanceInternal;
            this.f142639b = obj;
        }

        @Override // kotlinx.coroutines.Waiter
        public void b(Segment segment, int i3) {
            this.f142638a.b(segment, i3);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public void d(Object obj) {
            MutexImpl.A().set(MutexImpl.this, this.f142639b);
            this.f142638a.d(obj);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public void e(DisposableHandle disposableHandle) {
            this.f142638a.e(disposableHandle);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public boolean f(Object obj, Object obj2) {
            boolean zF = this.f142638a.f(obj, obj2);
            MutexImpl mutexImpl = MutexImpl.this;
            if (zF) {
                MutexImpl.A().set(mutexImpl, this.f142639b);
            }
            return zF;
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public CoroutineContext getContext() {
            return this.f142638a.getContext();
        }
    }

    public MutexImpl(boolean z2) {
        super(1, z2 ? 1 : 0);
        this.owner$volatile = z2 ? null : MutexKt.f142643a;
        this.f142634i = new Function3() { // from class: kotlinx.coroutines.sync.a
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MutexImpl.H(this.f142670a, (SelectInstance) obj, obj2, obj3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater A() {
        return f142633j;
    }

    private final int C(Object obj) {
        while (c()) {
            Object obj2 = f142633j.get(this);
            if (obj2 != MutexKt.f142643a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object D(MutexImpl mutexImpl, Object obj, Continuation continuation) {
        if (mutexImpl.b(obj)) {
            return Unit.f139807a;
        }
        Object objE = mutexImpl.E(obj, continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    private final Object E(Object obj, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImplB = CancellableContinuationKt.b(IntrinsicsKt.c(continuation));
        try {
            h(new CancellableContinuationWithOwner(cancellableContinuationImplB, obj));
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
    public static final Function3 H(final MutexImpl mutexImpl, SelectInstance selectInstance, final Object obj, Object obj2) {
        return new Function3() { // from class: kotlinx.coroutines.sync.b
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return MutexImpl.I(this.f142671a, obj, (Throwable) obj3, obj4, (CoroutineContext) obj5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(MutexImpl mutexImpl, Object obj, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        mutexImpl.i(obj);
        return Unit.f139807a;
    }

    private final int J(Object obj) {
        while (!u()) {
            if (obj == null) {
                return 1;
            }
            int iC = C(obj);
            if (iC == 1) {
                return 2;
            }
            if (iC == 2) {
                return 1;
            }
        }
        f142633j.set(this, obj);
        return 0;
    }

    public boolean B(Object obj) {
        return C(obj) == 1;
    }

    protected Object F(Object obj, Object obj2) {
        if (!Intrinsics.areEqual(obj2, MutexKt.f142644b)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    protected void G(SelectInstance selectInstance, Object obj) {
        if (obj != null && B(obj)) {
            selectInstance.d(MutexKt.f142644b);
        } else {
            Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            s(new SelectInstanceWithOwner((SelectInstanceInternal) selectInstance, obj), obj);
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean b(Object obj) {
        int iJ = J(obj);
        if (iJ == 0) {
            return true;
        }
        if (iJ == 1) {
            return false;
        }
        if (iJ != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean c() {
        return a() == 0;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object f(Object obj, Continuation continuation) {
        return D(this, obj, continuation);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void i(Object obj) {
        while (c()) {
            Object obj2 = f142633j.get(this);
            if (obj2 != MutexKt.f142643a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (androidx.concurrent.futures.a.a(f142633j, this, obj2, MutexKt.f142643a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public String toString() {
        return "Mutex@" + DebugStringsKt.b(this) + "[isLocked=" + c() + ",owner=" + f142633j.get(this) + ']';
    }
}
