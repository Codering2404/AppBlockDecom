package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class TintResources extends ResourcesWrapper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f2245b;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.f2245b = new WeakReference(context);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i3) {
        Drawable drawableA = a(i3);
        Context context = (Context) this.f2245b.get();
        if (drawableA != null && context != null) {
            ResourceManagerInternal.g().w(context, i3, drawableA);
        }
        return drawableA;
    }
}
