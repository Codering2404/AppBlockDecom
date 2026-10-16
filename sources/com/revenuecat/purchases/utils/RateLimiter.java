package com.revenuecat.purchases.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;

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
public final class RateLimiter {
    private final long[] callTimestamps;
    private int index;
    private final int maxCallInclusive;
    private final int maxCallsInPeriod;
    private final long periodSeconds;

    public /* synthetic */ RateLimiter(int i3, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, j3);
    }

    public final int getMaxCallsInPeriod() {
        return this.maxCallsInPeriod;
    }

    /* JADX INFO: renamed from: getPeriodSeconds-UwyO8pc, reason: not valid java name */
    public final long m1244getPeriodSecondsUwyO8pc() {
        return this.periodSeconds;
    }

    public final synchronized boolean shouldProceed() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i3 = (this.index + 1) % this.maxCallInclusive;
        long j3 = this.callTimestamps[i3];
        if (j3 != 0 && jCurrentTimeMillis - j3 <= Duration.p(this.periodSeconds)) {
            return false;
        }
        this.callTimestamps[this.index] = jCurrentTimeMillis;
        this.index = i3;
        return true;
    }

    private RateLimiter(int i3, long j3) {
        this.maxCallsInPeriod = i3;
        this.periodSeconds = j3;
        int i4 = i3 + 1;
        this.maxCallInclusive = i4;
        this.callTimestamps = new long[i4];
    }
}
