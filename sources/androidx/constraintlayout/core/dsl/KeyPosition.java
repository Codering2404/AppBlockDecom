package androidx.constraintlayout.core.dsl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyPosition extends Keys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f31428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f31429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f31430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f31431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Type f31432h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    public enum Type {
        CARTESIAN,
        f31434b,
        PATH
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPositions:{\n");
        b(sb, "target", this.f31425a);
        sb.append("frame:");
        sb.append(this.f31427c);
        sb.append(",\n");
        if (this.f31432h != null) {
            sb.append("type:'");
            sb.append(this.f31432h);
            sb.append("',\n");
        }
        b(sb, "easing", this.f31426b);
        a(sb, "percentX", this.f31430f);
        a(sb, "percentY", this.f31431g);
        a(sb, "percentWidth", this.f31428d);
        a(sb, "percentHeight", this.f31429e);
        sb.append("},\n");
        return sb.toString();
    }
}
