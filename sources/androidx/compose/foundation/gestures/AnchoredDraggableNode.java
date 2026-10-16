package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class AnchoredDraggableNode<T> extends DragGestureNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private AnchoredDraggableState f5445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Orientation f5446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Boolean f5447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private OverscrollEffect f5448p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Boolean f5449q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private FlingBehavior f5450r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FlingBehavior f5451s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Density f5452t;

    public AnchoredDraggableNode(AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z2, Boolean bool, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, Boolean bool2, FlingBehavior flingBehavior) {
        super(AnchoredDraggableKt.f5384a, z2, mutableInteractionSource, orientation);
        this.f5445m = anchoredDraggableState;
        this.f5446n = orientation;
        this.f5447o = bool;
        this.f5448p = overscrollEffect;
        this.f5449q = bool2;
        this.f5450r = flingBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object X2(float r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1) r0
            int r1 = r0.f5464d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f5464d = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1
            r0.<init>(r7, r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.f5462b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f5464d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r8 = r4.f5461a
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.b(r9)
            goto L73
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.ResultKt.b(r9)
            return r9
        L3e:
            kotlin.ResultKt.b(r9)
            androidx.compose.foundation.gestures.AnchoredDraggableState r9 = r7.f5445m
            boolean r9 = r9.w()
            if (r9 == 0) goto L55
            androidx.compose.foundation.gestures.AnchoredDraggableState r9 = r7.f5445m
            r4.f5464d = r3
            java.lang.Object r8 = r9.K(r8, r4)
            if (r8 != r0) goto L54
            goto L71
        L54:
            return r8
        L55:
            kotlin.jvm.internal.Ref$FloatRef r9 = new kotlin.jvm.internal.Ref$FloatRef
            r9.<init>()
            r9.f140141a = r8
            androidx.compose.foundation.gestures.AnchoredDraggableState r1 = r7.f5445m
            androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2 r3 = new androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2
            r5 = 0
            r3.<init>(r7, r9, r8, r5)
            r4.f5461a = r9
            r4.f5464d = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r8 = androidx.compose.foundation.gestures.AnchoredDraggableState.j(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L72
        L71:
            return r0
        L72:
            r8 = r9
        L73:
            float r8 = r8.f140141a
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.c(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableNode.X2(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean Z2() {
        Boolean bool = this.f5447o;
        if (bool == null) {
            return DelegatableNodeKt.n(this) == LayoutDirection.f30002b && this.f5446n == Orientation.f6032b;
        }
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long a3(long j3) {
        return Velocity.m(j3, Z2() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long b3(long j3) {
        return Offset.r(j3, Z2() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float d3(long j3) {
        return this.f5446n == Orientation.f6031a ? Velocity.i(j3) : Velocity.h(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float e3(long j3) {
        return Float.intBitsToFloat((int) (this.f5446n == Orientation.f6031a ? j3 & 4294967295L : j3 >> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long f3(float f3) {
        Orientation orientation = this.f5446n;
        float f4 = orientation == Orientation.f6032b ? f3 : 0.0f;
        if (orientation != Orientation.f6031a) {
            f3 = 0.0f;
        }
        return Offset.e((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long g3(float f3) {
        Orientation orientation = this.f5446n;
        float f4 = orientation == Orientation.f6032b ? f3 : 0.0f;
        if (orientation != Orientation.f6031a) {
            f3 = 0.0f;
        }
        return VelocityKt.a(f4, f3);
    }

    private final void i3() {
        Density densityK = DelegatableNodeKt.k(this);
        Density density = this.f5452t;
        if (density == null || !Intrinsics.areEqual(density, densityK)) {
            this.f5452t = densityK;
            j3(this.f5450r);
        }
    }

    private final void j3(FlingBehavior flingBehavior) {
        if (flingBehavior == null) {
            AnchoredDraggableDefaults anchoredDraggableDefaults = AnchoredDraggableDefaults.f5370a;
            AnimationSpec animationSpecC = anchoredDraggableDefaults.c();
            Function1 function1B = anchoredDraggableDefaults.b();
            Density densityK = DelegatableNodeKt.k(this);
            this.f5452t = densityK;
            flingBehavior = AnchoredDraggableKt.j(this.f5445m, densityK, function1B, animationSpecC);
        }
        c3(flingBehavior);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object B2(Function2 function2, Continuation continuation) {
        Object objJ = AnchoredDraggableState.j(this.f5445m, null, new AnchoredDraggableNode$drag$2(function2, this, null), continuation, 1, null);
        return objJ == IntrinsicsKt.f() ? objJ : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void G2(long j3) {
        if (isAttached()) {
            BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AnchoredDraggableNode$onDragStopped$1(this, j3, null), 3, null);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean K2() {
        Boolean bool = this.f5449q;
        return bool != null ? bool.booleanValue() : this.f5445m.y();
    }

    public final FlingBehavior Y2() {
        FlingBehavior flingBehavior = this.f5451s;
        if (flingBehavior != null) {
            return flingBehavior;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resolvedFlingBehavior");
        return null;
    }

    public final void c3(FlingBehavior flingBehavior) {
        this.f5451s = flingBehavior;
    }

    public final void h3(AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z2, Boolean bool, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, Boolean bool2, FlingBehavior flingBehavior) {
        boolean z3;
        boolean z4;
        this.f5450r = flingBehavior;
        if (Intrinsics.areEqual(this.f5445m, anchoredDraggableState)) {
            z3 = false;
        } else {
            this.f5445m = anchoredDraggableState;
            j3(flingBehavior);
            z3 = true;
        }
        if (this.f5446n != orientation) {
            this.f5446n = orientation;
            z3 = true;
        }
        if (Intrinsics.areEqual(this.f5447o, bool)) {
            z4 = z3;
        } else {
            this.f5447o = bool;
            z4 = true;
        }
        this.f5449q = bool2;
        this.f5448p = overscrollEffect;
        DragGestureNode.N2(this, null, z2, mutableInteractionSource, orientation, z4, 1, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        j3(this.f5450r);
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        u1();
        if (isAttached()) {
            i3();
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void F2(long j3) {
    }
}
