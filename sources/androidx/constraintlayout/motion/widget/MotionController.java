package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionController {
    private HashMap B;
    private HashMap C;
    private HashMap D;
    private KeyTrigger[] E;
    private int F;
    private int G;
    private View H;
    private int I;
    private float J;
    private Interpolator K;
    private boolean L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View f32709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f32710c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f32712e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CurveFit[] f32718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CurveFit f32719l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f32723p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f32724q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int[] f32725r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private double[] f32726s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private double[] f32727t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String[] f32728u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int[] f32729v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Rect f32708a = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f32711d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32713f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MotionPaths f32714g = new MotionPaths();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MotionPaths f32715h = new MotionPaths();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MotionConstrainedPoint f32716i = new MotionConstrainedPoint();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MotionConstrainedPoint f32717j = new MotionConstrainedPoint();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f32720m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f32721n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f32722o = 1.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f32730w = 4;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float[] f32731x = new float[4];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ArrayList f32732y = new ArrayList();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float[] f32733z = new float[1];
    private ArrayList A = new ArrayList();

    MotionController(View view) {
        int i3 = Key.f32582f;
        this.F = i3;
        this.G = i3;
        this.H = null;
        this.I = i3;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        H(view);
    }

    private float g(float f3, float[] fArr) {
        float f4 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f5 = this.f32722o;
            if (f5 != 1.0d) {
                float f6 = this.f32721n;
                if (f3 < f6) {
                    f3 = 0.0f;
                }
                if (f3 > f6 && f3 < 1.0d) {
                    f3 = Math.min((f3 - f6) * f5, 1.0f);
                }
            }
        }
        Easing easing = this.f32714g.f32844a;
        ArrayList arrayList = this.f32732y;
        int size = arrayList.size();
        float f7 = Float.NaN;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            MotionPaths motionPaths = (MotionPaths) obj;
            Easing easing2 = motionPaths.f32844a;
            if (easing2 != null) {
                float f8 = motionPaths.f32846c;
                if (f8 < f3) {
                    easing = easing2;
                    f4 = f8;
                } else if (Float.isNaN(f7)) {
                    f7 = motionPaths.f32846c;
                }
            }
        }
        if (easing != null) {
            float f9 = (Float.isNaN(f7) ? 1.0f : f7) - f4;
            double d3 = (f3 - f4) / f9;
            f3 = (((float) easing.a(d3)) * f9) + f4;
            if (fArr != null) {
                fArr[0] = (float) easing.b(d3);
            }
        }
        return f3;
    }

    private static Interpolator p(Context context, int i3, String str, int i4) {
        if (i3 == -2) {
            return AnimationUtils.loadInterpolator(context, i4);
        }
        if (i3 == -1) {
            final Easing easingC = Easing.c(str);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f3) {
                    return (float) easingC.a(f3);
                }
            };
        }
        if (i3 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i3 == 1) {
            return new AccelerateInterpolator();
        }
        if (i3 == 2) {
            return new DecelerateInterpolator();
        }
        if (i3 == 4) {
            return new BounceInterpolator();
        }
        if (i3 != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    private float s() {
        float[] fArr = new float[2];
        float f3 = 1.0f / 99;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i3 = 0;
        float fHypot = 0.0f;
        while (i3 < 100) {
            float f4 = i3 * f3;
            double dA = f4;
            Easing easing = this.f32714g.f32844a;
            ArrayList arrayList = this.f32732y;
            int size = arrayList.size();
            float f5 = Float.NaN;
            int i4 = 0;
            float f6 = 0.0f;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                float f7 = f3;
                MotionPaths motionPaths = (MotionPaths) obj;
                int i5 = i3;
                Easing easing2 = motionPaths.f32844a;
                if (easing2 != null) {
                    float f8 = motionPaths.f32846c;
                    if (f8 < f4) {
                        f6 = f8;
                        easing = easing2;
                    } else if (Float.isNaN(f5)) {
                        f5 = motionPaths.f32846c;
                    }
                }
                i3 = i5;
                f3 = f7;
            }
            float f9 = f3;
            int i6 = i3;
            if (easing != null) {
                if (Float.isNaN(f5)) {
                    f5 = 1.0f;
                }
                dA = (((float) easing.a((f4 - f6) / r16)) * (f5 - f6)) + f6;
            }
            this.f32718k[0].d(dA, this.f32726s);
            float f10 = fHypot;
            this.f32714g.f(dA, this.f32725r, this.f32726s, fArr, 0);
            fHypot = i6 > 0 ? (float) (((double) f10) + Math.hypot(d4 - ((double) fArr[1]), d3 - ((double) fArr[0]))) : f10;
            d3 = fArr[0];
            d4 = fArr[1];
            i3 = i6 + 1;
            f3 = f9;
        }
        return fHypot;
    }

    private void w(MotionPaths motionPaths) {
        if (Collections.binarySearch(this.f32732y, motionPaths) == 0) {
            Log.e("MotionController", " KeyPath position \"" + motionPaths.f32847d + "\" outside of range");
        }
        this.f32732y.add((-r0) - 1, motionPaths);
    }

    private void y(MotionPaths motionPaths) {
        motionPaths.p((int) this.f32709b.getX(), (int) this.f32709b.getY(), this.f32709b.getWidth(), this.f32709b.getHeight());
    }

    void A(Rect rect, Rect rect2, int i3, int i4, int i5) {
        if (i3 == 1) {
            int i6 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i5 - ((i6 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i3 == 2) {
            int i7 = rect.left + rect.right;
            rect2.left = i4 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i7 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i3 == 3) {
            int i8 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i8 / 2);
            rect2.top = i5 - ((i8 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i3 != 4) {
            return;
        }
        int i9 = rect.left + rect.right;
        rect2.left = i4 - (((rect.bottom + rect.top) + rect.width()) / 2);
        rect2.top = (i9 - rect.height()) / 2;
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    void B(View view) {
        MotionPaths motionPaths = this.f32714g;
        motionPaths.f32846c = 0.0f;
        motionPaths.f32847d = 0.0f;
        this.L = true;
        motionPaths.p(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f32715h.p(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f32716i.j(view);
        this.f32717j.j(view);
    }

    void C(Rect rect, ConstraintSet constraintSet, int i3, int i4) {
        MotionController motionController;
        int i5 = constraintSet.f33187d;
        if (i5 != 0) {
            motionController = this;
            motionController.A(rect, this.f32708a, i5, i3, i4);
            rect = motionController.f32708a;
        } else {
            motionController = this;
        }
        MotionPaths motionPaths = motionController.f32715h;
        motionPaths.f32846c = 1.0f;
        motionPaths.f32847d = 1.0f;
        y(motionPaths);
        motionController.f32715h.p(rect.left, rect.top, rect.width(), rect.height());
        motionController.f32715h.a(constraintSet.B(motionController.f32710c));
        motionController.f32717j.i(rect, constraintSet, i5, motionController.f32710c);
    }

    public void D(int i3) {
        this.F = i3;
    }

    void E(View view) {
        MotionPaths motionPaths = this.f32714g;
        motionPaths.f32846c = 0.0f;
        motionPaths.f32847d = 0.0f;
        motionPaths.p(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f32716i.j(view);
    }

    void F(Rect rect, ConstraintSet constraintSet, int i3, int i4) {
        MotionController motionController;
        Rect rect2;
        int i5 = constraintSet.f33187d;
        if (i5 != 0) {
            motionController = this;
            rect2 = rect;
            motionController.A(rect2, this.f32708a, i5, i3, i4);
        } else {
            motionController = this;
            rect2 = rect;
        }
        MotionPaths motionPaths = motionController.f32714g;
        motionPaths.f32846c = 0.0f;
        motionPaths.f32847d = 0.0f;
        y(motionPaths);
        motionController.f32714g.p(rect2.left, rect2.top, rect2.width(), rect2.height());
        ConstraintSet.Constraint constraintB = constraintSet.B(motionController.f32710c);
        motionController.f32714g.a(constraintB);
        motionController.f32720m = constraintB.f33194d.f33262g;
        motionController.f32716i.i(rect2, constraintSet, i5, motionController.f32710c);
        motionController.G = constraintB.f33196f.f33284i;
        ConstraintSet.Motion motion = constraintB.f33194d;
        motionController.I = motion.f33266k;
        motionController.J = motion.f33265j;
        Context context = motionController.f32709b.getContext();
        ConstraintSet.Motion motion2 = constraintB.f33194d;
        motionController.K = p(context, motion2.f33268m, motion2.f33267l, motion2.f33269n);
    }

    public void G(ViewState viewState, View view, int i3, int i4, int i5) {
        MotionPaths motionPaths = this.f32714g;
        motionPaths.f32846c = 0.0f;
        motionPaths.f32847d = 0.0f;
        Rect rect = new Rect();
        if (i3 == 1) {
            int i6 = viewState.f32565b + viewState.f32567d;
            rect.left = ((viewState.f32566c + viewState.f32568e) - viewState.b()) / 2;
            rect.top = i4 - ((i6 + viewState.a()) / 2);
            rect.right = rect.left + viewState.b();
            rect.bottom = rect.top + viewState.a();
        } else if (i3 == 2) {
            int i7 = viewState.f32565b + viewState.f32567d;
            rect.left = i5 - (((viewState.f32566c + viewState.f32568e) + viewState.b()) / 2);
            rect.top = (i7 - viewState.a()) / 2;
            rect.right = rect.left + viewState.b();
            rect.bottom = rect.top + viewState.a();
        }
        this.f32714g.p(rect.left, rect.top, rect.width(), rect.height());
        this.f32716i.h(rect, view, i3, viewState.f32564a);
    }

    public void H(View view) {
        this.f32709b = view;
        this.f32710c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f32712e = ((ConstraintLayout.LayoutParams) layoutParams).a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void I(int i3, int i4, float f3, long j3) {
        ArrayList arrayList;
        int i5;
        String[] strArr;
        int i6;
        int i7;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle viewTimeCycleH;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        int i8;
        ViewSpline viewSplineJ;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet();
        HashSet<String> hashSet2 = new HashSet();
        HashSet<String> hashSet3 = new HashSet();
        HashMap map = new HashMap();
        int i9 = this.F;
        if (i9 != Key.f32582f) {
            this.f32714g.f32854l = i9;
        }
        this.f32716i.f(this.f32717j, hashSet2);
        ArrayList arrayList2 = this.A;
        int i10 = 0;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i11 = 0;
            arrayList = null;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                Key key = (Key) obj;
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    w(new MotionPaths(i3, i4, keyPosition, this.f32714g, this.f32715h));
                    int i12 = keyPosition.f32642g;
                    if (i12 != Key.f32582f) {
                        this.f32713f = i12;
                    }
                } else if (key instanceof KeyCycle) {
                    key.d(hashSet3);
                } else if (key instanceof KeyTimeCycle) {
                    key.d(hashSet);
                } else if (key instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) key);
                } else {
                    key.h(map);
                    key.d(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.E = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        int i13 = 1;
        if (hashSet2.isEmpty()) {
            i5 = 1;
        } else {
            this.C = new HashMap();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[i13];
                    ArrayList arrayList3 = this.A;
                    int size2 = arrayList3.size();
                    int i14 = i10;
                    while (i14 < size2) {
                        Object obj2 = arrayList3.get(i14);
                        i14++;
                        int i15 = i13;
                        Key key2 = (Key) obj2;
                        HashMap map2 = key2.f32587e;
                        if (map2 != null && (constraintAttribute3 = (ConstraintAttribute) map2.get(str2)) != null) {
                            sparseArray.append(key2.f32583a, constraintAttribute3);
                        }
                        i13 = i15;
                    }
                    i8 = i13;
                    viewSplineJ = ViewSpline.i(str, sparseArray);
                } else {
                    i8 = i13;
                    viewSplineJ = ViewSpline.j(str);
                }
                if (viewSplineJ != null) {
                    viewSplineJ.g(str);
                    this.C.put(str, viewSplineJ);
                }
                i13 = i8;
                i10 = 0;
            }
            i5 = i13;
            ArrayList arrayList4 = this.A;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i16 = 0;
                while (i16 < size3) {
                    Object obj3 = arrayList4.get(i16);
                    i16++;
                    Key key3 = (Key) obj3;
                    if (key3 instanceof KeyAttributes) {
                        key3.a(this.C);
                    }
                }
            }
            this.f32716i.a(this.C, 0);
            this.f32717j.a(this.C, 100);
            for (String str3 : this.C.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = (Integer) map.get(str3)) == null) ? 0 : num.intValue();
                SplineSet splineSet = (SplineSet) this.C.get(str3);
                if (splineSet != null) {
                    splineSet.h(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.B == null) {
                this.B = new HashMap();
            }
            for (String str4 : hashSet) {
                if (!this.B.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[i5];
                        ArrayList arrayList5 = this.A;
                        int size4 = arrayList5.size();
                        int i17 = 0;
                        while (i17 < size4) {
                            Object obj4 = arrayList5.get(i17);
                            i17++;
                            Key key4 = (Key) obj4;
                            HashMap map3 = key4.f32587e;
                            if (map3 != null && (constraintAttribute2 = (ConstraintAttribute) map3.get(str5)) != null) {
                                sparseArray2.append(key4.f32583a, constraintAttribute2);
                            }
                        }
                        viewTimeCycleH = ViewTimeCycle.g(str4, sparseArray2);
                    } else {
                        viewTimeCycleH = ViewTimeCycle.h(str4, j3);
                    }
                    if (viewTimeCycleH != null) {
                        viewTimeCycleH.d(str4);
                        this.B.put(str4, viewTimeCycleH);
                    }
                }
            }
            ArrayList arrayList6 = this.A;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i18 = 0;
                while (i18 < size5) {
                    Object obj5 = arrayList6.get(i18);
                    i18++;
                    Key key5 = (Key) obj5;
                    if (key5 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key5).U(this.B);
                    }
                }
            }
            for (String str6 : this.B.keySet()) {
                ((ViewTimeCycle) this.B.get(str6)).e(map.containsKey(str6) ? ((Integer) map.get(str6)).intValue() : 0);
            }
        }
        int size6 = this.f32732y.size();
        int i19 = size6 + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i19];
        motionPathsArr[0] = this.f32714g;
        motionPathsArr[size6 + 1] = this.f32715h;
        if (this.f32732y.size() > 0 && this.f32713f == -1) {
            this.f32713f = 0;
        }
        ArrayList arrayList7 = this.f32732y;
        int size7 = arrayList7.size();
        int i20 = i5;
        int i21 = 0;
        while (i21 < size7) {
            Object obj6 = arrayList7.get(i21);
            i21++;
            motionPathsArr[i20] = (MotionPaths) obj6;
            i20++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.f32715h.f32858p.keySet()) {
            if (this.f32714g.f32858p.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.f32728u = strArr2;
        this.f32729v = new int[strArr2.length];
        int i22 = 0;
        while (true) {
            strArr = this.f32728u;
            if (i22 >= strArr.length) {
                break;
            }
            String str8 = strArr[i22];
            this.f32729v[i22] = 0;
            int i23 = 0;
            while (true) {
                if (i23 >= i19) {
                    break;
                }
                if (motionPathsArr[i23].f32858p.containsKey(str8) && (constraintAttribute = (ConstraintAttribute) motionPathsArr[i23].f32858p.get(str8)) != null) {
                    int[] iArr = this.f32729v;
                    iArr[i22] = iArr[i22] + constraintAttribute.h();
                    break;
                }
                i23++;
            }
            i22++;
        }
        boolean z2 = motionPathsArr[0].f32854l != Key.f32582f ? i5 : 0;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i24 = i5; i24 < i19; i24++) {
            motionPathsArr[i24].d(motionPathsArr[i24 - 1], zArr, this.f32728u, z2);
        }
        int i25 = 0;
        for (int i26 = i5; i26 < length; i26++) {
            if (zArr[i26]) {
                i25++;
            }
        }
        this.f32725r = new int[i25];
        int i27 = 2;
        int iMax = Math.max(2, i25);
        this.f32726s = new double[iMax];
        this.f32727t = new double[iMax];
        int i28 = 0;
        for (int i29 = i5; i29 < length; i29++) {
            if (zArr[i29]) {
                this.f32725r[i28] = i29;
                i28++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[i5] = this.f32725r.length;
        iArr2[0] = i19;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr2 = new double[i19];
        for (int i30 = 0; i30 < i19; i30++) {
            motionPathsArr[i30].e(dArr[i30], this.f32725r);
            dArr2[i30] = motionPathsArr[i30].f32846c;
        }
        int i31 = 0;
        while (true) {
            int[] iArr3 = this.f32725r;
            if (i31 >= iArr3.length) {
                break;
            }
            if (iArr3[i31] < MotionPaths.f32843u.length) {
                String str9 = MotionPaths.f32843u[this.f32725r[i31]] + " [";
                for (int i32 = 0; i32 < i19; i32++) {
                    str9 = str9 + dArr[i32][i31];
                }
            }
            i31++;
        }
        this.f32718k = new CurveFit[this.f32728u.length + 1];
        int i33 = 0;
        while (true) {
            String[] strArr3 = this.f32728u;
            if (i33 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i33];
            int i34 = 0;
            int i35 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i34 < i19) {
                if (motionPathsArr[i34].k(str10)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i19];
                        int[] iArr4 = new int[i27];
                        iArr4[i5] = motionPathsArr[i34].i(str10);
                        i7 = 0;
                        iArr4[0] = i19;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr4);
                    } else {
                        i7 = 0;
                    }
                    MotionPaths motionPaths = motionPathsArr[i34];
                    i6 = i33;
                    dArr3[i35] = motionPaths.f32846c;
                    motionPaths.h(str10, dArr4[i35], i7);
                    i35++;
                } else {
                    i6 = i33;
                }
                i34++;
                i33 = i6;
                i27 = 2;
            }
            int i36 = i33 + 1;
            this.f32718k[i36] = CurveFit.a(this.f32713f, Arrays.copyOf(dArr3, i35), (double[][]) Arrays.copyOf(dArr4, i35));
            i33 = i36;
            i27 = 2;
        }
        int i37 = 0;
        this.f32718k[0] = CurveFit.a(this.f32713f, dArr2, dArr);
        if (motionPathsArr[0].f32854l != Key.f32582f) {
            int[] iArr5 = new int[i19];
            double[] dArr5 = new double[i19];
            int[] iArr6 = new int[2];
            iArr6[i5] = 2;
            iArr6[0] = i19;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i38 = 0; i38 < i19; i38++) {
                iArr5[i38] = motionPathsArr[i38].f32854l;
                dArr5[i38] = r8.f32846c;
                double[] dArr7 = dArr6[i38];
                dArr7[0] = r8.f32848f;
                dArr7[i5] = r8.f32849g;
            }
            i37 = 0;
            this.f32719l = CurveFit.b(iArr5, dArr5, dArr6);
        }
        this.D = new HashMap();
        if (this.A != null) {
            float fS = Float.NaN;
            for (String str11 : hashSet3) {
                ViewOscillator viewOscillatorK = ViewOscillator.k(str11);
                if (viewOscillatorK != null) {
                    if (viewOscillatorK.j() && Float.isNaN(fS)) {
                        fS = s();
                    }
                    viewOscillatorK.h(str11);
                    this.D.put(str11, viewOscillatorK);
                }
            }
            ArrayList arrayList8 = this.A;
            int size8 = arrayList8.size();
            int i39 = i37;
            while (i39 < size8) {
                Object obj7 = arrayList8.get(i39);
                i39++;
                Key key6 = (Key) obj7;
                if (key6 instanceof KeyCycle) {
                    ((KeyCycle) key6).Y(this.D);
                }
            }
            Iterator it = this.D.values().iterator();
            while (it.hasNext()) {
                ((ViewOscillator) it.next()).i(fS);
            }
        }
    }

    public void J(MotionController motionController) {
        this.f32714g.s(motionController, motionController.f32714g);
        this.f32715h.s(motionController, motionController.f32715h);
    }

    public void a(Key key) {
        this.A.add(key);
    }

    void b(ArrayList arrayList) {
        this.A.addAll(arrayList);
    }

    int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrH = this.f32718k[0].h();
        if (iArr != null) {
            ArrayList arrayList = this.f32732y;
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                iArr[i3] = ((MotionPaths) obj).f32859q;
                i3++;
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < dArrH.length; i6++) {
            this.f32718k[0].d(dArrH[i6], this.f32726s);
            this.f32714g.f(dArrH[i6], this.f32725r, this.f32726s, fArr, i5);
            i5 += 2;
        }
        return i5 / 2;
    }

    void d(float[] fArr, int i3) {
        int i4 = i3;
        float f3 = 1.0f;
        float f4 = 1.0f / (i4 - 1);
        HashMap map = this.C;
        SplineSet splineSet = map == null ? null : (SplineSet) map.get("translationX");
        HashMap map2 = this.C;
        SplineSet splineSet2 = map2 == null ? null : (SplineSet) map2.get("translationY");
        HashMap map3 = this.D;
        ViewOscillator viewOscillator = map3 == null ? null : (ViewOscillator) map3.get("translationX");
        HashMap map4 = this.D;
        ViewOscillator viewOscillator2 = map4 != null ? (ViewOscillator) map4.get("translationY") : null;
        int i5 = 0;
        while (i5 < i4) {
            float fMin = i5 * f4;
            float f5 = this.f32722o;
            float f6 = 0.0f;
            if (f5 != f3) {
                float f7 = this.f32721n;
                if (fMin < f7) {
                    fMin = 0.0f;
                }
                if (fMin > f7 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f7) * f5, f3);
                }
            }
            double dA = fMin;
            Easing easing = this.f32714g.f32844a;
            ArrayList arrayList = this.f32732y;
            int size = arrayList.size();
            float f8 = Float.NaN;
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                MotionPaths motionPaths = (MotionPaths) obj;
                float f9 = f4;
                Easing easing2 = motionPaths.f32844a;
                if (easing2 != null) {
                    float f10 = motionPaths.f32846c;
                    if (f10 < fMin) {
                        f6 = f10;
                        easing = easing2;
                    } else if (Float.isNaN(f8)) {
                        f8 = motionPaths.f32846c;
                    }
                }
                f4 = f9;
            }
            float f11 = f4;
            if (easing != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                dA = (((float) easing.a((fMin - f6) / r17)) * (f8 - f6)) + f6;
            }
            this.f32718k[0].d(dA, this.f32726s);
            CurveFit curveFit = this.f32719l;
            if (curveFit != null) {
                double[] dArr = this.f32726s;
                if (dArr.length > 0) {
                    curveFit.d(dA, dArr);
                }
            }
            int i7 = i5 * 2;
            this.f32714g.f(dA, this.f32725r, this.f32726s, fArr, i7);
            if (viewOscillator != null) {
                fArr[i7] = fArr[i7] + viewOscillator.a(fMin);
            } else if (splineSet != null) {
                fArr[i7] = fArr[i7] + splineSet.a(fMin);
            }
            if (viewOscillator2 != null) {
                int i8 = i7 + 1;
                fArr[i8] = fArr[i8] + viewOscillator2.a(fMin);
            } else if (splineSet2 != null) {
                int i9 = i7 + 1;
                fArr[i9] = fArr[i9] + splineSet2.a(fMin);
            }
            i5++;
            i4 = i3;
            f4 = f11;
            f3 = 1.0f;
        }
    }

    void e(float f3, float[] fArr, int i3) {
        this.f32718k[0].d(g(f3, null), this.f32726s);
        this.f32714g.j(this.f32725r, this.f32726s, fArr, i3);
    }

    void f(boolean z2) {
        if (!"button".equals(Debug.d(this.f32709b)) || this.E == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            KeyTrigger[] keyTriggerArr = this.E;
            if (i3 >= keyTriggerArr.length) {
                return;
            }
            keyTriggerArr[i3].y(z2 ? -100.0f : 100.0f, this.f32709b);
            i3++;
        }
    }

    public int h() {
        return this.f32714g.f32855m;
    }

    public void i(double d3, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f32718k[0].d(d3, dArr);
        this.f32718k[0].g(d3, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f32714g.g(d3, this.f32725r, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.f32723p;
    }

    public float k() {
        return this.f32724q;
    }

    void l(float f3, float f4, float f5, float[] fArr) {
        double[] dArr;
        float fG = g(f3, this.f32733z);
        CurveFit[] curveFitArr = this.f32718k;
        int i3 = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.f32715h;
            float f6 = motionPaths.f32848f;
            MotionPaths motionPaths2 = this.f32714g;
            float f7 = f6 - motionPaths2.f32848f;
            float f8 = motionPaths.f32849g - motionPaths2.f32849g;
            float f9 = (motionPaths.f32850h - motionPaths2.f32850h) + f7;
            float f10 = (motionPaths.f32851i - motionPaths2.f32851i) + f8;
            fArr[0] = (f7 * (1.0f - f4)) + (f9 * f4);
            fArr[1] = (f8 * (1.0f - f5)) + (f10 * f5);
            return;
        }
        double d3 = fG;
        curveFitArr[0].g(d3, this.f32727t);
        this.f32718k[0].d(d3, this.f32726s);
        float f11 = this.f32733z[0];
        while (true) {
            dArr = this.f32727t;
            if (i3 >= dArr.length) {
                break;
            }
            dArr[i3] = dArr[i3] * ((double) f11);
            i3++;
        }
        CurveFit curveFit = this.f32719l;
        if (curveFit == null) {
            this.f32714g.q(f4, f5, fArr, this.f32725r, dArr, this.f32726s);
            return;
        }
        double[] dArr2 = this.f32726s;
        if (dArr2.length > 0) {
            curveFit.d(d3, dArr2);
            this.f32719l.g(d3, this.f32727t);
            this.f32714g.q(f4, f5, fArr, this.f32725r, this.f32727t, this.f32726s);
        }
    }

    public int m() {
        int iMax = this.f32714g.f32845b;
        ArrayList arrayList = this.f32732y;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            iMax = Math.max(iMax, ((MotionPaths) obj).f32845b);
        }
        return Math.max(iMax, this.f32715h.f32845b);
    }

    public float n() {
        return this.f32715h.f32848f;
    }

    public float o() {
        return this.f32715h.f32849g;
    }

    MotionPaths q(int i3) {
        return (MotionPaths) this.f32732y.get(i3);
    }

    void r(float f3, int i3, int i4, float f4, float f5, float[] fArr) {
        float fG = g(f3, this.f32733z);
        HashMap map = this.C;
        SplineSet splineSet = map == null ? null : (SplineSet) map.get("translationX");
        HashMap map2 = this.C;
        SplineSet splineSet2 = map2 == null ? null : (SplineSet) map2.get("translationY");
        HashMap map3 = this.C;
        SplineSet splineSet3 = map3 == null ? null : (SplineSet) map3.get("rotation");
        HashMap map4 = this.C;
        SplineSet splineSet4 = map4 == null ? null : (SplineSet) map4.get("scaleX");
        HashMap map5 = this.C;
        SplineSet splineSet5 = map5 == null ? null : (SplineSet) map5.get("scaleY");
        HashMap map6 = this.D;
        ViewOscillator viewOscillator = map6 == null ? null : (ViewOscillator) map6.get("translationX");
        HashMap map7 = this.D;
        ViewOscillator viewOscillator2 = map7 == null ? null : (ViewOscillator) map7.get("translationY");
        HashMap map8 = this.D;
        ViewOscillator viewOscillator3 = map8 == null ? null : (ViewOscillator) map8.get("rotation");
        HashMap map9 = this.D;
        ViewOscillator viewOscillator4 = map9 == null ? null : (ViewOscillator) map9.get("scaleX");
        HashMap map10 = this.D;
        ViewOscillator viewOscillator5 = map10 != null ? (ViewOscillator) map10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.b();
        velocityMatrix.d(splineSet3, fG);
        velocityMatrix.h(splineSet, splineSet2, fG);
        velocityMatrix.f(splineSet4, splineSet5, fG);
        velocityMatrix.c(viewOscillator3, fG);
        velocityMatrix.g(viewOscillator, viewOscillator2, fG);
        velocityMatrix.e(viewOscillator4, viewOscillator5, fG);
        CurveFit curveFit = this.f32719l;
        if (curveFit != null) {
            double[] dArr = this.f32726s;
            if (dArr.length > 0) {
                double d3 = fG;
                curveFit.d(d3, dArr);
                this.f32719l.g(d3, this.f32727t);
                this.f32714g.q(f4, f5, fArr, this.f32725r, this.f32727t, this.f32726s);
            }
            velocityMatrix.a(f4, f5, i3, i4, fArr);
            return;
        }
        int i5 = 0;
        if (this.f32718k == null) {
            MotionPaths motionPaths = this.f32715h;
            float f6 = motionPaths.f32848f;
            MotionPaths motionPaths2 = this.f32714g;
            float f7 = f6 - motionPaths2.f32848f;
            float f8 = motionPaths.f32849g - motionPaths2.f32849g;
            float f9 = (motionPaths.f32850h - motionPaths2.f32850h) + f7;
            float f10 = f8 + (motionPaths.f32851i - motionPaths2.f32851i);
            fArr[0] = (f7 * (1.0f - f4)) + (f9 * f4);
            fArr[1] = (f8 * (1.0f - f5)) + (f10 * f5);
            velocityMatrix.b();
            velocityMatrix.d(splineSet3, fG);
            velocityMatrix.h(splineSet, splineSet2, fG);
            velocityMatrix.f(splineSet4, splineSet5, fG);
            velocityMatrix.c(viewOscillator3, fG);
            velocityMatrix.g(viewOscillator, viewOscillator2, fG);
            velocityMatrix.e(viewOscillator4, viewOscillator5, fG);
            velocityMatrix.a(f4, f5, i3, i4, fArr);
            return;
        }
        double dG = g(fG, this.f32733z);
        this.f32718k[0].g(dG, this.f32727t);
        this.f32718k[0].d(dG, this.f32726s);
        float f11 = this.f32733z[0];
        while (true) {
            double[] dArr2 = this.f32727t;
            if (i5 >= dArr2.length) {
                this.f32714g.q(f4, f5, fArr, this.f32725r, dArr2, this.f32726s);
                velocityMatrix.a(f4, f5, i3, i4, fArr);
                return;
            } else {
                dArr2[i5] = dArr2[i5] * ((double) f11);
                i5++;
            }
        }
    }

    public float t() {
        return this.f32714g.f32848f;
    }

    public String toString() {
        return " start: x: " + this.f32714g.f32848f + " y: " + this.f32714g.f32849g + " end: x: " + this.f32715h.f32848f + " y: " + this.f32715h.f32849g;
    }

    public float u() {
        return this.f32714g.f32849g;
    }

    public View v() {
        return this.f32709b;
    }

    boolean x(View view, float f3, long j3, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean zJ;
        View view2;
        View view3;
        float f4;
        float f5;
        double d3;
        View view4 = view;
        float fG = g(f3, null);
        int i3 = this.I;
        if (i3 != Key.f32582f) {
            float f6 = 1.0f / i3;
            float fFloor = ((float) Math.floor(fG / f6)) * f6;
            float f7 = (fG % f6) / f6;
            if (!Float.isNaN(this.J)) {
                f7 = (f7 + this.J) % 1.0f;
            }
            Interpolator interpolator = this.K;
            fG = ((interpolator != null ? interpolator.getInterpolation(f7) : ((double) f7) > 0.5d ? 1.0f : 0.0f) * f6) + fFloor;
        }
        HashMap map = this.C;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((ViewSpline) it.next()).k(view4, fG);
            }
        }
        HashMap map2 = this.B;
        if (map2 != null) {
            ViewTimeCycle.PathRotate pathRotate2 = null;
            boolean zI = false;
            for (ViewTimeCycle viewTimeCycle : map2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate2 = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    zI |= viewTimeCycle.i(view4, fG, j3, keyCache);
                    view4 = view;
                }
            }
            zJ = zI;
            pathRotate = pathRotate2;
        } else {
            pathRotate = null;
            zJ = false;
        }
        CurveFit[] curveFitArr = this.f32718k;
        if (curveFitArr != null) {
            double d4 = fG;
            curveFitArr[0].d(d4, this.f32726s);
            this.f32718k[0].g(d4, this.f32727t);
            CurveFit curveFit = this.f32719l;
            if (curveFit != null) {
                double[] dArr = this.f32726s;
                if (dArr.length > 0) {
                    curveFit.d(d4, dArr);
                    this.f32719l.g(d4, this.f32727t);
                }
            }
            if (this.L) {
                view3 = view;
                f4 = 1.0f;
                f5 = 0.0f;
                d3 = d4;
            } else {
                float f8 = fG;
                f4 = 1.0f;
                d3 = d4;
                f5 = 0.0f;
                this.f32714g.r(f8, view, this.f32725r, this.f32726s, this.f32727t, null, this.f32711d);
                fG = f8;
                view3 = view;
                this.f32711d = false;
            }
            if (this.G != Key.f32582f) {
                if (this.H == null) {
                    this.H = ((View) view3.getParent()).findViewById(this.G);
                }
                if (this.H != null) {
                    float top = (r1.getTop() + this.H.getBottom()) / 2.0f;
                    float left = (this.H.getLeft() + this.H.getRight()) / 2.0f;
                    if (view3.getRight() - view3.getLeft() > 0 && view3.getBottom() - view3.getTop() > 0) {
                        view3.setPivotX(left - view3.getLeft());
                        view3.setPivotY(top - view3.getTop());
                    }
                }
            }
            HashMap map3 = this.C;
            if (map3 != null) {
                for (SplineSet splineSet : map3.values()) {
                    if (splineSet instanceof ViewSpline.PathRotate) {
                        double[] dArr2 = this.f32727t;
                        if (dArr2.length > 1) {
                            ((ViewSpline.PathRotate) splineSet).l(view3, fG, dArr2[0], dArr2[1]);
                        }
                    }
                    view3 = view;
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.f32727t;
                view2 = view;
                float f9 = fG;
                fG = f9;
                zJ |= pathRotate.j(view2, keyCache, f9, j3, dArr3[0], dArr3[1]);
            } else {
                view2 = view;
            }
            int i4 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.f32718k;
                if (i4 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i4].e(d3, this.f32731x);
                CustomSupport.b((ConstraintAttribute) this.f32714g.f32858p.get(this.f32728u[i4 - 1]), view2, this.f32731x);
                i4++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.f32716i;
            if (motionConstrainedPoint.f32684b == 0) {
                if (fG <= f5) {
                    view2.setVisibility(motionConstrainedPoint.f32685c);
                } else if (fG >= f4) {
                    view2.setVisibility(this.f32717j.f32685c);
                } else if (this.f32717j.f32685c != motionConstrainedPoint.f32685c) {
                    view2.setVisibility(0);
                }
            }
            if (this.E != null) {
                int i5 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.E;
                    if (i5 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i5].y(fG, view2);
                    i5++;
                }
            }
        } else {
            view2 = view;
            MotionPaths motionPaths = this.f32714g;
            float f10 = motionPaths.f32848f;
            MotionPaths motionPaths2 = this.f32715h;
            float f11 = f10 + ((motionPaths2.f32848f - f10) * fG);
            float f12 = motionPaths.f32849g;
            float f13 = f12 + ((motionPaths2.f32849g - f12) * fG);
            float f14 = motionPaths.f32850h;
            float f15 = motionPaths2.f32850h;
            float f16 = motionPaths.f32851i;
            float f17 = motionPaths2.f32851i;
            float f18 = f11 + 0.5f;
            int i6 = (int) f18;
            float f19 = f13 + 0.5f;
            int i7 = (int) f19;
            int i8 = (int) (f18 + ((f15 - f14) * fG) + f14);
            int i9 = (int) (f19 + ((f17 - f16) * fG) + f16);
            int i10 = i8 - i6;
            int i11 = i9 - i7;
            if (f15 != f14 || f17 != f16 || this.f32711d) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(i11, 1073741824));
                this.f32711d = false;
            }
            view2.layout(i6, i7, i8, i9);
        }
        HashMap map4 = this.D;
        if (map4 != null) {
            for (ViewOscillator viewOscillator : map4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr4 = this.f32727t;
                    ((ViewOscillator.PathRotateSet) viewOscillator).m(view2, fG, dArr4[0], dArr4[1]);
                } else {
                    viewOscillator.l(view2, fG);
                }
            }
        }
        return zJ;
    }

    public void z() {
        this.f32711d = true;
    }
}
