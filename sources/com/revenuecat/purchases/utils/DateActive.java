package com.revenuecat.purchases.utils;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DateActive {
    private final boolean inGracePeriod;
    private final boolean isActive;

    public DateActive(boolean z2, boolean z3) {
        this.isActive = z2;
        this.inGracePeriod = z3;
    }

    public static /* synthetic */ DateActive copy$default(DateActive dateActive, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = dateActive.isActive;
        }
        if ((i3 & 2) != 0) {
            z3 = dateActive.inGracePeriod;
        }
        return dateActive.copy(z2, z3);
    }

    public final boolean component1() {
        return this.isActive;
    }

    public final boolean component2() {
        return this.inGracePeriod;
    }

    public final DateActive copy(boolean z2, boolean z3) {
        return new DateActive(z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateActive)) {
            return false;
        }
        DateActive dateActive = (DateActive) obj;
        return this.isActive == dateActive.isActive && this.inGracePeriod == dateActive.inGracePeriod;
    }

    public final boolean getInGracePeriod() {
        return this.inGracePeriod;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isActive) * 31) + Boolean.hashCode(this.inGracePeriod);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        return "DateActive(isActive=" + this.isActive + ", inGracePeriod=" + this.inGracePeriod + ')';
    }
}
