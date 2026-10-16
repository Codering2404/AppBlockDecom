package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyPosition extends KeyPositionBase {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f32629h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f32630i = Key.f32582f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f32631j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f32632k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f32633l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f32634m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f32635n = Float.NaN;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f32636o = Float.NaN;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f32637p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f32638q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f32639r = Float.NaN;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f32640s = Float.NaN;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Loader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f32641a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f32641a = sparseIntArray;
            sparseIntArray.append(R.styleable.r6, 1);
            f32641a.append(R.styleable.p6, 2);
            f32641a.append(R.styleable.y6, 3);
            f32641a.append(R.styleable.n6, 4);
            f32641a.append(R.styleable.o6, 5);
            f32641a.append(R.styleable.v6, 6);
            f32641a.append(R.styleable.w6, 7);
            f32641a.append(R.styleable.q6, 9);
            f32641a.append(R.styleable.x6, 8);
            f32641a.append(R.styleable.u6, 11);
            f32641a.append(R.styleable.t6, 12);
            f32641a.append(R.styleable.s6, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (f32641a.get(index)) {
                    case 1:
                        if (MotionLayout.D0) {
                            int resourceId = typedArray.getResourceId(index, keyPosition.f32584b);
                            keyPosition.f32584b = resourceId;
                            if (resourceId == -1) {
                                keyPosition.f32585c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyPosition.f32585c = typedArray.getString(index);
                        } else {
                            keyPosition.f32584b = typedArray.getResourceId(index, keyPosition.f32584b);
                        }
                        break;
                    case 2:
                        keyPosition.f32583a = typedArray.getInt(index, keyPosition.f32583a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            keyPosition.f32629h = typedArray.getString(index);
                        } else {
                            keyPosition.f32629h = Easing.f31744c[typedArray.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        keyPosition.f32642g = typedArray.getInteger(index, keyPosition.f32642g);
                        break;
                    case 5:
                        keyPosition.f32631j = typedArray.getInt(index, keyPosition.f32631j);
                        break;
                    case 6:
                        keyPosition.f32634m = typedArray.getFloat(index, keyPosition.f32634m);
                        break;
                    case 7:
                        keyPosition.f32635n = typedArray.getFloat(index, keyPosition.f32635n);
                        break;
                    case 8:
                        float f3 = typedArray.getFloat(index, keyPosition.f32633l);
                        keyPosition.f32632k = f3;
                        keyPosition.f32633l = f3;
                        break;
                    case 9:
                        keyPosition.f32638q = typedArray.getInt(index, keyPosition.f32638q);
                        break;
                    case 10:
                        keyPosition.f32630i = typedArray.getInt(index, keyPosition.f32630i);
                        break;
                    case 11:
                        keyPosition.f32632k = typedArray.getFloat(index, keyPosition.f32632k);
                        break;
                    case 12:
                        keyPosition.f32633l = typedArray.getFloat(index, keyPosition.f32633l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f32641a.get(index));
                        break;
                }
            }
            if (keyPosition.f32583a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public KeyPosition() {
        this.f32586d = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: b */
    public Key clone() {
        return new KeyPosition().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key c(Key key) {
        super.c(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.f32629h = keyPosition.f32629h;
        this.f32630i = keyPosition.f32630i;
        this.f32631j = keyPosition.f32631j;
        this.f32632k = keyPosition.f32632k;
        this.f32633l = Float.NaN;
        this.f32634m = keyPosition.f32634m;
        this.f32635n = keyPosition.f32635n;
        this.f32636o = keyPosition.f32636o;
        this.f32637p = keyPosition.f32637p;
        this.f32639r = keyPosition.f32639r;
        this.f32640s = keyPosition.f32640s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void e(Context context, AttributeSet attributeSet) {
        Loader.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.m6));
    }

    public void m(int i3) {
        this.f32638q = i3;
    }

    public void n(String str, Object obj) {
        str.getClass();
        switch (str) {
            case "transitionEasing":
                this.f32629h = obj.toString();
                break;
            case "percentWidth":
                this.f32632k = k(obj);
                break;
            case "percentHeight":
                this.f32633l = k(obj);
                break;
            case "drawPath":
                this.f32631j = l(obj);
                break;
            case "sizePercent":
                float fK = k(obj);
                this.f32632k = fK;
                this.f32633l = fK;
                break;
            case "percentX":
                this.f32634m = k(obj);
                break;
            case "percentY":
                this.f32635n = k(obj);
                break;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void a(HashMap map) {
    }
}
