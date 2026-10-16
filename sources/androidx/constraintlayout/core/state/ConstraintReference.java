package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConstraintReference implements Reference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f31938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final State f31940b;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f31943c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f31945d0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    Dimension f31949f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    Dimension f31951g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private Object f31953h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ConstraintWidget f31955i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private HashMap f31957j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private HashMap f31959k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    TypedBundle f31961l0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f31942c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Facade f31944d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f31946e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f31948f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f31950g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f31952h = -1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected float f31954i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected float f31956j = 0.5f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f31958k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f31960l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f31962m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f31963n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f31964o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f31965p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected int f31966q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected int f31967r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f31968s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f31969t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected int f31970u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected int f31971v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f31972w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f31973x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f31974y = Float.NaN;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    float f31975z = Float.NaN;
    float A = Float.NaN;
    float B = Float.NaN;
    float C = Float.NaN;
    float D = Float.NaN;
    float E = Float.NaN;
    float F = Float.NaN;
    float G = Float.NaN;
    float H = Float.NaN;
    float I = Float.NaN;
    int J = 0;
    protected Object K = null;
    protected Object L = null;
    protected Object M = null;
    protected Object N = null;
    protected Object O = null;
    protected Object P = null;
    protected Object Q = null;
    protected Object R = null;
    protected Object S = null;
    protected Object T = null;
    Object U = null;
    protected Object V = null;
    protected Object W = null;
    Object X = null;
    Object Y = null;
    Object Z = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    Object f31939a0 = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    Object f31941b0 = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    State.Constraint f31947e0 = null;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.ConstraintReference$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31976a;

        static {
            int[] iArr = new int[State.Constraint.values().length];
            f31976a = iArr;
            try {
                iArr[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31976a[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31976a[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31976a[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31976a[State.Constraint.START_TO_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31976a[State.Constraint.START_TO_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31976a[State.Constraint.END_TO_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31976a[State.Constraint.END_TO_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31976a[State.Constraint.TOP_TO_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31976a[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f31976a[State.Constraint.TOP_TO_BASELINE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f31976a[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f31976a[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f31976a[State.Constraint.BOTTOM_TO_BASELINE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f31976a[State.Constraint.BASELINE_TO_BOTTOM.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f31976a[State.Constraint.BASELINE_TO_TOP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f31976a[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f31976a[State.Constraint.CIRCULAR_CONSTRAINT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f31976a[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f31976a[State.Constraint.CENTER_VERTICALLY.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ConstraintReferenceFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class IncorrectConstraintException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f31977a;

        @Override // java.lang.Throwable
        public String getMessage() {
            return toString();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.f31977a.toString();
        }
    }

    public ConstraintReference(State state) {
        Object obj = Dimension.f32003j;
        this.f31949f0 = Dimension.c(obj);
        this.f31951g0 = Dimension.c(obj);
        this.f31957j0 = new HashMap();
        this.f31959k0 = new HashMap();
        this.f31961l0 = null;
        this.f31940b = state;
    }

    private Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        return !(obj instanceof ConstraintReference) ? this.f31940b.t(obj) : obj;
    }

    private ConstraintWidget D(Object obj) {
        if (obj instanceof Reference) {
            return ((Reference) obj).a();
        }
        return null;
    }

    private void h(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintWidget constraintWidgetD = D(obj);
        if (constraintWidgetD == null) {
            return;
        }
        int[] iArr = AnonymousClass1.f31976a;
        int i3 = iArr[constraint.ordinal()];
        switch (iArr[constraint.ordinal()]) {
            case 1:
                ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                constraintWidget.q(type).b(constraintWidgetD.q(type), this.f31958k, this.f31966q, false);
                break;
            case 2:
                constraintWidget.q(ConstraintAnchor.Type.LEFT).b(constraintWidgetD.q(ConstraintAnchor.Type.RIGHT), this.f31958k, this.f31966q, false);
                break;
            case 3:
                constraintWidget.q(ConstraintAnchor.Type.RIGHT).b(constraintWidgetD.q(ConstraintAnchor.Type.LEFT), this.f31960l, this.f31967r, false);
                break;
            case 4:
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.q(type2).b(constraintWidgetD.q(type2), this.f31960l, this.f31967r, false);
                break;
            case 5:
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.LEFT;
                constraintWidget.q(type3).b(constraintWidgetD.q(type3), this.f31962m, this.f31968s, false);
                break;
            case 6:
                constraintWidget.q(ConstraintAnchor.Type.LEFT).b(constraintWidgetD.q(ConstraintAnchor.Type.RIGHT), this.f31962m, this.f31968s, false);
                break;
            case 7:
                constraintWidget.q(ConstraintAnchor.Type.RIGHT).b(constraintWidgetD.q(ConstraintAnchor.Type.LEFT), this.f31963n, this.f31969t, false);
                break;
            case 8:
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.q(type4).b(constraintWidgetD.q(type4), this.f31963n, this.f31969t, false);
                break;
            case 9:
                ConstraintAnchor.Type type5 = ConstraintAnchor.Type.TOP;
                constraintWidget.q(type5).b(constraintWidgetD.q(type5), this.f31964o, this.f31970u, false);
                break;
            case 10:
                constraintWidget.q(ConstraintAnchor.Type.TOP).b(constraintWidgetD.q(ConstraintAnchor.Type.BOTTOM), this.f31964o, this.f31970u, false);
                break;
            case 11:
                constraintWidget.i0(ConstraintAnchor.Type.TOP, constraintWidgetD, ConstraintAnchor.Type.BASELINE, this.f31964o, this.f31970u);
                break;
            case 12:
                constraintWidget.q(ConstraintAnchor.Type.BOTTOM).b(constraintWidgetD.q(ConstraintAnchor.Type.TOP), this.f31965p, this.f31971v, false);
                break;
            case 13:
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.BOTTOM;
                constraintWidget.q(type6).b(constraintWidgetD.q(type6), this.f31965p, this.f31971v, false);
                break;
            case 14:
                constraintWidget.i0(ConstraintAnchor.Type.BOTTOM, constraintWidgetD, ConstraintAnchor.Type.BASELINE, this.f31965p, this.f31971v);
                break;
            case 15:
                constraintWidget.i0(ConstraintAnchor.Type.BASELINE, constraintWidgetD, ConstraintAnchor.Type.BOTTOM, this.f31972w, this.f31973x);
                break;
            case 16:
                constraintWidget.i0(ConstraintAnchor.Type.BASELINE, constraintWidgetD, ConstraintAnchor.Type.TOP, this.f31972w, this.f31973x);
                break;
            case 17:
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BASELINE;
                constraintWidget.i0(type7, constraintWidgetD, type7, this.f31972w, this.f31973x);
                break;
            case 18:
                constraintWidget.m(constraintWidgetD, this.f31943c0, (int) this.f31945d0);
                break;
        }
    }

    private void x() {
        this.K = B(this.K);
        this.L = B(this.L);
        this.M = B(this.M);
        this.N = B(this.N);
        this.O = B(this.O);
        this.P = B(this.P);
        this.Q = B(this.Q);
        this.R = B(this.R);
        this.S = B(this.S);
        this.T = B(this.T);
        this.V = B(this.V);
        this.W = B(this.W);
        this.Y = B(this.Y);
        this.Z = B(this.Z);
        this.f31939a0 = B(this.f31939a0);
    }

    public ConstraintReference A(Object obj) {
        this.f31947e0 = State.Constraint.END_TO_START;
        this.Q = obj;
        return this;
    }

    public Dimension C() {
        return this.f31951g0;
    }

    public Dimension E() {
        return this.f31949f0;
    }

    public ConstraintReference F(float f3) {
        this.f31954i = f3;
        return this;
    }

    public ConstraintReference G() {
        if (this.K != null) {
            this.f31947e0 = State.Constraint.LEFT_TO_LEFT;
            return this;
        }
        this.f31947e0 = State.Constraint.LEFT_TO_RIGHT;
        return this;
    }

    public ConstraintReference H(Object obj) {
        this.f31947e0 = State.Constraint.LEFT_TO_LEFT;
        this.K = obj;
        return this;
    }

    public ConstraintReference I(Object obj) {
        this.f31947e0 = State.Constraint.LEFT_TO_RIGHT;
        this.L = obj;
        return this;
    }

    public ConstraintReference J(int i3) {
        State.Constraint constraint = this.f31947e0;
        if (constraint == null) {
            this.f31958k = i3;
            this.f31960l = i3;
            this.f31962m = i3;
            this.f31963n = i3;
            this.f31964o = i3;
            this.f31965p = i3;
            return this;
        }
        switch (AnonymousClass1.f31976a[constraint.ordinal()]) {
            case 1:
            case 2:
                this.f31958k = i3;
                break;
            case 3:
            case 4:
                this.f31960l = i3;
                break;
            case 5:
            case 6:
                this.f31962m = i3;
                break;
            case 7:
            case 8:
                this.f31963n = i3;
                break;
            case 9:
            case 10:
            case 11:
                this.f31964o = i3;
                break;
            case 12:
            case 13:
            case 14:
                this.f31965p = i3;
                break;
            case 15:
            case 16:
            case 17:
                this.f31972w = i3;
                break;
            case 18:
                this.f31945d0 = i3;
                break;
        }
        return this;
    }

    public ConstraintReference K(Object obj) {
        return J(this.f31940b.e(obj));
    }

    public ConstraintReference L(int i3) {
        State.Constraint constraint = this.f31947e0;
        if (constraint == null) {
            this.f31966q = i3;
            this.f31967r = i3;
            this.f31968s = i3;
            this.f31969t = i3;
            this.f31970u = i3;
            this.f31971v = i3;
            return this;
        }
        switch (AnonymousClass1.f31976a[constraint.ordinal()]) {
            case 1:
            case 2:
                this.f31966q = i3;
                break;
            case 3:
            case 4:
                this.f31967r = i3;
                break;
            case 5:
            case 6:
                this.f31968s = i3;
                break;
            case 7:
            case 8:
                this.f31969t = i3;
                break;
            case 9:
            case 10:
            case 11:
                this.f31970u = i3;
                break;
            case 12:
            case 13:
            case 14:
                this.f31971v = i3;
                break;
            case 15:
            case 16:
            case 17:
                this.f31973x = i3;
                break;
        }
        return this;
    }

    public ConstraintReference M(Object obj) {
        return L(this.f31940b.e(obj));
    }

    public ConstraintReference N(float f3) {
        this.f31974y = f3;
        return this;
    }

    public ConstraintReference O(float f3) {
        this.f31975z = f3;
        return this;
    }

    public ConstraintReference P() {
        if (this.M != null) {
            this.f31947e0 = State.Constraint.RIGHT_TO_LEFT;
            return this;
        }
        this.f31947e0 = State.Constraint.RIGHT_TO_RIGHT;
        return this;
    }

    public ConstraintReference Q(Object obj) {
        this.f31947e0 = State.Constraint.RIGHT_TO_LEFT;
        this.M = obj;
        return this;
    }

    public ConstraintReference R(Object obj) {
        this.f31947e0 = State.Constraint.RIGHT_TO_RIGHT;
        this.N = obj;
        return this;
    }

    public ConstraintReference S(float f3) {
        this.A = f3;
        return this;
    }

    public ConstraintReference T(float f3) {
        this.B = f3;
        return this;
    }

    public ConstraintReference U(float f3) {
        this.C = f3;
        return this;
    }

    public ConstraintReference V(float f3) {
        this.H = f3;
        return this;
    }

    public ConstraintReference W(float f3) {
        this.I = f3;
        return this;
    }

    public void X(Facade facade) {
        this.f31944d = facade;
        if (facade != null) {
            b(facade.a());
        }
    }

    public ConstraintReference Y(Dimension dimension) {
        this.f31951g0 = dimension;
        return this;
    }

    public void Z(int i3) {
        this.f31946e = i3;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public ConstraintWidget a() {
        if (this.f31955i0 == null) {
            ConstraintWidget constraintWidgetW = w();
            this.f31955i0 = constraintWidgetW;
            constraintWidgetW.I0(this.f31953h0);
        }
        return this.f31955i0;
    }

    public void a0(float f3) {
        this.f31950g = f3;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void apply() {
        if (this.f31955i0 == null) {
            return;
        }
        Facade facade = this.f31944d;
        if (facade != null) {
            facade.apply();
        }
        this.f31949f0.a(this.f31940b, this.f31955i0, 0);
        this.f31951g0.a(this.f31940b, this.f31955i0, 1);
        x();
        i();
        int i3 = this.f31946e;
        if (i3 != 0) {
            this.f31955i0.U0(i3);
        }
        int i4 = this.f31948f;
        if (i4 != 0) {
            this.f31955i0.l1(i4);
        }
        float f3 = this.f31950g;
        if (f3 != -1.0f) {
            this.f31955i0.Y0(f3);
        }
        float f4 = this.f31952h;
        if (f4 != -1.0f) {
            this.f31955i0.p1(f4);
        }
        this.f31955i0.T0(this.f31954i);
        this.f31955i0.k1(this.f31956j);
        ConstraintWidget constraintWidget = this.f31955i0;
        WidgetFrame widgetFrame = constraintWidget.f32297n;
        widgetFrame.f32155f = this.f31974y;
        widgetFrame.f32156g = this.f31975z;
        widgetFrame.f32157h = this.A;
        widgetFrame.f32158i = this.B;
        widgetFrame.f32159j = this.C;
        widgetFrame.f32160k = this.D;
        widgetFrame.f32161l = this.E;
        widgetFrame.f32162m = this.F;
        widgetFrame.f32163n = this.H;
        widgetFrame.f32164o = this.I;
        widgetFrame.f32165p = this.G;
        int i5 = this.J;
        widgetFrame.f32167r = i5;
        constraintWidget.q1(i5);
        this.f31955i0.f32297n.u(this.f31961l0);
        HashMap map = this.f31957j0;
        if (map != null) {
            for (String str : map.keySet()) {
                this.f31955i0.f32297n.s(str, 902, ((Integer) this.f31957j0.get(str)).intValue());
            }
        }
        HashMap map2 = this.f31959k0;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                this.f31955i0.f32297n.r(str2, 901, ((Float) this.f31959k0.get(str2)).floatValue());
            }
        }
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void b(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return;
        }
        this.f31955i0 = constraintWidget;
        constraintWidget.I0(this.f31953h0);
    }

    public void b0(String str) {
        this.f31942c = str;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void c(Object obj) {
        this.f31938a = obj;
    }

    public void c0(int i3) {
        this.f31948f = i3;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade d() {
        return this.f31944d;
    }

    public void d0(float f3) {
        this.f31952h = f3;
    }

    public void e(String str, int i3) {
        this.f31957j0.put(str, Integer.valueOf(i3));
    }

    public void e0(Object obj) {
        this.f31953h0 = obj;
        ConstraintWidget constraintWidget = this.f31955i0;
        if (constraintWidget != null) {
            constraintWidget.I0(obj);
        }
    }

    public void f(String str, float f3) {
        if (this.f31959k0 == null) {
            this.f31959k0 = new HashMap();
        }
        this.f31959k0.put(str, Float.valueOf(f3));
    }

    public ConstraintReference f0(Dimension dimension) {
        this.f31949f0 = dimension;
        return this;
    }

    public ConstraintReference g(float f3) {
        this.G = f3;
        return this;
    }

    public ConstraintReference g0() {
        if (this.O != null) {
            this.f31947e0 = State.Constraint.START_TO_START;
            return this;
        }
        this.f31947e0 = State.Constraint.START_TO_END;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.f31938a;
    }

    public ConstraintReference h0(Object obj) {
        this.f31947e0 = State.Constraint.START_TO_END;
        this.P = obj;
        return this;
    }

    public void i() {
        h(this.f31955i0, this.K, State.Constraint.LEFT_TO_LEFT);
        h(this.f31955i0, this.L, State.Constraint.LEFT_TO_RIGHT);
        h(this.f31955i0, this.M, State.Constraint.RIGHT_TO_LEFT);
        h(this.f31955i0, this.N, State.Constraint.RIGHT_TO_RIGHT);
        h(this.f31955i0, this.O, State.Constraint.START_TO_START);
        h(this.f31955i0, this.P, State.Constraint.START_TO_END);
        h(this.f31955i0, this.Q, State.Constraint.END_TO_START);
        h(this.f31955i0, this.R, State.Constraint.END_TO_END);
        h(this.f31955i0, this.S, State.Constraint.TOP_TO_TOP);
        h(this.f31955i0, this.T, State.Constraint.TOP_TO_BOTTOM);
        h(this.f31955i0, this.U, State.Constraint.TOP_TO_BASELINE);
        h(this.f31955i0, this.V, State.Constraint.BOTTOM_TO_TOP);
        h(this.f31955i0, this.W, State.Constraint.BOTTOM_TO_BOTTOM);
        h(this.f31955i0, this.X, State.Constraint.BOTTOM_TO_BASELINE);
        h(this.f31955i0, this.Y, State.Constraint.BASELINE_TO_BASELINE);
        h(this.f31955i0, this.Z, State.Constraint.BASELINE_TO_TOP);
        h(this.f31955i0, this.f31939a0, State.Constraint.BASELINE_TO_BOTTOM);
        h(this.f31955i0, this.f31941b0, State.Constraint.CIRCULAR_CONSTRAINT);
    }

    public ConstraintReference i0(Object obj) {
        this.f31947e0 = State.Constraint.START_TO_START;
        this.O = obj;
        return this;
    }

    public ConstraintReference j() {
        this.f31947e0 = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference j0() {
        if (this.S != null) {
            this.f31947e0 = State.Constraint.TOP_TO_TOP;
            return this;
        }
        this.f31947e0 = State.Constraint.TOP_TO_BOTTOM;
        return this;
    }

    public ConstraintReference k(Object obj) {
        this.f31947e0 = State.Constraint.BASELINE_TO_BASELINE;
        this.Y = obj;
        return this;
    }

    ConstraintReference k0(Object obj) {
        this.f31947e0 = State.Constraint.TOP_TO_BASELINE;
        this.U = obj;
        return this;
    }

    public ConstraintReference l(Object obj) {
        this.f31947e0 = State.Constraint.BASELINE_TO_BOTTOM;
        this.f31939a0 = obj;
        return this;
    }

    public ConstraintReference l0(Object obj) {
        this.f31947e0 = State.Constraint.TOP_TO_BOTTOM;
        this.T = obj;
        return this;
    }

    public ConstraintReference m(Object obj) {
        this.f31947e0 = State.Constraint.BASELINE_TO_TOP;
        this.Z = obj;
        return this;
    }

    public ConstraintReference m0(Object obj) {
        this.f31947e0 = State.Constraint.TOP_TO_TOP;
        this.S = obj;
        return this;
    }

    public ConstraintReference n() {
        if (this.V != null) {
            this.f31947e0 = State.Constraint.BOTTOM_TO_TOP;
            return this;
        }
        this.f31947e0 = State.Constraint.BOTTOM_TO_BOTTOM;
        return this;
    }

    public ConstraintReference n0(float f3) {
        this.D = f3;
        return this;
    }

    ConstraintReference o(Object obj) {
        this.f31947e0 = State.Constraint.BOTTOM_TO_BASELINE;
        this.X = obj;
        return this;
    }

    public ConstraintReference o0(float f3) {
        this.E = f3;
        return this;
    }

    public ConstraintReference p(Object obj) {
        this.f31947e0 = State.Constraint.BOTTOM_TO_BOTTOM;
        this.W = obj;
        return this;
    }

    public ConstraintReference p0(float f3) {
        this.F = f3;
        return this;
    }

    public ConstraintReference q(Object obj) {
        this.f31947e0 = State.Constraint.BOTTOM_TO_TOP;
        this.V = obj;
        return this;
    }

    public ConstraintReference q0(float f3) {
        this.f31956j = f3;
        return this;
    }

    public ConstraintReference r(Object obj, float f3, float f4) {
        this.f31941b0 = B(obj);
        this.f31943c0 = f3;
        this.f31945d0 = f4;
        this.f31947e0 = State.Constraint.CIRCULAR_CONSTRAINT;
        return this;
    }

    public ConstraintReference r0(int i3) {
        this.J = i3;
        return this;
    }

    public ConstraintReference s() {
        State.Constraint constraint = this.f31947e0;
        if (constraint == null) {
            t();
            return this;
        }
        switch (AnonymousClass1.f31976a[constraint.ordinal()]) {
            case 1:
            case 2:
                this.K = null;
                this.L = null;
                this.f31958k = 0;
                this.f31966q = 0;
                break;
            case 3:
            case 4:
                this.M = null;
                this.N = null;
                this.f31960l = 0;
                this.f31967r = 0;
                break;
            case 5:
            case 6:
                this.O = null;
                this.P = null;
                this.f31962m = 0;
                this.f31968s = 0;
                break;
            case 7:
            case 8:
                this.Q = null;
                this.R = null;
                this.f31963n = 0;
                this.f31969t = 0;
                break;
            case 9:
            case 10:
            case 11:
                this.S = null;
                this.T = null;
                this.U = null;
                this.f31964o = 0;
                this.f31970u = 0;
                break;
            case 12:
            case 13:
            case 14:
                this.V = null;
                this.W = null;
                this.X = null;
                this.f31965p = 0;
                this.f31971v = 0;
                break;
            case 17:
                this.Y = null;
                break;
            case 18:
                this.f31941b0 = null;
                break;
        }
        return this;
    }

    public ConstraintReference t() {
        this.K = null;
        this.L = null;
        this.f31958k = 0;
        this.M = null;
        this.N = null;
        this.f31960l = 0;
        this.O = null;
        this.P = null;
        this.f31962m = 0;
        this.Q = null;
        this.R = null;
        this.f31963n = 0;
        this.S = null;
        this.T = null;
        this.f31964o = 0;
        this.V = null;
        this.W = null;
        this.f31965p = 0;
        this.Y = null;
        this.f31941b0 = null;
        this.f31954i = 0.5f;
        this.f31956j = 0.5f;
        this.f31966q = 0;
        this.f31967r = 0;
        this.f31968s = 0;
        this.f31969t = 0;
        this.f31970u = 0;
        this.f31971v = 0;
        return this;
    }

    public ConstraintReference u() {
        g0().s();
        y().s();
        G().s();
        P().s();
        return this;
    }

    public ConstraintReference v() {
        j0().s();
        j().s();
        n().s();
        return this;
    }

    public ConstraintWidget w() {
        return new ConstraintWidget(E().l(), C().l());
    }

    public ConstraintReference y() {
        if (this.Q != null) {
            this.f31947e0 = State.Constraint.END_TO_START;
            return this;
        }
        this.f31947e0 = State.Constraint.END_TO_END;
        return this;
    }

    public ConstraintReference z(Object obj) {
        this.f31947e0 = State.Constraint.END_TO_END;
        this.R = obj;
        return this;
    }
}
