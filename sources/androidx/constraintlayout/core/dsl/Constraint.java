package androidx.constraintlayout.core.dsl;

import com.revenuecat.purchases.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Constraint {
    public static final Constraint J = new Constraint("parent");
    static int K = Integer.MIN_VALUE;
    static Map L;
    private int A;
    private int B;
    private int C;
    private int D;
    private float E;
    private float F;
    private String[] G;
    private boolean H;
    private boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f31277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f31278b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f31279c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HAnchor f31280d = new HAnchor(HSide.LEFT);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HAnchor f31281e = new HAnchor(HSide.RIGHT);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private VAnchor f31282f = new VAnchor(VSide.TOP);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private VAnchor f31283g = new VAnchor(VSide.BOTTOM);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HAnchor f31284h = new HAnchor(HSide.START);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HAnchor f31285i = new HAnchor(HSide.END);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VAnchor f31286j = new VAnchor(VSide.BASELINE);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f31287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f31288l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f31289m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f31290n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f31291o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f31292p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31293q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31294r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f31295s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f31296t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f31297u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f31298v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ChainMode f31299w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ChainMode f31300x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Behaviour f31301y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Behaviour f31302z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class Anchor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Side f31303a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31305c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Anchor f31304b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31306d = Integer.MIN_VALUE;

        Anchor(Side side) {
            this.f31303a = side;
        }

        public void a(StringBuilder sb) {
            if (this.f31304b != null) {
                sb.append(this.f31303a.toString().toLowerCase());
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(this);
                sb.append(",\n");
            }
        }

        public String b() {
            return Constraint.this.f31277a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            if (this.f31304b != null) {
                sb.append("'");
                sb.append(this.f31304b.b());
                sb.append("',");
                sb.append("'");
                sb.append(this.f31304b.f31303a.toString().toLowerCase());
                sb.append("'");
            }
            if (this.f31305c != 0) {
                sb.append(",");
                sb.append(this.f31305c);
            }
            if (this.f31306d != Integer.MIN_VALUE) {
                if (this.f31305c == 0) {
                    sb.append(",0,");
                    sb.append(this.f31306d);
                } else {
                    sb.append(",");
                    sb.append(this.f31306d);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    public enum Behaviour {
        SPREAD,
        WRAP,
        PERCENT,
        RATIO,
        f31312f
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ChainMode {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class HAnchor extends Anchor {
        HAnchor(HSide hSide) {
            super(Side.valueOf(hSide.name()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum HSide {
        LEFT,
        RIGHT,
        START,
        END
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Side {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        START,
        END,
        BASELINE
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class VAnchor extends Anchor {
        VAnchor(VSide vSide) {
            super(Side.valueOf(vSide.name()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum VSide {
        TOP,
        BOTTOM,
        BASELINE
    }

    static {
        HashMap map = new HashMap();
        L = map;
        map.put(ChainMode.SPREAD, "spread");
        L.put(ChainMode.SPREAD_INSIDE, "spread_inside");
        L.put(ChainMode.PACKED, "packed");
    }

    public Constraint(String str) {
        int i3 = K;
        this.f31287k = i3;
        this.f31288l = i3;
        this.f31289m = Float.NaN;
        this.f31290n = Float.NaN;
        this.f31291o = null;
        this.f31292p = null;
        this.f31293q = Integer.MIN_VALUE;
        this.f31294r = Float.NaN;
        this.f31295s = Integer.MIN_VALUE;
        this.f31296t = Integer.MIN_VALUE;
        this.f31297u = Float.NaN;
        this.f31298v = Float.NaN;
        this.f31299w = null;
        this.f31300x = null;
        this.f31301y = null;
        this.f31302z = null;
        this.A = i3;
        this.B = i3;
        this.C = i3;
        this.D = i3;
        this.E = Float.NaN;
        this.F = Float.NaN;
        this.G = null;
        this.H = false;
        this.I = false;
        this.f31277a = str;
    }

    protected void b(StringBuilder sb, String str, float f3) {
        if (Float.isNaN(f3)) {
            return;
        }
        sb.append(str);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(f3);
        sb.append(",\n");
    }

    public String c(String[] strArr) {
        StringBuilder sb = new StringBuilder("[");
        int i3 = 0;
        while (i3 < strArr.length) {
            sb.append(i3 == 0 ? "'" : ",'");
            sb.append(strArr[i3]);
            sb.append("'");
            i3++;
        }
        sb.append("]");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f31277a + ":{\n");
        this.f31280d.a(sb);
        this.f31281e.a(sb);
        this.f31282f.a(sb);
        this.f31283g.a(sb);
        this.f31284h.a(sb);
        this.f31285i.a(sb);
        this.f31286j.a(sb);
        if (this.f31287k != K) {
            sb.append("width:");
            sb.append(this.f31287k);
            sb.append(",\n");
        }
        if (this.f31288l != K) {
            sb.append("height:");
            sb.append(this.f31288l);
            sb.append(",\n");
        }
        b(sb, "horizontalBias", this.f31289m);
        b(sb, "verticalBias", this.f31290n);
        if (this.f31291o != null) {
            sb.append("dimensionRatio:'");
            sb.append(this.f31291o);
            sb.append("',\n");
        }
        if (this.f31292p != null && (!Float.isNaN(this.f31294r) || this.f31293q != Integer.MIN_VALUE)) {
            sb.append("circular:['");
            sb.append(this.f31292p);
            sb.append("'");
            if (!Float.isNaN(this.f31294r)) {
                sb.append(",");
                sb.append(this.f31294r);
            }
            if (this.f31293q != Integer.MIN_VALUE) {
                if (Float.isNaN(this.f31294r)) {
                    sb.append(",0,");
                    sb.append(this.f31293q);
                } else {
                    sb.append(",");
                    sb.append(this.f31293q);
                }
            }
            sb.append("],\n");
        }
        b(sb, "verticalWeight", this.f31297u);
        b(sb, "horizontalWeight", this.f31298v);
        if (this.f31299w != null) {
            sb.append("horizontalChainStyle:'");
            sb.append((String) L.get(this.f31299w));
            sb.append("',\n");
        }
        if (this.f31300x != null) {
            sb.append("verticalChainStyle:'");
            sb.append((String) L.get(this.f31300x));
            sb.append("',\n");
        }
        if (this.f31301y != null) {
            int i3 = this.A;
            int i4 = K;
            if (i3 == i4 && this.C == i4) {
                sb.append("width:'");
                sb.append(this.f31301y.toString().toLowerCase());
                sb.append("',\n");
            } else {
                sb.append("width:{value:'");
                sb.append(this.f31301y.toString().toLowerCase());
                sb.append("'");
                if (this.A != K) {
                    sb.append(",max:");
                    sb.append(this.A);
                }
                if (this.C != K) {
                    sb.append(",min:");
                    sb.append(this.C);
                }
                sb.append("},\n");
            }
        }
        if (this.f31302z != null) {
            int i5 = this.B;
            int i6 = K;
            if (i5 == i6 && this.D == i6) {
                sb.append("height:'");
                sb.append(this.f31302z.toString().toLowerCase());
                sb.append("',\n");
            } else {
                sb.append("height:{value:'");
                sb.append(this.f31302z.toString().toLowerCase());
                sb.append("'");
                if (this.B != K) {
                    sb.append(",max:");
                    sb.append(this.B);
                }
                if (this.D != K) {
                    sb.append(",min:");
                    sb.append(this.D);
                }
                sb.append("},\n");
            }
        }
        if (!Double.isNaN(this.E)) {
            sb.append("width:'");
            sb.append((int) this.E);
            sb.append("%',\n");
        }
        if (!Double.isNaN(this.F)) {
            sb.append("height:'");
            sb.append((int) this.F);
            sb.append("%',\n");
        }
        if (this.G != null) {
            sb.append("referenceIds:");
            sb.append(c(this.G));
            sb.append(",\n");
        }
        if (this.H) {
            sb.append("constrainedWidth:");
            sb.append(this.H);
            sb.append(",\n");
        }
        if (this.I) {
            sb.append("constrainedHeight:");
            sb.append(this.I);
            sb.append(",\n");
        }
        sb.append("},\n");
        return sb.toString();
    }
}
