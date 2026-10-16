package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Transition implements TypedValues {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap f32091a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap f32092b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedBundle f32093c = new TypedBundle();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32094d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f32095e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Easing f32096f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32097g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32098h = RCHTTPStatusCodes.BAD_REQUEST;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f32099i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private OnSwipe f32100j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final CorePixelDp f32101k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f32102l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f32103m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f32104n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f32105o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f32106p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f32107q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f32108r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class KeyPosition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f32110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f32111c;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    static class OnSwipe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f32118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private StopEngine f32120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f32121d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f32122e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f32123f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f32124g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f32125h = 1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f32126i = 10.0f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f32127j = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f32128k = 4.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private float f32129l = 1.2f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f32130m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private float f32131n = 1.0f;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private float f32132o = 400.0f;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private float f32133p = 10.0f;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private float f32134q = 0.01f;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private float f32135r = 0.0f;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f32136s = 0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private long f32137t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final String[] f32112u = {ViewHierarchyConstants.DIMENSION_TOP_KEY, ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "bottom", "middle", "start", "end"};

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static final float[][] f32113v = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final String[] f32114w = {"up", "down", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "start", "end", "clockwise", "anticlockwise"};

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final String[] f32115x = {"velocity", "spring"};

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final String[] f32116y = {"autocomplete", "toStart", tDEtWsFLJfe.Divd, "stop", "decelerate", "decelerateComplete", "neverCompleteStart", "neverCompleteEnd"};

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final String[] f32117z = {"overshoot", "bounceStart", "bounceEnd", "bounceBoth"};
        private static final float[][] A = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

        OnSwipe() {
        }

        void a(float f3, float f4, long j3, float f5) {
            SpringStopEngine springStopEngine;
            StopLogicEngine stopLogicEngine;
            StopLogicEngine.Decelerate decelerate;
            this.f32137t = j3;
            float fAbs = Math.abs(f4);
            float f6 = this.f32128k;
            if (fAbs > f6) {
                f4 = Math.signum(f4) * f6;
            }
            float f7 = f4;
            float fB = b(f3, f7, f5);
            this.f32135r = fB;
            if (fB == f3) {
                this.f32120c = null;
                return;
            }
            if (this.f32130m == 4 && this.f32127j == 0) {
                StopEngine stopEngine = this.f32120c;
                if (stopEngine instanceof StopLogicEngine.Decelerate) {
                    decelerate = (StopLogicEngine.Decelerate) stopEngine;
                } else {
                    decelerate = new StopLogicEngine.Decelerate();
                    this.f32120c = decelerate;
                }
                decelerate.c(f3, this.f32135r, f7);
                return;
            }
            if (this.f32127j == 0) {
                StopEngine stopEngine2 = this.f32120c;
                if (stopEngine2 instanceof StopLogicEngine) {
                    stopLogicEngine = (StopLogicEngine) stopEngine2;
                } else {
                    stopLogicEngine = new StopLogicEngine();
                    this.f32120c = stopLogicEngine;
                }
                stopLogicEngine.d(f3, this.f32135r, f7, f5, this.f32129l, this.f32128k);
                return;
            }
            StopEngine stopEngine3 = this.f32120c;
            if (stopEngine3 instanceof SpringStopEngine) {
                springStopEngine = (SpringStopEngine) stopEngine3;
            } else {
                springStopEngine = new SpringStopEngine();
                this.f32120c = springStopEngine;
            }
            springStopEngine.d(f3, this.f32135r, f7, this.f32131n, this.f32132o, this.f32133p, this.f32134q, this.f32136s);
        }

        float b(float f3, float f4, float f5) {
            float fAbs = (((Math.abs(f4) * 0.5f) * f4) / this.f32129l) + f3;
            switch (this.f32130m) {
                case 1:
                    return f3 >= 1.0f ? 1.0f : 0.0f;
                case 2:
                    return f3 <= 0.0f ? 0.0f : 1.0f;
                case 3:
                    return Float.NaN;
                case 4:
                    return Math.max(0.0f, Math.min(1.0f, fAbs));
                case 5:
                    return (fAbs <= 0.2f || fAbs >= 0.8f) ? fAbs > 0.5f ? 1.0f : 0.0f : fAbs;
                case 6:
                    return 1.0f;
                default:
                    if (fAbs > 0.5d) {
                        return 1.0f;
                    }
                case 7:
                    return 0.0f;
            }
        }

        float[] c() {
            return A[this.f32124g];
        }

        float d() {
            return this.f32125h;
        }

        float[] e() {
            return f32113v[this.f32119b];
        }

        public float f(long j3) {
            return this.f32120c.b() ? this.f32135r : this.f32120c.getInterpolation((j3 - this.f32137t) * 1.0E-9f);
        }

        public boolean g(float f3) {
            StopEngine stopEngine;
            return (this.f32130m == 3 || (stopEngine = this.f32120c) == null || stopEngine.b()) ? false : true;
        }

        void h(String str) {
            this.f32118a = str;
        }

        void i(int i3) {
            this.f32119b = i3;
        }

        void j(int i3) {
            this.f32127j = i3;
        }

        void k(int i3) {
            this.f32124g = i3;
            this.f32123f = i3 < 2;
        }

        void l(float f3) {
            if (Float.isNaN(f3)) {
                return;
            }
            this.f32125h = f3;
        }

        void m(float f3) {
            if (Float.isNaN(f3)) {
                return;
            }
            this.f32126i = f3;
        }

        void n(String str) {
            this.f32122e = str;
        }

        void o(float f3) {
            if (Float.isNaN(f3)) {
                return;
            }
            this.f32129l = f3;
        }

        void p(float f3) {
            if (Float.isNaN(f3)) {
                return;
            }
            this.f32128k = f3;
        }

        void q(int i3) {
            this.f32130m = i3;
        }

        void r(String str) {
            this.f32121d = str;
        }

        void s(int i3) {
            this.f32136s = i3;
        }

        void t(float f3) {
            if (Float.isNaN(f3)) {
                return;
            }
            this.f32133p = f3;
        }

        void u(float f3) {
            if (Float.isNaN(f3)) {
                return;
            }
            this.f32131n = f3;
        }

        void v(float f3) {
            if (Float.isNaN(f3)) {
                return;
            }
            this.f32132o = f3;
        }

        void w(float f3) {
            if (Float.isNaN(f3)) {
                return;
            }
            this.f32134q = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class WidgetState {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Motion f32141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f32142e = true;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        KeyCache f32146i = new KeyCache();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f32147j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f32148k = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WidgetFrame f32138a = new WidgetFrame();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        WidgetFrame f32139b = new WidgetFrame();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        WidgetFrame f32140c = new WidgetFrame();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        MotionWidget f32143f = new MotionWidget(this.f32138a);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        MotionWidget f32144g = new MotionWidget(this.f32139b);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        MotionWidget f32145h = new MotionWidget(this.f32140c);

        public WidgetState() {
            Motion motion = new Motion(this.f32143f);
            this.f32141d = motion;
            motion.z(this.f32143f);
            this.f32141d.v(this.f32144g);
        }

        public WidgetFrame a(int i3) {
            return i3 == 0 ? this.f32138a : i3 == 1 ? this.f32139b : this.f32140c;
        }

        String b() {
            return this.f32141d.j();
        }

        public void c(int i3, int i4, float f3, Transition transition) {
            this.f32147j = i4;
            this.f32148k = i3;
            if (this.f32142e) {
                this.f32141d.B(i3, i4, 1.0f, System.nanoTime());
                this.f32142e = false;
            }
            WidgetFrame.m(i3, i4, this.f32140c, this.f32138a, this.f32139b, transition, f3);
            this.f32140c.f32166q = f3;
            this.f32141d.t(this.f32145h, f3, System.nanoTime(), this.f32146i);
        }

        public void d(TypedBundle typedBundle, CustomVariable[] customVariableArr) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.g(motionKeyAttributes);
            if (customVariableArr != null) {
                for (int i3 = 0; i3 < customVariableArr.length; i3++) {
                    motionKeyAttributes.f31632e.put(customVariableArr[i3].g(), customVariableArr[i3]);
                }
            }
            this.f32141d.f(motionKeyAttributes);
        }

        public void e(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.g(motionKeyCycle);
            this.f32141d.f(motionKeyCycle);
        }

        public void f(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.g(motionKeyPosition);
            this.f32141d.f(motionKeyPosition);
        }

        public void g(WidgetState widgetState) {
            this.f32141d.D(widgetState.f32141d);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void h(ConstraintWidget constraintWidget, int i3) {
            if (i3 == 0) {
                this.f32138a.w(constraintWidget);
                MotionWidget motionWidget = this.f32143f;
                motionWidget.R(motionWidget);
                this.f32141d.z(this.f32143f);
                this.f32142e = true;
            } else if (i3 == 1) {
                this.f32139b.w(constraintWidget);
                this.f32141d.v(this.f32144g);
                this.f32142e = true;
            }
            this.f32148k = -1;
        }
    }

    public Transition(CorePixelDp corePixelDp) {
        this.f32101k = corePixelDp;
    }

    private void l(float f3) {
        this.f32106p = (int) (this.f32102l + 0.5f + ((this.f32104n - r0) * f3));
        this.f32107q = (int) (this.f32103m + 0.5f + ((this.f32105o - r0) * f3));
    }

    public WidgetFrame A(ConstraintWidget constraintWidget) {
        return D(constraintWidget.f32299o, null, 0).f32138a;
    }

    public WidgetFrame B(String str) {
        WidgetState widgetState = (WidgetState) this.f32092b.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f32138a;
    }

    public float C(long j3) {
        OnSwipe onSwipe = this.f32100j;
        if (onSwipe != null) {
            return onSwipe.f(j3);
        }
        return 0.0f;
    }

    public WidgetState D(String str, ConstraintWidget constraintWidget, int i3) {
        WidgetState widgetState = (WidgetState) this.f32092b.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            this.f32093c.g(widgetState.f32141d);
            widgetState.f32143f.R(widgetState.f32141d);
            this.f32092b.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.h(constraintWidget, i3);
            }
        }
        return widgetState;
    }

    public boolean E() {
        return this.f32100j != null;
    }

    public boolean F() {
        return this.f32091a.size() > 0;
    }

    public void G(int i3, int i4, float f3) {
        if (this.f32108r) {
            l(f3);
        }
        Easing easing = this.f32096f;
        if (easing != null) {
            f3 = (float) easing.a(f3);
        }
        Iterator it = this.f32092b.keySet().iterator();
        while (it.hasNext()) {
            ((WidgetState) this.f32092b.get((String) it.next())).c(i3, i4, f3, this);
        }
    }

    public boolean H() {
        return this.f32092b.isEmpty();
    }

    public boolean I(float f3, float f4) {
        OnSwipe onSwipe = this.f32100j;
        if (onSwipe == null) {
            return false;
        }
        String str = onSwipe.f32122e;
        if (str == null) {
            return true;
        }
        WidgetState widgetState = (WidgetState) this.f32092b.get(str);
        if (widgetState == null) {
            System.err.println("mLimitBoundsTo target is null");
            return false;
        }
        WidgetFrame widgetFrameA = widgetState.a(2);
        return f3 >= ((float) widgetFrameA.f32151b) && f3 < ((float) widgetFrameA.f32153d) && f4 >= ((float) widgetFrameA.f32152c) && f4 < ((float) widgetFrameA.f32154e);
    }

    public boolean J(float f3) {
        return this.f32100j.g(f3);
    }

    void K() {
        this.f32100j = null;
        this.f32093c.h();
    }

    public void L(float f3, long j3, float f4, float f5) {
        OnSwipe onSwipe = this.f32100j;
        if (onSwipe != null) {
            WidgetState widgetState = (WidgetState) this.f32092b.get(onSwipe.f32118a);
            float[] fArr = new float[2];
            float[] fArrC = this.f32100j.c();
            float[] fArrE = this.f32100j.e();
            widgetState.f32141d.l(f3, fArrE[0], fArrE[1], fArr);
            if (Math.abs((fArrC[0] * fArr[0]) + (fArrC[1] * fArr[1])) < 0.01d) {
                fArr[0] = 0.01f;
                fArr[1] = 0.01f;
            }
            this.f32100j.a(f3, (fArrC[0] != 0.0f ? f4 / fArr[0] : f5 / fArr[1]) * this.f32100j.d(), j3, this.f32098h * 0.001f);
        }
    }

    public void M(TypedBundle typedBundle) {
        typedBundle.f(this.f32093c);
        typedBundle.g(this);
    }

    public void N(ConstraintWidgetContainer constraintWidgetContainer, int i3) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidgetContainer.f32274b0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = dimensionBehaviour == dimensionBehaviour2;
        this.f32108r = z2;
        this.f32108r = z2 | (dimensionBehaviourArr[1] == dimensionBehaviour2);
        if (i3 == 0) {
            int iA0 = constraintWidgetContainer.a0();
            this.f32102l = iA0;
            this.f32106p = iA0;
            int iZ = constraintWidgetContainer.z();
            this.f32103m = iZ;
            this.f32107q = iZ;
        } else {
            this.f32104n = constraintWidgetContainer.a0();
            this.f32105o = constraintWidgetContainer.z();
        }
        ArrayList arrayListZ1 = constraintWidgetContainer.z1();
        int size = arrayListZ1.size();
        WidgetState[] widgetStateArr = new WidgetState[size];
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayListZ1.get(i4);
            WidgetState widgetStateD = D(constraintWidget.f32299o, null, i3);
            widgetStateArr[i4] = widgetStateD;
            widgetStateD.h(constraintWidget, i3);
            String strB = widgetStateD.b();
            if (strB != null) {
                widgetStateD.g(D(strB, null, i3));
            }
        }
        k();
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int a(String str) {
        return 0;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean b(int i3, int i4) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean c(int i3, float f3) {
        if (i3 != 706) {
            return false;
        }
        this.f32099i = f3;
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean d(int i3, boolean z2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean e(int i3, String str) {
        if (i3 != 705) {
            return false;
        }
        this.f32095e = str;
        this.f32096f = Easing.c(str);
        return false;
    }

    public void f(int i3, String str, String str2, int i4) {
        D(str, null, i3).a(i3).c(str2, i4);
    }

    public void g(int i3, String str, String str2, float f3) {
        D(str, null, i3).a(i3).d(str2, f3);
    }

    public void h(String str, TypedBundle typedBundle, CustomVariable[] customVariableArr) {
        D(str, null, 0).d(typedBundle, customVariableArr);
    }

    public void i(String str, TypedBundle typedBundle) {
        D(str, null, 0).e(typedBundle);
    }

    public void j(String str, TypedBundle typedBundle) {
        D(str, null, 0).f(typedBundle);
    }

    public void k() {
        float fMin;
        float fMax;
        float f3 = this.f32099i;
        if (f3 == 0.0f) {
            return;
        }
        boolean z2 = ((double) f3) < 0.0d;
        float fAbs = Math.abs(f3);
        Iterator it = this.f32092b.keySet().iterator();
        do {
            fMin = Float.MAX_VALUE;
            fMax = -3.4028235E38f;
            if (!it.hasNext()) {
                Iterator it2 = this.f32092b.keySet().iterator();
                while (it2.hasNext()) {
                    Motion motion = ((WidgetState) this.f32092b.get((String) it2.next())).f32141d;
                    float fM = motion.m() + motion.n();
                    fMin = Math.min(fMin, fM);
                    fMax = Math.max(fMax, fM);
                }
                Iterator it3 = this.f32092b.keySet().iterator();
                while (it3.hasNext()) {
                    Motion motion2 = ((WidgetState) this.f32092b.get((String) it3.next())).f32141d;
                    float fM2 = motion2.m() + motion2.n();
                    float f4 = fMax - fMin;
                    float f5 = fAbs - (((fM2 - fMin) * fAbs) / f4);
                    if (z2) {
                        f5 = fAbs - (((fMax - fM2) / f4) * fAbs);
                    }
                    motion2.y(1.0f / (1.0f - fAbs));
                    motion2.x(f5);
                }
                return;
            }
        } while (Float.isNaN(((WidgetState) this.f32092b.get((String) it.next())).f32141d.p()));
        Iterator it4 = this.f32092b.keySet().iterator();
        while (it4.hasNext()) {
            float fP = ((WidgetState) this.f32092b.get((String) it4.next())).f32141d.p();
            if (!Float.isNaN(fP)) {
                fMin = Math.min(fMin, fP);
                fMax = Math.max(fMax, fP);
            }
        }
        Iterator it5 = this.f32092b.keySet().iterator();
        while (it5.hasNext()) {
            Motion motion3 = ((WidgetState) this.f32092b.get((String) it5.next())).f32141d;
            float fP2 = motion3.p();
            if (!Float.isNaN(fP2)) {
                float f6 = 1.0f / (1.0f - fAbs);
                float f7 = fMax - fMin;
                float f8 = fAbs - (((fP2 - fMin) * fAbs) / f7);
                if (z2) {
                    f8 = fAbs - (((fMax - fP2) / f7) * fAbs);
                }
                motion3.y(f6);
                motion3.x(f8);
            }
        }
    }

    public void m() {
        this.f32092b.clear();
    }

    OnSwipe n() {
        OnSwipe onSwipe = new OnSwipe();
        this.f32100j = onSwipe;
        return onSwipe;
    }

    public float o(float f3, int i3, int i4, float f4, float f5) {
        float fAbs;
        float fD;
        Iterator it = this.f32092b.values().iterator();
        WidgetState widgetState = it.hasNext() ? (WidgetState) it.next() : null;
        OnSwipe onSwipe = this.f32100j;
        if (onSwipe == null || widgetState == null) {
            if (widgetState != null) {
                return (-f5) / widgetState.f32147j;
            }
            return 1.0f;
        }
        String str = onSwipe.f32118a;
        if (str == null) {
            float[] fArrC = onSwipe.c();
            int i5 = widgetState.f32147j;
            float f6 = i5;
            float f7 = i5;
            float f8 = fArrC[0];
            fAbs = f8 != 0.0f ? (f4 * Math.abs(f8)) / f6 : (f5 * Math.abs(fArrC[1])) / f7;
            fD = this.f32100j.d();
        } else {
            WidgetState widgetState2 = (WidgetState) this.f32092b.get(str);
            float[] fArrC2 = this.f32100j.c();
            float[] fArrE = this.f32100j.e();
            float[] fArr = new float[2];
            widgetState2.c(i3, i4, f3, this);
            widgetState2.f32141d.l(f3, fArrE[0], fArrE[1], fArr);
            float f9 = fArrC2[0];
            fAbs = f9 != 0.0f ? (f4 * Math.abs(f9)) / fArr[0] : (f5 * Math.abs(fArrC2[1])) / fArr[1];
            fD = this.f32100j.d();
        }
        return fAbs * fD;
    }

    public KeyPosition p(String str, int i3) {
        KeyPosition keyPosition;
        while (i3 <= 100) {
            HashMap map = (HashMap) this.f32091a.get(Integer.valueOf(i3));
            if (map != null && (keyPosition = (KeyPosition) map.get(str)) != null) {
                return keyPosition;
            }
            i3++;
        }
        return null;
    }

    public KeyPosition q(String str, int i3) {
        KeyPosition keyPosition;
        while (i3 >= 0) {
            HashMap map = (HashMap) this.f32091a.get(Integer.valueOf(i3));
            if (map != null && (keyPosition = (KeyPosition) map.get(str)) != null) {
                return keyPosition;
            }
            i3--;
        }
        return null;
    }

    public WidgetFrame r(ConstraintWidget constraintWidget) {
        return D(constraintWidget.f32299o, null, 1).f32139b;
    }

    public WidgetFrame s(String str) {
        WidgetState widgetState = (WidgetState) this.f32092b.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f32139b;
    }

    public WidgetFrame t(ConstraintWidget constraintWidget) {
        return D(constraintWidget.f32299o, null, 2).f32140c;
    }

    public WidgetFrame u(String str) {
        WidgetState widgetState = (WidgetState) this.f32092b.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f32140c;
    }

    public int v() {
        return this.f32107q;
    }

    public int w() {
        return this.f32106p;
    }

    public int x(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return ((WidgetState) this.f32092b.get(str)).f32141d.g(fArr, iArr, iArr2);
    }

    public Motion y(String str) {
        return D(str, null, 0).f32141d;
    }

    public float[] z(String str) {
        float[] fArr = new float[124];
        ((WidgetState) this.f32092b.get(str)).f32141d.h(fArr, 62);
        return fArr;
    }
}
