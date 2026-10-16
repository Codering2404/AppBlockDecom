package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static String[] E = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f32685c;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Easing f32698q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f32700s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f32701t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f32702u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f32703v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f32704w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f32683a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f32684b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32686d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f32687f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f32688g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f32689h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f32690i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f32691j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f32692k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f32693l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f32694m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f32695n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f32696o = 0.0f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f32697p = 0.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f32699r = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f32705x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f32706y = Float.NaN;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f32707z = -1;
    LinkedHashMap A = new LinkedHashMap();
    int B = 0;
    double[] C = new double[18];
    double[] D = new double[18];

    private boolean e(float f3, float f4) {
        return (Float.isNaN(f3) || Float.isNaN(f4)) ? Float.isNaN(f3) != Float.isNaN(f4) : Math.abs(f3 - f4) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(HashMap map, int i3) {
        for (String str : map.keySet()) {
            ViewSpline viewSpline = (ViewSpline) map.get(str);
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
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        b3 = 8;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        b3 = 9;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        b3 = 10;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        b3 = Ascii.VT;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        b3 = Ascii.FF;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b3 = Ascii.CR;
                    }
                    break;
            }
            switch (b3) {
                case 0:
                    viewSpline.e(i3, Float.isNaN(this.f32689h) ? 0.0f : this.f32689h);
                    break;
                case 1:
                    viewSpline.e(i3, Float.isNaN(this.f32690i) ? 0.0f : this.f32690i);
                    break;
                case 2:
                    viewSpline.e(i3, Float.isNaN(this.f32695n) ? 0.0f : this.f32695n);
                    break;
                case 3:
                    viewSpline.e(i3, Float.isNaN(this.f32696o) ? 0.0f : this.f32696o);
                    break;
                case 4:
                    viewSpline.e(i3, Float.isNaN(this.f32697p) ? 0.0f : this.f32697p);
                    break;
                case 5:
                    viewSpline.e(i3, Float.isNaN(this.f32706y) ? 0.0f : this.f32706y);
                    break;
                case 6:
                    viewSpline.e(i3, Float.isNaN(this.f32691j) ? 1.0f : this.f32691j);
                    break;
                case 7:
                    viewSpline.e(i3, Float.isNaN(this.f32692k) ? 1.0f : this.f32692k);
                    break;
                case 8:
                    viewSpline.e(i3, Float.isNaN(this.f32693l) ? 0.0f : this.f32693l);
                    break;
                case 9:
                    viewSpline.e(i3, Float.isNaN(this.f32694m) ? 0.0f : this.f32694m);
                    break;
                case 10:
                    viewSpline.e(i3, Float.isNaN(this.f32688g) ? 0.0f : this.f32688g);
                    break;
                case 11:
                    viewSpline.e(i3, Float.isNaN(this.f32687f) ? 0.0f : this.f32687f);
                    break;
                case 12:
                    viewSpline.e(i3, Float.isNaN(this.f32705x) ? 0.0f : this.f32705x);
                    break;
                case 13:
                    viewSpline.e(i3, Float.isNaN(this.f32683a) ? 1.0f : this.f32683a);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.A.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.A.get(str2);
                            if (viewSpline instanceof ViewSpline.CustomSet) {
                                ((ViewSpline.CustomSet) viewSpline).l(i3, constraintAttribute);
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i3 + ", value" + constraintAttribute.e() + viewSpline);
                            }
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                    }
                    break;
            }
        }
    }

    public void b(View view) {
        this.f32685c = view.getVisibility();
        this.f32683a = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f32686d = false;
        this.f32687f = view.getElevation();
        this.f32688g = view.getRotation();
        this.f32689h = view.getRotationX();
        this.f32690i = view.getRotationY();
        this.f32691j = view.getScaleX();
        this.f32692k = view.getScaleY();
        this.f32693l = view.getPivotX();
        this.f32694m = view.getPivotY();
        this.f32695n = view.getTranslationX();
        this.f32696o = view.getTranslationY();
        this.f32697p = view.getTranslationZ();
    }

    public void c(ConstraintSet.Constraint constraint) {
        ConstraintSet.PropertySet propertySet = constraint.f33193c;
        int i3 = propertySet.f33272c;
        this.f32684b = i3;
        int i4 = propertySet.f33271b;
        this.f32685c = i4;
        this.f32683a = (i4 == 0 || i3 != 0) ? propertySet.f33273d : 0.0f;
        ConstraintSet.Transform transform = constraint.f33196f;
        this.f32686d = transform.f33288m;
        this.f32687f = transform.f33289n;
        this.f32688g = transform.f33277b;
        this.f32689h = transform.f33278c;
        this.f32690i = transform.f33279d;
        this.f32691j = transform.f33280e;
        this.f32692k = transform.f33281f;
        this.f32693l = transform.f33282g;
        this.f32694m = transform.f33283h;
        this.f32695n = transform.f33285j;
        this.f32696o = transform.f33286k;
        this.f32697p = transform.f33287l;
        this.f32698q = Easing.c(constraint.f33194d.f33259d);
        ConstraintSet.Motion motion = constraint.f33194d;
        this.f32705x = motion.f33264i;
        this.f32699r = motion.f33261f;
        this.f32707z = motion.f33257b;
        this.f32706y = constraint.f33193c.f33274e;
        for (String str : constraint.f33197g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) constraint.f33197g.get(str);
            if (constraintAttribute.g()) {
                this.A.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.f32700s, motionConstrainedPoint.f32700s);
    }

    void f(MotionConstrainedPoint motionConstrainedPoint, HashSet hashSet) {
        if (e(this.f32683a, motionConstrainedPoint.f32683a)) {
            hashSet.add("alpha");
        }
        if (e(this.f32687f, motionConstrainedPoint.f32687f)) {
            hashSet.add("elevation");
        }
        int i3 = this.f32685c;
        int i4 = motionConstrainedPoint.f32685c;
        if (i3 != i4 && this.f32684b == 0 && (i3 == 0 || i4 == 0)) {
            hashSet.add("alpha");
        }
        if (e(this.f32688g, motionConstrainedPoint.f32688g)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f32705x) || !Float.isNaN(motionConstrainedPoint.f32705x)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f32706y) || !Float.isNaN(motionConstrainedPoint.f32706y)) {
            hashSet.add("progress");
        }
        if (e(this.f32689h, motionConstrainedPoint.f32689h)) {
            hashSet.add("rotationX");
        }
        if (e(this.f32690i, motionConstrainedPoint.f32690i)) {
            hashSet.add("rotationY");
        }
        if (e(this.f32693l, motionConstrainedPoint.f32693l)) {
            hashSet.add("transformPivotX");
        }
        if (e(this.f32694m, motionConstrainedPoint.f32694m)) {
            hashSet.add("transformPivotY");
        }
        if (e(this.f32691j, motionConstrainedPoint.f32691j)) {
            hashSet.add("scaleX");
        }
        if (e(this.f32692k, motionConstrainedPoint.f32692k)) {
            hashSet.add("scaleY");
        }
        if (e(this.f32695n, motionConstrainedPoint.f32695n)) {
            hashSet.add("translationX");
        }
        if (e(this.f32696o, motionConstrainedPoint.f32696o)) {
            hashSet.add("translationY");
        }
        if (e(this.f32697p, motionConstrainedPoint.f32697p)) {
            hashSet.add("translationZ");
        }
    }

    void g(float f3, float f4, float f5, float f6) {
        this.f32701t = f3;
        this.f32702u = f4;
        this.f32703v = f5;
        this.f32704w = f6;
    }

    public void h(Rect rect, View view, int i3, float f3) {
        g(rect.left, rect.top, rect.width(), rect.height());
        b(view);
        this.f32693l = Float.NaN;
        this.f32694m = Float.NaN;
        if (i3 == 1) {
            this.f32688g = f3 - 90.0f;
        } else {
            if (i3 != 2) {
                return;
            }
            this.f32688g = f3 + 90.0f;
        }
    }

    public void i(Rect rect, ConstraintSet constraintSet, int i3, int i4) {
        g(rect.left, rect.top, rect.width(), rect.height());
        c(constraintSet.B(i4));
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                }
            }
            float f3 = this.f32688g + 90.0f;
            this.f32688g = f3;
            if (f3 > 180.0f) {
                this.f32688g = f3 - 360.0f;
                return;
            }
            return;
        }
        this.f32688g -= 90.0f;
    }

    public void j(View view) {
        g(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        b(view);
    }
}
