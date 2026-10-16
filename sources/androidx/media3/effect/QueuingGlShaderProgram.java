package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlRect;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.effect.GlShaderProgram;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class QueuingGlShaderProgram<T> implements GlShaderProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentEffect f42537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TexturePool f42538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue f42539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GlShaderProgram.InputListener f42540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GlShaderProgram.OutputListener f42541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GlShaderProgram.ErrorListener f42542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Executor f42543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f42544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f42545i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ConcurrentEffect<T> {
        void a(GlTextureInfo glTextureInfo, long j3, Object obj);

        void c();

        Future d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3);

        void flush();

        void release();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TimedTextureInfo<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final GlTextureInfo f42548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f42549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Future f42550c;

        TimedTextureInfo(GlTextureInfo glTextureInfo, long j3, Future future) {
            this.f42548a = glTextureInfo;
            this.f42549b = j3;
            this.f42550c = future;
        }
    }

    public QueuingGlShaderProgram(boolean z2, int i3, ConcurrentEffect concurrentEffect) {
        Assertions.a(i3 > 0);
        this.f42537a = concurrentEffect;
        this.f42539c = new ArrayDeque(i3);
        this.f42538b = new TexturePool(z2, i3);
        this.f42540d = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.QueuingGlShaderProgram.1
        };
        this.f42541e = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.QueuingGlShaderProgram.2
        };
        this.f42542f = new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.a2
            @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
            public final void a(VideoFrameProcessingException videoFrameProcessingException) {
                Log.e("QueuingGlShaderProgram", "Exception caught by default QueuingGlShaderProgram errorListener.", videoFrameProcessingException);
            }
        };
        this.f42543g = MoreExecutors.a();
        this.f42544h = -1;
        this.f42545i = -1;
    }

    private void f() {
        while (true) {
            TimedTextureInfo timedTextureInfo = (TimedTextureInfo) this.f42539c.poll();
            if (timedTextureInfo == null) {
                return;
            } else {
                timedTextureInfo.f42550c.cancel(false);
            }
        }
    }

    private void j(final Exception exc) {
        this.f42543g.execute(new Runnable() { // from class: androidx.media3.effect.z1
            @Override // java.lang.Runnable
            public final void run() {
                this.f42823a.f42542f.a(VideoFrameProcessingException.a(exc));
            }
        });
    }

    private boolean n() {
        TimedTextureInfo timedTextureInfo = (TimedTextureInfo) this.f42539c.poll();
        if (timedTextureInfo == null) {
            return false;
        }
        try {
            Object objB = Futures.b(timedTextureInfo.f42550c, VideoFrameProcessingException.class, 500000L, TimeUnit.MILLISECONDS);
            GlTextureInfo glTextureInfo = timedTextureInfo.f42548a;
            GlUtil.H(glTextureInfo.f40691b, glTextureInfo.f40693d, glTextureInfo.f40694e);
            this.f42537a.a(timedTextureInfo.f42548a, timedTextureInfo.f42549b, objB);
            this.f42541e.a(timedTextureInfo.f42548a, timedTextureInfo.f42549b);
            return true;
        } catch (VideoFrameProcessingException | GlUtil.GlException e3) {
            j(e3);
            return false;
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void c() {
        try {
            this.f42537a.c();
        } catch (VideoFrameProcessingException e3) {
            j(e3);
        }
        while (n()) {
        }
        this.f42541e.c();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
        try {
            if (this.f42544h != glTextureInfo.f40693d || this.f42545i != glTextureInfo.f40694e || !this.f42538b.j()) {
                while (n()) {
                }
                int i3 = glTextureInfo.f40693d;
                this.f42544h = i3;
                int i4 = glTextureInfo.f40694e;
                this.f42545i = i4;
                this.f42538b.d(glObjectsProvider, i3, i4);
            }
            GlTextureInfo glTextureInfoL = this.f42538b.l();
            Assertions.g(glTextureInfo.f40691b != -1);
            GlUtil.c(glTextureInfo.f40691b, new GlRect(this.f42544h, this.f42545i), glTextureInfoL.f40691b, new GlRect(this.f42544h, this.f42545i));
            this.f42539c.add(new TimedTextureInfo(glTextureInfoL, j3, this.f42537a.d(glObjectsProvider, glTextureInfoL, j3)));
            this.f42540d.e(glTextureInfo);
            if (this.f42539c.size() == this.f42538b.a()) {
                Assertions.g(n());
            }
        } catch (GlUtil.GlException e3) {
            j(e3);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        try {
            this.f42537a.flush();
        } catch (VideoFrameProcessingException e3) {
            j(e3);
        }
        f();
        this.f42538b.e();
        this.f42540d.b();
        for (int i3 = 0; i3 < this.f42538b.a(); i3++) {
            this.f42540d.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void g(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.f42543g = executor;
        this.f42542f = errorListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void k(GlShaderProgram.OutputListener outputListener) {
        this.f42541e = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void l(GlTextureInfo glTextureInfo) {
        if (this.f42538b.k(glTextureInfo)) {
            this.f42538b.g(glTextureInfo);
            this.f42540d.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void m(GlShaderProgram.InputListener inputListener) {
        this.f42540d = inputListener;
        for (int i3 = 0; i3 < this.f42538b.h(); i3++) {
            inputListener.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        try {
            f();
            this.f42537a.release();
            this.f42538b.c();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }
}
