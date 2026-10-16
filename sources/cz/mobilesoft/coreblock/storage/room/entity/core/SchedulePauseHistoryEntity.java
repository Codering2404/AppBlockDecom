package cz.mobilesoft.coreblock.storage.room.entity.core;

import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
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
public final class SchedulePauseHistoryEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f126605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f126606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f126607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f126608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f126609e;

    public SchedulePauseHistoryEntity(int i3, int i4, int i5, boolean z2, Long l3) {
        this.f126605a = i3;
        this.f126606b = i4;
        this.f126607c = i5;
        this.f126608d = z2;
        this.f126609e = l3;
    }

    public final int a() {
        return this.f126605a;
    }

    public final int b() {
        return this.f126606b;
    }

    public final Long c() {
        return this.f126609e;
    }

    public final int d() {
        return this.f126607c;
    }

    public final boolean e() {
        return this.f126608d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchedulePauseHistoryEntity)) {
            return false;
        }
        SchedulePauseHistoryEntity schedulePauseHistoryEntity = (SchedulePauseHistoryEntity) obj;
        return this.f126605a == schedulePauseHistoryEntity.f126605a && this.f126606b == schedulePauseHistoryEntity.f126606b && this.f126607c == schedulePauseHistoryEntity.f126607c && this.f126608d == schedulePauseHistoryEntity.f126608d && Intrinsics.areEqual(this.f126609e, schedulePauseHistoryEntity.f126609e);
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.f126605a) * 31) + Integer.hashCode(this.f126606b)) * 31) + Integer.hashCode(this.f126607c)) * 31) + Boolean.hashCode(this.f126608d)) * 31;
        Long l3 = this.f126609e;
        return iHashCode + (l3 == null ? 0 : l3.hashCode());
    }

    public String toString() {
        return "SchedulePauseHistoryEntity(id=" + this.f126605a + ", pauseTimeSeconds=" + this.f126606b + ", updatedAt=" + this.f126607c + ", isForToday=" + this.f126608d + ", profileId=" + this.f126609e + ")";
    }

    public /* synthetic */ SchedulePauseHistoryEntity(int i3, int i4, int i5, boolean z2, Long l3, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i3, i4, (i6 & 4) != 0 ? TimeHelperExt.f128663a.g() : i5, z2, (i6 & 16) != 0 ? null : l3);
    }
}
