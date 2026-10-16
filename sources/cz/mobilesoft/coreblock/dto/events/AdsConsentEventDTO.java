package cz.mobilesoft.coreblock.dto.events;

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
public final class AdsConsentEventDTO {
    public static final int $stable = 0;
    private final Integer consentStatus;
    private final Long updateTime;
    private final Boolean userPrefersAdFree;

    public AdsConsentEventDTO() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AdsConsentEventDTO copy$default(AdsConsentEventDTO adsConsentEventDTO, Long l3, Integer num, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = adsConsentEventDTO.updateTime;
        }
        if ((i3 & 2) != 0) {
            num = adsConsentEventDTO.consentStatus;
        }
        if ((i3 & 4) != 0) {
            bool = adsConsentEventDTO.userPrefersAdFree;
        }
        return adsConsentEventDTO.copy(l3, num, bool);
    }

    public final Long component1() {
        return this.updateTime;
    }

    public final Integer component2() {
        return this.consentStatus;
    }

    public final Boolean component3() {
        return this.userPrefersAdFree;
    }

    public final AdsConsentEventDTO copy(Long l3, Integer num, Boolean bool) {
        return new AdsConsentEventDTO(l3, num, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdsConsentEventDTO)) {
            return false;
        }
        AdsConsentEventDTO adsConsentEventDTO = (AdsConsentEventDTO) obj;
        return Intrinsics.areEqual(this.updateTime, adsConsentEventDTO.updateTime) && Intrinsics.areEqual(this.consentStatus, adsConsentEventDTO.consentStatus) && Intrinsics.areEqual(this.userPrefersAdFree, adsConsentEventDTO.userPrefersAdFree);
    }

    public final Integer getConsentStatus() {
        return this.consentStatus;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final Boolean getUserPrefersAdFree() {
        return this.userPrefersAdFree;
    }

    public int hashCode() {
        Long l3 = this.updateTime;
        int iHashCode = (l3 == null ? 0 : l3.hashCode()) * 31;
        Integer num = this.consentStatus;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.userPrefersAdFree;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "AdsConsentEventDTO(updateTime=" + this.updateTime + ", consentStatus=" + this.consentStatus + ", userPrefersAdFree=" + this.userPrefersAdFree + ")";
    }

    public AdsConsentEventDTO(Long l3, Integer num, Boolean bool) {
        this.updateTime = l3;
        this.consentStatus = num;
        this.userPrefersAdFree = bool;
    }

    public /* synthetic */ AdsConsentEventDTO(Long l3, Integer num, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : bool);
    }
}
