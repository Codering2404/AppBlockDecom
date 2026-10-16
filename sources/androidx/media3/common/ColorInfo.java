package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ColorInfo {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ColorInfo f40546h = new Builder().d(1).c(2).e(3).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ColorInfo f40547i = new Builder().d(1).c(1).e(2).a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f40548j = Util.y0(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f40549k = Util.y0(1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f40550l = Util.y0(2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f40551m = Util.y0(3);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f40552n = Util.y0(4);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f40553o = Util.y0(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f40556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f40557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f40558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f40559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f40560g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f40561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f40562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f40563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f40564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f40565e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f40566f;

        public ColorInfo a() {
            return new ColorInfo(this.f40561a, this.f40562b, this.f40563c, this.f40564d, this.f40565e, this.f40566f);
        }

        public Builder b(int i3) {
            this.f40566f = i3;
            return this;
        }

        public Builder c(int i3) {
            this.f40562b = i3;
            return this;
        }

        public Builder d(int i3) {
            this.f40561a = i3;
            return this;
        }

        public Builder e(int i3) {
            this.f40563c = i3;
            return this;
        }

        public Builder f(byte[] bArr) {
            this.f40564d = bArr;
            return this;
        }

        public Builder g(int i3) {
            this.f40565e = i3;
            return this;
        }

        public Builder() {
            this.f40561a = -1;
            this.f40562b = -1;
            this.f40563c = -1;
            this.f40565e = -1;
            this.f40566f = -1;
        }

        private Builder(ColorInfo colorInfo) {
            this.f40561a = colorInfo.f40554a;
            this.f40562b = colorInfo.f40555b;
            this.f40563c = colorInfo.f40556c;
            this.f40564d = colorInfo.f40557d;
            this.f40565e = colorInfo.f40558e;
            this.f40566f = colorInfo.f40559f;
        }
    }

    private static String b(int i3) {
        if (i3 == -1) {
            return "NA";
        }
        return i3 + "bit Chroma";
    }

    private static String c(int i3) {
        if (i3 == -1) {
            return "Unset color range";
        }
        if (i3 == 1) {
            return "Full range";
        }
        if (i3 == 2) {
            return "Limited range";
        }
        return "Undefined color range " + i3;
    }

    public static int d(int i3) {
        if (i3 != 2) {
            return i3 != 6 ? 1 : 9;
        }
        return 5;
    }

    public static int e(int i3) {
        if (i3 != 2) {
            return i3 != 6 ? 1 : 9;
        }
        return 6;
    }

    private static String f(int i3) {
        if (i3 == -1) {
            return "Unset color space";
        }
        if (i3 == 6) {
            return "BT2020";
        }
        if (i3 == 1) {
            return "BT709";
        }
        if (i3 == 2) {
            return "BT601";
        }
        return "Undefined color space " + i3;
    }

    public static int g(int i3) {
        if (i3 == 1) {
            return 8;
        }
        if (i3 == 2) {
            return 13;
        }
        if (i3 == 6) {
            return 16;
        }
        if (i3 != 7) {
            return i3 != 10 ? 1 : 4;
        }
        return 18;
    }

    private static String h(int i3) {
        if (i3 == -1) {
            return "Unset color transfer";
        }
        if (i3 == 10) {
            return "Gamma 2.2";
        }
        if (i3 == 1) {
            return "Linear";
        }
        if (i3 == 2) {
            return "sRGB";
        }
        if (i3 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i3 == 6) {
            return "ST2084 PQ";
        }
        if (i3 == 7) {
            return "HLG";
        }
        return "Undefined color transfer " + i3;
    }

    public static boolean k(ColorInfo colorInfo) {
        if (colorInfo == null) {
            return true;
        }
        int i3 = colorInfo.f40554a;
        if (i3 != -1 && i3 != 1 && i3 != 2) {
            return false;
        }
        int i4 = colorInfo.f40555b;
        if (i4 != -1 && i4 != 2) {
            return false;
        }
        int i5 = colorInfo.f40556c;
        if ((i5 != -1 && i5 != 3) || colorInfo.f40557d != null) {
            return false;
        }
        int i6 = colorInfo.f40559f;
        if (i6 != -1 && i6 != 8) {
            return false;
        }
        int i7 = colorInfo.f40558e;
        return i7 == -1 || i7 == 8;
    }

    public static boolean l(ColorInfo colorInfo) {
        if (colorInfo == null) {
            return false;
        }
        int i3 = colorInfo.f40556c;
        return i3 == 7 || i3 == 6;
    }

    public static int n(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 9) {
            return (i3 == 4 || i3 == 5 || i3 == 6 || i3 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int o(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 4) {
            return 10;
        }
        if (i3 == 13) {
            return 2;
        }
        if (i3 == 16) {
            return 6;
        }
        if (i3 != 18) {
            return (i3 == 6 || i3 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String p(int i3) {
        if (i3 == -1) {
            return "NA";
        }
        return i3 + "bit Luma";
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ColorInfo.class == obj.getClass()) {
            ColorInfo colorInfo = (ColorInfo) obj;
            if (this.f40554a == colorInfo.f40554a && this.f40555b == colorInfo.f40555b && this.f40556c == colorInfo.f40556c && Arrays.equals(this.f40557d, colorInfo.f40557d) && this.f40558e == colorInfo.f40558e && this.f40559f == colorInfo.f40559f) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f40560g == 0) {
            this.f40560g = ((((((((((527 + this.f40554a) * 31) + this.f40555b) * 31) + this.f40556c) * 31) + Arrays.hashCode(this.f40557d)) * 31) + this.f40558e) * 31) + this.f40559f;
        }
        return this.f40560g;
    }

    public boolean i() {
        return (this.f40558e == -1 || this.f40559f == -1) ? false : true;
    }

    public boolean j() {
        return (this.f40554a == -1 || this.f40555b == -1 || this.f40556c == -1) ? false : true;
    }

    public boolean m() {
        return i() || j();
    }

    public String q() {
        String str;
        String strJ = j() ? Util.J("%s/%s/%s", f(this.f40554a), c(this.f40555b), h(this.f40556c)) : "NA/NA/NA";
        if (i()) {
            str = this.f40558e + "/" + this.f40559f;
        } else {
            str = "NA/NA";
        }
        return strJ + "/" + str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(f(this.f40554a));
        sb.append(", ");
        sb.append(c(this.f40555b));
        sb.append(", ");
        sb.append(h(this.f40556c));
        sb.append(", ");
        sb.append(this.f40557d != null);
        sb.append(", ");
        sb.append(p(this.f40558e));
        sb.append(", ");
        sb.append(b(this.f40559f));
        sb.append(")");
        return sb.toString();
    }

    private ColorInfo(int i3, int i4, int i5, byte[] bArr, int i6, int i7) {
        this.f40554a = i3;
        this.f40555b = i4;
        this.f40556c = i5;
        this.f40557d = bArr;
        this.f40558e = i6;
        this.f40559f = i7;
    }
}
