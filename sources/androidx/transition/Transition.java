package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Transition implements Cloneable {
    private static final Animator[] N = new Animator[0];
    private static final int[] O = {2, 1, 3, 4};
    private static final PathMotion P = new PathMotion() { // from class: androidx.transition.Transition.1
        @Override // androidx.transition.PathMotion
        public Path a(float f3, float f4, float f5, float f6) {
            Path path = new Path();
            path.moveTo(f3, f4);
            path.lineTo(f5, f6);
            return path;
        }
    };
    private static ThreadLocal Q = new ThreadLocal();
    TransitionPropagation G;
    private EpicenterCallback H;
    private ArrayMap I;
    long K;
    SeekController L;
    long M;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList f53501u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList f53502v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TransitionListener[] f53503w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f53482a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f53483b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f53484c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TimeInterpolator f53485d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList f53486f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList f53487g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList f53488h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f53489i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f53490j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList f53491k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList f53492l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ArrayList f53493m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList f53494n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ArrayList f53495o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ArrayList f53496p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TransitionValuesMaps f53497q = new TransitionValuesMaps();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TransitionValuesMaps f53498r = new TransitionValuesMaps();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    TransitionSet f53499s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int[] f53500t = O;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f53504x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ArrayList f53505y = new ArrayList();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Animator[] f53506z = N;
    int A = 0;
    private boolean B = false;
    boolean C = false;
    private Transition D = null;
    private ArrayList E = null;
    ArrayList F = new ArrayList();
    private PathMotion J = P;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AnimationInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f53510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f53511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TransitionValues f53512c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        WindowId f53513d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Transition f53514e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Animator f53515f;

        AnimationInfo(View view, String str, Transition transition, WindowId windowId, TransitionValues transitionValues, Animator animator) {
            this.f53510a = view;
            this.f53511b = str;
            this.f53512c = transitionValues;
            this.f53513d = windowId;
            this.f53514e = transition;
            this.f53515f = animator;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ArrayListManager {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class EpicenterCallback {
        public abstract Rect a(Transition transition);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl26 {
        static long a(Animator animator) {
            return animator.getTotalDuration();
        }

        static void b(Animator animator, long j3) {
            ((AnimatorSet) animator).setCurrentPlayTime(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchOrder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class SeekController extends TransitionListenerAdapter implements TransitionSeekController, DynamicAnimation.OnAnimationUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f53516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList f53517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ArrayList f53518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f53519d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f53520f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Consumer[] f53521g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Transition f53522h;

        private void i() {
            ArrayList arrayList = this.f53518c;
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            int size = this.f53518c.size();
            if (this.f53521g == null) {
                this.f53521g = new Consumer[size];
            }
            Consumer[] consumerArr = (Consumer[]) this.f53518c.toArray(this.f53521g);
            this.f53521g = null;
            for (int i3 = 0; i3 < size; i3++) {
                consumerArr[i3].accept(this);
                consumerArr[i3] = null;
            }
            this.f53521g = consumerArr;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void a(DynamicAnimation dynamicAnimation, float f3, float f4) {
            long jMax = Math.max(-1L, Math.min(j() + 1, Math.round(f3)));
            this.f53522h.g0(jMax, this.f53516a);
            this.f53516a = jMax;
            i();
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void g(Transition transition) {
            this.f53520f = true;
        }

        public long j() {
            return this.f53522h.J();
        }

        void k() {
            long j3 = j() == 0 ? 1L : 0L;
            this.f53522h.g0(j3, this.f53516a);
            this.f53516a = j3;
        }

        public void l() {
            this.f53519d = true;
            ArrayList arrayList = this.f53517b;
            if (arrayList != null) {
                this.f53517b = null;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ((Consumer) arrayList.get(i3)).accept(this);
                }
            }
            i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TransitionListener {
        void b(Transition transition);

        void c(Transition transition);

        void d(Transition transition);

        default void e(Transition transition, boolean z2) {
            f(transition);
        }

        void f(Transition transition);

        void g(Transition transition);

        default void h(Transition transition, boolean z2) {
            c(transition);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface TransitionNotification {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TransitionNotification f53523a = new TransitionNotification() { // from class: androidx.transition.b
            @Override // androidx.transition.Transition.TransitionNotification
            public final void b(Transition.TransitionListener transitionListener, Transition transition, boolean z2) {
                transitionListener.h(transition, z2);
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TransitionNotification f53524b = new TransitionNotification() { // from class: androidx.transition.c
            @Override // androidx.transition.Transition.TransitionNotification
            public final void b(Transition.TransitionListener transitionListener, Transition transition, boolean z2) {
                transitionListener.e(transition, z2);
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final TransitionNotification f53525c = new TransitionNotification() { // from class: androidx.transition.d
            @Override // androidx.transition.Transition.TransitionNotification
            public final void b(Transition.TransitionListener transitionListener, Transition transition, boolean z2) {
                transitionListener.g(transition);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final TransitionNotification f53526d = new TransitionNotification() { // from class: androidx.transition.e
            @Override // androidx.transition.Transition.TransitionNotification
            public final void b(Transition.TransitionListener transitionListener, Transition transition, boolean z2) {
                transitionListener.d(transition);
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final TransitionNotification f53527e = new TransitionNotification() { // from class: androidx.transition.f
            @Override // androidx.transition.Transition.TransitionNotification
            public final void b(Transition.TransitionListener transitionListener, Transition transition, boolean z2) {
                transitionListener.b(transition);
            }
        };

        void b(TransitionListener transitionListener, Transition transition, boolean z2);
    }

    private static ArrayMap D() {
        ArrayMap arrayMap = (ArrayMap) Q.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap arrayMap2 = new ArrayMap();
        Q.set(arrayMap2);
        return arrayMap2;
    }

    private static boolean P(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.f53545a.get(str);
        Object obj2 = transitionValues2.f53545a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void Q(ArrayMap arrayMap, ArrayMap arrayMap2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) sparseArray.valueAt(i3);
            if (view2 != null && O(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i3))) != null && O(view)) {
                TransitionValues transitionValues = (TransitionValues) arrayMap.get(view2);
                TransitionValues transitionValues2 = (TransitionValues) arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f53501u.add(transitionValues);
                    this.f53502v.add(transitionValues2);
                    arrayMap.remove(view2);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void R(ArrayMap arrayMap, ArrayMap arrayMap2) {
        TransitionValues transitionValues;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View view = (View) arrayMap.f(size);
            if (view != null && O(view) && (transitionValues = (TransitionValues) arrayMap2.remove(view)) != null && O(transitionValues.f53546b)) {
                this.f53501u.add((TransitionValues) arrayMap.h(size));
                this.f53502v.add(transitionValues);
            }
        }
    }

    private void S(ArrayMap arrayMap, ArrayMap arrayMap2, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        View view;
        int iR = longSparseArray.r();
        for (int i3 = 0; i3 < iR; i3++) {
            View view2 = (View) longSparseArray.s(i3);
            if (view2 != null && O(view2) && (view = (View) longSparseArray2.g(longSparseArray.k(i3))) != null && O(view)) {
                TransitionValues transitionValues = (TransitionValues) arrayMap.get(view2);
                TransitionValues transitionValues2 = (TransitionValues) arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f53501u.add(transitionValues);
                    this.f53502v.add(transitionValues2);
                    arrayMap.remove(view2);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void U(ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3, ArrayMap arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) arrayMap3.j(i3);
            if (view2 != null && O(view2) && (view = (View) arrayMap4.get(arrayMap3.f(i3))) != null && O(view)) {
                TransitionValues transitionValues = (TransitionValues) arrayMap.get(view2);
                TransitionValues transitionValues2 = (TransitionValues) arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f53501u.add(transitionValues);
                    this.f53502v.add(transitionValues2);
                    arrayMap.remove(view2);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void V(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap arrayMap = new ArrayMap(transitionValuesMaps.f53548a);
        ArrayMap arrayMap2 = new ArrayMap(transitionValuesMaps2.f53548a);
        int i3 = 0;
        while (true) {
            int[] iArr = this.f53500t;
            if (i3 >= iArr.length) {
                c(arrayMap, arrayMap2);
                return;
            }
            int i4 = iArr[i3];
            if (i4 == 1) {
                R(arrayMap, arrayMap2);
            } else if (i4 == 2) {
                U(arrayMap, arrayMap2, transitionValuesMaps.f53551d, transitionValuesMaps2.f53551d);
            } else if (i4 == 3) {
                Q(arrayMap, arrayMap2, transitionValuesMaps.f53549b, transitionValuesMaps2.f53549b);
            } else if (i4 == 4) {
                S(arrayMap, arrayMap2, transitionValuesMaps.f53550c, transitionValuesMaps2.f53550c);
            }
            i3++;
        }
    }

    private void W(Transition transition, TransitionNotification transitionNotification, boolean z2) {
        Transition transition2 = this.D;
        if (transition2 != null) {
            transition2.W(transition, transitionNotification, z2);
        }
        ArrayList arrayList = this.E;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.E.size();
        TransitionListener[] transitionListenerArr = this.f53503w;
        if (transitionListenerArr == null) {
            transitionListenerArr = new TransitionListener[size];
        }
        this.f53503w = null;
        TransitionListener[] transitionListenerArr2 = (TransitionListener[]) this.E.toArray(transitionListenerArr);
        for (int i3 = 0; i3 < size; i3++) {
            transitionNotification.b(transitionListenerArr2[i3], transition, z2);
            transitionListenerArr2[i3] = null;
        }
        this.f53503w = transitionListenerArr2;
    }

    private void c(ArrayMap arrayMap, ArrayMap arrayMap2) {
        for (int i3 = 0; i3 < arrayMap.size(); i3++) {
            TransitionValues transitionValues = (TransitionValues) arrayMap.j(i3);
            if (O(transitionValues.f53546b)) {
                this.f53501u.add(transitionValues);
                this.f53502v.add(null);
            }
        }
        for (int i4 = 0; i4 < arrayMap2.size(); i4++) {
            TransitionValues transitionValues2 = (TransitionValues) arrayMap2.j(i4);
            if (O(transitionValues2.f53546b)) {
                this.f53502v.add(transitionValues2);
                this.f53501u.add(null);
            }
        }
    }

    private static void e(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f53548a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.f53549b.indexOfKey(id) >= 0) {
                transitionValuesMaps.f53549b.put(id, null);
            } else {
                transitionValuesMaps.f53549b.put(id, view);
            }
        }
        String strH = ViewCompat.H(view);
        if (strH != null) {
            if (transitionValuesMaps.f53551d.containsKey(strH)) {
                transitionValuesMaps.f53551d.put(strH, null);
            } else {
                transitionValuesMaps.f53551d.put(strH, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.f53550c.i(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    transitionValuesMaps.f53550c.m(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) transitionValuesMaps.f53550c.g(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    transitionValuesMaps.f53550c.m(itemIdAtPosition, null);
                }
            }
        }
    }

    private void e0(Animator animator, final ArrayMap arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.f53505y.remove(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.f53505y.add(animator2);
                }
            });
            g(animator);
        }
    }

    private void i(View view, boolean z2) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f53490j;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.f53491k;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f53492l;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (((Class) this.f53492l.get(i3)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    TransitionValues transitionValues = new TransitionValues(view);
                    if (z2) {
                        k(transitionValues);
                    } else {
                        h(transitionValues);
                    }
                    transitionValues.f53547c.add(this);
                    j(transitionValues);
                    if (z2) {
                        e(this.f53497q, view, transitionValues);
                    } else {
                        e(this.f53498r, view, transitionValues);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f53494n;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.f53495o;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.f53496p;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    if (((Class) this.f53496p.get(i4)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                                i(viewGroup.getChildAt(i5), z2);
                            }
                        }
                    }
                }
            }
        }
    }

    public TransitionPropagation A() {
        return this.G;
    }

    public final Transition B() {
        TransitionSet transitionSet = this.f53499s;
        return transitionSet != null ? transitionSet.B() : this;
    }

    public long E() {
        return this.f53483b;
    }

    public List F() {
        return this.f53486f;
    }

    public List G() {
        return this.f53488h;
    }

    public List H() {
        return this.f53489i;
    }

    public List I() {
        return this.f53487g;
    }

    final long J() {
        return this.K;
    }

    public String[] K() {
        return null;
    }

    public TransitionValues L(View view, boolean z2) {
        TransitionSet transitionSet = this.f53499s;
        if (transitionSet != null) {
            return transitionSet.L(view, z2);
        }
        return (TransitionValues) (z2 ? this.f53497q : this.f53498r).f53548a.get(view);
    }

    boolean M() {
        return !this.f53505y.isEmpty();
    }

    public boolean N(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues != null && transitionValues2 != null) {
            String[] strArrK = K();
            if (strArrK != null) {
                for (String str : strArrK) {
                    if (P(transitionValues, transitionValues2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = transitionValues.f53545a.keySet().iterator();
                while (it.hasNext()) {
                    if (P(transitionValues, transitionValues2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean O(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f53490j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.f53491k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f53492l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((Class) this.f53492l.get(i3)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f53493m != null && ViewCompat.H(view) != null && this.f53493m.contains(ViewCompat.H(view))) {
            return false;
        }
        if ((this.f53486f.size() == 0 && this.f53487g.size() == 0 && (((arrayList = this.f53489i) == null || arrayList.isEmpty()) && ((arrayList2 = this.f53488h) == null || arrayList2.isEmpty()))) || this.f53486f.contains(Integer.valueOf(id)) || this.f53487g.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f53488h;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.H(view))) {
            return true;
        }
        if (this.f53489i != null) {
            for (int i4 = 0; i4 < this.f53489i.size(); i4++) {
                if (((Class) this.f53489i.get(i4)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    void X(TransitionNotification transitionNotification, boolean z2) {
        W(this, transitionNotification, z2);
    }

    public void Y(View view) {
        if (this.C) {
            return;
        }
        int size = this.f53505y.size();
        Animator[] animatorArr = (Animator[]) this.f53505y.toArray(this.f53506z);
        this.f53506z = N;
        for (int i3 = size - 1; i3 >= 0; i3--) {
            Animator animator = animatorArr[i3];
            animatorArr[i3] = null;
            animator.pause();
        }
        this.f53506z = animatorArr;
        X(TransitionNotification.f53526d, false);
        this.B = true;
    }

    void Z(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        this.f53501u = new ArrayList();
        this.f53502v = new ArrayList();
        V(this.f53497q, this.f53498r);
        ArrayMap arrayMapD = D();
        int size = arrayMapD.size();
        WindowId windowId = viewGroup.getWindowId();
        for (int i3 = size - 1; i3 >= 0; i3--) {
            Animator animator = (Animator) arrayMapD.f(i3);
            if (animator != null && (animationInfo = (AnimationInfo) arrayMapD.get(animator)) != null && animationInfo.f53510a != null && windowId.equals(animationInfo.f53513d)) {
                TransitionValues transitionValues = animationInfo.f53512c;
                View view = animationInfo.f53510a;
                TransitionValues transitionValuesL = L(view, true);
                TransitionValues transitionValuesX = x(view, true);
                if (transitionValuesL == null && transitionValuesX == null) {
                    transitionValuesX = (TransitionValues) this.f53498r.f53548a.get(view);
                }
                if ((transitionValuesL != null || transitionValuesX != null) && animationInfo.f53514e.N(transitionValues, transitionValuesX)) {
                    Transition transition = animationInfo.f53514e;
                    if (transition.B().L != null) {
                        animator.cancel();
                        transition.f53505y.remove(animator);
                        arrayMapD.remove(animator);
                        if (transition.f53505y.size() == 0) {
                            transition.X(TransitionNotification.f53525c, false);
                            if (!transition.C) {
                                transition.C = true;
                                transition.X(TransitionNotification.f53524b, false);
                            }
                        }
                    } else if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        arrayMapD.remove(animator);
                    }
                }
            }
        }
        r(viewGroup, this.f53497q, this.f53498r, this.f53501u, this.f53502v);
        if (this.L == null) {
            f0();
        } else if (Build.VERSION.SDK_INT >= 34) {
            a0();
            this.L.k();
            this.L.l();
        }
    }

    public Transition a(TransitionListener transitionListener) {
        if (this.E == null) {
            this.E = new ArrayList();
        }
        this.E.add(transitionListener);
        return this;
    }

    void a0() {
        ArrayMap arrayMapD = D();
        this.K = 0L;
        for (int i3 = 0; i3 < this.F.size(); i3++) {
            Animator animator = (Animator) this.F.get(i3);
            AnimationInfo animationInfo = (AnimationInfo) arrayMapD.get(animator);
            if (animator != null && animationInfo != null) {
                if (t() >= 0) {
                    animationInfo.f53515f.setDuration(t());
                }
                if (E() >= 0) {
                    animationInfo.f53515f.setStartDelay(E() + animationInfo.f53515f.getStartDelay());
                }
                if (w() != null) {
                    animationInfo.f53515f.setInterpolator(w());
                }
                this.f53505y.add(animator);
                this.K = Math.max(this.K, Impl26.a(animator));
            }
        }
        this.F.clear();
    }

    public Transition b(View view) {
        this.f53487g.add(view);
        return this;
    }

    public Transition b0(TransitionListener transitionListener) {
        Transition transition;
        ArrayList arrayList = this.E;
        if (arrayList != null) {
            if (!arrayList.remove(transitionListener) && (transition = this.D) != null) {
                transition.b0(transitionListener);
            }
            if (this.E.size() == 0) {
                this.E = null;
            }
        }
        return this;
    }

    public Transition c0(View view) {
        this.f53487g.remove(view);
        return this;
    }

    protected void cancel() {
        int size = this.f53505y.size();
        Animator[] animatorArr = (Animator[]) this.f53505y.toArray(this.f53506z);
        this.f53506z = N;
        for (int i3 = size - 1; i3 >= 0; i3--) {
            Animator animator = animatorArr[i3];
            animatorArr[i3] = null;
            animator.cancel();
        }
        this.f53506z = animatorArr;
        X(TransitionNotification.f53525c, false);
    }

    public void d0(View view) {
        if (this.B) {
            if (!this.C) {
                int size = this.f53505y.size();
                Animator[] animatorArr = (Animator[]) this.f53505y.toArray(this.f53506z);
                this.f53506z = N;
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    Animator animator = animatorArr[i3];
                    animatorArr[i3] = null;
                    animator.resume();
                }
                this.f53506z = animatorArr;
                X(TransitionNotification.f53527e, false);
            }
            this.B = false;
        }
    }

    protected void f0() {
        n0();
        ArrayMap arrayMapD = D();
        ArrayList arrayList = this.F;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Animator animator = (Animator) obj;
            if (arrayMapD.containsKey(animator)) {
                n0();
                e0(animator, arrayMapD);
            }
        }
        this.F.clear();
        s();
    }

    protected void g(Animator animator) {
        if (animator == null) {
            s();
            return;
        }
        if (t() >= 0) {
            animator.setDuration(t());
        }
        if (E() >= 0) {
            animator.setStartDelay(E() + animator.getStartDelay());
        }
        if (w() != null) {
            animator.setInterpolator(w());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.s();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    void g0(long j3, long j4) {
        long J = J();
        int i3 = 0;
        boolean z2 = j3 < j4;
        if ((j4 < 0 && j3 >= 0) || (j4 > J && j3 <= J)) {
            this.C = false;
            X(TransitionNotification.f53523a, z2);
        }
        int size = this.f53505y.size();
        Animator[] animatorArr = (Animator[]) this.f53505y.toArray(this.f53506z);
        this.f53506z = N;
        while (i3 < size) {
            Animator animator = animatorArr[i3];
            animatorArr[i3] = null;
            Impl26.b(animator, Math.min(Math.max(0L, j3), Impl26.a(animator)));
            i3++;
            J = J;
        }
        long j5 = J;
        this.f53506z = animatorArr;
        if ((j3 <= j5 || j4 > j5) && (j3 >= 0 || j4 < 0)) {
            return;
        }
        if (j3 > j5) {
            this.C = true;
        }
        X(TransitionNotification.f53524b, z2);
    }

    public abstract void h(TransitionValues transitionValues);

    public Transition h0(long j3) {
        this.f53484c = j3;
        return this;
    }

    public void i0(EpicenterCallback epicenterCallback) {
        this.H = epicenterCallback;
    }

    void j(TransitionValues transitionValues) {
        String[] strArrB;
        if (this.G == null || transitionValues.f53545a.isEmpty() || (strArrB = this.G.b()) == null) {
            return;
        }
        for (String str : strArrB) {
            if (!transitionValues.f53545a.containsKey(str)) {
                this.G.a(transitionValues);
                return;
            }
        }
    }

    public Transition j0(TimeInterpolator timeInterpolator) {
        this.f53485d = timeInterpolator;
        return this;
    }

    public abstract void k(TransitionValues transitionValues);

    public void k0(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.J = P;
        } else {
            this.J = pathMotion;
        }
    }

    public void l0(TransitionPropagation transitionPropagation) {
        this.G = transitionPropagation;
    }

    void m(ViewGroup viewGroup, boolean z2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayMap arrayMap;
        o(z2);
        if ((this.f53486f.size() > 0 || this.f53487g.size() > 0) && (((arrayList = this.f53488h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f53489i) == null || arrayList2.isEmpty()))) {
            for (int i3 = 0; i3 < this.f53486f.size(); i3++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.f53486f.get(i3)).intValue());
                if (viewFindViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(viewFindViewById);
                    if (z2) {
                        k(transitionValues);
                    } else {
                        h(transitionValues);
                    }
                    transitionValues.f53547c.add(this);
                    j(transitionValues);
                    if (z2) {
                        e(this.f53497q, viewFindViewById, transitionValues);
                    } else {
                        e(this.f53498r, viewFindViewById, transitionValues);
                    }
                }
            }
            for (int i4 = 0; i4 < this.f53487g.size(); i4++) {
                View view = (View) this.f53487g.get(i4);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z2) {
                    k(transitionValues2);
                } else {
                    h(transitionValues2);
                }
                transitionValues2.f53547c.add(this);
                j(transitionValues2);
                if (z2) {
                    e(this.f53497q, view, transitionValues2);
                } else {
                    e(this.f53498r, view, transitionValues2);
                }
            }
        } else {
            i(viewGroup, z2);
        }
        if (z2 || (arrayMap = this.I) == null) {
            return;
        }
        int size = arrayMap.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList3.add((View) this.f53497q.f53551d.remove((String) this.I.f(i5)));
        }
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) arrayList3.get(i6);
            if (view2 != null) {
                this.f53497q.f53551d.put((String) this.I.j(i6), view2);
            }
        }
    }

    public Transition m0(long j3) {
        this.f53483b = j3;
        return this;
    }

    protected void n0() {
        if (this.A == 0) {
            X(TransitionNotification.f53523a, false);
            this.C = false;
        }
        this.A++;
    }

    void o(boolean z2) {
        if (z2) {
            this.f53497q.f53548a.clear();
            this.f53497q.f53549b.clear();
            this.f53497q.f53550c.b();
        } else {
            this.f53498r.f53548a.clear();
            this.f53498r.f53549b.clear();
            this.f53498r.f53550c.b();
        }
    }

    String o0(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f53484c != -1) {
            sb.append("dur(");
            sb.append(this.f53484c);
            sb.append(") ");
        }
        if (this.f53483b != -1) {
            sb.append("dly(");
            sb.append(this.f53483b);
            sb.append(") ");
        }
        if (this.f53485d != null) {
            sb.append("interp(");
            sb.append(this.f53485d);
            sb.append(") ");
        }
        if (this.f53486f.size() > 0 || this.f53487g.size() > 0) {
            sb.append("tgts(");
            if (this.f53486f.size() > 0) {
                for (int i3 = 0; i3 < this.f53486f.size(); i3++) {
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.f53486f.get(i3));
                }
            }
            if (this.f53487g.size() > 0) {
                for (int i4 = 0; i4 < this.f53487g.size(); i4++) {
                    if (i4 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.f53487g.get(i4));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // 
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.F = new ArrayList();
            transition.f53497q = new TransitionValuesMaps();
            transition.f53498r = new TransitionValuesMaps();
            transition.f53501u = null;
            transition.f53502v = null;
            transition.L = null;
            transition.D = this;
            transition.E = null;
            return transition;
        } catch (CloneNotSupportedException e3) {
            throw new RuntimeException(e3);
        }
    }

    public Animator q(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    void r(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList arrayList, ArrayList arrayList2) {
        Animator animatorQ;
        Animator animator;
        int i3;
        boolean z2;
        int i4;
        View view;
        TransitionValues transitionValues;
        Object obj;
        View view2;
        Animator animator2;
        ArrayMap arrayMapD = D();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        boolean z3 = B().L != null;
        long jMin = Long.MAX_VALUE;
        int i5 = 0;
        while (i5 < size) {
            TransitionValues transitionValues2 = (TransitionValues) arrayList.get(i5);
            TransitionValues transitionValues3 = (TransitionValues) arrayList2.get(i5);
            if (transitionValues2 != null && !transitionValues2.f53547c.contains(this)) {
                transitionValues2 = null;
            }
            if (transitionValues3 != null && !transitionValues3.f53547c.contains(this)) {
                transitionValues3 = null;
            }
            if (!(transitionValues2 == null && transitionValues3 == null) && ((transitionValues2 == null || transitionValues3 == null || N(transitionValues2, transitionValues3)) && (animatorQ = q(viewGroup, transitionValues2, transitionValues3)) != null)) {
                if (transitionValues3 != null) {
                    View view3 = transitionValues3.f53546b;
                    String[] strArrK = K();
                    if (strArrK != null && strArrK.length > 0) {
                        transitionValues = new TransitionValues(view3);
                        i3 = size;
                        z2 = z3;
                        TransitionValues transitionValues4 = (TransitionValues) transitionValuesMaps2.f53548a.get(view3);
                        i4 = i5;
                        if (transitionValues4 != null) {
                            int i6 = 0;
                            while (i6 < strArrK.length) {
                                Map map = transitionValues.f53545a;
                                int i7 = i6;
                                String str = strArrK[i7];
                                map.put(str, transitionValues4.f53545a.get(str));
                                i6 = i7 + 1;
                                strArrK = strArrK;
                            }
                        }
                        int size2 = arrayMapD.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size2) {
                                view2 = view3;
                                animator2 = animatorQ;
                                break;
                            }
                            AnimationInfo animationInfo = (AnimationInfo) arrayMapD.get((Animator) arrayMapD.f(i8));
                            if (animationInfo.f53512c != null && animationInfo.f53510a == view3) {
                                view2 = view3;
                                if (animationInfo.f53511b.equals(y()) && animationInfo.f53512c.equals(transitionValues)) {
                                    animator2 = null;
                                    break;
                                }
                            } else {
                                view2 = view3;
                            }
                            i8++;
                            view3 = view2;
                        }
                    } else {
                        view2 = view3;
                        i3 = size;
                        z2 = z3;
                        i4 = i5;
                        animator2 = animatorQ;
                        transitionValues = null;
                    }
                    animator = animator2;
                    view = view2;
                } else {
                    animator = animatorQ;
                    i3 = size;
                    z2 = z3;
                    i4 = i5;
                    view = transitionValues2.f53546b;
                    transitionValues = null;
                }
                if (animator != null) {
                    TransitionPropagation transitionPropagation = this.G;
                    if (transitionPropagation != null) {
                        long jC = transitionPropagation.c(viewGroup, this, transitionValues2, transitionValues3);
                        sparseIntArray.put(this.F.size(), (int) jC);
                        jMin = Math.min(jC, jMin);
                    }
                    long j3 = jMin;
                    View view4 = view;
                    TransitionValues transitionValues5 = transitionValues;
                    Animator animator3 = animator;
                    AnimationInfo animationInfo2 = new AnimationInfo(view4, y(), this, viewGroup.getWindowId(), transitionValues5, animator3);
                    if (z2) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.play(animator3);
                        obj = animatorSet;
                    } else {
                        obj = animator3;
                    }
                    arrayMapD.put(obj, animationInfo2);
                    this.F.add(obj);
                    jMin = j3;
                }
            } else {
                i3 = size;
                z2 = z3;
                i4 = i5;
            }
            i5 = i4 + 1;
            size = i3;
            z3 = z2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i9 = 0; i9 < sparseIntArray.size(); i9++) {
                AnimationInfo animationInfo3 = (AnimationInfo) arrayMapD.get((Animator) this.F.get(sparseIntArray.keyAt(i9)));
                animationInfo3.f53515f.setStartDelay((((long) sparseIntArray.valueAt(i9)) - jMin) + animationInfo3.f53515f.getStartDelay());
            }
        }
    }

    protected void s() {
        int i3 = this.A - 1;
        this.A = i3;
        if (i3 == 0) {
            X(TransitionNotification.f53524b, false);
            for (int i4 = 0; i4 < this.f53497q.f53550c.r(); i4++) {
                View view = (View) this.f53497q.f53550c.s(i4);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i5 = 0; i5 < this.f53498r.f53550c.r(); i5++) {
                View view2 = (View) this.f53498r.f53550c.s(i5);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.C = true;
        }
    }

    public long t() {
        return this.f53484c;
    }

    public String toString() {
        return o0("");
    }

    public Rect u() {
        EpicenterCallback epicenterCallback = this.H;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.a(this);
    }

    public EpicenterCallback v() {
        return this.H;
    }

    public TimeInterpolator w() {
        return this.f53485d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f53502v;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f53501u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return (androidx.transition.TransitionValues) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.transition.TransitionValues x(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            androidx.transition.TransitionSet r0 = r5.f53499s
            if (r0 == 0) goto L9
            androidx.transition.TransitionValues r6 = r0.x(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f53501u
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f53502v
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            androidx.transition.TransitionValues r4 = (androidx.transition.TransitionValues) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f53546b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList r6 = r5.f53502v
            goto L36
        L34:
            java.util.ArrayList r6 = r5.f53501u
        L36:
            java.lang.Object r6 = r6.get(r3)
            androidx.transition.TransitionValues r6 = (androidx.transition.TransitionValues) r6
            return r6
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.x(android.view.View, boolean):androidx.transition.TransitionValues");
    }

    public String y() {
        return this.f53482a;
    }

    public PathMotion z() {
        return this.J;
    }
}
