package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttCssStyle {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f47286f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f47288h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f47295o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f47281a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f47282b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set f47283c = Collections.EMPTY_SET;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f47284d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f47285e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f47287g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f47289i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f47290j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f47291k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f47292l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47293m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f47294n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f47296p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f47297q = false;

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
    public @interface StyleFlags {
    }

    private static int B(int i3, String str, String str2, int i4) {
        if (str.isEmpty() || i3 == -1) {
            return i3;
        }
        if (str.equals(str2)) {
            return i3 + i4;
        }
        return -1;
    }

    public WebvttCssStyle A(boolean z2) {
        this.f47291k = z2 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f47289i) {
            return this.f47288h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f47297q;
    }

    public int c() {
        if (this.f47287g) {
            return this.f47286f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f47285e;
    }

    public float e() {
        return this.f47295o;
    }

    public int f() {
        return this.f47294n;
    }

    public int g() {
        return this.f47296p;
    }

    public int h(String str, String str2, Set set, String str3) {
        if (this.f47281a.isEmpty() && this.f47282b.isEmpty() && this.f47283c.isEmpty() && this.f47284d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iB = B(B(B(0, this.f47281a, str, 1073741824), this.f47282b, str2, 2), this.f47284d, str3, 4);
        if (iB == -1 || !set.containsAll(this.f47283c)) {
            return 0;
        }
        return iB + (this.f47283c.size() * 4);
    }

    public int i() {
        int i3 = this.f47292l;
        if (i3 == -1 && this.f47293m == -1) {
            return -1;
        }
        return (i3 == 1 ? 1 : 0) | (this.f47293m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f47289i;
    }

    public boolean k() {
        return this.f47287g;
    }

    public boolean l() {
        return this.f47290j == 1;
    }

    public boolean m() {
        return this.f47291k == 1;
    }

    public WebvttCssStyle n(int i3) {
        this.f47288h = i3;
        this.f47289i = true;
        return this;
    }

    public WebvttCssStyle o(boolean z2) {
        this.f47292l = z2 ? 1 : 0;
        return this;
    }

    public WebvttCssStyle p(boolean z2) {
        this.f47297q = z2;
        return this;
    }

    public WebvttCssStyle q(int i3) {
        this.f47286f = i3;
        this.f47287g = true;
        return this;
    }

    public WebvttCssStyle r(String str) {
        this.f47285e = str == null ? null : Ascii.e(str);
        return this;
    }

    public WebvttCssStyle s(float f3) {
        this.f47295o = f3;
        return this;
    }

    public WebvttCssStyle t(int i3) {
        this.f47294n = i3;
        return this;
    }

    public WebvttCssStyle u(boolean z2) {
        this.f47293m = z2 ? 1 : 0;
        return this;
    }

    public WebvttCssStyle v(int i3) {
        this.f47296p = i3;
        return this;
    }

    public void w(String[] strArr) {
        this.f47283c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f47281a = str;
    }

    public void y(String str) {
        this.f47282b = str;
    }

    public void z(String str) {
        this.f47284d = str;
    }
}
