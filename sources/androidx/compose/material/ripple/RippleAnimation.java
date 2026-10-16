package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;

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
public final class RippleAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Offset f15355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f15356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Float f15358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Offset f15359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Animatable f15360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Animatable f15361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Animatable f15362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CompletableDeferred f15363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableState f15364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f15365k;

    public /* synthetic */ RippleAnimation(Offset offset, float f3, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(offset, f3, z2);
    }

    private final Object f(Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new RippleAnimation$fadeIn$2(this, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    private final Object g(Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new RippleAnimation$fadeOut$2(this, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    private final boolean i() {
        return ((Boolean) this.f15365k.getValue()).booleanValue();
    }

    private final boolean j() {
        return ((Boolean) this.f15364j.getValue()).booleanValue();
    }

    private final void k(boolean z2) {
        this.f15365k.setValue(Boolean.valueOf(z2));
    }

    private final void l(boolean z2) {
        this.f15364j.setValue(Boolean.valueOf(z2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r2.g(r0) != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.material.ripple.RippleAnimation$animate$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = (androidx.compose.material.ripple.RippleAnimation$animate$1) r0
            int r1 = r0.f15369d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15369d = r1
            goto L18
        L13:
            androidx.compose.material.ripple.RippleAnimation$animate$1 r0 = new androidx.compose.material.ripple.RippleAnimation$animate$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f15367b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f15369d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r7)
            goto L72
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            java.lang.Object r2 = r0.f15366a
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.b(r7)
            goto L66
        L3f:
            java.lang.Object r2 = r0.f15366a
            androidx.compose.material.ripple.RippleAnimation r2 = (androidx.compose.material.ripple.RippleAnimation) r2
            kotlin.ResultKt.b(r7)
            goto L56
        L47:
            kotlin.ResultKt.b(r7)
            r0.f15366a = r6
            r0.f15369d = r5
            java.lang.Object r7 = r6.f(r0)
            if (r7 != r1) goto L55
            goto L71
        L55:
            r2 = r6
        L56:
            r2.l(r5)
            kotlinx.coroutines.CompletableDeferred r7 = r2.f15363i
            r0.f15366a = r2
            r0.f15369d = r4
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L66
            goto L71
        L66:
            r7 = 0
            r0.f15366a = r7
            r0.f15369d = r3
            java.lang.Object r7 = r2.g(r0)
            if (r7 != r1) goto L72
        L71:
            return r1
        L72:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.RippleAnimation.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void e(DrawScope drawScope, long j3) {
        if (this.f15358d == null) {
            this.f15358d = Float.valueOf(RippleAnimationKt.b(drawScope.b()));
        }
        if (this.f15355a == null) {
            this.f15355a = Offset.d(drawScope.V1());
        }
        if (this.f15359e == null) {
            this.f15359e = Offset.d(OffsetKt.a(Size.i(drawScope.b()) / 2.0f, Size.g(drawScope.b()) / 2.0f));
        }
        float fFloatValue = (!i() || j()) ? ((Number) this.f15360f.n()).floatValue() : 1.0f;
        Float f3 = this.f15358d;
        Intrinsics.checkNotNull(f3);
        float fB = MathHelpersKt.b(f3.floatValue(), this.f15356b, ((Number) this.f15361g.n()).floatValue());
        Offset offset = this.f15355a;
        Intrinsics.checkNotNull(offset);
        float fM = Offset.m(offset.u());
        Offset offset2 = this.f15359e;
        Intrinsics.checkNotNull(offset2);
        float fB2 = MathHelpersKt.b(fM, Offset.m(offset2.u()), ((Number) this.f15362h.n()).floatValue());
        Offset offset3 = this.f15355a;
        Intrinsics.checkNotNull(offset3);
        float fN = Offset.n(offset3.u());
        Offset offset4 = this.f15359e;
        Intrinsics.checkNotNull(offset4);
        long jA = OffsetKt.a(fB2, MathHelpersKt.b(fN, Offset.n(offset4.u()), ((Number) this.f15362h.n()).floatValue()));
        long jR = Color.r(j3, Color.u(j3) * fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.f15357c) {
            DrawScope.e2(drawScope, jR, fB, jA, 0.0f, null, null, 0, 120, null);
            return;
        }
        float fI = Size.i(drawScope.b());
        float fG = Size.g(drawScope.b());
        int iB = ClipOp.f25711b.b();
        DrawContext drawContextQ1 = drawScope.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().c(0.0f, 0.0f, fI, fG, iB);
            DrawScope.e2(drawScope, jR, fB, jA, 0.0f, null, null, 0, 120, null);
        } finally {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
        }
    }

    public final void h() {
        k(true);
        this.f15363i.J(Unit.f139807a);
    }

    private RippleAnimation(Offset offset, float f3, boolean z2) {
        this.f15355a = offset;
        this.f15356b = f3;
        this.f15357c = z2;
        this.f15360f = AnimatableKt.b(0.0f, 0.0f, 2, null);
        this.f15361g = AnimatableKt.b(0.0f, 0.0f, 2, null);
        this.f15362h = AnimatableKt.b(0.0f, 0.0f, 2, null);
        this.f15363i = CompletableDeferredKt.a(null);
        Boolean bool = Boolean.FALSE;
        this.f15364j = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f15365k = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
    }
}
