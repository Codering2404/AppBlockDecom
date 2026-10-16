package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyTrigger extends Key {
    HashMap A;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32662g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f32663h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f32664i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f32665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f32666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f32667l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f32668m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f32669n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f32670o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f32671p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f32672q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f32673r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f32674s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f32675t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f32676u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f32677v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f32678w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f32679x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    RectF f32680y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    RectF f32681z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Loader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f32682a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f32682a = sparseIntArray;
            sparseIntArray.append(R.styleable.U6, 8);
            f32682a.append(R.styleable.Y6, 4);
            f32682a.append(R.styleable.Z6, 1);
            f32682a.append(R.styleable.a7, 2);
            f32682a.append(R.styleable.V6, 7);
            f32682a.append(R.styleable.b7, 6);
            f32682a.append(R.styleable.d7, 5);
            f32682a.append(R.styleable.X6, 9);
            f32682a.append(R.styleable.W6, 10);
            f32682a.append(R.styleable.c7, 11);
            f32682a.append(R.styleable.e7, 12);
            f32682a.append(R.styleable.f7, 13);
            f32682a.append(R.styleable.g7, 14);
        }

        public static void a(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (f32682a.get(index)) {
                    case 1:
                        keyTrigger.f32665j = typedArray.getString(index);
                        break;
                    case 2:
                        keyTrigger.f32666k = typedArray.getString(index);
                        break;
                    case 3:
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f32682a.get(index));
                        break;
                    case 4:
                        keyTrigger.f32663h = typedArray.getString(index);
                        break;
                    case 5:
                        keyTrigger.f32670o = typedArray.getFloat(index, keyTrigger.f32670o);
                        break;
                    case 6:
                        keyTrigger.f32667l = typedArray.getResourceId(index, keyTrigger.f32667l);
                        break;
                    case 7:
                        if (MotionLayout.D0) {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.f32584b);
                            keyTrigger.f32584b = resourceId;
                            if (resourceId == -1) {
                                keyTrigger.f32585c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTrigger.f32585c = typedArray.getString(index);
                        } else {
                            keyTrigger.f32584b = typedArray.getResourceId(index, keyTrigger.f32584b);
                        }
                        break;
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.f32583a);
                        keyTrigger.f32583a = integer;
                        keyTrigger.f32674s = (integer + 0.5f) / 100.0f;
                        break;
                    case 9:
                        keyTrigger.f32668m = typedArray.getResourceId(index, keyTrigger.f32668m);
                        break;
                    case 10:
                        keyTrigger.f32676u = typedArray.getBoolean(index, keyTrigger.f32676u);
                        break;
                    case 11:
                        keyTrigger.f32664i = typedArray.getResourceId(index, keyTrigger.f32664i);
                        break;
                    case 12:
                        keyTrigger.f32679x = typedArray.getResourceId(index, keyTrigger.f32679x);
                        break;
                    case 13:
                        keyTrigger.f32677v = typedArray.getResourceId(index, keyTrigger.f32677v);
                        break;
                    case 14:
                        keyTrigger.f32678w = typedArray.getResourceId(index, keyTrigger.f32678w);
                        break;
                }
            }
        }
    }

    public KeyTrigger() {
        int i3 = Key.f32582f;
        this.f32664i = i3;
        this.f32665j = null;
        this.f32666k = null;
        this.f32667l = i3;
        this.f32668m = i3;
        this.f32669n = null;
        this.f32670o = 0.1f;
        this.f32671p = true;
        this.f32672q = true;
        this.f32673r = true;
        this.f32674s = Float.NaN;
        this.f32676u = false;
        this.f32677v = i3;
        this.f32678w = i3;
        this.f32679x = i3;
        this.f32680y = new RectF();
        this.f32681z = new RectF();
        this.A = new HashMap();
        this.f32586d = 5;
        this.f32587e = new HashMap();
    }

    private void A(String str, View view) {
        boolean z2 = str.length() == 1;
        if (!z2) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f32587e.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z2 || lowerCase.matches(str)) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f32587e.get(str2);
                if (constraintAttribute != null) {
                    constraintAttribute.a(view);
                }
            }
        }
    }

    private void B(RectF rectF, View view, boolean z2) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z2) {
            view.getMatrix().mapRect(rectF);
        }
    }

    private void z(String str, View view) {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(".")) {
            A(str, view);
            return;
        }
        if (this.A.containsKey(str)) {
            method = (Method) this.A.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = view.getClass().getMethod(str, null);
                this.A.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.A.put(str, null);
                Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + Debug.d(view));
                return;
            }
        }
        try {
            method.invoke(view, null);
        } catch (Exception unused2) {
            Log.e("KeyTrigger", "Exception in call \"" + this.f32663h + "\"on class " + view.getClass().getSimpleName() + " " + Debug.d(view));
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: b */
    public Key clone() {
        return new KeyTrigger().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key c(Key key) {
        super.c(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        this.f32662g = keyTrigger.f32662g;
        this.f32663h = keyTrigger.f32663h;
        this.f32664i = keyTrigger.f32664i;
        this.f32665j = keyTrigger.f32665j;
        this.f32666k = keyTrigger.f32666k;
        this.f32667l = keyTrigger.f32667l;
        this.f32668m = keyTrigger.f32668m;
        this.f32669n = keyTrigger.f32669n;
        this.f32670o = keyTrigger.f32670o;
        this.f32671p = keyTrigger.f32671p;
        this.f32672q = keyTrigger.f32672q;
        this.f32673r = keyTrigger.f32673r;
        this.f32674s = keyTrigger.f32674s;
        this.f32675t = keyTrigger.f32675t;
        this.f32676u = keyTrigger.f32676u;
        this.f32680y = keyTrigger.f32680y;
        this.f32681z = keyTrigger.f32681z;
        this.A = keyTrigger.A;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void e(Context context, AttributeSet attributeSet) {
        Loader.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.T6), context);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(float r10, android.view.View r11) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.y(float, android.view.View):void");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void a(HashMap map) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void d(HashSet hashSet) {
    }
}
