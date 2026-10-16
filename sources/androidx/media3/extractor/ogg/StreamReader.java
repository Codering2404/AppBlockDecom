package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
abstract class StreamReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TrackOutput f46909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExtractorOutput f46910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OggSeeker f46911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f46912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f46913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f46914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46916i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f46918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f46919l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f46920m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OggPacket f46908a = new OggPacket();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SetupData f46917j = new SetupData();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SetupData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Format f46921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        OggSeeker f46922b;

        SetupData() {
        }
    }

    private void a() {
        Assertions.i(this.f46909b);
        Util.k(this.f46910c);
    }

    private boolean i(ExtractorInput extractorInput) {
        while (this.f46908a.d(extractorInput)) {
            this.f46918k = extractorInput.getPosition() - this.f46913f;
            if (!h(this.f46908a.c(), this.f46913f, this.f46917j)) {
                return true;
            }
            this.f46913f = extractorInput.getPosition();
        }
        this.f46915h = 3;
        return false;
    }

    private int j(ExtractorInput extractorInput) {
        if (!i(extractorInput)) {
            return -1;
        }
        Format format = this.f46917j.f46921a;
        this.f46916i = format.F;
        if (!this.f46920m) {
            this.f46909b.c(format);
            this.f46920m = true;
        }
        OggSeeker oggSeeker = this.f46917j.f46922b;
        if (oggSeeker != null) {
            this.f46911d = oggSeeker;
        } else if (extractorInput.getLength() == -1) {
            this.f46911d = new UnseekableOggSeeker();
        } else {
            OggPageHeader oggPageHeaderB = this.f46908a.b();
            this.f46911d = new DefaultOggSeeker(this, this.f46913f, extractorInput.getLength(), oggPageHeaderB.f46901h + oggPageHeaderB.f46902i, oggPageHeaderB.f46896c, (oggPageHeaderB.f46895b & 4) != 0);
        }
        this.f46915h = 2;
        this.f46908a.f();
        return 0;
    }

    private int k(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long jA = this.f46911d.a(extractorInput);
        if (jA >= 0) {
            positionHolder.f46210a = jA;
            return 1;
        }
        if (jA < -1) {
            e(-(jA + 2));
        }
        if (!this.f46919l) {
            SeekMap seekMap = (SeekMap) Assertions.i(this.f46911d.b());
            this.f46910c.n(seekMap);
            this.f46909b.e(seekMap.l());
            this.f46919l = true;
        }
        if (this.f46918k <= 0 && !this.f46908a.d(extractorInput)) {
            this.f46915h = 3;
            return -1;
        }
        this.f46918k = 0L;
        ParsableByteArray parsableByteArrayC = this.f46908a.c();
        long jF = f(parsableByteArrayC);
        if (jF >= 0) {
            long j3 = this.f46914g;
            if (j3 + jF >= this.f46912e) {
                long jB = b(j3);
                this.f46909b.b(parsableByteArrayC, parsableByteArrayC.g());
                this.f46909b.g(jB, 1, parsableByteArrayC.g(), 0, null);
                this.f46912e = -1L;
            }
        }
        this.f46914g += jF;
        return 0;
    }

    protected long b(long j3) {
        return (j3 * 1000000) / ((long) this.f46916i);
    }

    protected long c(long j3) {
        return (((long) this.f46916i) * j3) / 1000000;
    }

    void d(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.f46910c = extractorOutput;
        this.f46909b = trackOutput;
        l(true);
    }

    protected void e(long j3) {
        this.f46914g = j3;
    }

    protected abstract long f(ParsableByteArray parsableByteArray);

    final int g(ExtractorInput extractorInput, PositionHolder positionHolder) {
        a();
        int i3 = this.f46915h;
        if (i3 == 0) {
            return j(extractorInput);
        }
        if (i3 == 1) {
            extractorInput.k((int) this.f46913f);
            this.f46915h = 2;
            return 0;
        }
        if (i3 == 2) {
            Util.k(this.f46911d);
            return k(extractorInput, positionHolder);
        }
        if (i3 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    protected abstract boolean h(ParsableByteArray parsableByteArray, long j3, SetupData setupData);

    protected void l(boolean z2) {
        if (z2) {
            this.f46917j = new SetupData();
            this.f46913f = 0L;
            this.f46915h = 0;
        } else {
            this.f46915h = 1;
        }
        this.f46912e = -1L;
        this.f46914g = 0L;
    }

    final void m(long j3, long j4) {
        this.f46908a.e();
        if (j3 == 0) {
            l(!this.f46919l);
        } else if (this.f46915h != 0) {
            this.f46912e = c(j4);
            ((OggSeeker) Util.k(this.f46911d)).c(this.f46912e);
            this.f46915h = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnseekableOggSeeker implements OggSeeker {
        private UnseekableOggSeeker() {
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public long a(ExtractorInput extractorInput) {
            return -1L;
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public SeekMap b() {
            return new SeekMap.Unseekable(-9223372036854775807L);
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public void c(long j3) {
        }
    }
}
