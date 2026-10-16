package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionKeyAttributes extends MotionKey {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f31633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f31634h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31635i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f31636j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f31637k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f31638l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f31639m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f31640n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f31641o = Float.NaN;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f31642p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f31643q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f31644r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f31645s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f31646t = Float.NaN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f31647u = Float.NaN;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f31648v = Float.NaN;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f31649w = Float.NaN;

    public MotionKeyAttributes() {
        this.f31631d = 1;
        this.f31632e = new HashMap();
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int a(String str) {
        return TypedValues.AttributesType.a(str);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean b(int i3, int i4) {
        if (i3 == 100) {
            this.f31628a = i4;
            return true;
        }
        if (i3 == 301) {
            this.f31634h = i4;
            return true;
        }
        if (i3 == 302) {
            this.f31635i = i4;
            return true;
        }
        if (b(i3, i4)) {
            return true;
        }
        return super.b(i3, i4);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean c(int i3, float f3) {
        if (i3 == 100) {
            this.f31643q = f3;
            return true;
        }
        switch (i3) {
            case 303:
                this.f31636j = f3;
                return true;
            case RCHTTPStatusCodes.NOT_MODIFIED /* 304 */:
                this.f31646t = f3;
                return true;
            case 305:
                this.f31647u = f3;
                return true;
            case 306:
                this.f31648v = f3;
                return true;
            case 307:
                this.f31637k = f3;
                return true;
            case 308:
                this.f31639m = f3;
                return true;
            case 309:
                this.f31640n = f3;
                return true;
            case 310:
                this.f31638l = f3;
                return true;
            case 311:
                this.f31644r = f3;
                return true;
            case 312:
                this.f31645s = f3;
                return true;
            case 313:
                this.f31641o = f3;
                return true;
            case 314:
                this.f31642p = f3;
                return true;
            case 315:
                this.f31649w = f3;
                return true;
            case 316:
                this.f31643q = f3;
                return true;
            default:
                return super.c(i3, f3);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean e(int i3, String str) {
        if (i3 == 101) {
            this.f31630c = str;
            return true;
        }
        if (i3 != 317) {
            return super.e(i3, str);
        }
        this.f31633g = str;
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void f(HashMap map) {
        for (String str : map.keySet()) {
            SplineSet splineSet = (SplineSet) map.get(str);
            if (splineSet != null) {
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
                        case -987906986:
                            if (!str.equals("pivotX")) {
                                b3 = -1;
                            }
                            break;
                        case -987906985:
                            b3 = str.equals("pivotY") ? (byte) 8 : (byte) -1;
                            break;
                        case -908189618:
                            b3 = str.equals("scaleX") ? (byte) 9 : (byte) -1;
                            break;
                        case -908189617:
                            b3 = str.equals("scaleY") ? (byte) 10 : (byte) -1;
                            break;
                        case -4379043:
                            b3 = str.equals("elevation") ? Ascii.VT : (byte) -1;
                            break;
                        case 92909918:
                            b3 = str.equals("alpha") ? Ascii.FF : (byte) -1;
                            break;
                        case 803192288:
                            b3 = str.equals("pathRotate") ? Ascii.CR : (byte) -1;
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    switch (b3) {
                        case 0:
                            if (!Float.isNaN(this.f31639m)) {
                                splineSet.e(this.f31628a, this.f31639m);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.f31640n)) {
                                splineSet.e(this.f31628a, this.f31640n);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.f31638l)) {
                                splineSet.e(this.f31628a, this.f31638l);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.f31646t)) {
                                splineSet.e(this.f31628a, this.f31646t);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.f31647u)) {
                                splineSet.e(this.f31628a, this.f31647u);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.f31648v)) {
                                splineSet.e(this.f31628a, this.f31648v);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.f31649w)) {
                                splineSet.e(this.f31628a, this.f31649w);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.f31639m)) {
                                splineSet.e(this.f31628a, this.f31641o);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.f31640n)) {
                                splineSet.e(this.f31628a, this.f31642p);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.f31644r)) {
                                splineSet.e(this.f31628a, this.f31644r);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.f31645s)) {
                                splineSet.e(this.f31628a, this.f31645s);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.f31637k)) {
                                splineSet.e(this.f31628a, this.f31637k);
                            }
                            break;
                        case 12:
                            if (!Float.isNaN(this.f31636j)) {
                                splineSet.e(this.f31628a, this.f31636j);
                            }
                            break;
                        case 13:
                            if (!Float.isNaN(this.f31643q)) {
                                splineSet.e(this.f31628a, this.f31643q);
                            }
                            break;
                        default:
                            System.err.println("not supported by KeyAttributes " + str);
                            break;
                    }
                } else {
                    CustomVariable customVariable = (CustomVariable) this.f31632e.get(str.substring(7));
                    if (customVariable != null) {
                        ((SplineSet.CustomSpline) splineSet).i(this.f31628a, customVariable);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: g */
    public MotionKey clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void i(HashSet hashSet) {
        if (!Float.isNaN(this.f31636j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f31637k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f31638l)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.f31639m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f31640n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f31641o)) {
            hashSet.add("pivotX");
        }
        if (!Float.isNaN(this.f31642p)) {
            hashSet.add("pivotY");
        }
        if (!Float.isNaN(this.f31646t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f31647u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f31648v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f31643q)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f31644r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f31645s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f31649w)) {
            hashSet.add("progress");
        }
        if (this.f31632e.size() > 0) {
            Iterator it = this.f31632e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void j(HashMap map) {
        if (!Float.isNaN(this.f31636j)) {
            map.put("alpha", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31637k)) {
            map.put("elevation", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31638l)) {
            map.put("rotationZ", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31639m)) {
            map.put("rotationX", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31640n)) {
            map.put("rotationY", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31641o)) {
            map.put("pivotX", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31642p)) {
            map.put("pivotY", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31646t)) {
            map.put("translationX", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31647u)) {
            map.put("translationY", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31648v)) {
            map.put("translationZ", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31643q)) {
            map.put("pathRotate", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31644r)) {
            map.put("scaleX", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31645s)) {
            map.put("scaleY", Integer.valueOf(this.f31634h));
        }
        if (!Float.isNaN(this.f31649w)) {
            map.put("progress", Integer.valueOf(this.f31634h));
        }
        if (this.f31632e.size() > 0) {
            Iterator it = this.f31632e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + ((String) it.next()), Integer.valueOf(this.f31634h));
            }
        }
    }
}
