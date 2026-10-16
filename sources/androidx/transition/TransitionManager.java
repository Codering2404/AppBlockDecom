package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TransitionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Transition f53530a = new AutoTransition();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadLocal f53531b = new ThreadLocal();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static ArrayList f53532c = new ArrayList();

    public static void a(ViewGroup viewGroup) {
        b(viewGroup, null);
    }

    public static void b(ViewGroup viewGroup, Transition transition) {
        if (f53532c.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        f53532c.add(viewGroup);
        if (transition == null) {
            transition = f53530a;
        }
        Transition transitionClone = transition.clone();
        e(viewGroup, transitionClone);
        Scene.c(viewGroup, null);
        d(viewGroup, transitionClone);
    }

    static ArrayMap c() {
        ArrayMap arrayMap;
        WeakReference weakReference = (WeakReference) f53531b.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap arrayMap2 = new ArrayMap();
        f53531b.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    private static void d(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        MultiListener multiListener = new MultiListener(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(multiListener);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
    }

    private static void e(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = (ArrayList) c().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((Transition) obj).Y(viewGroup);
            }
        }
        if (transition != null) {
            transition.m(viewGroup, true);
        }
        Scene sceneB = Scene.b(viewGroup);
        if (sceneB != null) {
            sceneB.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Transition f53533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f53534b;

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.f53533a = transition;
            this.f53534b = viewGroup;
        }

        private void a() {
            this.f53534b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f53534b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!TransitionManager.f53532c.remove(this.f53534b)) {
                return true;
            }
            final ArrayMap arrayMapC = TransitionManager.c();
            ArrayList arrayList = (ArrayList) arrayMapC.get(this.f53534b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayMapC.put(this.f53534b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f53533a);
            this.f53533a.a(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionManager.MultiListener.1
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void f(Transition transition) {
                    ((ArrayList) arrayMapC.get(MultiListener.this.f53534b)).remove(transition);
                    transition.b0(this);
                }
            });
            int i3 = 0;
            this.f53533a.m(this.f53534b, false);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    ((Transition) obj).d0(this.f53534b);
                }
            }
            this.f53533a.Z(this.f53534b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            TransitionManager.f53532c.remove(this.f53534b);
            ArrayList arrayList = (ArrayList) TransitionManager.c().get(this.f53534b);
            if (arrayList != null && arrayList.size() > 0) {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((Transition) obj).d0(this.f53534b);
                }
            }
            this.f53533a.o(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
