package cz.mobilesoft.coreblock.scene.more.settings.timenudge;

import cz.mobilesoft.coreblock.base.ViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class TimeNudgeSettingsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f110313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f110314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f110315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f110316d;

    public TimeNudgeSettingsViewState(boolean z2, List selectedApps, List list, boolean z3) {
        Intrinsics.checkNotNullParameter(selectedApps, "selectedApps");
        this.f110313a = z2;
        this.f110314b = selectedApps;
        this.f110315c = list;
        this.f110316d = z3;
    }

    public static /* synthetic */ TimeNudgeSettingsViewState b(TimeNudgeSettingsViewState timeNudgeSettingsViewState, boolean z2, List list, List list2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = timeNudgeSettingsViewState.f110313a;
        }
        if ((i3 & 2) != 0) {
            list = timeNudgeSettingsViewState.f110314b;
        }
        if ((i3 & 4) != 0) {
            list2 = timeNudgeSettingsViewState.f110315c;
        }
        if ((i3 & 8) != 0) {
            z3 = timeNudgeSettingsViewState.f110316d;
        }
        return timeNudgeSettingsViewState.a(z2, list, list2, z3);
    }

    public final TimeNudgeSettingsViewState a(boolean z2, List selectedApps, List list, boolean z3) {
        Intrinsics.checkNotNullParameter(selectedApps, "selectedApps");
        return new TimeNudgeSettingsViewState(z2, selectedApps, list, z3);
    }

    public final List c() {
        return this.f110315c;
    }

    public final List d() {
        return this.f110314b;
    }

    public final boolean e() {
        return this.f110316d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeNudgeSettingsViewState)) {
            return false;
        }
        TimeNudgeSettingsViewState timeNudgeSettingsViewState = (TimeNudgeSettingsViewState) obj;
        return this.f110313a == timeNudgeSettingsViewState.f110313a && Intrinsics.areEqual(this.f110314b, timeNudgeSettingsViewState.f110314b) && Intrinsics.areEqual(this.f110315c, timeNudgeSettingsViewState.f110315c) && this.f110316d == timeNudgeSettingsViewState.f110316d;
    }

    public final boolean f() {
        return this.f110313a;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.f110313a) * 31) + this.f110314b.hashCode()) * 31;
        List list = this.f110315c;
        return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.f110316d);
    }

    public String toString() {
        return "TimeNudgeSettingsViewState(isEnabled=" + this.f110313a + ", selectedApps=" + this.f110314b + ", missingPermissions=" + this.f110315c + ", statisticsDisabled=" + this.f110316d + ")";
    }

    public /* synthetic */ TimeNudgeSettingsViewState(boolean z2, List list, List list2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? null : list2, (i3 & 8) != 0 ? false : z3);
    }
}
