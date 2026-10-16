package org.koin.core.module.dsl;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
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
public final class SingleOfKt$singleOf$21 extends Lambda implements Function2<Scope, ParametersHolder, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function20 f146035a;

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Scope scope, ParametersHolder it) throws ClosedScopeException, NoBeanDefFoundException {
        Intrinsics.checkNotNullParameter(scope, KLAQHFCRAUejH.PwDYFFbBOx);
        Intrinsics.checkNotNullParameter(it, "it");
        Function20 function20 = this.f146035a;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object objE = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        Object objE2 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        Object objE3 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        Object objE4 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        Object objE5 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        Object objE6 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        Object objE7 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        Object objE8 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        Object objE9 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T10");
        Object objE10 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T11");
        Object objE11 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T12");
        Object objE12 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T13");
        Object objE13 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T14");
        Object objE14 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T15");
        Object objE15 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T16");
        Object objE16 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T17");
        Object objE17 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T18");
        Object objE18 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T19");
        Object objE19 = scope.e(Reflection.b(Object.class), null, null);
        Intrinsics.reifiedOperationMarker(4, "T20");
        return function20.g(objE, objE2, objE3, objE4, objE5, objE6, objE7, objE8, objE9, objE10, objE11, objE12, objE13, objE14, objE15, objE16, objE17, objE18, objE19, scope.e(Reflection.b(Object.class), null, null));
    }
}
