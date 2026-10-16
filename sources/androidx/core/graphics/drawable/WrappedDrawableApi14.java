package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final PorterDuff.Mode f34039h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f34040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PorterDuff.Mode f34041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f34042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    WrappedDrawableState f34043d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f34044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Drawable f34045g;

    WrappedDrawableApi14(WrappedDrawableState wrappedDrawableState, Resources resources) {
        this.f34043d = wrappedDrawableState;
        e(resources);
    }

    private WrappedDrawableState d() {
        return new WrappedDrawableState(this.f34043d);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        WrappedDrawableState wrappedDrawableState = this.f34043d;
        if (wrappedDrawableState == null || (constantState = wrappedDrawableState.f34048b) == null) {
            return;
        }
        b(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        WrappedDrawableState wrappedDrawableState = this.f34043d;
        ColorStateList colorStateList = wrappedDrawableState.f34049c;
        PorterDuff.Mode mode = wrappedDrawableState.f34050d;
        if (colorStateList == null || mode == null) {
            this.f34042c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f34042c || colorForState != this.f34040a || mode != this.f34041b) {
                setColorFilter(colorForState, mode);
                this.f34040a = colorForState;
                this.f34041b = mode;
                this.f34042c = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final Drawable a() {
        return this.f34045g;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f34045g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f34045g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState wrappedDrawableState = this.f34043d;
            if (wrappedDrawableState != null) {
                wrappedDrawableState.f34048b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f34045g.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.f34043d;
        return changingConfigurations | (wrappedDrawableState != null ? wrappedDrawableState.getChangingConfigurations() : 0) | this.f34045g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState wrappedDrawableState = this.f34043d;
        if (wrappedDrawableState == null || !wrappedDrawableState.a()) {
            return null;
        }
        this.f34043d.f34047a = getChangingConfigurations();
        return this.f34043d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f34045g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f34045g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f34045g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return DrawableCompat.f(this.f34045g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f34045g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f34045g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f34045g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f34045g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f34045g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f34045g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return DrawableCompat.h(this.f34045g);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        WrappedDrawableState wrappedDrawableState;
        ColorStateList colorStateList = (!c() || (wrappedDrawableState = this.f34043d) == null) ? null : wrappedDrawableState.f34049c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f34045g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f34045g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f34044f && super.mutate() == this) {
            this.f34043d = d();
            Drawable drawable = this.f34045g;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState wrappedDrawableState = this.f34043d;
            if (wrappedDrawableState != null) {
                Drawable drawable2 = this.f34045g;
                wrappedDrawableState.f34048b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f34044f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f34045g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        return DrawableCompat.m(this.f34045g, i3);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        return this.f34045g.setLevel(i3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f34045g.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        DrawableCompat.j(this.f34045g, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i3) {
        this.f34045g.setChangingConfigurations(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f34045g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f34045g.setDither(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f34045g.setFilterBitmap(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.f34045g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f34043d.f34049c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f34043d.f34050d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f34045g.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
