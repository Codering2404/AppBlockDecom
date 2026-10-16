package antonkozyriatskyi.circularprogressindicator;

import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PatternProgressTextAdapter implements CircularProgressIndicator.ProgressTextAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f55301a;

    public PatternProgressTextAdapter(String str) {
        this.f55301a = str;
    }

    @Override // antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator.ProgressTextAdapter
    public String a(double d3) {
        return String.format(this.f55301a, Double.valueOf(d3));
    }
}
