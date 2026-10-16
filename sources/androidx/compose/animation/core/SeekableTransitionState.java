package androidx.compose.animation.core;

import androidx.collection.MutableObjectList;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SeekableTransitionState<S> extends TransitionState<S> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Companion f4060r = new Companion(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f4061s = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final AnimationVector1D f4062t = new AnimationVector1D(0.0f);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final AnimationVector1D f4063u = new AnimationVector1D(1.0f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f4064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f4065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f4066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Transition f4067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function0 f4069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableFloatState f4070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CancellableContinuation f4071i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Mutex f4072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutatorMutex f4073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f4074l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableObjectList f4075m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private SeekingAnimationState f4076n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Function1 f4077o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f4078p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Function1 f4079q;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnimationVector1D a() {
            return SeekableTransitionState.f4063u;
        }

        public final AnimationVector1D b() {
            return SeekableTransitionState.f4062t;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SeekingAnimationState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f4080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private VectorizedAnimationSpec f4081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f4083d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private AnimationVector1D f4084e = new AnimationVector1D(0.0f);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private AnimationVector1D f4085f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f4086g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f4087h;

        public final VectorizedAnimationSpec a() {
            return this.f4081b;
        }

        public final long b() {
            return this.f4087h;
        }

        public final long c() {
            return this.f4086g;
        }

        public final AnimationVector1D d() {
            return this.f4085f;
        }

        public final long e() {
            return this.f4080a;
        }

        public final AnimationVector1D f() {
            return this.f4084e;
        }

        public final float g() {
            return this.f4083d;
        }

        public final boolean h() {
            return this.f4082c;
        }

        public final void i(VectorizedAnimationSpec vectorizedAnimationSpec) {
            this.f4081b = vectorizedAnimationSpec;
        }

        public final void j(long j3) {
            this.f4087h = j3;
        }

        public final void k(boolean z2) {
            this.f4082c = z2;
        }

        public final void l(long j3) {
            this.f4086g = j3;
        }

        public final void m(AnimationVector1D animationVector1D) {
            this.f4085f = animationVector1D;
        }

        public final void n(long j3) {
            this.f4080a = j3;
        }

        public final void o(float f3) {
            this.f4083d = f3;
        }

        public String toString() {
            return "progress nanos: " + this.f4080a + ", animationSpec: " + this.f4081b + ", isComplete: " + this.f4082c + ", value: " + this.f4083d + ", start: " + this.f4084e + ", initialVelocity: " + this.f4085f + ", durationNanos: " + this.f4086g + ", animationSpecDuration: " + this.f4087h;
        }
    }

    public SeekableTransitionState(Object obj) {
        super(null);
        this.f4064b = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f4065c = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f4066d = obj;
        this.f4069g = new Function0<Unit>() { // from class: androidx.compose.animation.core.SeekableTransitionState$recalculateTotalDurationNanos$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m23invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m23invoke() {
                SeekableTransitionState seekableTransitionState = this.f4102a;
                Transition transition = seekableTransitionState.f4067e;
                seekableTransitionState.W(transition != null ? transition.r() : 0L);
            }
        };
        this.f4070h = PrimitiveSnapshotStateKt.a(0.0f);
        this.f4072j = MutexKt.b(false, 1, null);
        this.f4073k = new MutatorMutex();
        this.f4074l = Long.MIN_VALUE;
        this.f4075m = new MutableObjectList(0, 1, null);
        this.f4077o = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SeekableTransitionState$firstFrameLambda$1
            {
                super(1);
            }

            public final void c(long j3) {
                this.f4101a.f4074l = j3;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                c(((Number) obj2).longValue());
                return Unit.f139807a;
            }
        };
        this.f4079q = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SeekableTransitionState$animateOneFrameLambda$1
            {
                super(1);
            }

            public final void c(long j3) {
                long j4 = j3 - this.f4088a.f4074l;
                this.f4088a.f4074l = j3;
                long jE = MathKt.e(j4 / ((double) this.f4088a.f4078p));
                if (this.f4088a.f4075m.h()) {
                    MutableObjectList mutableObjectList = this.f4088a.f4075m;
                    SeekableTransitionState seekableTransitionState = this.f4088a;
                    Object[] objArr = mutableObjectList.f3081a;
                    int i3 = mutableObjectList.f3082b;
                    int i4 = 0;
                    for (int i5 = 0; i5 < i3; i5++) {
                        SeekableTransitionState.SeekingAnimationState seekingAnimationState = (SeekableTransitionState.SeekingAnimationState) objArr[i5];
                        seekableTransitionState.N(seekingAnimationState, jE);
                        seekingAnimationState.k(true);
                    }
                    Transition transition = this.f4088a.f4067e;
                    if (transition != null) {
                        transition.R();
                    }
                    MutableObjectList mutableObjectList2 = this.f4088a.f4075m;
                    int i6 = mutableObjectList2.f3082b;
                    Object[] objArr2 = mutableObjectList2.f3081a;
                    IntRange intRangeB = RangesKt.B(0, i6);
                    int iG = intRangeB.g();
                    int iH = intRangeB.h();
                    if (iG <= iH) {
                        while (true) {
                            objArr2[iG - i4] = objArr2[iG];
                            if (((SeekableTransitionState.SeekingAnimationState) objArr2[iG]).h()) {
                                i4++;
                            }
                            if (iG == iH) {
                                break;
                            } else {
                                iG++;
                            }
                        }
                    }
                    ArraysKt.fill(objArr2, (Object) null, i6 - i4, i6);
                    mutableObjectList2.f3082b -= i4;
                }
                SeekableTransitionState.SeekingAnimationState seekingAnimationState2 = this.f4088a.f4076n;
                if (seekingAnimationState2 != null) {
                    seekingAnimationState2.l(this.f4088a.J());
                    this.f4088a.N(seekingAnimationState2, jE);
                    this.f4088a.U(seekingAnimationState2.g());
                    if (seekingAnimationState2.g() == 1.0f) {
                        this.f4088a.f4076n = null;
                    }
                    this.f4088a.R();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                c(((Number) obj2).longValue());
                return Unit.f139807a;
            }
        };
    }

    private final Object A(Continuation continuation) {
        float fO = SuspendAnimationKt.o(continuation.getContext());
        if (fO <= 0.0f) {
            E();
            return Unit.f139807a;
        }
        this.f4078p = fO;
        Object objC = MonotonicFrameClockKt.c(this.f4079q, continuation);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    public static /* synthetic */ Object C(SeekableTransitionState seekableTransitionState, Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = seekableTransitionState.b();
        }
        if ((i3 & 2) != 0) {
            finiteAnimationSpec = null;
        }
        return seekableTransitionState.B(obj, finiteAnimationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D(Continuation continuation) {
        if (this.f4074l == Long.MIN_VALUE) {
            Object objC = MonotonicFrameClockKt.c(this.f4077o, continuation);
            return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
        }
        Object objA = A(continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        Transition transition = this.f4067e;
        if (transition != null) {
            transition.g();
        }
        this.f4075m.t();
        if (this.f4076n != null) {
            this.f4076n = null;
            U(1.0f);
            R();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        Transition transition = this.f4067e;
        if (transition == null) {
            return;
        }
        SeekingAnimationState seekingAnimationState = this.f4076n;
        if (seekingAnimationState == null) {
            if (this.f4068f <= 0 || I() == 1.0f || Intrinsics.areEqual(a(), b())) {
                seekingAnimationState = null;
            } else {
                seekingAnimationState = new SeekingAnimationState();
                seekingAnimationState.o(I());
                long j3 = this.f4068f;
                seekingAnimationState.l(j3);
                seekingAnimationState.j(MathKt.e(j3 * (1.0d - ((double) I()))));
                seekingAnimationState.f().e(0, I());
            }
        }
        if (seekingAnimationState != null) {
            seekingAnimationState.l(this.f4068f);
            this.f4075m.n(seekingAnimationState);
            transition.J(seekingAnimationState);
        }
        this.f4076n = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(SeekingAnimationState seekingAnimationState, long j3) {
        long jE = seekingAnimationState.e() + j3;
        seekingAnimationState.n(jE);
        long jB = seekingAnimationState.b();
        if (jE >= jB) {
            seekingAnimationState.o(1.0f);
            return;
        }
        VectorizedAnimationSpec vectorizedAnimationSpecA = seekingAnimationState.a();
        if (vectorizedAnimationSpecA == null) {
            float f3 = jE / jB;
            seekingAnimationState.o((seekingAnimationState.f().a(0) * (1 - f3)) + (f3 * 1.0f));
        } else {
            AnimationVector1D animationVector1DF = seekingAnimationState.f();
            AnimationVector1D animationVector1D = f4063u;
            AnimationVector1D animationVector1DD = seekingAnimationState.d();
            if (animationVector1DD == null) {
                animationVector1DD = f4062t;
            }
            seekingAnimationState.o(RangesKt.o(((AnimationVector1D) vectorizedAnimationSpecA.g(jE, animationVector1DF, animationVector1D, animationVector1DD)).a(0), 0.0f, 1.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        if (androidx.compose.runtime.MonotonicFrameClockKt.c(r10, r0) == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object O(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.compose.animation.core.SeekableTransitionState$runAnimations$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 r0 = (androidx.compose.animation.core.SeekableTransitionState$runAnimations$1) r0
            int r1 = r0.f4106d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4106d = r1
            goto L18
        L13:
            androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$runAnimations$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f4104b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f4106d
            r3 = 2
            r4 = 1
            r5 = -9223372036854775808
            if (r2 == 0) goto L3b
            if (r2 == r4) goto L33
            if (r2 != r3) goto L2b
            goto L33
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L33:
            java.lang.Object r2 = r0.f4103a
            androidx.compose.animation.core.SeekableTransitionState r2 = (androidx.compose.animation.core.SeekableTransitionState) r2
            kotlin.ResultKt.b(r10)
            goto L76
        L3b:
            kotlin.ResultKt.b(r10)
            androidx.collection.MutableObjectList r10 = r9.f4075m
            boolean r10 = r10.g()
            if (r10 == 0) goto L4d
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r10 = r9.f4076n
            if (r10 != 0) goto L4d
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L4d:
            kotlin.coroutines.CoroutineContext r10 = r0.getContext()
            float r10 = androidx.compose.animation.core.SuspendAnimationKt.o(r10)
            r2 = 0
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 != 0) goto L62
            r9.E()
            r9.f4074l = r5
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L62:
            long r7 = r9.f4074l
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 != 0) goto L75
            kotlin.jvm.functions.Function1 r10 = r9.f4077o
            r0.f4103a = r9
            r0.f4106d = r4
            java.lang.Object r10 = androidx.compose.runtime.MonotonicFrameClockKt.c(r10, r0)
            if (r10 != r1) goto L75
            goto L92
        L75:
            r2 = r9
        L76:
            androidx.collection.MutableObjectList r10 = r2.f4075m
            boolean r10 = r10.h()
            if (r10 != 0) goto L88
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r10 = r2.f4076n
            if (r10 == 0) goto L83
            goto L88
        L83:
            r2.f4074l = r5
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L88:
            r0.f4103a = r2
            r0.f4106d = r3
            java.lang.Object r10 = r2.A(r0)
            if (r10 != r1) goto L76
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.O(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object Q(SeekableTransitionState seekableTransitionState, float f3, Object obj, Continuation continuation, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            obj = seekableTransitionState.b();
        }
        return seekableTransitionState.P(f3, obj, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        Transition transition = this.f4067e;
        if (transition == null) {
            return;
        }
        transition.I(MathKt.e(((double) I()) * transition.r()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(float f3) {
        this.f4070h.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Y(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 r0 = (androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1) r0
            int r1 = r0.f4130f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4130f = r1
            goto L18
        L13:
            androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f4128c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f4130f
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L46
            if (r2 == r5) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r1 = r0.f4127b
            java.lang.Object r0 = r0.f4126a
            androidx.compose.animation.core.SeekableTransitionState r0 = (androidx.compose.animation.core.SeekableTransitionState) r0
            kotlin.ResultKt.b(r8)
            goto L8c
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3b:
            java.lang.Object r2 = r0.f4127b
            java.lang.Object r6 = r0.f4126a
            androidx.compose.animation.core.SeekableTransitionState r6 = (androidx.compose.animation.core.SeekableTransitionState) r6
            kotlin.ResultKt.b(r8)
            r8 = r2
            goto L5d
        L46:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = r7.b()
            kotlinx.coroutines.sync.Mutex r2 = r7.f4072j
            r0.f4126a = r7
            r0.f4127b = r8
            r0.f4130f = r5
            java.lang.Object r2 = kotlinx.coroutines.sync.Mutex.DefaultImpls.a(r2, r4, r0, r5, r4)
            if (r2 != r1) goto L5c
            goto L88
        L5c:
            r6 = r7
        L5d:
            r0.f4126a = r6
            r0.f4127b = r8
            r0.f4130f = r3
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r2.<init>(r3, r5)
            r2.C()
            r6.T(r2)
            kotlinx.coroutines.sync.Mutex r3 = r6.H()
            kotlinx.coroutines.sync.Mutex.DefaultImpls.c(r3, r4, r5, r4)
            java.lang.Object r2 = r2.v()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r2 != r3) goto L86
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L86:
            if (r2 != r1) goto L89
        L88:
            return r1
        L89:
            r1 = r8
            r8 = r2
            r0 = r6
        L8c:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r1)
            if (r8 == 0) goto L95
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L95:
            r1 = -9223372036854775808
            r0.f4074l = r1
            java.util.concurrent.CancellationException r8 = new java.util.concurrent.CancellationException
            java.lang.String r0 = "targetState while waiting for composition"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.Y(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Z(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 r0 = (androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1) r0
            int r1 = r0.f4135f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4135f = r1
            goto L18
        L13:
            androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f4133c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f4135f
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L46
            if (r2 == r5) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r1 = r0.f4132b
            java.lang.Object r0 = r0.f4131a
            androidx.compose.animation.core.SeekableTransitionState r0 = (androidx.compose.animation.core.SeekableTransitionState) r0
            kotlin.ResultKt.b(r8)
            goto L9a
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3b:
            java.lang.Object r2 = r0.f4132b
            java.lang.Object r6 = r0.f4131a
            androidx.compose.animation.core.SeekableTransitionState r6 = (androidx.compose.animation.core.SeekableTransitionState) r6
            kotlin.ResultKt.b(r8)
            r8 = r2
            goto L5d
        L46:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = r7.b()
            kotlinx.coroutines.sync.Mutex r2 = r7.f4072j
            r0.f4131a = r7
            r0.f4132b = r8
            r0.f4135f = r5
            java.lang.Object r2 = kotlinx.coroutines.sync.Mutex.DefaultImpls.a(r2, r4, r0, r5, r4)
            if (r2 != r1) goto L5c
            goto L96
        L5c:
            r6 = r7
        L5d:
            java.lang.Object r2 = r6.f4066d
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r2)
            if (r2 == 0) goto L6b
            kotlinx.coroutines.sync.Mutex r8 = r6.f4072j
            kotlinx.coroutines.sync.Mutex.DefaultImpls.c(r8, r4, r5, r4)
            goto La0
        L6b:
            r0.f4131a = r6
            r0.f4132b = r8
            r0.f4135f = r3
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r2.<init>(r3, r5)
            r2.C()
            r6.T(r2)
            kotlinx.coroutines.sync.Mutex r3 = r6.H()
            kotlinx.coroutines.sync.Mutex.DefaultImpls.c(r3, r4, r5, r4)
            java.lang.Object r2 = r2.v()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r2 != r3) goto L94
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L94:
            if (r2 != r1) goto L97
        L96:
            return r1
        L97:
            r1 = r8
            r8 = r2
            r0 = r6
        L9a:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r1)
            if (r2 == 0) goto La3
        La0:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        La3:
            r2 = -9223372036854775808
            r0.f4074l = r2
            java.util.concurrent.CancellationException r0 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "snapTo() was canceled because state was changed to "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r8 = " instead of "
            r2.append(r8)
            r2.append(r1)
            java.lang.String r8 = r2.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.Z(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object B(Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation) {
        Transition transition = this.f4067e;
        if (transition == null) {
            return Unit.f139807a;
        }
        Object objE = MutatorMutex.e(this.f4073k, null, new SeekableTransitionState$animateTo$2(transition, this, obj, finiteAnimationSpec, null), continuation, 1, null);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    public final Object F() {
        return this.f4066d;
    }

    public final CancellableContinuation G() {
        return this.f4071i;
    }

    public final Mutex H() {
        return this.f4072j;
    }

    public final float I() {
        return this.f4070h.c();
    }

    public final long J() {
        return this.f4068f;
    }

    public final void L() {
        TransitionKt.g().p(this, TransitionKt.f4241a, this.f4069g);
    }

    public final void M() {
        long j3 = this.f4068f;
        L();
        long j4 = this.f4068f;
        if (j3 != j4) {
            SeekingAnimationState seekingAnimationState = this.f4076n;
            if (seekingAnimationState == null) {
                if (j4 != 0) {
                    R();
                    return;
                }
                return;
            }
            long jE = seekingAnimationState.e();
            long j5 = this.f4068f;
            if (jE > j5) {
                E();
                return;
            }
            seekingAnimationState.l(j5);
            if (seekingAnimationState.a() == null) {
                seekingAnimationState.j(MathKt.e((1.0d - ((double) seekingAnimationState.f().a(0))) * this.f4068f));
            }
        }
    }

    public final Object P(float f3, Object obj, Continuation continuation) {
        boolean z2 = false;
        if (0.0f <= f3 && f3 <= 1.0f) {
            z2 = true;
        }
        if (!z2) {
            PreconditionsKt.a("Expecting fraction between 0 and 1. Got " + f3);
        }
        Transition transition = this.f4067e;
        if (transition == null) {
            return Unit.f139807a;
        }
        Object objE = MutatorMutex.e(this.f4073k, null, new SeekableTransitionState$seekTo$3(obj, b(), this, transition, f3, null), continuation, 1, null);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    public final void S(Object obj) {
        this.f4066d = obj;
    }

    public final void T(CancellableContinuation cancellableContinuation) {
        this.f4071i = cancellableContinuation;
    }

    public void V(Object obj) {
        this.f4064b.setValue(obj);
    }

    public final void W(long j3) {
        this.f4068f = j3;
    }

    public final Object X(Object obj, Continuation continuation) {
        Transition transition = this.f4067e;
        if (transition == null) {
            return Unit.f139807a;
        }
        if (Intrinsics.areEqual(a(), obj) && Intrinsics.areEqual(b(), obj)) {
            return Unit.f139807a;
        }
        Object objE = MutatorMutex.e(this.f4073k, null, new SeekableTransitionState$snapTo$2(this, obj, transition, null), continuation, 1, null);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public Object a() {
        return this.f4065c.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public Object b() {
        return this.f4064b.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void d(Object obj) {
        this.f4065c.setValue(obj);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void f(Transition transition) {
        Transition transition2 = this.f4067e;
        if (!(transition2 == null || Intrinsics.areEqual(transition, transition2))) {
            PreconditionsKt.b("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.f4067e + ", new instance: " + transition);
        }
        this.f4067e = transition;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void g() {
        this.f4067e = null;
        TransitionKt.g().l(this);
    }
}
