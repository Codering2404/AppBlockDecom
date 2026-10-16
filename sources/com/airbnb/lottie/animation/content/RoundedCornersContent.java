package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LottieDrawable f56557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f56558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BaseKeyframeAnimation f56559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ShapeData f56560d;

    public RoundedCornersContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RoundedCorners roundedCorners) {
        this.f56557a = lottieDrawable;
        this.f56558b = roundedCorners.c();
        BaseKeyframeAnimation baseKeyframeAnimationA = roundedCorners.b().a();
        this.f56559c = baseKeyframeAnimationA;
        baseLayer.j(baseKeyframeAnimationA);
        baseKeyframeAnimationA.a(this);
    }

    private static int d(int i3, int i4) {
        int i5 = i3 / i4;
        return ((i3 ^ i4) >= 0 || i4 * i5 == i3) ? i5 : i5 - 1;
    }

    private static int e(int i3, int i4) {
        return i3 - (d(i3, i4) * i4);
    }

    private ShapeData j(ShapeData shapeData) {
        List listA = shapeData.a();
        boolean zD = shapeData.d();
        int size = listA.size() - 1;
        int i3 = 0;
        while (size >= 0) {
            CubicCurveData cubicCurveData = (CubicCurveData) listA.get(size);
            CubicCurveData cubicCurveData2 = (CubicCurveData) listA.get(e(size - 1, listA.size()));
            PointF pointFC = (size != 0 || zD) ? cubicCurveData2.c() : shapeData.b();
            i3 = (((size != 0 || zD) ? cubicCurveData2.b() : pointFC).equals(pointFC) && cubicCurveData.a().equals(pointFC) && !(!shapeData.d() && size == 0 && size == listA.size() - 1)) ? i3 + 2 : i3 + 1;
            size--;
        }
        ShapeData shapeData2 = this.f56560d;
        if (shapeData2 == null || shapeData2.a().size() != i3) {
            ArrayList arrayList = new ArrayList(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(new CubicCurveData());
            }
            this.f56560d = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f56560d.e(zD);
        return this.f56560d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f56557a.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.airbnb.lottie.model.content.ShapeData c(com.airbnb.lottie.model.content.ShapeData r19) {
        /*
            Method dump skipped, instruction units count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.RoundedCornersContent.c(com.airbnb.lottie.model.content.ShapeData):com.airbnb.lottie.model.content.ShapeData");
    }

    public BaseKeyframeAnimation h() {
        return this.f56559c;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
    }
}
