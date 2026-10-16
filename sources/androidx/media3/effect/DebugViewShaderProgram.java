package androidx.media3.effect;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DebugViewShaderProgram implements GlShaderProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f42255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DebugViewProvider f42256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SurfaceView f42257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DefaultShaderProgram f42258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SurfaceViewWrapper f42259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ColorInfo f42260f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private EGLDisplay f42265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f42266l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f42267m = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GlShaderProgram.InputListener f42261g = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.DebugViewShaderProgram.1
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GlShaderProgram.OutputListener f42262h = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.DebugViewShaderProgram.2
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GlShaderProgram.ErrorListener f42263i = new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.n
        @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
        public final void a(VideoFrameProcessingException videoFrameProcessingException) {
            Log.e("DebugViewShaderProgram", "Exception caught by errorListener.", videoFrameProcessingException);
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Executor f42264j = MoreExecutors.a();

    public DebugViewShaderProgram(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo) {
        this.f42255a = context;
        this.f42256b = debugViewProvider;
        this.f42260f = colorInfo;
    }

    private void j(int i3, int i4) {
        if (this.f42265k == null) {
            this.f42265k = GlUtil.M();
        }
        EGLContext eGLContextL = GlUtil.L();
        if (this.f42266l == -1 || this.f42267m == -1) {
            this.f42266l = i3;
            this.f42267m = i4;
        }
        SurfaceView surfaceViewB = this.f42256b.b(this.f42266l, this.f42267m);
        if (surfaceViewB != null && !Objects.equals(this.f42257c, surfaceViewB)) {
            this.f42259e = new SurfaceViewWrapper(this.f42265k, eGLContextL, surfaceViewB, this.f42260f.f40556c);
        }
        this.f42257c = surfaceViewB;
        if (this.f42258d == null) {
            ImmutableList.Builder builder = new ImmutableList.Builder();
            builder.a(Presentation.m(this.f42266l, this.f42267m, 0));
            Context context = this.f42255a;
            ImmutableList immutableListM = builder.m();
            ImmutableList immutableListY = ImmutableList.y();
            ColorInfo colorInfo = this.f42260f;
            this.f42258d = DefaultShaderProgram.u(context, immutableListM, immutableListY, colorInfo, colorInfo.f40556c == 1 ? 2 : 0);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void c() {
        this.f42262h.c();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, final GlTextureInfo glTextureInfo, final long j3) {
        try {
            j(glTextureInfo.f40693d, glTextureInfo.f40694e);
            final DefaultShaderProgram defaultShaderProgram = (DefaultShaderProgram) Assertions.e(this.f42258d);
            ((SurfaceViewWrapper) Assertions.e(this.f42259e)).a(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.o
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException {
                    defaultShaderProgram.n(glTextureInfo.f40690a, j3);
                }
            }, glObjectsProvider);
            this.f42262h.a(glTextureInfo, j3);
        } catch (VideoFrameProcessingException | GlUtil.GlException e3) {
            this.f42264j.execute(new Runnable() { // from class: androidx.media3.effect.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42774a.f42263i.a(VideoFrameProcessingException.b(e3, j3));
                }
            });
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        DefaultShaderProgram defaultShaderProgram = this.f42258d;
        if (defaultShaderProgram != null) {
            defaultShaderProgram.flush();
        }
        this.f42261g.b();
        this.f42261g.f();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void g(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.f42263i = errorListener;
        this.f42264j = executor;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void k(GlShaderProgram.OutputListener outputListener) {
        this.f42262h = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void l(GlTextureInfo glTextureInfo) {
        this.f42261g.e(glTextureInfo);
        this.f42261g.f();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void m(GlShaderProgram.InputListener inputListener) {
        this.f42261g = inputListener;
        inputListener.f();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        DefaultShaderProgram defaultShaderProgram = this.f42258d;
        if (defaultShaderProgram != null) {
            defaultShaderProgram.release();
        }
        try {
            GlUtil.e();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SurfaceViewWrapper implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EGLDisplay f42271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final EGLContext f42272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Surface f42273d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private EGLSurface f42274f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f42275g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f42276h;

        public SurfaceViewWrapper(EGLDisplay eGLDisplay, EGLContext eGLContext, SurfaceView surfaceView, int i3) {
            this.f42271b = eGLDisplay;
            this.f42272c = eGLContext;
            if (i3 == 7 && Util.f41609a < 34) {
                i3 = 6;
            }
            this.f42270a = i3;
            surfaceView.getHolder().addCallback(this);
            this.f42273d = surfaceView.getHolder().getSurface();
            this.f42275g = surfaceView.getWidth();
            this.f42276h = surfaceView.getHeight();
        }

        public synchronized void a(VideoFrameProcessingTaskExecutor.Task task, GlObjectsProvider glObjectsProvider) {
            try {
                Surface surface = this.f42273d;
                if (surface == null) {
                    return;
                }
                if (this.f42274f == null) {
                    this.f42274f = glObjectsProvider.a(this.f42271b, surface, this.f42270a, false);
                }
                EGLSurface eGLSurface = this.f42274f;
                GlUtil.G(this.f42271b, this.f42272c, eGLSurface, this.f42275g, this.f42276h);
                task.run();
                EGL14.eglSwapBuffers(this.f42271b, eGLSurface);
                GLES20.glFinish();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public synchronized void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
            this.f42275g = i4;
            this.f42276h = i5;
            Surface surface = surfaceHolder.getSurface();
            if (!surface.equals(this.f42273d)) {
                this.f42273d = surface;
                this.f42274f = null;
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public synchronized void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f42273d = null;
            this.f42274f = null;
            this.f42275g = -1;
            this.f42276h = -1;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }
    }
}
