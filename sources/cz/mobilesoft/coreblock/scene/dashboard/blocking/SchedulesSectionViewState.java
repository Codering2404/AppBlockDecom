package cz.mobilesoft.coreblock.scene.dashboard.blocking;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SchedulesSectionViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f100016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f100017b;

    public SchedulesSectionViewState(boolean z2, List profiles) {
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        this.f100016a = z2;
        this.f100017b = profiles;
    }

    public static /* synthetic */ SchedulesSectionViewState b(SchedulesSectionViewState schedulesSectionViewState, boolean z2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = schedulesSectionViewState.f100016a;
        }
        if ((i3 & 2) != 0) {
            list = schedulesSectionViewState.f100017b;
        }
        return schedulesSectionViewState.a(z2, list);
    }

    public final SchedulesSectionViewState a(boolean z2, List profiles) {
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        return new SchedulesSectionViewState(z2, profiles);
    }

    public final List c() {
        return this.f100017b;
    }

    public final boolean d() {
        return this.f100016a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchedulesSectionViewState)) {
            return false;
        }
        SchedulesSectionViewState schedulesSectionViewState = (SchedulesSectionViewState) obj;
        return this.f100016a == schedulesSectionViewState.f100016a && Intrinsics.areEqual(this.f100017b, schedulesSectionViewState.f100017b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f100016a) * 31) + this.f100017b.hashCode();
    }

    public String toString() {
        return "SchedulesSectionViewState(profilesLoading=" + this.f100016a + ", profiles=" + this.f100017b + ")";
    }

    public /* synthetic */ SchedulesSectionViewState(boolean z2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}
