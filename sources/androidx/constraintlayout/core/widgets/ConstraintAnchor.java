package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConstraintAnchor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f32254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f32255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f32256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f32257f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    SolverVariable f32260i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet f32252a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f32258g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f32259h = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f32255d = constraintWidget;
        this.f32256e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i3) {
        return b(constraintAnchor, i3, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i3, int i4, boolean z2) {
        if (constraintAnchor == null) {
            q();
            return true;
        }
        if (!z2 && !p(constraintAnchor)) {
            return false;
        }
        this.f32257f = constraintAnchor;
        if (constraintAnchor.f32252a == null) {
            constraintAnchor.f32252a = new HashSet();
        }
        HashSet hashSet = this.f32257f.f32252a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f32258g = i3;
        this.f32259h = i4;
        return true;
    }

    public void c(int i3, ArrayList arrayList, WidgetGroup widgetGroup) {
        HashSet hashSet = this.f32252a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Grouping.a(((ConstraintAnchor) it.next()).f32255d, i3, arrayList, widgetGroup);
            }
        }
    }

    public HashSet d() {
        return this.f32252a;
    }

    public int e() {
        if (this.f32254c) {
            return this.f32253b;
        }
        return 0;
    }

    public int f() {
        ConstraintAnchor constraintAnchor;
        if (this.f32255d.Z() == 8) {
            return 0;
        }
        return (this.f32259h == Integer.MIN_VALUE || (constraintAnchor = this.f32257f) == null || constraintAnchor.f32255d.Z() != 8) ? this.f32258g : this.f32259h;
    }

    public final ConstraintAnchor g() {
        switch (this.f32256e) {
            case NONE:
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
                return null;
            case LEFT:
                return this.f32255d.S;
            case TOP:
                return this.f32255d.T;
            case RIGHT:
                return this.f32255d.Q;
            case BOTTOM:
                return this.f32255d.R;
            default:
                throw new AssertionError(this.f32256e.name());
        }
    }

    public ConstraintWidget h() {
        return this.f32255d;
    }

    public SolverVariable i() {
        return this.f32260i;
    }

    public ConstraintAnchor j() {
        return this.f32257f;
    }

    public Type k() {
        return this.f32256e;
    }

    public boolean l() {
        HashSet hashSet = this.f32252a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((ConstraintAnchor) it.next()).g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet hashSet = this.f32252a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean n() {
        return this.f32254c;
    }

    public boolean o() {
        return this.f32257f != null;
    }

    public boolean p(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type typeK = constraintAnchor.k();
        Type type = this.f32256e;
        if (typeK == type) {
            return type != Type.BASELINE || (constraintAnchor.h().d0() && h().d0());
        }
        switch (type) {
            case NONE:
            case CENTER_X:
            case CENTER_Y:
                return false;
            case LEFT:
            case RIGHT:
                boolean z2 = typeK == Type.LEFT || typeK == Type.RIGHT;
                return constraintAnchor.h() instanceof Guideline ? z2 || typeK == Type.CENTER_X : z2;
            case TOP:
            case BOTTOM:
                boolean z3 = typeK == Type.TOP || typeK == Type.BOTTOM;
                return constraintAnchor.h() instanceof Guideline ? z3 || typeK == Type.CENTER_Y : z3;
            case BASELINE:
                return (typeK == Type.LEFT || typeK == Type.RIGHT) ? false : true;
            case CENTER:
                return (typeK == Type.BASELINE || typeK == Type.CENTER_X || typeK == Type.CENTER_Y) ? false : true;
            default:
                throw new AssertionError(this.f32256e.name());
        }
    }

    public void q() {
        HashSet hashSet;
        ConstraintAnchor constraintAnchor = this.f32257f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f32252a) != null) {
            hashSet.remove(this);
            if (this.f32257f.f32252a.size() == 0) {
                this.f32257f.f32252a = null;
            }
        }
        this.f32252a = null;
        this.f32257f = null;
        this.f32258g = 0;
        this.f32259h = Integer.MIN_VALUE;
        this.f32254c = false;
        this.f32253b = 0;
    }

    public void r() {
        this.f32254c = false;
        this.f32253b = 0;
    }

    public void s(Cache cache) {
        SolverVariable solverVariable = this.f32260i;
        if (solverVariable == null) {
            this.f32260i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.e();
        }
    }

    public void t(int i3) {
        this.f32253b = i3;
        this.f32254c = true;
    }

    public String toString() {
        return this.f32255d.v() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f32256e.toString();
    }

    public void u(int i3) {
        if (o()) {
            this.f32259h = i3;
        }
    }
}
