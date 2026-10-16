package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PathKeyframe extends Keyframe<PointF> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Path f56607q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Keyframe f56608r;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe keyframe) {
        super(lottieComposition, (PointF) keyframe.f57111b, (PointF) keyframe.f57112c, keyframe.f57113d, keyframe.f57114e, keyframe.f57115f, keyframe.f57116g, keyframe.f57117h);
        this.f56608r = keyframe;
        j();
    }

    public void j() {
        Object obj;
        Object obj2;
        Object obj3 = this.f57112c;
        boolean z2 = (obj3 == null || (obj2 = this.f57111b) == null || !((PointF) obj2).equals(((PointF) obj3).x, ((PointF) obj3).y)) ? false : true;
        Object obj4 = this.f57111b;
        if (obj4 == null || (obj = this.f57112c) == null || z2) {
            return;
        }
        Keyframe keyframe = this.f56608r;
        this.f56607q = Utils.d((PointF) obj4, (PointF) obj, keyframe.f57124o, keyframe.f57125p);
    }

    Path k() {
        return this.f56607q;
    }
}
