package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Drawable f66954a;

    public DrawableResource(Drawable drawable) {
        this.f66954a = (Drawable) Preconditions.e(drawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Drawable get() {
        Drawable.ConstantState constantState = this.f66954a.getConstantState();
        return constantState == null ? this.f66954a : constantState.newDrawable();
    }

    public void initialize() {
        Drawable drawable = this.f66954a;
        if (drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
        } else if (drawable instanceof GifDrawable) {
            ((GifDrawable) drawable).e().prepareToDraw();
        }
    }
}
