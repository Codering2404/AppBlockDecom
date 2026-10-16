package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
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
public final class LaunchCountConditionConfigurationViewState implements ConditionConfiguration<ConditionDTO.LaunchCountDTO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f115684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f115685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f115686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f115687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final UsageLimit.PeriodType f115688e;

    public LaunchCountConditionConfigurationViewState(long j3, Long l3, long j4, boolean z2, UsageLimit.PeriodType periodType) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        this.f115684a = j3;
        this.f115685b = l3;
        this.f115686c = j4;
        this.f115687d = z2;
        this.f115688e = periodType;
    }

    public static /* synthetic */ LaunchCountConditionConfigurationViewState e(LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState, long j3, Long l3, long j4, boolean z2, UsageLimit.PeriodType periodType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = launchCountConditionConfigurationViewState.f115684a;
        }
        long j5 = j3;
        if ((i3 & 2) != 0) {
            l3 = launchCountConditionConfigurationViewState.f115685b;
        }
        Long l4 = l3;
        if ((i3 & 4) != 0) {
            j4 = launchCountConditionConfigurationViewState.f115686c;
        }
        long j6 = j4;
        if ((i3 & 8) != 0) {
            z2 = launchCountConditionConfigurationViewState.f115687d;
        }
        boolean z3 = z2;
        if ((i3 & 16) != 0) {
            periodType = launchCountConditionConfigurationViewState.f115688e;
        }
        return launchCountConditionConfigurationViewState.d(j5, l4, j6, z3, periodType);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    public boolean a() {
        return this.f115684a > 0 && !j();
    }

    public final boolean c(LaunchCountConditionConfigurationViewState other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f115684a == other.f115684a && this.f115688e == other.f115688e;
    }

    public final LaunchCountConditionConfigurationViewState d(long j3, Long l3, long j4, boolean z2, UsageLimit.PeriodType periodType) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        return new LaunchCountConditionConfigurationViewState(j3, l3, j4, z2, periodType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LaunchCountConditionConfigurationViewState)) {
            return false;
        }
        LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState = (LaunchCountConditionConfigurationViewState) obj;
        return this.f115684a == launchCountConditionConfigurationViewState.f115684a && Intrinsics.areEqual(this.f115685b, launchCountConditionConfigurationViewState.f115685b) && this.f115686c == launchCountConditionConfigurationViewState.f115686c && this.f115687d == launchCountConditionConfigurationViewState.f115687d && this.f115688e == launchCountConditionConfigurationViewState.f115688e;
    }

    public final long f() {
        return this.f115684a;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ConditionDTO.LaunchCountDTO b() {
        return new ConditionDTO.LaunchCountDTO(this.f115684a, this.f115685b, this.f115686c, this.f115688e, null, 16, null);
    }

    public final Long h() {
        return this.f115685b;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f115684a) * 31;
        Long l3 = this.f115685b;
        return ((((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Long.hashCode(this.f115686c)) * 31) + Boolean.hashCode(this.f115687d)) * 31) + this.f115688e.hashCode();
    }

    public final UsageLimit.PeriodType i() {
        return this.f115688e;
    }

    public boolean j() {
        return !this.f115687d && this.f115684a > ((long) Limit.LAUNCH_COUNT.getLimitValue());
    }

    public final boolean k() {
        return this.f115687d;
    }

    public final boolean l(long j3) {
        Long l3 = this.f115685b;
        return l3 != null && j3 > l3.longValue();
    }

    public String toString() {
        return "LaunchCountConditionConfigurationViewState(allowedCount=" + this.f115684a + ", originalAllowedCount=" + this.f115685b + ", usedCount=" + this.f115686c + ", isPremiumFeatureActive=" + this.f115687d + ", periodType=" + this.f115688e + ")";
    }

    public /* synthetic */ LaunchCountConditionConfigurationViewState(long j3, Long l3, long j4, boolean z2, UsageLimit.PeriodType periodType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? 0L : j4, (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? UsageLimit.PeriodType.DAILY : periodType);
    }
}
