package androidx.media3.effect;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ExternalTextureManager extends TextureManager {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int[] f42374w = {2, 3, 6, 7, 8, 9, 11, 14};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int[] f42375x = {1920, 1088};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final long f42376y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GlObjectsProvider f42377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExternalShaderProgram f42378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f42379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Surface f42380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SurfaceTexture f42381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f42382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Queue f42383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ScheduledExecutorService f42384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f42385l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f42386m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f42387n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f42388o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private FrameInfo f42389p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private FrameInfo f42390q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f42391r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Future f42392s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CountDownLatch f42393t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile boolean f42394u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile RuntimeException f42395v;

    static {
        f42376y = Util.G0() ? 20000L : 500L;
    }

    public ExternalTextureManager(GlObjectsProvider glObjectsProvider, final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, boolean z2, boolean z3) throws VideoFrameProcessingException {
        super(videoFrameProcessingTaskExecutor);
        this.f42377d = glObjectsProvider;
        this.f42391r = z2;
        this.f42385l = z3;
        try {
            int iN = GlUtil.n();
            this.f42379f = iN;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iN);
            this.f42381h = surfaceTexture;
            this.f42382i = new float[16];
            this.f42383j = new ConcurrentLinkedQueue();
            this.f42384k = Util.R0("ExtTexMgr:Timer");
            surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: androidx.media3.effect.t0
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    ExternalTextureManager.u(this.f42793a, videoFrameProcessingTaskExecutor, surfaceTexture2);
                }
            });
            this.f42380g = new Surface(surfaceTexture);
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    public static /* synthetic */ void A(ExternalTextureManager externalTextureManager) {
        externalTextureManager.getClass();
        DebugTraceUtil.e("VideoFrameProcessor", "SurfaceTextureInput", -9223372036854775807L);
        if (externalTextureManager.f42391r) {
            externalTextureManager.f42383j.add((FrameInfo) Assertions.e(externalTextureManager.f42390q));
        }
        if (!externalTextureManager.f42394u) {
            if (externalTextureManager.f42388o) {
                externalTextureManager.H();
            }
            externalTextureManager.f42387n++;
            externalTextureManager.E();
            return;
        }
        externalTextureManager.f42381h.updateTexImage();
        externalTextureManager.f42383j.poll();
        if (externalTextureManager.f42393t == null || !externalTextureManager.f42383j.isEmpty()) {
            return;
        }
        externalTextureManager.f42393t.countDown();
    }

    private void B() {
        Future future = this.f42392s;
        if (future != null) {
            future.cancel(false);
        }
        this.f42392s = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.f42387n == this.f42383j.size()) {
            return;
        }
        Log.i("ExtTexMgr", Util.J("Forcing EOS after missing %d frames for %d ms, with available frame count: %d", Integer.valueOf(this.f42383j.size()), Long.valueOf(f42376y), Integer.valueOf(this.f42387n)));
        this.f42388o = false;
        this.f42389p = null;
        this.f42394u = true;
        F();
        this.f42383j.clear();
        q();
    }

    private static float D(float f3, int i3) {
        int i4 = i3;
        for (int i5 = 2; i5 <= 256; i5 *= 2) {
            int i6 = (((i3 + i5) - 1) / i5) * i5;
            if (I(i6, f3, i3) < I(i4, f3, i3)) {
                i4 = i6;
            }
        }
        for (int i7 : f42375x) {
            if (i7 >= i3 && I(i7, f3, i3) < I(i4, f3, i3)) {
                i4 = i7;
            }
        }
        return I(i4, f3, i3) > 1.0E-9f ? f3 : i3 / i4;
    }

    private void E() {
        if (this.f42386m == 0 || this.f42387n == 0 || this.f42389p != null) {
            return;
        }
        this.f42381h.updateTexImage();
        this.f42387n--;
        FrameInfo frameInfo = (FrameInfo) this.f42383j.element();
        this.f42389p = frameInfo;
        this.f42386m--;
        this.f42381h.getTransformMatrix(this.f42382i);
        long timestamp = (this.f42381h.getTimestamp() / 1000) + frameInfo.f40688b;
        if (this.f42385l) {
            float[] fArr = this.f42382i;
            Format format = frameInfo.f40687a;
            G(fArr, timestamp, format.f40639v, format.f40640w);
        }
        ((ExternalShaderProgram) Assertions.e(this.f42378e)).i(this.f42382i);
        ExternalShaderProgram externalShaderProgram = (ExternalShaderProgram) Assertions.e(this.f42378e);
        GlObjectsProvider glObjectsProvider = this.f42377d;
        int i3 = this.f42379f;
        Format format2 = frameInfo.f40687a;
        externalShaderProgram.d(glObjectsProvider, new GlTextureInfo(i3, -1, -1, format2.f40639v, format2.f40640w), timestamp);
        Assertions.i((FrameInfo) this.f42383j.remove());
        DebugTraceUtil.e("VideoFrameProcessor", "QueueFrame", timestamp);
    }

    private void F() {
        while (true) {
            int i3 = this.f42387n;
            if (i3 <= 0) {
                break;
            }
            this.f42387n = i3 - 1;
            this.f42381h.updateTexImage();
            this.f42383j.remove();
        }
        if (this.f42393t == null || !this.f42383j.isEmpty()) {
            return;
        }
        this.f42393t.countDown();
    }

    private static void G(float[] fArr, long j3, int i3, int i4) {
        byte b3;
        byte b4;
        boolean z2 = fArr.length != 16;
        for (int i5 : f42374w) {
            z2 |= Math.abs(fArr[i5]) > 1.0E-9f;
        }
        boolean z3 = z2 | (Math.abs(fArr[10] - 1.0f) > 1.0E-9f) | (Math.abs(fArr[15] - 1.0f) > 1.0E-9f);
        float fAbs = Math.abs(fArr[0]);
        byte b5 = Ascii.FF;
        byte b6 = 4;
        if (fAbs > 1.0E-9f && Math.abs(fArr[5]) > 1.0E-9f) {
            z = (Math.abs(fArr[4]) > 1.0E-9f) | z3 | (Math.abs(fArr[1]) > 1.0E-9f);
            b4 = 13;
            b6 = 5;
            b3 = 0;
        } else if (Math.abs(fArr[1]) <= 1.0E-9f || Math.abs(fArr[4]) <= 1.0E-9f) {
            b3 = -1;
            b4 = -1;
            b5 = -1;
            b6 = -1;
        } else {
            z = z3 | (Math.abs(fArr[0]) > 1.0E-9f) | (Math.abs(fArr[5]) > 1.0E-9f);
            b4 = 12;
            b5 = 13;
            b3 = 1;
        }
        if (z) {
            DebugTraceUtil.f("ExternalTextureManager", "SurfaceTextureTransformFix", j3, "Unable to apply SurfaceTexture fix", new Object[0]);
            return;
        }
        float f3 = fArr[b3];
        float f4 = fArr[b5];
        if (Math.abs(f3) + 1.0E-9f < 1.0f) {
            float fCopySign = Math.copySign(D(Math.abs(f3), i3), f3);
            DebugTraceUtil.f("ExternalTextureManager", "SurfaceTextureTransformFix", j3, "Width scale adjusted.", new Object[0]);
            fArr[b3] = fCopySign;
            fArr[b5] = ((f3 - fCopySign) * 0.5f) + f4;
        }
        float f5 = fArr[b6];
        float f6 = fArr[b4];
        if (Math.abs(f5) + 1.0E-9f < 1.0f) {
            float fCopySign2 = Math.copySign(D(Math.abs(f5), i4), f5);
            DebugTraceUtil.f("ExternalTextureManager", "SurfaceTextureTransformFix", j3, "Height scale adjusted.", new Object[0]);
            fArr[b6] = fCopySign2;
            fArr[b4] = ((f5 - fCopySign2) * 0.5f) + f6;
        }
    }

    private void H() {
        B();
        this.f42392s = this.f42384k.schedule(new Runnable() { // from class: androidx.media3.effect.q0
            @Override // java.lang.Runnable
            public final void run() {
                ExternalTextureManager externalTextureManager = this.f42780a;
                externalTextureManager.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.v0
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        externalTextureManager.C();
                    }
                });
            }
        }, f42376y, TimeUnit.MILLISECONDS);
    }

    private static float I(int i3, float f3, int i4) {
        float fAbs = 1.0f;
        for (int i5 = 0; i5 <= 2; i5++) {
            float f4 = ((i4 - i5) / i3) - f3;
            if (Math.abs(f4) < fAbs) {
                fAbs = Math.abs(f4);
            }
        }
        return fAbs;
    }

    public static /* synthetic */ void r(ExternalTextureManager externalTextureManager) {
        externalTextureManager.f42389p = null;
        if (!externalTextureManager.f42388o || !externalTextureManager.f42383j.isEmpty()) {
            externalTextureManager.E();
            return;
        }
        externalTextureManager.f42388o = false;
        ((ExternalShaderProgram) Assertions.e(externalTextureManager.f42378e)).c();
        DebugTraceUtil.e("ExternalTextureManager", "SignalEOS", Long.MIN_VALUE);
        externalTextureManager.B();
    }

    public static /* synthetic */ void t(ExternalTextureManager externalTextureManager) {
        if (externalTextureManager.f42391r) {
            externalTextureManager.f42394u = true;
        }
        if (!externalTextureManager.f42383j.isEmpty() || externalTextureManager.f42389p != null) {
            externalTextureManager.f42388o = true;
            externalTextureManager.H();
        } else {
            ((ExternalShaderProgram) Assertions.e(externalTextureManager.f42378e)).c();
            DebugTraceUtil.e("ExternalTextureManager", "SignalEOS", Long.MIN_VALUE);
            externalTextureManager.B();
        }
    }

    public static /* synthetic */ void u(final ExternalTextureManager externalTextureManager, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, SurfaceTexture surfaceTexture) {
        externalTextureManager.getClass();
        videoFrameProcessingTaskExecutor.k(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.w0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                ExternalTextureManager.A(this.f42807a);
            }
        }, false);
    }

    public static /* synthetic */ void v(ExternalTextureManager externalTextureManager) {
        externalTextureManager.f42386m++;
        externalTextureManager.E();
    }

    public static /* synthetic */ void w(ExternalTextureManager externalTextureManager, GlShaderProgram glShaderProgram) {
        externalTextureManager.f42386m = 0;
        externalTextureManager.f42378e = (ExternalShaderProgram) glShaderProgram;
    }

    public static /* synthetic */ void y(ExternalTextureManager externalTextureManager) {
        externalTextureManager.getClass();
        try {
            externalTextureManager.F();
        } catch (RuntimeException e3) {
            externalTextureManager.f42395v = e3;
            Log.e("ExtTexMgr", "Failed to remove texture frames", e3);
            if (externalTextureManager.f42393t != null) {
                externalTextureManager.f42393t.countDown();
            }
        }
    }

    @Override // androidx.media3.effect.TextureManager
    public void a() {
        this.f42394u = true;
    }

    @Override // androidx.media3.effect.TextureManager
    protected void c() {
        this.f42386m = 0;
        this.f42389p = null;
        this.f42383j.clear();
        this.f42390q = null;
        super.c();
    }

    @Override // androidx.media3.effect.TextureManager
    public Surface d() {
        return this.f42380g;
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void e(GlTextureInfo glTextureInfo) {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.u0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                ExternalTextureManager.r(this.f42798a);
            }
        });
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void f() {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.r0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                ExternalTextureManager.v(this.f42784a);
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public int g() {
        return this.f42383j.size();
    }

    @Override // androidx.media3.effect.TextureManager
    public void j(FrameInfo frameInfo) {
        this.f42390q = frameInfo;
        if (!this.f42391r) {
            this.f42383j.add(frameInfo);
        }
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.o0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                this.f42769a.f42394u = false;
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void k() {
        this.f42381h.release();
        this.f42380g.release();
        this.f42384k.shutdownNow();
    }

    @Override // androidx.media3.effect.TextureManager
    public void l() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f42393t = countDownLatch;
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.p0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                ExternalTextureManager.y(this.f42777a);
            }
        });
        try {
            if (!countDownLatch.await(f42376y, TimeUnit.MILLISECONDS)) {
                Log.i("ExtTexMgr", "Timeout reached while waiting for latch to be unblocked.");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            Log.i("ExtTexMgr", "Interrupted when waiting for MediaCodec frames to arrive.");
        }
        this.f42393t = null;
        if (this.f42395v != null) {
            throw this.f42395v;
        }
    }

    @Override // androidx.media3.effect.TextureManager
    public void m(FrameInfo frameInfo, boolean z2) {
        this.f42391r = z2;
        if (z2) {
            this.f42390q = frameInfo;
            SurfaceTexture surfaceTexture = this.f42381h;
            Format format = frameInfo.f40687a;
            surfaceTexture.setDefaultBufferSize(format.f40639v, format.f40640w);
        }
    }

    @Override // androidx.media3.effect.TextureManager
    public void p(final GlShaderProgram glShaderProgram) {
        Assertions.g(glShaderProgram instanceof ExternalShaderProgram);
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.s0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                ExternalTextureManager.w(this.f42788a, glShaderProgram);
            }
        });
    }

    @Override // androidx.media3.effect.TextureManager
    public void q() {
        this.f42637a.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.n0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                ExternalTextureManager.t(this.f42764a);
            }
        });
    }
}
