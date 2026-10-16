package androidx.legacy.widget;

import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class Space extends View {
    private static int a(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i3 : size : Math.min(i3, size);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(a(getSuggestedMinimumWidth(), i3), a(getSuggestedMinimumHeight(), i4));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }
}
