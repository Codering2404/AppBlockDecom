package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CompositionLayer extends BaseLayer {
    private BaseKeyframeAnimation D;
    private final List E;
    private final RectF F;
    private final RectF G;
    private final Paint H;
    private boolean I;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56887a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f56887a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56887a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List list, LottieComposition lottieComposition) {
        int i3;
        BaseLayer baseLayer;
        super(lottieDrawable, layer);
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.I = true;
        AnimatableFloatValue animatableFloatValueU = layer.u();
        if (animatableFloatValueU != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA = animatableFloatValueU.a();
            this.D = baseKeyframeAnimationA;
            j(baseKeyframeAnimationA);
            this.D.a(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.k().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = (Layer) list.get(size);
            BaseLayer baseLayerV = BaseLayer.v(this, layer2, lottieDrawable, lottieComposition);
            if (baseLayerV != null) {
                longSparseArray.m(baseLayerV.z().d(), baseLayerV);
                if (baseLayer2 != null) {
                    baseLayer2.I(baseLayerV);
                    baseLayer2 = null;
                } else {
                    this.E.add(0, baseLayerV);
                    int i4 = AnonymousClass1.f56887a[layer2.h().ordinal()];
                    if (i4 == 1 || i4 == 2) {
                        baseLayer2 = baseLayerV;
                    }
                }
            }
            size--;
        }
        for (i3 = 0; i3 < longSparseArray.r(); i3++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.g(longSparseArray.k(i3));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.g(baseLayer3.z().j())) != null) {
                baseLayer3.K(baseLayer);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void H(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
        for (int i4 = 0; i4 < this.E.size(); i4++) {
            ((BaseLayer) this.E.get(i4)).e(keyPath, i3, list, keyPath2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void J(boolean z2) {
        super.J(z2);
        Iterator it = this.E.iterator();
        while (it.hasNext()) {
            ((BaseLayer) it.next()).J(z2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void L(float f3) {
        super.L(f3);
        if (this.D != null) {
            f3 = ((((Float) this.D.h()).floatValue() * this.f56875q.b().i()) - this.f56875q.b().p()) / (this.f56874p.D().e() + 0.01f);
        }
        if (this.D == null) {
            f3 -= this.f56875q.r();
        }
        if (this.f56875q.v() != 0.0f && !"__container".equals(this.f56875q.i())) {
            f3 /= this.f56875q.v();
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            ((BaseLayer) this.E.get(size)).L(f3);
        }
    }

    public void O(boolean z2) {
        this.I = z2;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        super.d(obj, lottieValueCallback);
        if (obj == LottieProperty.E) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation baseKeyframeAnimation = this.D;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.n(null);
                    return;
                }
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.D = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            j(this.D);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z2) {
        super.f(rectF, matrix, z2);
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.F.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((BaseLayer) this.E.get(size)).f(this.F, this.f56873o, true);
            rectF.union(this.F);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void u(Canvas canvas, Matrix matrix, int i3) {
        L.a("CompositionLayer#draw");
        this.G.set(0.0f, 0.0f, this.f56875q.l(), this.f56875q.k());
        matrix.mapRect(this.G);
        boolean z2 = this.f56874p.Y() && this.E.size() > 1 && i3 != 255;
        if (z2) {
            this.H.setAlpha(i3);
            Utils.l(canvas, this.G, this.H);
        } else {
            canvas.save();
        }
        if (z2) {
            i3 = 255;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (((this.I || !"__container".equals(this.f56875q.i())) && !this.G.isEmpty()) ? canvas.clipRect(this.G) : true) {
                ((BaseLayer) this.E.get(size)).i(canvas, matrix, i3);
            }
        }
        canvas.restore();
        L.b("CompositionLayer#draw");
    }
}
