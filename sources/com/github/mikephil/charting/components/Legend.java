package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Legend extends ComponentBase {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LegendEntry[] f68405h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LegendEntry[] f68404g = new LegendEntry[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f68406i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LegendHorizontalAlignment f68407j = LegendHorizontalAlignment.LEFT;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LegendVerticalAlignment f68408k = LegendVerticalAlignment.BOTTOM;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private LegendOrientation f68409l = LegendOrientation.HORIZONTAL;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f68410m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LegendDirection f68411n = LegendDirection.LEFT_TO_RIGHT;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LegendForm f68412o = LegendForm.SQUARE;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f68413p = 8.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f68414q = 3.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private DashPathEffect f68415r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f68416s = 6.0f;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f68417t = 0.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f68418u = 5.0f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f68419v = 3.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f68420w = 0.95f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f68421x = 0.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f68422y = 0.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f68423z = 0.0f;
    public float A = 0.0f;
    private boolean B = false;
    private List C = new ArrayList(16);
    private List D = new ArrayList(16);
    private List E = new ArrayList(16);

    /* JADX INFO: renamed from: com.github.mikephil.charting.components.Legend$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68424a;

        static {
            int[] iArr = new int[LegendOrientation.values().length];
            f68424a = iArr;
            try {
                iArr[LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68424a[LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.f68399e = Utils.e(10.0f);
        this.f68396b = Utils.e(5.0f);
        this.f68397c = Utils.e(3.0f);
    }

    public float A(Paint paint) {
        float fE = Utils.e(this.f68418u);
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (LegendEntry legendEntry : this.f68404g) {
            float fE2 = Utils.e(Float.isNaN(legendEntry.f68448c) ? this.f68413p : legendEntry.f68448c);
            if (fE2 > f4) {
                f4 = fE2;
            }
            String str = legendEntry.f68446a;
            if (str != null) {
                float fD = Utils.d(paint, str);
                if (fD > f3) {
                    f3 = fD;
                }
            }
        }
        return f3 + f4 + fE;
    }

    public LegendOrientation B() {
        return this.f68409l;
    }

    public float C() {
        return this.f68419v;
    }

    public LegendVerticalAlignment D() {
        return this.f68408k;
    }

    public float E() {
        return this.f68416s;
    }

    public float F() {
        return this.f68417t;
    }

    public boolean G() {
        return this.f68410m;
    }

    public boolean H() {
        return this.f68406i;
    }

    public void I(LegendEntry[] legendEntryArr) {
        this.f68404g = legendEntryArr;
        this.f68406i = true;
    }

    public void J(List list) {
        this.f68404g = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l(android.graphics.Paint r27, com.github.mikephil.charting.utils.ViewPortHandler r28) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.l(android.graphics.Paint, com.github.mikephil.charting.utils.ViewPortHandler):void");
    }

    public List m() {
        return this.D;
    }

    public List n() {
        return this.C;
    }

    public List o() {
        return this.E;
    }

    public LegendDirection p() {
        return this.f68411n;
    }

    public LegendEntry[] q() {
        return this.f68404g;
    }

    public LegendEntry[] r() {
        return this.f68405h;
    }

    public LegendForm s() {
        return this.f68412o;
    }

    public DashPathEffect t() {
        return this.f68415r;
    }

    public float u() {
        return this.f68414q;
    }

    public float v() {
        return this.f68413p;
    }

    public float w() {
        return this.f68418u;
    }

    public LegendHorizontalAlignment x() {
        return this.f68407j;
    }

    public float y() {
        return this.f68420w;
    }

    public float z(Paint paint) {
        float f3 = 0.0f;
        for (LegendEntry legendEntry : this.f68404g) {
            String str = legendEntry.f68446a;
            if (str != null) {
                float fA = Utils.a(paint, str);
                if (fA > f3) {
                    f3 = fA;
                }
            }
        }
        return f3;
    }
}
