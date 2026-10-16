package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FixedSizeDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f67203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f67204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f67205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f67206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private State f67207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f67208f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class State extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f67209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f67210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f67211c;

        State(State state) {
            this(state.f67209a, state.f67210b, state.f67211c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.f67209a.newDrawable());
        }

        State(Drawable.ConstantState constantState, int i3, int i4) {
            this.f67209a = constantState;
            this.f67210b = i3;
            this.f67211c = i4;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new FixedSizeDrawable(this, this.f67209a.newDrawable(resources));
        }
    }

    public FixedSizeDrawable(Drawable drawable, int i3, int i4) {
        this(new State(drawable.getConstantState(), i3, i4), drawable);
    }

    private void a() {
        this.f67203a.setRectToRect(this.f67204b, this.f67205c, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f67206d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f67203a);
        this.f67206d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f67206d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.f67206d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f67206d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f67207e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f67206d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f67207e.f67211c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f67207e.f67210b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f67206d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f67206d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f67206d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f67206d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f67206d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f67208f && super.mutate() == this) {
            this.f67206d = this.f67206d.mutate();
            this.f67207e = new State(this.f67207e);
            this.f67208f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j3) {
        super.scheduleSelf(runnable, j3);
        this.f67206d.scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f67206d.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i4, int i5, int i6) {
        super.setBounds(i3, i4, i5, i6);
        this.f67205c.set(i3, i4, i5, i6);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i3) {
        this.f67206d.setChangingConfigurations(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i3, PorterDuff.Mode mode) {
        this.f67206d.setColorFilter(i3, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f67206d.setDither(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f67206d.setFilterBitmap(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        return this.f67206d.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f67206d.unscheduleSelf(runnable);
    }

    FixedSizeDrawable(State state, Drawable drawable) {
        this.f67207e = (State) Preconditions.e(state);
        this.f67206d = (Drawable) Preconditions.e(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f67203a = new Matrix();
        this.f67204b = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f67205c = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f67206d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f67205c.set(rect);
        a();
    }
}
