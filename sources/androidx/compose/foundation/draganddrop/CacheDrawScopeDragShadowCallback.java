package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class CacheDrawScopeDragShadowCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GraphicsLayer f5322a;

    public final DrawResult b(CacheDrawScope cacheDrawScope) {
        GraphicsLayer graphicsLayerP = cacheDrawScope.p();
        CacheDrawScope.H(cacheDrawScope, graphicsLayerP, null, null, 0L, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.draganddrop.CacheDrawScopeDragShadowCallback$cachePicture$1$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                contentDrawScope.i2();
            }
        }, 7, null);
        this.f5322a = graphicsLayerP;
        return cacheDrawScope.x(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.draganddrop.CacheDrawScopeDragShadowCallback$cachePicture$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                GraphicsLayer graphicsLayer = this.f5324a.f5322a;
                Intrinsics.checkNotNull(graphicsLayer);
                GraphicsLayerKt.a(contentDrawScope, graphicsLayer);
            }
        });
    }

    public final void c(DrawScope drawScope) {
        GraphicsLayer graphicsLayer = this.f5322a;
        if (graphicsLayer == null) {
            throw new IllegalArgumentException("No cached drag shadow. Check if the drag source node was rendered first");
        }
        GraphicsLayerKt.a(drawScope, graphicsLayer);
    }
}
