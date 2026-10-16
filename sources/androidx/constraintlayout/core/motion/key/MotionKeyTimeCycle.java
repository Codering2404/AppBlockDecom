package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionKeyTimeCycle extends MotionKey {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f31682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f31683h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f31684i = Float.NaN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f31685j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f31686k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f31687l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f31688m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f31689n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f31690o = Float.NaN;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f31691p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f31692q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31693r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f31694s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f31695t = Float.NaN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f31696u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f31697v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f31698w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f31699x = 0.0f;

    public MotionKeyTimeCycle() {
        this.f31631d = 3;
        this.f31632e = new HashMap();
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int a(String str) {
        return TypedValues.CycleType.a(str);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean b(int i3, int i4) {
        if (i3 == 100) {
            this.f31628a = i4;
            return true;
        }
        if (i3 != 421) {
            return super.b(i3, i4);
        }
        this.f31696u = i4;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean c(int i3, float f3) {
        if (i3 == 315) {
            this.f31695t = k(Float.valueOf(f3));
            return true;
        }
        if (i3 == 401) {
            this.f31683h = l(Float.valueOf(f3));
            return true;
        }
        if (i3 == 403) {
            this.f31684i = f3;
            return true;
        }
        if (i3 == 416) {
            this.f31689n = k(Float.valueOf(f3));
            return true;
        }
        if (i3 == 423) {
            this.f31698w = k(Float.valueOf(f3));
            return true;
        }
        if (i3 == 424) {
            this.f31699x = k(Float.valueOf(f3));
            return true;
        }
        switch (i3) {
            case RCHTTPStatusCodes.NOT_MODIFIED /* 304 */:
                this.f31692q = k(Float.valueOf(f3));
                return true;
            case 305:
                this.f31693r = k(Float.valueOf(f3));
                return true;
            case 306:
                this.f31694s = k(Float.valueOf(f3));
                return true;
            case 307:
                this.f31685j = k(Float.valueOf(f3));
                return true;
            case 308:
                this.f31687l = k(Float.valueOf(f3));
                return true;
            case 309:
                this.f31688m = k(Float.valueOf(f3));
                return true;
            case 310:
                this.f31686k = k(Float.valueOf(f3));
                return true;
            case 311:
                this.f31690o = k(Float.valueOf(f3));
                return true;
            case 312:
                this.f31691p = k(Float.valueOf(f3));
                return true;
            default:
                return super.c(i3, f3);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean d(int i3, boolean z2) {
        return super.d(i3, z2);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean e(int i3, String str) {
        if (i3 == 420) {
            this.f31682g = str;
            return true;
        }
        if (i3 != 421) {
            return super.e(i3, str);
        }
        this.f31696u = 7;
        this.f31697v = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: g */
    public MotionKey clone() {
        return new MotionKeyTimeCycle().n(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void i(HashSet hashSet) {
        if (!Float.isNaN(this.f31684i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f31685j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f31686k)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.f31687l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f31688m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f31690o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f31691p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f31689n)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f31692q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f31693r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f31694s)) {
            hashSet.add("translationZ");
        }
        if (this.f31632e.size() > 0) {
            Iterator it = this.f31632e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void m(HashMap map) {
        for (String str : map.keySet()) {
            TimeCycleSplineSet timeCycleSplineSet = (TimeCycleSplineSet) map.get(str);
            if (timeCycleSplineSet != null) {
                byte b3 = 7;
                if (!str.startsWith("CUSTOM")) {
                    switch (str.hashCode()) {
                        case -1249320806:
                            b3 = str.equals("rotationX") ? (byte) 0 : (byte) -1;
                            break;
                        case -1249320805:
                            b3 = str.equals("rotationY") ? (byte) 1 : (byte) -1;
                            break;
                        case -1249320804:
                            b3 = str.equals("rotationZ") ? (byte) 2 : (byte) -1;
                            break;
                        case -1225497657:
                            b3 = str.equals("translationX") ? (byte) 3 : (byte) -1;
                            break;
                        case -1225497656:
                            b3 = str.equals("translationY") ? (byte) 4 : (byte) -1;
                            break;
                        case -1225497655:
                            b3 = str.equals("translationZ") ? (byte) 5 : (byte) -1;
                            break;
                        case -1001078227:
                            b3 = str.equals("progress") ? (byte) 6 : (byte) -1;
                            break;
                        case -908189618:
                            if (!str.equals("scaleX")) {
                                b3 = -1;
                            }
                            break;
                        case -908189617:
                            b3 = str.equals("scaleY") ? (byte) 8 : (byte) -1;
                            break;
                        case -4379043:
                            b3 = str.equals("elevation") ? (byte) 9 : (byte) -1;
                            break;
                        case 92909918:
                            b3 = str.equals("alpha") ? (byte) 10 : (byte) -1;
                            break;
                        case 803192288:
                            b3 = str.equals("pathRotate") ? Ascii.VT : (byte) -1;
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    switch (b3) {
                        case 0:
                            if (!Float.isNaN(this.f31687l)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31687l, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.f31688m)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31688m, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.f31686k)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31686k, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.f31692q)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31692q, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.f31693r)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31693r, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.f31694s)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31694s, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.f31695t)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31695t, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.f31690o)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31690o, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.f31691p)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31691p, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.f31694s)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31694s, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.f31684i)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31684i, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.f31689n)) {
                                timeCycleSplineSet.b(this.f31628a, this.f31689n, this.f31698w, this.f31696u, this.f31699x);
                            }
                            break;
                        default:
                            Utils.a("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                } else {
                    CustomVariable customVariable = (CustomVariable) this.f31632e.get(str.substring(7));
                    if (customVariable != null) {
                        ((TimeCycleSplineSet.CustomVarSet) timeCycleSplineSet).f(this.f31628a, customVariable, this.f31698w, this.f31696u, this.f31699x);
                    }
                }
            }
        }
    }

    public MotionKeyTimeCycle n(MotionKey motionKey) {
        super.h(motionKey);
        MotionKeyTimeCycle motionKeyTimeCycle = (MotionKeyTimeCycle) motionKey;
        this.f31682g = motionKeyTimeCycle.f31682g;
        this.f31683h = motionKeyTimeCycle.f31683h;
        this.f31696u = motionKeyTimeCycle.f31696u;
        this.f31698w = motionKeyTimeCycle.f31698w;
        this.f31699x = motionKeyTimeCycle.f31699x;
        this.f31695t = motionKeyTimeCycle.f31695t;
        this.f31684i = motionKeyTimeCycle.f31684i;
        this.f31685j = motionKeyTimeCycle.f31685j;
        this.f31686k = motionKeyTimeCycle.f31686k;
        this.f31689n = motionKeyTimeCycle.f31689n;
        this.f31687l = motionKeyTimeCycle.f31687l;
        this.f31688m = motionKeyTimeCycle.f31688m;
        this.f31690o = motionKeyTimeCycle.f31690o;
        this.f31691p = motionKeyTimeCycle.f31691p;
        this.f31692q = motionKeyTimeCycle.f31692q;
        this.f31693r = motionKeyTimeCycle.f31693r;
        this.f31694s = motionKeyTimeCycle.f31694s;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void f(HashMap map) {
    }
}
