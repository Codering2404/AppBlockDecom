package com.applovin.impl;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class wg implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f64663a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f64664b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f64665c = new float[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f64666d = new float[3];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Display f64667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a[] f64668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f64669h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(float[] fArr, float f3);
    }

    public wg(Display display, a... aVarArr) {
        this.f64667f = display;
        this.f64668g = aVarArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f64664b);
        SensorManager.getOrientation(this.f64664b, this.f64666d);
        return this.f64666d[2];
    }

    private void b(float[] fArr) {
        if (!this.f64669h) {
            j9.a(this.f64665c, fArr);
            this.f64669h = true;
        }
        float[] fArr2 = this.f64664b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f64664b, 0, this.f64665c, 0);
    }

    private static void c(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f64663a, sensorEvent.values);
        a(this.f64663a, this.f64667f.getRotation());
        float fA = a(this.f64663a);
        c(this.f64663a);
        b(this.f64663a);
        a(this.f64663a, fA);
    }

    private void a(float[] fArr, float f3) {
        for (a aVar : this.f64668g) {
            aVar.a(fArr, f3);
        }
    }

    private void a(float[] fArr, int i3) {
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
            float[] fArr2 = this.f64664b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f64664b, i4, i5, fArr);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
