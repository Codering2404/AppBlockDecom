package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ViewTransitionController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MotionLayout f32971a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashSet f32973c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList f32975e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList f32972b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f32974d = "ViewTransitionController";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList f32976f = new ArrayList();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.f32971a = motionLayout;
    }

    private void f(final ViewTransition viewTransition, final boolean z2) {
        final int iH = viewTransition.h();
        final int iG = viewTransition.g();
        ConstraintLayout.getSharedValues().a(viewTransition.h(), new SharedValues.SharedValuesListener() { // from class: androidx.constraintlayout.motion.widget.ViewTransitionController.1
        });
    }

    private void j(ViewTransition viewTransition, View... viewArr) {
        int currentState = this.f32971a.getCurrentState();
        if (viewTransition.f32937e == 2) {
            viewTransition.c(this, this.f32971a, currentState, null, viewArr);
            return;
        }
        if (currentState != -1) {
            ConstraintSet constraintSetW = this.f32971a.W(currentState);
            if (constraintSetW == null) {
                return;
            }
            viewTransition.c(this, this.f32971a, currentState, constraintSetW, viewArr);
            return;
        }
        Log.w(this.f32974d, "No support for ViewTransition within transition yet. Currently: " + this.f32971a.toString());
    }

    public void a(ViewTransition viewTransition) {
        this.f32972b.add(viewTransition);
        this.f32973c = null;
        if (viewTransition.i() == 4) {
            f(viewTransition, true);
        } else if (viewTransition.i() == 5) {
            f(viewTransition, false);
        }
    }

    void b(ViewTransition.Animate animate) {
        if (this.f32975e == null) {
            this.f32975e = new ArrayList();
        }
        this.f32975e.add(animate);
    }

    void c() {
        ArrayList arrayList = this.f32975e;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((ViewTransition.Animate) obj).a();
        }
        this.f32975e.removeAll(this.f32976f);
        this.f32976f.clear();
        if (this.f32975e.isEmpty()) {
            this.f32975e = null;
        }
    }

    boolean d(int i3, MotionController motionController) {
        ArrayList arrayList = this.f32972b;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ViewTransition viewTransition = (ViewTransition) obj;
            if (viewTransition.e() == i3) {
                viewTransition.f32938f.a(motionController);
                return true;
            }
        }
        return false;
    }

    void e() {
        this.f32971a.invalidate();
    }

    void g(ViewTransition.Animate animate) {
        this.f32976f.add(animate);
    }

    void h(MotionEvent motionEvent) {
        int currentState = this.f32971a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        int i3 = 0;
        if (this.f32973c == null) {
            this.f32973c = new HashSet();
            ArrayList arrayList = this.f32972b;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                ViewTransition viewTransition = (ViewTransition) obj;
                int childCount = this.f32971a.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = this.f32971a.getChildAt(i5);
                    if (viewTransition.j(childAt)) {
                        childAt.getId();
                        this.f32973c.add(childAt);
                    }
                }
            }
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList arrayList2 = this.f32975e;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            ArrayList arrayList3 = this.f32975e;
            int size2 = arrayList3.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList3.get(i6);
                i6++;
                ((ViewTransition.Animate) obj2).d(action, x2, y2);
            }
        }
        if (action == 0 || action == 1) {
            ConstraintSet constraintSetW = this.f32971a.W(currentState);
            ArrayList arrayList4 = this.f32972b;
            int size3 = arrayList4.size();
            while (i3 < size3) {
                int i7 = i3 + 1;
                ViewTransition viewTransition2 = (ViewTransition) arrayList4.get(i3);
                if (viewTransition2.l(action)) {
                    for (View view : this.f32973c) {
                        if (viewTransition2.j(view)) {
                            view.getHitRect(rect);
                            if (rect.contains((int) x2, (int) y2)) {
                                viewTransition2.c(this, this.f32971a, currentState, constraintSetW, view);
                            }
                        }
                    }
                }
                i3 = i7;
            }
        }
    }

    void i(int i3, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f32972b;
        int size = arrayList2.size();
        ViewTransition viewTransition = null;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList2.get(i4);
            i4++;
            ViewTransition viewTransition2 = (ViewTransition) obj;
            if (viewTransition2.e() == i3) {
                for (View view : viewArr) {
                    if (viewTransition2.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    j(viewTransition2, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                viewTransition = viewTransition2;
            }
        }
        if (viewTransition == null) {
            Log.e(this.f32974d, " Could not find ViewTransition");
        }
    }
}
