package androidx.media3.transformer;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.muxer.MuxerException;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.AudioMixer;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.TransformerInternal;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TransformerInternal {
    private int A;
    private volatile boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Composition f48536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f48537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CapturingEncoderFactory f48538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Listener f48539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HandlerWrapper f48540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Clock f48541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f48542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HandlerThread f48543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HandlerWrapper f48544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f48545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f48546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AssetLoaderInputTracker f48547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f48548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MuxerWrapper f48549o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ConditionVariable f48550p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Object f48551q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f48552r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ProgressHolder f48553s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f48554t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f48555u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f48556v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f48557w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f48558x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private RuntimeException f48559y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f48560z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AssetLoaderInputTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f48561a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray f48562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SparseArray f48563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SparseArray f48564d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class SequenceMetadata {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final SparseArray f48565a = new SparseArray();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f48566b = -1;
        }

        public AssetLoaderInputTracker(Composition composition) {
            for (int i3 = 0; i3 < composition.f47968a.size(); i3++) {
                this.f48561a.add(new SequenceMetadata());
            }
            this.f48562b = new SparseArray();
            this.f48563c = new SparseArray();
            this.f48564d = new SparseArray();
        }

        public Format a(int i3, int i4) {
            SparseArray sparseArray = ((SequenceMetadata) this.f48561a.get(i3)).f48565a;
            Assertions.g(Util.t(sparseArray, i4));
            return (Format) sparseArray.get(i4);
        }

        public int b(int i3) {
            Assertions.h(h(), "Primary track can only be queried after all tracks are added.");
            for (int i4 = 0; i4 < this.f48561a.size(); i4++) {
                if (Util.t(((SequenceMetadata) this.f48561a.get(i4)).f48565a, i3)) {
                    return i4;
                }
            }
            return -1;
        }

        public int c() {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < this.f48561a.size(); i5++) {
                SparseArray sparseArray = ((SequenceMetadata) this.f48561a.get(i5)).f48565a;
                if (Util.t(sparseArray, 1)) {
                    i3 = 1;
                }
                if (Util.t(sparseArray, 2)) {
                    i4 = 1;
                }
            }
            return i3 + i4;
        }

        public SampleExporter d(int i3) {
            return (SampleExporter) this.f48562b.get(i3);
        }

        public boolean e() {
            for (int i3 = 0; i3 < this.f48561a.size(); i3++) {
                if (((SequenceMetadata) this.f48561a.get(i3)).f48566b == -1) {
                    return false;
                }
            }
            return true;
        }

        public boolean f(int i3) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.f48561a.size(); i5++) {
                if (Util.t(((SequenceMetadata) this.f48561a.get(i5)).f48565a, i3)) {
                    i4++;
                }
            }
            return ((Integer) this.f48564d.get(i3)).intValue() == i4;
        }

        public boolean g() {
            if (this.f48561a.size() < 2) {
                return false;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f48561a.size(); i4++) {
                if (Util.t(((SequenceMetadata) this.f48561a.get(i4)).f48565a, 2)) {
                    i3++;
                }
            }
            return i3 > 1;
        }

        public boolean h() {
            if (!e()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f48561a.size(); i3++) {
                SequenceMetadata sequenceMetadata = (SequenceMetadata) this.f48561a.get(i3);
                if (sequenceMetadata.f48566b != sequenceMetadata.f48565a.size()) {
                    return false;
                }
            }
            return true;
        }

        public void i(int i3) {
            this.f48564d.put(i3, Integer.valueOf(Util.t(this.f48564d, i3) ? 1 + ((Integer) this.f48564d.get(i3)).intValue() : 1));
        }

        public void j(int i3, SampleExporter sampleExporter) {
            Assertions.h(!Util.t(this.f48562b, i3), "Exactly one SampleExporter can be added for each track type.");
            this.f48562b.put(i3, sampleExporter);
        }

        public void k(int i3, Format format) {
            int iG = TransformerUtil.g(format.f40632o);
            SparseArray sparseArray = ((SequenceMetadata) this.f48561a.get(i3)).f48565a;
            Assertions.g(!Util.t(sparseArray, iG));
            sparseArray.put(iG, format);
        }

        public boolean l(int i3) {
            return ((SequenceMetadata) this.f48561a.get(i3)).f48565a.size() > 1;
        }

        public void m(int i3, boolean z2) {
            if (Util.t(this.f48563c, i3)) {
                Assertions.g(z2 == ((Boolean) this.f48563c.get(i3)).booleanValue());
            } else {
                this.f48563c.put(i3, Boolean.valueOf(z2));
            }
        }

        public void n(int i3, int i4) {
            ((SequenceMetadata) this.f48561a.get(i3)).f48566b = i4;
        }

        public boolean o(int i3) {
            Assertions.g(Util.t(this.f48563c, i3));
            return ((Boolean) this.f48563c.get(i3)).booleanValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void c(ImmutableList immutableList, String str, String str2);

        void d(ImmutableList immutableList, String str, String str2, ExportException exportException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.media3.transformer.TransformerInternal, java.lang.Object] */
    public TransformerInternal(Context context, Composition composition, TransformationRequest transformationRequest, AssetLoader.Factory factory, AudioMixer.Factory factory2, VideoFrameProcessor.Factory factory3, Codec.EncoderFactory encoderFactory, boolean z2, int i3, MuxerWrapper muxerWrapper, Listener listener, FallbackListener fallbackListener, HandlerWrapper handlerWrapper, DebugViewProvider debugViewProvider, Clock clock, long j3) {
        Composition composition2 = composition;
        Clock clock2 = clock;
        ?? obj = new Object();
        obj.f48535a = context;
        obj.f48536b = composition2;
        obj.f48538d = new CapturingEncoderFactory(encoderFactory);
        obj.f48554t = z2;
        obj.f48555u = i3;
        obj.f48539e = listener;
        obj.f48540f = handlerWrapper;
        obj.f48541g = clock2;
        obj.f48542h = j3;
        obj.f48549o = muxerWrapper;
        Log.i("TransformerInternal", "Init " + Integer.toHexString(System.identityHashCode(obj)) + " [AndroidXMedia3/1.7.1] [" + Util.f41613e + "]");
        HandlerThread handlerThread = new HandlerThread("Transformer:Internal");
        obj.f48543i = handlerThread;
        handlerThread.start();
        obj.f48545k = new ArrayList();
        Looper looper = handlerThread.getLooper();
        obj.f48546l = new Object();
        obj.f48547m = new AssetLoaderInputTracker(composition2);
        int i4 = 0;
        TransformerInternal transformerInternal = obj;
        while (i4 < composition2.f47968a.size()) {
            SequenceAssetLoaderListener sequenceAssetLoaderListener = transformerInternal.new SequenceAssetLoaderListener(i4, composition2, transformationRequest, factory2, factory3, fallbackListener, debugViewProvider);
            TransformerInternal transformerInternal2 = transformerInternal;
            int i5 = i4;
            Composition composition3 = composition2;
            EditedMediaItemSequence editedMediaItemSequence = (EditedMediaItemSequence) composition3.f47968a.get(i5);
            Clock clock3 = clock2;
            Looper looper2 = looper;
            transformerInternal2.f48545k.add(new SequenceAssetLoader(editedMediaItemSequence, composition3.f47971d, factory, new AssetLoader.CompositionSettings(transformationRequest.f48473d, composition3.f47975h), sequenceAssetLoaderListener, clock3, looper2));
            if (!editedMediaItemSequence.f48111b) {
                transformerInternal2.f48558x++;
            }
            i4 = i5 + 1;
            clock2 = clock3;
            looper = looper2;
            transformerInternal = transformerInternal2;
            composition2 = composition3;
        }
        final TransformerInternal transformerInternal3 = transformerInternal;
        Clock clock4 = clock2;
        Looper looper3 = looper;
        transformerInternal3.f48537c = transformerInternal3.f48558x != composition2.f47968a.size();
        transformerInternal3.f48551q = new Object();
        transformerInternal3.f48550p = new ConditionVariable();
        transformerInternal3.f48552r = new Object();
        transformerInternal3.f48553s = new ProgressHolder();
        transformerInternal3.f48548n = new ArrayList();
        transformerInternal3.f48544j = clock4.d(looper3, new Handler.Callback() { // from class: androidx.media3.transformer.g2
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f48676a.D(message);
            }
        });
    }

    private int B(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        throw new IllegalStateException("Unexpected end reason " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D(Message message) {
        if (this.B && message.what != 4) {
            return true;
        }
        try {
            int i3 = message.what;
            if (i3 == 1) {
                G();
            } else if (i3 == 2) {
                E((SampleExporter) message.obj);
            } else if (i3 == 3) {
                x();
            } else {
                if (i3 != 4) {
                    return false;
                }
                y(message.arg1, (ExportException) message.obj);
            }
        } catch (ExportException e3) {
            y(2, e3);
        } catch (RuntimeException e4) {
            y(2, ExportException.e(e4));
        }
        return true;
    }

    private void E(SampleExporter sampleExporter) {
        this.f48548n.add(sampleExporter);
        if (this.f48556v) {
            return;
        }
        this.f48544j.k(3);
        this.f48556v = true;
    }

    private void G() {
        for (int i3 = 0; i3 < this.f48545k.size(); i3++) {
            ((SequenceAssetLoader) this.f48545k.get(i3)).start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void H() {
        if (this.B) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f48545k.size(); i5++) {
            if (!((EditedMediaItemSequence) this.f48536b.f47968a.get(i5)).f48111b) {
                this.f48553s.f48349a = 0;
                int iE = ((SequenceAssetLoader) this.f48545k.get(i5)).e(this.f48553s);
                if (iE != 2) {
                    synchronized (this.f48552r) {
                        this.f48560z = iE;
                        this.A = 0;
                    }
                    return;
                }
                i3 += this.f48553s.f48349a;
                i4++;
            }
        }
        synchronized (this.f48552r) {
            this.f48560z = 2;
            this.A = i3 / i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        Assertions.h(this.f48543i.isAlive(), "Internal thread is dead.");
    }

    static /* synthetic */ int j(TransformerInternal transformerInternal) {
        int i3 = transformerInternal.f48558x;
        transformerInternal.f48558x = i3 - 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(MediaItem mediaItem) {
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.f40718f;
        return clippingConfiguration.f40746a > 0 && !clippingConfiguration.f40752g;
    }

    private void x() {
        for (int i3 = 0; i3 < this.f48548n.size(); i3++) {
            while (((SampleExporter) this.f48548n.get(i3)).p()) {
            }
        }
        H();
        if (this.f48549o.k()) {
            return;
        }
        this.f48544j.a(3, 10);
    }

    private void y(int i3, final ExportException exportException) {
        final ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i4 = 0; i4 < this.f48545k.size(); i4++) {
            builder.k(((SequenceAssetLoader) this.f48545k.get(i4)).D());
        }
        boolean z2 = i3 == 1;
        boolean z3 = this.B;
        ExportException exportExceptionD = null;
        if (!this.B) {
            this.B = true;
            Log.i("TransformerInternal", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.7.1] [" + Util.f41613e + "] [" + MediaLibraryInfo.b() + "]");
            for (int i5 = 0; i5 < this.f48548n.size(); i5++) {
                try {
                    ((SampleExporter) this.f48548n.get(i5)).r();
                } catch (RuntimeException e3) {
                    if (exportExceptionD == null) {
                        exportExceptionD = ExportException.e(e3);
                        this.f48559y = e3;
                    }
                }
            }
            for (int i6 = 0; i6 < this.f48545k.size(); i6++) {
                try {
                    ((SequenceAssetLoader) this.f48545k.get(i6)).release();
                } catch (RuntimeException e4) {
                    if (exportExceptionD == null) {
                        ExportException exportExceptionE = ExportException.e(e4);
                        this.f48559y = e4;
                        exportExceptionD = exportExceptionE;
                    }
                }
            }
            try {
                this.f48549o.f(B(i3));
            } catch (MuxerException e5) {
                if (exportExceptionD == null) {
                    exportExceptionD = ExportException.d(e5, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
                }
            } catch (RuntimeException e6) {
                if (exportExceptionD == null) {
                    ExportException exportExceptionE2 = ExportException.e(e6);
                    this.f48559y = e6;
                    exportExceptionD = exportExceptionE2;
                }
            }
            HandlerWrapper handlerWrapper = this.f48544j;
            final HandlerThread handlerThread = this.f48543i;
            Objects.requireNonNull(handlerThread);
            handlerWrapper.j(new Runnable() { // from class: androidx.media3.transformer.h2
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quitSafely();
                }
            });
        }
        if (z2) {
            this.f48550p.f();
            return;
        }
        if (exportException == null) {
            exportException = exportExceptionD;
        }
        if (exportException == null) {
            if (z3) {
                return;
            }
            Assertions.g(this.f48540f.j(new Runnable() { // from class: androidx.media3.transformer.j2
                @Override // java.lang.Runnable
                public final void run() {
                    TransformerInternal transformerInternal = this.f48690a;
                    transformerInternal.f48539e.c(builder.m(), transformerInternal.f48538d.e(), transformerInternal.f48538d.f());
                }
            }));
        } else if (z3) {
            Log.w("TransformerInternal", "Export error after export ended", exportException);
        } else {
            Assertions.g(this.f48540f.j(new Runnable() { // from class: androidx.media3.transformer.i2
                @Override // java.lang.Runnable
                public final void run() {
                    TransformerInternal transformerInternal = this.f48686a;
                    transformerInternal.f48539e.d(builder.m(), transformerInternal.f48538d.e(), transformerInternal.f48538d.f(), exportException);
                }
            }));
        }
    }

    public void A(ExportException exportException) {
        I();
        this.f48544j.d(4, 2, 0, exportException).a();
    }

    public int C(ProgressHolder progressHolder) {
        int i3;
        synchronized (this.f48552r) {
            try {
                i3 = this.f48560z;
                if (i3 == 2) {
                    progressHolder.f48349a = this.A;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i3;
    }

    public void F() {
        I();
        this.f48544j.k(1);
        synchronized (this.f48552r) {
            this.f48560z = 1;
            this.A = 0;
        }
        DebugTraceUtil.f("TransformerInternal", "Start", -9223372036854775807L, "%s", Util.f41613e);
    }

    public void v() {
        if (this.B) {
            return;
        }
        I();
        this.f48544j.d(4, 1, 0, null).a();
        this.f48541g.e();
        this.f48550p.c();
        this.f48550p.d();
        RuntimeException runtimeException = this.f48559y;
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public void z() {
        I();
        this.f48544j.d(4, 0, 0, null).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SequenceAssetLoaderListener implements AssetLoader.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f48567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EditedMediaItem f48568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Composition f48569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TransformationRequest f48570d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AudioMixer.Factory f48571e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final VideoFrameProcessor.Factory f48572f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final FallbackListener f48573g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final DebugViewProvider f48574h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f48575i;

        /* JADX WARN: Multi-variable type inference failed */
        public SequenceAssetLoaderListener(int i3, Composition composition, TransformationRequest transformationRequest, AudioMixer.Factory factory, VideoFrameProcessor.Factory factory2, FallbackListener fallbackListener, DebugViewProvider debugViewProvider) {
            this.f48567a = i3;
            this.f48568b = (EditedMediaItem) ((EditedMediaItemSequence) composition.f47968a.get(i3)).f48110a.get(0);
            this.f48569c = composition;
            this.f48570d = transformationRequest;
            this.f48571e = factory;
            this.f48572f = factory2;
            this.f48573g = fallbackListener;
            this.f48574h = debugViewProvider;
        }

        public static /* synthetic */ void e(SequenceAssetLoaderListener sequenceAssetLoaderListener, int i3, GraphInput graphInput, EditedMediaItem editedMediaItem, long j3, Format format, boolean z2) {
            sequenceAssetLoaderListener.i(i3, j3, z2);
            graphInput.b(editedMediaItem, j3, format, z2);
        }

        private void g(Format format) throws ExportException {
            Format formatN;
            int iG = TransformerUtil.g(format.f40632o);
            Assertions.g(TransformerInternal.this.f48547m.d(iG) == null);
            Format formatA = TransformerInternal.this.f48547m.a(this.f48567a, iG);
            if (MimeTypes.n(format.f40632o)) {
                TransformerInternal.this.f48547m.j(1, new AudioSampleExporter(formatA, format, this.f48570d, this.f48568b, this.f48569c.f47970c.f48126a, this.f48571e, TransformerInternal.this.f48538d, TransformerInternal.this.f48549o, this.f48573g));
                return;
            }
            if (MimeTypes.q(format.f40632o)) {
                formatN = formatA.b().T(TransformerUtil.c(TransformerUtil.h(formatA.C), this.f48570d.f48473d == 1)).N();
            } else {
                if (!MimeTypes.o(format.f40632o)) {
                    throw ExportException.e(new IllegalArgumentException("assetLoaderOutputFormat has to have a audio, video or image mimetype."));
                }
                formatN = format.b().T(TransformerUtil.h(format.C)).N();
            }
            Format format2 = formatN;
            AssetLoaderInputTracker assetLoaderInputTracker = TransformerInternal.this.f48547m;
            Context context = TransformerInternal.this.f48535a;
            TransformationRequest transformationRequest = this.f48570d;
            Composition composition = this.f48569c;
            assetLoaderInputTracker.j(2, new VideoSampleExporter(context, format2, transformationRequest, composition.f47969b, composition.f47970c.f48127b, this.f48572f, TransformerInternal.this.f48538d, TransformerInternal.this.f48549o, new Consumer() { // from class: androidx.media3.transformer.l2
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f48696a.d((ExportException) obj);
                }
            }, this.f48573g, this.f48574h, TransformerInternal.this.f48542h, TransformerInternal.this.f48547m.g(), TransformerInternal.this.f48554t, TransformerInternal.this.f48555u));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void h(int i3) {
            Assertions.g(TransformerInternal.this.f48547m.d(i3) == null);
            Assertions.b((i3 == 1 && ((EditedMediaItemSequence) this.f48569c.f47968a.get(this.f48567a)).a()) ? false : true, "Gaps can not be transmuxed.");
            TransformerInternal.this.f48547m.j(i3, new EncodedSampleExporter(TransformerInternal.this.f48547m.a(this.f48567a, i3), this.f48570d, TransformerInternal.this.f48549o, this.f48573g, TransformerInternal.this.f48542h));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void i(int i3, long j3, boolean z2) {
            if (TransformerInternal.this.f48537c) {
                synchronized (TransformerInternal.this.f48546l) {
                    try {
                        if (TransformerInternal.this.f48547m.l(this.f48567a) && i3 == 2) {
                            return;
                        }
                        if (((EditedMediaItemSequence) this.f48569c.f47968a.get(this.f48567a)).f48111b) {
                            return;
                        }
                        boolean z3 = true;
                        Assertions.h(j3 != -9223372036854775807L, "MediaItem duration required for sequence looping could not be extracted.");
                        this.f48575i += j3;
                        synchronized (TransformerInternal.this.f48551q) {
                            if (z2) {
                                try {
                                    TransformerInternal.j(TransformerInternal.this);
                                } finally {
                                }
                            }
                            if (TransformerInternal.this.f48558x != 0) {
                                z3 = false;
                            }
                            if (this.f48575i > TransformerInternal.this.f48557w || z3) {
                                TransformerInternal transformerInternal = TransformerInternal.this;
                                transformerInternal.f48557w = Math.max(this.f48575i, transformerInternal.f48557w);
                                for (int i4 = 0; i4 < TransformerInternal.this.f48545k.size(); i4++) {
                                    ((SequenceAssetLoader) TransformerInternal.this.f48545k.get(i4)).H(TransformerInternal.this.f48557w, z3);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean j(androidx.media3.common.Format r11, int r12) {
            /*
                r10 = this;
                r0 = r12 & 2
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L8
                r0 = r2
                goto L9
            L8:
                r0 = r1
            L9:
                r12 = r12 & r2
                if (r12 == 0) goto Le
                r12 = r2
                goto Lf
            Le:
                r12 = r1
            Lf:
                if (r0 != 0) goto L16
                if (r12 == 0) goto L14
                goto L16
            L14:
                r3 = r1
                goto L17
            L16:
                r3 = r2
            L17:
                androidx.media3.common.util.Assertions.a(r3)
                java.lang.String r3 = r11.f40632o
                int r3 = androidx.media3.transformer.TransformerUtil.g(r3)
                if (r12 != 0) goto L24
            L22:
                r11 = r2
                goto L67
            L24:
                if (r3 != r2) goto L3e
                androidx.media3.transformer.Composition r5 = r10.f48569c
                int r6 = r10.f48567a
                androidx.media3.transformer.TransformationRequest r7 = r10.f48570d
                androidx.media3.transformer.TransformerInternal r12 = androidx.media3.transformer.TransformerInternal.this
                androidx.media3.transformer.CapturingEncoderFactory r8 = androidx.media3.transformer.TransformerInternal.r(r12)
                androidx.media3.transformer.TransformerInternal r12 = androidx.media3.transformer.TransformerInternal.this
                androidx.media3.transformer.MuxerWrapper r9 = androidx.media3.transformer.TransformerInternal.n(r12)
                r4 = r11
                boolean r11 = androidx.media3.transformer.TransformerUtil.l(r4, r5, r6, r7, r8, r9)
                goto L67
            L3e:
                r4 = r11
                r11 = 2
                if (r3 != r11) goto L66
                r3 = r4
                androidx.media3.transformer.Composition r4 = r10.f48569c
                int r5 = r10.f48567a
                androidx.media3.transformer.TransformationRequest r6 = r10.f48570d
                androidx.media3.transformer.TransformerInternal r11 = androidx.media3.transformer.TransformerInternal.this
                androidx.media3.transformer.CapturingEncoderFactory r7 = androidx.media3.transformer.TransformerInternal.r(r11)
                androidx.media3.transformer.TransformerInternal r11 = androidx.media3.transformer.TransformerInternal.this
                androidx.media3.transformer.MuxerWrapper r8 = androidx.media3.transformer.TransformerInternal.n(r11)
                boolean r11 = androidx.media3.transformer.TransformerUtil.m(r3, r4, r5, r6, r7, r8)
                if (r11 != 0) goto L22
                androidx.media3.transformer.EditedMediaItem r11 = r10.f48568b
                androidx.media3.common.MediaItem r11 = r11.f48095a
                boolean r11 = androidx.media3.transformer.TransformerInternal.m(r11)
                if (r11 == 0) goto L66
                goto L22
            L66:
                r11 = r1
            L67:
                if (r11 == 0) goto L6b
                if (r0 == 0) goto L6c
            L6b:
                r1 = r2
            L6c:
                androidx.media3.common.util.Assertions.g(r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.transformer.TransformerInternal.SequenceAssetLoaderListener.j(androidx.media3.common.Format, int):boolean");
        }

        @Override // androidx.media3.transformer.AssetLoader.Listener
        public SampleConsumer a(Format format) {
            synchronized (TransformerInternal.this.f48546l) {
                try {
                    if (!TransformerInternal.this.f48547m.h()) {
                        return null;
                    }
                    final int iG = TransformerUtil.g(format.f40632o);
                    if (!TransformerInternal.this.f48547m.o(iG)) {
                        h(iG);
                    } else if (TransformerInternal.this.f48547m.b(iG) == this.f48567a) {
                        g(format);
                    }
                    SampleExporter sampleExporterD = TransformerInternal.this.f48547m.d(iG);
                    if (sampleExporterD == null) {
                        return null;
                    }
                    final GraphInput graphInputL = sampleExporterD.l(this.f48568b, format, this.f48567a);
                    ((SequenceAssetLoader) TransformerInternal.this.f48545k.get(this.f48567a)).C(new OnMediaItemChangedListener() { // from class: androidx.media3.transformer.k2
                        @Override // androidx.media3.transformer.OnMediaItemChangedListener
                        public final void b(EditedMediaItem editedMediaItem, long j3, Format format2, boolean z2) {
                            TransformerInternal.SequenceAssetLoaderListener.e(this.f48693a, iG, graphInputL, editedMediaItem, j3, format2, z2);
                        }
                    }, iG);
                    TransformerInternal.this.f48547m.i(iG);
                    if (TransformerInternal.this.f48547m.f(iG)) {
                        TransformerInternal.this.I();
                        TransformerInternal.this.f48544j.e(2, sampleExporterD).a();
                    }
                    return graphInputL;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.transformer.AssetLoader.Listener
        public boolean b(Format format, int i3) {
            boolean zJ;
            int iG = TransformerUtil.g(format.f40632o);
            Assertions.b((iG == 2 && ((EditedMediaItemSequence) this.f48569c.f47968a.get(this.f48567a)).a()) ? false : true, "Gaps in video sequences are not supported.");
            synchronized (TransformerInternal.this.f48546l) {
                try {
                    TransformerInternal.this.f48547m.k(this.f48567a, format);
                    if (TransformerInternal.this.f48547m.h()) {
                        int iC = TransformerInternal.this.f48547m.c();
                        TransformerInternal.this.f48549o.m(iC);
                        this.f48573g.d(iC);
                    }
                    zJ = j(format, i3);
                    if (!zJ && TransformerUtil.g(format.f40632o) == 2) {
                        TransformerUtil.k(TransformerInternal.this.f48549o, this.f48568b.f48101g.f48127b, format);
                    }
                    TransformerInternal.this.f48547m.m(iG, zJ);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zJ;
        }

        @Override // androidx.media3.transformer.AssetLoader.Listener
        public void c(int i3) {
            if (i3 <= 0) {
                d(ExportException.a(new IllegalStateException("AssetLoader instances must provide at least 1 track."), AdError.NO_FILL_ERROR_CODE));
                return;
            }
            synchronized (TransformerInternal.this.f48546l) {
                TransformerInternal.this.f48547m.n(this.f48567a, i3);
            }
        }

        @Override // androidx.media3.transformer.AssetLoader.Listener
        public void d(ExportException exportException) {
            TransformerInternal.this.A(exportException);
        }

        @Override // androidx.media3.transformer.AssetLoader.Listener
        public void f(long j3) {
        }
    }
}
