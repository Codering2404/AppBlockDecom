package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerState;
import java.util.concurrent.TimeUnit;
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
public final class UsageLimitConfigurationViewState implements ConditionConfiguration<ConditionDTO.UsageLimitDTO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f115784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f115785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f115786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UsageLimit.PeriodType f115787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TimePickerState f115788e;

    public UsageLimitConfigurationViewState(Long l3, long j3, boolean z2, UsageLimit.PeriodType periodType, TimePickerState timePickerState) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(timePickerState, "timePickerState");
        this.f115784a = l3;
        this.f115785b = j3;
        this.f115786c = z2;
        this.f115787d = periodType;
        this.f115788e = timePickerState;
    }

    public static /* synthetic */ UsageLimitConfigurationViewState e(UsageLimitConfigurationViewState usageLimitConfigurationViewState, Long l3, long j3, boolean z2, UsageLimit.PeriodType periodType, TimePickerState timePickerState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = usageLimitConfigurationViewState.f115784a;
        }
        if ((i3 & 2) != 0) {
            j3 = usageLimitConfigurationViewState.f115785b;
        }
        if ((i3 & 4) != 0) {
            z2 = usageLimitConfigurationViewState.f115786c;
        }
        if ((i3 & 8) != 0) {
            periodType = usageLimitConfigurationViewState.f115787d;
        }
        if ((i3 & 16) != 0) {
            timePickerState = usageLimitConfigurationViewState.f115788e;
        }
        TimePickerState timePickerState2 = timePickerState;
        boolean z3 = z2;
        return usageLimitConfigurationViewState.d(l3, j3, z3, periodType, timePickerState2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    public boolean a() {
        return this.f115788e.s() > 0 && !j();
    }

    public final boolean c(UsageLimitConfigurationViewState other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f115788e.s() == other.f115788e.s() && this.f115787d == other.f115787d;
    }

    public final UsageLimitConfigurationViewState d(Long l3, long j3, boolean z2, UsageLimit.PeriodType periodType, TimePickerState timePickerState) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(timePickerState, "timePickerState");
        return new UsageLimitConfigurationViewState(l3, j3, z2, periodType, timePickerState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsageLimitConfigurationViewState)) {
            return false;
        }
        UsageLimitConfigurationViewState usageLimitConfigurationViewState = (UsageLimitConfigurationViewState) obj;
        return Intrinsics.areEqual(this.f115784a, usageLimitConfigurationViewState.f115784a) && this.f115785b == usageLimitConfigurationViewState.f115785b && this.f115786c == usageLimitConfigurationViewState.f115786c && this.f115787d == usageLimitConfigurationViewState.f115787d && Intrinsics.areEqual(this.f115788e, usageLimitConfigurationViewState.f115788e);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConditionDTO.UsageLimitDTO b() {
        return new ConditionDTO.UsageLimitDTO(this.f115788e.s(), this.f115784a, this.f115785b, this.f115787d, null, 16, null);
    }

    public final Long g() {
        return this.f115784a;
    }

    public final UsageLimit.PeriodType h() {
        return this.f115787d;
    }

    public int hashCode() {
        Long l3 = this.f115784a;
        return ((((((((l3 == null ? 0 : l3.hashCode()) * 31) + Long.hashCode(this.f115785b)) * 31) + Boolean.hashCode(this.f115786c)) * 31) + this.f115787d.hashCode()) * 31) + this.f115788e.hashCode();
    }

    public final TimePickerState i() {
        return this.f115788e;
    }

    public boolean j() {
        return !this.f115786c && this.f115788e.s() > TimeUnit.MINUTES.toMillis((long) Limit.USAGE_LIMIT.getLimitValue());
    }

    public final boolean k() {
        return this.f115786c;
    }

    public final boolean l(long j3) {
        Long l3 = this.f115784a;
        return l3 != null && j3 > l3.longValue();
    }

    public String toString() {
        return "UsageLimitConfigurationViewState(originalAllowedTime=" + this.f115784a + ", usedTime=" + this.f115785b + ", isPremiumFeatureActive=" + this.f115786c + ", periodType=" + this.f115787d + ", timePickerState=" + this.f115788e + ")";
    }

    public /* synthetic */ UsageLimitConfigurationViewState(Long l3, long j3, boolean z2, UsageLimit.PeriodType periodType, TimePickerState timePickerState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? true : z2, (i3 & 8) != 0 ? UsageLimit.PeriodType.DAILY : periodType, (i3 & 16) != 0 ? new TimePickerState(null, null, null, null, 0, 0, 0, 0, false, false, 1023, null) : timePickerState);
    }
}
