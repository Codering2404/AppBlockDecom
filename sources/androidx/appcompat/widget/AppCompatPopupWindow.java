package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f1831b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1832a;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        a(context, attributeSet, i3, i4);
    }

    private void a(Context context, AttributeSet attributeSet, int i3, int i4) {
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, R.styleable.f840i2, i3, i4);
        int i5 = R.styleable.f848k2;
        if (tintTypedArrayV.s(i5)) {
            b(tintTypedArrayV.a(i5, false));
        }
        setBackgroundDrawable(tintTypedArrayV.g(R.styleable.f844j2));
        tintTypedArrayV.x();
    }

    private void b(boolean z2) {
        if (f1831b) {
            this.f1832a = z2;
        } else {
            PopupWindowCompat.a(this, z2);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i4) {
        if (f1831b && this.f1832a) {
            i4 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i4);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i3, int i4, int i5, int i6) {
        if (f1831b && this.f1832a) {
            i4 -= view.getHeight();
        }
        super.update(view, i3, i4, i5, i6);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i4, int i5) {
        if (f1831b && this.f1832a) {
            i4 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i4, i5);
    }
}
