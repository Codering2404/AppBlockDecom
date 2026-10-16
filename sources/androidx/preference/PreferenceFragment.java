package androidx.preference;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class PreferenceFragment extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DividerDecoration f50862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PreferenceManager f50863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    RecyclerView f50864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f50865d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f50866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f50867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f50868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Runnable f50869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Handler f50870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f50871k;

    /* JADX INFO: renamed from: androidx.preference.PreferenceFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PreferenceFragment f50872a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            this.f50872a.a();
        }
    }

    /* JADX INFO: renamed from: androidx.preference.PreferenceFragment$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PreferenceFragment f50873a;

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
            RecyclerView recyclerView = this.f50873a.f50864c;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    /* JADX INFO: renamed from: androidx.preference.PreferenceFragment$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Preference f50874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f50875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PreferenceFragment f50876c;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView.Adapter adapter = this.f50876c.f50864c.getAdapter();
            if (!(adapter instanceof PreferenceGroup.PreferencePositionCallback)) {
                if (adapter != 0) {
                    throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                }
                return;
            }
            Preference preference = this.f50874a;
            int iB = preference != null ? ((PreferenceGroup.PreferencePositionCallback) adapter).b(preference) : ((PreferenceGroup.PreferencePositionCallback) adapter).f(this.f50875b);
            if (iB != -1) {
                this.f50876c.f50864c.u1(iB);
            } else {
                adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, this.f50876c.f50864c, this.f50874a, this.f50875b));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DividerDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f50877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f50878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f50879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ PreferenceFragment f50880d;

        private boolean o(View view, RecyclerView recyclerView) {
            RecyclerView.ViewHolder viewHolderM0 = recyclerView.m0(view);
            if (!(viewHolderM0 instanceof PreferenceViewHolder) || !((PreferenceViewHolder) viewHolderM0).d()) {
                return false;
            }
            boolean z2 = this.f50879c;
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
                rect.bottom = this.f50878b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.f50877a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (o(childAt, recyclerView)) {
                    int y2 = ((int) childAt.getY()) + childAt.getHeight();
                    this.f50877a.setBounds(0, y2, width, this.f50878b + y2);
                    this.f50877a.draw(canvas);
                }
            }
        }

        public void l(boolean z2) {
            this.f50879c = z2;
        }

        public void m(Drawable drawable) {
            if (drawable != null) {
                this.f50878b = drawable.getIntrinsicHeight();
            } else {
                this.f50878b = 0;
            }
            this.f50877a = drawable;
            this.f50880d.f50864c.C0();
        }

        public void n(int i3) {
            this.f50878b = i3;
            this.f50880d.f50864c.C0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPreferenceDisplayDialogCallback {
        boolean a(PreferenceFragment preferenceFragment, Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPreferenceStartFragmentCallback {
        boolean a(PreferenceFragment preferenceFragment, Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPreferenceStartScreenCallback {
        boolean a(PreferenceFragment preferenceFragment, PreferenceScreen preferenceScreen);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RecyclerView.Adapter f50881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final RecyclerView f50882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Preference f50883d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f50884e;

        ScrollToPreferenceObserver(RecyclerView.Adapter adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.f50881b = adapter;
            this.f50882c = recyclerView;
            this.f50883d = preference;
            this.f50884e = str;
        }

        private void a() {
            this.f50881b.unregisterAdapterDataObserver(this);
            Preference preference = this.f50883d;
            int iB = preference != null ? ((PreferenceGroup.PreferencePositionCallback) this.f50881b).b(preference) : ((PreferenceGroup.PreferencePositionCallback) this.f50881b).f(this.f50884e);
            if (iB != -1) {
                this.f50882c.u1(iB);
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

    private void q() {
        PreferenceScreen preferenceScreenD = d();
        if (preferenceScreenD != null) {
            preferenceScreenD.T();
        }
        n();
    }

    void a() {
        PreferenceScreen preferenceScreenD = d();
        if (preferenceScreenD != null) {
            c().setAdapter(f(preferenceScreenD));
            preferenceScreenD.P();
        }
        e();
    }

    public Fragment b() {
        return null;
    }

    public final RecyclerView c() {
        return this.f50864c;
    }

    public PreferenceScreen d() {
        return this.f50863b.j();
    }

    protected RecyclerView.Adapter f(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    @Override // androidx.preference.PreferenceManager.OnNavigateToScreenListener
    public void g(PreferenceScreen preferenceScreen) {
        if ((b() instanceof OnPreferenceStartScreenCallback ? ((OnPreferenceStartScreenCallback) b()).a(this, preferenceScreen) : false) || !(getActivity() instanceof OnPreferenceStartScreenCallback)) {
            return;
        }
        ((OnPreferenceStartScreenCallback) getActivity()).a(this, preferenceScreen);
    }

    @Override // androidx.preference.DialogPreference.TargetFragment
    public Preference h(CharSequence charSequence) {
        PreferenceManager preferenceManager = this.f50863b;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.a(charSequence);
    }

    public RecyclerView.LayoutManager i() {
        return new LinearLayoutManager(getActivity());
    }

    public abstract void j(Bundle bundle, String str);

    public RecyclerView k(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (this.f50867g.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.f50976e)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.f50986d, viewGroup, false);
        recyclerView2.setLayoutManager(i());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void l(Preference preference) {
        DialogFragment dialogFragmentI;
        boolean zA = b() instanceof OnPreferenceDisplayDialogCallback ? ((OnPreferenceDisplayDialogCallback) b()).a(this, preference) : false;
        if (!zA && (getActivity() instanceof OnPreferenceDisplayDialogCallback)) {
            zA = ((OnPreferenceDisplayDialogCallback) getActivity()).a(this, preference);
        }
        if (!zA && getFragmentManager().findFragmentByTag("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                dialogFragmentI = EditTextPreferenceDialogFragment.i(preference.o());
            } else if (preference instanceof ListPreference) {
                dialogFragmentI = ListPreferenceDialogFragment.i(preference.o());
            } else {
                if (!(preference instanceof MultiSelectListPreference)) {
                    throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
                }
                dialogFragmentI = MultiSelectListPreferenceDialogFragment.i(preference.o());
            }
            dialogFragmentI.setTargetFragment(this, 0);
            dialogFragmentI.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    @Override // androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean m(Preference preference) {
        if (preference.k() != null) {
            zA = b() instanceof OnPreferenceStartFragmentCallback ? ((OnPreferenceStartFragmentCallback) b()).a(this, preference) : false;
            if (!zA && (getActivity() instanceof OnPreferenceStartFragmentCallback)) {
                return ((OnPreferenceStartFragmentCallback) getActivity()).a(this, preference);
            }
        }
        return zA;
    }

    public void o(Drawable drawable) {
        this.f50862a.m(drawable);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.f50965j, typedValue, true);
        int i3 = typedValue.resourceId;
        if (i3 == 0) {
            i3 = R.style.f50992a;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), i3);
        this.f50867g = contextThemeWrapper;
        PreferenceManager preferenceManager = new PreferenceManager(contextThemeWrapper);
        this.f50863b = preferenceManager;
        preferenceManager.m(this);
        j(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f50867g;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.f51048u0, TypedArrayUtils.a(context, R.attr.f50962g, android.R.attr.preferenceFragmentStyle), 0);
        this.f50868h = typedArrayObtainStyledAttributes.getResourceId(R.styleable.f51050v0, this.f50868h);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.f51052w0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f51054x0, -1);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f51056y0, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(this.f50867g);
        View viewInflate = layoutInflaterCloneInContext.inflate(this.f50868h, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewK = k(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewK == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.f50864c = recyclerViewK;
        recyclerViewK.j(this.f50862a);
        o(drawable);
        if (dimensionPixelSize != -1) {
            p(dimensionPixelSize);
        }
        this.f50862a.l(z2);
        if (this.f50864c.getParent() == null) {
            viewGroup2.addView(this.f50864c);
        }
        this.f50870j.post(this.f50871k);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f50870j.removeCallbacks(this.f50871k);
        this.f50870j.removeMessages(1);
        if (this.f50865d) {
            q();
        }
        this.f50864c = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreenD = d();
        if (preferenceScreenD != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenD.k0(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f50863b.n(this);
        this.f50863b.l(this);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f50863b.n(null);
        this.f50863b.l(null);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreenD;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenD = d()) != null) {
            preferenceScreenD.i0(bundle2);
        }
        if (this.f50865d) {
            a();
            Runnable runnable = this.f50869i;
            if (runnable != null) {
                runnable.run();
                this.f50869i = null;
            }
        }
        this.f50866f = true;
    }

    public void p(int i3) {
        this.f50862a.n(i3);
    }

    protected void e() {
    }

    protected void n() {
    }
}
