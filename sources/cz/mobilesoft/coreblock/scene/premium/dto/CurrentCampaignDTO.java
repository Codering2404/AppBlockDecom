package cz.mobilesoft.coreblock.scene.premium.dto;

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
public final class CurrentCampaignDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f113054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CampaignSource f113055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f113056c;

    public CurrentCampaignDTO(long j3, CampaignSource source, Long l3) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f113054a = j3;
        this.f113055b = source;
        this.f113056c = l3;
    }

    public final Long a() {
        return this.f113056c;
    }

    public final long b() {
        return this.f113054a;
    }

    public final CampaignSource c() {
        return this.f113055b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurrentCampaignDTO)) {
            return false;
        }
        CurrentCampaignDTO currentCampaignDTO = (CurrentCampaignDTO) obj;
        return this.f113054a == currentCampaignDTO.f113054a && this.f113055b == currentCampaignDTO.f113055b && Intrinsics.areEqual(this.f113056c, currentCampaignDTO.f113056c);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.f113054a) * 31) + this.f113055b.hashCode()) * 31;
        Long l3 = this.f113056c;
        return iHashCode + (l3 == null ? 0 : l3.hashCode());
    }

    public String toString() {
        return "CurrentCampaignDTO(id=" + this.f113054a + ", source=" + this.f113055b + ", expirationMillis=" + this.f113056c + ")";
    }

    public /* synthetic */ CurrentCampaignDTO(long j3, CampaignSource campaignSource, Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, campaignSource, (i3 & 4) != 0 ? null : l3);
    }
}
