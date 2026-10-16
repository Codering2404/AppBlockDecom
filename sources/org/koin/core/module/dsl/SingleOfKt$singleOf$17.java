package org.koin.core.module.dsl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.parameter.ParametersHolder;
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
public final class SingleOfKt$singleOf$17 extends Lambda implements Function2<Scope, ParametersHolder, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function16 f146030a;

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Scope single, ParametersHolder it) throws ClosedScopeException, NoBeanDefFoundException {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        Function16 function16 = this.f146030a;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object objE = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        Object objE2 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        Object objE3 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        Object objE4 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        Object objE5 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        Object objE6 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        Object objE7 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        Object objE8 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        Object objE9 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        Object objE10 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        Object objE11 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        Object objE12 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        Object objE13 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        Object objE14 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        Object objE15 = single.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T16");
        return function16.B(objE, objE2, objE3, objE4, objE5, objE6, objE7, objE8, objE9, objE10, objE11, objE12, objE13, objE14, objE15, single.e(Reflection.b(Object.class), null, null));
    }
}
