package org.koin.androidx.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.androidx.viewmodel.factory.KoinViewModelFactory;
import org.koin.core.qualifier.Qualifier;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class GetViewModelKt {
    public static final ViewModel a(KClass vmClass, ViewModelStore viewModelStore, String str, CreationExtras extras, Qualifier qualifier, Scope scope, Function0 function0) {
        Intrinsics.checkNotNullParameter(vmClass, "vmClass");
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Class clsA = JvmClassMappingKt.a(vmClass);
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStore, new KoinViewModelFactory(vmClass, scope, qualifier, function0), extras);
        return qualifier != null ? viewModelProvider.b(qualifier.getValue(), clsA) : str != null ? viewModelProvider.b(str, clsA) : viewModelProvider.a(clsA);
    }

    public static /* synthetic */ ViewModel b(KClass kClass, ViewModelStore viewModelStore, String str, CreationExtras creationExtras, Qualifier qualifier, Scope scope, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        if ((i3 & 16) != 0) {
            qualifier = null;
        }
        if ((i3 & 64) != 0) {
            function0 = null;
        }
        return a(kClass, viewModelStore, str, creationExtras, qualifier, scope, function0);
    }
}
