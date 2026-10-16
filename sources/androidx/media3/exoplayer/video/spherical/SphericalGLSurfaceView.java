package androidx.media3.exoplayer.video.spherical;

import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.spherical.OrientationListener;
import androidx.media3.exoplayer.video.spherical.TouchTracker;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f45967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f45968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Sensor f45969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final OrientationListener f45970d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f45971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SceneRenderer f45972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SurfaceTexture f45973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Surface f45974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f45975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f45976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f45977l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class Renderer implements GLSurfaceView.Renderer, TouchTracker.Listener, OrientationListener.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SceneRenderer f45978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f45979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f45980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float[] f45981d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float[] f45982f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final float[] f45983g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f45984h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f45985i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final float[] f45986j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final float[] f45987k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ SphericalGLSurfaceView f45988l;

        private float c(float f3) {
            if (f3 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f3))) * 2.0d);
            }
            return 90.0f;
        }

        private void d() {
            Matrix.setRotateM(this.f45982f, 0, -this.f45984h, (float) Math.cos(this.f45985i), (float) Math.sin(this.f45985i), 0.0f);
        }

        @Override // androidx.media3.exoplayer.video.spherical.OrientationListener.Listener
        public synchronized void a(float[] fArr, float f3) {
            float[] fArr2 = this.f45981d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f45985i = -f3;
            d();
        }

        @Override // androidx.media3.exoplayer.video.spherical.TouchTracker.Listener
        public synchronized void b(PointF pointF) {
            this.f45984h = pointF.y;
            d();
            Matrix.setRotateM(this.f45983g, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f45987k, 0, this.f45981d, 0, this.f45983g, 0);
                Matrix.multiplyMM(this.f45986j, 0, this.f45982f, 0, this.f45987k, 0);
            }
            Matrix.multiplyMM(this.f45980c, 0, this.f45979b, 0, this.f45986j, 0);
            this.f45978a.c(this.f45980c, false);
        }

        @Override // androidx.media3.exoplayer.video.spherical.TouchTracker.Listener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return this.f45988l.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i3, int i4) {
            GLES20.glViewport(0, 0, i3, i4);
            float f3 = i3 / i4;
            Matrix.perspectiveM(this.f45979b, 0, c(f3), f3, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            this.f45988l.d(this.f45978a.f());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface VideoSurfaceListener {
        void B(Surface surface);

        void D(Surface surface);
    }

    public static /* synthetic */ void a(SphericalGLSurfaceView sphericalGLSurfaceView) {
        Surface surface = sphericalGLSurfaceView.f45974i;
        if (surface != null) {
            Iterator it = sphericalGLSurfaceView.f45967a.iterator();
            while (it.hasNext()) {
                ((VideoSurfaceListener) it.next()).B(surface);
            }
        }
        e(sphericalGLSurfaceView.f45973h, surface);
        sphericalGLSurfaceView.f45973h = null;
        sphericalGLSurfaceView.f45974i = null;
    }

    public static /* synthetic */ void b(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = sphericalGLSurfaceView.f45973h;
        Surface surface = sphericalGLSurfaceView.f45974i;
        Surface surface2 = new Surface(surfaceTexture);
        sphericalGLSurfaceView.f45973h = surfaceTexture;
        sphericalGLSurfaceView.f45974i = surface2;
        Iterator it = sphericalGLSurfaceView.f45967a.iterator();
        while (it.hasNext()) {
            ((VideoSurfaceListener) it.next()).D(surface2);
        }
        e(surfaceTexture2, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final SurfaceTexture surfaceTexture) {
        this.f45971f.post(new Runnable() { // from class: androidx.media3.exoplayer.video.spherical.c
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView.b(this.f45997a, surfaceTexture);
            }
        });
    }

    private static void e(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void g() {
        boolean z2 = this.f45975j && this.f45976k;
        Sensor sensor = this.f45969c;
        if (sensor == null || z2 == this.f45977l) {
            return;
        }
        if (z2) {
            this.f45968b.registerListener(this.f45970d, sensor, 0);
        } else {
            this.f45968b.unregisterListener(this.f45970d);
        }
        this.f45977l = z2;
    }

    public void f(VideoSurfaceListener videoSurfaceListener) {
        this.f45967a.remove(videoSurfaceListener);
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.f45972g;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.f45972g;
    }

    public Surface getVideoSurface() {
        return this.f45974i;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f45971f.post(new Runnable() { // from class: androidx.media3.exoplayer.video.spherical.b
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView.a(this.f45996a);
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f45976k = false;
        g();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f45976k = true;
        g();
    }

    public void setDefaultStereoMode(int i3) {
        this.f45972g.g(i3);
    }

    public void setUseSensorRotation(boolean z2) {
        this.f45975j = z2;
        g();
    }
}
