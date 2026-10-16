package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.Path;
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
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform b(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void a(float[] fArr) {
                drawContext.g().v(fArr);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public long b() {
                return drawContext.b();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void c(float f3, float f4, float f5, float f6, int i3) {
                drawContext.g().c(f3, f4, f5, f6, i3);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void d(Path path, int i3) {
                drawContext.g().d(path, i3);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void e(float f3, float f4) {
                drawContext.g().e(f3, f4);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void i(float f3, float f4, long j3) {
                Canvas canvasG = drawContext.g();
                int i3 = (int) (j3 >> 32);
                int i4 = (int) (j3 & 4294967295L);
                canvasG.e(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4));
                canvasG.f(f3, f4);
                canvasG.e(-Float.intBitsToFloat(i3), -Float.intBitsToFloat(i4));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void j(float f3, long j3) {
                Canvas canvasG = drawContext.g();
                int i3 = (int) (j3 >> 32);
                int i4 = (int) (j3 & 4294967295L);
                canvasG.e(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4));
                canvasG.r(f3);
                canvasG.e(-Float.intBitsToFloat(i3), -Float.intBitsToFloat(i4));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void k(float f3, float f4, float f5, float f6) {
                Canvas canvasG = drawContext.g();
                DrawContext drawContext2 = drawContext;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (b() >> 32)) - (f5 + f3);
                long jD = Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (b() & 4294967295L)) - (f6 + f4))) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32));
                if (!(Float.intBitsToFloat((int) (jD >> 32)) >= 0.0f && Float.intBitsToFloat((int) (jD & 4294967295L)) >= 0.0f)) {
                    InlineClassHelperKt.a("Width and height must be greater than or equal to zero");
                }
                drawContext2.h(jD);
                canvasG.e(f3, f4);
            }
        };
    }
}
