package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaPeriod f44553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaPeriod.Callback f44554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ClippingSampleStream[] f44555c = new ClippingSampleStream[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f44556d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f44557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f44558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ClippingMediaSource.IllegalClippingException f44559h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ClippingSampleStream implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SampleStream f44560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f44561b;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.f44560a = sampleStream;
        }

        public void a() {
            this.f44561b = false;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void d() {
            this.f44560a.d();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int h(long j3) {
            if (ClippingMediaPeriod.this.n()) {
                return -3;
            }
            return this.f44560a.h(j3);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return !ClippingMediaPeriod.this.n() && this.f44560a.isReady();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            if (ClippingMediaPeriod.this.n()) {
                return -3;
            }
            if (this.f44561b) {
                decoderInputBuffer.n(4);
                return -4;
            }
            long jE = ClippingMediaPeriod.this.e();
            int iN = this.f44560a.n(formatHolder, decoderInputBuffer, i3);
            if (iN == -5) {
                Format format = (Format) Assertions.e(formatHolder.f43108b);
                int i4 = format.H;
                if (i4 != 0 || format.I != 0) {
                    ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                    if (clippingMediaPeriod.f44557f != 0) {
                        i4 = 0;
                    }
                    formatHolder.f43108b = format.b().Z(i4).a0(clippingMediaPeriod.f44558g == Long.MIN_VALUE ? format.I : 0).N();
                }
                return -5;
            }
            long j3 = ClippingMediaPeriod.this.f44558g;
            if (j3 == Long.MIN_VALUE || ((iN != -4 || decoderInputBuffer.f42140g < j3) && !(iN == -3 && jE == Long.MIN_VALUE && !decoderInputBuffer.f42139f))) {
                return iN;
            }
            decoderInputBuffer.f();
            decoderInputBuffer.n(4);
            this.f44561b = true;
            return -4;
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z2, long j3, long j4) {
        this.f44553a = mediaPeriod;
        this.f44556d = z2 ? j3 : -9223372036854775807L;
        this.f44557f = j3;
        this.f44558g = j4;
    }

    private SeekParameters d(long j3, SeekParameters seekParameters) {
        long jS = Util.s(seekParameters.f43301a, 0L, j3 - this.f44557f);
        long j4 = seekParameters.f43302b;
        long j5 = this.f44558g;
        long jS2 = Util.s(j4, 0L, j5 == Long.MIN_VALUE ? Long.MAX_VALUE : j5 - j3);
        return (jS == seekParameters.f43301a && jS2 == seekParameters.f43302b) ? seekParameters : new SeekParameters(jS, jS2);
    }

    private static long m(long j3, long j4, long j5) {
        long jMax = Math.max(j3, j4);
        return j5 != Long.MIN_VALUE ? Math.min(jMax, j5) : jMax;
    }

    private static boolean t(long j3, long j4, ExoTrackSelection[] exoTrackSelectionArr) {
        if (j3 < j4) {
            return true;
        }
        if (j3 != 0) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Format formatL = exoTrackSelection.l();
                    if (!MimeTypes.a(formatL.f40632o, formatL.f40628k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        return this.f44553a.a();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        return this.f44553a.b(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        long jC = this.f44553a.c();
        if (jC != Long.MIN_VALUE) {
            long j3 = this.f44558g;
            if (j3 == Long.MIN_VALUE || jC < j3) {
                return jC;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        long jE = this.f44553a.e();
        if (jE != Long.MIN_VALUE) {
            long j3 = this.f44558g;
            if (j3 == Long.MIN_VALUE || jE < j3) {
                return jE;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
        this.f44553a.f(j3);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void g(MediaPeriod mediaPeriod) {
        if (this.f44559h != null) {
            return;
        }
        ((MediaPeriod.Callback) Assertions.e(this.f44554b)).g(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long i(long j3, SeekParameters seekParameters) {
        long j4 = this.f44557f;
        if (j3 == j4) {
            return j4;
        }
        return this.f44553a.i(j3, d(j3, seekParameters));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long j(long j3) {
        this.f44556d = -9223372036854775807L;
        for (ClippingSampleStream clippingSampleStream : this.f44555c) {
            if (clippingSampleStream != null) {
                clippingSampleStream.a();
            }
        }
        return m(this.f44553a.j(j3), this.f44557f, this.f44558g);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        this.f44555c = new ClippingSampleStream[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i3 = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i3 >= sampleStreamArr.length) {
                break;
            }
            ClippingSampleStream[] clippingSampleStreamArr = this.f44555c;
            ClippingSampleStream clippingSampleStream = (ClippingSampleStream) sampleStreamArr[i3];
            clippingSampleStreamArr[i3] = clippingSampleStream;
            if (clippingSampleStream != null) {
                sampleStream = clippingSampleStream.f44560a;
            }
            sampleStreamArr2[i3] = sampleStream;
            i3++;
        }
        long jK = this.f44553a.k(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j3);
        long jM = m(jK, j3, this.f44558g);
        this.f44556d = (n() && t(jK, j3, exoTrackSelectionArr)) ? jM : -9223372036854775807L;
        for (int i4 = 0; i4 < sampleStreamArr.length; i4++) {
            SampleStream sampleStream2 = sampleStreamArr2[i4];
            if (sampleStream2 == null) {
                this.f44555c[i4] = null;
            } else {
                ClippingSampleStream[] clippingSampleStreamArr2 = this.f44555c;
                ClippingSampleStream clippingSampleStream2 = clippingSampleStreamArr2[i4];
                if (clippingSampleStream2 == null || clippingSampleStream2.f44560a != sampleStream2) {
                    clippingSampleStreamArr2[i4] = new ClippingSampleStream(sampleStream2);
                }
            }
            sampleStreamArr[i4] = this.f44555c[i4];
        }
        return jM;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long l() {
        if (n()) {
            long j3 = this.f44556d;
            this.f44556d = -9223372036854775807L;
            long jL = l();
            return jL != -9223372036854775807L ? jL : j3;
        }
        long jL2 = this.f44553a.l();
        if (jL2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return m(jL2, this.f44557f, this.f44558g);
    }

    boolean n() {
        return this.f44556d != -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void o() throws ClippingMediaSource.IllegalClippingException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f44559h;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.f44553a.o();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void h(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.e(this.f44554b)).h(this);
    }

    public void q(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.f44559h = illegalClippingException;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void r(MediaPeriod.Callback callback, long j3) {
        this.f44554b = callback;
        this.f44553a.r(this, j3);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray s() {
        return this.f44553a.s();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void u(long j3, boolean z2) {
        this.f44553a.u(j3, z2);
    }

    public void v(long j3, long j4) {
        this.f44557f = j3;
        this.f44558g = j4;
    }
}
