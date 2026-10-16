package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class VerticalChainReference extends ChainReference {

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.VerticalChainReference$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32212a;

        static {
            int[] iArr = new int[State.Chain.values().length];
            f32212a = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32212a[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32212a[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ArrayList arrayList = this.f32023o0;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            this.f32021m0.d(obj).v();
        }
        ArrayList arrayList2 = this.f32023o0;
        int size2 = arrayList2.size();
        ConstraintReference constraintReference = null;
        int i4 = 0;
        ConstraintReference constraintReference2 = null;
        while (i4 < size2) {
            Object obj2 = arrayList2.get(i4);
            i4++;
            ConstraintReference constraintReferenceD = this.f32021m0.d(obj2);
            if (constraintReference2 == null) {
                Object obj3 = this.S;
                if (obj3 != null) {
                    constraintReferenceD.m0(obj3).J(this.f31964o).L(this.f31970u);
                } else {
                    Object obj4 = this.T;
                    if (obj4 != null) {
                        constraintReferenceD.l0(obj4).J(this.f31964o).L(this.f31970u);
                    } else {
                        String string = constraintReferenceD.getKey().toString();
                        constraintReferenceD.m0(State.f32027k).K(Float.valueOf(B0(string))).M(Float.valueOf(A0(string)));
                    }
                }
                constraintReference2 = constraintReferenceD;
            }
            if (constraintReference != null) {
                String string2 = constraintReference.getKey().toString();
                String string3 = constraintReferenceD.getKey().toString();
                constraintReference.q(constraintReferenceD.getKey()).K(Float.valueOf(z0(string2))).M(Float.valueOf(y0(string2)));
                constraintReferenceD.l0(constraintReference.getKey()).K(Float.valueOf(B0(string3))).M(Float.valueOf(A0(string3)));
            }
            float fC0 = C0(obj2.toString());
            if (fC0 != -1.0f) {
                constraintReferenceD.d0(fC0);
            }
            constraintReference = constraintReferenceD;
        }
        if (constraintReference != null) {
            Object obj5 = this.V;
            if (obj5 != null) {
                constraintReference.q(obj5).J(this.f31965p).L(this.f31971v);
            } else {
                Object obj6 = this.W;
                if (obj6 != null) {
                    constraintReference.p(obj6).J(this.f31965p).L(this.f31971v);
                } else {
                    String string4 = constraintReference.getKey().toString();
                    constraintReference.p(State.f32027k).K(Float.valueOf(z0(string4))).M(Float.valueOf(y0(string4)));
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f3 = this.f32177q0;
        if (f3 != 0.5f) {
            constraintReference2.q0(f3);
        }
        int i5 = AnonymousClass1.f32212a[this.f32183w0.ordinal()];
        if (i5 == 1) {
            constraintReference2.c0(0);
        } else if (i5 == 2) {
            constraintReference2.c0(1);
        } else {
            if (i5 != 3) {
                return;
            }
            constraintReference2.c0(2);
        }
    }
}
