package androidx.media3.extractor.jpeg;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class JpegMotionPhotoExtractor implements Extractor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExtractorOutput f46389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f46390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46392e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MotionPhotoMetadata f46394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ExtractorInput f46395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private StartOffsetExtractorInput f46396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Mp4Extractor f46397j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f46388a = new ParsableByteArray(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f46393f = -1;

    private void b(ExtractorInput extractorInput) {
        this.f46388a.S(2);
        extractorInput.m(this.f46388a.e(), 0, 2);
        extractorInput.i(this.f46388a.P() - 2);
    }

    private void d() {
        ((ExtractorOutput) Assertions.e(this.f46389b)).q();
        this.f46389b.n(new SeekMap.Unseekable(-9223372036854775807L));
        this.f46390c = 6;
    }

    private static MotionPhotoMetadata e(String str, long j3) {
        MotionPhotoDescription motionPhotoDescriptionA;
        if (j3 == -1 || (motionPhotoDescriptionA = XmpMotionPhotoDescriptionParser.a(str)) == null) {
            return null;
        }
        return motionPhotoDescriptionA.a(j3);
    }

    private void f(MotionPhotoMetadata motionPhotoMetadata) {
        ((ExtractorOutput) Assertions.e(this.f46389b)).d(1024, 4).c(new Format.Builder().U("image/jpeg").n0(new Metadata(motionPhotoMetadata)).N());
    }

    private int k(ExtractorInput extractorInput) {
        this.f46388a.S(2);
        extractorInput.m(this.f46388a.e(), 0, 2);
        return this.f46388a.P();
    }

    private void l(ExtractorInput extractorInput) {
        this.f46388a.S(2);
        extractorInput.readFully(this.f46388a.e(), 0, 2);
        int iP = this.f46388a.P();
        this.f46391d = iP;
        if (iP == 65498) {
            if (this.f46393f != -1) {
                this.f46390c = 4;
                return;
            } else {
                d();
                return;
            }
        }
        if ((iP < 65488 || iP > 65497) && iP != 65281) {
            this.f46390c = 1;
        }
    }

    private void m(ExtractorInput extractorInput) {
        String strB;
        if (this.f46391d == 65505) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(this.f46392e);
            extractorInput.readFully(parsableByteArray.e(), 0, this.f46392e);
            if (this.f46394g == null && "http://ns.adobe.com/xap/1.0/".equals(parsableByteArray.B()) && (strB = parsableByteArray.B()) != null) {
                MotionPhotoMetadata motionPhotoMetadataE = e(strB, extractorInput.getLength());
                this.f46394g = motionPhotoMetadataE;
                if (motionPhotoMetadataE != null) {
                    this.f46393f = motionPhotoMetadataE.f46495d;
                }
            }
        } else {
            extractorInput.k(this.f46392e);
        }
        this.f46390c = 0;
    }

    private void n(ExtractorInput extractorInput) {
        this.f46388a.S(2);
        extractorInput.readFully(this.f46388a.e(), 0, 2);
        this.f46392e = this.f46388a.P() - 2;
        this.f46390c = 2;
    }

    private void o(ExtractorInput extractorInput) {
        if (!extractorInput.d(this.f46388a.e(), 0, 1, true)) {
            d();
            return;
        }
        extractorInput.f();
        if (this.f46397j == null) {
            this.f46397j = new Mp4Extractor(SubtitleParser.Factory.f46959a, 8);
        }
        StartOffsetExtractorInput startOffsetExtractorInput = new StartOffsetExtractorInput(extractorInput, this.f46393f);
        this.f46396i = startOffsetExtractorInput;
        if (!this.f46397j.g(startOffsetExtractorInput)) {
            d();
        } else {
            this.f46397j.h(new StartOffsetExtractorOutput(this.f46393f, (ExtractorOutput) Assertions.e(this.f46389b)));
            p();
        }
    }

    private void p() {
        f((MotionPhotoMetadata) Assertions.e(this.f46394g));
        this.f46390c = 5;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        if (j3 == 0) {
            this.f46390c = 0;
            this.f46397j = null;
        } else if (this.f46390c == 5) {
            ((Mp4Extractor) Assertions.e(this.f46397j)).a(j3, j4);
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        if (k(extractorInput) != 65496) {
            return false;
        }
        int iK = k(extractorInput);
        this.f46391d = iK;
        if (iK == 65504) {
            b(extractorInput);
            this.f46391d = k(extractorInput);
        }
        if (this.f46391d != 65505) {
            return false;
        }
        extractorInput.i(2);
        this.f46388a.S(6);
        extractorInput.m(this.f46388a.e(), 0, 6);
        return this.f46388a.J() == 1165519206 && this.f46388a.P() == 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46389b = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int i3 = this.f46390c;
        if (i3 == 0) {
            l(extractorInput);
            return 0;
        }
        if (i3 == 1) {
            n(extractorInput);
            return 0;
        }
        if (i3 == 2) {
            m(extractorInput);
            return 0;
        }
        if (i3 == 4) {
            long position = extractorInput.getPosition();
            long j3 = this.f46393f;
            if (position != j3) {
                positionHolder.f46210a = j3;
                return 1;
            }
            o(extractorInput);
            return 0;
        }
        if (i3 != 5) {
            if (i3 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f46396i == null || extractorInput != this.f46395h) {
            this.f46395h = extractorInput;
            this.f46396i = new StartOffsetExtractorInput(extractorInput, this.f46393f);
        }
        int iJ = ((Mp4Extractor) Assertions.e(this.f46397j)).j(this.f46396i, positionHolder);
        if (iJ == 1) {
            positionHolder.f46210a += this.f46393f;
        }
        return iJ;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
        Mp4Extractor mp4Extractor = this.f46397j;
        if (mp4Extractor != null) {
            mp4Extractor.release();
        }
    }
}
