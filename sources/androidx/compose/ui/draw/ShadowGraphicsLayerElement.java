package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.BlockGraphicsLayerModifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class ShadowGraphicsLayerElement extends ModifierNodeElement<BlockGraphicsLayerModifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f25427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Shape f25428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f25429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f25430d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f25431f;

    public /* synthetic */ ShadowGraphicsLayerElement(float f3, Shape shape, boolean z2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, shape, z2, j3, j4);
    }

    private final Function1 c() {
        return new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.ShadowGraphicsLayerElement$createBlock$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                graphicsLayerScope.E(graphicsLayerScope.M1(this.f25432a.f()));
                graphicsLayerScope.I1(this.f25432a.g());
                graphicsLayerScope.B(this.f25432a.e());
                graphicsLayerScope.y(this.f25432a.d());
                graphicsLayerScope.C(this.f25432a.h());
            }
        };
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BlockGraphicsLayerModifier create() {
        return new BlockGraphicsLayerModifier(c());
    }

    public final long d() {
        return this.f25430d;
    }

    public final boolean e() {
        return this.f25429c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShadowGraphicsLayerElement)) {
            return false;
        }
        ShadowGraphicsLayerElement shadowGraphicsLayerElement = (ShadowGraphicsLayerElement) obj;
        return Dp.i(this.f25427a, shadowGraphicsLayerElement.f25427a) && Intrinsics.areEqual(this.f25428b, shadowGraphicsLayerElement.f25428b) && this.f25429c == shadowGraphicsLayerElement.f25429c && Color.t(this.f25430d, shadowGraphicsLayerElement.f25430d) && Color.t(this.f25431f, shadowGraphicsLayerElement.f25431f);
    }

    public final float f() {
        return this.f25427a;
    }

    public final Shape g() {
        return this.f25428b;
    }

    public final long h() {
        return this.f25431f;
    }

    public int hashCode() {
        return (((((((Dp.j(this.f25427a) * 31) + this.f25428b.hashCode()) * 31) + Boolean.hashCode(this.f25429c)) * 31) + Color.z(this.f25430d)) * 31) + Color.z(this.f25431f);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void update(BlockGraphicsLayerModifier blockGraphicsLayerModifier) {
        blockGraphicsLayerModifier.o2(c());
        blockGraphicsLayerModifier.n2();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("shadow");
        inspectorInfo.b().c("elevation", Dp.d(this.f25427a));
        inspectorInfo.b().c("shape", this.f25428b);
        inspectorInfo.b().c("clip", Boolean.valueOf(this.f25429c));
        inspectorInfo.b().c("ambientColor", Color.n(this.f25430d));
        inspectorInfo.b().c("spotColor", Color.n(this.f25431f));
    }

    public String toString() {
        return "ShadowGraphicsLayerElement(elevation=" + ((Object) Dp.k(this.f25427a)) + ", shape=" + this.f25428b + ", clip=" + this.f25429c + ", ambientColor=" + ((Object) Color.A(this.f25430d)) + ", spotColor=" + ((Object) Color.A(this.f25431f)) + ')';
    }

    private ShadowGraphicsLayerElement(float f3, Shape shape, boolean z2, long j3, long j4) {
        this.f25427a = f3;
        this.f25428b = shape;
        this.f25429c = z2;
        this.f25430d = j3;
        this.f25431f = j4;
    }
}
