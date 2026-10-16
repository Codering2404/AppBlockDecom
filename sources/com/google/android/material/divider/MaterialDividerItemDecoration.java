package com.google.android.material.divider;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f80943h = R.style.P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f80944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f80945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f80946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f80947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f80948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f80949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f80950g;

    private void l(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        int i3;
        int i4;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int i5 = paddingTop + this.f80947d;
        int i6 = height - this.f80948e;
        boolean zO = ViewUtils.o(recyclerView);
        int childCount = recyclerView.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = recyclerView.getChildAt(i7);
            if (o(recyclerView, childAt)) {
                recyclerView.getLayoutManager().V(childAt, this.f80950g);
                int iRound = Math.round(childAt.getTranslationX());
                if (zO) {
                    i4 = this.f80950g.left + iRound;
                    i3 = this.f80945b + i4;
                } else {
                    i3 = iRound + this.f80950g.right;
                    i4 = i3 - this.f80945b;
                }
                this.f80944a.setBounds(i4, i5, i3, i6);
                this.f80944a.setAlpha(Math.round(childAt.getAlpha() * 255.0f));
                this.f80944a.draw(canvas);
            }
        }
        canvas.restore();
    }

    private void m(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        boolean zO = ViewUtils.o(recyclerView);
        int i3 = paddingLeft + (zO ? this.f80948e : this.f80947d);
        int i4 = width - (zO ? this.f80947d : this.f80948e);
        int childCount = recyclerView.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = recyclerView.getChildAt(i5);
            if (o(recyclerView, childAt)) {
                recyclerView.getLayoutManager().V(childAt, this.f80950g);
                int iRound = this.f80950g.bottom + Math.round(childAt.getTranslationY());
                this.f80944a.setBounds(i3, iRound - this.f80945b, i4, iRound);
                this.f80944a.setAlpha(Math.round(childAt.getAlpha() * 255.0f));
                this.f80944a.draw(canvas);
            }
        }
        canvas.restore();
    }

    private boolean o(RecyclerView recyclerView, View view) {
        int iK0 = recyclerView.k0(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        return iK0 != -1 && (!(adapter != null && iK0 == adapter.getItemCount() - 1) || this.f80949f) && n(iK0, adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, 0);
        if (o(recyclerView, view)) {
            if (this.f80946c == 1) {
                rect.bottom = this.f80945b;
            } else if (ViewUtils.o(recyclerView)) {
                rect.left = this.f80945b;
            } else {
                rect.right = this.f80945b;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        if (this.f80946c == 1) {
            m(canvas, recyclerView);
        } else {
            l(canvas, recyclerView);
        }
    }

    protected boolean n(int i3, RecyclerView.Adapter adapter) {
        return true;
    }
}
