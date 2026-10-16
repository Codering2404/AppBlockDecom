package androidx.core.widget;

import android.widget.ProgressBar;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f34657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f34658b;

    private void a() {
        removeCallbacks(this.f34657a);
        removeCallbacks(this.f34658b);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }
}
