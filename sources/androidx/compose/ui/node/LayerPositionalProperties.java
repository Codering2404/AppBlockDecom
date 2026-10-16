package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;

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
final class LayerPositionalProperties {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f27341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f27342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f27343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f27344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f27345g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f27339a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f27340b = 1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f27346h = 8.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f27347i = TransformOrigin.f25955b.a();

    public final void a(GraphicsLayerScope graphicsLayerScope) {
        this.f27339a = graphicsLayerScope.D();
        this.f27340b = graphicsLayerScope.P();
        this.f27341c = graphicsLayerScope.K();
        this.f27342d = graphicsLayerScope.J();
        this.f27343e = graphicsLayerScope.L();
        this.f27344f = graphicsLayerScope.t();
        this.f27345g = graphicsLayerScope.w();
        this.f27346h = graphicsLayerScope.A();
        this.f27347i = graphicsLayerScope.y0();
    }

    public final void b(LayerPositionalProperties layerPositionalProperties) {
        this.f27339a = layerPositionalProperties.f27339a;
        this.f27340b = layerPositionalProperties.f27340b;
        this.f27341c = layerPositionalProperties.f27341c;
        this.f27342d = layerPositionalProperties.f27342d;
        this.f27343e = layerPositionalProperties.f27343e;
        this.f27344f = layerPositionalProperties.f27344f;
        this.f27345g = layerPositionalProperties.f27345g;
        this.f27346h = layerPositionalProperties.f27346h;
        this.f27347i = layerPositionalProperties.f27347i;
    }

    public final boolean c(LayerPositionalProperties layerPositionalProperties) {
        return this.f27339a == layerPositionalProperties.f27339a && this.f27340b == layerPositionalProperties.f27340b && this.f27341c == layerPositionalProperties.f27341c && this.f27342d == layerPositionalProperties.f27342d && this.f27343e == layerPositionalProperties.f27343e && this.f27344f == layerPositionalProperties.f27344f && this.f27345g == layerPositionalProperties.f27345g && this.f27346h == layerPositionalProperties.f27346h && TransformOrigin.e(this.f27347i, layerPositionalProperties.f27347i);
    }
}
