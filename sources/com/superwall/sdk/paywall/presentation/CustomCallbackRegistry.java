package com.superwall.sdk.paywall.presentation;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CustomCallbackRegistry {
    private final ConcurrentHashMap<String, Function2<CustomCallback, Continuation<? super CustomCallbackResult>, Object>> handlers = new ConcurrentHashMap<>();

    public final void clear() {
        this.handlers.clear();
    }

    public final Function2<CustomCallback, Continuation<? super CustomCallbackResult>, Object> getHandler(String paywallIdentifier) {
        Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
        return this.handlers.get(paywallIdentifier);
    }

    public final void register(String paywallIdentifier, Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object> handler) {
        Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlers.put(paywallIdentifier, handler);
    }

    public final void unregister(String paywallIdentifier) {
        Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
        this.handlers.remove(paywallIdentifier);
    }
}
