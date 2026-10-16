package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.androidx.viewmodel.ViewModelParameter;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;

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
public final class StateViewModelFactory<T extends ViewModel> extends AbstractSavedStateViewModelFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Scope f40110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewModelParameter f40111f;

    private final Function0 d(final SavedStateHandle savedStateHandle) {
        final ParametersHolder parametersHolderA;
        Function0 function0B = this.f40111f.b();
        if (function0B == null || (parametersHolderA = (ParametersHolder) function0B.invoke()) == null) {
            parametersHolderA = ParametersHolderKt.a();
        }
        return new Function0<ParametersHolder>() { // from class: androidx.lifecycle.StateViewModelFactory$addHandle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ParametersHolder invoke() {
                return parametersHolderA.a(savedStateHandle);
            }
        };
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    protected ViewModel c(String key, Class modelClass, SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(handle, "handle");
        return (ViewModel) this.f40110e.e(this.f40111f.a(), this.f40111f.c(), d(handle));
    }
}
