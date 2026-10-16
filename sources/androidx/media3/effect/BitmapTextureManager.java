package androidx.media3.effect;

import android.graphics.Bitmap;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.Util;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class BitmapTextureManager extends TextureManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue f42195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final GlObjectsProvider f42196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f42197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RepeatingGainmapShaderProgram f42198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GlTextureInfo f42199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f42200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f42201j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f42202k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BitmapFrameSequenceInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f42203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FrameInfo f42204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimestampIterator f42205c;

        public BitmapFrameSequenceInfo(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) {
            this.f42203a = bitmap;
            this.f42204b = frameInfo;
            this.f42205c = timestampIterator;
        }
    }

    public BitmapTextureManager(GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, boolean z2) {
        super(videoFrameProcessingTaskExecutor);
        this.f42196e = glObjectsProvider;
        this.f42195d = new LinkedBlockingQueue();
        this.f42197f = z2;
    }

    public static /* synthetic */ void r(BitmapTextureManager bitmapTextureManager) throws GlUtil.GlException {
        GlTextureInfo glTextureInfo = bitmapTextureManager.f42199h;
        if (glTextureInfo != null) {
            glTextureInfo.a();
        }
        bitmapTextureManager.f42195d.clear();
    }

    public static /* synthetic */ void s(BitmapTextureManager bitmapTextureManager) throws VideoFrameProcessingException {
        bitmapTextureManager.f42200i++;
        bitmapTextureManager.v();
    }

    public static /* synthetic */ void t(BitmapTextureManager bitmapTextureManager, Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) throws VideoFrameProcessingException {
        bitmapTextureManager.w(bitmap, frameInfo, timestampIterator);
        bitmapTextureManager.f42201j = false;
    }

    public static /* synthetic */ void u(BitmapTextureManager bitmapTextureManager) {
        if (!bitmapTextureManager.f42195d.isEmpty()) {
            bitmapTextureManager.f42201j = true;
        } else {
            ((RepeatingGainmapShaderProgram) Assertions.e(bitmapTextureManager.f42198g)).c();
            DebugTraceUtil.e("BitmapTextureManager", "SignalEOS", Long.MIN_VALUE);
        }
    }

    private void v() throws VideoFrameProcessingException {
        if (this.f42195d.isEmpty() || this.f42200i == 0) {
            return;
        }
        BitmapFrameSequenceInfo bitmapFrameSequenceInfo = (BitmapFrameSequenceInfo) this.f42195d.element();
        FrameInfo frameInfo = bitmapFrameSequenceInfo.f42204b;
        TimestampIterator timestampIterator = bitmapFrameSequenceInfo.f42205c;
        Assertions.g(bitmapFrameSequenceInfo.f42205c.hasNext());
        long next = bitmapFrameSequenceInfo.f42204b.f40688b + timestampIterator.next();
        if (!this.f42202k) {
            this.f42202k = true;
            x(frameInfo, bitmapFrameSequenceInfo.f42203a);
        }
        this.f42200i--;
        ((RepeatingGainmapShaderProgram) Assertions.e(this.f42198g)).d(this.f42196e, (GlTextureInfo) Assertions.e(this.f42199h), next);
        DebugTraceUtil.f("VideoFrameProcessor", "QueueBitmap", next, "%dx%d", Integer.valueOf(frameInfo.f40687a.f40639v), Integer.valueOf(frameInfo.f40687a.f40640w));
        if (bitmapFrameSequenceInfo.f42205c.hasNext()) {
            return;
        }
        this.f42202k = false;
        ((BitmapFrameSequenceInfo) this.f42195d.remove()).f42203a.recycle();
        if (this.f42195d.isEmpty() && this.f42201j) {
            ((RepeatingGainmapShaderProgram) Assertions.e(this.f42198g)).c();
            DebugTraceUtil.e("BitmapTextureManager", "SignalEOS", Long.MIN_VALUE);
            this.f42201j = false;
        }
    }

    private void w(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) throws VideoFrameProcessingException {
        Assertions.b(timestampIterator.hasNext(), "Bitmap queued but no timestamps provided.");
        this.f42195d.add(new BitmapFrameSequenceInfo(bitmap, frameInfo, timestampIterator));
        v();
    }

    private void x(FrameInfo frameInfo, Bitmap bitmap) throws VideoFrameProcessingException {
        try {
            GlTextureInfo glTextureInfo = this.f42199h;
            if (glTextureInfo != null) {
                glTextureInfo.a();
            }
            int iV = GlUtil.v(bitmap);
            Format format = frameInfo.f40687a;
            this.f42199h = new GlTextureInfo(iV, -1, -1, format.f40639v, format.f40640w);
            if (Util.f41609a >= 34 && bitmap.hasGainmap()) {
                ((RepeatingGainmapShaderProgram) Assertions.e(this.f42198g)).h(f.a(Assertions.e(bitmap.getGainmap())));
            }
            if (this.f42197f) {
                ((RepeatingGainmapShaderProgram) Assertions.e(this.f42198g)).a();
            }
        } catch (GlUtil.GlException e3) {
            throw VideoFrameProcessingException.a(e3);
        }
    }

    @Override // androidx.media3.effect.TextureManager
    protected void c() throws VideoFrameProcessingException {
        this.f42195d.clear();
        this.f42202k = false;
        this.f42201j = false;
        this.f42200i = 0;
        GlTextureInfo glTextureInfo = this.f42199h;
        if (glTextureInfo != null) {
            try {
                glTextureInfo.a();
                this.f42199h = null;
            } catch (GlUtil.GlException e3) {
                throw VideoFrameProcessingException.a(e3);
            }
        }
        super.c();
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void f() {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.i
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException {
                BitmapTextureManager.s(this.f42732a);
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public int g() {
        return 0;
    }

    @Override // androidx.media3.effect.TextureManager
    public void h(final Bitmap bitmap, final FrameInfo frameInfo, final TimestampIterator timestampIterator) {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.h
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException {
                BitmapTextureManager.t(this.f42725a, bitmap, frameInfo, timestampIterator);
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void k() {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.j
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws GlUtil.GlException {
                BitmapTextureManager.r(this.f42735a);
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void p(GlShaderProgram glShaderProgram) {
        Assertions.g(glShaderProgram instanceof RepeatingGainmapShaderProgram);
        this.f42200i = 0;
        this.f42198g = (RepeatingGainmapShaderProgram) glShaderProgram;
    }

    @Override // androidx.media3.effect.TextureManager
    public void q() {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.g
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                BitmapTextureManager.u(this.f42717a);
            }
        });
    }
}
