package com.superwall.sdk.misc;

import com.superwall.sdk.misc.SuperwallScope;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class IOScope implements CoroutineScope, SuperwallScope {
    private final CoroutineContext coroutineContext;

    /* JADX WARN: Multi-variable type inference failed */
    public IOScope() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.superwall.sdk.misc.SuperwallScope
    public CoroutineExceptionHandler getExceptionHandler() {
        return SuperwallScope.DefaultImpls.getExceptionHandler(this);
    }

    public IOScope(CoroutineContext overrideWithContext) {
        Intrinsics.checkNotNullParameter(overrideWithContext, "overrideWithContext");
        this.coroutineContext = SupervisorKt.b(null, 1, null).plus(overrideWithContext).plus(getExceptionHandler());
    }

    public /* synthetic */ IOScope(CoroutineContext coroutineContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dispatchers.b() : coroutineContext);
    }
}
