package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class WidgetFrame {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static float f32149v = Float.NaN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintWidget f32150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f32151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f32152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f32153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f32154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f32155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f32156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f32157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f32158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f32159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f32160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f32161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f32162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f32163n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f32164o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f32165p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f32166q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f32167r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final HashMap f32168s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f32169t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    TypedBundle f32170u;

    public WidgetFrame() {
        this.f32150a = null;
        this.f32151b = 0;
        this.f32152c = 0;
        this.f32153d = 0;
        this.f32154e = 0;
        this.f32155f = Float.NaN;
        this.f32156g = Float.NaN;
        this.f32157h = Float.NaN;
        this.f32158i = Float.NaN;
        this.f32159j = Float.NaN;
        this.f32160k = Float.NaN;
        this.f32161l = Float.NaN;
        this.f32162m = Float.NaN;
        this.f32163n = Float.NaN;
        this.f32164o = Float.NaN;
        this.f32165p = Float.NaN;
        this.f32166q = Float.NaN;
        this.f32167r = 0;
        this.f32168s = new HashMap();
        this.f32169t = null;
    }

    private static void a(StringBuilder sb, String str, float f3) {
        if (Float.isNaN(f3)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f3);
        sb.append(",\n");
    }

    private static void b(StringBuilder sb, String str, int i3) {
        sb.append(str);
        sb.append(": ");
        sb.append(i3);
        sb.append(",\n");
    }

    private static float l(float f3, float f4, float f5, float f6) {
        boolean zIsNaN = Float.isNaN(f3);
        boolean zIsNaN2 = Float.isNaN(f4);
        if (zIsNaN && zIsNaN2) {
            return Float.NaN;
        }
        if (zIsNaN) {
            f3 = f5;
        }
        if (zIsNaN2) {
            f4 = f5;
        }
        return f3 + (f6 * (f4 - f3));
    }

    public static void m(int i3, int i4, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f3) {
        int i5;
        int i6;
        int i7;
        float f4;
        int i8;
        float f5;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f6 = 100.0f * f3;
        int i14 = (int) f6;
        int i15 = widgetFrame2.f32151b;
        int i16 = widgetFrame2.f32152c;
        int i17 = widgetFrame3.f32151b;
        int i18 = widgetFrame3.f32152c;
        int i19 = widgetFrame2.f32153d - i15;
        int i20 = widgetFrame2.f32154e - i16;
        int i21 = widgetFrame3.f32153d - i17;
        int i22 = widgetFrame3.f32154e - i18;
        int i23 = i15;
        float f7 = widgetFrame2.f32165p;
        float f8 = widgetFrame3.f32165p;
        if (widgetFrame2.f32167r == 8) {
            int i24 = i23 - ((int) (i21 / 2.0f));
            i7 = i16 - ((int) (i22 / 2.0f));
            if (Float.isNaN(f7)) {
                i5 = i22;
                i23 = i24;
                i6 = i21;
                f4 = 0.0f;
            } else {
                i23 = i24;
                i6 = i21;
                f4 = f7;
                i5 = i22;
            }
        } else {
            i5 = i22;
            i22 = i20;
            i6 = i19;
            i7 = i16;
            f4 = f7;
        }
        if (widgetFrame3.f32167r == 8) {
            i17 -= (int) (i6 / 2.0f);
            i18 -= (int) (i22 / 2.0f);
            if (Float.isNaN(f8)) {
                i8 = i22;
                i21 = i6;
                f8 = 0.0f;
            } else {
                i8 = i22;
                i21 = i6;
            }
        } else {
            i8 = i5;
        }
        if (Float.isNaN(f4) && !Float.isNaN(f8)) {
            f4 = 1.0f;
        }
        if (!Float.isNaN(f4) && Float.isNaN(f8)) {
            f8 = 1.0f;
        }
        int i25 = i17;
        float f9 = widgetFrame2.f32167r == 4 ? 0.0f : f4;
        int i26 = i18;
        float f10 = widgetFrame3.f32167r == 4 ? 0.0f : f8;
        if (widgetFrame.f32150a == null || !transition.F()) {
            f5 = f3;
            i9 = i25;
            i10 = i26;
            i11 = i7;
        } else {
            Transition.KeyPosition keyPositionQ = transition.q(widgetFrame.f32150a.f32299o, i14);
            int i27 = i7;
            Transition.KeyPosition keyPositionP = transition.p(widgetFrame.f32150a.f32299o, i14);
            if (keyPositionQ == keyPositionP) {
                keyPositionP = null;
            }
            if (keyPositionQ != null) {
                i23 = (int) (keyPositionQ.f32110b * i3);
                i11 = (int) (keyPositionQ.f32111c * i4);
                i12 = keyPositionQ.f32109a;
            } else {
                i12 = 0;
                i11 = i27;
            }
            if (keyPositionP != null) {
                i9 = (int) (keyPositionP.f32110b * i3);
                i10 = (int) (keyPositionP.f32111c * i4);
                i13 = keyPositionP.f32109a;
            } else {
                i13 = 100;
                i9 = i25;
                i10 = i26;
            }
            f5 = (f6 - i12) / (i13 - i12);
        }
        int i28 = i23;
        widgetFrame.f32150a = widgetFrame2.f32150a;
        int i29 = (int) (i28 + ((i9 - i28) * f5));
        widgetFrame.f32151b = i29;
        int i30 = (int) (i11 + (f5 * (i10 - i11)));
        widgetFrame.f32152c = i30;
        float f11 = 1.0f - f3;
        widgetFrame.f32153d = i29 + ((int) ((i6 * f11) + (i21 * f3)));
        widgetFrame.f32154e = i30 + ((int) ((f11 * i22) + (i8 * f3)));
        widgetFrame.f32155f = l(widgetFrame2.f32155f, widgetFrame3.f32155f, 0.5f, f3);
        widgetFrame.f32156g = l(widgetFrame2.f32156g, widgetFrame3.f32156g, 0.5f, f3);
        widgetFrame.f32157h = l(widgetFrame2.f32157h, widgetFrame3.f32157h, 0.0f, f3);
        widgetFrame.f32158i = l(widgetFrame2.f32158i, widgetFrame3.f32158i, 0.0f, f3);
        widgetFrame.f32159j = l(widgetFrame2.f32159j, widgetFrame3.f32159j, 0.0f, f3);
        widgetFrame.f32163n = l(widgetFrame2.f32163n, widgetFrame3.f32163n, 1.0f, f3);
        widgetFrame.f32164o = l(widgetFrame2.f32164o, widgetFrame3.f32164o, 1.0f, f3);
        widgetFrame.f32160k = l(widgetFrame2.f32160k, widgetFrame3.f32160k, 0.0f, f3);
        widgetFrame.f32161l = l(widgetFrame2.f32161l, widgetFrame3.f32161l, 0.0f, f3);
        widgetFrame.f32162m = l(widgetFrame2.f32162m, widgetFrame3.f32162m, 0.0f, f3);
        widgetFrame.f32165p = l(f9, f10, 1.0f, f3);
        Set<String> setKeySet = widgetFrame3.f32168s.keySet();
        widgetFrame.f32168s.clear();
        for (String str : setKeySet) {
            if (widgetFrame2.f32168s.containsKey(str)) {
                CustomVariable customVariable = (CustomVariable) widgetFrame2.f32168s.get(str);
                CustomVariable customVariable2 = (CustomVariable) widgetFrame3.f32168s.get(str);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame.f32168s.put(str, customVariable3);
                if (customVariable.m() == 1) {
                    customVariable3.r(Float.valueOf(l(customVariable.j(), customVariable2.j(), 0.0f, f3)));
                } else {
                    int iM = customVariable.m();
                    float[] fArr = new float[iM];
                    float[] fArr2 = new float[iM];
                    customVariable.k(fArr);
                    customVariable2.k(fArr2);
                    for (int i31 = 0; i31 < iM; i31++) {
                        fArr[i31] = l(fArr[i31], fArr2[i31], 0.0f, f3);
                        customVariable3.s(fArr);
                    }
                }
            }
        }
    }

    private void q(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor constraintAnchorQ = this.f32150a.q(type);
        if (constraintAnchorQ == null || constraintAnchorQ.f32257f == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(type.name());
        sb.append(": ['");
        String str = constraintAnchorQ.f32257f.h().f32299o;
        if (str == null) {
            str = "#PARENT";
        }
        sb.append(str);
        sb.append("', '");
        sb.append(constraintAnchorQ.f32257f.k().name());
        sb.append("', '");
        sb.append(constraintAnchorQ.f32258g);
        sb.append("'],\n");
    }

    public void c(String str, int i3) {
        s(str, 902, i3);
    }

    public void d(String str, float f3) {
        r(str, 901, f3);
    }

    public float e() {
        return this.f32151b + ((this.f32153d - r0) / 2.0f);
    }

    public float f() {
        return this.f32152c + ((this.f32154e - r0) / 2.0f);
    }

    public CustomVariable g(String str) {
        return (CustomVariable) this.f32168s.get(str);
    }

    public Set h() {
        return this.f32168s.keySet();
    }

    public String i() {
        ConstraintWidget constraintWidget = this.f32150a;
        return constraintWidget == null ? "unknown" : constraintWidget.f32299o;
    }

    public TypedBundle j() {
        return this.f32170u;
    }

    public int k() {
        return Math.max(0, this.f32154e - this.f32152c);
    }

    public boolean n() {
        return Float.isNaN(this.f32157h) && Float.isNaN(this.f32158i) && Float.isNaN(this.f32159j) && Float.isNaN(this.f32160k) && Float.isNaN(this.f32161l) && Float.isNaN(this.f32162m) && Float.isNaN(this.f32163n) && Float.isNaN(this.f32164o) && Float.isNaN(this.f32165p);
    }

    public StringBuilder o(StringBuilder sb) {
        return p(sb, false);
    }

    public StringBuilder p(StringBuilder sb, boolean z2) {
        sb.append("{\n");
        b(sb, ViewHierarchyConstants.DIMENSION_LEFT_KEY, this.f32151b);
        b(sb, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.f32152c);
        b(sb, "right", this.f32153d);
        b(sb, "bottom", this.f32154e);
        a(sb, "pivotX", this.f32155f);
        a(sb, "pivotY", this.f32156g);
        a(sb, "rotationX", this.f32157h);
        a(sb, "rotationY", this.f32158i);
        a(sb, "rotationZ", this.f32159j);
        a(sb, "translationX", this.f32160k);
        a(sb, "translationY", this.f32161l);
        a(sb, "translationZ", this.f32162m);
        a(sb, "scaleX", this.f32163n);
        a(sb, "scaleY", this.f32164o);
        a(sb, "alpha", this.f32165p);
        b(sb, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, this.f32167r);
        a(sb, "interpolatedPos", this.f32166q);
        if (this.f32150a != null) {
            for (ConstraintAnchor.Type type : ConstraintAnchor.Type.values()) {
                q(sb, type);
            }
        }
        if (z2) {
            a(sb, "phone_orientation", f32149v);
        }
        if (z2) {
            a(sb, "phone_orientation", f32149v);
        }
        if (this.f32168s.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.f32168s.keySet()) {
                CustomVariable customVariable = (CustomVariable) this.f32168s.get(str);
                sb.append(str);
                sb.append(": ");
                switch (customVariable.i()) {
                    case 900:
                        sb.append(customVariable.f());
                        sb.append(",\n");
                        break;
                    case 901:
                    case 905:
                        sb.append(customVariable.e());
                        sb.append(",\n");
                        break;
                    case 902:
                        sb.append("'");
                        sb.append(CustomVariable.b(customVariable.f()));
                        sb.append("',\n");
                        break;
                    case 903:
                        sb.append("'");
                        sb.append(customVariable.h());
                        sb.append("',\n");
                        break;
                    case 904:
                        sb.append("'");
                        sb.append(customVariable.d());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void r(String str, int i3, float f3) {
        if (this.f32168s.containsKey(str)) {
            ((CustomVariable) this.f32168s.get(str)).o(f3);
        } else {
            this.f32168s.put(str, new CustomVariable(str, i3, f3));
        }
    }

    public void s(String str, int i3, int i4) {
        if (this.f32168s.containsKey(str)) {
            ((CustomVariable) this.f32168s.get(str)).p(i4);
        } else {
            this.f32168s.put(str, new CustomVariable(str, i3, i4));
        }
    }

    public void t(String str, int i3, boolean z2) {
        if (this.f32168s.containsKey(str)) {
            ((CustomVariable) this.f32168s.get(str)).n(z2);
        } else {
            this.f32168s.put(str, new CustomVariable(str, i3, z2));
        }
    }

    void u(TypedBundle typedBundle) {
        this.f32170u = typedBundle;
    }

    public WidgetFrame v() {
        ConstraintWidget constraintWidget = this.f32150a;
        if (constraintWidget != null) {
            this.f32151b = constraintWidget.G();
            this.f32152c = this.f32150a.U();
            this.f32153d = this.f32150a.P();
            this.f32154e = this.f32150a.t();
            x(this.f32150a.f32297n);
        }
        return this;
    }

    public WidgetFrame w(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.f32150a = constraintWidget;
        v();
        return this;
    }

    public void x(WidgetFrame widgetFrame) {
        if (widgetFrame == null) {
            return;
        }
        this.f32155f = widgetFrame.f32155f;
        this.f32156g = widgetFrame.f32156g;
        this.f32157h = widgetFrame.f32157h;
        this.f32158i = widgetFrame.f32158i;
        this.f32159j = widgetFrame.f32159j;
        this.f32160k = widgetFrame.f32160k;
        this.f32161l = widgetFrame.f32161l;
        this.f32162m = widgetFrame.f32162m;
        this.f32163n = widgetFrame.f32163n;
        this.f32164o = widgetFrame.f32164o;
        this.f32165p = widgetFrame.f32165p;
        this.f32167r = widgetFrame.f32167r;
        u(widgetFrame.f32170u);
        this.f32168s.clear();
        for (CustomVariable customVariable : widgetFrame.f32168s.values()) {
            this.f32168s.put(customVariable.g(), customVariable.c());
        }
    }

    public int y() {
        return Math.max(0, this.f32153d - this.f32151b);
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.f32150a = null;
        this.f32151b = 0;
        this.f32152c = 0;
        this.f32153d = 0;
        this.f32154e = 0;
        this.f32155f = Float.NaN;
        this.f32156g = Float.NaN;
        this.f32157h = Float.NaN;
        this.f32158i = Float.NaN;
        this.f32159j = Float.NaN;
        this.f32160k = Float.NaN;
        this.f32161l = Float.NaN;
        this.f32162m = Float.NaN;
        this.f32163n = Float.NaN;
        this.f32164o = Float.NaN;
        this.f32165p = Float.NaN;
        this.f32166q = Float.NaN;
        this.f32167r = 0;
        this.f32168s = new HashMap();
        this.f32169t = null;
        this.f32150a = constraintWidget;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.f32150a = null;
        this.f32151b = 0;
        this.f32152c = 0;
        this.f32153d = 0;
        this.f32154e = 0;
        this.f32155f = Float.NaN;
        this.f32156g = Float.NaN;
        this.f32157h = Float.NaN;
        this.f32158i = Float.NaN;
        this.f32159j = Float.NaN;
        this.f32160k = Float.NaN;
        this.f32161l = Float.NaN;
        this.f32162m = Float.NaN;
        this.f32163n = Float.NaN;
        this.f32164o = Float.NaN;
        this.f32165p = Float.NaN;
        this.f32166q = Float.NaN;
        this.f32167r = 0;
        this.f32168s = new HashMap();
        this.f32169t = null;
        this.f32150a = widgetFrame.f32150a;
        this.f32151b = widgetFrame.f32151b;
        this.f32152c = widgetFrame.f32152c;
        this.f32153d = widgetFrame.f32153d;
        this.f32154e = widgetFrame.f32154e;
        x(widgetFrame);
    }
}
