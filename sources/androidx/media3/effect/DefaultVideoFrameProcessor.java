package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Pair;
import android.view.Surface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DefaultVideoFrameProcessor;
import androidx.media3.effect.FinalShaderProgramWrapper;
import androidx.media3.effect.GlTextureProducer;
import androidx.media3.effect.VideoFrameProcessingTaskExecutor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultVideoFrameProcessor implements VideoFrameProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f42328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GlObjectsProvider f42329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f42330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EGLDisplay f42331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final InputSwitcher f42332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final VideoFrameProcessingTaskExecutor f42333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final VideoFrameProcessor.Listener f42334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Executor f42335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f42336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final FinalShaderProgramWrapper f42337j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ConditionVariable f42339l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private InputStreamInfo f42340m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private InputStreamInfo f42341n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f42342o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Runnable f42343p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ColorInfo f42346s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final DebugViewProvider f42347t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile FrameInfo f42348u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile boolean f42349v;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final List f42344q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f42345r = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f42338k = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements VideoFrameProcessor.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f42350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f42351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final GlObjectsProvider f42352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ExecutorService f42353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final GlTextureProducer.Listener f42354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f42355f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f42356g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f42357h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f42358a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private ExecutorService f42359b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private GlObjectsProvider f42360c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private GlTextureProducer.Listener f42361d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f42362e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f42363f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private boolean f42364g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private boolean f42365h;

            public Builder a(ExecutorService executorService) {
                this.f42359b = executorService;
                return this;
            }

            public Builder b(GlObjectsProvider glObjectsProvider) {
                this.f42360c = glObjectsProvider;
                return this;
            }

            public Factory build() {
                return new Factory(this.f42358a, !this.f42363f, this.f42360c, this.f42359b, this.f42361d, this.f42362e, this.f42364g, this.f42365h);
            }

            public Builder c(GlTextureProducer.Listener listener, int i3) {
                this.f42361d = listener;
                Assertions.a(i3 >= 1);
                this.f42362e = i3;
                return this;
            }

            public Builder() {
                this.f42358a = 0;
                this.f42363f = true;
                this.f42364g = true;
                this.f42365h = true;
            }

            private Builder(Factory factory) {
                this.f42358a = factory.f42350a;
                this.f42359b = factory.f42353d;
                this.f42360c = factory.f42352c;
                this.f42361d = factory.f42354e;
                this.f42362e = factory.f42355f;
                this.f42363f = !factory.f42351b;
                this.f42364g = factory.f42356g;
                this.f42365h = factory.f42357h;
            }
        }

        public Builder k() {
            return new Builder();
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Factory
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public DefaultVideoFrameProcessor a(final Context context, final DebugViewProvider debugViewProvider, final ColorInfo colorInfo, final boolean z2, final Executor executor, final VideoFrameProcessor.Listener listener) throws VideoFrameProcessingException {
            ExecutorService executorServiceQ0 = this.f42353d;
            if (executorServiceQ0 == null) {
                executorServiceQ0 = Util.Q0("Effect:DefaultVideoFrameProcessor:GlThread");
            }
            ExecutorService executorService = executorServiceQ0;
            boolean z3 = this.f42353d == null;
            Objects.requireNonNull(listener);
            final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = new VideoFrameProcessingTaskExecutor(executorService, z3, new VideoFrameProcessingTaskExecutor.ErrorListener() { // from class: androidx.media3.effect.l0
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.ErrorListener
                public final void a(VideoFrameProcessingException videoFrameProcessingException) {
                    listener.a(videoFrameProcessingException);
                }
            });
            GlObjectsProvider defaultGlObjectsProvider = this.f42352c;
            final boolean z4 = defaultGlObjectsProvider == null || this.f42353d == null;
            if (defaultGlObjectsProvider == null) {
                defaultGlObjectsProvider = new DefaultGlObjectsProvider();
            }
            final GlObjectsProvider glObjectsProvider = defaultGlObjectsProvider;
            try {
                return (DefaultVideoFrameProcessor) executorService.submit(new Callable() { // from class: androidx.media3.effect.m0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        DefaultVideoFrameProcessor.Factory factory = this.f42753a;
                        return DefaultVideoFrameProcessor.B(context, debugViewProvider, colorInfo, factory.f42350a, z2, videoFrameProcessingTaskExecutor, executor, listener, glObjectsProvider, z4, factory.f42354e, factory.f42355f, factory.f42351b, factory.f42356g, factory.f42357h);
                    }
                }).get();
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                throw new VideoFrameProcessingException(e3);
            } catch (ExecutionException e4) {
                throw new VideoFrameProcessingException(e4);
            }
        }

        private Factory(int i3, boolean z2, GlObjectsProvider glObjectsProvider, ExecutorService executorService, GlTextureProducer.Listener listener, int i4, boolean z3, boolean z4) {
            this.f42350a = i3;
            this.f42351b = z2;
            this.f42352c = glObjectsProvider;
            this.f42353d = executorService;
            this.f42354e = listener;
            this.f42355f = i4;
            this.f42356g = z3;
            this.f42357h = z4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InputStreamInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Format f42367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f42368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f42369d;

        public InputStreamInfo(int i3, Format format, List list, long j3) {
            this.f42366a = i3;
            this.f42367b = format;
            this.f42368c = list;
            this.f42369d = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ReleaseOutputTextureCallback {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface WorkingColorSpace {
    }

    static {
        MediaLibraryInfo.a("media3.effect");
    }

    private DefaultVideoFrameProcessor(Context context, GlObjectsProvider glObjectsProvider, boolean z2, EGLDisplay eGLDisplay, InputSwitcher inputSwitcher, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, final VideoFrameProcessor.Listener listener, final Executor executor, FinalShaderProgramWrapper finalShaderProgramWrapper, boolean z3, ColorInfo colorInfo, DebugViewProvider debugViewProvider) {
        this.f42328a = context;
        this.f42329b = glObjectsProvider;
        this.f42330c = z2;
        this.f42331d = eGLDisplay;
        this.f42332e = inputSwitcher;
        this.f42333f = videoFrameProcessingTaskExecutor;
        this.f42334g = listener;
        this.f42335h = executor;
        this.f42336i = z3;
        this.f42346s = colorInfo;
        this.f42347t = debugViewProvider;
        this.f42337j = finalShaderProgramWrapper;
        ConditionVariable conditionVariable = new ConditionVariable();
        this.f42339l = conditionVariable;
        conditionVariable.f();
        finalShaderProgramWrapper.E(new FinalShaderProgramWrapper.OnInputStreamProcessedListener() { // from class: androidx.media3.effect.a0
            @Override // androidx.media3.effect.FinalShaderProgramWrapper.OnInputStreamProcessedListener
            public final void a() {
                DefaultVideoFrameProcessor.q(this.f42685a, executor, listener);
            }
        });
    }

    private static ImmutableList A(Context context, List list, ColorInfo colorInfo, FinalShaderProgramWrapper finalShaderProgramWrapper) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        ImmutableList.Builder builder3 = new ImmutableList.Builder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Effect effect = (Effect) list.get(i3);
            Assertions.b(effect instanceof GlEffect, "DefaultVideoFrameProcessor only supports GlEffects");
            GlEffect glEffect = (GlEffect) effect;
            if (glEffect instanceof GlMatrixTransformation) {
                builder2.a((GlMatrixTransformation) glEffect);
            } else if (glEffect instanceof RgbMatrix) {
                builder3.a((RgbMatrix) glEffect);
            } else {
                boolean zL = ColorInfo.l(colorInfo);
                ImmutableList immutableListM = builder2.m();
                ImmutableList immutableListM2 = builder3.m();
                if (!immutableListM.isEmpty() || !immutableListM2.isEmpty()) {
                    builder.a(DefaultShaderProgram.t(context, immutableListM, immutableListM2, zL));
                    builder2 = new ImmutableList.Builder();
                    builder3 = new ImmutableList.Builder();
                }
                builder.a(glEffect.a(context, zL));
            }
        }
        finalShaderProgramWrapper.D(builder2.m(), builder3.m());
        return builder.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DefaultVideoFrameProcessor B(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, int i3, boolean z2, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, VideoFrameProcessor.Listener listener, GlObjectsProvider glObjectsProvider, boolean z3, GlTextureProducer.Listener listener2, int i4, boolean z4, boolean z5, boolean z6) throws GlUtil.GlException {
        int i5;
        ColorInfo colorInfo2;
        EGLDisplay eGLDisplayM = GlUtil.M();
        Pair pairZ = z(glObjectsProvider, eGLDisplayM, ColorInfo.l(colorInfo) ? GlUtil.f41536b : GlUtil.f41535a);
        ColorInfo colorInfoA = colorInfo.a().e(1).f(null).a();
        if (!ColorInfo.l(colorInfo)) {
            i5 = i3;
            if (i5 != 2) {
                colorInfo2 = colorInfo;
            }
            Objects.requireNonNull(listener);
            return new DefaultVideoFrameProcessor(context, glObjectsProvider, z3, eGLDisplayM, new InputSwitcher(context, colorInfo2, glObjectsProvider, videoFrameProcessingTaskExecutor, executor, new i0(listener), i5, z4, z5, z6), videoFrameProcessingTaskExecutor, listener, executor, new FinalShaderProgramWrapper(context, eGLDisplayM, (EGLContext) pairZ.first, (EGLSurface) pairZ.second, colorInfo, videoFrameProcessingTaskExecutor, executor, listener, listener2, i4, i3, z2), z2, colorInfo, debugViewProvider);
        }
        i5 = i3;
        colorInfo2 = colorInfoA;
        Objects.requireNonNull(listener);
        return new DefaultVideoFrameProcessor(context, glObjectsProvider, z3, eGLDisplayM, new InputSwitcher(context, colorInfo2, glObjectsProvider, videoFrameProcessingTaskExecutor, executor, new i0(listener), i5, z4, z5, z6), videoFrameProcessingTaskExecutor, listener, executor, new FinalShaderProgramWrapper(context, eGLDisplayM, (EGLContext) pairZ.first, (EGLSurface) pairZ.second, colorInfo, videoFrameProcessingTaskExecutor, executor, listener, listener2, i4, i3, z2), z2, colorInfo, debugViewProvider);
    }

    private static String C(int i3) {
        if (i3 == 1) {
            return "Surface";
        }
        if (i3 == 2) {
            return "Bitmap";
        }
        if (i3 == 3) {
            return "Texture ID";
        }
        if (i3 == 4) {
            return "Surface with automatic frame registration";
        }
        throw new IllegalArgumentException(String.valueOf(i3));
    }

    private static boolean D(ColorInfo colorInfo, ColorInfo colorInfo2) {
        if (colorInfo.f40554a != 6 || colorInfo2.f40554a == 6 || !ColorInfo.l(colorInfo)) {
            return false;
        }
        int i3 = colorInfo2.f40556c;
        return i3 == 10 || i3 == 3;
    }

    private static boolean E(ColorInfo colorInfo, ColorInfo colorInfo2) {
        return colorInfo.equals(ColorInfo.f40547i) && colorInfo2.f40554a == 6 && ColorInfo.l(colorInfo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        try {
            try {
                this.f42332e.e();
                for (int i3 = 0; i3 < this.f42338k.size(); i3++) {
                    ((GlShaderProgram) this.f42338k.get(i3)).release();
                }
                this.f42337j.release();
            } catch (Throwable th) {
                if (this.f42330c) {
                    try {
                        this.f42329b.e(this.f42331d);
                    } catch (GlUtil.GlException e3) {
                        Log.e("DefaultFrameProcessor", "Error releasing GL objects", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            Log.e("DefaultFrameProcessor", "Error releasing shader program", e4);
        }
        if (this.f42330c) {
            try {
                this.f42329b.e(this.f42331d);
            } catch (GlUtil.GlException e5) {
                Log.e("DefaultFrameProcessor", "Error releasing GL objects", e5);
            }
        }
    }

    private void G() {
        synchronized (this.f42345r) {
            try {
                final InputStreamInfo inputStreamInfo = this.f42341n;
                if (inputStreamInfo != null) {
                    this.f42333f.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.h0
                        @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                        public final void run() throws VideoFrameProcessingException {
                            this.f42729a.x(inputStreamInfo, false);
                        }
                    });
                    this.f42341n = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void q(DefaultVideoFrameProcessor defaultVideoFrameProcessor, Executor executor, final VideoFrameProcessor.Listener listener) {
        if (!defaultVideoFrameProcessor.f42349v) {
            defaultVideoFrameProcessor.G();
            return;
        }
        Objects.requireNonNull(listener);
        executor.execute(new Runnable() { // from class: androidx.media3.effect.b0
            @Override // java.lang.Runnable
            public final void run() {
                listener.b();
            }
        });
        DebugTraceUtil.e("VideoFrameProcessor", "SignalEnded", Long.MIN_VALUE);
    }

    private Format u(Format format) {
        float f3 = format.f40643z;
        return f3 > 1.0f ? format.b().B0((int) (format.f40639v * format.f40643z)).q0(1.0f).N() : f3 < 1.0f ? format.b().d0((int) (format.f40640w / format.f40643z)).q0(1.0f).N() : format;
    }

    private static void v(GlObjectsProvider glObjectsProvider, List list, FinalShaderProgramWrapper finalShaderProgramWrapper, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, VideoFrameProcessor.Listener listener, Executor executor) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(finalShaderProgramWrapper);
        int i3 = 0;
        while (i3 < arrayList.size() - 1) {
            GlShaderProgram glShaderProgram = (GlShaderProgram) arrayList.get(i3);
            i3++;
            GlShaderProgram glShaderProgram2 = (GlShaderProgram) arrayList.get(i3);
            ChainingGlShaderProgramListener chainingGlShaderProgramListener = new ChainingGlShaderProgramListener(glObjectsProvider, glShaderProgram, glShaderProgram2, videoFrameProcessingTaskExecutor);
            glShaderProgram.k(chainingGlShaderProgramListener);
            Objects.requireNonNull(listener);
            glShaderProgram.g(executor, new i0(listener));
            glShaderProgram2.m(chainingGlShaderProgramListener);
        }
    }

    private static void w(ColorInfo colorInfo, ColorInfo colorInfo2) throws VideoFrameProcessingException {
        if (ColorInfo.l(colorInfo)) {
            Assertions.a(colorInfo.f40554a == 6);
        }
        if (ColorInfo.l(colorInfo) || ColorInfo.l(colorInfo2)) {
            try {
                if (GlUtil.K() != 3) {
                    throw new VideoFrameProcessingException("OpenGL ES 3.0 context support is required for HDR input or output.");
                }
            } catch (GlUtil.GlException e3) {
                throw VideoFrameProcessingException.a(e3);
            }
        }
        Assertions.a(colorInfo.j());
        Assertions.a(colorInfo.f40556c != 1);
        Assertions.a(colorInfo2.j());
        Assertions.a(colorInfo2.f40556c != 1);
        if (ColorInfo.l(colorInfo) != ColorInfo.l(colorInfo2)) {
            Assertions.a(D(colorInfo, colorInfo2) || E(colorInfo, colorInfo2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final InputStreamInfo inputStreamInfo, boolean z2) throws VideoFrameProcessingException {
        w((ColorInfo) Assertions.e(inputStreamInfo.f42367b.C), this.f42346s);
        if (z2 || !this.f42344q.equals(inputStreamInfo.f42368c)) {
            if (!this.f42338k.isEmpty()) {
                for (int i3 = 0; i3 < this.f42338k.size(); i3++) {
                    ((GlShaderProgram) this.f42338k.get(i3)).release();
                }
                this.f42338k.clear();
            }
            ImmutableList.Builder builderK = new ImmutableList.Builder().k(inputStreamInfo.f42368c);
            DebugViewProvider debugViewProvider = this.f42347t;
            if (debugViewProvider != DebugViewProvider.f40567a) {
                builderK.a(new DebugViewEffect(debugViewProvider, this.f42346s));
            }
            this.f42338k.addAll(A(this.f42328a, builderK.m(), this.f42346s, this.f42337j));
            this.f42332e.f((GlShaderProgram) Iterables.i(this.f42338k, this.f42337j));
            v(this.f42329b, this.f42338k, this.f42337j, this.f42333f, this.f42334g, this.f42335h);
            this.f42344q.clear();
            this.f42344q.addAll(inputStreamInfo.f42368c);
        }
        this.f42332e.i(inputStreamInfo.f42366a, new FrameInfo(inputStreamInfo.f42367b, inputStreamInfo.f42369d));
        this.f42339l.f();
        synchronized (this.f42345r) {
            try {
                Runnable runnable = this.f42343p;
                if (runnable != null) {
                    runnable.run();
                    this.f42343p = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f42335h.execute(new Runnable() { // from class: androidx.media3.effect.j0
            @Override // java.lang.Runnable
            public final void run() {
                DefaultVideoFrameProcessor defaultVideoFrameProcessor = this.f42736a;
                DefaultVideoFrameProcessor.InputStreamInfo inputStreamInfo2 = inputStreamInfo;
                defaultVideoFrameProcessor.f42334g.f(inputStreamInfo2.f42366a, inputStreamInfo2.f42367b, inputStreamInfo2.f42368c);
            }
        });
        InputStreamInfo inputStreamInfo2 = this.f42340m;
        if (inputStreamInfo2 == null || inputStreamInfo.f42367b.f40641x != inputStreamInfo2.f42367b.f40641x) {
            this.f42335h.execute(new Runnable() { // from class: androidx.media3.effect.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42741a.f42334g.e(inputStreamInfo.f42367b.f40641x);
                }
            });
        }
        this.f42340m = inputStreamInfo;
    }

    private static Pair y(GlObjectsProvider glObjectsProvider, EGLDisplay eGLDisplay, int i3, int[] iArr) {
        EGLContext eGLContextD = glObjectsProvider.d(eGLDisplay, i3, iArr);
        return Pair.create(eGLContextD, glObjectsProvider.c(eGLContextD, eGLDisplay));
    }

    private static Pair z(GlObjectsProvider glObjectsProvider, EGLDisplay eGLDisplay, int[] iArr) {
        try {
            return y(glObjectsProvider, eGLDisplay, 3, iArr);
        } catch (GlUtil.GlException unused) {
            return y(glObjectsProvider, eGLDisplay, 2, iArr);
        }
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public Surface a() {
        return this.f42332e.c();
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void b(final long j3) {
        Assertions.h(!this.f42336i, "Calling this method is not allowed when renderFramesAutomatically is enabled");
        this.f42333f.l(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.f0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                DefaultVideoFrameProcessor defaultVideoFrameProcessor = this.f42711a;
                defaultVideoFrameProcessor.f42337j.C(defaultVideoFrameProcessor.f42329b, j3);
            }
        });
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void d() {
        DebugTraceUtil.e("VideoFrameProcessor", "ReceiveEndOfAllInput", Long.MIN_VALUE);
        Assertions.g(!this.f42349v);
        this.f42349v = true;
        this.f42332e.h();
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void e(Runnable runnable) {
        synchronized (this.f42345r) {
            try {
                if (this.f42339l.e()) {
                    runnable.run();
                } else {
                    this.f42343p = runnable;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void f(SurfaceInfo surfaceInfo) {
        this.f42337j.F(surfaceInfo);
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void flush() {
        if (this.f42332e.d()) {
            this.f42349v = false;
            try {
                TextureManager textureManagerA = this.f42332e.a();
                textureManagerA.a();
                this.f42333f.e();
                textureManagerA.l();
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                textureManagerA.n(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.d0
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        countDownLatch.countDown();
                    }
                });
                VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.f42333f;
                final FinalShaderProgramWrapper finalShaderProgramWrapper = this.f42337j;
                Objects.requireNonNull(finalShaderProgramWrapper);
                videoFrameProcessingTaskExecutor.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.e0
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        finalShaderProgramWrapper.flush();
                    }
                });
                countDownLatch.await();
                textureManagerA.n(null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            G();
        }
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public boolean g(Bitmap bitmap, TimestampIterator timestampIterator) {
        Assertions.g(!this.f42349v);
        boolean z2 = false;
        if (!this.f42339l.e()) {
            return false;
        }
        if (ColorInfo.l(this.f42346s)) {
            if (Util.f41609a >= 34 && bitmap.hasGainmap()) {
                z2 = true;
            }
            Assertions.b(z2, "VideoFrameProcessor configured for HDR output, but either received SDR input, or is on an API level that doesn't support gainmaps. SDR to HDR tonemapping is not supported.");
        }
        this.f42332e.a().h(bitmap, (FrameInfo) Assertions.e(this.f42348u), timestampIterator);
        return true;
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public boolean h(int i3, long j3) {
        Assertions.g(!this.f42349v);
        if (!this.f42339l.e()) {
            return false;
        }
        this.f42332e.a().i(i3, j3);
        return true;
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void i(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        this.f42332e.g(onInputFrameProcessedListener);
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void j(int i3, Format format, List list, long j3) {
        DebugTraceUtil.f("VideoFrameProcessor", "RegisterNewInputStream", j3, "InputType %s - %dx%d", C(i3), Integer.valueOf(format.f40639v), Integer.valueOf(format.f40640w));
        this.f42348u = new FrameInfo(u(format), j3);
        try {
            this.f42339l.a();
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            this.f42335h.execute(new Runnable() { // from class: androidx.media3.effect.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42818a.f42334g.a(VideoFrameProcessingException.a(e3));
                }
            });
        }
        synchronized (this.f42345r) {
            try {
                final InputStreamInfo inputStreamInfo = new InputStreamInfo(i3, format, list, j3);
                if (this.f42342o) {
                    this.f42341n = inputStreamInfo;
                    this.f42339l.d();
                    this.f42332e.h();
                } else {
                    this.f42342o = true;
                    this.f42339l.d();
                    this.f42333f.j(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.c0
                        @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                        public final void run() throws VideoFrameProcessingException {
                            this.f42698a.x(inputStreamInfo, true);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public boolean k() {
        Assertions.g(!this.f42349v);
        Assertions.j(this.f42348u, "registerInputStream must be called before registering input frames");
        if (!this.f42339l.e()) {
            return false;
        }
        this.f42332e.a().j(this.f42348u);
        return true;
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public int l() {
        if (this.f42332e.d()) {
            return this.f42332e.a().g();
        }
        return 0;
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void release() {
        try {
            this.f42333f.i(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.g0
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() {
                    this.f42718a.F();
                }
            });
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e3);
        }
    }
}
