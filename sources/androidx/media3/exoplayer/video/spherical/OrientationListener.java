package androidx.media3.exoplayer.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class OrientationListener implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f45920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f45921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f45922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f45923d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Display f45924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Listener[] f45925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f45926h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(float[] fArr, float f3);
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f45921b);
        SensorManager.getOrientation(this.f45921b, this.f45923d);
        return this.f45923d[2];
    }

    private void b(float[] fArr, float f3) {
        for (Listener listener : this.f45925g) {
            listener.a(fArr, f3);
        }
    }

    private void c(float[] fArr) {
        if (!this.f45926h) {
            FrameRotationQueue.a(this.f45922c, fArr);
            this.f45926h = true;
        }
        float[] fArr2 = this.f45921b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f45921b, 0, this.f45922c, 0);
    }

    private void d(float[] fArr, int i3) {
        if (i3 != 0) {
            int i4 = 129;
            int i5 = 1;
            if (i3 == 1) {
                i5 = 129;
                i4 = 2;
            } else if (i3 == 2) {
                i5 = 130;
            } else {
                if (i3 != 3) {
                    throw new IllegalStateException();
                }
                i4 = 130;
            }
            float[] fArr2 = this.f45921b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f45921b, i4, i5, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f45920a, sensorEvent.values);
        d(this.f45920a, this.f45924f.getRotation());
        float fA = a(this.f45920a);
        e(this.f45920a);
        c(this.f45920a);
        b(this.f45920a, fA);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
