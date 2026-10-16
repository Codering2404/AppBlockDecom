package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.stetho.server.http.HttpStatus;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TransitionParser {
    private static int a(String str, String... strArr) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (strArr[i3].equals(str)) {
                return i3;
            }
        }
        return 0;
    }

    private static void b(TypedBundle typedBundle, int i3, String str, String... strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (strArr[i4].equals(str)) {
                typedBundle.b(i3, i4);
            }
        }
    }

    public static void c(CLObject cLObject, Transition transition) throws CLParsingException {
        transition.K();
        String strS = cLObject.S("pathMotionArc");
        TypedBundle typedBundle = new TypedBundle();
        boolean z2 = true;
        boolean z3 = false;
        if (strS != null) {
            switch (strS) {
                case "startVertical":
                    typedBundle.b(509, 1);
                    break;
                case "startHorizontal":
                    typedBundle.b(509, 2);
                    break;
                case "flip":
                    typedBundle.b(509, 3);
                    break;
                case "none":
                    typedBundle.b(509, 0);
                    break;
                case "above":
                    typedBundle.b(509, 5);
                    break;
                case "below":
                    typedBundle.b(509, 4);
                    break;
            }
            z3 = true;
        }
        String strS2 = cLObject.S("interpolator");
        if (strS2 != null) {
            typedBundle.c(705, strS2);
            z3 = true;
        }
        float fJ = cLObject.J("staggered");
        if (Float.isNaN(fJ)) {
            z2 = z3;
        } else {
            typedBundle.a(706, fJ);
        }
        if (z2) {
            transition.M(typedBundle);
        }
        CLObject cLObjectM = cLObject.M("onSwipe");
        if (cLObjectM != null) {
            h(cLObjectM, transition);
        }
        f(cLObject, transition);
    }

    private static void d(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray cLArrayG;
        CustomVariable[][] customVariableArr;
        CLObject cLObject2;
        int i3;
        String[] strArr;
        CLArray cLArrayG2 = cLObject.G("target");
        if (cLArrayG2 == null || (cLArrayG = cLObject.G("frames")) == null) {
            return;
        }
        String strS = cLObject.S("transitionEasing");
        String[] strArr2 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
        int[] iArr = {311, 312, RCHTTPStatusCodes.NOT_MODIFIED, 305, 306, 308, 309, 310, 303};
        boolean[] zArr = {false, false, true, true, true, false, false, false, false};
        int size = cLArrayG.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i4 = 0; i4 < cLArrayG.size(); i4++) {
            typedBundleArr[i4] = new TypedBundle();
        }
        int i5 = 0;
        for (int i6 = 9; i5 < i6; i6 = 9) {
            String str = strArr2[i5];
            int i7 = iArr[i5];
            boolean z2 = zArr[i5];
            CLArray cLArrayG3 = cLObject.G(str);
            if (cLArrayG3 != null && cLArrayG3.size() != size) {
                throw new CLParsingException("incorrect size for " + str + " array, not matching targets array!", cLObject);
            }
            if (cLArrayG3 != null) {
                int i8 = 0;
                while (i8 < size) {
                    float fH = cLArrayG3.H(i8);
                    String[] strArr3 = strArr2;
                    if (z2) {
                        fH = transition.f32101k.a(fH);
                    }
                    typedBundleArr[i8].a(i7, fH);
                    i8++;
                    strArr2 = strArr3;
                }
                strArr = strArr2;
            } else {
                strArr = strArr2;
                float fJ = cLObject.J(str);
                if (!Float.isNaN(fJ)) {
                    if (z2) {
                        fJ = transition.f32101k.a(fJ);
                    }
                    for (int i9 = 0; i9 < size; i9++) {
                        typedBundleArr[i9].a(i7, fJ);
                    }
                }
            }
            i5++;
            strArr2 = strArr;
        }
        int i10 = 0;
        CLElement cLElementO = cLObject.O("custom");
        if (cLElementO == null || !(cLElementO instanceof CLObject)) {
            customVariableArr = null;
        } else {
            CLObject cLObject3 = (CLObject) cLElementO;
            int size2 = cLObject3.size();
            customVariableArr = (CustomVariable[][]) Array.newInstance((Class<?>) CustomVariable.class, cLArrayG.size(), size2);
            int i11 = 0;
            while (i11 < size2) {
                CLKey cLKey = (CLKey) cLObject3.B(i11);
                String strB = cLKey.b();
                if (cLKey.d0() instanceof CLArray) {
                    CLArray cLArray = (CLArray) cLKey.d0();
                    int size3 = cLArray.size();
                    if (size3 != size || size3 <= 0) {
                        cLObject2 = cLObject3;
                    } else {
                        int i12 = i10;
                        if (cLArray.B(i12) instanceof CLNumber) {
                            int i13 = i12;
                            while (i13 < size) {
                                customVariableArr[i13][i11] = new CustomVariable(strB, 901, cLArray.B(i13).h());
                                i13++;
                                cLObject3 = cLObject3;
                            }
                            cLObject2 = cLObject3;
                        } else {
                            cLObject2 = cLObject3;
                            int i14 = 0;
                            while (i14 < size) {
                                long jH = ConstraintSetParser.h(cLArray.B(i14).b());
                                if (jH != -1) {
                                    i3 = i14;
                                    customVariableArr[i14][i11] = new CustomVariable(strB, 902, (int) jH);
                                } else {
                                    i3 = i14;
                                }
                                i14 = i3 + 1;
                            }
                        }
                    }
                } else {
                    cLObject2 = cLObject3;
                    CLElement cLElementD0 = cLKey.d0();
                    if (cLElementD0 instanceof CLNumber) {
                        float fH2 = cLElementD0.h();
                        for (int i15 = 0; i15 < size; i15++) {
                            customVariableArr[i15][i11] = new CustomVariable(strB, 901, fH2);
                        }
                    } else {
                        long jH2 = ConstraintSetParser.h(cLElementD0.b());
                        if (jH2 != -1) {
                            int i16 = 0;
                            while (i16 < size) {
                                customVariableArr[i16][i11] = new CustomVariable(strB, 902, (int) jH2);
                                i16++;
                                size2 = size2;
                                jH2 = jH2;
                            }
                        }
                    }
                }
                i11++;
                size2 = size2;
                cLObject3 = cLObject2;
                i10 = 0;
            }
        }
        String strS2 = cLObject.S("curveFit");
        for (int i17 = 0; i17 < cLArrayG2.size(); i17++) {
            for (int i18 = 0; i18 < size; i18++) {
                String strP = cLArrayG2.P(i17);
                TypedBundle typedBundle = typedBundleArr[i18];
                if (strS2 != null) {
                    typedBundle.b(508, a(strS2, "spline", "linear"));
                }
                typedBundle.e(HttpStatus.HTTP_NOT_IMPLEMENTED, strS);
                typedBundle.b(100, cLArrayG.getInt(i18));
                transition.h(strP, typedBundle, customVariableArr != null ? customVariableArr[i18] : null);
            }
        }
    }

    private static void e(CLObject cLObject, Transition transition) throws CLParsingException {
        int[] iArr;
        CLArray cLArrayE = cLObject.E("target");
        CLArray cLArrayE2 = cLObject.E("frames");
        String strS = cLObject.S("transitionEasing");
        String[] strArr = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha", "period", "offset", "phase"};
        int[] iArr2 = {311, 312, RCHTTPStatusCodes.NOT_MODIFIED, 305, 306, 308, 309, 310, RCHTTPStatusCodes.FORBIDDEN, 423, 424, 425};
        int[] iArr3 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0};
        int size = cLArrayE2.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i3 = 0; i3 < size; i3++) {
            typedBundleArr[i3] = new TypedBundle();
        }
        boolean z2 = false;
        for (int i4 = 0; i4 < 12; i4++) {
            if (cLObject.U(strArr[i4]) && iArr3[i4] == 1) {
                z2 = true;
            }
        }
        int i5 = 0;
        for (int i6 = 12; i5 < i6; i6 = 12) {
            String str = strArr[i5];
            int i7 = iArr2[i5];
            int i8 = iArr3[i5];
            CLArray cLArrayG = cLObject.G(str);
            String[] strArr2 = strArr;
            if (cLArrayG != null && cLArrayG.size() != size) {
                throw new CLParsingException("incorrect size for $attrName array, not matching targets array!", cLObject);
            }
            if (cLArrayG != null) {
                int i9 = 0;
                while (i9 < size) {
                    float fH = cLArrayG.H(i9);
                    int[] iArr4 = iArr2;
                    if (i8 == 1) {
                        fH = transition.f32101k.a(fH);
                    } else if (i8 == 2 && z2) {
                        fH = transition.f32101k.a(fH);
                    }
                    typedBundleArr[i9].a(i7, fH);
                    i9++;
                    iArr2 = iArr4;
                }
                iArr = iArr2;
            } else {
                iArr = iArr2;
                float fJ = cLObject.J(str);
                if (!Float.isNaN(fJ)) {
                    if (i8 == 1) {
                        fJ = transition.f32101k.a(fJ);
                    } else if (i8 == 2 && z2) {
                        fJ = transition.f32101k.a(fJ);
                    }
                    for (int i10 = 0; i10 < size; i10++) {
                        typedBundleArr[i10].a(i7, fJ);
                    }
                }
            }
            i5++;
            strArr = strArr2;
            iArr2 = iArr;
        }
        String strS2 = cLObject.S("curveFit");
        String strS3 = cLObject.S("easing");
        String strS4 = cLObject.S("waveShape");
        String strS5 = cLObject.S("customWave");
        for (int i11 = 0; i11 < cLArrayE.size(); i11++) {
            for (int i12 = 0; i12 < size; i12++) {
                String strP = cLArrayE.P(i11);
                TypedBundle typedBundle = typedBundleArr[i12];
                if (strS2 != null) {
                    if (strS2.equals("linear")) {
                        typedBundle.b(RCHTTPStatusCodes.UNAUTHORIZED, 1);
                    } else if (strS2.equals("spline")) {
                        typedBundle.b(RCHTTPStatusCodes.UNAUTHORIZED, 0);
                    }
                }
                typedBundle.e(HttpStatus.HTTP_NOT_IMPLEMENTED, strS);
                if (strS3 != null) {
                    typedBundle.c(420, strS3);
                }
                if (strS4 != null) {
                    typedBundle.c(421, strS4);
                }
                if (strS5 != null) {
                    typedBundle.c(422, strS5);
                }
                typedBundle.b(100, cLArrayE2.getInt(i12));
                transition.i(strP, typedBundle);
            }
        }
    }

    public static void f(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject cLObjectM = cLObject.M("KeyFrames");
        if (cLObjectM == null) {
            return;
        }
        CLArray cLArrayG = cLObjectM.G("KeyPositions");
        if (cLArrayG != null) {
            for (int i3 = 0; i3 < cLArrayG.size(); i3++) {
                CLElement cLElementB = cLArrayG.B(i3);
                if (cLElementB instanceof CLObject) {
                    g((CLObject) cLElementB, transition);
                }
            }
        }
        CLArray cLArrayG2 = cLObjectM.G("KeyAttributes");
        if (cLArrayG2 != null) {
            for (int i4 = 0; i4 < cLArrayG2.size(); i4++) {
                CLElement cLElementB2 = cLArrayG2.B(i4);
                if (cLElementB2 instanceof CLObject) {
                    d((CLObject) cLElementB2, transition);
                }
            }
        }
        CLArray cLArrayG3 = cLObjectM.G("KeyCycles");
        if (cLArrayG3 != null) {
            for (int i5 = 0; i5 < cLArrayG3.size(); i5++) {
                CLElement cLElementB3 = cLArrayG3.B(i5);
                if (cLElementB3 instanceof CLObject) {
                    e((CLObject) cLElementB3, transition);
                }
            }
        }
    }

    private static void g(CLObject cLObject, Transition transition) throws CLParsingException {
        TypedBundle typedBundle = new TypedBundle();
        CLArray cLArrayE = cLObject.E("target");
        CLArray cLArrayE2 = cLObject.E("frames");
        CLArray cLArrayG = cLObject.G("percentX");
        CLArray cLArrayG2 = cLObject.G("percentY");
        CLArray cLArrayG3 = cLObject.G("percentWidth");
        CLArray cLArrayG4 = cLObject.G("percentHeight");
        String strS = cLObject.S("pathMotionArc");
        String strS2 = cLObject.S("transitionEasing");
        String strS3 = cLObject.S("curveFit");
        String strS4 = cLObject.S("type");
        if (strS4 == null) {
            strS4 = "parentRelative";
        }
        if (cLArrayG == null || cLArrayE2.size() == cLArrayG.size()) {
            if (cLArrayG2 == null || cLArrayE2.size() == cLArrayG2.size()) {
                int i3 = 0;
                while (i3 < cLArrayE.size()) {
                    String strP = cLArrayE.P(i3);
                    int iA = a(strS4, "deltaRelative", "pathRelative", "parentRelative");
                    typedBundle.h();
                    typedBundle.b(510, iA);
                    if (strS3 != null) {
                        b(typedBundle, 508, strS3, "spline", "linear");
                    }
                    typedBundle.e(HttpStatus.HTTP_NOT_IMPLEMENTED, strS2);
                    if (strS != null) {
                        b(typedBundle, 509, strS, IntegrityManager.INTEGRITY_TYPE_NONE, "startVertical", "startHorizontal", "flip", "below", "above");
                    }
                    int i4 = 0;
                    while (i4 < cLArrayE2.size()) {
                        typedBundle.b(100, cLArrayE2.getInt(i4));
                        i(typedBundle, 506, cLArrayG, i4);
                        i(typedBundle, 507, cLArrayG2, i4);
                        i(typedBundle, 503, cLArrayG3, i4);
                        i(typedBundle, 504, cLArrayG4, i4);
                        transition.j(strP, typedBundle);
                        i4++;
                        strS4 = strS4;
                    }
                    i3++;
                    strS4 = strS4;
                }
            }
        }
    }

    private static void h(CLContainer cLContainer, Transition transition) {
        String strS = cLContainer.S("anchor");
        int iA = a(cLContainer.S("side"), Transition.OnSwipe.f32112u);
        int iA2 = a(cLContainer.S("direction"), Transition.OnSwipe.f32114w);
        float fJ = cLContainer.J("scale");
        float fJ2 = cLContainer.J("threshold");
        float fJ3 = cLContainer.J("maxVelocity");
        float fJ4 = cLContainer.J("maxAccel");
        String strS2 = cLContainer.S("limitBounds");
        int iA3 = a(cLContainer.S("mode"), Transition.OnSwipe.f32115x);
        int iA4 = a(cLContainer.S("touchUp"), Transition.OnSwipe.f32116y);
        float fJ5 = cLContainer.J("springMass");
        float fJ6 = cLContainer.J("springStiffness");
        float fJ7 = cLContainer.J("springDamping");
        float fJ8 = cLContainer.J("stopThreshold");
        int iA5 = a(cLContainer.S("springBoundary"), Transition.OnSwipe.f32117z);
        String strS3 = cLContainer.S("around");
        Transition.OnSwipe onSwipeN = transition.n();
        onSwipeN.h(strS);
        onSwipeN.i(iA);
        onSwipeN.k(iA2);
        onSwipeN.l(fJ);
        onSwipeN.m(fJ2);
        onSwipeN.p(fJ3);
        onSwipeN.o(fJ4);
        onSwipeN.n(strS2);
        onSwipeN.j(iA3);
        onSwipeN.q(iA4);
        onSwipeN.u(fJ5);
        onSwipeN.v(fJ6);
        onSwipeN.t(fJ7);
        onSwipeN.w(fJ8);
        onSwipeN.s(iA5);
        onSwipeN.r(strS3);
    }

    private static void i(TypedBundle typedBundle, int i3, CLArray cLArray, int i4) {
        if (cLArray != null) {
            typedBundle.a(i3, cLArray.H(i4));
        }
    }
}
