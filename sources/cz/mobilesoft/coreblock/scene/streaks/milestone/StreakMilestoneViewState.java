package cz.mobilesoft.coreblock.scene.streaks.milestone;

import cz.mobilesoft.coreblock.R;
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
public final class StreakMilestoneViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f120959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f120960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f120961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f120962d;

    public StreakMilestoneViewState(boolean z2, int i3, List weekStatuses, Integer num) {
        Intrinsics.checkNotNullParameter(weekStatuses, "weekStatuses");
        this.f120959a = z2;
        this.f120960b = i3;
        this.f120961c = weekStatuses;
        this.f120962d = num;
    }

    public final StreakMilestoneViewState a(boolean z2, int i3, List weekStatuses, Integer num) {
        Intrinsics.checkNotNullParameter(weekStatuses, "weekStatuses");
        return new StreakMilestoneViewState(z2, i3, weekStatuses, num);
    }

    public final Integer b() {
        return this.f120962d;
    }

    public final boolean c() {
        return this.f120960b < 3;
    }

    public final int d() {
        return this.f120960b;
    }

    public final int e() {
        int i3 = this.f120960b;
        return i3 == 1 ? R.string.nB : (2 > i3 || i3 >= 7) ? i3 == 7 ? R.string.pB : i3 == 30 ? R.string.mB : R.string.lB : R.string.oB;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakMilestoneViewState)) {
            return false;
        }
        StreakMilestoneViewState streakMilestoneViewState = (StreakMilestoneViewState) obj;
        return this.f120959a == streakMilestoneViewState.f120959a && this.f120960b == streakMilestoneViewState.f120960b && Intrinsics.areEqual(this.f120961c, streakMilestoneViewState.f120961c) && Intrinsics.areEqual(this.f120962d, streakMilestoneViewState.f120962d);
    }

    public final int f() {
        return this.f120960b == 1 ? R.string.kB : R.string.VA;
    }

    public final List g() {
        return this.f120961c;
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.f120959a) * 31) + Integer.hashCode(this.f120960b)) * 31) + this.f120961c.hashCode()) * 31;
        Integer num = this.f120962d;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "StreakMilestoneViewState(isLoading=" + this.f120959a + ", streakCount=" + this.f120960b + ", weekStatuses=" + this.f120961c + ", highlightedWeekdayIndex=" + this.f120962d + ")";
    }

    public /* synthetic */ StreakMilestoneViewState(boolean z2, int i3, List list, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? true : z2, (i4 & 2) != 0 ? 0 : i3, (i4 & 4) != 0 ? CollectionsKt.emptyList() : list, (i4 & 8) != 0 ? null : num);
    }
}
