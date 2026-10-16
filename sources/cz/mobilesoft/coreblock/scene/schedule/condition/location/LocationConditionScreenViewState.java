package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
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
public final class LocationConditionScreenViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f115445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f115446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeConditionConfigurationViewState f115447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocationConfigurationViewState f115448d;

    public LocationConditionScreenViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState, LocationConfigurationViewState locationConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(locationConfigurationViewState, "locationConfigurationViewState");
        this.f115445a = z2;
        this.f115446b = z3;
        this.f115447c = timeConfigurationViewState;
        this.f115448d = locationConfigurationViewState;
    }

    public static /* synthetic */ LocationConditionScreenViewState b(LocationConditionScreenViewState locationConditionScreenViewState, boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, LocationConfigurationViewState locationConfigurationViewState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = locationConditionScreenViewState.f115445a;
        }
        if ((i3 & 2) != 0) {
            z3 = locationConditionScreenViewState.f115446b;
        }
        if ((i3 & 4) != 0) {
            timeConditionConfigurationViewState = locationConditionScreenViewState.f115447c;
        }
        if ((i3 & 8) != 0) {
            locationConfigurationViewState = locationConditionScreenViewState.f115448d;
        }
        return locationConditionScreenViewState.a(z2, z3, timeConditionConfigurationViewState, locationConfigurationViewState);
    }

    public final LocationConditionScreenViewState a(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConfigurationViewState, LocationConfigurationViewState locationConfigurationViewState) {
        Intrinsics.checkNotNullParameter(timeConfigurationViewState, "timeConfigurationViewState");
        Intrinsics.checkNotNullParameter(locationConfigurationViewState, "locationConfigurationViewState");
        return new LocationConditionScreenViewState(z2, z3, timeConfigurationViewState, locationConfigurationViewState);
    }

    public final LocationConfigurationViewState c() {
        return this.f115448d;
    }

    public final TimeConditionConfigurationViewState d() {
        return this.f115447c;
    }

    public final boolean e() {
        return this.f115445a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationConditionScreenViewState)) {
            return false;
        }
        LocationConditionScreenViewState locationConditionScreenViewState = (LocationConditionScreenViewState) obj;
        return this.f115445a == locationConditionScreenViewState.f115445a && this.f115446b == locationConditionScreenViewState.f115446b && Intrinsics.areEqual(this.f115447c, locationConditionScreenViewState.f115447c) && Intrinsics.areEqual(this.f115448d, locationConditionScreenViewState.f115448d);
    }

    public final boolean f() {
        return this.f115447c.a() && this.f115448d.a();
    }

    public final boolean g() {
        return this.f115446b;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f115445a) * 31) + Boolean.hashCode(this.f115446b)) * 31) + this.f115447c.hashCode()) * 31) + this.f115448d.hashCode();
    }

    public String toString() {
        return "LocationConditionScreenViewState(isNewSchedule=" + this.f115445a + ", isStrictModeActive=" + this.f115446b + ", timeConfigurationViewState=" + this.f115447c + ", locationConfigurationViewState=" + this.f115448d + ")";
    }

    public /* synthetic */ LocationConditionScreenViewState(boolean z2, boolean z3, TimeConditionConfigurationViewState timeConditionConfigurationViewState, LocationConfigurationViewState locationConfigurationViewState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) == 0 ? z3 : false, (i3 & 4) != 0 ? new TimeConditionConfigurationViewState(null, false, false, false, false, null, false, 127, null) : timeConditionConfigurationViewState, (i3 & 8) != 0 ? new LocationConfigurationViewState(0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null) : locationConfigurationViewState);
    }
}
