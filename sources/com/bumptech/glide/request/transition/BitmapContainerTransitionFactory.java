package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransitionFactory f67237a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class BitmapGlideAnimation implements Transition<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Transition f67238a;

        BitmapGlideAnimation(Transition transition) {
            this.f67238a = transition;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
            return this.f67238a.a(new BitmapDrawable(viewAdapter.a().getResources(), BitmapContainerTransitionFactory.this.b(obj)), viewAdapter);
        }
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition a(DataSource dataSource, boolean z2) {
        return new BitmapGlideAnimation(this.f67237a.a(dataSource, z2));
    }

    protected abstract Bitmap b(Object obj);
}
