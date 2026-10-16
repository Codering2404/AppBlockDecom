package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.util.ReleasableExecutor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSpec f44939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataSource.Factory f44940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TransferListener f44941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LoadErrorHandlingPolicy f44942d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f44943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TrackGroupArray f44944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ArrayList f44945h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f44946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Loader f44947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Format f44948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f44949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f44950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    byte[] f44951n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f44952o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SampleStreamImpl implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f44953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f44954b;

        private SampleStreamImpl() {
        }

        private void a() {
            if (this.f44954b) {
                return;
            }
            SingleSampleMediaPeriod.this.f44943f.j(MimeTypes.k(SingleSampleMediaPeriod.this.f44948k.f40632o), SingleSampleMediaPeriod.this.f44948k, 0, null, 0L);
            this.f44954b = true;
        }

        public void b() {
            if (this.f44953a == 2) {
                this.f44953a = 1;
            }
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void d() throws IOException {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            if (singleSampleMediaPeriod.f44949l) {
                return;
            }
            singleSampleMediaPeriod.f44947j.j();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int h(long j3) {
            a();
            if (j3 <= 0 || this.f44953a == 2) {
                return 0;
            }
            this.f44953a = 2;
            return 1;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return SingleSampleMediaPeriod.this.f44950m;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            a();
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            boolean z2 = singleSampleMediaPeriod.f44950m;
            if (z2 && singleSampleMediaPeriod.f44951n == null) {
                this.f44953a = 2;
            }
            int i4 = this.f44953a;
            if (i4 == 2) {
                decoderInputBuffer.e(4);
                return -4;
            }
            if ((i3 & 2) != 0 || i4 == 0) {
                formatHolder.f43108b = singleSampleMediaPeriod.f44948k;
                this.f44953a = 1;
                return -5;
            }
            if (!z2) {
                return -3;
            }
            Assertions.e(singleSampleMediaPeriod.f44951n);
            decoderInputBuffer.e(1);
            decoderInputBuffer.f42140g = 0L;
            if ((i3 & 4) == 0) {
                decoderInputBuffer.p(SingleSampleMediaPeriod.this.f44952o);
                ByteBuffer byteBuffer = decoderInputBuffer.f42138d;
                SingleSampleMediaPeriod singleSampleMediaPeriod2 = SingleSampleMediaPeriod.this;
                byteBuffer.put(singleSampleMediaPeriod2.f44951n, 0, singleSampleMediaPeriod2.f44952o);
            }
            if ((i3 & 1) == 0) {
                this.f44953a = 2;
            }
            return -4;
        }
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec, DataSource.Factory factory, TransferListener transferListener, Format format, long j3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z2, ReleasableExecutor releasableExecutor) {
        this.f44939a = dataSpec;
        this.f44940b = factory;
        this.f44941c = transferListener;
        this.f44948k = format;
        this.f44946i = j3;
        this.f44942d = loadErrorHandlingPolicy;
        this.f44943f = eventDispatcher;
        this.f44949l = z2;
        this.f44944g = new TrackGroupArray(new TrackGroup(format));
        this.f44947j = releasableExecutor != null ? new Loader(releasableExecutor) : new Loader("SingleSampleMediaPeriod");
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        return this.f44947j.i();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        if (this.f44950m || this.f44947j.i() || this.f44947j.h()) {
            return false;
        }
        DataSource dataSourceA = this.f44940b.a();
        TransferListener transferListener = this.f44941c;
        if (transferListener != null) {
            dataSourceA.c(transferListener);
        }
        this.f44947j.n(new SourceLoadable(this.f44939a, dataSourceA), this, this.f44942d.b(1));
        return true;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        return (this.f44950m || this.f44947j.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        return this.f44950m ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void v(SourceLoadable sourceLoadable, long j3, long j4, boolean z2) {
        StatsDataSource statsDataSource = sourceLoadable.f44958c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.f44956a, sourceLoadable.f44957b, statsDataSource.o(), statsDataSource.p(), j3, j4, statsDataSource.n());
        this.f44942d.c(sourceLoadable.f44956a);
        this.f44943f.l(loadEventInfo, 1, -1, null, 0, null, 0L, this.f44946i);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long j(long j3) {
        for (int i3 = 0; i3 < this.f44945h.size(); i3++) {
            ((SampleStreamImpl) this.f44945h.get(i3)).b();
        }
        return j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
            SampleStream sampleStream = sampleStreamArr[i3];
            if (sampleStream != null && (exoTrackSelectionArr[i3] == null || !zArr[i3])) {
                this.f44945h.remove(sampleStream);
                sampleStreamArr[i3] = null;
            }
            if (sampleStreamArr[i3] == null && exoTrackSelectionArr[i3] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.f44945h.add(sampleStreamImpl);
                sampleStreamArr[i3] = sampleStreamImpl;
                zArr2[i3] = true;
            }
        }
        return j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long l() {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void t(SourceLoadable sourceLoadable, long j3, long j4) {
        this.f44952o = (int) sourceLoadable.f44958c.n();
        this.f44951n = (byte[]) Assertions.e(sourceLoadable.f44959d);
        this.f44950m = true;
        StatsDataSource statsDataSource = sourceLoadable.f44958c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.f44956a, sourceLoadable.f44957b, statsDataSource.o(), statsDataSource.p(), j3, j4, this.f44952o);
        this.f44942d.c(sourceLoadable.f44956a);
        this.f44943f.n(loadEventInfo, 1, -1, this.f44948k, 0, null, 0L, this.f44946i);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Loader.LoadErrorAction g(SourceLoadable sourceLoadable, long j3, long j4, IOException iOException, int i3) {
        Loader.LoadErrorAction loadErrorActionG;
        StatsDataSource statsDataSource = sourceLoadable.f44958c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.f44956a, sourceLoadable.f44957b, statsDataSource.o(), statsDataSource.p(), j3, j4, statsDataSource.n());
        long jA = this.f44942d.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, this.f44948k, 0, null, 0L, Util.t1(this.f44946i)), iOException, i3));
        boolean z2 = jA == -9223372036854775807L || i3 >= this.f44942d.b(1);
        if (this.f44949l && z2) {
            Log.j("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f44950m = true;
            loadErrorActionG = Loader.f45536f;
        } else {
            loadErrorActionG = jA != -9223372036854775807L ? Loader.g(false, jA) : Loader.f45537g;
        }
        Loader.LoadErrorAction loadErrorAction = loadErrorActionG;
        boolean zC = loadErrorAction.c();
        this.f44943f.p(loadEventInfo, 1, -1, this.f44948k, 0, null, 0L, this.f44946i, iOException, !zC);
        if (!zC) {
            this.f44942d.c(sourceLoadable.f44956a);
        }
        return loadErrorAction;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Callback
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void p(SourceLoadable sourceLoadable, long j3, long j4, int i3) {
        StatsDataSource statsDataSource = sourceLoadable.f44958c;
        this.f44943f.s(i3 == 0 ? new LoadEventInfo(sourceLoadable.f44956a, sourceLoadable.f44957b, j3) : new LoadEventInfo(sourceLoadable.f44956a, sourceLoadable.f44957b, statsDataSource.o(), statsDataSource.p(), j3, j4, statsDataSource.n()), 1, -1, this.f44948k, 0, null, 0L, this.f44946i, i3);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void r(MediaPeriod.Callback callback, long j3) {
        callback.g(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray s() {
        return this.f44944g;
    }

    public void w() {
        this.f44947j.l();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SourceLoadable implements Loader.Loadable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f44956a = LoadEventInfo.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DataSpec f44957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StatsDataSource f44958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f44959d;

        public SourceLoadable(DataSpec dataSpec, DataSource dataSource) {
            this.f44957b = dataSpec;
            this.f44958c = new StatsDataSource(dataSource);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public void a() {
            this.f44958c.q();
            try {
                this.f44958c.b(this.f44957b);
                int i3 = 0;
                while (i3 != -1) {
                    int iN = (int) this.f44958c.n();
                    byte[] bArr = this.f44959d;
                    if (bArr == null) {
                        this.f44959d = new byte[1024];
                    } else if (iN == bArr.length) {
                        this.f44959d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    StatsDataSource statsDataSource = this.f44958c;
                    byte[] bArr2 = this.f44959d;
                    i3 = statsDataSource.read(bArr2, iN, bArr2.length - iN);
                }
                DataSourceUtil.a(this.f44958c);
            } catch (Throwable th) {
                DataSourceUtil.a(this.f44958c);
                throw th;
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public void c() {
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void o() {
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long i(long j3, SeekParameters seekParameters) {
        return j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void u(long j3, boolean z2) {
    }
}
