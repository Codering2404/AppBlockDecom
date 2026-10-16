package androidx.constraintlayout.core.dsl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Ref {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f31502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f31503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f31504d;

    public String toString() {
        String str = this.f31501a;
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = (Float.isNaN(this.f31502b) && Float.isNaN(this.f31503c) && Float.isNaN(this.f31504d)) ? false : true;
        if (z2) {
            sb.append("[");
        }
        sb.append("'");
        sb.append(this.f31501a);
        sb.append("'");
        if (!Float.isNaN(this.f31504d)) {
            sb.append(",");
            sb.append(!Float.isNaN(this.f31502b) ? this.f31502b : 0.0f);
            sb.append(",");
            sb.append(Float.isNaN(this.f31503c) ? 0.0f : this.f31503c);
            sb.append(",");
            sb.append(this.f31504d);
        } else if (!Float.isNaN(this.f31503c)) {
            sb.append(",");
            sb.append(Float.isNaN(this.f31502b) ? 0.0f : this.f31502b);
            sb.append(",");
            sb.append(this.f31503c);
        } else if (!Float.isNaN(this.f31502b)) {
            sb.append(",");
            sb.append(this.f31502b);
        }
        if (z2) {
            sb.append("]");
        }
        sb.append(",");
        return sb.toString();
    }
}
