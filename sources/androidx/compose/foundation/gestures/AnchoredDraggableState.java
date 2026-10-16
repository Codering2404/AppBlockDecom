package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

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
public final class AnchoredDraggableState<T> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f5478p = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function1 f5479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1 f5480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0 f5481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimationSpec f5482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DecayAnimationSpec f5483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutatorMutex f5484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f5485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f5486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final State f5487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableFloatState f5488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final State f5489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableFloatState f5490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableState f5491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableState f5492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AnchoredDraggableState$anchoredDragScope$1 f5493o;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f5494a = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AnchoredDraggableState(Object obj) {
        this.f5479a = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$confirmValueChange$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2) {
                return Boolean.TRUE;
            }
        };
        this.f5484f = new MutatorMutex();
        this.f5485g = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f5486h = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f5487i = SnapshotStateKt.e(new Function0<T>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$targetValue$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object objP = this.f5534a.p();
                if (objP != null) {
                    return objP;
                }
                AnchoredDraggableState anchoredDraggableState = this.f5534a;
                if (Float.isNaN(anchoredDraggableState.r())) {
                    return anchoredDraggableState.n();
                }
                Object objB = anchoredDraggableState.l().b(anchoredDraggableState.r());
                return objB == null ? anchoredDraggableState.n() : objB;
            }
        });
        this.f5488j = PrimitiveSnapshotStateKt.a(Float.NaN);
        this.f5489k = SnapshotStateKt.d(SnapshotStateKt.r(), new Function0<Float>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$progress$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float fC = this.f5533a.l().c(this.f5533a.t());
                float fC2 = this.f5533a.l().c(this.f5533a.v()) - fC;
                float fAbs = Math.abs(fC2);
                float f3 = 1.0f;
                if (!Float.isNaN(fAbs) && fAbs > 1.0E-6f) {
                    float fA = (this.f5533a.A() - fC) / fC2;
                    if (fA < 1.0E-6f) {
                        f3 = 0.0f;
                    } else if (fA <= 0.999999f) {
                        f3 = fA;
                    }
                }
                return Float.valueOf(f3);
            }
        });
        this.f5490l = PrimitiveSnapshotStateKt.a(0.0f);
        this.f5491m = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f5492n = SnapshotStateKt__SnapshotStateKt.e(AnchoredDraggableKt.p(), null, 2, null);
        this.f5493o = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(Object obj) {
        this.f5485g.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Object obj) {
        this.f5491m.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(float f3) {
        this.f5490l.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(float f3) {
        this.f5488j.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(Object obj) {
        this.f5486h.setValue(obj);
    }

    public static /* synthetic */ Object j(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            mutatePriority = MutatePriority.f5071a;
        }
        return anchoredDraggableState.h(mutatePriority, function3, continuation);
    }

    public static /* synthetic */ Object k(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function4 function4, Continuation continuation, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            mutatePriority = MutatePriority.f5071a;
        }
        return anchoredDraggableState.i(obj, mutatePriority, function4, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p() {
        return this.f5491m.getValue();
    }

    public final float A() {
        if (Float.isNaN(r())) {
            InlineClassHelperKt.c("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return r();
    }

    public final void C(DecayAnimationSpec decayAnimationSpec) {
        this.f5483e = decayAnimationSpec;
    }

    public final void G(Function1 function1) {
        this.f5480b = function1;
    }

    public final void I(AnimationSpec animationSpec) {
        this.f5482d = animationSpec;
    }

    public final void J(Function0 function0) {
        this.f5481c = function0;
    }

    public final Object K(float f3, Continuation continuation) {
        if (!w()) {
            InlineClassHelperKt.a("AnchoredDraggableState was configured through a constructor without providing positional and velocity threshold. This overload of settle has been deprecated. Please refer to AnchoredDraggableState#settle(animationSpec) for more information.");
        }
        Object objN = n();
        Object objO = AnchoredDraggableKt.o(l(), A(), f3, s(), x());
        return ((Boolean) this.f5479a.invoke(objO)).booleanValue() ? AnchoredDraggableKt.m(this, objO, f3, null, null, continuation, 12, null) : AnchoredDraggableKt.m(this, objN, f3, null, null, continuation, 12, null);
    }

    public final Object h(MutatePriority mutatePriority, Function3 function3, Continuation continuation) {
        Object objD = this.f5484f.d(mutatePriority, new AnchoredDraggableState$anchoredDrag$2(this, function3, null), continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(java.lang.Object r6, androidx.compose.foundation.MutatePriority r7, kotlin.jvm.functions.Function4 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3) r0
            int r1 = r0.f5518d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5518d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f5516b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f5518d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f5515a
            androidx.compose.foundation.gestures.AnchoredDraggableState r6 = (androidx.compose.foundation.gestures.AnchoredDraggableState) r6
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2e
            goto L58
        L2e:
            r7 = move-exception
            goto L5e
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.b(r9)
            androidx.compose.foundation.gestures.DraggableAnchors r9 = r5.l()
            boolean r9 = r9.d(r6)
            if (r9 == 0) goto L62
            androidx.compose.foundation.MutatorMutex r9 = r5.f5484f     // Catch: java.lang.Throwable -> L5c
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4 r2 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4     // Catch: java.lang.Throwable -> L5c
            r2.<init>(r5, r6, r8, r4)     // Catch: java.lang.Throwable -> L5c
            r0.f5515a = r5     // Catch: java.lang.Throwable -> L5c
            r0.f5518d = r3     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r6 = r9.d(r7, r2, r0)     // Catch: java.lang.Throwable -> L5c
            if (r6 != r1) goto L57
            return r1
        L57:
            r6 = r5
        L58:
            r6.D(r4)
            goto L76
        L5c:
            r7 = move-exception
            r6 = r5
        L5e:
            r6.D(r4)
            throw r7
        L62:
            kotlin.jvm.functions.Function1 r7 = r5.f5479a
            java.lang.Object r7 = r7.invoke(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L76
            r5.H(r6)
            r5.B(r6)
        L76:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableState.i(java.lang.Object, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final DraggableAnchors l() {
        return (DraggableAnchors) this.f5492n.getValue();
    }

    public final Function1 m() {
        return this.f5479a;
    }

    public final Object n() {
        return this.f5485g.getValue();
    }

    public final DecayAnimationSpec o() {
        DecayAnimationSpec decayAnimationSpec = this.f5483e;
        if (decayAnimationSpec != null) {
            return decayAnimationSpec;
        }
        Intrinsics.throwUninitializedPropertyAccessException("decayAnimationSpec");
        return null;
    }

    public final float q() {
        return this.f5490l.c();
    }

    public final float r() {
        return this.f5488j.c();
    }

    public final Function1 s() {
        Function1 function1 = this.f5480b;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
        return null;
    }

    public final Object t() {
        return this.f5486h.getValue();
    }

    public final AnimationSpec u() {
        AnimationSpec animationSpec = this.f5482d;
        if (animationSpec != null) {
            return animationSpec;
        }
        Intrinsics.throwUninitializedPropertyAccessException("snapAnimationSpec");
        return null;
    }

    public final Object v() {
        return this.f5487i.getValue();
    }

    public final boolean w() {
        return (this.f5480b == null || this.f5481c == null || this.f5482d == null || this.f5483e == null) ? false : true;
    }

    public final Function0 x() {
        Function0 function0 = this.f5481c;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityThreshold");
        return null;
    }

    public final boolean y() {
        return p() != null;
    }

    public final float z(float f3) {
        return RangesKt.o((Float.isNaN(r()) ? 0.0f : r()) + f3, l().e(), l().f());
    }

    public AnchoredDraggableState(Object obj, Function1 function1) {
        this(obj);
        this.f5479a = function1;
    }
}
