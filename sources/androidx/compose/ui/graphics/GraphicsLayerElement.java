package androidx.compose.ui.graphics;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class GraphicsLayerElement extends ModifierNodeElement<SimpleGraphicsLayerModifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f25764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f25765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f25766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f25767d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f25768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f25769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f25770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f25771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f25772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final float f25773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f25774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Shape f25775m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f25776n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final RenderEffect f25777o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f25778p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final long f25779q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f25780r;

    public /* synthetic */ GraphicsLayerElement(float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j3, Shape shape, boolean z2, RenderEffect renderEffect, long j4, long j5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, j3, shape, z2, renderEffect, j4, j5, i3);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SimpleGraphicsLayerModifier create() {
        return new SimpleGraphicsLayerModifier(this.f25764a, this.f25765b, this.f25766c, this.f25767d, this.f25768f, this.f25769g, this.f25770h, this.f25771i, this.f25772j, this.f25773k, this.f25774l, this.f25775m, this.f25776n, this.f25777o, this.f25778p, this.f25779q, this.f25780r, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        simpleGraphicsLayerModifier.e(this.f25764a);
        simpleGraphicsLayerModifier.k(this.f25765b);
        simpleGraphicsLayerModifier.c(this.f25766c);
        simpleGraphicsLayerModifier.l(this.f25767d);
        simpleGraphicsLayerModifier.d(this.f25768f);
        simpleGraphicsLayerModifier.E(this.f25769g);
        simpleGraphicsLayerModifier.h(this.f25770h);
        simpleGraphicsLayerModifier.i(this.f25771i);
        simpleGraphicsLayerModifier.j(this.f25772j);
        simpleGraphicsLayerModifier.g(this.f25773k);
        simpleGraphicsLayerModifier.A0(this.f25774l);
        simpleGraphicsLayerModifier.I1(this.f25775m);
        simpleGraphicsLayerModifier.B(this.f25776n);
        simpleGraphicsLayerModifier.f(this.f25777o);
        simpleGraphicsLayerModifier.y(this.f25778p);
        simpleGraphicsLayerModifier.C(this.f25779q);
        simpleGraphicsLayerModifier.s(this.f25780r);
        simpleGraphicsLayerModifier.v2();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) obj;
        return Float.compare(this.f25764a, graphicsLayerElement.f25764a) == 0 && Float.compare(this.f25765b, graphicsLayerElement.f25765b) == 0 && Float.compare(this.f25766c, graphicsLayerElement.f25766c) == 0 && Float.compare(this.f25767d, graphicsLayerElement.f25767d) == 0 && Float.compare(this.f25768f, graphicsLayerElement.f25768f) == 0 && Float.compare(this.f25769g, graphicsLayerElement.f25769g) == 0 && Float.compare(this.f25770h, graphicsLayerElement.f25770h) == 0 && Float.compare(this.f25771i, graphicsLayerElement.f25771i) == 0 && Float.compare(this.f25772j, graphicsLayerElement.f25772j) == 0 && Float.compare(this.f25773k, graphicsLayerElement.f25773k) == 0 && TransformOrigin.e(this.f25774l, graphicsLayerElement.f25774l) && Intrinsics.areEqual(this.f25775m, graphicsLayerElement.f25775m) && this.f25776n == graphicsLayerElement.f25776n && Intrinsics.areEqual(this.f25777o, graphicsLayerElement.f25777o) && Color.t(this.f25778p, graphicsLayerElement.f25778p) && Color.t(this.f25779q, graphicsLayerElement.f25779q) && CompositingStrategy.g(this.f25780r, graphicsLayerElement.f25780r);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((Float.hashCode(this.f25764a) * 31) + Float.hashCode(this.f25765b)) * 31) + Float.hashCode(this.f25766c)) * 31) + Float.hashCode(this.f25767d)) * 31) + Float.hashCode(this.f25768f)) * 31) + Float.hashCode(this.f25769g)) * 31) + Float.hashCode(this.f25770h)) * 31) + Float.hashCode(this.f25771i)) * 31) + Float.hashCode(this.f25772j)) * 31) + Float.hashCode(this.f25773k)) * 31) + TransformOrigin.h(this.f25774l)) * 31) + this.f25775m.hashCode()) * 31) + Boolean.hashCode(this.f25776n)) * 31;
        RenderEffect renderEffect = this.f25777o;
        return ((((((iHashCode + (renderEffect == null ? 0 : renderEffect.hashCode())) * 31) + Color.z(this.f25778p)) * 31) + Color.z(this.f25779q)) * 31) + CompositingStrategy.h(this.f25780r);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("graphicsLayer");
        inspectorInfo.b().c("scaleX", Float.valueOf(this.f25764a));
        inspectorInfo.b().c("scaleY", Float.valueOf(this.f25765b));
        inspectorInfo.b().c("alpha", Float.valueOf(this.f25766c));
        inspectorInfo.b().c("translationX", Float.valueOf(this.f25767d));
        inspectorInfo.b().c("translationY", Float.valueOf(this.f25768f));
        inspectorInfo.b().c("shadowElevation", Float.valueOf(this.f25769g));
        inspectorInfo.b().c("rotationX", Float.valueOf(this.f25770h));
        inspectorInfo.b().c("rotationY", Float.valueOf(this.f25771i));
        inspectorInfo.b().c("rotationZ", Float.valueOf(this.f25772j));
        inspectorInfo.b().c("cameraDistance", Float.valueOf(this.f25773k));
        inspectorInfo.b().c("transformOrigin", TransformOrigin.b(this.f25774l));
        inspectorInfo.b().c("shape", this.f25775m);
        inspectorInfo.b().c("clip", Boolean.valueOf(this.f25776n));
        inspectorInfo.b().c("renderEffect", this.f25777o);
        inspectorInfo.b().c("ambientShadowColor", Color.n(this.f25778p));
        inspectorInfo.b().c("spotShadowColor", Color.n(this.f25779q));
        inspectorInfo.b().c("compositingStrategy", CompositingStrategy.d(this.f25780r));
    }

    public String toString() {
        return "GraphicsLayerElement(scaleX=" + this.f25764a + ", scaleY=" + this.f25765b + ", alpha=" + this.f25766c + ", translationX=" + this.f25767d + ", translationY=" + this.f25768f + ", shadowElevation=" + this.f25769g + ", rotationX=" + this.f25770h + ", rotationY=" + this.f25771i + ", rotationZ=" + this.f25772j + ", cameraDistance=" + this.f25773k + ", transformOrigin=" + ((Object) TransformOrigin.i(this.f25774l)) + ", shape=" + this.f25775m + ", clip=" + this.f25776n + ", renderEffect=" + this.f25777o + ", ambientShadowColor=" + ((Object) Color.A(this.f25778p)) + ", spotShadowColor=" + ((Object) Color.A(this.f25779q)) + ", compositingStrategy=" + ((Object) CompositingStrategy.i(this.f25780r)) + ')';
    }

    private GraphicsLayerElement(float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j3, Shape shape, boolean z2, RenderEffect renderEffect, long j4, long j5, int i3) {
        this.f25764a = f3;
        this.f25765b = f4;
        this.f25766c = f5;
        this.f25767d = f6;
        this.f25768f = f7;
        this.f25769g = f8;
        this.f25770h = f9;
        this.f25771i = f10;
        this.f25772j = f11;
        this.f25773k = f12;
        this.f25774l = j3;
        this.f25775m = shape;
        this.f25776n = z2;
        this.f25777o = renderEffect;
        this.f25778p = j4;
        this.f25779q = j5;
        this.f25780r = i3;
    }
}
