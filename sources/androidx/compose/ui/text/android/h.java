package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class h {
    public static /* synthetic */ BoringLayout a(CharSequence charSequence, TextPaint textPaint, int i3, Layout.Alignment alignment, float f3, float f4, BoringLayout.Metrics metrics, boolean z2, TextUtils.TruncateAt truncateAt, int i4, boolean z3) {
        return new BoringLayout(charSequence, textPaint, i3, alignment, f3, f4, metrics, z2, truncateAt, i4, z3);
    }
}
