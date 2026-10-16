package androidx.constraintlayout.core.dsl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyAttribute extends Keys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f31352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Fit f31356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Visibility f31357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f31358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f31359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f31360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f31361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f31362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f31363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f31364m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f31365n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f31366o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f31367p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f31368q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31369r;

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
        b(sb, "target", this.f31353b);
        sb.append("frame:");
        sb.append(this.f31354c);
        sb.append(",\n");
        b(sb, "easing", this.f31355d);
        if (this.f31356e != null) {
            sb.append("fit:'");
            sb.append(this.f31356e);
            sb.append("',\n");
        }
        if (this.f31357f != null) {
            sb.append("visibility:'");
            sb.append(this.f31357f);
            sb.append("',\n");
        }
        a(sb, "alpha", this.f31358g);
        a(sb, "rotationX", this.f31360i);
        a(sb, "rotationY", this.f31361j);
        a(sb, "rotationZ", this.f31359h);
        a(sb, "pivotX", this.f31362k);
        a(sb, "pivotY", this.f31363l);
        a(sb, "pathRotate", this.f31364m);
        a(sb, "scaleX", this.f31365n);
        a(sb, "scaleY", this.f31366o);
        a(sb, "translationX", this.f31367p);
        a(sb, "translationY", this.f31368q);
        a(sb, "translationZ", this.f31369r);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f31352a);
        sb.append(":{\n");
        f(sb);
        sb.append("},\n");
        return sb.toString();
    }
}
