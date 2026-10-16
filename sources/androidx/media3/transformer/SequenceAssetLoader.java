package androidx.media3.transformer;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.ExportResult;
import androidx.media3.transformer.SequenceAssetLoader;
import com.facebook.internal.AnalyticsEvents;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SequenceAssetLoader implements AssetLoader, AssetLoader.Listener {
    private static final Format B = new Format.Builder().u0("audio/mp4a-latm").v0(44100).R(2).N();
    private volatile boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f48390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f48391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f48392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AssetLoader.Factory f48393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AssetLoader.CompositionSettings f48394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AssetLoader.Listener f48395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HandlerWrapper f48396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f48397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f48398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ImmutableList.Builder f48399j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f48400k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicInteger f48401l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f48402m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f48403n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AssetLoader f48404o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f48405p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f48406q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f48407r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f48408s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f48409t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Format f48410u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Format f48411v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile boolean f48412w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile long f48413x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile long f48414y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile long f48415z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ClippingIterator implements TimestampIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimestampIterator f48416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f48417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f48418c;

        public ClippingIterator(TimestampIterator timestampIterator, long j3) {
            this.f48416a = timestampIterator;
            this.f48417b = j3;
        }

        @Override // androidx.media3.common.util.TimestampIterator
        public TimestampIterator b() {
            return new ClippingIterator(this.f48416a.b(), this.f48417b);
        }

        @Override // androidx.media3.common.util.TimestampIterator
        public boolean hasNext() {
            return !this.f48418c && this.f48416a.hasNext();
        }

        @Override // androidx.media3.common.util.TimestampIterator
        public long next() {
            Assertions.g(hasNext());
            long next = this.f48416a.next();
            if (this.f48417b <= next) {
                this.f48418c = true;
            }
            return next;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class GapInterceptingAssetLoaderFactory implements AssetLoader.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetLoader.Factory f48419a;

        public GapInterceptingAssetLoaderFactory(AssetLoader.Factory factory) {
            this.f48419a = factory;
        }

        @Override // androidx.media3.transformer.AssetLoader.Factory
        public AssetLoader a(EditedMediaItem editedMediaItem, Looper looper, AssetLoader.Listener listener, AssetLoader.CompositionSettings compositionSettings) {
            return editedMediaItem.d() ? new GapSignalingAssetLoader(editedMediaItem.f48099e) : this.f48419a.a(editedMediaItem, looper, listener, compositionSettings);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class GapSignalingAssetLoader implements AssetLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f48421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Format f48422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Format f48423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f48424d;

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            try {
                if (this.f48424d) {
                    return;
                }
                SampleConsumerWrapper sampleConsumerWrapperA = SequenceAssetLoader.this.a(this.f48423c);
                if (sampleConsumerWrapperA == null) {
                    SequenceAssetLoader.this.f48396g.postDelayed(new Runnable() { // from class: androidx.media3.transformer.w1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f48724a.b();
                        }
                    }, 10L);
                } else {
                    this.f48424d = true;
                    sampleConsumerWrapperA.k();
                }
            } catch (ExportException e3) {
                SequenceAssetLoader.this.d(e3);
            } catch (RuntimeException e4) {
                SequenceAssetLoader.this.d(ExportException.a(e4, 1000));
            }
        }

        @Override // androidx.media3.transformer.AssetLoader
        public int e(ProgressHolder progressHolder) {
            progressHolder.f48349a = this.f48424d ? 99 : 0;
            return 2;
        }

        @Override // androidx.media3.transformer.AssetLoader
        public ImmutableMap g() {
            return ImmutableMap.n();
        }

        @Override // androidx.media3.transformer.AssetLoader
        public void start() {
            SequenceAssetLoader.this.f(this.f48421a);
            SequenceAssetLoader.this.c(1);
            SequenceAssetLoader.this.b(this.f48422b, 2);
            b();
        }

        private GapSignalingAssetLoader(long j3) {
            this.f48421a = j3;
            this.f48422b = new Format.Builder().u0("audio/raw").N();
            this.f48423c = new Format.Builder().u0("audio/raw").v0(44100).R(2).o0(2).N();
        }

        @Override // androidx.media3.transformer.AssetLoader
        public void release() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SampleConsumerWrapper implements SampleConsumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SampleConsumer f48426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f48427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f48428c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f48429d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f48430e;

        public SampleConsumerWrapper(SampleConsumer sampleConsumer, int i3) {
            this.f48426a = sampleConsumer;
            this.f48427b = i3;
        }

        public static /* synthetic */ void b(SampleConsumerWrapper sampleConsumerWrapper) {
            sampleConsumerWrapper.getClass();
            try {
                if (SequenceAssetLoader.this.f48412w) {
                    return;
                }
                SequenceAssetLoader.this.B();
                sampleConsumerWrapper.f48428c += SequenceAssetLoader.this.f48414y;
                SequenceAssetLoader.this.f48404o.release();
                SequenceAssetLoader.this.f48402m = false;
                SequenceAssetLoader.o(SequenceAssetLoader.this);
                if (SequenceAssetLoader.this.f48403n == SequenceAssetLoader.this.f48390a.size()) {
                    SequenceAssetLoader.this.f48403n = 0;
                    SequenceAssetLoader.q(SequenceAssetLoader.this);
                }
                EditedMediaItem editedMediaItem = (EditedMediaItem) SequenceAssetLoader.this.f48390a.get(SequenceAssetLoader.this.f48403n);
                SequenceAssetLoader sequenceAssetLoader = SequenceAssetLoader.this;
                AssetLoader.Factory factory = sequenceAssetLoader.f48393d;
                Looper looper = (Looper) Assertions.e(Looper.myLooper());
                SequenceAssetLoader sequenceAssetLoader2 = SequenceAssetLoader.this;
                sequenceAssetLoader.f48404o = factory.a(editedMediaItem, looper, sequenceAssetLoader2, sequenceAssetLoader2.f48394e);
                SequenceAssetLoader.this.f48404o.start();
            } catch (RuntimeException e3) {
                SequenceAssetLoader.this.d(ExportException.a(e3, 1000));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k() {
            SequenceAssetLoader.this.f48401l.decrementAndGet();
            if (SequenceAssetLoader.this.E()) {
                return;
            }
            l();
        }

        private void l() {
            SequenceAssetLoader.this.f48396g.j(new Runnable() { // from class: androidx.media3.transformer.x1
                @Override // java.lang.Runnable
                public final void run() {
                    SequenceAssetLoader.SampleConsumerWrapper.b(this.f48726a);
                }
            });
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public Surface a() {
            return this.f48426a.a();
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public boolean c() {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) Assertions.i(this.f48426a.f());
            long j3 = this.f48428c + decoderInputBuffer.f42140g;
            if (SequenceAssetLoader.this.f48391b && (j3 >= SequenceAssetLoader.this.f48415z || this.f48429d)) {
                if (SequenceAssetLoader.this.A && !this.f48429d) {
                    ((ByteBuffer) Assertions.e(decoderInputBuffer.f42138d)).limit(0);
                    decoderInputBuffer.n(4);
                    Assertions.g(this.f48426a.c());
                    this.f48429d = true;
                    SequenceAssetLoader.this.f48401l.decrementAndGet();
                }
                return false;
            }
            if (decoderInputBuffer.i()) {
                SequenceAssetLoader.this.f48401l.decrementAndGet();
                if (!SequenceAssetLoader.this.E() || SequenceAssetLoader.this.f48391b) {
                    if (this.f48427b == 1 && !SequenceAssetLoader.this.f48391b && SequenceAssetLoader.this.f48406q) {
                        Assertions.g(this.f48426a.c());
                    } else {
                        decoderInputBuffer.f();
                        decoderInputBuffer.f42140g = 0L;
                    }
                    if (SequenceAssetLoader.this.f48401l.get() == 0) {
                        l();
                    }
                    return true;
                }
            }
            Assertions.g(this.f48426a.c());
            return true;
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public int d() {
            return this.f48426a.d();
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public void e(Runnable runnable) {
            this.f48426a.e(runnable);
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public DecoderInputBuffer f() {
            return this.f48426a.f();
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public int g(Bitmap bitmap, TimestampIterator timestampIterator) {
            if (SequenceAssetLoader.this.f48391b) {
                long j3 = -9223372036854775807L;
                while (true) {
                    if (!timestampIterator.hasNext()) {
                        break;
                    }
                    long next = timestampIterator.next();
                    if (this.f48428c + next <= SequenceAssetLoader.this.f48415z) {
                        j3 = next;
                    } else {
                        if (!SequenceAssetLoader.this.A) {
                            return 2;
                        }
                        if (j3 == -9223372036854775807L) {
                            if (this.f48430e) {
                                return 2;
                            }
                            this.f48430e = true;
                            h();
                            return 3;
                        }
                        ClippingIterator clippingIterator = new ClippingIterator(timestampIterator.b(), j3);
                        this.f48430e = true;
                        timestampIterator = clippingIterator;
                    }
                }
            }
            return this.f48426a.g(bitmap, timestampIterator.b());
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public void h() {
            SequenceAssetLoader.this.f48401l.decrementAndGet();
            if (SequenceAssetLoader.this.f48391b ? this.f48430e : SequenceAssetLoader.this.E()) {
                this.f48426a.h();
            } else if (SequenceAssetLoader.this.f48401l.get() == 0) {
                l();
            }
        }

        @Override // androidx.media3.transformer.SampleConsumer
        public boolean i(long j3) {
            long j4 = this.f48428c + j3;
            if (!SequenceAssetLoader.this.f48391b || j4 < SequenceAssetLoader.this.f48415z) {
                return this.f48426a.i(j3);
            }
            if (!SequenceAssetLoader.this.A || this.f48430e) {
                return false;
            }
            this.f48430e = true;
            h();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SequenceAssetLoader(EditedMediaItemSequence editedMediaItemSequence, boolean z2, AssetLoader.Factory factory, AssetLoader.CompositionSettings compositionSettings, AssetLoader.Listener listener, Clock clock, Looper looper) {
        ImmutableList immutableList = editedMediaItemSequence.f48110a;
        this.f48390a = immutableList;
        this.f48391b = editedMediaItemSequence.f48111b;
        this.f48392c = z2;
        GapInterceptingAssetLoaderFactory gapInterceptingAssetLoaderFactory = new GapInterceptingAssetLoaderFactory(factory);
        this.f48393d = gapInterceptingAssetLoaderFactory;
        this.f48394e = compositionSettings;
        this.f48395f = listener;
        this.f48396g = clock.d(looper, null);
        this.f48397h = new HashMap();
        this.f48398i = new HashMap();
        this.f48399j = new ImmutableList.Builder();
        this.f48400k = new AtomicInteger();
        this.f48401l = new AtomicInteger();
        this.f48402m = true;
        this.f48404o = gapInterceptingAssetLoaderFactory.a((EditedMediaItem) immutableList.get(0), looper, this, compositionSettings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        int size = this.f48408s * this.f48390a.size();
        int i3 = this.f48403n;
        if (size + i3 >= this.f48409t) {
            MediaItem mediaItem = ((EditedMediaItem) this.f48390a.get(i3)).f48095a;
            ImmutableMap immutableMapG = g();
            this.f48399j.a(new ExportResult.ProcessedInput(mediaItem, this.f48413x, this.f48410u, this.f48411v, (String) immutableMapG.get(1), (String) immutableMapG.get(2)));
            this.f48409t++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        return this.f48403n == this.f48390a.size() - 1;
    }

    private void F(int i3, Format format) {
        OnMediaItemChangedListener onMediaItemChangedListener = (OnMediaItemChangedListener) this.f48398i.get(Integer.valueOf(i3));
        if (onMediaItemChangedListener == null) {
            return;
        }
        EditedMediaItem editedMediaItem = (EditedMediaItem) this.f48390a.get(this.f48403n);
        long j3 = (i3 == 1 && this.f48391b && this.f48406q) ? -9223372036854775807L : this.f48413x;
        if (editedMediaItem.d()) {
            format = null;
        }
        onMediaItemChangedListener.b(editedMediaItem, j3, format, E());
    }

    static /* synthetic */ int o(SequenceAssetLoader sequenceAssetLoader) {
        int i3 = sequenceAssetLoader.f48403n;
        sequenceAssetLoader.f48403n = i3 + 1;
        return i3;
    }

    static /* synthetic */ int q(SequenceAssetLoader sequenceAssetLoader) {
        int i3 = sequenceAssetLoader.f48408s;
        sequenceAssetLoader.f48408s = i3 + 1;
        return i3;
    }

    public void C(OnMediaItemChangedListener onMediaItemChangedListener, int i3) {
        Assertions.a(i3 == 1 || i3 == 2);
        Assertions.a(this.f48398i.get(Integer.valueOf(i3)) == null);
        this.f48398i.put(Integer.valueOf(i3), onMediaItemChangedListener);
    }

    public ImmutableList D() {
        B();
        return this.f48399j.m();
    }

    @Override // androidx.media3.transformer.AssetLoader.Listener
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public SampleConsumerWrapper a(Format format) {
        SampleConsumerWrapper sampleConsumerWrapper;
        int iG = TransformerUtil.g(format.f40632o);
        DebugTraceUtil.f("AssetLoader", "OutputFormat", -9223372036854775807L, "%s:%s", Util.s0(iG), format);
        if (this.f48402m) {
            SampleConsumer sampleConsumerA = this.f48395f.a(format);
            if (sampleConsumerA == null) {
                return null;
            }
            sampleConsumerWrapper = new SampleConsumerWrapper(sampleConsumerA, iG);
            this.f48397h.put(Integer.valueOf(iG), sampleConsumerWrapper);
            if (this.f48392c && this.f48400k.get() == 1 && iG == 2) {
                this.f48397h.put(1, new SampleConsumerWrapper((SampleConsumer) Assertions.i(this.f48395f.a(B.b().u0("audio/raw").o0(2).N())), 1));
            }
        } else {
            Assertions.h(!(this.f48400k.get() == 1 && iG == 1 && this.f48397h.size() == 2), "Inputs with no video track are not supported when the output contains a video track");
            sampleConsumerWrapper = (SampleConsumerWrapper) Assertions.j((SampleConsumerWrapper) this.f48397h.get(Integer.valueOf(iG)), Util.J("The preceding MediaItem does not contain any track of type %d. If the Composition contains a sequence that starts with items without audio tracks (like images), followed by items with audio tracks, Composition.Builder.experimentalSetForceAudioTrack() needs to be set to true.", Integer.valueOf(iG)));
        }
        F(iG, format);
        if (this.f48400k.get() == 1 && this.f48397h.size() == 2) {
            Iterator it = this.f48397h.entrySet().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) ((Map.Entry) it.next()).getKey()).intValue();
                if (iG != iIntValue) {
                    F(iIntValue, null);
                }
            }
        }
        return sampleConsumerWrapper;
    }

    public void H(long j3, boolean z2) {
        this.f48415z = j3;
        this.A = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.transformer.AssetLoader.Listener
    public boolean b(Format format, int i3) {
        int i4 = 0;
        i4 = 0;
        i4 = 0;
        Object[] objArr = TransformerUtil.g(format.f40632o) == 1;
        DebugTraceUtil.f("AssetLoader", "InputFormat", -9223372036854775807L, "%s:%s", objArr != false ? "audio" : AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, format);
        if (objArr == true) {
            this.f48410u = format;
        } else {
            this.f48411v = format;
        }
        if (!this.f48402m) {
            boolean z2 = objArr != false ? this.f48406q : this.f48407r;
            if (z2) {
                Assertions.a((i3 & 2) != 0);
                return z2;
            }
            Assertions.a((i3 & 1) != 0);
            return z2;
        }
        if (this.f48392c && this.f48400k.get() == 1 && objArr == false) {
            i4 = 1;
        }
        if (!this.f48405p) {
            this.f48395f.c(this.f48400k.get() + i4);
            this.f48405p = true;
        }
        boolean zB = this.f48395f.b(format, i3);
        if (objArr == true) {
            this.f48406q = zB;
        } else {
            this.f48407r = zB;
        }
        if (i4 != 0) {
            this.f48395f.b(B, 2);
            this.f48406q = true;
        }
        return zB;
    }

    @Override // androidx.media3.transformer.AssetLoader.Listener
    public void c(int i3) {
        this.f48400k.set(i3);
        this.f48401l.set(i3);
    }

    @Override // androidx.media3.transformer.AssetLoader.Listener
    public void d(ExportException exportException) {
        this.f48395f.d(exportException);
    }

    @Override // androidx.media3.transformer.AssetLoader
    public int e(ProgressHolder progressHolder) {
        if (this.f48391b) {
            return 3;
        }
        int iE = this.f48404o.e(progressHolder);
        int size = this.f48390a.size();
        if (size == 1 || iE == 0) {
            return iE;
        }
        int i3 = (this.f48403n * 100) / size;
        if (iE == 2) {
            i3 += progressHolder.f48349a / size;
        }
        progressHolder.f48349a = i3;
        return 2;
    }

    @Override // androidx.media3.transformer.AssetLoader.Listener
    public void f(long j3) {
        Assertions.b(j3 != -9223372036854775807L || E(), "Could not retrieve required duration for EditedMediaItem " + this.f48403n);
        this.f48414y = ((EditedMediaItem) this.f48390a.get(this.f48403n)).b(j3);
        this.f48413x = j3;
        if (this.f48390a.size() != 1 || this.f48391b) {
            return;
        }
        this.f48395f.f(this.f48414y);
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap g() {
        return this.f48404o.g();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.f48404o.release();
        this.f48412w = true;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        this.f48404o.start();
        if (this.f48390a.size() > 1 || this.f48391b) {
            this.f48395f.f(-9223372036854775807L);
        }
    }
}
