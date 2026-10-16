package cz.mobilesoft.statistics.util;

import cz.mobilesoft.statistics.model.AggregatedAverage;
import cz.mobilesoft.statistics.model.AggregatedRecord;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
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
public final class WeeklyAverage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeeklyAverage f133864a = new WeeklyAverage();

    private WeeklyAverage() {
    }

    public static /* synthetic */ AggregatedAverage b(WeeklyAverage weeklyAverage, List list, long j3, long j4, TimeZone timeZone, long j5, int i3, Object obj) {
        TimeZone timeZone2;
        if ((i3 & 8) != 0) {
            TimeZone timeZone3 = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone3, "getDefault(...)");
            timeZone2 = timeZone3;
        } else {
            timeZone2 = timeZone;
        }
        return weeklyAverage.a(list, j3, j4, timeZone2, (i3 & 16) != 0 ? System.currentTimeMillis() : j5);
    }

    public final AggregatedAverage a(List records, long j3, long j4, TimeZone timeZone, long j5) {
        int i3;
        Intrinsics.checkNotNullParameter(records, "records");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        HashSet hashSet = new HashSet();
        if (j4 > j3) {
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTimeInMillis(j3);
            i3 = 0;
            while (calendar.getTimeInMillis() < j4 && calendar.getTimeInMillis() <= j5) {
                i3++;
                hashSet.add(simpleDateFormat.format(calendar.getTime()));
                calendar.add(6, 1);
            }
        } else {
            i3 = 0;
        }
        int i4 = i3 != 0 ? i3 : 1;
        ArrayList arrayList = new ArrayList();
        for (Object obj : records) {
            if (hashSet.contains(((AggregatedRecord) obj).c())) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        long jIntValue = 0;
        long jD = 0;
        int i5 = 0;
        while (i5 < size) {
            Object obj2 = arrayList.get(i5);
            i5++;
            jD += (long) ((AggregatedRecord) obj2).d();
        }
        int size2 = arrayList.size();
        int i6 = 0;
        while (i6 < size2) {
            Object obj3 = arrayList.get(i6);
            i6++;
            Integer numF = ((AggregatedRecord) obj3).f();
            jIntValue += (long) (numF != null ? numF.intValue() : 0);
        }
        float f3 = jD;
        float f4 = i4;
        return new AggregatedAverage(f3 / f4, jIntValue / f4);
    }
}
