package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaMetadata {
    public static final MediaMetadata K = new Builder().J();
    private static final String L = Util.y0(0);
    private static final String M = Util.y0(1);
    private static final String N = Util.y0(2);
    private static final String O = Util.y0(3);
    private static final String P = Util.y0(4);
    private static final String Q = Util.y0(5);
    private static final String R = Util.y0(6);
    private static final String S = Util.y0(8);
    private static final String T = Util.y0(9);
    private static final String U = Util.y0(10);
    private static final String V = Util.y0(11);
    private static final String W = Util.y0(12);
    private static final String X = Util.y0(13);
    private static final String Y = Util.y0(14);
    private static final String Z = Util.y0(15);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final String f40853a0 = Util.y0(16);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final String f40854b0 = Util.y0(17);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final String f40855c0 = Util.y0(18);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final String f40856d0 = Util.y0(19);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final String f40857e0 = Util.y0(20);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final String f40858f0 = Util.y0(21);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final String f40859g0 = Util.y0(22);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final String f40860h0 = Util.y0(23);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final String f40861i0 = Util.y0(24);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final String f40862j0 = Util.y0(25);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final String f40863k0 = Util.y0(26);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final String f40864l0 = Util.y0(27);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final String f40865m0 = Util.y0(28);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final String f40866n0 = Util.y0(29);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static final String f40867o0 = Util.y0(30);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final String f40868p0 = Util.y0(31);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final String f40869q0 = Util.y0(32);

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final String f40870r0 = Util.y0(33);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final String f40871s0 = Util.y0(34);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final String f40872t0 = Util.y0(1000);
    public final CharSequence A;
    public final CharSequence B;
    public final Integer C;
    public final Integer D;
    public final CharSequence E;
    public final CharSequence F;
    public final CharSequence G;
    public final Integer H;
    public final Bundle I;
    public final ImmutableList J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f40873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f40874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f40875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f40876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f40877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CharSequence f40878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f40879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f40880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rating f40881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rating f40882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f40883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f40884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Uri f40885m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f40886n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f40887o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Integer f40888p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Boolean f40889q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Boolean f40890r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Integer f40891s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Integer f40892t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Integer f40893u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Integer f40894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Integer f40895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Integer f40896x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Integer f40897y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CharSequence f40898z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
        private CharSequence A;
        private Integer B;
        private Integer C;
        private CharSequence D;
        private CharSequence E;
        private CharSequence F;
        private Integer G;
        private Bundle H;
        private ImmutableList I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f40899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f40900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f40901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f40902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f40903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private CharSequence f40904f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private CharSequence f40905g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Long f40906h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Rating f40907i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Rating f40908j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private byte[] f40909k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Integer f40910l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Uri f40911m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Integer f40912n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private Integer f40913o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private Integer f40914p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private Boolean f40915q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private Boolean f40916r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Integer f40917s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private Integer f40918t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private Integer f40919u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private Integer f40920v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private Integer f40921w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private Integer f40922x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private CharSequence f40923y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private CharSequence f40924z;

        public MediaMetadata J() {
            return new MediaMetadata(this);
        }

        public Builder K(byte[] bArr, int i3) {
            if (this.f40909k != null && i3 != 3 && Objects.equals(this.f40910l, 3)) {
                return this;
            }
            this.f40909k = (byte[]) bArr.clone();
            this.f40910l = Integer.valueOf(i3);
            return this;
        }

        public Builder L(MediaMetadata mediaMetadata) {
            if (mediaMetadata != null) {
                CharSequence charSequence = mediaMetadata.f40873a;
                if (charSequence != null) {
                    q0(charSequence);
                }
                CharSequence charSequence2 = mediaMetadata.f40874b;
                if (charSequence2 != null) {
                    Q(charSequence2);
                }
                CharSequence charSequence3 = mediaMetadata.f40875c;
                if (charSequence3 != null) {
                    P(charSequence3);
                }
                CharSequence charSequence4 = mediaMetadata.f40876d;
                if (charSequence4 != null) {
                    O(charSequence4);
                }
                CharSequence charSequence5 = mediaMetadata.f40877e;
                if (charSequence5 != null) {
                    Y(charSequence5);
                }
                CharSequence charSequence6 = mediaMetadata.f40878f;
                if (charSequence6 != null) {
                    o0(charSequence6);
                }
                CharSequence charSequence7 = mediaMetadata.f40879g;
                if (charSequence7 != null) {
                    W(charSequence7);
                }
                Long l3 = mediaMetadata.f40880h;
                if (l3 != null) {
                    Z(l3);
                }
                Rating rating = mediaMetadata.f40881i;
                if (rating != null) {
                    u0(rating);
                }
                Rating rating2 = mediaMetadata.f40882j;
                if (rating2 != null) {
                    g0(rating2);
                }
                Uri uri = mediaMetadata.f40885m;
                if (uri != null || mediaMetadata.f40883k != null) {
                    S(uri);
                    R(mediaMetadata.f40883k, mediaMetadata.f40884l);
                }
                Integer num = mediaMetadata.f40886n;
                if (num != null) {
                    t0(num);
                }
                Integer num2 = mediaMetadata.f40887o;
                if (num2 != null) {
                    s0(num2);
                }
                Integer num3 = mediaMetadata.f40888p;
                if (num3 != null) {
                    b0(num3);
                }
                Boolean bool = mediaMetadata.f40889q;
                if (bool != null) {
                    d0(bool);
                }
                Boolean bool2 = mediaMetadata.f40890r;
                if (bool2 != null) {
                    e0(bool2);
                }
                Integer num4 = mediaMetadata.f40891s;
                if (num4 != null) {
                    j0(num4);
                }
                Integer num5 = mediaMetadata.f40892t;
                if (num5 != null) {
                    j0(num5);
                }
                Integer num6 = mediaMetadata.f40893u;
                if (num6 != null) {
                    i0(num6);
                }
                Integer num7 = mediaMetadata.f40894v;
                if (num7 != null) {
                    h0(num7);
                }
                Integer num8 = mediaMetadata.f40895w;
                if (num8 != null) {
                    m0(num8);
                }
                Integer num9 = mediaMetadata.f40896x;
                if (num9 != null) {
                    l0(num9);
                }
                Integer num10 = mediaMetadata.f40897y;
                if (num10 != null) {
                    k0(num10);
                }
                CharSequence charSequence8 = mediaMetadata.f40898z;
                if (charSequence8 != null) {
                    v0(charSequence8);
                }
                CharSequence charSequence9 = mediaMetadata.A;
                if (charSequence9 != null) {
                    U(charSequence9);
                }
                CharSequence charSequence10 = mediaMetadata.B;
                if (charSequence10 != null) {
                    V(charSequence10);
                }
                Integer num11 = mediaMetadata.C;
                if (num11 != null) {
                    X(num11);
                }
                Integer num12 = mediaMetadata.D;
                if (num12 != null) {
                    r0(num12);
                }
                CharSequence charSequence11 = mediaMetadata.E;
                if (charSequence11 != null) {
                    c0(charSequence11);
                }
                CharSequence charSequence12 = mediaMetadata.F;
                if (charSequence12 != null) {
                    T(charSequence12);
                }
                CharSequence charSequence13 = mediaMetadata.G;
                if (charSequence13 != null) {
                    n0(charSequence13);
                }
                Integer num13 = mediaMetadata.H;
                if (num13 != null) {
                    f0(num13);
                }
                Bundle bundle = mediaMetadata.I;
                if (bundle != null) {
                    a0(bundle);
                }
                if (!mediaMetadata.J.isEmpty()) {
                    p0(mediaMetadata.J);
                }
            }
            return this;
        }

        public Builder M(Metadata metadata) {
            for (int i3 = 0; i3 < metadata.e(); i3++) {
                metadata.d(i3).b(this);
            }
            return this;
        }

        public Builder N(List list) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                Metadata metadata = (Metadata) list.get(i3);
                for (int i4 = 0; i4 < metadata.e(); i4++) {
                    metadata.d(i4).b(this);
                }
            }
            return this;
        }

        public Builder O(CharSequence charSequence) {
            this.f40902d = charSequence;
            return this;
        }

        public Builder P(CharSequence charSequence) {
            this.f40901c = charSequence;
            return this;
        }

        public Builder Q(CharSequence charSequence) {
            this.f40900b = charSequence;
            return this;
        }

        public Builder R(byte[] bArr, Integer num) {
            this.f40909k = bArr == null ? null : (byte[]) bArr.clone();
            this.f40910l = num;
            return this;
        }

        public Builder S(Uri uri) {
            this.f40911m = uri;
            return this;
        }

        public Builder T(CharSequence charSequence) {
            this.E = charSequence;
            return this;
        }

        public Builder U(CharSequence charSequence) {
            this.f40924z = charSequence;
            return this;
        }

        public Builder V(CharSequence charSequence) {
            this.A = charSequence;
            return this;
        }

        public Builder W(CharSequence charSequence) {
            this.f40905g = charSequence;
            return this;
        }

        public Builder X(Integer num) {
            this.B = num;
            return this;
        }

        public Builder Y(CharSequence charSequence) {
            this.f40903e = charSequence;
            return this;
        }

        public Builder Z(Long l3) {
            Assertions.a(l3 == null || l3.longValue() >= 0);
            this.f40906h = l3;
            return this;
        }

        public Builder a0(Bundle bundle) {
            this.H = bundle;
            return this;
        }

        public Builder b0(Integer num) {
            this.f40914p = num;
            return this;
        }

        public Builder c0(CharSequence charSequence) {
            this.D = charSequence;
            return this;
        }

        public Builder d0(Boolean bool) {
            this.f40915q = bool;
            return this;
        }

        public Builder e0(Boolean bool) {
            this.f40916r = bool;
            return this;
        }

        public Builder f0(Integer num) {
            this.G = num;
            return this;
        }

        public Builder g0(Rating rating) {
            this.f40908j = rating;
            return this;
        }

        public Builder h0(Integer num) {
            this.f40919u = num;
            return this;
        }

        public Builder i0(Integer num) {
            this.f40918t = num;
            return this;
        }

        public Builder j0(Integer num) {
            this.f40917s = num;
            return this;
        }

        public Builder k0(Integer num) {
            this.f40922x = num;
            return this;
        }

        public Builder l0(Integer num) {
            this.f40921w = num;
            return this;
        }

        public Builder m0(Integer num) {
            this.f40920v = num;
            return this;
        }

        public Builder n0(CharSequence charSequence) {
            this.F = charSequence;
            return this;
        }

        public Builder o0(CharSequence charSequence) {
            this.f40904f = charSequence;
            return this;
        }

        public Builder p0(List list) {
            this.I = ImmutableList.t(list);
            return this;
        }

        public Builder q0(CharSequence charSequence) {
            this.f40899a = charSequence;
            return this;
        }

        public Builder r0(Integer num) {
            this.C = num;
            return this;
        }

        public Builder s0(Integer num) {
            this.f40913o = num;
            return this;
        }

        public Builder t0(Integer num) {
            this.f40912n = num;
            return this;
        }

        public Builder u0(Rating rating) {
            this.f40907i = rating;
            return this;
        }

        public Builder v0(CharSequence charSequence) {
            this.f40923y = charSequence;
            return this;
        }

        public Builder() {
            this.I = ImmutableList.y();
        }

        private Builder(MediaMetadata mediaMetadata) {
            this.f40899a = mediaMetadata.f40873a;
            this.f40900b = mediaMetadata.f40874b;
            this.f40901c = mediaMetadata.f40875c;
            this.f40902d = mediaMetadata.f40876d;
            this.f40903e = mediaMetadata.f40877e;
            this.f40904f = mediaMetadata.f40878f;
            this.f40905g = mediaMetadata.f40879g;
            this.f40906h = mediaMetadata.f40880h;
            this.f40907i = mediaMetadata.f40881i;
            this.f40908j = mediaMetadata.f40882j;
            this.f40909k = mediaMetadata.f40883k;
            this.f40910l = mediaMetadata.f40884l;
            this.f40911m = mediaMetadata.f40885m;
            this.f40912n = mediaMetadata.f40886n;
            this.f40913o = mediaMetadata.f40887o;
            this.f40914p = mediaMetadata.f40888p;
            this.f40915q = mediaMetadata.f40889q;
            this.f40916r = mediaMetadata.f40890r;
            this.f40917s = mediaMetadata.f40892t;
            this.f40918t = mediaMetadata.f40893u;
            this.f40919u = mediaMetadata.f40894v;
            this.f40920v = mediaMetadata.f40895w;
            this.f40921w = mediaMetadata.f40896x;
            this.f40922x = mediaMetadata.f40897y;
            this.f40923y = mediaMetadata.f40898z;
            this.f40924z = mediaMetadata.A;
            this.A = mediaMetadata.B;
            this.B = mediaMetadata.C;
            this.C = mediaMetadata.D;
            this.D = mediaMetadata.E;
            this.E = mediaMetadata.F;
            this.F = mediaMetadata.G;
            this.G = mediaMetadata.H;
            this.I = mediaMetadata.J;
            this.H = mediaMetadata.I;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Deprecated
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FolderType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PictureType {
    }

    private static int b(int i3) {
        switch (i3) {
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
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                return 1;
            case 20:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            default:
                return 0;
            case 21:
                return 2;
            case 22:
                return 3;
            case 23:
                return 4;
            case 24:
                return 5;
            case 25:
                return 6;
        }
    }

    private static int c(int i3) {
        switch (i3) {
            case 1:
                return 0;
            case 2:
                return 21;
            case 3:
                return 22;
            case 4:
                return 23;
            case 5:
                return 24;
            case 6:
                return 25;
            default:
                return 20;
        }
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MediaMetadata.class == obj.getClass()) {
            MediaMetadata mediaMetadata = (MediaMetadata) obj;
            if (Objects.equals(this.f40873a, mediaMetadata.f40873a) && Objects.equals(this.f40874b, mediaMetadata.f40874b) && Objects.equals(this.f40875c, mediaMetadata.f40875c) && Objects.equals(this.f40876d, mediaMetadata.f40876d) && Objects.equals(this.f40877e, mediaMetadata.f40877e) && Objects.equals(this.f40878f, mediaMetadata.f40878f) && Objects.equals(this.f40879g, mediaMetadata.f40879g) && Objects.equals(this.f40880h, mediaMetadata.f40880h) && Objects.equals(this.f40881i, mediaMetadata.f40881i) && Objects.equals(this.f40882j, mediaMetadata.f40882j) && Arrays.equals(this.f40883k, mediaMetadata.f40883k) && Objects.equals(this.f40884l, mediaMetadata.f40884l) && Objects.equals(this.f40885m, mediaMetadata.f40885m) && Objects.equals(this.f40886n, mediaMetadata.f40886n) && Objects.equals(this.f40887o, mediaMetadata.f40887o) && Objects.equals(this.f40888p, mediaMetadata.f40888p) && Objects.equals(this.f40889q, mediaMetadata.f40889q) && Objects.equals(this.f40890r, mediaMetadata.f40890r) && Objects.equals(this.f40892t, mediaMetadata.f40892t) && Objects.equals(this.f40893u, mediaMetadata.f40893u) && Objects.equals(this.f40894v, mediaMetadata.f40894v) && Objects.equals(this.f40895w, mediaMetadata.f40895w) && Objects.equals(this.f40896x, mediaMetadata.f40896x) && Objects.equals(this.f40897y, mediaMetadata.f40897y) && Objects.equals(this.f40898z, mediaMetadata.f40898z) && Objects.equals(this.A, mediaMetadata.A) && Objects.equals(this.B, mediaMetadata.B) && Objects.equals(this.C, mediaMetadata.C) && Objects.equals(this.D, mediaMetadata.D) && Objects.equals(this.E, mediaMetadata.E) && Objects.equals(this.F, mediaMetadata.F) && Objects.equals(this.G, mediaMetadata.G) && Objects.equals(this.H, mediaMetadata.H) && Objects.equals(this.J, mediaMetadata.J)) {
                if ((this.I == null) == (mediaMetadata.I == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f40873a, this.f40874b, this.f40875c, this.f40876d, this.f40877e, this.f40878f, this.f40879g, this.f40880h, this.f40881i, this.f40882j, Integer.valueOf(Arrays.hashCode(this.f40883k)), this.f40884l, this.f40885m, this.f40886n, this.f40887o, this.f40888p, this.f40889q, this.f40890r, this.f40892t, this.f40893u, this.f40894v, this.f40895w, this.f40896x, this.f40897y, this.f40898z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, Boolean.valueOf(this.I == null), this.J);
    }

    private MediaMetadata(Builder builder) {
        Boolean boolValueOf = builder.f40915q;
        Integer numValueOf = builder.f40914p;
        Integer numValueOf2 = builder.G;
        if (boolValueOf != null) {
            if (!boolValueOf.booleanValue()) {
                numValueOf = -1;
            } else if (numValueOf == null || numValueOf.intValue() == -1) {
                numValueOf = Integer.valueOf(numValueOf2 != null ? b(numValueOf2.intValue()) : 0);
            }
        } else if (numValueOf != null) {
            boolean z2 = numValueOf.intValue() != -1;
            boolValueOf = Boolean.valueOf(z2);
            if (z2 && numValueOf2 == null) {
                numValueOf2 = Integer.valueOf(c(numValueOf.intValue()));
            }
        }
        this.f40873a = builder.f40899a;
        this.f40874b = builder.f40900b;
        this.f40875c = builder.f40901c;
        this.f40876d = builder.f40902d;
        this.f40877e = builder.f40903e;
        this.f40878f = builder.f40904f;
        this.f40879g = builder.f40905g;
        this.f40880h = builder.f40906h;
        this.f40881i = builder.f40907i;
        this.f40882j = builder.f40908j;
        this.f40883k = builder.f40909k;
        this.f40884l = builder.f40910l;
        this.f40885m = builder.f40911m;
        this.f40886n = builder.f40912n;
        this.f40887o = builder.f40913o;
        this.f40888p = numValueOf;
        this.f40889q = boolValueOf;
        this.f40890r = builder.f40916r;
        this.f40891s = builder.f40917s;
        this.f40892t = builder.f40917s;
        this.f40893u = builder.f40918t;
        this.f40894v = builder.f40919u;
        this.f40895w = builder.f40920v;
        this.f40896x = builder.f40921w;
        this.f40897y = builder.f40922x;
        this.f40898z = builder.f40923y;
        this.A = builder.f40924z;
        this.B = builder.A;
        this.C = builder.B;
        this.D = builder.C;
        this.E = builder.D;
        this.F = builder.E;
        this.G = builder.F;
        this.H = numValueOf2;
        this.J = builder.I;
        this.I = builder.H;
    }
}
