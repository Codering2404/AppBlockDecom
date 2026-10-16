package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4AlternateGroupData;
import androidx.media3.container.Mp4Box;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.DolbyVisionConfig;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.HevcConfig;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BoxParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f46678a = Util.t0("OpusHead");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BtrtData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f46679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f46680b;

        public BtrtData(long j3, long j4) {
            this.f46679a = j3;
            this.f46680b = j4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ChunkIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f46682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f46683c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f46684d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f46685e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ParsableByteArray f46686f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ParsableByteArray f46687g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f46688h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f46689i;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z2) throws ParserException {
            this.f46687g = parsableByteArray;
            this.f46686f = parsableByteArray2;
            this.f46685e = z2;
            parsableByteArray2.W(12);
            this.f46681a = parsableByteArray2.L();
            parsableByteArray.W(12);
            this.f46689i = parsableByteArray.L();
            ExtractorUtil.a(parsableByteArray.q() == 1, "first_chunk must be 1");
            this.f46682b = -1;
        }

        public boolean a() {
            int i3 = this.f46682b + 1;
            this.f46682b = i3;
            if (i3 == this.f46681a) {
                return false;
            }
            this.f46684d = this.f46685e ? this.f46686f.O() : this.f46686f.J();
            if (this.f46682b == this.f46688h) {
                this.f46683c = this.f46687g.L();
                this.f46687g.X(4);
                int i4 = this.f46689i - 1;
                this.f46689i = i4;
                this.f46688h = i4 > 0 ? this.f46687g.L() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EsdsData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f46690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f46691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f46692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f46693d;

        public EsdsData(String str, byte[] bArr, long j3, long j4) {
            this.f46690a = str;
            this.f46691b = bArr;
            this.f46692c = j3;
            this.f46693d = j4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EyesData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StriData f46694a;

        public EyesData(StriData striData) {
            this.f46694a = striData;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MdhdData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f46695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f46696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f46697c;

        public MdhdData(long j3, long j4, String str) {
            this.f46695a = j3;
            this.f46696b = j4;
            this.f46697c = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface SampleSizeBox {
        int a();

        int b();

        int c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StriData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f46698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f46699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f46700c;

        public StriData(boolean z2, boolean z3, boolean z4) {
            this.f46698a = z2;
            this.f46699b = z3;
            this.f46700c = z4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StsdData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TrackEncryptionBox[] f46701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Format f46702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f46703c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f46704d = 0;

        public StsdData(int i3) {
            this.f46701a = new TrackEncryptionBox[i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StszSampleSizeBox implements SampleSizeBox {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f46705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f46706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ParsableByteArray f46707c;

        public StszSampleSizeBox(Mp4Box.LeafBox leafBox, Format format) {
            ParsableByteArray parsableByteArray = leafBox.f41667b;
            this.f46707c = parsableByteArray;
            parsableByteArray.W(12);
            int iL = parsableByteArray.L();
            if ("audio/raw".equals(format.f40632o)) {
                int iK0 = Util.k0(format.G, format.E);
                if (iL == 0 || iL % iK0 != 0) {
                    Log.i("BoxParsers", "Audio sample size mismatch. stsd sample size: " + iK0 + ", stsz sample size: " + iL);
                    iL = iK0;
                }
            }
            this.f46705a = iL == 0 ? -1 : iL;
            this.f46706b = parsableByteArray.L();
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int a() {
            int i3 = this.f46705a;
            return i3 == -1 ? this.f46707c.L() : i3;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int b() {
            return this.f46705a;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int c() {
            return this.f46706b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Stz2SampleSizeBox implements SampleSizeBox {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ParsableByteArray f46708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f46709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f46710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f46711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f46712e;

        public Stz2SampleSizeBox(Mp4Box.LeafBox leafBox) {
            ParsableByteArray parsableByteArray = leafBox.f41667b;
            this.f46708a = parsableByteArray;
            parsableByteArray.W(12);
            this.f46710c = parsableByteArray.L() & 255;
            this.f46709b = parsableByteArray.L();
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int a() {
            int i3 = this.f46710c;
            if (i3 == 8) {
                return this.f46708a.H();
            }
            if (i3 == 16) {
                return this.f46708a.P();
            }
            int i4 = this.f46711d;
            this.f46711d = i4 + 1;
            if (i4 % 2 != 0) {
                return this.f46712e & 15;
            }
            int iH = this.f46708a.H();
            this.f46712e = iH;
            return (iH & 240) >> 4;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int b() {
            return -1;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int c() {
            return this.f46709b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TkhdData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f46713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f46714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f46715c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f46716d;

        public TkhdData(int i3, long j3, int i4, int i5) {
            this.f46713a = i3;
            this.f46714b = j3;
            this.f46715c = i4;
            this.f46716d = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class VexuData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EyesData f46717a;

        public VexuData(EyesData eyesData) {
            this.f46717a = eyesData;
        }

        public boolean b() {
            EyesData eyesData = this.f46717a;
            return eyesData != null && eyesData.f46694a.f46698a && this.f46717a.f46694a.f46699b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b2  */
    /* JADX WARN: Type inference failed for: r15v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r22v9, types: [int[]] */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v2, types: [int] */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r8v10, types: [int] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.media3.extractor.mp4.TrackSampleTable A(androidx.media3.extractor.mp4.Track r36, androidx.media3.container.Mp4Box.ContainerBox r37, androidx.media3.extractor.GaplessInfoHolder r38) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instruction units count: 1412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.BoxParser.A(androidx.media3.extractor.mp4.Track, androidx.media3.container.Mp4Box$ContainerBox, androidx.media3.extractor.GaplessInfoHolder):androidx.media3.extractor.mp4.TrackSampleTable");
    }

    private static EyesData B(ParsableByteArray parsableByteArray, int i3, int i4) throws ParserException {
        parsableByteArray.W(i3 + 8);
        int iF = parsableByteArray.f();
        while (iF - i3 < i4) {
            parsableByteArray.W(iF);
            int iQ = parsableByteArray.q();
            ExtractorUtil.a(iQ > 0, "childAtomSize must be positive");
            if (parsableByteArray.q() == 1937011305) {
                parsableByteArray.X(4);
                int iH = parsableByteArray.H();
                return new EyesData(new StriData((iH & 1) == 1, (iH & 2) == 2, (iH & 8) == 8));
            }
            iF += iQ;
        }
        return null;
    }

    private static StsdData C(ParsableByteArray parsableByteArray, int i3, int i4, String str, DrmInitData drmInitData, boolean z2) throws ParserException {
        parsableByteArray.W(12);
        int iQ = parsableByteArray.q();
        StsdData stsdData = new StsdData(iQ);
        for (int i5 = 0; i5 < iQ; i5++) {
            int iF = parsableByteArray.f();
            int iQ2 = parsableByteArray.q();
            ExtractorUtil.a(iQ2 > 0, "childAtomSize must be positive");
            int iQ3 = parsableByteArray.q();
            if (iQ3 == 1635148593 || iQ3 == 1635148595 || iQ3 == 1701733238 || iQ3 == 1831958048 || iQ3 == 1836070006 || iQ3 == 1752589105 || iQ3 == 1751479857 || iQ3 == 1932670515 || iQ3 == 1211250227 || iQ3 == 1748121139 || iQ3 == 1987063864 || iQ3 == 1987063865 || iQ3 == 1635135537 || iQ3 == 1685479798 || iQ3 == 1685479729 || iQ3 == 1685481573 || iQ3 == 1685481521 || iQ3 == 1634760241) {
                K(parsableByteArray, iQ3, iF, iQ2, i3, str, i4, drmInitData, stsdData, i5);
            } else if (iQ3 == 1836069985 || iQ3 == 1701733217 || iQ3 == 1633889587 || iQ3 == 1700998451 || iQ3 == 1633889588 || iQ3 == 1835823201 || iQ3 == 1685353315 || iQ3 == 1685353317 || iQ3 == 1685353320 || iQ3 == 1685353324 || iQ3 == 1685353336 || iQ3 == 1935764850 || iQ3 == 1935767394 || iQ3 == 1819304813 || iQ3 == 1936684916 || iQ3 == 1953984371 || iQ3 == 778924082 || iQ3 == 778924083 || iQ3 == 1835557169 || iQ3 == 1835560241 || iQ3 == 1634492771 || iQ3 == 1634492791 || iQ3 == 1970037111 || iQ3 == 1332770163 || iQ3 == 1716281667 || iQ3 == 1767992678) {
                h(parsableByteArray, iQ3, iF, iQ2, i3, str, z2, drmInitData, stsdData, i5);
            } else if (iQ3 == 1414810956 || iQ3 == 1954034535 || iQ3 == 2004251764 || iQ3 == 1937010800 || iQ3 == 1664495672) {
                StsdData stsdData2 = stsdData;
                D(parsableByteArray, iQ3, iF, iQ2, i3, str, stsdData2);
                stsdData = stsdData2;
            } else if (iQ3 == 1835365492) {
                u(parsableByteArray, iQ3, iF, i3, stsdData);
            } else if (iQ3 == 1667329389) {
                stsdData.f46702b = new Format.Builder().e0(i3).u0("application/x-camera-motion").N();
            }
            parsableByteArray.W(iF + iQ2);
        }
        return stsdData;
    }

    private static void D(ParsableByteArray parsableByteArray, int i3, int i4, int i5, int i6, String str, StsdData stsdData) {
        parsableByteArray.W(i4 + 16);
        String str2 = "application/ttml+xml";
        ImmutableList immutableListZ = null;
        long j3 = Long.MAX_VALUE;
        if (i3 != 1414810956) {
            if (i3 == 1954034535) {
                int i7 = i5 - 16;
                byte[] bArr = new byte[i7];
                parsableByteArray.l(bArr, 0, i7);
                immutableListZ = ImmutableList.z(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i3 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i3 == 1937010800) {
                j3 = 0;
            } else {
                if (i3 != 1664495672) {
                    throw new IllegalStateException();
                }
                stsdData.f46704d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        stsdData.f46702b = new Format.Builder().e0(i6).u0(str2).j0(str).y0(j3).g0(immutableListZ).N();
    }

    private static TkhdData E(ParsableByteArray parsableByteArray) {
        long j3;
        int i3;
        int i4;
        parsableByteArray.W(8);
        int iP = p(parsableByteArray.q());
        parsableByteArray.X(iP == 0 ? 8 : 16);
        int iQ = parsableByteArray.q();
        parsableByteArray.X(4);
        int iF = parsableByteArray.f();
        int i5 = iP == 0 ? 4 : 8;
        int i6 = 0;
        while (true) {
            j3 = -9223372036854775807L;
            if (i6 >= i5) {
                parsableByteArray.X(i5);
                break;
            }
            if (parsableByteArray.e()[iF + i6] != -1) {
                long J = iP == 0 ? parsableByteArray.J() : parsableByteArray.O();
                if (J != 0) {
                    j3 = J;
                }
            } else {
                i6++;
            }
        }
        parsableByteArray.X(10);
        long j4 = j3;
        int iP2 = parsableByteArray.P();
        parsableByteArray.X(4);
        int iQ2 = parsableByteArray.q();
        int iQ3 = parsableByteArray.q();
        parsableByteArray.X(4);
        int iQ4 = parsableByteArray.q();
        int iQ5 = parsableByteArray.q();
        if (iQ2 == 0 && iQ3 == 65536 && iQ4 == -65536 && iQ5 == 0) {
            i4 = 90;
        } else if (iQ2 == 0 && iQ3 == -65536 && iQ4 == 65536 && iQ5 == 0) {
            i4 = 270;
        } else {
            if (iQ2 != -65536 || iQ3 != 0 || iQ4 != 0 || iQ5 != -65536) {
                i3 = 0;
                return new TkhdData(iQ, j4, iP2, i3);
            }
            i4 = SensibleDefaults.X_OFFSET;
        }
        i3 = i4;
        return new TkhdData(iQ, j4, iP2, i3);
    }

    public static Track F(Mp4Box.ContainerBox containerBox, Mp4Box.LeafBox leafBox, long j3, DrmInitData drmInitData, boolean z2, boolean z3) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Format formatN;
        Mp4Box.ContainerBox containerBoxD;
        Pair pairL;
        Mp4Box.ContainerBox containerBox2 = (Mp4Box.ContainerBox) Assertions.e(containerBox.d(1835297121));
        int iE = e(q(((Mp4Box.LeafBox) Assertions.e(containerBox2.e(1751411826))).f41667b));
        if (iE == -1) {
            return null;
        }
        TkhdData tkhdDataE = E(((Mp4Box.LeafBox) Assertions.e(containerBox.e(1953196132))).f41667b);
        long j4 = j3 == -9223372036854775807L ? tkhdDataE.f46714b : j3;
        long j5 = v(leafBox.f41667b).f41673c;
        long jZ0 = j4 != -9223372036854775807L ? Util.Z0(j4, 1000000L, j5) : -9223372036854775807L;
        Mp4Box.ContainerBox containerBox3 = (Mp4Box.ContainerBox) Assertions.e(((Mp4Box.ContainerBox) Assertions.e(containerBox2.d(1835626086))).d(1937007212));
        MdhdData mdhdDataS = s(((Mp4Box.LeafBox) Assertions.e(containerBox2.e(1835296868))).f41667b);
        Mp4Box.LeafBox leafBoxE = containerBox3.e(1937011556);
        if (leafBoxE == null) {
            throw ParserException.a("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        StsdData stsdDataC = C(leafBoxE.f41667b, tkhdDataE.f46713a, tkhdDataE.f46716d, mdhdDataS.f46697c, drmInitData, z3);
        if (z2 || (containerBoxD = containerBox.d(1701082227)) == null || (pairL = l(containerBoxD)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairL.first;
            jArr2 = (long[]) pairL.second;
            jArr = jArr3;
        }
        if (stsdDataC.f46702b == null) {
            return null;
        }
        if (tkhdDataE.f46715c != 0) {
            Mp4AlternateGroupData mp4AlternateGroupData = new Mp4AlternateGroupData(tkhdDataE.f46715c);
            Format.Builder builderB = stsdDataC.f46702b.b();
            Metadata metadata = stsdDataC.f46702b.f40629l;
            formatN = builderB.n0(metadata != null ? metadata.a(mp4AlternateGroupData) : new Metadata(mp4AlternateGroupData)).N();
        } else {
            formatN = stsdDataC.f46702b;
        }
        return new Track(tkhdDataE.f46713a, iE, mdhdDataS.f46695a, j5, jZ0, mdhdDataS.f46696b, formatN, stsdDataC.f46704d, stsdDataC.f46701a, stsdDataC.f46703c, jArr, jArr2);
    }

    public static List G(Mp4Box.ContainerBox containerBox, GaplessInfoHolder gaplessInfoHolder, long j3, DrmInitData drmInitData, boolean z2, boolean z3, Function function) {
        Track track;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < containerBox.f41666d.size(); i3++) {
            Mp4Box.ContainerBox containerBox2 = (Mp4Box.ContainerBox) containerBox.f41666d.get(i3);
            if (containerBox2.f41663a == 1953653099 && (track = (Track) function.apply(F(containerBox2, (Mp4Box.LeafBox) Assertions.e(containerBox.e(1836476516)), j3, drmInitData, z2, z3))) != null) {
                arrayList.add(A(track, (Mp4Box.ContainerBox) Assertions.e(((Mp4Box.ContainerBox) Assertions.e(((Mp4Box.ContainerBox) Assertions.e(containerBox2.d(1835297121))).d(1835626086))).d(1937007212)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static Metadata H(Mp4Box.LeafBox leafBox) {
        ParsableByteArray parsableByteArray = leafBox.f41667b;
        parsableByteArray.W(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.a() >= 8) {
            int iF = parsableByteArray.f();
            int iQ = parsableByteArray.q();
            int iQ2 = parsableByteArray.q();
            if (iQ2 == 1835365473) {
                parsableByteArray.W(iF);
                metadata = metadata.b(I(parsableByteArray, iF + iQ));
            } else if (iQ2 == 1936553057) {
                parsableByteArray.W(iF);
                metadata = metadata.b(SmtaAtomUtil.b(parsableByteArray, iF + iQ));
            } else if (iQ2 == -1451722374) {
                metadata = metadata.b(L(parsableByteArray));
            }
            parsableByteArray.W(iF + iQ);
        }
        return metadata;
    }

    private static Metadata I(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.X(8);
        f(parsableByteArray);
        while (parsableByteArray.f() < i3) {
            int iF = parsableByteArray.f();
            int iQ = parsableByteArray.q();
            if (parsableByteArray.q() == 1768715124) {
                parsableByteArray.W(iF);
                return r(parsableByteArray, iF + iQ);
            }
            parsableByteArray.W(iF + iQ);
        }
        return null;
    }

    static VexuData J(ParsableByteArray parsableByteArray, int i3, int i4) throws ParserException {
        parsableByteArray.W(i3 + 8);
        int iF = parsableByteArray.f();
        EyesData eyesDataB = null;
        while (iF - i3 < i4) {
            parsableByteArray.W(iF);
            int iQ = parsableByteArray.q();
            ExtractorUtil.a(iQ > 0, "childAtomSize must be positive");
            if (parsableByteArray.q() == 1702454643) {
                eyesDataB = B(parsableByteArray, iF, iQ);
            }
            iF += iQ;
        }
        if (eyesDataB == null) {
            return null;
        }
        return new VexuData(eyesDataB);
    }

    private static void K(ParsableByteArray parsableByteArray, int i3, int i4, int i5, int i6, String str, int i7, DrmInitData drmInitData, StsdData stsdData, int i8) throws ParserException {
        int i9;
        String str2;
        int i10;
        DrmInitData drmInitData2;
        List list;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        NalUnitUtil.H265VpsData h265VpsData;
        int i17;
        int i18;
        int i19;
        int i20 = i4;
        int i21 = i5;
        DrmInitData drmInitDataD = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray.W(i20 + 16);
        parsableByteArray.X(16);
        int iP = parsableByteArray.P();
        int iP2 = parsableByteArray.P();
        parsableByteArray.X(50);
        int iF = parsableByteArray.f();
        int iIntValue = i3;
        if (iIntValue == 1701733238) {
            Pair pairY = y(parsableByteArray, i20, i21);
            if (pairY != null) {
                iIntValue = ((Integer) pairY.first).intValue();
                drmInitDataD = drmInitDataD == null ? null : drmInitDataD.d(((TrackEncryptionBox) pairY.second).f46832b);
                stsdData2.f46701a[i8] = (TrackEncryptionBox) pairY.second;
            }
            parsableByteArray.W(iF);
        }
        String str3 = "video/3gpp";
        String str4 = iIntValue == 1831958048 ? "video/mpeg" : iIntValue == 1211250227 ? "video/3gpp" : null;
        float fW = 1.0f;
        int i22 = 8;
        int i23 = 8;
        List listZ = null;
        String str5 = null;
        byte[] bArrX = null;
        int i24 = -1;
        int i25 = -1;
        int i26 = -1;
        int iN = -1;
        int i27 = -1;
        int iO = -1;
        ByteBuffer byteBufferA = null;
        BtrtData btrtDataJ = null;
        EsdsData esdsDataM = null;
        NalUnitUtil.H265VpsData h265VpsData2 = null;
        boolean z2 = false;
        while (iF - i20 < i21) {
            parsableByteArray.W(iF);
            int iF2 = parsableByteArray.f();
            int iQ = parsableByteArray.q();
            if (iQ == 0 && parsableByteArray.f() - i4 == i21) {
                break;
            }
            ExtractorUtil.a(iQ > 0, "childAtomSize must be positive");
            int iQ2 = parsableByteArray.q();
            if (iQ2 == 1635148611) {
                ExtractorUtil.a(str4 == null, null);
                parsableByteArray.W(iF2 + 8);
                AvcConfig avcConfigB = AvcConfig.b(parsableByteArray);
                List list2 = avcConfigB.f46052a;
                stsdData2.f46703c = avcConfigB.f46053b;
                if (!z2) {
                    fW = avcConfigB.f46062k;
                }
                String str6 = avcConfigB.f46063l;
                int i28 = avcConfigB.f46061j;
                int i29 = avcConfigB.f46058g;
                int i30 = avcConfigB.f46059h;
                listZ = list2;
                int i31 = avcConfigB.f46060i;
                int i32 = avcConfigB.f46056e;
                NalUnitUtil.H265VpsData h265VpsData3 = h265VpsData2;
                drmInitData2 = drmInitDataD;
                h265VpsData = h265VpsData3;
                i9 = iF;
                i11 = iIntValue;
                str2 = str3;
                iN = i29;
                i10 = i30;
                iO = i31;
                i23 = avcConfigB.f46057f;
                i22 = i32;
                str5 = str6;
                str4 = "video/avc";
                i25 = i28;
            } else {
                i9 = iF;
                if (iQ2 == 1752589123) {
                    ExtractorUtil.a(str4 == null, null);
                    parsableByteArray.W(iF2 + 8);
                    HevcConfig hevcConfigA = HevcConfig.a(parsableByteArray);
                    List list3 = hevcConfigA.f46177a;
                    stsdData2.f46703c = hevcConfigA.f46178b;
                    if (!z2) {
                        fW = hevcConfigA.f46188l;
                    }
                    int i33 = hevcConfigA.f46189m;
                    int i34 = hevcConfigA.f46179c;
                    String str7 = hevcConfigA.f46190n;
                    int i35 = hevcConfigA.f46187k;
                    listZ = list3;
                    if (i35 != -1) {
                        i24 = i35;
                    }
                    int i36 = hevcConfigA.f46184h;
                    int i37 = hevcConfigA.f46185i;
                    int i38 = hevcConfigA.f46186j;
                    int i39 = hevcConfigA.f46182f;
                    int i40 = hevcConfigA.f46183g;
                    drmInitData2 = drmInitDataD;
                    i11 = iIntValue;
                    str2 = str3;
                    i10 = i37;
                    iN = i36;
                    iO = i38;
                    i22 = i39;
                    h265VpsData = hevcConfigA.f46191o;
                    i25 = i33;
                    i26 = i34;
                    str5 = str7;
                    i23 = i40;
                    str4 = "video/hevc";
                } else {
                    str2 = str3;
                    if (iQ2 == 1818785347) {
                        ExtractorUtil.a("video/hevc".equals(str4), "lhvC must follow hvcC atom");
                        NalUnitUtil.H265VpsData h265VpsData4 = h265VpsData2;
                        ExtractorUtil.a(h265VpsData4 != null && h265VpsData4.f41727b.size() >= 2, "must have at least two layers");
                        parsableByteArray.W(iF2 + 8);
                        HevcConfig hevcConfigC = HevcConfig.c(parsableByteArray, (NalUnitUtil.H265VpsData) Assertions.e(h265VpsData4));
                        ExtractorUtil.a(stsdData2.f46703c == hevcConfigC.f46178b, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                        int i41 = hevcConfigC.f46184h;
                        int i42 = iN;
                        if (i41 != -1) {
                            ExtractorUtil.a(i42 == i41, "colorSpace must be the same for both views");
                        }
                        int i43 = hevcConfigC.f46185i;
                        int i44 = i27;
                        if (i43 != -1) {
                            ExtractorUtil.a(i44 == i43, "colorRange must be the same for both views");
                        }
                        int i45 = hevcConfigC.f46186j;
                        if (i45 != -1) {
                            int i46 = iO;
                            i18 = i46;
                            ExtractorUtil.a(i46 == i45, "colorTransfer must be the same for both views");
                        } else {
                            i18 = iO;
                        }
                        ExtractorUtil.a(i22 == hevcConfigC.f46182f, "bitdepthLuma must be the same for both views");
                        ExtractorUtil.a(i23 == hevcConfigC.f46183g, "bitdepthChroma must be the same for both views");
                        List listM = listZ;
                        if (listM != null) {
                            listM = ImmutableList.o().k(listM).k(hevcConfigC.f46177a).m();
                            i19 = i42;
                        } else {
                            i19 = i42;
                            ExtractorUtil.a(false, "initializationData must be already set from hvcC atom");
                        }
                        str4 = "video/mv-hevc";
                        drmInitData2 = drmInitDataD;
                        i11 = iIntValue;
                        i10 = i44;
                        iN = i19;
                        iO = i18;
                        str5 = hevcConfigC.f46190n;
                        h265VpsData = h265VpsData4;
                        listZ = listM;
                    } else {
                        List listI = listZ;
                        int i47 = iN;
                        i10 = i27;
                        int i48 = iO;
                        NalUnitUtil.H265VpsData h265VpsData5 = h265VpsData2;
                        if (iQ2 == 1986361461) {
                            VexuData vexuDataJ = J(parsableByteArray, iF2, iQ);
                            if (vexuDataJ == null || vexuDataJ.f46717a == null) {
                                i17 = i24;
                                i24 = i17;
                                drmInitData2 = drmInitDataD;
                                listZ = listI;
                                i11 = iIntValue;
                                iN = i47;
                                iO = i48;
                                h265VpsData = h265VpsData5;
                            } else if (h265VpsData5 == null || h265VpsData5.f41727b.size() < 2) {
                                i17 = i24;
                                if (i17 == -1) {
                                    i24 = vexuDataJ.f46717a.f46694a.f46700c ? 5 : 4;
                                } else {
                                    i24 = i17;
                                }
                                drmInitData2 = drmInitDataD;
                                listZ = listI;
                                i11 = iIntValue;
                                iN = i47;
                                iO = i48;
                                h265VpsData = h265VpsData5;
                            } else {
                                ExtractorUtil.a(vexuDataJ.b(), "both eye views must be marked as available");
                                ExtractorUtil.a(!vexuDataJ.f46717a.f46694a.f46700c, "for MV-HEVC, eye_views_reversed must be set to false");
                                i17 = i24;
                                i24 = i17;
                                drmInitData2 = drmInitDataD;
                                listZ = listI;
                                i11 = iIntValue;
                                iN = i47;
                                iO = i48;
                                h265VpsData = h265VpsData5;
                            }
                        } else {
                            int i49 = i24;
                            if (iQ2 == 1685480259 || iQ2 == 1685485123) {
                                drmInitData2 = drmInitDataD;
                                list = listI;
                                i11 = iIntValue;
                                i12 = i49;
                                i13 = i23;
                                i14 = i22;
                                i15 = i47;
                                i16 = i48;
                                DolbyVisionConfig dolbyVisionConfigA = DolbyVisionConfig.a(parsableByteArray);
                                if (dolbyVisionConfigA != null) {
                                    str4 = "video/dolby-vision";
                                    str5 = dolbyVisionConfigA.f46133c;
                                }
                            } else if (iQ2 == 1987076931) {
                                ExtractorUtil.a(str4 == null, null);
                                String str8 = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                parsableByteArray.W(iF2 + 12);
                                byte bH = (byte) parsableByteArray.H();
                                byte bH2 = (byte) parsableByteArray.H();
                                int iH = parsableByteArray.H();
                                i22 = iH >> 4;
                                i11 = iIntValue;
                                byte b3 = (byte) ((iH >> 1) & 7);
                                if (str8.equals("video/x-vnd.on2.vp9")) {
                                    listI = CodecSpecificDataUtil.i(bH, bH2, (byte) i22, b3);
                                }
                                boolean z3 = (iH & 1) != 0;
                                int iH2 = parsableByteArray.H();
                                int iH3 = parsableByteArray.H();
                                iN = ColorInfo.n(iH2);
                                int i50 = z3 ? 1 : 2;
                                iO = ColorInfo.o(iH3);
                                str4 = str8;
                                drmInitData2 = drmInitDataD;
                                i23 = i22;
                                i10 = i50;
                                h265VpsData = h265VpsData5;
                                listZ = listI;
                                i24 = i49;
                            } else {
                                i11 = iIntValue;
                                if (iQ2 == 1635135811) {
                                    int i51 = iQ - 8;
                                    byte[] bArr = new byte[i51];
                                    parsableByteArray.l(bArr, 0, i51);
                                    listZ = ImmutableList.z(bArr);
                                    parsableByteArray.W(iF2 + 8);
                                    ColorInfo colorInfoI = i(parsableByteArray);
                                    int i52 = colorInfoI.f40558e;
                                    int i53 = colorInfoI.f40559f;
                                    int i54 = colorInfoI.f40554a;
                                    int i55 = colorInfoI.f40555b;
                                    iO = colorInfoI.f40556c;
                                    i22 = i52;
                                    drmInitData2 = drmInitDataD;
                                    i23 = i53;
                                    iN = i54;
                                    i10 = i55;
                                    str4 = "video/av01";
                                    h265VpsData = h265VpsData5;
                                } else if (iQ2 == 1668050025) {
                                    if (byteBufferA == null) {
                                        byteBufferA = a();
                                    }
                                    ByteBuffer byteBuffer = byteBufferA;
                                    byteBuffer.position(21);
                                    byteBuffer.putShort(parsableByteArray.D());
                                    byteBuffer.putShort(parsableByteArray.D());
                                    byteBufferA = byteBuffer;
                                    drmInitData2 = drmInitDataD;
                                    listZ = listI;
                                    h265VpsData = h265VpsData5;
                                    iN = i47;
                                    iO = i48;
                                } else if (iQ2 == 1835295606) {
                                    if (byteBufferA == null) {
                                        byteBufferA = a();
                                    }
                                    ByteBuffer byteBuffer2 = byteBufferA;
                                    short sD = parsableByteArray.D();
                                    short sD2 = parsableByteArray.D();
                                    short sD3 = parsableByteArray.D();
                                    short sD4 = parsableByteArray.D();
                                    int i56 = i23;
                                    short sD5 = parsableByteArray.D();
                                    int i57 = i22;
                                    short sD6 = parsableByteArray.D();
                                    drmInitData2 = drmInitDataD;
                                    short sD7 = parsableByteArray.D();
                                    short sD8 = parsableByteArray.D();
                                    long J = parsableByteArray.J();
                                    long J2 = parsableByteArray.J();
                                    byteBuffer2.position(1);
                                    byteBuffer2.putShort(sD5);
                                    byteBuffer2.putShort(sD6);
                                    byteBuffer2.putShort(sD);
                                    byteBuffer2.putShort(sD2);
                                    byteBuffer2.putShort(sD3);
                                    byteBuffer2.putShort(sD4);
                                    byteBuffer2.putShort(sD7);
                                    byteBuffer2.putShort(sD8);
                                    byteBuffer2.putShort((short) (J / 10000));
                                    byteBuffer2.putShort((short) (J2 / 10000));
                                    byteBufferA = byteBuffer2;
                                    h265VpsData = h265VpsData5;
                                    i23 = i56;
                                    i22 = i57;
                                    iN = i47;
                                    iO = i48;
                                    listZ = listI;
                                    i24 = i49;
                                } else {
                                    drmInitData2 = drmInitDataD;
                                    list = listI;
                                    i12 = i49;
                                    i13 = i23;
                                    i14 = i22;
                                    if (iQ2 == 1681012275) {
                                        ExtractorUtil.a(str4 == null, null);
                                        h265VpsData = h265VpsData5;
                                        i23 = i13;
                                        i22 = i14;
                                        str4 = str2;
                                    } else if (iQ2 == 1702061171) {
                                        ExtractorUtil.a(str4 == null, null);
                                        esdsDataM = m(parsableByteArray, iF2);
                                        String str9 = esdsDataM.f46690a;
                                        byte[] bArr2 = esdsDataM.f46691b;
                                        listZ = bArr2 != null ? ImmutableList.z(bArr2) : list;
                                        str4 = str9;
                                        h265VpsData = h265VpsData5;
                                        i23 = i13;
                                        i22 = i14;
                                        iN = i47;
                                        iO = i48;
                                        i24 = i12;
                                    } else {
                                        if (iQ2 == 1651798644) {
                                            btrtDataJ = j(parsableByteArray, iF2);
                                        } else if (iQ2 == 1885434736) {
                                            fW = w(parsableByteArray, iF2);
                                            h265VpsData = h265VpsData5;
                                            i23 = i13;
                                            i22 = i14;
                                            iN = i47;
                                            iO = i48;
                                            listZ = list;
                                            i24 = i12;
                                            z2 = true;
                                        } else if (iQ2 == 1937126244) {
                                            bArrX = x(parsableByteArray, iF2, iQ);
                                        } else if (iQ2 == 1936995172) {
                                            int iH4 = parsableByteArray.H();
                                            parsableByteArray.X(3);
                                            if (iH4 == 0) {
                                                int iH5 = parsableByteArray.H();
                                                if (iH5 == 0) {
                                                    i12 = 0;
                                                } else if (iH5 == 1) {
                                                    i12 = 1;
                                                } else if (iH5 == 2) {
                                                    i12 = 2;
                                                } else if (iH5 == 3) {
                                                    i12 = 3;
                                                }
                                            }
                                        } else {
                                            if (iQ2 == 1634760259) {
                                                int i58 = iQ - 12;
                                                byte[] bArr3 = new byte[i58];
                                                parsableByteArray.W(iF2 + 12);
                                                parsableByteArray.l(bArr3, 0, i58);
                                                listZ = ImmutableList.z(bArr3);
                                                ColorInfo colorInfoG = g(new ParsableByteArray(bArr3));
                                                int i59 = colorInfoG.f40558e;
                                                int i60 = colorInfoG.f40559f;
                                                int i61 = colorInfoG.f40554a;
                                                int i62 = colorInfoG.f40555b;
                                                iO = colorInfoG.f40556c;
                                                i22 = i59;
                                                i23 = i60;
                                                iN = i61;
                                                i10 = i62;
                                                str4 = "video/apv";
                                                h265VpsData = h265VpsData5;
                                                i24 = i12;
                                            } else {
                                                i15 = i47;
                                                if (iQ2 == 1668246642) {
                                                    i16 = i48;
                                                    if (i15 == -1 && i16 == -1) {
                                                        int iQ3 = parsableByteArray.q();
                                                        if (iQ3 == 1852009592 || iQ3 == 1852009571) {
                                                            int iP3 = parsableByteArray.P();
                                                            int iP4 = parsableByteArray.P();
                                                            parsableByteArray.X(2);
                                                            boolean z4 = iQ == 19 && (parsableByteArray.H() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
                                                            int iN2 = ColorInfo.n(iP3);
                                                            i10 = z4 ? 1 : 2;
                                                            i23 = i13;
                                                            i22 = i14;
                                                            listZ = list;
                                                            iN = iN2;
                                                            iO = ColorInfo.o(iP4);
                                                            h265VpsData = h265VpsData5;
                                                            i24 = i12;
                                                        } else {
                                                            Log.i("BoxParsers", "Unsupported color type: " + Mp4Box.a(iQ3));
                                                        }
                                                    }
                                                } else {
                                                    i16 = i48;
                                                }
                                            }
                                        }
                                        h265VpsData = h265VpsData5;
                                        i23 = i13;
                                        i22 = i14;
                                    }
                                    iN = i47;
                                    iO = i48;
                                    listZ = list;
                                    i24 = i12;
                                }
                                i24 = i49;
                            }
                            i23 = i13;
                            i22 = i14;
                            listZ = list;
                            iO = i16;
                            iN = i15;
                            h265VpsData = h265VpsData5;
                            i24 = i12;
                        }
                    }
                }
            }
            DrmInitData drmInitData3 = drmInitData2;
            h265VpsData2 = h265VpsData;
            drmInitDataD = drmInitData3;
            i20 = i4;
            i21 = i5;
            iF = i9 + iQ;
            iIntValue = i11;
            str3 = str2;
            i27 = i10;
            stsdData2 = stsdData;
        }
        DrmInitData drmInitData4 = drmInitDataD;
        List list4 = listZ;
        int i63 = i24;
        int i64 = iN;
        int i65 = i27;
        int i66 = iO;
        int i67 = i23;
        int i68 = i22;
        if (str4 == null) {
            return;
        }
        Format.Builder builderT = new Format.Builder().e0(i6).u0(str4).S(str5).B0(iP).d0(iP2).q0(fW).t0(i7).r0(bArrX).x0(i63).g0(list4).l0(i25).m0(i26).Y(drmInitData4).j0(str).T(new ColorInfo.Builder().d(i64).c(i65).e(i66).f(byteBufferA != null ? byteBufferA.array() : null).g(i68).b(i67).a());
        if (btrtDataJ != null) {
            builderT.Q(Ints.m(btrtDataJ.f46679a)).p0(Ints.m(btrtDataJ.f46680b));
        } else if (esdsDataM != null) {
            builderT.Q(Ints.m(esdsDataM.f46692c)).p0(Ints.m(esdsDataM.f46693d));
        }
        stsdData.f46702b = builderT.N();
    }

    private static Metadata L(ParsableByteArray parsableByteArray) {
        short sD = parsableByteArray.D();
        parsableByteArray.X(2);
        String strE = parsableByteArray.E(sD);
        int iMax = Math.max(strE.lastIndexOf(43), strE.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(strE.substring(0, iMax)), Float.parseFloat(strE.substring(iMax, strE.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j3, long j4, long j5) {
        int length = jArr.length - 1;
        return jArr[0] <= j4 && j4 < jArr[Util.r(4, 0, length)] && jArr[Util.r(jArr.length - 4, 0, length)] < j5 && j5 <= j3;
    }

    private static int c(ParsableByteArray parsableByteArray, int i3, int i4, int i5) throws ParserException {
        int iF = parsableByteArray.f();
        ExtractorUtil.a(iF >= i4, null);
        while (iF - i4 < i5) {
            parsableByteArray.W(iF);
            int iQ = parsableByteArray.q();
            ExtractorUtil.a(iQ > 0, "childAtomSize must be positive");
            if (parsableByteArray.q() == i3) {
                return iF;
            }
            iF += iQ;
        }
        return -1;
    }

    private static String d(int i3) {
        char[] cArr = {(char) (((i3 >> 10) & 31) + 96), (char) (((i3 >> 5) & 31) + 96), (char) ((i3 & 31) + 96)};
        for (int i4 = 0; i4 < 3; i4++) {
            char c3 = cArr[i4];
            if (c3 < 'a' || c3 > 'z') {
                return null;
            }
        }
        return new String(cArr);
    }

    private static int e(int i3) {
        if (i3 == 1936684398) {
            return 1;
        }
        if (i3 == 1986618469) {
            return 2;
        }
        if (i3 == 1952807028 || i3 == 1935832172 || i3 == 1937072756 || i3 == 1668047728) {
            return 3;
        }
        return i3 == 1835365473 ? 5 : -1;
    }

    public static void f(ParsableByteArray parsableByteArray) {
        int iF = parsableByteArray.f();
        parsableByteArray.X(4);
        if (parsableByteArray.q() != 1751411826) {
            iF += 4;
        }
        parsableByteArray.W(iF);
    }

    private static ColorInfo g(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.e());
        parsableBitArray.p(parsableByteArray.f() * 8);
        parsableBitArray.s(1);
        int iH = parsableBitArray.h(8);
        for (int i3 = 0; i3 < iH; i3++) {
            parsableBitArray.s(1);
            int iH2 = parsableBitArray.h(8);
            for (int i4 = 0; i4 < iH2; i4++) {
                parsableBitArray.r(6);
                boolean zG = parsableBitArray.g();
                parsableBitArray.q();
                parsableBitArray.s(11);
                parsableBitArray.r(4);
                int iH3 = parsableBitArray.h(4) + 8;
                builder.g(iH3);
                builder.b(iH3);
                parsableBitArray.s(1);
                if (zG) {
                    int iH4 = parsableBitArray.h(8);
                    int iH5 = parsableBitArray.h(8);
                    parsableBitArray.s(1);
                    builder.d(ColorInfo.n(iH4)).c(parsableBitArray.g() ? 1 : 2).e(ColorInfo.o(iH5));
                }
            }
        }
        return builder.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(androidx.media3.common.util.ParsableByteArray r25, int r26, int r27, int r28, int r29, java.lang.String r30, boolean r31, androidx.media3.common.DrmInitData r32, androidx.media3.extractor.mp4.BoxParser.StsdData r33, int r34) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instruction units count: 1209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.BoxParser.h(androidx.media3.common.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, androidx.media3.common.DrmInitData, androidx.media3.extractor.mp4.BoxParser$StsdData, int):void");
    }

    private static ColorInfo i(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.e());
        parsableBitArray.p(parsableByteArray.f() * 8);
        parsableBitArray.s(1);
        int iH = parsableBitArray.h(3);
        parsableBitArray.r(6);
        boolean zG = parsableBitArray.g();
        boolean zG2 = parsableBitArray.g();
        if (iH == 2 && zG) {
            builder.g(zG2 ? 12 : 10);
            builder.b(zG2 ? 12 : 10);
        } else if (iH <= 2) {
            builder.g(zG ? 10 : 8);
            builder.b(zG ? 10 : 8);
        }
        parsableBitArray.r(13);
        parsableBitArray.q();
        int iH2 = parsableBitArray.h(4);
        if (iH2 != 1) {
            Log.g("BoxParsers", "Unsupported obu_type: " + iH2);
            return builder.a();
        }
        if (parsableBitArray.g()) {
            Log.g("BoxParsers", "Unsupported obu_extension_flag");
            return builder.a();
        }
        boolean zG3 = parsableBitArray.g();
        parsableBitArray.q();
        if (zG3 && parsableBitArray.h(8) > 127) {
            Log.g("BoxParsers", "Excessive obu_size");
            return builder.a();
        }
        int iH3 = parsableBitArray.h(3);
        parsableBitArray.q();
        if (parsableBitArray.g()) {
            Log.g("BoxParsers", "Unsupported reduced_still_picture_header");
            return builder.a();
        }
        if (parsableBitArray.g()) {
            Log.g("BoxParsers", "Unsupported timing_info_present_flag");
            return builder.a();
        }
        if (parsableBitArray.g()) {
            Log.g("BoxParsers", "Unsupported initial_display_delay_present_flag");
            return builder.a();
        }
        int iH4 = parsableBitArray.h(5);
        boolean z2 = false;
        for (int i3 = 0; i3 <= iH4; i3++) {
            parsableBitArray.r(12);
            if (parsableBitArray.h(5) > 7) {
                parsableBitArray.q();
            }
        }
        int iH5 = parsableBitArray.h(4);
        int iH6 = parsableBitArray.h(4);
        parsableBitArray.r(iH5 + 1);
        parsableBitArray.r(iH6 + 1);
        if (parsableBitArray.g()) {
            parsableBitArray.r(7);
        }
        parsableBitArray.r(7);
        boolean zG4 = parsableBitArray.g();
        if (zG4) {
            parsableBitArray.r(2);
        }
        if ((parsableBitArray.g() ? 2 : parsableBitArray.h(1)) > 0 && !parsableBitArray.g()) {
            parsableBitArray.r(1);
        }
        if (zG4) {
            parsableBitArray.r(3);
        }
        parsableBitArray.r(3);
        boolean zG5 = parsableBitArray.g();
        if (iH3 == 2 && zG5) {
            parsableBitArray.q();
        }
        if (iH3 != 1 && parsableBitArray.g()) {
            z2 = true;
        }
        if (parsableBitArray.g()) {
            int iH7 = parsableBitArray.h(8);
            int iH8 = parsableBitArray.h(8);
            builder.d(ColorInfo.n(iH7)).c(((z2 || iH7 != 1 || iH8 != 13 || parsableBitArray.h(8) != 0) ? parsableBitArray.h(1) : 1) != 1 ? 2 : 1).e(ColorInfo.o(iH8));
        }
        return builder.a();
    }

    private static BtrtData j(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.W(i3 + 8);
        parsableByteArray.X(4);
        return new BtrtData(parsableByteArray.J(), parsableByteArray.J());
    }

    static Pair k(ParsableByteArray parsableByteArray, int i3, int i4) throws ParserException {
        int i5 = i3 + 8;
        int i6 = -1;
        int i7 = 0;
        String strE = null;
        Integer numValueOf = null;
        while (i5 - i3 < i4) {
            parsableByteArray.W(i5);
            int iQ = parsableByteArray.q();
            int iQ2 = parsableByteArray.q();
            if (iQ2 == 1718775137) {
                numValueOf = Integer.valueOf(parsableByteArray.q());
            } else if (iQ2 == 1935894637) {
                parsableByteArray.X(4);
                strE = parsableByteArray.E(4);
            } else if (iQ2 == 1935894633) {
                i6 = i5;
                i7 = iQ;
            }
            i5 += iQ;
        }
        if (!"cenc".equals(strE) && !"cbc1".equals(strE) && !"cens".equals(strE) && !"cbcs".equals(strE)) {
            return null;
        }
        ExtractorUtil.a(numValueOf != null, "frma atom is mandatory");
        ExtractorUtil.a(i6 != -1, "schi atom is mandatory");
        TrackEncryptionBox trackEncryptionBoxZ = z(parsableByteArray, i6, i7, strE);
        ExtractorUtil.a(trackEncryptionBoxZ != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Util.k(trackEncryptionBoxZ));
    }

    private static Pair l(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxE = containerBox.e(1701606260);
        if (leafBoxE == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxE.f41667b;
        parsableByteArray.W(8);
        int iP = p(parsableByteArray.q());
        int iL = parsableByteArray.L();
        long[] jArr = new long[iL];
        long[] jArr2 = new long[iL];
        for (int i3 = 0; i3 < iL; i3++) {
            jArr[i3] = iP == 1 ? parsableByteArray.O() : parsableByteArray.J();
            jArr2[i3] = iP == 1 ? parsableByteArray.A() : parsableByteArray.q();
            if (parsableByteArray.D() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.X(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static EsdsData m(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.W(i3 + 12);
        parsableByteArray.X(1);
        n(parsableByteArray);
        parsableByteArray.X(2);
        int iH = parsableByteArray.H();
        if ((iH & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            parsableByteArray.X(2);
        }
        if ((iH & 64) != 0) {
            parsableByteArray.X(parsableByteArray.H());
        }
        if ((iH & 32) != 0) {
            parsableByteArray.X(2);
        }
        parsableByteArray.X(1);
        n(parsableByteArray);
        String strG = MimeTypes.g(parsableByteArray.H());
        if ("audio/mpeg".equals(strG) || "audio/vnd.dts".equals(strG) || "audio/vnd.dts.hd".equals(strG)) {
            return new EsdsData(strG, null, -1L, -1L);
        }
        parsableByteArray.X(4);
        long J = parsableByteArray.J();
        long J2 = parsableByteArray.J();
        parsableByteArray.X(1);
        int iN = n(parsableByteArray);
        long j3 = J2;
        byte[] bArr = new byte[iN];
        parsableByteArray.l(bArr, 0, iN);
        if (j3 <= 0) {
            j3 = -1;
        }
        return new EsdsData(strG, bArr, j3, J > 0 ? J : -1L);
    }

    private static int n(ParsableByteArray parsableByteArray) {
        int iH = parsableByteArray.H();
        int i3 = iH & 127;
        while ((iH & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128) {
            iH = parsableByteArray.H();
            i3 = (i3 << 7) | (iH & 127);
        }
        return i3;
    }

    public static int o(int i3) {
        return i3 & 16777215;
    }

    public static int p(int i3) {
        return (i3 >> 24) & 255;
    }

    private static int q(ParsableByteArray parsableByteArray) {
        parsableByteArray.W(16);
        return parsableByteArray.q();
    }

    private static Metadata r(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.X(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.f() < i3) {
            Metadata.Entry entryD = MetadataUtil.d(parsableByteArray);
            if (entryD != null) {
                arrayList.add(entryD);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static MdhdData s(ParsableByteArray parsableByteArray) {
        long j3;
        parsableByteArray.W(8);
        int iP = p(parsableByteArray.q());
        parsableByteArray.X(iP == 0 ? 8 : 16);
        long J = parsableByteArray.J();
        int iF = parsableByteArray.f();
        int i3 = iP == 0 ? 4 : 8;
        int i4 = 0;
        while (true) {
            j3 = -9223372036854775807L;
            if (i4 >= i3) {
                parsableByteArray.X(i3);
                break;
            }
            if (parsableByteArray.e()[iF + i4] != -1) {
                long J2 = iP == 0 ? parsableByteArray.J() : parsableByteArray.O();
                if (J2 != 0) {
                    long jZ0 = Util.Z0(J2, 1000000L, J);
                    J = J;
                    j3 = jZ0;
                }
            } else {
                i4++;
            }
        }
        return new MdhdData(J, j3, d(parsableByteArray.P()));
    }

    public static Metadata t(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxE = containerBox.e(1751411826);
        Mp4Box.LeafBox leafBoxE2 = containerBox.e(1801812339);
        Mp4Box.LeafBox leafBoxE3 = containerBox.e(1768715124);
        if (leafBoxE == null || leafBoxE2 == null || leafBoxE3 == null || q(leafBoxE.f41667b) != 1835299937) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxE2.f41667b;
        parsableByteArray.W(12);
        int iQ = parsableByteArray.q();
        String[] strArr = new String[iQ];
        for (int i3 = 0; i3 < iQ; i3++) {
            int iQ2 = parsableByteArray.q();
            parsableByteArray.X(4);
            strArr[i3] = parsableByteArray.E(iQ2 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafBoxE3.f41667b;
        parsableByteArray2.W(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.a() > 8) {
            int iF = parsableByteArray2.f();
            int iQ3 = parsableByteArray2.q();
            int iQ4 = parsableByteArray2.q() - 1;
            if (iQ4 < 0 || iQ4 >= iQ) {
                Log.i("BoxParsers", "Skipped metadata with unknown key index: " + iQ4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryI = MetadataUtil.i(parsableByteArray2, iF + iQ3, strArr[iQ4]);
                if (mdtaMetadataEntryI != null) {
                    arrayList.add(mdtaMetadataEntryI);
                }
            }
            parsableByteArray2.W(iF + iQ3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static void u(ParsableByteArray parsableByteArray, int i3, int i4, int i5, StsdData stsdData) {
        parsableByteArray.W(i4 + 16);
        if (i3 == 1835365492) {
            parsableByteArray.B();
            String strB = parsableByteArray.B();
            if (strB != null) {
                stsdData.f46702b = new Format.Builder().e0(i5).u0(strB).N();
            }
        }
    }

    public static Mp4TimestampData v(ParsableByteArray parsableByteArray) {
        long jA;
        long jA2;
        parsableByteArray.W(8);
        if (p(parsableByteArray.q()) == 0) {
            jA = parsableByteArray.J();
            jA2 = parsableByteArray.J();
        } else {
            jA = parsableByteArray.A();
            jA2 = parsableByteArray.A();
        }
        return new Mp4TimestampData(jA, jA2, parsableByteArray.J());
    }

    private static float w(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.W(i3 + 8);
        return parsableByteArray.L() / parsableByteArray.L();
    }

    private static byte[] x(ParsableByteArray parsableByteArray, int i3, int i4) {
        int i5 = i3 + 8;
        while (i5 - i3 < i4) {
            parsableByteArray.W(i5);
            int iQ = parsableByteArray.q();
            if (parsableByteArray.q() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.e(), i5, iQ + i5);
            }
            i5 += iQ;
        }
        return null;
    }

    private static Pair y(ParsableByteArray parsableByteArray, int i3, int i4) throws ParserException {
        Pair pairK;
        int iF = parsableByteArray.f();
        while (iF - i3 < i4) {
            parsableByteArray.W(iF);
            int iQ = parsableByteArray.q();
            ExtractorUtil.a(iQ > 0, "childAtomSize must be positive");
            if (parsableByteArray.q() == 1936289382 && (pairK = k(parsableByteArray, iF, iQ)) != null) {
                return pairK;
            }
            iF += iQ;
        }
        return null;
    }

    private static TrackEncryptionBox z(ParsableByteArray parsableByteArray, int i3, int i4, String str) {
        int i5;
        int i6;
        int i7 = i3 + 8;
        while (true) {
            byte[] bArr = null;
            if (i7 - i3 >= i4) {
                return null;
            }
            parsableByteArray.W(i7);
            int iQ = parsableByteArray.q();
            if (parsableByteArray.q() == 1952804451) {
                int iP = p(parsableByteArray.q());
                parsableByteArray.X(1);
                if (iP == 0) {
                    parsableByteArray.X(1);
                    i6 = 0;
                    i5 = 0;
                } else {
                    int iH = parsableByteArray.H();
                    i5 = iH & 15;
                    i6 = (iH & 240) >> 4;
                }
                boolean z2 = parsableByteArray.H() == 1;
                int iH2 = parsableByteArray.H();
                byte[] bArr2 = new byte[16];
                parsableByteArray.l(bArr2, 0, 16);
                if (z2 && iH2 == 0) {
                    int iH3 = parsableByteArray.H();
                    bArr = new byte[iH3];
                    parsableByteArray.l(bArr, 0, iH3);
                }
                return new TrackEncryptionBox(z2, str, iH2, bArr2, i6, i5, bArr);
            }
            i7 += iQ;
        }
    }
}
