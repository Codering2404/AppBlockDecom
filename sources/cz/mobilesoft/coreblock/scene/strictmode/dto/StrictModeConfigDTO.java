package cz.mobilesoft.coreblock.scene.strictmode.dto;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import java.util.List;
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
public final class StrictModeConfigDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f121046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StrictModeAccessMethod f121047b;

    public StrictModeConfigDTO(List options, StrictModeAccessMethod strictModeAccessMethod) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.f121046a = options;
        this.f121047b = strictModeAccessMethod;
    }

    public final StrictModeAccessMethod a() {
        return this.f121047b;
    }

    public final List b() {
        return this.f121046a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictModeConfigDTO)) {
            return false;
        }
        StrictModeConfigDTO strictModeConfigDTO = (StrictModeConfigDTO) obj;
        return Intrinsics.areEqual(this.f121046a, strictModeConfigDTO.f121046a) && this.f121047b == strictModeConfigDTO.f121047b;
    }

    public int hashCode() {
        int iHashCode = this.f121046a.hashCode() * 31;
        StrictModeAccessMethod strictModeAccessMethod = this.f121047b;
        return iHashCode + (strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode());
    }

    public String toString() {
        return "StrictModeConfigDTO(options=" + this.f121046a + ", accessMethod=" + this.f121047b + ")";
    }
}
