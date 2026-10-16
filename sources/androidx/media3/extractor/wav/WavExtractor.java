package androidx.media3.extractor.wav;

import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.WavUtil;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.FacebookRequestErrorClassification;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WavExtractor implements Extractor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ExtractorsFactory f47752h = new ExtractorsFactory() { // from class: androidx.media3.extractor.wav.a
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return WavExtractor.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExtractorOutput f47753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TrackOutput f47754b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OutputWriter f47757e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f47755c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f47756d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f47758f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f47759g = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ImaAdPcmOutputWriter implements OutputWriter {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int[] f47760m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int[] f47761n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExtractorOutput f47762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TrackOutput f47763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WavFormat f47764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f47765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f47766e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ParsableByteArray f47767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f47768g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Format f47769h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f47770i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f47771j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f47772k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f47773l;

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat) throws ParserException {
            this.f47762a = extractorOutput;
            this.f47763b = trackOutput;
            this.f47764c = wavFormat;
            int iMax = Math.max(1, wavFormat.f47784c / 10);
            this.f47768g = iMax;
            ParsableByteArray parsableByteArray = new ParsableByteArray(wavFormat.f47788g);
            parsableByteArray.z();
            int iZ = parsableByteArray.z();
            this.f47765d = iZ;
            int i3 = wavFormat.f47783b;
            int i4 = (((wavFormat.f47786e - (i3 * 4)) * 8) / (wavFormat.f47787f * i3)) + 1;
            if (iZ == i4) {
                int iM = Util.m(iMax, iZ);
                this.f47766e = new byte[wavFormat.f47786e * iM];
                this.f47767f = new ParsableByteArray(iM * h(iZ, i3));
                int i5 = ((wavFormat.f47784c * wavFormat.f47786e) * 8) / iZ;
                this.f47769h = new Format.Builder().u0("audio/raw").Q(i5).p0(i5).k0(h(iMax, i3)).R(wavFormat.f47783b).v0(wavFormat.f47784c).o0(2).N();
                return;
            }
            throw ParserException.a("Expected frames per block: " + i4 + "; got: " + iZ, null);
        }

        private void d(byte[] bArr, int i3, ParsableByteArray parsableByteArray) {
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < this.f47764c.f47783b; i5++) {
                    e(bArr, i4, i5, parsableByteArray.e());
                }
            }
            int iG = g(this.f47765d * i3);
            parsableByteArray.W(0);
            parsableByteArray.V(iG);
        }

        private void e(byte[] bArr, int i3, int i4, byte[] bArr2) {
            WavFormat wavFormat = this.f47764c;
            int i5 = wavFormat.f47786e;
            int i6 = wavFormat.f47783b;
            int i7 = (i3 * i5) + (i4 * 4);
            int i8 = (i6 * 4) + i7;
            int i9 = (i5 / i6) - 4;
            int iR = (short) (((bArr[i7 + 1] & 255) << 8) | (bArr[i7] & 255));
            int iMin = Math.min(bArr[i7 + 2] & 255, 88);
            int i10 = f47761n[iMin];
            int i11 = ((i3 * this.f47765d * i6) + i4) * 2;
            bArr2[i11] = (byte) (iR & 255);
            bArr2[i11 + 1] = (byte) (iR >> 8);
            for (int i12 = 0; i12 < i9 * 2; i12++) {
                byte b3 = bArr[((i12 / 8) * i6 * 4) + i8 + ((i12 / 2) % 4)];
                int i13 = i12 % 2 == 0 ? b3 & Ascii.SI : (b3 & 255) >> 4;
                int i14 = ((((i13 & 7) * 2) + 1) * i10) >> 3;
                if ((i13 & 8) != 0) {
                    i14 = -i14;
                }
                iR = Util.r(iR + i14, -32768, 32767);
                i11 += i6 * 2;
                bArr2[i11] = (byte) (iR & 255);
                bArr2[i11 + 1] = (byte) (iR >> 8);
                int i15 = iMin + f47760m[i13];
                int[] iArr = f47761n;
                iMin = Util.r(i15, 0, iArr.length - 1);
                i10 = iArr[iMin];
            }
        }

        private int f(int i3) {
            return i3 / (this.f47764c.f47783b * 2);
        }

        private int g(int i3) {
            return h(i3, this.f47764c.f47783b);
        }

        private static int h(int i3, int i4) {
            return i3 * 2 * i4;
        }

        private void i(int i3) {
            long jZ0 = this.f47771j + Util.Z0(this.f47773l, 1000000L, this.f47764c.f47784c);
            int iG = g(i3);
            this.f47763b.g(jZ0, 1, iG, this.f47772k - iG, null);
            this.f47773l += (long) i3;
            this.f47772k -= iG;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0035 -> B:4:0x001b). Please report as a decompilation issue!!! */
        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(androidx.media3.extractor.ExtractorInput r7, long r8) {
            /*
                r6 = this;
                int r0 = r6.f47768g
                int r1 = r6.f47772k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f47765d
                int r0 = androidx.media3.common.util.Util.m(r0, r1)
                androidx.media3.extractor.wav.WavFormat r1 = r6.f47764c
                int r1 = r1.f47786e
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r2 = 1
                if (r1 != 0) goto L1d
            L1b:
                r1 = r2
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L3e
                int r3 = r6.f47770i
                if (r3 >= r0) goto L3e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.f47766e
                int r5 = r6.f47770i
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L38
                goto L1b
            L38:
                int r4 = r6.f47770i
                int r4 = r4 + r3
                r6.f47770i = r4
                goto L1e
            L3e:
                int r7 = r6.f47770i
                androidx.media3.extractor.wav.WavFormat r8 = r6.f47764c
                int r8 = r8.f47786e
                int r7 = r7 / r8
                if (r7 <= 0) goto L75
                byte[] r8 = r6.f47766e
                androidx.media3.common.util.ParsableByteArray r9 = r6.f47767f
                r6.d(r8, r7, r9)
                int r8 = r6.f47770i
                androidx.media3.extractor.wav.WavFormat r9 = r6.f47764c
                int r9 = r9.f47786e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f47770i = r8
                androidx.media3.common.util.ParsableByteArray r7 = r6.f47767f
                int r7 = r7.g()
                androidx.media3.extractor.TrackOutput r8 = r6.f47763b
                androidx.media3.common.util.ParsableByteArray r9 = r6.f47767f
                r8.b(r9, r7)
                int r8 = r6.f47772k
                int r8 = r8 + r7
                r6.f47772k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f47768g
                if (r7 < r8) goto L75
                r6.i(r8)
            L75:
                if (r1 == 0) goto L82
                int r7 = r6.f47772k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L82
                r6.i(r7)
            L82:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.wav.WavExtractor.ImaAdPcmOutputWriter.a(androidx.media3.extractor.ExtractorInput, long):boolean");
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public void b(int i3, long j3) {
            WavSeekMap wavSeekMap = new WavSeekMap(this.f47764c, this.f47765d, i3, j3);
            this.f47762a.n(wavSeekMap);
            this.f47763b.c(this.f47769h);
            this.f47763b.e(wavSeekMap.l());
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public void c(long j3) {
            this.f47770i = 0;
            this.f47771j = j3;
            this.f47772k = 0;
            this.f47773l = 0L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface OutputWriter {
        boolean a(ExtractorInput extractorInput, long j3);

        void b(int i3, long j3);

        void c(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PassthroughOutputWriter implements OutputWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExtractorOutput f47774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TrackOutput f47775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WavFormat f47776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Format f47777d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f47778e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f47779f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47780g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f47781h;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat, String str, int i3) throws ParserException {
            this.f47774a = extractorOutput;
            this.f47775b = trackOutput;
            this.f47776c = wavFormat;
            int i4 = (wavFormat.f47783b * wavFormat.f47787f) / 8;
            if (wavFormat.f47786e == i4) {
                int i5 = wavFormat.f47784c;
                int i6 = i5 * i4 * 8;
                int iMax = Math.max(i4, (i5 * i4) / 10);
                this.f47778e = iMax;
                this.f47777d = new Format.Builder().U("audio/wav").u0(str).Q(i6).p0(i6).k0(iMax).R(wavFormat.f47783b).v0(wavFormat.f47784c).o0(i3).N();
                return;
            }
            throw ParserException.a("Expected block size: " + i4 + "; got: " + wavFormat.f47786e, null);
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public boolean a(ExtractorInput extractorInput, long j3) {
            int i3;
            int i4;
            long j4 = j3;
            while (j4 > 0 && (i3 = this.f47780g) < (i4 = this.f47778e)) {
                int iD = this.f47775b.d(extractorInput, (int) Math.min(i4 - i3, j4), true);
                if (iD == -1) {
                    j4 = 0;
                } else {
                    this.f47780g += iD;
                    j4 -= (long) iD;
                }
            }
            int i5 = this.f47776c.f47786e;
            int i6 = this.f47780g / i5;
            if (i6 > 0) {
                long jZ0 = this.f47779f + Util.Z0(this.f47781h, 1000000L, r1.f47784c);
                int i7 = i6 * i5;
                int i8 = this.f47780g - i7;
                this.f47775b.g(jZ0, 1, i7, i8, null);
                this.f47781h += (long) i6;
                this.f47780g = i8;
            }
            return j4 <= 0;
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public void b(int i3, long j3) {
            WavSeekMap wavSeekMap = new WavSeekMap(this.f47776c, 1, i3, j3);
            this.f47774a.n(wavSeekMap);
            this.f47775b.c(this.f47777d);
            this.f47775b.e(wavSeekMap.l());
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public void c(long j3) {
            this.f47779f = j3;
            this.f47780g = 0;
            this.f47781h = 0L;
        }
    }

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new WavExtractor()};
    }

    private void d() {
        Assertions.i(this.f47754b);
        Util.k(this.f47753a);
    }

    private void e(ExtractorInput extractorInput) throws ParserException {
        Assertions.g(extractorInput.getPosition() == 0);
        int i3 = this.f47758f;
        if (i3 != -1) {
            extractorInput.k(i3);
            this.f47755c = 4;
        } else {
            if (!WavHeaderReader.a(extractorInput)) {
                throw ParserException.a("Unsupported or unrecognized wav file type.", null);
            }
            extractorInput.k((int) (extractorInput.h() - extractorInput.getPosition()));
            this.f47755c = 1;
        }
    }

    private void f(ExtractorInput extractorInput) throws ParserException {
        WavFormat wavFormatB = WavHeaderReader.b(extractorInput);
        int i3 = wavFormatB.f47782a;
        if (i3 == 17) {
            this.f47757e = new ImaAdPcmOutputWriter(this.f47753a, this.f47754b, wavFormatB);
        } else if (i3 == 6) {
            this.f47757e = new PassthroughOutputWriter(this.f47753a, this.f47754b, wavFormatB, "audio/g711-alaw", -1);
        } else if (i3 == 7) {
            this.f47757e = new PassthroughOutputWriter(this.f47753a, this.f47754b, wavFormatB, "audio/g711-mlaw", -1);
        } else {
            int iA = WavUtil.a(i3, wavFormatB.f47787f);
            if (iA == 0) {
                throw ParserException.c("Unsupported WAV format type: " + wavFormatB.f47782a);
            }
            this.f47757e = new PassthroughOutputWriter(this.f47753a, this.f47754b, wavFormatB, "audio/raw", iA);
        }
        this.f47755c = 3;
    }

    private void k(ExtractorInput extractorInput) {
        this.f47756d = WavHeaderReader.c(extractorInput);
        this.f47755c = 2;
    }

    private int l(ExtractorInput extractorInput) {
        Assertions.g(this.f47759g != -1);
        return ((OutputWriter) Assertions.e(this.f47757e)).a(extractorInput, this.f47759g - extractorInput.getPosition()) ? -1 : 0;
    }

    private void m(ExtractorInput extractorInput) throws ParserException {
        Pair pairE = WavHeaderReader.e(extractorInput);
        this.f47758f = ((Long) pairE.first).intValue();
        long jLongValue = ((Long) pairE.second).longValue();
        long j3 = this.f47756d;
        if (j3 != -1 && jLongValue == 4294967295L) {
            jLongValue = j3;
        }
        this.f47759g = ((long) this.f47758f) + jLongValue;
        long length = extractorInput.getLength();
        if (length != -1 && this.f47759g > length) {
            Log.i("WavExtractor", "Data exceeds input length: " + this.f47759g + ", " + length);
            this.f47759g = length;
        }
        ((OutputWriter) Assertions.e(this.f47757e)).b(this.f47758f, this.f47759g);
        this.f47755c = 4;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f47755c = j3 == 0 ? 0 : 4;
        OutputWriter outputWriter = this.f47757e;
        if (outputWriter != null) {
            outputWriter.c(j4);
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        return WavHeaderReader.a(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f47753a = extractorOutput;
        this.f47754b = extractorOutput.d(0, 1);
        extractorOutput.q();
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        d();
        int i3 = this.f47755c;
        if (i3 == 0) {
            e(extractorInput);
            return 0;
        }
        if (i3 == 1) {
            k(extractorInput);
            return 0;
        }
        if (i3 == 2) {
            f(extractorInput);
            return 0;
        }
        if (i3 == 3) {
            m(extractorInput);
            return 0;
        }
        if (i3 == 4) {
            return l(extractorInput);
        }
        throw new IllegalStateException();
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
