package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import cz.mobilesoft.coreblock.base.ViewState;
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
public final class TimeConditionViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f115781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f115782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeConditionConfigurationViewState f115783c;

    public TimeConditionViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        this.f115781a = z2;
        this.f115782b = z3;
        this.f115783c = timeConfigurationViewState;
    }

    public static /* synthetic */ TimeConditionViewState b(TimeConditionViewState timeConditionViewState, boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = timeConditionViewState.f115781a;
        }
        if ((i3 & 2) != 0) {
            z3 = timeConditionViewState.f115782b;
        }
        if ((i3 & 4) != 0) {
            timeConditionConfigurationViewState = timeConditionViewState.f115783c;
        }
        return timeConditionViewState.a(z2, z3, timeConditionConfigurationViewState);
    }

    public final TimeConditionViewState a(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        return new TimeConditionViewState(z2, z3, timeConfigurationViewState);
    }

    public final TimeConditionConfigurationViewState c() {
        return this.f115783c;
    }

    public final boolean d() {
        return this.f115782b;
    }

    public final boolean e() {
        return this.f115783c.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeConditionViewState)) {
            return false;
        }
        TimeConditionViewState timeConditionViewState = (TimeConditionViewState) obj;
        return this.f115781a == timeConditionViewState.f115781a && this.f115782b == timeConditionViewState.f115782b && Intrinsics.areEqual(this.f115783c, timeConditionViewState.f115783c);
    }

    public final boolean f() {
        return this.f115781a;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f115781a) * 31) + Boolean.hashCode(this.f115782b)) * 31) + this.f115783c.hashCode();
    }

    public String toString() {
        return "TimeConditionViewState(isStrictModeActive=" + this.f115781a + ", isNewSchedule=" + this.f115782b + ", timeConfigurationViewState=" + this.f115783c + ")";
    }

    public /* synthetic */ TimeConditionViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? new TimeConditionConfigurationViewState(null, false, false, false, false, null, false, 127, null) : timeConditionConfigurationViewState);
    }
}
