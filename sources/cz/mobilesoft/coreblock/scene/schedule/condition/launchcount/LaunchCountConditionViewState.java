package cz.mobilesoft.coreblock.scene.schedule.condition.launchcount;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LaunchCountConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
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
public final class LaunchCountConditionViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f115262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f115263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeConditionConfigurationViewState f115264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LaunchCountConditionConfigurationViewState f115265d;

    public LaunchCountConditionViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState, LaunchCountConditionConfigurationViewState launchCountConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(launchCountConfigurationViewState, "launchCountConfigurationViewState");
        this.f115262a = z2;
        this.f115263b = z3;
        this.f115264c = timeConfigurationViewState;
        this.f115265d = launchCountConfigurationViewState;
    }

    public static /* synthetic */ LaunchCountConditionViewState b(LaunchCountConditionViewState launchCountConditionViewState, boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = launchCountConditionViewState.f115262a;
        }
        if ((i3 & 2) != 0) {
            z3 = launchCountConditionViewState.f115263b;
        }
        if ((i3 & 4) != 0) {
            timeConditionConfigurationViewState = launchCountConditionViewState.f115264c;
        }
        if ((i3 & 8) != 0) {
            launchCountConditionConfigurationViewState = launchCountConditionViewState.f115265d;
        }
        return launchCountConditionViewState.a(z2, z3, timeConditionConfigurationViewState, launchCountConditionConfigurationViewState);
    }

    public final LaunchCountConditionViewState a(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState, LaunchCountConditionConfigurationViewState launchCountConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(launchCountConfigurationViewState, "launchCountConfigurationViewState");
        return new LaunchCountConditionViewState(z2, z3, timeConfigurationViewState, launchCountConfigurationViewState);
    }

    public final LaunchCountConditionConfigurationViewState c() {
        return this.f115265d;
    }

    public final TimeConditionConfigurationViewState d() {
        return this.f115264c;
    }

    public final boolean e() {
        return this.f115262a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LaunchCountConditionViewState)) {
            return false;
        }
        LaunchCountConditionViewState launchCountConditionViewState = (LaunchCountConditionViewState) obj;
        return this.f115262a == launchCountConditionViewState.f115262a && this.f115263b == launchCountConditionViewState.f115263b && Intrinsics.areEqual(this.f115264c, launchCountConditionViewState.f115264c) && Intrinsics.areEqual(this.f115265d, launchCountConditionViewState.f115265d);
    }

    public final boolean f() {
        return this.f115265d.a() && this.f115264c.a();
    }

    public final boolean g() {
        return this.f115263b;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f115262a) * 31) + Boolean.hashCode(this.f115263b)) * 31) + this.f115264c.hashCode()) * 31) + this.f115265d.hashCode();
    }

    public String toString() {
        return "LaunchCountConditionViewState(isNewSchedule=" + this.f115262a + ", isStrictModeActive=" + this.f115263b + ", timeConfigurationViewState=" + this.f115264c + ", launchCountConfigurationViewState=" + this.f115265d + ")";
    }

    public /* synthetic */ LaunchCountConditionViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) == 0 ? z3 : false, (i3 & 4) != 0 ? new TimeConditionConfigurationViewState(null, false, false, false, false, null, false, 127, null) : timeConditionConfigurationViewState, (i3 & 8) != 0 ? new LaunchCountConditionConfigurationViewState(0L, null, 0L, false, null, 31, null) : launchCountConditionConfigurationViewState);
    }
}
