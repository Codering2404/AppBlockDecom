package cz.mobilesoft.coreblock.dto.diagnostic;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class ProfileApplicationDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f96968a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f96969b = 8;

    @SerializedName("applicationName")
    private final String applicationName;

    @SerializedName("flagNames")
    private final List<String> flagNames;

    @SerializedName("flags")
    private final Integer flags;

    @SerializedName("packageName")
    private final String packageName;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileApplicationDTO a(ApplicationProfileRelation application, String name) {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(name, "name");
            String strD = application.d();
            Integer numValueOf = Integer.valueOf(application.b());
            if (numValueOf.intValue() == 0) {
                numValueOf = null;
            }
            List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{application.g(1) ? "strictMode" : null, application.g(2) ? "unsupportedBrowser" : null});
            return new ProfileApplicationDTO(strD, name, numValueOf, listListOfNotNull.isEmpty() ? null : listListOfNotNull);
        }

        private Companion() {
        }
    }

    public ProfileApplicationDTO(String packageName, String applicationName, Integer num, List list) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        this.packageName = packageName;
        this.applicationName = applicationName;
        this.flags = num;
        this.flagNames = list;
    }

    public final String a() {
        return this.packageName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileApplicationDTO)) {
            return false;
        }
        ProfileApplicationDTO profileApplicationDTO = (ProfileApplicationDTO) obj;
        return Intrinsics.areEqual(this.packageName, profileApplicationDTO.packageName) && Intrinsics.areEqual(this.applicationName, profileApplicationDTO.applicationName) && Intrinsics.areEqual(this.flags, profileApplicationDTO.flags) && Intrinsics.areEqual(this.flagNames, profileApplicationDTO.flagNames);
    }

    public int hashCode() {
        int iHashCode = ((this.packageName.hashCode() * 31) + this.applicationName.hashCode()) * 31;
        Integer num = this.flags;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list = this.flagNames;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ProfileApplicationDTO(packageName=" + this.packageName + ", applicationName=" + this.applicationName + ", flags=" + this.flags + ", flagNames=" + this.flagNames + ")";
    }
}
