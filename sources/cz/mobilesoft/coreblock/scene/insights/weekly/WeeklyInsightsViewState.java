package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.storage.room.entity.core.AggregatedPauseHistory;
import cz.mobilesoft.coreblock.util.PackageManagerHelperKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import cz.mobilesoft.statistics.model.RecordDuration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class WeeklyInsightsViewState implements ViewState {
    public static final Companion A = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f104012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f104013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f104014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f104015d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Long f104016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Long f104017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Float f104018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final GraphData f104019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final GraphData f104020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final InsightsViewState.InsightsInterval f104021k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f104022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f104023m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f104024n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ImmutableList f104025o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f104026p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f104027q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final RecordDuration f104028r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AggregatedPauseHistory f104029s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f104030t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f104031u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f104032v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final boolean f104033w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final boolean f104034x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List f104035y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f104036z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GraphData a(Context context) {
            float fH;
            float f3;
            float fH2;
            Calendar calendar;
            Intrinsics.checkNotNullParameter(context, "context");
            Calendar calendar2 = Calendar.getInstance();
            int i3 = 12;
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            int i4 = 14;
            calendar2.set(14, 0);
            int i5 = 0;
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            float f4 = 0.0f;
            float f5 = 0.0f;
            while (i6 < 24) {
                calendar2.set(11, i6);
                long timeInMillis = calendar2.getTimeInMillis();
                float f6 = 1.0f;
                if (i6 < 0 || i6 >= 6) {
                    if (6 <= i6 && i6 < 9) {
                        fH = Random.f140182a.h();
                        f3 = 0.8f;
                    } else if (9 <= i6 && i6 < i3) {
                        fH2 = Random.f140182a.h() * 1.0f;
                    } else if (i3 <= i6 && i6 < i4) {
                        fH = Random.f140182a.h();
                        f3 = 0.7f;
                    } else if (i4 <= i6 && i6 < 18) {
                        fH = Random.f140182a.h();
                        f3 = 1.2f;
                    } else if (18 > i6 || i6 >= 22) {
                        fH = Random.f140182a.h();
                        f3 = 0.9f;
                    } else {
                        fH = Random.f140182a.h();
                        f3 = 1.5f;
                    }
                    fH2 = fH * f3;
                } else {
                    fH2 = 0.0f;
                }
                ArrayList arrayList2 = new ArrayList();
                int iK = Random.f140182a.k(1, 4);
                int i7 = i5;
                float fB = 0.0f;
                while (true) {
                    if (i7 >= iK) {
                        calendar = calendar2;
                        break;
                    }
                    Random.Default r5 = Random.f140182a;
                    float f7 = f6;
                    float fK = r5.k(5, 45) * fH2;
                    float f8 = fB + fK;
                    if (f8 <= 55.0f) {
                        arrayList2.add(new GraphData.GraphValueData.GraphValueSection(RangesKt.e(fK, 0.0f), (AppDistractionType) CollectionsKt.random(AppDistractionType.getEntries(), r5)));
                        i7++;
                        fB = f8;
                        f6 = f7;
                        calendar2 = calendar2;
                    } else {
                        calendar = calendar2;
                        float fE = RangesKt.e(55.0f - fB, 0.0f);
                        if (fE > f7) {
                            arrayList2.add(new GraphData.GraphValueData.GraphValueSection(fE, (AppDistractionType) CollectionsKt.random(AppDistractionType.getEntries(), r5)));
                            fB += fE;
                        }
                    }
                }
                if (arrayList2.isEmpty()) {
                    arrayList2.add(new GraphData.GraphValueData.GraphValueSection(RangesKt.e(Random.f140182a.h() * 5.0f * fH2, 0.0f), AppDistractionType.Neutral));
                    fB = ((GraphData.GraphValueData.GraphValueSection) CollectionsKt.first((List) arrayList2)).b();
                }
                float f9 = fB;
                arrayList.add(new GraphData.GraphValueData(timeInMillis, String.valueOf(i6), String.valueOf(i6), arrayList2));
                f4 += f9;
                if (f9 > f5) {
                    f5 = f9;
                }
                i6++;
                calendar2 = calendar;
                i3 = 12;
                i4 = 14;
                i5 = 0;
            }
            return new GraphData(context, arrayList, null, Float.valueOf(!arrayList.isEmpty() ? f4 / arrayList.size() : 0.0f), 8, 0.0f, RangesKt.j(RangesKt.e(f5 * 1.1f, 60.0f), 60.0f), 36, null);
        }

        public final WeeklyInsightsViewState b(Context context) {
            Float fValueOf;
            Intrinsics.checkNotNullParameter(context, "context");
            Calendar calendar = Calendar.getInstance();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 7; i3++) {
                calendar.set(7, calendar.getFirstDayOfWeek() + i3);
                long timeInMillis = calendar.getTimeInMillis();
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format("%ta", Arrays.copyOf(new Object[]{calendar}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                String str2 = String.format("%tA", Arrays.copyOf(new Object[]{calendar}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                IntRange intRange = new IntRange(30, SensibleDefaults.X_OFFSET);
                Random.Default r8 = Random.f140182a;
                GraphData.GraphValueData.GraphValueSection graphValueSection = new GraphData.GraphValueData.GraphValueSection(RangesKt.w(intRange, r8), (AppDistractionType) CollectionsKt.random(AppDistractionType.getEntries(), r8));
                float fW = RangesKt.w(new IntRange(10, 60), r8);
                EnumEntries<AppDistractionType> entries = AppDistractionType.getEntries();
                ArrayList arrayList2 = new ArrayList();
                for (AppDistractionType appDistractionType : entries) {
                    if (appDistractionType != AppDistractionType.Neutral) {
                        arrayList2.add(appDistractionType);
                    }
                }
                arrayList.add(new GraphData.GraphValueData(timeInMillis, str, str2, CollectionsKt.listOf((Object[]) new GraphData.GraphValueData.GraphValueSection[]{graphValueSection, new GraphData.GraphValueData.GraphValueSection(fW, (AppDistractionType) CollectionsKt.random(arrayList2, Random.f140182a))})));
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                float fE = ((GraphData.GraphValueData) it.next()).e();
                while (it.hasNext()) {
                    fE = Math.max(fE, ((GraphData.GraphValueData) it.next()).e());
                }
                fValueOf = Float.valueOf(fE);
            } else {
                fValueOf = null;
            }
            GraphData graphData = new GraphData(context, arrayList, null, Float.valueOf(120.0f), 3, 0.0f, fValueOf != null ? fValueOf.floatValue() : 240.0f, 36, null);
            GraphData graphDataA = a(context);
            long jCurrentTimeMillis = System.currentTimeMillis();
            InsightsViewState.InsightsInterval insightsInterval = new InsightsViewState.InsightsInterval(jCurrentTimeMillis - TimeUnit.DAYS.toMillis(7L), jCurrentTimeMillis, "Last 7 Days (Mock)");
            Random.Default r02 = Random.f140182a;
            List listListOf = CollectionsKt.listOf((Object[]) new AggregatedItemRecord[]{new AggregatedItemRecord(19800, "Social App X (Mock)", "com.example.socialappx", Integer.valueOf(r02.k(50, 200)), 1, "Distractive", "Social"), new AggregatedItemRecord(11700, "Productivity Tool Y (Mock)", "com.example.productivityy", Integer.valueOf(r02.k(20, 100)), 1, "Productive", "Productivity"), new AggregatedItemRecord(7200, "Game Z (Mock)", "com.example.gamez", Integer.valueOf(r02.k(30, 150)), 1, "Distractive", "Games"), new AggregatedItemRecord(5400, "News Reader (Mock)", "com.example.newsreader", Integer.valueOf(r02.k(10, 80)), 1, "Neutral", "News"), new AggregatedItemRecord(9000, "Another Social App (Mock)", "com.example.socialapp2", Integer.valueOf(r02.k(80, 250)), 1, "Distractive", "Social")});
            long seconds = TimeUnit.HOURS.toSeconds(3L);
            TimeUnit timeUnit = TimeUnit.MINUTES;
            return new WeeklyInsightsViewState(false, "Mock User", "https://example.com/mockuser.png", false, Long.valueOf(seconds + timeUnit.toSeconds(25L)), Long.valueOf(-timeUnit.toMillis(30L)), Float.valueOf(-0.15f), graphData, graphDataA, insightsInterval, MapsKt.mapOf(TuplesKt.a(AppDistractionType.Distractive, Double.valueOf(150.0d)), TuplesKt.a(AppDistractionType.Neutral, Double.valueOf(25.0d)), TuplesKt.a(AppDistractionType.Productive, Double.valueOf(45.5d))), CollectionsKt.sortedWith(listListOf, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewState$Companion$getMockWeeklyInsightsViewState$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt.d(Integer.valueOf(((AggregatedItemRecord) obj2).c()), Integer.valueOf(((AggregatedItemRecord) obj).c()));
                }
            }), false, null, null, false, null, new AggregatedPauseHistory(18L, 18000000L), false, false, false, false, false, 8253449, null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DistractiveApp {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Companion f104037e = new Companion(null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f104038f = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f104039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f104040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f104041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Drawable f104042d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public DistractiveApp(String packageName, String name, float f3, Drawable drawable) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(name, "name");
            this.f104039a = packageName;
            this.f104040b = name;
            this.f104041c = f3;
            this.f104042d = drawable;
        }

        public final Drawable a() {
            return this.f104042d;
        }

        public final float b() {
            return this.f104041c;
        }

        public final String c() {
            return this.f104040b;
        }

        public final String d() {
            return this.f104039a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DistractiveApp)) {
                return false;
            }
            DistractiveApp distractiveApp = (DistractiveApp) obj;
            return Intrinsics.areEqual(this.f104039a, distractiveApp.f104039a) && Intrinsics.areEqual(this.f104040b, distractiveApp.f104040b) && Float.compare(this.f104041c, distractiveApp.f104041c) == 0 && Intrinsics.areEqual(this.f104042d, distractiveApp.f104042d);
        }

        public int hashCode() {
            int iHashCode = ((((this.f104039a.hashCode() * 31) + this.f104040b.hashCode()) * 31) + Float.hashCode(this.f104041c)) * 31;
            Drawable drawable = this.f104042d;
            return iHashCode + (drawable == null ? 0 : drawable.hashCode());
        }

        public String toString() {
            return "DistractiveApp(packageName=" + this.f104039a + ", name=" + this.f104040b + ", duration=" + this.f104041c + ", appIcon=" + this.f104042d + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f104043a;

        static {
            int[] iArr = new int[WeeklyInsightsActivity.Navigation.values().length];
            try {
                iArr[WeeklyInsightsActivity.Navigation.Distractions.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WeeklyInsightsActivity.Navigation.Trend.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WeeklyInsightsActivity.Navigation.BreakTheRules.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f104043a = iArr;
        }
    }

    public WeeklyInsightsViewState(boolean z2, String str, String str2, boolean z3, Long l3, Long l4, Float f3, GraphData graphData, GraphData graphData2, InsightsViewState.InsightsInterval insightsInterval, Map averageDailyScreenTime, List appData, boolean z4, ImmutableList schedules, String str3, boolean z5, RecordDuration recordDuration, AggregatedPauseHistory aggregatedPauseHistory, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        AggregatedPauseHistory aggregatedPauseHistory2;
        Intrinsics.checkNotNullParameter(averageDailyScreenTime, "averageDailyScreenTime");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        this.f104012a = z2;
        this.f104013b = str;
        this.f104014c = str2;
        this.f104015d = z3;
        this.f104016f = l3;
        this.f104017g = l4;
        this.f104018h = f3;
        this.f104019i = graphData;
        this.f104020j = graphData2;
        this.f104021k = insightsInterval;
        this.f104022l = averageDailyScreenTime;
        this.f104023m = appData;
        this.f104024n = z4;
        this.f104025o = schedules;
        this.f104026p = str3;
        this.f104027q = z5;
        this.f104028r = recordDuration;
        this.f104029s = aggregatedPauseHistory;
        this.f104030t = z6;
        this.f104031u = z7;
        this.f104032v = z8;
        this.f104033w = z9;
        this.f104034x = z10;
        ArrayList arrayList = new ArrayList();
        for (WeeklyInsightsActivity.Navigation navigation : WeeklyInsightsActivity.Navigation.getEntries()) {
            int i3 = WhenMappings.f104043a[navigation.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        arrayList.add(navigation.getRoute());
                    } else if (this.f104015d && (aggregatedPauseHistory2 = this.f104029s) != null && aggregatedPauseHistory2.a() > 3) {
                        arrayList.add(navigation.getRoute());
                    }
                } else if (this.f104017g != null) {
                    arrayList.add(navigation.getRoute());
                }
            } else if (!this.f104023m.isEmpty()) {
                arrayList.add(navigation.getRoute());
            }
        }
        this.f104035y = arrayList;
        this.f104036z = 1 / arrayList.size();
    }

    public static /* synthetic */ WeeklyInsightsViewState b(WeeklyInsightsViewState weeklyInsightsViewState, boolean z2, String str, String str2, boolean z3, Long l3, Long l4, Float f3, GraphData graphData, GraphData graphData2, InsightsViewState.InsightsInterval insightsInterval, Map map, List list, boolean z4, ImmutableList immutableList, String str3, boolean z5, RecordDuration recordDuration, AggregatedPauseHistory aggregatedPauseHistory, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i3, Object obj) {
        boolean z11;
        boolean z12;
        boolean z13 = (i3 & 1) != 0 ? weeklyInsightsViewState.f104012a : z2;
        String str4 = (i3 & 2) != 0 ? weeklyInsightsViewState.f104013b : str;
        String str5 = (i3 & 4) != 0 ? weeklyInsightsViewState.f104014c : str2;
        boolean z14 = (i3 & 8) != 0 ? weeklyInsightsViewState.f104015d : z3;
        Long l5 = (i3 & 16) != 0 ? weeklyInsightsViewState.f104016f : l3;
        Long l6 = (i3 & 32) != 0 ? weeklyInsightsViewState.f104017g : l4;
        Float f4 = (i3 & 64) != 0 ? weeklyInsightsViewState.f104018h : f3;
        GraphData graphData3 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? weeklyInsightsViewState.f104019i : graphData;
        GraphData graphData4 = (i3 & Function.MAX_NARGS) != 0 ? weeklyInsightsViewState.f104020j : graphData2;
        InsightsViewState.InsightsInterval insightsInterval2 = (i3 & 512) != 0 ? weeklyInsightsViewState.f104021k : insightsInterval;
        Map map2 = (i3 & 1024) != 0 ? weeklyInsightsViewState.f104022l : map;
        List list2 = (i3 & 2048) != 0 ? weeklyInsightsViewState.f104023m : list;
        boolean z15 = (i3 & 4096) != 0 ? weeklyInsightsViewState.f104024n : z4;
        ImmutableList immutableList2 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? weeklyInsightsViewState.f104025o : immutableList;
        boolean z16 = z13;
        String str6 = (i3 & 16384) != 0 ? weeklyInsightsViewState.f104026p : str3;
        boolean z17 = (i3 & 32768) != 0 ? weeklyInsightsViewState.f104027q : z5;
        RecordDuration recordDuration2 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? weeklyInsightsViewState.f104028r : recordDuration;
        AggregatedPauseHistory aggregatedPauseHistory2 = (i3 & 131072) != 0 ? weeklyInsightsViewState.f104029s : aggregatedPauseHistory;
        boolean z18 = (i3 & 262144) != 0 ? weeklyInsightsViewState.f104030t : z6;
        boolean z19 = (i3 & 524288) != 0 ? weeklyInsightsViewState.f104031u : z7;
        boolean z20 = (i3 & 1048576) != 0 ? weeklyInsightsViewState.f104032v : z8;
        boolean z21 = (i3 & 2097152) != 0 ? weeklyInsightsViewState.f104033w : z9;
        if ((i3 & 4194304) != 0) {
            z12 = z21;
            z11 = weeklyInsightsViewState.f104034x;
        } else {
            z11 = z10;
            z12 = z21;
        }
        return weeklyInsightsViewState.a(z16, str4, str5, z14, l5, l6, f4, graphData3, graphData4, insightsInterval2, map2, list2, z15, immutableList2, str6, z17, recordDuration2, aggregatedPauseHistory2, z18, z19, z20, z12, z11);
    }

    public final Long A() {
        return this.f104017g;
    }

    public final Float B() {
        return this.f104018h;
    }

    public final GraphData C() {
        return this.f104019i;
    }

    public final String D() {
        InsightsViewState.InsightsInterval insightsInterval = this.f104021k;
        if (insightsInterval != null) {
            return insightsInterval.c();
        }
        return null;
    }

    public final boolean E() {
        return this.f104027q;
    }

    public final boolean F() {
        return this.f104024n;
    }

    public final String G(String currentRoute) {
        Intrinsics.checkNotNullParameter(currentRoute, "currentRoute");
        List list = this.f104035y;
        int iIndexOf = list.indexOf(currentRoute);
        this.f104036z = (iIndexOf + 2) / list.size();
        return (String) CollectionsKt.getOrNull(list, iIndexOf + 1);
    }

    public final String H(String currentRoute) {
        Intrinsics.checkNotNullParameter(currentRoute, "currentRoute");
        List list = this.f104035y;
        int iIndexOf = list.indexOf(currentRoute);
        this.f104036z = iIndexOf / list.size();
        return (String) list.get(RangesKt.f(iIndexOf - 1, 0));
    }

    public final WeeklyInsightsViewState a(boolean z2, String str, String str2, boolean z3, Long l3, Long l4, Float f3, GraphData graphData, GraphData graphData2, InsightsViewState.InsightsInterval insightsInterval, Map averageDailyScreenTime, List appData, boolean z4, ImmutableList schedules, String str3, boolean z5, RecordDuration recordDuration, AggregatedPauseHistory aggregatedPauseHistory, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        Intrinsics.checkNotNullParameter(averageDailyScreenTime, "averageDailyScreenTime");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        return new WeeklyInsightsViewState(z2, str, str2, z3, l3, l4, f3, graphData, graphData2, insightsInterval, averageDailyScreenTime, appData, z4, schedules, str3, z5, recordDuration, aggregatedPauseHistory, z6, z7, z8, z9, z10);
    }

    public final List c() {
        return this.f104023m;
    }

    public final Pair d(PackageManager packageManager, String packageName) {
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return PackageManagerHelperKt.a(packageManager, packageName);
    }

    public final Map e() {
        return this.f104022l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeeklyInsightsViewState)) {
            return false;
        }
        WeeklyInsightsViewState weeklyInsightsViewState = (WeeklyInsightsViewState) obj;
        return this.f104012a == weeklyInsightsViewState.f104012a && Intrinsics.areEqual(this.f104013b, weeklyInsightsViewState.f104013b) && Intrinsics.areEqual(this.f104014c, weeklyInsightsViewState.f104014c) && this.f104015d == weeklyInsightsViewState.f104015d && Intrinsics.areEqual(this.f104016f, weeklyInsightsViewState.f104016f) && Intrinsics.areEqual(this.f104017g, weeklyInsightsViewState.f104017g) && Intrinsics.areEqual((Object) this.f104018h, (Object) weeklyInsightsViewState.f104018h) && Intrinsics.areEqual(this.f104019i, weeklyInsightsViewState.f104019i) && Intrinsics.areEqual(this.f104020j, weeklyInsightsViewState.f104020j) && Intrinsics.areEqual(this.f104021k, weeklyInsightsViewState.f104021k) && Intrinsics.areEqual(this.f104022l, weeklyInsightsViewState.f104022l) && Intrinsics.areEqual(this.f104023m, weeklyInsightsViewState.f104023m) && this.f104024n == weeklyInsightsViewState.f104024n && Intrinsics.areEqual(this.f104025o, weeklyInsightsViewState.f104025o) && Intrinsics.areEqual(this.f104026p, weeklyInsightsViewState.f104026p) && this.f104027q == weeklyInsightsViewState.f104027q && Intrinsics.areEqual(this.f104028r, weeklyInsightsViewState.f104028r) && Intrinsics.areEqual(this.f104029s, weeklyInsightsViewState.f104029s) && this.f104030t == weeklyInsightsViewState.f104030t && this.f104031u == weeklyInsightsViewState.f104031u && this.f104032v == weeklyInsightsViewState.f104032v && this.f104033w == weeklyInsightsViewState.f104033w && this.f104034x == weeklyInsightsViewState.f104034x;
    }

    public final Long f() {
        return this.f104016f;
    }

    public final boolean g() {
        return this.f104034x;
    }

    public final boolean h() {
        return this.f104031u;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.f104012a) * 31;
        String str = this.f104013b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f104014c;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.f104015d)) * 31;
        Long l3 = this.f104016f;
        int iHashCode4 = (iHashCode3 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.f104017g;
        int iHashCode5 = (iHashCode4 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Float f3 = this.f104018h;
        int iHashCode6 = (iHashCode5 + (f3 == null ? 0 : f3.hashCode())) * 31;
        GraphData graphData = this.f104019i;
        int iHashCode7 = (iHashCode6 + (graphData == null ? 0 : graphData.hashCode())) * 31;
        GraphData graphData2 = this.f104020j;
        int iHashCode8 = (iHashCode7 + (graphData2 == null ? 0 : graphData2.hashCode())) * 31;
        InsightsViewState.InsightsInterval insightsInterval = this.f104021k;
        int iHashCode9 = (((((((((iHashCode8 + (insightsInterval == null ? 0 : insightsInterval.hashCode())) * 31) + this.f104022l.hashCode()) * 31) + this.f104023m.hashCode()) * 31) + Boolean.hashCode(this.f104024n)) * 31) + this.f104025o.hashCode()) * 31;
        String str3 = this.f104026p;
        int iHashCode10 = (((iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.f104027q)) * 31;
        RecordDuration recordDuration = this.f104028r;
        int iHashCode11 = (iHashCode10 + (recordDuration == null ? 0 : recordDuration.hashCode())) * 31;
        AggregatedPauseHistory aggregatedPauseHistory = this.f104029s;
        return ((((((((((iHashCode11 + (aggregatedPauseHistory != null ? aggregatedPauseHistory.hashCode() : 0)) * 31) + Boolean.hashCode(this.f104030t)) * 31) + Boolean.hashCode(this.f104031u)) * 31) + Boolean.hashCode(this.f104032v)) * 31) + Boolean.hashCode(this.f104033w)) * 31) + Boolean.hashCode(this.f104034x);
    }

    public final boolean i() {
        return this.f104030t;
    }

    public final InsightsViewState.InsightsInterval j() {
        return this.f104021k;
    }

    public final GraphData k() {
        return this.f104020j;
    }

    public final WeeklyReportExitAction l() {
        return this.f104032v ? WeeklyReportExitAction.EmailConsent : this.f104033w ? WeeklyReportExitAction.RatingDialog : WeeklyReportExitAction.None;
    }

    public final String m() {
        String strF;
        Long l3 = this.f104016f;
        return (l3 == null || (strF = DateHelperExtKt.f(l3.longValue(), false, false, false, 14, null)) == null) ? "" : strF;
    }

    public final String n() {
        Long l3 = this.f104017g;
        if (l3 == null) {
            return "";
        }
        long jLongValue = l3.longValue();
        String strF = DateHelperExtKt.f(jLongValue, false, false, false, 14, null);
        String str = (jLongValue < 0 ? "-" : "+") + strF;
        return str == null ? "" : str;
    }

    public final String o() {
        return this.f104014c;
    }

    public final String p() {
        List listB;
        GraphData graphData = this.f104019i;
        if (graphData == null || (listB = graphData.b()) == null) {
            return null;
        }
        Iterator it = listB.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            float fE = ((GraphData.GraphValueData) next).e();
            do {
                Object next2 = it.next();
                float fE2 = ((GraphData.GraphValueData) next2).e();
                if (Float.compare(fE, fE2) > 0) {
                    next = next2;
                    fE = fE2;
                }
            } while (it.hasNext());
        }
        GraphData.GraphValueData graphValueData = (GraphData.GraphValueData) next;
        if (graphValueData != null) {
            return graphValueData.b();
        }
        return null;
    }

    public final RecordDuration q() {
        return this.f104028r;
    }

    public final List r(PackageManager packageManager) {
        List listSubList;
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        if (this.f104023m.isEmpty()) {
            listSubList = CollectionsKt.emptyList();
        } else {
            List list = this.f104023m;
            listSubList = list.subList(0, RangesKt.k(6, list.size()));
        }
        List<AggregatedItemRecord> list2 = listSubList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (AggregatedItemRecord aggregatedItemRecord : list2) {
            Pair pairD = d(packageManager, aggregatedItemRecord.e());
            arrayList.add(new DistractiveApp(aggregatedItemRecord.e(), (String) pairD.e(), aggregatedItemRecord.c(), (Drawable) pairD.f()));
        }
        return arrayList;
    }

    public final AggregatedPauseHistory s() {
        return this.f104029s;
    }

    public final String t() {
        Integer numE;
        GraphData graphData = this.f104020j;
        if (graphData == null || (numE = graphData.e()) == null) {
            return null;
        }
        int iIntValue = numE.intValue();
        return ((GraphData.GraphValueData) this.f104020j.b().get(iIntValue)).b() + " - " + (iIntValue == CollectionsKt.getLastIndex(this.f104020j.b()) ? ((GraphData.GraphValueData) this.f104020j.b().get(0)).b() : ((GraphData.GraphValueData) this.f104020j.b().get(iIntValue + 1)).b());
    }

    public final IntervalDTO u() {
        Integer numE;
        GraphData graphData = this.f104020j;
        if (graphData == null || (numE = graphData.e()) == null) {
            return null;
        }
        long jIntValue = ((long) numE.intValue()) * 60;
        return new IntervalDTO(jIntValue, 60 + jIntValue, null, null, 12, null);
    }

    public final float v() {
        return this.f104036z;
    }

    public final ImmutableList w() {
        return this.f104025o;
    }

    public final String x() {
        return this.f104026p;
    }

    public final String y() {
        List listB;
        GraphData graphData = this.f104019i;
        if (graphData == null || (listB = graphData.b()) == null) {
            return null;
        }
        Iterator it = listB.iterator();
        float fE = 0.0f;
        while (it.hasNext()) {
            fE += ((GraphData.GraphValueData) it.next()).e() * 60;
        }
        return DateHelperExtKt.f((long) fE, false, false, false, 14, null);
    }

    public final String z() {
        return this.f104013b;
    }

    public String toString() {
        return "WeeklyInsightsViewState(isLoading=" + this.f104012a + ", userName=" + this.f104013b + ", imageUrl=" + this.f104014c + ", isPremium=" + this.f104015d + ", averageScreenTime=" + this.f104016f + ", weekDifference=" + this.f104017g + ", weekDifferencePercentage=" + this.f104018h + ", weeklyGraphData=" + this.f104019i + ", dailyGraphData=" + this.f104020j + ", currentInterval=" + this.f104021k + ", averageDailyScreenTime=" + this.f104022l + ", appData=" + this.f104023m + ", isStrictModeOn=" + this.f104024n + ", schedules=" + this.f104025o + ", selectedApp=" + this.f104026p + ", isMostDistractiveAppInAnyBlocking=" + this.f104027q + ", longestUse=" + this.f104028r + ", pauseHistory=" + this.f104029s + YgVrd.kLAt + this.f104030t + ", canCreateContinuousUseSchedule=" + this.f104031u + ", showEmailConsent=" + this.f104032v + ", showRatingDialog=" + this.f104033w + ", canAddSchedules=" + this.f104034x + ")";
    }

    public /* synthetic */ WeeklyInsightsViewState(boolean z2, String str, String str2, boolean z3, Long l3, Long l4, Float f3, GraphData graphData, GraphData graphData2, InsightsViewState.InsightsInterval insightsInterval, Map map, List list, boolean z4, ImmutableList immutableList, String str3, boolean z5, RecordDuration recordDuration, AggregatedPauseHistory aggregatedPauseHistory, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? true : z3, (i3 & 16) != 0 ? null : l3, (i3 & 32) != 0 ? null : l4, (i3 & 64) != 0 ? null : f3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : graphData, (i3 & Function.MAX_NARGS) != 0 ? null : graphData2, (i3 & 512) != 0 ? null : insightsInterval, (i3 & 1024) != 0 ? MapsKt.emptyMap() : map, (i3 & 2048) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4096) != 0 ? false : z4, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 16384) != 0 ? null : str3, (i3 & 32768) != 0 ? false : z5, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? null : recordDuration, (i3 & 131072) != 0 ? null : aggregatedPauseHistory, (i3 & 262144) != 0 ? true : z6, (i3 & 524288) != 0 ? true : z7, (i3 & 1048576) != 0 ? false : z8, (i3 & 2097152) != 0 ? false : z9, (i3 & 4194304) != 0 ? false : z10);
    }
}
