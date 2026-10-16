package cz.mobilesoft.coreblock.scene.schedule;

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
public final class ScheduleResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f114498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f114499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f114500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f114501d;

    public ScheduleResult(boolean z2, Integer num, Long l3, boolean z3) {
        this.f114498a = z2;
        this.f114499b = num;
        this.f114500c = l3;
        this.f114501d = z3;
    }

    public final boolean a() {
        return this.f114501d;
    }

    public final Integer b() {
        return this.f114499b;
    }

    public final Long c() {
        return this.f114500c;
    }

    public final boolean d() {
        return this.f114498a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleResult)) {
            return false;
        }
        ScheduleResult scheduleResult = (ScheduleResult) obj;
        return this.f114498a == scheduleResult.f114498a && Intrinsics.areEqual(this.f114499b, scheduleResult.f114499b) && Intrinsics.areEqual(this.f114500c, scheduleResult.f114500c) && this.f114501d == scheduleResult.f114501d;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.f114498a) * 31;
        Integer num = this.f114499b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l3 = this.f114500c;
        return ((iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31) + Boolean.hashCode(this.f114501d);
    }

    public String toString() {
        return "ScheduleResult(isSuccess=" + this.f114498a + ", newScheduleTypeCombinations=" + this.f114499b + ", scheduleId=" + this.f114500c + ", addToFollowSchedules=" + this.f114501d + ")";
    }

    public /* synthetic */ ScheduleResult(boolean z2, Integer num, Long l3, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : l3, (i3 & 8) != 0 ? false : z3);
    }
}
