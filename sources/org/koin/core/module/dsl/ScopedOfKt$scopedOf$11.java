package org.koin.core.module.dsl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function10;
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
public final class ScopedOfKt$scopedOf$11 extends Lambda implements Function2<Scope, ParametersHolder, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function10 f146001a;

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Scope scoped, ParametersHolder it) throws ClosedScopeException, NoBeanDefFoundException {
        Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
        Intrinsics.checkNotNullParameter(it, "it");
        Function10 function10 = this.f146001a;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object objE = scoped.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        Object objE2 = scoped.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        Object objE3 = scoped.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        Object objE4 = scoped.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        Object objE5 = scoped.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        Object objE6 = scoped.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        Object objE7 = scoped.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        Object objE8 = scoped.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        Object objE9 = scoped.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        return function10.F(objE, objE2, objE3, objE4, objE5, objE6, objE7, objE8, objE9, scoped.e(Reflection.b(Object.class), null, null));
    }
}
