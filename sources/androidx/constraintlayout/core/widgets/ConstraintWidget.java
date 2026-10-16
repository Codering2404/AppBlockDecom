package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConstraintWidget {
    public static float U0 = 0.5f;
    public int A;
    int A0;
    public float B;
    int B0;
    public int C;
    boolean C0;
    public int D;
    boolean D0;
    public float E;
    boolean E0;
    public boolean F;
    boolean F0;
    public boolean G;
    boolean G0;
    int H;
    boolean H0;
    float I;
    boolean I0;
    private int[] J;
    int J0;
    public float K;
    int K0;
    private boolean L;
    boolean L0;
    private boolean M;
    boolean M0;
    private boolean N;
    public float[] N0;
    private int O;
    protected ConstraintWidget[] O0;
    private int P;
    protected ConstraintWidget[] P0;
    public ConstraintAnchor Q;
    ConstraintWidget Q0;
    public ConstraintAnchor R;
    ConstraintWidget R0;
    public ConstraintAnchor S;
    public int S0;
    public ConstraintAnchor T;
    public int T0;
    public ConstraintAnchor U;
    ConstraintAnchor V;
    ConstraintAnchor W;
    public ConstraintAnchor X;
    public ConstraintAnchor[] Y;
    protected ArrayList Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f32271a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean[] f32272a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WidgetRun[] f32273b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public DimensionBehaviour[] f32274b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ChainRun f32275c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ConstraintWidget f32276c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ChainRun f32277d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    int f32278d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HorizontalWidgetRun f32279e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    int f32280e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VerticalWidgetRun f32281f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f32282f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f32283g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected int f32284g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f32285h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    protected int f32286h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f32287i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    protected int f32288i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f32289j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    int f32290j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f32291k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    int f32292k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f32293l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    protected int f32294l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f32295m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    protected int f32296m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WidgetFrame f32297n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    int f32298n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f32299o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected int f32300o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f32301p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    protected int f32302p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f32303q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    float f32304q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f32305r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    float f32306r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f32307s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private Object f32308s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f32309t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f32310t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f32311u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f32312u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f32313v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f32314v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f32315w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private String f32316w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f32317x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private String f32318x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f32319y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    int f32320y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f32321z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    int f32322z0;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32323a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f32323a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32323a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32323a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32323a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32323a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32323a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32323a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32323a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32323a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.f32271a = false;
        this.f32273b = new WidgetRun[2];
        this.f32279e = null;
        this.f32281f = null;
        this.f32283g = new boolean[]{true, true};
        this.f32285h = false;
        this.f32287i = true;
        this.f32289j = false;
        this.f32291k = true;
        this.f32293l = -1;
        this.f32295m = -1;
        this.f32297n = new WidgetFrame(this);
        this.f32301p = false;
        this.f32303q = false;
        this.f32305r = false;
        this.f32307s = false;
        this.f32309t = -1;
        this.f32311u = -1;
        this.f32313v = 0;
        this.f32315w = 0;
        this.f32317x = 0;
        this.f32319y = new int[2];
        this.f32321z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER};
        this.K = Float.NaN;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList();
        this.f32272a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f32274b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f32276c0 = null;
        this.f32278d0 = 0;
        this.f32280e0 = 0;
        this.f32282f0 = 0.0f;
        this.f32284g0 = -1;
        this.f32286h0 = 0;
        this.f32288i0 = 0;
        this.f32290j0 = 0;
        this.f32292k0 = 0;
        this.f32294l0 = 0;
        this.f32296m0 = 0;
        this.f32298n0 = 0;
        float f3 = U0;
        this.f32304q0 = f3;
        this.f32306r0 = f3;
        this.f32310t0 = 0;
        this.f32312u0 = 0;
        this.f32314v0 = false;
        this.f32316w0 = null;
        this.f32318x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    private void C0(StringBuilder sb, String str, float f3, float f4) {
        if (f3 == f4) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f3);
        sb.append(",\n");
    }

    private void D0(StringBuilder sb, String str, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i3);
        sb.append(",\n");
    }

    private void E0(StringBuilder sb, String str, String str2, String str3) {
        if (str3.equals(str2)) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(str2);
        sb.append(",\n");
    }

    private void F0(StringBuilder sb, String str, float f3, int i3) {
        if (f3 == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f3);
        sb.append(",");
        sb.append(i3);
        sb.append("");
        sb.append("],\n");
    }

    private void S(StringBuilder sb, String str, int i3, int i4, int i5, int i6, int i7, int i8, float f3, DimensionBehaviour dimensionBehaviour, float f4) {
        sb.append(str);
        sb.append(" :  {\n");
        E0(sb, "      behavior", dimensionBehaviour.toString(), DimensionBehaviour.FIXED.toString());
        D0(sb, "      size", i3, 0);
        D0(sb, "      min", i4, 0);
        D0(sb, "      max", i5, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        D0(sb, "      matchMin", i7, 0);
        D0(sb, "      matchDef", i8, 0);
        C0(sb, "      matchPercent", f3, 1.0f);
        sb.append("    },\n");
    }

    private void T(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f32257f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.f32257f);
        sb.append("'");
        if (constraintAnchor.f32259h != Integer.MIN_VALUE || constraintAnchor.f32258g != 0) {
            sb.append(",");
            sb.append(constraintAnchor.f32258g);
            if (constraintAnchor.f32259h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.f32259h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    private void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    /* JADX WARN: Removed duplicated region for block: B:306:0x0498 A[PHI: r7
      0x0498: PHI (r7v15 int) = (r7v14 int), (r7v19 int), (r7v19 int), (r7v19 int) binds: [B:299:0x0488, B:301:0x048e, B:302:0x0490, B:304:0x0494] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0542  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(androidx.constraintlayout.core.LinearSystem r29, boolean r30, boolean r31, boolean r32, boolean r33, androidx.constraintlayout.core.SolverVariable r34, androidx.constraintlayout.core.SolverVariable r35, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r36, boolean r37, androidx.constraintlayout.core.widgets.ConstraintAnchor r38, androidx.constraintlayout.core.widgets.ConstraintAnchor r39, int r40, int r41, int r42, int r43, float r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, int r50, int r51, int r52, int r53, float r54, boolean r55) {
        /*
            Method dump skipped, instruction units count: 1358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    private boolean j0(int i3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i4 = i3 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.Y;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i4];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f32257f;
        return (constraintAnchor4 == null || constraintAnchor4.f32257f == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i4 + 1]).f32257f) == null || constraintAnchor2.f32257f != constraintAnchor) ? false : true;
    }

    public float A() {
        return this.f32304q0;
    }

    public void A0() {
        this.f32301p = false;
        this.f32303q = false;
        this.f32305r = false;
        this.f32307s = false;
        int size = this.Z.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ConstraintAnchor) this.Z.get(i3)).r();
        }
    }

    public int B() {
        return this.J0;
    }

    public void B0(Cache cache) {
        this.Q.s(cache);
        this.R.s(cache);
        this.S.s(cache);
        this.T.s(cache);
        this.U.s(cache);
        this.X.s(cache);
        this.V.s(cache);
        this.W.s(cache);
    }

    public DimensionBehaviour C() {
        return this.f32274b0[0];
    }

    public int D() {
        ConstraintAnchor constraintAnchor = this.Q;
        int i3 = constraintAnchor != null ? constraintAnchor.f32258g : 0;
        ConstraintAnchor constraintAnchor2 = this.S;
        return constraintAnchor2 != null ? i3 + constraintAnchor2.f32258g : i3;
    }

    public int E() {
        return this.O;
    }

    public int F() {
        return this.P;
    }

    public int G() {
        return b0();
    }

    public void G0(boolean z2) {
        this.f32314v0 = z2;
    }

    public int H(int i3) {
        if (i3 == 0) {
            return a0();
        }
        if (i3 == 1) {
            return z();
        }
        return 0;
    }

    public void H0(int i3) {
        this.f32298n0 = i3;
        this.L = i3 > 0;
    }

    public int I() {
        return this.J[1];
    }

    public void I0(Object obj) {
        this.f32308s0 = obj;
    }

    public int J() {
        return this.J[0];
    }

    public void J0(String str) {
        this.f32316w0 = str;
    }

    public int K() {
        return this.f32302p0;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086 A[PHI: r0
      0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void K0(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L90
            int r1 = r9.length()
            if (r1 != 0) goto Lb
            goto L90
        Lb:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L39
            int r6 = r1 + (-1)
            if (r2 >= r6) goto L39
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L2b
            goto L36
        L2b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L35
            r3 = r4
            goto L36
        L35:
            r3 = r5
        L36:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L39:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L77
            int r1 = r1 - r4
            if (r2 >= r1) goto L77
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L86
            int r2 = r9.length()
            if (r2 <= 0) goto L86
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L86
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L86
            if (r5 != r4) goto L71
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L71:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L77:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L86:
            r9 = r0
        L87:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L8f
            r8.f32282f0 = r9
            r8.f32284g0 = r5
        L8f:
            return
        L90:
            r8.f32282f0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.K0(java.lang.String):void");
    }

    public int L() {
        return this.f32300o0;
    }

    public void L0(int i3) {
        if (this.L) {
            int i4 = i3 - this.f32298n0;
            int i5 = this.f32280e0 + i4;
            this.f32288i0 = i4;
            this.R.t(i4);
            this.T.t(i5);
            this.U.t(i3);
            this.f32303q = true;
        }
    }

    public ConstraintWidget M(int i3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i3 != 0) {
            if (i3 == 1 && (constraintAnchor2 = (constraintAnchor = this.T).f32257f) != null && constraintAnchor2.f32257f == constraintAnchor) {
                return constraintAnchor2.f32255d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f32257f;
        if (constraintAnchor4 == null || constraintAnchor4.f32257f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f32255d;
    }

    public void M0(int i3, int i4) {
        if (this.f32301p) {
            return;
        }
        this.Q.t(i3);
        this.S.t(i4);
        this.f32286h0 = i3;
        this.f32278d0 = i4 - i3;
        this.f32301p = true;
    }

    public ConstraintWidget N() {
        return this.f32276c0;
    }

    public void N0(int i3) {
        this.Q.t(i3);
        this.f32286h0 = i3;
    }

    public ConstraintWidget O(int i3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i3 != 0) {
            if (i3 == 1 && (constraintAnchor2 = (constraintAnchor = this.R).f32257f) != null && constraintAnchor2.f32257f == constraintAnchor) {
                return constraintAnchor2.f32255d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f32257f;
        if (constraintAnchor4 == null || constraintAnchor4.f32257f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f32255d;
    }

    public void O0(int i3) {
        this.R.t(i3);
        this.f32288i0 = i3;
    }

    public int P() {
        return b0() + this.f32278d0;
    }

    public void P0(int i3, int i4) {
        if (this.f32303q) {
            return;
        }
        this.R.t(i3);
        this.T.t(i4);
        this.f32288i0 = i3;
        this.f32280e0 = i4 - i3;
        if (this.L) {
            this.U.t(i3 + this.f32298n0);
        }
        this.f32303q = true;
    }

    public WidgetRun Q(int i3) {
        if (i3 == 0) {
            return this.f32279e;
        }
        if (i3 == 1) {
            return this.f32281f;
        }
        return null;
    }

    public void Q0(int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i5 - i3;
        int i10 = i6 - i4;
        this.f32286h0 = i3;
        this.f32288i0 = i4;
        if (this.f32312u0 == 8) {
            this.f32278d0 = 0;
            this.f32280e0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.f32274b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i9 < (i8 = this.f32278d0)) {
            i9 = i8;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i10 < (i7 = this.f32280e0)) {
            i10 = i7;
        }
        this.f32278d0 = i9;
        this.f32280e0 = i10;
        int i11 = this.f32302p0;
        if (i10 < i11) {
            this.f32280e0 = i11;
        }
        int i12 = this.f32300o0;
        if (i9 < i12) {
            this.f32278d0 = i12;
        }
        int i13 = this.A;
        if (i13 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f32278d0 = Math.min(this.f32278d0, i13);
        }
        int i14 = this.D;
        if (i14 > 0 && this.f32274b0[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f32280e0 = Math.min(this.f32280e0, i14);
        }
        int i15 = this.f32278d0;
        if (i9 != i15) {
            this.f32293l = i15;
        }
        int i16 = this.f32280e0;
        if (i10 != i16) {
            this.f32295m = i16;
        }
    }

    public void R(StringBuilder sb) {
        sb.append("  " + this.f32299o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.f32278d0);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.f32280e0);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f32286h0);
        sb.append("\n");
        sb.append("    actualTop:" + this.f32288i0);
        sb.append("\n");
        T(sb, ViewHierarchyConstants.DIMENSION_LEFT_KEY, this.Q);
        T(sb, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.R);
        T(sb, "right", this.S);
        T(sb, "bottom", this.T);
        T(sb, "baseline", this.U);
        T(sb, "centerX", this.V);
        T(sb, "centerY", this.W);
        S(sb, "    width", this.f32278d0, this.f32300o0, this.J[0], this.f32293l, this.f32321z, this.f32315w, this.B, this.f32274b0[0], this.N0[0]);
        S(sb, "    height", this.f32280e0, this.f32302p0, this.J[1], this.f32295m, this.C, this.f32317x, this.E, this.f32274b0[1], this.N0[1]);
        F0(sb, "    dimensionRatio", this.f32282f0, this.f32284g0);
        C0(sb, "    horizontalBias", this.f32304q0, U0);
        C0(sb, "    verticalBias", this.f32306r0, U0);
        D0(sb, "    horizontalChainStyle", this.J0, 0);
        D0(sb, "    verticalChainStyle", this.K0, 0);
        sb.append("  }");
    }

    public void R0(boolean z2) {
        this.L = z2;
    }

    public void S0(int i3) {
        this.f32280e0 = i3;
        int i4 = this.f32302p0;
        if (i3 < i4) {
            this.f32280e0 = i4;
        }
    }

    public void T0(float f3) {
        this.f32304q0 = f3;
    }

    public int U() {
        return c0();
    }

    public void U0(int i3) {
        this.J0 = i3;
    }

    public float V() {
        return this.f32306r0;
    }

    public void V0(int i3, int i4) {
        this.f32286h0 = i3;
        int i5 = i4 - i3;
        this.f32278d0 = i5;
        int i6 = this.f32300o0;
        if (i5 < i6) {
            this.f32278d0 = i6;
        }
    }

    public int W() {
        return this.K0;
    }

    public void W0(DimensionBehaviour dimensionBehaviour) {
        this.f32274b0[0] = dimensionBehaviour;
    }

    public DimensionBehaviour X() {
        return this.f32274b0[1];
    }

    public void X0(int i3, int i4, int i5, float f3) {
        this.f32315w = i3;
        this.f32321z = i4;
        if (i5 == Integer.MAX_VALUE) {
            i5 = 0;
        }
        this.A = i5;
        this.B = f3;
        if (f3 <= 0.0f || f3 >= 1.0f || i3 != 0) {
            return;
        }
        this.f32315w = 2;
    }

    public int Y() {
        int i3 = this.Q != null ? this.R.f32258g : 0;
        return this.S != null ? i3 + this.T.f32258g : i3;
    }

    public void Y0(float f3) {
        this.N0[0] = f3;
    }

    public int Z() {
        return this.f32312u0;
    }

    protected void Z0(int i3, boolean z2) {
        this.f32272a0[i3] = z2;
    }

    public int a0() {
        if (this.f32312u0 == 8) {
            return 0;
        }
        return this.f32278d0;
    }

    public void a1(boolean z2) {
        this.M = z2;
    }

    public int b0() {
        ConstraintWidget constraintWidget = this.f32276c0;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.f32286h0 : ((ConstraintWidgetContainer) constraintWidget).f32332d1 + this.f32286h0;
    }

    public void b1(boolean z2) {
        this.N = z2;
    }

    public int c0() {
        ConstraintWidget constraintWidget = this.f32276c0;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.f32288i0 : ((ConstraintWidgetContainer) constraintWidget).f32333e1 + this.f32288i0;
    }

    public void c1(int i3, int i4) {
        this.O = i3;
        this.P = i4;
        f1(false);
    }

    public boolean d0() {
        return this.L;
    }

    public void d1(int i3) {
        this.J[1] = i3;
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet hashSet, int i3, boolean z2) {
        if (z2) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.a(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            g(linearSystem, constraintWidgetContainer.c2(64));
        }
        if (i3 == 0) {
            HashSet hashSetD = this.Q.d();
            if (hashSetD != null) {
                Iterator it = hashSetD.iterator();
                while (it.hasNext()) {
                    ((ConstraintAnchor) it.next()).f32255d.e(constraintWidgetContainer, linearSystem, hashSet, i3, true);
                }
            }
            HashSet hashSetD2 = this.S.d();
            if (hashSetD2 != null) {
                Iterator it2 = hashSetD2.iterator();
                while (it2.hasNext()) {
                    ((ConstraintAnchor) it2.next()).f32255d.e(constraintWidgetContainer, linearSystem, hashSet, i3, true);
                }
                return;
            }
            return;
        }
        HashSet hashSetD3 = this.R.d();
        if (hashSetD3 != null) {
            Iterator it3 = hashSetD3.iterator();
            while (it3.hasNext()) {
                ((ConstraintAnchor) it3.next()).f32255d.e(constraintWidgetContainer, linearSystem, hashSet, i3, true);
            }
        }
        HashSet hashSetD4 = this.T.d();
        if (hashSetD4 != null) {
            Iterator it4 = hashSetD4.iterator();
            while (it4.hasNext()) {
                ((ConstraintAnchor) it4.next()).f32255d.e(constraintWidgetContainer, linearSystem, hashSet, i3, true);
            }
        }
        HashSet hashSetD5 = this.U.d();
        if (hashSetD5 != null) {
            Iterator it5 = hashSetD5.iterator();
            while (it5.hasNext()) {
                ((ConstraintAnchor) it5.next()).f32255d.e(constraintWidgetContainer, linearSystem, hashSet, i3, true);
            }
        }
    }

    public boolean e0(int i3) {
        if (i3 == 0) {
            return (this.Q.f32257f != null ? 1 : 0) + (this.S.f32257f != null ? 1 : 0) < 2;
        }
        return ((this.R.f32257f != null ? 1 : 0) + (this.T.f32257f != null ? 1 : 0)) + (this.U.f32257f != null ? 1 : 0) < 2;
    }

    public void e1(int i3) {
        this.J[0] = i3;
    }

    boolean f() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public boolean f0() {
        int size = this.Z.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((ConstraintAnchor) this.Z.get(i3)).m()) {
                return true;
            }
        }
        return false;
    }

    public void f1(boolean z2) {
        this.f32287i = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:325:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(androidx.constraintlayout.core.LinearSystem r51, boolean r52) {
        /*
            Method dump skipped, instruction units count: 1512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean g0() {
        return (this.f32293l == -1 && this.f32295m == -1) ? false : true;
    }

    public void g1(int i3) {
        if (i3 < 0) {
            this.f32302p0 = 0;
        } else {
            this.f32302p0 = i3;
        }
    }

    public boolean h() {
        return this.f32312u0 != 8;
    }

    public boolean h0(int i3, int i4) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i3 == 0) {
            ConstraintAnchor constraintAnchor3 = this.Q.f32257f;
            return constraintAnchor3 != null && constraintAnchor3.n() && (constraintAnchor2 = this.S.f32257f) != null && constraintAnchor2.n() && (this.S.f32257f.e() - this.S.f()) - (this.Q.f32257f.e() + this.Q.f()) >= i4;
        }
        ConstraintAnchor constraintAnchor4 = this.R.f32257f;
        if (constraintAnchor4 != null && constraintAnchor4.n() && (constraintAnchor = this.T.f32257f) != null && constraintAnchor.n() && (this.T.f32257f.e() - this.T.f()) - (this.R.f32257f.e() + this.R.f()) >= i4) {
            return true;
        }
        return false;
    }

    public void h1(int i3) {
        if (i3 < 0) {
            this.f32300o0 = 0;
        } else {
            this.f32300o0 = i3;
        }
    }

    public void i0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i3, int i4) {
        q(type).b(constraintWidget.q(type2), i3, i4, true);
    }

    public void i1(int i3, int i4) {
        this.f32286h0 = i3;
        this.f32288i0 = i4;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        k(type, constraintWidget, type2, 0);
    }

    public void j1(ConstraintWidget constraintWidget) {
        this.f32276c0 = constraintWidget;
    }

    public void k(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i3) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z2;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 != type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                if (type2 == type6 || type2 == ConstraintAnchor.Type.RIGHT) {
                    k(type6, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.TOP;
                if (type2 == type7 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    k(type7, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                return;
            }
            ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor constraintAnchorQ = q(type8);
            ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor constraintAnchorQ2 = q(type9);
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor constraintAnchorQ3 = q(type10);
            ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor constraintAnchorQ4 = q(type11);
            boolean z3 = true;
            if ((constraintAnchorQ == null || !constraintAnchorQ.o()) && (constraintAnchorQ2 == null || !constraintAnchorQ2.o())) {
                k(type8, constraintWidget, type8, 0);
                k(type9, constraintWidget, type9, 0);
                z2 = true;
            } else {
                z2 = false;
            }
            if ((constraintAnchorQ3 == null || !constraintAnchorQ3.o()) && (constraintAnchorQ4 == null || !constraintAnchorQ4.o())) {
                k(type10, constraintWidget, type10, 0);
                k(type11, constraintWidget, type11, 0);
            } else {
                z3 = false;
            }
            if (z2 && z3) {
                q(type5).a(constraintWidget.q(type5), 0);
                return;
            }
            if (z2) {
                ConstraintAnchor.Type type12 = ConstraintAnchor.Type.CENTER_X;
                q(type12).a(constraintWidget.q(type12), 0);
                return;
            } else {
                if (z3) {
                    ConstraintAnchor.Type type13 = ConstraintAnchor.Type.CENTER_Y;
                    q(type13).a(constraintWidget.q(type13), 0);
                    return;
                }
                return;
            }
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor constraintAnchorQ5 = q(type4);
            ConstraintAnchor constraintAnchorQ6 = constraintWidget.q(type2);
            ConstraintAnchor constraintAnchorQ7 = q(ConstraintAnchor.Type.RIGHT);
            constraintAnchorQ5.a(constraintAnchorQ6, 0);
            constraintAnchorQ7.a(constraintAnchorQ6, 0);
            q(type14).a(constraintAnchorQ6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor constraintAnchorQ8 = constraintWidget.q(type2);
            q(type3).a(constraintAnchorQ8, 0);
            q(ConstraintAnchor.Type.BOTTOM).a(constraintAnchorQ8, 0);
            q(type15).a(constraintAnchorQ8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            q(type16).a(constraintWidget.q(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            q(type17).a(constraintWidget.q(type17), 0);
            q(type14).a(constraintWidget.q(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            q(type18).a(constraintWidget.q(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            q(type19).a(constraintWidget.q(type19), 0);
            q(type15).a(constraintWidget.q(type2), 0);
            return;
        }
        ConstraintAnchor constraintAnchorQ9 = q(type);
        ConstraintAnchor constraintAnchorQ10 = constraintWidget.q(type2);
        if (constraintAnchorQ9.p(constraintAnchorQ10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor constraintAnchorQ11 = q(ConstraintAnchor.Type.TOP);
                ConstraintAnchor constraintAnchorQ12 = q(ConstraintAnchor.Type.BOTTOM);
                if (constraintAnchorQ11 != null) {
                    constraintAnchorQ11.q();
                }
                if (constraintAnchorQ12 != null) {
                    constraintAnchorQ12.q();
                }
            } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                ConstraintAnchor constraintAnchorQ13 = q(type20);
                if (constraintAnchorQ13 != null) {
                    constraintAnchorQ13.q();
                }
                ConstraintAnchor constraintAnchorQ14 = q(type5);
                if (constraintAnchorQ14.j() != constraintAnchorQ10) {
                    constraintAnchorQ14.q();
                }
                ConstraintAnchor constraintAnchorG = q(type).g();
                ConstraintAnchor constraintAnchorQ15 = q(type15);
                if (constraintAnchorQ15.o()) {
                    constraintAnchorG.q();
                    constraintAnchorQ15.q();
                }
            } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor constraintAnchorQ16 = q(type5);
                if (constraintAnchorQ16.j() != constraintAnchorQ10) {
                    constraintAnchorQ16.q();
                }
                ConstraintAnchor constraintAnchorG2 = q(type).g();
                ConstraintAnchor constraintAnchorQ17 = q(type14);
                if (constraintAnchorQ17.o()) {
                    constraintAnchorG2.q();
                    constraintAnchorQ17.q();
                }
            }
            constraintAnchorQ9.a(constraintAnchorQ10, i3);
        }
    }

    public boolean k0() {
        return this.f32305r;
    }

    public void k1(float f3) {
        this.f32306r0 = f3;
    }

    public void l(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i3) {
        if (constraintAnchor.h() == this) {
            k(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i3);
        }
    }

    public boolean l0(int i3) {
        return this.f32272a0[i3];
    }

    public void l1(int i3) {
        this.K0 = i3;
    }

    public void m(ConstraintWidget constraintWidget, float f3, int i3) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        i0(type, constraintWidget, type, i3, 0);
        this.K = f3;
    }

    public boolean m0() {
        ConstraintAnchor constraintAnchor = this.Q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f32257f;
        if (constraintAnchor2 != null && constraintAnchor2.f32257f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f32257f;
        return constraintAnchor4 != null && constraintAnchor4.f32257f == constraintAnchor3;
    }

    public void m1(int i3, int i4) {
        this.f32288i0 = i3;
        int i5 = i4 - i3;
        this.f32280e0 = i5;
        int i6 = this.f32302p0;
        if (i5 < i6) {
            this.f32280e0 = i6;
        }
    }

    public void n(ConstraintWidget constraintWidget, HashMap map) {
        this.f32309t = constraintWidget.f32309t;
        this.f32311u = constraintWidget.f32311u;
        this.f32315w = constraintWidget.f32315w;
        this.f32317x = constraintWidget.f32317x;
        int[] iArr = this.f32319y;
        int[] iArr2 = constraintWidget.f32319y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f32321z = constraintWidget.f32321z;
        this.A = constraintWidget.A;
        this.C = constraintWidget.C;
        this.D = constraintWidget.D;
        this.E = constraintWidget.E;
        this.F = constraintWidget.F;
        this.G = constraintWidget.G;
        this.H = constraintWidget.H;
        this.I = constraintWidget.I;
        int[] iArr3 = constraintWidget.J;
        this.J = Arrays.copyOf(iArr3, iArr3.length);
        this.K = constraintWidget.K;
        this.L = constraintWidget.L;
        this.M = constraintWidget.M;
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f32274b0 = (DimensionBehaviour[]) Arrays.copyOf(this.f32274b0, 2);
        this.f32276c0 = this.f32276c0 == null ? null : (ConstraintWidget) map.get(constraintWidget.f32276c0);
        this.f32278d0 = constraintWidget.f32278d0;
        this.f32280e0 = constraintWidget.f32280e0;
        this.f32282f0 = constraintWidget.f32282f0;
        this.f32284g0 = constraintWidget.f32284g0;
        this.f32286h0 = constraintWidget.f32286h0;
        this.f32288i0 = constraintWidget.f32288i0;
        this.f32290j0 = constraintWidget.f32290j0;
        this.f32292k0 = constraintWidget.f32292k0;
        this.f32294l0 = constraintWidget.f32294l0;
        this.f32296m0 = constraintWidget.f32296m0;
        this.f32298n0 = constraintWidget.f32298n0;
        this.f32300o0 = constraintWidget.f32300o0;
        this.f32302p0 = constraintWidget.f32302p0;
        this.f32304q0 = constraintWidget.f32304q0;
        this.f32306r0 = constraintWidget.f32306r0;
        this.f32308s0 = constraintWidget.f32308s0;
        this.f32310t0 = constraintWidget.f32310t0;
        this.f32312u0 = constraintWidget.f32312u0;
        this.f32314v0 = constraintWidget.f32314v0;
        this.f32316w0 = constraintWidget.f32316w0;
        this.f32318x0 = constraintWidget.f32318x0;
        this.f32320y0 = constraintWidget.f32320y0;
        this.f32322z0 = constraintWidget.f32322z0;
        this.A0 = constraintWidget.A0;
        this.B0 = constraintWidget.B0;
        this.C0 = constraintWidget.C0;
        this.D0 = constraintWidget.D0;
        this.E0 = constraintWidget.E0;
        this.F0 = constraintWidget.F0;
        this.G0 = constraintWidget.G0;
        this.H0 = constraintWidget.H0;
        this.J0 = constraintWidget.J0;
        this.K0 = constraintWidget.K0;
        this.L0 = constraintWidget.L0;
        this.M0 = constraintWidget.M0;
        float[] fArr = this.N0;
        float[] fArr2 = constraintWidget.N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.O0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.O0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.P0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.P0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.Q0;
        this.Q0 = constraintWidget2 == null ? null : (ConstraintWidget) map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.R0;
        this.R0 = constraintWidget3 != null ? (ConstraintWidget) map.get(constraintWidget3) : null;
    }

    public boolean n0() {
        return this.M;
    }

    public void n1(DimensionBehaviour dimensionBehaviour) {
        this.f32274b0[1] = dimensionBehaviour;
    }

    public void o(LinearSystem linearSystem) {
        linearSystem.q(this.Q);
        linearSystem.q(this.R);
        linearSystem.q(this.S);
        linearSystem.q(this.T);
        if (this.f32298n0 > 0) {
            linearSystem.q(this.U);
        }
    }

    public boolean o0() {
        ConstraintAnchor constraintAnchor = this.R;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f32257f;
        if (constraintAnchor2 != null && constraintAnchor2.f32257f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.T;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f32257f;
        return constraintAnchor4 != null && constraintAnchor4.f32257f == constraintAnchor3;
    }

    public void o1(int i3, int i4, int i5, float f3) {
        this.f32317x = i3;
        this.C = i4;
        if (i5 == Integer.MAX_VALUE) {
            i5 = 0;
        }
        this.D = i5;
        this.E = f3;
        if (f3 <= 0.0f || f3 >= 1.0f || i3 != 0) {
            return;
        }
        this.f32317x = 2;
    }

    public void p() {
        if (this.f32279e == null) {
            this.f32279e = new HorizontalWidgetRun(this);
        }
        if (this.f32281f == null) {
            this.f32281f = new VerticalWidgetRun(this);
        }
    }

    public boolean p0() {
        return this.N;
    }

    public void p1(float f3) {
        this.N0[1] = f3;
    }

    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f32323a[type.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean q0() {
        return this.f32287i && this.f32312u0 != 8;
    }

    public void q1(int i3) {
        this.f32312u0 = i3;
    }

    public int r() {
        return this.f32298n0;
    }

    public boolean r0() {
        if (this.f32301p) {
            return true;
        }
        return this.Q.n() && this.S.n();
    }

    public void r1(int i3) {
        this.f32278d0 = i3;
        int i4 = this.f32300o0;
        if (i3 < i4) {
            this.f32278d0 = i4;
        }
    }

    public float s(int i3) {
        if (i3 == 0) {
            return this.f32304q0;
        }
        if (i3 == 1) {
            return this.f32306r0;
        }
        return -1.0f;
    }

    public boolean s0() {
        if (this.f32303q) {
            return true;
        }
        return this.R.n() && this.T.n();
    }

    public void s1(int i3) {
        if (i3 < 0 || i3 > 3) {
            return;
        }
        this.f32313v = i3;
    }

    public int t() {
        return c0() + this.f32280e0;
    }

    public boolean t0() {
        return this.f32307s;
    }

    public void t1(int i3) {
        this.f32286h0 = i3;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f32318x0 != null) {
            str = "type: " + this.f32318x0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f32316w0 != null) {
            str2 = "id: " + this.f32316w0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f32286h0);
        sb.append(", ");
        sb.append(this.f32288i0);
        sb.append(") - (");
        sb.append(this.f32278d0);
        sb.append(" x ");
        sb.append(this.f32280e0);
        sb.append(")");
        return sb.toString();
    }

    public Object u() {
        return this.f32308s0;
    }

    public void u0() {
        this.f32305r = true;
    }

    public void u1(int i3) {
        this.f32288i0 = i3;
    }

    public String v() {
        return this.f32316w0;
    }

    public void v0() {
        this.f32307s = true;
    }

    public void v1(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.H == -1) {
            if (z4 && !z5) {
                this.H = 0;
            } else if (!z4 && z5) {
                this.H = 1;
                if (this.f32284g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.o() || !this.T.o())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.o() || !this.S.o())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.o() || !this.T.o() || !this.Q.o() || !this.S.o())) {
            if (this.R.o() && this.T.o()) {
                this.H = 0;
            } else if (this.Q.o() && this.S.o()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i3 = this.f32321z;
            if (i3 > 0 && this.C == 0) {
                this.H = 0;
            } else {
                if (i3 != 0 || this.C <= 0) {
                    return;
                }
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    public DimensionBehaviour w(int i3) {
        if (i3 == 0) {
            return C();
        }
        if (i3 == 1) {
            return X();
        }
        return null;
    }

    public boolean w0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.f32274b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void w1(boolean z2, boolean z3) {
        int i3;
        int i4;
        boolean zK = z2 & this.f32279e.k();
        boolean zK2 = z3 & this.f32281f.k();
        HorizontalWidgetRun horizontalWidgetRun = this.f32279e;
        int i5 = horizontalWidgetRun.f32490h.f32437g;
        VerticalWidgetRun verticalWidgetRun = this.f32281f;
        int i6 = verticalWidgetRun.f32490h.f32437g;
        int i7 = horizontalWidgetRun.f32491i.f32437g;
        int i8 = verticalWidgetRun.f32491i.f32437g;
        int i9 = i8 - i6;
        if (i7 - i5 < 0 || i9 < 0 || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE) {
            i7 = 0;
            i5 = 0;
            i8 = 0;
            i6 = 0;
        }
        int i10 = i7 - i5;
        int i11 = i8 - i6;
        if (zK) {
            this.f32286h0 = i5;
        }
        if (zK2) {
            this.f32288i0 = i6;
        }
        if (this.f32312u0 == 8) {
            this.f32278d0 = 0;
            this.f32280e0 = 0;
            return;
        }
        if (zK) {
            if (this.f32274b0[0] == DimensionBehaviour.FIXED && i10 < (i4 = this.f32278d0)) {
                i10 = i4;
            }
            this.f32278d0 = i10;
            int i12 = this.f32300o0;
            if (i10 < i12) {
                this.f32278d0 = i12;
            }
        }
        if (zK2) {
            if (this.f32274b0[1] == DimensionBehaviour.FIXED && i11 < (i3 = this.f32280e0)) {
                i11 = i3;
            }
            this.f32280e0 = i11;
            int i13 = this.f32302p0;
            if (i11 < i13) {
                this.f32280e0 = i13;
            }
        }
    }

    public float x() {
        return this.f32282f0;
    }

    public void x0() {
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f32276c0 = null;
        this.K = Float.NaN;
        this.f32278d0 = 0;
        this.f32280e0 = 0;
        this.f32282f0 = 0.0f;
        this.f32284g0 = -1;
        this.f32286h0 = 0;
        this.f32288i0 = 0;
        this.f32294l0 = 0;
        this.f32296m0 = 0;
        this.f32298n0 = 0;
        this.f32300o0 = 0;
        this.f32302p0 = 0;
        float f3 = U0;
        this.f32304q0 = f3;
        this.f32306r0 = f3;
        DimensionBehaviour[] dimensionBehaviourArr = this.f32274b0;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f32308s0 = null;
        this.f32310t0 = 0;
        this.f32312u0 = 0;
        this.f32318x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f32309t = -1;
        this.f32311u = -1;
        int[] iArr = this.J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f32315w = 0;
        this.f32317x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.D = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f32321z = 0;
        this.C = 0;
        this.f32285h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.f32283g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.f32272a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f32287i = true;
        int[] iArr2 = this.f32319y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f32293l = -1;
        this.f32295m = -1;
    }

    public void x1(LinearSystem linearSystem, boolean z2) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int iA = linearSystem.A(this.Q);
        int iA2 = linearSystem.A(this.R);
        int iA3 = linearSystem.A(this.S);
        int iA4 = linearSystem.A(this.T);
        if (z2 && (horizontalWidgetRun = this.f32279e) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.f32490h;
            if (dependencyNode.f32440j) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.f32491i;
                if (dependencyNode2.f32440j) {
                    iA = dependencyNode.f32437g;
                    iA3 = dependencyNode2.f32437g;
                }
            }
        }
        if (z2 && (verticalWidgetRun = this.f32281f) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.f32490h;
            if (dependencyNode3.f32440j) {
                DependencyNode dependencyNode4 = verticalWidgetRun.f32491i;
                if (dependencyNode4.f32440j) {
                    iA2 = dependencyNode3.f32437g;
                    iA4 = dependencyNode4.f32437g;
                }
            }
        }
        int i3 = iA4 - iA2;
        if (iA3 - iA < 0 || i3 < 0 || iA == Integer.MIN_VALUE || iA == Integer.MAX_VALUE || iA2 == Integer.MIN_VALUE || iA2 == Integer.MAX_VALUE || iA3 == Integer.MIN_VALUE || iA3 == Integer.MAX_VALUE || iA4 == Integer.MIN_VALUE || iA4 == Integer.MAX_VALUE) {
            iA = 0;
            iA4 = 0;
            iA2 = 0;
            iA3 = 0;
        }
        Q0(iA, iA2, iA3, iA4);
    }

    public int y() {
        return this.f32284g0;
    }

    public void y0() {
        z0();
        k1(U0);
        T0(U0);
    }

    public int z() {
        if (this.f32312u0 == 8) {
            return 0;
        }
        return this.f32280e0;
    }

    public void z0() {
        ConstraintWidget constraintWidgetN = N();
        if (constraintWidgetN != null && (constraintWidgetN instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) N()).U1()) {
            return;
        }
        int size = this.Z.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ConstraintAnchor) this.Z.get(i3)).q();
        }
    }

    public ConstraintWidget(int i3, int i4, int i5, int i6) {
        this.f32271a = false;
        this.f32273b = new WidgetRun[2];
        this.f32279e = null;
        this.f32281f = null;
        this.f32283g = new boolean[]{true, true};
        this.f32285h = false;
        this.f32287i = true;
        this.f32289j = false;
        this.f32291k = true;
        this.f32293l = -1;
        this.f32295m = -1;
        this.f32297n = new WidgetFrame(this);
        this.f32301p = false;
        this.f32303q = false;
        this.f32305r = false;
        this.f32307s = false;
        this.f32309t = -1;
        this.f32311u = -1;
        this.f32313v = 0;
        this.f32315w = 0;
        this.f32317x = 0;
        this.f32319y = new int[2];
        this.f32321z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER};
        this.K = Float.NaN;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList();
        this.f32272a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f32274b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f32276c0 = null;
        this.f32282f0 = 0.0f;
        this.f32284g0 = -1;
        this.f32290j0 = 0;
        this.f32292k0 = 0;
        this.f32294l0 = 0;
        this.f32296m0 = 0;
        this.f32298n0 = 0;
        float f3 = U0;
        this.f32304q0 = f3;
        this.f32306r0 = f3;
        this.f32310t0 = 0;
        this.f32312u0 = 0;
        this.f32314v0 = false;
        this.f32316w0 = null;
        this.f32318x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        this.f32286h0 = i3;
        this.f32288i0 = i4;
        this.f32278d0 = i5;
        this.f32280e0 = i6;
        d();
    }

    public ConstraintWidget(int i3, int i4) {
        this(0, 0, i3, i4);
    }
}
