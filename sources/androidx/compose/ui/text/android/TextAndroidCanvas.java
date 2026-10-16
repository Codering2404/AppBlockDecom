package androidx.compose.ui.text.android;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
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
public final class TextAndroidCanvas extends Canvas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Canvas f29005a;

    public final void a(Canvas canvas) {
        this.f29005a = canvas;
    }

    @Override // android.graphics.Canvas
    public boolean clipOutPath(Path path) {
        CanvasCompatO canvasCompatO = CanvasCompatO.f28937a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvasCompatO.a(canvas, path);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(RectF rectF) {
        CanvasCompatO canvasCompatO = CanvasCompatO.f28937a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvasCompatO.e(canvas, rectF);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path, Region.Op op) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipPath(path, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rectF, Region.Op op) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rectF, op);
    }

    @Override // android.graphics.Canvas
    public void concat(Matrix matrix) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.concat(matrix);
    }

    @Override // android.graphics.Canvas
    public void disableZ() {
        CanvasCompatQ canvasCompatQ = CanvasCompatQ.f28938a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatQ.a(canvas);
    }

    @Override // android.graphics.Canvas
    public void drawARGB(int i3, int i4, int i5, int i6) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawARGB(i3, i4, i5, i6);
    }

    @Override // android.graphics.Canvas
    public void drawArc(RectF rectF, float f3, float f4, boolean z2, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawArc(rectF, f3, f4, z2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, float f3, float f4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(Bitmap bitmap, int i3, int i4, float[] fArr, int i5, int[] iArr, int i6, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmapMesh(bitmap, i3, i4, fArr, i5, iArr, i6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float f3, float f4, float f5, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawCircle(f3, f4, f5, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i3) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(i3);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF rectF, float f3, float f4, RectF rectF2, float f5, float f6, Paint paint) {
        CanvasCompatQ canvasCompatQ = CanvasCompatQ.f28938a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatQ.e(canvas, rectF, f3, f4, rectF2, f5, f6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawGlyphs(int[] iArr, int i3, float[] fArr, int i4, int i5, Font font, Paint paint) {
        CanvasCompatS canvasCompatS = CanvasCompatS.f28940a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatS.a(canvas, iArr, i3, fArr, i4, i5, font, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLine(float f3, float f4, float f5, float f6, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawLine(f3, f4, f5, f6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, int i3, int i4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawLines(fArr, i3, i4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(RectF rectF, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawOval(rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPaint(Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPaint(paint);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch ninePatch, Rect rect, Paint paint) {
        CanvasCompatS canvasCompatS = CanvasCompatS.f28940a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatS.b(canvas, ninePatch, rect, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPath(path, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPicture(picture);
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float f3, float f4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPoint(f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, int i3, int i4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPoints(fArr, i3, i4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPosText(char[] cArr, int i3, int i4, float[] fArr, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPosText(cArr, i3, i4, fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRGB(int i3, int i4, int i5) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRGB(i3, i4, i5);
    }

    @Override // android.graphics.Canvas
    public void drawRect(RectF rectF, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRect(rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRenderNode(RenderNode renderNode) {
        CanvasCompatQ canvasCompatQ = CanvasCompatQ.f28938a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatQ.g(canvas, renderNode);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(RectF rectF, float f3, float f4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRoundRect(rectF, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] cArr, int i3, int i4, float f3, float f4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(cArr, i3, i4, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] cArr, int i3, int i4, Path path, float f3, float f4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextOnPath(cArr, i3, i4, path, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(char[] cArr, int i3, int i4, int i5, int i6, float f3, float f4, boolean z2, Paint paint) {
        CanvasCompatM canvasCompatM = CanvasCompatM.f28936a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatM.b(canvas, cArr, i3, i4, i5, i6, f3, f4, z2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawVertices(Canvas.VertexMode vertexMode, int i3, float[] fArr, int i4, float[] fArr2, int i5, int[] iArr, int i6, short[] sArr, int i7, int i8, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawVertices(vertexMode, i3, fArr, i4, fArr2, i5, iArr, i6, sArr, i7, i8, paint);
    }

    @Override // android.graphics.Canvas
    public void enableZ() {
        CanvasCompatQ canvasCompatQ = CanvasCompatQ.f28938a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatQ.i(canvas);
    }

    @Override // android.graphics.Canvas
    public boolean getClipBounds(Rect rect) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        boolean clipBounds = canvas.getClipBounds(rect);
        if (clipBounds) {
            rect.set(0, 0, rect.width(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }
        return clipBounds;
    }

    @Override // android.graphics.Canvas
    public int getDensity() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getDensity();
    }

    @Override // android.graphics.Canvas
    public DrawFilter getDrawFilter() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getDrawFilter();
    }

    @Override // android.graphics.Canvas
    public int getHeight() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getHeight();
    }

    @Override // android.graphics.Canvas
    public void getMatrix(Matrix matrix) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.getMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapHeight() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getMaximumBitmapHeight();
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapWidth() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getMaximumBitmapWidth();
    }

    @Override // android.graphics.Canvas
    public int getSaveCount() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getSaveCount();
    }

    @Override // android.graphics.Canvas
    public int getWidth() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getWidth();
    }

    @Override // android.graphics.Canvas
    public boolean isOpaque() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.isOpaque();
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF rectF, Canvas.EdgeType edgeType) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(rectF, edgeType);
    }

    @Override // android.graphics.Canvas
    public void restore() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.restore();
    }

    @Override // android.graphics.Canvas
    public void restoreToCount(int i3) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.restoreToCount(i3);
    }

    @Override // android.graphics.Canvas
    public void rotate(float f3) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.rotate(f3);
    }

    @Override // android.graphics.Canvas
    public int save() {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.save();
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF rectF, Paint paint, int i3) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(rectF, paint, i3);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF rectF, int i3, int i4) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(rectF, i3, i4);
    }

    @Override // android.graphics.Canvas
    public void scale(float f3, float f4) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.scale(f3, f4);
    }

    @Override // android.graphics.Canvas
    public void setBitmap(Bitmap bitmap) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.setBitmap(bitmap);
    }

    @Override // android.graphics.Canvas
    public void setDensity(int i3) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.setDensity(i3);
    }

    @Override // android.graphics.Canvas
    public void setDrawFilter(DrawFilter drawFilter) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.setDrawFilter(drawFilter);
    }

    @Override // android.graphics.Canvas
    public void setMatrix(Matrix matrix) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.setMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    public void skew(float f3, float f4) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.skew(f3, f4);
    }

    @Override // android.graphics.Canvas
    public void translate(float f3, float f4) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.translate(f3, f4);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(Rect rect) {
        CanvasCompatO canvasCompatO = CanvasCompatO.f28937a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvasCompatO.d(canvas, rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipPath(path);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect, Region.Op op) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rect, op);
    }

    @Override // android.graphics.Canvas
    public void drawArc(float f3, float f4, float f5, float f6, float f7, float f8, boolean z2, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawArc(f3, f4, f5, f6, f7, f8, z2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, rect, rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long j3) {
        CanvasCompatQ canvasCompatQ = CanvasCompatQ.f28938a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatQ.c(canvas, j3);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawLines(fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(float f3, float f4, float f5, float f6, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawOval(f3, f4, f5, f6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch ninePatch, RectF rectF, Paint paint) {
        CanvasCompatS canvasCompatS = CanvasCompatS.f28940a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatS.c(canvas, ninePatch, rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, RectF rectF) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPicture(picture, rectF);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPoints(fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPosText(String str, float[] fArr, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPosText(str, fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(Rect rect, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRect(rect, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float f3, float f4, float f5, float f6, float f7, float f8, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRoundRect(f3, f4, f5, f6, f7, f8, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, float f3, float f4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(str, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(String str, Path path, float f3, float f4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextOnPath(str, path, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF rectF) {
        CanvasCompatR canvasCompatR = CanvasCompatR.f28939a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvasCompatR.c(canvas, rectF);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF rectF, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(rectF, paint);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF rectF, int i3) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(rectF, i3);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(float f3, float f4, float f5, float f6) {
        CanvasCompatO canvasCompatO = CanvasCompatO.f28937a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvasCompatO.b(canvas, f3, f4, f5, f6);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rectF) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rectF);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, rect, rect2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i3, PorterDuff.Mode mode) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(i3, mode);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, Rect rect) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPicture(picture, rect);
    }

    @Override // android.graphics.Canvas
    public void drawRect(float f3, float f4, float f5, float f6, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRect(f3, f4, f5, f6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, int i3, int i4, float f3, float f4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(str, i3, i4, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path path, Canvas.EdgeType edgeType) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(path, edgeType);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f3, float f4, float f5, float f6, Paint paint, int i3) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(f3, f4, f5, f6, paint, i3);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float f3, float f4, float f5, float f6, int i3, int i4) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(f3, f4, f5, f6, i3, i4);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(int i3, int i4, int i5, int i6) {
        CanvasCompatO canvasCompatO = CanvasCompatO.f28937a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvasCompatO.c(canvas, i3, i4, i5, i6);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rect);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] iArr, int i3, int i4, float f3, float f4, int i5, int i6, boolean z2, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(iArr, i3, i4, f3, f4, i5, i6, z2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i3, BlendMode blendMode) {
        CanvasCompatQ canvasCompatQ = CanvasCompatQ.f28938a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatQ.b(canvas, i3, blendMode);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF rectF, float[] fArr, RectF rectF2, float[] fArr2, Paint paint) {
        CanvasCompatQ canvasCompatQ = CanvasCompatQ.f28938a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatQ.f(canvas, rectF, fArr, rectF2, fArr2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(CharSequence charSequence, int i3, int i4, float f3, float f4, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(charSequence, i3, i4, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(CharSequence charSequence, int i3, int i4, int i5, int i6, float f3, float f4, boolean z2, Paint paint) {
        CanvasCompatM canvasCompatM = CanvasCompatM.f28936a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatM.a(canvas, charSequence, i3, i4, i5, i6, f3, f4, z2, paint);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path path) {
        CanvasCompatR canvasCompatR = CanvasCompatR.f28939a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvasCompatR.b(canvas, path);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f3, float f4, float f5, float f6, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(f3, f4, f5, f6, paint);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float f3, float f4, float f5, float f6, int i3) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(f3, f4, f5, f6, i3);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f3, float f4, float f5, float f6, Region.Op op) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(f3, f4, f5, f6, op);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] iArr, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(iArr, i3, i4, i5, i6, i7, i8, z2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long j3, BlendMode blendMode) {
        CanvasCompatQ canvasCompatQ = CanvasCompatQ.f28938a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatQ.d(canvas, j3, blendMode);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float f3, float f4, float f5, float f6, Canvas.EdgeType edgeType) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(f3, f4, f5, f6, edgeType);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f3, float f4, float f5, float f6) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(f3, f4, f5, f6);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float f3, float f4, float f5, float f6) {
        CanvasCompatR canvasCompatR = CanvasCompatR.f28939a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvasCompatR.a(canvas, f3, f4, f5, f6);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(int i3, int i4, int i5, int i6) {
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(i3, i4, i5, i6);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(MeasuredText measuredText, int i3, int i4, int i5, int i6, float f3, float f4, boolean z2, Paint paint) {
        CanvasCompatQ canvasCompatQ = CanvasCompatQ.f28938a;
        Canvas canvas = this.f29005a;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvasCompatQ.h(canvas, measuredText, i3, i4, i5, i6, f3, f4, z2, paint);
    }
}
