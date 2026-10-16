package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SavedStateHandleSupport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CreationExtras.Key f40088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CreationExtras.Key f40089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CreationExtras.Key f40090c;

    static {
        CreationExtras.Companion companion = CreationExtras.f40228b;
        f40088a = new CreationExtras.Key<SavedStateRegistryOwner>() { // from class: androidx.lifecycle.SavedStateHandleSupport$special$$inlined$Key$1
        };
        f40089b = new CreationExtras.Key<ViewModelStoreOwner>() { // from class: androidx.lifecycle.SavedStateHandleSupport$special$$inlined$Key$2
        };
        f40090c = new CreationExtras.Key<Bundle>() { // from class: androidx.lifecycle.SavedStateHandleSupport$special$$inlined$Key$3
        };
    }

    public static final SavedStateHandle a(CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(creationExtras, "<this>");
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) creationExtras.a(f40088a);
        if (savedStateRegistryOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) creationExtras.a(f40089b);
        if (viewModelStoreOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) creationExtras.a(f40090c);
        String str = (String) creationExtras.a(ViewModelProvider.f40125c);
        if (str != null) {
            return b(savedStateRegistryOwner, viewModelStoreOwner, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    private static final SavedStateHandle b(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, String str, Bundle bundle) {
        SavedStateHandlesProvider savedStateHandlesProviderD = d(savedStateRegistryOwner);
        SavedStateHandlesVM savedStateHandlesVME = e(viewModelStoreOwner);
        SavedStateHandle savedStateHandle = (SavedStateHandle) savedStateHandlesVME.y0().get(str);
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        SavedStateHandle savedStateHandleA = SavedStateHandle.f40079c.a(savedStateHandlesProviderD.c(str), bundle);
        savedStateHandlesVME.y0().put(str, savedStateHandleA);
        return savedStateHandleA;
    }

    public static final void c(SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "<this>");
        Lifecycle.State currentState = savedStateRegistryOwner.getLifecycle().getCurrentState();
        if (currentState != Lifecycle.State.f39948b && currentState != Lifecycle.State.f39949c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (savedStateRegistryOwner.getSavedStateRegistry().b("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(savedStateRegistryOwner.getSavedStateRegistry(), (ViewModelStoreOwner) savedStateRegistryOwner);
            savedStateRegistryOwner.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            savedStateRegistryOwner.getLifecycle().addObserver(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "<this>");
        SavedStateRegistry.SavedStateProvider savedStateProviderB = savedStateRegistryOwner.getSavedStateRegistry().b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = savedStateProviderB instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) savedStateProviderB : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final SavedStateHandlesVM e(ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "<this>");
        return (SavedStateHandlesVM) ViewModelProvider.Companion.d(ViewModelProvider.f40124b, viewModelStoreOwner, new ViewModelProvider.Factory() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public ViewModel create(KClass modelClass, CreationExtras extras) {
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                Intrinsics.checkNotNullParameter(extras, "extras");
                return new SavedStateHandlesVM();
            }
        }, null, 4, null).c("androidx.lifecycle.internal.SavedStateHandlesVM", Reflection.b(SavedStateHandlesVM.class));
    }
}
