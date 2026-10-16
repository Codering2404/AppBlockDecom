package com.revenuecat.purchases.ui.revenuecatui.activity;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
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
public final class PaywallActivityNonSerializableArgsStore {
    public static final PaywallActivityNonSerializableArgsStore INSTANCE = new PaywallActivityNonSerializableArgsStore();
    private static final Map<Integer, PaywallActivityNonSerializableArgs> argsByHashCode = new LinkedHashMap();
    public static final int $stable = 8;

    private PaywallActivityNonSerializableArgsStore() {
    }

    public final synchronized void clear() {
        argsByHashCode.clear();
    }

    public final synchronized PaywallActivityNonSerializableArgs get(int i3) {
        return argsByHashCode.get(Integer.valueOf(i3));
    }

    public final synchronized void remove(int i3) {
        argsByHashCode.remove(Integer.valueOf(i3));
    }

    public final synchronized int store(PaywallActivityNonSerializableArgs args) {
        int iIdentityHashCode;
        Intrinsics.checkNotNullParameter(args, "args");
        iIdentityHashCode = System.identityHashCode(args);
        argsByHashCode.put(Integer.valueOf(iIdentityHashCode), args);
        return iIdentityHashCode;
    }
}
