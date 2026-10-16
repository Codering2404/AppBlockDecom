package androidx.media3.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.container.Mp4Box;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.container.ReorderingSeiMessageQueue;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.emsg.EventMessageEncoder;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class FragmentedMp4Extractor implements Extractor {
    public static final ExtractorsFactory M = new ExtractorsFactory() { // from class: androidx.media3.extractor.mp4.b
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return FragmentedMp4Extractor.d();
        }
    };
    private static final byte[] N = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final Format O = new Format.Builder().u0("application/x-emsg").N();
    private long A;
    private long B;
    private TrackBundle C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private ExtractorOutput I;
    private TrackOutput[] J;
    private TrackOutput[] K;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SubtitleParser.Factory f46729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f46730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Track f46731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f46732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseArray f46733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ParsableByteArray f46734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ParsableByteArray f46735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ParsableByteArray f46736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f46737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ParsableByteArray f46738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final TimestampAdjuster f46739k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final EventMessageEncoder f46740l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ParsableByteArray f46741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ArrayDeque f46742n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ArrayDeque f46743o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ReorderingSeiMessageQueue f46744p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final TrackOutput f46745q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ImmutableList f46746r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f46747s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f46748t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f46749u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f46750v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ParsableByteArray f46751w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f46752x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f46753y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f46754z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class MetadataSampleInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f46755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f46756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46757c;

        public MetadataSampleInfo(long j3, boolean z2, int i3) {
            this.f46755a = j3;
            this.f46756b = z2;
            this.f46757c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class TrackBundle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TrackOutput f46758a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TrackSampleTable f46761d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DefaultSampleValues f46762e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f46763f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f46764g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f46765h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f46766i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f46767j;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f46770m;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TrackFragment f46759b = new TrackFragment();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ParsableByteArray f46760c = new ParsableByteArray();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final ParsableByteArray f46768k = new ParsableByteArray(1);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final ParsableByteArray f46769l = new ParsableByteArray();

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues, String str) {
            this.f46758a = trackOutput;
            this.f46761d = trackSampleTable;
            this.f46762e = defaultSampleValues;
            this.f46767j = str;
            j(trackSampleTable, defaultSampleValues);
        }

        public int c() {
            int i3 = !this.f46770m ? this.f46761d.f46860g[this.f46763f] : this.f46759b.f46846k[this.f46763f] ? 1 : 0;
            return g() != null ? i3 | 1073741824 : i3;
        }

        public long d() {
            return !this.f46770m ? this.f46761d.f46856c[this.f46763f] : this.f46759b.f46842g[this.f46765h];
        }

        public long e() {
            return !this.f46770m ? this.f46761d.f46859f[this.f46763f] : this.f46759b.c(this.f46763f);
        }

        public int f() {
            return !this.f46770m ? this.f46761d.f46857d[this.f46763f] : this.f46759b.f46844i[this.f46763f];
        }

        public TrackEncryptionBox g() {
            if (!this.f46770m) {
                return null;
            }
            int i3 = ((DefaultSampleValues) Util.k(this.f46759b.f46836a)).f46718a;
            TrackEncryptionBox trackEncryptionBoxB = this.f46759b.f46849n;
            if (trackEncryptionBoxB == null) {
                trackEncryptionBoxB = this.f46761d.f46854a.b(i3);
            }
            if (trackEncryptionBoxB == null || !trackEncryptionBoxB.f46831a) {
                return null;
            }
            return trackEncryptionBoxB;
        }

        public boolean h() {
            this.f46763f++;
            if (!this.f46770m) {
                return false;
            }
            int i3 = this.f46764g + 1;
            this.f46764g = i3;
            int[] iArr = this.f46759b.f46843h;
            int i4 = this.f46765h;
            if (i3 != iArr[i4]) {
                return true;
            }
            this.f46765h = i4 + 1;
            this.f46764g = 0;
            return false;
        }

        public int i(int i3, int i4) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox trackEncryptionBoxG = g();
            if (trackEncryptionBoxG == null) {
                return 0;
            }
            int length = trackEncryptionBoxG.f46834d;
            if (length != 0) {
                parsableByteArray = this.f46759b.f46850o;
            } else {
                byte[] bArr = (byte[]) Util.k(trackEncryptionBoxG.f46835e);
                this.f46769l.U(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.f46769l;
                length = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean zG = this.f46759b.g(this.f46763f);
            boolean z2 = zG || i4 != 0;
            this.f46768k.e()[0] = (byte) ((z2 ? ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : 0) | length);
            this.f46768k.W(0);
            this.f46758a.a(this.f46768k, 1, 1);
            this.f46758a.a(parsableByteArray, length, 1);
            if (!z2) {
                return length + 1;
            }
            if (!zG) {
                this.f46760c.S(8);
                byte[] bArrE = this.f46760c.e();
                bArrE[0] = 0;
                bArrE[1] = 1;
                bArrE[2] = (byte) ((i4 >> 8) & 255);
                bArrE[3] = (byte) (i4 & 255);
                bArrE[4] = (byte) ((i3 >> 24) & 255);
                bArrE[5] = (byte) ((i3 >> 16) & 255);
                bArrE[6] = (byte) ((i3 >> 8) & 255);
                bArrE[7] = (byte) (i3 & 255);
                this.f46758a.a(this.f46760c, 8, 1);
                return length + 9;
            }
            ParsableByteArray parsableByteArray3 = this.f46759b.f46850o;
            int iP = parsableByteArray3.P();
            parsableByteArray3.X(-2);
            int i5 = (iP * 6) + 2;
            if (i4 != 0) {
                this.f46760c.S(i5);
                byte[] bArrE2 = this.f46760c.e();
                parsableByteArray3.l(bArrE2, 0, i5);
                int i6 = (((bArrE2[2] & 255) << 8) | (bArrE2[3] & 255)) + i4;
                bArrE2[2] = (byte) ((i6 >> 8) & 255);
                bArrE2[3] = (byte) (i6 & 255);
                parsableByteArray3 = this.f46760c;
            }
            this.f46758a.a(parsableByteArray3, i5, 1);
            return length + 1 + i5;
        }

        public void j(TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.f46761d = trackSampleTable;
            this.f46762e = defaultSampleValues;
            this.f46758a.c(trackSampleTable.f46854a.f46825g.b().U(this.f46767j).N());
            k();
        }

        public void k() {
            this.f46759b.f();
            this.f46763f = 0;
            this.f46765h = 0;
            this.f46764g = 0;
            this.f46766i = 0;
            this.f46770m = false;
        }

        public void l(long j3) {
            int i3 = this.f46763f;
            while (true) {
                TrackFragment trackFragment = this.f46759b;
                if (i3 >= trackFragment.f46841f || trackFragment.c(i3) > j3) {
                    return;
                }
                if (this.f46759b.f46846k[i3]) {
                    this.f46766i = i3;
                }
                i3++;
            }
        }

        public void m() {
            TrackEncryptionBox trackEncryptionBoxG = g();
            if (trackEncryptionBoxG == null) {
                return;
            }
            ParsableByteArray parsableByteArray = this.f46759b.f46850o;
            int i3 = trackEncryptionBoxG.f46834d;
            if (i3 != 0) {
                parsableByteArray.X(i3);
            }
            if (this.f46759b.g(this.f46763f)) {
                parsableByteArray.X(parsableByteArray.P() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            TrackEncryptionBox trackEncryptionBoxB = this.f46761d.f46854a.b(((DefaultSampleValues) Util.k(this.f46759b.f46836a)).f46718a);
            this.f46758a.c(this.f46761d.f46854a.f46825g.b().U(this.f46767j).Y(drmInitData.d(trackEncryptionBoxB != null ? trackEncryptionBoxB.f46832b : null)).N());
        }
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory, int i3) {
        this(factory, i3, null, null, ImmutableList.y(), null);
    }

    private static void A(Mp4Box.ContainerBox containerBox, SparseArray sparseArray, boolean z2, int i3, byte[] bArr) throws ParserException {
        int size = containerBox.f41666d.size();
        for (int i4 = 0; i4 < size; i4++) {
            Mp4Box.ContainerBox containerBox2 = (Mp4Box.ContainerBox) containerBox.f41666d.get(i4);
            if (containerBox2.f41663a == 1953653094) {
                J(containerBox2, sparseArray, z2, i3, bArr);
            }
        }
    }

    private static void B(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.W(8);
        int iQ = parsableByteArray.q();
        if ((BoxParser.o(iQ) & 1) == 1) {
            parsableByteArray.X(8);
        }
        int iL = parsableByteArray.L();
        if (iL == 1) {
            trackFragment.f46839d += BoxParser.p(iQ) == 0 ? parsableByteArray.J() : parsableByteArray.O();
        } else {
            throw ParserException.a("Unexpected saio entry count: " + iL, null);
        }
    }

    private static void C(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i3;
        int i4 = trackEncryptionBox.f46834d;
        parsableByteArray.W(8);
        if ((BoxParser.o(parsableByteArray.q()) & 1) == 1) {
            parsableByteArray.X(8);
        }
        int iH = parsableByteArray.H();
        int iL = parsableByteArray.L();
        if (iL > trackFragment.f46841f) {
            throw ParserException.a("Saiz sample count " + iL + " is greater than fragment sample count" + trackFragment.f46841f, null);
        }
        if (iH == 0) {
            boolean[] zArr = trackFragment.f46848m;
            i3 = 0;
            for (int i5 = 0; i5 < iL; i5++) {
                int iH2 = parsableByteArray.H();
                i3 += iH2;
                zArr[i5] = iH2 > i4;
            }
        } else {
            i3 = iH * iL;
            Arrays.fill(trackFragment.f46848m, 0, iL, iH > i4);
        }
        Arrays.fill(trackFragment.f46848m, iL, trackFragment.f46841f, false);
        if (i3 > 0) {
            trackFragment.d(i3);
        }
    }

    private static void D(Mp4Box.ContainerBox containerBox, String str, TrackFragment trackFragment) throws ParserException {
        byte[] bArr = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (int i3 = 0; i3 < containerBox.f41665c.size(); i3++) {
            Mp4Box.LeafBox leafBox = (Mp4Box.LeafBox) containerBox.f41665c.get(i3);
            ParsableByteArray parsableByteArray3 = leafBox.f41667b;
            int i4 = leafBox.f41663a;
            if (i4 == 1935828848) {
                parsableByteArray3.W(12);
                if (parsableByteArray3.q() == 1936025959) {
                    parsableByteArray = parsableByteArray3;
                }
            } else if (i4 == 1936158820) {
                parsableByteArray3.W(12);
                if (parsableByteArray3.q() == 1936025959) {
                    parsableByteArray2 = parsableByteArray3;
                }
            }
        }
        if (parsableByteArray == null || parsableByteArray2 == null) {
            return;
        }
        parsableByteArray.W(8);
        int iP = BoxParser.p(parsableByteArray.q());
        parsableByteArray.X(4);
        if (iP == 1) {
            parsableByteArray.X(4);
        }
        if (parsableByteArray.q() != 1) {
            throw ParserException.c("Entry count in sbgp != 1 (unsupported).");
        }
        parsableByteArray2.W(8);
        int iP2 = BoxParser.p(parsableByteArray2.q());
        parsableByteArray2.X(4);
        if (iP2 == 1) {
            if (parsableByteArray2.J() == 0) {
                throw ParserException.c("Variable length description in sgpd found (unsupported)");
            }
        } else if (iP2 >= 2) {
            parsableByteArray2.X(4);
        }
        if (parsableByteArray2.J() != 1) {
            throw ParserException.c("Entry count in sgpd != 1 (unsupported).");
        }
        parsableByteArray2.X(1);
        int iH = parsableByteArray2.H();
        int i5 = (iH & 240) >> 4;
        int i6 = iH & 15;
        boolean z2 = parsableByteArray2.H() == 1;
        if (z2) {
            int iH2 = parsableByteArray2.H();
            byte[] bArr2 = new byte[16];
            parsableByteArray2.l(bArr2, 0, 16);
            if (iH2 == 0) {
                int iH3 = parsableByteArray2.H();
                bArr = new byte[iH3];
                parsableByteArray2.l(bArr, 0, iH3);
            }
            trackFragment.f46847l = true;
            trackFragment.f46849n = new TrackEncryptionBox(z2, str, iH2, bArr2, i5, i6, bArr);
        }
    }

    private static void E(ParsableByteArray parsableByteArray, int i3, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.W(i3 + 8);
        int iO = BoxParser.o(parsableByteArray.q());
        if ((iO & 1) != 0) {
            throw ParserException.c("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z2 = (iO & 2) != 0;
        int iL = parsableByteArray.L();
        if (iL == 0) {
            Arrays.fill(trackFragment.f46848m, 0, trackFragment.f46841f, false);
            return;
        }
        if (iL == trackFragment.f46841f) {
            Arrays.fill(trackFragment.f46848m, 0, iL, z2);
            trackFragment.d(parsableByteArray.a());
            trackFragment.a(parsableByteArray);
        } else {
            throw ParserException.a("Senc sample count " + iL + " is different from fragment sample count" + trackFragment.f46841f, null);
        }
    }

    private static void F(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        E(parsableByteArray, 0, trackFragment);
    }

    private static Pair G(ParsableByteArray parsableByteArray, long j3) throws ParserException {
        long jO;
        long jO2;
        parsableByteArray.W(8);
        int iP = BoxParser.p(parsableByteArray.q());
        parsableByteArray.X(4);
        long J = parsableByteArray.J();
        if (iP == 0) {
            jO = parsableByteArray.J();
            jO2 = parsableByteArray.J();
        } else {
            jO = parsableByteArray.O();
            jO2 = parsableByteArray.O();
        }
        long j4 = j3 + jO2;
        long jZ0 = Util.Z0(jO, 1000000L, J);
        parsableByteArray.X(2);
        int iP2 = parsableByteArray.P();
        int[] iArr = new int[iP2];
        long[] jArr = new long[iP2];
        long[] jArr2 = new long[iP2];
        long[] jArr3 = new long[iP2];
        long j5 = j4;
        long jZ02 = jZ0;
        int i3 = 0;
        while (i3 < iP2) {
            int iQ = parsableByteArray.q();
            if ((Integer.MIN_VALUE & iQ) != 0) {
                throw ParserException.a("Unhandled indirect reference", null);
            }
            long J2 = parsableByteArray.J();
            iArr[i3] = iQ & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            jArr[i3] = j5;
            jArr3[i3] = jZ02;
            jO += J2;
            long[] jArr4 = jArr3;
            jZ02 = Util.Z0(jO, 1000000L, J);
            jArr2[i3] = jZ02 - jArr4[i3];
            parsableByteArray.X(4);
            j5 += (long) iArr[i3];
            i3++;
            jArr3 = jArr4;
        }
        return Pair.create(Long.valueOf(jZ0), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private static long H(ParsableByteArray parsableByteArray) {
        parsableByteArray.W(8);
        return BoxParser.p(parsableByteArray.q()) == 1 ? parsableByteArray.O() : parsableByteArray.J();
    }

    private static TrackBundle I(ParsableByteArray parsableByteArray, SparseArray sparseArray, boolean z2) {
        parsableByteArray.W(8);
        int iO = BoxParser.o(parsableByteArray.q());
        TrackBundle trackBundle = (TrackBundle) (z2 ? sparseArray.valueAt(0) : sparseArray.get(parsableByteArray.q()));
        if (trackBundle == null) {
            return null;
        }
        if ((iO & 1) != 0) {
            long jO = parsableByteArray.O();
            TrackFragment trackFragment = trackBundle.f46759b;
            trackFragment.f46838c = jO;
            trackFragment.f46839d = jO;
        }
        DefaultSampleValues defaultSampleValues = trackBundle.f46762e;
        trackBundle.f46759b.f46836a = new DefaultSampleValues((iO & 2) != 0 ? parsableByteArray.q() - 1 : defaultSampleValues.f46718a, (iO & 8) != 0 ? parsableByteArray.q() : defaultSampleValues.f46719b, (iO & 16) != 0 ? parsableByteArray.q() : defaultSampleValues.f46720c, (iO & 32) != 0 ? parsableByteArray.q() : defaultSampleValues.f46721d);
        return trackBundle;
    }

    private static void J(Mp4Box.ContainerBox containerBox, SparseArray sparseArray, boolean z2, int i3, byte[] bArr) throws ParserException {
        TrackBundle trackBundleI = I(((Mp4Box.LeafBox) Assertions.e(containerBox.e(1952868452))).f41667b, sparseArray, z2);
        if (trackBundleI == null) {
            return;
        }
        TrackFragment trackFragment = trackBundleI.f46759b;
        long j3 = trackFragment.f46852q;
        boolean z3 = trackFragment.f46853r;
        trackBundleI.k();
        trackBundleI.f46770m = true;
        Mp4Box.LeafBox leafBoxE = containerBox.e(1952867444);
        if (leafBoxE == null || (i3 & 2) != 0) {
            trackFragment.f46852q = j3;
            trackFragment.f46853r = z3;
        } else {
            trackFragment.f46852q = H(leafBoxE.f41667b);
            trackFragment.f46853r = true;
        }
        M(containerBox, trackBundleI, i3);
        TrackEncryptionBox trackEncryptionBoxB = trackBundleI.f46761d.f46854a.b(((DefaultSampleValues) Assertions.e(trackFragment.f46836a)).f46718a);
        Mp4Box.LeafBox leafBoxE2 = containerBox.e(1935763834);
        if (leafBoxE2 != null) {
            C((TrackEncryptionBox) Assertions.e(trackEncryptionBoxB), leafBoxE2.f41667b, trackFragment);
        }
        Mp4Box.LeafBox leafBoxE3 = containerBox.e(1935763823);
        if (leafBoxE3 != null) {
            B(leafBoxE3.f41667b, trackFragment);
        }
        Mp4Box.LeafBox leafBoxE4 = containerBox.e(1936027235);
        if (leafBoxE4 != null) {
            F(leafBoxE4.f41667b, trackFragment);
        }
        D(containerBox, trackEncryptionBoxB != null ? trackEncryptionBoxB.f46832b : null, trackFragment);
        int size = containerBox.f41665c.size();
        for (int i4 = 0; i4 < size; i4++) {
            Mp4Box.LeafBox leafBox = (Mp4Box.LeafBox) containerBox.f41665c.get(i4);
            if (leafBox.f41663a == 1970628964) {
                N(leafBox.f41667b, trackFragment, bArr);
            }
        }
    }

    private static Pair K(ParsableByteArray parsableByteArray) {
        parsableByteArray.W(12);
        return Pair.create(Integer.valueOf(parsableByteArray.q()), new DefaultSampleValues(parsableByteArray.q() - 1, parsableByteArray.q(), parsableByteArray.q(), parsableByteArray.q()));
    }

    private static int L(TrackBundle trackBundle, int i3, int i4, ParsableByteArray parsableByteArray, int i5) throws ParserException {
        boolean z2;
        int iQ;
        int i6;
        int iQ2;
        int i7;
        int iQ3;
        int i8;
        int iQ4;
        parsableByteArray.W(8);
        int iO = BoxParser.o(parsableByteArray.q());
        Track track = trackBundle.f46761d.f46854a;
        TrackFragment trackFragment = trackBundle.f46759b;
        DefaultSampleValues defaultSampleValues = (DefaultSampleValues) Util.k(trackFragment.f46836a);
        trackFragment.f46843h[i3] = parsableByteArray.L();
        long[] jArr = trackFragment.f46842g;
        long j3 = trackFragment.f46838c;
        jArr[i3] = j3;
        if ((iO & 1) != 0) {
            jArr[i3] = j3 + ((long) parsableByteArray.q());
        }
        boolean z3 = (iO & 4) != 0;
        int iQ5 = defaultSampleValues.f46721d;
        if (z3) {
            iQ5 = parsableByteArray.q();
        }
        boolean z4 = (iO & Function.MAX_NARGS) != 0;
        boolean z5 = (iO & 512) != 0;
        boolean z6 = (iO & 1024) != 0;
        boolean z7 = (iO & 2048) != 0;
        long j4 = r(track) ? ((long[]) Util.k(track.f46828j))[0] : 0L;
        int[] iArr = trackFragment.f46844i;
        long[] jArr2 = trackFragment.f46845j;
        boolean[] zArr = trackFragment.f46846k;
        boolean z8 = z7;
        boolean z9 = track.f46820b == 2 && (i4 & 1) != 0;
        int i9 = i5 + trackFragment.f46843h[i3];
        boolean z10 = z3;
        long j5 = track.f46821c;
        long j6 = trackFragment.f46852q;
        int i10 = i5;
        while (i10 < i9) {
            if (z4) {
                iQ = parsableByteArray.q();
                z2 = z9;
            } else {
                z2 = z9;
                iQ = defaultSampleValues.f46719b;
            }
            int iF = f(iQ);
            if (z5) {
                iQ2 = parsableByteArray.q();
                i6 = i9;
            } else {
                i6 = i9;
                iQ2 = defaultSampleValues.f46720c;
            }
            int iF2 = f(iQ2);
            if (z6) {
                i7 = iF2;
                iQ3 = parsableByteArray.q();
            } else if (i10 == 0 && z10) {
                i7 = iF2;
                iQ3 = iQ5;
            } else {
                i7 = iF2;
                iQ3 = defaultSampleValues.f46721d;
            }
            if (z8) {
                i8 = iQ3;
                iQ4 = parsableByteArray.q();
            } else {
                i8 = iQ3;
                iQ4 = 0;
            }
            int i11 = i10;
            long jZ0 = Util.Z0((((long) iQ4) + j6) - j4, 1000000L, j5);
            jArr2[i11] = jZ0;
            if (!trackFragment.f46853r) {
                jArr2[i11] = jZ0 + trackBundle.f46761d.f46861h;
            }
            iArr[i11] = i7;
            zArr[i11] = ((i8 >> 16) & 1) == 0 && (!z2 || i11 == 0);
            j6 += (long) iF;
            i10 = i11 + 1;
            i9 = i6;
            z9 = z2;
        }
        int i12 = i9;
        trackFragment.f46852q = j6;
        return i12;
    }

    private static void M(Mp4Box.ContainerBox containerBox, TrackBundle trackBundle, int i3) throws ParserException {
        List list = containerBox.f41665c;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Mp4Box.LeafBox leafBox = (Mp4Box.LeafBox) list.get(i6);
            if (leafBox.f41663a == 1953658222) {
                ParsableByteArray parsableByteArray = leafBox.f41667b;
                parsableByteArray.W(12);
                int iL = parsableByteArray.L();
                if (iL > 0) {
                    i5 += iL;
                    i4++;
                }
            }
        }
        trackBundle.f46765h = 0;
        trackBundle.f46764g = 0;
        trackBundle.f46763f = 0;
        trackBundle.f46759b.e(i4, i5);
        int i7 = 0;
        int iL2 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Mp4Box.LeafBox leafBox2 = (Mp4Box.LeafBox) list.get(i8);
            if (leafBox2.f41663a == 1953658222) {
                iL2 = L(trackBundle, i7, i3, leafBox2.f41667b, iL2);
                i7++;
            }
        }
    }

    private static void N(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.W(8);
        parsableByteArray.l(bArr, 0, 16);
        if (Arrays.equals(bArr, N)) {
            E(parsableByteArray, 16, trackFragment);
        }
    }

    private void O(long j3) throws ParserException {
        while (!this.f46742n.isEmpty() && ((Mp4Box.ContainerBox) this.f46742n.peek()).f41664b == j3) {
            t((Mp4Box.ContainerBox) this.f46742n.pop());
        }
        l();
    }

    private void Q(ExtractorInput extractorInput) throws ParserException {
        int i3 = (int) (this.f46749u - ((long) this.f46750v));
        ParsableByteArray parsableByteArray = this.f46751w;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.e(), 8, i3);
            v(new Mp4Box.LeafBox(this.f46748t, parsableByteArray), extractorInput.getPosition());
        } else {
            extractorInput.k(i3);
        }
        O(extractorInput.getPosition());
    }

    private void R(ExtractorInput extractorInput) throws ParserException {
        int size = this.f46733e.size();
        long j3 = Long.MAX_VALUE;
        TrackBundle trackBundle = null;
        for (int i3 = 0; i3 < size; i3++) {
            TrackFragment trackFragment = ((TrackBundle) this.f46733e.valueAt(i3)).f46759b;
            if (trackFragment.f46851p) {
                long j4 = trackFragment.f46839d;
                if (j4 < j3) {
                    trackBundle = (TrackBundle) this.f46733e.valueAt(i3);
                    j3 = j4;
                }
            }
        }
        if (trackBundle == null) {
            this.f46747s = 3;
            return;
        }
        int position = (int) (j3 - extractorInput.getPosition());
        if (position < 0) {
            throw ParserException.a("Offset to encryption data was negative.", null);
        }
        extractorInput.k(position);
        trackBundle.f46759b.b(extractorInput);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean S(androidx.media3.extractor.ExtractorInput r17) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instruction units count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.FragmentedMp4Extractor.S(androidx.media3.extractor.ExtractorInput):boolean");
    }

    private static boolean T(int i3) {
        return i3 == 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1836019558 || i3 == 1953653094 || i3 == 1836475768 || i3 == 1701082227;
    }

    private static boolean U(int i3) {
        return i3 == 1751411826 || i3 == 1835296868 || i3 == 1836476516 || i3 == 1936286840 || i3 == 1937011556 || i3 == 1937011827 || i3 == 1668576371 || i3 == 1937011555 || i3 == 1937011578 || i3 == 1937013298 || i3 == 1937007471 || i3 == 1668232756 || i3 == 1937011571 || i3 == 1952867444 || i3 == 1952868452 || i3 == 1953196132 || i3 == 1953654136 || i3 == 1953658222 || i3 == 1886614376 || i3 == 1935763834 || i3 == 1935763823 || i3 == 1936027235 || i3 == 1970628964 || i3 == 1935828848 || i3 == 1936158820 || i3 == 1701606260 || i3 == 1835362404 || i3 == 1701671783;
    }

    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new FragmentedMp4Extractor(SubtitleParser.Factory.f46959a, 32)};
    }

    private boolean e(Format format) {
        return Objects.equals(format.f40632o, "video/avc") ? (this.f46730b & 64) != 0 : Objects.equals(format.f40632o, "video/hevc") && (this.f46730b & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
    }

    private static int f(int i3) throws ParserException {
        if (i3 >= 0) {
            return i3;
        }
        throw ParserException.a("Unexpected negative value: " + i3, null);
    }

    public static int k(int i3) {
        int i4 = (i3 & 1) != 0 ? 64 : 0;
        return (i3 & 2) != 0 ? i4 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : i4;
    }

    private void l() {
        this.f46747s = 0;
        this.f46750v = 0;
    }

    private DefaultSampleValues m(SparseArray sparseArray, int i3) {
        return sparseArray.size() == 1 ? (DefaultSampleValues) sparseArray.valueAt(0) : (DefaultSampleValues) Assertions.e((DefaultSampleValues) sparseArray.get(i3));
    }

    private static DrmInitData n(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            Mp4Box.LeafBox leafBox = (Mp4Box.LeafBox) list.get(i3);
            if (leafBox.f41663a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrE = leafBox.f41667b.e();
                UUID uuidF = PsshAtomUtil.f(bArrE);
                if (uuidF == null) {
                    Log.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidF, "video/mp4", bArrE));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static TrackBundle o(SparseArray sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j3 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < size; i3++) {
            TrackBundle trackBundle2 = (TrackBundle) sparseArray.valueAt(i3);
            if ((trackBundle2.f46770m || trackBundle2.f46763f != trackBundle2.f46761d.f46855b) && (!trackBundle2.f46770m || trackBundle2.f46765h != trackBundle2.f46759b.f46840e)) {
                long jD = trackBundle2.d();
                if (jD < j3) {
                    trackBundle = trackBundle2;
                    j3 = jD;
                }
            }
        }
        return trackBundle;
    }

    private void q() {
        int i3;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.J = trackOutputArr;
        TrackOutput trackOutput = this.f46745q;
        int i4 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i5 = 100;
        if ((this.f46730b & 4) != 0) {
            trackOutputArr[i3] = this.I.d(100, 5);
            i5 = 101;
            i3++;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.U0(this.J, i3);
        this.J = trackOutputArr2;
        for (TrackOutput trackOutput2 : trackOutputArr2) {
            trackOutput2.c(O);
        }
        this.K = new TrackOutput[this.f46732d.size()];
        while (i4 < this.K.length) {
            TrackOutput trackOutputD = this.I.d(i5, 3);
            trackOutputD.c((Format) this.f46732d.get(i4));
            this.K[i4] = trackOutputD;
            i4++;
            i5++;
        }
    }

    private static boolean r(Track track) {
        long[] jArr = track.f46827i;
        if (jArr != null && jArr.length == 1 && track.f46828j != null) {
            long j3 = jArr[0];
            if (j3 == 0 || Util.Z0(j3, 1000000L, track.f46822d) + Util.Z0(track.f46828j[0], 1000000L, track.f46821c) >= track.f46823e) {
                return true;
            }
        }
        return false;
    }

    private void t(Mp4Box.ContainerBox containerBox) throws ParserException {
        int i3 = containerBox.f41663a;
        if (i3 == 1836019574) {
            x(containerBox);
        } else if (i3 == 1836019558) {
            w(containerBox);
        } else {
            if (this.f46742n.isEmpty()) {
                return;
            }
            ((Mp4Box.ContainerBox) this.f46742n.peek()).b(containerBox);
        }
    }

    private void u(ParsableByteArray parsableByteArray) {
        String str;
        String str2;
        long jZ0;
        long jZ02;
        long J;
        long jA;
        if (this.J.length == 0) {
            return;
        }
        parsableByteArray.W(8);
        int iP = BoxParser.p(parsableByteArray.q());
        if (iP == 0) {
            str = (String) Assertions.e(parsableByteArray.B());
            str2 = (String) Assertions.e(parsableByteArray.B());
            long J2 = parsableByteArray.J();
            jZ0 = Util.Z0(parsableByteArray.J(), 1000000L, J2);
            long j3 = this.B;
            long j4 = j3 != -9223372036854775807L ? j3 + jZ0 : -9223372036854775807L;
            jZ02 = Util.Z0(parsableByteArray.J(), 1000L, J2);
            J = parsableByteArray.J();
            jA = j4;
        } else {
            if (iP != 1) {
                Log.i("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iP);
                return;
            }
            long J3 = parsableByteArray.J();
            jA = Util.Z0(parsableByteArray.O(), 1000000L, J3);
            long jZ03 = Util.Z0(parsableByteArray.J(), 1000L, J3);
            long J4 = parsableByteArray.J();
            str = (String) Assertions.e(parsableByteArray.B());
            str2 = (String) Assertions.e(parsableByteArray.B());
            jZ02 = jZ03;
            J = J4;
            jZ0 = -9223372036854775807L;
        }
        String str3 = str;
        String str4 = str2;
        byte[] bArr = new byte[parsableByteArray.a()];
        parsableByteArray.l(bArr, 0, parsableByteArray.a());
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.f46740l.a(new EventMessage(str3, str4, jZ02, J, bArr)));
        int iA = parsableByteArray2.a();
        for (TrackOutput trackOutput : this.J) {
            parsableByteArray2.W(0);
            trackOutput.b(parsableByteArray2, iA);
        }
        if (jA == -9223372036854775807L) {
            this.f46743o.addLast(new MetadataSampleInfo(jZ0, true, iA));
            this.f46753y += iA;
            return;
        }
        if (!this.f46743o.isEmpty()) {
            this.f46743o.addLast(new MetadataSampleInfo(jA, false, iA));
            this.f46753y += iA;
            return;
        }
        TimestampAdjuster timestampAdjuster = this.f46739k;
        if (timestampAdjuster != null && !timestampAdjuster.g()) {
            this.f46743o.addLast(new MetadataSampleInfo(jA, false, iA));
            this.f46753y += iA;
            return;
        }
        TimestampAdjuster timestampAdjuster2 = this.f46739k;
        if (timestampAdjuster2 != null) {
            jA = timestampAdjuster2.a(jA);
        }
        long j5 = jA;
        for (TrackOutput trackOutput2 : this.J) {
            trackOutput2.g(j5, 1, iA, 0, null);
        }
    }

    private void v(Mp4Box.LeafBox leafBox, long j3) throws ParserException {
        if (!this.f46742n.isEmpty()) {
            ((Mp4Box.ContainerBox) this.f46742n.peek()).c(leafBox);
            return;
        }
        int i3 = leafBox.f41663a;
        if (i3 != 1936286840) {
            if (i3 == 1701671783) {
                u(leafBox.f41667b);
            }
        } else {
            Pair pairG = G(leafBox.f41667b, j3);
            this.B = ((Long) pairG.first).longValue();
            this.I.n((SeekMap) pairG.second);
            this.L = true;
        }
    }

    private void w(Mp4Box.ContainerBox containerBox) throws ParserException {
        A(containerBox, this.f46733e, this.f46731c != null, this.f46730b, this.f46737i);
        DrmInitData drmInitDataN = n(containerBox.f41665c);
        if (drmInitDataN != null) {
            int size = this.f46733e.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((TrackBundle) this.f46733e.valueAt(i3)).n(drmInitDataN);
            }
        }
        if (this.f46754z != -9223372036854775807L) {
            int size2 = this.f46733e.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((TrackBundle) this.f46733e.valueAt(i4)).l(this.f46754z);
            }
            this.f46754z = -9223372036854775807L;
        }
    }

    private void x(Mp4Box.ContainerBox containerBox) {
        int i3 = 0;
        Assertions.h(this.f46731c == null, "Unexpected moov box.");
        DrmInitData drmInitDataN = n(containerBox.f41665c);
        Mp4Box.ContainerBox containerBox2 = (Mp4Box.ContainerBox) Assertions.e(containerBox.d(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = containerBox2.f41665c.size();
        long jZ = -9223372036854775807L;
        for (int i4 = 0; i4 < size; i4++) {
            Mp4Box.LeafBox leafBox = (Mp4Box.LeafBox) containerBox2.f41665c.get(i4);
            int i5 = leafBox.f41663a;
            if (i5 == 1953654136) {
                Pair pairK = K(leafBox.f41667b);
                sparseArray.put(((Integer) pairK.first).intValue(), (DefaultSampleValues) pairK.second);
            } else if (i5 == 1835362404) {
                jZ = z(leafBox.f41667b);
            }
        }
        List listG = BoxParser.G(containerBox, new GaplessInfoHolder(), jZ, drmInitDataN, (this.f46730b & 16) != 0, false, new com.google.common.base.Function() { // from class: androidx.media3.extractor.mp4.a
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return this.f46864a.s((Track) obj);
            }
        });
        int size2 = listG.size();
        if (this.f46733e.size() != 0) {
            Assertions.g(this.f46733e.size() == size2);
            while (i3 < size2) {
                TrackSampleTable trackSampleTable = (TrackSampleTable) listG.get(i3);
                Track track = trackSampleTable.f46854a;
                ((TrackBundle) this.f46733e.get(track.f46819a)).j(trackSampleTable, m(sparseArray, track.f46819a));
                i3++;
            }
            return;
        }
        String strB = MimeTypeResolver.b(listG);
        while (i3 < size2) {
            TrackSampleTable trackSampleTable2 = (TrackSampleTable) listG.get(i3);
            Track track2 = trackSampleTable2.f46854a;
            TrackOutput trackOutputD = this.I.d(i3, track2.f46820b);
            trackOutputD.e(track2.f46823e);
            this.f46733e.put(track2.f46819a, new TrackBundle(trackOutputD, trackSampleTable2, m(sparseArray, track2.f46819a), strB));
            this.A = Math.max(this.A, track2.f46823e);
            i3++;
        }
        this.I.q();
    }

    private void y(long j3) {
        while (!this.f46743o.isEmpty()) {
            MetadataSampleInfo metadataSampleInfo = (MetadataSampleInfo) this.f46743o.removeFirst();
            this.f46753y -= metadataSampleInfo.f46757c;
            long jA = metadataSampleInfo.f46755a;
            if (metadataSampleInfo.f46756b) {
                jA += j3;
            }
            TimestampAdjuster timestampAdjuster = this.f46739k;
            if (timestampAdjuster != null) {
                jA = timestampAdjuster.a(jA);
            }
            long j4 = jA;
            for (TrackOutput trackOutput : this.J) {
                trackOutput.g(j4, 1, metadataSampleInfo.f46757c, this.f46753y, null);
            }
        }
    }

    private static long z(ParsableByteArray parsableByteArray) {
        parsableByteArray.W(8);
        return BoxParser.p(parsableByteArray.q()) == 0 ? parsableByteArray.J() : parsableByteArray.O();
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        int size = this.f46733e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((TrackBundle) this.f46733e.valueAt(i3)).k();
        }
        this.f46743o.clear();
        this.f46753y = 0;
        this.f46744p.b();
        this.f46754z = j4;
        this.f46742n.clear();
        l();
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        SniffFailure sniffFailureB = Sniffer.b(extractorInput);
        this.f46746r = sniffFailureB != null ? ImmutableList.z(sniffFailureB) : ImmutableList.y();
        return sniffFailureB == null;
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        if ((this.f46730b & 32) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f46729a);
        }
        this.I = extractorOutput;
        l();
        q();
        Track track = this.f46731c;
        if (track != null) {
            this.f46733e.put(0, new TrackBundle(this.I.d(0, track.f46820b), new TrackSampleTable(this.f46731c, new long[0], new int[0], 0, new long[0], new int[0], 0L), new DefaultSampleValues(0, 0, 0, 0), MimeTypeResolver.a(this.f46731c.f46825g)));
            this.I.q();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        while (true) {
            int i3 = this.f46747s;
            if (i3 != 0) {
                if (i3 == 1) {
                    Q(extractorInput);
                } else if (i3 == 2) {
                    R(extractorInput);
                } else if (S(extractorInput)) {
                    return 0;
                }
            } else if (!P(extractorInput)) {
                this.f46744p.d();
                return -1;
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public ImmutableList i() {
        return this.f46746r;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }

    protected Track s(Track track) {
        return track;
    }

    private boolean P(ExtractorInput extractorInput) throws ParserException {
        if (this.f46750v == 0) {
            if (!extractorInput.g(this.f46741m.e(), 0, 8, true)) {
                return false;
            }
            this.f46750v = 8;
            this.f46741m.W(0);
            this.f46749u = this.f46741m.J();
            this.f46748t = this.f46741m.q();
        }
        long j3 = this.f46749u;
        if (j3 == 1) {
            extractorInput.readFully(this.f46741m.e(), 8, 8);
            this.f46750v += 8;
            this.f46749u = this.f46741m.O();
        } else if (j3 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.f46742n.isEmpty()) {
                length = ((Mp4Box.ContainerBox) this.f46742n.peek()).f41664b;
            }
            if (length != -1) {
                this.f46749u = (length - extractorInput.getPosition()) + ((long) this.f46750v);
            }
        }
        if (this.f46749u < this.f46750v) {
            throw ParserException.c("Atom size less than header length (unsupported).");
        }
        long position = extractorInput.getPosition() - ((long) this.f46750v);
        int i3 = this.f46748t;
        if ((i3 == 1836019558 || i3 == 1835295092) && !this.L) {
            this.I.n(new SeekMap.Unseekable(this.A, position));
            this.L = true;
        }
        if (this.f46748t == 1836019558) {
            int size = this.f46733e.size();
            for (int i4 = 0; i4 < size; i4++) {
                TrackFragment trackFragment = ((TrackBundle) this.f46733e.valueAt(i4)).f46759b;
                trackFragment.f46837b = position;
                trackFragment.f46839d = position;
                trackFragment.f46838c = position;
            }
        }
        int i5 = this.f46748t;
        if (i5 == 1835295092) {
            this.C = null;
            this.f46752x = position + this.f46749u;
            this.f46747s = 2;
            return true;
        }
        if (T(i5)) {
            long position2 = (extractorInput.getPosition() + this.f46749u) - 8;
            this.f46742n.push(new Mp4Box.ContainerBox(this.f46748t, position2));
            if (this.f46749u == this.f46750v) {
                O(position2);
            } else {
                l();
            }
        } else if (U(this.f46748t)) {
            if (this.f46750v != 8) {
                throw ParserException.c(qRMDmh.IZNlywaQXiTS);
            }
            if (this.f46749u > 2147483647L) {
                throw ParserException.c("Leaf atom with length > 2147483647 (unsupported).");
            }
            ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.f46749u);
            System.arraycopy(this.f46741m.e(), 0, parsableByteArray.e(), 0, 8);
            this.f46751w = parsableByteArray;
            this.f46747s = 1;
        } else {
            if (this.f46749u > 2147483647L) {
                throw ParserException.c("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.f46751w = null;
            this.f46747s = 1;
        }
        return true;
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory, int i3, TimestampAdjuster timestampAdjuster, Track track, List list, TrackOutput trackOutput) {
        this.f46729a = factory;
        this.f46730b = i3;
        this.f46739k = timestampAdjuster;
        this.f46731c = track;
        this.f46732d = Collections.unmodifiableList(list);
        this.f46745q = trackOutput;
        this.f46740l = new EventMessageEncoder();
        this.f46741m = new ParsableByteArray(16);
        this.f46734f = new ParsableByteArray(NalUnitUtil.f41674a);
        this.f46735g = new ParsableByteArray(6);
        this.f46736h = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.f46737i = bArr;
        this.f46738j = new ParsableByteArray(bArr);
        this.f46742n = new ArrayDeque();
        this.f46743o = new ArrayDeque();
        this.f46733e = new SparseArray();
        this.f46746r = ImmutableList.y();
        this.A = -9223372036854775807L;
        this.f46754z = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.I = ExtractorOutput.m8;
        this.J = new TrackOutput[0];
        this.K = new TrackOutput[0];
        this.f46744p = new ReorderingSeiMessageQueue(new ReorderingSeiMessageQueue.SeiConsumer() { // from class: androidx.media3.extractor.mp4.c
            @Override // androidx.media3.container.ReorderingSeiMessageQueue.SeiConsumer
            public final void a(long j3, ParsableByteArray parsableByteArray) {
                CeaUtil.a(j3, parsableByteArray, this.f46865a.K);
            }
        });
    }
}
