package cz.mobilesoft.coreblock.scene.timenudge;

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
public final class TimeNudgeViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f122884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f122885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f122886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f122887d;

    public TimeNudgeViewState(boolean z2, long j3, long j4, List selectedApps) {
        Intrinsics.checkNotNullParameter(selectedApps, "selectedApps");
        this.f122884a = z2;
        this.f122885b = j3;
        this.f122886c = j4;
        this.f122887d = selectedApps;
    }

    public final TimeNudgeViewState a(boolean z2, long j3, long j4, List selectedApps) {
        Intrinsics.checkNotNullParameter(selectedApps, "selectedApps");
        return new TimeNudgeViewState(z2, j3, j4, selectedApps);
    }

    public final List b() {
        return this.f122887d;
    }

    public final long c() {
        return this.f122885b;
    }

    public final long d() {
        return this.f122886c;
    }

    public final boolean e() {
        return this.f122884a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeNudgeViewState)) {
            return false;
        }
        TimeNudgeViewState timeNudgeViewState = (TimeNudgeViewState) obj;
        return this.f122884a == timeNudgeViewState.f122884a && this.f122885b == timeNudgeViewState.f122885b && this.f122886c == timeNudgeViewState.f122886c && Intrinsics.areEqual(this.f122887d, timeNudgeViewState.f122887d);
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f122884a) * 31) + Long.hashCode(this.f122885b)) * 31) + Long.hashCode(this.f122886c)) * 31) + this.f122887d.hashCode();
    }

    public String toString() {
        return "TimeNudgeViewState(isLoading=" + this.f122884a + ", selectedAppsTimeSeconds=" + this.f122885b + ", totalTimeSeconds=" + this.f122886c + ", selectedApps=" + this.f122887d + ")";
    }

    public /* synthetic */ TimeNudgeViewState(boolean z2, long j3, long j4, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? 0L : j4, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list);
    }
}
