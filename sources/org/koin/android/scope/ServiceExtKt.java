package org.koin.android.scope;

import android.app.Service;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
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
public final class ServiceExtKt {
    public static final Scope a(Service service) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        if (!(service instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Service should implement AndroidScopeComponent");
        }
        Koin koinA = ComponentCallbackExtKt.a(service);
        Scope scopeI = koinA.i(KoinScopeComponentKt.c(service));
        return scopeI == null ? koinA.b(KoinScopeComponentKt.c(service), KoinScopeComponentKt.d(service), service) : scopeI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(Service service) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        if (!(service instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Service should implement AndroidScopeComponent");
        }
        ((AndroidScopeComponent) service).getScope().c();
    }
}
