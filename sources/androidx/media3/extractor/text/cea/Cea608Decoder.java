package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.superwall.sdk.billing.GoogleBillingWrapperKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Cea608Decoder extends CeaDecoder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f46982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f46983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f46984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f46985l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f46988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List f46989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f46990q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f46991r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f46992s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f46993t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private byte f46994u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private byte f46995v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f46997x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f46998y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f46980z = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] A = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] B = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] C = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] D = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] E = {193, RCHTTPStatusCodes.CREATED, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] F = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] G = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ParsableByteArray f46981h = new ParsableByteArray();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ArrayList f46986m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CueBuilder f46987n = new CueBuilder(0, 4);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f46996w = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CueBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f46999a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f47000b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StringBuilder f47001c = new StringBuilder();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f47002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f47003e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f47004f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47005g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f47006h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class CueStyle {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f47007a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f47008b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f47009c;

            public CueStyle(int i3, boolean z2, int i4) {
                this.f47007a = i3;
                this.f47008b = z2;
                this.f47009c = i4;
            }
        }

        public CueBuilder(int i3, int i4) {
            j(i3);
            this.f47006h = i4;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f47001c);
            int length = spannableStringBuilder.length();
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = 0;
            int i8 = 0;
            boolean z2 = false;
            while (i7 < this.f46999a.size()) {
                CueStyle cueStyle = (CueStyle) this.f46999a.get(i7);
                boolean z3 = cueStyle.f47008b;
                int i9 = cueStyle.f47007a;
                if (i9 != 8) {
                    boolean z4 = i9 == 7;
                    if (i9 != 7) {
                        i6 = Cea608Decoder.B[i9];
                    }
                    z2 = z4;
                }
                int i10 = cueStyle.f47009c;
                i7++;
                if (i10 != (i7 < this.f46999a.size() ? ((CueStyle) this.f46999a.get(i7)).f47009c : length)) {
                    if (i3 != -1 && !z3) {
                        q(spannableStringBuilder, i3, i10);
                        i3 = -1;
                    } else if (i3 == -1 && z3) {
                        i3 = i10;
                    }
                    if (i4 != -1 && !z2) {
                        o(spannableStringBuilder, i4, i10);
                        i4 = -1;
                    } else if (i4 == -1 && z2) {
                        i4 = i10;
                    }
                    if (i6 != i5) {
                        n(spannableStringBuilder, i8, i10, i5);
                        i5 = i6;
                        i8 = i10;
                    }
                }
            }
            if (i3 != -1 && i3 != length) {
                q(spannableStringBuilder, i3, length);
            }
            if (i4 != -1 && i4 != length) {
                o(spannableStringBuilder, i4, length);
            }
            if (i8 != length) {
                n(spannableStringBuilder, i8, length, i5);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i3, int i4, int i5) {
            if (i5 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i3, i4, 33);
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i3, int i4) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i3, int i4) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, 33);
        }

        public void e(char c3) {
            if (this.f47001c.length() < 32) {
                this.f47001c.append(c3);
            }
        }

        public void f() {
            int length = this.f47001c.length();
            if (length > 0) {
                this.f47001c.delete(length - 1, length);
                for (int size = this.f46999a.size() - 1; size >= 0; size--) {
                    CueStyle cueStyle = (CueStyle) this.f46999a.get(size);
                    int i3 = cueStyle.f47009c;
                    if (i3 != length) {
                        return;
                    }
                    cueStyle.f47009c = i3 - 1;
                }
            }
        }

        public Cue g(int i3) {
            float f3;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.f47000b.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.f47000b.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) h());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.f47003e + this.f47004f;
            int length = (32 - i5) - spannableStringBuilder.length();
            int i6 = i5 - length;
            if (i3 == Integer.MIN_VALUE) {
                i3 = (this.f47005g != 2 || (Math.abs(i6) >= 3 && length >= 0)) ? (this.f47005g != 2 || i6 <= 0) ? 0 : 2 : 1;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    i5 = 32 - length;
                }
                f3 = ((i5 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f3 = 0.5f;
            }
            int i7 = this.f47002d;
            if (i7 > 7) {
                i7 -= 17;
            } else if (this.f47005g == 1) {
                i7 -= this.f47006h - 1;
            }
            return new Cue.Builder().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i7, 1).k(f3).l(i3).a();
        }

        public boolean i() {
            return this.f46999a.isEmpty() && this.f47000b.isEmpty() && this.f47001c.length() == 0;
        }

        public void j(int i3) {
            this.f47005g = i3;
            this.f46999a.clear();
            this.f47000b.clear();
            this.f47001c.setLength(0);
            this.f47002d = 15;
            this.f47003e = 0;
            this.f47004f = 0;
        }

        public void k() {
            this.f47000b.add(h());
            this.f47001c.setLength(0);
            this.f46999a.clear();
            int iMin = Math.min(this.f47006h, this.f47002d);
            while (this.f47000b.size() >= iMin) {
                this.f47000b.remove(0);
            }
        }

        public void l(int i3) {
            this.f47005g = i3;
        }

        public void m(int i3) {
            this.f47006h = i3;
        }

        public void p(int i3, boolean z2) {
            this.f46999a.add(new CueStyle(i3, z2, this.f47001c.length()));
        }
    }

    public Cea608Decoder(String str, int i3, long j3) {
        if (j3 != -9223372036854775807L) {
            Assertions.a(j3 >= GoogleBillingWrapperKt.RECONNECT_TIMER_MAX_TIME_MILLISECONDS);
            this.f46985l = j3 * 1000;
        } else {
            this.f46985l = -9223372036854775807L;
        }
        this.f46982i = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i3 == 1) {
            this.f46984k = 0;
            this.f46983j = 0;
        } else if (i3 == 2) {
            this.f46984k = 1;
            this.f46983j = 0;
        } else if (i3 == 3) {
            this.f46984k = 0;
            this.f46983j = 1;
        } else if (i3 != 4) {
            Log.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f46984k = 0;
            this.f46983j = 0;
        } else {
            this.f46984k = 1;
            this.f46983j = 1;
        }
        O(0);
        N();
        this.f46997x = true;
        this.f46998y = -9223372036854775807L;
    }

    private void A(byte b3, byte b4) {
        int i3 = f46980z[b3 & 7];
        if ((b4 & 32) != 0) {
            i3++;
        }
        if (i3 != this.f46987n.f47002d) {
            if (this.f46990q != 1 && !this.f46987n.i()) {
                CueBuilder cueBuilder = new CueBuilder(this.f46990q, this.f46991r);
                this.f46987n = cueBuilder;
                this.f46986m.add(cueBuilder);
            }
            this.f46987n.f47002d = i3;
        }
        boolean z2 = (b4 & Ascii.DLE) == 16;
        boolean z3 = (b4 & 1) == 1;
        int i4 = (b4 >> 1) & 7;
        this.f46987n.p(z2 ? 8 : i4, z3);
        if (z2) {
            this.f46987n.f47003e = A[i4];
        }
    }

    private static boolean B(byte b3) {
        return (b3 & 224) == 0;
    }

    private static boolean C(byte b3, byte b4) {
        return (b3 & 246) == 18 && (b4 & 224) == 32;
    }

    private static boolean D(byte b3, byte b4) {
        return (b3 & 247) == 17 && (b4 & 240) == 32;
    }

    private static boolean E(byte b3, byte b4) {
        return (b3 & 246) == 20 && (b4 & 240) == 32;
    }

    private static boolean F(byte b3, byte b4) {
        return (b3 & 240) == 16 && (b4 & 192) == 64;
    }

    private static boolean G(byte b3) {
        return (b3 & 240) == 16;
    }

    private boolean H(boolean z2, byte b3, byte b4) {
        if (!z2 || !G(b3)) {
            this.f46993t = false;
        } else {
            if (this.f46993t && this.f46994u == b3 && this.f46995v == b4) {
                this.f46993t = false;
                return true;
            }
            this.f46993t = true;
            this.f46994u = b3;
            this.f46995v = b4;
        }
        return false;
    }

    private static boolean I(byte b3) {
        return (b3 & 246) == 20;
    }

    private static boolean J(byte b3, byte b4) {
        return (b3 & 247) == 17 && (b4 & 240) == 48;
    }

    private static boolean K(byte b3, byte b4) {
        return (b3 & 247) == 23 && b4 >= 33 && b4 <= 35;
    }

    private static boolean L(byte b3) {
        return 1 <= b3 && b3 <= 15;
    }

    private void M(byte b3, byte b4) {
        if (L(b3)) {
            this.f46997x = false;
            return;
        }
        if (I(b3)) {
            if (b4 != 32 && b4 != 47) {
                switch (b4) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b4) {
                            case 42:
                            case 43:
                                this.f46997x = false;
                                break;
                        }
                        return;
                }
            }
            this.f46997x = true;
        }
    }

    private void N() {
        this.f46987n.j(this.f46990q);
        this.f46986m.clear();
        this.f46986m.add(this.f46987n);
    }

    private void O(int i3) {
        int i4 = this.f46990q;
        if (i4 == i3) {
            return;
        }
        this.f46990q = i3;
        if (i3 == 3) {
            for (int i5 = 0; i5 < this.f46986m.size(); i5++) {
                ((CueBuilder) this.f46986m.get(i5)).l(i3);
            }
            return;
        }
        N();
        if (i4 == 3 || i3 == 1 || i3 == 0) {
            this.f46988o = Collections.EMPTY_LIST;
        }
    }

    private void P(int i3) {
        this.f46991r = i3;
        this.f46987n.m(i3);
    }

    private boolean Q() {
        return (this.f46985l == -9223372036854775807L || this.f46998y == -9223372036854775807L || l() - this.f46998y < this.f46985l) ? false : true;
    }

    private boolean R(byte b3) {
        if (B(b3)) {
            this.f46996w = s(b3);
        }
        return this.f46996w == this.f46984k;
    }

    private static char r(byte b3) {
        return (char) C[(b3 & Ascii.DEL) - 32];
    }

    private static int s(byte b3) {
        return (b3 >> 3) & 1;
    }

    private List t() {
        int size = this.f46986m.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i3 = 0; i3 < size; i3++) {
            Cue cueG = ((CueBuilder) this.f46986m.get(i3)).g(Integer.MIN_VALUE);
            arrayList.add(cueG);
            if (cueG != null) {
                iMin = Math.min(iMin, cueG.f41424i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            Cue cue = (Cue) arrayList.get(i4);
            if (cue != null) {
                if (cue.f41424i != iMin) {
                    cue = (Cue) Assertions.e(((CueBuilder) this.f46986m.get(i4)).g(iMin));
                }
                arrayList2.add(cue);
            }
        }
        return arrayList2;
    }

    private static char u(byte b3) {
        return (char) E[b3 & Ascii.US];
    }

    private static char v(byte b3) {
        return (char) F[b3 & Ascii.US];
    }

    private static char w(byte b3, byte b4) {
        return (b3 & 1) == 0 ? u(b4) : v(b4);
    }

    private static char x(byte b3) {
        return (char) D[b3 & Ascii.SI];
    }

    private void y(byte b3) {
        this.f46987n.e(' ');
        this.f46987n.p((b3 >> 1) & 7, (b3 & 1) == 1);
    }

    private void z(byte b3) {
        if (b3 == 32) {
            O(2);
            return;
        }
        if (b3 == 41) {
            O(3);
            return;
        }
        switch (b3) {
            case 37:
                O(1);
                P(2);
                break;
            case 38:
                O(1);
                P(3);
                break;
            case 39:
                O(1);
                P(4);
                break;
            default:
                int i3 = this.f46990q;
                if (i3 != 0) {
                    if (b3 != 33) {
                        switch (b3) {
                            case 44:
                                this.f46988o = Collections.EMPTY_LIST;
                                if (i3 == 1 || i3 == 3) {
                                    N();
                                }
                                break;
                            case 45:
                                if (i3 == 1 && !this.f46987n.i()) {
                                    this.f46987n.k();
                                    break;
                                }
                                break;
                            case 46:
                                N();
                                break;
                            case 47:
                                this.f46988o = t();
                                N();
                                break;
                        }
                    } else {
                        this.f46987n.f();
                        break;
                    }
                }
                break;
        }
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.extractor.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void c(long j3) {
        super.c(j3);
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public void flush() {
        super.flush();
        this.f46988o = null;
        this.f46989p = null;
        O(0);
        P(4);
        N();
        this.f46992s = false;
        this.f46993t = false;
        this.f46994u = (byte) 0;
        this.f46995v = (byte) 0;
        this.f46996w = 0;
        this.f46997x = true;
        this.f46998y = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    protected Subtitle g() {
        List list = this.f46988o;
        this.f46989p = list;
        return new CeaSubtitle((List) Assertions.e(list));
    }

    @Override // androidx.media3.decoder.Decoder
    public String getName() {
        return "Cea608Decoder";
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void h(androidx.media3.extractor.text.SubtitleInputBuffer r10) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea608Decoder.h(androidx.media3.extractor.text.SubtitleInputBuffer):void");
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    /* JADX INFO: renamed from: i */
    public /* bridge */ /* synthetic */ SubtitleInputBuffer f() {
        return super.f();
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: j */
    public SubtitleOutputBuffer a() {
        SubtitleOutputBuffer subtitleOutputBufferK;
        SubtitleOutputBuffer subtitleOutputBufferA = super.a();
        if (subtitleOutputBufferA != null) {
            return subtitleOutputBufferA;
        }
        if (!Q() || (subtitleOutputBufferK = k()) == null) {
            return null;
        }
        this.f46988o = Collections.EMPTY_LIST;
        this.f46998y = -9223372036854775807L;
        subtitleOutputBufferK.p(l(), g(), Long.MAX_VALUE);
        return subtitleOutputBufferK;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    protected boolean m() {
        return this.f46988o != this.f46989p;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    /* JADX INFO: renamed from: n */
    public /* bridge */ /* synthetic */ void b(SubtitleInputBuffer subtitleInputBuffer) {
        super.b(subtitleInputBuffer);
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public void release() {
    }
}
