package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class HelperReference extends ConstraintReference implements Facade {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    protected final State f32021m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    final State.Helper f32022n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected ArrayList f32023o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private HelperWidget f32024p0;

    public HelperReference(State state, State.Helper helper) {
        super(state);
        this.f32023o0 = new ArrayList();
        this.f32021m0 = state;
        this.f32022n0 = helper;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget a() {
        return u0();
    }

    public HelperReference s0(Object... objArr) {
        Collections.addAll(this.f32023o0, objArr);
        return this;
    }

    public void t0() {
        super.apply();
    }

    public HelperWidget u0() {
        return this.f32024p0;
    }

    public State.Helper v0() {
        return this.f32022n0;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
    }
}
