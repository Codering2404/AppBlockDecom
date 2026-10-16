package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ChainHead {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ConstraintWidget f32230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ConstraintWidget f32231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ConstraintWidget f32232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ConstraintWidget f32233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ConstraintWidget f32234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected ConstraintWidget f32235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected ConstraintWidget f32236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected ArrayList f32237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f32238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f32239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected float f32240k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f32241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f32242m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f32243n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f32244o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f32245p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f32246q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected boolean f32247r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected boolean f32248s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f32249t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f32250u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f32251v;

    public ChainHead(ConstraintWidget constraintWidget, int i3, boolean z2) {
        this.f32230a = constraintWidget;
        this.f32245p = i3;
        this.f32246q = z2;
    }

    private void b() {
        int i3 = this.f32245p * 2;
        ConstraintWidget constraintWidget = this.f32230a;
        this.f32244o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.f32238i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.P0;
            int i4 = this.f32245p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i4] = null;
            constraintWidget.O0[i4] = null;
            if (constraintWidget.Z() != 8) {
                this.f32241l++;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget.w(this.f32245p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourW != dimensionBehaviour) {
                    this.f32242m += constraintWidget.H(this.f32245p);
                }
                int iF = this.f32242m + constraintWidget.Y[i3].f();
                this.f32242m = iF;
                int i5 = i3 + 1;
                this.f32242m = iF + constraintWidget.Y[i5].f();
                int iF2 = this.f32243n + constraintWidget.Y[i3].f();
                this.f32243n = iF2;
                this.f32243n = iF2 + constraintWidget.Y[i5].f();
                if (this.f32231b == null) {
                    this.f32231b = constraintWidget;
                }
                this.f32233d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f32274b0;
                int i6 = this.f32245p;
                if (dimensionBehaviourArr[i6] == dimensionBehaviour) {
                    int i7 = constraintWidget.f32319y[i6];
                    if (i7 == 0 || i7 == 3 || i7 == 2) {
                        this.f32239j++;
                        float f3 = constraintWidget.N0[i6];
                        if (f3 > 0.0f) {
                            this.f32240k += f3;
                        }
                        if (c(constraintWidget, i6)) {
                            if (f3 < 0.0f) {
                                this.f32247r = true;
                            } else {
                                this.f32248s = true;
                            }
                            if (this.f32237h == null) {
                                this.f32237h = new ArrayList();
                            }
                            this.f32237h.add(constraintWidget);
                        }
                        if (this.f32235f == null) {
                            this.f32235f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f32236g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.O0[this.f32245p] = constraintWidget;
                        }
                        this.f32236g = constraintWidget;
                    }
                    if (this.f32245p == 0) {
                        if (constraintWidget.f32315w != 0 || constraintWidget.f32321z != 0 || constraintWidget.A != 0) {
                            this.f32244o = false;
                        }
                    } else if (constraintWidget.f32317x != 0 || constraintWidget.C != 0 || constraintWidget.D != 0) {
                        this.f32244o = false;
                    }
                    if (constraintWidget.f32282f0 != 0.0f) {
                        this.f32244o = false;
                        this.f32250u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.P0[this.f32245p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.Y[i3 + 1].f32257f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f32255d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.Y[i3].f32257f;
                if (constraintAnchor2 != null && constraintAnchor2.f32255d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z2 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f32231b;
        if (constraintWidget6 != null) {
            this.f32242m -= constraintWidget6.Y[i3].f();
        }
        ConstraintWidget constraintWidget7 = this.f32233d;
        if (constraintWidget7 != null) {
            this.f32242m -= constraintWidget7.Y[i3 + 1].f();
        }
        this.f32232c = constraintWidget;
        if (this.f32245p == 0 && this.f32246q) {
            this.f32234e = constraintWidget;
        } else {
            this.f32234e = this.f32230a;
        }
        this.f32249t = this.f32248s && this.f32247r;
    }

    private static boolean c(ConstraintWidget constraintWidget, int i3) {
        if (constraintWidget.Z() == 8 || constraintWidget.f32274b0[i3] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        int i4 = constraintWidget.f32319y[i3];
        return i4 == 0 || i4 == 3;
    }

    public void a() {
        if (!this.f32251v) {
            b();
        }
        this.f32251v = true;
    }
}
