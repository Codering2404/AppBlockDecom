package androidx.constraintlayout.core.dsl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyAttributes extends Keys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f31377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String[] f31378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Fit f31380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f31381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Visibility[] f31382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f31383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f31384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float[] f31385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[] f31386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f31387k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float[] f31388l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float[] f31389m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float[] f31390n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float[] f31391o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float[] f31392p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float[] f31393q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float[] f31394r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Fit {
        SPLINE,
        LINEAR
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Visibility {
        VISIBLE,
        INVISIBLE,
        GONE
    }

    protected void f(StringBuilder sb) {
        d(sb, "target", this.f31378b);
        sb.append("frame:");
        sb.append(Arrays.toString(this.f31381e));
        sb.append(",\n");
        b(sb, "easing", this.f31379c);
        if (this.f31380d != null) {
            sb.append("fit:'");
            sb.append(this.f31380d);
            sb.append("',\n");
        }
        if (this.f31382f != null) {
            sb.append("visibility:'");
            sb.append(Arrays.toString(this.f31382f));
            sb.append("',\n");
        }
        c(sb, "alpha", this.f31383g);
        c(sb, "rotationX", this.f31385i);
        c(sb, "rotationY", this.f31386j);
        c(sb, "rotationZ", this.f31384h);
        c(sb, "pivotX", this.f31387k);
        c(sb, "pivotY", this.f31388l);
        c(sb, "pathRotate", this.f31389m);
        c(sb, "scaleX", this.f31390n);
        c(sb, "scaleY", this.f31391o);
        c(sb, "translationX", this.f31392p);
        c(sb, "translationY", this.f31393q);
        c(sb, "translationZ", this.f31394r);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f31377a);
        sb.append(":{\n");
        f(sb);
        sb.append("},\n");
        return sb.toString();
    }
}
