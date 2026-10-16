package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f52000g = true;

    public abstract boolean A(RecyclerView.ViewHolder viewHolder);

    public final void B(RecyclerView.ViewHolder viewHolder) {
        J(viewHolder);
        h(viewHolder);
    }

    public final void C(RecyclerView.ViewHolder viewHolder) {
        K(viewHolder);
    }

    public final void D(RecyclerView.ViewHolder viewHolder, boolean z2) {
        L(viewHolder, z2);
        h(viewHolder);
    }

    public final void E(RecyclerView.ViewHolder viewHolder, boolean z2) {
        M(viewHolder, z2);
    }

    public final void F(RecyclerView.ViewHolder viewHolder) {
        N(viewHolder);
        h(viewHolder);
    }

    public final void G(RecyclerView.ViewHolder viewHolder) {
        O(viewHolder);
    }

    public final void H(RecyclerView.ViewHolder viewHolder) {
        P(viewHolder);
        h(viewHolder);
    }

    public final void I(RecyclerView.ViewHolder viewHolder) {
        Q(viewHolder);
    }

    public void R(boolean z2) {
        this.f52000g = z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i3;
        int i4;
        return (itemHolderInfo == null || ((i3 = itemHolderInfo.f51906a) == (i4 = itemHolderInfo2.f51906a) && itemHolderInfo.f51907b == itemHolderInfo2.f51907b)) ? x(viewHolder) : z(viewHolder, i3, itemHolderInfo.f51907b, i4, itemHolderInfo2.f51907b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean b(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i3;
        int i4;
        int i5 = itemHolderInfo.f51906a;
        int i6 = itemHolderInfo.f51907b;
        if (viewHolder2.shouldIgnore()) {
            int i7 = itemHolderInfo.f51906a;
            i4 = itemHolderInfo.f51907b;
            i3 = i7;
        } else {
            i3 = itemHolderInfo2.f51906a;
            i4 = itemHolderInfo2.f51907b;
        }
        return y(viewHolder, viewHolder2, i5, i6, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i3 = itemHolderInfo.f51906a;
        int i4 = itemHolderInfo.f51907b;
        View view = viewHolder.itemView;
        int left = itemHolderInfo2 == null ? view.getLeft() : itemHolderInfo2.f51906a;
        int top = itemHolderInfo2 == null ? view.getTop() : itemHolderInfo2.f51907b;
        if (viewHolder.isRemoved() || (i3 == left && i4 == top)) {
            return A(viewHolder);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return z(viewHolder, i3, i4, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i3 = itemHolderInfo.f51906a;
        int i4 = itemHolderInfo2.f51906a;
        if (i3 != i4 || itemHolderInfo.f51907b != itemHolderInfo2.f51907b) {
            return z(viewHolder, i3, itemHolderInfo.f51907b, i4, itemHolderInfo2.f51907b);
        }
        F(viewHolder);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean f(RecyclerView.ViewHolder viewHolder) {
        return !this.f52000g || viewHolder.isInvalid();
    }

    public abstract boolean x(RecyclerView.ViewHolder viewHolder);

    public abstract boolean y(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i4, int i5, int i6);

    public abstract boolean z(RecyclerView.ViewHolder viewHolder, int i3, int i4, int i5, int i6);

    public void J(RecyclerView.ViewHolder viewHolder) {
    }

    public void K(RecyclerView.ViewHolder viewHolder) {
    }

    public void N(RecyclerView.ViewHolder viewHolder) {
    }

    public void O(RecyclerView.ViewHolder viewHolder) {
    }

    public void P(RecyclerView.ViewHolder viewHolder) {
    }

    public void Q(RecyclerView.ViewHolder viewHolder) {
    }

    public void L(RecyclerView.ViewHolder viewHolder, boolean z2) {
    }

    public void M(RecyclerView.ViewHolder viewHolder, boolean z2) {
    }
}
