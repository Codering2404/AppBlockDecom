package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Dimension {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f32002i = new String("FIXED_DIMENSION");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f32003j = new String("WRAP_DIMENSION");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f32004k = new String("SPREAD_DIMENSION");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f32005l = new String("PARENT_DIMENSION");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f32006m = new String("PERCENT_DIMENSION");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f32007n = new String("RATIO_DIMENSION");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f32008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f32009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f32010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f32011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f32012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f32013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f32014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f32015h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.f32008a = -2;
        this.f32009b = 0;
        this.f32010c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f32011d = 1.0f;
        this.f32012e = 0;
        this.f32013f = null;
        this.f32014g = f32003j;
        this.f32015h = false;
    }

    public static Dimension b(int i3) {
        Dimension dimension = new Dimension(f32002i);
        dimension.j(i3);
        return dimension;
    }

    public static Dimension c(Object obj) {
        Dimension dimension = new Dimension(f32002i);
        dimension.k(obj);
        return dimension;
    }

    public static Dimension d() {
        return new Dimension(f32005l);
    }

    public static Dimension e(Object obj, float f3) {
        Dimension dimension = new Dimension(f32006m);
        dimension.q(obj, f3);
        return dimension;
    }

    public static Dimension f(String str) {
        Dimension dimension = new Dimension(f32007n);
        dimension.r(str);
        return dimension;
    }

    public static Dimension g(Object obj) {
        Dimension dimension = new Dimension();
        dimension.t(obj);
        return dimension;
    }

    public static Dimension h() {
        return new Dimension(f32003j);
    }

    public void a(State state, ConstraintWidget constraintWidget, int i3) {
        String str = this.f32013f;
        if (str != null) {
            constraintWidget.K0(str);
        }
        int i4 = 2;
        if (i3 == 0) {
            if (this.f32015h) {
                constraintWidget.W0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.f32014g;
                if (obj == f32003j) {
                    i4 = 1;
                } else if (obj != f32006m) {
                    i4 = 0;
                }
                constraintWidget.X0(i4, this.f32009b, this.f32010c, this.f32011d);
                return;
            }
            int i5 = this.f32009b;
            if (i5 > 0) {
                constraintWidget.h1(i5);
            }
            int i6 = this.f32010c;
            if (i6 < Integer.MAX_VALUE) {
                constraintWidget.e1(i6);
            }
            Object obj2 = this.f32014g;
            if (obj2 == f32003j) {
                constraintWidget.W0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                return;
            }
            if (obj2 == f32005l) {
                constraintWidget.W0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                return;
            } else {
                if (obj2 == null) {
                    constraintWidget.W0(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.r1(this.f32012e);
                    return;
                }
                return;
            }
        }
        if (this.f32015h) {
            constraintWidget.n1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.f32014g;
            if (obj3 == f32003j) {
                i4 = 1;
            } else if (obj3 != f32006m) {
                i4 = 0;
            }
            constraintWidget.o1(i4, this.f32009b, this.f32010c, this.f32011d);
            return;
        }
        int i7 = this.f32009b;
        if (i7 > 0) {
            constraintWidget.g1(i7);
        }
        int i8 = this.f32010c;
        if (i8 < Integer.MAX_VALUE) {
            constraintWidget.d1(i8);
        }
        Object obj4 = this.f32014g;
        if (obj4 == f32003j) {
            constraintWidget.n1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            return;
        }
        if (obj4 == f32005l) {
            constraintWidget.n1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        } else if (obj4 == null) {
            constraintWidget.n1(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.S0(this.f32012e);
        }
    }

    public boolean i(int i3) {
        return this.f32014g == null && this.f32012e == i3;
    }

    public Dimension j(int i3) {
        this.f32014g = null;
        this.f32012e = i3;
        return this;
    }

    public Dimension k(Object obj) {
        this.f32014g = obj;
        if (obj instanceof Integer) {
            this.f32012e = ((Integer) obj).intValue();
            this.f32014g = null;
        }
        return this;
    }

    int l() {
        return this.f32012e;
    }

    public Dimension m(int i3) {
        if (this.f32010c >= 0) {
            this.f32010c = i3;
        }
        return this;
    }

    public Dimension n(Object obj) {
        Object obj2 = f32003j;
        if (obj == obj2 && this.f32015h) {
            this.f32014g = obj2;
            this.f32010c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return this;
    }

    public Dimension o(int i3) {
        if (i3 >= 0) {
            this.f32009b = i3;
        }
        return this;
    }

    public Dimension p(Object obj) {
        if (obj == f32003j) {
            this.f32009b = -2;
        }
        return this;
    }

    public Dimension q(Object obj, float f3) {
        this.f32011d = f3;
        return this;
    }

    public Dimension r(String str) {
        this.f32013f = str;
        return this;
    }

    public Dimension s(int i3) {
        this.f32015h = true;
        if (i3 >= 0) {
            this.f32010c = i3;
        }
        return this;
    }

    public Dimension t(Object obj) {
        this.f32014g = obj;
        this.f32015h = true;
        return this;
    }

    private Dimension(Object obj) {
        this.f32008a = -2;
        this.f32009b = 0;
        this.f32010c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f32011d = 1.0f;
        this.f32012e = 0;
        this.f32013f = null;
        this.f32015h = false;
        this.f32014g = obj;
    }
}
