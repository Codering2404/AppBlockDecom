package com.google.android.libraries.places.api.net.kotlin;

import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class FindCurrentPlaceRequestKt {
    public static final FindCurrentPlaceRequest a(List placeFields, Function1 function1) {
        Intrinsics.checkNotNullParameter(placeFields, "placeFields");
        FindCurrentPlaceRequest.Builder builderB = FindCurrentPlaceRequest.b(placeFields);
        if (function1 != null) {
            function1.invoke(builderB);
        }
        FindCurrentPlaceRequest findCurrentPlaceRequestA = builderB.a();
        Intrinsics.checkNotNullExpressionValue(findCurrentPlaceRequestA, "build(...)");
        return findCurrentPlaceRequestA;
    }
}
