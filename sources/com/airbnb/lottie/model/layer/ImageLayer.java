package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ImageLayer extends BaseLayer {
    private final Paint D;
    private final Rect E;
    private final Rect F;
    private final LottieImageAsset G;
    private BaseKeyframeAnimation H;
    private BaseKeyframeAnimation I;

    ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.D = new LPaint(3);
        this.E = new Rect();
        this.F = new Rect();
        this.G = lottieDrawable.J(layer.m());
    }

    private Bitmap O() {
        Bitmap bitmap;
        BaseKeyframeAnimation baseKeyframeAnimation = this.I;
        if (baseKeyframeAnimation != null && (bitmap = (Bitmap) baseKeyframeAnimation.h()) != null) {
            return bitmap;
        }
        Bitmap bitmapB = this.f56874p.B(this.f56875q.m());
        if (bitmapB != null) {
            return bitmapB;
        }
        LottieImageAsset lottieImageAsset = this.G;
        if (lottieImageAsset != null) {
            return lottieImageAsset.a();
        }
        return null;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        super.d(obj, lottieValueCallback);
        if (obj == LottieProperty.K) {
            if (lottieValueCallback == null) {
                this.H = null;
                return;
            } else {
                this.H = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                return;
            }
        }
        if (obj == LottieProperty.N) {
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
        if (this.G != null) {
            float fE = Utils.e();
            rectF.set(0.0f, 0.0f, this.G.e() * fE, this.G.c() * fE);
            this.f56873o.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void u(Canvas canvas, Matrix matrix, int i3) {
        Bitmap bitmapO = O();
        if (bitmapO == null || bitmapO.isRecycled() || this.G == null) {
            return;
        }
        float fE = Utils.e();
        this.D.setAlpha(i3);
        BaseKeyframeAnimation baseKeyframeAnimation = this.H;
        if (baseKeyframeAnimation != null) {
            this.D.setColorFilter((ColorFilter) baseKeyframeAnimation.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.E.set(0, 0, bitmapO.getWidth(), bitmapO.getHeight());
        if (this.f56874p.K()) {
            this.F.set(0, 0, (int) (this.G.e() * fE), (int) (this.G.c() * fE));
        } else {
            this.F.set(0, 0, (int) (bitmapO.getWidth() * fE), (int) (bitmapO.getHeight() * fE));
        }
        canvas.drawBitmap(bitmapO, this.E, this.F, this.D);
        canvas.restore();
    }
}
