package com.facebook.appevents.gps.topics;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class TopicData {
    private final long modelVersion;
    private final long taxonomyVersion;
    private final int topicId;

    public TopicData(long j3, long j4, int i3) {
        this.taxonomyVersion = j3;
        this.modelVersion = j4;
        this.topicId = i3;
    }

    public static /* synthetic */ TopicData copy$default(TopicData topicData, long j3, long j4, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j3 = topicData.taxonomyVersion;
        }
        long j5 = j3;
        if ((i4 & 2) != 0) {
            j4 = topicData.modelVersion;
        }
        long j6 = j4;
        if ((i4 & 4) != 0) {
            i3 = topicData.topicId;
        }
        return topicData.copy(j5, j6, i3);
    }

    public final long component1() {
        return this.taxonomyVersion;
    }

    public final long component2() {
        return this.modelVersion;
    }

    public final int component3() {
        return this.topicId;
    }

    public final TopicData copy(long j3, long j4, int i3) {
        return new TopicData(j3, j4, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopicData)) {
            return false;
        }
        TopicData topicData = (TopicData) obj;
        return this.taxonomyVersion == topicData.taxonomyVersion && this.modelVersion == topicData.modelVersion && this.topicId == topicData.topicId;
    }

    public final long getModelVersion() {
        return this.modelVersion;
    }

    public final long getTaxonomyVersion() {
        return this.taxonomyVersion;
    }

    public final int getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        return (((Long.hashCode(this.taxonomyVersion) * 31) + Long.hashCode(this.modelVersion)) * 31) + Integer.hashCode(this.topicId);
    }

    public String toString() {
        return "TopicData(taxonomyVersion=" + this.taxonomyVersion + ", modelVersion=" + this.modelVersion + ", topicId=" + this.topicId + ')';
    }
}
