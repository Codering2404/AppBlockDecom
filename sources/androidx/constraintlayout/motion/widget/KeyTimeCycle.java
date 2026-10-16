package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyTimeCycle extends Key {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f32643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32644h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f32645i = Float.NaN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f32646j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f32647k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f32648l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f32649m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f32650n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f32651o = Float.NaN;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f32652p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f32653q = Float.NaN;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f32654r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f32655s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f32656t = Float.NaN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f32657u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f32658v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f32659w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f32660x = 0.0f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Loader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f32661a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f32661a = sparseIntArray;
            sparseIntArray.append(R.styleable.A6, 1);
            f32661a.append(R.styleable.J6, 2);
            f32661a.append(R.styleable.F6, 4);
            f32661a.append(R.styleable.G6, 5);
            f32661a.append(R.styleable.H6, 6);
            f32661a.append(R.styleable.D6, 7);
            f32661a.append(R.styleable.P6, 8);
            f32661a.append(R.styleable.O6, 9);
            f32661a.append(R.styleable.N6, 10);
            f32661a.append(R.styleable.L6, 12);
            f32661a.append(R.styleable.K6, 13);
            f32661a.append(R.styleable.E6, 14);
            f32661a.append(R.styleable.B6, 15);
            f32661a.append(R.styleable.C6, 16);
            f32661a.append(R.styleable.I6, 17);
            f32661a.append(R.styleable.M6, 18);
            f32661a.append(R.styleable.R6, 20);
            f32661a.append(R.styleable.Q6, 21);
            f32661a.append(R.styleable.S6, 19);
        }

        public static void a(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (f32661a.get(index)) {
                    case 1:
                        keyTimeCycle.f32645i = typedArray.getFloat(index, keyTimeCycle.f32645i);
                        break;
                    case 2:
                        keyTimeCycle.f32646j = typedArray.getDimension(index, keyTimeCycle.f32646j);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f32661a.get(index));
                        break;
                    case 4:
                        keyTimeCycle.f32647k = typedArray.getFloat(index, keyTimeCycle.f32647k);
                        break;
                    case 5:
                        keyTimeCycle.f32648l = typedArray.getFloat(index, keyTimeCycle.f32648l);
                        break;
                    case 6:
                        keyTimeCycle.f32649m = typedArray.getFloat(index, keyTimeCycle.f32649m);
                        break;
                    case 7:
                        keyTimeCycle.f32651o = typedArray.getFloat(index, keyTimeCycle.f32651o);
                        break;
                    case 8:
                        keyTimeCycle.f32650n = typedArray.getFloat(index, keyTimeCycle.f32650n);
                        break;
                    case 9:
                        keyTimeCycle.f32643g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.D0) {
                            int resourceId = typedArray.getResourceId(index, keyTimeCycle.f32584b);
                            keyTimeCycle.f32584b = resourceId;
                            if (resourceId == -1) {
                                keyTimeCycle.f32585c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTimeCycle.f32585c = typedArray.getString(index);
                        } else {
                            keyTimeCycle.f32584b = typedArray.getResourceId(index, keyTimeCycle.f32584b);
                        }
                        break;
                    case 12:
                        keyTimeCycle.f32583a = typedArray.getInt(index, keyTimeCycle.f32583a);
                        break;
                    case 13:
                        keyTimeCycle.f32644h = typedArray.getInteger(index, keyTimeCycle.f32644h);
                        break;
                    case 14:
                        keyTimeCycle.f32652p = typedArray.getFloat(index, keyTimeCycle.f32652p);
                        break;
                    case 15:
                        keyTimeCycle.f32653q = typedArray.getDimension(index, keyTimeCycle.f32653q);
                        break;
                    case 16:
                        keyTimeCycle.f32654r = typedArray.getDimension(index, keyTimeCycle.f32654r);
                        break;
                    case 17:
                        keyTimeCycle.f32655s = typedArray.getDimension(index, keyTimeCycle.f32655s);
                        break;
                    case 18:
                        keyTimeCycle.f32656t = typedArray.getFloat(index, keyTimeCycle.f32656t);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            keyTimeCycle.f32658v = typedArray.getString(index);
                            keyTimeCycle.f32657u = 7;
                        } else {
                            keyTimeCycle.f32657u = typedArray.getInt(index, keyTimeCycle.f32657u);
                        }
                        break;
                    case 20:
                        keyTimeCycle.f32659w = typedArray.getFloat(index, keyTimeCycle.f32659w);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            keyTimeCycle.f32660x = typedArray.getDimension(index, keyTimeCycle.f32660x);
                        } else {
                            keyTimeCycle.f32660x = typedArray.getFloat(index, keyTimeCycle.f32660x);
                        }
                        break;
                }
            }
        }
    }

    public KeyTimeCycle() {
        this.f32586d = 3;
        this.f32587e = new HashMap();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void U(HashMap map) {
        for (String str : map.keySet()) {
            ViewTimeCycle viewTimeCycle = (ViewTimeCycle) map.get(str);
            if (viewTimeCycle != null) {
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
                        case -40300674:
                            b3 = str.equals("rotation") ? (byte) 8 : (byte) -1;
                            break;
                        case -4379043:
                            b3 = str.equals("elevation") ? (byte) 9 : (byte) -1;
                            break;
                        case 37232917:
                            b3 = str.equals("transitionPathRotate") ? (byte) 10 : (byte) -1;
                            break;
                        case 92909918:
                            b3 = str.equals("alpha") ? Ascii.VT : (byte) -1;
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    switch (b3) {
                        case 0:
                            if (!Float.isNaN(this.f32648l)) {
                                viewTimeCycle.b(this.f32583a, this.f32648l, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.f32649m)) {
                                viewTimeCycle.b(this.f32583a, this.f32649m, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.f32653q)) {
                                viewTimeCycle.b(this.f32583a, this.f32653q, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.f32654r)) {
                                viewTimeCycle.b(this.f32583a, this.f32654r, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.f32655s)) {
                                viewTimeCycle.b(this.f32583a, this.f32655s, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.f32656t)) {
                                viewTimeCycle.b(this.f32583a, this.f32656t, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.f32651o)) {
                                viewTimeCycle.b(this.f32583a, this.f32651o, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.f32652p)) {
                                viewTimeCycle.b(this.f32583a, this.f32652p, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.f32647k)) {
                                viewTimeCycle.b(this.f32583a, this.f32647k, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.f32646j)) {
                                viewTimeCycle.b(this.f32583a, this.f32646j, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.f32650n)) {
                                viewTimeCycle.b(this.f32583a, this.f32650n, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.f32645i)) {
                                viewTimeCycle.b(this.f32583a, this.f32645i, this.f32659w, this.f32657u, this.f32660x);
                            }
                            break;
                        default:
                            Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                } else {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f32587e.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((ViewTimeCycle.CustomSet) viewTimeCycle).j(this.f32583a, constraintAttribute, this.f32659w, this.f32657u, this.f32660x);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void a(HashMap map) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: b */
    public Key clone() {
        return new KeyTimeCycle().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key c(Key key) {
        super.c(key);
        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) key;
        this.f32643g = keyTimeCycle.f32643g;
        this.f32644h = keyTimeCycle.f32644h;
        this.f32657u = keyTimeCycle.f32657u;
        this.f32659w = keyTimeCycle.f32659w;
        this.f32660x = keyTimeCycle.f32660x;
        this.f32656t = keyTimeCycle.f32656t;
        this.f32645i = keyTimeCycle.f32645i;
        this.f32646j = keyTimeCycle.f32646j;
        this.f32647k = keyTimeCycle.f32647k;
        this.f32650n = keyTimeCycle.f32650n;
        this.f32648l = keyTimeCycle.f32648l;
        this.f32649m = keyTimeCycle.f32649m;
        this.f32651o = keyTimeCycle.f32651o;
        this.f32652p = keyTimeCycle.f32652p;
        this.f32653q = keyTimeCycle.f32653q;
        this.f32654r = keyTimeCycle.f32654r;
        this.f32655s = keyTimeCycle.f32655s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.f32645i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f32646j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f32647k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f32648l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f32649m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f32653q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f32654r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f32655s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f32650n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f32651o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f32652p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f32656t)) {
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
        Loader.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.z6));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void h(HashMap map) {
        if (this.f32644h == -1) {
            return;
        }
        if (!Float.isNaN(this.f32645i)) {
            map.put("alpha", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32646j)) {
            map.put("elevation", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32647k)) {
            map.put("rotation", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32648l)) {
            map.put("rotationX", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32649m)) {
            map.put("rotationY", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32653q)) {
            map.put("translationX", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32654r)) {
            map.put("translationY", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32655s)) {
            map.put("translationZ", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32650n)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32651o)) {
            map.put("scaleX", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32651o)) {
            map.put("scaleY", Integer.valueOf(this.f32644h));
        }
        if (!Float.isNaN(this.f32656t)) {
            map.put("progress", Integer.valueOf(this.f32644h));
        }
        if (this.f32587e.size() > 0) {
            Iterator it = this.f32587e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + ((String) it.next()), Integer.valueOf(this.f32644h));
            }
        }
    }
}
