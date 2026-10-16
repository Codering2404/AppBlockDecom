package androidx.constraintlayout.core.dsl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyPositions extends Keys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f31437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Type f31439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f31440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f31441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f31442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f31443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f31444h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        CARTESIAN,
        SCREEN,
        PATH
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPositions:{\n");
        d(sb, "target", this.f31437a);
        sb.append("frame:");
        sb.append(Arrays.toString(this.f31440d));
        sb.append(",\n");
        if (this.f31439c != null) {
            sb.append("type:'");
            sb.append(this.f31439c);
            sb.append("',\n");
        }
        b(sb, "easing", this.f31438b);
        c(sb, "percentX", this.f31443g);
        c(sb, "percentX", this.f31444h);
        c(sb, "percentWidth", this.f31441e);
        c(sb, "percentHeight", this.f31442f);
        sb.append("},\n");
        return sb.toString();
    }
}
