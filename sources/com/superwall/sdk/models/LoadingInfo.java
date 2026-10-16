package com.superwall.sdk.models;

import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class LoadingInfo {
    private final Instant endAt;
    private final Instant failAt;
    private final Instant startAt;

    public LoadingInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LoadingInfo copy$default(LoadingInfo loadingInfo, Instant instant, Instant instant2, Instant instant3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            instant = loadingInfo.startAt;
        }
        if ((i3 & 2) != 0) {
            instant2 = loadingInfo.endAt;
        }
        if ((i3 & 4) != 0) {
            instant3 = loadingInfo.failAt;
        }
        return loadingInfo.copy(instant, instant2, instant3);
    }

    public final Instant component1() {
        return this.startAt;
    }

    public final Instant component2() {
        return this.endAt;
    }

    public final Instant component3() {
        return this.failAt;
    }

    public final LoadingInfo copy(Instant instant, Instant instant2, Instant instant3) {
        return new LoadingInfo(instant, instant2, instant3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadingInfo)) {
            return false;
        }
        LoadingInfo loadingInfo = (LoadingInfo) obj;
        return Intrinsics.areEqual(this.startAt, loadingInfo.startAt) && Intrinsics.areEqual(this.endAt, loadingInfo.endAt) && Intrinsics.areEqual(this.failAt, loadingInfo.failAt);
    }

    public final Instant getEndAt() {
        return this.endAt;
    }

    public final Instant getFailAt() {
        return this.failAt;
    }

    public final Instant getStartAt() {
        return this.startAt;
    }

    public int hashCode() {
        Instant instant = this.startAt;
        int iHashCode = (instant == null ? 0 : instant.hashCode()) * 31;
        Instant instant2 = this.endAt;
        int iHashCode2 = (iHashCode + (instant2 == null ? 0 : instant2.hashCode())) * 31;
        Instant instant3 = this.failAt;
        return iHashCode2 + (instant3 != null ? instant3.hashCode() : 0);
    }

    public String toString() {
        return "LoadingInfo(startAt=" + this.startAt + ", endAt=" + this.endAt + ", failAt=" + this.failAt + ")";
    }

    public LoadingInfo(Instant instant, Instant instant2, Instant instant3) {
        this.startAt = instant;
        this.endAt = instant2;
        this.failAt = instant3;
    }

    public /* synthetic */ LoadingInfo(Instant instant, Instant instant2, Instant instant3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : instant, (i3 & 2) != 0 ? null : instant2, (i3 & 4) != 0 ? null : instant3);
    }
}
