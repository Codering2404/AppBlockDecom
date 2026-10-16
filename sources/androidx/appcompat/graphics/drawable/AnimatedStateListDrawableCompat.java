package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AnimatedStateListState f1176p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Transition f1177q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1178r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1179s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1180t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AnimatableTransition extends Transition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animatable f1181a;

        AnimatableTransition(Animatable animatable) {
            super();
            this.f1181a = animatable;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void c() {
            this.f1181a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void d() {
            this.f1181a.stop();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        LongSparseArray K;
        SparseArrayCompat L;

        AnimatedStateListState(AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.K = animatedStateListState.K;
                this.L = animatedStateListState.L;
            } else {
                this.K = new LongSparseArray();
                this.L = new SparseArrayCompat();
            }
        }

        private static long E(int i3, int i4) {
            return ((long) i4) | (((long) i3) << 32);
        }

        int C(int[] iArr, Drawable drawable, int i3) {
            int iA = super.A(iArr, drawable);
            this.L.m(iA, Integer.valueOf(i3));
            return iA;
        }

        int D(int i3, int i4, Drawable drawable, boolean z2) {
            int iA = super.a(drawable);
            long jE = E(i3, i4);
            long j3 = z2 ? 8589934592L : 0L;
            long j4 = iA;
            this.K.a(jE, Long.valueOf(j4 | j3));
            if (z2) {
                this.K.a(E(i4, i3), Long.valueOf(4294967296L | j4 | j3));
            }
            return iA;
        }

        int F(int i3) {
            if (i3 < 0) {
                return 0;
            }
            return ((Integer) this.L.h(i3, 0)).intValue();
        }

        int G(int[] iArr) {
            int iB = super.B(iArr);
            return iB >= 0 ? iB : super.B(StateSet.WILD_CARD);
        }

        int H(int i3, int i4) {
            return (int) ((Long) this.K.h(E(i3, i4), -1L)).longValue();
        }

        boolean I(int i3, int i4) {
            return (((Long) this.K.h(E(i3, i4), -1L)).longValue() & 4294967296L) != 0;
        }

        boolean J(int i3, int i4) {
            return (((Long) this.K.h(E(i3, i4), -1L)).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void s() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AnimatedVectorDrawableTransition extends Transition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedVectorDrawableCompat f1182a;

        AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f1182a = animatedVectorDrawableCompat;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void c() {
            this.f1182a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void d() {
            this.f1182a.stop();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AnimationDrawableTransition extends Transition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f1183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f1184b;

        AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z2, boolean z3) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i3 = z2 ? numberOfFrames - 1 : 0;
            int i4 = z2 ? 0 : numberOfFrames - 1;
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z2);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i3, i4);
            objectAnimatorOfInt.setAutoCancel(true);
            objectAnimatorOfInt.setDuration(frameInterpolator.a());
            objectAnimatorOfInt.setInterpolator(frameInterpolator);
            this.f1184b = z3;
            this.f1183a = objectAnimatorOfInt;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean a() {
            return this.f1184b;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void b() {
            this.f1183a.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void c() {
            this.f1183a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void d() {
            this.f1183a.cancel();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FrameInterpolator implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f1185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1187c;

        FrameInterpolator(AnimationDrawable animationDrawable, boolean z2) {
            b(animationDrawable, z2);
        }

        int a() {
            return this.f1187c;
        }

        int b(AnimationDrawable animationDrawable, boolean z2) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f1186b = numberOfFrames;
            int[] iArr = this.f1185a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f1185a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f1185a;
            int i3 = 0;
            for (int i4 = 0; i4 < numberOfFrames; i4++) {
                int duration = animationDrawable.getDuration(z2 ? (numberOfFrames - i4) - 1 : i4);
                iArr2[i4] = duration;
                i3 += duration;
            }
            this.f1187c = i3;
            return i3;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            int i3 = (int) ((f3 * this.f1187c) + 0.5f);
            int i4 = this.f1186b;
            int[] iArr = this.f1185a;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = iArr[i5];
                if (i3 < i6) {
                    break;
                }
                i3 -= i6;
                i5++;
            }
            return (i5 / i4) + (i5 < i4 ? i3 / this.f1187c : 0.0f);
        }
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    public static AnimatedStateListDrawableCompat m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.n(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    r(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, R.styleable.f1252h);
        int resourceId = typedArrayQ.getResourceId(R.styleable.f1253i, 0);
        int resourceId2 = typedArrayQ.getResourceId(R.styleable.f1254j, -1);
        Drawable drawableI = resourceId2 > 0 ? ResourceManagerInternal.g().i(context, resourceId2) : null;
        typedArrayQ.recycle();
        int[] iArrK = k(attributeSet);
        if (drawableI == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableI = xmlPullParser.getName().equals("vector") ? VectorDrawableCompat.c(resources, xmlPullParser, attributeSet, theme) : Compatibility.Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableI != null) {
            return this.f1176p.C(iArrK, drawableI, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, R.styleable.f1255k);
        int resourceId = typedArrayQ.getResourceId(R.styleable.f1258n, -1);
        int resourceId2 = typedArrayQ.getResourceId(R.styleable.f1257m, -1);
        int resourceId3 = typedArrayQ.getResourceId(R.styleable.f1256l, -1);
        Drawable drawableI = resourceId3 > 0 ? ResourceManagerInternal.g().i(context, resourceId3) : null;
        boolean z2 = typedArrayQ.getBoolean(R.styleable.f1259o, false);
        typedArrayQ.recycle();
        if (drawableI == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableI = xmlPullParser.getName().equals("animated-vector") ? AnimatedVectorDrawableCompat.b(context, resources, xmlPullParser, attributeSet, theme) : Compatibility.Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableI == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.f1176p.D(resourceId, resourceId2, drawableI, z2);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    private boolean s(int i3) {
        int iC;
        int iH;
        Transition animatableTransition;
        Transition transition = this.f1177q;
        if (transition == null) {
            iC = c();
        } else {
            if (i3 == this.f1178r) {
                return true;
            }
            if (i3 == this.f1179s && transition.a()) {
                transition.b();
                this.f1178r = this.f1179s;
                this.f1179s = i3;
                return true;
            }
            iC = this.f1178r;
            transition.d();
        }
        this.f1177q = null;
        this.f1179s = -1;
        this.f1178r = -1;
        AnimatedStateListState animatedStateListState = this.f1176p;
        int iF = animatedStateListState.F(iC);
        int iF2 = animatedStateListState.F(i3);
        if (iF2 == 0 || iF == 0 || (iH = animatedStateListState.H(iF, iF2)) < 0) {
            return false;
        }
        boolean zJ = animatedStateListState.J(iF, iF2);
        g(iH);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            animatableTransition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.I(iF, iF2), zJ);
        } else {
            if (!(current instanceof AnimatedVectorDrawableCompat)) {
                if (current instanceof Animatable) {
                    animatableTransition = new AnimatableTransition((Animatable) current);
                }
                return false;
            }
            animatableTransition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) current);
        }
        animatableTransition.c();
        this.f1177q = animatableTransition;
        this.f1179s = iC;
        this.f1178r = i3;
        return true;
    }

    private void t(TypedArray typedArray) {
        AnimatedStateListState animatedStateListState = this.f1176p;
        animatedStateListState.f1205d |= Compatibility.Api21Impl.b(typedArray);
        animatedStateListState.y(typedArray.getBoolean(R.styleable.f1248d, animatedStateListState.f1210i));
        animatedStateListState.u(typedArray.getBoolean(R.styleable.f1249e, animatedStateListState.f1213l));
        animatedStateListState.v(typedArray.getInt(R.styleable.f1250f, animatedStateListState.A));
        animatedStateListState.w(typedArray.getInt(R.styleable.f1251g, animatedStateListState.B));
        setDither(typedArray.getBoolean(R.styleable.f1246b, animatedStateListState.f1225x));
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void h(DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.h(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.f1176p = (AnimatedStateListState) drawableContainerState;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.f1177q;
        if (transition != null) {
            transition.d();
            this.f1177q = null;
            g(this.f1178r);
            this.f1178r = -1;
            this.f1179s = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public AnimatedStateListState b() {
        return new AnimatedStateListState(this.f1176p, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1180t && super.mutate() == this) {
            this.f1176p.s();
            this.f1180t = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, R.styleable.f1245a);
        setVisible(typedArrayQ.getBoolean(R.styleable.f1247c, true), true);
        t(typedArrayQ);
        i(resources);
        typedArrayQ.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iG = this.f1176p.G(iArr);
        boolean z2 = iG != c() && (s(iG) || g(iG));
        Drawable current = getCurrent();
        return current != null ? current.setState(iArr) | z2 : z2;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Transition transition = this.f1177q;
        if (transition != null && (visible || z3)) {
            if (z2) {
                transition.c();
                return visible;
            }
            jumpToCurrentState();
        }
        return visible;
    }

    AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        super(null);
        this.f1178r = -1;
        this.f1179s = -1;
        h(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class Transition {
        private Transition() {
        }

        public boolean a() {
            return false;
        }

        public abstract void c();

        public abstract void d();

        public void b() {
        }
    }
}
