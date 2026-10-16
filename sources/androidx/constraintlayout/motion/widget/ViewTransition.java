package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ViewTransition {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static String f32932w = "ViewTransition";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32933a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f32937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    KeyFrames f32938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ConstraintSet.Constraint f32939g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f32942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f32943k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Context f32947o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32934b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f32935c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32936d = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32940h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f32941i = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f32944l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f32945m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f32946n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f32948p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f32949q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f32950r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f32951s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f32952t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f32953u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f32954v = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Animate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f32956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f32957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f32958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        MotionController f32959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f32960e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f32961f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ViewTransitionController f32963h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Interpolator f32964i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f32966k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f32967l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f32968m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f32970o;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        KeyCache f32962g = new KeyCache();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f32965j = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Rect f32969n = new Rect();

        Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i3, int i4, int i5, Interpolator interpolator, int i6, int i7) {
            this.f32970o = false;
            this.f32963h = viewTransitionController;
            this.f32959d = motionController;
            this.f32960e = i3;
            this.f32961f = i4;
            long jNanoTime = System.nanoTime();
            this.f32958c = jNanoTime;
            this.f32968m = jNanoTime;
            this.f32963h.b(this);
            this.f32964i = interpolator;
            this.f32956a = i6;
            this.f32957b = i7;
            if (i5 == 3) {
                this.f32970o = true;
            }
            this.f32967l = i3 == 0 ? Float.MAX_VALUE : 1.0f / i3;
            a();
        }

        void a() {
            if (this.f32965j) {
                c();
            } else {
                b();
            }
        }

        void b() {
            long jNanoTime = System.nanoTime();
            long j3 = jNanoTime - this.f32968m;
            this.f32968m = jNanoTime;
            float f3 = this.f32966k + (((float) (j3 * 1.0E-6d)) * this.f32967l);
            this.f32966k = f3;
            if (f3 >= 1.0f) {
                this.f32966k = 1.0f;
            }
            Interpolator interpolator = this.f32964i;
            float interpolation = interpolator == null ? this.f32966k : interpolator.getInterpolation(this.f32966k);
            MotionController motionController = this.f32959d;
            boolean zX = motionController.x(motionController.f32709b, interpolation, jNanoTime, this.f32962g);
            if (this.f32966k >= 1.0f) {
                if (this.f32956a != -1) {
                    this.f32959d.v().setTag(this.f32956a, Long.valueOf(System.nanoTime()));
                }
                if (this.f32957b != -1) {
                    this.f32959d.v().setTag(this.f32957b, null);
                }
                if (!this.f32970o) {
                    this.f32963h.g(this);
                }
            }
            if (this.f32966k < 1.0f || zX) {
                this.f32963h.e();
            }
        }

        void c() {
            long jNanoTime = System.nanoTime();
            long j3 = jNanoTime - this.f32968m;
            this.f32968m = jNanoTime;
            float f3 = this.f32966k - (((float) (j3 * 1.0E-6d)) * this.f32967l);
            this.f32966k = f3;
            if (f3 < 0.0f) {
                this.f32966k = 0.0f;
            }
            Interpolator interpolator = this.f32964i;
            float interpolation = interpolator == null ? this.f32966k : interpolator.getInterpolation(this.f32966k);
            MotionController motionController = this.f32959d;
            boolean zX = motionController.x(motionController.f32709b, interpolation, jNanoTime, this.f32962g);
            if (this.f32966k <= 0.0f) {
                if (this.f32956a != -1) {
                    this.f32959d.v().setTag(this.f32956a, Long.valueOf(System.nanoTime()));
                }
                if (this.f32957b != -1) {
                    this.f32959d.v().setTag(this.f32957b, null);
                }
                this.f32963h.g(this);
            }
            if (this.f32966k > 0.0f || zX) {
                this.f32963h.e();
            }
        }

        public void d(int i3, float f3, float f4) {
            if (i3 == 1) {
                if (this.f32965j) {
                    return;
                }
                e(true);
            } else {
                if (i3 != 2) {
                    return;
                }
                this.f32959d.v().getHitRect(this.f32969n);
                if (this.f32969n.contains((int) f3, (int) f4) || this.f32965j) {
                    return;
                }
                e(true);
            }
        }

        void e(boolean z2) {
            int i3;
            this.f32965j = z2;
            if (z2 && (i3 = this.f32961f) != -1) {
                this.f32967l = i3 == 0 ? Float.MAX_VALUE : 1.0f / i3;
            }
            this.f32963h.e();
            this.f32968m = System.nanoTime();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097 A[Catch: IOException -> 0x0043, XmlPullParserException -> 0x0046, TryCatch #2 {IOException -> 0x0043, XmlPullParserException -> 0x0046, blocks: (B:3:0x0026, B:11:0x0037, B:37:0x00ce, B:18:0x0049, B:19:0x0051, B:36:0x0097, B:21:0x0055, B:26:0x0066, B:24:0x005e, B:27:0x006e, B:29:0x0074, B:30:0x0078, B:32:0x0080, B:33:0x0088, B:35:0x0090), top: B:42:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    ViewTransition(android.content.Context r5, org.xmlpull.v1.XmlPullParser r6) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public static /* synthetic */ void a(ViewTransition viewTransition, View[] viewArr) {
        if (viewTransition.f32948p != -1) {
            for (View view : viewArr) {
                view.setTag(viewTransition.f32948p, Long.valueOf(System.nanoTime()));
            }
        }
        if (viewTransition.f32949q != -1) {
            for (View view2 : viewArr) {
                view2.setTag(viewTransition.f32949q, null);
            }
        }
    }

    private void k(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ta);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == R.styleable.ua) {
                this.f32933a = typedArrayObtainStyledAttributes.getResourceId(index, this.f32933a);
            } else if (index == R.styleable.Ca) {
                if (MotionLayout.D0) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f32942j);
                    this.f32942j = resourceId;
                    if (resourceId == -1) {
                        this.f32943k = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.f32943k = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.f32942j = typedArrayObtainStyledAttributes.getResourceId(index, this.f32942j);
                }
            } else if (index == R.styleable.Da) {
                this.f32934b = typedArrayObtainStyledAttributes.getInt(index, this.f32934b);
            } else if (index == R.styleable.Ga) {
                this.f32935c = typedArrayObtainStyledAttributes.getBoolean(index, this.f32935c);
            } else if (index == R.styleable.Ea) {
                this.f32936d = typedArrayObtainStyledAttributes.getInt(index, this.f32936d);
            } else if (index == R.styleable.ya) {
                this.f32940h = typedArrayObtainStyledAttributes.getInt(index, this.f32940h);
            } else if (index == R.styleable.Ha) {
                this.f32941i = typedArrayObtainStyledAttributes.getInt(index, this.f32941i);
            } else if (index == R.styleable.Ia) {
                this.f32937e = typedArrayObtainStyledAttributes.getInt(index, this.f32937e);
            } else if (index == R.styleable.Ba) {
                int i4 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i4 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.f32946n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f32944l = -2;
                    }
                } else if (i4 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f32945m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f32944l = -1;
                    } else {
                        this.f32946n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.f32944l = -2;
                    }
                } else {
                    this.f32944l = typedArrayObtainStyledAttributes.getInteger(index, this.f32944l);
                }
            } else if (index == R.styleable.Fa) {
                this.f32948p = typedArrayObtainStyledAttributes.getResourceId(index, this.f32948p);
            } else if (index == R.styleable.xa) {
                this.f32949q = typedArrayObtainStyledAttributes.getResourceId(index, this.f32949q);
            } else if (index == R.styleable.Aa) {
                this.f32950r = typedArrayObtainStyledAttributes.getResourceId(index, this.f32950r);
            } else if (index == R.styleable.za) {
                this.f32951s = typedArrayObtainStyledAttributes.getResourceId(index, this.f32951s);
            } else if (index == R.styleable.wa) {
                this.f32953u = typedArrayObtainStyledAttributes.getResourceId(index, this.f32953u);
            } else if (index == R.styleable.va) {
                this.f32952t = typedArrayObtainStyledAttributes.getInteger(index, this.f32952t);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void m(MotionScene.Transition transition, View view) {
        int i3 = this.f32940h;
        if (i3 != -1) {
            transition.E(i3);
        }
        transition.I(this.f32936d);
        transition.G(this.f32944l, this.f32945m, this.f32946n);
        int id = view.getId();
        KeyFrames keyFrames = this.f32938f;
        if (keyFrames != null) {
            ArrayList arrayListD = keyFrames.d(-1);
            KeyFrames keyFrames2 = new KeyFrames();
            int size = arrayListD.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayListD.get(i4);
                i4++;
                keyFrames2.c(((Key) obj).clone().i(id));
            }
            transition.t(keyFrames2);
        }
    }

    void b(ViewTransitionController viewTransitionController, MotionLayout motionLayout, View view) {
        MotionController motionController = new MotionController(view);
        motionController.B(view);
        this.f32938f.a(motionController);
        motionController.I(motionLayout.getWidth(), motionLayout.getHeight(), this.f32940h, System.nanoTime());
        new Animate(viewTransitionController, motionController, this.f32940h, this.f32941i, this.f32934b, f(motionLayout.getContext()), this.f32948p, this.f32949q);
    }

    void c(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i3, ConstraintSet constraintSet, final View... viewArr) {
        if (this.f32935c) {
            return;
        }
        int i4 = this.f32937e;
        if (i4 == 2) {
            b(viewTransitionController, motionLayout, viewArr[0]);
            return;
        }
        if (i4 == 1) {
            for (int i5 : motionLayout.getConstraintSetIds()) {
                if (i5 != i3) {
                    ConstraintSet constraintSetW = motionLayout.W(i5);
                    for (View view : viewArr) {
                        ConstraintSet.Constraint constraintZ = constraintSetW.z(view.getId());
                        ConstraintSet.Constraint constraint = this.f32939g;
                        if (constraint != null) {
                            constraint.d(constraintZ);
                            constraintZ.f33197g.putAll(this.f32939g.f33197g);
                        }
                    }
                }
            }
        }
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.p(constraintSet);
        for (View view2 : viewArr) {
            ConstraintSet.Constraint constraintZ2 = constraintSet2.z(view2.getId());
            ConstraintSet.Constraint constraint2 = this.f32939g;
            if (constraint2 != null) {
                constraint2.d(constraintZ2);
                constraintZ2.f33197g.putAll(this.f32939g.f33197g);
            }
        }
        motionLayout.t0(i3, constraintSet2);
        int i6 = R.id.f33299b;
        motionLayout.t0(i6, constraintSet);
        motionLayout.setState(i6, -1, -1);
        MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.f32739a, i6, i3);
        for (View view3 : viewArr) {
            m(transition, view3);
        }
        motionLayout.setTransition(transition);
        motionLayout.m0(new Runnable() { // from class: androidx.constraintlayout.motion.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                ViewTransition.a(this.f32982a, viewArr);
            }
        });
    }

    boolean d(View view) {
        int i3 = this.f32950r;
        boolean z2 = i3 == -1 || view.getTag(i3) != null;
        int i4 = this.f32951s;
        return z2 && (i4 == -1 || view.getTag(i4) == null);
    }

    int e() {
        return this.f32933a;
    }

    Interpolator f(Context context) {
        int i3 = this.f32944l;
        if (i3 == -2) {
            return AnimationUtils.loadInterpolator(context, this.f32946n);
        }
        if (i3 == -1) {
            final Easing easingC = Easing.c(this.f32945m);
            return new Interpolator(this) { // from class: androidx.constraintlayout.motion.widget.ViewTransition.1
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
        if (i3 == 5) {
            return new OvershootInterpolator();
        }
        if (i3 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int g() {
        return this.f32952t;
    }

    public int h() {
        return this.f32953u;
    }

    public int i() {
        return this.f32934b;
    }

    boolean j(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f32942j == -1 && this.f32943k == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.f32942j) {
            return true;
        }
        return this.f32943k != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).f33111c0) != null && str.matches(this.f32943k);
    }

    boolean l(int i3) {
        int i4 = this.f32934b;
        return i4 == 1 ? i3 == 0 : i4 == 2 ? i3 == 1 : i4 == 3 && i3 == 0;
    }

    public String toString() {
        return "ViewTransition(" + Debug.c(this.f32947o, this.f32933a) + ")";
    }
}
