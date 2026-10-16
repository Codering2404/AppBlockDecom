package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SolidLayer extends BaseLayer {
    private final RectF D;
    private final Paint E;
    private final float[] F;
    private final Path G;
    private final Layer H;
    private BaseKeyframeAnimation I;

    SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.D = new RectF();
        LPaint lPaint = new LPaint();
        this.E = lPaint;
        this.F = new float[8];
        this.G = new Path();
        this.H = layer;
        lPaint.setAlpha(0);
        lPaint.setStyle(Paint.Style.FILL);
        lPaint.setColor(layer.o());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        super.d(obj, lottieValueCallback);
        if (obj == LottieProperty.K) {
            if (lottieValueCallback == null) {
                this.I = null;
            } else {
                this.I = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z2) {
        super.f(rectF, matrix, z2);
        this.D.set(0.0f, 0.0f, this.H.q(), this.H.p());
        this.f56873o.mapRect(this.D);
        rectF.set(this.D);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void u(Canvas canvas, Matrix matrix, int i3) {
        int iAlpha = Color.alpha(this.H.o());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i3 / 255.0f) * (((iAlpha / 255.0f) * (this.f56882x.h() == null ? 100 : ((Integer) this.f56882x.h().h()).intValue())) / 100.0f) * 255.0f);
        this.E.setAlpha(iIntValue);
        BaseKeyframeAnimation baseKeyframeAnimation = this.I;
        if (baseKeyframeAnimation != null) {
            this.E.setColorFilter((ColorFilter) baseKeyframeAnimation.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.H.q();
            float[] fArr2 = this.F;
            fArr2[3] = 0.0f;
            fArr2[4] = this.H.q();
            this.F[5] = this.H.p();
            float[] fArr3 = this.F;
            fArr3[6] = 0.0f;
            fArr3[7] = this.H.p();
            matrix.mapPoints(this.F);
            this.G.reset();
            Path path = this.G;
            float[] fArr4 = this.F;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.G;
            float[] fArr5 = this.F;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.G;
            float[] fArr6 = this.F;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.G;
            float[] fArr7 = this.F;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.G;
            float[] fArr8 = this.F;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.G.close();
            canvas.drawPath(this.G, this.E);
        }
    }
}
