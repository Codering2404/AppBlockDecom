package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f51628d = {R.attr.listDivider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f51629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f51630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f51631c = new Rect();

    public DividerItemDecoration(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f51628d);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f51629a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
        o(i3);
    }

    private void l(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.getLayoutManager().V(childAt, this.f51631c);
            int iRound = this.f51631c.right + Math.round(childAt.getTranslationX());
            this.f51629a.setBounds(iRound - this.f51629a.getIntrinsicWidth(), paddingTop, iRound, height);
            this.f51629a.draw(canvas);
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
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.o0(childAt, this.f51631c);
            int iRound = this.f51631c.bottom + Math.round(childAt.getTranslationY());
            this.f51629a.setBounds(paddingLeft, iRound - this.f51629a.getIntrinsicHeight(), width, iRound);
            this.f51629a.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable = this.f51629a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f51630b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() == null || this.f51629a == null) {
            return;
        }
        if (this.f51630b == 1) {
            m(canvas, recyclerView);
        } else {
            l(canvas, recyclerView);
        }
    }

    public void n(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f51629a = drawable;
    }

    public void o(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f51630b = i3;
    }
}
