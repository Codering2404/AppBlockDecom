package androidx.media3.effect;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
abstract class TextureManager implements GlShaderProgram.InputListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final VideoFrameProcessingTaskExecutor f42637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f42638b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VideoFrameProcessingTaskExecutor.Task f42639c;

    public TextureManager(VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        this.f42637a = videoFrameProcessingTaskExecutor;
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public final void b() {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.m2
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                this.f42763a.c();
            }
        });
    }

    protected void c() {
        synchronized (this.f42638b) {
            try {
                VideoFrameProcessingTaskExecutor.Task task = this.f42639c;
                if (task != null) {
                    this.f42637a.l(task);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Surface d() {
        throw new UnsupportedOperationException();
    }

    public abstract int g();

    public void h(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) {
        throw new UnsupportedOperationException();
    }

    public void i(int i3, long j3) {
        throw new UnsupportedOperationException();
    }

    public void j(FrameInfo frameInfo) {
        throw new UnsupportedOperationException();
    }

    public abstract void k();

    public final void n(VideoFrameProcessingTaskExecutor.Task task) {
        synchronized (this.f42638b) {
            this.f42639c = task;
        }
    }

    public void o(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        throw new UnsupportedOperationException();
    }

    public abstract void p(GlShaderProgram glShaderProgram);

    public abstract void q();

    public void a() {
    }

    public void l() {
    }

    public void m(FrameInfo frameInfo, boolean z2) {
    }
}
