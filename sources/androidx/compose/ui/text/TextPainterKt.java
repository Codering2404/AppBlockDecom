package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextPainterKt {
    private static final void a(DrawTransform drawTransform, TextLayoutResult textLayoutResult) {
        if (!textLayoutResult.i() || TextOverflow.h(textLayoutResult.l().f(), TextOverflow.f29661b.e())) {
            return;
        }
        DrawTransform.h(drawTransform, 0.0f, 0.0f, (int) (textLayoutResult.B() >> 32), (int) (textLayoutResult.B() & 4294967295L), 0, 16, null);
    }

    public static final void b(DrawScope drawScope, TextLayoutResult textLayoutResult, long j3, long j4, float f3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3) {
        float f4;
        int i4;
        Shadow shadow2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        Canvas canvas;
        MultiParagraph multiParagraph;
        Shadow shadowZ = shadow == null ? textLayoutResult.l().i().z() : shadow;
        TextDecoration textDecorationC = textDecoration == null ? textLayoutResult.l().i().C() : textDecoration;
        DrawStyle drawStyleK = drawStyle == null ? textLayoutResult.l().i().k() : drawStyle;
        DrawContext drawContextQ1 = drawScope.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            DrawTransform drawTransformE = drawContextQ1.e();
            drawTransformE.e(Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (4294967295L & j4)));
            a(drawTransformE, textLayoutResult);
            Brush brushI = textLayoutResult.l().i().i();
            if (brushI == null || j3 != 16) {
                MultiParagraph multiParagraphW = textLayoutResult.w();
                Canvas canvasG = drawScope.Q1().g();
                if (j3 == 16) {
                    j3 = textLayoutResult.l().i().j();
                }
                multiParagraphW.G(canvasG, TextDrawStyleKt.c(j3, f3), shadowZ, textDecorationC, drawStyleK, i3);
            } else {
                MultiParagraph multiParagraphW2 = textLayoutResult.w();
                Canvas canvasG2 = drawScope.Q1().g();
                if (Float.isNaN(f3)) {
                    f4 = textLayoutResult.l().i().f();
                    i4 = i3;
                    shadow2 = shadowZ;
                    textDecoration2 = textDecorationC;
                    drawStyle2 = drawStyleK;
                    canvas = canvasG2;
                    multiParagraph = multiParagraphW2;
                } else {
                    f4 = f3;
                    canvas = canvasG2;
                    multiParagraph = multiParagraphW2;
                    i4 = i3;
                    shadow2 = shadowZ;
                    textDecoration2 = textDecorationC;
                    drawStyle2 = drawStyleK;
                }
                multiParagraph.I(canvas, brushI, f4, shadow2, textDecoration2, drawStyle2, i4);
            }
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
        } catch (Throwable th) {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
            throw th;
        }
    }
}
