package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Constraint;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Chain extends Helper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Map f31269f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class Anchor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Constraint.Anchor f31270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31272c;

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            if (this.f31270a != null) {
                sb.append("'");
                sb.append(this.f31270a.b());
                sb.append("',");
                sb.append("'");
                sb.append(this.f31270a.f31303a.toString().toLowerCase());
                sb.append("'");
            }
            if (this.f31271b != 0) {
                sb.append(",");
                sb.append(this.f31271b);
            }
            if (this.f31272c != Integer.MIN_VALUE) {
                if (this.f31271b == 0) {
                    sb.append(",0,");
                    sb.append(this.f31272c);
                } else {
                    sb.append(",");
                    sb.append(this.f31272c);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Style {
        PACKED,
        SPREAD,
        SPREAD_INSIDE
    }

    static {
        HashMap map = new HashMap();
        f31269f = map;
        map.put(Style.SPREAD, "'spread'");
        map.put(Style.SPREAD_INSIDE, "'spread_inside'");
        map.put(Style.PACKED, "'packed'");
    }
}
