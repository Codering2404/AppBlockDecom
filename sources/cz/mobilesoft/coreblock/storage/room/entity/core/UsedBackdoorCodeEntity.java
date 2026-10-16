package cz.mobilesoft.coreblock.storage.room.entity.core;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class UsedBackdoorCodeEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f126620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f126621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f126622c;

    public final String a() {
        return this.f126621b;
    }

    public final long b() {
        return this.f126620a;
    }

    public final long c() {
        return this.f126622c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsedBackdoorCodeEntity)) {
            return false;
        }
        UsedBackdoorCodeEntity usedBackdoorCodeEntity = (UsedBackdoorCodeEntity) obj;
        return this.f126620a == usedBackdoorCodeEntity.f126620a && Intrinsics.areEqual(this.f126621b, usedBackdoorCodeEntity.f126621b) && this.f126622c == usedBackdoorCodeEntity.f126622c;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f126620a) * 31) + this.f126621b.hashCode()) * 31) + Long.hashCode(this.f126622c);
    }

    public String toString() {
        return "UsedBackdoorCodeEntity(id=" + this.f126620a + ", code=" + this.f126621b + ", timeInMillis=" + this.f126622c + ")";
    }
}
