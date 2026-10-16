package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SubAppRelation implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f126503c;

    public SubAppRelation(long j3, long j4, String subAppId) {
        Intrinsics.checkNotNullParameter(subAppId, "subAppId");
        this.f126501a = j3;
        this.f126502b = j4;
        this.f126503c = subAppId;
    }

    public final long a() {
        return this.f126501a;
    }

    public final long b() {
        return this.f126502b;
    }

    public final String c() {
        return this.f126503c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubAppRelation)) {
            return false;
        }
        SubAppRelation subAppRelation = (SubAppRelation) obj;
        return this.f126501a == subAppRelation.f126501a && this.f126502b == subAppRelation.f126502b && Intrinsics.areEqual(this.f126503c, subAppRelation.f126503c);
    }

    public int hashCode() {
        return (((Long.hashCode(this.f126501a) * 31) + Long.hashCode(this.f126502b)) * 31) + this.f126503c.hashCode();
    }

    public String toString() {
        return "SubAppRelation(id=" + this.f126501a + ", profileId=" + this.f126502b + ", subAppId=" + this.f126503c + ")";
    }

    public /* synthetic */ SubAppRelation(long j3, long j4, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, j4, str);
    }
}
