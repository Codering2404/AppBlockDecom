package androidx.media3.effect;

import android.content.Context;
import android.util.SparseArray;
import android.view.Surface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.effect.GlShaderProgram;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class InputSwitcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f42444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorInfo f42445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GlObjectsProvider f42446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VideoFrameProcessingTaskExecutor f42447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final GlShaderProgram.ErrorListener f42448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f42449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SparseArray f42450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f42451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f42452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private GlShaderProgram f42453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextureManager f42454k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class GatedChainingListenerWrapper implements GlShaderProgram.OutputListener, GlShaderProgram.InputListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ChainingGlShaderProgramListener f42455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f42456b;

        public GatedChainingListenerWrapper(GlObjectsProvider glObjectsProvider, GlShaderProgram glShaderProgram, GlShaderProgram glShaderProgram2, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
            this.f42455a = new ChainingGlShaderProgramListener(glObjectsProvider, glShaderProgram, glShaderProgram2, videoFrameProcessingTaskExecutor);
        }

        @Override // androidx.media3.effect.GlShaderProgram.OutputListener
        public synchronized void a(GlTextureInfo glTextureInfo, long j3) {
            if (this.f42456b) {
                this.f42455a.a(glTextureInfo, j3);
            }
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public synchronized void b() {
            if (this.f42456b) {
                this.f42455a.b();
            }
        }

        @Override // androidx.media3.effect.GlShaderProgram.OutputListener
        public synchronized void c() {
            if (this.f42456b) {
                this.f42455a.c();
            }
        }

        public void d(boolean z2) {
            this.f42456b = z2;
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void e(GlTextureInfo glTextureInfo) {
            if (this.f42456b) {
                this.f42455a.e(glTextureInfo);
            }
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void f() {
            if (this.f42456b) {
                this.f42455a.f();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Input {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextureManager f42457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ExternalShaderProgram f42458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ColorInfo f42459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private GatedChainingListenerWrapper f42460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f42461e;

        public Input(TextureManager textureManager) {
            this.f42457a = textureManager;
        }

        public ColorInfo b() {
            return this.f42459c;
        }

        public ExternalShaderProgram c() {
            return this.f42458b;
        }

        public void d() {
            if (this.f42461e) {
                return;
            }
            this.f42461e = true;
            this.f42457a.k();
            ExternalShaderProgram externalShaderProgram = this.f42458b;
            if (externalShaderProgram != null) {
                externalShaderProgram.release();
            }
        }

        public void e(boolean z2) {
            GatedChainingListenerWrapper gatedChainingListenerWrapper = this.f42460d;
            if (gatedChainingListenerWrapper == null) {
                return;
            }
            gatedChainingListenerWrapper.d(z2);
        }

        public void f(GatedChainingListenerWrapper gatedChainingListenerWrapper) {
            this.f42460d = gatedChainingListenerWrapper;
            ((ExternalShaderProgram) Assertions.e(this.f42458b)).k(gatedChainingListenerWrapper);
        }

        public void g(ColorInfo colorInfo) {
            this.f42459c = colorInfo;
        }

        public void h(ExternalShaderProgram externalShaderProgram) {
            ExternalShaderProgram externalShaderProgram2 = this.f42458b;
            if (externalShaderProgram2 != null) {
                externalShaderProgram2.release();
            }
            this.f42458b = externalShaderProgram;
            this.f42457a.p(externalShaderProgram);
            externalShaderProgram.m(this.f42457a);
        }
    }

    public InputSwitcher(Context context, ColorInfo colorInfo, GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, GlShaderProgram.ErrorListener errorListener, int i3, boolean z2, boolean z3, boolean z4) {
        this.f42444a = context;
        this.f42445b = colorInfo;
        this.f42446c = glObjectsProvider;
        this.f42447d = videoFrameProcessingTaskExecutor;
        this.f42449f = executor;
        this.f42448e = errorListener;
        SparseArray sparseArray = new SparseArray();
        this.f42450g = sparseArray;
        this.f42451h = i3;
        this.f42452i = z3;
        Input input = new Input(new ExternalTextureManager(glObjectsProvider, videoFrameProcessingTaskExecutor, z2, z3));
        sparseArray.put(1, input);
        sparseArray.put(4, input);
        sparseArray.put(2, new Input(new BitmapTextureManager(glObjectsProvider, videoFrameProcessingTaskExecutor, z4)));
        sparseArray.put(3, new Input(new TexIdTextureManager(glObjectsProvider, videoFrameProcessingTaskExecutor)));
    }

    private DefaultShaderProgram b(ColorInfo colorInfo, int i3) throws VideoFrameProcessingException {
        DefaultShaderProgram defaultShaderProgramW;
        if (i3 == 1) {
            defaultShaderProgramW = DefaultShaderProgram.w(this.f42444a, colorInfo, this.f42445b, this.f42451h, this.f42452i);
        } else if (i3 == 2 || i3 == 3) {
            defaultShaderProgramW = DefaultShaderProgram.x(this.f42444a, colorInfo, this.f42445b, this.f42451h, i3);
        } else {
            if (i3 != 4) {
                throw new VideoFrameProcessingException("Unsupported input type " + i3);
            }
            defaultShaderProgramW = DefaultShaderProgram.w(this.f42444a, colorInfo, this.f42445b, this.f42451h, this.f42452i);
        }
        defaultShaderProgramW.g(this.f42449f, this.f42448e);
        return defaultShaderProgramW;
    }

    public TextureManager a() {
        return (TextureManager) Assertions.i(this.f42454k);
    }

    public Surface c() {
        Assertions.g(Util.t(this.f42450g, 1));
        return ((Input) this.f42450g.get(1)).f42457a.d();
    }

    public boolean d() {
        return this.f42454k != null;
    }

    public void e() {
        for (int i3 = 0; i3 < this.f42450g.size(); i3++) {
            SparseArray sparseArray = this.f42450g;
            ((Input) sparseArray.get(sparseArray.keyAt(i3))).d();
        }
    }

    public void f(GlShaderProgram glShaderProgram) {
        this.f42453j = glShaderProgram;
    }

    public void g(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        Assertions.g(Util.t(this.f42450g, 3));
        ((Input) this.f42450g.get(3)).f42457a.o(onInputFrameProcessedListener);
    }

    public void h() {
        ((TextureManager) Assertions.e(this.f42454k)).q();
    }

    public void i(int i3, FrameInfo frameInfo) {
        Assertions.i(this.f42453j);
        Assertions.h(Util.t(this.f42450g, i3), "Input type not registered: " + i3);
        for (int i4 = 0; i4 < this.f42450g.size(); i4++) {
            SparseArray sparseArray = this.f42450g;
            ((Input) sparseArray.get(sparseArray.keyAt(i4))).e(false);
        }
        Input input = (Input) this.f42450g.get(i3);
        ColorInfo colorInfo = (ColorInfo) Assertions.e(frameInfo.f40687a.C);
        if (input.b() == null || !colorInfo.equals(input.b())) {
            input.h(b(colorInfo, i3));
            input.g(colorInfo);
        }
        input.f(new GatedChainingListenerWrapper(this.f42446c, (GlShaderProgram) Assertions.e(input.c()), this.f42453j, this.f42447d));
        input.e(true);
        this.f42453j.m((GlShaderProgram.InputListener) Assertions.e(input.f42460d));
        TextureManager textureManager = input.f42457a;
        this.f42454k = textureManager;
        ((TextureManager) Assertions.e(textureManager)).m(frameInfo, i3 == 4);
    }
}
