package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AlignVerticallyReference extends HelperReference {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private float f32172q0;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.f32172q0 = 0.5f;
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
            constraintReferenceD.v();
            Object obj2 = this.S;
            if (obj2 != null) {
                constraintReferenceD.m0(obj2);
            } else {
                Object obj3 = this.T;
                if (obj3 != null) {
                    constraintReferenceD.l0(obj3);
                } else {
                    constraintReferenceD.m0(State.f32027k);
                }
            }
            Object obj4 = this.V;
            if (obj4 != null) {
                constraintReferenceD.q(obj4);
            } else {
                Object obj5 = this.W;
                if (obj5 != null) {
                    constraintReferenceD.p(obj5);
                } else {
                    constraintReferenceD.p(State.f32027k);
                }
            }
            float f3 = this.f32172q0;
            if (f3 != 0.5f) {
                constraintReferenceD.q0(f3);
            }
        }
    }
}
