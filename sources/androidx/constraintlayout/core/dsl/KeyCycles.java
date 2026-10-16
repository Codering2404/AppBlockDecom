package androidx.constraintlayout.core.dsl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyCycles extends KeyAttributes {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Wave f31413s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float[] f31414t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float[] f31415u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float[] f31416v;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Wave {
        SIN,
        SQUARE,
        TRIANGLE,
        SAW,
        REVERSE_SAW,
        COS
    }

    @Override // androidx.constraintlayout.core.dsl.KeyAttributes
    protected void f(StringBuilder sb) {
        super.f(sb);
        if (this.f31413s != null) {
            sb.append("shape:'");
            sb.append(this.f31413s);
            sb.append("',\n");
        }
        c(sb, "period", this.f31414t);
        c(sb, "offset", this.f31415u);
        c(sb, "phase", this.f31416v);
    }
}
