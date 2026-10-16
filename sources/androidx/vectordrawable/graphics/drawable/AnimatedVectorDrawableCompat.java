package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimatedVectorDrawableCompatState f53622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f53623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.animation.ArgbEvaluator f53624d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    AnimatedVectorDrawableDelegateState f53625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Animator.AnimatorListener f53626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayList f53627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Drawable.Callback f53628i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f53631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        VectorDrawableCompat f53632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AnimatorSet f53633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList f53634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ArrayMap f53635e;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.f53631a = animatedVectorDrawableCompatState.f53631a;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.f53632b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.f53632b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f53632b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.f53632b.mutate();
                    this.f53632b = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.f53632b.setBounds(animatedVectorDrawableCompatState.f53632b.getBounds());
                    this.f53632b.h(false);
                }
                ArrayList arrayList = animatedVectorDrawableCompatState.f53634d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f53634d = new ArrayList(size);
                    this.f53635e = new ArrayMap(size);
                    for (int i3 = 0; i3 < size; i3++) {
                        Animator animator = (Animator) animatedVectorDrawableCompatState.f53634d.get(i3);
                        Animator animatorClone = animator.clone();
                        String str = (String) animatedVectorDrawableCompatState.f53635e.get(animator);
                        animatorClone.setTarget(this.f53632b.d(str));
                        this.f53634d.add(animatorClone);
                        this.f53635e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f53633c == null) {
                this.f53633c = new AnimatorSet();
            }
            this.f53633c.playTogether(this.f53634d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f53631a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    public static AnimatedVectorDrawableCompat a(Context context, int i3) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        Drawable drawableF = ResourcesCompat.f(context.getResources(), i3, context.getTheme());
        animatedVectorDrawableCompat.f53641a = drawableF;
        drawableF.setCallback(animatedVectorDrawableCompat.f53628i);
        animatedVectorDrawableCompat.f53625f = new AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.f53641a.getConstantState());
        return animatedVectorDrawableCompat;
    }

    public static AnimatedVectorDrawableCompat b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    private static void d(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animationCallback.a());
    }

    private void e() {
        Animator.AnimatorListener animatorListener = this.f53626g;
        if (animatorListener != null) {
            this.f53622b.f53633c.removeListener(animatorListener);
            this.f53626g = null;
        }
    }

    private void f(String str, Animator animator) {
        animator.setTarget(this.f53622b.f53632b.d(str));
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.f53622b;
        if (animatedVectorDrawableCompatState.f53634d == null) {
            animatedVectorDrawableCompatState.f53634d = new ArrayList();
            this.f53622b.f53635e = new ArrayMap();
        }
        this.f53622b.f53634d.add(animator);
        this.f53622b.f53635e.put(animator, str);
    }

    private static boolean h(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animationCallback.a());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.a(drawable, theme);
        }
    }

    public void c(Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            d((AnimatedVectorDrawable) drawable, animationCallback);
            return;
        }
        if (animationCallback == null) {
            return;
        }
        if (this.f53627h == null) {
            this.f53627h = new ArrayList();
        }
        if (this.f53627h.contains(animationCallback)) {
            return;
        }
        this.f53627h.add(animationCallback);
        if (this.f53626g == null) {
            this.f53626g = new AnimatorListenerAdapter() { // from class: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.f53627h);
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((Animatable2Compat.AnimationCallback) arrayList.get(i3)).b(AnimatedVectorDrawableCompat.this);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.f53627h);
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((Animatable2Compat.AnimationCallback) arrayList.get(i3)).c(AnimatedVectorDrawableCompat.this);
                    }
                }
            };
        }
        this.f53622b.f53633c.addListener(this.f53626g);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            return DrawableCompat.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f53622b.f53632b.draw(canvas);
        if (this.f53622b.f53633c.isStarted()) {
            invalidateSelf();
        }
    }

    public boolean g(Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            h((AnimatedVectorDrawable) drawable, animationCallback);
        }
        ArrayList arrayList = this.f53627h;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(animationCallback);
        if (this.f53627h.size() == 0) {
            e();
        }
        return zRemove;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f53641a;
        return drawable != null ? DrawableCompat.d(drawable) : this.f53622b.f53632b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f53622b.f53631a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f53641a;
        return drawable != null ? DrawableCompat.e(drawable) : this.f53622b.f53632b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f53641a != null) {
            return new AnimatedVectorDrawableDelegateState(this.f53641a.getConstantState());
        }
        return null;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f53622b.f53632b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f53622b.f53632b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.getOpacity() : this.f53622b.f53632b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.f53612e);
                    int resourceId = typedArrayQ.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat vectorDrawableCompatB = VectorDrawableCompat.b(resources, resourceId, theme);
                        vectorDrawableCompatB.h(false);
                        vectorDrawableCompatB.setCallback(this.f53628i);
                        VectorDrawableCompat vectorDrawableCompat = this.f53622b.f53632b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback(null);
                        }
                        this.f53622b.f53632b = vectorDrawableCompatB;
                    }
                    typedArrayQ.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.f53613f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f53623c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        f(string, AnimatorInflaterCompat.a(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f53622b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f53641a;
        return drawable != null ? DrawableCompat.h(drawable) : this.f53622b.f53632b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f53641a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f53622b.f53633c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.isStateful() : this.f53622b.f53632b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f53622b.f53632b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.setLevel(i3) : this.f53622b.f53632b.setLevel(i3);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.setState(iArr) : this.f53622b.f53632b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.setAlpha(i3);
        } else {
            this.f53622b.f53632b.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.j(drawable, z2);
        } else {
            this.f53622b.f53632b.setAutoMirrored(z2);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i3) {
        super.setChangingConfigurations(i3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i3, PorterDuff.Mode mode) {
        super.setColorFilter(i3, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f3, float f4) {
        super.setHotspot(f3, f4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i3, int i4, int i5, int i6) {
        super.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.n(drawable, i3);
        } else {
            this.f53622b.f53632b.setTint(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
        } else {
            this.f53622b.f53632b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
        } else {
            this.f53622b.f53632b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        this.f53622b.f53632b.setVisible(z2, z3);
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f53622b.f53633c.isStarted()) {
                return;
            }
            this.f53622b.f53633c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f53622b.f53633c.end();
        }
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f53622b.f53632b.setColorFilter(colorFilter);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f53636a;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f53636a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f53636a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f53636a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable drawableNewDrawable = this.f53636a.newDrawable();
            animatedVectorDrawableCompat.f53641a = drawableNewDrawable;
            drawableNewDrawable.setCallback(animatedVectorDrawableCompat.f53628i);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable drawableNewDrawable = this.f53636a.newDrawable(resources);
            animatedVectorDrawableCompat.f53641a = drawableNewDrawable;
            drawableNewDrawable.setCallback(animatedVectorDrawableCompat.f53628i);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable drawableNewDrawable = this.f53636a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f53641a = drawableNewDrawable;
            drawableNewDrawable.setCallback(animatedVectorDrawableCompat.f53628i);
            return animatedVectorDrawableCompat;
        }
    }

    private AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.f53624d = null;
        this.f53626g = null;
        this.f53627h = null;
        Drawable.Callback callback = new Drawable.Callback() { // from class: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j3);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.f53628i = callback;
        this.f53623c = context;
        if (animatedVectorDrawableCompatState != null) {
            this.f53622b = animatedVectorDrawableCompatState;
        } else {
            this.f53622b = new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, callback, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
