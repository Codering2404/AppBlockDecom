package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    public static /* synthetic */ void v(Runnable runnable, Transition transition, Runnable runnable2) {
        if (runnable != null) {
            runnable.run();
        } else {
            transition.cancel();
            runnable2.run();
        }
    }

    private static boolean w(Transition transition) {
        return (FragmentTransitionImpl.i(transition.F()) && FragmentTransitionImpl.i(transition.G()) && FragmentTransitionImpl.i(transition.H())) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void b(Object obj, ArrayList arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i3 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iU0 = transitionSet.u0();
            while (i3 < iU0) {
                b(transitionSet.t0(i3), arrayList);
                i3++;
            }
            return;
        }
        if (w(transition) || !FragmentTransitionImpl.i(transition.I())) {
            return;
        }
        int size = arrayList.size();
        while (i3 < size) {
            transition.b((View) arrayList.get(i3));
            i3++;
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.b(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object j(Object obj, Object obj2, Object obj3) {
        Transition transitionB0 = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (transitionB0 != null && transition != null) {
            transitionB0 = new TransitionSet().r0(transitionB0).r0(transition).B0(1);
        } else if (transitionB0 == null) {
            transitionB0 = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return transitionB0;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transitionB0 != null) {
            transitionSet.r0(transitionB0);
        }
        transitionSet.r0(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object k(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.r0((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.r0((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.r0((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void m(Object obj, final View view, final ArrayList arrayList) {
        ((Transition) obj).a(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.2
            @Override // androidx.transition.Transition.TransitionListener
            public void c(Transition transition) {
                transition.b0(this);
                transition.a(this);
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void f(Transition transition) {
                transition.b0(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((View) arrayList.get(i3)).setVisibility(0);
                }
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void b(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void d(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void g(Transition transition) {
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void n(Object obj, final Object obj2, final ArrayList arrayList, final Object obj3, final ArrayList arrayList2, final Object obj4, final ArrayList arrayList3) {
        ((Transition) obj).a(new TransitionListenerAdapter() { // from class: androidx.transition.FragmentTransitionSupport.3
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void c(Transition transition) {
                Object obj5 = obj2;
                if (obj5 != null) {
                    FragmentTransitionSupport.this.x(obj5, arrayList, null);
                }
                Object obj6 = obj3;
                if (obj6 != null) {
                    FragmentTransitionSupport.this.x(obj6, arrayList2, null);
                }
                Object obj7 = obj4;
                if (obj7 != null) {
                    FragmentTransitionSupport.this.x(obj7, arrayList3, null);
                }
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void f(Transition transition) {
                transition.b0(this);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void o(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).i0(new Transition.EpicenterCallback() { // from class: androidx.transition.FragmentTransitionSupport.5
                @Override // androidx.transition.Transition.EpicenterCallback
                public Rect a(Transition transition) {
                    Rect rect2 = rect;
                    if (rect2 == null || rect2.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void p(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            h(view, rect);
            ((Transition) obj).i0(new Transition.EpicenterCallback() { // from class: androidx.transition.FragmentTransitionSupport.1
                @Override // androidx.transition.Transition.EpicenterCallback
                public Rect a(Transition transition) {
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void q(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        y(fragment, obj, cancellationSignal, null, runnable);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void s(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List listI = transitionSet.I();
        listI.clear();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            FragmentTransitionImpl.d(listI, (View) arrayList.get(i3));
        }
        listI.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void t(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.I().clear();
            transitionSet.I().addAll(arrayList2);
            x(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.r0((Transition) obj);
        return transitionSet;
    }

    public void x(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        Transition transition = (Transition) obj;
        int i3 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iU0 = transitionSet.u0();
            while (i3 < iU0) {
                x(transitionSet.t0(i3), arrayList, arrayList2);
                i3++;
            }
            return;
        }
        if (w(transition)) {
            return;
        }
        List listI = transition.I();
        if (listI.size() == arrayList.size() && listI.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i3 < size) {
                transition.b((View) arrayList2.get(i3));
                i3++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.c0((View) arrayList.get(size2));
            }
        }
    }

    public void y(Fragment fragment, Object obj, CancellationSignal cancellationSignal, final Runnable runnable, final Runnable runnable2) {
        final Transition transition = (Transition) obj;
        cancellationSignal.c(new CancellationSignal.OnCancelListener() { // from class: androidx.transition.a
            @Override // androidx.core.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                FragmentTransitionSupport.v(runnable, transition, runnable2);
            }
        });
        transition.a(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.4
            @Override // androidx.transition.Transition.TransitionListener
            public void f(Transition transition2) {
                runnable2.run();
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void b(Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void c(Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void d(Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void g(Transition transition2) {
            }
        });
    }
}
