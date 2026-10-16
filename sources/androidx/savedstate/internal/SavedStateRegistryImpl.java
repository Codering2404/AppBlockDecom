package androidx.savedstate.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
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
public final class SavedStateRegistryImpl {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Companion f53013i = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SavedStateRegistryOwner f53014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f53015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SynchronizedObject f53016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f53017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f53018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bundle f53019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f53020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f53021h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SavedStateRegistryImpl(SavedStateRegistryOwner owner, Function0 onAttach) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onAttach, "onAttach");
        this.f53014a = owner;
        this.f53015b = onAttach;
        this.f53016c = new SynchronizedObject();
        this.f53017d = new LinkedHashMap();
        this.f53021h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(SavedStateRegistryImpl savedStateRegistryImpl, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistryImpl.f53021h = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistryImpl.f53021h = false;
        }
    }

    public final Bundle c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.f53020g) {
            throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
        }
        Bundle bundle = this.f53019f;
        if (bundle == null) {
            return null;
        }
        Bundle bundleA = SavedStateReader.a(bundle);
        Bundle bundleC = SavedStateReader.b(bundleA, key) ? SavedStateReader.C(bundleA, key) : null;
        SavedStateWriter.I(SavedStateWriter.a(bundle), key);
        if (SavedStateReader.O(SavedStateReader.a(bundle))) {
            this.f53019f = null;
        }
        return bundleC;
    }

    public final SavedStateRegistry.SavedStateProvider d(String key) {
        SavedStateRegistry.SavedStateProvider savedStateProvider;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.f53016c) {
            Iterator it = this.f53017d.entrySet().iterator();
            do {
                savedStateProvider = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                SavedStateRegistry.SavedStateProvider savedStateProvider2 = (SavedStateRegistry.SavedStateProvider) entry.getValue();
                if (Intrinsics.areEqual(str, key)) {
                    savedStateProvider = savedStateProvider2;
                }
            } while (savedStateProvider == null);
        }
        return savedStateProvider;
    }

    public final boolean e() {
        return this.f53021h;
    }

    public final void f() {
        if (this.f53014a.getLifecycle().getCurrentState() != Lifecycle.State.f39948b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        if (this.f53018e) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        this.f53015b.invoke();
        this.f53014a.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.savedstate.internal.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                SavedStateRegistryImpl.g(this.f53022a, lifecycleOwner, event);
            }
        });
        this.f53018e = true;
    }

    public final void h(Bundle bundle) {
        if (!this.f53018e) {
            f();
        }
        if (this.f53014a.getLifecycle().getCurrentState().b(Lifecycle.State.f39950d)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + this.f53014a.getLifecycle().getCurrentState()).toString());
        }
        if (this.f53020g) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        Bundle bundleC = null;
        if (bundle != null) {
            Bundle bundleA = SavedStateReader.a(bundle);
            if (SavedStateReader.b(bundleA, "androidx.lifecycle.BundlableSavedStateRegistry.key")) {
                bundleC = SavedStateReader.C(bundleA, "androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
        }
        this.f53019f = bundleC;
        this.f53020g = true;
    }

    public final void i(Bundle outBundle) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
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
        Bundle bundle = this.f53019f;
        if (bundle != null) {
            SavedStateWriter.d(bundleA, bundle);
        }
        synchronized (this.f53016c) {
            try {
                for (Map.Entry entry2 : this.f53017d.entrySet()) {
                    SavedStateWriter.A(bundleA, (String) entry2.getKey(), ((SavedStateRegistry.SavedStateProvider) entry2.getValue()).a());
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (SavedStateReader.O(SavedStateReader.a(bundleB))) {
            return;
        }
        SavedStateWriter.A(SavedStateWriter.a(outBundle), "androidx.lifecycle.BundlableSavedStateRegistry.key", bundleB);
    }

    public final void j(String key, SavedStateRegistry.SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        synchronized (this.f53016c) {
            if (this.f53017d.containsKey(key)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            this.f53017d.put(key, provider);
            Unit unit = Unit.f139807a;
        }
    }

    public final void k(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.f53016c) {
        }
    }
}
