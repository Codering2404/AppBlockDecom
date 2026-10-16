package androidx.media3.extractor.mp3;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.Id3Peeker;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.extractor.mp3.Seeker;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp3Extractor implements Extractor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ExtractorsFactory f46634v = new ExtractorsFactory() { // from class: androidx.media3.extractor.mp3.a
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return Mp3Extractor.b();
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Id3Decoder.FramePredicate f46635w = new Id3Decoder.FramePredicate() { // from class: androidx.media3.extractor.mp3.b
        @Override // androidx.media3.extractor.metadata.id3.Id3Decoder.FramePredicate
        public final boolean a(int i3, int i4, int i5, int i6, int i7) {
            return Mp3Extractor.d(i3, i4, i5, i6, i7);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f46636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f46637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f46638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MpegAudioUtil.Header f46639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final GaplessInfoHolder f46640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Id3Peeker f46641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TrackOutput f46642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ExtractorOutput f46643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TrackOutput f46644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TrackOutput f46645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f46646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Metadata f46647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f46648m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f46649n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f46650o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f46651p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f46652q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Seeker f46653r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f46654s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f46655t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f46656u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public Mp3Extractor() {
        this(0);
    }

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new Mp3Extractor()};
    }

    public static /* synthetic */ boolean d(int i3, int i4, int i5, int i6, int i7) {
        if (i4 == 67 && i5 == 79 && i6 == 77 && (i7 == 77 || i3 == 2)) {
            return true;
        }
        if (i4 == 77 && i5 == 76 && i6 == 76) {
            return i7 == 84 || i3 == 2;
        }
        return false;
    }

    private void e() {
        Assertions.i(this.f46644i);
        Util.k(this.f46643h);
    }

    private Seeker f(ExtractorInput extractorInput) {
        long jO;
        long jD;
        Seeker seekerS = s(extractorInput);
        MlltSeeker mlltSeekerR = r(this.f46647l, extractorInput.getPosition());
        if (this.f46654s) {
            return new Seeker.UnseekableSeeker();
        }
        if ((this.f46636a & 4) != 0) {
            if (mlltSeekerR != null) {
                jO = mlltSeekerR.l();
                jD = mlltSeekerR.d();
            } else if (seekerS != null) {
                jO = seekerS.l();
                jD = seekerS.d();
            } else {
                jO = o(this.f46647l);
                jD = -1;
            }
            seekerS = new IndexSeeker(jO, extractorInput.getPosition(), jD);
        } else if (mlltSeekerR != null) {
            seekerS = mlltSeekerR;
        } else if (seekerS == null) {
            seekerS = null;
        }
        if (seekerS == null || (!seekerS.e() && (this.f46636a & 1) != 0)) {
            seekerS = n(extractorInput, (this.f46636a & 2) != 0);
        }
        if (seekerS != null) {
            this.f46644i.e(seekerS.l());
        }
        return seekerS;
    }

    private long k(long j3) {
        return this.f46648m + ((j3 * 1000000) / ((long) this.f46639d.f46206d));
    }

    private Seeker m(long j3, XingFrame xingFrame, long j4) {
        long j5;
        long j6;
        long jA = xingFrame.a();
        if (jA == -9223372036854775807L) {
            return null;
        }
        long j7 = xingFrame.f46664c;
        if (j7 != -1) {
            long j8 = j3 + j7;
            j5 = j7 - ((long) xingFrame.f46662a.f46205c);
            j6 = j8;
        } else {
            if (j4 == -1) {
                return null;
            }
            j5 = (j4 - j3) - ((long) xingFrame.f46662a.f46205c);
            j6 = j4;
        }
        long j9 = j5;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        return new ConstantBitrateSeeker(j6, j3 + ((long) xingFrame.f46662a.f46205c), Ints.d(Util.b1(j9, 8000000L, jA, roundingMode)), Ints.d(LongMath.b(j9, xingFrame.f46663b, roundingMode)), false);
    }

    private Seeker n(ExtractorInput extractorInput, boolean z2) {
        extractorInput.m(this.f46638c.e(), 0, 4);
        this.f46638c.W(0);
        this.f46639d.a(this.f46638c.q());
        return new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.f46639d, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static long o(Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int iE = metadata.e();
        for (int i3 = 0; i3 < iE; i3++) {
            Metadata.Entry entryD = metadata.d(i3);
            if (entryD instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entryD;
                if (textInformationFrame.f46475a.equals("TLEN")) {
                    return Util.P0(Long.parseLong((String) textInformationFrame.f46489d.get(0)));
                }
            }
        }
        return -9223372036854775807L;
    }

    private static int p(ParsableByteArray parsableByteArray, int i3) {
        if (parsableByteArray.g() >= i3 + 4) {
            parsableByteArray.W(i3);
            int iQ = parsableByteArray.q();
            if (iQ == 1483304551 || iQ == 1231971951) {
                return iQ;
            }
        }
        if (parsableByteArray.g() < 40) {
            return 0;
        }
        parsableByteArray.W(36);
        return parsableByteArray.q() == 1447187017 ? 1447187017 : 0;
    }

    private static boolean q(int i3, long j3) {
        return ((long) (i3 & (-128000))) == (j3 & (-128000));
    }

    private static MlltSeeker r(Metadata metadata, long j3) {
        if (metadata == null) {
            return null;
        }
        int iE = metadata.e();
        for (int i3 = 0; i3 < iE; i3++) {
            Metadata.Entry entryD = metadata.d(i3);
            if (entryD instanceof MlltFrame) {
                return MlltSeeker.a(j3, (MlltFrame) entryD, o(metadata));
            }
        }
        return null;
    }

    private Seeker s(ExtractorInput extractorInput) {
        int i3;
        int i4;
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f46639d.f46205c);
        extractorInput.m(parsableByteArray.e(), 0, this.f46639d.f46205c);
        MpegAudioUtil.Header header = this.f46639d;
        int i5 = 21;
        if ((header.f46203a & 1) != 0) {
            if (header.f46207e != 1) {
                i5 = 36;
            }
        } else if (header.f46207e == 1) {
            i5 = 13;
        }
        int iP = p(parsableByteArray, i5);
        if (iP != 1231971951) {
            if (iP == 1447187017) {
                VbriSeeker vbriSeekerA = VbriSeeker.a(extractorInput.getLength(), extractorInput.getPosition(), this.f46639d, parsableByteArray);
                extractorInput.k(this.f46639d.f46205c);
                return vbriSeekerA;
            }
            if (iP != 1483304551) {
                extractorInput.f();
                return null;
            }
        }
        XingFrame xingFrameB = XingFrame.b(this.f46639d, parsableByteArray);
        if (!this.f46640e.a() && (i3 = xingFrameB.f46665d) != -1 && (i4 = xingFrameB.f46666e) != -1) {
            GaplessInfoHolder gaplessInfoHolder = this.f46640e;
            gaplessInfoHolder.f46175a = i3;
            gaplessInfoHolder.f46176b = i4;
        }
        long position = extractorInput.getPosition();
        if (extractorInput.getLength() != -1 && xingFrameB.f46664c != -1 && extractorInput.getLength() != xingFrameB.f46664c + position) {
            Log.g("Mp3Extractor", "Data size mismatch between stream (" + extractorInput.getLength() + ") and Xing frame (" + (xingFrameB.f46664c + position) + "), using Xing value.");
        }
        extractorInput.k(this.f46639d.f46205c);
        return iP == 1483304551 ? XingSeeker.a(xingFrameB, position) : m(position, xingFrameB, extractorInput.getLength());
    }

    private void t() {
        Seeker seeker = this.f46653r;
        if ((seeker instanceof ConstantBitrateSeeker) && seeker.e()) {
            long j3 = this.f46651p;
            if (j3 == -1 || j3 == this.f46653r.d()) {
                return;
            }
            this.f46653r = ((ConstantBitrateSeeker) this.f46653r).h(this.f46651p);
            ((ExtractorOutput) Assertions.e(this.f46643h)).n(this.f46653r);
            ((TrackOutput) Assertions.e(this.f46644i)).e(this.f46653r.l());
        }
    }

    private boolean u(ExtractorInput extractorInput) {
        Seeker seeker = this.f46653r;
        if (seeker != null) {
            long jD = seeker.d();
            if (jD != -1 && extractorInput.h() > jD - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.d(this.f46638c.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private int v(ExtractorInput extractorInput) throws Throwable {
        if (this.f46646k == 0) {
            try {
                x(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.f46653r == null) {
            Seeker seekerF = f(extractorInput);
            this.f46653r = seekerF;
            this.f46643h.n(seekerF);
            Format.Builder builderN0 = new Format.Builder().U("audio/mpeg").u0(this.f46639d.f46204b).k0(4096).R(this.f46639d.f46207e).v0(this.f46639d.f46206d).Z(this.f46640e.f46175a).a0(this.f46640e.f46176b).n0((this.f46636a & 8) != 0 ? null : this.f46647l);
            if (this.f46653r.k() != -2147483647) {
                builderN0.Q(this.f46653r.k());
            }
            this.f46645j.c(builderN0.N());
            this.f46650o = extractorInput.getPosition();
        } else if (this.f46650o != 0) {
            long position = extractorInput.getPosition();
            long j3 = this.f46650o;
            if (position < j3) {
                extractorInput.k((int) (j3 - position));
            }
        }
        return w(extractorInput);
    }

    private int w(ExtractorInput extractorInput) {
        if (this.f46652q == 0) {
            extractorInput.f();
            if (u(extractorInput)) {
                return -1;
            }
            this.f46638c.W(0);
            int iQ = this.f46638c.q();
            if (!q(iQ, this.f46646k) || MpegAudioUtil.j(iQ) == -1) {
                extractorInput.k(1);
                this.f46646k = 0;
                return 0;
            }
            this.f46639d.a(iQ);
            if (this.f46648m == -9223372036854775807L) {
                this.f46648m = this.f46653r.f(extractorInput.getPosition());
                if (this.f46637b != -9223372036854775807L) {
                    this.f46648m += this.f46637b - this.f46653r.f(0L);
                }
            }
            this.f46652q = this.f46639d.f46205c;
            long position = extractorInput.getPosition();
            MpegAudioUtil.Header header = this.f46639d;
            this.f46651p = position + ((long) header.f46205c);
            Seeker seeker = this.f46653r;
            if (seeker instanceof IndexSeeker) {
                IndexSeeker indexSeeker = (IndexSeeker) seeker;
                indexSeeker.c(k(this.f46649n + ((long) header.f46209g)), this.f46651p);
                if (this.f46655t && indexSeeker.a(this.f46656u)) {
                    this.f46655t = false;
                    this.f46645j = this.f46644i;
                }
            }
        }
        int iD = this.f46645j.d(extractorInput, this.f46652q, true);
        if (iD == -1) {
            return -1;
        }
        int i3 = this.f46652q - iD;
        this.f46652q = i3;
        if (i3 > 0) {
            return 0;
        }
        this.f46645j.g(k(this.f46649n), 1, this.f46639d.f46205c, 0, null);
        this.f46649n += (long) this.f46639d.f46209g;
        this.f46652q = 0;
        return 0;
    }

    private boolean x(ExtractorInput extractorInput, boolean z2) throws Throwable {
        int iH;
        int i3;
        int iJ;
        int i4 = z2 ? 32768 : 131072;
        extractorInput.f();
        if (extractorInput.getPosition() == 0) {
            Metadata metadataA = this.f46641f.a(extractorInput, (this.f46636a & 8) == 0 ? null : f46635w);
            this.f46647l = metadataA;
            if (metadataA != null) {
                this.f46640e.c(metadataA);
            }
            iH = (int) extractorInput.h();
            if (!z2) {
                extractorInput.k(iH);
            }
            i3 = 0;
        } else {
            iH = 0;
            i3 = 0;
        }
        int i5 = i3;
        int i6 = i5;
        while (true) {
            if (!u(extractorInput)) {
                this.f46638c.W(0);
                int iQ = this.f46638c.q();
                if ((i3 == 0 || q(iQ, i3)) && (iJ = MpegAudioUtil.j(iQ)) != -1) {
                    i5++;
                    if (i5 != 1) {
                        if (i5 == 4) {
                            break;
                        }
                    } else {
                        this.f46639d.a(iQ);
                        i3 = iQ;
                    }
                    extractorInput.i(iJ - 4);
                } else {
                    int i7 = i6 + 1;
                    if (i6 == i4) {
                        if (z2) {
                            return false;
                        }
                        t();
                        throw new EOFException();
                    }
                    if (z2) {
                        extractorInput.f();
                        extractorInput.i(iH + i7);
                    } else {
                        extractorInput.k(1);
                    }
                    i5 = 0;
                    i6 = i7;
                    i3 = 0;
                }
            } else if (i5 <= 0) {
                t();
                throw new EOFException();
            }
        }
        if (z2) {
            extractorInput.k(iH + i6);
        } else {
            extractorInput.f();
        }
        this.f46646k = i3;
        return true;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f46646k = 0;
        this.f46648m = -9223372036854775807L;
        this.f46649n = 0L;
        this.f46652q = 0;
        this.f46656u = j4;
        Seeker seeker = this.f46653r;
        if (!(seeker instanceof IndexSeeker) || ((IndexSeeker) seeker).a(j4)) {
            return;
        }
        this.f46655t = true;
        this.f46645j = this.f46642g;
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        return x(extractorInput, true);
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46643h = extractorOutput;
        TrackOutput trackOutputD = extractorOutput.d(0, 1);
        this.f46644i = trackOutputD;
        this.f46645j = trackOutputD;
        this.f46643h.q();
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws Throwable {
        e();
        int iV = v(extractorInput);
        if (iV == -1 && (this.f46653r instanceof IndexSeeker)) {
            long jK = k(this.f46649n);
            if (this.f46653r.l() != jK) {
                ((IndexSeeker) this.f46653r).g(jK);
                this.f46643h.n(this.f46653r);
                this.f46644i.e(this.f46653r.l());
            }
        }
        return iV;
    }

    public void l() {
        this.f46654s = true;
    }

    public Mp3Extractor(int i3) {
        this(i3, -9223372036854775807L);
    }

    public Mp3Extractor(int i3, long j3) {
        this.f46636a = (i3 & 2) != 0 ? i3 | 1 : i3;
        this.f46637b = j3;
        this.f46638c = new ParsableByteArray(10);
        this.f46639d = new MpegAudioUtil.Header();
        this.f46640e = new GaplessInfoHolder();
        this.f46648m = -9223372036854775807L;
        this.f46641f = new Id3Peeker();
        DiscardingTrackOutput discardingTrackOutput = new DiscardingTrackOutput();
        this.f46642g = discardingTrackOutput;
        this.f46645j = discardingTrackOutput;
        this.f46651p = -1L;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
