package cz.mobilesoft.appblock.service.lock;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface BlockingDecision {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Blocked implements BlockingDecision {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f94764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UsageLimit.PeriodType f94765b;

        public Blocked(List profiles, UsageLimit.PeriodType periodType) {
            Intrinsics.checkNotNullParameter(profiles, "profiles");
            this.f94764a = profiles;
            this.f94765b = periodType;
        }

        public final List a() {
            return this.f94764a;
        }

        public final UsageLimit.PeriodType b() {
            return this.f94765b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Blocked)) {
                return false;
            }
            Blocked blocked = (Blocked) obj;
            return Intrinsics.areEqual(this.f94764a, blocked.f94764a) && this.f94765b == blocked.f94765b;
        }

        public int hashCode() {
            int iHashCode = this.f94764a.hashCode() * 31;
            UsageLimit.PeriodType periodType = this.f94765b;
            return iHashCode + (periodType == null ? 0 : periodType.hashCode());
        }

        public String toString() {
            return "Blocked(profiles=" + this.f94764a + ", usageLimitPeriodType=" + this.f94765b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotBlocked implements BlockingDecision {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NotBlocked f94766a = new NotBlocked();

        private NotBlocked() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof NotBlocked);
        }

        public int hashCode() {
            return -561143453;
        }

        public String toString() {
            return "NotBlocked";
        }
    }
}
