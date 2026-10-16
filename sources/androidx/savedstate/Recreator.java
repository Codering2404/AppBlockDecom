package androidx.savedstate;

import android.os.Bundle;
import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
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
public final class Recreator implements LifecycleEventObserver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f52993b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SavedStateRegistryOwner f52994a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Recreator(SavedStateRegistryOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.f52994a = owner;
    }

    private final void a(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
            Intrinsics.checkNotNull(clsAsSubclass);
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    Intrinsics.checkNotNull(objNewInstance);
                    ((SavedStateRegistry.AutoRecreated) objNewInstance).a(this.f52994a);
                } catch (Exception e3) {
                    throw new RuntimeException("Failed to instantiate " + str, e3);
                }
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("Class " + str + " wasn't found", e5);
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void j(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.getLifecycle().removeObserver(this);
        Bundle bundleA = this.f52994a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        List listM = SavedStateReader.M(SavedStateReader.a(bundleA), "classes_to_restore");
        if (listM == null) {
            throw new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator it = listM.iterator();
        while (it.hasNext()) {
            a((String) it.next());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f52995a;

        public SavedStateProvider(SavedStateRegistry registry) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            this.f52995a = new LinkedHashSet();
            registry.c("androidx.savedstate.Restarter", this);
        }

        public final void b(String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            this.f52995a.add(className);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public Bundle a() {
            Pair[] pairArr;
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
            SavedStateWriter.H(SavedStateWriter.a(bundleB), vxrlPPpdv.jkewlAapqWwnvv, CollectionsKt.toList(this.f52995a));
            return bundleB;
        }
    }
}
