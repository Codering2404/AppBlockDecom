package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Constraint;
import com.revenuecat.purchases.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Helper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Map f31340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Map f31341e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f31342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected HelperType f31343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Map f31344c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class HelperType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f31345a;

        public String toString() {
            return this.f31345a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        VERTICAL_GUIDELINE,
        HORIZONTAL_GUIDELINE,
        VERTICAL_CHAIN,
        HORIZONTAL_CHAIN,
        BARRIER
    }

    static {
        HashMap map = new HashMap();
        f31340d = map;
        map.put(Constraint.Side.LEFT, "'left'");
        map.put(Constraint.Side.RIGHT, "'right'");
        map.put(Constraint.Side.TOP, "'top'");
        map.put(Constraint.Side.BOTTOM, "'bottom'");
        map.put(Constraint.Side.START, "'start'");
        map.put(Constraint.Side.END, "'end'");
        map.put(Constraint.Side.BASELINE, "'baseline'");
        HashMap map2 = new HashMap();
        f31341e = map2;
        map2.put(Type.VERTICAL_GUIDELINE, "vGuideline");
        map2.put(Type.HORIZONTAL_GUIDELINE, "hGuideline");
        map2.put(Type.VERTICAL_CHAIN, "vChain");
        map2.put(Type.HORIZONTAL_CHAIN, "hChain");
        map2.put(Type.BARRIER, "barrier");
    }

    public void a(Map map, StringBuilder sb) {
        if (map.isEmpty()) {
            return;
        }
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append((String) map.get(str));
            sb.append(",\n");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f31342a + ":{\n");
        if (this.f31343b != null) {
            sb.append("type:'");
            sb.append(this.f31343b.toString());
            sb.append("',\n");
        }
        Map map = this.f31344c;
        if (map != null) {
            a(map, sb);
        }
        sb.append("},\n");
        return sb.toString();
    }
}
