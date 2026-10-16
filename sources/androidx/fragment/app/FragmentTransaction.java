package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentTransaction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentFactory f37334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassLoader f37335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList f37336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f37337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f37338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f37339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f37340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f37341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f37342i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f37343j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f37344k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f37345l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    CharSequence f37346m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f37347n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    CharSequence f37348o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayList f37349p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList f37350q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f37351r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ArrayList f37352s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Op {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f37353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Fragment f37354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f37355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f37356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f37357e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f37358f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f37359g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Lifecycle.State f37360h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Lifecycle.State f37361i;

        Op() {
        }

        Op(int i3, Fragment fragment) {
            this.f37353a = i3;
            this.f37354b = fragment;
            this.f37355c = false;
            Lifecycle.State state = Lifecycle.State.f39951f;
            this.f37360h = state;
            this.f37361i = state;
        }

        Op(int i3, Fragment fragment, boolean z2) {
            this.f37353a = i3;
            this.f37354b = fragment;
            this.f37355c = z2;
            Lifecycle.State state = Lifecycle.State.f39951f;
            this.f37360h = state;
            this.f37361i = state;
        }

        Op(int i3, Fragment fragment, Lifecycle.State state) {
            this.f37353a = i3;
            this.f37354b = fragment;
            this.f37355c = false;
            this.f37360h = fragment.mMaxState;
            this.f37361i = state;
        }

        Op(Op op) {
            this.f37353a = op.f37353a;
            this.f37354b = op.f37354b;
            this.f37355c = op.f37355c;
            this.f37356d = op.f37356d;
            this.f37357e = op.f37357e;
            this.f37358f = op.f37358f;
            this.f37359g = op.f37359g;
            this.f37360h = op.f37360h;
            this.f37361i = op.f37361i;
        }
    }

    FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.f37336c = new ArrayList();
        this.f37343j = true;
        this.f37351r = false;
        this.f37334a = fragmentFactory;
        this.f37335b = classLoader;
    }

    public FragmentTransaction b(int i3, Fragment fragment) {
        p(i3, fragment, null, 1);
        return this;
    }

    public FragmentTransaction c(int i3, Fragment fragment, String str) {
        p(i3, fragment, str, 1);
        return this;
    }

    FragmentTransaction d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public FragmentTransaction e(Fragment fragment, String str) {
        p(0, fragment, str, 1);
        return this;
    }

    void f(Op op) {
        this.f37336c.add(op);
        op.f37356d = this.f37337d;
        op.f37357e = this.f37338e;
        op.f37358f = this.f37339f;
        op.f37359g = this.f37340g;
    }

    public FragmentTransaction g(View view, String str) {
        if (!FragmentTransition.f()) {
            return this;
        }
        String strH = ViewCompat.H(view);
        if (strH == null) {
            throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        }
        if (this.f37349p == null) {
            this.f37349p = new ArrayList();
            this.f37350q = new ArrayList();
        } else {
            if (this.f37350q.contains(str)) {
                throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
            }
            if (this.f37349p.contains(strH)) {
                throw new IllegalArgumentException("A shared element with the source name '" + strH + "' has already been added to the transaction.");
            }
        }
        this.f37349p.add(strH);
        this.f37350q.add(str);
        return this;
    }

    public FragmentTransaction h(String str) {
        if (!this.f37343j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f37342i = true;
        this.f37344k = str;
        return this;
    }

    public FragmentTransaction i(Fragment fragment) {
        f(new Op(7, fragment));
        return this;
    }

    public abstract int j();

    public abstract int k();

    public abstract void l();

    public abstract void m();

    public FragmentTransaction n(Fragment fragment) {
        f(new Op(6, fragment));
        return this;
    }

    public FragmentTransaction o() {
        if (this.f37342i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f37343j = false;
        return this;
    }

    void p(int i3, Fragment fragment, String str, int i4) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.h(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i3 != 0) {
            if (i3 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i5 = fragment.mFragmentId;
            if (i5 != 0 && i5 != i3) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i3);
            }
            fragment.mFragmentId = i3;
            fragment.mContainerId = i3;
        }
        f(new Op(i4, fragment));
    }

    public boolean q() {
        return this.f37336c.isEmpty();
    }

    public FragmentTransaction r(Fragment fragment) {
        f(new Op(3, fragment));
        return this;
    }

    public FragmentTransaction s(int i3, Fragment fragment) {
        return t(i3, fragment, null);
    }

    public FragmentTransaction t(int i3, Fragment fragment, String str) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        p(i3, fragment, str, 2);
        return this;
    }

    public FragmentTransaction u(int i3, int i4, int i5, int i6) {
        this.f37337d = i3;
        this.f37338e = i4;
        this.f37339f = i5;
        this.f37340g = i6;
        return this;
    }

    public FragmentTransaction v(Fragment fragment, Lifecycle.State state) {
        f(new Op(10, fragment, state));
        return this;
    }

    public FragmentTransaction w(Fragment fragment) {
        f(new Op(8, fragment));
        return this;
    }

    public FragmentTransaction x(boolean z2) {
        this.f37351r = z2;
        return this;
    }

    public FragmentTransaction y(int i3) {
        this.f37341h = i3;
        return this;
    }

    FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader, FragmentTransaction fragmentTransaction) {
        this(fragmentFactory, classLoader);
        ArrayList arrayList = fragmentTransaction.f37336c;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            this.f37336c.add(new Op((Op) obj));
        }
        this.f37337d = fragmentTransaction.f37337d;
        this.f37338e = fragmentTransaction.f37338e;
        this.f37339f = fragmentTransaction.f37339f;
        this.f37340g = fragmentTransaction.f37340g;
        this.f37341h = fragmentTransaction.f37341h;
        this.f37342i = fragmentTransaction.f37342i;
        this.f37343j = fragmentTransaction.f37343j;
        this.f37344k = fragmentTransaction.f37344k;
        this.f37347n = fragmentTransaction.f37347n;
        this.f37348o = fragmentTransaction.f37348o;
        this.f37345l = fragmentTransaction.f37345l;
        this.f37346m = fragmentTransaction.f37346m;
        if (fragmentTransaction.f37349p != null) {
            ArrayList arrayList2 = new ArrayList();
            this.f37349p = arrayList2;
            arrayList2.addAll(fragmentTransaction.f37349p);
        }
        if (fragmentTransaction.f37350q != null) {
            ArrayList arrayList3 = new ArrayList();
            this.f37350q = arrayList3;
            arrayList3.addAll(fragmentTransaction.f37350q);
        }
        this.f37351r = fragmentTransaction.f37351r;
    }
}
