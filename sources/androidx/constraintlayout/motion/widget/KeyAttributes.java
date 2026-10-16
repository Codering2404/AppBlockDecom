package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyAttributes extends Key {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f32588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32589h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f32590i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f32591j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f32592k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f32593l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f32594m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f32595n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f32596o = Float.NaN;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f32597p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f32598q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f32599r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f32600s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f32601t = Float.NaN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f32602u = Float.NaN;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f32603v = Float.NaN;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f32604w = Float.NaN;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Loader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f32605a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f32605a = sparseIntArray;
            sparseIntArray.append(R.styleable.v5, 1);
            f32605a.append(R.styleable.G5, 2);
            f32605a.append(R.styleable.C5, 4);
            f32605a.append(R.styleable.D5, 5);
            f32605a.append(R.styleable.E5, 6);
            f32605a.append(R.styleable.w5, 19);
            f32605a.append(R.styleable.x5, 20);
            f32605a.append(R.styleable.A5, 7);
            f32605a.append(R.styleable.M5, 8);
            f32605a.append(R.styleable.L5, 9);
            f32605a.append(R.styleable.K5, 10);
            f32605a.append(R.styleable.I5, 12);
            f32605a.append(R.styleable.H5, 13);
            f32605a.append(R.styleable.B5, 14);
            f32605a.append(R.styleable.y5, 15);
            f32605a.append(R.styleable.z5, 16);
            f32605a.append(R.styleable.F5, 17);
            f32605a.append(R.styleable.J5, 18);
        }

        public static void a(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (f32605a.get(index)) {
                    case 1:
                        keyAttributes.f32591j = typedArray.getFloat(index, keyAttributes.f32591j);
                        break;
                    case 2:
                        keyAttributes.f32592k = typedArray.getDimension(index, keyAttributes.f32592k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f32605a.get(index));
                        break;
                    case 4:
                        keyAttributes.f32593l = typedArray.getFloat(index, keyAttributes.f32593l);
                        break;
                    case 5:
                        keyAttributes.f32594m = typedArray.getFloat(index, keyAttributes.f32594m);
                        break;
                    case 6:
                        keyAttributes.f32595n = typedArray.getFloat(index, keyAttributes.f32595n);
                        break;
                    case 7:
                        keyAttributes.f32599r = typedArray.getFloat(index, keyAttributes.f32599r);
                        break;
                    case 8:
                        keyAttributes.f32598q = typedArray.getFloat(index, keyAttributes.f32598q);
                        break;
                    case 9:
                        keyAttributes.f32588g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.D0) {
                            int resourceId = typedArray.getResourceId(index, keyAttributes.f32584b);
                            keyAttributes.f32584b = resourceId;
                            if (resourceId == -1) {
                                keyAttributes.f32585c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyAttributes.f32585c = typedArray.getString(index);
                        } else {
                            keyAttributes.f32584b = typedArray.getResourceId(index, keyAttributes.f32584b);
                        }
                        break;
                    case 12:
                        keyAttributes.f32583a = typedArray.getInt(index, keyAttributes.f32583a);
                        break;
                    case 13:
                        keyAttributes.f32589h = typedArray.getInteger(index, keyAttributes.f32589h);
                        break;
                    case 14:
                        keyAttributes.f32600s = typedArray.getFloat(index, keyAttributes.f32600s);
                        break;
                    case 15:
                        keyAttributes.f32601t = typedArray.getDimension(index, keyAttributes.f32601t);
                        break;
                    case 16:
                        keyAttributes.f32602u = typedArray.getDimension(index, keyAttributes.f32602u);
                        break;
                    case 17:
                        keyAttributes.f32603v = typedArray.getDimension(index, keyAttributes.f32603v);
                        break;
                    case 18:
                        keyAttributes.f32604w = typedArray.getFloat(index, keyAttributes.f32604w);
                        break;
                    case 19:
                        keyAttributes.f32596o = typedArray.getDimension(index, keyAttributes.f32596o);
                        break;
                    case 20:
                        keyAttributes.f32597p = typedArray.getDimension(index, keyAttributes.f32597p);
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.f32586d = 1;
        this.f32587e = new HashMap();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void R(String str, Object obj) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    b3 = 0;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    b3 = 1;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    b3 = 2;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    b3 = 3;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b3 = 4;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b3 = 5;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b3 = 6;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b3 = 7;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b3 = 8;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    b3 = 9;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    b3 = 10;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    b3 = Ascii.VT;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b3 = Ascii.FF;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b3 = Ascii.CR;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b3 = Ascii.SO;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    b3 = Ascii.SI;
                }
                break;
            case 1941332754:
                if (str.equals(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY)) {
                    b3 = Ascii.DLE;
                }
                break;
        }
        switch (b3) {
            case 0:
                this.f32604w = k(obj);
                break;
            case 1:
                this.f32588g = obj.toString();
                break;
            case 2:
                this.f32594m = k(obj);
                break;
            case 3:
                this.f32595n = k(obj);
                break;
            case 4:
                this.f32601t = k(obj);
                break;
            case 5:
                this.f32602u = k(obj);
                break;
            case 6:
                this.f32603v = k(obj);
                break;
            case 7:
                this.f32599r = k(obj);
                break;
            case 8:
                this.f32600s = k(obj);
                break;
            case 9:
                this.f32596o = k(obj);
                break;
            case 10:
                this.f32597p = k(obj);
                break;
            case 11:
                this.f32593l = k(obj);
                break;
            case 12:
                this.f32592k = k(obj);
                break;
            case 13:
                this.f32598q = k(obj);
                break;
            case 14:
                this.f32591j = k(obj);
                break;
            case 15:
                this.f32589h = l(obj);
                break;
            case 16:
                this.f32590i = j(obj);
                break;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void a(HashMap map) {
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
                        case -1225497657:
                            b3 = str.equals("translationX") ? (byte) 2 : (byte) -1;
                            break;
                        case -1225497656:
                            b3 = str.equals("translationY") ? (byte) 3 : (byte) -1;
                            break;
                        case -1225497655:
                            b3 = str.equals("translationZ") ? (byte) 4 : (byte) -1;
                            break;
                        case -1001078227:
                            b3 = str.equals("progress") ? (byte) 5 : (byte) -1;
                            break;
                        case -908189618:
                            b3 = str.equals("scaleX") ? (byte) 6 : (byte) -1;
                            break;
                        case -908189617:
                            if (!str.equals("scaleY")) {
                                b3 = -1;
                            }
                            break;
                        case -760884510:
                            b3 = str.equals("transformPivotX") ? (byte) 8 : (byte) -1;
                            break;
                        case -760884509:
                            b3 = str.equals("transformPivotY") ? (byte) 9 : (byte) -1;
                            break;
                        case -40300674:
                            b3 = str.equals("rotation") ? (byte) 10 : (byte) -1;
                            break;
                        case -4379043:
                            b3 = str.equals("elevation") ? Ascii.VT : (byte) -1;
                            break;
                        case 37232917:
                            b3 = str.equals("transitionPathRotate") ? Ascii.FF : (byte) -1;
                            break;
                        case 92909918:
                            b3 = str.equals("alpha") ? Ascii.CR : (byte) -1;
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    switch (b3) {
                        case 0:
                            if (!Float.isNaN(this.f32594m)) {
                                splineSet.e(this.f32583a, this.f32594m);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.f32595n)) {
                                splineSet.e(this.f32583a, this.f32595n);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.f32601t)) {
                                splineSet.e(this.f32583a, this.f32601t);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.f32602u)) {
                                splineSet.e(this.f32583a, this.f32602u);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.f32603v)) {
                                splineSet.e(this.f32583a, this.f32603v);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.f32604w)) {
                                splineSet.e(this.f32583a, this.f32604w);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.f32599r)) {
                                splineSet.e(this.f32583a, this.f32599r);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.f32600s)) {
                                splineSet.e(this.f32583a, this.f32600s);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.f32594m)) {
                                splineSet.e(this.f32583a, this.f32596o);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.f32595n)) {
                                splineSet.e(this.f32583a, this.f32597p);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.f32593l)) {
                                splineSet.e(this.f32583a, this.f32593l);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.f32592k)) {
                                splineSet.e(this.f32583a, this.f32592k);
                            }
                            break;
                        case 12:
                            if (!Float.isNaN(this.f32598q)) {
                                splineSet.e(this.f32583a, this.f32598q);
                            }
                            break;
                        case 13:
                            if (!Float.isNaN(this.f32591j)) {
                                splineSet.e(this.f32583a, this.f32591j);
                            }
                            break;
                    }
                } else {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f32587e.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((ViewSpline.CustomSet) splineSet).l(this.f32583a, constraintAttribute);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: b */
    public Key clone() {
        return new KeyAttributes().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key c(Key key) {
        super.c(key);
        KeyAttributes keyAttributes = (KeyAttributes) key;
        this.f32589h = keyAttributes.f32589h;
        this.f32590i = keyAttributes.f32590i;
        this.f32591j = keyAttributes.f32591j;
        this.f32592k = keyAttributes.f32592k;
        this.f32593l = keyAttributes.f32593l;
        this.f32594m = keyAttributes.f32594m;
        this.f32595n = keyAttributes.f32595n;
        this.f32596o = keyAttributes.f32596o;
        this.f32597p = keyAttributes.f32597p;
        this.f32598q = keyAttributes.f32598q;
        this.f32599r = keyAttributes.f32599r;
        this.f32600s = keyAttributes.f32600s;
        this.f32601t = keyAttributes.f32601t;
        this.f32602u = keyAttributes.f32602u;
        this.f32603v = keyAttributes.f32603v;
        this.f32604w = keyAttributes.f32604w;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.f32591j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f32592k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f32593l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f32594m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f32595n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f32596o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f32597p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f32601t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f32602u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f32603v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f32598q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f32599r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f32600s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f32604w)) {
            hashSet.add("progress");
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
        Loader.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.u5));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void h(HashMap map) {
        if (this.f32589h == -1) {
            return;
        }
        if (!Float.isNaN(this.f32591j)) {
            map.put("alpha", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32592k)) {
            map.put("elevation", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32593l)) {
            map.put("rotation", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32594m)) {
            map.put("rotationX", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32595n)) {
            map.put("rotationY", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32596o)) {
            map.put("transformPivotX", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32597p)) {
            map.put("transformPivotY", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32601t)) {
            map.put("translationX", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32602u)) {
            map.put("translationY", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32603v)) {
            map.put("translationZ", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32598q)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32599r)) {
            map.put("scaleX", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32600s)) {
            map.put("scaleY", Integer.valueOf(this.f32589h));
        }
        if (!Float.isNaN(this.f32604w)) {
            map.put("progress", Integer.valueOf(this.f32589h));
        }
        if (this.f32587e.size() > 0) {
            Iterator it = this.f32587e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + ((String) it.next()), Integer.valueOf(this.f32589h));
            }
        }
    }
}
