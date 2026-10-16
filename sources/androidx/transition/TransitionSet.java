package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TransitionSet extends Transition {
    int T;
    ArrayList R = new ArrayList();
    private boolean S = true;
    boolean U = false;
    private int V = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransitionSetListener extends TransitionListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TransitionSet f53540a;

        TransitionSetListener(TransitionSet transitionSet) {
            this.f53540a = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void c(Transition transition) {
            TransitionSet transitionSet = this.f53540a;
            if (transitionSet.U) {
                return;
            }
            transitionSet.n0();
            this.f53540a.U = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void f(Transition transition) {
            TransitionSet transitionSet = this.f53540a;
            int i3 = transitionSet.T - 1;
            transitionSet.T = i3;
            if (i3 == 0) {
                transitionSet.U = false;
                transitionSet.s();
            }
            transition.b0(this);
        }
    }

    private void D0() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((Transition) obj).a(transitionSetListener);
        }
        this.T = this.R.size();
    }

    private void s0(Transition transition) {
        this.R.add(transition);
        transition.f53499s = this;
    }

    private int v0(long j3) {
        for (int i3 = 1; i3 < this.R.size(); i3++) {
            if (((Transition) this.R.get(i3)).M > j3) {
                return i3 - 1;
            }
        }
        return this.R.size() - 1;
    }

    public TransitionSet B0(int i3) {
        if (i3 == 0) {
            this.S = true;
            return this;
        }
        if (i3 == 1) {
            this.S = false;
            return this;
        }
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i3);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public TransitionSet m0(long j3) {
        return (TransitionSet) super.m0(j3);
    }

    @Override // androidx.transition.Transition
    boolean M() {
        for (int i3 = 0; i3 < this.R.size(); i3++) {
            if (((Transition) this.R.get(i3)).M()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public void Y(View view) {
        super.Y(view);
        int size = this.R.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Transition) this.R.get(i3)).Y(view);
        }
    }

    @Override // androidx.transition.Transition
    void a0() {
        this.K = 0L;
        TransitionListenerAdapter transitionListenerAdapter = new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.2
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void g(Transition transition) {
                TransitionSet.this.R.remove(transition);
                if (TransitionSet.this.M()) {
                    return;
                }
                TransitionSet.this.X(Transition.TransitionNotification.f53525c, false);
                TransitionSet transitionSet = TransitionSet.this;
                transitionSet.C = true;
                transitionSet.X(Transition.TransitionNotification.f53524b, false);
            }
        };
        for (int i3 = 0; i3 < this.R.size(); i3++) {
            Transition transition = (Transition) this.R.get(i3);
            transition.a(transitionListenerAdapter);
            transition.a0();
            long J = transition.J();
            if (this.S) {
                this.K = Math.max(this.K, J);
            } else {
                long j3 = this.K;
                transition.M = j3;
                this.K = j3 + J;
            }
        }
    }

    @Override // androidx.transition.Transition
    protected void cancel() {
        super.cancel();
        int size = this.R.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Transition) this.R.get(i3)).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void d0(View view) {
        super.d0(view);
        int size = this.R.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Transition) this.R.get(i3)).d0(view);
        }
    }

    @Override // androidx.transition.Transition
    protected void f0() {
        if (this.R.isEmpty()) {
            n0();
            s();
            return;
        }
        D0();
        int i3 = 0;
        if (this.S) {
            ArrayList arrayList = this.R;
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((Transition) obj).f0();
            }
            return;
        }
        for (int i4 = 1; i4 < this.R.size(); i4++) {
            Transition transition = (Transition) this.R.get(i4 - 1);
            final Transition transition2 = (Transition) this.R.get(i4);
            transition.a(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void f(Transition transition3) {
                    transition2.f0();
                    transition3.b0(this);
                }
            });
        }
        Transition transition3 = (Transition) this.R.get(0);
        if (transition3 != null) {
            transition3.f0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void g0(long r20, long r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = r22
            long r5 = r0.J()
            androidx.transition.TransitionSet r7 = r0.f53499s
            r8 = 0
            if (r7 == 0) goto L22
            int r7 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r7 >= 0) goto L18
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 < 0) goto Lc2
        L18:
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L22
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L22
            goto Lc2
        L22:
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r10 = 0
            r11 = 1
            if (r7 >= 0) goto L2a
            r12 = r11
            goto L2b
        L2a:
            r12 = r10
        L2b:
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 < 0) goto L33
            int r14 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r14 < 0) goto L3b
        L33:
            int r14 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r14 > 0) goto L42
            int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r14 <= 0) goto L42
        L3b:
            r0.C = r10
            androidx.transition.Transition$TransitionNotification r14 = androidx.transition.Transition.TransitionNotification.f53523a
            r0.X(r14, r12)
        L42:
            boolean r14 = r0.S
            if (r14 == 0) goto L5f
        L46:
            java.util.ArrayList r7 = r0.R
            int r7 = r7.size()
            if (r10 >= r7) goto L5c
            java.util.ArrayList r7 = r0.R
            java.lang.Object r7 = r7.get(r10)
            androidx.transition.Transition r7 = (androidx.transition.Transition) r7
            r7.g0(r1, r3)
            int r10 = r10 + 1
            goto L46
        L5c:
            r16 = r8
            goto La7
        L5f:
            int r10 = r0.v0(r3)
            if (r7 < 0) goto L8a
        L65:
            java.util.ArrayList r7 = r0.R
            int r7 = r7.size()
            if (r10 >= r7) goto L5c
            java.util.ArrayList r7 = r0.R
            java.lang.Object r7 = r7.get(r10)
            androidx.transition.Transition r7 = (androidx.transition.Transition) r7
            long r14 = r7.M
            r16 = r8
            long r8 = r1 - r14
            int r18 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r18 >= 0) goto L80
            goto La7
        L80:
            long r14 = r3 - r14
            r7.g0(r8, r14)
            int r10 = r10 + 1
            r8 = r16
            goto L65
        L8a:
            r16 = r8
        L8c:
            if (r10 < 0) goto La7
            java.util.ArrayList r7 = r0.R
            java.lang.Object r7 = r7.get(r10)
            androidx.transition.Transition r7 = (androidx.transition.Transition) r7
            long r8 = r7.M
            long r14 = r1 - r8
            long r8 = r3 - r8
            r7.g0(r14, r8)
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 < 0) goto La4
            goto La7
        La4:
            int r10 = r10 + (-1)
            goto L8c
        La7:
            androidx.transition.TransitionSet r7 = r0.f53499s
            if (r7 == 0) goto Lc2
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto Lb3
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 <= 0) goto Lb9
        Lb3:
            if (r13 >= 0) goto Lc2
            int r2 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r2 < 0) goto Lc2
        Lb9:
            if (r1 <= 0) goto Lbd
            r0.C = r11
        Lbd:
            androidx.transition.Transition$TransitionNotification r1 = androidx.transition.Transition.TransitionNotification.f53524b
            r0.X(r1, r12)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionSet.g0(long, long):void");
    }

    @Override // androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        if (O(transitionValues.f53546b)) {
            ArrayList arrayList = this.R;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                Transition transition = (Transition) obj;
                if (transition.O(transitionValues.f53546b)) {
                    transition.h(transitionValues);
                    transitionValues.f53547c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void i0(Transition.EpicenterCallback epicenterCallback) {
        super.i0(epicenterCallback);
        this.V |= 8;
        int size = this.R.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Transition) this.R.get(i3)).i0(epicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    void j(TransitionValues transitionValues) {
        super.j(transitionValues);
        int size = this.R.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Transition) this.R.get(i3)).j(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        if (O(transitionValues.f53546b)) {
            ArrayList arrayList = this.R;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                Transition transition = (Transition) obj;
                if (transition.O(transitionValues.f53546b)) {
                    transition.k(transitionValues);
                    transitionValues.f53547c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void k0(PathMotion pathMotion) {
        super.k0(pathMotion);
        this.V |= 4;
        if (this.R != null) {
            for (int i3 = 0; i3 < this.R.size(); i3++) {
                ((Transition) this.R.get(i3)).k0(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void l0(TransitionPropagation transitionPropagation) {
        super.l0(transitionPropagation);
        this.V |= 2;
        int size = this.R.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Transition) this.R.get(i3)).l0(transitionPropagation);
        }
    }

    @Override // androidx.transition.Transition
    String o0(String str) {
        String strO0 = super.o0(str);
        for (int i3 = 0; i3 < this.R.size(); i3++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strO0);
            sb.append("\n");
            sb.append(((Transition) this.R.get(i3)).o0(str + "  "));
            strO0 = sb.toString();
        }
        return strO0;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: p */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.R = new ArrayList();
        int size = this.R.size();
        for (int i3 = 0; i3 < size; i3++) {
            transitionSet.s0(((Transition) this.R.get(i3)).clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public TransitionSet a(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.a(transitionListener);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public TransitionSet b(View view) {
        for (int i3 = 0; i3 < this.R.size(); i3++) {
            ((Transition) this.R.get(i3)).b(view);
        }
        return (TransitionSet) super.b(view);
    }

    @Override // androidx.transition.Transition
    void r(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList arrayList, ArrayList arrayList2) {
        long jE = E();
        int size = this.R.size();
        for (int i3 = 0; i3 < size; i3++) {
            Transition transition = (Transition) this.R.get(i3);
            if (jE > 0 && (this.S || i3 == 0)) {
                long jE2 = transition.E();
                if (jE2 > 0) {
                    transition.m0(jE2 + jE);
                } else {
                    transition.m0(jE);
                }
            }
            transition.r(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    public TransitionSet r0(Transition transition) {
        s0(transition);
        long j3 = this.f53484c;
        if (j3 >= 0) {
            transition.h0(j3);
        }
        if ((this.V & 1) != 0) {
            transition.j0(w());
        }
        if ((this.V & 2) != 0) {
            transition.l0(A());
        }
        if ((this.V & 4) != 0) {
            transition.k0(z());
        }
        if ((this.V & 8) != 0) {
            transition.i0(v());
        }
        return this;
    }

    public Transition t0(int i3) {
        if (i3 < 0 || i3 >= this.R.size()) {
            return null;
        }
        return (Transition) this.R.get(i3);
    }

    public int u0() {
        return this.R.size();
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public TransitionSet b0(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.b0(transitionListener);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public TransitionSet c0(View view) {
        for (int i3 = 0; i3 < this.R.size(); i3++) {
            ((Transition) this.R.get(i3)).c0(view);
        }
        return (TransitionSet) super.c0(view);
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public TransitionSet h0(long j3) {
        ArrayList arrayList;
        super.h0(j3);
        if (this.f53484c >= 0 && (arrayList = this.R) != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Transition) this.R.get(i3)).h0(j3);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public TransitionSet j0(TimeInterpolator timeInterpolator) {
        this.V |= 1;
        ArrayList arrayList = this.R;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Transition) this.R.get(i3)).j0(timeInterpolator);
            }
        }
        return (TransitionSet) super.j0(timeInterpolator);
    }
}
