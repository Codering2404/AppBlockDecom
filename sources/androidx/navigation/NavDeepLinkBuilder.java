package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.internal.NavContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

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
public final class NavDeepLinkBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NavContext f48847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Activity f48848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Intent f48849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private NavGraph f48850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f48851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bundle f48852g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DeepLinkDestination {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f48853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f48854b;

        public DeepLinkDestination(int i3, Bundle bundle) {
            this.f48853a = i3;
            this.f48854b = bundle;
        }

        public final Bundle a() {
            return this.f48854b;
        }

        public final int b() {
            return this.f48853a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class PermissiveNavigatorProvider extends NavigatorProvider {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Navigator f48855d;

        @Override // androidx.navigation.NavigatorProvider
        public Navigator e(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            try {
                return super.e(name);
            } catch (IllegalStateException unused) {
                Navigator navigator = this.f48855d;
                Intrinsics.checkNotNull(navigator, "null cannot be cast to non-null type T of androidx.navigation.NavDeepLinkBuilder.PermissiveNavigatorProvider.getNavigator");
                return navigator;
            }
        }
    }

    public NavDeepLinkBuilder(Context context) {
        Intent launchIntentForPackage;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f48846a = context;
        this.f48847b = new NavContext(context);
        Activity activity = (Activity) SequencesKt.E(SequencesKt.N(SequencesKt.h(context, new Function1() { // from class: androidx.navigation.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavDeepLinkBuilder.c((Context) obj);
            }
        }), new Function1() { // from class: androidx.navigation.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavDeepLinkBuilder.d((Context) obj);
            }
        }));
        this.f48848c = activity;
        if (activity != null) {
            launchIntentForPackage = new Intent(context, activity.getClass());
        } else {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                launchIntentForPackage = new Intent();
            }
        }
        launchIntentForPackage.addFlags(268468224);
        this.f48849d = launchIntentForPackage;
        this.f48851f = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context c(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ContextWrapper contextWrapper = it instanceof ContextWrapper ? (ContextWrapper) it : null;
        if (contextWrapper != null) {
            return contextWrapper.getBaseContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity d(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof Activity) {
            return (Activity) it;
        }
        return null;
    }

    private final void g() {
        ArrayList arrayList = new ArrayList();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        NavDestination navDestination = null;
        for (DeepLinkDestination deepLinkDestination : this.f48851f) {
            int iB = deepLinkDestination.b();
            Bundle bundleA = deepLinkDestination.a();
            NavDestination navDestinationH = h(iB);
            if (navDestinationH == null) {
                throw new IllegalArgumentException("Navigation destination " + NavDestination.f48864g.d(this.f48847b, iB) + " cannot be found in the navigation graph " + this.f48850e);
            }
            for (int i3 : navDestinationH.e(navDestination)) {
                arrayList.add(Integer.valueOf(i3));
                arrayList2.add(bundleA);
            }
            navDestination = navDestinationH;
        }
        this.f48849d.putExtra("android-support-nav:controller:deepLinkIds", CollectionsKt.toIntArray(arrayList));
        this.f48849d.putParcelableArrayListExtra("android-support-nav:controller:deepLinkArgs", arrayList2);
    }

    private final NavDestination h(int i3) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavGraph navGraph = this.f48850e;
        Intrinsics.checkNotNull(navGraph);
        arrayDeque.add(navGraph);
        while (!arrayDeque.isEmpty()) {
            NavDestination navDestination = (NavDestination) arrayDeque.removeFirst();
            if (navDestination.o() == i3) {
                return navDestination;
            }
            if (navDestination instanceof NavGraph) {
                Iterator<NavDestination> it = ((NavGraph) navDestination).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        return null;
    }

    public static /* synthetic */ NavDeepLinkBuilder k(NavDeepLinkBuilder navDeepLinkBuilder, int i3, Bundle bundle, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.j(i3, bundle);
    }

    private final void l() {
        Iterator it = this.f48851f.iterator();
        while (it.hasNext()) {
            int iB = ((DeepLinkDestination) it.next()).b();
            if (h(iB) == null) {
                throw new IllegalArgumentException("Navigation destination " + NavDestination.f48864g.d(this.f48847b, iB) + " cannot be found in the navigation graph " + this.f48850e);
            }
        }
    }

    public final NavDeepLinkBuilder e(int i3, Bundle bundle) {
        this.f48851f.add(new DeepLinkDestination(i3, bundle));
        if (this.f48850e != null) {
            l();
        }
        return this;
    }

    public final TaskStackBuilder f() {
        if (this.f48850e == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link");
        }
        if (this.f48851f.isEmpty()) {
            throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link");
        }
        g();
        TaskStackBuilder taskStackBuilderB = TaskStackBuilder.f(this.f48846a).b(new Intent(this.f48849d));
        Intrinsics.checkNotNullExpressionValue(taskStackBuilderB, "addNextIntentWithParentStack(...)");
        int iH = taskStackBuilderB.h();
        for (int i3 = 0; i3 < iH; i3++) {
            Intent intentG = taskStackBuilderB.g(i3);
            if (intentG != null) {
                intentG.putExtra("android-support-nav:controller:deepLinkIntent", this.f48849d);
            }
        }
        return taskStackBuilderB;
    }

    public final NavDeepLinkBuilder i(Bundle bundle) {
        this.f48852g = bundle;
        this.f48849d.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    public final NavDeepLinkBuilder j(int i3, Bundle bundle) {
        this.f48851f.clear();
        this.f48851f.add(new DeepLinkDestination(i3, bundle));
        if (this.f48850e != null) {
            l();
        }
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDeepLinkBuilder(NavController navController) {
        this(navController.s());
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.f48850e = navController.x();
    }
}
