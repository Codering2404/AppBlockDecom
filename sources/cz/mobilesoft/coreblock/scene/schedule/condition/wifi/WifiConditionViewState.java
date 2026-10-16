package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
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
public final class WifiConditionViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f116082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f116083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeConditionConfigurationViewState f116084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WifiConfigurationViewState f116085d;

    public WifiConditionViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState, WifiConfigurationViewState wifiConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(wifiConfigurationViewState, "wifiConfigurationViewState");
        this.f116082a = z2;
        this.f116083b = z3;
        this.f116084c = timeConfigurationViewState;
        this.f116085d = wifiConfigurationViewState;
    }

    public static /* synthetic */ WifiConditionViewState b(WifiConditionViewState wifiConditionViewState, boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, WifiConfigurationViewState wifiConfigurationViewState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = wifiConditionViewState.f116082a;
        }
        if ((i3 & 2) != 0) {
            z3 = wifiConditionViewState.f116083b;
        }
        if ((i3 & 4) != 0) {
            timeConditionConfigurationViewState = wifiConditionViewState.f116084c;
        }
        if ((i3 & 8) != 0) {
            wifiConfigurationViewState = wifiConditionViewState.f116085d;
        }
        return wifiConditionViewState.a(z2, z3, timeConditionConfigurationViewState, wifiConfigurationViewState);
    }

    public final WifiConditionViewState a(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState, WifiConfigurationViewState wifiConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(wifiConfigurationViewState, "wifiConfigurationViewState");
        return new WifiConditionViewState(z2, z3, timeConfigurationViewState, wifiConfigurationViewState);
    }

    public final TimeConditionConfigurationViewState c() {
        return this.f116084c;
    }

    public final WifiConfigurationViewState d() {
        return this.f116085d;
    }

    public final boolean e() {
        return this.f116083b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiConditionViewState)) {
            return false;
        }
        WifiConditionViewState wifiConditionViewState = (WifiConditionViewState) obj;
        return this.f116082a == wifiConditionViewState.f116082a && this.f116083b == wifiConditionViewState.f116083b && Intrinsics.areEqual(this.f116084c, wifiConditionViewState.f116084c) && Intrinsics.areEqual(this.f116085d, wifiConditionViewState.f116085d);
    }

    public final boolean f() {
        return this.f116085d.a() && this.f116084c.a();
    }

    public final boolean g() {
        return this.f116082a;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f116082a) * 31) + Boolean.hashCode(this.f116083b)) * 31) + this.f116084c.hashCode()) * 31) + this.f116085d.hashCode();
    }

    public String toString() {
        return "WifiConditionViewState(isStrictModeActive=" + this.f116082a + ", isNewSchedule=" + this.f116083b + ", timeConfigurationViewState=" + this.f116084c + ", wifiConfigurationViewState=" + this.f116085d + ")";
    }

    public /* synthetic */ WifiConditionViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, WifiConfigurationViewState wifiConfigurationViewState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) == 0 ? z3 : false, (i3 & 4) != 0 ? new TimeConditionConfigurationViewState(null, false, false, false, false, null, false, 127, null) : timeConditionConfigurationViewState, (i3 & 8) != 0 ? new WifiConfigurationViewState(null, false, false, null, null, null, null, false, false, false, 1023, null) : wifiConfigurationViewState);
    }
}
