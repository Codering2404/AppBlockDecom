package androidx.media3.exoplayer.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SceneRenderer implements VideoFrameMetadataListener, CameraMotionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f45954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f45955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ProjectionRenderer f45956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FrameRotationQueue f45957d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TimedValueQueue f45958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimedValueQueue f45959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f45960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f45961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f45962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SurfaceTexture f45963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile int f45964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f45965m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f45966n;

    private void h(byte[] bArr, int i3, long j3) {
        byte[] bArr2 = this.f45966n;
        int i4 = this.f45965m;
        this.f45966n = bArr;
        if (i3 == -1) {
            i3 = this.f45964l;
        }
        this.f45965m = i3;
        if (i4 == i3 && Arrays.equals(bArr2, this.f45966n)) {
            return;
        }
        byte[] bArr3 = this.f45966n;
        Projection projectionA = bArr3 != null ? ProjectionDecoder.a(bArr3, this.f45965m) : null;
        if (projectionA == null || !ProjectionRenderer.c(projectionA)) {
            projectionA = Projection.b(this.f45965m);
        }
        this.f45959g.a(j3, projectionA);
    }

    @Override // androidx.media3.exoplayer.video.spherical.CameraMotionListener
    public void a(long j3, float[] fArr) {
        this.f45957d.e(j3, fArr);
    }

    public void c(float[] fArr, boolean z2) {
        GLES20.glClear(16384);
        try {
            GlUtil.e();
        } catch (GlUtil.GlException e3) {
            Log.e("SceneRenderer", "Failed to draw a frame", e3);
        }
        if (this.f45954a.compareAndSet(true, false)) {
            ((SurfaceTexture) Assertions.e(this.f45963k)).updateTexImage();
            try {
                GlUtil.e();
            } catch (GlUtil.GlException e4) {
                Log.e("SceneRenderer", "Failed to draw a frame", e4);
            }
            if (this.f45955b.compareAndSet(true, false)) {
                GlUtil.Y(this.f45960h);
            }
            long timestamp = this.f45963k.getTimestamp();
            Long l3 = (Long) this.f45958f.g(timestamp);
            if (l3 != null) {
                this.f45957d.c(this.f45960h, l3.longValue());
            }
            Projection projection = (Projection) this.f45959g.j(timestamp);
            if (projection != null) {
                this.f45956c.d(projection);
            }
        }
        Matrix.multiplyMM(this.f45961i, 0, fArr, 0, this.f45960h, 0);
        this.f45956c.a(this.f45962j, this.f45961i, z2);
    }

    @Override // androidx.media3.exoplayer.video.spherical.CameraMotionListener
    public void d() {
        this.f45958f.c();
        this.f45957d.d();
        this.f45955b.set(true);
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameMetadataListener
    public void e(long j3, long j4, Format format, MediaFormat mediaFormat) {
        this.f45958f.a(j4, Long.valueOf(j3));
        h(format.A, format.B, j4);
    }

    public SurfaceTexture f() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GlUtil.e();
            this.f45956c.b();
            GlUtil.e();
            this.f45962j = GlUtil.n();
        } catch (GlUtil.GlException e3) {
            Log.e("SceneRenderer", "Failed to initialize the renderer", e3);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f45962j);
        this.f45963k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: androidx.media3.exoplayer.video.spherical.a
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f45995a.f45954a.set(true);
            }
        });
        return this.f45963k;
    }

    public void g(int i3) {
        this.f45964l = i3;
    }
}
