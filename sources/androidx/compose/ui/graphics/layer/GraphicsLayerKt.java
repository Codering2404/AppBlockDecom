package androidx.compose.ui.graphics.layer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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
public final class GraphicsLayerKt {
    public static final void a(DrawScope drawScope, GraphicsLayer graphicsLayer) {
        graphicsLayer.h(drawScope.Q1().g(), drawScope.Q1().i());
    }

    public static final void b(GraphicsLayer graphicsLayer, Outline outline) {
        if (outline instanceof Outline.Rectangle) {
            Outline.Rectangle rectangle = (Outline.Rectangle) outline;
            long jE = Offset.e((((long) Float.floatToRawIntBits(rectangle.b().o())) << 32) | (((long) Float.floatToRawIntBits(rectangle.b().r())) & 4294967295L));
            Rect rectB = rectangle.b();
            float fP = rectB.p() - rectB.o();
            Rect rectB2 = rectangle.b();
            graphicsLayer.T(jE, Size.d((((long) Float.floatToRawIntBits(rectB2.i() - rectB2.r())) & 4294967295L) | (Float.floatToRawIntBits(fP) << 32)));
            return;
        }
        if (outline instanceof Outline.Generic) {
            graphicsLayer.Q(((Outline.Generic) outline).b());
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            if (rounded.c() != null) {
                graphicsLayer.Q(rounded.c());
                return;
            }
            RoundRect roundRectB = rounded.b();
            long jE2 = Offset.e((((long) Float.floatToRawIntBits(roundRectB.e())) << 32) | (((long) Float.floatToRawIntBits(roundRectB.g())) & 4294967295L));
            float fJ = roundRectB.j();
            graphicsLayer.Y(jE2, Size.d((((long) Float.floatToRawIntBits(roundRectB.d())) & 4294967295L) | (Float.floatToRawIntBits(fJ) << 32)), Float.intBitsToFloat((int) (roundRectB.b() >> 32)));
        }
    }
}
