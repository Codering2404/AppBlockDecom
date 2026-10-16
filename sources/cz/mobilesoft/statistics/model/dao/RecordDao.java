package cz.mobilesoft.statistics.model.dao;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import cz.mobilesoft.statistics.model.AggregatedAverage;
import cz.mobilesoft.statistics.model.AggregatedRecordsWithAverage;
import cz.mobilesoft.statistics.model.Record;
import cz.mobilesoft.statistics.util.WeeklyAverage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface RecordDao extends BaseDao<Record> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    private default String I(Integer[] numArr, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder();
        if (numArr != null) {
            sb.append("AND typeId IN (" + TextUtils.join(",", numArr) + ") ");
        }
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add("'" + str + "'");
            }
            sb.append("AND name IN (" + TextUtils.join(",", arrayList) + ") ");
        }
        if (strArr2 != null) {
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            for (String str2 : strArr2) {
                arrayList2.add("'" + str2 + "'");
            }
            sb.append("AND name NOT IN (" + TextUtils.join(",", arrayList2) + ") ");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "with(...)");
        return string;
    }

    private default SimpleSQLiteQuery o(String str, Integer[] numArr, String[] strArr, String[] strArr2, String str2, String str3, long j3, long j4) {
        Long[] lArr;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " + str + " AS date, \n                        SUM(isInitial) AS launchCount, \n                        SUM(duration) AS duration, \n                        typeId, appDistractionType \n                        FROM record LEFT JOIN applicationAppType \n                        ON record.name = applicationAppType.packageName \n                        WHERE timestamp BETWEEN ?/1000 AND ?/1000 ");
        if (numArr == null && strArr == null && strArr2 == null) {
            sb.append(y());
            lArr = new Long[]{Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j4)};
        } else {
            if (numArr == null) {
                sb.append(y());
            }
            sb.append(I(numArr, strArr, strArr2));
            lArr = numArr == null ? new Long[]{Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j4)} : new Long[]{Long.valueOf(j3), Long.valueOf(j4)};
        }
        if (str2 != null) {
            sb.append("AND category = '" + str2 + "' ");
        }
        if (str3 != null) {
            sb.append("AND applicationAppType.appDistractionType = '" + str3 + "' ");
        }
        sb.append("GROUP BY date, applicationAppType.appDistractionType ORDER BY date, typeId");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new SimpleSQLiteQuery(string, lArr);
    }

    private default SimpleSQLiteQuery p(String str, Integer[] numArr, String[] strArr, String[] strArr2, String str2, String str3, long j3, long j4) {
        Long[] lArr;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT AVG(duration) as avgDuration,\n\t\t\t             AVG(launchCount) as avgLaunchCount FROM (");
        sb.append("SELECT SUM(duration) AS duration, \n                        SUM(isInitial) AS launchCount \n                        FROM record \n                        LEFT JOIN applicationAppType ON record.name = applicationAppType.packageName \n                        WHERE timestamp BETWEEN ?/1000 AND ?/1000 ");
        if (numArr == null && strArr == null && strArr2 == null) {
            sb.append(y());
            lArr = new Long[]{Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j4)};
        } else {
            if (numArr == null) {
                sb.append(y());
            }
            sb.append(I(numArr, strArr, strArr2));
            lArr = new Long[]{Long.valueOf(j3), Long.valueOf(j4)};
        }
        if (str2 != null) {
            sb.append("AND category = '" + str2 + "' ");
        }
        if (str3 != null) {
            sb.append("AND applicationAppType.appDistractionType = '" + str3 + "' ");
        }
        sb.append("GROUP BY " + str);
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new SimpleSQLiteQuery(string, lArr);
    }

    private default String y() {
        return "AND name || \"_\" || timestamp NOT IN (\n\t\t\t\tSELECT parentName || \"_\" || timestamp\n\t\t\t\tFROM record\n\t\t\t\tWHERE parentName IS NOT NULL\n                AND timestamp BETWEEN ?/1000 AND ?/1000) ";
    }

    List A(SupportSQLiteQuery supportSQLiteQuery);

    Object B(Collection collection, List list, long j3, long j4, Continuation continuation);

    Object C(List list, long j3, long j4, Continuation continuation);

    Object D(List list, long j3, long j4, Continuation continuation);

    Object E(List list, long j3, long j4, Continuation continuation);

    Object G(String str, long j3, long j4, Continuation continuation);

    Object H(Collection collection, List list, String str, long j3, long j4, Continuation continuation);

    List J(SupportSQLiteQuery supportSQLiteQuery);

    Flow K(Collection collection, List list, long j3, long j4);

    Object L(Collection collection, List list, long j3, long j4, Continuation continuation);

    Object M(Collection collection, List list, long j3, long j4, Continuation continuation);

    Object N(List list, long j3, long j4, Continuation continuation);

    Object O(List list, long j3, long j4, Continuation continuation);

    default AggregatedRecordsWithAverage P(Integer[] numArr, String[] strArr, String[] strArr2, long j3, long j4) {
        return new AggregatedRecordsWithAverage(T(p("strftime('%H', timestamp, 'unixepoch', 'localtime')", numArr, strArr, strArr2, null, null, j3, j4)), A(o("strftime('%H', timestamp, 'unixepoch', 'localtime')", numArr, strArr, strArr2, null, null, j3, j4)));
    }

    Object Q(Collection collection, List list, long j3, long j4, Continuation continuation);

    default List R(String dateFormat, Integer[] numArr, String[] strArr, String[] strArr2, String str, String str2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(dateFormat, "dateFormat");
        return A(o(dateFormat, numArr, strArr, strArr2, str, str2, j3, j4));
    }

    default AggregatedRecordsWithAverage S(String dateFormat, Integer[] numArr, String[] strArr, String[] strArr2, String str, String str2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(dateFormat, "dateFormat");
        return new AggregatedRecordsWithAverage(T(p(dateFormat, numArr, strArr, strArr2, str, str2, j3, j4)), A(o(dateFormat, numArr, strArr, strArr2, str, str2, j3, j4)));
    }

    AggregatedAverage T(SupportSQLiteQuery supportSQLiteQuery);

    default List a(Collection typeIds, String[] strArr, String str, String str2, List list, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        return J(r(str, str2, j3, j4, (Integer[]) typeIds.toArray(new Integer[0]), strArr, list != null ? (String[]) list.toArray(new String[0]) : null));
    }

    default AggregatedRecordsWithAverage b(Integer[] numArr, String[] strArr, String[] strArr2, long j3, long j4) {
        List listA = A(o("DATE(timestamp, 'unixepoch', 'localtime')", numArr, strArr, strArr2, null, null, j3, j4));
        return new AggregatedRecordsWithAverage(WeeklyAverage.b(WeeklyAverage.f133864a, listA, j3, j4, null, 0L, 24, null), listA);
    }

    Object c(Collection collection, String str, List list, long j3, long j4, Continuation continuation);

    Flow d(Collection collection, List list, long j3, long j4);

    Object e(List list, long j3, long j4, Continuation continuation);

    Flow f();

    void g(int i3);

    LiveData h(List list, long j3, long j4);

    Object j(Collection collection, List list, String str, long j3, long j4, Continuation continuation);

    void k();

    Object l(int i3, Continuation continuation);

    Flow m(String str);

    Object n(Collection collection, List list, long j3, long j4, Continuation continuation);

    Object q(Collection collection, List list, long j3, long j4, Continuation continuation);

    default SimpleSQLiteQuery r(String str, String str2, long j3, long j4, Integer[] numArr, String[] strArr, String[] strArr2) {
        Long[] lArr;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT name, parentName, typeId, applicationAppType.appDistractionType as appDistractionType, \n            SUM(duration) AS duration, \n            SUM(isInitial) AS launchCount FROM record\n             LEFT JOIN applicationAppType ON record.name = applicationAppType.packageName ");
        sb.append("WHERE timestamp BETWEEN ?/1000 AND ?/1000  ");
        if (numArr == null && strArr2 == null && strArr == null) {
            sb.append(y());
            lArr = new Long[]{Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j4)};
        } else {
            if (numArr == null) {
                sb.append(y());
            }
            sb.append(I(numArr, strArr, strArr2));
            lArr = numArr == null ? new Long[]{Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j4)} : new Long[]{Long.valueOf(j3), Long.valueOf(j4)};
        }
        if (str2 != null) {
            sb.append("AND (category = '" + str2 + "' OR typeId = 1) ");
        }
        if (str != null) {
            sb.append("AND (applicationAppType.appDistractionType = '" + str + "'  OR typeId = 1) ");
        }
        sb.append("GROUP BY parentName, name \nORDER BY duration DESC");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new SimpleSQLiteQuery(string, lArr);
    }

    Object s(String str, String str2, Continuation continuation);

    List t(Collection collection, long j3, long j4, long j5, long j6, List list);

    Object u(Continuation continuation);

    Object v(Collection collection, List list, long j3, long j4, Continuation continuation);

    LiveData z(Collection collection, List list, long j3, long j4);
}
