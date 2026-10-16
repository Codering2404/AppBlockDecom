package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
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
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f142178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f142179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BufferOverflow f142180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object[] f142181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f142182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f142183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f142184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f142185m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Emitter implements DisposableHandle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SharedFlowImpl f142186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f142187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f142188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Continuation f142189d;

        public Emitter(SharedFlowImpl sharedFlowImpl, long j3, Object obj, Continuation continuation) {
            this.f142186a = sharedFlowImpl;
            this.f142187b = j3;
            this.f142188c = obj;
            this.f142189d = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.f142186a.y(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f142190a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.f141062a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.f141064c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.f141063b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f142190a = iArr;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {387, 394, 397}, m = "collect$suspendImpl")
    static final class AnonymousClass1<T> extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f142191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f142192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f142193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f142194d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f142195f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f142197h;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f142195f = obj;
            this.f142197h |= Integer.MIN_VALUE;
            return SharedFlowImpl.A(SharedFlowImpl.this, null, this);
        }
    }

    public SharedFlowImpl(int i3, int i4, BufferOverflow bufferOverflow) {
        this.f142178f = i3;
        this.f142179g = i4;
        this.f142180h = bufferOverflow;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0092, code lost:
    
        if (((kotlinx.coroutines.flow.SubscribedFlowCollector) r9).a(r0) == r1) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object A(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.A(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void B(long j3) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (((AbstractSharedFlow) this).f142258b != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).f142257a) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j4 = sharedFlowSlot.f142199a;
                    if (j4 >= 0 && j4 < j3) {
                        sharedFlowSlot.f142199a = j3;
                    }
                }
            }
        }
        this.f142183k = j3;
    }

    private final void E() {
        Object[] objArr = this.f142181i;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.g(objArr, K(), null);
        this.f142184l--;
        long jK = K() + 1;
        if (this.f142182j < jK) {
            this.f142182j = jK;
        }
        if (this.f142183k < jK) {
            B(jK);
        }
    }

    static /* synthetic */ Object F(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) throws Throwable {
        if (sharedFlowImpl.c(obj)) {
            return Unit.f139807a;
        }
        Object objG = sharedFlowImpl.G(obj, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    private final Object G(Object obj, Continuation continuation) throws Throwable {
        Throwable th;
        Continuation[] continuationArrI;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        Continuation[] continuationArrI2 = AbstractSharedFlowKt.f142261a;
        synchronized (this) {
            try {
                if (R(obj)) {
                    try {
                        Result.Companion companion = Result.f139772b;
                        cancellableContinuationImpl.resumeWith(Result.b(Unit.f139807a));
                        continuationArrI = I(continuationArrI2);
                        emitter = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        emitter = new Emitter(this, K() + ((long) P()), obj, cancellableContinuationImpl);
                        H(emitter);
                        this.f142185m++;
                        if (this.f142179g == 0) {
                            continuationArrI2 = I(continuationArrI2);
                        }
                        continuationArrI = continuationArrI2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (emitter != null) {
                    CancellableContinuationKt.a(cancellableContinuationImpl, emitter);
                }
                for (Continuation continuation2 : continuationArrI) {
                    if (continuation2 != null) {
                        Result.Companion companion2 = Result.f139772b;
                        continuation2.resumeWith(Result.b(Unit.f139807a));
                    }
                }
                Object objV = cancellableContinuationImpl.v();
                if (objV == IntrinsicsKt.f()) {
                    DebugProbesKt.c(continuation);
                }
                return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(Object obj) {
        int iP = P();
        Object[] objArrQ = this.f142181i;
        if (objArrQ == null) {
            objArrQ = Q(null, 0, 2);
        } else if (iP >= objArrQ.length) {
            objArrQ = Q(objArrQ, iP, objArrQ.length * 2);
        }
        SharedFlowKt.g(objArrQ, K() + ((long) iP), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.coroutines.Continuation[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final Continuation[] I(Continuation[] continuationArr) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        Continuation continuation;
        int length = continuationArr.length;
        if (((AbstractSharedFlow) this).f142258b != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).f142257a) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i3 = 0;
            continuationArr = continuationArr;
            while (i3 < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i3];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).f142200b) != null && T(sharedFlowSlot) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                        continuationArr = objArrCopyOf;
                    }
                    ((Continuation[]) continuationArr)[length] = continuation;
                    sharedFlowSlot.f142200b = null;
                    length++;
                }
                i3++;
                continuationArr = continuationArr;
            }
        }
        return (Continuation[]) continuationArr;
    }

    private final long J() {
        return K() + ((long) this.f142184l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long K() {
        return Math.min(this.f142183k, this.f142182j);
    }

    private final Object M(long j3) {
        Object[] objArr = this.f142181i;
        Intrinsics.checkNotNull(objArr);
        Object objF = SharedFlowKt.f(objArr, j3);
        return objF instanceof Emitter ? ((Emitter) objF).f142188c : objF;
    }

    private final long N() {
        return K() + ((long) this.f142184l) + ((long) this.f142185m);
    }

    private final int O() {
        return (int) ((K() + ((long) this.f142184l)) - this.f142182j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P() {
        return this.f142184l + this.f142185m;
    }

    private final Object[] Q(Object[] objArr, int i3, int i4) {
        if (i4 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i4];
        this.f142181i = objArr2;
        if (objArr != null) {
            long jK = K();
            for (int i5 = 0; i5 < i3; i5++) {
                long j3 = ((long) i5) + jK;
                SharedFlowKt.g(objArr2, j3, SharedFlowKt.f(objArr, j3));
            }
        }
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R(Object obj) {
        if (l() == 0) {
            return S(obj);
        }
        if (this.f142184l >= this.f142179g && this.f142183k <= this.f142182j) {
            int i3 = WhenMappings.f142190a[this.f142180h.ordinal()];
            if (i3 == 1) {
                return false;
            }
            if (i3 == 2) {
                return true;
            }
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        H(obj);
        int i4 = this.f142184l + 1;
        this.f142184l = i4;
        if (i4 > this.f142179g) {
            E();
        }
        if (O() > this.f142178f) {
            V(this.f142182j + 1, this.f142183k, J(), N());
        }
        return true;
    }

    private final boolean S(Object obj) {
        if (this.f142178f == 0) {
            return true;
        }
        H(obj);
        int i3 = this.f142184l + 1;
        this.f142184l = i3;
        if (i3 > this.f142178f) {
            E();
        }
        this.f142183k = K() + ((long) this.f142184l);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T(SharedFlowSlot sharedFlowSlot) {
        long j3 = sharedFlowSlot.f142199a;
        if (j3 >= J() && (this.f142179g > 0 || j3 > K() || this.f142185m == 0)) {
            return -1L;
        }
        return j3;
    }

    private final Object U(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation[] continuationArrW = AbstractSharedFlowKt.f142261a;
        synchronized (this) {
            try {
                long jT = T(sharedFlowSlot);
                if (jT < 0) {
                    obj = SharedFlowKt.f142198a;
                } else {
                    long j3 = sharedFlowSlot.f142199a;
                    Object objM = M(jT);
                    sharedFlowSlot.f142199a = jT + 1;
                    continuationArrW = W(j3);
                    obj = objM;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArrW) {
            if (continuation != null) {
                Result.Companion companion = Result.f139772b;
                continuation.resumeWith(Result.b(Unit.f139807a));
            }
        }
        return obj;
    }

    private final void V(long j3, long j4, long j5, long j6) {
        long jMin = Math.min(j4, j3);
        for (long jK = K(); jK < jMin; jK++) {
            Object[] objArr = this.f142181i;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.g(objArr, jK, null);
        }
        this.f142182j = j3;
        this.f142183k = j4;
        this.f142184l = (int) (j5 - jMin);
        this.f142185m = (int) (j6 - j5);
    }

    private final Object x(SharedFlowSlot sharedFlowSlot, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        synchronized (this) {
            try {
                if (T(sharedFlowSlot) < 0) {
                    sharedFlowSlot.f142200b = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuationImpl.resumeWith(Result.b(Unit.f139807a));
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(Emitter emitter) {
        synchronized (this) {
            if (emitter.f142187b < K()) {
                return;
            }
            Object[] objArr = this.f142181i;
            Intrinsics.checkNotNull(objArr);
            if (SharedFlowKt.f(objArr, emitter.f142187b) != emitter) {
                return;
            }
            SharedFlowKt.g(objArr, emitter.f142187b, SharedFlowKt.f142198a);
            z();
            Unit unit = Unit.f139807a;
        }
    }

    private final void z() {
        if (this.f142179g != 0 || this.f142185m > 1) {
            Object[] objArr = this.f142181i;
            Intrinsics.checkNotNull(objArr);
            while (this.f142185m > 0 && SharedFlowKt.f(objArr, (K() + ((long) P())) - 1) == SharedFlowKt.f142198a) {
                this.f142185m--;
                SharedFlowKt.g(objArr, K() + ((long) P()), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public SharedFlowSlot i() {
        return new SharedFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public SharedFlowSlot[] j(int i3) {
        return new SharedFlowSlot[i3];
    }

    protected final Object L() {
        Object[] objArr = this.f142181i;
        Intrinsics.checkNotNull(objArr);
        return SharedFlowKt.f(objArr, (this.f142182j + ((long) O())) - 1);
    }

    public final Continuation[] W(long j3) {
        long j4;
        long j5;
        long j6;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (j3 > this.f142183k) {
            return AbstractSharedFlowKt.f142261a;
        }
        long jK = K();
        long j7 = ((long) this.f142184l) + jK;
        if (this.f142179g == 0 && this.f142185m > 0) {
            j7++;
        }
        if (((AbstractSharedFlow) this).f142258b != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).f142257a) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    long j8 = ((SharedFlowSlot) abstractSharedFlowSlot).f142199a;
                    if (j8 >= 0 && j8 < j7) {
                        j7 = j8;
                    }
                }
            }
        }
        if (j7 <= this.f142183k) {
            return AbstractSharedFlowKt.f142261a;
        }
        long J = J();
        int iMin = l() > 0 ? Math.min(this.f142185m, this.f142179g - ((int) (J - j7))) : this.f142185m;
        Continuation[] continuationArr = AbstractSharedFlowKt.f142261a;
        long j9 = ((long) this.f142185m) + J;
        if (iMin > 0) {
            continuationArr = new Continuation[iMin];
            Object[] objArr = this.f142181i;
            Intrinsics.checkNotNull(objArr);
            j6 = 1;
            long j10 = J;
            int i3 = 0;
            while (true) {
                if (J >= j9) {
                    j4 = jK;
                    j5 = j7;
                    J = j10;
                    break;
                }
                Object objF = SharedFlowKt.f(objArr, J);
                j4 = jK;
                Symbol symbol = SharedFlowKt.f142198a;
                if (objF != symbol) {
                    Intrinsics.checkNotNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    Emitter emitter = (Emitter) objF;
                    int i4 = i3 + 1;
                    j5 = j7;
                    continuationArr[i3] = emitter.f142189d;
                    SharedFlowKt.g(objArr, J, symbol);
                    SharedFlowKt.g(objArr, j10, emitter.f142188c);
                    long j11 = j10 + 1;
                    if (i4 >= iMin) {
                        J = j11;
                        break;
                    }
                    i3 = i4;
                    j10 = j11;
                } else {
                    j5 = j7;
                }
                J++;
                jK = j4;
                j7 = j5;
            }
        } else {
            j4 = jK;
            j5 = j7;
            j6 = 1;
        }
        Continuation[] continuationArr2 = continuationArr;
        int i5 = (int) (J - j4);
        long j12 = l() == 0 ? J : j5;
        long jMax = Math.max(this.f142182j, J - ((long) Math.min(this.f142178f, i5)));
        if (this.f142179g == 0 && jMax < j9) {
            Object[] objArr2 = this.f142181i;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.f(objArr2, jMax), SharedFlowKt.f142198a)) {
                J += j6;
                jMax += j6;
            }
        }
        V(jMax, j12, J, j9);
        z();
        return !(continuationArr2.length == 0) ? I(continuationArr2) : continuationArr2;
    }

    public final long X() {
        long j3 = this.f142182j;
        if (j3 < this.f142183k) {
            this.f142183k = j3;
        }
        return j3;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow a(CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        return SharedFlowKt.e(this, coroutineContext, i3, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List b() {
        synchronized (this) {
            int iO = O();
            if (iO == 0) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(iO);
            Object[] objArr = this.f142181i;
            Intrinsics.checkNotNull(objArr);
            for (int i3 = 0; i3 < iO; i3++) {
                arrayList.add(SharedFlowKt.f(objArr, this.f142182j + ((long) i3)));
            }
            return arrayList;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean c(Object obj) {
        int i3;
        boolean z2;
        Continuation[] continuationArrI = AbstractSharedFlowKt.f142261a;
        synchronized (this) {
            if (R(obj)) {
                continuationArrI = I(continuationArrI);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        for (Continuation continuation : continuationArrI) {
            if (continuation != null) {
                Result.Companion companion = Result.f139772b;
                continuation.resumeWith(Result.b(Unit.f139807a));
            }
        }
        return z2;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        return A(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void e() throws Throwable {
        synchronized (this) {
            try {
                try {
                    V(J(), this.f142183k, J(), N());
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, Continuation continuation) {
        return F(this, obj, continuation);
    }
}
