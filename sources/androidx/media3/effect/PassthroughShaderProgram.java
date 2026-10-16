package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.effect.GlShaderProgram;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PassthroughShaderProgram implements GlShaderProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GlShaderProgram.InputListener f42520a = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.PassthroughShaderProgram.1
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GlShaderProgram.OutputListener f42521b = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.PassthroughShaderProgram.2
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GlShaderProgram.ErrorListener f42522c = new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.x1
        @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
        public final void a(VideoFrameProcessingException videoFrameProcessingException) {
            PassthroughShaderProgram.e(videoFrameProcessingException);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Executor f42523d = MoreExecutors.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f42524e = -1;

    @Override // androidx.media3.effect.GlShaderProgram
    public void c() {
        this.f42521b.c();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
        this.f42524e = glTextureInfo.f40690a;
        this.f42521b.a(glTextureInfo, j3);
    }

    protected final GlShaderProgram.InputListener f() {
        return this.f42520a;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.f42524e = -1;
        this.f42520a.b();
        this.f42520a.f();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void g(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.f42523d = executor;
        this.f42522c = errorListener;
    }

    protected final void j(final Exception exc) {
        this.f42523d.execute(new Runnable() { // from class: androidx.media3.effect.y1
            @Override // java.lang.Runnable
            public final void run() {
                this.f42816a.f42522c.a(VideoFrameProcessingException.a(exc));
            }
        });
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void k(GlShaderProgram.OutputListener outputListener) {
        this.f42521b = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void l(GlTextureInfo glTextureInfo) {
        Assertions.g(glTextureInfo.f40690a == this.f42524e);
        this.f42524e = -1;
        this.f42520a.e(glTextureInfo);
        this.f42520a.f();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void m(GlShaderProgram.InputListener inputListener) {
        this.f42520a = inputListener;
        if (this.f42524e == -1) {
            inputListener.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() {
        this.f42524e = -1;
    }

    public static /* synthetic */ void e(VideoFrameProcessingException videoFrameProcessingException) {
    }
}
