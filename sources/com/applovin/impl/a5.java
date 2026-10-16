package com.applovin.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class a5 implements o2 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a5 f58171s = new b().a("").a();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final o2.a f58172t = new o2.a() { // from class: com.applovin.impl.js
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return a5.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f58173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f58174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f58175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f58176d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f58177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f58178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f58179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f58180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f58181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f58182k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f58183l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f58184m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f58185n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f58186o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f58187p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f58188q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f58189r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f58190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f58191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Layout.Alignment f58192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Layout.Alignment f58193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f58194e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f58195f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f58196g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f58197h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f58198i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f58199j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f58200k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private float f58201l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private float f58202m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f58203n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f58204o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f58205p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private float f58206q;

        public b() {
            this.f58190a = null;
            this.f58191b = null;
            this.f58192c = null;
            this.f58193d = null;
            this.f58194e = -3.4028235E38f;
            this.f58195f = Integer.MIN_VALUE;
            this.f58196g = Integer.MIN_VALUE;
            this.f58197h = -3.4028235E38f;
            this.f58198i = Integer.MIN_VALUE;
            this.f58199j = Integer.MIN_VALUE;
            this.f58200k = -3.4028235E38f;
            this.f58201l = -3.4028235E38f;
            this.f58202m = -3.4028235E38f;
            this.f58203n = false;
            this.f58204o = -16777216;
            this.f58205p = Integer.MIN_VALUE;
        }

        public b a(Bitmap bitmap) {
            this.f58191b = bitmap;
            return this;
        }

        public b b() {
            this.f58203n = false;
            return this;
        }

        public int c() {
            return this.f58196g;
        }

        public int d() {
            return this.f58198i;
        }

        public CharSequence e() {
            return this.f58190a;
        }

        public b a(float f3) {
            this.f58202m = f3;
            return this;
        }

        public b b(float f3) {
            this.f58197h = f3;
            return this;
        }

        public b c(float f3) {
            this.f58206q = f3;
            return this;
        }

        public b d(float f3) {
            this.f58201l = f3;
            return this;
        }

        public b a(float f3, int i3) {
            this.f58194e = f3;
            this.f58195f = i3;
            return this;
        }

        public b b(int i3) {
            this.f58198i = i3;
            return this;
        }

        public b c(int i3) {
            this.f58205p = i3;
            return this;
        }

        public b d(int i3) {
            this.f58204o = i3;
            this.f58203n = true;
            return this;
        }

        public b b(Layout.Alignment alignment) {
            this.f58192c = alignment;
            return this;
        }

        public b a(int i3) {
            this.f58196g = i3;
            return this;
        }

        public b b(float f3, int i3) {
            this.f58200k = f3;
            this.f58199j = i3;
            return this;
        }

        public b a(Layout.Alignment alignment) {
            this.f58193d = alignment;
            return this;
        }

        public b a(CharSequence charSequence) {
            this.f58190a = charSequence;
            return this;
        }

        public a5 a() {
            return new a5(this.f58190a, this.f58192c, this.f58193d, this.f58191b, this.f58194e, this.f58195f, this.f58196g, this.f58197h, this.f58198i, this.f58199j, this.f58200k, this.f58201l, this.f58202m, this.f58203n, this.f58204o, this.f58205p, this.f58206q);
        }

        private b(a5 a5Var) {
            this.f58190a = a5Var.f58173a;
            this.f58191b = a5Var.f58176d;
            this.f58192c = a5Var.f58174b;
            this.f58193d = a5Var.f58175c;
            this.f58194e = a5Var.f58177f;
            this.f58195f = a5Var.f58178g;
            this.f58196g = a5Var.f58179h;
            this.f58197h = a5Var.f58180i;
            this.f58198i = a5Var.f58181j;
            this.f58199j = a5Var.f58186o;
            this.f58200k = a5Var.f58187p;
            this.f58201l = a5Var.f58182k;
            this.f58202m = a5Var.f58183l;
            this.f58203n = a5Var.f58184m;
            this.f58204o = a5Var.f58185n;
            this.f58205p = a5Var.f58188q;
            this.f58206q = a5Var.f58189r;
        }
    }

    private a5(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f3, int i3, int i4, float f4, int i5, int i6, float f5, float f6, float f7, boolean z2, int i7, int i8, float f8) {
        if (charSequence == null) {
            b1.a(bitmap);
        } else {
            b1.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f58173a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f58173a = charSequence.toString();
        } else {
            this.f58173a = null;
        }
        this.f58174b = alignment;
        this.f58175c = alignment2;
        this.f58176d = bitmap;
        this.f58177f = f3;
        this.f58178g = i3;
        this.f58179h = i4;
        this.f58180i = f4;
        this.f58181j = i5;
        this.f58182k = f6;
        this.f58183l = f7;
        this.f58184m = z2;
        this.f58185n = i7;
        this.f58186o = i6;
        this.f58187p = f5;
        this.f58188q = i8;
        this.f58189r = f8;
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj != null && a5.class == obj.getClass()) {
            a5 a5Var = (a5) obj;
            if (TextUtils.equals(this.f58173a, a5Var.f58173a) && this.f58174b == a5Var.f58174b && this.f58175c == a5Var.f58175c && ((bitmap = this.f58176d) != null ? !((bitmap2 = a5Var.f58176d) == null || !bitmap.sameAs(bitmap2)) : a5Var.f58176d == null) && this.f58177f == a5Var.f58177f && this.f58178g == a5Var.f58178g && this.f58179h == a5Var.f58179h && this.f58180i == a5Var.f58180i && this.f58181j == a5Var.f58181j && this.f58182k == a5Var.f58182k && this.f58183l == a5Var.f58183l && this.f58184m == a5Var.f58184m && this.f58185n == a5Var.f58185n && this.f58186o == a5Var.f58186o && this.f58187p == a5Var.f58187p && this.f58188q == a5Var.f58188q && this.f58189r == a5Var.f58189r) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f58173a, this.f58174b, this.f58175c, this.f58176d, Float.valueOf(this.f58177f), Integer.valueOf(this.f58178g), Integer.valueOf(this.f58179h), Float.valueOf(this.f58180i), Integer.valueOf(this.f58181j), Float.valueOf(this.f58182k), Float.valueOf(this.f58183l), Boolean.valueOf(this.f58184m), Integer.valueOf(this.f58185n), Integer.valueOf(this.f58186o), Float.valueOf(this.f58187p), Integer.valueOf(this.f58188q), Float.valueOf(this.f58189r));
    }

    public b a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a5 a(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(a(0));
        if (charSequence != null) {
            bVar.a(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(a(1));
        if (alignment != null) {
            bVar.b(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(a(2));
        if (alignment2 != null) {
            bVar.a(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(a(3));
        if (bitmap != null) {
            bVar.a(bitmap);
        }
        if (bundle.containsKey(a(4)) && bundle.containsKey(a(5))) {
            bVar.a(bundle.getFloat(a(4)), bundle.getInt(a(5)));
        }
        if (bundle.containsKey(a(6))) {
            bVar.a(bundle.getInt(a(6)));
        }
        if (bundle.containsKey(a(7))) {
            bVar.b(bundle.getFloat(a(7)));
        }
        if (bundle.containsKey(a(8))) {
            bVar.b(bundle.getInt(a(8)));
        }
        if (bundle.containsKey(a(10)) && bundle.containsKey(a(9))) {
            bVar.b(bundle.getFloat(a(10)), bundle.getInt(a(9)));
        }
        if (bundle.containsKey(a(11))) {
            bVar.d(bundle.getFloat(a(11)));
        }
        if (bundle.containsKey(a(12))) {
            bVar.a(bundle.getFloat(a(12)));
        }
        if (bundle.containsKey(a(13))) {
            bVar.d(bundle.getInt(a(13)));
        }
        if (!bundle.getBoolean(a(14), false)) {
            bVar.b();
        }
        if (bundle.containsKey(a(15))) {
            bVar.c(bundle.getInt(a(15)));
        }
        if (bundle.containsKey(a(16))) {
            bVar.c(bundle.getFloat(a(16)));
        }
        return bVar.a();
    }
}
