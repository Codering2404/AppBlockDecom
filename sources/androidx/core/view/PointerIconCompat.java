package androidx.core.view;

import android.content.Context;
import android.view.PointerIcon;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PointerIconCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointerIcon f34430a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static PointerIcon a(Context context, int i3) {
            return PointerIcon.getSystemIcon(context, i3);
        }
    }

    private PointerIconCompat(PointerIcon pointerIcon) {
        this.f34430a = pointerIcon;
    }

    public static PointerIconCompat b(Context context, int i3) {
        return new PointerIconCompat(Api24Impl.a(context, i3));
    }

    public Object a() {
        return this.f34430a;
    }
}
