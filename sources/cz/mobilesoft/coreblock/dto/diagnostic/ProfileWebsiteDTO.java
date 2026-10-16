package cz.mobilesoft.coreblock.dto.diagnostic;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import java.util.Locale;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ProfileWebsiteDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f96973a = new Companion(null);

    @SerializedName("blockingType")
    private final int blockingType;

    @SerializedName("blockingTypeName")
    private final String blockingTypeName;

    @SerializedName("isAnywhereInUrl")
    private final boolean isAnywhereInUrl;

    @SerializedName("name")
    private final String name;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileWebsiteDTO a(WebsiteProfileRelation website) {
            Intrinsics.checkNotNullParameter(website, "website");
            int id = website.a().getId();
            String lowerCase = website.a().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return new ProfileWebsiteDTO(id, lowerCase, website.c(), website.e());
        }

        private Companion() {
        }
    }

    public ProfileWebsiteDTO(int i3, String blockingTypeName, String name, boolean z2) {
        Intrinsics.checkNotNullParameter(blockingTypeName, "blockingTypeName");
        Intrinsics.checkNotNullParameter(name, "name");
        this.blockingType = i3;
        this.blockingTypeName = blockingTypeName;
        this.name = name;
        this.isAnywhereInUrl = z2;
    }

    public final int a() {
        return this.blockingType;
    }

    public final String b() {
        return this.name;
    }

    public final boolean c() {
        return this.isAnywhereInUrl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileWebsiteDTO)) {
            return false;
        }
        ProfileWebsiteDTO profileWebsiteDTO = (ProfileWebsiteDTO) obj;
        return this.blockingType == profileWebsiteDTO.blockingType && Intrinsics.areEqual(this.blockingTypeName, profileWebsiteDTO.blockingTypeName) && Intrinsics.areEqual(this.name, profileWebsiteDTO.name) && this.isAnywhereInUrl == profileWebsiteDTO.isAnywhereInUrl;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.blockingType) * 31) + this.blockingTypeName.hashCode()) * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.isAnywhereInUrl);
    }

    public String toString() {
        return "ProfileWebsiteDTO(blockingType=" + this.blockingType + ", blockingTypeName=" + this.blockingTypeName + ", name=" + this.name + ", isAnywhereInUrl=" + this.isAnywhereInUrl + ")";
    }
}
