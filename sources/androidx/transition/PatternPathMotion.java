package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PatternPathMotion extends PathMotion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f53451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f53452b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f53453c = new Matrix();

    public PatternPathMotion(Path path) {
        c(path);
    }

    private static float b(float f3, float f4) {
        return (float) Math.sqrt((f3 * f3) + (f4 * f4));
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f3, float f4, float f5, float f6) {
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        float fB = b(f7, f8);
        double dAtan2 = Math.atan2(f8, f7);
        this.f53453c.setScale(fB, fB);
        this.f53453c.postRotate((float) Math.toDegrees(dAtan2));
        this.f53453c.postTranslate(f3, f4);
        Path path = new Path();
        this.f53452b.transform(this.f53453c, path);
        return path;
    }

    public void c(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f5 = fArr[0];
        float f6 = fArr[1];
        if (f5 == f3 && f6 == f4) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f53453c.setTranslate(-f5, -f6);
        float f7 = f3 - f5;
        float f8 = f4 - f6;
        float fB = 1.0f / b(f7, f8);
        this.f53453c.postScale(fB, fB);
        this.f53453c.postRotate((float) Math.toDegrees(-Math.atan2(f8, f7)));
        path.transform(this.f53453c, this.f53452b);
        this.f53451a = path;
    }
}
