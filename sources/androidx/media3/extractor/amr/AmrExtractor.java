package androidx.media3.extractor.amr;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class AmrExtractor implements Extractor {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ExtractorsFactory f46259s = new ExtractorsFactory() { // from class: androidx.media3.extractor.amr.a
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return AmrExtractor.b();
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int[] f46260t = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int[] f46261u = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final byte[] f46262v = Util.t0("#!AMR\n");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final byte[] f46263w = Util.t0("#!AMR-WB\n");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f46264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f46265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TrackOutput f46266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f46267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f46268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f46269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f46271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f46274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ExtractorOutput f46275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TrackOutput f46276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TrackOutput f46277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private SeekMap f46278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f46279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f46280q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f46281r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public AmrExtractor() {
        this(0);
    }

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new AmrExtractor()};
    }

    private void d() {
        Assertions.i(this.f46276m);
        Util.k(this.f46275l);
    }

    private static int e(int i3, long j3) {
        return (int) ((((long) i3) * 8000000) / j3);
    }

    private SeekMap f(long j3, boolean z2) {
        return new ConstantBitrateSeekMap(j3, this.f46271h, e(this.f46272i, 20000L), this.f46272i, z2);
    }

    private int k(int i3) throws ParserException {
        if (n(i3)) {
            return this.f46267d ? f46261u[i3] : f46260t[i3];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.f46267d ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i3);
        throw ParserException.a(sb.toString(), null);
    }

    private boolean l(int i3) {
        if (this.f46267d) {
            return false;
        }
        return i3 < 12 || i3 > 14;
    }

    private boolean m(long j3, long j4) {
        return Math.abs(j4 - j3) < 20000;
    }

    private boolean n(int i3) {
        if (i3 < 0 || i3 > 15) {
            return false;
        }
        return o(i3) || l(i3);
    }

    private boolean o(int i3) {
        if (this.f46267d) {
            return i3 < 10 || i3 > 13;
        }
        return false;
    }

    private void q(long j3, int i3) {
        int i4;
        if (this.f46278o != null) {
            return;
        }
        int i5 = this.f46265b;
        if ((i5 & 4) != 0) {
            this.f46278o = new IndexSeekMap(new long[]{this.f46271h}, new long[]{0}, -9223372036854775807L);
        } else if ((i5 & 1) == 0 || !((i4 = this.f46272i) == -1 || i4 == this.f46269f)) {
            this.f46278o = new SeekMap.Unseekable(-9223372036854775807L);
        } else if (this.f46273j >= 20 || i3 == -1) {
            SeekMap seekMapF = f(j3, (i5 & 2) != 0);
            this.f46278o = seekMapF;
            this.f46276m.e(seekMapF.l());
        }
        SeekMap seekMap = this.f46278o;
        if (seekMap != null) {
            this.f46275l.n(seekMap);
        }
    }

    private static boolean r(ExtractorInput extractorInput, byte[] bArr) {
        extractorInput.f();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.m(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int s(ExtractorInput extractorInput) throws ParserException {
        extractorInput.f();
        extractorInput.m(this.f46264a, 0, 1);
        byte b3 = this.f46264a[0];
        if ((b3 & 131) <= 0) {
            return k((b3 >> 3) & 15);
        }
        throw ParserException.a("Invalid padding bits for frame header " + ((int) b3), null);
    }

    private boolean t(ExtractorInput extractorInput) {
        byte[] bArr = f46262v;
        if (r(extractorInput, bArr)) {
            this.f46267d = false;
            extractorInput.k(bArr.length);
            return true;
        }
        byte[] bArr2 = f46263w;
        if (!r(extractorInput, bArr2)) {
            return false;
        }
        this.f46267d = true;
        extractorInput.k(bArr2.length);
        return true;
    }

    private int u(ExtractorInput extractorInput) throws ParserException {
        if (this.f46270g == 0) {
            try {
                int iS = s(extractorInput);
                this.f46269f = iS;
                this.f46270g = iS;
                if (this.f46272i == -1) {
                    this.f46271h = extractorInput.getPosition();
                    this.f46272i = this.f46269f;
                }
                if (this.f46272i == this.f46269f) {
                    this.f46273j++;
                }
                SeekMap seekMap = this.f46278o;
                if (seekMap instanceof IndexSeekMap) {
                    IndexSeekMap indexSeekMap = (IndexSeekMap) seekMap;
                    long j3 = this.f46274k + this.f46268e + 20000;
                    long position = extractorInput.getPosition() + ((long) this.f46269f);
                    if (!indexSeekMap.c(j3, 100000L)) {
                        indexSeekMap.a(j3, position);
                    }
                    if (this.f46279p && m(j3, this.f46280q)) {
                        this.f46279p = false;
                        this.f46277n = this.f46276m;
                    }
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iD = this.f46277n.d(extractorInput, this.f46270g, true);
        if (iD == -1) {
            return -1;
        }
        int i3 = this.f46270g - iD;
        this.f46270g = i3;
        if (i3 > 0) {
            return 0;
        }
        this.f46277n.g(this.f46274k + this.f46268e, 1, this.f46269f, 0, null);
        this.f46268e += 20000;
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f46268e = 0L;
        this.f46269f = 0;
        this.f46270g = 0;
        this.f46280q = j4;
        SeekMap seekMap = this.f46278o;
        if (!(seekMap instanceof IndexSeekMap)) {
            if (j3 == 0 || !(seekMap instanceof ConstantBitrateSeekMap)) {
                this.f46274k = 0L;
                return;
            } else {
                this.f46274k = ((ConstantBitrateSeekMap) seekMap).c(j3);
                return;
            }
        }
        long jF = ((IndexSeekMap) seekMap).f(j3);
        this.f46274k = jF;
        if (m(jF, this.f46280q)) {
            return;
        }
        this.f46279p = true;
        this.f46277n = this.f46266c;
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        return t(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46275l = extractorOutput;
        TrackOutput trackOutputD = extractorOutput.d(0, 1);
        this.f46276m = trackOutputD;
        this.f46277n = trackOutputD;
        extractorOutput.q();
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        d();
        if (extractorInput.getPosition() == 0 && !t(extractorInput)) {
            throw ParserException.a("Could not find AMR header.", null);
        }
        p();
        int iU = u(extractorInput);
        q(extractorInput.getLength(), iU);
        if (iU == -1) {
            SeekMap seekMap = this.f46278o;
            if (seekMap instanceof IndexSeekMap) {
                long j3 = this.f46274k + this.f46268e;
                ((IndexSeekMap) seekMap).g(j3);
                this.f46275l.n(this.f46278o);
                this.f46276m.e(j3);
            }
        }
        return iU;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }

    public AmrExtractor(int i3) {
        this.f46265b = (i3 & 2) != 0 ? i3 | 1 : i3;
        this.f46264a = new byte[1];
        this.f46272i = -1;
        DiscardingTrackOutput discardingTrackOutput = new DiscardingTrackOutput();
        this.f46266c = discardingTrackOutput;
        this.f46277n = discardingTrackOutput;
    }

    private void p() {
        if (this.f46281r) {
            return;
        }
        this.f46281r = true;
        boolean z2 = this.f46267d;
        String str = FptyjHFU.NsLKUu;
        String str2 = z2 ? str : YgVrd.cBslLfIkbpvdZKq;
        if (!z2) {
            str = "audio/3gpp";
        }
        this.f46276m.c(new Format.Builder().U(str2).u0(str).k0(z2 ? f46261u[8] : f46260t[7]).R(1).v0(z2 ? 16000 : 8000).N());
    }
}
