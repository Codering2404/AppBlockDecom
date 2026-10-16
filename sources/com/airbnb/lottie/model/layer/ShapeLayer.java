package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeLayer extends BaseLayer {
    private final ContentGroup D;
    private final CompositionLayer E;

    ShapeLayer(LottieDrawable lottieDrawable, Layer layer, CompositionLayer compositionLayer, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        this.E = compositionLayer;
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.n(), false), lottieComposition);
        this.D = contentGroup;
        List list = Collections.EMPTY_LIST;
        contentGroup.b(list, list);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void H(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
        this.D.e(keyPath, i3, list, keyPath2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z2) {
        super.f(rectF, matrix, z2);
        this.D.f(rectF, this.f56873o, z2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void u(Canvas canvas, Matrix matrix, int i3) {
        this.D.i(canvas, matrix, i3);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public BlurEffect w() {
        BlurEffect blurEffectW = super.w();
        return blurEffectW != null ? blurEffectW : this.E.w();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public DropShadowEffect y() {
        DropShadowEffect dropShadowEffectY = super.y();
        return dropShadowEffectY != null ? dropShadowEffectY : this.E.y();
    }
}
