package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class WrappedDrawableApi21 extends WrappedDrawableApi14 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Method f34046i;

    WrappedDrawableApi21(WrappedDrawableState wrappedDrawableState, Resources resources) {
        super(wrappedDrawableState, resources);
        g();
    }

    private void g() {
        if (f34046i == null) {
            try {
                f34046i = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception e3) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e3);
            }
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    protected boolean c() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f34045g.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f34045g.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f34045g;
        if (drawable == null || (method = f34046i) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, null)).booleanValue();
        } catch (Exception e3) {
            Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e3);
            return false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f3, float f4) {
        this.f34045g.setHotspot(f3, f4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i4, int i5, int i6) {
        this.f34045g.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public void setTint(int i3) {
        if (c()) {
            super.setTint(i3);
        } else {
            this.f34045g.setTint(i3);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f34045g.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f34045g.setTintMode(mode);
        }
    }
}
