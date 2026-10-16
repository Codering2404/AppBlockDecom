package cz.mobilesoft.statistics.di;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabaseKt;
import cz.mobilesoft.statistics.model.AggregatedRecordsWithAverage;
import cz.mobilesoft.statistics.model.ApplicationAppType;
import cz.mobilesoft.statistics.model.NotificationRecord;
import cz.mobilesoft.statistics.model.datasource.StatisticsDatabase;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.flow.Flow;

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
public final class Repository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StatisticsDatabase f133604a;

    public Repository(StatisticsDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.f133604a = database;
    }

    private final Integer C(Double d3, Double d4) {
        if (Intrinsics.areEqual(d3, 0.0d)) {
            d3 = null;
        }
        if (d3 != null) {
            double dDoubleValue = d3.doubleValue();
            if (Intrinsics.areEqual(d4, 0.0d)) {
                d4 = null;
            }
            if (d4 != null) {
                return Integer.valueOf(MathKt.c((((double) 100) * dDoubleValue) / d4.doubleValue()) - 100);
            }
        }
        return null;
    }

    public final Object A(List list, long j3, long j4, Continuation continuation) {
        return this.f133604a.p().D(list, j3, j4, continuation);
    }

    public final Object B(Collection collection, List list, String str, String str2, String str3, long j3, long j4, Continuation continuation) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List list2 = list;
        return str != null ? this.f133604a.p().G(str, j3, j4, continuation) : str2 != null ? this.f133604a.p().j(collection, list2, str2, j3, j4, continuation) : str3 != null ? this.f133604a.p().H(collection, list2, str3, j3, j4, continuation) : this.f133604a.p().M(collection, list2, j3, j4, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c0, code lost:
    
        if (r1 == r8) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D(java.util.Collection r18, java.util.List r19, long r20, long r22, long r24, long r26, kotlin.coroutines.Continuation r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.di.Repository.D(java.util.Collection, java.util.List, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (r1 == r7) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object E(java.util.List r17, long r18, long r20, long r22, long r24, kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r16
            r1 = r26
            boolean r2 = r1 instanceof cz.mobilesoft.statistics.di.Repository$getIntervalsLaunchCountComparisonPercentage$2
            if (r2 == 0) goto L18
            r2 = r1
            cz.mobilesoft.statistics.di.Repository$getIntervalsLaunchCountComparisonPercentage$2 r2 = (cz.mobilesoft.statistics.di.Repository$getIntervalsLaunchCountComparisonPercentage$2) r2
            int r3 = r2.f133662j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.f133662j = r3
        L16:
            r6 = r2
            goto L1e
        L18:
            cz.mobilesoft.statistics.di.Repository$getIntervalsLaunchCountComparisonPercentage$2 r2 = new cz.mobilesoft.statistics.di.Repository$getIntervalsLaunchCountComparisonPercentage$2
            r2.<init>(r0, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r6.f133660h
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r6.f133662j
            r8 = 2
            r3 = 1
            if (r2 == 0) goto L56
            if (r2 == r3) goto L46
            if (r2 != r8) goto L3e
            java.lang.Object r2 = r6.f133655b
            java.lang.Double r2 = (java.lang.Double) r2
            java.lang.Object r3 = r6.f133654a
            java.util.List r3 = (java.util.List) r3
            kotlin.ResultKt.b(r1)
            r15 = r2
            r2 = r0
            r0 = r15
            goto Lab
        L3e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L46:
            long r2 = r6.f133659g
            long r4 = r6.f133658f
            long r9 = r6.f133657d
            long r11 = r6.f133656c
            java.lang.Object r13 = r6.f133654a
            java.util.List r13 = (java.util.List) r13
            kotlin.ResultKt.b(r1)
            goto L83
        L56:
            kotlin.ResultKt.b(r1)
            r1 = r17
            r6.f133654a = r1
            r4 = r18
            r6.f133656c = r4
            r9 = r20
            r6.f133657d = r9
            r11 = r22
            r6.f133658f = r11
            r13 = r24
            r6.f133659g = r13
            r6.f133662j = r3
            r2 = r4
            r4 = r9
            java.lang.Object r9 = r0.I(r1, r2, r4, r6)
            if (r9 != r7) goto L7a
            r2 = r16
            goto Laa
        L7a:
            r1 = r9
            r4 = r11
            r2 = r13
            r13 = r17
            r11 = r18
            r9 = r20
        L83:
            r0 = r1
            java.lang.Double r0 = (java.lang.Double) r0
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r6.f133654a = r1
            r6.f133655b = r0
            r6.f133656c = r11
            r6.f133657d = r9
            r6.f133658f = r4
            r6.f133659g = r2
            r6.f133662j = r8
            r17 = r16
            r21 = r2
            r19 = r4
            r23 = r6
            r18 = r13
            java.lang.Object r1 = r17.I(r18, r19, r21, r23)
            r2 = r17
            if (r1 != r7) goto Lab
        Laa:
            return r7
        Lab:
            java.lang.Double r1 = (java.lang.Double) r1
            java.lang.Integer r0 = r2.C(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.di.Repository.E(java.util.List, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c0, code lost:
    
        if (r1 == r8) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F(java.util.Collection r18, java.util.List r19, long r20, long r22, long r24, long r26, kotlin.coroutines.Continuation r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.di.Repository.F(java.util.Collection, java.util.List, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (r1 == r7) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object G(java.util.List r17, long r18, long r20, long r22, long r24, kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r16
            r1 = r26
            boolean r2 = r1 instanceof cz.mobilesoft.statistics.di.Repository$getIntervalsTotalComparisonPercentage$2
            if (r2 == 0) goto L18
            r2 = r1
            cz.mobilesoft.statistics.di.Repository$getIntervalsTotalComparisonPercentage$2 r2 = (cz.mobilesoft.statistics.di.Repository$getIntervalsTotalComparisonPercentage$2) r2
            int r3 = r2.f133681j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.f133681j = r3
        L16:
            r6 = r2
            goto L1e
        L18:
            cz.mobilesoft.statistics.di.Repository$getIntervalsTotalComparisonPercentage$2 r2 = new cz.mobilesoft.statistics.di.Repository$getIntervalsTotalComparisonPercentage$2
            r2.<init>(r0, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r6.f133679h
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r6.f133681j
            r8 = 2
            r3 = 1
            if (r2 == 0) goto L56
            if (r2 == r3) goto L46
            if (r2 != r8) goto L3e
            java.lang.Object r2 = r6.f133674b
            java.lang.Double r2 = (java.lang.Double) r2
            java.lang.Object r3 = r6.f133673a
            java.util.List r3 = (java.util.List) r3
            kotlin.ResultKt.b(r1)
            r15 = r2
            r2 = r0
            r0 = r15
            goto Lab
        L3e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L46:
            long r2 = r6.f133678g
            long r4 = r6.f133677f
            long r9 = r6.f133676d
            long r11 = r6.f133675c
            java.lang.Object r13 = r6.f133673a
            java.util.List r13 = (java.util.List) r13
            kotlin.ResultKt.b(r1)
            goto L83
        L56:
            kotlin.ResultKt.b(r1)
            r1 = r17
            r6.f133673a = r1
            r4 = r18
            r6.f133675c = r4
            r9 = r20
            r6.f133676d = r9
            r11 = r22
            r6.f133677f = r11
            r13 = r24
            r6.f133678g = r13
            r6.f133681j = r3
            r2 = r4
            r4 = r9
            java.lang.Object r9 = r0.A(r1, r2, r4, r6)
            if (r9 != r7) goto L7a
            r2 = r16
            goto Laa
        L7a:
            r1 = r9
            r4 = r11
            r2 = r13
            r13 = r17
            r11 = r18
            r9 = r20
        L83:
            r0 = r1
            java.lang.Double r0 = (java.lang.Double) r0
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r6.f133673a = r1
            r6.f133674b = r0
            r6.f133675c = r11
            r6.f133676d = r9
            r6.f133677f = r4
            r6.f133678g = r2
            r6.f133681j = r8
            r17 = r16
            r21 = r2
            r19 = r4
            r23 = r6
            r18 = r13
            java.lang.Object r1 = r17.A(r18, r19, r21, r23)
            r2 = r17
            if (r1 != r7) goto Lab
        Laa:
            return r7
        Lab:
            java.lang.Double r1 = (java.lang.Double) r1
            java.lang.Integer r0 = r2.C(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.di.Repository.G(java.util.List, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object H(Collection collection, List list, long j3, long j4, Continuation continuation) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return this.f133604a.p().v(collection, list, j3, j4, continuation);
    }

    public final Object I(List list, long j3, long j4, Continuation continuation) {
        return this.f133604a.p().E(list, j3, j4, continuation);
    }

    public final Object J(Collection collection, List list, long j3, long j4, Continuation continuation) {
        return this.f133604a.p().q(collection, list, j3, j4, continuation);
    }

    public final Double K(List ignoredNames, long j3, long j4) {
        Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
        return this.f133604a.o().x(ignoredNames, j3, j4);
    }

    public final Object L(Continuation continuation) {
        return this.f133604a.p().u(continuation);
    }

    public final AggregatedRecordsWithAverage M(Integer[] numArr, String[] strArr, String[] strArr2, long j3, long j4) {
        return this.f133604a.p().b(numArr, strArr, strArr2, j3, j4);
    }

    public final void N(List records) {
        Intrinsics.checkNotNullParameter(records, "records");
        this.f133604a.p().F(records);
    }

    public final void O(NotificationRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        this.f133604a.o().w(record);
    }

    public final Flow P(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return this.f133604a.p().m(packageName);
    }

    public final Object Q(List list, Continuation continuation) {
        Object objG = RoomDatabaseKt.g(this.f133604a, new Repository$updateApplicationsToInsights$2(list, this, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public final void R(String packageName, String appType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appType, "appType");
        this.f133604a.n().i(new ApplicationAppType(packageName, appType));
    }

    public final void b(Integer num) {
        if (num == null) {
            this.f133604a.p().k();
        } else {
            this.f133604a.p().g(num.intValue());
        }
    }

    public final LiveData c(Collection typeIds, List list, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return this.f133604a.p().z(typeIds, list, j3, j4);
    }

    public final LiveData d(List names, long j3, long j4) {
        Intrinsics.checkNotNullParameter(names, "names");
        return this.f133604a.p().h(names, j3, j4);
    }

    public final Object e(Collection collection, String str, List list, long j3, long j4, Continuation continuation) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List list2 = list;
        return str != null ? this.f133604a.p().c(collection, str, list2, j3, j4, continuation) : this.f133604a.p().n(collection, list2, j3, j4, continuation);
    }

    public final Flow f(Collection typeIds, List list, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return this.f133604a.p().d(typeIds, list, j3, j4);
    }

    public final List g(Collection typeIds, String str, String str2, String[] strArr, List list, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        return this.f133604a.p().a(typeIds, strArr, str, str2, list, j3, j4);
    }

    public final Object h(List list, long j3, long j4, Continuation continuation) {
        return this.f133604a.p().C(list, j3, j4, continuation);
    }

    public final Flow i(Collection typeIds, List list, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return this.f133604a.p().K(typeIds, list, j3, j4);
    }

    public final List j(String dateFormat, Integer[] numArr, String[] strArr, String str, String str2, String[] strArr2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(dateFormat, "dateFormat");
        return this.f133604a.p().R(dateFormat, numArr, strArr, strArr2, str, str2, j3, j4);
    }

    public final AggregatedRecordsWithAverage k(String dateFormat, Integer[] numArr, String[] strArr, String str, String str2, String[] strArr2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(dateFormat, "dateFormat");
        return this.f133604a.p().S(dateFormat, numArr, strArr, strArr2, str, str2, j3, j4);
    }

    public final List l(Collection typeIds, Pair start, Pair end, List ignoredNames) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
        return this.f133604a.p().t(typeIds, ((Number) start.e()).longValue(), ((Number) start.f()).longValue(), ((Number) end.e()).longValue(), ((Number) end.f()).longValue(), ignoredNames);
    }

    public final Flow m() {
        return this.f133604a.p().f();
    }

    public final Object n(int i3, Continuation continuation) {
        return this.f133604a.p().l(i3, continuation);
    }

    public final Object o(Collection collection, List list, long j3, long j4, Continuation continuation) {
        return this.f133604a.p().B(collection, list, j3, j4, continuation);
    }

    public final AggregatedRecordsWithAverage p(Integer[] numArr, String[] strArr, String[] strArr2, long j3, long j4) {
        return this.f133604a.p().P(numArr, strArr, strArr2, j3, j4);
    }

    public final Object q(Collection collection, List list, long j3, long j4, Continuation continuation) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return this.f133604a.p().Q(collection, list, j3, j4, continuation);
    }

    public final Object r(List list, long j3, long j4, Continuation continuation) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return this.f133604a.p().e(list, j3, j4, continuation);
    }

    public final Object s(List list, long j3, long j4, Continuation continuation) {
        return this.f133604a.p().N(list, j3, j4, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00de, code lost:
    
        if (r1 == r8) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(java.util.Collection r18, java.util.List r19, long r20, long r22, long r24, long r26, kotlin.coroutines.Continuation r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.di.Repository.t(java.util.Collection, java.util.List, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (r1 == r7) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(java.util.List r17, long r18, long r20, long r22, long r24, kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r16
            r1 = r26
            boolean r2 = r1 instanceof cz.mobilesoft.statistics.di.Repository$getDailyAverageComparisonPercentage$2
            if (r2 == 0) goto L18
            r2 = r1
            cz.mobilesoft.statistics.di.Repository$getDailyAverageComparisonPercentage$2 r2 = (cz.mobilesoft.statistics.di.Repository$getDailyAverageComparisonPercentage$2) r2
            int r3 = r2.f133624j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.f133624j = r3
        L16:
            r6 = r2
            goto L1e
        L18:
            cz.mobilesoft.statistics.di.Repository$getDailyAverageComparisonPercentage$2 r2 = new cz.mobilesoft.statistics.di.Repository$getDailyAverageComparisonPercentage$2
            r2.<init>(r0, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r6.f133622h
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r6.f133624j
            r8 = 2
            r3 = 1
            if (r2 == 0) goto L56
            if (r2 == r3) goto L46
            if (r2 != r8) goto L3e
            java.lang.Object r2 = r6.f133617b
            java.lang.Double r2 = (java.lang.Double) r2
            java.lang.Object r3 = r6.f133616a
            java.util.List r3 = (java.util.List) r3
            kotlin.ResultKt.b(r1)
            r15 = r2
            r2 = r0
            r0 = r15
            goto Lab
        L3e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L46:
            long r2 = r6.f133621g
            long r4 = r6.f133620f
            long r9 = r6.f133619d
            long r11 = r6.f133618c
            java.lang.Object r13 = r6.f133616a
            java.util.List r13 = (java.util.List) r13
            kotlin.ResultKt.b(r1)
            goto L83
        L56:
            kotlin.ResultKt.b(r1)
            r1 = r17
            r6.f133616a = r1
            r4 = r18
            r6.f133618c = r4
            r9 = r20
            r6.f133619d = r9
            r11 = r22
            r6.f133620f = r11
            r13 = r24
            r6.f133621g = r13
            r6.f133624j = r3
            r2 = r4
            r4 = r9
            java.lang.Object r9 = r0.s(r1, r2, r4, r6)
            if (r9 != r7) goto L7a
            r2 = r16
            goto Laa
        L7a:
            r1 = r9
            r4 = r11
            r2 = r13
            r13 = r17
            r11 = r18
            r9 = r20
        L83:
            r0 = r1
            java.lang.Double r0 = (java.lang.Double) r0
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r6.f133616a = r1
            r6.f133617b = r0
            r6.f133618c = r11
            r6.f133619d = r9
            r6.f133620f = r4
            r6.f133621g = r2
            r6.f133624j = r8
            r17 = r16
            r21 = r2
            r19 = r4
            r23 = r6
            r18 = r13
            java.lang.Object r1 = r17.s(r18, r19, r21, r23)
            r2 = r17
            if (r1 != r7) goto Lab
        Laa:
            return r7
        Lab:
            java.lang.Double r1 = (java.lang.Double) r1
            java.lang.Integer r0 = r2.C(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.di.Repository.u(java.util.List, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object v(Collection collection, List list, long j3, long j4, Continuation continuation) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return this.f133604a.p().L(collection, list, j3, j4, continuation);
    }

    public final Object w(List list, long j3, long j4, Continuation continuation) {
        return this.f133604a.p().O(list, j3, j4, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c0, code lost:
    
        if (r1 == r8) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x(java.util.Collection r18, java.util.List r19, long r20, long r22, long r24, long r26, kotlin.coroutines.Continuation r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.di.Repository.x(java.util.Collection, java.util.List, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (r1 == r7) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(java.util.List r17, long r18, long r20, long r22, long r24, kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r16
            r1 = r26
            boolean r2 = r1 instanceof cz.mobilesoft.statistics.di.Repository$getDailyAverageLaunchCountComparisonPercentage$2
            if (r2 == 0) goto L18
            r2 = r1
            cz.mobilesoft.statistics.di.Repository$getDailyAverageLaunchCountComparisonPercentage$2 r2 = (cz.mobilesoft.statistics.di.Repository$getDailyAverageLaunchCountComparisonPercentage$2) r2
            int r3 = r2.f133643j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.f133643j = r3
        L16:
            r6 = r2
            goto L1e
        L18:
            cz.mobilesoft.statistics.di.Repository$getDailyAverageLaunchCountComparisonPercentage$2 r2 = new cz.mobilesoft.statistics.di.Repository$getDailyAverageLaunchCountComparisonPercentage$2
            r2.<init>(r0, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r6.f133641h
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r6.f133643j
            r8 = 2
            r3 = 1
            if (r2 == 0) goto L56
            if (r2 == r3) goto L46
            if (r2 != r8) goto L3e
            java.lang.Object r2 = r6.f133636b
            java.lang.Double r2 = (java.lang.Double) r2
            java.lang.Object r3 = r6.f133635a
            java.util.List r3 = (java.util.List) r3
            kotlin.ResultKt.b(r1)
            r15 = r2
            r2 = r0
            r0 = r15
            goto Lab
        L3e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L46:
            long r2 = r6.f133640g
            long r4 = r6.f133639f
            long r9 = r6.f133638d
            long r11 = r6.f133637c
            java.lang.Object r13 = r6.f133635a
            java.util.List r13 = (java.util.List) r13
            kotlin.ResultKt.b(r1)
            goto L83
        L56:
            kotlin.ResultKt.b(r1)
            r1 = r17
            r6.f133635a = r1
            r4 = r18
            r6.f133637c = r4
            r9 = r20
            r6.f133638d = r9
            r11 = r22
            r6.f133639f = r11
            r13 = r24
            r6.f133640g = r13
            r6.f133643j = r3
            r2 = r4
            r4 = r9
            java.lang.Object r9 = r0.w(r1, r2, r4, r6)
            if (r9 != r7) goto L7a
            r2 = r16
            goto Laa
        L7a:
            r1 = r9
            r4 = r11
            r2 = r13
            r13 = r17
            r11 = r18
            r9 = r20
        L83:
            r0 = r1
            java.lang.Double r0 = (java.lang.Double) r0
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r6.f133635a = r1
            r6.f133636b = r0
            r6.f133637c = r11
            r6.f133638d = r9
            r6.f133639f = r4
            r6.f133640g = r2
            r6.f133643j = r8
            r17 = r16
            r21 = r2
            r19 = r4
            r23 = r6
            r18 = r13
            java.lang.Object r1 = r17.w(r18, r19, r21, r23)
            r2 = r17
            if (r1 != r7) goto Lab
        Laa:
            return r7
        Lab:
            java.lang.Double r1 = (java.lang.Double) r1
            java.lang.Integer r0 = r2.C(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.di.Repository.y(java.util.List, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object z(Collection collection, List list, long j3, long j4, Continuation continuation) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return this.f133604a.p().M(collection, list, j3, j4, continuation);
    }
}
