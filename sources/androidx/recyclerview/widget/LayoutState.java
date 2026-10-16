package androidx.recyclerview.widget;

import android.view.View;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
class LayoutState {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f51743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f51744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f51745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f51746e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f51749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f51750i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f51742a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f51747f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f51748g = 0;

    LayoutState() {
    }

    boolean a(RecyclerView.State state) {
        int i3 = this.f51744c;
        return i3 >= 0 && i3 < state.b();
    }

    View b(RecyclerView.Recycler recycler) {
        View viewO = recycler.o(this.f51744c);
        this.f51744c += this.f51745d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f51743b + ", mCurrentPosition=" + this.f51744c + ", mItemDirection=" + this.f51745d + ", mLayoutDirection=" + this.f51746e + muQRKXGtpOhe.tYYAwDwY + this.f51747f + ", mEndLine=" + this.f51748g + '}';
    }
}
