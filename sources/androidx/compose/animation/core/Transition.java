package androidx.compose.animation.core;

import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

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
public final class Transition<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransitionState f4189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Transition f4190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f4192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f4193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableLongState f4194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableLongState f4195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f4196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SnapshotStateList f4197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SnapshotStateList f4198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f4199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f4200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final State f4201m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class DeferredAnimation<T, V extends AnimationVector> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TwoWayConverter f4202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MutableState f4204c = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final TransitionAnimationState f4206a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Function1 f4207b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Function1 f4208c;

            public DeferredAnimationData(TransitionAnimationState transitionAnimationState, Function1 function1, Function1 function12) {
                this.f4206a = transitionAnimationState;
                this.f4207b = function1;
                this.f4208c = function12;
            }

            public final TransitionAnimationState b() {
                return this.f4206a;
            }

            @Override // androidx.compose.runtime.State
            public Object getValue() {
                r(Transition.this.o());
                return this.f4206a.getValue();
            }

            public final Function1 i() {
                return this.f4208c;
            }

            public final Function1 n() {
                return this.f4207b;
            }

            public final void p(Function1 function1) {
                this.f4208c = function1;
            }

            public final void q(Function1 function1) {
                this.f4207b = function1;
            }

            public final void r(Segment segment) {
                Object objInvoke = this.f4208c.invoke(segment.a());
                if (!Transition.this.w()) {
                    this.f4206a.N(objInvoke, (FiniteAnimationSpec) this.f4207b.invoke(segment));
                } else {
                    this.f4206a.L(this.f4208c.invoke(segment.c()), objInvoke, (FiniteAnimationSpec) this.f4207b.invoke(segment));
                }
            }
        }

        public DeferredAnimation(TwoWayConverter twoWayConverter, String str) {
            this.f4202a = twoWayConverter;
            this.f4203b = str;
        }

        public final State a(Function1 function1, Function1 function12) {
            DeferredAnimationData deferredAnimationDataB = b();
            if (deferredAnimationDataB == null) {
                Transition transition = Transition.this;
                deferredAnimationDataB = new DeferredAnimationData(new TransitionAnimationState(function12.invoke(transition.i()), AnimationStateKt.i(this.f4202a, function12.invoke(Transition.this.i())), this.f4202a, this.f4203b), function1, function12);
                Transition transition2 = Transition.this;
                c(deferredAnimationDataB);
                transition2.c(deferredAnimationDataB.b());
            }
            Transition transition3 = Transition.this;
            deferredAnimationDataB.p(function12);
            deferredAnimationDataB.q(function1);
            deferredAnimationDataB.r(transition3.o());
            return deferredAnimationDataB;
        }

        public final DeferredAnimationData b() {
            return (DeferredAnimationData) this.f4204c.getValue();
        }

        public final void c(DeferredAnimationData deferredAnimationData) {
            this.f4204c.setValue(deferredAnimationData);
        }

        public final void d() {
            DeferredAnimationData deferredAnimationDataB = b();
            if (deferredAnimationDataB != null) {
                Transition transition = Transition.this;
                deferredAnimationDataB.b().L(deferredAnimationDataB.i().invoke(transition.o().c()), deferredAnimationDataB.i().invoke(transition.o().a()), (FiniteAnimationSpec) deferredAnimationDataB.n().invoke(transition.o()));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Segment<S> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
        }

        Object a();

        Object c();

        default boolean d(Object obj, Object obj2) {
            return Intrinsics.areEqual(obj, c()) && Intrinsics.areEqual(obj2, a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SegmentImpl<S> implements Segment<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f4210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f4211b;

        public SegmentImpl(Object obj, Object obj2) {
            this.f4210a = obj;
            this.f4211b = obj2;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public Object a() {
            return this.f4211b;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public Object c() {
            return this.f4210a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Segment)) {
                return false;
            }
            Segment segment = (Segment) obj;
            return Intrinsics.areEqual(c(), segment.c()) && Intrinsics.areEqual(a(), segment.a());
        }

        public int hashCode() {
            Object objC = c();
            int iHashCode = (objC != null ? objC.hashCode() : 0) * 31;
            Object objA = a();
            return iHashCode + (objA != null ? objA.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TwoWayConverter f4212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MutableState f4214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SpringSpec f4215d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MutableState f4216f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final MutableState f4217g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private SeekableTransitionState.SeekingAnimationState f4218h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private TargetBasedAnimation f4219i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final MutableState f4220j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final MutableFloatState f4221k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f4222l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final MutableState f4223m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private AnimationVector f4224n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final MutableLongState f4225o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f4226p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final FiniteAnimationSpec f4227q;

        public TransitionAnimationState(Object obj, AnimationVector animationVector, TwoWayConverter twoWayConverter, String str) {
            Object objInvoke;
            this.f4212a = twoWayConverter;
            this.f4213b = str;
            this.f4214c = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
            SpringSpec springSpecL = AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
            this.f4215d = springSpecL;
            this.f4216f = SnapshotStateKt__SnapshotStateKt.e(springSpecL, null, 2, null);
            this.f4217g = SnapshotStateKt__SnapshotStateKt.e(new TargetBasedAnimation(n(), twoWayConverter, obj, v(), animationVector), null, 2, null);
            this.f4220j = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
            this.f4221k = PrimitiveSnapshotStateKt.a(-1.0f);
            this.f4223m = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
            this.f4224n = animationVector;
            this.f4225o = SnapshotLongStateKt.a(i().d());
            Float f3 = (Float) VisibilityThresholdsKt.h().get(twoWayConverter);
            if (f3 != null) {
                float fFloatValue = f3.floatValue();
                AnimationVector animationVector2 = (AnimationVector) twoWayConverter.a().invoke(obj);
                int iB = animationVector2.b();
                for (int i3 = 0; i3 < iB; i3++) {
                    animationVector2.e(i3, fFloatValue);
                }
                objInvoke = this.f4212a.b().invoke(animationVector2);
            } else {
                objInvoke = null;
            }
            this.f4227q = AnimationSpecKt.l(0.0f, 0.0f, objInvoke, 3, null);
        }

        private final void B(TargetBasedAnimation targetBasedAnimation) {
            this.f4217g.setValue(targetBasedAnimation);
        }

        private final void C(FiniteAnimationSpec finiteAnimationSpec) {
            this.f4216f.setValue(finiteAnimationSpec);
        }

        private final void H(Object obj) {
            this.f4214c.setValue(obj);
        }

        private final void J(Object obj, boolean z2) {
            TargetBasedAnimation targetBasedAnimation = this.f4219i;
            if (Intrinsics.areEqual(targetBasedAnimation != null ? targetBasedAnimation.g() : null, v())) {
                B(new TargetBasedAnimation(this.f4227q, this.f4212a, obj, obj, AnimationVectorsKt.g(this.f4224n)));
                this.f4222l = true;
                D(i().d());
                return;
            }
            AnimationSpec animationSpecN = (!z2 || this.f4226p || (n() instanceof SpringSpec)) ? n() : this.f4227q;
            if (Transition.this.n() > 0) {
                animationSpecN = AnimationSpecKt.c(animationSpecN, Transition.this.n());
            }
            B(new TargetBasedAnimation(animationSpecN, this.f4212a, obj, v(), this.f4224n));
            D(i().d());
            this.f4222l = false;
            Transition.this.x();
        }

        static /* synthetic */ void K(TransitionAnimationState transitionAnimationState, Object obj, boolean z2, int i3, Object obj2) {
            if ((i3 & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            if ((i3 & 2) != 0) {
                z2 = false;
            }
            transitionAnimationState.J(obj, z2);
        }

        private final Object v() {
            return this.f4214c.getValue();
        }

        public final void A(long j3) {
            if (r() == -1.0f) {
                this.f4226p = true;
                if (Intrinsics.areEqual(i().g(), i().i())) {
                    I(i().g());
                } else {
                    I(i().f(j3));
                    this.f4224n = i().b(j3);
                }
            }
        }

        public final void D(long j3) {
            this.f4225o.t(j3);
        }

        public final void E(boolean z2) {
            this.f4220j.setValue(Boolean.valueOf(z2));
        }

        public final void F(SeekableTransitionState.SeekingAnimationState seekingAnimationState) {
            if (!Intrinsics.areEqual(i().g(), i().i())) {
                this.f4219i = i();
                this.f4218h = seekingAnimationState;
            }
            B(new TargetBasedAnimation(this.f4227q, this.f4212a, getValue(), getValue(), AnimationVectorsKt.g(this.f4224n)));
            D(i().d());
            this.f4222l = true;
        }

        public final void G(float f3) {
            this.f4221k.s(f3);
        }

        public void I(Object obj) {
            this.f4223m.setValue(obj);
        }

        public final void L(Object obj, Object obj2, FiniteAnimationSpec finiteAnimationSpec) {
            H(obj2);
            C(finiteAnimationSpec);
            if (Intrinsics.areEqual(i().i(), obj) && Intrinsics.areEqual(i().g(), obj2)) {
                return;
            }
            K(this, obj, false, 2, null);
        }

        public final void M() {
            TargetBasedAnimation targetBasedAnimation;
            SeekableTransitionState.SeekingAnimationState seekingAnimationState = this.f4218h;
            if (seekingAnimationState == null || (targetBasedAnimation = this.f4219i) == null) {
                return;
            }
            long jE = MathKt.e(seekingAnimationState.c() * ((double) seekingAnimationState.g()));
            Object objF = targetBasedAnimation.f(jE);
            if (this.f4222l) {
                i().k(objF);
            }
            i().j(objF);
            D(i().d());
            if (r() == -2.0f || this.f4222l) {
                I(objF);
            } else {
                A(Transition.this.n());
            }
            if (jE < seekingAnimationState.c()) {
                seekingAnimationState.k(false);
            } else {
                this.f4218h = null;
                this.f4219i = null;
            }
        }

        public final void N(Object obj, FiniteAnimationSpec finiteAnimationSpec) {
            if (this.f4222l) {
                TargetBasedAnimation targetBasedAnimation = this.f4219i;
                if (Intrinsics.areEqual(obj, targetBasedAnimation != null ? targetBasedAnimation.g() : null)) {
                    return;
                }
            }
            if (Intrinsics.areEqual(v(), obj) && r() == -1.0f) {
                return;
            }
            H(obj);
            C(finiteAnimationSpec);
            J(r() == -3.0f ? obj : getValue(), !w());
            E(r() == -3.0f);
            if (r() >= 0.0f) {
                I(i().f((long) (i().d() * r())));
            } else if (r() == -3.0f) {
                I(obj);
            }
            this.f4222l = false;
            G(-1.0f);
        }

        public final void b() {
            this.f4219i = null;
            this.f4218h = null;
            this.f4222l = false;
        }

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.f4223m.getValue();
        }

        public final TargetBasedAnimation i() {
            return (TargetBasedAnimation) this.f4217g.getValue();
        }

        public final FiniteAnimationSpec n() {
            return (FiniteAnimationSpec) this.f4216f.getValue();
        }

        public final long p() {
            return this.f4225o.d();
        }

        public final SeekableTransitionState.SeekingAnimationState q() {
            return this.f4218h;
        }

        public final float r() {
            return this.f4221k.c();
        }

        public String toString() {
            return "current value: " + getValue() + ", target: " + v() + ", spec: " + n();
        }

        public final boolean w() {
            return ((Boolean) this.f4220j.getValue()).booleanValue();
        }

        public final void x(long j3, boolean z2) {
            if (z2) {
                j3 = i().d();
            }
            I(i().f(j3));
            this.f4224n = i().b(j3);
            if (i().c(j3)) {
                E(true);
            }
        }

        public final void y() {
            G(-2.0f);
        }

        public final void z(float f3) {
            if (f3 != -4.0f && f3 != -5.0f) {
                G(f3);
                return;
            }
            TargetBasedAnimation targetBasedAnimation = this.f4219i;
            if (targetBasedAnimation != null) {
                i().j(targetBasedAnimation.g());
                this.f4218h = null;
                this.f4219i = null;
            }
            Object objI = f3 == -4.0f ? i().i() : i().g();
            i().j(objI);
            i().k(objI);
            I(objI);
            D(i().d());
        }
    }

    public Transition(TransitionState transitionState, Transition transition, String str) {
        this.f4189a = transitionState;
        this.f4190b = transition;
        this.f4191c = str;
        this.f4192d = SnapshotStateKt__SnapshotStateKt.e(i(), null, 2, null);
        this.f4193e = SnapshotStateKt__SnapshotStateKt.e(new SegmentImpl(i(), i()), null, 2, null);
        this.f4194f = SnapshotLongStateKt.a(0L);
        this.f4195g = SnapshotLongStateKt.a(Long.MIN_VALUE);
        Boolean bool = Boolean.FALSE;
        this.f4196h = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f4197i = SnapshotStateKt.f();
        this.f4198j = SnapshotStateKt.f();
        this.f4199k = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f4201m = SnapshotStateKt.e(new Function0<Long>() { // from class: androidx.compose.animation.core.Transition$totalDurationNanos$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(this.f4240a.f());
            }
        });
        transitionState.f(this);
    }

    private final void M(Segment segment) {
        this.f4193e.setValue(segment);
    }

    private final void P(boolean z2) {
        this.f4196h.setValue(Boolean.valueOf(z2));
    }

    private final void Q(long j3) {
        this.f4194f.t(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final long f() {
        SnapshotStateList snapshotStateList = this.f4197i;
        int size = snapshotStateList.size();
        long jMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jMax = Math.max(jMax, ((TransitionAnimationState) snapshotStateList.get(i3)).p());
        }
        SnapshotStateList snapshotStateList2 = this.f4198j;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            jMax = Math.max(jMax, ((Transition) snapshotStateList2.get(i4)).f());
        }
        return jMax;
    }

    private final boolean t() {
        return ((Boolean) this.f4196h.getValue()).booleanValue();
    }

    private final long u() {
        return this.f4194f.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        P(true);
        if (w()) {
            SnapshotStateList snapshotStateList = this.f4197i;
            int size = snapshotStateList.size();
            long jMax = 0;
            for (int i3 = 0; i3 < size; i3++) {
                TransitionAnimationState transitionAnimationState = (TransitionAnimationState) snapshotStateList.get(i3);
                jMax = Math.max(jMax, transitionAnimationState.p());
                transitionAnimationState.A(this.f4200l);
            }
            P(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(long j3, boolean z2) {
        boolean z3 = true;
        if (p() == Long.MIN_VALUE) {
            C(j3);
        } else if (!this.f4189a.c()) {
            this.f4189a.e(true);
        }
        P(false);
        SnapshotStateList snapshotStateList = this.f4197i;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            TransitionAnimationState transitionAnimationState = (TransitionAnimationState) snapshotStateList.get(i3);
            if (!transitionAnimationState.w()) {
                transitionAnimationState.x(j3, z2);
            }
            if (!transitionAnimationState.w()) {
                z3 = false;
            }
        }
        SnapshotStateList snapshotStateList2 = this.f4198j;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Transition transition = (Transition) snapshotStateList2.get(i4);
            if (!Intrinsics.areEqual(transition.q(), transition.i())) {
                transition.A(j3, z2);
            }
            if (!Intrinsics.areEqual(transition.q(), transition.i())) {
                z3 = false;
            }
        }
        if (z3) {
            B();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
        N(Long.MIN_VALUE);
        TransitionState transitionState = this.f4189a;
        if (transitionState instanceof MutableTransitionState) {
            transitionState.d(q());
        }
        K(0L);
        this.f4189a.e(false);
        SnapshotStateList snapshotStateList = this.f4198j;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Transition) snapshotStateList.get(i3)).B();
        }
    }

    public final void C(long j3) {
        N(j3);
        this.f4189a.e(true);
    }

    public final void D(DeferredAnimation deferredAnimation) {
        TransitionAnimationState transitionAnimationStateB;
        DeferredAnimation.DeferredAnimationData deferredAnimationDataB = deferredAnimation.b();
        if (deferredAnimationDataB == null || (transitionAnimationStateB = deferredAnimationDataB.b()) == null) {
            return;
        }
        E(transitionAnimationStateB);
    }

    public final void E(TransitionAnimationState transitionAnimationState) {
        this.f4197i.remove(transitionAnimationState);
    }

    public final boolean F(Transition transition) {
        return this.f4198j.remove(transition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G(float f3) {
        SnapshotStateList snapshotStateList = this.f4197i;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((TransitionAnimationState) snapshotStateList.get(i3)).z(f3);
        }
        SnapshotStateList snapshotStateList2 = this.f4198j;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((Transition) snapshotStateList2.get(i4)).G(f3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H(Object obj, Object obj2, long j3) {
        N(Long.MIN_VALUE);
        this.f4189a.e(false);
        if (!w() || !Intrinsics.areEqual(i(), obj) || !Intrinsics.areEqual(q(), obj2)) {
            if (!Intrinsics.areEqual(i(), obj)) {
                TransitionState transitionState = this.f4189a;
                if (transitionState instanceof MutableTransitionState) {
                    transitionState.d(obj);
                }
            }
            O(obj2);
            L(true);
            M(new SegmentImpl(obj, obj2));
        }
        SnapshotStateList snapshotStateList = this.f4198j;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Transition transition = (Transition) snapshotStateList.get(i3);
            Intrinsics.checkNotNull(transition, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if (transition.w()) {
                transition.H(transition.i(), transition.q(), j3);
            }
        }
        SnapshotStateList snapshotStateList2 = this.f4197i;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((TransitionAnimationState) snapshotStateList2.get(i4)).A(j3);
        }
        this.f4200l = j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I(long j3) {
        if (p() == Long.MIN_VALUE) {
            N(j3);
        }
        K(j3);
        P(false);
        SnapshotStateList snapshotStateList = this.f4197i;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((TransitionAnimationState) snapshotStateList.get(i3)).A(j3);
        }
        SnapshotStateList snapshotStateList2 = this.f4198j;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Transition transition = (Transition) snapshotStateList2.get(i4);
            if (!Intrinsics.areEqual(transition.q(), transition.i())) {
                transition.I(j3);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J(SeekableTransitionState.SeekingAnimationState seekingAnimationState) {
        SnapshotStateList snapshotStateList = this.f4197i;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((TransitionAnimationState) snapshotStateList.get(i3)).F(seekingAnimationState);
        }
        SnapshotStateList snapshotStateList2 = this.f4198j;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((Transition) snapshotStateList2.get(i4)).J(seekingAnimationState);
        }
    }

    public final void K(long j3) {
        if (this.f4190b == null) {
            Q(j3);
        }
    }

    public final void L(boolean z2) {
        this.f4199k.setValue(Boolean.valueOf(z2));
    }

    public final void N(long j3) {
        this.f4195g.t(j3);
    }

    public final void O(Object obj) {
        this.f4192d.setValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R() {
        SnapshotStateList snapshotStateList = this.f4197i;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((TransitionAnimationState) snapshotStateList.get(i3)).M();
        }
        SnapshotStateList snapshotStateList2 = this.f4198j;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((Transition) snapshotStateList2.get(i4)).R();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(Object obj) {
        if (Intrinsics.areEqual(q(), obj)) {
            return;
        }
        M(new SegmentImpl(q(), obj));
        if (!Intrinsics.areEqual(i(), q())) {
            this.f4189a.d(q());
        }
        O(obj);
        if (!v()) {
            P(true);
        }
        SnapshotStateList snapshotStateList = this.f4197i;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((TransitionAnimationState) snapshotStateList.get(i3)).y();
        }
    }

    public final boolean c(TransitionAnimationState transitionAnimationState) {
        return this.f4197i.add(transitionAnimationState);
    }

    public final boolean d(Transition transition) {
        return this.f4198j.add(transition);
    }

    public final void e(final Object obj, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1493585151);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(obj) : composerK.I(obj) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1493585151, i4, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1176)");
            }
            if (w()) {
                composerK.a0(1824284987);
                composerK.U();
            } else {
                composerK.a0(1822801203);
                S(obj);
                if (!Intrinsics.areEqual(obj, i()) || v() || t()) {
                    composerK.a0(1823032494);
                    Object objG = composerK.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                        composerK.w(objG);
                    }
                    final CoroutineScope coroutineScope = (CoroutineScope) objG;
                    int i5 = i4 & 112;
                    boolean zI = composerK.I(coroutineScope) | (i5 == 32);
                    Object objG2 = composerK.G();
                    if (zI || objG2 == companion.a()) {
                        objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1

                            /* JADX INFO: renamed from: androidx.compose.animation.core.Transition$animateTo$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            @Metadata
                            @DebugMetadata(c = "androidx.compose.animation.core.Transition$animateTo$1$1$1", f = "Transition.kt", l = {1192}, m = "invokeSuspend")
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                float f4231a;

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                int f4232b;

                                /* JADX INFO: renamed from: c, reason: collision with root package name */
                                private /* synthetic */ Object f4233c;

                                /* JADX INFO: renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Transition f4234d;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Transition transition, Continuation continuation) {
                                    super(2, continuation);
                                    this.f4234d = transition;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Object obj, Continuation continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f4234d, continuation);
                                    anonymousClass1.f4233c = obj;
                                    return anonymousClass1;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) throws Throwable {
                                    final float fO;
                                    CoroutineScope coroutineScope;
                                    Object objF = IntrinsicsKt.f();
                                    int i3 = this.f4232b;
                                    if (i3 == 0) {
                                        ResultKt.b(obj);
                                        CoroutineScope coroutineScope2 = (CoroutineScope) this.f4233c;
                                        fO = SuspendAnimationKt.o(coroutineScope2.getCoroutineContext());
                                        coroutineScope = coroutineScope2;
                                    } else {
                                        if (i3 != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        fO = this.f4231a;
                                        coroutineScope = (CoroutineScope) this.f4233c;
                                        ResultKt.b(obj);
                                    }
                                    while (CoroutineScopeKt.h(coroutineScope)) {
                                        final Transition transition = this.f4234d;
                                        Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.Transition.animateTo.1.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public final void c(long j3) {
                                                if (transition.w()) {
                                                    return;
                                                }
                                                transition.z(j3, fO);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                c(((Number) obj2).longValue());
                                                return Unit.f139807a;
                                            }
                                        };
                                        this.f4233c = coroutineScope;
                                        this.f4231a = fO;
                                        this.f4232b = 1;
                                        if (MonotonicFrameClockKt.c(function1, this) == objF) {
                                            return objF;
                                        }
                                    }
                                    return Unit.f139807a;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                BuildersKt__Builders_commonKt.d(coroutineScope, null, CoroutineStart.f140919d, new AnonymousClass1(this, null), 1, null);
                                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        composerK.w(objG2);
                    }
                    EffectsKt.b(coroutineScope, this, (Function1) objG2, composerK, i5);
                    composerK.U();
                } else {
                    composerK.a0(1824275067);
                    composerK.U();
                }
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.core.Transition$animateTo$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    this.f4237a.e(obj, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        SnapshotStateList snapshotStateList = this.f4197i;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((TransitionAnimationState) snapshotStateList.get(i3)).b();
        }
        SnapshotStateList snapshotStateList2 = this.f4198j;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((Transition) snapshotStateList2.get(i4)).g();
        }
    }

    public final List h() {
        return this.f4197i;
    }

    public final Object i() {
        return this.f4189a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean j() {
        SnapshotStateList snapshotStateList = this.f4197i;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((TransitionAnimationState) snapshotStateList.get(i3)).q() != null) {
                return true;
            }
        }
        SnapshotStateList snapshotStateList2 = this.f4198j;
        int size2 = snapshotStateList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (((Transition) snapshotStateList2.get(i4)).j()) {
                return true;
            }
        }
        return false;
    }

    public final String k() {
        return this.f4191c;
    }

    public final long l() {
        return this.f4200l;
    }

    public final Transition m() {
        return this.f4190b;
    }

    public final long n() {
        Transition transition = this.f4190b;
        return transition != null ? transition.n() : u();
    }

    public final Segment o() {
        return (Segment) this.f4193e.getValue();
    }

    public final long p() {
        return this.f4195g.d();
    }

    public final Object q() {
        return this.f4192d.getValue();
    }

    public final long r() {
        return ((Number) this.f4201m.getValue()).longValue();
    }

    public final List s() {
        return this.f4198j;
    }

    public String toString() {
        List listH = h();
        int size = listH.size();
        String str = "Transition animation values: ";
        for (int i3 = 0; i3 < size; i3++) {
            str = str + ((TransitionAnimationState) listH.get(i3)) + ", ";
        }
        return str;
    }

    public final boolean v() {
        return p() != Long.MIN_VALUE;
    }

    public final boolean w() {
        return ((Boolean) this.f4199k.getValue()).booleanValue();
    }

    public final void y() {
        B();
        this.f4189a.g();
    }

    public final void z(long j3, float f3) {
        if (p() == Long.MIN_VALUE) {
            C(j3);
        }
        long jP = j3 - p();
        if (f3 != 0.0f) {
            jP = MathKt.e(jP / ((double) f3));
        }
        K(jP);
        A(jP, f3 == 0.0f);
    }

    public Transition(TransitionState transitionState, String str) {
        this(transitionState, null, str);
    }

    public Transition(Object obj, String str) {
        this(new MutableTransitionState(obj), null, str);
    }
}
