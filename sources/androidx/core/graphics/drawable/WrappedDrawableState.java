package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WrappedDrawableState extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f34047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f34048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ColorStateList f34049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f34050d;

    WrappedDrawableState(WrappedDrawableState wrappedDrawableState) {
        this.f34049c = null;
        this.f34050d = WrappedDrawableApi14.f34039h;
        if (wrappedDrawableState != null) {
            this.f34047a = wrappedDrawableState.f34047a;
            this.f34048b = wrappedDrawableState.f34048b;
            this.f34049c = wrappedDrawableState.f34049c;
            this.f34050d = wrappedDrawableState.f34050d;
        }
    }

    boolean a() {
        return this.f34048b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i3 = this.f34047a;
        Drawable.ConstantState constantState = this.f34048b;
        return i3 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new WrappedDrawableApi21(this, resources);
    }
}
