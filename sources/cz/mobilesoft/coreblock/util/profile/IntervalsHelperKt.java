package cz.mobilesoft.coreblock.util.profile;

import android.content.Context;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class IntervalsHelperKt {
    public static final Interval b(List list, long j3, boolean z2) {
        Object next = null;
        if (list == null) {
            return null;
        }
        List listN = n(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            if (i((Interval) obj, j3)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long jH = h((Interval) next, j3, z2);
                do {
                    Object next2 = it.next();
                    long jH2 = h((Interval) next2, j3, z2);
                    if (jH < jH2) {
                        next = next2;
                        jH = jH2;
                    }
                } while (it.hasNext());
            }
        }
        return (Interval) next;
    }

    public static final long c(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        long jA = 0;
        for (IntervalDTO intervalDTO : configuration.g()) {
            jA += intervalDTO.a() - intervalDTO.b();
        }
        return TimeUnit.MINUTES.toHours(jA);
    }

    public static final String d(List list, final Context context) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (list.size() > 2) {
            String quantityString = context.getResources().getQuantityString(R.plurals.f95756q, list.size(), Integer.valueOf(list.size()));
            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
            return quantityString;
        }
        if (list.size() != 1 || ((IntervalHolder) CollectionsKt.first(list)).b() != 0 || (((IntervalHolder) CollectionsKt.first(list)).a() != 1440 && ((IntervalHolder) CollectionsKt.first(list)).a() != 1439)) {
            return CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.util.profile.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IntervalsHelperKt.e(context, (IntervalHolder) obj);
                }
            }, 30, null);
        }
        String string = context.getString(R.string.f95827o0);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(Context context, IntervalHolder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return IntervalsHelper.f129240a.b(context, it.b(), it.a());
    }

    public static final Long f(List list, long j3, boolean z2) {
        Interval intervalB = b(list, j3, z2);
        if (intervalB != null) {
            if (k(intervalB)) {
                intervalB = null;
            }
            if (intervalB != null) {
                return Long.valueOf(DateHelper.h().getTimeInMillis() + TimeUnit.MINUTES.toMillis(h(intervalB, j3, z2)));
            }
        }
        return null;
    }

    public static final String g(Interval interval, Context context, long j3, boolean z2) {
        Intrinsics.checkNotNullParameter(interval, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        long j4 = 1439;
        if (interval.b() == 0 && (interval.a() == 1440 || interval.a() == 1439)) {
            String string = context.getString(R.string.A);
            Intrinsics.checkNotNull(string);
            return string;
        }
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        long jH = h(interval, j3, z2);
        if (jH != 1440) {
            long j5 = jH % 1440;
            j4 = ((((j5 ^ 1440) & ((-j5) | j5)) >> 63) & 1440) + j5;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeFormat.getTimeZone());
        long j6 = 60;
        calendar.set(0, 0, 0, (int) (j4 / j6), (int) (j4 % j6));
        String string2 = context.getString(R.string.J, timeFormat.format(calendar.getTime()));
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    public static final long h(Interval interval, long j3, boolean z2) {
        Intrinsics.checkNotNullParameter(interval, "<this>");
        if (!m(interval) || j(interval, j3)) {
            return interval.a();
        }
        if (z2) {
            return interval.a() + 1440;
        }
        return 1440L;
    }

    public static final boolean i(Interval interval, long j3) {
        Intrinsics.checkNotNullParameter(interval, "<this>");
        if (k(interval)) {
            return true;
        }
        return interval.b() == interval.a() ? interval.b() == j3 : m(interval) ? interval.b() <= j3 || interval.a() > j3 : interval.b() <= j3 && interval.a() > j3;
    }

    private static final boolean j(Interval interval, long j3) {
        return m(interval) && j3 < interval.a();
    }

    public static final boolean k(IntervalHolder intervalHolder) {
        Intrinsics.checkNotNullParameter(intervalHolder, "<this>");
        return l(TuplesKt.a(Long.valueOf(intervalHolder.b()), Long.valueOf(intervalHolder.a())));
    }

    public static final boolean l(Pair pair) {
        Long l3;
        Intrinsics.checkNotNullParameter(pair, "<this>");
        if (pair.e() != null && pair.f() != null && (l3 = (Long) pair.e()) != null && l3.longValue() == 0) {
            Long l4 = (Long) pair.f();
            if (l4 != null && l4.longValue() == 1440) {
                return true;
            }
            Long l5 = (Long) pair.f();
            if (l5 != null && l5.longValue() == 1439) {
                return true;
            }
        }
        return false;
    }

    public static final boolean m(IntervalHolder intervalHolder) {
        Intrinsics.checkNotNullParameter(intervalHolder, "<this>");
        return ((intervalHolder.a() > 0L ? 1 : (intervalHolder.a() == 0L ? 0 : -1)) == 0 ? 1439L : intervalHolder.a()) < intervalHolder.b();
    }

    public static final List n(List list) {
        Interval intervalD;
        Object next;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((Interval) obj).f() == null) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list2 = (List) pair.a();
        List<Interval> list3 = (List) pair.b();
        List mutableList = CollectionsKt.toMutableList((Collection) list2);
        ArrayList arrayList3 = new ArrayList();
        for (Interval interval : list3) {
            Iterator it = mutableList.iterator();
            while (true) {
                intervalD = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                long jE = ((Interval) next).e();
                Long lF = interval.f();
                if (lF != null && jE == lF.longValue()) {
                    break;
                }
            }
            Interval interval2 = (Interval) next;
            if (interval2 != null) {
                mutableList.remove(interval2);
                intervalD = Interval.d(interval, 0L, 0L, interval2.b(), 0L, null, false, false, 123, null);
            }
            if (intervalD != null) {
                arrayList3.add(intervalD);
            }
        }
        mutableList.addAll(arrayList3);
        return mutableList;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object o(cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r21, cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r22, kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.IntervalsHelperKt.o(cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval, cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final List p(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            IntervalDTO intervalDTO = (IntervalDTO) it.next();
            float fB = intervalDTO.b() / 1440.0f;
            float fA = (intervalDTO.a() >= 1439 ? 1440L : intervalDTO.a()) / 1440.0f;
            if (intervalDTO.b() <= intervalDTO.a()) {
                arrayList.add(TuplesKt.a(Float.valueOf(fB), Float.valueOf(fA)));
            } else {
                arrayList.add(TuplesKt.a(Float.valueOf(fB), Float.valueOf(1.0f)));
                arrayList.add(TuplesKt.a(Float.valueOf(0.0f), Float.valueOf(fA)));
            }
        }
        return arrayList;
    }
}
