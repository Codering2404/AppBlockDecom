package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.SpecialEffectsController;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class SpecialEffectsController {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f37431f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f37432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f37433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f37434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37436e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SpecialEffectsController a(ViewGroup container, FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            SpecialEffectsControllerFactory specialEffectsControllerFactoryJ0 = fragmentManager.J0();
            Intrinsics.checkNotNullExpressionValue(specialEffectsControllerFactoryJ0, "fragmentManager.specialEffectsControllerFactory");
            return b(container, specialEffectsControllerFactoryJ0);
        }

        public final SpecialEffectsController b(ViewGroup container, SpecialEffectsControllerFactory factory) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(factory, "factory");
            int i3 = R.id.f37096b;
            Object tag = container.getTag(i3);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            SpecialEffectsController specialEffectsControllerA = factory.a(container);
            Intrinsics.checkNotNullExpressionValue(specialEffectsControllerA, "factory.createController(container)");
            container.setTag(i3, specialEffectsControllerA);
            return specialEffectsControllerA;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class FragmentStateManagerOperation extends Operation {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final FragmentStateManager f37437h;

        /* JADX WARN: Illegal instructions before constructor call */
        public FragmentStateManagerOperation(Operation.State finalState, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(finalState, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
            Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
            Fragment fragmentK = fragmentStateManager.k();
            Intrinsics.checkNotNullExpressionValue(fragmentK, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, fragmentK, cancellationSignal);
            this.f37437h = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void e() {
            super.e();
            this.f37437h.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void n() {
            if (i() != Operation.LifecycleImpact.ADDING) {
                if (i() == Operation.LifecycleImpact.f37447c) {
                    Fragment fragmentK = this.f37437h.k();
                    Intrinsics.checkNotNullExpressionValue(fragmentK, "fragmentStateManager.fragment");
                    View viewRequireView = fragmentK.requireView();
                    Intrinsics.checkNotNullExpressionValue(viewRequireView, "fragment.requireView()");
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragmentK);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.f37437h.k();
            Intrinsics.checkNotNullExpressionValue(fragmentK2, "fragmentStateManager.fragment");
            View viewFindFocus = fragmentK2.mView.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.setFocusedView(viewFindFocus);
                if (FragmentManager.R0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK2);
                }
            }
            View viewRequireView2 = h().requireView();
            Intrinsics.checkNotNullExpressionValue(viewRequireView2, "this.fragment.requireView()");
            if (viewRequireView2.getParent() == null) {
                this.f37437h.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragmentK2.getPostOnViewCreatedAlpha());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static class Operation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private State f37438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LifecycleImpact f37439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Fragment f37440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f37441d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Set f37442e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f37443f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f37444g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public enum LifecycleImpact {
            NONE,
            ADDING,
            f37447c
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        @Metadata
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Companion f37449a = new Companion(null);

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final State a(View view) {
                    Intrinsics.checkNotNullParameter(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? State.INVISIBLE : b(view.getVisibility());
                }

                public final State b(int i3) {
                    if (i3 == 0) {
                        return State.VISIBLE;
                    }
                    if (i3 == 4) {
                        return State.INVISIBLE;
                    }
                    if (i3 == 8) {
                        return State.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i3);
                }

                private Companion() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f37455a;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f37455a = iArr;
                }
            }

            public static final State c(int i3) {
                return f37449a.b(i3);
            }

            public final void b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                int i3 = WhenMappings.f37455a[ordinal()];
                if (i3 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (FragmentManager.R0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i3 == 2) {
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i3 == 3) {
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i3 != 4) {
                    return;
                }
                if (FragmentManager.R0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f37456a;

            static {
                int[] iArr = new int[LifecycleImpact.values().length];
                try {
                    iArr[LifecycleImpact.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LifecycleImpact.f37447c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LifecycleImpact.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f37456a = iArr;
            }
        }

        public Operation(State finalState, LifecycleImpact lifecycleImpact, Fragment fragment, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(finalState, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
            this.f37438a = finalState;
            this.f37439b = lifecycleImpact;
            this.f37440c = fragment;
            this.f37441d = new ArrayList();
            this.f37442e = new LinkedHashSet();
            cancellationSignal.c(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.v
                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                public final void onCancel() {
                    SpecialEffectsController.Operation.b(this.f37521a);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Operation this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.d();
        }

        public final void c(Runnable listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f37441d.add(listener);
        }

        public final void d() {
            if (this.f37443f) {
                return;
            }
            this.f37443f = true;
            if (this.f37442e.isEmpty()) {
                e();
                return;
            }
            Iterator it = CollectionsKt.toMutableSet(this.f37442e).iterator();
            while (it.hasNext()) {
                ((CancellationSignal) it.next()).a();
            }
        }

        public void e() {
            if (this.f37444g) {
                return;
            }
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f37444g = true;
            Iterator it = this.f37441d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void f(CancellationSignal signal) {
            Intrinsics.checkNotNullParameter(signal, "signal");
            if (this.f37442e.remove(signal) && this.f37442e.isEmpty()) {
                e();
            }
        }

        public final State g() {
            return this.f37438a;
        }

        public final Fragment h() {
            return this.f37440c;
        }

        public final LifecycleImpact i() {
            return this.f37439b;
        }

        public final boolean j() {
            return this.f37443f;
        }

        public final boolean k() {
            return this.f37444g;
        }

        public final void l(CancellationSignal signal) {
            Intrinsics.checkNotNullParameter(signal, "signal");
            n();
            this.f37442e.add(signal);
        }

        public void n() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f37438a + " lifecycleImpact = " + this.f37439b + " fragment = " + this.f37440c + '}';
        }

        public final void m(State finalState, LifecycleImpact lifecycleImpact) {
            Intrinsics.checkNotNullParameter(finalState, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            int i3 = WhenMappings.f37456a[lifecycleImpact.ordinal()];
            if (i3 == 1) {
                if (this.f37438a == State.REMOVED) {
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f37440c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f37439b + " to ADDING.");
                    }
                    this.f37438a = State.VISIBLE;
                    this.f37439b = LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (i3 == 2) {
                if (FragmentManager.R0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f37440c + " mFinalState = " + this.f37438a + jlWo.NCR + this.f37439b + " to REMOVING.");
                }
                this.f37438a = State.REMOVED;
                this.f37439b = LifecycleImpact.f37447c;
                return;
            }
            if (i3 == 3 && this.f37438a != State.REMOVED) {
                if (FragmentManager.R0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f37440c + " mFinalState = " + this.f37438a + " -> " + finalState + '.');
                }
                this.f37438a = finalState;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37457a;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f37457a = iArr;
        }
    }

    public SpecialEffectsController(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.f37432a = container;
        this.f37433b = new ArrayList();
        this.f37434c = new ArrayList();
    }

    private final void c(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        synchronized (this.f37433b) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Fragment fragmentK = fragmentStateManager.k();
            Intrinsics.checkNotNullExpressionValue(fragmentK, "fragmentStateManager.fragment");
            Operation operationL = l(fragmentK);
            if (operationL != null) {
                operationL.m(state, lifecycleImpact);
                return;
            }
            final FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.f37433b.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.c(new Runnable() { // from class: androidx.fragment.app.t
                @Override // java.lang.Runnable
                public final void run() {
                    SpecialEffectsController.d(this.f37517a, fragmentStateManagerOperation);
                }
            });
            fragmentStateManagerOperation.c(new Runnable() { // from class: androidx.fragment.app.u
                @Override // java.lang.Runnable
                public final void run() {
                    SpecialEffectsController.e(this.f37519a, fragmentStateManagerOperation);
                }
            });
            Unit unit = Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SpecialEffectsController this$0, FragmentStateManagerOperation operation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        if (this$0.f37433b.contains(operation)) {
            Operation.State stateG = operation.g();
            View view = operation.h().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            stateG.b(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SpecialEffectsController this$0, FragmentStateManagerOperation operation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        this$0.f37433b.remove(operation);
        this$0.f37434c.remove(operation);
    }

    private final Operation l(Fragment fragment) {
        Object next;
        Iterator it = this.f37433b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (Intrinsics.areEqual(operation.h(), fragment) && !operation.j()) {
                break;
            }
        }
        return (Operation) next;
    }

    private final Operation m(Fragment fragment) {
        Object next;
        Iterator it = this.f37434c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (Intrinsics.areEqual(operation.h(), fragment) && !operation.j()) {
                break;
            }
        }
        return (Operation) next;
    }

    public static final SpecialEffectsController r(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return f37431f.a(viewGroup, fragmentManager);
    }

    public static final SpecialEffectsController s(ViewGroup viewGroup, SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        return f37431f.b(viewGroup, specialEffectsControllerFactory);
    }

    private final void u() {
        for (Operation operation : this.f37433b) {
            if (operation.i() == Operation.LifecycleImpact.ADDING) {
                View viewRequireView = operation.h().requireView();
                Intrinsics.checkNotNullExpressionValue(viewRequireView, "fragment.requireView()");
                operation.m(Operation.State.f37449a.b(viewRequireView.getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public final void f(Operation.State finalState, FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(finalState, "finalState");
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        c(finalState, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public final void g(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        c(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void h(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        c(Operation.State.REMOVED, Operation.LifecycleImpact.f37447c, fragmentStateManager);
    }

    public final void i(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        c(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public abstract void j(List list, boolean z2);

    public final void k() {
        if (this.f37436e) {
            return;
        }
        if (!ViewCompat.Q(this.f37432a)) {
            n();
            this.f37435d = false;
            return;
        }
        synchronized (this.f37433b) {
            try {
                if (!this.f37433b.isEmpty()) {
                    List<Operation> mutableList = CollectionsKt.toMutableList((Collection) this.f37434c);
                    this.f37434c.clear();
                    for (Operation operation : mutableList) {
                        if (FragmentManager.R0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.d();
                        if (!operation.k()) {
                            this.f37434c.add(operation);
                        }
                    }
                    u();
                    List mutableList2 = CollectionsKt.toMutableList((Collection) this.f37433b);
                    this.f37433b.clear();
                    this.f37434c.addAll(mutableList2);
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it = mutableList2.iterator();
                    while (it.hasNext()) {
                        ((Operation) it.next()).n();
                    }
                    j(mutableList2, this.f37435d);
                    this.f37435d = false;
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n() {
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zQ = ViewCompat.Q(this.f37432a);
        synchronized (this.f37433b) {
            try {
                u();
                Iterator it = this.f37433b.iterator();
                while (it.hasNext()) {
                    ((Operation) it.next()).n();
                }
                for (Operation operation : CollectionsKt.toMutableList((Collection) this.f37434c)) {
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zQ ? "" : "Container " + this.f37432a + " is not attached to window. ") + "Cancelling running operation " + operation);
                    }
                    operation.d();
                }
                for (Operation operation2 : CollectionsKt.toMutableList((Collection) this.f37433b)) {
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zQ ? "" : "Container " + this.f37432a + " is not attached to window. ") + "Cancelling pending operation " + operation2);
                    }
                    operation2.d();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o() {
        if (this.f37436e) {
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f37436e = false;
            k();
        }
    }

    public final Operation.LifecycleImpact p(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        Fragment fragmentK = fragmentStateManager.k();
        Intrinsics.checkNotNullExpressionValue(fragmentK, "fragmentStateManager.fragment");
        Operation operationL = l(fragmentK);
        Operation.LifecycleImpact lifecycleImpactI = operationL != null ? operationL.i() : null;
        Operation operationM = m(fragmentK);
        Operation.LifecycleImpact lifecycleImpactI2 = operationM != null ? operationM.i() : null;
        int i3 = lifecycleImpactI == null ? -1 : WhenMappings.f37457a[lifecycleImpactI.ordinal()];
        return (i3 == -1 || i3 == 1) ? lifecycleImpactI2 : lifecycleImpactI;
    }

    public final ViewGroup q() {
        return this.f37432a;
    }

    public final void t() {
        Object objPrevious;
        synchronized (this.f37433b) {
            try {
                u();
                List list = this.f37433b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    Operation operation = (Operation) objPrevious;
                    Operation.State.Companion companion = Operation.State.f37449a;
                    View view = operation.h().mView;
                    Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                    Operation.State stateA = companion.a(view);
                    Operation.State stateG = operation.g();
                    Operation.State state = Operation.State.VISIBLE;
                    if (stateG == state && stateA != state) {
                        break;
                    }
                }
                Operation operation2 = (Operation) objPrevious;
                Fragment fragmentH = operation2 != null ? operation2.h() : null;
                this.f37436e = fragmentH != null ? fragmentH.isPostponed() : false;
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v(boolean z2) {
        this.f37435d = z2;
    }
}
