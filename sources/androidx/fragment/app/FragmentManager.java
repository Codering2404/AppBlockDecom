package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.legacy.content.Werj.QgXempTBEfV;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean S;
    private ActivityResultLauncher D;
    private ActivityResultLauncher E;
    private ActivityResultLauncher F;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList M;
    private ArrayList N;
    private ArrayList O;
    private FragmentManagerViewModel P;
    private FragmentStrictMode.Policy Q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f37218b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList f37220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList f37221e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f37223g;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ArrayList f37229m;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private FragmentHostCallback f37238v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private FragmentContainer f37239w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Fragment f37240x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Fragment f37241y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f37217a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FragmentStore f37219c = new FragmentStore();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FragmentLayoutInflaterFactory f37222f = new FragmentLayoutInflaterFactory(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final OnBackPressedCallback f37224h = new OnBackPressedCallback(false) { // from class: androidx.fragment.app.FragmentManager.1
        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            FragmentManager.this.N0();
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f37225i = new AtomicInteger();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f37226j = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f37227k = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f37228l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final FragmentLifecycleCallbacksDispatcher f37230n = new FragmentLifecycleCallbacksDispatcher(this);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList f37231o = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Consumer f37232p = new Consumer() { // from class: androidx.fragment.app.o
        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            FragmentManager.e(this.f37486a, (Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Consumer f37233q = new Consumer() { // from class: androidx.fragment.app.p
        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            FragmentManager.a(this.f37487a, (Integer) obj);
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Consumer f37234r = new Consumer() { // from class: androidx.fragment.app.q
        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            FragmentManager.d(this.f37488a, (MultiWindowModeChangedInfo) obj);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Consumer f37235s = new Consumer() { // from class: androidx.fragment.app.r
        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            FragmentManager.c(this.f37489a, (PictureInPictureModeChangedInfo) obj);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MenuProvider f37236t = new MenuProvider() { // from class: androidx.fragment.app.FragmentManager.2
        @Override // androidx.core.view.MenuProvider
        public void a(Menu menu) {
            FragmentManager.this.O(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public void b(Menu menu) {
            FragmentManager.this.S(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public boolean c(MenuItem menuItem) {
            return FragmentManager.this.N(menuItem);
        }

        @Override // androidx.core.view.MenuProvider
        public void d(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.G(menu, menuInflater);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f37237u = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private FragmentFactory f37242z = null;
    private FragmentFactory A = new FragmentFactory() { // from class: androidx.fragment.app.FragmentManager.3
        @Override // androidx.fragment.app.FragmentFactory
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.E0().b(FragmentManager.this.E0().f(), str, null);
        }
    };
    private SpecialEffectsControllerFactory B = null;
    private SpecialEffectsControllerFactory C = new SpecialEffectsControllerFactory() { // from class: androidx.fragment.app.FragmentManager.4
        @Override // androidx.fragment.app.SpecialEffectsControllerFactory
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    };
    ArrayDeque G = new ArrayDeque();
    private Runnable R = new Runnable() { // from class: androidx.fragment.app.FragmentManager.5
        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.e0(true);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface BackStackEntry {
        int getId();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private class ClearBackStackState implements OpGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f37257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FragmentManager f37258b;

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            return this.f37258b.u(arrayList, arrayList2, this.f37257a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentC = intentSenderRequest.c();
            if (intentC != null && (bundleExtra = intentC.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentC.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentC.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.Builder(intentSenderRequest.f()).b(null).c(intentSenderRequest.e(), intentSenderRequest.d()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResult parseResult(int i3, Intent intent) {
            return new ActivityResult(i3, intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class LifecycleAwareResultListener implements FragmentResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Lifecycle f37261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FragmentResultListener f37262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LifecycleEventObserver f37263c;

        LifecycleAwareResultListener(Lifecycle lifecycle, FragmentResultListener fragmentResultListener, LifecycleEventObserver lifecycleEventObserver) {
            this.f37261a = lifecycle;
            this.f37262b = fragmentResultListener;
            this.f37263c = lifecycleEventObserver;
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void a(String str, Bundle bundle) {
            this.f37262b.a(str, bundle);
        }

        public boolean b(Lifecycle.State state) {
            return this.f37261a.getCurrentState().b(state);
        }

        public void c() {
            this.f37261a.removeObserver(this.f37263c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    interface OpGenerator {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private class PopBackStackState implements OpGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f37264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f37265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f37266c;

        PopBackStackState(String str, int i3, int i4) {
            this.f37264a = str;
            this.f37265b = i3;
            this.f37266c = i4;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = FragmentManager.this.f37241y;
            if (fragment == null || this.f37265b >= 0 || this.f37264a != null || !fragment.getChildFragmentManager().j1()) {
                return FragmentManager.this.m1(arrayList, arrayList2, this.f37264a, this.f37265b, this.f37266c);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private class RestoreBackStackState implements OpGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f37268a;

        RestoreBackStackState(String str) {
            this.f37268a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            return FragmentManager.this.u1(arrayList, arrayList2, this.f37268a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private class SaveBackStackState implements OpGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f37270a;

        SaveBackStackState(String str) {
            this.f37270a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            return FragmentManager.this.z1(arrayList, arrayList2, this.f37270a);
        }
    }

    private ViewGroup A0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f37239w.d()) {
            View viewC = this.f37239w.c(fragment.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    private void I1(Fragment fragment) {
        ViewGroup viewGroupA0 = A0(fragment);
        if (viewGroupA0 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        int i3 = R.id.f37097c;
        if (viewGroupA0.getTag(i3) == null) {
            viewGroupA0.setTag(i3, fragment);
        }
        ((Fragment) viewGroupA0.getTag(i3)).setPopDirection(fragment.getPopDirection());
    }

    private void K1() {
        Iterator it = this.f37219c.k().iterator();
        while (it.hasNext()) {
            f1((FragmentStateManager) it.next());
        }
    }

    static Fragment L0(View view) {
        Object tag = view.getTag(R.id.f37095a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void L1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        FragmentHostCallback fragmentHostCallback = this.f37238v;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
                throw runtimeException;
            }
        }
        try {
            a0("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e4) {
            Log.e("FragmentManager", "Failed dumping state", e4);
            throw runtimeException;
        }
    }

    private void N1() {
        synchronized (this.f37217a) {
            try {
                if (this.f37217a.isEmpty()) {
                    this.f37224h.setEnabled(w0() > 0 && W0(this.f37240x));
                } else {
                    this.f37224h.setEnabled(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void P(Fragment fragment) {
        if (fragment == null || !fragment.equals(j0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    public static boolean R0(int i3) {
        return S || Log.isLoggable("FragmentManager", i3);
    }

    private boolean S0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.r();
    }

    private boolean T0() {
        Fragment fragment = this.f37240x;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.f37240x.getParentFragmentManager().T0();
    }

    private void W(int i3) {
        try {
            this.f37218b = true;
            this.f37219c.d(i3);
            c1(i3, false);
            Iterator it = x().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).n();
            }
            this.f37218b = false;
            e0(true);
        } catch (Throwable th) {
            this.f37218b = false;
            throw th;
        }
    }

    private void Z() {
        if (this.L) {
            this.L = false;
            K1();
        }
    }

    public static /* synthetic */ void a(FragmentManager fragmentManager, Integer num) {
        if (fragmentManager.T0() && num.intValue() == 80) {
            fragmentManager.J(false);
        }
    }

    private void b0() {
        Iterator it = x().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).n();
        }
    }

    public static /* synthetic */ void c(FragmentManager fragmentManager, PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo) {
        if (fragmentManager.T0()) {
            fragmentManager.R(pictureInPictureModeChangedInfo.a(), false);
        }
    }

    public static /* synthetic */ void d(FragmentManager fragmentManager, MultiWindowModeChangedInfo multiWindowModeChangedInfo) {
        if (fragmentManager.T0()) {
            fragmentManager.K(multiWindowModeChangedInfo.a(), false);
        }
    }

    private void d0(boolean z2) {
        if (this.f37218b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f37238v == null) {
            if (!this.K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f37238v.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z2) {
            s();
        }
        if (this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }

    public static /* synthetic */ void e(FragmentManager fragmentManager, Configuration configuration) {
        if (fragmentManager.T0()) {
            fragmentManager.D(configuration, false);
        }
    }

    private static void g0(ArrayList arrayList, ArrayList arrayList2, int i3, int i4) {
        while (i3 < i4) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                backStackRecord.z(-1);
                backStackRecord.F();
            } else {
                backStackRecord.z(1);
                backStackRecord.E();
            }
            i3++;
        }
    }

    private void h0(ArrayList arrayList, ArrayList arrayList2, int i3, int i4) {
        ArrayList arrayList3;
        boolean z2 = ((BackStackRecord) arrayList.get(i3)).f37351r;
        ArrayList arrayList4 = this.O;
        if (arrayList4 == null) {
            this.O = new ArrayList();
        } else {
            arrayList4.clear();
        }
        this.O.addAll(this.f37219c.o());
        Fragment fragmentI0 = I0();
        boolean z3 = false;
        for (int i5 = i3; i5 < i4; i5++) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i5);
            fragmentI0 = !((Boolean) arrayList2.get(i5)).booleanValue() ? backStackRecord.G(this.O, fragmentI0) : backStackRecord.J(this.O, fragmentI0);
            z3 = z3 || backStackRecord.f37342i;
        }
        this.O.clear();
        if (!z2 && this.f37237u >= 1) {
            for (int i6 = i3; i6 < i4; i6++) {
                ArrayList arrayList5 = ((BackStackRecord) arrayList.get(i6)).f37336c;
                int size = arrayList5.size();
                int i7 = 0;
                while (i7 < size) {
                    Object obj = arrayList5.get(i7);
                    i7++;
                    Fragment fragment = ((FragmentTransaction.Op) obj).f37354b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.f37219c.r(z(fragment));
                    }
                }
            }
        }
        g0(arrayList, arrayList2, i3, i4);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i4 - 1)).booleanValue();
        if (z3 && (arrayList3 = this.f37229m) != null && !arrayList3.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size2 = arrayList.size();
            int i8 = 0;
            while (i8 < size2) {
                Object obj2 = arrayList.get(i8);
                i8++;
                linkedHashSet.addAll(s0((BackStackRecord) obj2));
            }
            ArrayList arrayList6 = this.f37229m;
            int size3 = arrayList6.size();
            int i9 = 0;
            while (i9 < size3) {
                Object obj3 = arrayList6.get(i9);
                i9++;
                OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) obj3;
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    onBackStackChangedListener.b((Fragment) it.next(), zBooleanValue);
                }
            }
            ArrayList arrayList7 = this.f37229m;
            int size4 = arrayList7.size();
            int i10 = 0;
            while (i10 < size4) {
                Object obj4 = arrayList7.get(i10);
                i10++;
                OnBackStackChangedListener onBackStackChangedListener2 = (OnBackStackChangedListener) obj4;
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    onBackStackChangedListener2.a((Fragment) it2.next(), zBooleanValue);
                }
            }
        }
        for (int i11 = i3; i11 < i4; i11++) {
            BackStackRecord backStackRecord2 = (BackStackRecord) arrayList.get(i11);
            if (zBooleanValue) {
                for (int size5 = backStackRecord2.f37336c.size() - 1; size5 >= 0; size5--) {
                    Fragment fragment2 = ((FragmentTransaction.Op) backStackRecord2.f37336c.get(size5)).f37354b;
                    if (fragment2 != null) {
                        z(fragment2).m();
                    }
                }
            } else {
                ArrayList arrayList8 = backStackRecord2.f37336c;
                int size6 = arrayList8.size();
                int i12 = 0;
                while (i12 < size6) {
                    Object obj5 = arrayList8.get(i12);
                    i12++;
                    Fragment fragment3 = ((FragmentTransaction.Op) obj5).f37354b;
                    if (fragment3 != null) {
                        z(fragment3).m();
                    }
                }
            }
        }
        c1(this.f37237u, true);
        for (SpecialEffectsController specialEffectsController : y(arrayList, i3, i4)) {
            specialEffectsController.v(zBooleanValue);
            specialEffectsController.t();
            specialEffectsController.k();
        }
        while (i3 < i4) {
            BackStackRecord backStackRecord3 = (BackStackRecord) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue() && backStackRecord3.f37107v >= 0) {
                backStackRecord3.f37107v = -1;
            }
            backStackRecord3.I();
            i3++;
        }
        if (z3) {
            s1();
        }
    }

    private int k0(String str, int i3, boolean z2) {
        ArrayList arrayList = this.f37220d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i3 < 0) {
            if (z2) {
                return 0;
            }
            return this.f37220d.size() - 1;
        }
        int size = this.f37220d.size() - 1;
        while (size >= 0) {
            BackStackRecord backStackRecord = (BackStackRecord) this.f37220d.get(size);
            if ((str != null && str.equals(backStackRecord.H())) || (i3 >= 0 && i3 == backStackRecord.f37107v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z2) {
            if (size == this.f37220d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            BackStackRecord backStackRecord2 = (BackStackRecord) this.f37220d.get(size - 1);
            if ((str == null || !str.equals(backStackRecord2.H())) && (i3 < 0 || i3 != backStackRecord2.f37107v)) {
                break;
            }
            size--;
        }
        return size;
    }

    public static Fragment l0(View view) {
        Fragment fragmentQ0 = q0(view);
        if (fragmentQ0 != null) {
            return fragmentQ0;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    private boolean l1(String str, int i3, int i4) {
        e0(false);
        d0(true);
        Fragment fragment = this.f37241y;
        if (fragment != null && i3 < 0 && str == null && fragment.getChildFragmentManager().j1()) {
            return true;
        }
        boolean zM1 = m1(this.M, this.N, str, i3, i4);
        if (zM1) {
            this.f37218b = true;
            try {
                q1(this.M, this.N);
            } finally {
                t();
            }
        }
        N1();
        Z();
        this.f37219c.b();
        return zM1;
    }

    static FragmentManager p0(View view) {
        FragmentActivity fragmentActivity;
        Fragment fragmentQ0 = q0(view);
        if (fragmentQ0 != null) {
            if (fragmentQ0.isAdded()) {
                return fragmentQ0.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + fragmentQ0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                fragmentActivity = null;
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    static Fragment q0(View view) {
        while (view != null) {
            Fragment fragmentL0 = L0(view);
            if (fragmentL0 != null) {
                return fragmentL0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void q1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (!((BackStackRecord) arrayList.get(i3)).f37351r) {
                if (i4 != i3) {
                    h0(arrayList, arrayList2, i4, i3);
                }
                i4 = i3 + 1;
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    while (i4 < size && ((Boolean) arrayList2.get(i4)).booleanValue() && !((BackStackRecord) arrayList.get(i4)).f37351r) {
                        i4++;
                    }
                }
                h0(arrayList, arrayList2, i3, i4);
                i3 = i4 - 1;
            }
            i3++;
        }
        if (i4 != size) {
            h0(arrayList, arrayList2, i4, size);
        }
    }

    private void r0() {
        Iterator it = x().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).o();
        }
    }

    private void s() {
        if (Y0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private Set s0(BackStackRecord backStackRecord) {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < backStackRecord.f37336c.size(); i3++) {
            Fragment fragment = ((FragmentTransaction.Op) backStackRecord.f37336c.get(i3)).f37354b;
            if (fragment != null && backStackRecord.f37342i) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    private void s1() {
        if (this.f37229m != null) {
            for (int i3 = 0; i3 < this.f37229m.size(); i3++) {
                ((OnBackStackChangedListener) this.f37229m.get(i3)).onBackStackChanged();
            }
        }
    }

    private void t() {
        this.f37218b = false;
        this.N.clear();
        this.M.clear();
    }

    private boolean t0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f37217a) {
            if (this.f37217a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f37217a.size();
                boolean zA = false;
                for (int i3 = 0; i3 < size; i3++) {
                    zA |= ((OpGenerator) this.f37217a.get(i3)).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f37217a.clear();
                this.f37238v.g().removeCallbacks(this.R);
            }
        }
    }

    private void v() {
        FragmentHostCallback fragmentHostCallback = this.f37238v;
        if (fragmentHostCallback instanceof ViewModelStoreOwner ? this.f37219c.p().H0() : fragmentHostCallback.f() instanceof Activity ? !((Activity) this.f37238v.f()).isChangingConfigurations() : true) {
            Iterator it = this.f37226j.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).f37123a.iterator();
                while (it2.hasNext()) {
                    this.f37219c.p().A0((String) it2.next(), false);
                }
            }
        }
    }

    static int w1(int i3) {
        if (i3 == 4097) {
            return 8194;
        }
        if (i3 == 8194) {
            return 4097;
        }
        if (i3 == 8197) {
            return 4100;
        }
        if (i3 != 4099) {
            return i3 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    private Set x() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f37219c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((FragmentStateManager) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.s(viewGroup, J0()));
            }
        }
        return hashSet;
    }

    private FragmentManagerViewModel x0(Fragment fragment) {
        return this.P.D0(fragment);
    }

    private Set y(ArrayList arrayList, int i3, int i4) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i3 < i4) {
            ArrayList arrayList2 = ((BackStackRecord) arrayList.get(i3)).f37336c;
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList2.get(i5);
                i5++;
                Fragment fragment = ((FragmentTransaction.Op) obj).f37354b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.r(viewGroup, this));
                }
            }
            i3++;
        }
        return hashSet;
    }

    void A(Fragment fragment) {
        if (R0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (R0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f37219c.u(fragment);
            if (S0(fragment)) {
                this.H = true;
            }
            I1(fragment);
        }
    }

    public Fragment.SavedState A1(Fragment fragment) {
        FragmentStateManager fragmentStateManagerN = this.f37219c.n(fragment.mWho);
        if (fragmentStateManagerN == null || !fragmentStateManagerN.k().equals(fragment)) {
            L1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return fragmentStateManagerN.q();
    }

    void B() {
        this.I = false;
        this.J = false;
        this.P.J0(false);
        W(4);
    }

    public FragmentFactory B0() {
        FragmentFactory fragmentFactory = this.f37242z;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.f37240x;
        return fragment != null ? fragment.mFragmentManager.B0() : this.A;
    }

    void B1() {
        synchronized (this.f37217a) {
            try {
                if (this.f37217a.size() == 1) {
                    this.f37238v.g().removeCallbacks(this.R);
                    this.f37238v.g().post(this.R);
                    N1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void C() {
        this.I = false;
        this.J = false;
        this.P.J0(false);
        W(0);
    }

    FragmentStore C0() {
        return this.f37219c;
    }

    void C1(Fragment fragment, boolean z2) {
        ViewGroup viewGroupA0 = A0(fragment);
        if (viewGroupA0 == null || !(viewGroupA0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupA0).setDrawDisappearingViewsLast(!z2);
    }

    void D(Configuration configuration, boolean z2) {
        if (z2 && (this.f37238v instanceof OnConfigurationChangedProvider)) {
            L1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z2) {
                    fragment.mChildFragmentManager.D(configuration, true);
                }
            }
        }
    }

    public List D0() {
        return this.f37219c.o();
    }

    public void D1(FragmentFactory fragmentFactory) {
        this.f37242z = fragmentFactory;
    }

    boolean E(MenuItem menuItem) {
        if (this.f37237u < 1) {
            return false;
        }
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public FragmentHostCallback E0() {
        return this.f37238v;
    }

    public final void E1(String str, Bundle bundle) {
        LifecycleAwareResultListener lifecycleAwareResultListener = (LifecycleAwareResultListener) this.f37228l.get(str);
        if (lifecycleAwareResultListener == null || !lifecycleAwareResultListener.b(Lifecycle.State.f39950d)) {
            this.f37227k.put(str, bundle);
        } else {
            lifecycleAwareResultListener.a(str, bundle);
        }
        if (R0(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    void F() {
        this.I = false;
        this.J = false;
        this.P.J0(false);
        W(1);
    }

    LayoutInflater.Factory2 F0() {
        return this.f37222f;
    }

    public final void F1(final String str, LifecycleOwner lifecycleOwner, final FragmentResultListener fragmentResultListener) {
        final Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.f39947a) {
            return;
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.fragment.app.FragmentManager.6
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void j(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                Bundle bundle;
                if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.f37227k.get(str)) != null) {
                    fragmentResultListener.a(str, bundle);
                    FragmentManager.this.w(str);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver(this);
                    FragmentManager.this.f37228l.remove(str);
                }
            }
        };
        LifecycleAwareResultListener lifecycleAwareResultListener = (LifecycleAwareResultListener) this.f37228l.put(str, new LifecycleAwareResultListener(lifecycle, fragmentResultListener, lifecycleEventObserver));
        if (lifecycleAwareResultListener != null) {
            lifecycleAwareResultListener.c();
        }
        if (R0(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + fragmentResultListener);
        }
        lifecycle.addObserver(lifecycleEventObserver);
    }

    boolean G(Menu menu, MenuInflater menuInflater) {
        if (this.f37237u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null && V0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f37221e != null) {
            for (int i3 = 0; i3 < this.f37221e.size(); i3++) {
                Fragment fragment2 = (Fragment) this.f37221e.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f37221e = arrayList;
        return z2;
    }

    FragmentLifecycleCallbacksDispatcher G0() {
        return this.f37230n;
    }

    void G1(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(j0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void H() {
        this.K = true;
        e0(true);
        b0();
        v();
        W(-1);
        Object obj = this.f37238v;
        if (obj instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) obj).removeOnTrimMemoryListener(this.f37233q);
        }
        Object obj2 = this.f37238v;
        if (obj2 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) obj2).removeOnConfigurationChangedListener(this.f37232p);
        }
        Object obj3 = this.f37238v;
        if (obj3 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) obj3).removeOnMultiWindowModeChangedListener(this.f37234r);
        }
        Object obj4 = this.f37238v;
        if (obj4 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) obj4).removeOnPictureInPictureModeChangedListener(this.f37235s);
        }
        Object obj5 = this.f37238v;
        if ((obj5 instanceof MenuHost) && this.f37240x == null) {
            ((MenuHost) obj5).removeMenuProvider(this.f37236t);
        }
        this.f37238v = null;
        this.f37239w = null;
        this.f37240x = null;
        if (this.f37223g != null) {
            this.f37224h.remove();
            this.f37223g = null;
        }
        ActivityResultLauncher activityResultLauncher = this.D;
        if (activityResultLauncher != null) {
            activityResultLauncher.d();
            this.E.d();
            this.F.d();
        }
    }

    Fragment H0() {
        return this.f37240x;
    }

    void H1(Fragment fragment) {
        if (fragment == null || (fragment.equals(j0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f37241y;
            this.f37241y = fragment;
            P(fragment2);
            P(this.f37241y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void I() {
        W(1);
    }

    public Fragment I0() {
        return this.f37241y;
    }

    void J(boolean z2) {
        if (z2 && (this.f37238v instanceof OnTrimMemoryProvider)) {
            L1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z2) {
                    fragment.mChildFragmentManager.J(true);
                }
            }
        }
    }

    SpecialEffectsControllerFactory J0() {
        SpecialEffectsControllerFactory specialEffectsControllerFactory = this.B;
        if (specialEffectsControllerFactory != null) {
            return specialEffectsControllerFactory;
        }
        Fragment fragment = this.f37240x;
        return fragment != null ? fragment.mFragmentManager.J0() : this.C;
    }

    void J1(Fragment fragment) {
        if (R0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    void K(boolean z2, boolean z3) {
        if (z3 && (this.f37238v instanceof OnMultiWindowModeChangedProvider)) {
            L1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
                if (z3) {
                    fragment.mChildFragmentManager.K(z2, true);
                }
            }
        }
    }

    public FragmentStrictMode.Policy K0() {
        return this.Q;
    }

    void L(Fragment fragment) {
        Iterator it = this.f37231o.iterator();
        while (it.hasNext()) {
            ((FragmentOnAttachListener) it.next()).a(this, fragment);
        }
    }

    void M() {
        for (Fragment fragment : this.f37219c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.M();
            }
        }
    }

    ViewModelStore M0(Fragment fragment) {
        return this.P.G0(fragment);
    }

    public void M1(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.f37230n.p(fragmentLifecycleCallbacks);
    }

    boolean N(MenuItem menuItem) {
        if (this.f37237u < 1) {
            return false;
        }
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void N0() {
        e0(true);
        if (this.f37224h.isEnabled()) {
            j1();
        } else {
            this.f37223g.l();
        }
    }

    void O(Menu menu) {
        if (this.f37237u < 1) {
            return;
        }
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    void O0(Fragment fragment) {
        if (R0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        I1(fragment);
    }

    void P0(Fragment fragment) {
        if (fragment.mAdded && S0(fragment)) {
            this.H = true;
        }
    }

    void Q() {
        W(5);
    }

    public boolean Q0() {
        return this.K;
    }

    void R(boolean z2, boolean z3) {
        if (z3 && (this.f37238v instanceof OnPictureInPictureModeChangedProvider)) {
            L1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
                if (z3) {
                    fragment.mChildFragmentManager.R(z2, true);
                }
            }
        }
    }

    boolean S(Menu menu) {
        boolean z2 = false;
        if (this.f37237u < 1) {
            return false;
        }
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null && V0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    void T() {
        N1();
        P(this.f37241y);
    }

    void U() {
        this.I = false;
        this.J = false;
        this.P.J0(false);
        W(7);
    }

    boolean U0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    void V() {
        this.I = false;
        this.J = false;
        this.P.J0(false);
        W(5);
    }

    boolean V0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    boolean W0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.I0()) && W0(fragmentManager.f37240x);
    }

    void X() {
        this.J = true;
        this.P.J0(true);
        W(4);
    }

    boolean X0(int i3) {
        return this.f37237u >= i3;
    }

    void Y() {
        W(2);
    }

    public boolean Y0() {
        return this.I || this.J;
    }

    void Z0(Fragment fragment, String[] strArr, int i3) {
        if (this.F == null) {
            this.f37238v.k(fragment, strArr, i3);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i3));
        this.F.b(strArr);
    }

    void a1(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        if (this.D == null) {
            this.f37238v.m(fragment, intent, i3, bundle);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i3));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.D.b(intent);
    }

    void b1(Fragment fragment, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (this.E == null) {
            this.f37238v.n(fragment, intentSender, i3, intent, i4, i5, i6, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (R0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + fragment);
            }
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.Builder(intentSender).b(intent).c(i5, i4).a();
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i3));
        if (R0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.E.b(intentSenderRequestA);
    }

    void c0(OpGenerator opGenerator, boolean z2) {
        if (!z2) {
            if (this.f37238v == null) {
                if (!this.K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            s();
        }
        synchronized (this.f37217a) {
            try {
                if (this.f37238v == null) {
                    if (!z2) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f37217a.add(opGenerator);
                    B1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void c1(int i3, boolean z2) {
        FragmentHostCallback fragmentHostCallback;
        if (this.f37238v == null && i3 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || i3 != this.f37237u) {
            this.f37237u = i3;
            this.f37219c.t();
            K1();
            if (this.H && (fragmentHostCallback = this.f37238v) != null && this.f37237u == 7) {
                fragmentHostCallback.o();
                this.H = false;
            }
        }
    }

    void d1() {
        if (this.f37238v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.J0(false);
        for (Fragment fragment : this.f37219c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    boolean e0(boolean z2) {
        d0(z2);
        boolean z3 = false;
        while (t0(this.M, this.N)) {
            z3 = true;
            this.f37218b = true;
            try {
                q1(this.M, this.N);
            } finally {
                t();
            }
        }
        N1();
        Z();
        this.f37219c.b();
        return z3;
    }

    void e1(FragmentContainerView fragmentContainerView) {
        View view;
        for (FragmentStateManager fragmentStateManager : this.f37219c.k()) {
            Fragment fragmentK = fragmentStateManager.k();
            if (fragmentK.mContainerId == fragmentContainerView.getId() && (view = fragmentK.mView) != null && view.getParent() == null) {
                fragmentK.mContainer = fragmentContainerView;
                fragmentStateManager.b();
            }
        }
    }

    void f0(OpGenerator opGenerator, boolean z2) {
        if (z2 && (this.f37238v == null || this.K)) {
            return;
        }
        d0(z2);
        if (opGenerator.a(this.M, this.N)) {
            this.f37218b = true;
            try {
                q1(this.M, this.N);
            } finally {
                t();
            }
        }
        N1();
        Z();
        this.f37219c.b();
    }

    void f1(FragmentStateManager fragmentStateManager) {
        Fragment fragmentK = fragmentStateManager.k();
        if (fragmentK.mDeferStart) {
            if (this.f37218b) {
                this.L = true;
            } else {
                fragmentK.mDeferStart = false;
                fragmentStateManager.m();
            }
        }
    }

    public void g1(int i3, int i4) {
        h1(i3, i4, false);
    }

    void h1(int i3, int i4, boolean z2) {
        if (i3 >= 0) {
            c0(new PopBackStackState(null, i3, i4), z2);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i3);
    }

    void i(BackStackRecord backStackRecord) {
        if (this.f37220d == null) {
            this.f37220d = new ArrayList();
        }
        this.f37220d.add(backStackRecord);
    }

    public boolean i0() {
        boolean zE0 = e0(true);
        r0();
        return zE0;
    }

    public void i1(String str, int i3) {
        c0(new PopBackStackState(str, -1, i3), false);
    }

    FragmentStateManager j(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.h(fragment, str);
        }
        if (R0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        FragmentStateManager fragmentStateManagerZ = z(fragment);
        fragment.mFragmentManager = this;
        this.f37219c.r(fragmentStateManagerZ);
        if (!fragment.mDetached) {
            this.f37219c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (S0(fragment)) {
                this.H = true;
            }
        }
        return fragmentStateManagerZ;
    }

    Fragment j0(String str) {
        return this.f37219c.f(str);
    }

    public boolean j1() {
        return l1(null, -1, 0);
    }

    public void k(FragmentOnAttachListener fragmentOnAttachListener) {
        this.f37231o.add(fragmentOnAttachListener);
    }

    public boolean k1(int i3, int i4) {
        if (i3 >= 0) {
            return l1(null, i3, i4);
        }
        throw new IllegalArgumentException("Bad id: " + i3);
    }

    public void l(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f37229m == null) {
            this.f37229m = new ArrayList();
        }
        this.f37229m.add(onBackStackChangedListener);
    }

    void m(Fragment fragment) {
        this.P.y0(fragment);
    }

    public Fragment m0(int i3) {
        return this.f37219c.g(i3);
    }

    boolean m1(ArrayList arrayList, ArrayList arrayList2, String str, int i3, int i4) {
        int iK0 = k0(str, i3, (i4 & 1) != 0);
        if (iK0 < 0) {
            return false;
        }
        for (int size = this.f37220d.size() - 1; size >= iK0; size--) {
            arrayList.add((BackStackRecord) this.f37220d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    int n() {
        return this.f37225i.getAndIncrement();
    }

    public Fragment n0(String str) {
        return this.f37219c.h(str);
    }

    public void n1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            L1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void o(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, final Fragment fragment) {
        String str;
        if (this.f37238v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f37238v = fragmentHostCallback;
        this.f37239w = fragmentContainer;
        this.f37240x = fragment;
        if (fragment != null) {
            k(new FragmentOnAttachListener() { // from class: androidx.fragment.app.FragmentManager.7
                @Override // androidx.fragment.app.FragmentOnAttachListener
                public void a(FragmentManager fragmentManager, Fragment fragment2) {
                    fragment.onAttachFragment(fragment2);
                }
            });
        } else if (fragmentHostCallback instanceof FragmentOnAttachListener) {
            k((FragmentOnAttachListener) fragmentHostCallback);
        }
        if (this.f37240x != null) {
            N1();
        }
        if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
            OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
            this.f37223g = onBackPressedDispatcher;
            LifecycleOwner lifecycleOwner = onBackPressedDispatcherOwner;
            if (fragment != null) {
                lifecycleOwner = fragment;
            }
            onBackPressedDispatcher.i(lifecycleOwner, this.f37224h);
        }
        if (fragment != null) {
            this.P = fragment.mFragmentManager.x0(fragment);
        } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            this.P = FragmentManagerViewModel.E0(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore());
        } else {
            this.P = new FragmentManagerViewModel(false);
        }
        this.P.J0(Y0());
        this.f37219c.A(this.P);
        Object obj = this.f37238v;
        if ((obj instanceof SavedStateRegistryOwner) && fragment == null) {
            SavedStateRegistry savedStateRegistry = ((SavedStateRegistryOwner) obj).getSavedStateRegistry();
            savedStateRegistry.c("android:support:fragments", new SavedStateRegistry.SavedStateProvider() { // from class: androidx.fragment.app.s
                @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
                public final Bundle a() {
                    return this.f37490a.x1();
                }
            });
            Bundle bundleA = savedStateRegistry.a("android:support:fragments");
            if (bundleA != null) {
                v1(bundleA);
            }
        }
        Object obj2 = this.f37238v;
        if (obj2 instanceof ActivityResultRegistryOwner) {
            ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) obj2).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.D = activityResultRegistry.l(str2 + "StartActivityForResult", new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.8
                @Override // androidx.activity.result.ActivityResultCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onActivityResult(ActivityResult activityResult) {
                    LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.G.pollLast();
                    if (launchedFragmentInfo == null) {
                        Log.w("FragmentManager", "No Activities were started for result for " + this);
                        return;
                    }
                    String str3 = launchedFragmentInfo.f37259a;
                    int i3 = launchedFragmentInfo.f37260b;
                    Fragment fragmentI = FragmentManager.this.f37219c.i(str3);
                    if (fragmentI != null) {
                        fragmentI.onActivityResult(i3, activityResult.d(), activityResult.c());
                        return;
                    }
                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                }
            });
            this.E = activityResultRegistry.l(str2 + "StartIntentSenderForResult", new FragmentIntentSenderContract(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.9
                @Override // androidx.activity.result.ActivityResultCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onActivityResult(ActivityResult activityResult) {
                    LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.G.pollFirst();
                    if (launchedFragmentInfo == null) {
                        Log.w("FragmentManager", "No IntentSenders were started for " + this);
                        return;
                    }
                    String str3 = launchedFragmentInfo.f37259a;
                    int i3 = launchedFragmentInfo.f37260b;
                    Fragment fragmentI = FragmentManager.this.f37219c.i(str3);
                    if (fragmentI != null) {
                        fragmentI.onActivityResult(i3, activityResult.d(), activityResult.c());
                        return;
                    }
                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                }
            });
            this.F = activityResultRegistry.l(str2 + "RequestPermissions", new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() { // from class: androidx.fragment.app.FragmentManager.10
                @Override // androidx.activity.result.ActivityResultCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onActivityResult(Map map) {
                    String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                    ArrayList arrayList = new ArrayList(map.values());
                    int[] iArr = new int[arrayList.size()];
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        iArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue() ? 0 : -1;
                    }
                    LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.G.pollFirst();
                    if (launchedFragmentInfo == null) {
                        Log.w("FragmentManager", "No permissions were requested for " + this);
                        return;
                    }
                    String str3 = launchedFragmentInfo.f37259a;
                    int i4 = launchedFragmentInfo.f37260b;
                    Fragment fragmentI = FragmentManager.this.f37219c.i(str3);
                    if (fragmentI != null) {
                        fragmentI.onRequestPermissionsResult(i4, strArr, iArr);
                        return;
                    }
                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str3);
                }
            });
        }
        Object obj3 = this.f37238v;
        if (obj3 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) obj3).addOnConfigurationChangedListener(this.f37232p);
        }
        Object obj4 = this.f37238v;
        if (obj4 instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) obj4).addOnTrimMemoryListener(this.f37233q);
        }
        Object obj5 = this.f37238v;
        if (obj5 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) obj5).addOnMultiWindowModeChangedListener(this.f37234r);
        }
        Object obj6 = this.f37238v;
        if (obj6 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) obj6).addOnPictureInPictureModeChangedListener(this.f37235s);
        }
        Object obj7 = this.f37238v;
        if ((obj7 instanceof MenuHost) && fragment == null) {
            ((MenuHost) obj7).addMenuProvider(this.f37236t);
        }
    }

    Fragment o0(String str) {
        return this.f37219c.i(str);
    }

    public void o1(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z2) {
        this.f37230n.o(fragmentLifecycleCallbacks, z2);
    }

    void p(Fragment fragment) {
        if (R0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f37219c.a(fragment);
            if (R0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (S0(fragment)) {
                this.H = true;
            }
        }
    }

    void p1(Fragment fragment) {
        if (R0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        this.f37219c.u(fragment);
        if (S0(fragment)) {
            this.H = true;
        }
        fragment.mRemoving = true;
        I1(fragment);
    }

    public FragmentTransaction q() {
        return new BackStackRecord(this);
    }

    boolean r() {
        boolean zS0 = false;
        for (Fragment fragment : this.f37219c.l()) {
            if (fragment != null) {
                zS0 = S0(fragment);
            }
            if (zS0) {
                return true;
            }
        }
        return false;
    }

    void r1(Fragment fragment) {
        this.P.I0(fragment);
    }

    public void t1(String str) {
        c0(new RestoreBackStackState(str), false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f37240x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f37240x)));
            sb.append("}");
        } else {
            FragmentHostCallback fragmentHostCallback = this.f37238v;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f37238v)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    boolean u(ArrayList arrayList, ArrayList arrayList2, String str) {
        if (u1(arrayList, arrayList2, str)) {
            return m1(arrayList, arrayList2, str, -1, 1);
        }
        return false;
    }

    List u0() {
        return this.f37219c.l();
    }

    boolean u1(ArrayList arrayList, ArrayList arrayList2, String str) {
        BackStackState backStackState = (BackStackState) this.f37226j.remove(str);
        if (backStackState == null) {
            return false;
        }
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            BackStackRecord backStackRecord = (BackStackRecord) obj;
            if (backStackRecord.f37108w) {
                ArrayList arrayList3 = backStackRecord.f37336c;
                int size2 = arrayList3.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayList3.get(i4);
                    i4++;
                    Fragment fragment = ((FragmentTransaction.Op) obj2).f37354b;
                    if (fragment != null) {
                        map.put(fragment.mWho, fragment);
                    }
                }
            }
        }
        Iterator it = backStackState.a(this, map).iterator();
        while (true) {
            boolean z2 = false;
            while (it.hasNext()) {
                if (((BackStackRecord) it.next()).a(arrayList, arrayList2) || z2) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    public BackStackEntry v0(int i3) {
        return (BackStackEntry) this.f37220d.get(i3);
    }

    public final void w(String str) {
        this.f37227k.remove(str);
        if (R0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public int w0() {
        ArrayList arrayList = this.f37220d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle x1() {
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        r0();
        b0();
        e0(true);
        this.I = true;
        this.P.J0(true);
        ArrayList arrayListY = this.f37219c.y();
        HashMap mapM = this.f37219c.m();
        if (!mapM.isEmpty()) {
            ArrayList arrayListZ = this.f37219c.z();
            ArrayList arrayList = this.f37220d;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i3 = 0; i3 < size; i3++) {
                    backStackRecordStateArr[i3] = new BackStackRecordState((BackStackRecord) this.f37220d.get(i3));
                    if (R0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f37220d.get(i3));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f37272a = arrayListY;
            fragmentManagerState.f37273b = arrayListZ;
            fragmentManagerState.f37274c = backStackRecordStateArr;
            fragmentManagerState.f37275d = this.f37225i.get();
            Fragment fragment = this.f37241y;
            if (fragment != null) {
                fragmentManagerState.f37276f = fragment.mWho;
            }
            fragmentManagerState.f37277g.addAll(this.f37226j.keySet());
            fragmentManagerState.f37278h.addAll(this.f37226j.values());
            fragmentManagerState.f37279i = new ArrayList(this.G);
            bundle.putParcelable(ServerProtocol.DIALOG_PARAM_STATE, fragmentManagerState);
            for (String str : this.f37227k.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f37227k.get(str));
            }
            for (String str2 : mapM.keySet()) {
                bundle.putBundle("fragment_" + str2, (Bundle) mapM.get(str2));
            }
        } else if (R0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    FragmentContainer y0() {
        return this.f37239w;
    }

    public void y1(String str) {
        c0(new SaveBackStackState(str), false);
    }

    FragmentStateManager z(Fragment fragment) {
        FragmentStateManager fragmentStateManagerN = this.f37219c.n(fragment.mWho);
        if (fragmentStateManagerN != null) {
            return fragmentStateManagerN;
        }
        FragmentStateManager fragmentStateManager = new FragmentStateManager(this.f37230n, this.f37219c, fragment);
        fragmentStateManager.o(this.f37238v.f().getClassLoader());
        fragmentStateManager.t(this.f37237u);
        return fragmentStateManager;
    }

    public Fragment z0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentJ0 = j0(string);
        if (fragmentJ0 == null) {
            L1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentJ0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean z1(java.util.ArrayList r19, java.util.ArrayList r20, java.lang.String r21) {
        /*
            Method dump skipped, instruction units count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.z1(java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    public void a0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f37219c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f37221e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                Fragment fragment = (Fragment) this.f37221e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList2 = this.f37220d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                BackStackRecord backStackRecord = (BackStackRecord) this.f37220d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.C(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f37225i.get());
        synchronized (this.f37217a) {
            try {
                int size3 = this.f37217a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size3; i5++) {
                        OpGenerator opGenerator = (OpGenerator) this.f37217a.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(opGenerator);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println(QgXempTBEfV.RIWwrS);
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f37238v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f37239w);
        if (this.f37240x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f37240x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f37237u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    void v1(Parcelable parcelable) {
        FragmentStateManager fragmentStateManager;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f37238v.f().getClassLoader());
                this.f37227k.put(str.substring(7), bundle2);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f37238v.f().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.f37219c.x(map);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable(ServerProtocol.DIALOG_PARAM_STATE);
        if (fragmentManagerState == null) {
            return;
        }
        this.f37219c.v();
        ArrayList arrayList = fragmentManagerState.f37272a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Bundle bundleB = this.f37219c.B((String) obj, null);
            if (bundleB != null) {
                Fragment fragmentC0 = this.P.C0(((FragmentState) bundleB.getParcelable(ServerProtocol.DIALOG_PARAM_STATE)).f37289b);
                if (fragmentC0 != null) {
                    if (R0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentC0);
                    }
                    fragmentStateManager = new FragmentStateManager(this.f37230n, this.f37219c, fragmentC0, bundleB);
                } else {
                    fragmentStateManager = new FragmentStateManager(this.f37230n, this.f37219c, this.f37238v.f().getClassLoader(), B0(), bundleB);
                }
                Fragment fragmentK = fragmentStateManager.k();
                fragmentK.mSavedFragmentState = bundleB;
                fragmentK.mFragmentManager = this;
                if (R0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK.mWho + "): " + fragmentK);
                }
                fragmentStateManager.o(this.f37238v.f().getClassLoader());
                this.f37219c.r(fragmentStateManager);
                fragmentStateManager.t(this.f37237u);
            }
        }
        for (Fragment fragment : this.P.F0()) {
            if (!this.f37219c.c(fragment.mWho)) {
                if (R0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f37272a);
                }
                this.P.I0(fragment);
                fragment.mFragmentManager = this;
                FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.f37230n, this.f37219c, fragment);
                fragmentStateManager2.t(1);
                fragmentStateManager2.m();
                fragment.mRemoving = true;
                fragmentStateManager2.m();
            }
        }
        this.f37219c.w(fragmentManagerState.f37273b);
        if (fragmentManagerState.f37274c != null) {
            this.f37220d = new ArrayList(fragmentManagerState.f37274c.length);
            int i4 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f37274c;
                if (i4 >= backStackRecordStateArr.length) {
                    break;
                }
                BackStackRecord backStackRecordC = backStackRecordStateArr[i4].c(this);
                if (R0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i4 + " (index " + backStackRecordC.f37107v + "): " + backStackRecordC);
                    PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                    backStackRecordC.D(cJfnYMIyomoWf.bHZAihvYGET, printWriter, false);
                    printWriter.close();
                }
                this.f37220d.add(backStackRecordC);
                i4++;
            }
        } else {
            this.f37220d = null;
        }
        this.f37225i.set(fragmentManagerState.f37275d);
        String str3 = fragmentManagerState.f37276f;
        if (str3 != null) {
            Fragment fragmentJ0 = j0(str3);
            this.f37241y = fragmentJ0;
            P(fragmentJ0);
        }
        ArrayList arrayList2 = fragmentManagerState.f37277g;
        if (arrayList2 != null) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                this.f37226j.put((String) arrayList2.get(i5), (BackStackState) fragmentManagerState.f37278h.get(i5));
            }
        }
        this.G = new ArrayDeque(fragmentManagerState.f37279i);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>() { // from class: androidx.fragment.app.FragmentManager.LaunchedFragmentInfo.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i3) {
                return new LaunchedFragmentInfo[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f37259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f37260b;

        LaunchedFragmentInfo(String str, int i3) {
            this.f37259a = str;
            this.f37260b = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f37259a);
            parcel.writeInt(this.f37260b);
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.f37259a = parcel.readString();
            this.f37260b = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class FragmentLifecycleCallbacks {
        public void d(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void e(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void f(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void i(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void k(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void l(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void n(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void g(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void h(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void j(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface OnBackStackChangedListener {
        void onBackStackChanged();

        default void a(Fragment fragment, boolean z2) {
        }

        default void b(Fragment fragment, boolean z2) {
        }
    }
}
