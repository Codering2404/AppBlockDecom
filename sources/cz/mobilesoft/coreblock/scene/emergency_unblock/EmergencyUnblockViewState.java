package cz.mobilesoft.coreblock.scene.emergency_unblock;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EmergencyUnblockViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f101793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f101794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f101795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StrictModeAccessMethod f101796d;

    public EmergencyUnblockViewState(List emergencyUnblockingList, boolean z2, List emergencyUnblocksLastMonth, StrictModeAccessMethod strictModeAccessMethod) {
        Intrinsics.checkNotNullParameter(emergencyUnblockingList, "emergencyUnblockingList");
        Intrinsics.checkNotNullParameter(emergencyUnblocksLastMonth, "emergencyUnblocksLastMonth");
        this.f101793a = emergencyUnblockingList;
        this.f101794b = z2;
        this.f101795c = emergencyUnblocksLastMonth;
        this.f101796d = strictModeAccessMethod;
    }

    public static /* synthetic */ EmergencyUnblockViewState b(EmergencyUnblockViewState emergencyUnblockViewState, List list, boolean z2, List list2, StrictModeAccessMethod strictModeAccessMethod, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = emergencyUnblockViewState.f101793a;
        }
        if ((i3 & 2) != 0) {
            z2 = emergencyUnblockViewState.f101794b;
        }
        if ((i3 & 4) != 0) {
            list2 = emergencyUnblockViewState.f101795c;
        }
        if ((i3 & 8) != 0) {
            strictModeAccessMethod = emergencyUnblockViewState.f101796d;
        }
        return emergencyUnblockViewState.a(list, z2, list2, strictModeAccessMethod);
    }

    public final EmergencyUnblockViewState a(List emergencyUnblockingList, boolean z2, List emergencyUnblocksLastMonth, StrictModeAccessMethod strictModeAccessMethod) {
        Intrinsics.checkNotNullParameter(emergencyUnblockingList, "emergencyUnblockingList");
        Intrinsics.checkNotNullParameter(emergencyUnblocksLastMonth, "emergencyUnblocksLastMonth");
        return new EmergencyUnblockViewState(emergencyUnblockingList, z2, emergencyUnblocksLastMonth, strictModeAccessMethod);
    }

    public final boolean c() {
        return this.f101794b;
    }

    public final int d() {
        return this.f101795c.size() > 2 ? this.f101795c.size() + this.f101793a.size() : this.f101793a.size();
    }

    public final List e() {
        return this.f101793a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmergencyUnblockViewState)) {
            return false;
        }
        EmergencyUnblockViewState emergencyUnblockViewState = (EmergencyUnblockViewState) obj;
        return Intrinsics.areEqual(this.f101793a, emergencyUnblockViewState.f101793a) && this.f101794b == emergencyUnblockViewState.f101794b && Intrinsics.areEqual(this.f101795c, emergencyUnblockViewState.f101795c) && this.f101796d == emergencyUnblockViewState.f101796d;
    }

    public final StrictModeGlowColor f(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(443569134, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewState.<get-glowColor> (EmergencyUnblockViewState.kt:24)");
        }
        StrictModeGlowColor strictModeGlowColor = StrictModeGlowColor.Purple;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return strictModeGlowColor;
    }

    public int hashCode() {
        int iHashCode = ((((this.f101793a.hashCode() * 31) + Boolean.hashCode(this.f101794b)) * 31) + this.f101795c.hashCode()) * 31;
        StrictModeAccessMethod strictModeAccessMethod = this.f101796d;
        return iHashCode + (strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode());
    }

    public String toString() {
        return "EmergencyUnblockViewState(emergencyUnblockingList=" + this.f101793a + ", alwaysValidateEmergencyString=" + this.f101794b + ", emergencyUnblocksLastMonth=" + this.f101795c + ", strictModeAccessMethod=" + this.f101796d + ")";
    }

    public /* synthetic */ EmergencyUnblockViewState(List list, boolean z2, List list2, StrictModeAccessMethod strictModeAccessMethod, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 8) != 0 ? null : strictModeAccessMethod);
    }
}
