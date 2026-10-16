package cz.mobilesoft.coreblock.dto;

import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppWebWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AggregatedItemRecord f96897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList f96898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StatisticsUsageTypeFilter f96899c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f96900a;

        static {
            int[] iArr = new int[StatisticsUsageTypeFilter.values().length];
            try {
                iArr[StatisticsUsageTypeFilter.USAGE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StatisticsUsageTypeFilter.LAUNCH_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StatisticsUsageTypeFilter.UNLOCKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f96900a = iArr;
        }
    }

    public AppWebWrapper(AggregatedItemRecord aggregatedItemRecord, ArrayList arrayList, StatisticsUsageTypeFilter usageType) {
        Intrinsics.checkNotNullParameter(usageType, "usageType");
        this.f96897a = aggregatedItemRecord;
        this.f96898b = arrayList;
        this.f96899c = usageType;
    }

    public final AggregatedItemRecord a() {
        return this.f96897a;
    }

    public final int b() {
        Integer numD;
        AggregatedItemRecord aggregatedItemRecord = this.f96897a;
        int i3 = 0;
        int iIntValue = (aggregatedItemRecord == null || (numD = aggregatedItemRecord.d()) == null) ? 0 : numD.intValue();
        ArrayList arrayList = this.f96898b;
        if (arrayList != null) {
            int size = arrayList.size();
            int iIntValue2 = 0;
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                Integer numD2 = ((AggregatedItemRecord) obj).d();
                iIntValue2 += numD2 != null ? numD2.intValue() : 0;
            }
            i3 = iIntValue2;
        }
        return iIntValue + i3;
    }

    public final int c() {
        AggregatedItemRecord aggregatedItemRecord = this.f96897a;
        int iC = 0;
        int iC2 = aggregatedItemRecord != null ? aggregatedItemRecord.c() : 0;
        ArrayList arrayList = this.f96898b;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                iC += ((AggregatedItemRecord) obj).c();
            }
        }
        return iC2 + iC;
    }

    public final StatisticsUsageTypeFilter d() {
        return this.f96899c;
    }

    public final int e() {
        int i3 = WhenMappings.f96900a[this.f96899c.ordinal()];
        if (i3 == 1) {
            return c();
        }
        if (i3 == 2 || i3 == 3) {
            return b();
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppWebWrapper)) {
            return false;
        }
        AppWebWrapper appWebWrapper = (AppWebWrapper) obj;
        return Intrinsics.areEqual(this.f96897a, appWebWrapper.f96897a) && Intrinsics.areEqual(this.f96898b, appWebWrapper.f96898b) && this.f96899c == appWebWrapper.f96899c;
    }

    public final ArrayList f() {
        return this.f96898b;
    }

    public final void g(AggregatedItemRecord aggregatedItemRecord) {
        this.f96897a = aggregatedItemRecord;
    }

    public final void h(ArrayList arrayList) {
        this.f96898b = arrayList;
    }

    public int hashCode() {
        AggregatedItemRecord aggregatedItemRecord = this.f96897a;
        int iHashCode = (aggregatedItemRecord == null ? 0 : aggregatedItemRecord.hashCode()) * 31;
        ArrayList arrayList = this.f96898b;
        return ((iHashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31) + this.f96899c.hashCode();
    }

    public String toString() {
        return "AppWebWrapper(app=" + this.f96897a + ", webs=" + this.f96898b + ", usageType=" + this.f96899c + ")";
    }

    public /* synthetic */ AppWebWrapper(AggregatedItemRecord aggregatedItemRecord, ArrayList arrayList, StatisticsUsageTypeFilter statisticsUsageTypeFilter, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aggregatedItemRecord, (i3 & 2) != 0 ? null : arrayList, (i3 & 4) != 0 ? StatisticsUsageTypeFilter.USAGE_TIME : statisticsUsageTypeFilter);
    }
}
