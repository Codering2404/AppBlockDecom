package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinMediationProvider;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.common.Constants;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class ConstraintSetParser {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class DesignElement {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f31978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f31979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        HashMap f31980c;

        public String a() {
            return this.f31978a;
        }

        public HashMap b() {
            return this.f31980c;
        }

        public String c() {
            return this.f31979b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class FiniteGenerator implements GeneratedValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f31981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f31982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f31983c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f31985e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f31986f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f31988h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f31989i;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f31984d = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f31987g = 0.0f;

        FiniteGenerator(float f3, float f4, float f5, String str, String str2) {
            this.f31981a = f3;
            this.f31982b = f4;
            this.f31983c = f5;
            this.f31985e = str == null ? "" : str;
            this.f31986f = str2 == null ? "" : str2;
            this.f31989i = f4;
            this.f31988h = f3;
        }

        public ArrayList a() {
            ArrayList arrayList = new ArrayList();
            int i3 = (int) this.f31988h;
            int i4 = (int) this.f31989i;
            int i5 = i3;
            while (i3 <= i4) {
                arrayList.add(this.f31985e + i5 + this.f31986f);
                i5 += (int) this.f31983c;
                i3++;
            }
            return arrayList;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            float f3 = this.f31987g;
            if (f3 >= this.f31989i) {
                this.f31984d = true;
            }
            if (!this.f31984d) {
                this.f31987g = f3 + this.f31983c;
            }
            return this.f31987g;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    interface GeneratedValue {
        float value();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class Generator implements GeneratedValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f31990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f31991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f31992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f31993d = false;

        Generator(float f3, float f4) {
            this.f31990a = f3;
            this.f31991b = f4;
            this.f31992c = f3;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (!this.f31993d) {
                this.f31992c += this.f31991b;
            }
            return this.f31992c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class LayoutVariables {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        HashMap f31994a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        HashMap f31995b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        HashMap f31996c = new HashMap();

        float a(Object obj) {
            if (!(obj instanceof CLString)) {
                if (obj instanceof CLNumber) {
                    return ((CLNumber) obj).h();
                }
                return 0.0f;
            }
            String strB = ((CLString) obj).b();
            if (this.f31995b.containsKey(strB)) {
                return ((GeneratedValue) this.f31995b.get(strB)).value();
            }
            if (this.f31994a.containsKey(strB)) {
                return ((Integer) this.f31994a.get(strB)).floatValue();
            }
            return 0.0f;
        }

        ArrayList b(String str) {
            if (this.f31996c.containsKey(str)) {
                return (ArrayList) this.f31996c.get(str);
            }
            return null;
        }

        void c(String str, float f3, float f4) {
            if (this.f31995b.containsKey(str) && (this.f31995b.get(str) instanceof OverrideValue)) {
                return;
            }
            this.f31995b.put(str, new Generator(f3, f4));
        }

        void d(String str, float f3, float f4, float f5, String str2, String str3) {
            if (this.f31995b.containsKey(str) && (this.f31995b.get(str) instanceof OverrideValue)) {
                return;
            }
            FiniteGenerator finiteGenerator = new FiniteGenerator(f3, f4, f5, str2, str3);
            this.f31995b.put(str, finiteGenerator);
            this.f31996c.put(str, finiteGenerator.a());
        }

        void e(String str, int i3) {
            this.f31994a.put(str, Integer.valueOf(i3));
        }

        void f(String str, ArrayList arrayList) {
            this.f31996c.put(str, arrayList);
        }

        public void g(String str, float f3) {
            this.f31995b.put(str, new OverrideValue(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class OverrideValue implements GeneratedValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f32001a;

        OverrideValue(float f3) {
            this.f32001a = f3;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            return this.f32001a;
        }
    }

    static void A(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.E() == null) {
            constraintReference.f0(Dimension.h());
        }
        if (constraintReference.C() == null) {
            constraintReference.Y(Dimension.h());
        }
        ArrayList arrayListV = cLObject.V();
        if (arrayListV == null) {
            return;
        }
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            a(state, layoutVariables, constraintReference, cLObject, (String) obj);
        }
    }

    static void B(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        A(state, layoutVariables, state.d(str), cLObject);
    }

    public static void C(CLObject cLObject, State state, LayoutVariables layoutVariables) {
        String str;
        CLElement cLElementD;
        ArrayList arrayListV = cLObject.V();
        if (arrayListV == null) {
            return;
        }
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            str = (String) obj;
            cLElementD = cLObject.D(str);
            str.getClass();
            switch (str) {
                case "Helpers":
                    if (cLElementD instanceof CLArray) {
                        t(state, layoutVariables, (CLArray) cLElementD);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "Generate":
                    if (cLElementD instanceof CLObject) {
                        o(state, layoutVariables, (CLObject) cLElementD);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "Variables":
                    if (cLElementD instanceof CLObject) {
                        z(state, layoutVariables, (CLObject) cLElementD);
                        break;
                    } else {
                        break;
                    }
                    break;
                default:
                    if (cLElementD instanceof CLObject) {
                        CLObject cLObject2 = (CLObject) cLElementD;
                        String strC = c(cLObject2);
                        if (strC != null) {
                            switch (strC) {
                                case "vGuideline":
                                    r(1, state, str, cLObject2);
                                    break;
                                case "column":
                                case "row":
                                case "grid":
                                    p(strC, state, str, layoutVariables, cLObject2);
                                    break;
                                case "hChain":
                                case "vChain":
                                    g(strC, state, str, layoutVariables, cLObject2);
                                    break;
                                case "barrier":
                                    e(state, str, cLObject2);
                                    break;
                                case "hFlow":
                                case "vFlow":
                                    n(strC, state, str, layoutVariables, cLObject2);
                                    break;
                                case "hGuideline":
                                    r(0, state, str, cLObject2);
                                    break;
                            }
                        } else {
                            B(state, layoutVariables, str, cLObject2);
                            break;
                        }
                    } else {
                        if (cLElementD instanceof CLNumber) {
                            layoutVariables.e(str, cLElementD.o());
                        }
                        break;
                    }
                    break;
            }
        }
    }

    private static float D(State state, float f3) {
        return state.h().a(f3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static void a(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject, String str) throws CLParsingException {
        byte b3;
        str.getClass();
        switch (str.hashCode()) {
            case -1448775240:
                b3 = !str.equals("centerVertically") ? (byte) -1 : (byte) 0;
                break;
            case -1364013995:
                b3 = !str.equals("center") ? (byte) -1 : (byte) 1;
                break;
            case -1349088399:
                b3 = !str.equals("custom") ? (byte) -1 : (byte) 2;
                break;
            case -1249320806:
                b3 = !str.equals("rotationX") ? (byte) -1 : (byte) 3;
                break;
            case -1249320805:
                b3 = !str.equals("rotationY") ? (byte) -1 : (byte) 4;
                break;
            case -1249320804:
                b3 = !str.equals("rotationZ") ? (byte) -1 : (byte) 5;
                break;
            case -1225497657:
                b3 = !str.equals("translationX") ? (byte) -1 : (byte) 6;
                break;
            case -1225497656:
                b3 = !str.equals("translationY") ? (byte) -1 : (byte) 7;
                break;
            case -1225497655:
                b3 = !str.equals("translationZ") ? (byte) -1 : (byte) 8;
                break;
            case -1221029593:
                b3 = !str.equals(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) ? (byte) -1 : (byte) 9;
                break;
            case -1068318794:
                b3 = !str.equals("motion") ? (byte) -1 : (byte) 10;
                break;
            case -987906986:
                b3 = !str.equals("pivotX") ? (byte) -1 : Ascii.VT;
                break;
            case -987906985:
                b3 = !str.equals("pivotY") ? (byte) -1 : Ascii.FF;
                break;
            case -908189618:
                b3 = !str.equals("scaleX") ? (byte) -1 : Ascii.CR;
                break;
            case -908189617:
                b3 = !str.equals("scaleY") ? (byte) -1 : Ascii.SO;
                break;
            case -247669061:
                b3 = !str.equals("hRtlBias") ? (byte) -1 : Ascii.SI;
                break;
            case -61505906:
                b3 = !str.equals("vWeight") ? (byte) -1 : Ascii.DLE;
                break;
            case 92909918:
                b3 = !str.equals("alpha") ? (byte) -1 : (byte) 17;
                break;
            case 98116417:
                b3 = !str.equals("hBias") ? (byte) -1 : Ascii.DC2;
                break;
            case 111045711:
                b3 = !str.equals("vBias") ? (byte) -1 : (byte) 19;
                break;
            case 113126854:
                b3 = !str.equals(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) ? (byte) -1 : Ascii.DC4;
                break;
            case 398344448:
                b3 = !str.equals("hWeight") ? (byte) -1 : Ascii.NAK;
                break;
            case 1404070310:
                b3 = !str.equals("centerHorizontally") ? (byte) -1 : Ascii.SYN;
                break;
            case 1941332754:
                b3 = !str.equals(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY) ? (byte) -1 : Ascii.ETB;
                break;
            default:
                b3 = -1;
                break;
        }
        switch (b3) {
            case 0:
                String strQ = cLObject.Q(str);
                boolean zEquals = strQ.equals("parent");
                Object obj = strQ;
                if (zEquals) {
                    obj = State.f32027k;
                }
                ConstraintReference constraintReferenceD = state.d(obj);
                constraintReference.m0(constraintReferenceD);
                constraintReference.p(constraintReferenceD);
                break;
            case 1:
                String strQ2 = cLObject.Q(str);
                ConstraintReference constraintReferenceD2 = strQ2.equals("parent") ? state.d(State.f32027k) : state.d(strQ2);
                constraintReference.i0(constraintReferenceD2);
                constraintReference.z(constraintReferenceD2);
                constraintReference.m0(constraintReferenceD2);
                constraintReference.p(constraintReferenceD2);
                break;
            case 2:
                k(cLObject, constraintReference, str);
                break;
            case 3:
                constraintReference.S(layoutVariables.a(cLObject.D(str)));
                break;
            case 4:
                constraintReference.T(layoutVariables.a(cLObject.D(str)));
                break;
            case 5:
                constraintReference.U(layoutVariables.a(cLObject.D(str)));
                break;
            case 6:
                constraintReference.n0(D(state, layoutVariables.a(cLObject.D(str))));
                break;
            case 7:
                constraintReference.o0(D(state, layoutVariables.a(cLObject.D(str))));
                break;
            case 8:
                constraintReference.p0(D(state, layoutVariables.a(cLObject.D(str))));
                break;
            case 9:
                constraintReference.Y(l(cLObject, str, state, state.h()));
                break;
            case 10:
                w(cLObject.D(str), constraintReference);
                break;
            case 11:
                constraintReference.N(layoutVariables.a(cLObject.D(str)));
                break;
            case 12:
                constraintReference.O(layoutVariables.a(cLObject.D(str)));
                break;
            case 13:
                constraintReference.V(layoutVariables.a(cLObject.D(str)));
                break;
            case 14:
                constraintReference.W(layoutVariables.a(cLObject.D(str)));
                break;
            case 15:
                float fA = layoutVariables.a(cLObject.D(str));
                if (state.r()) {
                    fA = 1.0f - fA;
                }
                constraintReference.F(fA);
                break;
            case 16:
                constraintReference.d0(layoutVariables.a(cLObject.D(str)));
                break;
            case 17:
                constraintReference.g(layoutVariables.a(cLObject.D(str)));
                break;
            case 18:
                constraintReference.F(layoutVariables.a(cLObject.D(str)));
                break;
            case 19:
                constraintReference.q0(layoutVariables.a(cLObject.D(str)));
                break;
            case 20:
                constraintReference.f0(l(cLObject, str, state, state.h()));
                break;
            case 21:
                constraintReference.a0(layoutVariables.a(cLObject.D(str)));
                break;
            case 22:
                String strQ3 = cLObject.Q(str);
                boolean zEquals2 = strQ3.equals("parent");
                Object obj2 = strQ3;
                if (zEquals2) {
                    obj2 = State.f32027k;
                }
                ConstraintReference constraintReferenceD3 = state.d(obj2);
                constraintReference.i0(constraintReferenceD3);
                constraintReference.z(constraintReferenceD3);
                break;
            case 23:
                String strQ4 = cLObject.Q(str);
                strQ4.getClass();
                switch (strQ4) {
                    case "invisible":
                        constraintReference.r0(4);
                        constraintReference.g(0.0f);
                        break;
                    case "gone":
                        constraintReference.r0(8);
                        break;
                    case "visible":
                        constraintReference.r0(0);
                        break;
                }
                break;
            default:
                i(state, layoutVariables, cLObject, constraintReference, str);
                break;
        }
    }

    private static int b(String str, String... strArr) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (strArr[i3].equals(str)) {
                return i3;
            }
        }
        return -1;
    }

    static String c(CLObject cLObject) {
        ArrayList arrayListV = cLObject.V();
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            if (((String) obj).equals("type")) {
                return cLObject.Q("type");
            }
        }
        return null;
    }

    static void e(State state, String str, CLObject cLObject) throws CLParsingException {
        String str2;
        boolean zR = state.r();
        BarrierReference barrierReferenceB = state.b(str, State.Direction.END);
        ArrayList arrayListV = cLObject.V();
        if (arrayListV == null) {
            return;
        }
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            str2 = (String) obj;
            str2.getClass();
            switch (str2) {
                case "margin":
                    float fJ = cLObject.J(str2);
                    if (Float.isNaN(fJ)) {
                        break;
                    } else {
                        barrierReferenceB.K(Float.valueOf(D(state, fJ)));
                        break;
                    }
                    break;
                case "direction":
                    String strQ = cLObject.Q(str2);
                    strQ.getClass();
                    switch (strQ) {
                        case "bottom":
                            barrierReferenceB.w0(State.Direction.BOTTOM);
                            break;
                        case "end":
                            if (zR) {
                                barrierReferenceB.w0(State.Direction.LEFT);
                                break;
                            } else {
                                barrierReferenceB.w0(State.Direction.RIGHT);
                                break;
                            }
                            break;
                        case "top":
                            barrierReferenceB.w0(State.Direction.TOP);
                            break;
                        case "left":
                            barrierReferenceB.w0(State.Direction.LEFT);
                            break;
                        case "right":
                            barrierReferenceB.w0(State.Direction.RIGHT);
                            break;
                        case "start":
                            if (zR) {
                                barrierReferenceB.w0(State.Direction.RIGHT);
                                break;
                            } else {
                                barrierReferenceB.w0(State.Direction.LEFT);
                                break;
                            }
                            break;
                    }
                    break;
                case "contains":
                    CLArray cLArrayG = cLObject.G(str2);
                    if (cLArrayG != null) {
                        for (int i4 = 0; i4 < cLArrayG.size(); i4++) {
                            barrierReferenceB.s0(state.d(cLArrayG.B(i4).b()));
                        }
                        break;
                    } else {
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void f(int r8, androidx.constraintlayout.core.state.State r9, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r10, androidx.constraintlayout.core.parser.CLArray r11) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            if (r8 != 0) goto L7
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r8 = r9.o()
            goto Lb
        L7:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r8 = r9.C()
        Lb:
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r1 = r11.B(r0)
            boolean r2 = r1 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r2 == 0) goto Lae
            androidx.constraintlayout.core.parser.CLArray r1 = (androidx.constraintlayout.core.parser.CLArray) r1
            int r2 = r1.size()
            if (r2 >= r0) goto L1e
            goto Lae
        L1e:
            r2 = 0
            r3 = r2
        L20:
            int r4 = r1.size()
            if (r3 >= r4) goto L34
            java.lang.String r4 = r1.P(r3)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            r8.s0(r4)
            int r3 = r3 + 1
            goto L20
        L34:
            int r1 = r11.size()
            r3 = 2
            if (r1 <= r3) goto Lae
            androidx.constraintlayout.core.parser.CLElement r11 = r11.B(r3)
            boolean r1 = r11 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r1 != 0) goto L44
            goto Lae
        L44:
            androidx.constraintlayout.core.parser.CLObject r11 = (androidx.constraintlayout.core.parser.CLObject) r11
            java.util.ArrayList r1 = r11.V()
            int r3 = r1.size()
            r4 = r2
        L4f:
            if (r4 >= r3) goto Lae
            java.lang.Object r5 = r1.get(r4)
            int r4 = r4 + 1
            java.lang.String r5 = (java.lang.String) r5
            r5.getClass()
            java.lang.String r6 = "style"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L68
            i(r9, r10, r11, r8, r5)
            goto L4f
        L68:
            androidx.constraintlayout.core.parser.CLElement r5 = r11.D(r5)
            boolean r6 = r5 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r6 == 0) goto L85
            r6 = r5
            androidx.constraintlayout.core.parser.CLArray r6 = (androidx.constraintlayout.core.parser.CLArray) r6
            int r7 = r6.size()
            if (r7 <= r0) goto L85
            java.lang.String r5 = r6.P(r2)
            float r6 = r6.H(r0)
            r8.x0(r6)
            goto L89
        L85:
            java.lang.String r5 = r5.b()
        L89:
            r5.getClass()
            java.lang.String r6 = "packed"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto La8
            java.lang.String r6 = "spread_inside"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto La2
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r8.D0(r5)
            goto L4f
        La2:
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r8.D0(r5)
            goto L4f
        La8:
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r8.D0(r5)
            goto L4f
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.f(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0225  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(java.lang.String r21, androidx.constraintlayout.core.state.State r22, java.lang.String r23, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r24, androidx.constraintlayout.core.parser.CLObject r25) {
        /*
            Method dump skipped, instruction units count: 614
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.g(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static long h(String str) {
        if (!str.startsWith("#")) {
            return -1L;
        }
        String strSubstring = str.substring(1);
        if (strSubstring.length() == 6) {
            strSubstring = "FF" + strSubstring;
        }
        return Long.parseLong(strSubstring, 16);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x00d0. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012d  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void i(androidx.constraintlayout.core.state.State r22, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r23, androidx.constraintlayout.core.parser.CLObject r24, androidx.constraintlayout.core.state.ConstraintReference r25, java.lang.String r26) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instruction units count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.i(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.ConstraintReference, java.lang.String):void");
    }

    static void j(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList arrayListV = cLObject.V();
        if (arrayListV == null) {
            return;
        }
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            String str = (String) obj;
            CLObject cLObjectL = cLObject.L(str);
            String strS = cLObjectL.S("Extends");
            if (strS == null || strS.isEmpty()) {
                coreMotionScene.q(str, cLObjectL.y());
            } else {
                String strM = coreMotionScene.m(strS);
                if (strM != null) {
                    CLObject cLObjectD = CLParser.d(strM);
                    ArrayList arrayListV2 = cLObjectL.V();
                    if (arrayListV2 != null) {
                        int size2 = arrayListV2.size();
                        int i4 = 0;
                        while (i4 < size2) {
                            Object obj2 = arrayListV2.get(i4);
                            i4++;
                            String str2 = (String) obj2;
                            CLElement cLElementD = cLObjectL.D(str2);
                            if (cLElementD instanceof CLObject) {
                                d(cLObjectD, str2, (CLObject) cLElementD);
                            }
                        }
                        coreMotionScene.q(str, cLObjectD.y());
                    }
                }
            }
        }
    }

    static void k(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList arrayListV;
        CLObject cLObjectM = cLObject.M(str);
        if (cLObjectM == null || (arrayListV = cLObjectM.V()) == null) {
            return;
        }
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            String str2 = (String) obj;
            CLElement cLElementD = cLObjectM.D(str2);
            if (cLElementD instanceof CLNumber) {
                constraintReference.f(str2, cLElementD.h());
            } else if (cLElementD instanceof CLString) {
                long jH = h(cLElementD.b());
                if (jH != -1) {
                    constraintReference.e(str2, (int) jH);
                }
            }
        }
    }

    static Dimension l(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElementD = cLObject.D(str);
        Dimension dimensionB = Dimension.b(0);
        if (cLElementD instanceof CLString) {
            return m(cLElementD.b());
        }
        if (cLElementD instanceof CLNumber) {
            return Dimension.b(state.e(Float.valueOf(corePixelDp.a(cLObject.I(str)))));
        }
        if (cLElementD instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElementD;
            String strS = cLObject2.S("value");
            if (strS != null) {
                dimensionB = m(strS);
            }
            CLElement cLElementO = cLObject2.O("min");
            if (cLElementO != null) {
                if (cLElementO instanceof CLNumber) {
                    dimensionB.o(state.e(Float.valueOf(corePixelDp.a(((CLNumber) cLElementO).h()))));
                } else if (cLElementO instanceof CLString) {
                    dimensionB.p(Dimension.f32003j);
                }
            }
            CLElement cLElementO2 = cLObject2.O(AppLovinMediationProvider.MAX);
            if (cLElementO2 != null) {
                if (cLElementO2 instanceof CLNumber) {
                    dimensionB.m(state.e(Float.valueOf(corePixelDp.a(((CLNumber) cLElementO2).h()))));
                    return dimensionB;
                }
                if (cLElementO2 instanceof CLString) {
                    dimensionB.n(Dimension.f32003j);
                }
            }
        }
        return dimensionB;
    }

    static Dimension m(String str) {
        Dimension dimensionB;
        dimensionB = Dimension.b(0);
        str.getClass();
        switch (str) {
            case "preferWrap":
                return Dimension.g(Dimension.f32003j);
            case "parent":
                return Dimension.d();
            case "spread":
                return Dimension.g(Dimension.f32004k);
            case "wrap":
                return Dimension.h();
            default:
                return str.endsWith("%") ? Dimension.e(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).s(0) : str.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR) ? Dimension.f(str).t(Dimension.f32004k) : dimensionB;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x040f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void n(java.lang.String r18, androidx.constraintlayout.core.state.State r19, java.lang.String r20, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r21, androidx.constraintlayout.core.parser.CLObject r22) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instruction units count: 1248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.n(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void o(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList arrayListV = cLObject.V();
        if (arrayListV == null) {
            return;
        }
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            String str = (String) obj;
            CLElement cLElementD = cLObject.D(str);
            ArrayList arrayListB = layoutVariables.b(str);
            if (arrayListB != null && (cLElementD instanceof CLObject)) {
                int size2 = arrayListB.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayListB.get(i4);
                    i4++;
                    B(state, layoutVariables, (String) obj2, (CLObject) cLElementD);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void p(java.lang.String r11, androidx.constraintlayout.core.state.State r12, java.lang.String r13, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r14, androidx.constraintlayout.core.parser.CLObject r15) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instruction units count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.p(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void q(int i3, State state, CLArray cLArray) throws CLParsingException {
        CLObject cLObject;
        String strS;
        CLElement cLElementB = cLArray.B(1);
        if ((cLElementB instanceof CLObject) && (strS = (cLObject = (CLObject) cLElementB).S("id")) != null) {
            r(i3, state, strS, cLObject);
        }
    }

    static void r(int i3, State state, String str, CLObject cLObject) throws CLParsingException {
        String str2;
        float fD;
        float fH;
        ArrayList arrayListV = cLObject.V();
        if (arrayListV == null) {
            return;
        }
        ConstraintReference constraintReferenceD = state.d(str);
        if (i3 == 0) {
            state.p(str);
        } else {
            state.D(str);
        }
        boolean z2 = !state.r() || i3 == 0;
        GuidelineReference guidelineReference = (GuidelineReference) constraintReferenceD.d();
        int size = arrayListV.size();
        float fD2 = 0.0f;
        boolean z3 = false;
        boolean z4 = true;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayListV.get(i4);
            i4++;
            str2 = (String) obj;
            str2.getClass();
            switch (str2) {
                case "percent":
                    CLArray cLArrayG = cLObject.G(str2);
                    if (cLArrayG != null) {
                        if (cLArrayG.size() > 1) {
                            String strP = cLArrayG.P(0);
                            fH = cLArrayG.H(1);
                            strP.getClass();
                            switch (strP) {
                                case "end":
                                    z4 = !z2;
                                    fD2 = fH;
                                    break;
                                case "left":
                                    fD2 = fH;
                                    z3 = true;
                                    z4 = true;
                                    break;
                                case "right":
                                    fD2 = fH;
                                    z4 = false;
                                    break;
                                case "start":
                                    z4 = z2;
                                    fD2 = fH;
                                    break;
                                default:
                                    fD2 = fH;
                                    break;
                            }
                        }
                        z3 = true;
                        break;
                    } else {
                        fD2 = cLObject.I(str2);
                        z3 = true;
                        z4 = true;
                        break;
                    }
                    break;
                case "end":
                    fD = D(state, cLObject.I(str2));
                    z4 = !z2;
                    fD2 = fD;
                    break;
                case "left":
                    fD2 = D(state, cLObject.I(str2));
                    z4 = true;
                    break;
                case "right":
                    fD2 = D(state, cLObject.I(str2));
                    z4 = false;
                    break;
                case "start":
                    fD = D(state, cLObject.I(str2));
                    z4 = z2;
                    fD2 = fD;
                    break;
            }
        }
        if (z3) {
            if (z4) {
                guidelineReference.f(fD2);
                return;
            } else {
                guidelineReference.f(1.0f - fD2);
                return;
            }
        }
        if (z4) {
            guidelineReference.h(Float.valueOf(fD2));
        } else {
            guidelineReference.e(Float.valueOf(fD2));
        }
    }

    static void s(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String strS = cLObject.S("export");
        if (strS != null) {
            coreMotionScene.r(strS);
        }
    }

    static void t(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        for (int i3 = 0; i3 < cLArray.size(); i3++) {
            CLElement cLElementB = cLArray.B(i3);
            if (cLElementB instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElementB;
                if (cLArray2.size() > 1) {
                    String strP = cLArray2.P(0);
                    strP.getClass();
                    switch (strP) {
                        case "vGuideline":
                            q(1, state, cLArray2);
                            break;
                        case "hChain":
                            f(0, state, layoutVariables, cLArray2);
                            break;
                        case "vChain":
                            f(1, state, layoutVariables, cLArray2);
                            break;
                        case "hGuideline":
                            q(0, state, cLArray2);
                            break;
                    }
                }
            }
        }
    }

    public static void u(String str, State state, LayoutVariables layoutVariables) {
        try {
            C(CLParser.d(str), state, layoutVariables);
        } catch (CLParsingException e3) {
            System.err.println("Error parsing JSON " + e3);
        }
    }

    public static void v(String str, Transition transition, int i3) {
        CLObject cLObjectM;
        try {
            CLObject cLObjectD = CLParser.d(str);
            ArrayList arrayListV = cLObjectD.V();
            if (arrayListV == null) {
                return;
            }
            int size = arrayListV.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayListV.get(i4);
                i4++;
                String str2 = (String) obj;
                CLElement cLElementD = cLObjectD.D(str2);
                if ((cLElementD instanceof CLObject) && (cLObjectM = ((CLObject) cLElementD).M("custom")) != null) {
                    ArrayList arrayListV2 = cLObjectM.V();
                    int size2 = arrayListV2.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        Object obj2 = arrayListV2.get(i5);
                        i5++;
                        String str3 = (String) obj2;
                        CLElement cLElementD2 = cLObjectM.D(str3);
                        if (cLElementD2 instanceof CLNumber) {
                            transition.g(i3, str2, str3, cLElementD2.h());
                        } else if (cLElementD2 instanceof CLString) {
                            long jH = h(cLElementD2.b());
                            if (jH != -1) {
                                transition.f(i3, str2, str3, (int) jH);
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e3) {
            System.err.println("Error parsing JSON " + e3);
        }
    }

    private static void w(CLElement cLElement, ConstraintReference constraintReference) throws CLParsingException {
        String str;
        if (cLElement instanceof CLObject) {
            CLObject cLObject = (CLObject) cLElement;
            TypedBundle typedBundle = new TypedBundle();
            ArrayList arrayListV = cLObject.V();
            if (arrayListV == null) {
                return;
            }
            int size = arrayListV.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListV.get(i3);
                i3++;
                str = (String) obj;
                str.getClass();
                switch (str) {
                    case "stagger":
                        typedBundle.a(600, cLObject.I(str));
                        break;
                    case "easing":
                        typedBundle.c(603, cLObject.Q(str));
                        break;
                    case "quantize":
                        CLElement cLElementD = cLObject.D(str);
                        if (cLElementD instanceof CLArray) {
                            CLArray cLArray = (CLArray) cLElementD;
                            int size2 = cLArray.size();
                            if (size2 > 0) {
                                typedBundle.b(610, cLArray.getInt(0));
                                if (size2 > 1) {
                                    typedBundle.c(611, cLArray.P(1));
                                    if (size2 > 2) {
                                        typedBundle.a(602, cLArray.H(2));
                                    }
                                }
                            }
                            break;
                        } else {
                            typedBundle.b(610, cLObject.K(str));
                            break;
                        }
                        break;
                    case "pathArc":
                        String strQ = cLObject.Q(str);
                        int iB = b(strQ, IntegrityManager.INTEGRITY_TYPE_NONE, "startVertical", "startHorizontal", "flip", "below", "above");
                        if (iB == -1) {
                            System.err.println(cLObject.p() + " pathArc = '" + strQ + "'");
                            break;
                        } else {
                            typedBundle.b(607, iB);
                            break;
                        }
                        break;
                    case "relativeTo":
                        typedBundle.c(605, cLObject.Q(str));
                        break;
                }
            }
            constraintReference.f31961l0 = typedBundle;
        }
    }

    public static void x(CoreMotionScene coreMotionScene, String str) {
        try {
            CLObject cLObjectD = CLParser.d(str);
            ArrayList arrayListV = cLObjectD.V();
            if (arrayListV == null) {
                return;
            }
            int size = arrayListV.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListV.get(i3);
                i3++;
                String str2 = (String) obj;
                CLElement cLElementD = cLObjectD.D(str2);
                if (cLElementD instanceof CLObject) {
                    CLObject cLObject = (CLObject) cLElementD;
                    int iHashCode = str2.hashCode();
                    if (iHashCode != -2137403731) {
                        if (iHashCode != -241441378) {
                            if (iHashCode == 1101852654 && str2.equals("ConstraintSets")) {
                                j(coreMotionScene, cLObject);
                            }
                        } else if (str2.equals("Transitions")) {
                            y(coreMotionScene, cLObject);
                        }
                    } else if (str2.equals("Header")) {
                        s(coreMotionScene, cLObject);
                    }
                }
            }
        } catch (CLParsingException e3) {
            System.err.println("Error parsing JSON " + e3);
        }
    }

    static void y(CoreMotionScene coreMotionScene, CLObject cLObject) {
        ArrayList arrayListV = cLObject.V();
        if (arrayListV == null) {
            return;
        }
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            String str = (String) obj;
            coreMotionScene.o(str, cLObject.L(str).y());
        }
    }

    private static void z(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList arrayListV = cLObject.V();
        if (arrayListV == null) {
            return;
        }
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            String str = (String) obj;
            CLElement cLElementD = cLObject.D(str);
            if (cLElementD instanceof CLNumber) {
                layoutVariables.e(str, cLElementD.o());
            } else if (cLElementD instanceof CLObject) {
                CLObject cLObject2 = (CLObject) cLElementD;
                if (cLObject2.U("from") && cLObject2.U("to")) {
                    layoutVariables.d(str, layoutVariables.a(cLObject2.D("from")), layoutVariables.a(cLObject2.D("to")), 1.0f, cLObject2.S("prefix"), cLObject2.S("postfix"));
                } else if (cLObject2.U("from") && cLObject2.U("step")) {
                    layoutVariables.c(str, layoutVariables.a(cLObject2.D("from")), layoutVariables.a(cLObject2.D("step")));
                } else if (cLObject2.U("ids")) {
                    CLArray cLArrayE = cLObject2.E("ids");
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < cLArrayE.size(); i4++) {
                        arrayList.add(cLArrayE.P(i4));
                    }
                    layoutVariables.f(str, arrayList);
                } else if (cLObject2.U("tag")) {
                    layoutVariables.f(str, state.k(cLObject2.Q("tag")));
                }
            }
        }
    }

    static void d(CLObject cLObject, String str, CLObject cLObject2) throws CLParsingException {
        if (!cLObject.U(str)) {
            cLObject.W(str, cLObject2);
            return;
        }
        CLObject cLObjectL = cLObject.L(str);
        ArrayList arrayListV = cLObject2.V();
        int size = arrayListV.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListV.get(i3);
            i3++;
            String str2 = (String) obj;
            if (!str2.equals("clear")) {
                cLObjectL.W(str2, cLObject2.D(str2));
            } else {
                CLArray cLArrayE = cLObject2.E("clear");
                for (int i4 = 0; i4 < cLArrayE.size(); i4++) {
                    String strR = cLArrayE.R(i4);
                    if (strR != null) {
                        switch (strR) {
                            case "transforms":
                                cLObjectL.Z(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY);
                                cLObjectL.Z("alpha");
                                cLObjectL.Z("pivotX");
                                cLObjectL.Z("pivotY");
                                cLObjectL.Z("rotationX");
                                cLObjectL.Z("rotationY");
                                cLObjectL.Z("rotationZ");
                                cLObjectL.Z("scaleX");
                                cLObjectL.Z("scaleY");
                                cLObjectL.Z("translationX");
                                cLObjectL.Z("translationY");
                                break;
                            case "constraints":
                                cLObjectL.Z("start");
                                cLObjectL.Z("end");
                                cLObjectL.Z(ViewHierarchyConstants.DIMENSION_TOP_KEY);
                                cLObjectL.Z(MHoiDDglUlPJC.ZbAoUbmC);
                                cLObjectL.Z("baseline");
                                cLObjectL.Z("center");
                                cLObjectL.Z("centerHorizontally");
                                cLObjectL.Z("centerVertically");
                                break;
                            case "dimensions":
                                cLObjectL.Z(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                                cLObjectL.Z(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                                break;
                            default:
                                cLObjectL.Z(strR);
                                break;
                        }
                    }
                }
            }
        }
    }
}
