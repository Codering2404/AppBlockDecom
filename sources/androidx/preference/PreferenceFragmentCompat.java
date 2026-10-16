package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PreferenceFragmentCompat extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PreferenceManager f50886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    RecyclerView f50887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f50888d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f50889f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f50891h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DividerDecoration f50885a = new DividerDecoration();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f50890g = R.layout.f50985c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f50892i = new Handler(Looper.getMainLooper()) { // from class: androidx.preference.PreferenceFragmentCompat.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PreferenceFragmentCompat.this.w();
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f50893j = new Runnable() { // from class: androidx.preference.PreferenceFragmentCompat.2
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = PreferenceFragmentCompat.this.f50887c;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    };

    /* JADX INFO: renamed from: androidx.preference.PreferenceFragmentCompat$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Preference f50896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f50897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PreferenceFragmentCompat f50898c;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView.Adapter adapter = this.f50898c.f50887c.getAdapter();
            if (!(adapter instanceof PreferenceGroup.PreferencePositionCallback)) {
                if (adapter != 0) {
                    throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                }
                return;
            }
            Preference preference = this.f50896a;
            int iB = preference != null ? ((PreferenceGroup.PreferencePositionCallback) adapter).b(preference) : ((PreferenceGroup.PreferencePositionCallback) adapter).f(this.f50897b);
            if (iB != -1) {
                this.f50898c.f50887c.u1(iB);
            } else {
                adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, this.f50898c.f50887c, this.f50896a, this.f50897b));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DividerDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f50899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f50900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f50901c = true;

        DividerDecoration() {
        }

        private boolean o(View view, RecyclerView recyclerView) {
            RecyclerView.ViewHolder viewHolderM0 = recyclerView.m0(view);
            if (!(viewHolderM0 instanceof PreferenceViewHolder) || !((PreferenceViewHolder) viewHolderM0).d()) {
                return false;
            }
            boolean z2 = this.f50901c;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z2;
            }
            RecyclerView.ViewHolder viewHolderM02 = recyclerView.m0(recyclerView.getChildAt(iIndexOfChild + 1));
            return (viewHolderM02 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) viewHolderM02).c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (o(view, recyclerView)) {
                rect.bottom = this.f50900b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.f50899a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (o(childAt, recyclerView)) {
                    int y2 = ((int) childAt.getY()) + childAt.getHeight();
                    this.f50899a.setBounds(0, y2, width, this.f50900b + y2);
                    this.f50899a.draw(canvas);
                }
            }
        }

        public void l(boolean z2) {
            this.f50901c = z2;
        }

        public void m(Drawable drawable) {
            if (drawable != null) {
                this.f50900b = drawable.getIntrinsicHeight();
            } else {
                this.f50900b = 0;
            }
            this.f50899a = drawable;
            PreferenceFragmentCompat.this.f50887c.C0();
        }

        public void n(int i3) {
            this.f50900b = i3;
            PreferenceFragmentCompat.this.f50887c.C0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPreferenceDisplayDialogCallback {
        boolean a(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPreferenceStartFragmentCallback {
        boolean k(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPreferenceStartScreenCallback {
        boolean a(PreferenceFragmentCompat preferenceFragmentCompat, PreferenceScreen preferenceScreen);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RecyclerView.Adapter f50903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final RecyclerView f50904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Preference f50905d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f50906e;

        ScrollToPreferenceObserver(RecyclerView.Adapter adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.f50903b = adapter;
            this.f50904c = recyclerView;
            this.f50905d = preference;
            this.f50906e = str;
        }

        private void a() {
            this.f50903b.unregisterAdapterDataObserver(this);
            Preference preference = this.f50905d;
            int iB = preference != null ? ((PreferenceGroup.PreferencePositionCallback) this.f50903b).b(preference) : ((PreferenceGroup.PreferencePositionCallback) this.f50903b).f(this.f50906e);
            if (iB != -1) {
                this.f50904c.u1(iB);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i4) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i4) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i4, int i5) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i4) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i4, Object obj) {
            a();
        }
    }

    private void I() {
        y().setAdapter(null);
        PreferenceScreen preferenceScreenZ = z();
        if (preferenceScreenZ != null) {
            preferenceScreenZ.T();
        }
        F();
    }

    protected RecyclerView.Adapter B(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    public RecyclerView.LayoutManager C() {
        return new LinearLayoutManager(requireContext());
    }

    public abstract void D(Bundle bundle, String str);

    public RecyclerView E(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.f50976e)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.f50986d, viewGroup, false);
        recyclerView2.setLayoutManager(C());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    public void G(Drawable drawable) {
        this.f50885a.m(drawable);
    }

    public void H(int i3) {
        this.f50885a.n(i3);
    }

    @Override // androidx.preference.PreferenceManager.OnNavigateToScreenListener
    public void g(PreferenceScreen preferenceScreen) {
        boolean zA = x() instanceof OnPreferenceStartScreenCallback ? ((OnPreferenceStartScreenCallback) x()).a(this, preferenceScreen) : false;
        for (Fragment parentFragment = this; !zA && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof OnPreferenceStartScreenCallback) {
                zA = ((OnPreferenceStartScreenCallback) parentFragment).a(this, preferenceScreen);
            }
        }
        if (!zA && (getContext() instanceof OnPreferenceStartScreenCallback)) {
            zA = ((OnPreferenceStartScreenCallback) getContext()).a(this, preferenceScreen);
        }
        if (zA || !(getActivity() instanceof OnPreferenceStartScreenCallback)) {
            return;
        }
        ((OnPreferenceStartScreenCallback) getActivity()).a(this, preferenceScreen);
    }

    @Override // androidx.preference.DialogPreference.TargetFragment
    public Preference h(CharSequence charSequence) {
        PreferenceManager preferenceManager = this.f50886b;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.a(charSequence);
    }

    @Override // androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void l(Preference preference) {
        DialogFragment dialogFragmentH;
        boolean zA = x() instanceof OnPreferenceDisplayDialogCallback ? ((OnPreferenceDisplayDialogCallback) x()).a(this, preference) : false;
        for (Fragment parentFragment = this; !zA && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof OnPreferenceDisplayDialogCallback) {
                zA = ((OnPreferenceDisplayDialogCallback) parentFragment).a(this, preference);
            }
        }
        if (!zA && (getContext() instanceof OnPreferenceDisplayDialogCallback)) {
            zA = ((OnPreferenceDisplayDialogCallback) getContext()).a(this, preference);
        }
        if (!zA && (getActivity() instanceof OnPreferenceDisplayDialogCallback)) {
            zA = ((OnPreferenceDisplayDialogCallback) getActivity()).a(this, preference);
        }
        if (!zA && getParentFragmentManager().n0("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                dialogFragmentH = EditTextPreferenceDialogFragmentCompat.I(preference.o());
            } else if (preference instanceof ListPreference) {
                dialogFragmentH = ListPreferenceDialogFragmentCompat.H(preference.o());
            } else {
                if (!(preference instanceof MultiSelectListPreference)) {
                    throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                }
                dialogFragmentH = MultiSelectListPreferenceDialogFragmentCompat.H(preference.o());
            }
            dialogFragmentH.setTargetFragment(this, 0);
            dialogFragmentH.show(getParentFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    @Override // androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean m(Preference preference) {
        if (preference.k() == null) {
            return false;
        }
        boolean zK = x() instanceof OnPreferenceStartFragmentCallback ? ((OnPreferenceStartFragmentCallback) x()).k(this, preference) : false;
        for (Fragment parentFragment = this; !zK && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof OnPreferenceStartFragmentCallback) {
                zK = ((OnPreferenceStartFragmentCallback) parentFragment).k(this, preference);
            }
        }
        if (!zK && (getContext() instanceof OnPreferenceStartFragmentCallback)) {
            zK = ((OnPreferenceStartFragmentCallback) getContext()).k(this, preference);
        }
        if (!zK && (getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            zK = ((OnPreferenceStartFragmentCallback) getActivity()).k(this, preference);
        }
        if (zK) {
            return true;
        }
        Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Bundle bundleI = preference.i();
        Fragment fragmentA = parentFragmentManager.B0().a(requireActivity().getClassLoader(), preference.k());
        fragmentA.setArguments(bundleI);
        fragmentA.setTargetFragment(this, 0);
        parentFragmentManager.q().s(((View) requireView().getParent()).getId(), fragmentA).h(null).j();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(R.attr.f50965j, typedValue, true);
        int i3 = typedValue.resourceId;
        if (i3 == 0) {
            i3 = R.style.f50992a;
        }
        requireContext().getTheme().applyStyle(i3, false);
        PreferenceManager preferenceManager = new PreferenceManager(requireContext());
        this.f50886b = preferenceManager;
        preferenceManager.m(this);
        D(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = requireContext().obtainStyledAttributes(null, R.styleable.f51058z0, R.attr.f50961f, 0);
        this.f50890g = typedArrayObtainStyledAttributes.getResourceId(R.styleable.A0, this.f50890g);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.B0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.C0, -1);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.D0, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(requireContext());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.f50890g, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewE = E(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewE == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.f50887c = recyclerViewE;
        recyclerViewE.j(this.f50885a);
        G(drawable);
        if (dimensionPixelSize != -1) {
            H(dimensionPixelSize);
        }
        this.f50885a.l(z2);
        if (this.f50887c.getParent() == null) {
            viewGroup2.addView(this.f50887c);
        }
        this.f50892i.post(this.f50893j);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f50892i.removeCallbacks(this.f50893j);
        this.f50892i.removeMessages(1);
        if (this.f50888d) {
            I();
        }
        this.f50887c = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreenZ = z();
        if (preferenceScreenZ != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenZ.k0(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f50886b.n(this);
        this.f50886b.l(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f50886b.n(null);
        this.f50886b.l(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreenZ;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenZ = z()) != null) {
            preferenceScreenZ.i0(bundle2);
        }
        if (this.f50888d) {
            w();
            Runnable runnable = this.f50891h;
            if (runnable != null) {
                runnable.run();
                this.f50891h = null;
            }
        }
        this.f50889f = true;
    }

    void w() {
        PreferenceScreen preferenceScreenZ = z();
        if (preferenceScreenZ != null) {
            y().setAdapter(B(preferenceScreenZ));
            preferenceScreenZ.P();
        }
        A();
    }

    public Fragment x() {
        return null;
    }

    public final RecyclerView y() {
        return this.f50887c;
    }

    public PreferenceScreen z() {
        return this.f50886b.j();
    }

    protected void A() {
    }

    protected void F() {
    }
}
