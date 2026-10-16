package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.effect.GlShaderProgram;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TimestampWrapperShaderProgram implements GlShaderProgram, GlShaderProgram.InputListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f42666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f42667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WrappedShaderProgramInputListener f42668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GlShaderProgram f42669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final GlShaderProgram f42670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f42671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f42672g;

    public TimestampWrapperShaderProgram(Context context, boolean z2, TimestampWrapper timestampWrapper) {
        this.f42666a = timestampWrapper.f42664b;
        this.f42667b = timestampWrapper.f42665c;
        GlShaderProgram glShaderProgramA = timestampWrapper.f42663a.a(context, z2);
        this.f42669d = glShaderProgramA;
        WrappedShaderProgramInputListener wrappedShaderProgramInputListener = new WrappedShaderProgramInputListener();
        this.f42668c = wrappedShaderProgramInputListener;
        glShaderProgramA.m(wrappedShaderProgramInputListener);
        this.f42670e = new FrameCache(wrappedShaderProgramInputListener.f42673a).a(context, z2);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void c() {
        this.f42669d.c();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
        if (this.f42666a > j3 || j3 > this.f42667b) {
            this.f42672g++;
            this.f42670e.d(glObjectsProvider, glTextureInfo, j3);
        } else {
            this.f42671f++;
            this.f42669d.d(glObjectsProvider, glTextureInfo, j3);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.f42668c.c(false);
        this.f42669d.flush();
        this.f42668c.c(true);
        this.f42670e.flush();
        this.f42672g = 0;
        this.f42671f = 0;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void g(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.f42669d.g(executor, errorListener);
        this.f42670e.g(executor, errorListener);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void k(GlShaderProgram.OutputListener outputListener) {
        this.f42669d.k(outputListener);
        this.f42670e.k(outputListener);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void l(GlTextureInfo glTextureInfo) {
        if (this.f42672g > 0) {
            this.f42670e.l(glTextureInfo);
            this.f42672g--;
        } else {
            if (this.f42671f <= 0) {
                throw new IllegalArgumentException("Output texture not contained in either shader.");
            }
            this.f42669d.l(glTextureInfo);
            this.f42671f--;
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void m(GlShaderProgram.InputListener inputListener) {
        this.f42668c.a(inputListener);
        this.f42668c.c(true);
        this.f42670e.m(inputListener);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() {
        this.f42670e.release();
        this.f42669d.release();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class WrappedShaderProgramInputListener implements GlShaderProgram.InputListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f42673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f42674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private GlShaderProgram.InputListener f42675c;

        private WrappedShaderProgramInputListener() {
        }

        public void a(GlShaderProgram.InputListener inputListener) {
            this.f42675c = inputListener;
        }

        public void c(boolean z2) {
            Assertions.g((z2 && this.f42675c == null) ? false : true);
            this.f42674b = z2;
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void e(GlTextureInfo glTextureInfo) {
            ((GlShaderProgram.InputListener) Assertions.e(this.f42675c)).e(glTextureInfo);
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void f() {
            GlShaderProgram.InputListener inputListener = this.f42675c;
            if (inputListener == null) {
                this.f42673a++;
            }
            if (this.f42674b) {
                ((GlShaderProgram.InputListener) Assertions.e(inputListener)).f();
            }
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void b() {
        }
    }
}
