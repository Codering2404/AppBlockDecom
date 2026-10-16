package androidx.compose.ui.text.platform.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BulletSpan_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Outline outline, Canvas canvas, Paint paint, float f3, float f4, int i3) {
        if (outline instanceof Outline.Generic) {
            canvas.save();
            Rect rectA = outline.a();
            canvas.translate(f3, f4 - ((rectA.i() - rectA.r()) / 2.0f));
            Path pathB = ((Outline.Generic) outline).b();
            if (!(pathB instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            canvas.drawPath(((AndroidPath) pathB).A(), paint);
            canvas.restore();
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (outline instanceof Outline.Rectangle) {
                Outline.Rectangle rectangle = (Outline.Rectangle) outline;
                Rect rectB = rectangle.b();
                float fI = f4 - ((rectB.i() - rectB.r()) / 2.0f);
                Rect rectB2 = rectangle.b();
                float fP = f3 + (i3 * (rectB2.p() - rectB2.o()));
                Rect rectB3 = rectangle.b();
                canvas.drawRect(f3, fI, fP, f4 + ((rectB3.i() - rectB3.r()) / 2.0f), paint);
                return;
            }
            return;
        }
        Outline.Rounded rounded = (Outline.Rounded) outline;
        if (RoundRectKt.g(rounded.b())) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (rounded.b().h() >> 32));
            canvas.drawRoundRect(f3, f4 - (rounded.b().d() / 2.0f), (i3 * rounded.b().j()) + f3, (rounded.b().d() / 2.0f) + f4, fIntBitsToFloat, fIntBitsToFloat, paint);
            return;
        }
        Path pathA = AndroidPath_androidKt.a();
        Path.s(pathA, rounded.b(), null, 2, null);
        canvas.save();
        canvas.translate(f3, f4 - (rounded.b().d() / 2.0f));
        if (!(pathA instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((AndroidPath) pathA).A(), paint);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Paint paint, Brush brush, float f3, long j3, Function0 function0) {
        Integer numValueOf = null;
        if (brush == null) {
            if (!Float.isNaN(f3)) {
                numValueOf = Integer.valueOf(paint.getAlpha());
                paint.setAlpha((int) Math.rint(f3 * 255.0f));
            }
            function0.invoke();
            if (numValueOf != null) {
                paint.setAlpha(numValueOf.intValue());
                return;
            }
            return;
        }
        if (brush instanceof SolidColor) {
            int color = paint.getColor();
            if (!Float.isNaN(f3)) {
                numValueOf = Integer.valueOf(paint.getAlpha());
                paint.setAlpha((int) Math.rint(f3 * 255.0f));
            }
            paint.setColor(ColorKt.k(((SolidColor) brush).a()));
            function0.invoke();
            paint.setColor(color);
            if (numValueOf != null) {
                paint.setAlpha(numValueOf.intValue());
                return;
            }
            return;
        }
        if (brush instanceof ShaderBrush) {
            Shader shader = paint.getShader();
            if (!Float.isNaN(f3)) {
                numValueOf = Integer.valueOf(paint.getAlpha());
                paint.setAlpha((int) Math.rint(f3 * 255.0f));
            }
            paint.setShader(((ShaderBrush) brush).mo220createShaderuvyYCjk(j3));
            function0.invoke();
            paint.setShader(shader);
            if (numValueOf != null) {
                paint.setAlpha(numValueOf.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Paint paint, DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.f26098a)) {
            paint.setStyle(Paint.Style.FILL);
            return;
        }
        if (drawStyle instanceof Stroke) {
            paint.setStyle(Paint.Style.STROKE);
            Stroke stroke = (Stroke) drawStyle;
            paint.setStrokeWidth(stroke.f());
            paint.setStrokeMiter(stroke.d());
            paint.setStrokeCap(DrawStyleSpan_androidKt.a(stroke.b()));
            paint.setStrokeJoin(DrawStyleSpan_androidKt.b(stroke.c()));
            PathEffect pathEffectE = stroke.e();
            paint.setPathEffect(pathEffectE != null ? AndroidPathEffect_androidKt.b(pathEffectE) : null);
        }
    }
}
