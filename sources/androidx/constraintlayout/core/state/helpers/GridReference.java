package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.utils.GridCore;
import androidx.constraintlayout.core.widgets.HelperWidget;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class GridReference extends HelperReference {
    private String A0;
    private String B0;
    private String C0;
    private String D0;
    private int E0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private GridCore f32194q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f32195r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f32196s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f32197t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f32198u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private int f32199v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private int f32200w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private int f32201x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private float f32202y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private float f32203z0;

    public GridReference(State state, State.Helper helper) {
        super(state, helper);
        this.f32195r0 = 0;
        this.f32196s0 = 0;
        this.f32197t0 = 0;
        this.f32198u0 = 0;
        if (helper == State.Helper.ROW) {
            this.f32200w0 = 1;
        } else if (helper == State.Helper.COLUMN) {
            this.f32201x0 = 1;
        }
    }

    public void A0(float f3) {
        this.f32202y0 = f3;
    }

    public void B0(int i3) {
        this.f32199v0 = i3;
    }

    public void C0(int i3) {
        this.f32198u0 = i3;
    }

    public void D0(int i3) {
        this.f32196s0 = i3;
    }

    public void E0(int i3) {
        this.f32195r0 = i3;
    }

    public void F0(int i3) {
        this.f32197t0 = i3;
    }

    public void G0(String str) {
        this.A0 = str;
    }

    public void H0(int i3) {
        if (super.v0() == State.Helper.COLUMN) {
            return;
        }
        this.f32200w0 = i3;
    }

    public void I0(String str) {
        this.D0 = str;
    }

    public void J0(String str) {
        this.C0 = str;
    }

    public void K0(float f3) {
        this.f32203z0 = f3;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        u0();
        this.f32194q0.x2(this.f32199v0);
        int i3 = this.f32200w0;
        if (i3 != 0) {
            this.f32194q0.z2(i3);
        }
        int i4 = this.f32201x0;
        if (i4 != 0) {
            this.f32194q0.u2(i4);
        }
        float f3 = this.f32202y0;
        if (f3 != 0.0f) {
            this.f32194q0.w2(f3);
        }
        float f4 = this.f32203z0;
        if (f4 != 0.0f) {
            this.f32194q0.C2(f4);
        }
        String str = this.A0;
        if (str != null && !str.isEmpty()) {
            this.f32194q0.y2(this.A0);
        }
        String str2 = this.B0;
        if (str2 != null && !str2.isEmpty()) {
            this.f32194q0.t2(this.B0);
        }
        String str3 = this.C0;
        if (str3 != null && !str3.isEmpty()) {
            this.f32194q0.B2(this.C0);
        }
        String str4 = this.D0;
        if (str4 != null && !str4.isEmpty()) {
            this.f32194q0.A2(this.D0);
        }
        this.f32194q0.v2(this.E0);
        this.f32194q0.U1(this.f32195r0);
        this.f32194q0.R1(this.f32196s0);
        this.f32194q0.V1(this.f32197t0);
        this.f32194q0.Q1(this.f32198u0);
        t0();
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public HelperWidget u0() {
        if (this.f32194q0 == null) {
            this.f32194q0 = new GridCore();
        }
        return this.f32194q0;
    }

    public void w0(String str) {
        this.B0 = str;
    }

    public void x0(int i3) {
        if (super.v0() == State.Helper.ROW) {
            return;
        }
        this.f32201x0 = i3;
    }

    public void y0(int i3) {
        this.E0 = i3;
    }

    public void z0(String str) {
        if (str.isEmpty()) {
            return;
        }
        String[] strArrSplit = str.split("\\|");
        this.E0 = 0;
        for (String str2 : strArrSplit) {
            String lowerCase = str2.toLowerCase();
            lowerCase.getClass();
            if (lowerCase.equals("subgridbycolrow")) {
                this.E0 |= 1;
            } else if (lowerCase.equals("spansrespectwidgetorder")) {
                this.E0 |= 2;
            }
        }
    }
}
