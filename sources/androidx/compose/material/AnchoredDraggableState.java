package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnchoredDraggableState<T> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f11688p = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f11689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f11690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimationSpec f11691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f11692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final InternalMutatorMutex f11693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DraggableState f11694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f11695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final State f11696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final State f11697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableFloatState f11698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final State f11699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableFloatState f11700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableState f11701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableState f11702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AnchoredDragScope f11703o;

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f11704a = new AnonymousClass1();

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
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AnchoredDraggableState(Object obj, Function1 function1, Function0 function0, AnimationSpec animationSpec, Function1 function12) {
        this.f11689a = function1;
        this.f11690b = function0;
        this.f11691c = animationSpec;
        this.f11692d = function12;
        this.f11693e = new InternalMutatorMutex();
        this.f11694f = new AnchoredDraggableState$draggableState$1(this);
        this.f11695g = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f11696h = SnapshotStateKt.e(new Function0<T>() { // from class: androidx.compose.material.AnchoredDraggableState$targetValue$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object objT = this.f11745a.t();
                if (objT != null) {
                    return objT;
                }
                AnchoredDraggableState anchoredDraggableState = this.f11745a;
                float fW = anchoredDraggableState.w();
                return !Float.isNaN(fW) ? anchoredDraggableState.l(fW, anchoredDraggableState.s(), 0.0f) : anchoredDraggableState.s();
            }
        });
        this.f11697i = SnapshotStateKt.e(new Function0<T>() { // from class: androidx.compose.material.AnchoredDraggableState$closestValue$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object objT = this.f11737a.t();
                if (objT != null) {
                    return objT;
                }
                AnchoredDraggableState anchoredDraggableState = this.f11737a;
                float fW = anchoredDraggableState.w();
                return !Float.isNaN(fW) ? anchoredDraggableState.m(fW, anchoredDraggableState.s()) : anchoredDraggableState.s();
            }
        });
        this.f11698j = PrimitiveSnapshotStateKt.a(Float.NaN);
        this.f11699k = SnapshotStateKt.d(SnapshotStateKt.r(), new Function0<Float>() { // from class: androidx.compose.material.AnchoredDraggableState$progress$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float fC = this.f11744a.o().c(this.f11744a.s());
                float fC2 = this.f11744a.o().c(this.f11744a.q()) - fC;
                float fAbs = Math.abs(fC2);
                float f3 = 1.0f;
                if (!Float.isNaN(fAbs) && fAbs > 1.0E-6f) {
                    float fA = (this.f11744a.A() - fC) / fC2;
                    if (fA < 1.0E-6f) {
                        f3 = 0.0f;
                    } else if (fA <= 0.999999f) {
                        f3 = fA;
                    }
                }
                return Float.valueOf(f3);
            }
        });
        this.f11700l = PrimitiveSnapshotStateKt.a(0.0f);
        this.f11701m = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f11702n = SnapshotStateKt__SnapshotStateKt.e(AnchoredDraggableKt.i(), null, 2, null);
        this.f11703o = new AnchoredDragScope() { // from class: androidx.compose.material.AnchoredDraggableState$anchoredDragScope$1
            @Override // androidx.compose.material.AnchoredDragScope
            public void a(float f3, float f4) {
                this.f11736a.F(f3);
                this.f11736a.E(f4);
            }
        };
    }

    private final void B(DraggableAnchors draggableAnchors) {
        this.f11702n.setValue(draggableAnchors);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(Object obj) {
        this.f11695g.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Object obj) {
        this.f11701m.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(float f3) {
        this.f11700l.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(float f3) {
        this.f11698j.s(f3);
    }

    private final boolean H(final Object obj) {
        return this.f11693e.e(new Function0<Unit>() { // from class: androidx.compose.material.AnchoredDraggableState$trySnapTo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m113invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m113invoke() {
                AnchoredDragScope anchoredDragScope = this.f11746a.f11703o;
                AnchoredDraggableState anchoredDraggableState = this.f11746a;
                Object obj2 = obj;
                float fC = anchoredDraggableState.o().c(obj2);
                if (!Float.isNaN(fC)) {
                    AnchoredDragScope.b(anchoredDragScope, fC, 0.0f, 2, null);
                    anchoredDraggableState.D(null);
                }
                anchoredDraggableState.C(obj2);
            }
        });
    }

    public static /* synthetic */ void J(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i3, Object obj2) {
        if ((i3 & 2) != 0 && (Float.isNaN(anchoredDraggableState.w()) || (obj = draggableAnchors.b(anchoredDraggableState.w())) == null)) {
            obj = anchoredDraggableState.x();
        }
        anchoredDraggableState.I(draggableAnchors, obj);
    }

    public static /* synthetic */ Object k(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function4 function4, Continuation continuation, int i3, Object obj2) throws Throwable {
        if ((i3 & 2) != 0) {
            mutatePriority = MutatePriority.f5071a;
        }
        return anchoredDraggableState.j(obj, mutatePriority, function4, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(float f3, Object obj, float f4) {
        DraggableAnchors draggableAnchorsO = o();
        float fC = draggableAnchorsO.c(obj);
        float fFloatValue = ((Number) this.f11690b.invoke()).floatValue();
        if (fC != f3 && !Float.isNaN(fC)) {
            if (fC < f3) {
                if (f4 >= fFloatValue) {
                    Object objA = draggableAnchorsO.a(f3, true);
                    Intrinsics.checkNotNull(objA);
                    return objA;
                }
                Object objA2 = draggableAnchorsO.a(f3, true);
                Intrinsics.checkNotNull(objA2);
                if (f3 >= Math.abs(fC + Math.abs(((Number) this.f11689a.invoke(Float.valueOf(Math.abs(draggableAnchorsO.c(objA2) - fC)))).floatValue()))) {
                    return objA2;
                }
            } else {
                if (f4 <= (-fFloatValue)) {
                    Object objA3 = draggableAnchorsO.a(f3, false);
                    Intrinsics.checkNotNull(objA3);
                    return objA3;
                }
                Object objA4 = draggableAnchorsO.a(f3, false);
                Intrinsics.checkNotNull(objA4);
                float fAbs = Math.abs(fC - Math.abs(((Number) this.f11689a.invoke(Float.valueOf(Math.abs(fC - draggableAnchorsO.c(objA4))))).floatValue()));
                if (f3 >= 0.0f ? f3 <= fAbs : Math.abs(f3) >= fAbs) {
                    return objA4;
                }
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(float f3, Object obj) {
        DraggableAnchors draggableAnchorsO = o();
        float fC = draggableAnchorsO.c(obj);
        if (fC != f3 && !Float.isNaN(fC)) {
            if (fC < f3) {
                Object objA = draggableAnchorsO.a(f3, true);
                if (objA != null) {
                    return objA;
                }
            } else {
                Object objA2 = draggableAnchorsO.a(f3, false);
                if (objA2 != null) {
                    return objA2;
                }
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t() {
        return this.f11701m.getValue();
    }

    public final float A() {
        if (Float.isNaN(w())) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return w();
    }

    public final Object G(float f3, Continuation continuation) throws Throwable {
        Object objS = s();
        Object objL = l(A(), objS, f3);
        if (((Boolean) this.f11692d.invoke(objL)).booleanValue()) {
            Object objF = AnchoredDraggableKt.f(this, objL, f3, continuation);
            return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
        }
        Object objF2 = AnchoredDraggableKt.f(this, objS, f3, continuation);
        return objF2 == IntrinsicsKt.f() ? objF2 : Unit.f139807a;
    }

    public final void I(DraggableAnchors draggableAnchors, Object obj) {
        if (Intrinsics.areEqual(o(), draggableAnchors)) {
            return;
        }
        B(draggableAnchors);
        if (H(obj)) {
            return;
        }
        D(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(java.lang.Object r7, androidx.compose.foundation.MutatePriority r8, kotlin.jvm.functions.Function4 r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableState.j(java.lang.Object, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float n(float f3) {
        float fZ = z(f3);
        float fW = Float.isNaN(w()) ? 0.0f : w();
        F(fZ);
        return fZ - fW;
    }

    public final DraggableAnchors o() {
        return (DraggableAnchors) this.f11702n.getValue();
    }

    public final AnimationSpec p() {
        return this.f11691c;
    }

    public final Object q() {
        return this.f11697i.getValue();
    }

    public final Function1 r() {
        return this.f11692d;
    }

    public final Object s() {
        return this.f11695g.getValue();
    }

    public final DraggableState u() {
        return this.f11694f;
    }

    public final float v() {
        return this.f11700l.c();
    }

    public final float w() {
        return this.f11698j.c();
    }

    public final Object x() {
        return this.f11696h.getValue();
    }

    public final boolean y() {
        return t() != null;
    }

    public final float z(float f3) {
        return RangesKt.o((Float.isNaN(w()) ? 0.0f : w()) + f3, o().e(), o().f());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(androidx.compose.foundation.MutatePriority r7, kotlin.jvm.functions.Function3 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material.AnchoredDraggableState$anchoredDrag$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.material.AnchoredDraggableState$anchoredDrag$1 r0 = (androidx.compose.material.AnchoredDraggableState$anchoredDrag$1) r0
            int r1 = r0.f11714d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11714d = r1
            goto L18
        L13:
            androidx.compose.material.AnchoredDraggableState$anchoredDrag$1 r0 = new androidx.compose.material.AnchoredDraggableState$anchoredDrag$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f11712b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f11714d
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L31
            java.lang.Object r7 = r0.f11711a
            androidx.compose.material.AnchoredDraggableState r7 = (androidx.compose.material.AnchoredDraggableState) r7
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2f
            goto L51
        L2f:
            r8 = move-exception
            goto L8a
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r8 = 0
            java.lang.String r8 = kotlin.experimental.kJ.HcgZcEUYo.kMFS
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.ResultKt.b(r9)
            androidx.compose.material.InternalMutatorMutex r9 = r6.f11693e     // Catch: java.lang.Throwable -> L88
            androidx.compose.material.AnchoredDraggableState$anchoredDrag$2 r2 = new androidx.compose.material.AnchoredDraggableState$anchoredDrag$2     // Catch: java.lang.Throwable -> L88
            r5 = 0
            r2.<init>(r6, r8, r5)     // Catch: java.lang.Throwable -> L88
            r0.f11711a = r6     // Catch: java.lang.Throwable -> L88
            r0.f11714d = r4     // Catch: java.lang.Throwable -> L88
            java.lang.Object r7 = r9.d(r7, r2, r0)     // Catch: java.lang.Throwable -> L88
            if (r7 != r1) goto L50
            return r1
        L50:
            r7 = r6
        L51:
            androidx.compose.material.DraggableAnchors r8 = r7.o()
            float r9 = r7.w()
            java.lang.Object r8 = r8.b(r9)
            if (r8 == 0) goto L85
            float r9 = r7.w()
            androidx.compose.material.DraggableAnchors r0 = r7.o()
            float r0 = r0.c(r8)
            float r9 = r9 - r0
            float r9 = java.lang.Math.abs(r9)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 > 0) goto L85
            kotlin.jvm.functions.Function1 r9 = r7.f11692d
            java.lang.Object r9 = r9.invoke(r8)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L85
            r7.C(r8)
        L85:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L88:
            r8 = move-exception
            r7 = r6
        L8a:
            androidx.compose.material.DraggableAnchors r9 = r7.o()
            float r0 = r7.w()
            java.lang.Object r9 = r9.b(r0)
            if (r9 == 0) goto Lbe
            float r0 = r7.w()
            androidx.compose.material.DraggableAnchors r1 = r7.o()
            float r1 = r1.c(r9)
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto Lbe
            kotlin.jvm.functions.Function1 r0 = r7.f11692d
            java.lang.Object r0 = r0.invoke(r9)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Lbe
            r7.C(r9)
        Lbe:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableState.i(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, Function1 function1, Function0 function0, AnimationSpec animationSpec, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, draggableAnchors, function1, function0, animationSpec, (i3 & 32) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material.AnchoredDraggableState.2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2) {
                return Boolean.TRUE;
            }
        } : function12);
    }

    public AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, Function1 function1, Function0 function0, AnimationSpec animationSpec, Function1 function12) {
        this(obj, function1, function0, animationSpec, function12);
        B(draggableAnchors);
        H(obj);
    }
}
