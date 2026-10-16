package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ShadowRenderer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f81743i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float[] f81744j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f81745k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f81746l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f81747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f81748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f81749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f81750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f81751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f81752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f81753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f81754h;

    public ShadowRenderer() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i3, float f3, float f4) {
        float f5;
        boolean z2 = f4 < 0.0f;
        Path path = this.f81753g;
        if (z2) {
            int[] iArr = f81745k;
            iArr[0] = 0;
            iArr[1] = this.f81752f;
            iArr[2] = this.f81751e;
            iArr[3] = this.f81750d;
            f5 = f3;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            f5 = f3;
            path.arcTo(rectF, f5, f4);
            path.close();
            float f6 = -i3;
            rectF.inset(f6, f6);
            int[] iArr2 = f81745k;
            iArr2[0] = 0;
            iArr2[1] = this.f81750d;
            iArr2[2] = this.f81751e;
            iArr2[3] = this.f81752f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f7 = 1.0f - (i3 / fWidth);
        float[] fArr = f81746l;
        fArr[1] = f7;
        fArr[2] = ((1.0f - f7) / 2.0f) + f7;
        this.f81748b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f81745k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z2) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f81754h);
        }
        canvas.drawArc(rectF, f5, f4, true, this.f81748b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i3) {
        rectF.bottom += i3;
        rectF.offset(0.0f, -i3);
        int[] iArr = f81743i;
        iArr[0] = this.f81752f;
        iArr[1] = this.f81751e;
        iArr[2] = this.f81750d;
        Paint paint = this.f81749c;
        float f3 = rectF.left;
        paint.setShader(new LinearGradient(f3, rectF.top, f3, rectF.bottom, iArr, f81744j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f81749c);
        canvas.restore();
    }

    public void c(Canvas canvas, Matrix matrix, RectF rectF, int i3, float f3, float f4, float[] fArr) {
        if (f4 > 0.0f) {
            f3 += f4;
            f4 = -f4;
        }
        float f5 = f3;
        float f6 = f4;
        a(canvas, matrix, rectF, i3, f5, f6);
        Path path = this.f81753g;
        path.rewind();
        path.moveTo(fArr[0], fArr[1]);
        path.arcTo(rectF, f5, f6);
        path.close();
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        canvas.drawPath(path, this.f81754h);
        canvas.drawPath(path, this.f81747a);
        canvas.restore();
    }

    public Paint d() {
        return this.f81747a;
    }

    public void e(int i3) {
        this.f81750d = ColorUtils.k(i3, 68);
        this.f81751e = ColorUtils.k(i3, 20);
        this.f81752f = ColorUtils.k(i3, 0);
        this.f81747a.setColor(this.f81750d);
    }

    public ShadowRenderer(int i3) {
        this.f81753g = new Path();
        Paint paint = new Paint();
        this.f81754h = paint;
        this.f81747a = new Paint();
        e(i3);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f81748b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f81749c = new Paint(paint2);
    }
}
