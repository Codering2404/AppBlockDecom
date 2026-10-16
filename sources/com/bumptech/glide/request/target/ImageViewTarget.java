package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Animatable f67212j;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    private void r(Object obj) {
        if (!(obj instanceof Animatable)) {
            this.f67212j = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.f67212j = animatable;
        animatable.start();
    }

    private void t(Object obj) {
        s(obj);
        r(obj);
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public void d(Drawable drawable) {
        ((ImageView) this.f67225b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public Drawable e() {
        return ((ImageView) this.f67225b).getDrawable();
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void f(Drawable drawable) {
        super.f(drawable);
        t(null);
        d(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void g(Drawable drawable) {
        super.g(drawable);
        Animatable animatable = this.f67212j;
        if (animatable != null) {
            animatable.stop();
        }
        t(null);
        d(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void h(Object obj, Transition transition) {
        if (transition == null || !transition.a(obj, this)) {
            t(obj);
        } else {
            r(obj);
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void j(Drawable drawable) {
        super.j(drawable);
        t(null);
        d(drawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable animatable = this.f67212j;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable animatable = this.f67212j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    protected abstract void s(Object obj);
}
