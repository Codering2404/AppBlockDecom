package cz.mobilesoft.coreblock.util.updates;

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
public final class InAppUpdatesVersion {
    public static final int $stable = 0;
    private final Integer priority;
    private final Integer versionCode;

    public InAppUpdatesVersion(Integer num, Integer num2) {
        this.versionCode = num;
        this.priority = num2;
    }

    public static /* synthetic */ InAppUpdatesVersion copy$default(InAppUpdatesVersion inAppUpdatesVersion, Integer num, Integer num2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = inAppUpdatesVersion.versionCode;
        }
        if ((i3 & 2) != 0) {
            num2 = inAppUpdatesVersion.priority;
        }
        return inAppUpdatesVersion.copy(num, num2);
    }

    public final Integer component1() {
        return this.versionCode;
    }

    public final Integer component2() {
        return this.priority;
    }

    public final InAppUpdatesVersion copy(Integer num, Integer num2) {
        return new InAppUpdatesVersion(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InAppUpdatesVersion)) {
            return false;
        }
        InAppUpdatesVersion inAppUpdatesVersion = (InAppUpdatesVersion) obj;
        return Intrinsics.areEqual(this.versionCode, inAppUpdatesVersion.versionCode) && Intrinsics.areEqual(this.priority, inAppUpdatesVersion.priority);
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Integer getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        Integer num = this.versionCode;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.priority;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "InAppUpdatesVersion(versionCode=" + this.versionCode + ", priority=" + this.priority + ")";
    }
}
