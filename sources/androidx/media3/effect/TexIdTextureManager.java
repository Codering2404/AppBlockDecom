package androidx.media3.effect;

import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TexIdTextureManager extends TextureManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameConsumptionManager f42628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OnInputFrameProcessedListener f42629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FrameInfo f42630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GlObjectsProvider f42631g;

    public TexIdTextureManager(GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        super(videoFrameProcessingTaskExecutor);
        this.f42631g = glObjectsProvider;
    }

    public static /* synthetic */ void s(TexIdTextureManager texIdTextureManager) {
        ((FrameConsumptionManager) Assertions.e(texIdTextureManager.f42628d)).h();
        DebugTraceUtil.e("TexIdTextureManager", "SignalEOS", Long.MIN_VALUE);
    }

    public static /* synthetic */ void t(TexIdTextureManager texIdTextureManager, int i3, FrameInfo frameInfo, long j3) {
        texIdTextureManager.getClass();
        Format format = frameInfo.f40687a;
        ((FrameConsumptionManager) Assertions.e(texIdTextureManager.f42628d)).g(new GlTextureInfo(i3, -1, -1, format.f40639v, format.f40640w), j3);
        DebugTraceUtil.f("VideoFrameProcessor", "QueueTexture", j3, "%dx%d", Integer.valueOf(frameInfo.f40687a.f40639v), Integer.valueOf(frameInfo.f40687a.f40640w));
    }

    @Override // androidx.media3.effect.TextureManager
    protected synchronized void c() {
        ((FrameConsumptionManager) Assertions.e(this.f42628d)).b();
        super.c();
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void e(final GlTextureInfo glTextureInfo) {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.l2
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                ((OnInputFrameProcessedListener) Assertions.e(this.f42749a.f42629e)).a(glTextureInfo.f40690a, GlUtil.q());
            }
        });
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void f() {
        Assertions.e(this.f42628d);
        VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.f42637a;
        final FrameConsumptionManager frameConsumptionManager = this.f42628d;
        Objects.requireNonNull(frameConsumptionManager);
        videoFrameProcessingTaskExecutor.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.j2
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                frameConsumptionManager.f();
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public int g() {
        return ((FrameConsumptionManager) Assertions.e(this.f42628d)).d();
    }

    @Override // androidx.media3.effect.TextureManager
    public void i(final int i3, final long j3) {
        final FrameInfo frameInfo = (FrameInfo) Assertions.e(this.f42630f);
        Assertions.e(this.f42629e);
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.k2
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                TexIdTextureManager.t(this.f42743a, i3, frameInfo, j3);
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void m(FrameInfo frameInfo, boolean z2) {
        this.f42630f = frameInfo;
    }

    @Override // androidx.media3.effect.TextureManager
    public void o(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        this.f42629e = onInputFrameProcessedListener;
    }

    @Override // androidx.media3.effect.TextureManager
    public void p(GlShaderProgram glShaderProgram) {
        this.f42628d = new FrameConsumptionManager(this.f42631g, glShaderProgram, this.f42637a);
    }

    @Override // androidx.media3.effect.TextureManager
    public void q() {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.i2
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                TexIdTextureManager.s(this.f42734a);
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void k() {
    }
}
