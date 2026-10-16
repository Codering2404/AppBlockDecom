package cz.mobilesoft.coreblock.dto.diagnostic;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
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
public final class UsageLimitDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f96977a = new Companion(null);

    @SerializedName("allowedCount")
    private final long allowedCount;

    @SerializedName("limitType")
    private final int limitType;

    @SerializedName("limitTypeName")
    private final String limitTypeName;

    @SerializedName("periodType")
    private final int periodType;

    @SerializedName("periodTypeName")
    private final String periodTypeName;

    @SerializedName("usedCount")
    private final long usedCount;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UsageLimitDTO a(UsageLimit usageLimit) {
            Intrinsics.checkNotNullParameter(usageLimit, "usageLimit");
            long jF = usageLimit.f();
            long jM = usageLimit.m();
            int id = usageLimit.i().getId();
            String strName = usageLimit.i().name();
            Locale locale = Locale.ROOT;
            String lowerCase = strName.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int id2 = usageLimit.k().getId();
            String lowerCase2 = usageLimit.k().name().toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            return new UsageLimitDTO(jF, jM, id, lowerCase, id2, lowerCase2);
        }

        private Companion() {
        }
    }

    public UsageLimitDTO(long j3, long j4, int i3, String limitTypeName, int i4, String periodTypeName) {
        Intrinsics.checkNotNullParameter(limitTypeName, "limitTypeName");
        Intrinsics.checkNotNullParameter(periodTypeName, "periodTypeName");
        this.allowedCount = j3;
        this.usedCount = j4;
        this.limitType = i3;
        this.limitTypeName = limitTypeName;
        this.periodType = i4;
        this.periodTypeName = periodTypeName;
    }

    public final long a() {
        return this.allowedCount;
    }

    public final int b() {
        return this.limitType;
    }

    public final int c() {
        return this.periodType;
    }

    public final long d() {
        return this.usedCount;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsageLimitDTO)) {
            return false;
        }
        UsageLimitDTO usageLimitDTO = (UsageLimitDTO) obj;
        return this.allowedCount == usageLimitDTO.allowedCount && this.usedCount == usageLimitDTO.usedCount && this.limitType == usageLimitDTO.limitType && Intrinsics.areEqual(this.limitTypeName, usageLimitDTO.limitTypeName) && this.periodType == usageLimitDTO.periodType && Intrinsics.areEqual(this.periodTypeName, usageLimitDTO.periodTypeName);
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.allowedCount) * 31) + Long.hashCode(this.usedCount)) * 31) + Integer.hashCode(this.limitType)) * 31) + this.limitTypeName.hashCode()) * 31) + Integer.hashCode(this.periodType)) * 31) + this.periodTypeName.hashCode();
    }

    public String toString() {
        return "UsageLimitDTO(allowedCount=" + this.allowedCount + ", usedCount=" + this.usedCount + ", limitType=" + this.limitType + ", limitTypeName=" + this.limitTypeName + ", periodType=" + this.periodType + ", periodTypeName=" + this.periodTypeName + ")";
    }
}
