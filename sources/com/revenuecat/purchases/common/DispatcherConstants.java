package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class DispatcherConstants {
    public static final DispatcherConstants INSTANCE = new DispatcherConstants();
    private static final long jitterDelay;
    private static final long jitterLongDelay;

    static {
        Duration.Companion companion = Duration.f140631b;
        DurationUnit durationUnit = DurationUnit.f140640d;
        jitterDelay = DurationKt.t(5000L, durationUnit);
        jitterLongDelay = DurationKt.t(10000L, durationUnit);
    }

    private DispatcherConstants() {
    }

    /* JADX INFO: renamed from: getJitterDelay-UwyO8pc, reason: not valid java name */
    public final long m523getJitterDelayUwyO8pc() {
        return jitterDelay;
    }

    /* JADX INFO: renamed from: getJitterLongDelay-UwyO8pc, reason: not valid java name */
    public final long m524getJitterLongDelayUwyO8pc() {
        return jitterLongDelay;
    }
}
