package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TimeOffsetMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaPeriod f44979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f44980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaPeriod.Callback f44981c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TimeOffsetSampleStream implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SampleStream f44982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f44983b;

        public TimeOffsetSampleStream(SampleStream sampleStream, long j3) {
            this.f44982a = sampleStream;
            this.f44983b = j3;
        }

        public SampleStream a() {
            return this.f44982a;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void d() {
            this.f44982a.d();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int h(long j3) {
            return this.f44982a.h(j3 - this.f44983b);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return this.f44982a.isReady();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            int iN = this.f44982a.n(formatHolder, decoderInputBuffer, i3);
            if (iN == -4) {
                decoderInputBuffer.f42140g += this.f44983b;
            }
            return iN;
        }
    }

    public TimeOffsetMediaPeriod(MediaPeriod mediaPeriod, long j3) {
        this.f44979a = mediaPeriod;
        this.f44980b = j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        return this.f44979a.a();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        return this.f44979a.b(loadingInfo.a().f(loadingInfo.f43121a - this.f44980b).d());
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        long jC = this.f44979a.c();
        if (jC == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jC + this.f44980b;
    }

    public MediaPeriod d() {
        return this.f44979a;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        long jE = this.f44979a.e();
        if (jE == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jE + this.f44980b;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
        this.f44979a.f(j3 - this.f44980b);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void g(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.e(this.f44981c)).g(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long i(long j3, SeekParameters seekParameters) {
        return this.f44979a.i(j3 - this.f44980b, seekParameters) + this.f44980b;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long j(long j3) {
        return this.f44979a.j(j3 - this.f44980b) + this.f44980b;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i3 = 0;
        while (true) {
            SampleStream sampleStreamA = null;
            if (i3 >= sampleStreamArr.length) {
                break;
            }
            TimeOffsetSampleStream timeOffsetSampleStream = (TimeOffsetSampleStream) sampleStreamArr[i3];
            if (timeOffsetSampleStream != null) {
                sampleStreamA = timeOffsetSampleStream.a();
            }
            sampleStreamArr2[i3] = sampleStreamA;
            i3++;
        }
        long jK = this.f44979a.k(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j3 - this.f44980b);
        for (int i4 = 0; i4 < sampleStreamArr.length; i4++) {
            SampleStream sampleStream = sampleStreamArr2[i4];
            if (sampleStream == null) {
                sampleStreamArr[i4] = null;
            } else {
                SampleStream sampleStream2 = sampleStreamArr[i4];
                if (sampleStream2 == null || ((TimeOffsetSampleStream) sampleStream2).a() != sampleStream) {
                    sampleStreamArr[i4] = new TimeOffsetSampleStream(sampleStream, this.f44980b);
                }
            }
        }
        return jK + this.f44980b;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long l() {
        long jL = this.f44979a.l();
        if (jL == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jL + this.f44980b;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void h(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.e(this.f44981c)).h(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void o() {
        this.f44979a.o();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void r(MediaPeriod.Callback callback, long j3) {
        this.f44981c = callback;
        this.f44979a.r(this, j3 - this.f44980b);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray s() {
        return this.f44979a.s();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void u(long j3, boolean z2) {
        this.f44979a.u(j3 - this.f44980b, z2);
    }
}
