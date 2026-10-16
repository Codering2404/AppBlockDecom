package androidx.core.graphics.drawable;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    void b(int i3, int i4, int i5, Rect rect, Rect rect2) {
        Gravity.apply(i3, i4, i5, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        e();
        outline.setRoundRect(this.f34033g, a());
    }
}
