package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    private Rect A;
    private long B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List f51684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f51685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    RecyclerView.ViewHolder f51686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f51687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f51688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f51689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f51690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f51691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f51692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f51693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f51694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f51695l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Callback f51696m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f51697n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f51698o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    List f51699p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f51700q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    RecyclerView f51701r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final Runnable f51702s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    VelocityTracker f51703t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List f51704u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List f51705v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private RecyclerView.ChildDrawingOrderCallback f51706w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    View f51707x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f51708y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    GestureDetectorCompat f51709z;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.ItemTouchHelper$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ItemTouchHelper f51710a;

        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = this.f51710a;
            if (itemTouchHelper.f51686c == null || !itemTouchHelper.C()) {
                return;
            }
            ItemTouchHelper itemTouchHelper2 = this.f51710a;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper2.f51686c;
            if (viewHolder != null) {
                itemTouchHelper2.x(viewHolder);
            }
            ItemTouchHelper itemTouchHelper3 = this.f51710a;
            itemTouchHelper3.f51701r.removeCallbacks(itemTouchHelper3.f51702s);
            ViewCompat.e0(this.f51710a.f51701r, this);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.ItemTouchHelper$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements RecyclerView.OnItemTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ItemTouchHelper f51711a;

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            this.f51711a.f51709z.a(motionEvent);
            VelocityTracker velocityTracker = this.f51711a.f51703t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (this.f51711a.f51695l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f51711a.f51695l);
            if (iFindPointerIndex >= 0) {
                this.f51711a.n(actionMasked, motionEvent, iFindPointerIndex);
            }
            ItemTouchHelper itemTouchHelper = this.f51711a;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.f51686c;
            if (viewHolder == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (iFindPointerIndex >= 0) {
                        itemTouchHelper.F(motionEvent, itemTouchHelper.f51698o, iFindPointerIndex);
                        this.f51711a.x(viewHolder);
                        ItemTouchHelper itemTouchHelper2 = this.f51711a;
                        itemTouchHelper2.f51701r.removeCallbacks(itemTouchHelper2.f51702s);
                        this.f51711a.f51702s.run();
                        this.f51711a.f51701r.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    ItemTouchHelper itemTouchHelper3 = this.f51711a;
                    if (pointerId == itemTouchHelper3.f51695l) {
                        itemTouchHelper3.f51695l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        ItemTouchHelper itemTouchHelper4 = this.f51711a;
                        itemTouchHelper4.F(motionEvent, itemTouchHelper4.f51698o, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = itemTouchHelper.f51703t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            this.f51711a.D(null, 0);
            this.f51711a.f51695l = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            int iFindPointerIndex;
            RecoverAnimation recoverAnimationQ;
            this.f51711a.f51709z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f51711a.f51695l = motionEvent.getPointerId(0);
                this.f51711a.f51687d = motionEvent.getX();
                this.f51711a.f51688e = motionEvent.getY();
                this.f51711a.y();
                ItemTouchHelper itemTouchHelper = this.f51711a;
                if (itemTouchHelper.f51686c == null && (recoverAnimationQ = itemTouchHelper.q(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = this.f51711a;
                    itemTouchHelper2.f51687d -= recoverAnimationQ.f51733k;
                    itemTouchHelper2.f51688e -= recoverAnimationQ.f51734l;
                    itemTouchHelper2.p(recoverAnimationQ.f51728f, true);
                    if (this.f51711a.f51684a.remove(recoverAnimationQ.f51728f.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = this.f51711a;
                        itemTouchHelper3.f51696m.c(itemTouchHelper3.f51701r, recoverAnimationQ.f51728f);
                    }
                    this.f51711a.D(recoverAnimationQ.f51728f, recoverAnimationQ.f51729g);
                    ItemTouchHelper itemTouchHelper4 = this.f51711a;
                    itemTouchHelper4.F(motionEvent, itemTouchHelper4.f51698o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper5 = this.f51711a;
                itemTouchHelper5.f51695l = -1;
                itemTouchHelper5.D(null, 0);
            } else {
                int i3 = this.f51711a.f51695l;
                if (i3 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i3)) >= 0) {
                    this.f51711a.n(actionMasked, motionEvent, iFindPointerIndex);
                }
            }
            VelocityTracker velocityTracker = this.f51711a.f51703t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return this.f51711a.f51686c != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void e(boolean z2) {
            if (z2) {
                this.f51711a.D(null, 0);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.ItemTouchHelper$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass5 implements RecyclerView.ChildDrawingOrderCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ItemTouchHelper f51718a;

        @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
        public int a(int i3, int i4) {
            ItemTouchHelper itemTouchHelper = this.f51718a;
            View view = itemTouchHelper.f51707x;
            if (view != null) {
                int iIndexOfChild = itemTouchHelper.f51708y;
                if (iIndexOfChild == -1) {
                    iIndexOfChild = itemTouchHelper.f51701r.indexOfChild(view);
                    this.f51718a.f51708y = iIndexOfChild;
                }
                if (i4 == i3 - 1) {
                    return iIndexOfChild;
                }
                if (i4 >= iIndexOfChild) {
                    return i4 + 1;
                }
            }
            return i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f51722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ItemTouchHelper f51723b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewR;
            RecyclerView.ViewHolder viewHolderM0;
            if (!this.f51722a || (viewR = this.f51723b.r(motionEvent)) == null || (viewHolderM0 = this.f51723b.f51701r.m0(viewR)) == null) {
                return;
            }
            ItemTouchHelper itemTouchHelper = this.f51723b;
            if (itemTouchHelper.f51696m.o(itemTouchHelper.f51701r, viewHolderM0)) {
                int pointerId = motionEvent.getPointerId(0);
                int i3 = this.f51723b.f51695l;
                if (pointerId == i3) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = this.f51723b;
                    itemTouchHelper2.f51687d = x2;
                    itemTouchHelper2.f51688e = y2;
                    itemTouchHelper2.f51692i = 0.0f;
                    itemTouchHelper2.f51691h = 0.0f;
                    if (itemTouchHelper2.f51696m.r()) {
                        this.f51723b.D(viewHolderM0, 2);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SimpleCallback extends Callback {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f51739d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f51740e;

        public int C(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f51740e;
        }

        public int D(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f51739d;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int k(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return Callback.t(C(recyclerView, viewHolder), D(recyclerView, viewHolder));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ViewDropHandler {
        void f(View view, View view2, int i3, int i4);
    }

    private void A() {
        VelocityTracker velocityTracker = this.f51703t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f51703t = null;
        }
    }

    private int E(RecyclerView.ViewHolder viewHolder) {
        if (this.f51697n == 2) {
            return 0;
        }
        int iK = this.f51696m.k(this.f51701r, viewHolder);
        int iD = (this.f51696m.d(iK, ViewCompat.y(this.f51701r)) & 65280) >> 8;
        if (iD == 0) {
            return 0;
        }
        int i3 = (iK & 65280) >> 8;
        if (Math.abs(this.f51691h) > Math.abs(this.f51692i)) {
            int iM = m(viewHolder, iD);
            if (iM > 0) {
                return (i3 & iM) == 0 ? Callback.e(iM, ViewCompat.y(this.f51701r)) : iM;
            }
            int iO = o(viewHolder, iD);
            if (iO > 0) {
                return iO;
            }
        } else {
            int iO2 = o(viewHolder, iD);
            if (iO2 > 0) {
                return iO2;
            }
            int iM2 = m(viewHolder, iD);
            if (iM2 > 0) {
                return (i3 & iM2) == 0 ? Callback.e(iM2, ViewCompat.y(this.f51701r)) : iM2;
            }
        }
        return 0;
    }

    private int m(RecyclerView.ViewHolder viewHolder, int i3) {
        if ((i3 & 12) == 0) {
            return 0;
        }
        int i4 = this.f51691h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f51703t;
        if (velocityTracker != null && this.f51695l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f51696m.n(this.f51690g));
            float xVelocity = this.f51703t.getXVelocity(this.f51695l);
            float yVelocity = this.f51703t.getYVelocity(this.f51695l);
            int i5 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i5 & i3) != 0 && i4 == i5 && fAbs >= this.f51696m.l(this.f51689f) && fAbs > Math.abs(yVelocity)) {
                return i5;
            }
        }
        float width = this.f51701r.getWidth() * this.f51696m.m(viewHolder);
        if ((i3 & i4) == 0 || Math.abs(this.f51691h) <= width) {
            return 0;
        }
        return i4;
    }

    private int o(RecyclerView.ViewHolder viewHolder, int i3) {
        if ((i3 & 3) == 0) {
            return 0;
        }
        int i4 = this.f51692i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f51703t;
        if (velocityTracker != null && this.f51695l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f51696m.n(this.f51690g));
            float xVelocity = this.f51703t.getXVelocity(this.f51695l);
            float yVelocity = this.f51703t.getYVelocity(this.f51695l);
            int i5 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i5 & i3) != 0 && i5 == i4 && fAbs >= this.f51696m.l(this.f51689f) && fAbs > Math.abs(xVelocity)) {
                return i5;
            }
        }
        float height = this.f51701r.getHeight() * this.f51696m.m(viewHolder);
        if ((i3 & i4) == 0 || Math.abs(this.f51692i) <= height) {
            return 0;
        }
        return i4;
    }

    private List s(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List list = this.f51704u;
        if (list == null) {
            this.f51704u = new ArrayList();
            this.f51705v = new ArrayList();
        } else {
            list.clear();
            this.f51705v.clear();
        }
        int iH = this.f51696m.h();
        int iRound = Math.round(this.f51693j + this.f51691h) - iH;
        int iRound2 = Math.round(this.f51694k + this.f51692i) - iH;
        int i3 = iH * 2;
        int width = viewHolder2.itemView.getWidth() + iRound + i3;
        int height = viewHolder2.itemView.getHeight() + iRound2 + i3;
        int i4 = (iRound + width) / 2;
        int i5 = (iRound2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.f51701r.getLayoutManager();
        int iP = layoutManager.P();
        int i6 = 0;
        while (i6 < iP) {
            View viewO = layoutManager.O(i6);
            if (viewO != viewHolder2.itemView && viewO.getBottom() >= iRound2 && viewO.getTop() <= height && viewO.getRight() >= iRound && viewO.getLeft() <= width) {
                RecyclerView.ViewHolder viewHolderM0 = this.f51701r.m0(viewO);
                if (this.f51696m.a(this.f51701r, this.f51686c, viewHolderM0)) {
                    int iAbs = Math.abs(i4 - ((viewO.getLeft() + viewO.getRight()) / 2));
                    int iAbs2 = Math.abs(i5 - ((viewO.getTop() + viewO.getBottom()) / 2));
                    int i7 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.f51704u.size();
                    int i8 = 0;
                    for (int i9 = 0; i9 < size && i7 > ((Integer) this.f51705v.get(i9)).intValue(); i9++) {
                        i8++;
                    }
                    this.f51704u.add(i8, viewHolderM0);
                    this.f51705v.add(i8, Integer.valueOf(i7));
                }
            }
            i6++;
            viewHolder2 = viewHolder;
        }
        return this.f51704u;
    }

    private RecyclerView.ViewHolder t(MotionEvent motionEvent) {
        View viewR;
        RecyclerView.LayoutManager layoutManager = this.f51701r.getLayoutManager();
        int i3 = this.f51695l;
        if (i3 == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i3);
        float x2 = motionEvent.getX(iFindPointerIndex) - this.f51687d;
        float y2 = motionEvent.getY(iFindPointerIndex) - this.f51688e;
        float fAbs = Math.abs(x2);
        float fAbs2 = Math.abs(y2);
        int i4 = this.f51700q;
        if (fAbs < i4 && fAbs2 < i4) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.q()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.r()) && (viewR = r(motionEvent)) != null) {
            return this.f51701r.m0(viewR);
        }
        return null;
    }

    private void u(float[] fArr) {
        if ((this.f51698o & 12) != 0) {
            fArr[0] = (this.f51693j + this.f51691h) - this.f51686c.itemView.getLeft();
        } else {
            fArr[0] = this.f51686c.itemView.getTranslationX();
        }
        if ((this.f51698o & 3) != 0) {
            fArr[1] = (this.f51694k + this.f51692i) - this.f51686c.itemView.getTop();
        } else {
            fArr[1] = this.f51686c.itemView.getTranslationY();
        }
    }

    private static boolean w(View view, float f3, float f4, float f5, float f6) {
        return f3 >= f5 && f3 <= f5 + ((float) view.getWidth()) && f4 >= f6 && f4 <= f6 + ((float) view.getHeight());
    }

    void B(View view) {
        if (view == this.f51707x) {
            this.f51707x = null;
            if (this.f51706w != null) {
                this.f51701r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean C() {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.C():boolean");
    }

    void D(RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z2;
        float fSignum;
        float fSignum2;
        if (viewHolder == this.f51686c && i3 == this.f51697n) {
            return;
        }
        this.B = Long.MIN_VALUE;
        int i4 = this.f51697n;
        p(viewHolder, true);
        this.f51697n = i3;
        if (i3 == 2) {
            if (viewHolder == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.f51707x = viewHolder.itemView;
            l();
        }
        int i5 = (1 << ((i3 * 8) + 8)) - 1;
        final RecyclerView.ViewHolder viewHolder2 = this.f51686c;
        boolean z3 = false;
        if (viewHolder2 != null) {
            if (viewHolder2.itemView.getParent() != null) {
                final int iE = i4 == 2 ? 0 : E(viewHolder2);
                A();
                int i6 = 4;
                if (iE == 1 || iE == 2) {
                    fSignum = 0.0f;
                    fSignum2 = Math.signum(this.f51692i) * this.f51701r.getHeight();
                } else if (iE == 4 || iE == 8 || iE == 16 || iE == 32) {
                    fSignum2 = 0.0f;
                    fSignum = Math.signum(this.f51691h) * this.f51701r.getWidth();
                } else {
                    fSignum = 0.0f;
                    fSignum2 = 0.0f;
                }
                if (i4 == 2) {
                    i6 = 8;
                } else if (iE > 0) {
                    i6 = 2;
                }
                u(this.f51685b);
                float[] fArr = this.f51685b;
                float f3 = fArr[0];
                float f4 = fArr[1];
                z2 = false;
                RecoverAnimation recoverAnimation = new RecoverAnimation(viewHolder2, i6, i4, f3, f4, fSignum, fSignum2) { // from class: androidx.recyclerview.widget.ItemTouchHelper.3
                    @Override // androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.f51735m) {
                            return;
                        }
                        if (iE <= 0) {
                            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                            itemTouchHelper.f51696m.c(itemTouchHelper.f51701r, viewHolder2);
                        } else {
                            ItemTouchHelper.this.f51684a.add(viewHolder2.itemView);
                            this.f51732j = true;
                            int i7 = iE;
                            if (i7 > 0) {
                                ItemTouchHelper.this.z(this, i7);
                            }
                        }
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        View view = itemTouchHelper2.f51707x;
                        View view2 = viewHolder2.itemView;
                        if (view == view2) {
                            itemTouchHelper2.B(view2);
                        }
                    }
                };
                recoverAnimation.b(this.f51696m.g(this.f51701r, i6, fSignum - f3, fSignum2 - f4));
                this.f51699p.add(recoverAnimation);
                recoverAnimation.d();
                z3 = true;
            } else {
                z2 = false;
                B(viewHolder2.itemView);
                this.f51696m.c(this.f51701r, viewHolder2);
                z3 = false;
            }
            this.f51686c = null;
        } else {
            z2 = false;
        }
        if (viewHolder != null) {
            this.f51698o = (this.f51696m.f(this.f51701r, viewHolder) & i5) >> (this.f51697n * 8);
            this.f51693j = viewHolder.itemView.getLeft();
            this.f51694k = viewHolder.itemView.getTop();
            this.f51686c = viewHolder;
            if (i3 == 2) {
                viewHolder.itemView.performHapticFeedback(z2 ? 1 : 0);
            }
        }
        ViewParent parent = this.f51701r.getParent();
        if (parent != null) {
            if (this.f51686c != null) {
                z2 = true;
            }
            parent.requestDisallowInterceptTouchEvent(z2);
        }
        if (!z3) {
            this.f51701r.getLayoutManager().z1();
        }
        this.f51696m.A(this.f51686c, this.f51697n);
        this.f51701r.invalidate();
    }

    void F(MotionEvent motionEvent, int i3, int i4) {
        float x2 = motionEvent.getX(i4);
        float y2 = motionEvent.getY(i4);
        float f3 = x2 - this.f51687d;
        this.f51691h = f3;
        this.f51692i = y2 - this.f51688e;
        if ((i3 & 4) == 0) {
            this.f51691h = Math.max(0.0f, f3);
        }
        if ((i3 & 8) == 0) {
            this.f51691h = Math.min(0.0f, this.f51691h);
        }
        if ((i3 & 1) == 0) {
            this.f51692i = Math.max(0.0f, this.f51692i);
        }
        if ((i3 & 2) == 0) {
            this.f51692i = Math.min(0.0f, this.f51692i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void b(View view) {
        B(view);
        RecyclerView.ViewHolder viewHolderM0 = this.f51701r.m0(view);
        if (viewHolderM0 == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.f51686c;
        if (viewHolder != null && viewHolderM0 == viewHolder) {
            D(null, 0);
            return;
        }
        p(viewHolderM0, false);
        if (this.f51684a.remove(viewHolderM0.itemView)) {
            this.f51696m.c(this.f51701r, viewHolderM0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f3;
        float f4;
        this.f51708y = -1;
        if (this.f51686c != null) {
            u(this.f51685b);
            float[] fArr = this.f51685b;
            float f5 = fArr[0];
            f4 = fArr[1];
            f3 = f5;
        } else {
            f3 = 0.0f;
            f4 = 0.0f;
        }
        this.f51696m.w(canvas, recyclerView, this.f51686c, this.f51699p, this.f51697n, f3, f4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f3;
        float f4;
        if (this.f51686c != null) {
            u(this.f51685b);
            float[] fArr = this.f51685b;
            float f5 = fArr[0];
            f4 = fArr[1];
            f3 = f5;
        } else {
            f3 = 0.0f;
            f4 = 0.0f;
        }
        this.f51696m.x(canvas, recyclerView, this.f51686c, this.f51699p, this.f51697n, f3, f4);
    }

    void n(int i3, MotionEvent motionEvent, int i4) {
        RecyclerView.ViewHolder viewHolderT;
        int iF;
        if (this.f51686c != null || i3 != 2 || this.f51697n == 2 || !this.f51696m.q() || this.f51701r.getScrollState() == 1 || (viewHolderT = t(motionEvent)) == null || (iF = (this.f51696m.f(this.f51701r, viewHolderT) & 65280) >> 8) == 0) {
            return;
        }
        float x2 = motionEvent.getX(i4);
        float y2 = motionEvent.getY(i4);
        float f3 = x2 - this.f51687d;
        float f4 = y2 - this.f51688e;
        float fAbs = Math.abs(f3);
        float fAbs2 = Math.abs(f4);
        int i5 = this.f51700q;
        if (fAbs >= i5 || fAbs2 >= i5) {
            if (fAbs > fAbs2) {
                if (f3 < 0.0f && (iF & 4) == 0) {
                    return;
                }
                if (f3 > 0.0f && (iF & 8) == 0) {
                    return;
                }
            } else {
                if (f4 < 0.0f && (iF & 1) == 0) {
                    return;
                }
                if (f4 > 0.0f && (iF & 2) == 0) {
                    return;
                }
            }
            this.f51692i = 0.0f;
            this.f51691h = 0.0f;
            this.f51695l = motionEvent.getPointerId(0);
            D(viewHolderT, 1);
        }
    }

    void p(RecyclerView.ViewHolder viewHolder, boolean z2) {
        for (int size = this.f51699p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) this.f51699p.get(size);
            if (recoverAnimation.f51728f == viewHolder) {
                recoverAnimation.f51735m |= z2;
                if (!recoverAnimation.f51736n) {
                    recoverAnimation.a();
                }
                this.f51699p.remove(size);
                return;
            }
        }
    }

    RecoverAnimation q(MotionEvent motionEvent) {
        if (this.f51699p.isEmpty()) {
            return null;
        }
        View viewR = r(motionEvent);
        for (int size = this.f51699p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) this.f51699p.get(size);
            if (recoverAnimation.f51728f.itemView == viewR) {
                return recoverAnimation;
            }
        }
        return null;
    }

    View r(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f51686c;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (w(view, x2, y2, this.f51693j + this.f51691h, this.f51694k + this.f51692i)) {
                return view;
            }
        }
        for (int size = this.f51699p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) this.f51699p.get(size);
            View view2 = recoverAnimation.f51728f.itemView;
            if (w(view2, x2, y2, recoverAnimation.f51733k, recoverAnimation.f51734l)) {
                return view2;
            }
        }
        return this.f51701r.X(x2, y2);
    }

    boolean v() {
        int size = this.f51699p.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!((RecoverAnimation) this.f51699p.get(i3)).f51736n) {
                return true;
            }
        }
        return false;
    }

    void x(RecyclerView.ViewHolder viewHolder) {
        if (!this.f51701r.isLayoutRequested() && this.f51697n == 2) {
            float fJ = this.f51696m.j(viewHolder);
            int i3 = (int) (this.f51693j + this.f51691h);
            int i4 = (int) (this.f51694k + this.f51692i);
            if (Math.abs(i4 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * fJ || Math.abs(i3 - viewHolder.itemView.getLeft()) >= viewHolder.itemView.getWidth() * fJ) {
                List listS = s(viewHolder);
                if (listS.size() == 0) {
                    return;
                }
                RecyclerView.ViewHolder viewHolderB = this.f51696m.b(viewHolder, listS, i3, i4);
                if (viewHolderB == null) {
                    this.f51704u.clear();
                    this.f51705v.clear();
                    return;
                }
                int absoluteAdapterPosition = viewHolderB.getAbsoluteAdapterPosition();
                int absoluteAdapterPosition2 = viewHolder.getAbsoluteAdapterPosition();
                if (this.f51696m.y(this.f51701r, viewHolder, viewHolderB)) {
                    this.f51696m.z(this.f51701r, viewHolder, absoluteAdapterPosition2, viewHolderB, absoluteAdapterPosition, i3, i4);
                }
            }
        }
    }

    void y() {
        VelocityTracker velocityTracker = this.f51703t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f51703t = VelocityTracker.obtain();
    }

    void z(final RecoverAnimation recoverAnimation, final int i3) {
        this.f51701r.post(new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.f51701r;
                if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                RecoverAnimation recoverAnimation2 = recoverAnimation;
                if (recoverAnimation2.f51735m || recoverAnimation2.f51728f.getAbsoluteAdapterPosition() == -1) {
                    return;
                }
                RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.f51701r.getItemAnimator();
                if ((itemAnimator == null || !itemAnimator.q(null)) && !ItemTouchHelper.this.v()) {
                    ItemTouchHelper.this.f51696m.B(recoverAnimation.f51728f, i3);
                } else {
                    ItemTouchHelper.this.f51701r.post(this);
                }
            }
        });
    }

    private void l() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Interpolator f51719b = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f3) {
                return f3 * f3 * f3 * f3 * f3;
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Interpolator f51720c = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f3) {
                float f4 = f3 - 1.0f;
                return (f4 * f4 * f4 * f4 * f4) + 1.0f;
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f51721a;

        public static int e(int i3, int i4) {
            int i5;
            int i6 = i3 & 789516;
            if (i6 == 0) {
                return i3;
            }
            int i7 = i3 & (~i6);
            if (i4 == 0) {
                i5 = i6 << 2;
            } else {
                int i8 = i6 << 1;
                i7 |= (-789517) & i8;
                i5 = (i8 & 789516) << 2;
            }
            return i7 | i5;
        }

        private int i(RecyclerView recyclerView) {
            if (this.f51721a == -1) {
                this.f51721a = recyclerView.getResources().getDimensionPixelSize(R.dimen.f51444d);
            }
            return this.f51721a;
        }

        public static int s(int i3, int i4) {
            return i4 << (i3 * 8);
        }

        public static int t(int i3, int i4) {
            return s(2, i3) | s(1, i4) | s(0, i4 | i3);
        }

        public void A(RecyclerView.ViewHolder viewHolder, int i3) {
            if (viewHolder != null) {
                ItemTouchUIUtilImpl.f51741a.b(viewHolder.itemView);
            }
        }

        public abstract void B(RecyclerView.ViewHolder viewHolder, int i3);

        public boolean a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder b(RecyclerView.ViewHolder viewHolder, List list, int i3, int i4) {
            int bottom;
            int iAbs;
            int top;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int iAbs4;
            int width = viewHolder.itemView.getWidth() + i3;
            int height = i4 + viewHolder.itemView.getHeight();
            int left2 = i3 - viewHolder.itemView.getLeft();
            int top2 = i4 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i5 = -1;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView.ViewHolder viewHolder3 = (RecyclerView.ViewHolder) list.get(i6);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (iAbs4 = Math.abs(right)) > i5) {
                    viewHolder2 = viewHolder3;
                    i5 = iAbs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i3) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (iAbs3 = Math.abs(left)) > i5) {
                    viewHolder2 = viewHolder3;
                    i5 = iAbs3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i4) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (iAbs2 = Math.abs(top)) > i5) {
                    viewHolder2 = viewHolder3;
                    i5 = iAbs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (iAbs = Math.abs(bottom)) > i5) {
                    viewHolder2 = viewHolder3;
                    i5 = iAbs;
                }
            }
            return viewHolder2;
        }

        public void c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.f51741a.a(viewHolder.itemView);
        }

        public int d(int i3, int i4) {
            int i5;
            int i6 = i3 & 3158064;
            if (i6 == 0) {
                return i3;
            }
            int i7 = i3 & (~i6);
            if (i4 == 0) {
                i5 = i6 >> 2;
            } else {
                int i8 = i6 >> 1;
                i7 |= (-3158065) & i8;
                i5 = (i8 & 3158064) >> 2;
            }
            return i7 | i5;
        }

        final int f(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return d(k(recyclerView, viewHolder), ViewCompat.y(recyclerView));
        }

        public long g(RecyclerView recyclerView, int i3, float f3, float f4) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i3 == 8 ? 200L : 250L : i3 == 8 ? itemAnimator.n() : itemAnimator.o();
        }

        public int h() {
            return 0;
        }

        public float j(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int k(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float m(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        boolean o(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (f(recyclerView, viewHolder) & 16711680) != 0;
        }

        public int p(RecyclerView recyclerView, int i3, int i4, int i5, long j3) {
            int iSignum = (int) (((int) (((int) Math.signum(i4)) * i(recyclerView) * f51720c.getInterpolation(Math.min(1.0f, (Math.abs(i4) * 1.0f) / i3)))) * f51719b.getInterpolation(j3 <= 2000 ? j3 / 2000.0f : 1.0f));
            return iSignum == 0 ? i4 > 0 ? 1 : -1 : iSignum;
        }

        public boolean q() {
            return true;
        }

        public boolean r() {
            return true;
        }

        public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f3, float f4, int i3, boolean z2) {
            ItemTouchUIUtilImpl.f51741a.c(canvas, recyclerView, viewHolder.itemView, f3, f4, i3, z2);
        }

        public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f3, float f4, int i3, boolean z2) {
            ItemTouchUIUtilImpl.f51741a.d(canvas, recyclerView, viewHolder.itemView, f3, f4, i3, z2);
        }

        void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List list, int i3, float f3, float f4) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                RecoverAnimation recoverAnimation = (RecoverAnimation) list.get(i4);
                recoverAnimation.e();
                int iSave = canvas.save();
                u(canvas, recyclerView, recoverAnimation.f51728f, recoverAnimation.f51733k, recoverAnimation.f51734l, recoverAnimation.f51729g, false);
                canvas.restoreToCount(iSave);
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                u(canvas, recyclerView, viewHolder, f3, f4, i3, true);
                canvas.restoreToCount(iSave2);
            }
        }

        void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List list, int i3, float f3, float f4) {
            int size = list.size();
            boolean z2 = false;
            for (int i4 = 0; i4 < size; i4++) {
                RecoverAnimation recoverAnimation = (RecoverAnimation) list.get(i4);
                int iSave = canvas.save();
                v(canvas, recyclerView, recoverAnimation.f51728f, recoverAnimation.f51733k, recoverAnimation.f51734l, recoverAnimation.f51729g, false);
                canvas.restoreToCount(iSave);
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                v(canvas, recyclerView, viewHolder, f3, f4, i3, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i5 = size - 1; i5 >= 0; i5--) {
                RecoverAnimation recoverAnimation2 = (RecoverAnimation) list.get(i5);
                boolean z3 = recoverAnimation2.f51736n;
                if (z3 && !recoverAnimation2.f51732j) {
                    list.remove(i5);
                } else if (!z3) {
                    z2 = true;
                }
            }
            if (z2) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void z(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i3, RecyclerView.ViewHolder viewHolder2, int i4, int i5, int i6) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).f(viewHolder.itemView, viewHolder2.itemView, i5, i6);
                return;
            }
            if (layoutManager.q()) {
                if (layoutManager.W(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.u1(i4);
                }
                if (layoutManager.Z(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.u1(i4);
                }
            }
            if (layoutManager.r()) {
                if (layoutManager.a0(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.u1(i4);
                }
                if (layoutManager.U(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.u1(i4);
                }
            }
        }

        public float l(float f3) {
            return f3;
        }

        public float n(float f3) {
            return f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RecoverAnimation implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f51724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f51725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f51726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f51727d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final RecyclerView.ViewHolder f51728f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f51729g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final ValueAnimator f51730h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final int f51731i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f51732j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f51733k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f51734l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f51735m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f51736n = false;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private float f51737o;

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i3, int i4, float f3, float f4, float f5, float f6) {
            this.f51729g = i4;
            this.f51731i = i3;
            this.f51728f = viewHolder;
            this.f51724a = f3;
            this.f51725b = f4;
            this.f51726c = f5;
            this.f51727d = f6;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f51730h = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.c(valueAnimator.getAnimatedFraction());
                }
            });
            valueAnimatorOfFloat.setTarget(viewHolder.itemView);
            valueAnimatorOfFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f51730h.cancel();
        }

        public void b(long j3) {
            this.f51730h.setDuration(j3);
        }

        public void c(float f3) {
            this.f51737o = f3;
        }

        public void d() {
            this.f51728f.setIsRecyclable(false);
            this.f51730h.start();
        }

        public void e() {
            float f3 = this.f51724a;
            float f4 = this.f51726c;
            if (f3 == f4) {
                this.f51733k = this.f51728f.itemView.getTranslationX();
            } else {
                this.f51733k = f3 + (this.f51737o * (f4 - f3));
            }
            float f5 = this.f51725b;
            float f6 = this.f51727d;
            if (f5 == f6) {
                this.f51734l = this.f51728f.itemView.getTranslationY();
            } else {
                this.f51734l = f5 + (this.f51737o * (f6 - f5));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f51736n) {
                this.f51728f.setIsRecyclable(true);
            }
            this.f51736n = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void d(View view) {
    }
}
