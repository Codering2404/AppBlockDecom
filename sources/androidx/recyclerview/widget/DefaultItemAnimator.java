package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static TimeInterpolator f51552s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList f51553h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f51554i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f51555j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList f51556k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ArrayList f51557l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ArrayList f51558m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ArrayList f51559n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ArrayList f51560o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayList f51561p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList f51562q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    ArrayList f51563r = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MoveInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f51598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f51599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f51600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f51601d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f51602e;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i3, int i4, int i5, int i6) {
            this.f51598a = viewHolder;
            this.f51599b = i3;
            this.f51600c = i4;
            this.f51601d = i5;
            this.f51602e = i6;
        }
    }

    private void V(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f51562q.add(viewHolder);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                DefaultItemAnimator.this.H(viewHolder);
                DefaultItemAnimator.this.f51562q.remove(viewHolder);
                DefaultItemAnimator.this.X();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.I(viewHolder);
            }
        }).start();
    }

    private void Y(List list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = (ChangeInfo) list.get(size);
            if (a0(changeInfo, viewHolder) && changeInfo.f51592a == null && changeInfo.f51593b == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void Z(ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.f51592a;
        if (viewHolder != null) {
            a0(changeInfo, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.f51593b;
        if (viewHolder2 != null) {
            a0(changeInfo, viewHolder2);
        }
    }

    private boolean a0(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z2 = false;
        if (changeInfo.f51593b == viewHolder) {
            changeInfo.f51593b = null;
        } else {
            if (changeInfo.f51592a != viewHolder) {
                return false;
            }
            changeInfo.f51592a = null;
            z2 = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        D(viewHolder, z2);
        return true;
    }

    private void b0(RecyclerView.ViewHolder viewHolder) {
        if (f51552s == null) {
            f51552s = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f51552s);
        j(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean A(RecyclerView.ViewHolder viewHolder) {
        b0(viewHolder);
        this.f51553h.add(viewHolder);
        return true;
    }

    void S(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f51560o.add(viewHolder);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                DefaultItemAnimator.this.B(viewHolder);
                DefaultItemAnimator.this.f51560o.remove(viewHolder);
                DefaultItemAnimator.this.X();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.C(viewHolder);
            }
        }).start();
    }

    void T(final ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.f51592a;
        final View view = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.f51593b;
        final View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f51563r.add(changeInfo.f51592a);
            duration.translationX(changeInfo.f51596e - changeInfo.f51594c);
            duration.translationY(changeInfo.f51597f - changeInfo.f51595d);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    DefaultItemAnimator.this.D(changeInfo.f51592a, true);
                    DefaultItemAnimator.this.f51563r.remove(changeInfo.f51592a);
                    DefaultItemAnimator.this.X();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.E(changeInfo.f51592a, true);
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f51563r.add(changeInfo.f51593b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    DefaultItemAnimator.this.D(changeInfo.f51593b, false);
                    DefaultItemAnimator.this.f51563r.remove(changeInfo.f51593b);
                    DefaultItemAnimator.this.X();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.E(changeInfo.f51593b, false);
                }
            }).start();
        }
    }

    void U(final RecyclerView.ViewHolder viewHolder, int i3, int i4, int i5, int i6) {
        final View view = viewHolder.itemView;
        final int i7 = i5 - i3;
        final int i8 = i6 - i4;
        if (i7 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i8 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f51561p.add(viewHolder);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i7 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i8 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                DefaultItemAnimator.this.F(viewHolder);
                DefaultItemAnimator.this.f51561p.remove(viewHolder);
                DefaultItemAnimator.this.X();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.G(viewHolder);
            }
        }).start();
    }

    void W(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.ViewHolder) list.get(size)).itemView.animate().cancel();
        }
    }

    void X() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean g(RecyclerView.ViewHolder viewHolder, List list) {
        return !list.isEmpty() || super.g(viewHolder, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void j(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.f51555j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((MoveInfo) this.f51555j.get(size)).f51598a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                F(viewHolder);
                this.f51555j.remove(size);
            }
        }
        Y(this.f51556k, viewHolder);
        if (this.f51553h.remove(viewHolder)) {
            view.setAlpha(1.0f);
            H(viewHolder);
        }
        if (this.f51554i.remove(viewHolder)) {
            view.setAlpha(1.0f);
            B(viewHolder);
        }
        for (int size2 = this.f51559n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f51559n.get(size2);
            Y(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f51559n.remove(size2);
            }
        }
        for (int size3 = this.f51558m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f51558m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((MoveInfo) arrayList2.get(size4)).f51598a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    F(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f51558m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f51557l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f51557l.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                B(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f51557l.remove(size5);
                }
            }
        }
        this.f51562q.remove(viewHolder);
        this.f51560o.remove(viewHolder);
        this.f51563r.remove(viewHolder);
        this.f51561p.remove(viewHolder);
        X();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void k() {
        int size = this.f51555j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = (MoveInfo) this.f51555j.get(size);
            View view = moveInfo.f51598a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            F(moveInfo.f51598a);
            this.f51555j.remove(size);
        }
        for (int size2 = this.f51553h.size() - 1; size2 >= 0; size2--) {
            H((RecyclerView.ViewHolder) this.f51553h.get(size2));
            this.f51553h.remove(size2);
        }
        int size3 = this.f51554i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) this.f51554i.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            B(viewHolder);
            this.f51554i.remove(size3);
        }
        for (int size4 = this.f51556k.size() - 1; size4 >= 0; size4--) {
            Z((ChangeInfo) this.f51556k.get(size4));
        }
        this.f51556k.clear();
        if (p()) {
            for (int size5 = this.f51558m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f51558m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size6);
                    View view2 = moveInfo2.f51598a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    F(moveInfo2.f51598a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f51558m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f51557l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f51557l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) arrayList2.get(size8);
                    viewHolder2.itemView.setAlpha(1.0f);
                    B(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f51557l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f51559n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f51559n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    Z((ChangeInfo) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f51559n.remove(arrayList3);
                    }
                }
            }
            W(this.f51562q);
            W(this.f51561p);
            W(this.f51560o);
            W(this.f51563r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean p() {
        return (this.f51554i.isEmpty() && this.f51556k.isEmpty() && this.f51555j.isEmpty() && this.f51553h.isEmpty() && this.f51561p.isEmpty() && this.f51562q.isEmpty() && this.f51560o.isEmpty() && this.f51563r.isEmpty() && this.f51558m.isEmpty() && this.f51557l.isEmpty() && this.f51559n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void v() {
        boolean zIsEmpty = this.f51553h.isEmpty();
        boolean zIsEmpty2 = this.f51555j.isEmpty();
        boolean zIsEmpty3 = this.f51556k.isEmpty();
        boolean zIsEmpty4 = this.f51554i.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        ArrayList arrayList = this.f51553h;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            V((RecyclerView.ViewHolder) obj);
        }
        this.f51553h.clear();
        if (!zIsEmpty2) {
            final ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f51555j);
            this.f51558m.add(arrayList2);
            this.f51555j.clear();
            Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList3 = arrayList2;
                    int size2 = arrayList3.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        Object obj2 = arrayList3.get(i4);
                        i4++;
                        MoveInfo moveInfo = (MoveInfo) obj2;
                        DefaultItemAnimator.this.U(moveInfo.f51598a, moveInfo.f51599b, moveInfo.f51600c, moveInfo.f51601d, moveInfo.f51602e);
                    }
                    arrayList2.clear();
                    DefaultItemAnimator.this.f51558m.remove(arrayList2);
                }
            };
            if (zIsEmpty) {
                runnable.run();
            } else {
                ViewCompat.f0(((MoveInfo) arrayList2.get(0)).f51598a.itemView, runnable, o());
            }
        }
        if (!zIsEmpty3) {
            final ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(this.f51556k);
            this.f51559n.add(arrayList3);
            this.f51556k.clear();
            Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList4 = arrayList3;
                    int size2 = arrayList4.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        Object obj2 = arrayList4.get(i4);
                        i4++;
                        DefaultItemAnimator.this.T((ChangeInfo) obj2);
                    }
                    arrayList3.clear();
                    DefaultItemAnimator.this.f51559n.remove(arrayList3);
                }
            };
            if (zIsEmpty) {
                runnable2.run();
            } else {
                ViewCompat.f0(((ChangeInfo) arrayList3.get(0)).f51592a.itemView, runnable2, o());
            }
        }
        if (zIsEmpty4) {
            return;
        }
        final ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(this.f51554i);
        this.f51557l.add(arrayList4);
        this.f51554i.clear();
        Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList5 = arrayList4;
                int size2 = arrayList5.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayList5.get(i4);
                    i4++;
                    DefaultItemAnimator.this.S((RecyclerView.ViewHolder) obj2);
                }
                arrayList4.clear();
                DefaultItemAnimator.this.f51557l.remove(arrayList4);
            }
        };
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            runnable3.run();
        } else {
            ViewCompat.f0(((RecyclerView.ViewHolder) arrayList4.get(0)).itemView, runnable3, (!zIsEmpty ? o() : 0L) + Math.max(!zIsEmpty2 ? n() : 0L, zIsEmpty3 ? 0L : m()));
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean x(RecyclerView.ViewHolder viewHolder) {
        b0(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.f51554i.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean y(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i4, int i5, int i6) {
        if (viewHolder == viewHolder2) {
            return z(viewHolder, i3, i4, i5, i6);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        b0(viewHolder);
        int i7 = (int) ((i5 - i3) - translationX);
        int i8 = (int) ((i6 - i4) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            b0(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i7);
            viewHolder2.itemView.setTranslationY(-i8);
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.f51556k.add(new ChangeInfo(viewHolder, viewHolder2, i3, i4, i5, i6));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean z(RecyclerView.ViewHolder viewHolder, int i3, int i4, int i5, int i6) {
        View view = viewHolder.itemView;
        int translationX = i3 + ((int) view.getTranslationX());
        int translationY = i4 + ((int) viewHolder.itemView.getTranslationY());
        b0(viewHolder);
        int i7 = i5 - translationX;
        int i8 = i6 - translationY;
        if (i7 == 0 && i8 == 0) {
            F(viewHolder);
            return false;
        }
        if (i7 != 0) {
            view.setTranslationX(-i7);
        }
        if (i8 != 0) {
            view.setTranslationY(-i8);
        }
        this.f51555j.add(new MoveInfo(viewHolder, translationX, translationY, i5, i6));
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ChangeInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f51592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f51593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f51594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f51595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f51596e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f51597f;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f51592a = viewHolder;
            this.f51593b = viewHolder2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f51592a + ", newHolder=" + this.f51593b + ", fromX=" + this.f51594c + ", fromY=" + this.f51595d + ", toX=" + this.f51596e + ", toY=" + this.f51597f + '}';
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i4, int i5, int i6) {
            this(viewHolder, viewHolder2);
            this.f51594c = i3;
            this.f51595d = i4;
            this.f51596e = i5;
            this.f51597f = i6;
        }
    }
}
