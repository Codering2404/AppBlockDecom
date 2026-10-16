package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionKeyCycle extends MotionKey {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f31650g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f31651h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31652i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f31653j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f31654k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f31655l = 0.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f31656m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f31657n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f31658o = Float.NaN;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f31659p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f31660q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31661r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f31662s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f31663t = Float.NaN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f31664u = Float.NaN;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f31665v = Float.NaN;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f31666w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f31667x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f31668y = Float.NaN;

    public MotionKeyCycle() {
        this.f31631d = 4;
        this.f31632e = new HashMap();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int a(String str) {
        byte b3;
        str.getClass();
        switch (str.hashCode()) {
            case -1581616630:
                b3 = !str.equals("customWave") ? (byte) -1 : (byte) 0;
                break;
            case -1310311125:
                b3 = !str.equals("easing") ? (byte) -1 : (byte) 1;
                break;
            case -1249320806:
                b3 = !str.equals("rotationX") ? (byte) -1 : (byte) 2;
                break;
            case -1249320805:
                b3 = !str.equals("rotationY") ? (byte) -1 : (byte) 3;
                break;
            case -1249320804:
                b3 = !str.equals("rotationZ") ? (byte) -1 : (byte) 4;
                break;
            case -1225497657:
                b3 = !str.equals("translationX") ? (byte) -1 : (byte) 5;
                break;
            case -1225497656:
                b3 = !str.equals("translationY") ? (byte) -1 : (byte) 6;
                break;
            case -1225497655:
                b3 = !str.equals("translationZ") ? (byte) -1 : (byte) 7;
                break;
            case -1019779949:
                b3 = !str.equals("offset") ? (byte) -1 : (byte) 8;
                break;
            case -1001078227:
                b3 = !str.equals("progress") ? (byte) -1 : (byte) 9;
                break;
            case -991726143:
                b3 = !str.equals("period") ? (byte) -1 : (byte) 10;
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
            case 92909918:
                b3 = !str.equals("alpha") ? (byte) -1 : Ascii.SI;
                break;
            case 106629499:
                b3 = !str.equals("phase") ? (byte) -1 : Ascii.DLE;
                break;
            case 579057826:
                b3 = !str.equals("curveFit") ? (byte) -1 : (byte) 17;
                break;
            case 803192288:
                b3 = !str.equals("pathRotate") ? (byte) -1 : Ascii.DC2;
                break;
            case 1532805160:
                b3 = !str.equals("waveShape") ? (byte) -1 : (byte) 19;
                break;
            case 1941332754:
                b3 = !str.equals(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY) ? (byte) -1 : Ascii.DC4;
                break;
            default:
                b3 = -1;
                break;
        }
        switch (b3) {
            case 0:
                return 422;
            case 1:
                return 420;
            case 2:
                return 308;
            case 3:
                return 309;
            case 4:
                return 310;
            case 5:
                return RCHTTPStatusCodes.NOT_MODIFIED;
            case 6:
                return 305;
            case 7:
                return 306;
            case 8:
                return 424;
            case 9:
                return 315;
            case 10:
                return 423;
            case 11:
                return 313;
            case 12:
                return 314;
            case 13:
                return 311;
            case 14:
                return 312;
            case 15:
                return RCHTTPStatusCodes.FORBIDDEN;
            case 16:
                return 425;
            case 17:
                return RCHTTPStatusCodes.UNAUTHORIZED;
            case 18:
                return 416;
            case 19:
                return 421;
            case 20:
                return 402;
            default:
                return -1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean b(int i3, int i4) {
        if (i3 == 401) {
            this.f31651h = i4;
            return true;
        }
        if (i3 == 421) {
            this.f31652i = i4;
            return true;
        }
        if (c(i3, i4)) {
            return true;
        }
        return super.b(i3, i4);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean c(int i3, float f3) {
        if (i3 == 315) {
            this.f31657n = f3;
            return true;
        }
        if (i3 == 403) {
            this.f31658o = f3;
            return true;
        }
        if (i3 == 416) {
            this.f31661r = f3;
            return true;
        }
        switch (i3) {
            case RCHTTPStatusCodes.NOT_MODIFIED /* 304 */:
                this.f31666w = f3;
                return true;
            case 305:
                this.f31667x = f3;
                return true;
            case 306:
                this.f31668y = f3;
                return true;
            case 307:
                this.f31659p = f3;
                return true;
            case 308:
                this.f31662s = f3;
                return true;
            case 309:
                this.f31663t = f3;
                return true;
            case 310:
                this.f31660q = f3;
                return true;
            case 311:
                this.f31664u = f3;
                return true;
            case 312:
                this.f31665v = f3;
                return true;
            default:
                switch (i3) {
                    case 423:
                        this.f31654k = f3;
                        return true;
                    case 424:
                        this.f31655l = f3;
                        return true;
                    case 425:
                        this.f31656m = f3;
                        return true;
                    default:
                        return super.c(i3, f3);
                }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean e(int i3, String str) {
        if (i3 == 420) {
            this.f31650g = str;
            return true;
        }
        if (i3 != 422) {
            return super.e(i3, str);
        }
        this.f31653j = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: g */
    public MotionKey clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void i(HashSet hashSet) {
        if (!Float.isNaN(this.f31658o)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f31659p)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f31660q)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.f31662s)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f31663t)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f31664u)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f31665v)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f31661r)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f31666w)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f31667x)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f31668y)) {
            hashSet.add("translationZ");
        }
        if (this.f31632e.size() > 0) {
            Iterator it = this.f31632e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    public void m(HashMap map) {
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        for (String str : map.keySet()) {
            if (str.startsWith("CUSTOM")) {
                CustomVariable customVariable = (CustomVariable) this.f31632e.get(str.substring(7));
                if (customVariable != null && customVariable.i() == 901 && (keyCycleOscillator = (KeyCycleOscillator) map.get(str)) != null) {
                    keyCycleOscillator.f(this.f31628a, this.f31652i, this.f31653j, -1, this.f31654k, this.f31655l, this.f31656m / 360.0f, customVariable.j(), customVariable);
                }
            } else {
                float fN = n(str);
                if (!Float.isNaN(fN) && (keyCycleOscillator2 = (KeyCycleOscillator) map.get(str)) != null) {
                    keyCycleOscillator2.e(this.f31628a, this.f31652i, this.f31653j, -1, this.f31654k, this.f31655l, this.f31656m / 360.0f, fN);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public float n(String str) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    b3 = 0;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    b3 = 1;
                }
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    b3 = 2;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b3 = 3;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b3 = 4;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b3 = 5;
                }
                break;
            case -1019779949:
                if (str.equals("offset")) {
                    b3 = 6;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    b3 = 7;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b3 = 8;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b3 = 9;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b3 = 10;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b3 = Ascii.VT;
                }
                break;
            case 106629499:
                if (str.equals("phase")) {
                    b3 = Ascii.FF;
                }
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    b3 = Ascii.CR;
                }
                break;
        }
        switch (b3) {
            case 0:
                return this.f31662s;
            case 1:
                return this.f31663t;
            case 2:
                return this.f31660q;
            case 3:
                return this.f31666w;
            case 4:
                return this.f31667x;
            case 5:
                return this.f31668y;
            case 6:
                return this.f31655l;
            case 7:
                return this.f31657n;
            case 8:
                return this.f31664u;
            case 9:
                return this.f31665v;
            case 10:
                return this.f31659p;
            case 11:
                return this.f31658o;
            case 12:
                return this.f31656m;
            case 13:
                return this.f31661r;
            default:
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void f(HashMap map) {
    }
}
