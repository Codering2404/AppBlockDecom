package cz.mobilesoft.statistics.api;

import androidx.lifecycle.LiveData;
import cz.mobilesoft.statistics.di.Repository;
import cz.mobilesoft.statistics.model.AggregatedRecordsWithAverage;
import cz.mobilesoft.statistics.model.NotificationRecord;
import cz.mobilesoft.statistics.util.Transformer;
import cz.mobilesoft.statistics.util.WeeklyAverage;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class Statistics implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Statistics f133571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function1 f133572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f133573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f133574d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Statistics$ioScope$1 f133575f;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final Statistics statistics = new Statistics();
        f133571a = statistics;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f133573c = LazyKt.a(lazyThreadSafetyModeB, new Function0<Repository>() { // from class: cz.mobilesoft.statistics.api.Statistics$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = statistics;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(Repository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f133574d = LazyKt.a(lazyThreadSafetyModeB2, new Function0<Transformer>() { // from class: cz.mobilesoft.statistics.api.Statistics$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = statistics;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(Transformer.class), objArr2, objArr3);
            }
        });
        f133575f = new Statistics$ioScope$1();
    }

    private Statistics() {
    }

    public static final Object A(Collection collection, List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().z(collection, list, j3, j4, continuation);
    }

    public static final Object B(List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().A(list, j3, j4, continuation);
    }

    public static /* synthetic */ Object C(Collection collection, List list, long j3, long j4, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = null;
        }
        return A(collection, list, j3, j4, continuation);
    }

    public static final Object D(Collection collection, List list, String str, String str2, String str3, long j3, long j4, Continuation continuation) {
        return f133571a.O().B(collection, list, str, str2, str3, j3, j4, continuation);
    }

    public static final Object E(Collection collection, List list, long j3, long j4, long j5, long j6, Continuation continuation) {
        return f133571a.O().D(collection, list, j3, j4, j5, j6, continuation);
    }

    public static final Object F(List list, long j3, long j4, long j5, long j6, Continuation continuation) {
        return f133571a.O().E(list, j3, j4, j5, j6, continuation);
    }

    public static final Object G(Collection collection, List list, long j3, long j4, long j5, long j6, Continuation continuation) {
        return f133571a.O().F(collection, list, j3, j4, j5, j6, continuation);
    }

    public static final Object H(List list, long j3, long j4, long j5, long j6, Continuation continuation) {
        return f133571a.O().G(list, j3, j4, j5, j6, continuation);
    }

    public static final Object I(Collection collection, List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().H(collection, list, j3, j4, continuation);
    }

    public static final Object J(List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().I(list, j3, j4, continuation);
    }

    public static final Function1 L() {
        return f133572b;
    }

    public static final Object N(Continuation continuation) {
        return f133571a.O().L(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Repository O() {
        return (Repository) f133573c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Transformer P() {
        return (Transformer) f133574d.getValue();
    }

    public static final AggregatedRecordsWithAverage Q(Integer[] typeIds, String[] strArr, String str, String str2, String str3, long j3, long j4, boolean z2) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        if (!z2) {
            return f133571a.O().k("DATE(timestamp, 'unixepoch', 'localtime')", typeIds, str != null ? new String[]{str} : null, str2, str3, strArr, j3, j4);
        }
        List listJ = f133571a.O().j("DATE(timestamp, 'unixepoch', 'localtime')", typeIds, str != null ? new String[]{str} : null, str2, str3, strArr, j3, j4);
        return new AggregatedRecordsWithAverage(WeeklyAverage.b(WeeklyAverage.f133864a, listJ, j3, j4, null, 0L, 24, null), listJ);
    }

    public static final void S(Recordable recordable) {
        Intrinsics.checkNotNullParameter(recordable, "recordable");
        U(CollectionsKt.listOf(recordable), null, null, 6, null);
    }

    public static final void T(List recordables, Function0 function0, Function0 function02) {
        Intrinsics.checkNotNullParameter(recordables, "recordables");
        BuildersKt__Builders_commonKt.d(f133575f, null, null, new Statistics$saveRecords$1(recordables, function02, function0, null), 3, null);
    }

    public static /* synthetic */ void U(List list, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        if ((i3 & 4) != 0) {
            function02 = null;
        }
        T(list, function0, function02);
    }

    public static final void W(Function1 function1) {
        f133572b = function1;
    }

    public static final void c(Integer num) {
        BuildersKt__Builders_commonKt.d(f133575f, null, null, new Statistics$deleteDataByTypeId$1(num, null), 3, null);
    }

    public static /* synthetic */ void d(Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        c(num);
    }

    public static final LiveData e(Collection typeIds, List list, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        return f133571a.O().c(typeIds, list, j3, j4);
    }

    public static final LiveData f(List names, long j3, long j4) {
        Intrinsics.checkNotNullParameter(names, "names");
        return f133571a.O().d(names, j3, j4);
    }

    public static final Object g(Collection collection, String str, List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().e(collection, str, list, j3, j4, continuation);
    }

    public static final List i(Collection typeIds, String str, String str2, String[] strArr, List list, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        return f133571a.O().g(typeIds, str, str2, strArr, list, j3, j4);
    }

    public static final Object j(List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().h(list, j3, j4, continuation);
    }

    public static final Flow k(Collection typeIds, List list, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        return f133571a.O().i(typeIds, list, j3, j4);
    }

    public static final AggregatedRecordsWithAverage p(Integer[] typeIds, String[] strArr, String str, String str2, String str3, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        return f133571a.O().k("strftime('%H', timestamp, 'unixepoch', 'localtime')", typeIds, str != null ? new String[]{str} : null, str2, str3, strArr, j3, j4);
    }

    public static final Object q(Collection collection, List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().q(collection, list, j3, j4, continuation);
    }

    public static final Object r(List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().r(list, j3, j4, continuation);
    }

    public static final Object s(List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().s(list, j3, j4, continuation);
    }

    public static final Object t(Collection collection, List list, long j3, long j4, long j5, long j6, Continuation continuation) {
        return f133571a.O().t(collection, list, j3, j4, j5, j6, continuation);
    }

    public static final Object u(List list, long j3, long j4, long j5, long j6, Continuation continuation) {
        return f133571a.O().u(list, j3, j4, j5, j6, continuation);
    }

    public static final Object v(Collection collection, List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().v(collection, list, j3, j4, continuation);
    }

    public static /* synthetic */ Object w(Collection collection, List list, long j3, long j4, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = null;
        }
        return v(collection, list, j3, j4, continuation);
    }

    public static final Object x(List list, long j3, long j4, Continuation continuation) {
        return f133571a.O().w(list, j3, j4, continuation);
    }

    public static final Object y(Collection collection, List list, long j3, long j4, long j5, long j6, Continuation continuation) {
        return f133571a.O().x(collection, list, j3, j4, j5, j6, continuation);
    }

    public static final Object z(List list, long j3, long j4, long j5, long j6, Continuation continuation) {
        return f133571a.O().y(list, j3, j4, j5, j6, continuation);
    }

    public final Object K(Collection collection, List list, long j3, long j4, Continuation continuation) {
        return O().J(collection, list, j3, j4, continuation);
    }

    public final Double M(List ignoredNames, long j3, long j4) {
        Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
        return O().K(ignoredNames, j3, j4);
    }

    public final void R(String packageName, long j3) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        O().O(new NotificationRecord(0L, j3, packageName, 1, null));
    }

    public final Flow V(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return O().P(packageName);
    }

    public final Object X(List list, Continuation continuation) {
        Object objQ = O().Q(list, continuation);
        return objQ == IntrinsicsKt.f() ? objQ : Unit.f139807a;
    }

    public final void Y(String packageName, String appType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appType, "appType");
        O().R(packageName, appType);
    }

    public final Flow h(Collection typeIds, List list, long j3, long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        return O().f(typeIds, list, j3, j4);
    }

    public final List l(Collection typeIds, Pair start, Pair end, List ignoredNames) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
        return O().l(typeIds, start, end, ignoredNames);
    }

    public final Flow m() {
        return O().m();
    }

    public final Object n(int i3, Continuation continuation) {
        return O().n(i3, continuation);
    }

    public final Object o(Collection collection, List list, long j3, long j4, Continuation continuation) {
        return O().o(collection, list, j3, j4, continuation);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
