package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
@Deprecated
@Metadata
public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SavedStateRegistry f39864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Lifecycle f39865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f39866d;

    private final ViewModel b(String str, Class cls) {
        SavedStateRegistry savedStateRegistry = this.f39864b;
        Intrinsics.checkNotNull(savedStateRegistry);
        Lifecycle lifecycle = this.f39865c;
        Intrinsics.checkNotNull(lifecycle);
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(savedStateRegistry, lifecycle, str, this.f39866d);
        ViewModel viewModelC = c(str, cls, savedStateHandleControllerB.c());
        viewModelC.addCloseable("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return viewModelC;
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public void a(ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        SavedStateRegistry savedStateRegistry = this.f39864b;
        if (savedStateRegistry != null) {
            Intrinsics.checkNotNull(savedStateRegistry);
            Lifecycle lifecycle = this.f39865c;
            Intrinsics.checkNotNull(lifecycle);
            LegacySavedStateHandleController.a(viewModel, savedStateRegistry, lifecycle);
        }
    }

    protected abstract ViewModel c(String str, Class cls, SavedStateHandle savedStateHandle);

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public ViewModel create(Class modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        String str = (String) extras.a(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (str != null) {
            return this.f39864b != null ? b(str, modelClass) : c(str, modelClass, SavedStateHandleSupport.a(extras));
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public ViewModel create(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            if (this.f39865c != null) {
                return b(canonicalName, modelClass);
            }
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
