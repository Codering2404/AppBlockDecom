package androidx.constraintlayout.core.dsl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyCycle extends KeyAttribute {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Wave f31402s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f31403t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f31404u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f31405v;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Wave {
        SIN,
        SQUARE,
        TRIANGLE,
        SAW,
        REVERSE_SAW,
        COS
    }

    @Override // androidx.constraintlayout.core.dsl.KeyAttribute
    protected void f(StringBuilder sb) {
        super.f(sb);
        if (this.f31402s != null) {
            sb.append("shape:'");
            sb.append(this.f31402s);
            sb.append("',\n");
        }
        a(sb, "period", this.f31403t);
        a(sb, "offset", this.f31404u);
        a(sb, "phase", this.f31405v);
    }
}
