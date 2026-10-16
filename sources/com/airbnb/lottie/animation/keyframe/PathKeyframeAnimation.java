package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PointF f56609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float[] f56610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PathMeasure f56611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PathKeyframe f56612l;

    public PathKeyframeAnimation(List list) {
        super(list);
        this.f56609i = new PointF();
        this.f56610j = new float[2];
        this.f56611k = new PathMeasure();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(Keyframe keyframe, float f3) {
        float f4;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path pathK = pathKeyframe.k();
        if (pathK == null) {
            return (PointF) keyframe.f57111b;
        }
        LottieValueCallback lottieValueCallback = this.f56584e;
        if (lottieValueCallback != null) {
            f4 = f3;
            PointF pointF = (PointF) lottieValueCallback.b(pathKeyframe.f57116g, pathKeyframe.f57117h.floatValue(), (PointF) pathKeyframe.f57111b, (PointF) pathKeyframe.f57112c, e(), f4, f());
            if (pointF != null) {
                return pointF;
            }
        } else {
            f4 = f3;
        }
        if (this.f56612l != pathKeyframe) {
            this.f56611k.setPath(pathK, false);
            this.f56612l = pathKeyframe;
        }
        PathMeasure pathMeasure = this.f56611k;
        pathMeasure.getPosTan(pathMeasure.getLength() * f4, this.f56610j, null);
        PointF pointF2 = this.f56609i;
        float[] fArr = this.f56610j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f56609i;
    }
}
