package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorState;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
/* JADX INFO: loaded from: classes2.dex */
@Navigator.Name("dialog")
@Metadata
public final class DialogFragmentNavigator extends Navigator<Destination> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Companion f49255i = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f49256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FragmentManager f49257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f49258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DialogFragmentNavigator$observer$1 f49259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f49260h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static class Destination extends NavDestination implements FloatingWindow {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f49261i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(Navigator fragmentNavigator) {
            super(fragmentNavigator);
            Intrinsics.checkNotNullParameter(fragmentNavigator, "fragmentNavigator");
        }

        public final String H() {
            String str = this.f49261i;
            if (str == null) {
                throw new IllegalStateException("DialogFragment class was not set");
            }
            Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
            return str;
        }

        public final Destination I(String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            this.f49261i = className;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && (obj instanceof Destination) && super.equals(obj) && Intrinsics.areEqual(this.f49261i, ((Destination) obj).f49261i);
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            String str = this.f49261i;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // androidx.navigation.NavDestination
        public void x(Context context, AttributeSet attrs) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            super.x(context, attrs);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.f49290a);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
            String string = typedArrayObtainAttributes.getString(R.styleable.f49291b);
            if (string != null) {
                I(string);
            }
            typedArrayObtainAttributes.recycle();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.navigation.fragment.DialogFragmentNavigator$observer$1] */
    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.f49256d = context;
        this.f49257e = fragmentManager;
        this.f49258f = new LinkedHashSet();
        this.f49259g = new LifecycleEventObserver() { // from class: androidx.navigation.fragment.DialogFragmentNavigator$observer$1

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f49263a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f49263a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void j(LifecycleOwner source, Lifecycle.Event event) {
                int iNextIndex;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                int i3 = WhenMappings.f49263a[event.ordinal()];
                if (i3 == 1) {
                    DialogFragment dialogFragment = (DialogFragment) source;
                    Iterable iterable = (Iterable) this.f49262a.d().c().getValue();
                    if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                        Iterator it = iterable.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual(((NavBackStackEntry) it.next()).f(), dialogFragment.getTag())) {
                                return;
                            }
                        }
                    }
                    dialogFragment.dismiss();
                    return;
                }
                Object obj = null;
                if (i3 == 2) {
                    DialogFragment dialogFragment2 = (DialogFragment) source;
                    for (Object obj2 : (Iterable) this.f49262a.d().d().getValue()) {
                        if (Intrinsics.areEqual(((NavBackStackEntry) obj2).f(), dialogFragment2.getTag())) {
                            obj = obj2;
                        }
                    }
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                    if (navBackStackEntry != null) {
                        this.f49262a.d().f(navBackStackEntry);
                        return;
                    }
                    return;
                }
                if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                    DialogFragment dialogFragment3 = (DialogFragment) source;
                    for (Object obj3 : (Iterable) this.f49262a.d().d().getValue()) {
                        if (Intrinsics.areEqual(((NavBackStackEntry) obj3).f(), dialogFragment3.getTag())) {
                            obj = obj3;
                        }
                    }
                    NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
                    if (navBackStackEntry2 != null) {
                        this.f49262a.d().f(navBackStackEntry2);
                    }
                    dialogFragment3.getLifecycle().removeObserver(this);
                    return;
                }
                DialogFragment dialogFragment4 = (DialogFragment) source;
                if (dialogFragment4.requireDialog().isShowing()) {
                    return;
                }
                List list = (List) this.f49262a.d().c().getValue();
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (Intrinsics.areEqual(((NavBackStackEntry) listIterator.previous()).f(), dialogFragment4.getTag())) {
                            iNextIndex = listIterator.nextIndex();
                            break;
                        }
                    } else {
                        iNextIndex = -1;
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) CollectionsKt.getOrNull(list, iNextIndex);
                if (!Intrinsics.areEqual(CollectionsKt.lastOrNull(list), navBackStackEntry3)) {
                    Log.i("DialogFragmentNavigator", "Dialog " + dialogFragment4 + " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
                }
                if (navBackStackEntry3 != null) {
                    this.f49262a.w(iNextIndex, navBackStackEntry3, false);
                }
            }
        };
        this.f49260h = new LinkedHashMap();
    }

    private final DialogFragment t(NavBackStackEntry navBackStackEntry) {
        NavDestination navDestinationD = navBackStackEntry.d();
        Intrinsics.checkNotNull(navDestinationD, "null cannot be cast to non-null type androidx.navigation.fragment.DialogFragmentNavigator.Destination");
        Destination destination = (Destination) navDestinationD;
        String strH = destination.H();
        if (strH.charAt(0) == '.') {
            strH = this.f49256d.getPackageName() + strH;
        }
        Fragment fragmentA = this.f49257e.B0().a(this.f49256d.getClassLoader(), strH);
        Intrinsics.checkNotNullExpressionValue(fragmentA, "instantiate(...)");
        if (DialogFragment.class.isAssignableFrom(fragmentA.getClass())) {
            DialogFragment dialogFragment = (DialogFragment) fragmentA;
            dialogFragment.setArguments(navBackStackEntry.b());
            dialogFragment.getLifecycle().addObserver(this.f49259g);
            this.f49260h.put(navBackStackEntry.f(), dialogFragment);
            return dialogFragment;
        }
        throw new IllegalArgumentException(("Dialog destination " + destination.H() + " is not an instance of DialogFragment").toString());
    }

    private final void u(NavBackStackEntry navBackStackEntry) {
        t(navBackStackEntry).show(this.f49257e, navBackStackEntry.f());
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.lastOrNull((List) d().c().getValue());
        boolean zContains = CollectionsKt.contains((Iterable) d().d().getValue(), navBackStackEntry2);
        d().m(navBackStackEntry);
        if (navBackStackEntry2 == null || zContains) {
            return;
        }
        d().f(navBackStackEntry2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(DialogFragmentNavigator dialogFragmentNavigator, FragmentManager fragmentManager, Fragment childFragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<unused var>");
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        Set set = dialogFragmentNavigator.f49258f;
        if (TypeIntrinsics.a(set).remove(childFragment.getTag())) {
            childFragment.getLifecycle().addObserver(dialogFragmentNavigator.f49259g);
        }
        Map map = dialogFragmentNavigator.f49260h;
        TypeIntrinsics.d(map).remove(childFragment.getTag());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int i3, NavBackStackEntry navBackStackEntry, boolean z2) {
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.getOrNull((List) d().c().getValue(), i3 - 1);
        boolean zContains = CollectionsKt.contains((Iterable) d().d().getValue(), navBackStackEntry2);
        d().j(navBackStackEntry, z2);
        if (navBackStackEntry2 == null || zContains) {
            return;
        }
        d().f(navBackStackEntry2);
    }

    @Override // androidx.navigation.Navigator
    public void g(List entries, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        if (this.f49257e.Y0()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            u((NavBackStackEntry) it.next());
        }
    }

    @Override // androidx.navigation.Navigator
    public void i(NavigatorState state) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(state, "state");
        super.i(state);
        for (NavBackStackEntry navBackStackEntry : (List) state.c().getValue()) {
            DialogFragment dialogFragment = (DialogFragment) this.f49257e.n0(navBackStackEntry.f());
            if (dialogFragment == null || (lifecycle = dialogFragment.getLifecycle()) == null) {
                this.f49258f.add(navBackStackEntry.f());
            } else {
                lifecycle.addObserver(this.f49259g);
            }
        }
        this.f49257e.k(new FragmentOnAttachListener() { // from class: androidx.navigation.fragment.a
            @Override // androidx.fragment.app.FragmentOnAttachListener
            public final void a(FragmentManager fragmentManager, Fragment fragment) {
                DialogFragmentNavigator.v(this.f49296a, fragmentManager, fragment);
            }
        });
    }

    @Override // androidx.navigation.Navigator
    public void n(NavBackStackEntry popUpTo, boolean z2) {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        if (this.f49257e.Y0()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List list = (List) d().c().getValue();
        int iIndexOf = list.indexOf(popUpTo);
        Iterator it = CollectionsKt.reversed(list.subList(iIndexOf, list.size())).iterator();
        while (it.hasNext()) {
            Fragment fragmentN0 = this.f49257e.n0(((NavBackStackEntry) it.next()).f());
            if (fragmentN0 != null) {
                ((DialogFragment) fragmentN0).dismiss();
            }
        }
        w(iIndexOf, popUpTo, z2);
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Destination c() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public void j(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, pMpIcGE.vAjQaFWAEq);
        if (this.f49257e.Y0()) {
            Log.i("DialogFragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        DialogFragment dialogFragment = (DialogFragment) this.f49260h.get(navBackStackEntry.f());
        if (dialogFragment == null) {
            Fragment fragmentN0 = this.f49257e.n0(navBackStackEntry.f());
            dialogFragment = fragmentN0 instanceof DialogFragment ? (DialogFragment) fragmentN0 : null;
        }
        if (dialogFragment != null) {
            dialogFragment.getLifecycle().removeObserver(this.f49259g);
            dialogFragment.dismiss();
        }
        t(navBackStackEntry).show(this.f49257e, navBackStackEntry.f());
        d().h(navBackStackEntry);
    }
}
