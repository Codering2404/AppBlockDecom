package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DayOfWeek;

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
public final class TimeConditionConfigurationViewState implements ConditionConfiguration<ConditionDTO.TimeDTO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Configuration f115712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f115713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f115714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f115715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f115716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IntervalDTO f115717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f115718g;

    public TimeConditionConfigurationViewState(Configuration configuration, boolean z2, boolean z3, boolean z4, boolean z5, IntervalDTO intervalDTO, boolean z6) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f115712a = configuration;
        this.f115713b = z2;
        this.f115714c = z3;
        this.f115715d = z4;
        this.f115716e = z5;
        this.f115717f = intervalDTO;
        this.f115718g = z6;
    }

    public static /* synthetic */ TimeConditionConfigurationViewState d(TimeConditionConfigurationViewState timeConditionConfigurationViewState, Configuration configuration, boolean z2, boolean z3, boolean z4, boolean z5, IntervalDTO intervalDTO, boolean z6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            configuration = timeConditionConfigurationViewState.f115712a;
        }
        if ((i3 & 2) != 0) {
            z2 = timeConditionConfigurationViewState.f115713b;
        }
        if ((i3 & 4) != 0) {
            z3 = timeConditionConfigurationViewState.f115714c;
        }
        if ((i3 & 8) != 0) {
            z4 = timeConditionConfigurationViewState.f115715d;
        }
        if ((i3 & 16) != 0) {
            z5 = timeConditionConfigurationViewState.f115716e;
        }
        if ((i3 & 32) != 0) {
            intervalDTO = timeConditionConfigurationViewState.f115717f;
        }
        if ((i3 & 64) != 0) {
            z6 = timeConditionConfigurationViewState.f115718g;
        }
        IntervalDTO intervalDTO2 = intervalDTO;
        boolean z7 = z6;
        boolean z8 = z5;
        boolean z9 = z3;
        return timeConditionConfigurationViewState.c(configuration, z2, z9, z4, z8, intervalDTO2, z7);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    public boolean a() {
        Configuration configuration = this.f115712a;
        if (configuration.k().isEmpty()) {
            return false;
        }
        if (!configuration.e().isEmpty() || configuration.l()) {
            return (this.f115713b || configuration.e().size() <= Limit.TIMES_LIMIT.getLimitValue()) && !l();
        }
        return false;
    }

    public final TimeConditionConfigurationViewState c(Configuration configuration, boolean z2, boolean z3, boolean z4, boolean z5, IntervalDTO intervalDTO, boolean z6) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return new TimeConditionConfigurationViewState(configuration, z2, z3, z4, z5, intervalDTO, z6);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ConditionDTO.TimeDTO b() {
        if (this.f115712a.k().isEmpty()) {
            return null;
        }
        if (this.f115712a.e().isEmpty() && !this.f115712a.l()) {
            return null;
        }
        Iterator<E> it = this.f115712a.k().iterator();
        int value = 0;
        int value2 = 0;
        while (it.hasNext()) {
            value2 |= DayFlags.Companion.b((DayOfWeek) it.next()).getValue();
        }
        ArrayList arrayListArrayListOf = this.f115712a.l() ? CollectionsKt.arrayListOf(new IntervalDTO(0L, 1440L, null, null, 12, null)) : new ArrayList(this.f115712a.e());
        Iterator<E> it2 = this.f115712a.i().iterator();
        while (it2.hasNext()) {
            value |= DayFlags.Companion.b((DayOfWeek) it2.next()).getValue();
        }
        return new ConditionDTO.TimeDTO(value2, arrayListArrayListOf, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeConditionConfigurationViewState)) {
            return false;
        }
        TimeConditionConfigurationViewState timeConditionConfigurationViewState = (TimeConditionConfigurationViewState) obj;
        return Intrinsics.areEqual(this.f115712a, timeConditionConfigurationViewState.f115712a) && this.f115713b == timeConditionConfigurationViewState.f115713b && this.f115714c == timeConditionConfigurationViewState.f115714c && this.f115715d == timeConditionConfigurationViewState.f115715d && this.f115716e == timeConditionConfigurationViewState.f115716e && Intrinsics.areEqual(this.f115717f, timeConditionConfigurationViewState.f115717f) && this.f115718g == timeConditionConfigurationViewState.f115718g;
    }

    public final Configuration f() {
        return this.f115712a;
    }

    public final IntervalDTO g() {
        return this.f115717f;
    }

    public final boolean h() {
        return this.f115714c;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.f115712a.hashCode() * 31) + Boolean.hashCode(this.f115713b)) * 31) + Boolean.hashCode(this.f115714c)) * 31) + Boolean.hashCode(this.f115715d)) * 31) + Boolean.hashCode(this.f115716e)) * 31;
        IntervalDTO intervalDTO = this.f115717f;
        return ((iHashCode + (intervalDTO == null ? 0 : intervalDTO.hashCode())) * 31) + Boolean.hashCode(this.f115718g);
    }

    public final boolean i() {
        return this.f115715d;
    }

    public final boolean j() {
        return this.f115716e;
    }

    public final boolean k() {
        return this.f115718g;
    }

    public boolean l() {
        return !this.f115713b && this.f115712a.e().size() > Limit.TIMES_LIMIT.getLimitValue();
    }

    public final boolean m() {
        return this.f115713b;
    }

    public String toString() {
        return "TimeConditionConfigurationViewState(configuration=" + this.f115712a + ", isTimePremiumFeatureActive=" + this.f115713b + ", shakeDays=" + this.f115714c + ", shakeIntervals=" + this.f115715d + ", showTimeRangePickerBottomSheet=" + this.f115716e + ", selectedIntervalForEdit=" + this.f115717f + ", is12HoursFormat=" + this.f115718g + ")";
    }

    public /* synthetic */ TimeConditionConfigurationViewState(Configuration configuration, boolean z2, boolean z3, boolean z4, boolean z5, IntervalDTO intervalDTO, boolean z6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Configuration(null, null, null, false, false, 31, null) : configuration, (i3 & 2) != 0 ? true : z2, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? false : z4, (i3 & 16) != 0 ? false : z5, (i3 & 32) != 0 ? null : intervalDTO, (i3 & 64) != 0 ? false : z6);
    }
}
