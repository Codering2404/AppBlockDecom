package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private Paint A;
    float B;
    BlurMaskFilter C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f56859a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix f56860b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f56861c = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Paint f56862d = new LPaint(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f56863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f56864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f56865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f56866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f56867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f56868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RectF f56869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final RectF f56870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final RectF f56871m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f56872n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final Matrix f56873o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final LottieDrawable f56874p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final Layer f56875q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MaskKeyframeAnimation f56876r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private FloatKeyframeAnimation f56877s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private BaseLayer f56878t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private BaseLayer f56879u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List f56880v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final List f56881w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final TransformKeyframeAnimation f56882x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f56883y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f56884z;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.BaseLayer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f56886b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f56886b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56886b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56886b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f56886b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f56885a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f56885a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f56885a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f56885a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f56885a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f56885a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f56885a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f56863e = new LPaint(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f56864f = new LPaint(1, mode2);
        LPaint lPaint = new LPaint(1);
        this.f56865g = lPaint;
        this.f56866h = new LPaint(PorterDuff.Mode.CLEAR);
        this.f56867i = new RectF();
        this.f56868j = new RectF();
        this.f56869k = new RectF();
        this.f56870l = new RectF();
        this.f56871m = new RectF();
        this.f56873o = new Matrix();
        this.f56881w = new ArrayList();
        this.f56883y = true;
        this.B = 0.0f;
        this.f56874p = lottieDrawable;
        this.f56875q = layer;
        this.f56872n = layer.i() + "#draw";
        if (layer.h() == Layer.MatteType.INVERT) {
            lPaint.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            lPaint.setXfermode(new PorterDuffXfermode(mode));
        }
        TransformKeyframeAnimation transformKeyframeAnimationB = layer.w().b();
        this.f56882x = transformKeyframeAnimationB;
        transformKeyframeAnimationB.b(this);
        if (layer.g() != null && !layer.g().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.g());
            this.f56876r = maskKeyframeAnimation;
            Iterator it = maskKeyframeAnimation.a().iterator();
            while (it.hasNext()) {
                ((BaseKeyframeAnimation) it.next()).a(this);
            }
            for (BaseKeyframeAnimation baseKeyframeAnimation : this.f56876r.c()) {
                j(baseKeyframeAnimation);
                baseKeyframeAnimation.a(this);
            }
        }
        N();
    }

    private void C(RectF rectF, Matrix matrix) {
        this.f56869k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (A()) {
            int size = this.f56876r.b().size();
            for (int i3 = 0; i3 < size; i3++) {
                Mask mask = (Mask) this.f56876r.b().get(i3);
                Path path = (Path) ((BaseKeyframeAnimation) this.f56876r.a().get(i3)).h();
                if (path != null) {
                    this.f56859a.set(path);
                    this.f56859a.transform(matrix);
                    int i4 = AnonymousClass1.f56886b[mask.a().ordinal()];
                    if (i4 == 1 || i4 == 2) {
                        return;
                    }
                    if ((i4 == 3 || i4 == 4) && mask.d()) {
                        return;
                    }
                    this.f56859a.computeBounds(this.f56871m, false);
                    if (i3 == 0) {
                        this.f56869k.set(this.f56871m);
                    } else {
                        RectF rectF2 = this.f56869k;
                        rectF2.set(Math.min(rectF2.left, this.f56871m.left), Math.min(this.f56869k.top, this.f56871m.top), Math.max(this.f56869k.right, this.f56871m.right), Math.max(this.f56869k.bottom, this.f56871m.bottom));
                    }
                }
            }
            if (rectF.intersect(this.f56869k)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void D(RectF rectF, Matrix matrix) {
        if (B() && this.f56875q.h() != Layer.MatteType.INVERT) {
            this.f56870l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f56878t.f(this.f56870l, matrix, true);
            if (rectF.intersect(this.f56870l)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void E() {
        this.f56874p.invalidateSelf();
    }

    private void F(float f3) {
        this.f56874p.D().n().a(this.f56875q.i(), f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z2) {
        if (z2 != this.f56883y) {
            this.f56883y = z2;
            E();
        }
    }

    private void N() {
        if (this.f56875q.e().isEmpty()) {
            M(true);
            return;
        }
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.f56875q.e());
        this.f56877s = floatKeyframeAnimation;
        floatKeyframeAnimation.l();
        this.f56877s.a(new BaseKeyframeAnimation.AnimationListener() { // from class: com.airbnb.lottie.model.layer.a
            @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
            public final void a() {
                BaseLayer baseLayer = this.f56932a;
                baseLayer.M(baseLayer.f56877s.p() == 1.0f);
            }
        });
        M(((Float) this.f56877s.h()).floatValue() == 1.0f);
        j(this.f56877s);
    }

    private void k(Canvas canvas, Matrix matrix, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        this.f56859a.set((Path) baseKeyframeAnimation.h());
        this.f56859a.transform(matrix);
        this.f56862d.setAlpha((int) (((Integer) baseKeyframeAnimation2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f56859a, this.f56862d);
    }

    private void l(Canvas canvas, Matrix matrix, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        Utils.l(canvas, this.f56867i, this.f56863e);
        this.f56859a.set((Path) baseKeyframeAnimation.h());
        this.f56859a.transform(matrix);
        this.f56862d.setAlpha((int) (((Integer) baseKeyframeAnimation2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f56859a, this.f56862d);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        Utils.l(canvas, this.f56867i, this.f56862d);
        canvas.drawRect(this.f56867i, this.f56862d);
        this.f56859a.set((Path) baseKeyframeAnimation.h());
        this.f56859a.transform(matrix);
        this.f56862d.setAlpha((int) (((Integer) baseKeyframeAnimation2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f56859a, this.f56864f);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        Utils.l(canvas, this.f56867i, this.f56863e);
        canvas.drawRect(this.f56867i, this.f56862d);
        this.f56864f.setAlpha((int) (((Integer) baseKeyframeAnimation2.h()).intValue() * 2.55f));
        this.f56859a.set((Path) baseKeyframeAnimation.h());
        this.f56859a.transform(matrix);
        canvas.drawPath(this.f56859a, this.f56864f);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        Utils.l(canvas, this.f56867i, this.f56864f);
        canvas.drawRect(this.f56867i, this.f56862d);
        this.f56864f.setAlpha((int) (((Integer) baseKeyframeAnimation2.h()).intValue() * 2.55f));
        this.f56859a.set((Path) baseKeyframeAnimation.h());
        this.f56859a.transform(matrix);
        canvas.drawPath(this.f56859a, this.f56864f);
        canvas.restore();
    }

    private void p(Canvas canvas, Matrix matrix) {
        L.a("Layer#saveLayer");
        Utils.m(canvas, this.f56867i, this.f56863e, 19);
        L.b("Layer#saveLayer");
        for (int i3 = 0; i3 < this.f56876r.b().size(); i3++) {
            Mask mask = (Mask) this.f56876r.b().get(i3);
            BaseKeyframeAnimation baseKeyframeAnimation = (BaseKeyframeAnimation) this.f56876r.a().get(i3);
            BaseKeyframeAnimation baseKeyframeAnimation2 = (BaseKeyframeAnimation) this.f56876r.c().get(i3);
            int i4 = AnonymousClass1.f56886b[mask.a().ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    if (i3 == 0) {
                        this.f56862d.setColor(-16777216);
                        this.f56862d.setAlpha(255);
                        canvas.drawRect(this.f56867i, this.f56862d);
                    }
                    if (mask.d()) {
                        o(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        q(canvas, matrix, baseKeyframeAnimation);
                    }
                } else if (i4 != 3) {
                    if (i4 == 4) {
                        if (mask.d()) {
                            m(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                        } else {
                            k(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                        }
                    }
                } else if (mask.d()) {
                    n(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    l(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (r()) {
                this.f56862d.setAlpha(255);
                canvas.drawRect(this.f56867i, this.f56862d);
            }
        }
        L.a("Layer#restoreLayer");
        canvas.restore();
        L.b("Layer#restoreLayer");
    }

    private void q(Canvas canvas, Matrix matrix, BaseKeyframeAnimation baseKeyframeAnimation) {
        this.f56859a.set((Path) baseKeyframeAnimation.h());
        this.f56859a.transform(matrix);
        canvas.drawPath(this.f56859a, this.f56864f);
    }

    private boolean r() {
        if (this.f56876r.a().isEmpty()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f56876r.b().size(); i3++) {
            if (((Mask) this.f56876r.b().get(i3)).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.f56880v != null) {
            return;
        }
        if (this.f56879u == null) {
            this.f56880v = Collections.EMPTY_LIST;
            return;
        }
        this.f56880v = new ArrayList();
        for (BaseLayer baseLayer = this.f56879u; baseLayer != null; baseLayer = baseLayer.f56879u) {
            this.f56880v.add(baseLayer);
        }
    }

    private void t(Canvas canvas) {
        L.a("Layer#clearLayer");
        RectF rectF = this.f56867i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f56866h);
        L.b("Layer#clearLayer");
    }

    static BaseLayer v(CompositionLayer compositionLayer, Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (AnonymousClass1.f56885a[layer.f().ordinal()]) {
            case 1:
                return new ShapeLayer(lottieDrawable, layer, compositionLayer, lottieComposition);
            case 2:
                return new CompositionLayer(lottieDrawable, layer, lottieComposition.o(layer.m()), lottieComposition);
            case 3:
                return new SolidLayer(lottieDrawable, layer);
            case 4:
                return new ImageLayer(lottieDrawable, layer);
            case 5:
                return new NullLayer(lottieDrawable, layer);
            case 6:
                return new TextLayer(lottieDrawable, layer);
            default:
                Logger.c("Unknown layer type " + layer.f());
                return null;
        }
    }

    boolean A() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.f56876r;
        return (maskKeyframeAnimation == null || maskKeyframeAnimation.a().isEmpty()) ? false : true;
    }

    boolean B() {
        return this.f56878t != null;
    }

    public void G(BaseKeyframeAnimation baseKeyframeAnimation) {
        this.f56881w.remove(baseKeyframeAnimation);
    }

    void I(BaseLayer baseLayer) {
        this.f56878t = baseLayer;
    }

    void J(boolean z2) {
        if (z2 && this.A == null) {
            this.A = new LPaint();
        }
        this.f56884z = z2;
    }

    void K(BaseLayer baseLayer) {
        this.f56879u = baseLayer;
    }

    void L(float f3) {
        this.f56882x.j(f3);
        if (this.f56876r != null) {
            for (int i3 = 0; i3 < this.f56876r.a().size(); i3++) {
                ((BaseKeyframeAnimation) this.f56876r.a().get(i3)).m(f3);
            }
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f56877s;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.m(f3);
        }
        BaseLayer baseLayer = this.f56878t;
        if (baseLayer != null) {
            baseLayer.L(f3);
        }
        for (int i4 = 0; i4 < this.f56881w.size(); i4++) {
            ((BaseKeyframeAnimation) this.f56881w.get(i4)).m(f3);
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        E();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        this.f56882x.c(obj, lottieValueCallback);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
        BaseLayer baseLayer = this.f56878t;
        if (baseLayer != null) {
            KeyPath keyPathA = keyPath2.a(baseLayer.getName());
            if (keyPath.c(this.f56878t.getName(), i3)) {
                list.add(keyPathA.i(this.f56878t));
            }
            if (keyPath.h(getName(), i3)) {
                this.f56878t.H(keyPath, keyPath.e(this.f56878t.getName(), i3) + i3, list, keyPathA);
            }
        }
        if (keyPath.g(getName(), i3)) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.a(getName());
                if (keyPath.c(getName(), i3)) {
                    list.add(keyPath2.i(this));
                }
            }
            if (keyPath.h(getName(), i3)) {
                H(keyPath, i3 + keyPath.e(getName(), i3), list, keyPath2);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z2) {
        this.f56867i.set(0.0f, 0.0f, 0.0f, 0.0f);
        s();
        this.f56873o.set(matrix);
        if (z2) {
            List list = this.f56880v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f56873o.preConcat(((BaseLayer) this.f56880v.get(size)).f56882x.f());
                }
            } else {
                BaseLayer baseLayer = this.f56879u;
                if (baseLayer != null) {
                    this.f56873o.preConcat(baseLayer.f56882x.f());
                }
            }
        }
        this.f56873o.preConcat(this.f56882x.f());
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56875q.i();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void i(Canvas canvas, Matrix matrix, int i3) {
        Paint paint;
        Integer num;
        L.a(this.f56872n);
        if (!this.f56883y || this.f56875q.x()) {
            L.b(this.f56872n);
            return;
        }
        s();
        L.a("Layer#parentMatrix");
        this.f56860b.reset();
        this.f56860b.set(matrix);
        for (int size = this.f56880v.size() - 1; size >= 0; size--) {
            this.f56860b.preConcat(((BaseLayer) this.f56880v.get(size)).f56882x.f());
        }
        L.b("Layer#parentMatrix");
        BaseKeyframeAnimation baseKeyframeAnimationH = this.f56882x.h();
        int iIntValue = (int) ((((i3 / 255.0f) * ((baseKeyframeAnimationH == null || (num = (Integer) baseKeyframeAnimationH.h()) == null) ? 100 : num.intValue())) / 100.0f) * 255.0f);
        if (!B() && !A()) {
            this.f56860b.preConcat(this.f56882x.f());
            L.a("Layer#drawLayer");
            u(canvas, this.f56860b, iIntValue);
            L.b("Layer#drawLayer");
            F(L.b(this.f56872n));
            return;
        }
        L.a("Layer#computeBounds");
        f(this.f56867i, this.f56860b, false);
        D(this.f56867i, matrix);
        this.f56860b.preConcat(this.f56882x.f());
        C(this.f56867i, this.f56860b);
        this.f56868j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.f56861c);
        if (!this.f56861c.isIdentity()) {
            Matrix matrix2 = this.f56861c;
            matrix2.invert(matrix2);
            this.f56861c.mapRect(this.f56868j);
        }
        if (!this.f56867i.intersect(this.f56868j)) {
            this.f56867i.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        L.b("Layer#computeBounds");
        if (this.f56867i.width() >= 1.0f && this.f56867i.height() >= 1.0f) {
            L.a("Layer#saveLayer");
            this.f56862d.setAlpha(255);
            Utils.l(canvas, this.f56867i, this.f56862d);
            L.b("Layer#saveLayer");
            t(canvas);
            L.a("Layer#drawLayer");
            u(canvas, this.f56860b, iIntValue);
            L.b("Layer#drawLayer");
            if (A()) {
                p(canvas, this.f56860b);
            }
            if (B()) {
                L.a("Layer#drawMatte");
                L.a("Layer#saveLayer");
                Utils.m(canvas, this.f56867i, this.f56865g, 19);
                L.b("Layer#saveLayer");
                t(canvas);
                this.f56878t.i(canvas, matrix, iIntValue);
                L.a("Layer#restoreLayer");
                canvas.restore();
                L.b("Layer#restoreLayer");
                L.b("Layer#drawMatte");
            }
            L.a("Layer#restoreLayer");
            canvas.restore();
            L.b("Layer#restoreLayer");
        }
        if (this.f56884z && (paint = this.A) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.A.setColor(-251901);
            this.A.setStrokeWidth(4.0f);
            canvas.drawRect(this.f56867i, this.A);
            this.A.setStyle(Paint.Style.FILL);
            this.A.setColor(1357638635);
            canvas.drawRect(this.f56867i, this.A);
        }
        F(L.b(this.f56872n));
    }

    public void j(BaseKeyframeAnimation baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.f56881w.add(baseKeyframeAnimation);
    }

    abstract void u(Canvas canvas, Matrix matrix, int i3);

    public BlurEffect w() {
        return this.f56875q.a();
    }

    public BlurMaskFilter x(float f3) {
        if (this.B == f3) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f3 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f3;
        return blurMaskFilter;
    }

    public DropShadowEffect y() {
        return this.f56875q.c();
    }

    Layer z() {
        return this.f56875q;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
    }

    void H(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
    }
}
