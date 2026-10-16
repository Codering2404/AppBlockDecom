package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class State {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Integer f32027k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CorePixelDp f32028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f32029b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected HashMap f32030c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected HashMap f32031d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    HashMap f32032e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintReference f32033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayList f32035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ArrayList f32036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f32037j;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 androidx.constraintlayout.core.state.State$Chain, still in use, count: 1, list:
      (r0v0 androidx.constraintlayout.core.state.State$Chain) from 0x0044: INVOKE 
      (wrap:java.util.Map:0x0040: SGET  A[WRAPPED] (LINE:65) androidx.constraintlayout.core.state.State.Chain.d java.util.Map)
      ("spread")
      (r0v0 androidx.constraintlayout.core.state.State$Chain)
     INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:69)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED;


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static Map f32041d = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static Map f32042f = new HashMap();

        static {
            f32041d.put("packed", new Chain());
            f32041d.put("spread_inside", new Chain());
            f32041d.put("spread", new Chain());
            f32042f.put("packed", 2);
            f32042f.put("spread_inside", 1);
            f32042f.put("spread", 0);
        }

        private Chain() {
        }

        public static int b(String str) {
            if (f32042f.containsKey(str)) {
                return ((Integer) f32042f.get(str)).intValue();
            }
            return -1;
        }

        public static Chain valueOf(String str) {
            return (Chain) Enum.valueOf(Chain.class, str);
        }

        public static Chain[] values() {
            return (Chain[]) f32043g.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        TOP_TO_BASELINE,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BOTTOM_TO_BASELINE,
        BASELINE_TO_BASELINE,
        BASELINE_TO_TOP,
        BASELINE_TO_BOTTOM,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        HORIZONTAL_FLOW,
        VERTICAL_FLOW,
        GRID,
        ROW,
        COLUMN,
        FLOW
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 androidx.constraintlayout.core.state.State$Wrap, still in use, count: 1, list:
      (r0v0 androidx.constraintlayout.core.state.State$Wrap) from 0x0036: INVOKE 
      (wrap:java.util.Map:0x0032: SGET  A[WRAPPED] (LINE:51) androidx.constraintlayout.core.state.State.Wrap.d java.util.Map)
      (wrap:java.lang.String:SGET  A[WRAPPED] com.facebook.appevents.integrity.IntegrityManager.INTEGRITY_TYPE_NONE java.lang.String)
      (r0v0 androidx.constraintlayout.core.state.State$Wrap)
     INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:55)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Wrap {
        NONE,
        CHAIN,
        ALIGNED;


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static Map f32088d = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static Map f32089f = new HashMap();

        static {
            f32088d.put(IntegrityManager.INTEGRITY_TYPE_NONE, new Wrap());
            f32088d.put("chain", new Wrap());
            f32088d.put("aligned", new Wrap());
            f32089f.put(IntegrityManager.INTEGRITY_TYPE_NONE, 0);
            f32089f.put("chain", 3);
            f32089f.put("aligned", 2);
        }

        private Wrap() {
        }

        public static int b(String str) {
            if (f32089f.containsKey(str)) {
                return ((Integer) f32089f.get(str)).intValue();
            }
            return -1;
        }

        public static Wrap valueOf(String str) {
            return (Wrap) Enum.valueOf(Wrap.class, str);
        }

        public static Wrap[] values() {
            return (Wrap[]) f32090g.clone();
        }
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.f32033f = constraintReference;
        this.f32034g = 0;
        this.f32035h = new ArrayList();
        this.f32036i = new ArrayList();
        this.f32037j = true;
        Integer num = f32027k;
        constraintReference.c(num);
        this.f32030c.put(num, constraintReference);
    }

    private String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i3 = this.f32034g;
        this.f32034g = i3 + 1;
        sb.append(i3);
        sb.append("__");
        return sb.toString();
    }

    public void A(String str, String str2) {
        ArrayList arrayList;
        ConstraintReference constraintReferenceD = d(str);
        if (constraintReferenceD != null) {
            constraintReferenceD.b0(str2);
            if (this.f32032e.containsKey(str2)) {
                arrayList = (ArrayList) this.f32032e.get(str2);
            } else {
                arrayList = new ArrayList();
                this.f32032e.put(str2, arrayList);
            }
            arrayList.add(str);
        }
    }

    public State B(Dimension dimension) {
        this.f32033f.f0(dimension);
        return this;
    }

    public VerticalChainReference C() {
        return (VerticalChainReference) n(null, Helper.VERTICAL_CHAIN);
    }

    public GuidelineReference D(Object obj) {
        return l(obj, 1);
    }

    public State E(Dimension dimension) {
        return B(dimension);
    }

    public void a(ConstraintWidgetContainer constraintWidgetContainer) {
        HelperReference helperReference;
        HelperWidget helperWidgetU0;
        HelperWidget helperWidgetU02;
        constraintWidgetContainer.C1();
        this.f32033f.E().a(this, constraintWidgetContainer, 0);
        this.f32033f.C().a(this, constraintWidgetContainer, 1);
        for (Object obj : this.f32031d.keySet()) {
            HelperWidget helperWidgetU03 = ((HelperReference) this.f32031d.get(obj)).u0();
            if (helperWidgetU03 != null) {
                Reference referenceD = (Reference) this.f32030c.get(obj);
                if (referenceD == null) {
                    referenceD = d(obj);
                }
                referenceD.b(helperWidgetU03);
            }
        }
        for (Object obj2 : this.f32030c.keySet()) {
            Reference reference = (Reference) this.f32030c.get(obj2);
            if (reference != this.f32033f && (reference.d() instanceof HelperReference) && (helperWidgetU02 = ((HelperReference) reference.d()).u0()) != null) {
                Reference referenceD2 = (Reference) this.f32030c.get(obj2);
                if (referenceD2 == null) {
                    referenceD2 = d(obj2);
                }
                referenceD2.b(helperWidgetU02);
            }
        }
        Iterator it = this.f32030c.keySet().iterator();
        while (it.hasNext()) {
            Reference reference2 = (Reference) this.f32030c.get(it.next());
            if (reference2 != this.f32033f) {
                ConstraintWidget constraintWidgetA = reference2.a();
                constraintWidgetA.J0(reference2.getKey().toString());
                constraintWidgetA.j1(null);
                if (reference2.d() instanceof GuidelineReference) {
                    reference2.apply();
                }
                constraintWidgetContainer.a(constraintWidgetA);
            } else {
                reference2.b(constraintWidgetContainer);
            }
        }
        Iterator it2 = this.f32031d.keySet().iterator();
        while (it2.hasNext()) {
            HelperReference helperReference2 = (HelperReference) this.f32031d.get(it2.next());
            if (helperReference2.u0() != null) {
                ArrayList arrayList = helperReference2.f32023o0;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj3 = arrayList.get(i3);
                    i3++;
                    helperReference2.u0().a(((Reference) this.f32030c.get(obj3)).a());
                }
                helperReference2.apply();
            } else {
                helperReference2.apply();
            }
        }
        Iterator it3 = this.f32030c.keySet().iterator();
        while (it3.hasNext()) {
            Reference reference3 = (Reference) this.f32030c.get(it3.next());
            if (reference3 != this.f32033f && (reference3.d() instanceof HelperReference) && (helperWidgetU0 = (helperReference = (HelperReference) reference3.d()).u0()) != null) {
                ArrayList arrayList2 = helperReference.f32023o0;
                int size2 = arrayList2.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj4 = arrayList2.get(i4);
                    i4++;
                    Reference reference4 = (Reference) this.f32030c.get(obj4);
                    if (reference4 != null) {
                        helperWidgetU0.a(reference4.a());
                    } else if (obj4 instanceof Reference) {
                        helperWidgetU0.a(((Reference) obj4).a());
                    } else {
                        System.out.println("couldn't find reference for " + obj4);
                    }
                }
                reference3.apply();
            }
        }
        for (Object obj5 : this.f32030c.keySet()) {
            Reference reference5 = (Reference) this.f32030c.get(obj5);
            reference5.apply();
            ConstraintWidget constraintWidgetA2 = reference5.a();
            if (constraintWidgetA2 != null && obj5 != null) {
                constraintWidgetA2.f32299o = obj5.toString();
            }
        }
    }

    public BarrierReference b(Object obj, Direction direction) {
        ConstraintReference constraintReferenceD = d(obj);
        if (constraintReferenceD.d() == null || !(constraintReferenceD.d() instanceof BarrierReference)) {
            BarrierReference barrierReference = new BarrierReference(this);
            barrierReference.w0(direction);
            constraintReferenceD.X(barrierReference);
        }
        return (BarrierReference) constraintReferenceD.d();
    }

    public void c(Object obj) {
        this.f32035h.add(obj);
        this.f32037j = true;
    }

    public ConstraintReference d(Object obj) {
        Reference referenceF = (Reference) this.f32030c.get(obj);
        if (referenceF == null) {
            referenceF = f(obj);
            this.f32030c.put(obj, referenceF);
            referenceF.c(obj);
        }
        if (referenceF instanceof ConstraintReference) {
            return (ConstraintReference) referenceF;
        }
        return null;
    }

    public int e(Object obj) {
        if (obj instanceof Float) {
            return Math.round(((Float) obj).floatValue());
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference f(Object obj) {
        return new ConstraintReference(this);
    }

    CorePixelDp h() {
        return this.f32028a;
    }

    public FlowReference i(Object obj, boolean z2) {
        ConstraintReference constraintReferenceD = d(obj);
        if (constraintReferenceD.d() == null || !(constraintReferenceD.d() instanceof FlowReference)) {
            constraintReferenceD.X(z2 ? new FlowReference(this, Helper.VERTICAL_FLOW) : new FlowReference(this, Helper.HORIZONTAL_FLOW));
        }
        return (FlowReference) constraintReferenceD.d();
    }

    public GridReference j(Object obj, String str) {
        ConstraintReference constraintReferenceD = d(obj);
        if (constraintReferenceD.d() == null || !(constraintReferenceD.d() instanceof GridReference)) {
            Helper helper = Helper.GRID;
            if (str.charAt(0) == 'r') {
                helper = Helper.ROW;
            } else if (str.charAt(0) == 'c') {
                helper = Helper.COLUMN;
            }
            constraintReferenceD.X(new GridReference(this, helper));
        }
        return (GridReference) constraintReferenceD.d();
    }

    public ArrayList k(String str) {
        if (this.f32032e.containsKey(str)) {
            return (ArrayList) this.f32032e.get(str);
        }
        return null;
    }

    public GuidelineReference l(Object obj, int i3) {
        ConstraintReference constraintReferenceD = d(obj);
        if (constraintReferenceD.d() == null || !(constraintReferenceD.d() instanceof GuidelineReference)) {
            GuidelineReference guidelineReference = new GuidelineReference(this);
            guidelineReference.g(i3);
            guidelineReference.c(obj);
            constraintReferenceD.X(guidelineReference);
        }
        return (GuidelineReference) constraintReferenceD.d();
    }

    public State m(Dimension dimension) {
        return y(dimension);
    }

    public HelperReference n(Object obj, Helper helper) {
        if (obj == null) {
            obj = g();
        }
        HelperReference horizontalChainReference = (HelperReference) this.f32031d.get(obj);
        if (horizontalChainReference == null) {
            switch (helper) {
                case HORIZONTAL_CHAIN:
                    horizontalChainReference = new HorizontalChainReference(this);
                    break;
                case VERTICAL_CHAIN:
                    horizontalChainReference = new VerticalChainReference(this);
                    break;
                case ALIGN_HORIZONTALLY:
                    horizontalChainReference = new AlignHorizontallyReference(this);
                    break;
                case ALIGN_VERTICALLY:
                    horizontalChainReference = new AlignVerticallyReference(this);
                    break;
                case BARRIER:
                    horizontalChainReference = new BarrierReference(this);
                    break;
                case LAYER:
                default:
                    horizontalChainReference = new HelperReference(this, helper);
                    break;
                case HORIZONTAL_FLOW:
                case VERTICAL_FLOW:
                    horizontalChainReference = new FlowReference(this, helper);
                    break;
                case GRID:
                case ROW:
                case COLUMN:
                    horizontalChainReference = new GridReference(this, helper);
                    break;
            }
            horizontalChainReference.c(obj);
            this.f32031d.put(obj, horizontalChainReference);
        }
        return horizontalChainReference;
    }

    public HorizontalChainReference o() {
        return (HorizontalChainReference) n(null, Helper.HORIZONTAL_CHAIN);
    }

    public GuidelineReference p(Object obj) {
        return l(obj, 0);
    }

    public boolean q(ConstraintWidget constraintWidget) {
        if (this.f32037j) {
            this.f32036i.clear();
            ArrayList arrayList = this.f32035h;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ConstraintWidget constraintWidgetA = ((Reference) this.f32030c.get(obj)).a();
                if (constraintWidgetA != null) {
                    this.f32036i.add(constraintWidgetA);
                }
            }
            this.f32037j = false;
        }
        return this.f32036i.contains(constraintWidget);
    }

    public boolean r() {
        return !this.f32029b;
    }

    public void s(Object obj, Object obj2) {
        ConstraintReference constraintReferenceD = d(obj);
        if (constraintReferenceD != null) {
            constraintReferenceD.e0(obj2);
        }
    }

    Reference t(Object obj) {
        return (Reference) this.f32030c.get(obj);
    }

    public void u() {
        Iterator it = this.f32030c.keySet().iterator();
        while (it.hasNext()) {
            ((Reference) this.f32030c.get(it.next())).a().x0();
        }
        this.f32030c.clear();
        this.f32030c.put(f32027k, this.f32033f);
        this.f32031d.clear();
        this.f32032e.clear();
        this.f32035h.clear();
        this.f32037j = true;
    }

    public boolean v(int i3) {
        return this.f32033f.C().i(i3);
    }

    public boolean w(int i3) {
        return this.f32033f.E().i(i3);
    }

    public void x(CorePixelDp corePixelDp) {
        this.f32028a = corePixelDp;
    }

    public State y(Dimension dimension) {
        this.f32033f.Y(dimension);
        return this;
    }

    public void z(boolean z2) {
        this.f32029b = !z2;
    }
}
