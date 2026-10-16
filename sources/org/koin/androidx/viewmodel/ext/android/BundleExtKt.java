package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class BundleExtKt {
    public static final CreationExtras a(Bundle bundle, ViewModelStoreOwner viewModelStoreOwner) {
        Object objB;
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        if (bundle.keySet().isEmpty()) {
            return null;
        }
        try {
            Result.Companion companion = Result.f139772b;
            MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(null, 1, null);
            mutableCreationExtras.c(SavedStateHandleSupport.f40090c, bundle);
            mutableCreationExtras.c(SavedStateHandleSupport.f40089b, viewModelStoreOwner);
            mutableCreationExtras.c(SavedStateHandleSupport.f40088a, (SavedStateRegistryOwner) viewModelStoreOwner);
            objB = Result.b(mutableCreationExtras);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        return (CreationExtras) (Result.g(objB) ? null : objB);
    }
}
