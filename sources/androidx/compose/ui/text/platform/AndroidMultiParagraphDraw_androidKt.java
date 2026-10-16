package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
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
public final class AndroidMultiParagraphDraw_androidKt {
    public static final void a(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3) {
        canvas.t();
        if (multiParagraph.z().size() <= 1 || (brush instanceof SolidColor)) {
            b(multiParagraph, canvas, brush, f3, shadow, textDecoration, drawStyle, i3);
        } else if (brush instanceof ShaderBrush) {
            List listZ = multiParagraph.z();
            int size = listZ.size();
            float fMax = 0.0f;
            float height = 0.0f;
            for (int i4 = 0; i4 < size; i4++) {
                ParagraphInfo paragraphInfo = (ParagraphInfo) listZ.get(i4);
                height += paragraphInfo.e().getHeight();
                fMax = Math.max(fMax, paragraphInfo.e().getWidth());
            }
            Shader shaderMo220createShaderuvyYCjk = ((ShaderBrush) brush).mo220createShaderuvyYCjk(Size.d((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(height)) & 4294967295L)));
            Matrix matrix = new Matrix();
            shaderMo220createShaderuvyYCjk.getLocalMatrix(matrix);
            List listZ2 = multiParagraph.z();
            int size2 = listZ2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ParagraphInfo paragraphInfo2 = (ParagraphInfo) listZ2.get(i5);
                paragraphInfo2.e().w(canvas, BrushKt.a(shaderMo220createShaderuvyYCjk), f3, shadow, textDecoration, drawStyle, i3);
                canvas.e(0.0f, paragraphInfo2.e().getHeight());
                matrix.setTranslate(0.0f, -paragraphInfo2.e().getHeight());
                shaderMo220createShaderuvyYCjk.setLocalMatrix(matrix);
            }
        }
        canvas.k();
    }

    private static final void b(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3) {
        List listZ = multiParagraph.z();
        int size = listZ.size();
        for (int i4 = 0; i4 < size; i4++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) listZ.get(i4);
            paragraphInfo.e().w(canvas, brush, f3, shadow, textDecoration, drawStyle, i3);
            canvas.e(0.0f, paragraphInfo.e().getHeight());
        }
    }
}
