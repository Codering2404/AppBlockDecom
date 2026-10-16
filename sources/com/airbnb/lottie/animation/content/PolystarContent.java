package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f56521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LottieDrawable f56522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PolystarShape.Type f56523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f56524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f56525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BaseKeyframeAnimation f56526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BaseKeyframeAnimation f56527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final BaseKeyframeAnimation f56528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final BaseKeyframeAnimation f56529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BaseKeyframeAnimation f56530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final BaseKeyframeAnimation f56531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final BaseKeyframeAnimation f56532m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f56534o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f56520a = new Path();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CompoundTrimPathContent f56533n = new CompoundTrimPathContent();

    /* JADX INFO: renamed from: com.airbnb.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56535a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f56535a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56535a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.f56522c = lottieDrawable;
        this.f56521b = polystarShape.d();
        PolystarShape.Type typeJ = polystarShape.j();
        this.f56523d = typeJ;
        this.f56524e = polystarShape.k();
        this.f56525f = polystarShape.l();
        BaseKeyframeAnimation baseKeyframeAnimationA = polystarShape.g().a();
        this.f56526g = baseKeyframeAnimationA;
        BaseKeyframeAnimation baseKeyframeAnimationA2 = polystarShape.h().a();
        this.f56527h = baseKeyframeAnimationA2;
        BaseKeyframeAnimation baseKeyframeAnimationA3 = polystarShape.i().a();
        this.f56528i = baseKeyframeAnimationA3;
        BaseKeyframeAnimation baseKeyframeAnimationA4 = polystarShape.e().a();
        this.f56530k = baseKeyframeAnimationA4;
        BaseKeyframeAnimation baseKeyframeAnimationA5 = polystarShape.f().a();
        this.f56532m = baseKeyframeAnimationA5;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (typeJ == type) {
            this.f56529j = polystarShape.b().a();
            this.f56531l = polystarShape.c().a();
        } else {
            this.f56529j = null;
            this.f56531l = null;
        }
        baseLayer.j(baseKeyframeAnimationA);
        baseLayer.j(baseKeyframeAnimationA2);
        baseLayer.j(baseKeyframeAnimationA3);
        baseLayer.j(baseKeyframeAnimationA4);
        baseLayer.j(baseKeyframeAnimationA5);
        if (typeJ == type) {
            baseLayer.j(this.f56529j);
            baseLayer.j(this.f56531l);
        }
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
        baseKeyframeAnimationA3.a(this);
        baseKeyframeAnimationA4.a(this);
        baseKeyframeAnimationA5.a(this);
        if (typeJ == type) {
            this.f56529j.a(this);
            this.f56531l.a(this);
        }
    }

    private void h() {
        double d3;
        int iFloor = (int) Math.floor(((Float) this.f56526g.h()).floatValue());
        double radians = Math.toRadians((this.f56528i == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = ((Float) this.f56532m.h()).floatValue() / 100.0f;
        float fFloatValue2 = ((Float) this.f56530k.h()).floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.f56520a.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i3 = 0;
        while (i3 < dCeil) {
            float fCos2 = (float) (Math.cos(d7) * d5);
            int i4 = i3;
            double d8 = d7;
            float fSin2 = (float) (d5 * Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d3 = dCeil;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f3 = fFloatValue2 * fFloatValue * 0.25f;
                this.f56520a.cubicTo(fCos - (f3 * fCos3), fSin - (f3 * fSin3), fCos2 + (((float) Math.cos(dAtan22)) * f3), fSin2 + (f3 * ((float) Math.sin(dAtan22))), fCos2, fSin2);
                fCos = fCos2;
                fSin = fSin2;
            } else {
                fSin = fSin2;
                d3 = dCeil;
                fCos = fCos2;
                this.f56520a.lineTo(fCos, fSin);
            }
            d7 = d8 + d6;
            i3 = i4 + 1;
            dCeil = d3;
        }
        PointF pointF = (PointF) this.f56527h.h();
        this.f56520a.offset(pointF.x, pointF.y);
        this.f56520a.close();
    }

    private void j() {
        float f3;
        float f4;
        int i3;
        float fCos;
        float fSin;
        float f5;
        float f6;
        double d3;
        float f7;
        int i4;
        float f8;
        double d4;
        float f9;
        float f10;
        double d5;
        float f11;
        float f12;
        float fFloatValue = ((Float) this.f56526g.h()).floatValue();
        double radians = Math.toRadians((this.f56528i == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d6 = fFloatValue;
        float f13 = (float) (6.283185307179586d / d6);
        if (this.f56525f) {
            f13 *= -1.0f;
        }
        float f14 = f13 / 2.0f;
        float f15 = fFloatValue - ((int) fFloatValue);
        int i5 = (f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1));
        if (i5 != 0) {
            radians += (double) ((1.0f - f15) * f14);
        }
        float fFloatValue2 = ((Float) this.f56530k.h()).floatValue();
        float fFloatValue3 = ((Float) this.f56529j.h()).floatValue();
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56531l;
        float fFloatValue4 = baseKeyframeAnimation != null ? ((Float) baseKeyframeAnimation.h()).floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56532m;
        float fFloatValue5 = baseKeyframeAnimation2 != null ? ((Float) baseKeyframeAnimation2.h()).floatValue() / 100.0f : 0.0f;
        if (i5 != 0) {
            f7 = ((fFloatValue2 - fFloatValue3) * f15) + fFloatValue3;
            f4 = 0.0f;
            i3 = i5;
            double d7 = f7;
            f3 = 2.0f;
            float fCos2 = (float) (d7 * Math.cos(radians));
            fSin = (float) (d7 * Math.sin(radians));
            this.f56520a.moveTo(fCos2, fSin);
            d3 = radians + ((double) ((f13 * f15) / 2.0f));
            f5 = f15;
            fCos = fCos2;
            f6 = f14;
        } else {
            f3 = 2.0f;
            f4 = 0.0f;
            i3 = i5;
            double d8 = fFloatValue2;
            fCos = (float) (Math.cos(radians) * d8);
            fSin = (float) (d8 * Math.sin(radians));
            this.f56520a.moveTo(fCos, fSin);
            f5 = f15;
            f6 = f14;
            d3 = radians + ((double) f6);
            f7 = 0.0f;
        }
        double dCeil = Math.ceil(d6) * 2.0d;
        int i6 = 0;
        boolean z2 = false;
        double d9 = d3;
        float f16 = fSin;
        float f17 = fCos;
        double d10 = d9;
        while (true) {
            double d11 = i6;
            if (d11 >= dCeil) {
                PointF pointF = (PointF) this.f56527h.h();
                this.f56520a.offset(pointF.x, pointF.y);
                this.f56520a.close();
                return;
            }
            float f18 = z2 ? fFloatValue2 : fFloatValue3;
            if (f7 == f4 || d11 != dCeil - 2.0d) {
                i4 = i6;
                f8 = f6;
            } else {
                i4 = i6;
                f8 = (f13 * f5) / f3;
            }
            if (f7 == f4 || d11 != dCeil - 1.0d) {
                d4 = d11;
                f9 = f18;
            } else {
                d4 = d11;
                f9 = f7;
            }
            double d12 = f9;
            float fCos3 = (float) (d12 * Math.cos(d10));
            float f19 = f13;
            float fSin2 = (float) (d12 * Math.sin(d10));
            if (fFloatValue4 == f4 && fFloatValue5 == f4) {
                this.f56520a.lineTo(fCos3, fSin2);
                f12 = fCos3;
                f11 = fSin2;
                f10 = f6;
                d5 = d10;
            } else {
                f10 = f6;
                d5 = d10;
                double dAtan2 = (float) (Math.atan2(f16, f17) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                float f20 = f17;
                float f21 = f16;
                f11 = fSin2;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin4 = (float) Math.sin(dAtan22);
                float f22 = z2 ? fFloatValue4 : fFloatValue5;
                float f23 = z2 ? fFloatValue5 : fFloatValue4;
                float f24 = (z2 ? fFloatValue3 : fFloatValue2) * f22 * 0.47829f;
                float f25 = fCos4 * f24;
                float f26 = f24 * fSin3;
                float f27 = (z2 ? fFloatValue2 : fFloatValue3) * f23 * 0.47829f;
                float f28 = fCos5 * f27;
                float f29 = f27 * fSin4;
                if (i3 != 0) {
                    if (i4 == 0) {
                        f25 *= f5;
                        f26 *= f5;
                    } else if (d4 == dCeil - 1.0d) {
                        f28 *= f5;
                        f29 *= f5;
                    }
                }
                f12 = fCos3;
                this.f56520a.cubicTo(f20 - f25, f21 - f26, fCos3 + f28, f11 + f29, f12, f11);
            }
            d10 = d5 + ((double) f8);
            z2 = !z2;
            i6 = i4 + 1;
            f6 = f10;
            f17 = f12;
            f16 = f11;
            f13 = f19;
        }
    }

    private void k() {
        this.f56534o = false;
        this.f56522c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        k();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            Content content = (Content) list.get(i3);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.k() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f56533n.a(trimPathContent);
                    trimPathContent.d(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        BaseKeyframeAnimation baseKeyframeAnimation2;
        if (obj == LottieProperty.f56379w) {
            this.f56526g.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.f56380x) {
            this.f56528i.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.f56370n) {
            this.f56527h.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.f56381y && (baseKeyframeAnimation2 = this.f56529j) != null) {
            baseKeyframeAnimation2.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.f56382z) {
            this.f56530k.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.A && (baseKeyframeAnimation = this.f56531l) != null) {
            baseKeyframeAnimation.n(lottieValueCallback);
        } else if (obj == LottieProperty.B) {
            this.f56532m.n(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i3, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path g() {
        if (this.f56534o) {
            return this.f56520a;
        }
        this.f56520a.reset();
        if (this.f56524e) {
            this.f56534o = true;
            return this.f56520a;
        }
        int i3 = AnonymousClass1.f56535a[this.f56523d.ordinal()];
        if (i3 == 1) {
            j();
        } else if (i3 == 2) {
            h();
        }
        this.f56520a.close();
        this.f56533n.b(this.f56520a);
        this.f56534o = true;
        return this.f56520a;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56521b;
    }
}
