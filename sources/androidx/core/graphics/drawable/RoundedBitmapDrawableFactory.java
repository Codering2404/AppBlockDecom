package androidx.core.graphics.drawable;

import android.graphics.Rect;
import androidx.core.view.GravityCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RoundedBitmapDrawableFactory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        void b(int i3, int i4, int i5, Rect rect, Rect rect2) {
            GravityCompat.a(i3, i4, i5, rect, rect2, 0);
        }
    }
}
