package com.superwall.sdk.storage;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class ReviewCount {
    public static final Companion Companion = new Companion(null);
    private final int timesQueried;
    private final long timestamp;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ReviewCount> serializer() {
            return ReviewCount$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ReviewCount() {
        this(0, 0L, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ReviewCount copy$default(ReviewCount reviewCount, int i3, long j3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = reviewCount.timesQueried;
        }
        if ((i4 & 2) != 0) {
            j3 = reviewCount.timestamp;
        }
        return reviewCount.copy(i3, j3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(ReviewCount reviewCount, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || reviewCount.timesQueried != 0) {
            compositeEncoder.w(serialDescriptor, 0, reviewCount.timesQueried);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && reviewCount.timestamp == new Date().getTime()) {
            return;
        }
        compositeEncoder.F(serialDescriptor, 1, reviewCount.timestamp);
    }

    public final int component1() {
        return this.timesQueried;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final ReviewCount copy(int i3, long j3) {
        return new ReviewCount(i3, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReviewCount)) {
            return false;
        }
        ReviewCount reviewCount = (ReviewCount) obj;
        return this.timesQueried == reviewCount.timesQueried && this.timestamp == reviewCount.timestamp;
    }

    public final Date getDate() {
        return new Date(this.timestamp);
    }

    public final int getTimesQueried() {
        return this.timesQueried;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (Integer.hashCode(this.timesQueried) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "ReviewCount(timesQueried=" + this.timesQueried + ", timestamp=" + this.timestamp + ")";
    }

    public /* synthetic */ ReviewCount(int i3, int i4, long j3, SerializationConstructorMarker serializationConstructorMarker) {
        this.timesQueried = (i3 & 1) == 0 ? 0 : i4;
        if ((i3 & 2) == 0) {
            this.timestamp = new Date().getTime();
        } else {
            this.timestamp = j3;
        }
    }

    public ReviewCount(int i3, long j3) {
        this.timesQueried = i3;
        this.timestamp = j3;
    }

    public /* synthetic */ ReviewCount(int i3, long j3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i3, (i4 & 2) != 0 ? new Date().getTime() : j3);
    }

    @SerialName
    public static /* synthetic */ void getTimesQueried$annotations() {
    }
}
