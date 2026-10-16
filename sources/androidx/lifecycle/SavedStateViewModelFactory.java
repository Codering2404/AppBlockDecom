package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
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
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Application f40096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ViewModelProvider.Factory f40097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f40098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Lifecycle f40099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SavedStateRegistry f40100f;

    public SavedStateViewModelFactory() {
        this.f40097c = new ViewModelProvider.AndroidViewModelFactory();
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public void a(ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (this.f40099e != null) {
            SavedStateRegistry savedStateRegistry = this.f40100f;
            Intrinsics.checkNotNull(savedStateRegistry);
            Lifecycle lifecycle = this.f40099e;
            Intrinsics.checkNotNull(lifecycle);
            LegacySavedStateHandleController.a(viewModel, savedStateRegistry, lifecycle);
        }
    }

    public final ViewModel b(String key, Class modelClass) {
        ViewModel viewModelD;
        Application application;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Lifecycle lifecycle = this.f40099e;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.f40096b == null) ? SavedStateViewModelFactory_androidKt.c(modelClass, SavedStateViewModelFactory_androidKt.f40102b) : SavedStateViewModelFactory_androidKt.c(modelClass, SavedStateViewModelFactory_androidKt.f40101a);
        if (constructorC == null) {
            return this.f40096b != null ? this.f40097c.create(modelClass) : ViewModelProvider.NewInstanceFactory.Companion.a().create(modelClass);
        }
        SavedStateRegistry savedStateRegistry = this.f40100f;
        Intrinsics.checkNotNull(savedStateRegistry);
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(savedStateRegistry, lifecycle, key, this.f40098d);
        if (!zIsAssignableFrom || (application = this.f40096b) == null) {
            viewModelD = SavedStateViewModelFactory_androidKt.d(modelClass, constructorC, savedStateHandleControllerB.c());
        } else {
            Intrinsics.checkNotNull(application);
            viewModelD = SavedStateViewModelFactory_androidKt.d(modelClass, constructorC, application, savedStateHandleControllerB.c());
        }
        viewModelD.addCloseable("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return viewModelD;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public ViewModel create(KClass modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return create(JvmClassMappingKt.a(modelClass), extras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public ViewModel create(Class modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        String str = (String) extras.a(ViewModelProvider.f40125c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(SavedStateHandleSupport.f40088a) == null || extras.a(SavedStateHandleSupport.f40089b) == null) {
            if (this.f40099e != null) {
                return b(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(ViewModelProvider.AndroidViewModelFactory.f40129e);
        boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactory_androidKt.c(modelClass, SavedStateViewModelFactory_androidKt.f40102b) : SavedStateViewModelFactory_androidKt.c(modelClass, SavedStateViewModelFactory_androidKt.f40101a);
        return constructorC == null ? this.f40097c.create(modelClass, extras) : (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactory_androidKt.d(modelClass, constructorC, SavedStateHandleSupport.a(extras)) : SavedStateViewModelFactory_androidKt.d(modelClass, constructorC, application, SavedStateHandleSupport.a(extras));
    }

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner owner, Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.f40100f = owner.getSavedStateRegistry();
        this.f40099e = owner.getLifecycle();
        this.f40098d = bundle;
        this.f40096b = application;
        if (application != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.f40127c.a(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.f40097c = androidViewModelFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public ViewModel create(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return b(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
