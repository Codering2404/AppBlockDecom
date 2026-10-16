package androidx.compose.ui.draw;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectListKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
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
final class ScopedGraphicsContext implements GraphicsContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MutableObjectList f25425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GraphicsContext f25426b;

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public GraphicsLayer a() {
        GraphicsContext graphicsContext = this.f25426b;
        if (!(graphicsContext != null)) {
            InlineClassHelperKt.c("GraphicsContext not provided");
        }
        GraphicsLayer graphicsLayerA = graphicsContext.a();
        MutableObjectList mutableObjectList = this.f25425a;
        if (mutableObjectList == null) {
            this.f25425a = ObjectListKt.g(graphicsLayerA);
            return graphicsLayerA;
        }
        mutableObjectList.n(graphicsLayerA);
        return graphicsLayerA;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public void b(GraphicsLayer graphicsLayer) {
        GraphicsContext graphicsContext = this.f25426b;
        if (graphicsContext != null) {
            graphicsContext.b(graphicsLayer);
        }
    }

    public final GraphicsContext c() {
        return this.f25426b;
    }

    public final void d() {
        MutableObjectList mutableObjectList = this.f25425a;
        if (mutableObjectList != null) {
            Object[] objArr = mutableObjectList.f3081a;
            int i3 = mutableObjectList.f3082b;
            for (int i4 = 0; i4 < i3; i4++) {
                b((GraphicsLayer) objArr[i4]);
            }
            mutableObjectList.t();
        }
    }

    public final void e(GraphicsContext graphicsContext) {
        d();
        this.f25426b = graphicsContext;
    }
}
