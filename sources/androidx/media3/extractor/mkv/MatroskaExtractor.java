package androidx.media3.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MatroskaExtractor implements Extractor {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final ExtractorsFactory f46551f0 = new ExtractorsFactory() { // from class: androidx.media3.extractor.mkv.a
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return MatroskaExtractor.b();
        }
    };

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final byte[] f46552g0 = {Framer.STDOUT_FRAME_PREFIX, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final byte[] f46553h0 = Util.t0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final byte[] f46554i0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final byte[] f46555j0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final UUID f46556k0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final Map f46557l0;
    private long A;
    private boolean B;
    private long C;
    private long D;
    private long E;
    private LongArray F;
    private LongArray G;
    private boolean H;
    private boolean I;
    private int J;
    private long K;
    private long L;
    private int M;
    private int N;
    private int[] O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private boolean T;
    private long U;
    private int V;
    private int W;
    private int X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EbmlReader f46558a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f46559a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VarintReader f46560b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f46561b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f46562c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private byte f46563c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f46564d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f46565d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f46566e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private ExtractorOutput f46567e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SubtitleParser.Factory f46568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ParsableByteArray f46569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ParsableByteArray f46570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ParsableByteArray f46571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ParsableByteArray f46572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ParsableByteArray f46573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ParsableByteArray f46574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ParsableByteArray f46575m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ParsableByteArray f46576n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ParsableByteArray f46577o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ParsableByteArray f46578p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ByteBuffer f46579q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f46580r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f46581s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f46582t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f46583u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f46584v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f46585w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Track f46586x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f46587y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f46588z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void a(int i3) throws ParserException {
            MatroskaExtractor.this.q(i3);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void b(int i3, double d3) {
            MatroskaExtractor.this.t(i3, d3);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void c(int i3, int i4, ExtractorInput extractorInput) throws ParserException {
            MatroskaExtractor.this.n(i3, i4, extractorInput);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void d(int i3, long j3) throws ParserException {
            MatroskaExtractor.this.z(i3, j3);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public int e(int i3) {
            return MatroskaExtractor.this.w(i3);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public boolean f(int i3) {
            return MatroskaExtractor.this.B(i3);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void g(int i3, String str) throws ParserException {
            MatroskaExtractor.this.I(i3, str);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void h(int i3, long j3, long j4) throws ParserException {
            MatroskaExtractor.this.H(i3, j3, j4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class Track {
        public byte[] P;
        public TrueHdSampleRechunker V;
        public boolean W;
        public TrackOutput Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f46590a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f46591a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f46592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f46593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f46594d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f46595e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f46596f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f46597g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f46598h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f46599i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte[] f46600j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public TrackOutput.CryptoData f46601k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public byte[] f46602l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public DrmInitData f46603m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f46604n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f46605o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f46606p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f46607q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f46608r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f46609s = 0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f46610t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f46611u = 0.0f;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public float f46612v = 0.0f;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public float f46613w = 0.0f;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public byte[] f46614x = null;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f46615y = -1;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f46616z = false;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = 1000;
        public int E = 200;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public float N = -1.0f;
        public float O = -1.0f;
        public int Q = 1;
        public int R = -1;
        public int S = 8000;
        public long T = 0;
        public long U = 0;
        public boolean X = true;
        private String Y = "eng";

        protected Track() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            Assertions.e(this.Z);
        }

        private byte[] g(String str) throws ParserException {
            byte[] bArr = this.f46602l;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.a("Missing CodecPrivate for codec " + str, null);
        }

        private byte[] h() {
            if (this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f || this.N == -1.0f || this.O == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.F * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.G * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.H * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.I * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.J * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.K * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.L * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.M * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.N + 0.5f));
            byteBufferOrder.putShort((short) (this.O + 0.5f));
            byteBufferOrder.putShort((short) this.D);
            byteBufferOrder.putShort((short) this.E);
            return bArr;
        }

        private static Pair k(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.X(16);
                long jX = parsableByteArray.x();
                if (jX == 1482049860) {
                    return new Pair("video/divx", null);
                }
                if (jX == 859189832) {
                    return new Pair("video/3gpp", null);
                }
                if (jX != 826496599) {
                    Log.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair("video/x-unknown", null);
                }
                byte[] bArrE = parsableByteArray.e();
                for (int iF = parsableByteArray.f() + 20; iF < bArrE.length - 4; iF++) {
                    if (bArrE[iF] == 0 && bArrE[iF + 1] == 0 && bArrE[iF + 2] == 1 && bArrE[iF + 3] == 15) {
                        return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrE, iF, bArrE.length)));
                    }
                }
                throw ParserException.a("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing FourCC private data", null);
            }
        }

        private static boolean l(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int iZ = parsableByteArray.z();
                if (iZ == 1) {
                    return true;
                }
                if (iZ == 65534) {
                    parsableByteArray.W(24);
                    if (parsableByteArray.A() == MatroskaExtractor.f46556k0.getMostSignificantBits()) {
                        if (parsableByteArray.A() == MatroskaExtractor.f46556k0.getLeastSignificantBits()) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing MS/ACM codec private", null);
            }
        }

        private static List m(byte[] bArr) throws ParserException {
            int i3;
            int i4;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.a("Error parsing vorbis codec private", null);
                }
                int i5 = 0;
                int i6 = 1;
                while (true) {
                    i3 = bArr[i6];
                    if ((i3 & 255) != 255) {
                        break;
                    }
                    i5 += 255;
                    i6++;
                }
                int i7 = i6 + 1;
                int i8 = i5 + (i3 & 255);
                int i9 = 0;
                while (true) {
                    i4 = bArr[i7];
                    if ((i4 & 255) != 255) {
                        break;
                    }
                    i9 += 255;
                    i7++;
                }
                int i10 = i7 + 1;
                int i11 = i9 + (i4 & 255);
                if (bArr[i10] != 1) {
                    throw ParserException.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i8];
                System.arraycopy(bArr, i10, bArr2, 0, i8);
                int i12 = i10 + i8;
                if (bArr[i12] != 3) {
                    throw ParserException.a("Error parsing vorbis codec private", null);
                }
                int i13 = i12 + i11;
                if (bArr[i13] != 5) {
                    throw ParserException.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i13];
                System.arraycopy(bArr, i13, bArr3, 0, bArr.length - i13);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.a("Error parsing vorbis codec private", null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o(boolean z2) {
            return "A_OPUS".equals(this.f46593c) ? z2 : this.f46597g > 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:221:0x0449  */
        /* JADX WARN: Removed duplicated region for block: B:226:0x0462  */
        /* JADX WARN: Removed duplicated region for block: B:227:0x0464  */
        /* JADX WARN: Removed duplicated region for block: B:230:0x0471  */
        /* JADX WARN: Removed duplicated region for block: B:231:0x0483  */
        /* JADX WARN: Removed duplicated region for block: B:297:0x05ad  */
        /* JADX WARN: Removed duplicated region for block: B:302:0x05c8  */
        /* JADX WARN: Removed duplicated region for block: B:303:0x05cb  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0015  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void i(androidx.media3.extractor.ExtractorOutput r19, int r20) throws androidx.media3.common.ParserException {
            /*
                Method dump skipped, instruction units count: 1744
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mkv.MatroskaExtractor.Track.i(androidx.media3.extractor.ExtractorOutput, int):void");
        }

        public void j() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.V;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.a(this.Z, this.f46601k);
            }
        }

        public void n() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.V;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.b();
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", Integer.valueOf(SensibleDefaults.X_OFFSET));
        map.put("htc_video_rotA-270", 270);
        f46557l0 = Collections.unmodifiableMap(map);
    }

    public MatroskaExtractor(SubtitleParser.Factory factory, int i3) {
        this(new DefaultEbmlReader(), i3, factory);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean A(String str) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    b3 = 0;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    b3 = 1;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    b3 = 2;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    b3 = 3;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    b3 = 4;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    b3 = 5;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    b3 = 6;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    b3 = 7;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    b3 = 8;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    b3 = 9;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    b3 = 10;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    b3 = Ascii.VT;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    b3 = Ascii.FF;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    b3 = Ascii.CR;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    b3 = Ascii.SO;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    b3 = Ascii.SI;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    b3 = Ascii.DLE;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    b3 = 17;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    b3 = Ascii.DC2;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    b3 = 19;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    b3 = Ascii.DC4;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    b3 = Ascii.NAK;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    b3 = Ascii.SYN;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    b3 = Ascii.ETB;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    b3 = Ascii.CAN;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    b3 = Ascii.EM;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    b3 = Ascii.SUB;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    b3 = Ascii.ESC;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    b3 = Ascii.FS;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    b3 = Ascii.GS;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    b3 = Ascii.RS;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    b3 = Ascii.US;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    b3 = 32;
                }
                break;
        }
        switch (b3) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                return true;
            default:
                return false;
        }
    }

    private boolean C(PositionHolder positionHolder, long j3) {
        if (this.B) {
            this.D = j3;
            positionHolder.f46210a = this.C;
            this.B = false;
            return true;
        }
        if (this.f46587y) {
            long j4 = this.D;
            if (j4 != -1) {
                positionHolder.f46210a = j4;
                this.D = -1L;
                return true;
            }
        }
        return false;
    }

    private void D(ExtractorInput extractorInput, int i3) {
        if (this.f46571i.g() >= i3) {
            return;
        }
        if (this.f46571i.b() < i3) {
            ParsableByteArray parsableByteArray = this.f46571i;
            parsableByteArray.c(Math.max(parsableByteArray.b() * 2, i3));
        }
        extractorInput.readFully(this.f46571i.e(), this.f46571i.g(), i3 - this.f46571i.g());
        this.f46571i.V(i3);
    }

    private void E() {
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = false;
        this.Z = false;
        this.f46559a0 = false;
        this.f46561b0 = 0;
        this.f46563c0 = (byte) 0;
        this.f46565d0 = false;
        this.f46574l.S(0);
    }

    private long F(long j3) throws ParserException {
        long j4 = this.f46582t;
        if (j4 != -9223372036854775807L) {
            return Util.Z0(j3, j4, 1000L);
        }
        throw ParserException.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static void G(String str, long j3, byte[] bArr) {
        byte[] bArrU;
        int i3;
        str.getClass();
        switch (str) {
            case "S_TEXT/ASS":
                bArrU = u(j3, "%01d:%02d:%02d:%02d", 10000L);
                i3 = 21;
                break;
            case "S_TEXT/WEBVTT":
                bArrU = u(j3, "%02d:%02d:%02d.%03d", 1000L);
                i3 = 25;
                break;
            case "S_TEXT/UTF8":
                bArrU = u(j3, "%02d:%02d:%02d,%03d", 1000L);
                i3 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArrU, 0, bArr, i3, bArrU.length);
    }

    private int J(ExtractorInput extractorInput, Track track, int i3, boolean z2) throws ParserException {
        int i4;
        if ("S_TEXT/UTF8".equals(track.f46593c)) {
            K(extractorInput, f46552g0, i3);
            return s();
        }
        if ("S_TEXT/ASS".equals(track.f46593c)) {
            K(extractorInput, f46554i0, i3);
            return s();
        }
        if ("S_TEXT/WEBVTT".equals(track.f46593c)) {
            K(extractorInput, f46555j0, i3);
            return s();
        }
        TrackOutput trackOutput = track.Z;
        if (!this.Y) {
            if (track.f46599i) {
                this.R &= -1073741825;
                boolean z3 = this.Z;
                int i5 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (!z3) {
                    extractorInput.readFully(this.f46571i.e(), 0, 1);
                    this.V++;
                    if ((this.f46571i.e()[0] & 128) == 128) {
                        throw ParserException.a("Extension bit is set in signal byte", null);
                    }
                    this.f46563c0 = this.f46571i.e()[0];
                    this.Z = true;
                }
                byte b3 = this.f46563c0;
                if ((b3 & 1) == 1) {
                    boolean z4 = (b3 & 2) == 2;
                    this.R |= 1073741824;
                    if (!this.f46565d0) {
                        extractorInput.readFully(this.f46576n.e(), 0, 8);
                        this.V += 8;
                        this.f46565d0 = true;
                        byte[] bArrE = this.f46571i.e();
                        if (!z4) {
                            i5 = 0;
                        }
                        bArrE[0] = (byte) (i5 | 8);
                        this.f46571i.W(0);
                        trackOutput.a(this.f46571i, 1, 1);
                        this.W++;
                        this.f46576n.W(0);
                        trackOutput.a(this.f46576n, 8, 1);
                        this.W += 8;
                    }
                    if (z4) {
                        if (!this.f46559a0) {
                            extractorInput.readFully(this.f46571i.e(), 0, 1);
                            this.V++;
                            this.f46571i.W(0);
                            this.f46561b0 = this.f46571i.H();
                            this.f46559a0 = true;
                        }
                        int i6 = this.f46561b0 * 4;
                        this.f46571i.S(i6);
                        extractorInput.readFully(this.f46571i.e(), 0, i6);
                        this.V += i6;
                        short s2 = (short) ((this.f46561b0 / 2) + 1);
                        int i7 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.f46579q;
                        if (byteBuffer == null || byteBuffer.capacity() < i7) {
                            this.f46579q = ByteBuffer.allocate(i7);
                        }
                        this.f46579q.position(0);
                        this.f46579q.putShort(s2);
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            i4 = this.f46561b0;
                            if (i8 >= i4) {
                                break;
                            }
                            int iL = this.f46571i.L();
                            if (i8 % 2 == 0) {
                                this.f46579q.putShort((short) (iL - i9));
                            } else {
                                this.f46579q.putInt(iL - i9);
                            }
                            i8++;
                            i9 = iL;
                        }
                        int i10 = (i3 - this.V) - i9;
                        if (i4 % 2 == 1) {
                            this.f46579q.putInt(i10);
                        } else {
                            this.f46579q.putShort((short) i10);
                            this.f46579q.putInt(0);
                        }
                        this.f46577o.U(this.f46579q.array(), i7);
                        trackOutput.a(this.f46577o, i7, 1);
                        this.W += i7;
                    }
                }
            } else {
                byte[] bArr = track.f46600j;
                if (bArr != null) {
                    this.f46574l.U(bArr, bArr.length);
                }
            }
            if (track.o(z2)) {
                this.R |= 268435456;
                this.f46578p.S(0);
                int iG = (this.f46574l.g() + i3) - this.V;
                this.f46571i.S(4);
                this.f46571i.e()[0] = (byte) ((iG >> 24) & 255);
                this.f46571i.e()[1] = (byte) ((iG >> 16) & 255);
                this.f46571i.e()[2] = (byte) ((iG >> 8) & 255);
                this.f46571i.e()[3] = (byte) (iG & 255);
                trackOutput.a(this.f46571i, 4, 2);
                this.W += 4;
            }
            this.Y = true;
        }
        int iG2 = i3 + this.f46574l.g();
        if (!"V_MPEG4/ISO/AVC".equals(track.f46593c) && !"V_MPEGH/ISO/HEVC".equals(track.f46593c)) {
            if (track.V != null) {
                Assertions.g(this.f46574l.g() == 0);
                track.V.d(extractorInput);
            }
            while (true) {
                int i11 = this.V;
                if (i11 >= iG2) {
                    break;
                }
                int iL2 = L(extractorInput, trackOutput, iG2 - i11);
                this.V += iL2;
                this.W += iL2;
            }
        } else {
            byte[] bArrE2 = this.f46570h.e();
            bArrE2[0] = 0;
            bArrE2[1] = 0;
            bArrE2[2] = 0;
            int i12 = track.f46591a0;
            int i13 = 4 - i12;
            while (this.V < iG2) {
                int i14 = this.X;
                if (i14 == 0) {
                    M(extractorInput, bArrE2, i13, i12);
                    this.V += i12;
                    this.f46570h.W(0);
                    this.X = this.f46570h.L();
                    this.f46569g.W(0);
                    trackOutput.b(this.f46569g, 4);
                    this.W += 4;
                } else {
                    int iL3 = L(extractorInput, trackOutput, i14);
                    this.V += iL3;
                    this.W += iL3;
                    this.X -= iL3;
                }
            }
        }
        if ("A_VORBIS".equals(track.f46593c)) {
            this.f46572j.W(0);
            trackOutput.b(this.f46572j, 4);
            this.W += 4;
        }
        return s();
    }

    private void K(ExtractorInput extractorInput, byte[] bArr, int i3) {
        int length = bArr.length + i3;
        if (this.f46575m.b() < length) {
            this.f46575m.T(Arrays.copyOf(bArr, length + i3));
        } else {
            System.arraycopy(bArr, 0, this.f46575m.e(), 0, bArr.length);
        }
        extractorInput.readFully(this.f46575m.e(), bArr.length, i3);
        this.f46575m.W(0);
        this.f46575m.V(length);
    }

    private int L(ExtractorInput extractorInput, TrackOutput trackOutput, int i3) {
        int iA = this.f46574l.a();
        if (iA <= 0) {
            return trackOutput.d(extractorInput, i3, false);
        }
        int iMin = Math.min(i3, iA);
        trackOutput.b(this.f46574l, iMin);
        return iMin;
    }

    private void M(ExtractorInput extractorInput, byte[] bArr, int i3, int i4) {
        int iMin = Math.min(i4, this.f46574l.a());
        extractorInput.readFully(bArr, i3 + iMin, i4 - iMin);
        if (iMin > 0) {
            this.f46574l.l(bArr, i3, iMin);
        }
    }

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new MatroskaExtractor(SubtitleParser.Factory.f46959a, 2)};
    }

    private void k(int i3) throws ParserException {
        if (this.F == null || this.G == null) {
            throw ParserException.a("Element " + i3 + " must be in a Cues", null);
        }
    }

    private void l(int i3) throws ParserException {
        if (this.f46586x != null) {
            return;
        }
        throw ParserException.a("Element " + i3 + " must be in a TrackEntry", null);
    }

    private void m() {
        Assertions.i(this.f46567e0);
    }

    private SeekMap o(LongArray longArray, LongArray longArray2) {
        int i3;
        if (this.f46581s == -1 || this.f46584v == -9223372036854775807L || longArray == null || longArray.d() == 0 || longArray2 == null || longArray2.d() != longArray.d()) {
            return new SeekMap.Unseekable(this.f46584v);
        }
        int iD = longArray.d();
        int[] iArrCopyOf = new int[iD];
        long[] jArrCopyOf = new long[iD];
        long[] jArrCopyOf2 = new long[iD];
        long[] jArrCopyOf3 = new long[iD];
        int i4 = 0;
        for (int i5 = 0; i5 < iD; i5++) {
            jArrCopyOf3[i5] = longArray.c(i5);
            jArrCopyOf[i5] = this.f46581s + longArray2.c(i5);
        }
        while (true) {
            i3 = iD - 1;
            if (i4 >= i3) {
                break;
            }
            int i6 = i4 + 1;
            iArrCopyOf[i4] = (int) (jArrCopyOf[i6] - jArrCopyOf[i4]);
            jArrCopyOf2[i4] = jArrCopyOf3[i6] - jArrCopyOf3[i4];
            i4 = i6;
        }
        int i7 = i3;
        while (i7 > 0 && jArrCopyOf3[i7] > this.f46584v) {
            i7--;
        }
        iArrCopyOf[i7] = (int) ((this.f46581s + this.f46580r) - jArrCopyOf[i7]);
        jArrCopyOf2[i7] = this.f46584v - jArrCopyOf3[i7];
        if (i7 < i3) {
            Log.i("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration");
            int i8 = i7 + 1;
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i8);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i8);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i8);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i8);
        }
        return new ChunkIndex(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p(androidx.media3.extractor.mkv.MatroskaExtractor.Track r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mkv.MatroskaExtractor.p(androidx.media3.extractor.mkv.MatroskaExtractor$Track, long, int, int, int):void");
    }

    private static int[] r(int[] iArr, int i3) {
        return iArr == null ? new int[i3] : iArr.length >= i3 ? iArr : new int[Math.max(iArr.length * 2, i3)];
    }

    private int s() {
        int i3 = this.W;
        E();
        return i3;
    }

    private static byte[] u(long j3, String str, long j4) {
        Assertions.a(j3 != -9223372036854775807L);
        int i3 = (int) (j3 / 3600000000L);
        long j5 = j3 - (((long) i3) * 3600000000L);
        int i4 = (int) (j5 / 60000000);
        long j6 = j5 - (((long) i4) * 60000000);
        int i5 = (int) (j6 / 1000000);
        return Util.t0(String.format(Locale.US, str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf((int) ((j6 - (((long) i5) * 1000000)) / j4))));
    }

    protected boolean B(int i3) {
        return i3 == 357149030 || i3 == 524531317 || i3 == 475249515 || i3 == 374648427;
    }

    protected void H(int i3, long j3, long j4) throws ParserException {
        m();
        if (i3 == 160) {
            this.T = false;
            this.U = 0L;
            return;
        }
        if (i3 == 174) {
            Track track = new Track();
            this.f46586x = track;
            track.f46590a = this.f46585w;
            return;
        }
        if (i3 == 187) {
            this.H = false;
            return;
        }
        if (i3 == 19899) {
            this.f46588z = -1;
            this.A = -1L;
            return;
        }
        if (i3 == 20533) {
            v(i3).f46599i = true;
            return;
        }
        if (i3 == 21968) {
            v(i3).f46616z = true;
            return;
        }
        if (i3 == 408125543) {
            long j5 = this.f46581s;
            if (j5 != -1 && j5 != j3) {
                throw ParserException.a("Multiple Segment elements not supported", null);
            }
            this.f46581s = j3;
            this.f46580r = j4;
            return;
        }
        if (i3 == 475249515) {
            this.F = new LongArray();
            this.G = new LongArray();
        } else if (i3 == 524531317 && !this.f46587y) {
            if (this.f46564d && this.C != -1) {
                this.B = true;
            } else {
                this.f46567e0.n(new SeekMap.Unseekable(this.f46584v));
                this.f46587y = true;
            }
        }
    }

    protected void I(int i3, String str) throws ParserException {
        if (i3 == 134) {
            v(i3).f46593c = str;
            return;
        }
        if (i3 != 17026) {
            if (i3 == 21358) {
                v(i3).f46592b = str;
                return;
            } else {
                if (i3 != 2274716) {
                    return;
                }
                v(i3).Y = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            this.f46585w = Objects.equals(str, "webm");
            return;
        }
        throw ParserException.a("DocType " + str + " not supported", null);
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.E = -9223372036854775807L;
        this.J = 0;
        this.f46558a.reset();
        this.f46560b.e();
        E();
        for (int i3 = 0; i3 < this.f46562c.size(); i3++) {
            ((Track) this.f46562c.valueAt(i3)).n();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean g(ExtractorInput extractorInput) {
        return new Sniffer().b(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void h(ExtractorOutput extractorOutput) {
        if (this.f46566e) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f46568f);
        }
        this.f46567e0 = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        this.I = false;
        boolean zA = true;
        while (zA && !this.I) {
            zA = this.f46558a.a(extractorInput);
            if (zA && C(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i3 = 0; i3 < this.f46562c.size(); i3++) {
            Track track = (Track) this.f46562c.valueAt(i3);
            track.f();
            track.j();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void n(int i3, int i4, ExtractorInput extractorInput) throws ParserException {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j3;
        int i10;
        int i11;
        int i12;
        ExtractorInput extractorInput2 = extractorInput;
        int i13 = 0;
        int i14 = 1;
        if (i3 != 161 && i3 != 163) {
            if (i3 == 165) {
                if (this.J != 2) {
                    return;
                }
                y((Track) this.f46562c.get(this.P), this.S, extractorInput2, i4);
                return;
            }
            if (i3 == 16877) {
                x(v(i3), extractorInput2, i4);
                return;
            }
            if (i3 == 16981) {
                l(i3);
                byte[] bArr = new byte[i4];
                this.f46586x.f46600j = bArr;
                extractorInput2.readFully(bArr, 0, i4);
                return;
            }
            if (i3 == 18402) {
                byte[] bArr2 = new byte[i4];
                extractorInput2.readFully(bArr2, 0, i4);
                v(i3).f46601k = new TrackOutput.CryptoData(1, bArr2, 0, 0);
                return;
            }
            if (i3 == 21419) {
                Arrays.fill(this.f46573k.e(), (byte) 0);
                extractorInput2.readFully(this.f46573k.e(), 4 - i4, i4);
                this.f46573k.W(0);
                this.f46588z = (int) this.f46573k.J();
                return;
            }
            if (i3 == 25506) {
                l(i3);
                byte[] bArr3 = new byte[i4];
                this.f46586x.f46602l = bArr3;
                extractorInput2.readFully(bArr3, 0, i4);
                return;
            }
            if (i3 != 30322) {
                throw ParserException.a("Unexpected id: " + i3, null);
            }
            l(i3);
            byte[] bArr4 = new byte[i4];
            this.f46586x.f46614x = bArr4;
            extractorInput2.readFully(bArr4, 0, i4);
            return;
        }
        int i15 = 8;
        if (this.J == 0) {
            this.P = (int) this.f46560b.d(extractorInput2, false, true, 8);
            this.Q = this.f46560b.b();
            this.L = -9223372036854775807L;
            this.J = 1;
            this.f46571i.S(0);
        }
        Track track = (Track) this.f46562c.get(this.P);
        if (track == null) {
            extractorInput2.k(i4 - this.Q);
            this.J = 0;
            return;
        }
        track.f();
        if (this.J == 1) {
            D(extractorInput2, 3);
            int i16 = (this.f46571i.e()[2] & 6) >> 1;
            if (i16 == 0) {
                this.N = 1;
                int[] iArrR = r(this.O, 1);
                this.O = iArrR;
                iArrR[0] = (i4 - this.Q) - 3;
            } else {
                D(extractorInput2, 4);
                int i17 = (this.f46571i.e()[3] & 255) + 1;
                this.N = i17;
                int[] iArrR2 = r(this.O, i17);
                this.O = iArrR2;
                if (i16 == 2) {
                    int i18 = (i4 - this.Q) - 4;
                    int i19 = this.N;
                    Arrays.fill(iArrR2, 0, i19, i18 / i19);
                } else {
                    if (i16 != 1) {
                        if (i16 != 3) {
                            throw ParserException.a("Unexpected lacing value: " + i16, null);
                        }
                        int i20 = 0;
                        int i21 = 0;
                        int i22 = 4;
                        while (true) {
                            int i23 = this.N;
                            i5 = i14;
                            if (i20 >= i23 - 1) {
                                i6 = i13;
                                this.O[i23 - 1] = ((i4 - this.Q) - i22) - i21;
                                break;
                            }
                            this.O[i20] = i13;
                            int i24 = i22 + 1;
                            D(extractorInput2, i24);
                            if (this.f46571i.e()[i22] == 0) {
                                throw ParserException.a("No valid varint length mask found", null);
                            }
                            int i25 = i13;
                            while (true) {
                                if (i25 >= i15) {
                                    i7 = i13;
                                    i8 = i15;
                                    i9 = i20;
                                    j3 = 0;
                                    break;
                                }
                                i8 = i15;
                                int i26 = i5 << (7 - i25);
                                i7 = i13;
                                if ((this.f46571i.e()[i22] & i26) != 0) {
                                    i24 += i25;
                                    D(extractorInput2, i24);
                                    int i27 = i22 + 1;
                                    j3 = this.f46571i.e()[i22] & 255 & (~i26);
                                    while (true) {
                                        int i28 = i27;
                                        if (i28 >= i24) {
                                            break;
                                        }
                                        i27 = i28 + 1;
                                        j3 = (j3 << i8) | ((long) (this.f46571i.e()[i28] & 255));
                                        i20 = i20;
                                    }
                                    i9 = i20;
                                    if (i9 > 0) {
                                        j3 -= (1 << ((i25 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i25++;
                                    extractorInput2 = extractorInput;
                                    i13 = i7;
                                    i15 = i8;
                                }
                            }
                            i22 = i24;
                            if (j3 < -2147483648L || j3 > 2147483647L) {
                                break;
                            }
                            int i29 = (int) j3;
                            int[] iArr = this.O;
                            if (i9 != 0) {
                                i29 += iArr[i9 - 1];
                            }
                            iArr[i9] = i29;
                            i21 += i29;
                            i20 = i9 + 1;
                            extractorInput2 = extractorInput;
                            i14 = i5;
                            i13 = i7;
                            i15 = i8;
                        }
                        throw ParserException.a("EBML lacing sample size out of range.", null);
                    }
                    int i30 = 0;
                    int i31 = 0;
                    int i32 = 4;
                    while (true) {
                        i10 = this.N;
                        if (i30 >= i10 - 1) {
                            break;
                        }
                        this.O[i30] = 0;
                        while (true) {
                            i11 = i32 + 1;
                            D(extractorInput2, i11);
                            int i33 = this.f46571i.e()[i32] & 255;
                            int[] iArr2 = this.O;
                            i12 = iArr2[i30] + i33;
                            iArr2[i30] = i12;
                            if (i33 != 255) {
                                break;
                            } else {
                                i32 = i11;
                            }
                        }
                        i31 += i12;
                        i30++;
                        i32 = i11;
                    }
                    this.O[i10 - 1] = ((i4 - this.Q) - i32) - i31;
                }
            }
            i6 = 0;
            i5 = 1;
            this.K = this.E + F((this.f46571i.e()[i6] << 8) | (this.f46571i.e()[i5] & 255));
            this.R = (track.f46595e == 2 || (i3 == 163 && (this.f46571i.e()[2] & 128) == 128)) ? i5 : i6;
            this.J = 2;
            this.M = i6;
        } else {
            i5 = 1;
        }
        if (i3 == 163) {
            while (true) {
                int i34 = this.M;
                if (i34 >= this.N) {
                    this.J = 0;
                    return;
                }
                int iJ = J(extractorInput, track, this.O[i34], false);
                Track track2 = track;
                p(track2, this.K + ((long) ((this.M * track.f46596f) / 1000)), this.R, iJ, 0);
                this.M++;
                track = track2;
            }
        } else {
            while (true) {
                int i35 = this.M;
                if (i35 >= this.N) {
                    return;
                }
                int[] iArr3 = this.O;
                boolean z2 = i5;
                iArr3[i35] = J(extractorInput, track, iArr3[i35], z2);
                this.M += z2 ? 1 : 0;
            }
        }
    }

    protected void q(int i3) throws ParserException {
        m();
        if (i3 == 160) {
            if (this.J != 2) {
                return;
            }
            Track track = (Track) this.f46562c.get(this.P);
            track.f();
            if (this.U > 0 && "A_OPUS".equals(track.f46593c)) {
                this.f46578p.T(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.U).array());
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.N; i5++) {
                i4 += this.O[i5];
            }
            int i6 = 0;
            while (i6 < this.N) {
                long j3 = this.K + ((long) ((track.f46596f * i6) / 1000));
                int i7 = this.R;
                if (i6 == 0 && !this.T) {
                    i7 |= 1;
                }
                int i8 = this.O[i6];
                int i9 = i4 - i8;
                p(track, j3, i7, i8, i9);
                i6++;
                i4 = i9;
            }
            this.J = 0;
            return;
        }
        if (i3 == 174) {
            Track track2 = (Track) Assertions.i(this.f46586x);
            String str = track2.f46593c;
            if (str == null) {
                throw ParserException.a("CodecId is missing in TrackEntry element", null);
            }
            if (A(str)) {
                track2.i(this.f46567e0, track2.f46594d);
                this.f46562c.put(track2.f46594d, track2);
            }
            this.f46586x = null;
            return;
        }
        if (i3 == 19899) {
            int i10 = this.f46588z;
            if (i10 != -1) {
                long j4 = this.A;
                if (j4 != -1) {
                    if (i10 == 475249515) {
                        this.C = j4;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.a("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i3 == 25152) {
            l(i3);
            Track track3 = this.f46586x;
            if (track3.f46599i) {
                if (track3.f46601k == null) {
                    throw ParserException.a("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                track3.f46603m = new DrmInitData(new DrmInitData.SchemeData(C.f40541a, "video/webm", this.f46586x.f46601k.f46228b));
                return;
            }
            return;
        }
        if (i3 == 28032) {
            l(i3);
            Track track4 = this.f46586x;
            if (track4.f46599i && track4.f46600j != null) {
                throw ParserException.a("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i3 == 357149030) {
            if (this.f46582t == -9223372036854775807L) {
                this.f46582t = 1000000L;
            }
            long j5 = this.f46583u;
            if (j5 != -9223372036854775807L) {
                this.f46584v = F(j5);
                return;
            }
            return;
        }
        if (i3 == 374648427) {
            if (this.f46562c.size() == 0) {
                throw ParserException.a("No valid tracks were found", null);
            }
            this.f46567e0.q();
        } else {
            if (i3 != 475249515) {
                return;
            }
            if (!this.f46587y) {
                this.f46567e0.n(o(this.F, this.G));
                this.f46587y = true;
            }
            this.F = null;
            this.G = null;
        }
    }

    protected void t(int i3, double d3) {
        if (i3 == 181) {
            v(i3).S = (int) d3;
            return;
        }
        if (i3 == 17545) {
            this.f46583u = (long) d3;
            return;
        }
        switch (i3) {
            case 21969:
                v(i3).F = (float) d3;
                break;
            case 21970:
                v(i3).G = (float) d3;
                break;
            case 21971:
                v(i3).H = (float) d3;
                break;
            case 21972:
                v(i3).I = (float) d3;
                break;
            case 21973:
                v(i3).J = (float) d3;
                break;
            case 21974:
                v(i3).K = (float) d3;
                break;
            case 21975:
                v(i3).L = (float) d3;
                break;
            case 21976:
                v(i3).M = (float) d3;
                break;
            case 21977:
                v(i3).N = (float) d3;
                break;
            case 21978:
                v(i3).O = (float) d3;
                break;
            default:
                switch (i3) {
                    case 30323:
                        v(i3).f46611u = (float) d3;
                        break;
                    case 30324:
                        v(i3).f46612v = (float) d3;
                        break;
                    case 30325:
                        v(i3).f46613w = (float) d3;
                        break;
                }
                break;
        }
    }

    protected Track v(int i3) throws ParserException {
        l(i3);
        return this.f46586x;
    }

    protected int w(int i3) {
        switch (i3) {
            case 131:
            case 136:
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21938:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected void x(Track track, ExtractorInput extractorInput, int i3) {
        if (track.f46598h != 1685485123 && track.f46598h != 1685480259) {
            extractorInput.k(i3);
            return;
        }
        byte[] bArr = new byte[i3];
        track.P = bArr;
        extractorInput.readFully(bArr, 0, i3);
    }

    protected void y(Track track, int i3, ExtractorInput extractorInput, int i4) {
        if (i3 != 4 || !"V_VP9".equals(track.f46593c)) {
            extractorInput.k(i4);
        } else {
            this.f46578p.S(i4);
            extractorInput.readFully(this.f46578p.e(), 0, i4);
        }
    }

    protected void z(int i3, long j3) throws ParserException {
        if (i3 == 20529) {
            if (j3 == 0) {
                return;
            }
            throw ParserException.a("ContentEncodingOrder " + j3 + " not supported", null);
        }
        if (i3 == 20530) {
            if (j3 == 1) {
                return;
            }
            throw ParserException.a("ContentEncodingScope " + j3 + " not supported", null);
        }
        switch (i3) {
            case 131:
                v(i3).f46595e = (int) j3;
                return;
            case 136:
                v(i3).X = j3 == 1;
                return;
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
                this.L = F(j3);
                return;
            case 159:
                v(i3).Q = (int) j3;
                return;
            case 176:
                v(i3).f46604n = (int) j3;
                return;
            case 179:
                k(i3);
                this.F.a(F(j3));
                return;
            case 186:
                v(i3).f46605o = (int) j3;
                return;
            case 215:
                v(i3).f46594d = (int) j3;
                return;
            case 231:
                this.E = F(j3);
                return;
            case 238:
                this.S = (int) j3;
                return;
            case 241:
                if (this.H) {
                    return;
                }
                k(i3);
                this.G.a(j3);
                this.H = true;
                return;
            case 251:
                this.T = true;
                return;
            case 16871:
                v(i3).f46598h = (int) j3;
                return;
            case 16980:
                if (j3 == 3) {
                    return;
                }
                throw ParserException.a("ContentCompAlgo " + j3 + " not supported", null);
            case 17029:
                if (j3 < 1 || j3 > 2) {
                    throw ParserException.a("DocTypeReadVersion " + j3 + " not supported", null);
                }
                return;
            case 17143:
                if (j3 == 1) {
                    return;
                }
                throw ParserException.a("EBMLReadVersion " + j3 + " not supported", null);
            case 18401:
                if (j3 == 5) {
                    return;
                }
                throw ParserException.a("ContentEncAlgo " + j3 + " not supported", null);
            case 18408:
                if (j3 == 1) {
                    return;
                }
                throw ParserException.a("AESSettingsCipherMode " + j3 + " not supported", null);
            case 21420:
                this.A = j3 + this.f46581s;
                return;
            case 21432:
                int i4 = (int) j3;
                l(i3);
                if (i4 == 0) {
                    this.f46586x.f46615y = 0;
                    return;
                }
                if (i4 == 1) {
                    this.f46586x.f46615y = 2;
                    return;
                } else if (i4 == 3) {
                    this.f46586x.f46615y = 1;
                    return;
                } else {
                    if (i4 != 15) {
                        return;
                    }
                    this.f46586x.f46615y = 3;
                    return;
                }
            case 21680:
                v(i3).f46607q = (int) j3;
                return;
            case 21682:
                v(i3).f46609s = (int) j3;
                return;
            case 21690:
                v(i3).f46608r = (int) j3;
                return;
            case 21930:
                v(i3).W = j3 == 1;
                return;
            case 21938:
                l(i3);
                Track track = this.f46586x;
                track.f46616z = true;
                track.f46606p = (int) j3;
                return;
            case 21998:
                v(i3).f46597g = (int) j3;
                return;
            case 22186:
                v(i3).T = j3;
                return;
            case 22203:
                v(i3).U = j3;
                return;
            case 25188:
                v(i3).R = (int) j3;
                return;
            case 30114:
                this.U = j3;
                return;
            case 30321:
                l(i3);
                int i5 = (int) j3;
                if (i5 == 0) {
                    this.f46586x.f46610t = 0;
                    return;
                }
                if (i5 == 1) {
                    this.f46586x.f46610t = 1;
                    return;
                } else if (i5 == 2) {
                    this.f46586x.f46610t = 2;
                    return;
                } else {
                    if (i5 != 3) {
                        return;
                    }
                    this.f46586x.f46610t = 3;
                    return;
                }
            case 2352003:
                v(i3).f46596f = (int) j3;
                return;
            case 2807729:
                this.f46582t = j3;
                return;
            default:
                switch (i3) {
                    case 21945:
                        l(i3);
                        int i6 = (int) j3;
                        if (i6 == 1) {
                            this.f46586x.C = 2;
                            return;
                        } else {
                            if (i6 != 2) {
                                return;
                            }
                            this.f46586x.C = 1;
                            return;
                        }
                    case 21946:
                        l(i3);
                        int iO = ColorInfo.o((int) j3);
                        if (iO != -1) {
                            this.f46586x.B = iO;
                            return;
                        }
                        return;
                    case 21947:
                        l(i3);
                        this.f46586x.f46616z = true;
                        int iN = ColorInfo.n((int) j3);
                        if (iN != -1) {
                            this.f46586x.A = iN;
                            return;
                        }
                        return;
                    case 21948:
                        v(i3).D = (int) j3;
                        return;
                    case 21949:
                        v(i3).E = (int) j3;
                        return;
                    default:
                        return;
                }
        }
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i3, SubtitleParser.Factory factory) {
        this.f46581s = -1L;
        this.f46582t = -9223372036854775807L;
        this.f46583u = -9223372036854775807L;
        this.f46584v = -9223372036854775807L;
        this.C = -1L;
        this.D = -1L;
        this.E = -9223372036854775807L;
        this.f46558a = ebmlReader;
        ebmlReader.b(new InnerEbmlProcessor());
        this.f46568f = factory;
        this.f46564d = (i3 & 1) == 0;
        this.f46566e = (i3 & 2) == 0;
        this.f46560b = new VarintReader();
        this.f46562c = new SparseArray();
        this.f46571i = new ParsableByteArray(4);
        this.f46572j = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f46573k = new ParsableByteArray(4);
        this.f46569g = new ParsableByteArray(NalUnitUtil.f41674a);
        this.f46570h = new ParsableByteArray(4);
        this.f46574l = new ParsableByteArray();
        this.f46575m = new ParsableByteArray();
        this.f46576n = new ParsableByteArray(8);
        this.f46577o = new ParsableByteArray();
        this.f46578p = new ParsableByteArray();
        this.O = new int[1];
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
