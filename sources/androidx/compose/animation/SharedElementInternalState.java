package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SharedElementInternalState implements LayerRenderer, RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableFloatState f3627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f3628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f3629d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f3630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f3631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f3632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f3633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableState f3634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Path f3635k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private SharedElementInternalState f3637m;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Function0 f3636l = new Function0() { // from class: androidx.compose.animation.SharedElementInternalState$lookaheadCoords$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableState f3638n = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    public SharedElementInternalState(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z2, SharedTransitionScope.OverlayClip overlayClip, boolean z3, SharedTransitionScope.SharedContentState sharedContentState, float f3) {
        this.f3627b = PrimitiveSnapshotStateKt.a(f3);
        this.f3628c = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(z3), null, 2, null);
        this.f3629d = SnapshotStateKt__SnapshotStateKt.e(sharedElement, null, 2, null);
        this.f3630f = SnapshotStateKt__SnapshotStateKt.e(boundsAnimation, null, 2, null);
        this.f3631g = SnapshotStateKt__SnapshotStateKt.e(placeHolderSize, null, 2, null);
        this.f3632h = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(z2), null, 2, null);
        this.f3633i = SnapshotStateKt__SnapshotStateKt.e(overlayClip, null, 2, null);
        this.f3634j = SnapshotStateKt__SnapshotStateKt.e(sharedContentState, null, 2, null);
    }

    private final boolean q() {
        return Intrinsics.areEqual(p().i(), this) || !o();
    }

    public void A(SharedElementInternalState sharedElementInternalState) {
        this.f3637m = sharedElementInternalState;
    }

    public final void B(SharedTransitionScope.PlaceHolderSize placeHolderSize) {
        this.f3631g.setValue(placeHolderSize);
    }

    public final void C(boolean z2) {
        this.f3628c.setValue(Boolean.valueOf(z2));
    }

    public final void D(boolean z2) {
        this.f3632h.setValue(Boolean.valueOf(z2));
    }

    public final void E(SharedElement sharedElement) {
        this.f3629d.setValue(sharedElement);
    }

    public final void F(SharedTransitionScope.SharedContentState sharedContentState) {
        this.f3634j.setValue(sharedContentState);
    }

    public void G(float f3) {
        this.f3627b.s(f3);
    }

    @Override // androidx.compose.animation.LayerRenderer
    public float a() {
        return this.f3627b.c();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void b(DrawScope drawScope) {
        GraphicsLayer graphicsLayerI = i();
        if (graphicsLayerI != null && this.f3626a && r()) {
            if (p().c() == null) {
                throw new IllegalArgumentException("Error: current bounds not set yet.");
            }
            Rect rectC = p().c();
            Unit unit = null;
            Offset offsetD = rectC != null ? Offset.d(rectC.t()) : null;
            Intrinsics.checkNotNull(offsetD);
            long jU = offsetD.u();
            float fIntBitsToFloat = Float.intBitsToFloat((int) (jU >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jU & 4294967295L));
            Path path = this.f3635k;
            if (path != null) {
                int iB = ClipOp.f25711b.b();
                DrawContext drawContextQ1 = drawScope.Q1();
                long jB = drawContextQ1.b();
                drawContextQ1.g().t();
                try {
                    drawContextQ1.e().d(path, iB);
                    drawScope.Q1().e().e(fIntBitsToFloat, fIntBitsToFloat2);
                    try {
                        GraphicsLayerKt.a(drawScope, graphicsLayerI);
                        drawContextQ1.g().k();
                        drawContextQ1.h(jB);
                        unit = Unit.f139807a;
                    } finally {
                    }
                } catch (Throwable th) {
                    drawContextQ1.g().k();
                    drawContextQ1.h(jB);
                    throw th;
                }
            }
            if (unit == null) {
                drawScope.Q1().e().e(fIntBitsToFloat, fIntBitsToFloat2);
                try {
                    GraphicsLayerKt.a(drawScope, graphicsLayerI);
                } finally {
                }
            }
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        p().f().q(this);
        p().t();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        p().f().r(this);
        p().t();
    }

    public final long f() {
        Object objInvoke = this.f3636l.invoke();
        if (objInvoke == null) {
            throw new IllegalArgumentException("Error: lookahead coordinates is null.");
        }
        return p().f().h().S((LayoutCoordinates) objInvoke, Offset.f25596b.c());
    }

    public final BoundsAnimation g() {
        return (BoundsAnimation) this.f3630f.getValue();
    }

    public final Path h() {
        return this.f3635k;
    }

    public final GraphicsLayer i() {
        return (GraphicsLayer) this.f3638n.getValue();
    }

    public final SharedTransitionScope.OverlayClip k() {
        return (SharedTransitionScope.OverlayClip) this.f3633i.getValue();
    }

    public SharedElementInternalState l() {
        return this.f3637m;
    }

    public final SharedTransitionScope.PlaceHolderSize m() {
        return (SharedTransitionScope.PlaceHolderSize) this.f3631g.getValue();
    }

    public final boolean n() {
        return ((Boolean) this.f3628c.getValue()).booleanValue();
    }

    public final boolean o() {
        return ((Boolean) this.f3632h.getValue()).booleanValue();
    }

    public final SharedElement p() {
        return (SharedElement) this.f3629d.getValue();
    }

    public final boolean r() {
        return q() && p().d() && n();
    }

    public final boolean s() {
        if (p().d()) {
            return !r() && q();
        }
        return true;
    }

    public final SharedTransitionScope.SharedContentState t() {
        return (SharedTransitionScope.SharedContentState) this.f3634j.getValue();
    }

    public final void u(BoundsAnimation boundsAnimation) {
        this.f3630f.setValue(boundsAnimation);
    }

    public final void v(Path path) {
        this.f3635k = path;
    }

    public final void w(boolean z2) {
        this.f3626a = z2;
    }

    public final void x(GraphicsLayer graphicsLayer) {
        this.f3638n.setValue(graphicsLayer);
    }

    public final void y(Function0 function0) {
        this.f3636l = function0;
    }

    public final void z(SharedTransitionScope.OverlayClip overlayClip) {
        this.f3633i.setValue(overlayClip);
    }

    public final long j() {
        Object objInvoke = this.f3636l.invoke();
        if (objInvoke != null) {
            return IntSizeKt.e(((LayoutCoordinates) objInvoke).a());
        }
        throw new IllegalArgumentException((qRMDmh.wmHGBXKZAoyQfAi + p().e() + '.').toString());
    }
}
