package com.applovin.impl;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.applovin.impl.a5;
import com.applovin.impl.z2;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class z2 extends a3 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ah f65294g = new ah();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zg f65295h = new zg();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f65296i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f65297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f65298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final b[] f65299l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b f65300m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List f65301n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f65302o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private c f65303p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f65304q;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Comparator f65305c = new Comparator() { // from class: com.applovin.impl.a90
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return z2.a.a((z2.a) obj, (z2.a) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a5 f65306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f65307b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f3, int i3, int i4, float f4, int i5, float f5, boolean z2, int i6, int i7) {
            a5.b bVarD = new a5.b().a(charSequence).b(alignment).a(f3, i3).a(i4).b(f4).b(i5).d(f5);
            if (z2) {
                bVarD.d(i6);
            }
            this.f65306a = bVarD.a();
            this.f65307b = i7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(a aVar, a aVar2) {
            return Integer.compare(aVar2.f65307b, aVar.f65307b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f65335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f65336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f65337d = 0;

        public c(int i3, int i4) {
            this.f65334a = i3;
            this.f65335b = i4;
            this.f65336c = new byte[(i4 * 2) - 1];
        }
    }

    public z2(int i3, List list) {
        this.f65298k = i3 == -1 ? 1 : i3;
        this.f65297j = list != null && o3.a(list);
        this.f65299l = new b[8];
        for (int i4 = 0; i4 < 8; i4++) {
            this.f65299l[i4] = new b();
        }
        this.f65300m = this.f65299l[0];
    }

    private void c(int i3) {
        if (i3 <= 7) {
            return;
        }
        if (i3 <= 15) {
            this.f65295h.d(8);
        } else if (i3 <= 23) {
            this.f65295h.d(16);
        } else if (i3 <= 31) {
            this.f65295h.d(24);
        }
    }

    private void d(int i3) {
        if (i3 <= 135) {
            this.f65295h.d(32);
            return;
        }
        if (i3 <= 143) {
            this.f65295h.d(40);
        } else if (i3 <= 159) {
            this.f65295h.d(2);
            this.f65295h.d(this.f65295h.a(6) * 8);
        }
    }

    private void h(int i3) {
        if (i3 == 32) {
            this.f65300m.a(' ');
            return;
        }
        if (i3 == 33) {
            this.f65300m.a((char) 160);
            return;
        }
        if (i3 == 37) {
            this.f65300m.a((char) 8230);
            return;
        }
        if (i3 == 42) {
            this.f65300m.a((char) 352);
            return;
        }
        if (i3 == 44) {
            this.f65300m.a((char) 338);
            return;
        }
        if (i3 == 63) {
            this.f65300m.a((char) 376);
            return;
        }
        if (i3 == 57) {
            this.f65300m.a((char) 8482);
            return;
        }
        if (i3 == 58) {
            this.f65300m.a((char) 353);
            return;
        }
        if (i3 == 60) {
            this.f65300m.a((char) 339);
            return;
        }
        if (i3 == 61) {
            this.f65300m.a((char) 8480);
            return;
        }
        switch (i3) {
            case 48:
                this.f65300m.a((char) 9608);
                break;
            case 49:
                this.f65300m.a((char) 8216);
                break;
            case 50:
                this.f65300m.a((char) 8217);
                break;
            case 51:
                this.f65300m.a((char) 8220);
                break;
            case 52:
                this.f65300m.a((char) 8221);
                break;
            case 53:
                this.f65300m.a((char) 8226);
                break;
            default:
                switch (i3) {
                    case 118:
                        this.f65300m.a((char) 8539);
                        break;
                    case 119:
                        this.f65300m.a((char) 8540);
                        break;
                    case 120:
                        this.f65300m.a((char) 8541);
                        break;
                    case 121:
                        this.f65300m.a((char) 8542);
                        break;
                    case 122:
                        this.f65300m.a((char) 9474);
                        break;
                    case 123:
                        this.f65300m.a((char) 9488);
                        break;
                    case 124:
                        this.f65300m.a((char) 9492);
                        break;
                    case 125:
                        this.f65300m.a((char) 9472);
                        break;
                    case 126:
                        this.f65300m.a((char) 9496);
                        break;
                    case 127:
                        this.f65300m.a((char) 9484);
                        break;
                    default:
                        oc.d("Cea708Decoder", "Invalid G2 character: " + i3);
                        break;
                }
                break;
        }
    }

    private void i(int i3) {
        if (i3 == 160) {
            this.f65300m.a((char) 13252);
            return;
        }
        oc.d("Cea708Decoder", "Invalid G3 character: " + i3);
        this.f65300m.a('_');
    }

    private void k() {
        if (this.f65303p == null) {
            return;
        }
        q();
        this.f65303p = null;
    }

    private List l() {
        a aVarB;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 8; i3++) {
            if (!this.f65299l[i3].f() && this.f65299l[i3].g() && (aVarB = this.f65299l[i3].b()) != null) {
                arrayList.add(aVarB);
            }
        }
        Collections.sort(arrayList, a.f65305c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList2.add(((a) arrayList.get(i4)).f65306a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void m() {
        this.f65300m.a(this.f65295h.a(4), this.f65295h.a(2), this.f65295h.a(2), this.f65295h.f(), this.f65295h.f(), this.f65295h.a(3), this.f65295h.a(3));
    }

    private void n() {
        int iA = b.a(this.f65295h.a(2), this.f65295h.a(2), this.f65295h.a(2), this.f65295h.a(2));
        int iA2 = b.a(this.f65295h.a(2), this.f65295h.a(2), this.f65295h.a(2), this.f65295h.a(2));
        this.f65295h.d(2);
        this.f65300m.b(iA, iA2, b.a(this.f65295h.a(2), this.f65295h.a(2), this.f65295h.a(2)));
    }

    private void o() {
        this.f65295h.d(4);
        int iA = this.f65295h.a(4);
        this.f65295h.d(2);
        this.f65300m.a(iA, this.f65295h.a(6));
    }

    private void p() {
        int iA = b.a(this.f65295h.a(2), this.f65295h.a(2), this.f65295h.a(2), this.f65295h.a(2));
        int iA2 = this.f65295h.a(2);
        int iA3 = b.a(this.f65295h.a(2), this.f65295h.a(2), this.f65295h.a(2));
        if (this.f65295h.f()) {
            iA2 |= 4;
        }
        boolean zF = this.f65295h.f();
        int iA4 = this.f65295h.a(2);
        int iA5 = this.f65295h.a(2);
        int iA6 = this.f65295h.a(2);
        this.f65295h.d(8);
        this.f65300m.a(iA, iA3, zF, iA2, iA4, iA5, iA6);
    }

    private void q() {
        c cVar = this.f65303p;
        if (cVar.f65337d != (cVar.f65335b * 2) - 1) {
            oc.a("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f65303p.f65335b * 2) - 1) + ", but current index is " + this.f65303p.f65337d + " (sequence number " + this.f65303p.f65334a + ");");
        }
        zg zgVar = this.f65295h;
        c cVar2 = this.f65303p;
        zgVar.a(cVar2.f65336c, cVar2.f65337d);
        int iA = this.f65295h.a(3);
        int iA2 = this.f65295h.a(5);
        if (iA == 7) {
            this.f65295h.d(2);
            iA = this.f65295h.a(6);
            if (iA < 7) {
                oc.d("Cea708Decoder", "Invalid extended service number: " + iA);
            }
        }
        if (iA2 == 0) {
            if (iA != 0) {
                oc.d("Cea708Decoder", "serviceNumber is non-zero (" + iA + ") when blockSize is 0");
                return;
            }
            return;
        }
        if (iA != this.f65298k) {
            return;
        }
        boolean z2 = false;
        while (this.f65295h.b() > 0) {
            int iA3 = this.f65295h.a(8);
            if (iA3 == 16) {
                int iA4 = this.f65295h.a(8);
                if (iA4 <= 31) {
                    c(iA4);
                } else {
                    if (iA4 <= 127) {
                        h(iA4);
                    } else if (iA4 <= 159) {
                        d(iA4);
                    } else if (iA4 <= 255) {
                        i(iA4);
                    } else {
                        oc.d("Cea708Decoder", "Invalid extended command: " + iA4);
                    }
                    z2 = true;
                }
            } else if (iA3 <= 31) {
                a(iA3);
            } else {
                if (iA3 <= 127) {
                    f(iA3);
                } else if (iA3 <= 159) {
                    b(iA3);
                } else if (iA3 <= 255) {
                    g(iA3);
                } else {
                    oc.d("Cea708Decoder", "Invalid base command: " + iA3);
                }
                z2 = true;
            }
        }
        if (z2) {
            this.f65301n = l();
        }
    }

    private void r() {
        for (int i3 = 0; i3 < 8; i3++) {
            this.f65299l[i3].h();
        }
    }

    @Override // com.applovin.impl.a3
    protected void a(rl rlVar) {
        ByteBuffer byteBuffer = (ByteBuffer) b1.a(rlVar.f62183c);
        this.f65294g.a(byteBuffer.array(), byteBuffer.limit());
        while (this.f65294g.a() >= 3) {
            int iW = this.f65294g.w();
            int i3 = iW & 3;
            boolean z2 = (iW & 4) == 4;
            byte bW = (byte) this.f65294g.w();
            byte bW2 = (byte) this.f65294g.w();
            if (i3 == 2 || i3 == 3) {
                if (z2) {
                    if (i3 == 3) {
                        k();
                        int i4 = (bW & 192) >> 6;
                        int i5 = this.f65296i;
                        if (i5 != -1 && i4 != (i5 + 1) % 4) {
                            r();
                            oc.d("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f65296i + " current=" + i4);
                        }
                        this.f65296i = i4;
                        int i6 = bW & 63;
                        if (i6 == 0) {
                            i6 = 64;
                        }
                        c cVar = new c(i4, i6);
                        this.f65303p = cVar;
                        byte[] bArr = cVar.f65336c;
                        int i7 = cVar.f65337d;
                        cVar.f65337d = i7 + 1;
                        bArr[i7] = bW2;
                    } else {
                        b1.a(i3 == 2);
                        c cVar2 = this.f65303p;
                        if (cVar2 == null) {
                            oc.b("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = cVar2.f65336c;
                            int i8 = cVar2.f65337d;
                            bArr2[i8] = bW;
                            cVar2.f65337d = i8 + 2;
                            bArr2[i8 + 1] = bW2;
                        }
                    }
                    c cVar3 = this.f65303p;
                    if (cVar3.f65337d == (cVar3.f65335b * 2) - 1) {
                        k();
                    }
                }
            }
        }
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.l5
    public void b() {
        super.b();
        this.f65301n = null;
        this.f65302o = null;
        this.f65304q = 0;
        this.f65300m = this.f65299l[0];
        r();
        this.f65303p = null;
    }

    @Override // com.applovin.impl.a3
    protected nl e() {
        List list = this.f65301n;
        this.f65302o = list;
        return new b3((List) b1.a(list));
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ rl d() {
        return super.d();
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: g */
    public /* bridge */ /* synthetic */ sl c() {
        return super.c();
    }

    @Override // com.applovin.impl.a3
    protected boolean j() {
        return this.f65301n != this.f65302o;
    }

    private void f(int i3) {
        if (i3 == 127) {
            this.f65300m.a((char) 9835);
        } else {
            this.f65300m.a((char) (i3 & 255));
        }
    }

    private void g(int i3) {
        this.f65300m.a((char) (i3 & 255));
    }

    private void e(int i3) {
        b bVar = this.f65299l[i3];
        this.f65295h.d(2);
        boolean zF = this.f65295h.f();
        boolean zF2 = this.f65295h.f();
        boolean zF3 = this.f65295h.f();
        int iA = this.f65295h.a(3);
        boolean zF4 = this.f65295h.f();
        int iA2 = this.f65295h.a(7);
        int iA3 = this.f65295h.a(8);
        int iA4 = this.f65295h.a(4);
        int iA5 = this.f65295h.a(4);
        this.f65295h.d(2);
        int iA6 = this.f65295h.a(6);
        this.f65295h.d(2);
        bVar.a(zF, zF2, zF3, iA, zF4, iA2, iA3, iA5, iA6, iA4, this.f65295h.a(3), this.f65295h.a(3));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(int i3) {
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
                if (this.f65304q != i5) {
                    this.f65304q = i5;
                    this.f65300m = this.f65299l[i5];
                }
                break;
            case 136:
                while (i4 <= 8) {
                    if (this.f65295h.f()) {
                        this.f65299l[8 - i4].d();
                    }
                    i4++;
                }
                break;
            case 137:
                for (int i6 = 1; i6 <= 8; i6++) {
                    if (this.f65295h.f()) {
                        this.f65299l[8 - i6].a(true);
                    }
                }
                break;
            case 138:
                while (i4 <= 8) {
                    if (this.f65295h.f()) {
                        this.f65299l[8 - i4].a(false);
                    }
                    i4++;
                }
                break;
            case 139:
                for (int i7 = 1; i7 <= 8; i7++) {
                    if (this.f65295h.f()) {
                        this.f65299l[8 - i7].a(!r0.g());
                    }
                }
                break;
            case 140:
                while (i4 <= 8) {
                    if (this.f65295h.f()) {
                        this.f65299l[8 - i4].h();
                    }
                    i4++;
                }
                break;
            case 141:
                this.f65295h.d(8);
                break;
            case 142:
                break;
            case 143:
                r();
                break;
            case 144:
                if (!this.f65300m.e()) {
                    this.f65295h.d(16);
                } else {
                    m();
                }
                break;
            case 145:
                if (!this.f65300m.e()) {
                    this.f65295h.d(24);
                } else {
                    n();
                }
                break;
            case 146:
                if (!this.f65300m.e()) {
                    this.f65295h.d(16);
                } else {
                    o();
                }
                break;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                oc.d("Cea708Decoder", "Invalid C1 command: " + i3);
                break;
            case 151:
                if (!this.f65300m.e()) {
                    this.f65295h.d(32);
                } else {
                    p();
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
                e(i8);
                if (this.f65304q != i8) {
                    this.f65304q = i8;
                    this.f65300m = this.f65299l[i8];
                }
                break;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {
        private static final int[] A;
        private static final int[] B;
        private static final boolean[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        private static final int[] G;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f65308w = a(2, 2, 2, 0);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f65309x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f65310y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final int[] f65311z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f65312a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SpannableStringBuilder f65313b = new SpannableStringBuilder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f65314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f65315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f65316e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f65317f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f65318g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f65319h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f65320i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f65321j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f65322k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f65323l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f65324m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f65325n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f65326o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f65327p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f65328q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f65329r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f65330s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f65331t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f65332u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f65333v;

        static {
            int iA = a(0, 0, 0, 0);
            f65309x = iA;
            int iA2 = a(0, 0, 0, 3);
            f65310y = iA2;
            f65311z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{iA, iA2, iA, iA, iA2, iA, iA};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{iA, iA, iA, iA, iA, iA2, iA2};
        }

        public b() {
            h();
        }

        public void a(char c3) {
            if (c3 != '\n') {
                this.f65313b.append(c3);
                return;
            }
            this.f65312a.add(c());
            this.f65313b.clear();
            if (this.f65327p != -1) {
                this.f65327p = 0;
            }
            if (this.f65328q != -1) {
                this.f65328q = 0;
            }
            if (this.f65329r != -1) {
                this.f65329r = 0;
            }
            if (this.f65331t != -1) {
                this.f65331t = 0;
            }
            while (true) {
                if ((!this.f65322k || this.f65312a.size() < this.f65321j) && this.f65312a.size() < 15) {
                    return;
                } else {
                    this.f65312a.remove(0);
                }
            }
        }

        public a b() {
            Layout.Alignment alignment;
            float f3;
            float f4;
            int i3;
            float f5;
            int i4;
            if (f()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.f65312a.size(); i5++) {
                spannableStringBuilder.append((CharSequence) this.f65312a.get(i5));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) c());
            int i6 = this.f65323l;
            int i7 = 2;
            if (i6 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i6 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i6 != 2) {
                if (i6 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.f65323l);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            if (this.f65317f) {
                f3 = this.f65319h / 99.0f;
                f4 = this.f65318g / 99.0f;
            } else {
                f3 = this.f65319h / 209.0f;
                f4 = this.f65318g / 74.0f;
            }
            float f6 = (f3 * 0.9f) + 0.05f;
            float f7 = (f4 * 0.9f) + 0.05f;
            int i8 = this.f65320i;
            int i9 = i8 / 3;
            if (i9 == 0) {
                i3 = i8;
                f5 = f6;
                i4 = 0;
            } else if (i9 == 1) {
                i3 = i8;
                f5 = f6;
                i4 = 1;
            } else {
                i3 = i8;
                f5 = f6;
                i4 = 2;
            }
            int i10 = i3 % 3;
            if (i10 == 0) {
                i7 = 0;
            } else if (i10 == 1) {
                i7 = 1;
            }
            return new a(spannableStringBuilder, alignment, f7, 0, i4, f5, i7, -3.4028235E38f, this.f65326o != f65309x, this.f65326o, this.f65316e);
        }

        public SpannableString c() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f65313b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f65327p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f65327p, length, 33);
                }
                if (this.f65328q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f65328q, length, 33);
                }
                if (this.f65329r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f65330s), this.f65329r, length, 33);
                }
                if (this.f65331t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f65332u), this.f65331t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void d() {
            this.f65312a.clear();
            this.f65313b.clear();
            this.f65327p = -1;
            this.f65328q = -1;
            this.f65329r = -1;
            this.f65331t = -1;
            this.f65333v = 0;
        }

        public boolean e() {
            return this.f65314c;
        }

        public boolean f() {
            if (e()) {
                return this.f65312a.isEmpty() && this.f65313b.length() == 0;
            }
            return true;
        }

        public boolean g() {
            return this.f65315d;
        }

        public void h() {
            d();
            this.f65314c = false;
            this.f65315d = false;
            this.f65316e = 4;
            this.f65317f = false;
            this.f65318g = 0;
            this.f65319h = 0;
            this.f65320i = 0;
            this.f65321j = 15;
            this.f65322k = true;
            this.f65323l = 0;
            this.f65324m = 0;
            this.f65325n = 0;
            int i3 = f65309x;
            this.f65326o = i3;
            this.f65330s = f65308w;
            this.f65332u = i3;
        }

        public void a() {
            int length = this.f65313b.length();
            if (length > 0) {
                this.f65313b.delete(length - 1, length);
            }
        }

        public void a(boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.f65314c = true;
            this.f65315d = z2;
            this.f65322k = z3;
            this.f65316e = i3;
            this.f65317f = z5;
            this.f65318g = i4;
            this.f65319h = i5;
            this.f65320i = i8;
            int i11 = i6 + 1;
            if (this.f65321j != i11) {
                this.f65321j = i11;
                while (true) {
                    if ((!z3 || this.f65312a.size() < this.f65321j) && this.f65312a.size() < 15) {
                        break;
                    } else {
                        this.f65312a.remove(0);
                    }
                }
            }
            if (i9 != 0 && this.f65324m != i9) {
                this.f65324m = i9;
                int i12 = i9 - 1;
                a(D[i12], f65310y, C[i12], 0, A[i12], B[i12], f65311z[i12]);
            }
            if (i10 == 0 || this.f65325n == i10) {
                return;
            }
            this.f65325n = i10;
            int i13 = i10 - 1;
            a(0, 1, 1, false, false, F[i13], E[i13]);
            b(f65308w, G[i13], f65309x);
        }

        public void b(int i3, int i4, int i5) {
            if (this.f65329r != -1 && this.f65330s != i3) {
                this.f65313b.setSpan(new ForegroundColorSpan(this.f65330s), this.f65329r, this.f65313b.length(), 33);
            }
            if (i3 != f65308w) {
                this.f65329r = this.f65313b.length();
                this.f65330s = i3;
            }
            if (this.f65331t != -1 && this.f65332u != i4) {
                this.f65313b.setSpan(new BackgroundColorSpan(this.f65332u), this.f65331t, this.f65313b.length(), 33);
            }
            if (i4 != f65309x) {
                this.f65331t = this.f65313b.length();
                this.f65332u = i4;
            }
        }

        public static int a(int i3, int i4, int i5) {
            return a(i3, i4, i5, 0);
        }

        public static int a(int i3, int i4, int i5, int i6) {
            b1.a(i3, 0, 4);
            b1.a(i4, 0, 4);
            b1.a(i5, 0, 4);
            b1.a(i6, 0, 4);
            return Color.argb(i6 != 2 ? i6 != 3 ? 255 : 0 : 127, i3 > 1 ? 255 : 0, i4 > 1 ? 255 : 0, i5 > 1 ? 255 : 0);
        }

        public void a(int i3, int i4, int i5, boolean z2, boolean z3, int i6, int i7) {
            if (this.f65327p != -1) {
                if (!z2) {
                    this.f65313b.setSpan(new StyleSpan(2), this.f65327p, this.f65313b.length(), 33);
                    this.f65327p = -1;
                }
            } else if (z2) {
                this.f65327p = this.f65313b.length();
            }
            if (this.f65328q == -1) {
                if (z3) {
                    this.f65328q = this.f65313b.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.f65313b.setSpan(new UnderlineSpan(), this.f65328q, this.f65313b.length(), 33);
                this.f65328q = -1;
            }
        }

        public void a(int i3, int i4) {
            if (this.f65333v != i3) {
                a('\n');
            }
            this.f65333v = i3;
        }

        public void a(boolean z2) {
            this.f65315d = z2;
        }

        public void a(int i3, int i4, boolean z2, int i5, int i6, int i7, int i8) {
            this.f65326o = i3;
            this.f65323l = i8;
        }
    }

    private void a(int i3) {
        if (i3 != 0) {
            if (i3 == 3) {
                this.f65301n = l();
                return;
            }
            if (i3 != 8) {
                switch (i3) {
                    case 12:
                        r();
                        break;
                    case 13:
                        this.f65300m.a('\n');
                        break;
                    case 14:
                        break;
                    default:
                        if (i3 >= 17 && i3 <= 23) {
                            oc.d("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i3);
                            this.f65295h.d(8);
                        } else if (i3 >= 24 && i3 <= 31) {
                            oc.d("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i3);
                            this.f65295h.d(16);
                        } else {
                            oc.d("Cea708Decoder", "Invalid C0 command: " + i3);
                        }
                        break;
                }
                return;
            }
            this.f65300m.a();
        }
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.l5
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.ol
    public /* bridge */ /* synthetic */ void a(long j3) {
        super.a(j3);
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void a(rl rlVar) {
        super.a(rlVar);
    }
}
