package com.applovin.impl;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import com.applovin.impl.jo;
import com.applovin.impl.wg;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class rk extends GLSurfaceView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f62854n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f62855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f62856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Sensor f62857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final wg f62858d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f62859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final jo f62860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final dj f62861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SurfaceTexture f62862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Surface f62863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f62864k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f62865l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f62866m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(Surface surface);

        void b(Surface surface);
    }

    public rk(Context context) {
        this(context, null);
    }

    public v2 getCameraMotionListener() {
        return this.f62861h;
    }

    public uq getVideoFrameMetadataListener() {
        return this.f62861h;
    }

    public Surface getVideoSurface() {
        return this.f62863j;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f62859f.post(new Runnable() { // from class: com.applovin.impl.o40
            @Override // java.lang.Runnable
            public final void run() {
                this.f62181a.a();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f62865l = false;
        b();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f62865l = true;
        b();
    }

    public void setDefaultStereoMode(int i3) {
        this.f62861h.a(i3);
    }

    public void setUseSensorRotation(boolean z2) {
        this.f62864k = z2;
        b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class a implements GLSurfaceView.Renderer, jo.a, wg.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final dj f62867a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float[] f62870d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float[] f62871e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float[] f62872f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f62873g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f62874h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f62868b = new float[16];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f62869c = new float[16];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final float[] f62875i = new float[16];

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final float[] f62876j = new float[16];

        public a(dj djVar) {
            float[] fArr = new float[16];
            this.f62870d = fArr;
            float[] fArr2 = new float[16];
            this.f62871e = fArr2;
            float[] fArr3 = new float[16];
            this.f62872f = fArr3;
            this.f62867a = djVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f62874h = 3.1415927f;
        }

        private float a(float f3) {
            if (f3 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f3))) * 2.0d);
            }
            return 90.0f;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f62876j, 0, this.f62870d, 0, this.f62872f, 0);
                Matrix.multiplyMM(this.f62875i, 0, this.f62871e, 0, this.f62876j, 0);
            }
            Matrix.multiplyMM(this.f62869c, 0, this.f62868b, 0, this.f62875i, 0);
            this.f62867a.a(this.f62869c, false);
        }

        @Override // com.applovin.impl.jo.a
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return rk.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i3, int i4) {
            GLES20.glViewport(0, 0, i3, i4);
            float f3 = i3 / i4;
            Matrix.perspectiveM(this.f62868b, 0, a(f3), f3, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            rk.this.b(this.f62867a.b());
        }

        @Override // com.applovin.impl.wg.a
        public synchronized void a(float[] fArr, float f3) {
            float[] fArr2 = this.f62870d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f62874h = -f3;
            a();
        }

        @Override // com.applovin.impl.jo.a
        public synchronized void a(PointF pointF) {
            this.f62873g = pointF.y;
            a();
            Matrix.setRotateM(this.f62872f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        private void a() {
            Matrix.setRotateM(this.f62871e, 0, -this.f62873g, (float) Math.cos(this.f62874h), (float) Math.sin(this.f62874h), 0.0f);
        }
    }

    public rk(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62855a = new CopyOnWriteArrayList();
        this.f62859f = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) b1.a(context.getSystemService("sensor"));
        this.f62856b = sensorManager;
        Sensor defaultSensor = xp.f65027a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f62857c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        dj djVar = new dj();
        this.f62861h = djVar;
        a aVar = new a(djVar);
        jo joVar = new jo(context, aVar, 25.0f);
        this.f62860g = joVar;
        this.f62858d = new wg(((WindowManager) b1.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), joVar, aVar);
        this.f62864k = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(joVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final SurfaceTexture surfaceTexture) {
        this.f62859f.post(new Runnable() { // from class: com.applovin.impl.n40
            @Override // java.lang.Runnable
            public final void run() {
                this.f61980a.a(surfaceTexture);
            }
        });
    }

    public void a(b bVar) {
        this.f62855a.add(bVar);
    }

    public void b(b bVar) {
        this.f62855a.remove(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        Surface surface = this.f62863j;
        if (surface != null) {
            Iterator it = this.f62855a.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(surface);
            }
        }
        a(this.f62862i, surface);
        this.f62862i = null;
        this.f62863j = null;
    }

    private void b() {
        boolean z2 = this.f62864k && this.f62865l;
        Sensor sensor = this.f62857c;
        if (sensor == null || z2 == this.f62866m) {
            return;
        }
        if (z2) {
            this.f62856b.registerListener(this.f62858d, sensor, 0);
        } else {
            this.f62856b.unregisterListener(this.f62858d);
        }
        this.f62866m = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f62862i;
        Surface surface = this.f62863j;
        Surface surface2 = new Surface(surfaceTexture);
        this.f62862i = surfaceTexture;
        this.f62863j = surface2;
        Iterator it = this.f62855a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b(surface2);
        }
        a(surfaceTexture2, surface);
    }

    private static void a(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }
}
