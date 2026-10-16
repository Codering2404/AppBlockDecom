package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.effect.GlShaderProgram;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseGlShaderProgram implements GlShaderProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final TexturePool f42175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GlShaderProgram.InputListener f42176b = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.BaseGlShaderProgram.1
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GlShaderProgram.OutputListener f42177c = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.BaseGlShaderProgram.2
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GlShaderProgram.ErrorListener f42178d = new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.b
        @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
        public final void a(VideoFrameProcessingException videoFrameProcessingException) {
            Log.e("BaseGlShaderProgram", "Exception caught by default BaseGlShaderProgram errorListener.", videoFrameProcessingException);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Executor f42179e = MoreExecutors.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f42180f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f42181g = -1;

    public BaseGlShaderProgram(boolean z2, int i3) {
        this.f42175a = new TexturePool(z2, i3);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void c() {
        this.f42177c.c();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
        try {
            if (this.f42180f != glTextureInfo.f40693d || this.f42181g != glTextureInfo.f40694e || !this.f42175a.j()) {
                int i3 = glTextureInfo.f40693d;
                this.f42180f = i3;
                int i4 = glTextureInfo.f40694e;
                this.f42181g = i4;
                Size sizeJ = j(i3, i4);
                this.f42175a.d(glObjectsProvider, sizeJ.b(), sizeJ.a());
            }
            GlTextureInfo glTextureInfoL = this.f42175a.l();
            GlUtil.H(glTextureInfoL.f40691b, glTextureInfoL.f40693d, glTextureInfoL.f40694e);
            if (r()) {
                GlUtil.g();
            }
            n(glTextureInfo.f40690a, j3);
            this.f42176b.e(glTextureInfo);
            this.f42177c.a(glTextureInfoL, j3);
        } catch (VideoFrameProcessingException e3) {
            e = e3;
            this.f42179e.execute(new Runnable() { // from class: androidx.media3.effect.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42683a.f42178d.a(VideoFrameProcessingException.a(e));
                }
            });
        } catch (GlUtil.GlException e4) {
            e = e4;
            this.f42179e.execute(new Runnable() { // from class: androidx.media3.effect.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42683a.f42178d.a(VideoFrameProcessingException.a(e));
                }
            });
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.f42175a.e();
        this.f42176b.b();
        for (int i3 = 0; i3 < this.f42175a.a(); i3++) {
            this.f42176b.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void g(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.f42179e = executor;
        this.f42178d = errorListener;
    }

    public abstract Size j(int i3, int i4);

    @Override // androidx.media3.effect.GlShaderProgram
    public void k(GlShaderProgram.OutputListener outputListener) {
        this.f42177c = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void l(GlTextureInfo glTextureInfo) {
        if (this.f42175a.k(glTextureInfo)) {
            this.f42175a.g(glTextureInfo);
            this.f42176b.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void m(GlShaderProgram.InputListener inputListener) {
        this.f42176b = inputListener;
        for (int i3 = 0; i3 < this.f42175a.h(); i3++) {
            inputListener.f();
        }
    }

    public abstract void n(int i3, long j3);

    protected final GlShaderProgram.InputListener o() {
        return this.f42176b;
    }

    protected final GlShaderProgram.OutputListener p() {
        return this.f42177c;
    }

    protected final void q(final Exception exc) {
        this.f42179e.execute(new Runnable() { // from class: androidx.media3.effect.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f42696a.f42178d.a(VideoFrameProcessingException.a(exc));
            }
        });
    }

    public boolean r() {
        return true;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        try {
            this.f42175a.c();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}
