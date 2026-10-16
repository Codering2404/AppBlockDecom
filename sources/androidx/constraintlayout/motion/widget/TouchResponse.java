package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class TouchResponse {
    private static final float[][] G = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] H = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f32923r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f32924s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MotionLayout f32925t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32906a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32907b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f32908c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32909d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32910e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32911f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f32912g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f32913h = 0.5f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f32914i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f32915j = 0.5f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f32916k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f32917l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f32918m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f32919n = 1.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f32920o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float[] f32921p = new float[2];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int[] f32922q = new int[2];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f32926u = 4.0f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f32927v = 1.2f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f32928w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f32929x = 1.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f32930y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f32931z = 10.0f;
    private float A = 10.0f;
    private float B = 1.0f;
    private float C = Float.NaN;
    private float D = Float.NaN;
    private int E = 0;
    private int F = 0;

    TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f32925t = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            if (index == R.styleable.n9) {
                this.f32909d = typedArray.getResourceId(index, this.f32909d);
            } else if (index == R.styleable.o9) {
                int i4 = typedArray.getInt(index, this.f32906a);
                this.f32906a = i4;
                float[] fArr = G[i4];
                this.f32913h = fArr[0];
                this.f32912g = fArr[1];
            } else if (index == R.styleable.Y8) {
                int i5 = typedArray.getInt(index, this.f32907b);
                this.f32907b = i5;
                float[][] fArr2 = H;
                if (i5 < fArr2.length) {
                    float[] fArr3 = fArr2[i5];
                    this.f32918m = fArr3[0];
                    this.f32919n = fArr3[1];
                } else {
                    this.f32919n = Float.NaN;
                    this.f32918m = Float.NaN;
                    this.f32917l = true;
                }
            } else if (index == R.styleable.d9) {
                this.f32926u = typedArray.getFloat(index, this.f32926u);
            } else if (index == R.styleable.c9) {
                this.f32927v = typedArray.getFloat(index, this.f32927v);
            } else if (index == R.styleable.e9) {
                this.f32928w = typedArray.getBoolean(index, this.f32928w);
            } else if (index == R.styleable.Z8) {
                this.f32929x = typedArray.getFloat(index, this.f32929x);
            } else if (index == R.styleable.a9) {
                this.f32931z = typedArray.getFloat(index, this.f32931z);
            } else if (index == R.styleable.p9) {
                this.f32910e = typedArray.getResourceId(index, this.f32910e);
            } else if (index == R.styleable.g9) {
                this.f32908c = typedArray.getInt(index, this.f32908c);
            } else if (index == R.styleable.f9) {
                this.f32930y = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.b9) {
                this.f32911f = typedArray.getResourceId(index, 0);
            } else if (index == R.styleable.h9) {
                this.f32916k = typedArray.getResourceId(index, this.f32916k);
            } else if (index == R.styleable.j9) {
                this.A = typedArray.getFloat(index, this.A);
            } else if (index == R.styleable.k9) {
                this.B = typedArray.getFloat(index, this.B);
            } else if (index == R.styleable.l9) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == R.styleable.m9) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == R.styleable.i9) {
                this.E = typedArray.getInt(index, this.E);
            } else if (index == R.styleable.X8) {
                this.F = typedArray.getInt(index, this.F);
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.W8);
        b(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    void A() {
        View viewFindViewById;
        int i3 = this.f32909d;
        if (i3 != -1) {
            viewFindViewById = this.f32925t.findViewById(i3);
            if (viewFindViewById == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + Debug.c(this.f32925t.getContext(), this.f32909d));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener(this) { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this) { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void a(NestedScrollView nestedScrollView2, int i4, int i5, int i6, int i7) {
                }
            });
        }
    }

    float a(float f3, float f4) {
        return (f3 * this.f32918m) + (f4 * this.f32919n);
    }

    public int d() {
        return this.F;
    }

    public int e() {
        return this.f32930y;
    }

    RectF f(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i3 = this.f32911f;
        if (i3 == -1 || (viewFindViewById = viewGroup.findViewById(i3)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    float g() {
        return this.f32927v;
    }

    public float h() {
        return this.f32926u;
    }

    boolean i() {
        return this.f32928w;
    }

    float j(float f3, float f4) {
        this.f32925t.V(this.f32909d, this.f32925t.getProgress(), this.f32913h, this.f32912g, this.f32921p);
        float f5 = this.f32918m;
        if (f5 != 0.0f) {
            float[] fArr = this.f32921p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f3 * f5) / fArr[0];
        }
        float[] fArr2 = this.f32921p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f4 * this.f32919n) / fArr2[1];
    }

    public int k() {
        return this.E;
    }

    public float l() {
        return this.A;
    }

    public float m() {
        return this.B;
    }

    public float n() {
        return this.C;
    }

    public float o() {
        return this.D;
    }

    RectF p(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i3 = this.f32910e;
        if (i3 == -1 || (viewFindViewById = viewGroup.findViewById(i3)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    int q() {
        return this.f32910e;
    }

    boolean r() {
        return this.f32920o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void s(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i3, MotionScene motionScene) {
        char c3;
        int i4;
        char c4;
        float f3;
        char c5;
        if (this.f32917l) {
            t(motionEvent, motionTracker, i3, motionScene);
            return;
        }
        motionTracker.b(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f32923r = motionEvent.getRawX();
            this.f32924s = motionEvent.getRawY();
            this.f32920o = false;
            return;
        }
        if (action == 1) {
            this.f32920o = false;
            motionTracker.e(1000);
            float fD = motionTracker.d();
            float fC = motionTracker.c();
            float progress = this.f32925t.getProgress();
            int i5 = this.f32909d;
            if (i5 != -1) {
                this.f32925t.V(i5, progress, this.f32913h, this.f32912g, this.f32921p);
                c3 = 0;
            } else {
                float fMin = Math.min(this.f32925t.getWidth(), this.f32925t.getHeight());
                float[] fArr = this.f32921p;
                fArr[1] = this.f32919n * fMin;
                c3 = 0;
                fArr[0] = fMin * this.f32918m;
            }
            float f4 = this.f32918m;
            float[] fArr2 = this.f32921p;
            float fAbs = f4 != 0.0f ? fD / fArr2[c3] : fC / fArr2[1];
            float f5 = !Float.isNaN(fAbs) ? (fAbs / 3.0f) + progress : progress;
            if (f5 == 0.0f || f5 == 1.0f || (i4 = this.f32908c) == 3) {
                if (0.0f >= f5 || 1.0f <= f5) {
                    this.f32925t.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            float f6 = ((double) f5) < 0.5d ? 0.0f : 1.0f;
            if (i4 == 6) {
                if (progress + fAbs < 0.0f) {
                    fAbs = Math.abs(fAbs);
                }
                f6 = 1.0f;
            }
            if (this.f32908c == 7) {
                if (progress + fAbs > 1.0f) {
                    fAbs = -Math.abs(fAbs);
                }
                f6 = 0.0f;
            }
            this.f32925t.k0(this.f32908c, f6, fAbs);
            if (0.0f >= progress || 1.0f <= progress) {
                this.f32925t.setState(MotionLayout.TransitionState.FINISHED);
                return;
            }
            return;
        }
        if (action != 2) {
            return;
        }
        float rawY = motionEvent.getRawY() - this.f32924s;
        float rawX = motionEvent.getRawX() - this.f32923r;
        if (Math.abs((this.f32918m * rawX) + (this.f32919n * rawY)) > this.f32931z || this.f32920o) {
            float progress2 = this.f32925t.getProgress();
            if (!this.f32920o) {
                this.f32920o = true;
                this.f32925t.setProgress(progress2);
            }
            int i6 = this.f32909d;
            if (i6 != -1) {
                c4 = 1;
                c5 = 0;
                f3 = progress2;
                this.f32925t.V(i6, f3, this.f32913h, this.f32912g, this.f32921p);
            } else {
                c4 = 1;
                f3 = progress2;
                c5 = 0;
                float fMin2 = Math.min(this.f32925t.getWidth(), this.f32925t.getHeight());
                float[] fArr3 = this.f32921p;
                fArr3[1] = this.f32919n * fMin2;
                fArr3[0] = fMin2 * this.f32918m;
            }
            float f7 = this.f32918m;
            float[] fArr4 = this.f32921p;
            if (Math.abs(((f7 * fArr4[c5]) + (this.f32919n * fArr4[c4])) * this.f32929x) < 0.01d) {
                float[] fArr5 = this.f32921p;
                fArr5[c5] = 0.01f;
                fArr5[c4] = 0.01f;
            }
            float fMax = Math.max(Math.min(f3 + (this.f32918m != 0.0f ? rawX / this.f32921p[c5] : rawY / this.f32921p[c4]), 1.0f), 0.0f);
            if (this.f32908c == 6) {
                fMax = Math.max(fMax, 0.01f);
            }
            if (this.f32908c == 7) {
                fMax = Math.min(fMax, 0.99f);
            }
            float progress3 = this.f32925t.getProgress();
            if (fMax != progress3) {
                if (progress3 == 0.0f || progress3 == 1.0f) {
                    this.f32925t.P(progress3 == 0.0f ? c4 : c5);
                }
                this.f32925t.setProgress(fMax);
                motionTracker.e(1000);
                this.f32925t.f32745d = this.f32918m != 0.0f ? motionTracker.d() / this.f32921p[c5] : motionTracker.c() / this.f32921p[c4];
            } else {
                this.f32925t.f32745d = 0.0f;
            }
            this.f32923r = motionEvent.getRawX();
            this.f32924s = motionEvent.getRawY();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void t(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker r25, int r26, androidx.constraintlayout.motion.widget.MotionScene r27) {
        /*
            Method dump skipped, instruction units count: 824
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.TouchResponse.t(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker, int, androidx.constraintlayout.motion.widget.MotionScene):void");
    }

    public String toString() {
        if (Float.isNaN(this.f32918m)) {
            return "rotation";
        }
        return this.f32918m + " , " + this.f32919n;
    }

    void u(float f3, float f4) {
        float progress = this.f32925t.getProgress();
        if (!this.f32920o) {
            this.f32920o = true;
            this.f32925t.setProgress(progress);
        }
        this.f32925t.V(this.f32909d, progress, this.f32913h, this.f32912g, this.f32921p);
        float f5 = this.f32918m;
        float[] fArr = this.f32921p;
        if (Math.abs((f5 * fArr[0]) + (this.f32919n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.f32921p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f6 = this.f32918m;
        float fMax = Math.max(Math.min(progress + (f6 != 0.0f ? (f3 * f6) / this.f32921p[0] : (f4 * this.f32919n) / this.f32921p[1]), 1.0f), 0.0f);
        if (fMax != this.f32925t.getProgress()) {
            this.f32925t.setProgress(fMax);
        }
    }

    void v(float f3, float f4) {
        this.f32920o = false;
        float progress = this.f32925t.getProgress();
        this.f32925t.V(this.f32909d, progress, this.f32913h, this.f32912g, this.f32921p);
        float f5 = this.f32918m;
        float[] fArr = this.f32921p;
        float f6 = f5 != 0.0f ? (f3 * f5) / fArr[0] : (f4 * this.f32919n) / fArr[1];
        if (!Float.isNaN(f6)) {
            progress += f6 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z2 = progress != 1.0f;
            int i3 = this.f32908c;
            if ((i3 != 3) && z2) {
                this.f32925t.k0(i3, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f6);
            }
        }
    }

    void w(float f3, float f4) {
        this.f32923r = f3;
        this.f32924s = f4;
    }

    public void x(boolean z2) {
        if (z2) {
            float[][] fArr = H;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = G;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = H;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = G;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = G[this.f32906a];
        this.f32913h = fArr5[0];
        this.f32912g = fArr5[1];
        int i3 = this.f32907b;
        float[][] fArr6 = H;
        if (i3 >= fArr6.length) {
            return;
        }
        float[] fArr7 = fArr6[i3];
        this.f32918m = fArr7[0];
        this.f32919n = fArr7[1];
    }

    public void y(int i3) {
        this.f32908c = i3;
    }

    void z(float f3, float f4) {
        this.f32923r = f3;
        this.f32924s = f4;
        this.f32920o = false;
    }
}
