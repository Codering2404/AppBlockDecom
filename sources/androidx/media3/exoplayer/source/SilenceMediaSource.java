package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SilenceMediaSource extends BaseMediaSource {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Format f44913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final MediaItem f44914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final byte[] f44915m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f44916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaItem f44917j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory {
    }

    static {
        Format formatN = new Format.Builder().u0("audio/raw").R(2).v0(44100).o0(2).N();
        f44913k = formatN;
        f44914l = new MediaItem.Builder().f("SilenceMediaSource").k(Uri.EMPTY).g(formatN.f40632o).a();
        f44915m = new byte[Util.k0(2, 2) * 1024];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long r0(long j3) {
        return ((long) Util.k0(2, 2)) * ((j3 * 44100) / 1000000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long s0(long j3) {
        return ((j3 / ((long) Util.k0(2, 2))) * 1000000) / 44100;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public synchronized void H(MediaItem mediaItem) {
        this.f44917j = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void f0(TransferListener transferListener) {
        j0(new SinglePeriodTimeline(this.f44916i, true, false, false, null, m()));
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        return new SilenceMediaPeriod(this.f44916i);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public synchronized MediaItem m() {
        return this.f44917j;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SilenceMediaPeriod implements MediaPeriod {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final TrackGroupArray f44918c = new TrackGroupArray(new TrackGroup(SilenceMediaSource.f44913k));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f44919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f44920b = new ArrayList();

        public SilenceMediaPeriod(long j3) {
            this.f44919a = j3;
        }

        private long d(long j3) {
            return Util.s(j3, 0L, this.f44919a);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public boolean a() {
            return false;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public boolean b(LoadingInfo loadingInfo) {
            return false;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public long c() {
            return Long.MIN_VALUE;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public long e() {
            return Long.MIN_VALUE;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long i(long j3, SeekParameters seekParameters) {
            return d(j3);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long j(long j3) {
            long jD = d(j3);
            for (int i3 = 0; i3 < this.f44920b.size(); i3++) {
                ((SilenceSampleStream) this.f44920b.get(i3)).a(jD);
            }
            return jD;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
            long jD = d(j3);
            for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
                SampleStream sampleStream = sampleStreamArr[i3];
                if (sampleStream != null && (exoTrackSelectionArr[i3] == null || !zArr[i3])) {
                    this.f44920b.remove(sampleStream);
                    sampleStreamArr[i3] = null;
                }
                if (sampleStreamArr[i3] == null && exoTrackSelectionArr[i3] != null) {
                    SilenceSampleStream silenceSampleStream = new SilenceSampleStream(this.f44919a);
                    silenceSampleStream.a(jD);
                    this.f44920b.add(silenceSampleStream);
                    sampleStreamArr[i3] = silenceSampleStream;
                    zArr2[i3] = true;
                }
            }
            return jD;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long l() {
            return -9223372036854775807L;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void r(MediaPeriod.Callback callback, long j3) {
            callback.g(this);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public TrackGroupArray s() {
            return f44918c;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void o() {
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public void f(long j3) {
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void u(long j3, boolean z2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SilenceSampleStream implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f44921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f44922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f44923c;

        public SilenceSampleStream(long j3) {
            this.f44921a = SilenceMediaSource.r0(j3);
            a(0L);
        }

        public void a(long j3) {
            this.f44923c = Util.s(SilenceMediaSource.r0(j3), 0L, this.f44921a);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int h(long j3) {
            long j4 = this.f44923c;
            a(j3);
            return (int) ((this.f44923c - j4) / ((long) SilenceMediaSource.f44915m.length));
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return true;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            if (!this.f44922b || (i3 & 2) != 0) {
                formatHolder.f43108b = SilenceMediaSource.f44913k;
                this.f44922b = true;
                return -5;
            }
            long j3 = this.f44921a;
            long j4 = this.f44923c;
            long j5 = j3 - j4;
            if (j5 == 0) {
                decoderInputBuffer.e(4);
                return -4;
            }
            decoderInputBuffer.f42140g = SilenceMediaSource.s0(j4);
            decoderInputBuffer.e(1);
            int iMin = (int) Math.min(SilenceMediaSource.f44915m.length, j5);
            if ((i3 & 4) == 0) {
                decoderInputBuffer.p(iMin);
                decoderInputBuffer.f42138d.put(SilenceMediaSource.f44915m, 0, iMin);
            }
            if ((i3 & 1) == 0) {
                this.f44923c += (long) iMin;
            }
            return -4;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void d() {
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void L() {
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
    }
}
