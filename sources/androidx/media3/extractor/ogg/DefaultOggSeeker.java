package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class DefaultOggSeeker implements OggSeeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OggPageHeader f46866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f46867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f46868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreamReader f46869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f46871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f46872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f46873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f46874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f46875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f46876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f46877l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        @Override // androidx.media3.extractor.SeekMap
        public SeekMap.SeekPoints b(long j3) {
            return new SeekMap.SeekPoints(new SeekPoint(j3, Util.s((DefaultOggSeeker.this.f46867b + BigInteger.valueOf(DefaultOggSeeker.this.f46869d.c(j3)).multiply(BigInteger.valueOf(DefaultOggSeeker.this.f46868c - DefaultOggSeeker.this.f46867b)).divide(BigInteger.valueOf(DefaultOggSeeker.this.f46871f)).longValue()) - 30000, DefaultOggSeeker.this.f46867b, DefaultOggSeeker.this.f46868c - 1)));
        }

        @Override // androidx.media3.extractor.SeekMap
        public boolean e() {
            return true;
        }

        @Override // androidx.media3.extractor.SeekMap
        public long l() {
            return DefaultOggSeeker.this.f46869d.b(DefaultOggSeeker.this.f46871f);
        }
    }

    public DefaultOggSeeker(StreamReader streamReader, long j3, long j4, long j5, long j6, boolean z2) {
        Assertions.a(j3 >= 0 && j4 > j3);
        this.f46869d = streamReader;
        this.f46867b = j3;
        this.f46868c = j4;
        if (j5 == j4 - j3 || z2) {
            this.f46871f = j6;
            this.f46870e = 4;
        } else {
            this.f46870e = 0;
        }
        this.f46866a = new OggPageHeader();
    }

    private long i(ExtractorInput extractorInput) throws IOException {
        if (this.f46874i == this.f46875j) {
            return -1L;
        }
        long position = extractorInput.getPosition();
        if (!this.f46866a.d(extractorInput, this.f46875j)) {
            long j3 = this.f46874i;
            if (j3 != position) {
                return j3;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f46866a.a(extractorInput, false);
        extractorInput.f();
        long j4 = this.f46873h;
        OggPageHeader oggPageHeader = this.f46866a;
        long j5 = oggPageHeader.f46896c;
        long j6 = j4 - j5;
        int i3 = oggPageHeader.f46901h + oggPageHeader.f46902i;
        if (0 <= j6 && j6 < 72000) {
            return -1L;
        }
        if (j6 < 0) {
            this.f46875j = position;
            this.f46877l = j5;
        } else {
            this.f46874i = extractorInput.getPosition() + ((long) i3);
            this.f46876k = this.f46866a.f46896c;
        }
        long j7 = this.f46875j;
        long j8 = this.f46874i;
        if (j7 - j8 < 100000) {
            this.f46875j = j8;
            return j8;
        }
        long position2 = extractorInput.getPosition() - (((long) i3) * (j6 <= 0 ? 2L : 1L));
        long j9 = this.f46875j;
        long j10 = this.f46874i;
        return Util.s(position2 + ((j6 * (j9 - j10)) / (this.f46877l - this.f46876k)), j10, j9 - 1);
    }

    private void k(ExtractorInput extractorInput) throws ParserException {
        while (true) {
            this.f46866a.c(extractorInput);
            this.f46866a.a(extractorInput, false);
            OggPageHeader oggPageHeader = this.f46866a;
            if (oggPageHeader.f46896c > this.f46873h) {
                extractorInput.f();
                return;
            } else {
                extractorInput.k(oggPageHeader.f46901h + oggPageHeader.f46902i);
                this.f46874i = extractorInput.getPosition();
                this.f46876k = this.f46866a.f46896c;
            }
        }
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public long a(ExtractorInput extractorInput) throws IOException {
        int i3 = this.f46870e;
        if (i3 == 0) {
            long position = extractorInput.getPosition();
            this.f46872g = position;
            this.f46870e = 1;
            long j3 = this.f46868c - 65307;
            if (j3 > position) {
                return j3;
            }
        } else if (i3 != 1) {
            if (i3 == 2) {
                long jI = i(extractorInput);
                if (jI != -1) {
                    return jI;
                }
                this.f46870e = 3;
            } else if (i3 != 3) {
                if (i3 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            k(extractorInput);
            this.f46870e = 4;
            return -(this.f46876k + 2);
        }
        this.f46871f = j(extractorInput);
        this.f46870e = 4;
        return this.f46872g;
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public void c(long j3) {
        this.f46873h = Util.s(j3, 0L, this.f46871f - 1);
        this.f46870e = 2;
        this.f46874i = this.f46867b;
        this.f46875j = this.f46868c;
        this.f46876k = 0L;
        this.f46877l = this.f46871f;
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public OggSeekMap b() {
        if (this.f46871f != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    long j(ExtractorInput extractorInput) throws ParserException, EOFException {
        this.f46866a.b();
        if (!this.f46866a.c(extractorInput)) {
            throw new EOFException();
        }
        this.f46866a.a(extractorInput, false);
        OggPageHeader oggPageHeader = this.f46866a;
        extractorInput.k(oggPageHeader.f46901h + oggPageHeader.f46902i);
        long j3 = this.f46866a.f46896c;
        while (true) {
            OggPageHeader oggPageHeader2 = this.f46866a;
            if ((oggPageHeader2.f46895b & 4) == 4 || !oggPageHeader2.c(extractorInput) || extractorInput.getPosition() >= this.f46868c || !this.f46866a.a(extractorInput, true)) {
                break;
            }
            OggPageHeader oggPageHeader3 = this.f46866a;
            if (!ExtractorUtil.e(extractorInput, oggPageHeader3.f46901h + oggPageHeader3.f46902i)) {
                break;
            }
            j3 = this.f46866a.f46896c;
        }
        return j3;
    }
}
