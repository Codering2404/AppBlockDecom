package androidx.media3.extractor.flv;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.flv.TagPayloadReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class VideoTagPayloadReader extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f46379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f46380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f46382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f46383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46384g;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        this.f46379b = new ParsableByteArray(NalUnitUtil.f41674a);
        this.f46380c = new ParsableByteArray(4);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int iH = parsableByteArray.H();
        int i3 = (iH >> 4) & 15;
        int i4 = iH & 15;
        if (i4 == 7) {
            this.f46384g = i3;
            return i3 != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i4);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean c(ParsableByteArray parsableByteArray, long j3) throws ParserException {
        int iH = parsableByteArray.H();
        long jR = j3 + (((long) parsableByteArray.r()) * 1000);
        if (iH == 0 && !this.f46382e) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.a()]);
            parsableByteArray.l(parsableByteArray2.e(), 0, parsableByteArray.a());
            AvcConfig avcConfigB = AvcConfig.b(parsableByteArray2);
            this.f46381d = avcConfigB.f46053b;
            this.f46378a.c(new Format.Builder().U("video/x-flv").u0("video/avc").S(avcConfigB.f46063l).B0(avcConfigB.f46054c).d0(avcConfigB.f46055d).q0(avcConfigB.f46062k).g0(avcConfigB.f46052a).N());
            this.f46382e = true;
            return false;
        }
        if (iH != 1 || !this.f46382e) {
            return false;
        }
        int i3 = this.f46384g == 1 ? 1 : 0;
        if (!this.f46383f && i3 == 0) {
            return false;
        }
        byte[] bArrE = this.f46380c.e();
        bArrE[0] = 0;
        bArrE[1] = 0;
        bArrE[2] = 0;
        int i4 = 4 - this.f46381d;
        int i5 = 0;
        while (parsableByteArray.a() > 0) {
            parsableByteArray.l(this.f46380c.e(), i4, this.f46381d);
            this.f46380c.W(0);
            int iL = this.f46380c.L();
            this.f46379b.W(0);
            this.f46378a.b(this.f46379b, 4);
            this.f46378a.b(parsableByteArray, iL);
            i5 = i5 + 4 + iL;
        }
        this.f46378a.g(jR, i3, i5, 0, null);
        this.f46383f = true;
        return true;
    }
}
