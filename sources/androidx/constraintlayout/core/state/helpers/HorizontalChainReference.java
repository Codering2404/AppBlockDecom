package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class HorizontalChainReference extends ChainReference {

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32211a;

        static {
            int[] iArr = new int[State.Chain.values().length];
            f32211a = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32211a[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32211a[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ArrayList arrayList = this.f32023o0;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            this.f32021m0.d(obj).u();
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
                Object obj3 = this.O;
                if (obj3 != null) {
                    constraintReferenceD.i0(obj3).J(this.f31962m).L(this.f31968s);
                } else {
                    Object obj4 = this.P;
                    if (obj4 != null) {
                        constraintReferenceD.h0(obj4).J(this.f31962m).L(this.f31968s);
                    } else {
                        Object obj5 = this.K;
                        if (obj5 != null) {
                            constraintReferenceD.i0(obj5).J(this.f31958k).L(this.f31966q);
                        } else {
                            Object obj6 = this.L;
                            if (obj6 != null) {
                                constraintReferenceD.h0(obj6).J(this.f31958k).L(this.f31966q);
                            } else {
                                String string = constraintReferenceD.getKey().toString();
                                constraintReferenceD.i0(State.f32027k).K(Float.valueOf(B0(string))).M(Float.valueOf(A0(string)));
                            }
                        }
                    }
                }
                constraintReference2 = constraintReferenceD;
            }
            if (constraintReference != null) {
                String string2 = constraintReference.getKey().toString();
                String string3 = constraintReferenceD.getKey().toString();
                constraintReference.A(constraintReferenceD.getKey()).K(Float.valueOf(z0(string2))).M(Float.valueOf(y0(string2)));
                constraintReferenceD.h0(constraintReference.getKey()).K(Float.valueOf(B0(string3))).M(Float.valueOf(A0(string3)));
            }
            float fC0 = C0(obj2.toString());
            if (fC0 != -1.0f) {
                constraintReferenceD.a0(fC0);
            }
            constraintReference = constraintReferenceD;
        }
        if (constraintReference != null) {
            Object obj7 = this.Q;
            if (obj7 != null) {
                constraintReference.A(obj7).J(this.f31963n).L(this.f31969t);
            } else {
                Object obj8 = this.R;
                if (obj8 != null) {
                    constraintReference.z(obj8).J(this.f31963n).L(this.f31969t);
                } else {
                    Object obj9 = this.M;
                    if (obj9 != null) {
                        constraintReference.A(obj9).J(this.f31960l).L(this.f31967r);
                    } else {
                        Object obj10 = this.N;
                        if (obj10 != null) {
                            constraintReference.z(obj10).J(this.f31960l).L(this.f31967r);
                        } else {
                            String string4 = constraintReference.getKey().toString();
                            constraintReference.z(State.f32027k).K(Float.valueOf(z0(string4))).M(Float.valueOf(y0(string4)));
                        }
                    }
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f3 = this.f32177q0;
        if (f3 != 0.5f) {
            constraintReference2.F(f3);
        }
        int i5 = AnonymousClass1.f32211a[this.f32183w0.ordinal()];
        if (i5 == 1) {
            constraintReference2.Z(0);
        } else if (i5 == 2) {
            constraintReference2.Z(1);
        } else {
            if (i5 != 3) {
                return;
            }
            constraintReference2.Z(2);
        }
    }
}
