package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ChainingGlShaderProgramListener implements GlShaderProgram.InputListener, GlShaderProgram.OutputListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GlShaderProgram f42231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameConsumptionManager f42232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final VideoFrameProcessingTaskExecutor f42233c;

    public ChainingGlShaderProgramListener(GlObjectsProvider glObjectsProvider, GlShaderProgram glShaderProgram, GlShaderProgram glShaderProgram2, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        this.f42231a = glShaderProgram;
        this.f42232b = new FrameConsumptionManager(glObjectsProvider, glShaderProgram2, videoFrameProcessingTaskExecutor);
        this.f42233c = videoFrameProcessingTaskExecutor;
    }

    @Override // androidx.media3.effect.GlShaderProgram.OutputListener
    public synchronized void a(GlTextureInfo glTextureInfo, long j3) {
        this.f42232b.g(glTextureInfo, j3);
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void b() {
        this.f42232b.b();
        VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.f42233c;
        final GlShaderProgram glShaderProgram = this.f42231a;
        Objects.requireNonNull(glShaderProgram);
        videoFrameProcessingTaskExecutor.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.l
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                glShaderProgram.flush();
            }
        });
    }

    @Override // androidx.media3.effect.GlShaderProgram.OutputListener
    public synchronized void c() {
        this.f42232b.h();
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void e(final GlTextureInfo glTextureInfo) {
        this.f42233c.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.m
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                this.f42751a.f42231a.l(glTextureInfo);
            }
        });
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void f() {
        this.f42232b.f();
    }
}
