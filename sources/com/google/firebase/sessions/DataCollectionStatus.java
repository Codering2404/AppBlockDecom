package com.google.firebase.sessions;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class DataCollectionStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataCollectionState f89950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataCollectionState f89951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f89952c;

    public DataCollectionStatus(DataCollectionState performance, DataCollectionState crashlytics, double d3) {
        Intrinsics.checkNotNullParameter(performance, "performance");
        Intrinsics.checkNotNullParameter(crashlytics, "crashlytics");
        this.f89950a = performance;
        this.f89951b = crashlytics;
        this.f89952c = d3;
    }

    public final DataCollectionState a() {
        return this.f89951b;
    }

    public final DataCollectionState b() {
        return this.f89950a;
    }

    public final double c() {
        return this.f89952c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataCollectionStatus)) {
            return false;
        }
        DataCollectionStatus dataCollectionStatus = (DataCollectionStatus) obj;
        return this.f89950a == dataCollectionStatus.f89950a && this.f89951b == dataCollectionStatus.f89951b && Double.compare(this.f89952c, dataCollectionStatus.f89952c) == 0;
    }

    public int hashCode() {
        return (((this.f89950a.hashCode() * 31) + this.f89951b.hashCode()) * 31) + Double.hashCode(this.f89952c);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.f89950a + ", crashlytics=" + this.f89951b + ", sessionSamplingRate=" + this.f89952c + ')';
    }
}
