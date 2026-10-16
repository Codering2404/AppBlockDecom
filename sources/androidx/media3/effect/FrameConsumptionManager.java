package androidx.media3.effect;

import android.util.Pair;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FrameConsumptionManager implements GlShaderProgram.InputListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GlObjectsProvider f42425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GlShaderProgram f42426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final VideoFrameProcessingTaskExecutor f42427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue f42428d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f42429e;

    public FrameConsumptionManager(GlObjectsProvider glObjectsProvider, GlShaderProgram glShaderProgram, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        this.f42425a = glObjectsProvider;
        this.f42426b = glShaderProgram;
        this.f42427c = videoFrameProcessingTaskExecutor;
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void b() {
        this.f42429e = 0;
        this.f42428d.clear();
    }

    public synchronized int d() {
        return this.f42428d.size();
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void f() {
        final Pair pair = (Pair) this.f42428d.poll();
        if (pair == null) {
            this.f42429e++;
            return;
        }
        this.f42427c.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.f1
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                FrameConsumptionManager frameConsumptionManager = this.f42713a;
                Pair pair2 = pair;
                frameConsumptionManager.f42426b.d(frameConsumptionManager.f42425a, (GlTextureInfo) pair2.first, ((Long) pair2.second).longValue());
            }
        });
        Pair pair2 = (Pair) this.f42428d.peek();
        if (pair2 != null && ((Long) pair2.second).longValue() == Long.MIN_VALUE) {
            VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.f42427c;
            GlShaderProgram glShaderProgram = this.f42426b;
            Objects.requireNonNull(glShaderProgram);
            videoFrameProcessingTaskExecutor.j(new e1(glShaderProgram));
            this.f42428d.remove();
        }
    }

    public synchronized void g(final GlTextureInfo glTextureInfo, final long j3) {
        try {
            if (this.f42429e > 0) {
                this.f42427c.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.g1
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        FrameConsumptionManager frameConsumptionManager = this.f42719a;
                        frameConsumptionManager.f42426b.d(frameConsumptionManager.f42425a, glTextureInfo, j3);
                    }
                });
                this.f42429e--;
            } else {
                this.f42428d.add(Pair.create(glTextureInfo, Long.valueOf(j3)));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void h() {
        try {
            if (this.f42428d.isEmpty()) {
                VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.f42427c;
                GlShaderProgram glShaderProgram = this.f42426b;
                Objects.requireNonNull(glShaderProgram);
                videoFrameProcessingTaskExecutor.j(new e1(glShaderProgram));
            } else {
                this.f42428d.add(Pair.create(GlTextureInfo.f40689f, Long.MIN_VALUE));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
