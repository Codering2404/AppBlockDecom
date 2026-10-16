package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FlowReference extends HelperReference {
    protected int A0;
    protected int B0;
    protected int C0;
    protected int D0;
    protected int E0;
    protected int F0;
    protected int G0;
    protected int H0;
    protected int I0;
    protected int J0;
    protected int K0;
    protected float L0;
    protected float M0;
    protected float N0;
    protected float O0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    protected Flow f32184q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    protected HashMap f32185r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    protected HashMap f32186s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    protected HashMap f32187t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    protected int f32188u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    protected int f32189v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    protected int f32190w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    protected int f32191x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    protected int f32192y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    protected int f32193z0;

    public FlowReference(State state, State.Helper helper) {
        super(state, helper);
        this.f32188u0 = 0;
        this.f32189v0 = -1;
        this.f32190w0 = -1;
        this.f32191x0 = -1;
        this.f32192y0 = -1;
        this.f32193z0 = -1;
        this.A0 = -1;
        this.B0 = 2;
        this.C0 = 2;
        this.D0 = 0;
        this.E0 = 0;
        this.F0 = 0;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = -1;
        this.K0 = 0;
        this.L0 = 0.5f;
        this.M0 = 0.5f;
        this.N0 = 0.5f;
        this.O0 = 0.5f;
        if (helper == State.Helper.VERTICAL_FLOW) {
            this.K0 = 1;
        }
    }

    public void A0(int i3) {
        this.f32190w0 = i3;
    }

    public void B0(int i3) {
        this.C0 = i3;
    }

    public void C0(int i3) {
        this.E0 = i3;
    }

    public void D0(int i3) {
        this.f32192y0 = i3;
    }

    public void E0(float f3) {
        this.O0 = f3;
    }

    public void F0(int i3) {
        this.A0 = i3;
    }

    public void G0(float f3) {
        this.M0 = f3;
    }

    public void H0(int i3) {
        this.f32191x0 = i3;
    }

    public void I0(int i3) {
        this.J0 = i3;
    }

    public void J0(int i3) {
        this.K0 = i3;
    }

    public void K0(int i3) {
        this.I0 = i3;
    }

    public void L0(int i3) {
        this.F0 = i3;
    }

    public void M0(int i3) {
        this.G0 = i3;
    }

    public void N0(int i3) {
        this.H0 = i3;
    }

    public void O0(int i3) {
        this.B0 = i3;
    }

    public void P0(int i3) {
        this.D0 = i3;
    }

    public void Q0(int i3) {
        this.f32189v0 = i3;
    }

    public void R0(int i3) {
        this.f32188u0 = i3;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        u0();
        b(this.f32184q0);
        this.f32184q0.K2(this.K0);
        this.f32184q0.P2(this.f32188u0);
        int i3 = this.J0;
        if (i3 != -1) {
            this.f32184q0.J2(i3);
        }
        int i4 = this.F0;
        if (i4 != 0) {
            this.f32184q0.S1(i4);
        }
        int i5 = this.H0;
        if (i5 != 0) {
            this.f32184q0.V1(i5);
        }
        int i6 = this.G0;
        if (i6 != 0) {
            this.f32184q0.T1(i6);
        }
        int i7 = this.I0;
        if (i7 != 0) {
            this.f32184q0.Q1(i7);
        }
        int i8 = this.E0;
        if (i8 != 0) {
            this.f32184q0.D2(i8);
        }
        int i9 = this.D0;
        if (i9 != 0) {
            this.f32184q0.N2(i9);
        }
        float f3 = this.f31954i;
        if (f3 != 0.5f) {
            this.f32184q0.C2(f3);
        }
        float f4 = this.N0;
        if (f4 != 0.5f) {
            this.f32184q0.x2(f4);
        }
        float f5 = this.O0;
        if (f5 != 0.5f) {
            this.f32184q0.F2(f5);
        }
        float f6 = this.f31956j;
        if (f6 != 0.5f) {
            this.f32184q0.M2(f6);
        }
        float f7 = this.L0;
        if (f7 != 0.5f) {
            this.f32184q0.z2(f7);
        }
        float f8 = this.M0;
        if (f8 != 0.5f) {
            this.f32184q0.H2(f8);
        }
        int i10 = this.C0;
        if (i10 != 2) {
            this.f32184q0.B2(i10);
        }
        int i11 = this.B0;
        if (i11 != 2) {
            this.f32184q0.L2(i11);
        }
        int i12 = this.f32189v0;
        if (i12 != -1) {
            this.f32184q0.O2(i12);
        }
        int i13 = this.f32190w0;
        if (i13 != -1) {
            this.f32184q0.A2(i13);
        }
        int i14 = this.f32191x0;
        if (i14 != -1) {
            this.f32184q0.I2(i14);
        }
        int i15 = this.f32192y0;
        if (i15 != -1) {
            this.f32184q0.E2(i15);
        }
        int i16 = this.f32193z0;
        if (i16 != -1) {
            this.f32184q0.y2(i16);
        }
        int i17 = this.A0;
        if (i17 != -1) {
            this.f32184q0.G2(i17);
        }
        t0();
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public HelperWidget u0() {
        if (this.f32184q0 == null) {
            this.f32184q0 = new Flow();
        }
        return this.f32184q0;
    }

    public void w0(String str, float f3, float f4, float f5) {
        super.s0(str);
        if (!Float.isNaN(f3)) {
            if (this.f32185r0 == null) {
                this.f32185r0 = new HashMap();
            }
            this.f32185r0.put(str, Float.valueOf(f3));
        }
        if (!Float.isNaN(f4)) {
            if (this.f32186s0 == null) {
                this.f32186s0 = new HashMap();
            }
            this.f32186s0.put(str, Float.valueOf(f4));
        }
        if (Float.isNaN(f5)) {
            return;
        }
        if (this.f32187t0 == null) {
            this.f32187t0 = new HashMap();
        }
        this.f32187t0.put(str, Float.valueOf(f5));
    }

    public void x0(float f3) {
        this.N0 = f3;
    }

    public void y0(int i3) {
        this.f32193z0 = i3;
    }

    public void z0(float f3) {
        this.L0 = f3;
    }
}
