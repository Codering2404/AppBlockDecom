package cz.mobilesoft.coreblock.dto.diagnostic;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import java.text.SimpleDateFormat;
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
public final class ProfileIntervalDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f96972a = new Companion(null);

    @SerializedName("fromInMinutes")
    private final long fromInMinutes;

    @SerializedName("fromReadable")
    private final String fromReadable;

    @SerializedName("toInMinutes")
    private final long toInMinutes;

    @SerializedName("toReadable")
    private final String toReadable;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileIntervalDTO a(Interval interval) {
            Intrinsics.checkNotNullParameter(interval, "interval");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.US);
            long jB = interval.b();
            long jA = interval.a();
            long j3 = 60;
            long j4 = 1000;
            String str = simpleDateFormat.format(Long.valueOf(interval.b() * j3 * j4));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            String str2 = simpleDateFormat.format(Long.valueOf(interval.a() * j3 * j4));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return new ProfileIntervalDTO(jB, jA, str, str2);
        }

        private Companion() {
        }
    }

    public ProfileIntervalDTO(long j3, long j4, String fromReadable, String toReadable) {
        Intrinsics.checkNotNullParameter(fromReadable, "fromReadable");
        Intrinsics.checkNotNullParameter(toReadable, "toReadable");
        this.fromInMinutes = j3;
        this.toInMinutes = j4;
        this.fromReadable = fromReadable;
        this.toReadable = toReadable;
    }

    public final long a() {
        return this.fromInMinutes;
    }

    public final String b() {
        return this.fromReadable;
    }

    public final long c() {
        return this.toInMinutes;
    }

    public final String d() {
        return this.toReadable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileIntervalDTO)) {
            return false;
        }
        ProfileIntervalDTO profileIntervalDTO = (ProfileIntervalDTO) obj;
        return this.fromInMinutes == profileIntervalDTO.fromInMinutes && this.toInMinutes == profileIntervalDTO.toInMinutes && Intrinsics.areEqual(this.fromReadable, profileIntervalDTO.fromReadable) && Intrinsics.areEqual(this.toReadable, profileIntervalDTO.toReadable);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.fromInMinutes) * 31) + Long.hashCode(this.toInMinutes)) * 31) + this.fromReadable.hashCode()) * 31) + this.toReadable.hashCode();
    }

    public String toString() {
        return "ProfileIntervalDTO(fromInMinutes=" + this.fromInMinutes + ", toInMinutes=" + this.toInMinutes + ", fromReadable=" + this.fromReadable + ", toReadable=" + this.toReadable + ")";
    }
}
