package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import androidx.media3.extractor.text.cea.Cea708Decoder;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Cea708Decoder extends CeaDecoder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ParsableByteArray f47010h = new ParsableByteArray();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ParsableBitArray f47011i = new ParsableBitArray();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f47012j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f47013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f47014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CueInfoBuilder[] f47015m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CueInfoBuilder f47016n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f47017o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List f47018p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private DtvCcPacket f47019q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f47020r;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Cea708CueInfo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Comparator f47021c = new Comparator() { // from class: androidx.media3.extractor.text.cea.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((Cea708Decoder.Cea708CueInfo) obj2).f47023b, ((Cea708Decoder.Cea708CueInfo) obj).f47023b);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cue f47022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47023b;

        public Cea708CueInfo(CharSequence charSequence, Layout.Alignment alignment, float f3, int i3, int i4, float f4, int i5, float f5, boolean z2, int i6, int i7) {
            Cue.Builder builderN = new Cue.Builder().o(charSequence).p(alignment).h(f3, i3).i(i4).k(f4).l(i5).n(f5);
            if (z2) {
                builderN.s(i6);
            }
            this.f47022a = builderN.a();
            this.f47023b = i7;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CueInfoBuilder {
        private static final int[] A;
        private static final boolean[] B;
        private static final int[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f47024v = h(2, 2, 2, 0);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f47025w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f47026x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final int[] f47027y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final int[] f47028z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f47029a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SpannableStringBuilder f47030b = new SpannableStringBuilder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f47031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f47032d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f47033e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f47034f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47035g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f47036h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f47037i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f47038j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f47039k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f47040l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f47041m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f47042n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f47043o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f47044p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f47045q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f47046r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f47047s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f47048t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f47049u;

        static {
            int iH = h(0, 0, 0, 0);
            f47025w = iH;
            int iH2 = h(0, 0, 0, 3);
            f47026x = iH2;
            f47027y = new int[]{0, 0, 0, 0, 0, 2, 0};
            f47028z = new int[]{0, 0, 0, 0, 0, 0, 2};
            A = new int[]{3, 3, 3, 3, 3, 3, 1};
            B = new boolean[]{false, false, false, true, true, true, false};
            C = new int[]{iH, iH2, iH, iH, iH2, iH, iH};
            D = new int[]{0, 1, 2, 3, 4, 3, 4};
            E = new int[]{0, 0, 0, 0, 0, 3, 3};
            F = new int[]{iH, iH, iH, iH, iH, iH2, iH2};
        }

        public CueInfoBuilder() {
            l();
        }

        public static int g(int i3, int i4, int i5) {
            return h(i3, i4, i5, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                androidx.media3.common.util.Assertions.c(r4, r0, r1)
                androidx.media3.common.util.Assertions.c(r5, r0, r1)
                androidx.media3.common.util.Assertions.c(r6, r0, r1)
                androidx.media3.common.util.Assertions.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L1b
                if (r7 == r1) goto L1b
                r3 = 2
                if (r7 == r3) goto L1f
                r3 = 3
                if (r7 == r3) goto L1d
            L1b:
                r7 = r2
                goto L21
            L1d:
                r7 = r0
                goto L21
            L1f:
                r7 = 127(0x7f, float:1.78E-43)
            L21:
                if (r4 <= r1) goto L25
                r4 = r2
                goto L26
            L25:
                r4 = r0
            L26:
                if (r5 <= r1) goto L2a
                r5 = r2
                goto L2b
            L2a:
                r5 = r0
            L2b:
                if (r6 <= r1) goto L2e
                r0 = r2
            L2e:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea708Decoder.CueInfoBuilder.h(int, int, int, int):int");
        }

        public void a(char c3) {
            if (c3 != '\n') {
                this.f47030b.append(c3);
                return;
            }
            this.f47029a.add(d());
            this.f47030b.clear();
            if (this.f47043o != -1) {
                this.f47043o = 0;
            }
            if (this.f47044p != -1) {
                this.f47044p = 0;
            }
            if (this.f47045q != -1) {
                this.f47045q = 0;
            }
            if (this.f47047s != -1) {
                this.f47047s = 0;
            }
            while (true) {
                if (this.f47029a.size() < this.f47038j && this.f47029a.size() < 15) {
                    this.f47049u = this.f47029a.size();
                    return;
                }
                this.f47029a.remove(0);
            }
        }

        public void b() {
            int length = this.f47030b.length();
            if (length > 0) {
                this.f47030b.delete(length - 1, length);
            }
        }

        public Cea708CueInfo c() {
            Layout.Alignment alignment;
            float f3;
            float f4;
            int i3;
            float f5;
            int i4;
            if (j()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.f47029a.size(); i5++) {
                spannableStringBuilder.append((CharSequence) this.f47029a.get(i5));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            int i6 = this.f47039k;
            int i7 = 2;
            if (i6 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i6 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i6 != 2) {
                if (i6 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.f47039k);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            if (this.f47034f) {
                f3 = this.f47036h / 99.0f;
                f4 = this.f47035g / 99.0f;
            } else {
                f3 = this.f47036h / 209.0f;
                f4 = this.f47035g / 74.0f;
            }
            float f6 = (f3 * 0.9f) + 0.05f;
            float f7 = (f4 * 0.9f) + 0.05f;
            int i8 = this.f47037i;
            if (i8 / 3 == 0) {
                i3 = i8;
                f5 = f6;
                i4 = 0;
            } else if (i8 / 3 == 1) {
                i3 = i8;
                f5 = f6;
                i4 = 1;
            } else {
                i3 = i8;
                f5 = f6;
                i4 = 2;
            }
            if (i3 % 3 == 0) {
                i7 = 0;
            } else if (i3 % 3 == 1) {
                i7 = 1;
            }
            return new Cea708CueInfo(spannableStringBuilder, alignment, f7, 0, i4, f5, i7, -3.4028235E38f, this.f47042n != f47025w, this.f47042n, this.f47033e);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f47030b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f47043o != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f47043o, length, 33);
                }
                if (this.f47044p != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f47044p, length, 33);
                }
                if (this.f47045q != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f47046r), this.f47045q, length, 33);
                }
                if (this.f47047s != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f47048t), this.f47047s, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f47029a.clear();
            this.f47030b.clear();
            this.f47043o = -1;
            this.f47044p = -1;
            this.f47045q = -1;
            this.f47047s = -1;
            this.f47049u = 0;
        }

        public void f(boolean z2, int i3, boolean z3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f47031c = true;
            this.f47032d = z2;
            this.f47033e = i3;
            this.f47034f = z3;
            this.f47035g = i4;
            this.f47036h = i5;
            this.f47037i = i7;
            int i10 = i6 + 1;
            if (this.f47038j != i10) {
                this.f47038j = i10;
                while (true) {
                    if (this.f47029a.size() < this.f47038j && this.f47029a.size() < 15) {
                        break;
                    } else {
                        this.f47029a.remove(0);
                    }
                }
            }
            if (i8 != 0 && this.f47040l != i8) {
                this.f47040l = i8;
                int i11 = i8 - 1;
                q(C[i11], f47026x, B[i11], 0, f47028z[i11], A[i11], f47027y[i11]);
            }
            if (i9 == 0 || this.f47041m == i9) {
                return;
            }
            this.f47041m = i9;
            int i12 = i9 - 1;
            m(0, 1, 1, false, false, E[i12], D[i12]);
            n(f47024v, F[i12], f47025w);
        }

        public boolean i() {
            return this.f47031c;
        }

        public boolean j() {
            if (i()) {
                return this.f47029a.isEmpty() && this.f47030b.length() == 0;
            }
            return true;
        }

        public boolean k() {
            return this.f47032d;
        }

        public void l() {
            e();
            this.f47031c = false;
            this.f47032d = false;
            this.f47033e = 4;
            this.f47034f = false;
            this.f47035g = 0;
            this.f47036h = 0;
            this.f47037i = 0;
            this.f47038j = 15;
            this.f47039k = 0;
            this.f47040l = 0;
            this.f47041m = 0;
            int i3 = f47025w;
            this.f47042n = i3;
            this.f47046r = f47024v;
            this.f47048t = i3;
        }

        public void m(int i3, int i4, int i5, boolean z2, boolean z3, int i6, int i7) {
            if (this.f47043o != -1) {
                if (!z2) {
                    this.f47030b.setSpan(new StyleSpan(2), this.f47043o, this.f47030b.length(), 33);
                    this.f47043o = -1;
                }
            } else if (z2) {
                this.f47043o = this.f47030b.length();
            }
            if (this.f47044p == -1) {
                if (z3) {
                    this.f47044p = this.f47030b.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.f47030b.setSpan(new UnderlineSpan(), this.f47044p, this.f47030b.length(), 33);
                this.f47044p = -1;
            }
        }

        public void n(int i3, int i4, int i5) {
            if (this.f47045q != -1 && this.f47046r != i3) {
                this.f47030b.setSpan(new ForegroundColorSpan(this.f47046r), this.f47045q, this.f47030b.length(), 33);
            }
            if (i3 != f47024v) {
                this.f47045q = this.f47030b.length();
                this.f47046r = i3;
            }
            if (this.f47047s != -1 && this.f47048t != i4) {
                this.f47030b.setSpan(new BackgroundColorSpan(this.f47048t), this.f47047s, this.f47030b.length(), 33);
            }
            if (i4 != f47025w) {
                this.f47047s = this.f47030b.length();
                this.f47048t = i4;
            }
        }

        public void o(int i3, int i4) {
            if (this.f47049u != i3) {
                a('\n');
            }
            this.f47049u = i3;
        }

        public void p(boolean z2) {
            this.f47032d = z2;
        }

        public void q(int i3, int i4, boolean z2, int i5, int i6, int i7, int i8) {
            this.f47042n = i3;
            this.f47039k = i8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DtvCcPacket {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f47052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f47053d = 0;

        public DtvCcPacket(int i3, int i4) {
            this.f47050a = i3;
            this.f47051b = i4;
            this.f47052c = new byte[(i4 * 2) - 1];
        }
    }

    public Cea708Decoder(int i3, List list) {
        this.f47014l = i3 == -1 ? 1 : i3;
        this.f47013k = list != null && CodecSpecificDataUtil.w(list);
        this.f47015m = new CueInfoBuilder[8];
        for (int i4 = 0; i4 < 8; i4++) {
            this.f47015m[i4] = new CueInfoBuilder();
        }
        this.f47016n = this.f47015m[0];
    }

    private void A(int i3) {
        if (i3 == 160) {
            this.f47016n.a((char) 13252);
            return;
        }
        Log.i("Cea708Decoder", "Invalid G3 character: " + i3);
        this.f47016n.a('_');
    }

    private void B() {
        this.f47016n.m(this.f47011i.h(4), this.f47011i.h(2), this.f47011i.h(2), this.f47011i.g(), this.f47011i.g(), this.f47011i.h(3), this.f47011i.h(3));
    }

    private void C() {
        int iH = CueInfoBuilder.h(this.f47011i.h(2), this.f47011i.h(2), this.f47011i.h(2), this.f47011i.h(2));
        int iH2 = CueInfoBuilder.h(this.f47011i.h(2), this.f47011i.h(2), this.f47011i.h(2), this.f47011i.h(2));
        this.f47011i.r(2);
        this.f47016n.n(iH, iH2, CueInfoBuilder.g(this.f47011i.h(2), this.f47011i.h(2), this.f47011i.h(2)));
    }

    private void D() {
        this.f47011i.r(4);
        int iH = this.f47011i.h(4);
        this.f47011i.r(2);
        this.f47016n.o(iH, this.f47011i.h(6));
    }

    private void E() {
        int iH = CueInfoBuilder.h(this.f47011i.h(2), this.f47011i.h(2), this.f47011i.h(2), this.f47011i.h(2));
        int iH2 = this.f47011i.h(2);
        int iG = CueInfoBuilder.g(this.f47011i.h(2), this.f47011i.h(2), this.f47011i.h(2));
        if (this.f47011i.g()) {
            iH2 |= 4;
        }
        boolean zG = this.f47011i.g();
        int iH3 = this.f47011i.h(2);
        int iH4 = this.f47011i.h(2);
        int iH5 = this.f47011i.h(2);
        this.f47011i.r(8);
        this.f47016n.q(iH, iG, zG, iH2, iH3, iH4, iH5);
    }

    private void F() {
        DtvCcPacket dtvCcPacket = this.f47019q;
        if (dtvCcPacket.f47053d != (dtvCcPacket.f47051b * 2) - 1) {
            Log.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f47019q.f47051b * 2) - 1) + ", but current index is " + this.f47019q.f47053d + " (sequence number " + this.f47019q.f47050a + ");");
        }
        ParsableBitArray parsableBitArray = this.f47011i;
        DtvCcPacket dtvCcPacket2 = this.f47019q;
        parsableBitArray.o(dtvCcPacket2.f47052c, dtvCcPacket2.f47053d);
        boolean z2 = false;
        while (true) {
            if (this.f47011i.b() <= 0) {
                break;
            }
            int iH = this.f47011i.h(3);
            int iH2 = this.f47011i.h(5);
            if (iH == 7) {
                this.f47011i.r(2);
                iH = this.f47011i.h(6);
                if (iH < 7) {
                    Log.i("Cea708Decoder", "Invalid extended service number: " + iH);
                }
            }
            if (iH2 == 0) {
                if (iH != 0) {
                    Log.i("Cea708Decoder", "serviceNumber is non-zero (" + iH + ") when blockSize is 0");
                }
            } else if (iH != this.f47014l) {
                this.f47011i.s(iH2);
            } else {
                int iE = this.f47011i.e() + (iH2 * 8);
                while (this.f47011i.e() < iE) {
                    int iH3 = this.f47011i.h(8);
                    if (iH3 == 16) {
                        int iH4 = this.f47011i.h(8);
                        if (iH4 <= 31) {
                            u(iH4);
                        } else {
                            if (iH4 <= 127) {
                                z(iH4);
                            } else if (iH4 <= 159) {
                                v(iH4);
                            } else if (iH4 <= 255) {
                                A(iH4);
                            } else {
                                Log.i("Cea708Decoder", "Invalid extended command: " + iH4);
                            }
                            z2 = true;
                        }
                    } else if (iH3 <= 31) {
                        s(iH3);
                    } else {
                        if (iH3 <= 127) {
                            x(iH3);
                        } else if (iH3 <= 159) {
                            t(iH3);
                        } else if (iH3 <= 255) {
                            y(iH3);
                        } else {
                            Log.i("Cea708Decoder", "Invalid base command: " + iH3);
                        }
                        z2 = true;
                    }
                }
            }
        }
        if (z2) {
            this.f47017o = r();
        }
    }

    private void G() {
        for (int i3 = 0; i3 < 8; i3++) {
            this.f47015m[i3].l();
        }
    }

    private void q() {
        if (this.f47019q == null) {
            return;
        }
        F();
        this.f47019q = null;
    }

    private List r() {
        Cea708CueInfo cea708CueInfoC;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 8; i3++) {
            if (!this.f47015m[i3].j() && this.f47015m[i3].k() && (cea708CueInfoC = this.f47015m[i3].c()) != null) {
                arrayList.add(cea708CueInfoC);
            }
        }
        Collections.sort(arrayList, Cea708CueInfo.f47021c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList2.add(((Cea708CueInfo) arrayList.get(i4)).f47022a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void s(int i3) {
        if (i3 != 0) {
            if (i3 == 3) {
                this.f47017o = r();
                return;
            }
            if (i3 == 8) {
                this.f47016n.b();
                return;
            }
            switch (i3) {
                case 12:
                    G();
                    break;
                case 13:
                    this.f47016n.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i3 >= 17 && i3 <= 23) {
                        Log.i("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i3);
                        this.f47011i.r(8);
                    } else if (i3 >= 24 && i3 <= 31) {
                        Log.i("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i3);
                        this.f47011i.r(16);
                    } else {
                        Log.i("Cea708Decoder", "Invalid C0 command: " + i3);
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void t(int i3) {
        int i4 = 1;
        switch (i3) {
            case ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD /* 128 */:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i5 = i3 - 128;
                if (this.f47020r != i5) {
                    this.f47020r = i5;
                    this.f47016n = this.f47015m[i5];
                }
                break;
            case 136:
                while (i4 <= 8) {
                    if (this.f47011i.g()) {
                        this.f47015m[8 - i4].e();
                    }
                    i4++;
                }
                break;
            case 137:
                for (int i6 = 1; i6 <= 8; i6++) {
                    if (this.f47011i.g()) {
                        this.f47015m[8 - i6].p(true);
                    }
                }
                break;
            case 138:
                while (i4 <= 8) {
                    if (this.f47011i.g()) {
                        this.f47015m[8 - i4].p(false);
                    }
                    i4++;
                }
                break;
            case 139:
                for (int i7 = 1; i7 <= 8; i7++) {
                    if (this.f47011i.g()) {
                        this.f47015m[8 - i7].p(!r0.k());
                    }
                }
                break;
            case 140:
                while (i4 <= 8) {
                    if (this.f47011i.g()) {
                        this.f47015m[8 - i4].l();
                    }
                    i4++;
                }
                break;
            case 141:
                this.f47011i.r(8);
                break;
            case 142:
                break;
            case 143:
                G();
                break;
            case 144:
                if (this.f47016n.i()) {
                    B();
                } else {
                    this.f47011i.r(16);
                }
                break;
            case 145:
                if (this.f47016n.i()) {
                    C();
                } else {
                    this.f47011i.r(24);
                }
                break;
            case 146:
                if (this.f47016n.i()) {
                    D();
                } else {
                    this.f47011i.r(16);
                }
                break;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                Log.i("Cea708Decoder", "Invalid C1 command: " + i3);
                break;
            case 151:
                if (this.f47016n.i()) {
                    E();
                } else {
                    this.f47011i.r(32);
                }
                break;
            case 152:
            case 153:
            case 154:
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
            case 156:
            case 157:
            case 158:
            case 159:
                int i8 = i3 - 152;
                w(i8);
                if (this.f47020r != i8) {
                    this.f47020r = i8;
                    this.f47016n = this.f47015m[i8];
                }
                break;
        }
    }

    private void u(int i3) {
        if (i3 <= 7) {
            return;
        }
        if (i3 <= 15) {
            this.f47011i.r(8);
        } else if (i3 <= 23) {
            this.f47011i.r(16);
        } else if (i3 <= 31) {
            this.f47011i.r(24);
        }
    }

    private void v(int i3) {
        if (i3 <= 135) {
            this.f47011i.r(32);
            return;
        }
        if (i3 <= 143) {
            this.f47011i.r(40);
        } else if (i3 <= 159) {
            this.f47011i.r(2);
            this.f47011i.r(this.f47011i.h(6) * 8);
        }
    }

    private void w(int i3) {
        CueInfoBuilder cueInfoBuilder = this.f47015m[i3];
        this.f47011i.r(2);
        boolean zG = this.f47011i.g();
        this.f47011i.r(2);
        int iH = this.f47011i.h(3);
        boolean zG2 = this.f47011i.g();
        int iH2 = this.f47011i.h(7);
        int iH3 = this.f47011i.h(8);
        int iH4 = this.f47011i.h(4);
        int iH5 = this.f47011i.h(4);
        this.f47011i.r(2);
        this.f47011i.r(6);
        this.f47011i.r(2);
        cueInfoBuilder.f(zG, iH, zG2, iH2, iH3, iH5, iH4, this.f47011i.h(3), this.f47011i.h(3));
    }

    private void x(int i3) {
        if (i3 == 127) {
            this.f47016n.a((char) 9835);
        } else {
            this.f47016n.a((char) (i3 & 255));
        }
    }

    private void y(int i3) {
        this.f47016n.a((char) (i3 & 255));
    }

    private void z(int i3) {
        if (i3 == 32) {
            this.f47016n.a(' ');
            return;
        }
        if (i3 == 33) {
            this.f47016n.a((char) 160);
            return;
        }
        if (i3 == 37) {
            this.f47016n.a((char) 8230);
            return;
        }
        if (i3 == 42) {
            this.f47016n.a((char) 352);
            return;
        }
        if (i3 == 44) {
            this.f47016n.a((char) 338);
            return;
        }
        if (i3 == 63) {
            this.f47016n.a((char) 376);
            return;
        }
        if (i3 == 57) {
            this.f47016n.a((char) 8482);
            return;
        }
        if (i3 == 58) {
            this.f47016n.a((char) 353);
            return;
        }
        if (i3 == 60) {
            this.f47016n.a((char) 339);
            return;
        }
        if (i3 == 61) {
            this.f47016n.a((char) 8480);
            return;
        }
        switch (i3) {
            case 48:
                this.f47016n.a((char) 9608);
                break;
            case 49:
                this.f47016n.a((char) 8216);
                break;
            case 50:
                this.f47016n.a((char) 8217);
                break;
            case 51:
                this.f47016n.a((char) 8220);
                break;
            case 52:
                this.f47016n.a((char) 8221);
                break;
            case 53:
                this.f47016n.a((char) 8226);
                break;
            default:
                switch (i3) {
                    case 118:
                        this.f47016n.a((char) 8539);
                        break;
                    case 119:
                        this.f47016n.a((char) 8540);
                        break;
                    case 120:
                        this.f47016n.a((char) 8541);
                        break;
                    case 121:
                        this.f47016n.a((char) 8542);
                        break;
                    case 122:
                        this.f47016n.a((char) 9474);
                        break;
                    case 123:
                        this.f47016n.a((char) 9488);
                        break;
                    case 124:
                        this.f47016n.a((char) 9492);
                        break;
                    case 125:
                        this.f47016n.a((char) 9472);
                        break;
                    case 126:
                        this.f47016n.a((char) 9496);
                        break;
                    case 127:
                        this.f47016n.a((char) 9484);
                        break;
                    default:
                        Log.i("Cea708Decoder", "Invalid G2 character: " + i3);
                        break;
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
        this.f47017o = null;
        this.f47018p = null;
        this.f47020r = 0;
        this.f47016n = this.f47015m[0];
        G();
        this.f47019q = null;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    protected Subtitle g() {
        List list = this.f47017o;
        this.f47018p = list;
        return new CeaSubtitle((List) Assertions.e(list));
    }

    @Override // androidx.media3.decoder.Decoder
    public String getName() {
        return "Cea708Decoder";
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    protected void h(SubtitleInputBuffer subtitleInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(subtitleInputBuffer.f42138d);
        this.f47010h.U(byteBuffer.array(), byteBuffer.limit());
        while (this.f47010h.a() >= 3) {
            int iH = this.f47010h.H();
            int i3 = iH & 3;
            boolean z2 = (iH & 4) == 4;
            byte bH = (byte) this.f47010h.H();
            byte bH2 = (byte) this.f47010h.H();
            if (i3 == 2 || i3 == 3) {
                if (z2) {
                    if (i3 == 3) {
                        q();
                        int i4 = (bH & 192) >> 6;
                        int i5 = this.f47012j;
                        if (i5 != -1 && i4 != (i5 + 1) % 4) {
                            G();
                            Log.i("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f47012j + " current=" + i4);
                        }
                        this.f47012j = i4;
                        int i6 = bH & 63;
                        if (i6 == 0) {
                            i6 = 64;
                        }
                        DtvCcPacket dtvCcPacket = new DtvCcPacket(i4, i6);
                        this.f47019q = dtvCcPacket;
                        byte[] bArr = dtvCcPacket.f47052c;
                        int i7 = dtvCcPacket.f47053d;
                        dtvCcPacket.f47053d = i7 + 1;
                        bArr[i7] = bH2;
                    } else {
                        Assertions.a(i3 == 2);
                        DtvCcPacket dtvCcPacket2 = this.f47019q;
                        if (dtvCcPacket2 == null) {
                            Log.d("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = dtvCcPacket2.f47052c;
                            int i8 = dtvCcPacket2.f47053d;
                            int i9 = i8 + 1;
                            dtvCcPacket2.f47053d = i9;
                            bArr2[i8] = bH;
                            dtvCcPacket2.f47053d = i8 + 2;
                            bArr2[i9] = bH2;
                        }
                    }
                    DtvCcPacket dtvCcPacket3 = this.f47019q;
                    if (dtvCcPacket3.f47053d == (dtvCcPacket3.f47051b * 2) - 1) {
                        q();
                    }
                }
            }
        }
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    /* JADX INFO: renamed from: i */
    public /* bridge */ /* synthetic */ SubtitleInputBuffer f() {
        return super.f();
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    /* JADX INFO: renamed from: j */
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer a() {
        return super.a();
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    protected boolean m() {
        return this.f47017o != this.f47018p;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    /* JADX INFO: renamed from: n */
    public /* bridge */ /* synthetic */ void b(SubtitleInputBuffer subtitleInputBuffer) {
        super.b(subtitleInputBuffer);
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }
}
