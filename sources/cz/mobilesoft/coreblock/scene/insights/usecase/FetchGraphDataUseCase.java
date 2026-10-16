package cz.mobilesoft.coreblock.scene.insights.usecase;

import android.content.Context;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import cz.mobilesoft.statistics.model.AggregatedRecord;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public final class FetchGraphDataUseCase extends SuspendUseCase<Params, GraphResult> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f103718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Locale f103719b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f103732a;

        static {
            int[] iArr = new int[InsightsViewState.InsightsPeriodType.values().length];
            try {
                iArr[InsightsViewState.InsightsPeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Trend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f103732a = iArr;
        }
    }

    public FetchGraphDataUseCase(Context context) {
        Locale locale;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f103718a = context;
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), "ar")) {
            locale = Locale.US;
            str = "US";
        } else {
            locale = Locale.getDefault();
            str = "getDefault(...)";
        }
        Intrinsics.checkNotNullExpressionValue(locale, str);
        this.f103719b = locale;
    }

    private final List c(long j3, TreeMap treeMap, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2, int i3) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(j3);
        ArrayList arrayList = new ArrayList(treeMap.size());
        for (Map.Entry entry : treeMap.entrySet()) {
            String str = simpleDateFormat.format(calendar.getTime());
            String str2 = simpleDateFormat2.format(calendar.getTime());
            long timeInMillis = calendar.getTimeInMillis();
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNull(str2);
            Iterable<AggregatedRecord> iterable = (Iterable) entry.getValue();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (AggregatedRecord aggregatedRecord : iterable) {
                AppDistractionType appDistractionTypeA = AppDistractionType.Companion.a(aggregatedRecord.a());
                if (appDistractionTypeA == null) {
                    appDistractionTypeA = AppDistractionType.Neutral;
                }
                Pair pairA = TuplesKt.a(appDistractionTypeA, Integer.valueOf(aggregatedRecord.d()));
                linkedHashMap.put(pairA.e(), pairA.f());
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                arrayList2.add(new GraphData.GraphValueData.GraphValueSection(((Number) entry2.getValue()).floatValue() / 60.0f, (AppDistractionType) entry2.getKey()));
            }
            GraphData.GraphValueData graphValueData = new GraphData.GraphValueData(timeInMillis, str, str2, CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase$createBarChartData$lambda$1$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt.d(Integer.valueOf(((GraphData.GraphValueData.GraphValueSection) obj).a().ordinal()), Integer.valueOf(((GraphData.GraphValueData.GraphValueSection) obj2).a().ordinal()));
                }
            }));
            calendar.add(i3, 1);
            arrayList.add(graphValueData);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase.Params r25, kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase.d(cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase.Params r26, int r27, java.lang.String r28, boolean r29, kotlin.coroutines.Continuation r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase.e(cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase$Params, int, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object f(FetchGraphDataUseCase fetchGraphDataUseCase, Params params, int i3, String str, boolean z2, Continuation continuation, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 3;
        }
        int i5 = i3;
        if ((i4 & 4) != 0) {
            str = "EE";
        }
        String str2 = str;
        if ((i4 & 8) != 0) {
            z2 = false;
        }
        return fetchGraphDataUseCase.e(params, i5, str2, z2, continuation);
    }

    private final Object g(Params params, Continuation continuation) {
        return e(params, 4, "MMM", true, continuation);
    }

    private final Object h(Params params, Continuation continuation) {
        return f(this, params, 0, null, false, continuation, 14, null);
    }

    private final TreeMap i(long j3, long j4) {
        TreeMap treeMap = new TreeMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", this.f103719b);
        Calendar calendar = Calendar.getInstance(this.f103719b);
        calendar.setTimeInMillis(j3);
        while (calendar.getTimeInMillis() < j4) {
            treeMap.put(simpleDateFormat.format(calendar.getTime()), new ArrayList());
            calendar.add(11, 1);
        }
        return treeMap;
    }

    private final TreeMap j(long j3, long j4) {
        TreeMap treeMap = new TreeMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", this.f103719b);
        Calendar calendar = Calendar.getInstance(this.f103719b);
        calendar.setTimeInMillis(j3);
        while (calendar.getTimeInMillis() < j4) {
            treeMap.put(simpleDateFormat.format(calendar.getTime()), new ArrayList());
            calendar.add(6, 1);
        }
        return treeMap;
    }

    public Object k(Params params, Continuation continuation) {
        int i3 = WhenMappings.f103732a[params.d().ordinal()];
        if (i3 == 1) {
            return d(params, continuation);
        }
        if (i3 == 2) {
            return h(params, continuation);
        }
        if (i3 == 3) {
            return g(params, continuation);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GraphResult {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f103720d = GraphData.f132767h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Float f103721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Float f103722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final GraphData f103723c;

        public GraphResult(Float f3, Float f4, GraphData graphData) {
            Intrinsics.checkNotNullParameter(graphData, "graphData");
            this.f103721a = f3;
            this.f103722b = f4;
            this.f103723c = graphData;
        }

        public final Float a() {
            return this.f103721a;
        }

        public final GraphData b() {
            return this.f103723c;
        }

        public final Float c() {
            return this.f103722b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GraphResult)) {
                return false;
            }
            GraphResult graphResult = (GraphResult) obj;
            return Intrinsics.areEqual((Object) this.f103721a, (Object) graphResult.f103721a) && Intrinsics.areEqual((Object) this.f103722b, (Object) graphResult.f103722b) && Intrinsics.areEqual(this.f103723c, graphResult.f103723c);
        }

        public int hashCode() {
            Float f3 = this.f103721a;
            int iHashCode = (f3 == null ? 0 : f3.hashCode()) * 31;
            Float f4 = this.f103722b;
            return ((iHashCode + (f4 != null ? f4.hashCode() : 0)) * 31) + this.f103723c.hashCode();
        }

        public String toString() {
            return "GraphResult(averageScreenTime=" + this.f103721a + ", totalScreenTime=" + this.f103722b + ", graphData=" + this.f103723c + ")";
        }

        public /* synthetic */ GraphResult(Float f3, Float f4, GraphData graphData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : f3, (i3 & 2) != 0 ? null : f4, graphData);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InsightsViewState.InsightsPeriodType f103724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Category f103725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AppDistractionType f103726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f103727d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f103728e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List f103729f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f103730g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f103731h;

        public Params(InsightsViewState.InsightsPeriodType insightsPeriodType, Category category, AppDistractionType appDistractionType, long j3, long j4, List ignoredNames, String str, boolean z2) {
            Intrinsics.checkNotNullParameter(insightsPeriodType, "insightsPeriodType");
            Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
            this.f103724a = insightsPeriodType;
            this.f103725b = category;
            this.f103726c = appDistractionType;
            this.f103727d = j3;
            this.f103728e = j4;
            this.f103729f = ignoredNames;
            this.f103730g = str;
            this.f103731h = z2;
        }

        public final boolean a() {
            return this.f103731h;
        }

        public final long b() {
            return this.f103728e;
        }

        public final List c() {
            return this.f103729f;
        }

        public final InsightsViewState.InsightsPeriodType d() {
            return this.f103724a;
        }

        public final String e() {
            return this.f103730g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f103724a == params.f103724a && this.f103725b == params.f103725b && this.f103726c == params.f103726c && this.f103727d == params.f103727d && this.f103728e == params.f103728e && Intrinsics.areEqual(this.f103729f, params.f103729f) && Intrinsics.areEqual(this.f103730g, params.f103730g) && this.f103731h == params.f103731h;
        }

        public final AppDistractionType f() {
            return this.f103726c;
        }

        public final Category g() {
            return this.f103725b;
        }

        public final long h() {
            return this.f103727d;
        }

        public int hashCode() {
            int iHashCode = this.f103724a.hashCode() * 31;
            Category category = this.f103725b;
            int iHashCode2 = (iHashCode + (category == null ? 0 : category.hashCode())) * 31;
            AppDistractionType appDistractionType = this.f103726c;
            int iHashCode3 = (((((((iHashCode2 + (appDistractionType == null ? 0 : appDistractionType.hashCode())) * 31) + Long.hashCode(this.f103727d)) * 31) + Long.hashCode(this.f103728e)) * 31) + this.f103729f.hashCode()) * 31;
            String str = this.f103730g;
            return ((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.f103731h);
        }

        public String toString() {
            return "Params(insightsPeriodType=" + this.f103724a + ", selectedCategory=" + this.f103725b + ", selectedAppDistractionType=" + this.f103726c + ", start=" + this.f103727d + ", end=" + this.f103728e + ", ignoredNames=" + this.f103729f + ", packageName=" + this.f103730g + ", capMaxValueAtHour=" + this.f103731h + ")";
        }

        public /* synthetic */ Params(InsightsViewState.InsightsPeriodType insightsPeriodType, Category category, AppDistractionType appDistractionType, long j3, long j4, List list, String str, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(insightsPeriodType, category, appDistractionType, j3, j4, list, str, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z2);
        }
    }
}
