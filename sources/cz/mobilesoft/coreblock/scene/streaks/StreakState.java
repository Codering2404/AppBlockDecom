package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

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
public final class StreakState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f120508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakStats f120509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakEvaluator.DayPreview f120510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f120511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f120512e;

    public final StreakLine a() {
        Object objPrevious;
        List list = this.f120512e;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((StreakLine) objPrevious).d()) {
                break;
            }
        }
        return (StreakLine) objPrevious;
    }

    public final List b() {
        return this.f120511d;
    }

    public final List c() {
        return this.f120512e;
    }

    public final StreakStats d() {
        return this.f120509b;
    }

    public final boolean e() {
        return this.f120508a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakState)) {
            return false;
        }
        StreakState streakState = (StreakState) obj;
        return this.f120508a == streakState.f120508a && Intrinsics.areEqual(this.f120509b, streakState.f120509b) && Intrinsics.areEqual(this.f120510c, streakState.f120510c) && Intrinsics.areEqual(this.f120511d, streakState.f120511d) && Intrinsics.areEqual(this.f120512e, streakState.f120512e);
    }

    public final boolean f() {
        StreakEvaluator.DayPreview dayPreview = this.f120510c;
        return (dayPreview != null ? dayPreview.d() : null) == StreakDayStatus.LOST;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.f120508a) * 31) + this.f120509b.hashCode()) * 31;
        StreakEvaluator.DayPreview dayPreview = this.f120510c;
        return ((((iHashCode + (dayPreview == null ? 0 : dayPreview.hashCode())) * 31) + this.f120511d.hashCode()) * 31) + this.f120512e.hashCode();
    }

    public String toString() {
        return "StreakState(isEnabled=" + this.f120508a + ", stats=" + this.f120509b + ", todayPreview=" + this.f120510c + ", days=" + this.f120511d + ", lines=" + this.f120512e + ")";
    }

    public StreakState(boolean z2, StreakStats stats, StreakEvaluator.DayPreview dayPreview, List days, List list) {
        Intrinsics.checkNotNullParameter(stats, "stats");
        Intrinsics.checkNotNullParameter(days, "days");
        Intrinsics.checkNotNullParameter(list, vgWWUoTKYyuC.IMGMWfoPdkc);
        this.f120508a = z2;
        this.f120509b = stats;
        this.f120510c = dayPreview;
        this.f120511d = days;
        this.f120512e = list;
    }
}
