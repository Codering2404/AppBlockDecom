package cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.UsageLimitConfigurationViewState;
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
public final class UsageLimitConditionViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f115909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f115910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeConditionConfigurationViewState f115911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UsageLimitConfigurationViewState f115912d;

    public UsageLimitConditionViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState, UsageLimitConfigurationViewState usageLimitConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(usageLimitConfigurationViewState, "usageLimitConfigurationViewState");
        this.f115909a = z2;
        this.f115910b = z3;
        this.f115911c = timeConfigurationViewState;
        this.f115912d = usageLimitConfigurationViewState;
    }

    public static /* synthetic */ UsageLimitConditionViewState b(UsageLimitConditionViewState usageLimitConditionViewState, boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, UsageLimitConfigurationViewState usageLimitConfigurationViewState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = usageLimitConditionViewState.f115909a;
        }
        if ((i3 & 2) != 0) {
            z3 = usageLimitConditionViewState.f115910b;
        }
        if ((i3 & 4) != 0) {
            timeConditionConfigurationViewState = usageLimitConditionViewState.f115911c;
        }
        if ((i3 & 8) != 0) {
            usageLimitConfigurationViewState = usageLimitConditionViewState.f115912d;
        }
        return usageLimitConditionViewState.a(z2, z3, timeConditionConfigurationViewState, usageLimitConfigurationViewState);
    }

    public final UsageLimitConditionViewState a(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState, UsageLimitConfigurationViewState usageLimitConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(usageLimitConfigurationViewState, "usageLimitConfigurationViewState");
        return new UsageLimitConditionViewState(z2, z3, timeConfigurationViewState, usageLimitConfigurationViewState);
    }

    public final boolean c() {
        if (!this.f115911c.a() || this.f115912d.i().s() <= 0) {
            return false;
        }
        return this.f115912d.k() || this.f115912d.i().s() <= TimeUnit.MINUTES.toMillis((long) Limit.USAGE_LIMIT.getLimitValue());
    }

    public final TimeConditionConfigurationViewState d() {
        return this.f115911c;
    }

    public final UsageLimitConfigurationViewState e() {
        return this.f115912d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsageLimitConditionViewState)) {
            return false;
        }
        UsageLimitConditionViewState usageLimitConditionViewState = (UsageLimitConditionViewState) obj;
        return this.f115909a == usageLimitConditionViewState.f115909a && this.f115910b == usageLimitConditionViewState.f115910b && Intrinsics.areEqual(this.f115911c, usageLimitConditionViewState.f115911c) && Intrinsics.areEqual(this.f115912d, usageLimitConditionViewState.f115912d);
    }

    public final boolean f() {
        return this.f115910b;
    }

    public final boolean g() {
        return this.f115909a;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f115909a) * 31) + Boolean.hashCode(this.f115910b)) * 31) + this.f115911c.hashCode()) * 31) + this.f115912d.hashCode();
    }

    public String toString() {
        return "UsageLimitConditionViewState(isStrictModeActive=" + this.f115909a + ", isNewSchedule=" + this.f115910b + ", timeConfigurationViewState=" + this.f115911c + ", usageLimitConfigurationViewState=" + this.f115912d + ")";
    }

    public /* synthetic */ UsageLimitConditionViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, UsageLimitConfigurationViewState usageLimitConfigurationViewState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? new TimeConditionConfigurationViewState(null, false, false, false, false, null, false, 127, null) : timeConditionConfigurationViewState, (i3 & 8) != 0 ? new UsageLimitConfigurationViewState(null, 0L, false, null, null, 31, null) : usageLimitConfigurationViewState);
    }
}
