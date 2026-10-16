package androidx.constraintlayout.core.motion.utils;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.stetho.server.http.HttpStatus;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import d.qFm.sECyKyO;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface TypedValues {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Custom {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface CycleType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f31894a = {"curveFit", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "alpha", "translationX", "translationY", "translationZ", "elevation", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "pivotX", "pivotY", "progress", "pathRotate", "easing", "waveShape", "customWave", "period", "offset", "phase"};

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        static int a(String str) {
            byte b3;
            str.getClass();
            switch (str.hashCode()) {
                case -1310311125:
                    b3 = !str.equals("easing") ? (byte) -1 : (byte) 0;
                    break;
                case -1249320806:
                    b3 = !str.equals("rotationX") ? (byte) -1 : (byte) 1;
                    break;
                case -1249320805:
                    b3 = !str.equals("rotationY") ? (byte) -1 : (byte) 2;
                    break;
                case -1249320804:
                    b3 = !str.equals("rotationZ") ? (byte) -1 : (byte) 3;
                    break;
                case -1225497657:
                    b3 = !str.equals("translationX") ? (byte) -1 : (byte) 4;
                    break;
                case -1225497656:
                    b3 = !str.equals("translationY") ? (byte) -1 : (byte) 5;
                    break;
                case -1225497655:
                    b3 = !str.equals("translationZ") ? (byte) -1 : (byte) 6;
                    break;
                case -1001078227:
                    b3 = !str.equals("progress") ? (byte) -1 : (byte) 7;
                    break;
                case -987906986:
                    b3 = !str.equals("pivotX") ? (byte) -1 : (byte) 8;
                    break;
                case -987906985:
                    b3 = !str.equals("pivotY") ? (byte) -1 : (byte) 9;
                    break;
                case -908189618:
                    b3 = !str.equals("scaleX") ? (byte) -1 : (byte) 10;
                    break;
                case -908189617:
                    b3 = !str.equals("scaleY") ? (byte) -1 : Ascii.VT;
                    break;
                case 92909918:
                    b3 = !str.equals("alpha") ? (byte) -1 : Ascii.FF;
                    break;
                case 579057826:
                    b3 = !str.equals("curveFit") ? (byte) -1 : Ascii.CR;
                    break;
                case 803192288:
                    b3 = !str.equals("pathRotate") ? (byte) -1 : Ascii.SO;
                    break;
                case 1941332754:
                    b3 = !str.equals(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY) ? (byte) -1 : Ascii.SI;
                    break;
                default:
                    b3 = -1;
                    break;
            }
            switch (b3) {
                case 0:
                    return 420;
                case 1:
                    return 308;
                case 2:
                    return 309;
                case 3:
                    return 310;
                case 4:
                    return RCHTTPStatusCodes.NOT_MODIFIED;
                case 5:
                    return 305;
                case 6:
                    return 306;
                case 7:
                    return 315;
                case 8:
                    return 313;
                case 9:
                    return 314;
                case 10:
                    return 311;
                case 11:
                    return 312;
                case 12:
                    return RCHTTPStatusCodes.FORBIDDEN;
                case 13:
                    return RCHTTPStatusCodes.UNAUTHORIZED;
                case 14:
                    return 416;
                case 15:
                    return 402;
                default:
                    return -1;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface MotionScene {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    public interface MotionType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f31895a = {"Stagger", "PathRotate", "QuantizeMotionPhase", "TransitionEasing", "QuantizeInterpolator", "AnimateRelativeTo", "AnimateCircleAngleTo", "PathMotionArc", "DrawPath", "PolarRelativeTo", bfIdKSjLOVjG.XHlWczaPhwHMF, "QuantizeInterpolatorType", "QuantizeInterpolatorID"};

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        static int a(String str) {
            byte b3;
            str.getClass();
            switch (str.hashCode()) {
                case -2033446275:
                    b3 = !str.equals("AnimateCircleAngleTo") ? (byte) -1 : (byte) 0;
                    break;
                case -1532277420:
                    b3 = !str.equals("QuantizeMotionPhase") ? (byte) -1 : (byte) 1;
                    break;
                case -1529145600:
                    b3 = !str.equals("QuantizeMotionSteps") ? (byte) -1 : (byte) 2;
                    break;
                case -1498310144:
                    b3 = !str.equals("PathRotate") ? (byte) -1 : (byte) 3;
                    break;
                case -1030753096:
                    b3 = !str.equals("QuantizeInterpolator") ? (byte) -1 : (byte) 4;
                    break;
                case -762370135:
                    b3 = !str.equals("DrawPath") ? (byte) -1 : (byte) 5;
                    break;
                case -232872051:
                    b3 = !str.equals("Stagger") ? (byte) -1 : (byte) 6;
                    break;
                case 1138491429:
                    b3 = !str.equals("PolarRelativeTo") ? (byte) -1 : (byte) 7;
                    break;
                case 1539234834:
                    b3 = !str.equals("QuantizeInterpolatorType") ? (byte) -1 : (byte) 8;
                    break;
                case 1583722451:
                    b3 = !str.equals("QuantizeInterpolatorID") ? (byte) -1 : (byte) 9;
                    break;
                case 1639368448:
                    b3 = !str.equals("TransitionEasing") ? (byte) -1 : (byte) 10;
                    break;
                case 1900899336:
                    b3 = !str.equals("AnimateRelativeTo") ? (byte) -1 : Ascii.VT;
                    break;
                case 2109694967:
                    b3 = !str.equals("PathMotionArc") ? (byte) -1 : Ascii.FF;
                    break;
                default:
                    b3 = -1;
                    break;
            }
            switch (b3) {
                case 0:
                    return 606;
                case 1:
                    return 602;
                case 2:
                    return 610;
                case 3:
                    return 601;
                case 4:
                    return 604;
                case 5:
                    return 608;
                case 6:
                    return 600;
                case 7:
                    return 609;
                case 8:
                    return 611;
                case 9:
                    return 612;
                case 10:
                    return 603;
                case 11:
                    return 605;
                case 12:
                    return 607;
                default:
                    return -1;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnSwipe {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PositionType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f31896a = {"transitionEasing", "drawPath", "percentWidth", "percentHeight", "sizePercent", "percentX", "percentY"};

        static int a(String str) {
            str.getClass();
            switch (str) {
                case "transitionEasing":
                    return HttpStatus.HTTP_NOT_IMPLEMENTED;
                case "percentWidth":
                    return 503;
                case "percentHeight":
                    return 504;
                case "drawPath":
                    return 502;
                case "sizePercent":
                    return 505;
                case "percentX":
                    return 506;
                case "percentY":
                    return 507;
                default:
                    return -1;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TransitionType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TriggerType {
    }

    int a(String str);

    boolean b(int i3, int i4);

    boolean c(int i3, float f3);

    boolean d(int i3, boolean z2);

    boolean e(int i3, String str);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    public interface AttributesType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f31893a = {"curveFit", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "alpha", "translationX", "translationY", "translationZ", "elevation", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "pivotX", "pivotY", "progress", "pathRotate", "easing", "CUSTOM", "frame", "target", "pivotTarget"};

        static int a(String str) {
            byte b3;
            str.getClass();
            switch (str.hashCode()) {
                case -1310311125:
                    b3 = !str.equals("easing") ? (byte) -1 : (byte) 0;
                    break;
                case -1249320806:
                    b3 = !str.equals("rotationX") ? (byte) -1 : (byte) 1;
                    break;
                case -1249320805:
                    b3 = !str.equals(sECyKyO.Wsx) ? (byte) -1 : (byte) 2;
                    break;
                case -1249320804:
                    b3 = !str.equals("rotationZ") ? (byte) -1 : (byte) 3;
                    break;
                case -1225497657:
                    b3 = !str.equals("translationX") ? (byte) -1 : (byte) 4;
                    break;
                case -1225497656:
                    b3 = !str.equals("translationY") ? (byte) -1 : (byte) 5;
                    break;
                case -1225497655:
                    b3 = !str.equals("translationZ") ? (byte) -1 : (byte) 6;
                    break;
                case -1001078227:
                    b3 = !str.equals("progress") ? (byte) -1 : (byte) 7;
                    break;
                case -987906986:
                    b3 = !str.equals("pivotX") ? (byte) -1 : (byte) 8;
                    break;
                case -987906985:
                    b3 = !str.equals("pivotY") ? (byte) -1 : (byte) 9;
                    break;
                case -908189618:
                    b3 = !str.equals("scaleX") ? (byte) -1 : (byte) 10;
                    break;
                case -908189617:
                    b3 = !str.equals("scaleY") ? (byte) -1 : Ascii.VT;
                    break;
                case -880905839:
                    b3 = !str.equals("target") ? (byte) -1 : Ascii.FF;
                    break;
                case -4379043:
                    b3 = !str.equals("elevation") ? (byte) -1 : Ascii.CR;
                    break;
                case 92909918:
                    b3 = !str.equals("alpha") ? (byte) -1 : Ascii.SO;
                    break;
                case 97692013:
                    b3 = !str.equals("frame") ? (byte) -1 : Ascii.SI;
                    break;
                case 579057826:
                    b3 = !str.equals("curveFit") ? (byte) -1 : Ascii.DLE;
                    break;
                case 803192288:
                    b3 = !str.equals("pathRotate") ? (byte) -1 : (byte) 17;
                    break;
                case 1167159411:
                    b3 = !str.equals("pivotTarget") ? (byte) -1 : Ascii.DC2;
                    break;
                case 1941332754:
                    b3 = !str.equals(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY) ? (byte) -1 : (byte) 19;
                    break;
                default:
                    b3 = -1;
                    break;
            }
            switch (b3) {
                case 0:
                    return 317;
                case 1:
                    return 308;
                case 2:
                    return 309;
                case 3:
                    return 310;
                case 4:
                    return RCHTTPStatusCodes.NOT_MODIFIED;
                case 5:
                    return 305;
                case 6:
                    return 306;
                case 7:
                    return 315;
                case 8:
                    return 313;
                case 9:
                    return 314;
                case 10:
                    return 311;
                case 11:
                    return 312;
                case 12:
                    return 101;
                case 13:
                    return 307;
                case 14:
                    return 303;
                case 15:
                    return 100;
                case 16:
                    return 301;
                case 17:
                    return 316;
                case 18:
                    return 318;
                case 19:
                    return 302;
                default:
                    return -1;
            }
        }
    }
}
