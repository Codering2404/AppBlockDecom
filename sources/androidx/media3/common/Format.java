package androidx.media3.common;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.math.DoubleMath;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Format {
    private static final Format P = new Builder().N();
    private static final String Q = Util.y0(0);
    private static final String R = Util.y0(1);
    private static final String S = Util.y0(2);
    private static final String T = Util.y0(3);
    private static final String U = Util.y0(4);
    private static final String V = Util.y0(5);
    private static final String W = Util.y0(6);
    private static final String X = Util.y0(7);
    private static final String Y = Util.y0(8);
    private static final String Z = Util.y0(9);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final String f40593a0 = Util.y0(10);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final String f40594b0 = Util.y0(11);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final String f40595c0 = Util.y0(12);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final String f40596d0 = Util.y0(13);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final String f40597e0 = Util.y0(14);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final String f40598f0 = Util.y0(15);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final String f40599g0 = Util.y0(16);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final String f40600h0 = Util.y0(17);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final String f40601i0 = Util.y0(18);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final String f40602j0 = Util.y0(19);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final String f40603k0 = Util.y0(20);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final String f40604l0 = Util.y0(21);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final String f40605m0 = Util.y0(22);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final String f40606n0 = Util.y0(23);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static final String f40607o0 = Util.y0(24);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final String f40608p0 = Util.y0(25);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final String f40609q0 = Util.y0(26);

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final String f40610r0 = Util.y0(27);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final String f40611s0 = Util.y0(28);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final String f40612t0 = Util.y0(29);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final String f40613u0 = Util.y0(30);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private static final String f40614v0 = Util.y0(31);

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private static final String f40615w0 = Util.y0(32);

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private static final String f40616x0 = Util.y0(33);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private static final String f40617y0 = Util.y0(34);
    public final byte[] A;
    public final int B;
    public final ColorInfo C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    private int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f40620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f40621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f40622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f40623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f40624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f40625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f40626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f40627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f40628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Metadata f40629l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f40630m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f40631n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f40632o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f40633p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f40634q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f40635r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DrmInitData f40636s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f40637t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f40638u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f40639v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f40640w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f40641x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f40642y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f40643z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
        private int A;
        private ColorInfo B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private int H;
        private int I;
        private int J;
        private int K;
        private int L;
        private int M;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f40644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f40645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List f40646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f40647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f40648e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f40649f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f40650g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f40651h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f40652i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f40653j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Metadata f40654k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Object f40655l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f40656m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f40657n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f40658o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f40659p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private List f40660q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private DrmInitData f40661r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private long f40662s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f40663t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f40664u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f40665v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private float f40666w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f40667x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private float f40668y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private byte[] f40669z;

        public Builder A0(int i3) {
            this.L = i3;
            return this;
        }

        public Builder B0(int i3) {
            this.f40664u = i3;
            return this;
        }

        public Format N() {
            return new Format(this);
        }

        public Builder O(int i3) {
            this.I = i3;
            return this;
        }

        public Builder P(int i3) {
            this.f40650g = i3;
            return this;
        }

        public Builder Q(int i3) {
            this.f40651h = i3;
            return this;
        }

        public Builder R(int i3) {
            this.D = i3;
            return this;
        }

        public Builder S(String str) {
            this.f40653j = str;
            return this;
        }

        public Builder T(ColorInfo colorInfo) {
            this.B = colorInfo;
            return this;
        }

        public Builder U(String str) {
            this.f40656m = MimeTypes.r(str);
            return this;
        }

        public Builder V(int i3) {
            this.M = i3;
            return this;
        }

        public Builder W(int i3) {
            this.J = i3;
            return this;
        }

        public Builder X(Object obj) {
            this.f40655l = obj;
            return this;
        }

        public Builder Y(DrmInitData drmInitData) {
            this.f40661r = drmInitData;
            return this;
        }

        public Builder Z(int i3) {
            this.G = i3;
            return this;
        }

        public Builder a0(int i3) {
            this.H = i3;
            return this;
        }

        public Builder b0(float f3) {
            this.f40666w = f3;
            return this;
        }

        public Builder c0(boolean z2) {
            this.f40663t = z2;
            return this;
        }

        public Builder d0(int i3) {
            this.f40665v = i3;
            return this;
        }

        public Builder e0(int i3) {
            this.f40644a = Integer.toString(i3);
            return this;
        }

        public Builder f0(String str) {
            this.f40644a = str;
            return this;
        }

        public Builder g0(List list) {
            this.f40660q = list;
            return this;
        }

        public Builder h0(String str) {
            this.f40645b = str;
            return this;
        }

        public Builder i0(List list) {
            this.f40646c = ImmutableList.t(list);
            return this;
        }

        public Builder j0(String str) {
            this.f40647d = str;
            return this;
        }

        public Builder k0(int i3) {
            this.f40658o = i3;
            return this;
        }

        public Builder l0(int i3) {
            this.f40659p = i3;
            return this;
        }

        public Builder m0(int i3) {
            this.C = i3;
            return this;
        }

        public Builder n0(Metadata metadata) {
            this.f40654k = metadata;
            return this;
        }

        public Builder o0(int i3) {
            this.F = i3;
            return this;
        }

        public Builder p0(int i3) {
            this.f40652i = i3;
            return this;
        }

        public Builder q0(float f3) {
            this.f40668y = f3;
            return this;
        }

        public Builder r0(byte[] bArr) {
            this.f40669z = bArr;
            return this;
        }

        public Builder s0(int i3) {
            this.f40649f = i3;
            return this;
        }

        public Builder t0(int i3) {
            this.f40667x = i3;
            return this;
        }

        public Builder u0(String str) {
            this.f40657n = MimeTypes.r(str);
            return this;
        }

        public Builder v0(int i3) {
            this.E = i3;
            return this;
        }

        public Builder w0(int i3) {
            this.f40648e = i3;
            return this;
        }

        public Builder x0(int i3) {
            this.A = i3;
            return this;
        }

        public Builder y0(long j3) {
            this.f40662s = j3;
            return this;
        }

        public Builder z0(int i3) {
            this.K = i3;
            return this;
        }

        public Builder() {
            this.f40646c = ImmutableList.y();
            this.f40651h = -1;
            this.f40652i = -1;
            this.f40658o = -1;
            this.f40659p = -1;
            this.f40662s = Long.MAX_VALUE;
            this.f40664u = -1;
            this.f40665v = -1;
            this.f40666w = -1.0f;
            this.f40668y = 1.0f;
            this.A = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.I = -1;
            this.J = 1;
            this.K = -1;
            this.L = -1;
            this.M = 0;
            this.f40650g = 0;
        }

        private Builder(Format format) {
            this.f40644a = format.f40618a;
            this.f40645b = format.f40619b;
            this.f40646c = format.f40620c;
            this.f40647d = format.f40621d;
            this.f40648e = format.f40622e;
            this.f40649f = format.f40623f;
            this.f40651h = format.f40625h;
            this.f40652i = format.f40626i;
            this.f40653j = format.f40628k;
            this.f40654k = format.f40629l;
            this.f40655l = format.f40630m;
            this.f40656m = format.f40631n;
            this.f40657n = format.f40632o;
            this.f40658o = format.f40633p;
            this.f40659p = format.f40634q;
            this.f40660q = format.f40635r;
            this.f40661r = format.f40636s;
            this.f40662s = format.f40637t;
            this.f40663t = format.f40638u;
            this.f40664u = format.f40639v;
            this.f40665v = format.f40640w;
            this.f40666w = format.f40641x;
            this.f40667x = format.f40642y;
            this.f40668y = format.f40643z;
            this.f40669z = format.A;
            this.A = format.B;
            this.B = format.C;
            this.C = format.D;
            this.D = format.E;
            this.E = format.F;
            this.F = format.G;
            this.G = format.H;
            this.H = format.I;
            this.I = format.J;
            this.J = format.K;
            this.K = format.L;
            this.L = format.M;
            this.M = format.N;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CueReplacementBehavior {
    }

    public static /* synthetic */ String a(Label label) {
        return label.f40704a + ": " + label.f40705b;
    }

    private static String d(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Label label = (Label) it.next();
            if (TextUtils.equals(label.f40704a, str)) {
                return label.f40705b;
            }
        }
        return ((Label) list.get(0)).f40705b;
    }

    private static boolean g(Builder builder) {
        if (builder.f40646c.isEmpty() && builder.f40645b == null) {
            return true;
        }
        for (int i3 = 0; i3 < builder.f40646c.size(); i3++) {
            if (((Label) builder.f40646c.get(i3)).f40705b.equals(builder.f40645b)) {
                return true;
            }
        }
        return false;
    }

    public static String h(Format format) {
        if (format == null) {
            return "null";
        }
        Joiner joinerH = Joiner.h(',');
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(format.f40618a);
        sb.append(", mimeType=");
        sb.append(format.f40632o);
        if (format.f40631n != null) {
            sb.append(", container=");
            sb.append(format.f40631n);
        }
        if (format.f40627j != -1) {
            sb.append(", bitrate=");
            sb.append(format.f40627j);
        }
        if (format.f40628k != null) {
            sb.append(", codecs=");
            sb.append(format.f40628k);
        }
        if (format.f40636s != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i3 = 0;
            while (true) {
                DrmInitData drmInitData = format.f40636s;
                if (i3 >= drmInitData.f40584d) {
                    break;
                }
                UUID uuid = drmInitData.f(i3).f40586b;
                if (uuid.equals(C.f40542b)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(C.f40543c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C.f40545e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C.f40544d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C.f40541a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i3++;
            }
            sb.append(", drm=[");
            joinerH.c(sb, linkedHashSet);
            sb.append(']');
        }
        if (format.f40639v != -1 && format.f40640w != -1) {
            sb.append(", res=");
            sb.append(format.f40639v);
            sb.append("x");
            sb.append(format.f40640w);
        }
        if (!DoubleMath.a(format.f40643z, 1.0d, 0.001d)) {
            sb.append(", par=");
            sb.append(Util.J("%.3f", Float.valueOf(format.f40643z)));
        }
        ColorInfo colorInfo = format.C;
        if (colorInfo != null && colorInfo.m()) {
            sb.append(", color=");
            sb.append(format.C.q());
        }
        if (format.f40641x != -1.0f) {
            sb.append(", fps=");
            sb.append(format.f40641x);
        }
        if (format.D != -1) {
            sb.append(", maxSubLayers=");
            sb.append(format.D);
        }
        if (format.E != -1) {
            sb.append(", channels=");
            sb.append(format.E);
        }
        if (format.F != -1) {
            sb.append(", sample_rate=");
            sb.append(format.F);
        }
        if (format.f40621d != null) {
            sb.append(", language=");
            sb.append(format.f40621d);
        }
        if (!format.f40620c.isEmpty()) {
            sb.append(", labels=[");
            joinerH.c(sb, Lists.p(format.f40620c, new Function() { // from class: androidx.media3.common.f
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return Format.a((Label) obj);
                }
            }));
            sb.append("]");
        }
        if (format.f40622e != 0) {
            sb.append(", selectionFlags=[");
            joinerH.c(sb, Util.n0(format.f40622e));
            sb.append("]");
        }
        if (format.f40623f != 0) {
            sb.append(", roleFlags=[");
            joinerH.c(sb, Util.m0(format.f40623f));
            sb.append("]");
        }
        if (format.f40630m != null) {
            sb.append(", customData=");
            sb.append(format.f40630m);
        }
        if ((format.f40623f & 32768) != 0) {
            sb.append(", auxiliaryTrackType=");
            sb.append(Util.Q(format.f40624g));
        }
        return sb.toString();
    }

    public Builder b() {
        return new Builder();
    }

    public Format c(int i3) {
        return b().V(i3).N();
    }

    public int e() {
        int i3;
        int i4 = this.f40639v;
        if (i4 == -1 || (i3 = this.f40640w) == -1) {
            return -1;
        }
        return i4 * i3;
    }

    public boolean equals(Object obj) {
        int i3;
        if (this == obj) {
            return true;
        }
        if (obj != null && Format.class == obj.getClass()) {
            Format format = (Format) obj;
            int i4 = this.O;
            if ((i4 == 0 || (i3 = format.O) == 0 || i4 == i3) && this.f40622e == format.f40622e && this.f40623f == format.f40623f && this.f40624g == format.f40624g && this.f40625h == format.f40625h && this.f40626i == format.f40626i && this.f40633p == format.f40633p && this.f40637t == format.f40637t && this.f40639v == format.f40639v && this.f40640w == format.f40640w && this.f40642y == format.f40642y && this.B == format.B && this.D == format.D && this.E == format.E && this.F == format.F && this.G == format.G && this.H == format.H && this.I == format.I && this.J == format.J && this.L == format.L && this.M == format.M && this.N == format.N && Float.compare(this.f40641x, format.f40641x) == 0 && Float.compare(this.f40643z, format.f40643z) == 0 && Objects.equals(this.f40618a, format.f40618a) && Objects.equals(this.f40619b, format.f40619b) && this.f40620c.equals(format.f40620c) && Objects.equals(this.f40628k, format.f40628k) && Objects.equals(this.f40631n, format.f40631n) && Objects.equals(this.f40632o, format.f40632o) && Objects.equals(this.f40621d, format.f40621d) && Arrays.equals(this.A, format.A) && Objects.equals(this.f40629l, format.f40629l) && Objects.equals(this.C, format.C) && Objects.equals(this.f40636s, format.f40636s) && f(format) && Objects.equals(this.f40630m, format.f40630m)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(Format format) {
        if (this.f40635r.size() != format.f40635r.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f40635r.size(); i3++) {
            if (!Arrays.equals((byte[]) this.f40635r.get(i3), (byte[]) format.f40635r.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.O == 0) {
            String str = this.f40618a;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f40619b;
            int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f40620c.hashCode()) * 31;
            String str3 = this.f40621d;
            int iHashCode3 = (((((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f40622e) * 31) + this.f40623f) * 31) + this.f40624g) * 31) + this.f40625h) * 31) + this.f40626i) * 31;
            String str4 = this.f40628k;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f40629l;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            Object obj = this.f40630m;
            int iHashCode6 = (iHashCode5 + (obj == null ? 0 : obj.hashCode())) * 31;
            String str5 = this.f40631n;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f40632o;
            this.O = ((((((((((((((((((((((((((((((((((((iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f40633p) * 31) + ((int) this.f40637t)) * 31) + this.f40639v) * 31) + this.f40640w) * 31) + Float.floatToIntBits(this.f40641x)) * 31) + this.f40642y) * 31) + Float.floatToIntBits(this.f40643z)) * 31) + this.B) * 31) + this.D) * 31) + this.E) * 31) + this.F) * 31) + this.G) * 31) + this.H) * 31) + this.I) * 31) + this.J) * 31) + this.L) * 31) + this.M) * 31) + this.N;
        }
        return this.O;
    }

    public Format i(Format format) {
        String str;
        if (this == format) {
            return this;
        }
        int iK = MimeTypes.k(this.f40632o);
        String str2 = format.f40618a;
        int i3 = format.L;
        int i4 = format.M;
        String str3 = format.f40619b;
        if (str3 == null) {
            str3 = this.f40619b;
        }
        List list = !format.f40620c.isEmpty() ? format.f40620c : this.f40620c;
        String str4 = this.f40621d;
        if ((iK == 3 || iK == 1) && (str = format.f40621d) != null) {
            str4 = str;
        }
        int i5 = this.f40625h;
        if (i5 == -1) {
            i5 = format.f40625h;
        }
        int i6 = this.f40626i;
        if (i6 == -1) {
            i6 = format.f40626i;
        }
        String str5 = this.f40628k;
        if (str5 == null) {
            String strU = Util.U(format.f40628k, iK);
            if (Util.j1(strU).length == 1) {
                str5 = strU;
            }
        }
        Metadata metadata = this.f40629l;
        Metadata metadataB = metadata == null ? format.f40629l : metadata.b(format.f40629l);
        float f3 = this.f40641x;
        if (f3 == -1.0f && iK == 2) {
            f3 = format.f40641x;
        }
        return b().f0(str2).h0(str3).i0(list).j0(str4).w0(this.f40622e | format.f40622e).s0(this.f40623f | format.f40623f).Q(i5).p0(i6).S(str5).n0(metadataB).Y(DrmInitData.e(format.f40636s, this.f40636s)).b0(f3).z0(i3).A0(i4).N();
    }

    public String toString() {
        return "Format(" + this.f40618a + ", " + this.f40619b + ", " + this.f40631n + ", " + this.f40632o + ", " + this.f40628k + ", " + this.f40627j + ", " + this.f40621d + ", [" + this.f40639v + ", " + this.f40640w + ", " + this.f40641x + ", " + this.C + "], [" + this.E + ", " + this.F + "])";
    }

    private Format(Builder builder) {
        this.f40618a = builder.f40644a;
        String strS0 = Util.S0(builder.f40647d);
        this.f40621d = strS0;
        if (builder.f40646c.isEmpty() && builder.f40645b != null) {
            this.f40620c = ImmutableList.z(new Label(strS0, builder.f40645b));
            this.f40619b = builder.f40645b;
        } else if (builder.f40646c.isEmpty() || builder.f40645b != null) {
            Assertions.g(g(builder));
            this.f40620c = builder.f40646c;
            this.f40619b = builder.f40645b;
        } else {
            this.f40620c = builder.f40646c;
            this.f40619b = d(builder.f40646c, strS0);
        }
        this.f40622e = builder.f40648e;
        Assertions.h(builder.f40650g == 0 || (builder.f40649f & 32768) != 0, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.f40623f = builder.f40649f;
        this.f40624g = builder.f40650g;
        int i3 = builder.f40651h;
        this.f40625h = i3;
        int i4 = builder.f40652i;
        this.f40626i = i4;
        this.f40627j = i4 != -1 ? i4 : i3;
        this.f40628k = builder.f40653j;
        this.f40629l = builder.f40654k;
        this.f40630m = builder.f40655l;
        this.f40631n = builder.f40656m;
        this.f40632o = builder.f40657n;
        this.f40633p = builder.f40658o;
        this.f40634q = builder.f40659p;
        this.f40635r = builder.f40660q == null ? Collections.EMPTY_LIST : builder.f40660q;
        DrmInitData drmInitData = builder.f40661r;
        this.f40636s = drmInitData;
        this.f40637t = builder.f40662s;
        this.f40638u = builder.f40663t;
        this.f40639v = builder.f40664u;
        this.f40640w = builder.f40665v;
        this.f40641x = builder.f40666w;
        this.f40642y = builder.f40667x == -1 ? 0 : builder.f40667x;
        this.f40643z = builder.f40668y == -1.0f ? 1.0f : builder.f40668y;
        this.A = builder.f40669z;
        this.B = builder.A;
        this.C = builder.B;
        this.D = builder.C;
        this.E = builder.D;
        this.F = builder.E;
        this.G = builder.F;
        this.H = builder.G == -1 ? 0 : builder.G;
        this.I = builder.H != -1 ? builder.H : 0;
        this.J = builder.I;
        this.K = builder.J;
        this.L = builder.K;
        this.M = builder.L;
        if (builder.M != 0 || drmInitData == null) {
            this.N = builder.M;
        } else {
            this.N = 1;
        }
    }
}
