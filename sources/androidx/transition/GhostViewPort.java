package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class GhostViewPort extends ViewGroup implements GhostView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewGroup f53436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View f53437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final View f53438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f53439d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Matrix f53440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f53441g;

    GhostViewPort(View view) {
        super(view.getContext());
        this.f53441g = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.transition.GhostViewPort.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                View view2;
                GhostViewPort.this.postInvalidateOnAnimation();
                GhostViewPort ghostViewPort = GhostViewPort.this;
                ViewGroup viewGroup = ghostViewPort.f53436a;
                if (viewGroup == null || (view2 = ghostViewPort.f53437b) == null) {
                    return true;
                }
                viewGroup.endViewTransition(view2);
                GhostViewPort.this.f53436a.postInvalidateOnAnimation();
                GhostViewPort ghostViewPort2 = GhostViewPort.this;
                ghostViewPort2.f53436a = null;
                ghostViewPort2.f53437b = null;
                return true;
            }
        };
        this.f53438c = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    static GhostViewPort b(View view, ViewGroup viewGroup, Matrix matrix) {
        int i3;
        GhostViewHolder ghostViewHolder;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        GhostViewHolder ghostViewHolderB = GhostViewHolder.b(viewGroup);
        GhostViewPort ghostViewPortE = e(view);
        if (ghostViewPortE == null || (ghostViewHolder = (GhostViewHolder) ghostViewPortE.getParent()) == ghostViewHolderB) {
            i3 = 0;
        } else {
            i3 = ghostViewPortE.f53439d;
            ghostViewHolder.removeView(ghostViewPortE);
            ghostViewPortE = null;
        }
        if (ghostViewPortE == null) {
            if (matrix == null) {
                matrix = new Matrix();
                c(view, viewGroup, matrix);
            }
            ghostViewPortE = new GhostViewPort(view);
            ghostViewPortE.h(matrix);
            if (ghostViewHolderB == null) {
                ghostViewHolderB = new GhostViewHolder(viewGroup);
            } else {
                ghostViewHolderB.g();
            }
            d(viewGroup, ghostViewHolderB);
            d(viewGroup, ghostViewPortE);
            ghostViewHolderB.a(ghostViewPortE);
            ghostViewPortE.f53439d = i3;
        } else if (matrix != null) {
            ghostViewPortE.h(matrix);
        }
        ghostViewPortE.f53439d++;
        return ghostViewPortE;
    }

    static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        ViewUtils.h(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        ViewUtils.i(viewGroup, matrix);
    }

    static void d(View view, View view2) {
        ViewUtils.e(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static GhostViewPort e(View view) {
        return (GhostViewPort) view.getTag(R.id.f53454a);
    }

    static void f(View view) {
        GhostViewPort ghostViewPortE = e(view);
        if (ghostViewPortE != null) {
            int i3 = ghostViewPortE.f53439d - 1;
            ghostViewPortE.f53439d = i3;
            if (i3 <= 0) {
                ((GhostViewHolder) ghostViewPortE.getParent()).removeView(ghostViewPortE);
            }
        }
    }

    static void g(View view, GhostViewPort ghostViewPort) {
        view.setTag(R.id.f53454a, ghostViewPort);
    }

    @Override // androidx.transition.GhostView
    public void a(ViewGroup viewGroup, View view) {
        this.f53436a = viewGroup;
        this.f53437b = view;
    }

    void h(Matrix matrix) {
        this.f53440f = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.f53438c, this);
        this.f53438c.getViewTreeObserver().addOnPreDrawListener(this.f53441g);
        ViewUtils.g(this.f53438c, 4);
        if (this.f53438c.getParent() != null) {
            ((View) this.f53438c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f53438c.getViewTreeObserver().removeOnPreDrawListener(this.f53441g);
        ViewUtils.g(this.f53438c, 0);
        g(this.f53438c, null);
        if (this.f53438c.getParent() != null) {
            ((View) this.f53438c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        CanvasUtils.a(canvas, true);
        canvas.setMatrix(this.f53440f);
        ViewUtils.g(this.f53438c, 0);
        this.f53438c.invalidate();
        ViewUtils.g(this.f53438c, 4);
        drawChild(canvas, this.f53438c, getDrawingTime());
        CanvasUtils.a(canvas, false);
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (e(this.f53438c) == this) {
            ViewUtils.g(this.f53438c, i3 == 0 ? 4 : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
    }
}
