package androidx.transition;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class PathProperty<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Property f53445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathMeasure f53446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f53447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f53448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PointF f53449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f53450f;

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(Object obj) {
        return Float.valueOf(this.f53450f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Object obj, Float f3) {
        this.f53450f = f3.floatValue();
        this.f53446b.getPosTan(this.f53447c * f3.floatValue(), this.f53448d, null);
        PointF pointF = this.f53449e;
        float[] fArr = this.f53448d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f53445a.set(obj, pointF);
    }
}
