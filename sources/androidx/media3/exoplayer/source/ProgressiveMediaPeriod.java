package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.IcyDataSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.util.ReleasableExecutor;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.facebook.appevents.AppEventsConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    private static final Map S = N();
    private static final Format T = new Format.Builder().f0("icy").u0("application/x-icy").N();
    private boolean A;
    private boolean B;
    private TrackState C;
    private SeekMap D;
    private long E;
    private boolean F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private long M;
    private long N;
    private boolean O;
    private int P;
    private boolean Q;
    private boolean R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f44795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataSource f44796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DrmSessionManager f44797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LoadErrorHandlingPolicy f44798d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f44799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f44800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Listener f44801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Allocator f44802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f44803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f44804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f44805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Format f44806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f44807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Loader f44808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ProgressiveMediaExtractor f44809p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ConditionVariable f44810q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Runnable f44811r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f44812s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Handler f44813t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private MediaPeriod.Callback f44814u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private IcyHeaders f44815v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private SampleQueue[] f44816w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TrackId[] f44817x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f44818y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f44819z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ExtractingLoadable implements Loader.Loadable, IcyDataSource.Listener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f44822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StatsDataSource f44823c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ProgressiveMediaExtractor f44824d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ExtractorOutput f44825e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ConditionVariable f44826f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile boolean f44828h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f44830j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private TrackOutput f44832l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f44833m;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final PositionHolder f44827g = new PositionHolder();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f44829i = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f44821a = LoadEventInfo.a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private DataSpec f44831k = i(0);

        public ExtractingLoadable(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
            this.f44822b = uri;
            this.f44823c = new StatsDataSource(dataSource);
            this.f44824d = progressiveMediaExtractor;
            this.f44825e = extractorOutput;
            this.f44826f = conditionVariable;
        }

        private DataSpec i(long j3) {
            return new DataSpec.Builder().i(this.f44822b).h(j3).f(ProgressiveMediaPeriod.this.f44803j).b(6).e(ProgressiveMediaPeriod.S).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(long j3, long j4) {
            this.f44827g.f46210a = j3;
            this.f44830j = j4;
            this.f44829i = true;
            this.f44833m = false;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public void a() {
            int iE = 0;
            while (iE == 0 && !this.f44828h) {
                try {
                    long j3 = this.f44827g.f46210a;
                    DataSpec dataSpecI = i(j3);
                    this.f44831k = dataSpecI;
                    long jB = this.f44823c.b(dataSpecI);
                    if (this.f44828h) {
                        if (iE != 1 && this.f44824d.d() != -1) {
                            this.f44827g.f46210a = this.f44824d.d();
                        }
                        DataSourceUtil.a(this.f44823c);
                        return;
                    }
                    if (jB != -1) {
                        jB += j3;
                        ProgressiveMediaPeriod.this.Y();
                    }
                    long j4 = jB;
                    ProgressiveMediaPeriod.this.f44815v = IcyHeaders.d(this.f44823c.e());
                    DataReader icyDataSource = this.f44823c;
                    if (ProgressiveMediaPeriod.this.f44815v != null && ProgressiveMediaPeriod.this.f44815v.f46443f != -1) {
                        icyDataSource = new IcyDataSource(this.f44823c, ProgressiveMediaPeriod.this.f44815v.f46443f, this);
                        TrackOutput trackOutputQ = ProgressiveMediaPeriod.this.Q();
                        this.f44832l = trackOutputQ;
                        trackOutputQ.c(ProgressiveMediaPeriod.T);
                    }
                    this.f44824d.c(icyDataSource, this.f44822b, this.f44823c.e(), j3, j4, this.f44825e);
                    if (ProgressiveMediaPeriod.this.f44815v != null) {
                        this.f44824d.b();
                    }
                    if (this.f44829i) {
                        this.f44824d.a(j3, this.f44830j);
                        this.f44829i = false;
                    }
                    while (iE == 0 && !this.f44828h) {
                        try {
                            this.f44826f.a();
                            iE = this.f44824d.e(this.f44827g);
                            long jD = this.f44824d.d();
                            if (jD > ProgressiveMediaPeriod.this.f44804k + j3) {
                                this.f44826f.d();
                                ProgressiveMediaPeriod.this.f44813t.post(ProgressiveMediaPeriod.this.f44812s);
                                j3 = jD;
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                    if (iE == 1) {
                        iE = 0;
                    } else if (this.f44824d.d() != -1) {
                        this.f44827g.f46210a = this.f44824d.d();
                    }
                    DataSourceUtil.a(this.f44823c);
                } catch (Throwable th) {
                    if (iE != 1 && this.f44824d.d() != -1) {
                        this.f44827g.f46210a = this.f44824d.d();
                    }
                    DataSourceUtil.a(this.f44823c);
                    throw th;
                }
            }
        }

        @Override // androidx.media3.exoplayer.source.IcyDataSource.Listener
        public void b(ParsableByteArray parsableByteArray) {
            long jMax = !this.f44833m ? this.f44830j : Math.max(ProgressiveMediaPeriod.this.P(true), this.f44830j);
            int iA = parsableByteArray.a();
            TrackOutput trackOutput = (TrackOutput) Assertions.e(this.f44832l);
            trackOutput.b(parsableByteArray, iA);
            trackOutput.g(jMax, 1, iA, 0, null);
            this.f44833m = true;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public void c() {
            this.f44828h = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Listener {
        void F(long j3, SeekMap seekMap, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SampleStreamImpl implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f44835a;

        public SampleStreamImpl(int i3) {
            this.f44835a = i3;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void d() throws IOException {
            ProgressiveMediaPeriod.this.X(this.f44835a);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int h(long j3) {
            return ProgressiveMediaPeriod.this.i0(this.f44835a, j3);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return ProgressiveMediaPeriod.this.S(this.f44835a);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            return ProgressiveMediaPeriod.this.e0(this.f44835a, formatHolder, decoderInputBuffer, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TrackId {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f44838b;

        public TrackId(int i3, boolean z2) {
            this.f44837a = i3;
            this.f44838b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && TrackId.class == obj.getClass()) {
                TrackId trackId = (TrackId) obj;
                if (this.f44837a == trackId.f44837a && this.f44838b == trackId.f44838b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f44837a * 31) + (this.f44838b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TrackState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TrackGroupArray f44839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f44840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean[] f44841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean[] f44842d;

        public TrackState(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f44839a = trackGroupArray;
            this.f44840b = zArr;
            int i3 = trackGroupArray.f44987a;
            this.f44841c = new boolean[i3];
            this.f44842d = new boolean[i3];
        }
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Listener listener, Allocator allocator, String str, int i3, int i4, Format format, long j3, ReleasableExecutor releasableExecutor) {
        this.f44795a = uri;
        this.f44796b = dataSource;
        this.f44797c = drmSessionManager;
        this.f44800g = eventDispatcher;
        this.f44798d = loadErrorHandlingPolicy;
        this.f44799f = eventDispatcher2;
        this.f44801h = listener;
        this.f44802i = allocator;
        this.f44803j = str;
        this.f44804k = i3;
        this.f44805l = i4;
        this.f44806m = format;
        this.f44808o = releasableExecutor != null ? new Loader(releasableExecutor) : new Loader("ProgressiveMediaPeriod");
        this.f44809p = progressiveMediaExtractor;
        this.f44807n = j3;
        this.f44810q = new ConditionVariable();
        this.f44811r = new Runnable() { // from class: androidx.media3.exoplayer.source.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f45066a.T();
            }
        };
        this.f44812s = new Runnable() { // from class: androidx.media3.exoplayer.source.d0
            @Override // java.lang.Runnable
            public final void run() {
                ProgressiveMediaPeriod.y(this.f45159a);
            }
        };
        this.f44813t = Util.C();
        this.f44817x = new TrackId[0];
        this.f44816w = new SampleQueue[0];
        this.N = -9223372036854775807L;
        this.G = 1;
    }

    private void L() {
        Assertions.g(this.f44819z);
        Assertions.e(this.C);
        Assertions.e(this.D);
    }

    private boolean M(ExtractingLoadable extractingLoadable, int i3) {
        SeekMap seekMap;
        if (this.L || !((seekMap = this.D) == null || seekMap.l() == -9223372036854775807L)) {
            this.P = i3;
            return true;
        }
        if (this.f44819z && !k0()) {
            this.O = true;
            return false;
        }
        this.I = this.f44819z;
        this.M = 0L;
        this.P = 0;
        for (SampleQueue sampleQueue : this.f44816w) {
            sampleQueue.R();
        }
        extractingLoadable.j(0L, 0L);
        return true;
    }

    private static Map N() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        return Collections.unmodifiableMap(map);
    }

    private int O() {
        int iE = 0;
        for (SampleQueue sampleQueue : this.f44816w) {
            iE += sampleQueue.E();
        }
        return iE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long P(boolean z2) {
        long jMax = Long.MIN_VALUE;
        for (int i3 = 0; i3 < this.f44816w.length; i3++) {
            if (z2 || ((TrackState) Assertions.e(this.C)).f44841c[i3]) {
                jMax = Math.max(jMax, this.f44816w[i3].x());
            }
        }
        return jMax;
    }

    private boolean R() {
        return this.N != -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.R || this.f44819z || !this.f44818y || this.D == null) {
            return;
        }
        for (SampleQueue sampleQueue : this.f44816w) {
            if (sampleQueue.D() == null) {
                return;
            }
        }
        this.f44810q.d();
        int length = this.f44816w.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            Format formatN = (Format) Assertions.e(this.f44816w[i3].D());
            String str = formatN.f40632o;
            boolean zN = MimeTypes.n(str);
            boolean z2 = zN || MimeTypes.q(str);
            zArr[i3] = z2;
            this.A = z2 | this.A;
            this.B = this.f44807n != -9223372036854775807L && length == 1 && MimeTypes.o(str);
            IcyHeaders icyHeaders = this.f44815v;
            if (icyHeaders != null) {
                if (zN || this.f44817x[i3].f44838b) {
                    Metadata metadata = formatN.f40629l;
                    formatN = formatN.b().n0(metadata == null ? new Metadata(icyHeaders) : metadata.a(icyHeaders)).N();
                }
                if (zN && formatN.f40625h == -1 && formatN.f40626i == -1 && icyHeaders.f46438a != -1) {
                    formatN = formatN.b().Q(icyHeaders.f46438a).N();
                }
            }
            Format formatC = formatN.c(this.f44797c.c(formatN));
            trackGroupArr[i3] = new TrackGroup(Integer.toString(i3), formatC);
            this.J = formatC.f40638u | this.J;
        }
        this.C = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
        if (this.B && this.E == -9223372036854775807L) {
            this.E = this.f44807n;
            this.D = new ForwardingSeekMap(this.D) { // from class: androidx.media3.exoplayer.source.ProgressiveMediaPeriod.1
                @Override // androidx.media3.extractor.ForwardingSeekMap, androidx.media3.extractor.SeekMap
                public long l() {
                    return ProgressiveMediaPeriod.this.E;
                }
            };
        }
        this.f44801h.F(this.E, this.D, this.F);
        this.f44819z = true;
        ((MediaPeriod.Callback) Assertions.e(this.f44814u)).g(this);
    }

    private void U(int i3) {
        L();
        TrackState trackState = this.C;
        boolean[] zArr = trackState.f44842d;
        if (zArr[i3]) {
            return;
        }
        Format formatA = trackState.f44839a.b(i3).a(0);
        this.f44799f.j(MimeTypes.k(formatA.f40632o), formatA, 0, null, this.M);
        zArr[i3] = true;
    }

    private void V(int i3) {
        L();
        if (this.O) {
            if (!this.A || this.C.f44840b[i3]) {
                if (this.f44816w[i3].I(false)) {
                    return;
                }
                this.N = 0L;
                this.O = false;
                this.I = true;
                this.M = 0L;
                this.P = 0;
                for (SampleQueue sampleQueue : this.f44816w) {
                    sampleQueue.R();
                }
                ((MediaPeriod.Callback) Assertions.e(this.f44814u)).h(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        this.f44813t.post(new Runnable() { // from class: androidx.media3.exoplayer.source.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f45064a.L = true;
            }
        });
    }

    private TrackOutput d0(TrackId trackId) {
        int length = this.f44816w.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (trackId.equals(this.f44817x[i3])) {
                return this.f44816w[i3];
            }
        }
        if (this.f44818y) {
            Log.i("ProgressiveMediaPeriod", "Extractor added new track (id=" + trackId.f44837a + ") after finishing tracks.");
            return new DiscardingTrackOutput();
        }
        SampleQueue sampleQueueL = SampleQueue.l(this.f44802i, this.f44797c, this.f44800g);
        sampleQueueL.Z(this);
        int i4 = length + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.f44817x, i4);
        trackIdArr[length] = trackId;
        this.f44817x = (TrackId[]) Util.l(trackIdArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.f44816w, i4);
        sampleQueueArr[length] = sampleQueueL;
        this.f44816w = (SampleQueue[]) Util.l(sampleQueueArr);
        return sampleQueueL;
    }

    private boolean g0(boolean[] zArr, long j3, boolean z2) {
        int length = this.f44816w.length;
        for (int i3 = 0; i3 < length; i3++) {
            SampleQueue sampleQueue = this.f44816w[i3];
            if (sampleQueue.A() != 0 || !z2) {
                if (!(this.B ? sampleQueue.U(sampleQueue.w()) : sampleQueue.V(j3, false)) && (zArr[i3] || !this.A)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(SeekMap seekMap) {
        this.D = this.f44815v == null ? seekMap : new SeekMap.Unseekable(-9223372036854775807L);
        this.E = seekMap.l();
        boolean z2 = !this.L && seekMap.l() == -9223372036854775807L;
        this.F = z2;
        this.G = z2 ? 7 : 1;
        if (this.f44819z) {
            this.f44801h.F(this.E, seekMap, z2);
        } else {
            T();
        }
    }

    private void j0() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.f44795a, this.f44796b, this.f44809p, this, this.f44810q);
        if (this.f44819z) {
            Assertions.g(R());
            long j3 = this.E;
            if (j3 != -9223372036854775807L && this.N > j3) {
                this.Q = true;
                this.N = -9223372036854775807L;
                return;
            }
            extractingLoadable.j(((SeekMap) Assertions.e(this.D)).b(this.N).f46211a.f46217b, this.N);
            for (SampleQueue sampleQueue : this.f44816w) {
                sampleQueue.X(this.N);
            }
            this.N = -9223372036854775807L;
        }
        this.P = O();
        this.f44808o.n(extractingLoadable, this, this.f44798d.b(this.G));
    }

    private boolean k0() {
        return this.I || R();
    }

    public static /* synthetic */ void y(ProgressiveMediaPeriod progressiveMediaPeriod) {
        if (progressiveMediaPeriod.R) {
            return;
        }
        ((MediaPeriod.Callback) Assertions.e(progressiveMediaPeriod.f44814u)).h(progressiveMediaPeriod);
    }

    TrackOutput Q() {
        return d0(new TrackId(0, true));
    }

    boolean S(int i3) {
        return !k0() && this.f44816w[i3].I(this.Q);
    }

    void W() throws IOException {
        this.f44808o.k(this.f44798d.b(this.G));
    }

    void X(int i3) throws IOException {
        this.f44816w[i3].K();
        W();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void v(ExtractingLoadable extractingLoadable, long j3, long j4, boolean z2) {
        StatsDataSource statsDataSource = extractingLoadable.f44823c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f44821a, extractingLoadable.f44831k, statsDataSource.o(), statsDataSource.p(), j3, j4, statsDataSource.n());
        this.f44798d.c(extractingLoadable.f44821a);
        this.f44799f.l(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.f44830j, this.E);
        if (z2) {
            return;
        }
        for (SampleQueue sampleQueue : this.f44816w) {
            sampleQueue.R();
        }
        if (this.K > 0) {
            ((MediaPeriod.Callback) Assertions.e(this.f44814u)).h(this);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        return this.f44808o.i() && this.f44810q.e();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void t(ExtractingLoadable extractingLoadable, long j3, long j4) {
        if (this.E == -9223372036854775807L && this.D != null) {
            long jP = P(true);
            long j5 = jP == Long.MIN_VALUE ? 0L : jP + 10000;
            this.E = j5;
            this.f44801h.F(j5, this.D, this.F);
        }
        StatsDataSource statsDataSource = extractingLoadable.f44823c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f44821a, extractingLoadable.f44831k, statsDataSource.o(), statsDataSource.p(), j3, j4, statsDataSource.n());
        this.f44798d.c(extractingLoadable.f44821a);
        this.f44799f.n(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.f44830j, this.E);
        this.Q = true;
        ((MediaPeriod.Callback) Assertions.e(this.f44814u)).h(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        if (this.Q || this.f44808o.h() || this.O) {
            return false;
        }
        if ((this.f44819z || this.f44806m != null) && this.K == 0) {
            return false;
        }
        boolean zF = this.f44810q.f();
        if (this.f44808o.i()) {
            return zF;
        }
        j0();
        return true;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public Loader.LoadErrorAction g(ExtractingLoadable extractingLoadable, long j3, long j4, IOException iOException, int i3) {
        ExtractingLoadable extractingLoadable2;
        Loader.LoadErrorAction loadErrorActionG;
        StatsDataSource statsDataSource = extractingLoadable.f44823c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f44821a, extractingLoadable.f44831k, statsDataSource.o(), statsDataSource.p(), j3, j4, statsDataSource.n());
        long jA = this.f44798d.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, Util.t1(extractingLoadable.f44830j), Util.t1(this.E)), iOException, i3));
        if (jA == -9223372036854775807L) {
            loadErrorActionG = Loader.f45537g;
            extractingLoadable2 = extractingLoadable;
        } else {
            int iO = O();
            extractingLoadable2 = extractingLoadable;
            loadErrorActionG = M(extractingLoadable2, iO) ? Loader.g(iO > this.P, jA) : Loader.f45536f;
        }
        boolean zC = loadErrorActionG.c();
        this.f44799f.p(loadEventInfo, 1, -1, null, 0, null, extractingLoadable2.f44830j, this.E, iOException, !zC);
        if (!zC) {
            this.f44798d.c(extractingLoadable2.f44821a);
        }
        return loadErrorActionG;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        return e();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void p(ExtractingLoadable extractingLoadable, long j3, long j4, int i3) {
        StatsDataSource statsDataSource = extractingLoadable.f44823c;
        this.f44799f.s(i3 == 0 ? new LoadEventInfo(extractingLoadable.f44821a, extractingLoadable.f44831k, j3) : new LoadEventInfo(extractingLoadable.f44821a, extractingLoadable.f44831k, statsDataSource.o(), statsDataSource.p(), j3, j4, statsDataSource.n()), 1, -1, null, 0, null, extractingLoadable.f44830j, this.E, i3);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public TrackOutput d(int i3, int i4) {
        return d0(new TrackId(i3, false));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        long jP;
        L();
        if (this.Q || this.K == 0) {
            return Long.MIN_VALUE;
        }
        if (R()) {
            return this.N;
        }
        if (this.A) {
            int length = this.f44816w.length;
            jP = Long.MAX_VALUE;
            for (int i3 = 0; i3 < length; i3++) {
                TrackState trackState = this.C;
                if (trackState.f44840b[i3] && trackState.f44841c[i3] && !this.f44816w[i3].H()) {
                    jP = Math.min(jP, this.f44816w[i3].x());
                }
            }
        } else {
            jP = Long.MAX_VALUE;
        }
        if (jP == Long.MAX_VALUE) {
            jP = P(false);
        }
        return jP == Long.MIN_VALUE ? this.M : jP;
    }

    int e0(int i3, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i4) {
        if (k0()) {
            return -3;
        }
        U(i3);
        int iO = this.f44816w[i3].O(formatHolder, decoderInputBuffer, i4, this.Q);
        if (iO == -3) {
            V(i3);
        }
        return iO;
    }

    public void f0() {
        if (this.f44819z) {
            for (SampleQueue sampleQueue : this.f44816w) {
                sampleQueue.N();
            }
        }
        this.f44808o.m(this);
        this.f44813t.removeCallbacksAndMessages(null);
        this.f44814u = null;
        this.R = true;
    }

    @Override // androidx.media3.exoplayer.source.SampleQueue.UpstreamFormatChangedListener
    public void h(Format format) {
        this.f44813t.post(this.f44811r);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long i(long j3, SeekParameters seekParameters) {
        L();
        if (!this.D.e()) {
            return 0L;
        }
        SeekMap.SeekPoints seekPointsB = this.D.b(j3);
        return seekParameters.a(j3, seekPointsB.f46211a.f46216a, seekPointsB.f46212b.f46216a);
    }

    int i0(int i3, long j3) throws Throwable {
        if (k0()) {
            return 0;
        }
        U(i3);
        SampleQueue sampleQueue = this.f44816w[i3];
        int iC = sampleQueue.C(j3, this.Q);
        sampleQueue.a0(iC);
        if (iC == 0) {
            V(i3);
        }
        return iC;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long j(long j3) {
        L();
        boolean[] zArr = this.C.f44840b;
        if (!this.D.e()) {
            j3 = 0;
        }
        int i3 = 0;
        this.I = false;
        boolean z2 = this.M == j3;
        this.M = j3;
        if (R()) {
            this.N = j3;
            return j3;
        }
        if (this.G == 7 || ((!this.Q && !this.f44808o.i()) || !g0(zArr, j3, z2))) {
            this.O = false;
            this.N = j3;
            this.Q = false;
            this.J = false;
            if (this.f44808o.i()) {
                SampleQueue[] sampleQueueArr = this.f44816w;
                int length = sampleQueueArr.length;
                while (i3 < length) {
                    sampleQueueArr[i3].q();
                    i3++;
                }
                this.f44808o.e();
                return j3;
            }
            this.f44808o.f();
            SampleQueue[] sampleQueueArr2 = this.f44816w;
            int length2 = sampleQueueArr2.length;
            while (i3 < length2) {
                sampleQueueArr2[i3].R();
                i3++;
            }
        }
        return j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        ExoTrackSelection exoTrackSelection;
        L();
        TrackState trackState = this.C;
        TrackGroupArray trackGroupArray = trackState.f44839a;
        boolean[] zArr3 = trackState.f44841c;
        int i3 = this.K;
        int i4 = 0;
        for (int i5 = 0; i5 < exoTrackSelectionArr.length; i5++) {
            SampleStream sampleStream = sampleStreamArr[i5];
            if (sampleStream != null && (exoTrackSelectionArr[i5] == null || !zArr[i5])) {
                int i6 = ((SampleStreamImpl) sampleStream).f44835a;
                Assertions.g(zArr3[i6]);
                this.K--;
                zArr3[i6] = false;
                sampleStreamArr[i5] = null;
            }
        }
        boolean z2 = !this.H ? j3 == 0 || this.B : i3 != 0;
        for (int i7 = 0; i7 < exoTrackSelectionArr.length; i7++) {
            if (sampleStreamArr[i7] == null && (exoTrackSelection = exoTrackSelectionArr[i7]) != null) {
                Assertions.g(exoTrackSelection.length() == 1);
                Assertions.g(exoTrackSelection.d(0) == 0);
                int iD = trackGroupArray.d(exoTrackSelection.h());
                Assertions.g(!zArr3[iD]);
                this.K++;
                zArr3[iD] = true;
                this.J = exoTrackSelection.l().f40638u | this.J;
                sampleStreamArr[i7] = new SampleStreamImpl(iD);
                zArr2[i7] = true;
                if (!z2) {
                    SampleQueue sampleQueue = this.f44816w[iD];
                    z2 = (sampleQueue.A() == 0 || sampleQueue.V(j3, true)) ? false : true;
                }
            }
        }
        if (this.K == 0) {
            this.O = false;
            this.I = false;
            this.J = false;
            if (this.f44808o.i()) {
                SampleQueue[] sampleQueueArr = this.f44816w;
                int length = sampleQueueArr.length;
                while (i4 < length) {
                    sampleQueueArr[i4].q();
                    i4++;
                }
                this.f44808o.e();
            } else {
                this.Q = false;
                SampleQueue[] sampleQueueArr2 = this.f44816w;
                int length2 = sampleQueueArr2.length;
                while (i4 < length2) {
                    sampleQueueArr2[i4].R();
                    i4++;
                }
            }
        } else if (z2) {
            j3 = j(j3);
            while (i4 < sampleStreamArr.length) {
                if (sampleStreamArr[i4] != null) {
                    zArr2[i4] = true;
                }
                i4++;
            }
        }
        this.H = true;
        return j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long l() {
        if (this.J) {
            this.J = false;
            return this.M;
        }
        if (!this.I) {
            return -9223372036854775807L;
        }
        if (!this.Q && O() <= this.P) {
            return -9223372036854775807L;
        }
        this.I = false;
        return this.M;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.ReleaseCallback
    public void m() {
        for (SampleQueue sampleQueue : this.f44816w) {
            sampleQueue.P();
        }
        this.f44809p.release();
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void n(final SeekMap seekMap) {
        this.f44813t.post(new Runnable() { // from class: androidx.media3.exoplayer.source.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f45162a.h0(seekMap);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void o() throws IOException {
        W();
        if (this.Q && !this.f44819z) {
            throw ParserException.a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void q() {
        this.f44818y = true;
        this.f44813t.post(this.f44811r);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void r(MediaPeriod.Callback callback, long j3) {
        this.f44814u = callback;
        if (this.f44806m == null) {
            this.f44810q.f();
            j0();
        } else {
            d(this.f44805l, 3).c(this.f44806m);
            h0(new IndexSeekMap(new long[]{0}, new long[]{0}, -9223372036854775807L));
            q();
            this.N = j3;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray s() {
        L();
        return this.C.f44839a;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void u(long j3, boolean z2) {
        if (this.B) {
            return;
        }
        L();
        if (R()) {
            return;
        }
        boolean[] zArr = this.C.f44841c;
        int length = this.f44816w.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f44816w[i3].p(j3, z2, zArr[i3]);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
    }
}
