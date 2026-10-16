package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.HelperWidget;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class BarrierReference extends HelperReference {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private State.Direction f32173q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f32174r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private Barrier f32175s0;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.BarrierReference$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32176a;

        static {
            int[] iArr = new int[State.Direction.values().length];
            f32176a = iArr;
            try {
                iArr[State.Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32176a[State.Direction.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32176a[State.Direction.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32176a[State.Direction.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32176a[State.Direction.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32176a[State.Direction.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public BarrierReference(State state) {
        super(state, State.Helper.BARRIER);
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ConstraintReference J(int i3) {
        this.f32174r0 = i3;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ConstraintReference K(Object obj) {
        J(this.f32021m0.e(obj));
        return this;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        u0();
        int i3 = AnonymousClass1.f32176a[this.f32173q0.ordinal()];
        int i4 = 3;
        if (i3 == 3 || i3 == 4) {
            i4 = 1;
        } else if (i3 == 5) {
            i4 = 2;
        } else if (i3 != 6) {
            i4 = 0;
        }
        this.f32175s0.H1(i4);
        this.f32175s0.I1(this.f32174r0);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public HelperWidget u0() {
        if (this.f32175s0 == null) {
            this.f32175s0 = new Barrier();
        }
        return this.f32175s0;
    }

    public void w0(State.Direction direction) {
        this.f32173q0 = direction;
    }
}
