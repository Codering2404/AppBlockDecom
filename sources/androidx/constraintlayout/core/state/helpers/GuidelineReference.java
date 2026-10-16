package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class GuidelineReference implements Facade, Reference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final State f32204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Guideline f32206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32207d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32208e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f32209f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f32210g;

    public GuidelineReference(State state) {
        this.f32204a = state;
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget a() {
        if (this.f32206c == null) {
            this.f32206c = new Guideline();
        }
        return this.f32206c;
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference
    public void apply() {
        this.f32206c.H1(this.f32205b);
        int i3 = this.f32207d;
        if (i3 != -1) {
            this.f32206c.E1(i3);
            return;
        }
        int i4 = this.f32208e;
        if (i4 != -1) {
            this.f32206c.F1(i4);
        } else {
            this.f32206c.G1(this.f32209f);
        }
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void b(ConstraintWidget constraintWidget) {
        if (constraintWidget instanceof Guideline) {
            this.f32206c = (Guideline) constraintWidget;
        } else {
            this.f32206c = null;
        }
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void c(Object obj) {
        this.f32210g = obj;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade d() {
        return null;
    }

    public GuidelineReference e(Object obj) {
        this.f32207d = -1;
        this.f32208e = this.f32204a.e(obj);
        this.f32209f = 0.0f;
        return this;
    }

    public GuidelineReference f(float f3) {
        this.f32207d = -1;
        this.f32208e = -1;
        this.f32209f = f3;
        return this;
    }

    public void g(int i3) {
        this.f32205b = i3;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.f32210g;
    }

    public GuidelineReference h(Object obj) {
        this.f32207d = this.f32204a.e(obj);
        this.f32208e = -1;
        this.f32209f = 0.0f;
        return this;
    }
}
