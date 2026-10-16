package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TtmlStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f47228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f47229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f47230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f47231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f47232e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f47238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f47239l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Layout.Alignment f47242o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Layout.Alignment f47243p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextEmphasis f47245r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f47247t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f47248u;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f47233f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f47234g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f47235h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47236i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f47237j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47240m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f47241n = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f47244q = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f47246s = Float.MAX_VALUE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RubyType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    private TtmlStyle t(TtmlStyle ttmlStyle, boolean z2) {
        int i3;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (ttmlStyle != null) {
            if (!this.f47230c && ttmlStyle.f47230c) {
                z(ttmlStyle.f47229b);
            }
            if (this.f47235h == -1) {
                this.f47235h = ttmlStyle.f47235h;
            }
            if (this.f47236i == -1) {
                this.f47236i = ttmlStyle.f47236i;
            }
            if (this.f47228a == null && (str = ttmlStyle.f47228a) != null) {
                this.f47228a = str;
            }
            if (this.f47233f == -1) {
                this.f47233f = ttmlStyle.f47233f;
            }
            if (this.f47234g == -1) {
                this.f47234g = ttmlStyle.f47234g;
            }
            if (this.f47241n == -1) {
                this.f47241n = ttmlStyle.f47241n;
            }
            if (this.f47242o == null && (alignment2 = ttmlStyle.f47242o) != null) {
                this.f47242o = alignment2;
            }
            if (this.f47243p == null && (alignment = ttmlStyle.f47243p) != null) {
                this.f47243p = alignment;
            }
            if (this.f47244q == -1) {
                this.f47244q = ttmlStyle.f47244q;
            }
            if (this.f47237j == -1) {
                this.f47237j = ttmlStyle.f47237j;
                this.f47238k = ttmlStyle.f47238k;
            }
            if (this.f47245r == null) {
                this.f47245r = ttmlStyle.f47245r;
            }
            if (this.f47246s == Float.MAX_VALUE) {
                this.f47246s = ttmlStyle.f47246s;
            }
            if (this.f47247t == null) {
                this.f47247t = ttmlStyle.f47247t;
            }
            if (this.f47248u == null) {
                this.f47248u = ttmlStyle.f47248u;
            }
            if (z2 && !this.f47232e && ttmlStyle.f47232e) {
                w(ttmlStyle.f47231d);
            }
            if (z2 && this.f47240m == -1 && (i3 = ttmlStyle.f47240m) != -1) {
                this.f47240m = i3;
            }
        }
        return this;
    }

    public TtmlStyle A(String str) {
        this.f47228a = str;
        return this;
    }

    public TtmlStyle B(float f3) {
        this.f47238k = f3;
        return this;
    }

    public TtmlStyle C(int i3) {
        this.f47237j = i3;
        return this;
    }

    public TtmlStyle D(String str) {
        this.f47239l = str;
        return this;
    }

    public TtmlStyle E(boolean z2) {
        this.f47236i = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle F(boolean z2) {
        this.f47233f = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle G(Layout.Alignment alignment) {
        this.f47243p = alignment;
        return this;
    }

    public TtmlStyle H(String str) {
        this.f47247t = str;
        return this;
    }

    public TtmlStyle I(int i3) {
        this.f47241n = i3;
        return this;
    }

    public TtmlStyle J(int i3) {
        this.f47240m = i3;
        return this;
    }

    public TtmlStyle K(float f3) {
        this.f47246s = f3;
        return this;
    }

    public TtmlStyle L(Layout.Alignment alignment) {
        this.f47242o = alignment;
        return this;
    }

    public TtmlStyle M(boolean z2) {
        this.f47244q = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle N(TextEmphasis textEmphasis) {
        this.f47245r = textEmphasis;
        return this;
    }

    public TtmlStyle O(boolean z2) {
        this.f47234g = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle a(TtmlStyle ttmlStyle) {
        return t(ttmlStyle, true);
    }

    public int b() {
        if (this.f47232e) {
            return this.f47231d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public String c() {
        return this.f47248u;
    }

    public int d() {
        if (this.f47230c) {
            return this.f47229b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String e() {
        return this.f47228a;
    }

    public float f() {
        return this.f47238k;
    }

    public int g() {
        return this.f47237j;
    }

    public String h() {
        return this.f47239l;
    }

    public Layout.Alignment i() {
        return this.f47243p;
    }

    public String j() {
        return this.f47247t;
    }

    public int k() {
        return this.f47241n;
    }

    public int l() {
        return this.f47240m;
    }

    public float m() {
        return this.f47246s;
    }

    public int n() {
        int i3 = this.f47235h;
        if (i3 == -1 && this.f47236i == -1) {
            return -1;
        }
        return (i3 == 1 ? 1 : 0) | (this.f47236i == 1 ? 2 : 0);
    }

    public Layout.Alignment o() {
        return this.f47242o;
    }

    public boolean p() {
        return this.f47244q == 1;
    }

    public TextEmphasis q() {
        return this.f47245r;
    }

    public boolean r() {
        return this.f47232e;
    }

    public boolean s() {
        return this.f47230c;
    }

    public boolean u() {
        return this.f47233f == 1;
    }

    public boolean v() {
        return this.f47234g == 1;
    }

    public TtmlStyle w(int i3) {
        this.f47231d = i3;
        this.f47232e = true;
        return this;
    }

    public TtmlStyle x(boolean z2) {
        this.f47235h = z2 ? 1 : 0;
        return this;
    }

    public TtmlStyle y(String str) {
        this.f47248u = str;
        return this;
    }

    public TtmlStyle z(int i3) {
        this.f47229b = i3;
        this.f47230c = true;
        return this;
    }
}
