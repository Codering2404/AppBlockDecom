package androidx.media3.transformer;

import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.primitives.Floats;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SpeedProviderMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaPeriod f48447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SpeedProviderMapper f48448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaPeriod.Callback f48449c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SpeedProviderMapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f48450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f48451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f48452c;

        public SpeedProviderMapper(SpeedProvider speedProvider) {
            LongArray longArray = new LongArray();
            LongArray longArray2 = new LongArray();
            ArrayList arrayList = new ArrayList();
            float fA = speedProvider.a(0L);
            longArray.a(0L);
            longArray2.a(0L);
            arrayList.add(Float.valueOf(fA));
            float fA2 = fA;
            long jB = speedProvider.b(0L);
            long j3 = 0;
            long j4 = 0;
            while (true) {
                long j5 = jB;
                if (j5 == -9223372036854775807L) {
                    this.f48450a = longArray.e();
                    this.f48451b = longArray2.e();
                    this.f48452c = Floats.f(arrayList);
                    return;
                } else {
                    j3 += (long) ((j5 - j4) / fA2);
                    fA2 = speedProvider.a(j5);
                    longArray.a(j3);
                    longArray2.a(j5);
                    arrayList.add(Float.valueOf(fA2));
                    jB = speedProvider.b(j5);
                    j4 = j5;
                }
            }
        }

        public long a(long j3) {
            return (long) (this.f48450a[r0] + ((j3 - this.f48451b[r0]) / this.f48452c[Util.j(this.f48451b, j3, true, true)]));
        }

        public long b(long j3) {
            return (long) (this.f48451b[r0] + ((j3 - this.f48450a[r0]) * this.f48452c[Util.j(this.f48450a, j3, true, true)]));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SpeedProviderMapperSampleStream implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SampleStream f48453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SpeedProviderMapper f48454b;

        public SpeedProviderMapperSampleStream(SampleStream sampleStream, SpeedProviderMapper speedProviderMapper) {
            this.f48453a = sampleStream;
            this.f48454b = speedProviderMapper;
        }

        public SampleStream a() {
            return this.f48453a;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void d() {
            this.f48453a.d();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int h(long j3) {
            return this.f48453a.h(this.f48454b.b(j3));
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return this.f48453a.isReady();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            int iN = this.f48453a.n(formatHolder, decoderInputBuffer, i3);
            if (iN == -4) {
                decoderInputBuffer.f42140g = this.f48454b.a(decoderInputBuffer.f42140g);
            }
            return iN;
        }
    }

    public SpeedProviderMediaPeriod(MediaPeriod mediaPeriod, SpeedProvider speedProvider) {
        this.f48447a = mediaPeriod;
        this.f48448b = new SpeedProviderMapper(speedProvider);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        return this.f48447a.a();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        return this.f48447a.b(loadingInfo.a().f(this.f48448b.b(loadingInfo.f43121a)).d());
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        long jC = this.f48447a.c();
        if (jC == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f48448b.a(jC);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void h(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.e(this.f48449c)).h(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        long jE = this.f48447a.e();
        if (jE == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f48448b.a(jE);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
        this.f48447a.f(this.f48448b.b(j3));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void g(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.e(this.f48449c)).g(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long i(long j3, SeekParameters seekParameters) {
        SpeedProviderMapper speedProviderMapper = this.f48448b;
        return speedProviderMapper.a(this.f48447a.i(speedProviderMapper.b(j3), seekParameters));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long j(long j3) {
        SpeedProviderMapper speedProviderMapper = this.f48448b;
        return speedProviderMapper.a(this.f48447a.j(speedProviderMapper.b(j3)));
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
            SpeedProviderMapperSampleStream speedProviderMapperSampleStream = (SpeedProviderMapperSampleStream) sampleStreamArr[i3];
            if (speedProviderMapperSampleStream != null) {
                sampleStreamA = speedProviderMapperSampleStream.a();
            }
            sampleStreamArr2[i3] = sampleStreamA;
            i3++;
        }
        long jK = this.f48447a.k(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, this.f48448b.b(j3));
        for (int i4 = 0; i4 < sampleStreamArr.length; i4++) {
            SampleStream sampleStream = sampleStreamArr2[i4];
            if (sampleStream == null) {
                sampleStreamArr[i4] = null;
            } else {
                SampleStream sampleStream2 = sampleStreamArr[i4];
                if (sampleStream2 == null || ((SpeedProviderMapperSampleStream) sampleStream2).a() != sampleStream) {
                    sampleStreamArr[i4] = new SpeedProviderMapperSampleStream(sampleStream, this.f48448b);
                }
            }
        }
        return this.f48448b.a(jK);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long l() {
        long jL = this.f48447a.l();
        if (jL == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f48448b.a(jL);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void o() {
        this.f48447a.o();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void r(MediaPeriod.Callback callback, long j3) {
        this.f48449c = callback;
        this.f48447a.r(this, this.f48448b.b(j3));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray s() {
        return this.f48447a.s();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void u(long j3, boolean z2) {
        this.f48447a.u(this.f48448b.b(j3), z2);
    }
}
