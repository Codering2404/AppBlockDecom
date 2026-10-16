package androidx.compose.ui.text.android;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.text.MeasuredText;
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
final class CanvasCompatQ {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CanvasCompatQ f28938a = new CanvasCompatQ();

    private CanvasCompatQ() {
    }

    public final void a(Canvas canvas) {
        canvas.disableZ();
    }

    public final void b(Canvas canvas, int i3, BlendMode blendMode) {
        canvas.drawColor(i3, blendMode);
    }

    public final void c(Canvas canvas, long j3) {
        canvas.drawColor(j3);
    }

    public final void d(Canvas canvas, long j3, BlendMode blendMode) {
        canvas.drawColor(j3, blendMode);
    }

    public final void e(Canvas canvas, RectF rectF, float f3, float f4, RectF rectF2, float f5, float f6, Paint paint) {
        canvas.drawDoubleRoundRect(rectF, f3, f4, rectF2, f5, f6, paint);
    }

    public final void f(Canvas canvas, RectF rectF, float[] fArr, RectF rectF2, float[] fArr2, Paint paint) {
        canvas.drawDoubleRoundRect(rectF, fArr, rectF2, fArr2, paint);
    }

    public final void g(Canvas canvas, RenderNode renderNode) {
        canvas.drawRenderNode(renderNode);
    }

    public final void h(Canvas canvas, MeasuredText measuredText, int i3, int i4, int i5, int i6, float f3, float f4, boolean z2, Paint paint) {
        canvas.drawTextRun(measuredText, i3, i4, i5, i6, f3, f4, z2, paint);
    }

    public final void i(Canvas canvas) {
        canvas.enableZ();
    }
}
