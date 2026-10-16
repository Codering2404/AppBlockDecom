package org.koin.core.scope;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.qualifier.Qualifier;

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
public final class Scope$inject$1 extends Lambda implements Function0<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Scope f146079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Qualifier f146080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f146081c;

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Scope scope = this.f146079a;
        Qualifier qualifier = this.f146080b;
        Function0 function0 = this.f146081c;
        Intrinsics.reifiedOperationMarker(4, "T");
        return scope.e(Reflection.b(Object.class), qualifier, function0);
    }
}
