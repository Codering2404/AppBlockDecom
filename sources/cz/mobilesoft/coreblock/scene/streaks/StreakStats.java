package cz.mobilesoft.coreblock.scene.streaks;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class StreakStats {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f120513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f120514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f120515c;

    public StreakStats(int i3, int i4, int i5) {
        this.f120513a = i3;
        this.f120514b = i4;
        this.f120515c = i5;
    }

    public final int a() {
        return this.f120514b;
    }

    public final int b() {
        return this.f120513a;
    }

    public final int c() {
        return this.f120515c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakStats)) {
            return false;
        }
        StreakStats streakStats = (StreakStats) obj;
        return this.f120513a == streakStats.f120513a && this.f120514b == streakStats.f120514b && this.f120515c == streakStats.f120515c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f120513a) * 31) + Integer.hashCode(this.f120514b)) * 31) + Integer.hashCode(this.f120515c);
    }

    public String toString() {
        return "StreakStats(currentCount=" + this.f120513a + ", bestCount=" + this.f120514b + ", totalDaysCount=" + this.f120515c + ")";
    }

    public /* synthetic */ StreakStats(int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i3, (i6 & 2) != 0 ? 0 : i4, (i6 & 4) != 0 ? 0 : i5);
    }
}
