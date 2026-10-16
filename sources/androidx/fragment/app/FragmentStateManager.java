package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FragmentStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentLifecycleCallbacksDispatcher f37302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentStore f37303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Fragment f37304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37305d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37306e = -1;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentStateManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37309a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f37309a = iArr;
            try {
                iArr[Lifecycle.State.f39951f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37309a[Lifecycle.State.f39950d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37309a[Lifecycle.State.f39949c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37309a[Lifecycle.State.f39948b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment) {
        this.f37302a = fragmentLifecycleCallbacksDispatcher;
        this.f37303b = fragmentStore;
        this.f37304c = fragment;
    }

    private boolean l(View view) {
        if (view == this.f37304c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f37304c.mView) {
                return true;
            }
        }
        return false;
    }

    void a() {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f37304c);
        }
        Bundle bundle = this.f37304c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.f37304c.performActivityCreated(bundle2);
        this.f37302a.a(this.f37304c, bundle2, false);
    }

    void b() {
        Fragment fragmentQ0 = FragmentManager.q0(this.f37304c.mContainer);
        Fragment parentFragment = this.f37304c.getParentFragment();
        if (fragmentQ0 != null && !fragmentQ0.equals(parentFragment)) {
            Fragment fragment = this.f37304c;
            FragmentStrictMode.q(fragment, fragmentQ0, fragment.mContainerId);
        }
        int iJ = this.f37303b.j(this.f37304c);
        Fragment fragment2 = this.f37304c;
        fragment2.mContainer.addView(fragment2.mView, iJ);
    }

    void c() {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f37304c);
        }
        Fragment fragment = this.f37304c;
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManagerN = null;
        if (fragment2 != null) {
            FragmentStateManager fragmentStateManagerN2 = this.f37303b.n(fragment2.mWho);
            if (fragmentStateManagerN2 == null) {
                throw new IllegalStateException("Fragment " + this.f37304c + " declared target fragment " + this.f37304c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f37304c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            fragmentStateManagerN = fragmentStateManagerN2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManagerN = this.f37303b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f37304c + " declared target fragment " + this.f37304c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (fragmentStateManagerN != null) {
            fragmentStateManagerN.m();
        }
        Fragment fragment4 = this.f37304c;
        fragment4.mHost = fragment4.mFragmentManager.E0();
        Fragment fragment5 = this.f37304c;
        fragment5.mParentFragment = fragment5.mFragmentManager.H0();
        this.f37302a.g(this.f37304c, false);
        this.f37304c.performAttach();
        this.f37302a.b(this.f37304c, false);
    }

    int d() {
        Fragment fragment = this.f37304c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.f37306e;
        int i3 = AnonymousClass2.f37309a[fragment.mMaxState.ordinal()];
        if (i3 != 1) {
            iMin = i3 != 2 ? i3 != 3 ? i3 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment2 = this.f37304c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                iMin = Math.max(this.f37306e, 2);
                View view = this.f37304c.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f37306e < 4 ? Math.min(iMin, fragment2.mState) : Math.min(iMin, 1);
            }
        }
        if (!this.f37304c.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment3 = this.f37304c;
        ViewGroup viewGroup = fragment3.mContainer;
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpactP = viewGroup != null ? SpecialEffectsController.r(viewGroup, fragment3.getParentFragmentManager()).p(this) : null;
        if (lifecycleImpactP == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (lifecycleImpactP == SpecialEffectsController.Operation.LifecycleImpact.f37447c) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f37304c;
            if (fragment4.mRemoving) {
                iMin = fragment4.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f37304c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f37304c);
        }
        return iMin;
    }

    void e() {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f37304c);
        }
        Bundle bundle = this.f37304c.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        Fragment fragment = this.f37304c;
        if (fragment.mIsCreated) {
            fragment.mState = 1;
            fragment.restoreChildFragmentState();
        } else {
            this.f37302a.h(fragment, bundle2, false);
            this.f37304c.performCreate(bundle2);
            this.f37302a.c(this.f37304c, bundle2, false);
        }
    }

    void f() {
        String resourceName;
        if (this.f37304c.mFromLayout) {
            return;
        }
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f37304c);
        }
        Bundle bundle = this.f37304c.mSavedFragmentState;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = this.f37304c.performGetLayoutInflater(bundle2);
        Fragment fragment = this.f37304c;
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i3 = fragment.mContainerId;
            if (i3 != 0) {
                if (i3 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f37304c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.y0().c(this.f37304c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment2 = this.f37304c;
                    if (!fragment2.mRestored) {
                        try {
                            resourceName = fragment2.getResources().getResourceName(this.f37304c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f37304c.mContainerId) + " (" + resourceName + ") for fragment " + this.f37304c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.p(this.f37304c, viewGroup);
                }
            }
        }
        Fragment fragment3 = this.f37304c;
        fragment3.mContainer = viewGroup;
        fragment3.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, bundle2);
        if (this.f37304c.mView != null) {
            if (FragmentManager.R0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f37304c);
            }
            this.f37304c.mView.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.f37304c;
            fragment4.mView.setTag(R.id.f37095a, fragment4);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment5 = this.f37304c;
            if (fragment5.mHidden) {
                fragment5.mView.setVisibility(8);
            }
            if (ViewCompat.Q(this.f37304c.mView)) {
                ViewCompat.j0(this.f37304c.mView);
            } else {
                final View view = this.f37304c.mView;
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentStateManager.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                        view.removeOnAttachStateChangeListener(this);
                        ViewCompat.j0(view);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                    }
                });
            }
            this.f37304c.performViewCreated();
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f37302a;
            Fragment fragment6 = this.f37304c;
            fragmentLifecycleCallbacksDispatcher.m(fragment6, fragment6.mView, bundle2, false);
            int visibility = this.f37304c.mView.getVisibility();
            this.f37304c.setPostOnViewCreatedAlpha(this.f37304c.mView.getAlpha());
            Fragment fragment7 = this.f37304c;
            if (fragment7.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment7.mView.findFocus();
                if (viewFindFocus != null) {
                    this.f37304c.setFocusedView(viewFindFocus);
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f37304c);
                    }
                }
                this.f37304c.mView.setAlpha(0.0f);
            }
        }
        this.f37304c.mState = 2;
    }

    void g() {
        Fragment fragmentF;
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f37304c);
        }
        Fragment fragment = this.f37304c;
        boolean zIsChangingConfigurations = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (z2) {
            Fragment fragment2 = this.f37304c;
            if (!fragment2.mBeingSaved) {
                this.f37303b.B(fragment2.mWho, null);
            }
        }
        if (!z2 && !this.f37303b.p().K0(this.f37304c)) {
            String str = this.f37304c.mTargetWho;
            if (str != null && (fragmentF = this.f37303b.f(str)) != null && fragmentF.mRetainInstance) {
                this.f37304c.mTarget = fragmentF;
            }
            this.f37304c.mState = 0;
            return;
        }
        FragmentHostCallback<?> fragmentHostCallback = this.f37304c.mHost;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            zIsChangingConfigurations = this.f37303b.p().H0();
        } else if (fragmentHostCallback.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) fragmentHostCallback.f()).isChangingConfigurations();
        }
        if ((z2 && !this.f37304c.mBeingSaved) || zIsChangingConfigurations) {
            this.f37303b.p().z0(this.f37304c, false);
        }
        this.f37304c.performDestroy();
        this.f37302a.d(this.f37304c, false);
        for (FragmentStateManager fragmentStateManager : this.f37303b.k()) {
            if (fragmentStateManager != null) {
                Fragment fragmentK = fragmentStateManager.k();
                if (this.f37304c.mWho.equals(fragmentK.mTargetWho)) {
                    fragmentK.mTarget = this.f37304c;
                    fragmentK.mTargetWho = null;
                }
            }
        }
        Fragment fragment3 = this.f37304c;
        String str2 = fragment3.mTargetWho;
        if (str2 != null) {
            fragment3.mTarget = this.f37303b.f(str2);
        }
        this.f37303b.s(this);
    }

    void h() {
        View view;
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f37304c);
        }
        Fragment fragment = this.f37304c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f37304c.performDestroyView();
        this.f37302a.n(this.f37304c, false);
        Fragment fragment2 = this.f37304c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.p(null);
        this.f37304c.mInLayout = false;
    }

    void i() {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f37304c);
        }
        this.f37304c.performDetach();
        this.f37302a.e(this.f37304c, false);
        Fragment fragment = this.f37304c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((!fragment.mRemoving || fragment.isInBackStack()) && !this.f37303b.p().K0(this.f37304c)) {
            return;
        }
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f37304c);
        }
        this.f37304c.initState();
    }

    void j() {
        Fragment fragment = this.f37304c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.R0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f37304c);
            }
            Bundle bundle = this.f37304c.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            Fragment fragment2 = this.f37304c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(bundle2), null, bundle2);
            View view = this.f37304c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f37304c;
                fragment3.mView.setTag(R.id.f37095a, fragment3);
                Fragment fragment4 = this.f37304c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f37304c.performViewCreated();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f37302a;
                Fragment fragment5 = this.f37304c;
                fragmentLifecycleCallbacksDispatcher.m(fragment5, fragment5.mView, bundle2, false);
                this.f37304c.mState = 2;
            }
        }
    }

    Fragment k() {
        return this.f37304c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f37305d) {
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f37305d = true;
            boolean z2 = false;
            while (true) {
                int iD = d();
                Fragment fragment = this.f37304c;
                int i3 = fragment.mState;
                if (iD == i3) {
                    if (!z2 && i3 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f37304c.mBeingSaved) {
                        if (FragmentManager.R0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f37304c);
                        }
                        this.f37303b.p().z0(this.f37304c, true);
                        this.f37303b.s(this);
                        if (FragmentManager.R0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f37304c);
                        }
                        this.f37304c.initState();
                    }
                    Fragment fragment2 = this.f37304c;
                    if (fragment2.mHiddenChanged) {
                        if (fragment2.mView != null && (viewGroup = fragment2.mContainer) != null) {
                            SpecialEffectsController specialEffectsControllerR = SpecialEffectsController.r(viewGroup, fragment2.getParentFragmentManager());
                            if (this.f37304c.mHidden) {
                                specialEffectsControllerR.g(this);
                            } else {
                                specialEffectsControllerR.i(this);
                            }
                        }
                        Fragment fragment3 = this.f37304c;
                        FragmentManager fragmentManager = fragment3.mFragmentManager;
                        if (fragmentManager != null) {
                            fragmentManager.P0(fragment3);
                        }
                        Fragment fragment4 = this.f37304c;
                        fragment4.mHiddenChanged = false;
                        fragment4.onHiddenChanged(fragment4.mHidden);
                        this.f37304c.mChildFragmentManager.M();
                    }
                    this.f37305d = false;
                    return;
                }
                if (iD <= i3) {
                    switch (i3 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.mBeingSaved && this.f37303b.q(fragment.mWho) == null) {
                                this.f37303b.B(this.f37304c.mWho, r());
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f37304c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.R0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f37304c);
                            }
                            Fragment fragment5 = this.f37304c;
                            if (fragment5.mBeingSaved) {
                                this.f37303b.B(fragment5.mWho, r());
                            } else if (fragment5.mView != null && fragment5.mSavedViewState == null) {
                                s();
                            }
                            Fragment fragment6 = this.f37304c;
                            if (fragment6.mView != null && (viewGroup2 = fragment6.mContainer) != null) {
                                SpecialEffectsController.r(viewGroup2, fragment6.getParentFragmentManager()).h(this);
                            }
                            this.f37304c.mState = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i3 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                SpecialEffectsController.r(viewGroup3, fragment.getParentFragmentManager()).f(SpecialEffectsController.Operation.State.c(this.f37304c.mView.getVisibility()), this);
                            }
                            this.f37304c.mState = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z2 = true;
            }
        } catch (Throwable th) {
            this.f37305d = false;
            throw th;
        }
    }

    void n() {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f37304c);
        }
        this.f37304c.performPause();
        this.f37302a.f(this.f37304c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.f37304c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.f37304c.mSavedFragmentState.getBundle("savedInstanceState") == null) {
            this.f37304c.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
        }
        Fragment fragment = this.f37304c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("viewState");
        Fragment fragment2 = this.f37304c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("viewRegistryState");
        FragmentState fragmentState = (FragmentState) this.f37304c.mSavedFragmentState.getParcelable(ServerProtocol.DIALOG_PARAM_STATE);
        if (fragmentState != null) {
            Fragment fragment3 = this.f37304c;
            fragment3.mTargetWho = fragmentState.f37299m;
            fragment3.mTargetRequestCode = fragmentState.f37300n;
            Boolean bool = fragment3.mSavedUserVisibleHint;
            if (bool != null) {
                fragment3.mUserVisibleHint = bool.booleanValue();
                this.f37304c.mSavedUserVisibleHint = null;
            } else {
                fragment3.mUserVisibleHint = fragmentState.f37301o;
            }
        }
        Fragment fragment4 = this.f37304c;
        if (fragment4.mUserVisibleHint) {
            return;
        }
        fragment4.mDeferStart = true;
    }

    void p() {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f37304c);
        }
        View focusedView = this.f37304c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean zRequestFocus = focusedView.requestFocus();
            if (FragmentManager.R0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(zRequestFocus ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f37304c);
                sb.append(" resulting in focused view ");
                sb.append(this.f37304c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f37304c.setFocusedView(null);
        this.f37304c.performResume();
        this.f37302a.i(this.f37304c, false);
        this.f37303b.B(this.f37304c.mWho, null);
        Fragment fragment = this.f37304c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    Fragment.SavedState q() {
        if (this.f37304c.mState > -1) {
            return new Fragment.SavedState(r());
        }
        return null;
    }

    Bundle r() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.f37304c;
        if (fragment.mState == -1 && (bundle = fragment.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable(ServerProtocol.DIALOG_PARAM_STATE, new FragmentState(this.f37304c));
        if (this.f37304c.mState > -1) {
            Bundle bundle3 = new Bundle();
            this.f37304c.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f37302a.j(this.f37304c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.f37304c.mSavedStateRegistryController.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleX1 = this.f37304c.mChildFragmentManager.x1();
            if (!bundleX1.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleX1);
            }
            if (this.f37304c.mView != null) {
                s();
            }
            SparseArray<Parcelable> sparseArray = this.f37304c.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.f37304c.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.f37304c.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    void s() {
        if (this.f37304c.mView == null) {
            return;
        }
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f37304c + " with view " + this.f37304c.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f37304c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f37304c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f37304c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f37304c.mSavedViewRegistryState = bundle;
    }

    void t(int i3) {
        this.f37306e = i3;
    }

    void u() {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f37304c);
        }
        this.f37304c.performStart();
        this.f37302a.k(this.f37304c, false);
    }

    void v() {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f37304c);
        }
        this.f37304c.performStop();
        this.f37302a.l(this.f37304c, false);
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, ClassLoader classLoader, FragmentFactory fragmentFactory, Bundle bundle) {
        this.f37302a = fragmentLifecycleCallbacksDispatcher;
        this.f37303b = fragmentStore;
        Fragment fragmentA = ((FragmentState) bundle.getParcelable(ServerProtocol.DIALOG_PARAM_STATE)).a(fragmentFactory, classLoader);
        this.f37304c = fragmentA;
        fragmentA.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        fragmentA.setArguments(bundle2);
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment, Bundle bundle) {
        this.f37302a = fragmentLifecycleCallbacksDispatcher;
        this.f37303b = fragmentStore;
        this.f37304c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        fragment.mSavedFragmentState = bundle;
        fragment.mArguments = bundle.getBundle("arguments");
    }
}
