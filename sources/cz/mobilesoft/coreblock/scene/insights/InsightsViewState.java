package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.format.DateFormat;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.InsightsBlockingSessions;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.storage.room.entity.core.MoodCheckInEntity;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.PackageManagerHelperKt;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import cz.mobilesoft.statistics.model.RecordDuration;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class InsightsViewState implements ViewState {
    public static final Companion Y = new Companion(null);
    private static final int Z = 57600;
    private final boolean A;
    private final List B;
    private final boolean C;
    private final boolean D;
    private final Map E;
    private final RecordDuration F;
    private final Long G;
    private final Double H;
    private final Double I;
    private final List J;
    private final GraphData K;
    private final GraphData L;
    private final InsightsBlockingSessions M;
    private final boolean N;
    private final long O;
    private final boolean P;
    private final boolean Q;
    private final boolean R;
    private final MoodCheckInEntity S;
    private final boolean T;
    private final boolean U;
    private final boolean V;
    private final int W;
    private final Calendar X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewModelState f102924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f102925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f102926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f102927d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f102928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AppDistractionType f102929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final InsightsPeriodType f102930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f102931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Category f102932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AppDistractionType f102933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ImmutableList f102934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f102935m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Long f102936n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Long f102937o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Long f102938p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final GraphData f102939q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final GraphData f102940r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Float f102941s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Long f102942t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Map f102943u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final List f102944v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Map f102945w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f102946x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final ImmutableList f102947y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final boolean f102948z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return InsightsViewState.Z;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InsightsInterval {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f102949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f102950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f102951c;

        public InsightsInterval(long j3, long j4, String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.f102949a = j3;
            this.f102950b = j4;
            this.f102951c = title;
        }

        public final long a() {
            return this.f102950b;
        }

        public final long b() {
            return this.f102949a;
        }

        public final String c() {
            return this.f102951c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InsightsInterval)) {
                return false;
            }
            InsightsInterval insightsInterval = (InsightsInterval) obj;
            return this.f102949a == insightsInterval.f102949a && this.f102950b == insightsInterval.f102950b && Intrinsics.areEqual(this.f102951c, insightsInterval.f102951c);
        }

        public int hashCode() {
            return (((Long.hashCode(this.f102949a) * 31) + Long.hashCode(this.f102950b)) * 31) + this.f102951c.hashCode();
        }

        public String toString() {
            return "InsightsInterval(start=" + this.f102949a + ", end=" + this.f102950b + ", title=" + this.f102951c + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InsightsPeriodType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InsightsPeriodType[] $VALUES;
        private final String eventName;
        private final int titleRes;
        public static final InsightsPeriodType Day = new InsightsPeriodType("Day", 0, R.string.b9, "day");
        public static final InsightsPeriodType Week = new InsightsPeriodType("Week", 1, R.string.lG, "week");
        public static final InsightsPeriodType Trend = new InsightsPeriodType("Trend", 2, R.string.dE, "all_time");

        private static final /* synthetic */ InsightsPeriodType[] $values() {
            return new InsightsPeriodType[]{Day, Week, Trend};
        }

        static {
            InsightsPeriodType[] insightsPeriodTypeArr$values = $values();
            $VALUES = insightsPeriodTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(insightsPeriodTypeArr$values);
        }

        private InsightsPeriodType(String str, int i3, int i4, String str2) {
            this.titleRes = i4;
            this.eventName = str2;
        }

        public static EnumEntries<InsightsPeriodType> getEntries() {
            return $ENTRIES;
        }

        public static InsightsPeriodType valueOf(String str) {
            return (InsightsPeriodType) Enum.valueOf(InsightsPeriodType.class, str);
        }

        public static InsightsPeriodType[] values() {
            return (InsightsPeriodType[]) $VALUES.clone();
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final int getTitleRes() {
            return this.titleRes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f102952a;

        static {
            int[] iArr = new int[InsightsPeriodType.values().length];
            try {
                iArr[InsightsPeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InsightsPeriodType.Week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InsightsPeriodType.Trend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f102952a = iArr;
        }
    }

    public InsightsViewState(ViewModelState state, List missingPermissions, boolean z2, Set browserPackageNames, String str, AppDistractionType appDistractionType, InsightsPeriodType selectedInsightType, int i3, Category category, AppDistractionType appDistractionType2, ImmutableList intervals, int i4, Long l3, Long l4, Long l5, GraphData graphData, GraphData graphData2, Float f3, Long l6, Map categories, List list, Map map, int i5, ImmutableList schedules, boolean z3, boolean z4, List list2, boolean z5, boolean z6, Map averageDailyScreenTime, RecordDuration recordDuration, Long l7, Double d3, Double d4, List list3, GraphData graphData3, GraphData graphData4, InsightsBlockingSessions insightsBlockingSessions, boolean z7, long j3, boolean z8, boolean z9, boolean z10, MoodCheckInEntity moodCheckInEntity, boolean z11, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        Intrinsics.checkNotNullParameter(browserPackageNames, "browserPackageNames");
        Intrinsics.checkNotNullParameter(selectedInsightType, "selectedInsightType");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        Intrinsics.checkNotNullParameter(averageDailyScreenTime, "averageDailyScreenTime");
        this.f102924a = state;
        this.f102925b = missingPermissions;
        this.f102926c = z2;
        this.f102927d = browserPackageNames;
        this.f102928f = str;
        this.f102929g = appDistractionType;
        this.f102930h = selectedInsightType;
        this.f102931i = i3;
        this.f102932j = category;
        this.f102933k = appDistractionType2;
        this.f102934l = intervals;
        this.f102935m = i4;
        this.f102936n = l3;
        this.f102937o = l4;
        this.f102938p = l5;
        this.f102939q = graphData;
        this.f102940r = graphData2;
        this.f102941s = f3;
        this.f102942t = l6;
        this.f102943u = categories;
        this.f102944v = list;
        this.f102945w = map;
        this.f102946x = i5;
        this.f102947y = schedules;
        this.f102948z = z3;
        this.A = z4;
        this.B = list2;
        this.C = z5;
        this.D = z6;
        this.E = averageDailyScreenTime;
        this.F = recordDuration;
        this.G = l7;
        this.H = d3;
        this.I = d4;
        this.J = list3;
        this.K = graphData3;
        this.L = graphData4;
        this.M = insightsBlockingSessions;
        this.N = z7;
        this.O = j3;
        this.P = z8;
        this.Q = z9;
        this.R = z10;
        this.S = moodCheckInEntity;
        this.T = z11;
        this.U = z12;
        this.V = z13;
        this.W = 100;
        this.X = Calendar.getInstance();
    }

    private final String F(Context context) {
        GraphData.GraphValueData graphValueDataG;
        GraphData graphData = this.f102939q;
        if (graphData == null || (graphValueDataG = graphData.g()) == null) {
            return null;
        }
        int i3 = WhenMappings.f102952a[this.f102930h.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return DateFormat.getDateFormat(context).format(Long.valueOf(graphValueDataG.c()));
            }
            if (i3 == 3) {
                return "Trend";
            }
            throw new NoWhenBranchMatchedException();
        }
        this.X.setTimeInMillis(graphValueDataG.c());
        java.text.DateFormat timeFormat = DateFormat.getTimeFormat(context);
        String str = timeFormat.format(this.X.getTime());
        this.X.add(11, 1);
        return str + " - " + timeFormat.format(this.X.getTime());
    }

    public static /* synthetic */ String H(InsightsViewState insightsViewState, long j3, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return insightsViewState.G(j3, z2);
    }

    public static /* synthetic */ InsightsViewState d(InsightsViewState insightsViewState, ViewModelState viewModelState, List list, boolean z2, Set set, String str, AppDistractionType appDistractionType, InsightsPeriodType insightsPeriodType, int i3, Category category, AppDistractionType appDistractionType2, ImmutableList immutableList, int i4, Long l3, Long l4, Long l5, GraphData graphData, GraphData graphData2, Float f3, Long l6, Map map, List list2, Map map2, int i5, ImmutableList immutableList2, boolean z3, boolean z4, List list3, boolean z5, boolean z6, Map map3, RecordDuration recordDuration, Long l7, Double d3, Double d4, List list4, GraphData graphData3, GraphData graphData4, InsightsBlockingSessions insightsBlockingSessions, boolean z7, long j3, boolean z8, boolean z9, boolean z10, MoodCheckInEntity moodCheckInEntity, boolean z11, boolean z12, boolean z13, int i6, int i7, Object obj) {
        Long l8;
        List list5;
        long j4;
        ViewModelState viewModelState2 = (i6 & 1) != 0 ? insightsViewState.f102924a : viewModelState;
        List list6 = (i6 & 2) != 0 ? insightsViewState.f102925b : list;
        boolean z14 = (i6 & 4) != 0 ? insightsViewState.f102926c : z2;
        Set set2 = (i6 & 8) != 0 ? insightsViewState.f102927d : set;
        String str2 = (i6 & 16) != 0 ? insightsViewState.f102928f : str;
        AppDistractionType appDistractionType3 = (i6 & 32) != 0 ? insightsViewState.f102929g : appDistractionType;
        InsightsPeriodType insightsPeriodType2 = (i6 & 64) != 0 ? insightsViewState.f102930h : insightsPeriodType;
        int i8 = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? insightsViewState.f102931i : i3;
        Category category2 = (i6 & Function.MAX_NARGS) != 0 ? insightsViewState.f102932j : category;
        AppDistractionType appDistractionType4 = (i6 & 512) != 0 ? insightsViewState.f102933k : appDistractionType2;
        ImmutableList immutableList3 = (i6 & 1024) != 0 ? insightsViewState.f102934l : immutableList;
        int i9 = (i6 & 2048) != 0 ? insightsViewState.f102935m : i4;
        Long l9 = (i6 & 4096) != 0 ? insightsViewState.f102936n : l3;
        ViewModelState viewModelState3 = viewModelState2;
        Long l10 = (i6 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? insightsViewState.f102937o : l4;
        Long l11 = (i6 & 16384) != 0 ? insightsViewState.f102938p : l5;
        GraphData graphData5 = (i6 & 32768) != 0 ? insightsViewState.f102939q : graphData;
        GraphData graphData6 = (i6 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? insightsViewState.f102940r : graphData2;
        Float f4 = (i6 & 131072) != 0 ? insightsViewState.f102941s : f3;
        Long l12 = (i6 & 262144) != 0 ? insightsViewState.f102942t : l6;
        Map map4 = (i6 & 524288) != 0 ? insightsViewState.f102943u : map;
        List list7 = (i6 & 1048576) != 0 ? insightsViewState.f102944v : list2;
        Map map5 = (i6 & 2097152) != 0 ? insightsViewState.f102945w : map2;
        int i10 = (i6 & 4194304) != 0 ? insightsViewState.f102946x : i5;
        ImmutableList immutableList4 = (i6 & 8388608) != 0 ? insightsViewState.f102947y : immutableList2;
        boolean z15 = (i6 & 16777216) != 0 ? insightsViewState.f102948z : z3;
        boolean z16 = (i6 & 33554432) != 0 ? insightsViewState.A : z4;
        List list8 = (i6 & 67108864) != 0 ? insightsViewState.B : list3;
        boolean z17 = (i6 & 134217728) != 0 ? insightsViewState.C : z5;
        boolean z18 = (i6 & 268435456) != 0 ? insightsViewState.D : z6;
        Map map6 = (i6 & 536870912) != 0 ? insightsViewState.E : map3;
        RecordDuration recordDuration2 = (i6 & 1073741824) != 0 ? insightsViewState.F : recordDuration;
        Long l13 = (i6 & Integer.MIN_VALUE) != 0 ? insightsViewState.G : l7;
        Double d5 = (i7 & 1) != 0 ? insightsViewState.H : d3;
        Double d6 = (i7 & 2) != 0 ? insightsViewState.I : d4;
        List list9 = (i7 & 4) != 0 ? insightsViewState.J : list4;
        GraphData graphData7 = (i7 & 8) != 0 ? insightsViewState.K : graphData3;
        GraphData graphData8 = (i7 & 16) != 0 ? insightsViewState.L : graphData4;
        InsightsBlockingSessions insightsBlockingSessions2 = (i7 & 32) != 0 ? insightsViewState.M : insightsBlockingSessions;
        boolean z19 = (i7 & 64) != 0 ? insightsViewState.N : z7;
        if ((i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            l8 = l11;
            list5 = list6;
            j4 = insightsViewState.O;
        } else {
            l8 = l11;
            list5 = list6;
            j4 = j3;
        }
        return insightsViewState.c(viewModelState3, list5, z14, set2, str2, appDistractionType3, insightsPeriodType2, i8, category2, appDistractionType4, immutableList3, i9, l9, l10, l8, graphData5, graphData6, f4, l12, map4, list7, map5, i10, immutableList4, z15, z16, list8, z17, z18, map6, recordDuration2, l13, d5, d6, list9, graphData7, graphData8, insightsBlockingSessions2, z19, j4, (i7 & Function.MAX_NARGS) != 0 ? insightsViewState.P : z8, (i7 & 512) != 0 ? insightsViewState.Q : z9, (i7 & 1024) != 0 ? insightsViewState.R : z10, (i7 & 2048) != 0 ? insightsViewState.S : moodCheckInEntity, (i7 & 4096) != 0 ? insightsViewState.T : z11, (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? insightsViewState.U : z12, (i7 & 16384) != 0 ? insightsViewState.V : z13);
    }

    public final Long A() {
        return this.f102942t;
    }

    public final List B() {
        return this.B;
    }

    public final GraphData C() {
        return this.K;
    }

    public final String D() {
        String strH;
        Long lE = e();
        return (lE == null || (strH = H(this, lE.longValue(), false, 2, null)) == null) ? "" : strH;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String E(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState$InsightsPeriodType r0 = r6.f102930h
            int[] r1 = cz.mobilesoft.coreblock.scene.insights.InsightsViewState.WhenMappings.f102952a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L56
            r1 = 2
            if (r0 == r1) goto L40
            r1 = 3
            if (r0 != r1) goto L3a
            java.lang.Float r0 = r6.j0()
            if (r0 == 0) goto L37
            float r0 = r0.floatValue()
            int r1 = cz.mobilesoft.coreblock.R.string.Ig
            r2 = 100
            float r2 = (float) r2
            float r0 = r0 * r2
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r0 = r7.getString(r1, r0)
            if (r0 != 0) goto L5c
        L37:
            java.lang.String r0 = ""
            goto L5c
        L3a:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L40:
            cz.mobilesoft.coreblock.view.graph.GraphData r0 = r6.f102939q
            if (r0 == 0) goto L49
            cz.mobilesoft.coreblock.view.graph.GraphData$GraphValueData r0 = r0.g()
            goto L4a
        L49:
            r0 = 0
        L4a:
            if (r0 != 0) goto L4f
            int r0 = cz.mobilesoft.coreblock.R.string.v2
            goto L51
        L4f:
            int r0 = cz.mobilesoft.coreblock.R.string.Bv
        L51:
            java.lang.String r0 = r7.getString(r0)
            goto L5c
        L56:
            int r0 = cz.mobilesoft.coreblock.R.string.Bv
            java.lang.String r0 = r7.getString(r0)
        L5c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toUpperCase(r1)
            java.lang.String r2 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            cz.mobilesoft.coreblock.dto.Category r3 = r6.f102932j
            java.lang.String r4 = " • "
            if (r3 == 0) goto L96
            int r3 = r3.getTitleRes()
            java.lang.String r3 = r7.getString(r3)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            java.lang.String r1 = r3.toUpperCase(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r4)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
        L96:
            java.lang.String r7 = r6.F(r7)
            if (r7 == 0) goto Lb2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r4)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            if (r7 != 0) goto Lb1
            goto Lb2
        Lb1:
            return r7
        Lb2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewState.E(android.content.Context):java.lang.String");
    }

    public final String G(long j3, boolean z2) {
        String strF = DateHelperExtKt.f(Math.abs(j3), false, false, false, 14, null);
        if (z2 || this.f102930h != InsightsPeriodType.Trend) {
            return strF;
        }
        return (j3 < 0 ? "-" : "+") + strF;
    }

    public final boolean I() {
        return this.f102926c;
    }

    public final boolean J() {
        return this.Q;
    }

    public final ImmutableList K() {
        return this.f102934l;
    }

    public final GraphData L() {
        return this.L;
    }

    public final Long M() {
        return this.G;
    }

    public final RecordDuration N() {
        return this.F;
    }

    public final List O() {
        return this.f102925b;
    }

    public final boolean P() {
        return this.P;
    }

    public final long Q() {
        return this.O;
    }

    public final boolean R() {
        return !this.f102925b.isEmpty();
    }

    public final Double S() {
        return this.I;
    }

    public final int T() {
        return this.W;
    }

    public final AppDistractionType U() {
        return this.f102929g;
    }

    public final String V() {
        return this.f102928f;
    }

    public final List W() {
        List list = this.f102944v;
        List listSubList = list != null ? list.subList(0, RangesKt.k((this.f102946x * 10) + 5, list.size())) : null;
        return listSubList == null ? CollectionsKt.emptyList() : listSubList;
    }

    public final String X() {
        Integer numE;
        GraphData graphData = this.f102940r;
        if (graphData == null || (numE = graphData.e()) == null) {
            return null;
        }
        int iIntValue = numE.intValue();
        return ((GraphData.GraphValueData) this.f102940r.b().get(iIntValue)).b() + " - " + (iIntValue == CollectionsKt.getLastIndex(this.f102940r.b()) ? ((GraphData.GraphValueData) this.f102940r.b().get(0)).b() : ((GraphData.GraphValueData) this.f102940r.b().get(iIntValue + 1)).b());
    }

    public final ImmutableList Y() {
        return this.f102947y;
    }

    public final Category Z() {
        return this.f102932j;
    }

    public final InsightsPeriodType a0() {
        return this.f102930h;
    }

    public final Float b(AggregatedItemRecord app) {
        Intrinsics.checkNotNullParameter(app, "app");
        InsightsPeriodType insightsPeriodType = this.f102930h;
        if (insightsPeriodType != InsightsPeriodType.Week && (insightsPeriodType != InsightsPeriodType.Day || this.f102937o != null)) {
            return null;
        }
        Long l3 = this.f102937o;
        if (l3 == null) {
            l3 = this.f102938p;
        }
        if (l3 == null) {
            return null;
        }
        return Float.valueOf(app.c() / l3.longValue());
    }

    public final int b0() {
        return this.f102931i;
    }

    public final InsightsViewState c(ViewModelState state, List missingPermissions, boolean z2, Set browserPackageNames, String str, AppDistractionType appDistractionType, InsightsPeriodType selectedInsightType, int i3, Category category, AppDistractionType appDistractionType2, ImmutableList intervals, int i4, Long l3, Long l4, Long l5, GraphData graphData, GraphData graphData2, Float f3, Long l6, Map categories, List list, Map map, int i5, ImmutableList schedules, boolean z3, boolean z4, List list2, boolean z5, boolean z6, Map averageDailyScreenTime, RecordDuration recordDuration, Long l7, Double d3, Double d4, List list3, GraphData graphData3, GraphData graphData4, InsightsBlockingSessions insightsBlockingSessions, boolean z7, long j3, boolean z8, boolean z9, boolean z10, MoodCheckInEntity moodCheckInEntity, boolean z11, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        Intrinsics.checkNotNullParameter(browserPackageNames, "browserPackageNames");
        Intrinsics.checkNotNullParameter(selectedInsightType, "selectedInsightType");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        Intrinsics.checkNotNullParameter(averageDailyScreenTime, "averageDailyScreenTime");
        return new InsightsViewState(state, missingPermissions, z2, browserPackageNames, str, appDistractionType, selectedInsightType, i3, category, appDistractionType2, intervals, i4, l3, l4, l5, graphData, graphData2, f3, l6, categories, list, map, i5, schedules, z3, z4, list2, z5, z6, averageDailyScreenTime, recordDuration, l7, d3, d4, list3, graphData3, graphData4, insightsBlockingSessions, z7, j3, z8, z9, z10, moodCheckInEntity, z11, z12, z13);
    }

    public final boolean c0() {
        if (p0() || this.f102930h != InsightsPeriodType.Day || !this.P || this.N) {
            return false;
        }
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        LocalTime localTimeNow = LocalTime.now();
        Intrinsics.checkNotNullExpressionValue(localTimeNow, "now(...)");
        return timeHelperExt.x(localTimeNow);
    }

    public final boolean d0() {
        List list;
        return (p0() || this.f102930h == InsightsPeriodType.Trend || this.f102933k != null || (list = this.f102944v) == null || !(list.isEmpty() ^ true) || this.Q || this.R) ? false : true;
    }

    public final Long e() {
        Long l3 = this.f102937o;
        return l3 == null ? this.f102930h == InsightsPeriodType.Day ? this.f102938p : this.f102936n : l3;
    }

    public final boolean e0() {
        List list;
        return (this.f102926c || (list = this.f102944v) == null || !(list.isEmpty() ^ true)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsightsViewState)) {
            return false;
        }
        InsightsViewState insightsViewState = (InsightsViewState) obj;
        return Intrinsics.areEqual(this.f102924a, insightsViewState.f102924a) && Intrinsics.areEqual(this.f102925b, insightsViewState.f102925b) && this.f102926c == insightsViewState.f102926c && Intrinsics.areEqual(this.f102927d, insightsViewState.f102927d) && Intrinsics.areEqual(this.f102928f, insightsViewState.f102928f) && this.f102929g == insightsViewState.f102929g && this.f102930h == insightsViewState.f102930h && this.f102931i == insightsViewState.f102931i && this.f102932j == insightsViewState.f102932j && this.f102933k == insightsViewState.f102933k && Intrinsics.areEqual(this.f102934l, insightsViewState.f102934l) && this.f102935m == insightsViewState.f102935m && Intrinsics.areEqual(this.f102936n, insightsViewState.f102936n) && Intrinsics.areEqual(this.f102937o, insightsViewState.f102937o) && Intrinsics.areEqual(this.f102938p, insightsViewState.f102938p) && Intrinsics.areEqual(this.f102939q, insightsViewState.f102939q) && Intrinsics.areEqual(this.f102940r, insightsViewState.f102940r) && Intrinsics.areEqual((Object) this.f102941s, (Object) insightsViewState.f102941s) && Intrinsics.areEqual(this.f102942t, insightsViewState.f102942t) && Intrinsics.areEqual(this.f102943u, insightsViewState.f102943u) && Intrinsics.areEqual(this.f102944v, insightsViewState.f102944v) && Intrinsics.areEqual(this.f102945w, insightsViewState.f102945w) && this.f102946x == insightsViewState.f102946x && Intrinsics.areEqual(this.f102947y, insightsViewState.f102947y) && this.f102948z == insightsViewState.f102948z && this.A == insightsViewState.A && Intrinsics.areEqual(this.B, insightsViewState.B) && this.C == insightsViewState.C && this.D == insightsViewState.D && Intrinsics.areEqual(this.E, insightsViewState.E) && Intrinsics.areEqual(this.F, insightsViewState.F) && Intrinsics.areEqual(this.G, insightsViewState.G) && Intrinsics.areEqual((Object) this.H, (Object) insightsViewState.H) && Intrinsics.areEqual((Object) this.I, (Object) insightsViewState.I) && Intrinsics.areEqual(this.J, insightsViewState.J) && Intrinsics.areEqual(this.K, insightsViewState.K) && Intrinsics.areEqual(this.L, insightsViewState.L) && Intrinsics.areEqual(this.M, insightsViewState.M) && this.N == insightsViewState.N && this.O == insightsViewState.O && this.P == insightsViewState.P && this.Q == insightsViewState.Q && this.R == insightsViewState.R && Intrinsics.areEqual(this.S, insightsViewState.S) && this.T == insightsViewState.T && this.U == insightsViewState.U && this.V == insightsViewState.V;
    }

    public final AppDistractionType f() {
        return this.f102933k;
    }

    public final boolean f0() {
        return (this.C || this.f102930h == InsightsPeriodType.Day) ? false : true;
    }

    public final Pair g(PackageManager packageManager, String packageName) {
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return PackageManagerHelperKt.a(packageManager, packageName);
    }

    public final ViewModelState g0() {
        return this.f102924a;
    }

    public final int h() {
        return this.f102946x;
    }

    public final Long h0() {
        return this.f102938p;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f102924a.hashCode() * 31) + this.f102925b.hashCode()) * 31) + Boolean.hashCode(this.f102926c)) * 31) + this.f102927d.hashCode()) * 31;
        String str = this.f102928f;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        AppDistractionType appDistractionType = this.f102929g;
        int iHashCode3 = (((((iHashCode2 + (appDistractionType == null ? 0 : appDistractionType.hashCode())) * 31) + this.f102930h.hashCode()) * 31) + Integer.hashCode(this.f102931i)) * 31;
        Category category = this.f102932j;
        int iHashCode4 = (iHashCode3 + (category == null ? 0 : category.hashCode())) * 31;
        AppDistractionType appDistractionType2 = this.f102933k;
        int iHashCode5 = (((((iHashCode4 + (appDistractionType2 == null ? 0 : appDistractionType2.hashCode())) * 31) + this.f102934l.hashCode()) * 31) + Integer.hashCode(this.f102935m)) * 31;
        Long l3 = this.f102936n;
        int iHashCode6 = (iHashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.f102937o;
        int iHashCode7 = (iHashCode6 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.f102938p;
        int iHashCode8 = (iHashCode7 + (l5 == null ? 0 : l5.hashCode())) * 31;
        GraphData graphData = this.f102939q;
        int iHashCode9 = (iHashCode8 + (graphData == null ? 0 : graphData.hashCode())) * 31;
        GraphData graphData2 = this.f102940r;
        int iHashCode10 = (iHashCode9 + (graphData2 == null ? 0 : graphData2.hashCode())) * 31;
        Float f3 = this.f102941s;
        int iHashCode11 = (iHashCode10 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Long l6 = this.f102942t;
        int iHashCode12 = (((iHashCode11 + (l6 == null ? 0 : l6.hashCode())) * 31) + this.f102943u.hashCode()) * 31;
        List list = this.f102944v;
        int iHashCode13 = (iHashCode12 + (list == null ? 0 : list.hashCode())) * 31;
        Map map = this.f102945w;
        int iHashCode14 = (((((((((iHashCode13 + (map == null ? 0 : map.hashCode())) * 31) + Integer.hashCode(this.f102946x)) * 31) + this.f102947y.hashCode()) * 31) + Boolean.hashCode(this.f102948z)) * 31) + Boolean.hashCode(this.A)) * 31;
        List list2 = this.B;
        int iHashCode15 = (((((((iHashCode14 + (list2 == null ? 0 : list2.hashCode())) * 31) + Boolean.hashCode(this.C)) * 31) + Boolean.hashCode(this.D)) * 31) + this.E.hashCode()) * 31;
        RecordDuration recordDuration = this.F;
        int iHashCode16 = (iHashCode15 + (recordDuration == null ? 0 : recordDuration.hashCode())) * 31;
        Long l7 = this.G;
        int iHashCode17 = (iHashCode16 + (l7 == null ? 0 : l7.hashCode())) * 31;
        Double d3 = this.H;
        int iHashCode18 = (iHashCode17 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.I;
        int iHashCode19 = (iHashCode18 + (d4 == null ? 0 : d4.hashCode())) * 31;
        List list3 = this.J;
        int iHashCode20 = (iHashCode19 + (list3 == null ? 0 : list3.hashCode())) * 31;
        GraphData graphData3 = this.K;
        int iHashCode21 = (iHashCode20 + (graphData3 == null ? 0 : graphData3.hashCode())) * 31;
        GraphData graphData4 = this.L;
        int iHashCode22 = (iHashCode21 + (graphData4 == null ? 0 : graphData4.hashCode())) * 31;
        InsightsBlockingSessions insightsBlockingSessions = this.M;
        int iHashCode23 = (((((((((((iHashCode22 + (insightsBlockingSessions == null ? 0 : insightsBlockingSessions.hashCode())) * 31) + Boolean.hashCode(this.N)) * 31) + Long.hashCode(this.O)) * 31) + Boolean.hashCode(this.P)) * 31) + Boolean.hashCode(this.Q)) * 31) + Boolean.hashCode(this.R)) * 31;
        MoodCheckInEntity moodCheckInEntity = this.S;
        return ((((((iHashCode23 + (moodCheckInEntity != null ? moodCheckInEntity.hashCode() : 0)) * 31) + Boolean.hashCode(this.T)) * 31) + Boolean.hashCode(this.U)) * 31) + Boolean.hashCode(this.V);
    }

    public final List i() {
        return CollectionsKt.plus((Collection) TrendInterval.getEntries().subList(0, RangesKt.f(this.f102934l.size() - 1, 0)), (Iterable) CollectionsKt.listOf(TrendInterval.Max));
    }

    public final Boolean i0() {
        Long lE = e();
        if (lE != null) {
            return Boolean.valueOf(lE.longValue() > 0);
        }
        return null;
    }

    public final Map j() {
        return this.E;
    }

    public final Float j0() {
        List listB;
        List listB2;
        GraphData graphData = this.f102939q;
        GraphData.GraphValueData graphValueData = (graphData == null || (listB2 = graphData.b()) == null) ? null : (GraphData.GraphValueData) CollectionsKt.firstOrNull(listB2);
        GraphData graphData2 = this.f102939q;
        GraphData.GraphValueData graphValueData2 = (graphData2 == null || (listB = graphData2.b()) == null) ? null : (GraphData.GraphValueData) CollectionsKt.lastOrNull(listB);
        if (graphValueData == null || graphValueData.e() == 0.0f || graphValueData2 == null) {
            return null;
        }
        return Float.valueOf((graphValueData2.e() - graphValueData.e()) / graphValueData.e());
    }

    public final Long k() {
        return this.f102930h == InsightsPeriodType.Day ? this.f102938p : this.f102936n;
    }

    public final Double k0() {
        return this.H;
    }

    public final GraphData l() {
        return this.f102939q;
    }

    public final Map l0() {
        return this.f102945w;
    }

    public final List m() {
        List list = this.J;
        if (list != null) {
            return CollectionsKt.take(list, 3);
        }
        return null;
    }

    public final Float m0() {
        return this.f102941s;
    }

    public final InsightsBlockingSessions n() {
        return this.M;
    }

    public final Float n0() {
        GraphData graphData = this.K;
        if ((graphData != null ? graphData.a() : null) != null) {
            GraphData graphData2 = this.L;
            if ((graphData2 != null ? graphData2.a() : null) != null) {
                return Float.valueOf(this.L.a().floatValue() - this.K.a().floatValue());
            }
        }
        return null;
    }

    public final boolean o() {
        return this.U;
    }

    public final List o0() {
        List listTakeLast;
        List list = this.J;
        if (list == null || (listTakeLast = CollectionsKt.takeLast(list, 3)) == null) {
            return null;
        }
        return CollectionsKt.asReversed(listTakeLast);
    }

    public final boolean p() {
        List list = this.f102944v;
        return list != null && list.size() > W().size();
    }

    public final boolean p0() {
        return this.f102928f != null;
    }

    public final boolean q() {
        return this.V;
    }

    public final boolean q0(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return this.f102927d.contains(packageName);
    }

    public final boolean r() {
        return this.f102935m < this.f102934l.size() - 1;
    }

    public final boolean r0() {
        List list = this.f102944v;
        return (list == null || list.isEmpty()) && this.f102930h != InsightsPeriodType.Trend;
    }

    public final boolean s() {
        return this.f102935m > 0;
    }

    public final boolean s0() {
        return this.A;
    }

    public final Map t() {
        return this.f102943u;
    }

    public final boolean t0() {
        return this.N;
    }

    public String toString() {
        return "InsightsViewState(state=" + this.f102924a + ", missingPermissions=" + this.f102925b + ", hasAccessibilityPermission=" + this.f102926c + ", browserPackageNames=" + this.f102927d + ", packageName=" + this.f102928f + ", packageAppDistractionType=" + this.f102929g + ", selectedInsightType=" + this.f102930h + ", selectedTrendInterval=" + this.f102931i + ", selectedCategory=" + this.f102932j + ", appDistractionTypeFilter=" + this.f102933k + ", intervals=" + this.f102934l + ", currentIndex=" + this.f102935m + ", averageScreenTime=" + this.f102936n + ", focusedScreenTime=" + this.f102937o + ", totalScreenTime=" + this.f102938p + ", barGraphData=" + this.f102939q + ", dailyUsageGraphData=" + this.f102940r + ", weekDifference=" + this.f102941s + ", dayComparisonDeltaSeconds=" + this.f102942t + ", categories=" + this.f102943u + ", appData=" + this.f102944v + ", webData=" + this.f102945w + ", appListPage=" + this.f102946x + ", schedules=" + this.f102947y + ", isStrictModeOn=" + this.f102948z + ", isExcludedFromReports=" + this.A + ", excludedApps=" + this.B + ", isSubscriber=" + this.C + ", categoriesAllowed=" + this.D + ", averageDailyScreenTime=" + this.E + ", longestContinuousUse=" + this.F + ", longestBreak=" + this.G + ", unlockCount=" + this.H + ", notificationsCount=" + this.I + ", appsDifferences=" + this.J + ", firstWeekDailyUsageGraphData=" + this.K + ", lastWeekDailyUsageGraphData=" + this.L + ", blockSessions=" + this.M + ", isMoodCheckInTodayShown=" + this.N + ", moodCheckInClosedCount=" + this.O + ", moodCheckInAutoShowOn=" + this.P + ", hasAnyAppClassification=" + this.Q + ", isAppFeelBannerDismissed=" + this.R + ", currentMood=" + this.S + ", existsAnyMoodRecord=" + this.T + ", canAddSchedules=" + this.U + ", canOpenSocialShare=" + this.V + ")";
    }

    public final boolean u() {
        return this.D;
    }

    public final boolean u0() {
        return this.f102948z;
    }

    public final int v() {
        return this.f102935m;
    }

    public final boolean v0() {
        return this.C;
    }

    public final InsightsInterval w() {
        return (InsightsInterval) CollectionsKt.getOrNull(this.f102934l, this.f102935m);
    }

    public final MoodCheckInEntity x() {
        return this.S;
    }

    public final String y() {
        String strC;
        InsightsInterval insightsIntervalW = w();
        return (insightsIntervalW == null || (strC = insightsIntervalW.c()) == null) ? "" : strC;
    }

    public final GraphData z() {
        return this.f102940r;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TrendInterval {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TrendInterval[] $VALUES;
        private final Integer days;
        private final String shortTitle;
        private final String title;
        public static final TrendInterval Day30 = new TrendInterval("Day30", 0, 30);
        public static final TrendInterval Day90 = new TrendInterval("Day90", 1, 90);
        public static final TrendInterval Day180 = new TrendInterval("Day180", 2, Integer.valueOf(SensibleDefaults.X_OFFSET));
        public static final TrendInterval Max = new TrendInterval("Max", 3, null, 1, null);

        private static final /* synthetic */ TrendInterval[] $values() {
            return new TrendInterval[]{Day30, Day90, Day180, Max};
        }

        static {
            TrendInterval[] trendIntervalArr$values = $values();
            $VALUES = trendIntervalArr$values;
            $ENTRIES = EnumEntriesKt.a(trendIntervalArr$values);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private TrendInterval(java.lang.String r2, int r3, java.lang.Integer r4) {
            /*
                r1 = this;
                r1.<init>(r2, r3)
                r1.days = r4
                if (r4 == 0) goto L24
                int r2 = r4.intValue()
                int r2 = r2 / 30
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r0 = "LAST "
                r3.append(r0)
                r3.append(r2)
                java.lang.String r2 = " MONTHS"
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                goto L25
            L24:
                r2 = 0
            L25:
                r1.title = r2
                if (r4 == 0) goto L42
                int r2 = r4.intValue()
                int r2 = r2 / 30
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                java.lang.String r2 = "M"
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                if (r2 != 0) goto L44
            L42:
                java.lang.String r2 = "Max"
            L44:
                r1.shortTitle = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewState.TrendInterval.<init>(java.lang.String, int, java.lang.Integer):void");
        }

        public static EnumEntries<TrendInterval> getEntries() {
            return $ENTRIES;
        }

        public static TrendInterval valueOf(String str) {
            return (TrendInterval) Enum.valueOf(TrendInterval.class, str);
        }

        public static TrendInterval[] values() {
            return (TrendInterval[]) $VALUES.clone();
        }

        public final Integer getDays() {
            return this.days;
        }

        public final String getShortTitle() {
            return this.shortTitle;
        }

        public final String getTitle() {
            return this.title;
        }

        /* synthetic */ TrendInterval(String str, int i3, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, (i4 & 1) != 0 ? null : num);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ InsightsViewState(ViewModelState viewModelState, List list, boolean z2, Set set, String str, AppDistractionType appDistractionType, InsightsPeriodType insightsPeriodType, int i3, Category category, AppDistractionType appDistractionType2, ImmutableList immutableList, int i4, Long l3, Long l4, Long l5, GraphData graphData, GraphData graphData2, Float f3, Long l6, Map map, List list2, Map map2, int i5, ImmutableList immutableList2, boolean z3, boolean z4, List list3, boolean z5, boolean z6, Map map3, RecordDuration recordDuration, Long l7, Double d3, Double d4, List list4, GraphData graphData3, GraphData graphData4, InsightsBlockingSessions insightsBlockingSessions, boolean z7, long j3, boolean z8, boolean z9, boolean z10, MoodCheckInEntity moodCheckInEntity, boolean z11, boolean z12, boolean z13, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        ViewModelState viewModelState2 = (i6 & 1) != 0 ? Loading.f127895a : viewModelState;
        this(viewModelState2, (i6 & 2) != 0 ? CollectionsKt.emptyList() : list, (i6 & 4) != 0 ? false : z2, (i6 & 8) != 0 ? SetsKt.emptySet() : set, (i6 & 16) != 0 ? null : str, (i6 & 32) != 0 ? null : appDistractionType, (i6 & 64) != 0 ? InsightsPeriodType.Day : insightsPeriodType, (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0 : i3, (i6 & Function.MAX_NARGS) != 0 ? null : category, (i6 & 512) != 0 ? null : appDistractionType2, (i6 & 1024) != 0 ? ExtensionsKt.a() : immutableList, (i6 & 2048) != 0 ? 0 : i4, (i6 & 4096) != 0 ? null : l3, (i6 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : l4, (i6 & 16384) != 0 ? null : l5, (i6 & 32768) != 0 ? null : graphData, (i6 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? null : graphData2, (i6 & 131072) != 0 ? null : f3, (i6 & 262144) != 0 ? null : l6, (i6 & 524288) != 0 ? MapsKt.emptyMap() : map, (i6 & 1048576) != 0 ? null : list2, (i6 & 2097152) != 0 ? null : map2, (i6 & 4194304) != 0 ? 0 : i5, (i6 & 8388608) != 0 ? ExtensionsKt.a() : immutableList2, (i6 & 16777216) != 0 ? false : z3, (i6 & 33554432) != 0 ? false : z4, (i6 & 67108864) != 0 ? CollectionsKt.emptyList() : list3, (i6 & 134217728) != 0 ? true : z5, (i6 & 268435456) != 0 ? false : z6, (i6 & 536870912) != 0 ? MapsKt.emptyMap() : map3, (i6 & 1073741824) != 0 ? null : recordDuration, (i6 & Integer.MIN_VALUE) != 0 ? null : l7, (i7 & 1) != 0 ? null : d3, (i7 & 2) != 0 ? null : d4, (i7 & 4) != 0 ? null : list4, (i7 & 8) != 0 ? null : graphData3, (i7 & 16) != 0 ? null : graphData4, (i7 & 32) != 0 ? null : insightsBlockingSessions, (i7 & 64) != 0 ? true : z7, (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0L : j3, (i7 & Function.MAX_NARGS) == 0 ? z8 : true, (i7 & 512) != 0 ? false : z9, (i7 & 1024) != 0 ? false : z10, (i7 & 2048) != 0 ? null : moodCheckInEntity, (i7 & 4096) != 0 ? false : z11, (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z12, (i7 & 16384) != 0 ? false : z13);
    }
}
