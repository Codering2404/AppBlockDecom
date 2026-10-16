package androidx.transition;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Scene {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f53465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f53466b;

    public static Scene b(ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(R.id.f53459f);
    }

    static void c(ViewGroup viewGroup, Scene scene) {
        viewGroup.setTag(R.id.f53459f, scene);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f53465a) != this || (runnable = this.f53466b) == null) {
            return;
        }
        runnable.run();
    }
}
