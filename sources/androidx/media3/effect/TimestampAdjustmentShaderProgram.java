package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampConsumer;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.TimestampAdjustment;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TimestampAdjustmentShaderProgram implements GlShaderProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimestampAdjustment.TimestampMap f42655a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GlTextureInfo f42658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GlShaderProgram.InputListener f42659e = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.TimestampAdjustmentShaderProgram.1
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GlShaderProgram.OutputListener f42660f = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.TimestampAdjustmentShaderProgram.2
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f42656b = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f42657c = new AtomicBoolean();

    public TimestampAdjustmentShaderProgram(TimestampAdjustment.TimestampMap timestampMap) {
        this.f42655a = timestampMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j3) {
        this.f42660f.a((GlTextureInfo) Assertions.e(this.f42658d), j3);
        if (this.f42657c.get()) {
            this.f42660f.c();
            this.f42657c.set(false);
        }
        this.f42656b.decrementAndGet();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void c() {
        if (this.f42656b.get() == 0) {
            this.f42660f.c();
        } else {
            this.f42657c.set(true);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3) {
        this.f42658d = glTextureInfo;
        this.f42655a.a(j3, new TimestampConsumer() { // from class: androidx.media3.effect.n2
            @Override // androidx.media3.common.util.TimestampConsumer
            public final void a(long j4) {
                this.f42765a.e(j4);
            }
        });
        this.f42656b.incrementAndGet();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        throw new UnsupportedOperationException("This effect is not supported for previewing.");
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void k(GlShaderProgram.OutputListener outputListener) {
        this.f42660f = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void l(GlTextureInfo glTextureInfo) {
        Assertions.g(glTextureInfo.f40690a == ((GlTextureInfo) Assertions.e(this.f42658d)).f40690a);
        this.f42659e.e(glTextureInfo);
        this.f42659e.f();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void m(GlShaderProgram.InputListener inputListener) {
        this.f42659e = inputListener;
        if (this.f42658d == null) {
            inputListener.f();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() {
        this.f42658d = null;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void g(Executor executor, GlShaderProgram.ErrorListener errorListener) {
    }
}
