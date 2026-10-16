package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyCycle extends Key {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f32606g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32607h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f32608i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f32609j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f32610k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f32611l = 0.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f32612m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f32613n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f32614o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f32615p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f32616q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f32617r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f32618s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f32619t = Float.NaN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f32620u = Float.NaN;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f32621v = Float.NaN;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f32622w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f32623x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f32624y = Float.NaN;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f32625z = Float.NaN;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Loader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f32626a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f32626a = sparseIntArray;
            sparseIntArray.append(R.styleable.b6, 1);
            f32626a.append(R.styleable.Z5, 2);
            f32626a.append(R.styleable.c6, 3);
            f32626a.append(R.styleable.Y5, 4);
            f32626a.append(R.styleable.h6, 5);
            f32626a.append(R.styleable.f6, 6);
            f32626a.append(R.styleable.e6, 7);
            f32626a.append(R.styleable.i6, 8);
            f32626a.append(R.styleable.O5, 9);
            f32626a.append(R.styleable.X5, 10);
            f32626a.append(R.styleable.T5, 11);
            f32626a.append(R.styleable.U5, 12);
            f32626a.append(R.styleable.V5, 13);
            f32626a.append(R.styleable.d6, 14);
            f32626a.append(R.styleable.R5, 15);
            f32626a.append(R.styleable.S5, 16);
            f32626a.append(R.styleable.P5, 17);
            f32626a.append(R.styleable.Q5, 18);
            f32626a.append(R.styleable.W5, 19);
            f32626a.append(R.styleable.a6, 20);
            f32626a.append(R.styleable.g6, 21);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (f32626a.get(index)) {
                    case 1:
                        if (MotionLayout.D0) {
                            int resourceId = typedArray.getResourceId(index, keyCycle.f32584b);
                            keyCycle.f32584b = resourceId;
                            if (resourceId == -1) {
                                keyCycle.f32585c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyCycle.f32585c = typedArray.getString(index);
                        } else {
                            keyCycle.f32584b = typedArray.getResourceId(index, keyCycle.f32584b);
                        }
                        break;
                    case 2:
                        keyCycle.f32583a = typedArray.getInt(index, keyCycle.f32583a);
                        break;
                    case 3:
                        keyCycle.f32606g = typedArray.getString(index);
                        break;
                    case 4:
                        keyCycle.f32607h = typedArray.getInteger(index, keyCycle.f32607h);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            keyCycle.f32609j = typedArray.getString(index);
                            keyCycle.f32608i = 7;
                        } else {
                            keyCycle.f32608i = typedArray.getInt(index, keyCycle.f32608i);
                        }
                        break;
                    case 6:
                        keyCycle.f32610k = typedArray.getFloat(index, keyCycle.f32610k);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            keyCycle.f32611l = typedArray.getDimension(index, keyCycle.f32611l);
                        } else {
                            keyCycle.f32611l = typedArray.getFloat(index, keyCycle.f32611l);
                        }
                        break;
                    case 8:
                        keyCycle.f32614o = typedArray.getInt(index, keyCycle.f32614o);
                        break;
                    case 9:
                        keyCycle.f32615p = typedArray.getFloat(index, keyCycle.f32615p);
                        break;
                    case 10:
                        keyCycle.f32616q = typedArray.getDimension(index, keyCycle.f32616q);
                        break;
                    case 11:
                        keyCycle.f32617r = typedArray.getFloat(index, keyCycle.f32617r);
                        break;
                    case 12:
                        keyCycle.f32619t = typedArray.getFloat(index, keyCycle.f32619t);
                        break;
                    case 13:
                        keyCycle.f32620u = typedArray.getFloat(index, keyCycle.f32620u);
                        break;
                    case 14:
                        keyCycle.f32618s = typedArray.getFloat(index, keyCycle.f32618s);
                        break;
                    case 15:
                        keyCycle.f32621v = typedArray.getFloat(index, keyCycle.f32621v);
                        break;
                    case 16:
                        keyCycle.f32622w = typedArray.getFloat(index, keyCycle.f32622w);
                        break;
                    case 17:
                        keyCycle.f32623x = typedArray.getDimension(index, keyCycle.f32623x);
                        break;
                    case 18:
                        keyCycle.f32624y = typedArray.getDimension(index, keyCycle.f32624y);
                        break;
                    case 19:
                        keyCycle.f32625z = typedArray.getDimension(index, keyCycle.f32625z);
                        break;
                    case 20:
                        keyCycle.f32613n = typedArray.getFloat(index, keyCycle.f32613n);
                        break;
                    case 21:
                        keyCycle.f32612m = typedArray.getFloat(index, keyCycle.f32612m) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f32626a.get(index));
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.f32586d = 4;
        this.f32587e = new HashMap();
    }

    public void Y(HashMap map) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        for (String str : map.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f32587e.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.d() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (viewOscillator = (ViewOscillator) map.get(str)) != null) {
                    viewOscillator.f(this.f32583a, this.f32608i, this.f32609j, this.f32614o, this.f32610k, this.f32611l, this.f32612m, constraintAttribute.e(), constraintAttribute);
                }
            } else {
                float fZ = Z(str);
                if (!Float.isNaN(fZ) && (viewOscillator2 = (ViewOscillator) map.get(str)) != null) {
                    viewOscillator2.e(this.f32583a, this.f32608i, this.f32609j, this.f32614o, this.f32610k, this.f32611l, this.f32612m, fZ);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public float Z(String str) {
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
            case -1225497657:
                if (str.equals("translationX")) {
                    b3 = 2;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b3 = 3;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b3 = 4;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    b3 = 5;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b3 = 6;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b3 = 7;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    b3 = 8;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b3 = 9;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b3 = 10;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b3 = Ascii.VT;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    b3 = Ascii.FF;
                }
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    b3 = Ascii.CR;
                }
                break;
        }
        switch (b3) {
            case 0:
                return this.f32619t;
            case 1:
                return this.f32620u;
            case 2:
                return this.f32623x;
            case 3:
                return this.f32624y;
            case 4:
                return this.f32625z;
            case 5:
                return this.f32613n;
            case 6:
                return this.f32621v;
            case 7:
                return this.f32622w;
            case 8:
                return this.f32617r;
            case 9:
                return this.f32616q;
            case 10:
                return this.f32618s;
            case 11:
                return this.f32615p;
            case 12:
                return this.f32611l;
            case 13:
                return this.f32612m;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void a(HashMap map) {
        Debug.g("KeyCycle", "add " + map.size() + " values", 2);
        for (String str : map.keySet()) {
            SplineSet splineSet = (SplineSet) map.get(str);
            if (splineSet != null) {
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
                    case -1225497657:
                        if (str.equals("translationX")) {
                            b3 = 2;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            b3 = 3;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            b3 = 4;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            b3 = 5;
                        }
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            b3 = 6;
                        }
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            b3 = 7;
                        }
                        break;
                    case -40300674:
                        if (str.equals("rotation")) {
                            b3 = 8;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            b3 = 9;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            b3 = 10;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            b3 = Ascii.VT;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            b3 = Ascii.FF;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            b3 = Ascii.CR;
                        }
                        break;
                }
                switch (b3) {
                    case 0:
                        splineSet.e(this.f32583a, this.f32619t);
                        break;
                    case 1:
                        splineSet.e(this.f32583a, this.f32620u);
                        break;
                    case 2:
                        splineSet.e(this.f32583a, this.f32623x);
                        break;
                    case 3:
                        splineSet.e(this.f32583a, this.f32624y);
                        break;
                    case 4:
                        splineSet.e(this.f32583a, this.f32625z);
                        break;
                    case 5:
                        splineSet.e(this.f32583a, this.f32613n);
                        break;
                    case 6:
                        splineSet.e(this.f32583a, this.f32621v);
                        break;
                    case 7:
                        splineSet.e(this.f32583a, this.f32622w);
                        break;
                    case 8:
                        splineSet.e(this.f32583a, this.f32617r);
                        break;
                    case 9:
                        splineSet.e(this.f32583a, this.f32616q);
                        break;
                    case 10:
                        splineSet.e(this.f32583a, this.f32618s);
                        break;
                    case 11:
                        splineSet.e(this.f32583a, this.f32615p);
                        break;
                    case 12:
                        splineSet.e(this.f32583a, this.f32611l);
                        break;
                    case 13:
                        splineSet.e(this.f32583a, this.f32612m);
                        break;
                    default:
                        if (!str.startsWith("CUSTOM")) {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                        }
                        break;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: b */
    public Key clone() {
        return new KeyCycle().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key c(Key key) {
        super.c(key);
        KeyCycle keyCycle = (KeyCycle) key;
        this.f32606g = keyCycle.f32606g;
        this.f32607h = keyCycle.f32607h;
        this.f32608i = keyCycle.f32608i;
        this.f32609j = keyCycle.f32609j;
        this.f32610k = keyCycle.f32610k;
        this.f32611l = keyCycle.f32611l;
        this.f32612m = keyCycle.f32612m;
        this.f32613n = keyCycle.f32613n;
        this.f32614o = keyCycle.f32614o;
        this.f32615p = keyCycle.f32615p;
        this.f32616q = keyCycle.f32616q;
        this.f32617r = keyCycle.f32617r;
        this.f32618s = keyCycle.f32618s;
        this.f32619t = keyCycle.f32619t;
        this.f32620u = keyCycle.f32620u;
        this.f32621v = keyCycle.f32621v;
        this.f32622w = keyCycle.f32622w;
        this.f32623x = keyCycle.f32623x;
        this.f32624y = keyCycle.f32624y;
        this.f32625z = keyCycle.f32625z;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.f32615p)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f32616q)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f32617r)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f32619t)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f32620u)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f32621v)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f32622w)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f32618s)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f32623x)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f32624y)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f32625z)) {
            hashSet.add("translationZ");
        }
        if (this.f32587e.size() > 0) {
            Iterator it = this.f32587e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void e(Context context, AttributeSet attributeSet) {
        Loader.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.N5));
    }
}
