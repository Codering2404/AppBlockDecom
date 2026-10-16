package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.ogg.StreamReader;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class VorbisReader extends StreamReader {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private VorbisSetup f46923n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f46924o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f46925p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private VorbisUtil.VorbisIdHeader f46926q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private VorbisUtil.CommentHeader f46927r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class VorbisSetup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VorbisUtil.VorbisIdHeader f46928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VorbisUtil.CommentHeader f46929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f46930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final VorbisUtil.Mode[] f46931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f46932e;

        public VorbisSetup(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader, byte[] bArr, VorbisUtil.Mode[] modeArr, int i3) {
            this.f46928a = vorbisIdHeader;
            this.f46929b = commentHeader;
            this.f46930c = bArr;
            this.f46931d = modeArr;
            this.f46932e = i3;
        }
    }

    VorbisReader() {
    }

    static void n(ParsableByteArray parsableByteArray, long j3) {
        if (parsableByteArray.b() < parsableByteArray.g() + 4) {
            parsableByteArray.T(Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g() + 4));
        } else {
            parsableByteArray.V(parsableByteArray.g() + 4);
        }
        byte[] bArrE = parsableByteArray.e();
        bArrE[parsableByteArray.g() - 4] = (byte) (j3 & 255);
        bArrE[parsableByteArray.g() - 3] = (byte) ((j3 >>> 8) & 255);
        bArrE[parsableByteArray.g() - 2] = (byte) ((j3 >>> 16) & 255);
        bArrE[parsableByteArray.g() - 1] = (byte) ((j3 >>> 24) & 255);
    }

    private static int o(byte b3, VorbisSetup vorbisSetup) {
        return !vorbisSetup.f46931d[p(b3, vorbisSetup.f46932e, 1)].f46245a ? vorbisSetup.f46928a.f46255g : vorbisSetup.f46928a.f46256h;
    }

    static int p(byte b3, int i3, int i4) {
        return (b3 >> i4) & (255 >>> (8 - i3));
    }

    public static boolean r(ParsableByteArray parsableByteArray) {
        try {
            return VorbisUtil.o(1, parsableByteArray, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected void e(long j3) {
        super.e(j3);
        this.f46925p = j3 != 0;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.f46926q;
        this.f46924o = vorbisIdHeader != null ? vorbisIdHeader.f46255g : 0;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected long f(ParsableByteArray parsableByteArray) {
        if ((parsableByteArray.e()[0] & 1) == 1) {
            return -1L;
        }
        int iO = o(parsableByteArray.e()[0], (VorbisSetup) Assertions.i(this.f46923n));
        long j3 = this.f46925p ? (this.f46924o + iO) / 4 : 0;
        n(parsableByteArray, j3);
        this.f46925p = true;
        this.f46924o = iO;
        return j3;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected boolean h(ParsableByteArray parsableByteArray, long j3, StreamReader.SetupData setupData) throws ParserException {
        if (this.f46923n != null) {
            Assertions.e(setupData.f46921a);
            return false;
        }
        VorbisSetup vorbisSetupQ = q(parsableByteArray);
        this.f46923n = vorbisSetupQ;
        if (vorbisSetupQ == null) {
            return true;
        }
        VorbisUtil.VorbisIdHeader vorbisIdHeader = vorbisSetupQ.f46928a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(vorbisIdHeader.f46258j);
        arrayList.add(vorbisSetupQ.f46930c);
        setupData.f46921a = new Format.Builder().U("audio/ogg").u0("audio/vorbis").Q(vorbisIdHeader.f46253e).p0(vorbisIdHeader.f46252d).R(vorbisIdHeader.f46250b).v0(vorbisIdHeader.f46251c).g0(arrayList).n0(VorbisUtil.d(ImmutableList.v(vorbisSetupQ.f46929b.f46243b))).N();
        return true;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected void l(boolean z2) {
        super.l(z2);
        if (z2) {
            this.f46923n = null;
            this.f46926q = null;
            this.f46927r = null;
        }
        this.f46924o = 0;
        this.f46925p = false;
    }

    VorbisSetup q(ParsableByteArray parsableByteArray) throws ParserException {
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.f46926q;
        if (vorbisIdHeader == null) {
            this.f46926q = VorbisUtil.l(parsableByteArray);
            return null;
        }
        VorbisUtil.CommentHeader commentHeader = this.f46927r;
        if (commentHeader == null) {
            this.f46927r = VorbisUtil.j(parsableByteArray);
            return null;
        }
        byte[] bArr = new byte[parsableByteArray.g()];
        System.arraycopy(parsableByteArray.e(), 0, bArr, 0, parsableByteArray.g());
        return new VorbisSetup(vorbisIdHeader, commentHeader, bArr, VorbisUtil.m(parsableByteArray, vorbisIdHeader.f46250b), VorbisUtil.b(r4.length - 1));
    }
}
