package androidx.navigation.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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
public final class NavBackStackEntryStateImpl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f49334e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f49335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f49336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f49337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bundle f49338d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public NavBackStackEntryStateImpl(NavBackStackEntry entry, int i3) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.f49335a = entry.f();
        this.f49336b = i3;
        this.f49337c = entry.b();
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry2 : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.a((String) entry2.getKey(), entry2.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.a(bundleB);
        this.f49338d = bundleB;
        entry.l(bundleB);
    }

    public final Bundle a() {
        return this.f49337c;
    }

    public final int b() {
        return this.f49336b;
    }

    public final String c() {
        return this.f49335a;
    }

    public final NavBackStackEntry d(NavContext context, NavDestination destination, Bundle bundle, Lifecycle.State hostLifecycleState, NavControllerViewModel navControllerViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(hostLifecycleState, "hostLifecycleState");
        return NavBackStackEntry.f48787k.a(context, destination, bundle, hostLifecycleState, navControllerViewModel, this.f49335a, this.f49338d);
    }

    public final Bundle e() {
        Pair[] pairArr;
        Pair[] pairArr2;
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle bundleA = SavedStateWriter.a(bundleB);
        SavedStateWriter.F(bundleA, "nav-entry-state:id", this.f49335a);
        SavedStateWriter.q(bundleA, "nav-entry-state:destination-id", this.f49336b);
        Bundle bundleB2 = this.f49337c;
        if (bundleB2 == null) {
            Map mapEmptyMap2 = MapsKt.emptyMap();
            if (mapEmptyMap2.isEmpty()) {
                pairArr2 = new Pair[0];
            } else {
                ArrayList arrayList2 = new ArrayList(mapEmptyMap2.size());
                for (Map.Entry entry2 : mapEmptyMap2.entrySet()) {
                    arrayList2.add(TuplesKt.a((String) entry2.getKey(), entry2.getValue()));
                }
                pairArr2 = (Pair[]) arrayList2.toArray(new Pair[0]);
            }
            bundleB2 = BundleKt.b((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
            SavedStateWriter.a(bundleB2);
        }
        SavedStateWriter.A(bundleA, "nav-entry-state:args", bundleB2);
        SavedStateWriter.A(bundleA, "nav-entry-state:saved-state", this.f49338d);
        return bundleB;
    }

    public NavBackStackEntryStateImpl(Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.f49335a = SavedStateReader.J(SavedStateReader.a(state), "nav-entry-state:id");
        this.f49336b = SavedStateReader.s(SavedStateReader.a(state), "nav-entry-state:destination-id");
        this.f49337c = SavedStateReader.C(SavedStateReader.a(state), "nav-entry-state:args");
        this.f49338d = SavedStateReader.C(SavedStateReader.a(state), "nav-entry-state:saved-state");
    }
}
