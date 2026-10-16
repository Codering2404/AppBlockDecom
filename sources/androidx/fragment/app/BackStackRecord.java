package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final FragmentManager f37105t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f37106u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f37107v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f37108w;

    BackStackRecord(FragmentManager fragmentManager) {
        super(fragmentManager.B0(), fragmentManager.E0() != null ? fragmentManager.E0().f().getClassLoader() : null);
        this.f37107v = -1;
        this.f37108w = false;
        this.f37105t = fragmentManager;
    }

    void A() {
        int size = this.f37336c.size() - 1;
        while (size >= 0) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) this.f37336c.get(size);
            if (op.f37355c) {
                if (op.f37353a == 8) {
                    op.f37355c = false;
                    this.f37336c.remove(size - 1);
                    size--;
                } else {
                    int i3 = op.f37354b.mContainerId;
                    op.f37353a = 2;
                    op.f37355c = false;
                    for (int i4 = size - 1; i4 >= 0; i4--) {
                        FragmentTransaction.Op op2 = (FragmentTransaction.Op) this.f37336c.get(i4);
                        if (op2.f37355c && op2.f37354b.mContainerId == i3) {
                            this.f37336c.remove(i4);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    int B(boolean z2) {
        if (this.f37106u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            C("  ", printWriter);
            printWriter.close();
        }
        this.f37106u = true;
        if (this.f37342i) {
            this.f37107v = this.f37105t.n();
        } else {
            this.f37107v = -1;
        }
        this.f37105t.c0(this, z2);
        return this.f37107v;
    }

    public void C(String str, PrintWriter printWriter) {
        D(str, printWriter, true);
    }

    public void D(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f37344k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f37107v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f37106u);
            if (this.f37341h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f37341h));
            }
            if (this.f37337d != 0 || this.f37338e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f37337d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f37338e));
            }
            if (this.f37339f != 0 || this.f37340g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f37339f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f37340g));
            }
            if (this.f37345l != 0 || this.f37346m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f37345l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f37346m);
            }
            if (this.f37347n != 0 || this.f37348o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f37347n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f37348o);
            }
        }
        if (this.f37336c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f37336c.size();
        for (int i3 = 0; i3 < size; i3++) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) this.f37336c.get(i3);
            switch (op.f37353a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + op.f37353a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i3);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(op.f37354b);
            if (z2) {
                if (op.f37356d != 0 || op.f37357e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.f37356d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.f37357e));
                }
                if (op.f37358f != 0 || op.f37359g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.f37358f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.f37359g));
                }
            }
        }
    }

    void E() {
        int size = this.f37336c.size();
        for (int i3 = 0; i3 < size; i3++) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) this.f37336c.get(i3);
            Fragment fragment = op.f37354b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f37108w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f37341h);
                fragment.setSharedElementNames(this.f37349p, this.f37350q);
            }
            switch (op.f37353a) {
                case 1:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.C1(fragment, false);
                    this.f37105t.j(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f37353a);
                case 3:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.p1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.O0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.C1(fragment, false);
                    this.f37105t.J1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.A(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.C1(fragment, false);
                    this.f37105t.p(fragment);
                    break;
                case 8:
                    this.f37105t.H1(fragment);
                    break;
                case 9:
                    this.f37105t.H1(null);
                    break;
                case 10:
                    this.f37105t.G1(fragment, op.f37361i);
                    break;
            }
        }
    }

    void F() {
        for (int size = this.f37336c.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) this.f37336c.get(size);
            Fragment fragment = op.f37354b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f37108w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.w1(this.f37341h));
                fragment.setSharedElementNames(this.f37350q, this.f37349p);
            }
            switch (op.f37353a) {
                case 1:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.C1(fragment, true);
                    this.f37105t.p1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f37353a);
                case 3:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.J1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.C1(fragment, true);
                    this.f37105t.O0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.p(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.f37356d, op.f37357e, op.f37358f, op.f37359g);
                    this.f37105t.C1(fragment, true);
                    this.f37105t.A(fragment);
                    break;
                case 8:
                    this.f37105t.H1(null);
                    break;
                case 9:
                    this.f37105t.H1(fragment);
                    break;
                case 10:
                    this.f37105t.G1(fragment, op.f37360h);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment G(java.util.ArrayList r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList r5 = r0.f37336c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList r5 = r0.f37336c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.FragmentTransaction$Op r5 = (androidx.fragment.app.FragmentTransaction.Op) r5
            int r6 = r5.f37353a
            r7 = 1
            if (r6 == r7) goto Lb6
            r8 = 2
            r9 = 0
            r10 = 3
            r11 = 9
            if (r6 == r8) goto L5a
            if (r6 == r10) goto L43
            r8 = 6
            if (r6 == r8) goto L43
            r8 = 7
            if (r6 == r8) goto Lb6
            r8 = 8
            if (r6 == r8) goto L31
            goto Lbb
        L31:
            java.util.ArrayList r6 = r0.f37336c
            androidx.fragment.app.FragmentTransaction$Op r8 = new androidx.fragment.app.FragmentTransaction$Op
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.f37355c = r7
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.f37354b
            goto Lbb
        L43:
            androidx.fragment.app.Fragment r6 = r5.f37354b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.f37354b
            if (r5 != r3) goto Lbb
            java.util.ArrayList r3 = r0.f37336c
            androidx.fragment.app.FragmentTransaction$Op r6 = new androidx.fragment.app.FragmentTransaction$Op
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            androidx.fragment.app.Fragment r6 = r5.f37354b
            int r8 = r6.mContainerId
            int r12 = r1.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.mContainerId
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = r7
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList r3 = r0.f37336c
            androidx.fragment.app.FragmentTransaction$Op r15 = new androidx.fragment.app.FragmentTransaction$Op
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            androidx.fragment.app.FragmentTransaction$Op r15 = new androidx.fragment.app.FragmentTransaction$Op
            r15.<init>(r10, r14, r7)
            int r2 = r5.f37356d
            r15.f37356d = r2
            int r2 = r5.f37358f
            r15.f37358f = r2
            int r2 = r5.f37357e
            r15.f37357e = r2
            int r2 = r5.f37359g
            r15.f37359g = r2
            java.util.ArrayList r2 = r0.f37336c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList r2 = r0.f37336c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.f37353a = r7
            r5.f37355c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.Fragment r2 = r5.f37354b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.G(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    public String H() {
        return this.f37344k;
    }

    public void I() {
        if (this.f37352s != null) {
            for (int i3 = 0; i3 < this.f37352s.size(); i3++) {
                ((Runnable) this.f37352s.get(i3)).run();
            }
            this.f37352s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment J(java.util.ArrayList r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.f37336c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList r2 = r5.f37336c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.FragmentTransaction$Op r2 = (androidx.fragment.app.FragmentTransaction.Op) r2
            int r3 = r2.f37353a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.Lifecycle$State r3 = r2.f37360h
            r2.f37361i = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f37354b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f37354b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f37354b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.J(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f37342i) {
            return true;
        }
        this.f37105t.i(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.f37107v;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int j() {
        return B(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int k() {
        return B(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void l() {
        o();
        this.f37105t.f0(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void m() {
        o();
        this.f37105t.f0(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction n(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f37105t) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    void p(int i3, Fragment fragment, String str, int i4) {
        super.p(i3, fragment, str, i4);
        fragment.mFragmentManager = this.f37105t;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean q() {
        return this.f37336c.isEmpty();
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction r(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f37105t) {
            return super.r(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction v(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f37105t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f37105t);
        }
        if (state == Lifecycle.State.f39948b && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state != Lifecycle.State.f39947a) {
            return super.v(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction w(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.f37105t) {
            return super.w(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void z(int i3) {
        if (this.f37342i) {
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i3);
            }
            int size = this.f37336c.size();
            for (int i4 = 0; i4 < size; i4++) {
                FragmentTransaction.Op op = (FragmentTransaction.Op) this.f37336c.get(i4);
                Fragment fragment = op.f37354b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i3;
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + op.f37354b + " to " + op.f37354b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f37107v >= 0) {
            sb.append(" #");
            sb.append(this.f37107v);
        }
        if (this.f37344k != null) {
            sb.append(" ");
            sb.append(this.f37344k);
        }
        sb.append(YznnJpHcAmeoW.bQbQChKBAWgJcBN);
        return sb.toString();
    }

    BackStackRecord(BackStackRecord backStackRecord) {
        super(backStackRecord.f37105t.B0(), backStackRecord.f37105t.E0() != null ? backStackRecord.f37105t.E0().f().getClassLoader() : null, backStackRecord);
        this.f37107v = -1;
        this.f37108w = false;
        this.f37105t = backStackRecord.f37105t;
        this.f37106u = backStackRecord.f37106u;
        this.f37107v = backStackRecord.f37107v;
        this.f37108w = backStackRecord.f37108w;
    }
}
