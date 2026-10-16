package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionWidget implements TypedValues {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WidgetFrame f31605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Motion f31606b = new Motion();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    PropertySet f31607c = new PropertySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f31608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f31609e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Motion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f31610a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f31611b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f31612c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f31613d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f31614e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f31615f = Float.NaN;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f31616g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f31617h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f31618i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f31619j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f31620k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f31621l = -3;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f31622m = -1;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PropertySet {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31623a = 4;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f31624b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f31625c = 1.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f31626d = Float.NaN;
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.f31605a = new WidgetFrame();
        this.f31605a = widgetFrame;
    }

    public WidgetFrame A() {
        return this.f31605a;
    }

    public int B() {
        WidgetFrame widgetFrame = this.f31605a;
        return widgetFrame.f32153d - widgetFrame.f32151b;
    }

    public int C() {
        return this.f31605a.f32151b;
    }

    public int D() {
        return this.f31605a.f32152c;
    }

    public void E(int i3, int i4, int i5, int i6) {
        F(i3, i4, i5, i6);
    }

    public void F(int i3, int i4, int i5, int i6) {
        if (this.f31605a == null) {
            this.f31605a = new WidgetFrame((ConstraintWidget) null);
        }
        WidgetFrame widgetFrame = this.f31605a;
        widgetFrame.f32152c = i4;
        widgetFrame.f32151b = i3;
        widgetFrame.f32153d = i5;
        widgetFrame.f32154e = i6;
    }

    public void G(String str, int i3, float f3) {
        this.f31605a.r(str, i3, f3);
    }

    public void H(String str, int i3, int i4) {
        this.f31605a.s(str, i3, i4);
    }

    public void I(String str, int i3, boolean z2) {
        this.f31605a.t(str, i3, z2);
    }

    public void J(float f3) {
        this.f31605a.f32155f = f3;
    }

    public void K(float f3) {
        this.f31605a.f32156g = f3;
    }

    public void L(float f3) {
        this.f31605a.f32159j = f3;
    }

    public boolean M(int i3, float f3) {
        switch (i3) {
            case 303:
                this.f31605a.f32165p = f3;
                return true;
            case RCHTTPStatusCodes.NOT_MODIFIED /* 304 */:
                this.f31605a.f32160k = f3;
                return true;
            case 305:
                this.f31605a.f32161l = f3;
                return true;
            case 306:
                this.f31605a.f32162m = f3;
                return true;
            case 307:
            default:
                return false;
            case 308:
                this.f31605a.f32157h = f3;
                return true;
            case 309:
                this.f31605a.f32158i = f3;
                return true;
            case 310:
                this.f31605a.f32159j = f3;
                return true;
            case 311:
                this.f31605a.f32163n = f3;
                return true;
            case 312:
                this.f31605a.f32164o = f3;
                return true;
            case 313:
                this.f31605a.f32155f = f3;
                return true;
            case 314:
                this.f31605a.f32156g = f3;
                return true;
            case 315:
                this.f31608d = f3;
                return true;
            case 316:
                this.f31609e = f3;
                return true;
        }
    }

    public boolean N(int i3, float f3) {
        switch (i3) {
            case 600:
                this.f31606b.f31615f = f3;
                return true;
            case 601:
                this.f31606b.f31617h = f3;
                return true;
            case 602:
                this.f31606b.f31618i = f3;
                return true;
            default:
                return false;
        }
    }

    public boolean O(int i3, int i4) {
        switch (i3) {
            case 606:
                this.f31606b.f31611b = i4;
                return true;
            case 607:
                this.f31606b.f31613d = i4;
                return true;
            case 608:
                this.f31606b.f31614e = i4;
                return true;
            case 609:
                this.f31606b.f31616g = i4;
                return true;
            case 610:
                this.f31606b.f31619j = i4;
                return true;
            case 611:
                this.f31606b.f31621l = i4;
                return true;
            case 612:
                this.f31606b.f31622m = i4;
                return true;
            default:
                return false;
        }
    }

    public boolean P(int i3, String str) {
        if (i3 == 603) {
            this.f31606b.f31612c = str;
            return true;
        }
        if (i3 != 604) {
            return false;
        }
        this.f31606b.f31620k = str;
        return true;
    }

    public void Q(int i3) {
        this.f31607c.f31623a = i3;
    }

    public void R(TypedValues typedValues) {
        if (this.f31605a.j() != null) {
            this.f31605a.j().g(typedValues);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int a(String str) {
        int iA = TypedValues.AttributesType.a(str);
        return iA != -1 ? iA : TypedValues.MotionType.a(str);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean b(int i3, int i4) {
        if (M(i3, i4)) {
            return true;
        }
        return O(i3, i4);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean c(int i3, float f3) {
        if (M(i3, f3)) {
            return true;
        }
        return N(i3, f3);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean d(int i3, boolean z2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean e(int i3, String str) {
        if (i3 != 605) {
            return P(i3, str);
        }
        this.f31606b.f31610a = str;
        return true;
    }

    public MotionWidget f(int i3) {
        return null;
    }

    public float g() {
        return this.f31605a.f32165p;
    }

    public int h() {
        return this.f31605a.f32154e;
    }

    public CustomVariable i(String str) {
        return this.f31605a.g(str);
    }

    public Set j() {
        return this.f31605a.h();
    }

    public int k() {
        WidgetFrame widgetFrame = this.f31605a;
        return widgetFrame.f32154e - widgetFrame.f32152c;
    }

    public int l() {
        return this.f31605a.f32151b;
    }

    public MotionWidget m() {
        return null;
    }

    public float n() {
        return this.f31605a.f32155f;
    }

    public float o() {
        return this.f31605a.f32156g;
    }

    public int p() {
        return this.f31605a.f32153d;
    }

    public float q() {
        return this.f31605a.f32157h;
    }

    public float r() {
        return this.f31605a.f32158i;
    }

    public float s() {
        return this.f31605a.f32159j;
    }

    public float t() {
        return this.f31605a.f32163n;
    }

    public String toString() {
        return this.f31605a.f32151b + ", " + this.f31605a.f32152c + ", " + this.f31605a.f32153d + ", " + this.f31605a.f32154e;
    }

    public float u() {
        return this.f31605a.f32164o;
    }

    public int v() {
        return this.f31605a.f32152c;
    }

    public float w() {
        return this.f31605a.f32160k;
    }

    public float x() {
        return this.f31605a.f32161l;
    }

    public float y() {
        return this.f31605a.f32162m;
    }

    public int z() {
        return this.f31607c.f31623a;
    }
}
