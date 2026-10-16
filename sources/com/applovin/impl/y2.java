package com.applovin.impl;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.a5;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class y2 extends a3 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f65117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f65118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f65119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f65120k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List f65123n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f65124o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f65125p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f65126q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f65127r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f65128s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private byte f65129t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private byte f65130u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f65132w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f65133x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int[] f65114y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f65115z = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] A = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] D = {193, RCHTTPStatusCodes.CREATED, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ah f65116g = new ah();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ArrayList f65121l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private a f65122m = new a(0, 4);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f65131v = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f65134a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f65135b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StringBuilder f65136c = new StringBuilder();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f65137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f65138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f65139f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f65140g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f65141h;

        /* JADX INFO: renamed from: com.applovin.impl.y2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class C0130a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f65142a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f65143b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f65144c;

            public C0130a(int i3, boolean z2, int i4) {
                this.f65142a = i3;
                this.f65143b = z2;
                this.f65144c = i4;
            }
        }

        public a(int i3, int i4) {
            b(i3);
            this.f65141h = i4;
        }

        public void d() {
            this.f65135b.add(b());
            this.f65136c.setLength(0);
            this.f65134a.clear();
            int iMin = Math.min(this.f65141h, this.f65137d);
            while (this.f65135b.size() >= iMin) {
                this.f65135b.remove(0);
            }
        }

        public void b(int i3) {
            this.f65140g = i3;
            this.f65134a.clear();
            this.f65135b.clear();
            this.f65136c.setLength(0);
            this.f65137d = 15;
            this.f65138e = 0;
            this.f65139f = 0;
        }

        public boolean c() {
            return this.f65134a.isEmpty() && this.f65135b.isEmpty() && this.f65136c.length() == 0;
        }

        public void a(char c3) {
            if (this.f65136c.length() < 32) {
                this.f65136c.append(c3);
            }
        }

        public void a() {
            int length = this.f65136c.length();
            if (length > 0) {
                this.f65136c.delete(length - 1, length);
                for (int size = this.f65134a.size() - 1; size >= 0; size--) {
                    C0130a c0130a = (C0130a) this.f65134a.get(size);
                    int i3 = c0130a.f65144c;
                    if (i3 != length) {
                        return;
                    }
                    c0130a.f65144c = i3 - 1;
                }
            }
        }

        public void c(int i3) {
            this.f65140g = i3;
        }

        public void d(int i3) {
            this.f65141h = i3;
        }

        private static void b(SpannableStringBuilder spannableStringBuilder, int i3, int i4) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, 33);
        }

        private SpannableString b() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f65136c);
            int length = spannableStringBuilder.length();
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = 0;
            int i8 = 0;
            boolean z2 = false;
            while (i7 < this.f65134a.size()) {
                C0130a c0130a = (C0130a) this.f65134a.get(i7);
                boolean z3 = c0130a.f65143b;
                int i9 = c0130a.f65142a;
                if (i9 != 8) {
                    boolean z4 = i9 == 7;
                    if (i9 != 7) {
                        i6 = y2.A[i9];
                    }
                    z2 = z4;
                }
                int i10 = c0130a.f65144c;
                i7++;
                if (i10 != (i7 < this.f65134a.size() ? ((C0130a) this.f65134a.get(i7)).f65144c : length)) {
                    if (i3 != -1 && !z3) {
                        b(spannableStringBuilder, i3, i10);
                        i3 = -1;
                    } else if (i3 == -1 && z3) {
                        i3 = i10;
                    }
                    if (i4 != -1 && !z2) {
                        a(spannableStringBuilder, i4, i10);
                        i4 = -1;
                    } else if (i4 == -1 && z2) {
                        i4 = i10;
                    }
                    if (i6 != i5) {
                        a(spannableStringBuilder, i8, i10, i5);
                        i5 = i6;
                        i8 = i10;
                    }
                }
            }
            if (i3 != -1 && i3 != length) {
                b(spannableStringBuilder, i3, length);
            }
            if (i4 != -1 && i4 != length) {
                a(spannableStringBuilder, i4, length);
            }
            if (i8 != length) {
                a(spannableStringBuilder, i8, length, i5);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public a5 a(int i3) {
            float f3;
            int i4 = this.f65138e + this.f65139f;
            int i5 = 32 - i4;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i6 = 0; i6 < this.f65135b.size(); i6++) {
                spannableStringBuilder.append(xp.a((CharSequence) this.f65135b.get(i6), i5));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(xp.a(b(), i5));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i5 - spannableStringBuilder.length();
            int i7 = i4 - length;
            if (i3 == Integer.MIN_VALUE) {
                if (this.f65140g != 2 || (Math.abs(i7) >= 3 && length >= 0)) {
                    i3 = (this.f65140g != 2 || i7 <= 0) ? 0 : 2;
                } else {
                    i3 = 1;
                }
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    i4 = 32 - length;
                }
                f3 = ((i4 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f3 = 0.5f;
            }
            int i8 = this.f65137d;
            if (i8 > 7) {
                i8 -= 17;
            } else if (this.f65140g == 1) {
                i8 -= this.f65141h - 1;
            }
            return new a5.b().a(spannableStringBuilder).b(Layout.Alignment.ALIGN_NORMAL).a(i8, 1).b(f3).b(i3).a();
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i3, int i4, int i5) {
            if (i5 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i3, i4, 33);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i3, int i4) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, 33);
        }

        public void a(int i3, boolean z2) {
            this.f65134a.add(new C0130a(i3, z2, this.f65136c.length()));
        }
    }

    public y2(String str, int i3, long j3) {
        this.f65120k = j3 > 0 ? j3 * 1000 : -9223372036854775807L;
        this.f65117h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i3 == 1) {
            this.f65119j = 0;
            this.f65118i = 0;
        } else if (i3 == 2) {
            this.f65119j = 1;
            this.f65118i = 0;
        } else if (i3 == 3) {
            this.f65119j = 0;
            this.f65118i = 1;
        } else if (i3 != 4) {
            oc.d("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f65119j = 0;
            this.f65118i = 0;
        } else {
            this.f65119j = 1;
            this.f65118i = 1;
        }
        a(0);
        m();
        this.f65132w = true;
        this.f65133x = -9223372036854775807L;
    }

    private static int b(byte b3) {
        return (b3 >> 3) & 1;
    }

    private static boolean c(byte b3, byte b4) {
        return (b3 & 246) == 18 && (b4 & 224) == 32;
    }

    private static boolean d(byte b3, byte b4) {
        return (b3 & 247) == 17 && (b4 & 240) == 32;
    }

    private static boolean e(byte b3, byte b4) {
        return (b3 & 246) == 20 && (b4 & 240) == 32;
    }

    private static boolean f(byte b3, byte b4) {
        return (b3 & 240) == 16 && (b4 & 192) == 64;
    }

    private static boolean g(byte b3, byte b4) {
        return (b3 & 247) == 17 && (b4 & 240) == 48;
    }

    private static boolean h(byte b3) {
        return (b3 & 224) == 0;
    }

    private static boolean i(byte b3) {
        return (b3 & 240) == 16;
    }

    private static boolean j(byte b3) {
        return (b3 & 247) == 20;
    }

    private static boolean k(byte b3) {
        return 1 <= b3 && b3 <= 15;
    }

    private List l() {
        int size = this.f65121l.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i3 = 0; i3 < size; i3++) {
            a5 a5VarA = ((a) this.f65121l.get(i3)).a(Integer.MIN_VALUE);
            arrayList.add(a5VarA);
            if (a5VarA != null) {
                iMin = Math.min(iMin, a5VarA.f58181j);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            a5 a5Var = (a5) arrayList.get(i4);
            if (a5Var != null) {
                if (a5Var.f58181j != iMin) {
                    a5Var = (a5) b1.a(((a) this.f65121l.get(i4)).a(iMin));
                }
                arrayList2.add(a5Var);
            }
        }
        return arrayList2;
    }

    private void m() {
        this.f65122m.b(this.f65125p);
        this.f65121l.clear();
        this.f65121l.add(this.f65122m);
    }

    private boolean n() {
        return (this.f65120k == -9223372036854775807L || this.f65133x == -9223372036854775807L || i() - this.f65133x < this.f65120k) ? false : true;
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.l5
    public void a() {
    }

    private static char d(byte b3) {
        return (char) E[b3 & Ascii.US];
    }

    private static boolean h(byte b3, byte b4) {
        return (b3 & 247) == 23 && b4 >= 33 && b4 <= 35;
    }

    private void i(byte b3, byte b4) {
        if (k(b3)) {
            this.f65132w = false;
            return;
        }
        if (j(b3)) {
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
                                this.f65132w = false;
                                break;
                        }
                        return;
                }
            }
            this.f65132w = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    @Override // com.applovin.impl.a3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(com.applovin.impl.rl r10) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.y2.a(com.applovin.impl.rl):void");
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.l5
    public void b() {
        super.b();
        this.f65123n = null;
        this.f65124o = null;
        a(0);
        b(4);
        m();
        this.f65127r = false;
        this.f65128s = false;
        this.f65129t = (byte) 0;
        this.f65130u = (byte) 0;
        this.f65131v = 0;
        this.f65132w = true;
        this.f65133x = -9223372036854775807L;
    }

    @Override // com.applovin.impl.a3
    protected nl e() {
        List list = this.f65123n;
        this.f65124o = list;
        return new b3((List) b1.a(list));
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ rl d() {
        return super.d();
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.l5
    /* JADX INFO: renamed from: g */
    public sl c() {
        sl slVarH;
        sl slVarC = super.c();
        if (slVarC != null) {
            return slVarC;
        }
        if (!n() || (slVarH = h()) == null) {
            return null;
        }
        this.f65123n = Collections.EMPTY_LIST;
        this.f65133x = -9223372036854775807L;
        slVarH.a(i(), e(), Long.MAX_VALUE);
        return slVarH;
    }

    @Override // com.applovin.impl.a3
    protected boolean j() {
        return this.f65123n != this.f65124o;
    }

    private static char c(byte b3) {
        return (char) D[b3 & Ascii.US];
    }

    private void f(byte b3) {
        this.f65122m.a(' ');
        this.f65122m.a((b3 >> 1) & 7, (b3 & 1) == 1);
    }

    private static char e(byte b3) {
        return (char) C[b3 & Ascii.SI];
    }

    private void g(byte b3) {
        if (b3 == 32) {
            a(2);
            return;
        }
        if (b3 != 41) {
            switch (b3) {
                case 37:
                    a(1);
                    b(2);
                    break;
                case 38:
                    a(1);
                    b(3);
                    break;
                case 39:
                    a(1);
                    b(4);
                    break;
                default:
                    int i3 = this.f65125p;
                    if (i3 != 0) {
                        if (b3 != 33) {
                            switch (b3) {
                                case 44:
                                    this.f65123n = Collections.EMPTY_LIST;
                                    if (i3 == 1 || i3 == 3) {
                                        m();
                                    }
                                    break;
                                case 45:
                                    if (i3 == 1 && !this.f65122m.c()) {
                                        this.f65122m.d();
                                        break;
                                    }
                                    break;
                                case 46:
                                    m();
                                    break;
                                case 47:
                                    this.f65123n = l();
                                    m();
                                    break;
                            }
                        } else {
                            this.f65122m.a();
                            break;
                        }
                    }
                    break;
            }
            return;
        }
        a(3);
    }

    private boolean l(byte b3) {
        if (h(b3)) {
            this.f65131v = b(b3);
        }
        return this.f65131v == this.f65119j;
    }

    private void b(byte b3, byte b4) {
        int i3 = f65114y[b3 & 7];
        if ((b4 & 32) != 0) {
            i3++;
        }
        if (i3 != this.f65122m.f65137d) {
            if (this.f65125p != 1 && !this.f65122m.c()) {
                a aVar = new a(this.f65125p, this.f65126q);
                this.f65122m = aVar;
                this.f65121l.add(aVar);
            }
            this.f65122m.f65137d = i3;
        }
        boolean z2 = (b4 & Ascii.DLE) == 16;
        boolean z3 = (b4 & 1) == 1;
        int i4 = (b4 >> 1) & 7;
        this.f65122m.a(z2 ? 8 : i4, z3);
        if (z2) {
            this.f65122m.f65138e = f65115z[i4];
        }
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void a(rl rlVar) {
        super.a(rlVar);
    }

    private void b(int i3) {
        this.f65126q = i3;
        this.f65122m.d(i3);
    }

    private static char a(byte b3) {
        return (char) B[(b3 & Ascii.DEL) - 32];
    }

    private static char a(byte b3, byte b4) {
        if ((b3 & 1) == 0) {
            return c(b4);
        }
        return d(b4);
    }

    private boolean a(boolean z2, byte b3, byte b4) {
        if (z2 && i(b3)) {
            if (this.f65128s && this.f65129t == b3 && this.f65130u == b4) {
                this.f65128s = false;
                return true;
            }
            this.f65128s = true;
            this.f65129t = b3;
            this.f65130u = b4;
        } else {
            this.f65128s = false;
        }
        return false;
    }

    private void a(int i3) {
        int i4 = this.f65125p;
        if (i4 == i3) {
            return;
        }
        this.f65125p = i3;
        if (i3 == 3) {
            for (int i5 = 0; i5 < this.f65121l.size(); i5++) {
                ((a) this.f65121l.get(i5)).c(i3);
            }
            return;
        }
        m();
        if (i4 == 3 || i3 == 1 || i3 == 0) {
            this.f65123n = Collections.EMPTY_LIST;
        }
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.ol
    public /* bridge */ /* synthetic */ void a(long j3) {
        super.a(j3);
    }
}
