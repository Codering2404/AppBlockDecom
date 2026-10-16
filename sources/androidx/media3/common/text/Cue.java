package androidx.media3.common.text;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Cue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f41416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f41417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f41418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f41419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f41420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f41421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f41422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f41423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f41424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f41425j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f41426k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f41427l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f41428m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f41429n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f41430o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f41431p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f41432q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Cue f41407r = new Builder().o("").a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f41408s = Util.y0(0);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f41409t = Util.y0(17);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f41410u = Util.y0(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f41411v = Util.y0(2);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f41412w = Util.y0(3);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f41413x = Util.y0(18);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f41414y = Util.y0(4);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f41415z = Util.y0(5);
    private static final String A = Util.y0(6);
    private static final String B = Util.y0(7);
    private static final String C = Util.y0(8);
    private static final String D = Util.y0(9);
    private static final String E = Util.y0(10);
    private static final String F = Util.y0(11);
    private static final String G = Util.y0(12);
    private static final String H = Util.y0(13);
    private static final String I = Util.y0(14);
    private static final String J = Util.y0(15);
    private static final String K = Util.y0(16);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f41433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f41434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Layout.Alignment f41435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Layout.Alignment f41436d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f41437e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f41438f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f41439g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f41440h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f41441i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f41442j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f41443k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private float f41444l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private float f41445m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f41446n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f41447o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f41448p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private float f41449q;

        public Cue a() {
            return new Cue(this.f41433a, this.f41435c, this.f41436d, this.f41434b, this.f41437e, this.f41438f, this.f41439g, this.f41440h, this.f41441i, this.f41442j, this.f41443k, this.f41444l, this.f41445m, this.f41446n, this.f41447o, this.f41448p, this.f41449q);
        }

        public Builder b() {
            this.f41446n = false;
            return this;
        }

        public int c() {
            return this.f41439g;
        }

        public int d() {
            return this.f41441i;
        }

        public CharSequence e() {
            return this.f41433a;
        }

        public Builder f(Bitmap bitmap) {
            this.f41434b = bitmap;
            return this;
        }

        public Builder g(float f3) {
            this.f41445m = f3;
            return this;
        }

        public Builder h(float f3, int i3) {
            this.f41437e = f3;
            this.f41438f = i3;
            return this;
        }

        public Builder i(int i3) {
            this.f41439g = i3;
            return this;
        }

        public Builder j(Layout.Alignment alignment) {
            this.f41436d = alignment;
            return this;
        }

        public Builder k(float f3) {
            this.f41440h = f3;
            return this;
        }

        public Builder l(int i3) {
            this.f41441i = i3;
            return this;
        }

        public Builder m(float f3) {
            this.f41449q = f3;
            return this;
        }

        public Builder n(float f3) {
            this.f41444l = f3;
            return this;
        }

        public Builder o(CharSequence charSequence) {
            this.f41433a = charSequence;
            return this;
        }

        public Builder p(Layout.Alignment alignment) {
            this.f41435c = alignment;
            return this;
        }

        public Builder q(float f3, int i3) {
            this.f41443k = f3;
            this.f41442j = i3;
            return this;
        }

        public Builder r(int i3) {
            this.f41448p = i3;
            return this;
        }

        public Builder s(int i3) {
            this.f41447o = i3;
            this.f41446n = true;
            return this;
        }

        public Builder() {
            this.f41433a = null;
            this.f41434b = null;
            this.f41435c = null;
            this.f41436d = null;
            this.f41437e = -3.4028235E38f;
            this.f41438f = Integer.MIN_VALUE;
            this.f41439g = Integer.MIN_VALUE;
            this.f41440h = -3.4028235E38f;
            this.f41441i = Integer.MIN_VALUE;
            this.f41442j = Integer.MIN_VALUE;
            this.f41443k = -3.4028235E38f;
            this.f41444l = -3.4028235E38f;
            this.f41445m = -3.4028235E38f;
            this.f41446n = false;
            this.f41447o = -16777216;
            this.f41448p = Integer.MIN_VALUE;
        }

        private Builder(Cue cue) {
            this.f41433a = cue.f41416a;
            this.f41434b = cue.f41419d;
            this.f41435c = cue.f41417b;
            this.f41436d = cue.f41418c;
            this.f41437e = cue.f41420e;
            this.f41438f = cue.f41421f;
            this.f41439g = cue.f41422g;
            this.f41440h = cue.f41423h;
            this.f41441i = cue.f41424i;
            this.f41442j = cue.f41429n;
            this.f41443k = cue.f41430o;
            this.f41444l = cue.f41425j;
            this.f41445m = cue.f41426k;
            this.f41446n = cue.f41427l;
            this.f41447o = cue.f41428m;
            this.f41448p = cue.f41431p;
            this.f41449q = cue.f41432q;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VerticalType {
    }

    public static Cue b(Bundle bundle) {
        Builder builder = new Builder();
        CharSequence charSequence = bundle.getCharSequence(f41408s);
        if (charSequence != null) {
            builder.o(charSequence);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f41409t);
            if (parcelableArrayList != null) {
                SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
                int size = parcelableArrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = parcelableArrayList.get(i3);
                    i3++;
                    CustomSpanBundler.c((Bundle) obj, spannableStringValueOf);
                }
                builder.o(spannableStringValueOf);
            }
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(f41410u);
        if (alignment != null) {
            builder.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(f41411v);
        if (alignment2 != null) {
            builder.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(f41412w);
        if (bitmap != null) {
            builder.f(bitmap);
        } else {
            byte[] byteArray = bundle.getByteArray(f41413x);
            if (byteArray != null) {
                builder.f(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
            }
        }
        String str = f41414y;
        if (bundle.containsKey(str)) {
            String str2 = f41415z;
            if (bundle.containsKey(str2)) {
                builder.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = A;
        if (bundle.containsKey(str3)) {
            builder.i(bundle.getInt(str3));
        }
        String str4 = B;
        if (bundle.containsKey(str4)) {
            builder.k(bundle.getFloat(str4));
        }
        String str5 = C;
        if (bundle.containsKey(str5)) {
            builder.l(bundle.getInt(str5));
        }
        String str6 = E;
        if (bundle.containsKey(str6)) {
            String str7 = D;
            if (bundle.containsKey(str7)) {
                builder.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = F;
        if (bundle.containsKey(str8)) {
            builder.n(bundle.getFloat(str8));
        }
        String str9 = G;
        if (bundle.containsKey(str9)) {
            builder.g(bundle.getFloat(str9));
        }
        String str10 = H;
        if (bundle.containsKey(str10)) {
            builder.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(I, false)) {
            builder.b();
        }
        String str11 = J;
        if (bundle.containsKey(str11)) {
            builder.r(bundle.getInt(str11));
        }
        String str12 = K;
        if (bundle.containsKey(str12)) {
            builder.m(bundle.getFloat(str12));
        }
        return builder.a();
    }

    private Bundle c() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f41416a;
        if (charSequence != null) {
            bundle.putCharSequence(f41408s, charSequence);
            CharSequence charSequence2 = this.f41416a;
            if (charSequence2 instanceof Spanned) {
                ArrayList<? extends Parcelable> arrayListA = CustomSpanBundler.a((Spanned) charSequence2);
                if (!arrayListA.isEmpty()) {
                    bundle.putParcelableArrayList(f41409t, arrayListA);
                }
            }
        }
        bundle.putSerializable(f41410u, this.f41417b);
        bundle.putSerializable(f41411v, this.f41418c);
        bundle.putFloat(f41414y, this.f41420e);
        bundle.putInt(f41415z, this.f41421f);
        bundle.putInt(A, this.f41422g);
        bundle.putFloat(B, this.f41423h);
        bundle.putInt(C, this.f41424i);
        bundle.putInt(D, this.f41429n);
        bundle.putFloat(E, this.f41430o);
        bundle.putFloat(F, this.f41425j);
        bundle.putFloat(G, this.f41426k);
        bundle.putBoolean(I, this.f41427l);
        bundle.putInt(H, this.f41428m);
        bundle.putInt(J, this.f41431p);
        bundle.putFloat(K, this.f41432q);
        return bundle;
    }

    public Builder a() {
        return new Builder();
    }

    public Bundle d() {
        Bundle bundleC = c();
        if (this.f41419d != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Assertions.g(this.f41419d.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            bundleC.putByteArray(f41413x, byteArrayOutputStream.toByteArray());
        }
        return bundleC;
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj != null && Cue.class == obj.getClass()) {
            Cue cue = (Cue) obj;
            if (TextUtils.equals(this.f41416a, cue.f41416a) && this.f41417b == cue.f41417b && this.f41418c == cue.f41418c && ((bitmap = this.f41419d) != null ? !((bitmap2 = cue.f41419d) == null || !bitmap.sameAs(bitmap2)) : cue.f41419d == null) && this.f41420e == cue.f41420e && this.f41421f == cue.f41421f && this.f41422g == cue.f41422g && this.f41423h == cue.f41423h && this.f41424i == cue.f41424i && this.f41425j == cue.f41425j && this.f41426k == cue.f41426k && this.f41427l == cue.f41427l && this.f41428m == cue.f41428m && this.f41429n == cue.f41429n && this.f41430o == cue.f41430o && this.f41431p == cue.f41431p && this.f41432q == cue.f41432q) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f41416a, this.f41417b, this.f41418c, this.f41419d, Float.valueOf(this.f41420e), Integer.valueOf(this.f41421f), Integer.valueOf(this.f41422g), Float.valueOf(this.f41423h), Integer.valueOf(this.f41424i), Float.valueOf(this.f41425j), Float.valueOf(this.f41426k), Boolean.valueOf(this.f41427l), Integer.valueOf(this.f41428m), Integer.valueOf(this.f41429n), Float.valueOf(this.f41430o), Integer.valueOf(this.f41431p), Float.valueOf(this.f41432q));
    }

    private Cue(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f3, int i3, int i4, float f4, int i5, int i6, float f5, float f6, float f7, boolean z2, int i7, int i8, float f8) {
        if (charSequence == null) {
            Assertions.e(bitmap);
        } else {
            Assertions.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f41416a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f41416a = charSequence.toString();
        } else {
            this.f41416a = null;
        }
        this.f41417b = alignment;
        this.f41418c = alignment2;
        this.f41419d = bitmap;
        this.f41420e = f3;
        this.f41421f = i3;
        this.f41422g = i4;
        this.f41423h = f4;
        this.f41424i = i5;
        this.f41425j = f6;
        this.f41426k = f7;
        this.f41427l = z2;
        this.f41428m = i7;
        this.f41429n = i6;
        this.f41430o = f5;
        this.f41431p = i8;
        this.f41432q = f8;
    }
}
