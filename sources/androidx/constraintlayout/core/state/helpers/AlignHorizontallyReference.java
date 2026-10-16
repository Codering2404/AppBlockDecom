package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AlignHorizontallyReference extends HelperReference {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private float f32171q0;

    public AlignHorizontallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.f32171q0 = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ArrayList arrayList = this.f32023o0;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ConstraintReference constraintReferenceD = this.f32021m0.d(obj);
            constraintReferenceD.u();
            Object obj2 = this.O;
            if (obj2 != null) {
                constraintReferenceD.i0(obj2);
            } else {
                Object obj3 = this.P;
                if (obj3 != null) {
                    constraintReferenceD.h0(obj3);
                } else {
                    constraintReferenceD.i0(State.f32027k);
                }
            }
            Object obj4 = this.Q;
            if (obj4 != null) {
                constraintReferenceD.A(obj4);
            } else {
                Object obj5 = this.R;
                if (obj5 != null) {
                    constraintReferenceD.z(obj5);
                } else {
                    constraintReferenceD.z(State.f32027k);
                }
            }
            float f3 = this.f32171q0;
            if (f3 != 0.5f) {
                constraintReferenceD.F(f3);
            }
        }
    }
}
