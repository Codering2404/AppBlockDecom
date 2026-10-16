package androidx.constraintlayout.core.widgets.analyzer;

import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DependencyNode implements Dependency {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    WidgetRun f32434d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f32436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f32437g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dependency f32431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f32432b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f32433c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Type f32435e = Type.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f32438h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    DimensionDependency f32439i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f32440j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    List f32441k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    List f32442l = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f32434d = widgetRun;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
        Iterator it = this.f32442l.iterator();
        while (it.hasNext()) {
            if (!((DependencyNode) it.next()).f32440j) {
                return;
            }
        }
        this.f32433c = true;
        Dependency dependency2 = this.f32431a;
        if (dependency2 != null) {
            dependency2.a(this);
        }
        if (this.f32432b) {
            this.f32434d.a(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int i3 = 0;
        for (DependencyNode dependencyNode2 : this.f32442l) {
            if (!(dependencyNode2 instanceof DimensionDependency)) {
                i3++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i3 == 1 && dependencyNode.f32440j) {
            DimensionDependency dimensionDependency = this.f32439i;
            if (dimensionDependency != null) {
                if (!dimensionDependency.f32440j) {
                    return;
                } else {
                    this.f32436f = this.f32438h * dimensionDependency.f32437g;
                }
            }
            d(dependencyNode.f32437g + this.f32436f);
        }
        Dependency dependency3 = this.f32431a;
        if (dependency3 != null) {
            dependency3.a(this);
        }
    }

    public void b(Dependency dependency) {
        this.f32441k.add(dependency);
        if (this.f32440j) {
            dependency.a(dependency);
        }
    }

    public void c() {
        this.f32442l.clear();
        this.f32441k.clear();
        this.f32440j = false;
        this.f32437g = 0;
        this.f32433c = false;
        this.f32432b = false;
    }

    public void d(int i3) {
        if (this.f32440j) {
            return;
        }
        this.f32440j = true;
        this.f32437g = i3;
        for (Dependency dependency : this.f32441k) {
            dependency.a(dependency);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f32434d.f32484b.v());
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(this.f32435e);
        sb.append("(");
        sb.append(this.f32440j ? Integer.valueOf(this.f32437g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f32442l.size());
        sb.append(":d=");
        sb.append(this.f32441k.size());
        sb.append(">");
        return sb.toString();
    }
}
