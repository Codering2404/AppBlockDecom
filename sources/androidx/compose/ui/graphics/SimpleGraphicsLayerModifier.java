package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class SimpleGraphicsLayerModifier extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f25908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f25909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f25910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f25911d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f25912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f25913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f25914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f25915i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f25916j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f25917k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f25918l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Shape f25919m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f25920n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private RenderEffect f25921o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f25922p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f25923q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f25924r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Function1 f25925s;

    public /* synthetic */ SimpleGraphicsLayerModifier(float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j3, Shape shape, boolean z2, RenderEffect renderEffect, long j4, long j5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, j3, shape, z2, renderEffect, j4, j5, i3);
    }

    public final float A() {
        return this.f25917k;
    }

    public final void A0(long j3) {
        this.f25918l = j3;
    }

    public final void B(boolean z2) {
        this.f25920n = z2;
    }

    public final void C(long j3) {
        this.f25923q = j3;
    }

    public final float D() {
        return this.f25908a;
    }

    public final void E(float f3) {
        this.f25913g = f3;
    }

    public final void I1(Shape shape) {
        this.f25919m = shape;
    }

    public final float J() {
        return this.f25912f;
    }

    public final float K() {
        return this.f25911d;
    }

    public final float L() {
        return this.f25914h;
    }

    public final float P() {
        return this.f25909b;
    }

    public final void c(float f3) {
        this.f25910c = f3;
    }

    public final void d(float f3) {
        this.f25912f = f3;
    }

    public final void e(float f3) {
        this.f25908a = f3;
    }

    public final void f(RenderEffect renderEffect) {
        this.f25921o = renderEffect;
    }

    public final void g(float f3) {
        this.f25917k = f3;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void h(float f3) {
        this.f25914h = f3;
    }

    public final void i(float f3) {
        this.f25915i = f3;
    }

    public final void j(float f3) {
        this.f25916j = f3;
    }

    public final void k(float f3) {
        this.f25909b = f3;
    }

    public final void l(float f3) {
        this.f25911d = f3;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(j3);
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.w(placementScope, placeableN0, 0, 0, 0.0f, this.f25925s, 4, null);
            }
        }, 4, null);
    }

    public final float n2() {
        return this.f25910c;
    }

    public final long o2() {
        return this.f25922p;
    }

    public final boolean p2() {
        return this.f25920n;
    }

    public final int q2() {
        return this.f25924r;
    }

    public final RenderEffect r2() {
        return this.f25921o;
    }

    public final void s(int i3) {
        this.f25924r = i3;
    }

    public final float s2() {
        return this.f25913g;
    }

    public final float t() {
        return this.f25915i;
    }

    public final Shape t2() {
        return this.f25919m;
    }

    public String toString() {
        return "SimpleGraphicsLayerModifier(scaleX=" + this.f25908a + ", scaleY=" + this.f25909b + ", alpha = " + this.f25910c + ", translationX=" + this.f25911d + ", translationY=" + this.f25912f + ", shadowElevation=" + this.f25913g + ", rotationX=" + this.f25914h + ", rotationY=" + this.f25915i + ", rotationZ=" + this.f25916j + ", cameraDistance=" + this.f25917k + ", transformOrigin=" + ((Object) TransformOrigin.i(this.f25918l)) + ", shape=" + this.f25919m + ", clip=" + this.f25920n + ", renderEffect=" + this.f25921o + ", ambientShadowColor=" + ((Object) Color.A(this.f25922p)) + ", spotShadowColor=" + ((Object) Color.A(this.f25923q)) + ", compositingStrategy=" + ((Object) CompositingStrategy.i(this.f25924r)) + ')';
    }

    public final long u2() {
        return this.f25923q;
    }

    public final void v2() {
        NodeCoordinator nodeCoordinatorX2 = DelegatableNodeKt.j(this, NodeKind.a(2)).X2();
        if (nodeCoordinatorX2 != null) {
            nodeCoordinatorX2.R3(this.f25925s, true);
        }
    }

    public final float w() {
        return this.f25916j;
    }

    public final void y(long j3) {
        this.f25922p = j3;
    }

    public final long y0() {
        return this.f25918l;
    }

    private SimpleGraphicsLayerModifier(float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j3, Shape shape, boolean z2, RenderEffect renderEffect, long j4, long j5, int i3) {
        this.f25908a = f3;
        this.f25909b = f4;
        this.f25910c = f5;
        this.f25911d = f6;
        this.f25912f = f7;
        this.f25913g = f8;
        this.f25914h = f9;
        this.f25915i = f10;
        this.f25916j = f11;
        this.f25917k = f12;
        this.f25918l = j3;
        this.f25919m = shape;
        this.f25920n = z2;
        this.f25921o = renderEffect;
        this.f25922p = j4;
        this.f25923q = j5;
        this.f25924r = i3;
        this.f25925s = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$layerBlock$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                graphicsLayerScope.e(this.f25926a.D());
                graphicsLayerScope.k(this.f25926a.P());
                graphicsLayerScope.c(this.f25926a.n2());
                graphicsLayerScope.l(this.f25926a.K());
                graphicsLayerScope.d(this.f25926a.J());
                graphicsLayerScope.E(this.f25926a.s2());
                graphicsLayerScope.h(this.f25926a.L());
                graphicsLayerScope.i(this.f25926a.t());
                graphicsLayerScope.j(this.f25926a.w());
                graphicsLayerScope.g(this.f25926a.A());
                graphicsLayerScope.A0(this.f25926a.y0());
                graphicsLayerScope.I1(this.f25926a.t2());
                graphicsLayerScope.B(this.f25926a.p2());
                graphicsLayerScope.f(this.f25926a.r2());
                graphicsLayerScope.y(this.f25926a.o2());
                graphicsLayerScope.C(this.f25926a.u2());
                graphicsLayerScope.s(this.f25926a.q2());
            }
        };
    }
}
