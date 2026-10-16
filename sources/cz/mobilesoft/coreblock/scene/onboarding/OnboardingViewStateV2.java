package cz.mobilesoft.coreblock.scene.onboarding;

import com.facebook.AccessTokenManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.intro.OnboardingAnswersDTO;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class OnboardingViewStateV2 implements ViewState {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Companion f111027u = new Companion(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Set f111028v = SetsKt.setOf((Object[]) new String[]{"statistics", "graph", "years_spent_splash", "years_spent", "your_potential", "crucial_week"});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PremiumState f111029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f111030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f111031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f111032d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f111033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Integer f111034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f111035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f111036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f111037j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final OnboardingVariant f111038k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ViewModelState f111039l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f111040m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final GraphData f111041n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List f111042o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f111043p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f111044q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final OnboardingFlowVariant f111045r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f111046s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Integer f111047t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnboardingVariant {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OnboardingVariant[] $VALUES;
        public static final Companion Companion;
        private final String type;
        public static final OnboardingVariant NoSkip = new OnboardingVariant("NoSkip", 0, "NoSkip");
        public static final OnboardingVariant PartialSkip = new OnboardingVariant("PartialSkip", 1, "PartialSkip");
        public static final OnboardingVariant FullSkip = new OnboardingVariant("FullSkip", 2, "FullSkip");

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final OnboardingVariant a(String type) {
                OnboardingVariant next;
                Intrinsics.checkNotNullParameter(type, "type");
                Iterator<OnboardingVariant> it = OnboardingVariant.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getType(), type)) {
                        break;
                    }
                }
                OnboardingVariant onboardingVariant = next;
                return onboardingVariant == null ? OnboardingVariant.NoSkip : onboardingVariant;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ OnboardingVariant[] $values() {
            return new OnboardingVariant[]{NoSkip, PartialSkip, FullSkip};
        }

        static {
            OnboardingVariant[] onboardingVariantArr$values = $values();
            $VALUES = onboardingVariantArr$values;
            $ENTRIES = EnumEntriesKt.a(onboardingVariantArr$values);
            Companion = new Companion(null);
        }

        private OnboardingVariant(String str, int i3, String str2) {
            this.type = str2;
        }

        public static EnumEntries<OnboardingVariant> getEntries() {
            return $ENTRIES;
        }

        public static OnboardingVariant valueOf(String str) {
            return (OnboardingVariant) Enum.valueOf(OnboardingVariant.class, str);
        }

        public static OnboardingVariant[] values() {
            return (OnboardingVariant[]) $VALUES.clone();
        }

        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TopApp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f111048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f111049b;

        public TopApp(String packageName, long j3) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.f111048a = packageName;
            this.f111049b = j3;
        }

        public final long a() {
            return this.f111049b;
        }

        public final String b() {
            return this.f111048a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TopApp)) {
                return false;
            }
            TopApp topApp = (TopApp) obj;
            return Intrinsics.areEqual(this.f111048a, topApp.f111048a) && this.f111049b == topApp.f111049b;
        }

        public int hashCode() {
            return (this.f111048a.hashCode() * 31) + Long.hashCode(this.f111049b);
        }

        public String toString() {
            return "TopApp(packageName=" + this.f111048a + ", duration=" + this.f111049b + ")";
        }
    }

    public OnboardingViewStateV2(PremiumState premiumState, boolean z2, boolean z3, boolean z4, Integer num, Integer num2, long j3, long j4, List recommendedApps, OnboardingVariant onboardingVariant, ViewModelState appUsageState, List appsWebsList, GraphData graphData, List appData, boolean z5, boolean z6, OnboardingFlowVariant onboardingFlowVariant, boolean z7) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(recommendedApps, "recommendedApps");
        Intrinsics.checkNotNullParameter(onboardingVariant, "onboardingVariant");
        Intrinsics.checkNotNullParameter(appUsageState, "appUsageState");
        Intrinsics.checkNotNullParameter(appsWebsList, "appsWebsList");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(onboardingFlowVariant, "onboardingFlowVariant");
        this.f111029a = premiumState;
        this.f111030b = z2;
        this.f111031c = z3;
        this.f111032d = z4;
        this.f111033f = num;
        this.f111034g = num2;
        this.f111035h = j3;
        this.f111036i = j4;
        this.f111037j = recommendedApps;
        this.f111038k = onboardingVariant;
        this.f111039l = appUsageState;
        this.f111040m = appsWebsList;
        this.f111041n = graphData;
        this.f111042o = appData;
        this.f111043p = z5;
        this.f111044q = z6;
        this.f111045r = onboardingFlowVariant;
        this.f111046s = z7;
        this.f111047t = num != null ? Integer.valueOf(num.intValue() * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS) : null;
    }

    public static /* synthetic */ OnboardingViewStateV2 b(OnboardingViewStateV2 onboardingViewStateV2, PremiumState premiumState, boolean z2, boolean z3, boolean z4, Integer num, Integer num2, long j3, long j4, List list, OnboardingVariant onboardingVariant, ViewModelState viewModelState, List list2, GraphData graphData, List list3, boolean z5, boolean z6, OnboardingFlowVariant onboardingFlowVariant, boolean z7, int i3, Object obj) {
        boolean z8;
        OnboardingFlowVariant onboardingFlowVariant2;
        PremiumState premiumState2 = (i3 & 1) != 0 ? onboardingViewStateV2.f111029a : premiumState;
        boolean z9 = (i3 & 2) != 0 ? onboardingViewStateV2.f111030b : z2;
        boolean z10 = (i3 & 4) != 0 ? onboardingViewStateV2.f111031c : z3;
        boolean z11 = (i3 & 8) != 0 ? onboardingViewStateV2.f111032d : z4;
        Integer num3 = (i3 & 16) != 0 ? onboardingViewStateV2.f111033f : num;
        Integer num4 = (i3 & 32) != 0 ? onboardingViewStateV2.f111034g : num2;
        long j5 = (i3 & 64) != 0 ? onboardingViewStateV2.f111035h : j3;
        long j6 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? onboardingViewStateV2.f111036i : j4;
        List list4 = (i3 & Function.MAX_NARGS) != 0 ? onboardingViewStateV2.f111037j : list;
        OnboardingVariant onboardingVariant2 = (i3 & 512) != 0 ? onboardingViewStateV2.f111038k : onboardingVariant;
        ViewModelState viewModelState2 = (i3 & 1024) != 0 ? onboardingViewStateV2.f111039l : viewModelState;
        List list5 = (i3 & 2048) != 0 ? onboardingViewStateV2.f111040m : list2;
        PremiumState premiumState3 = premiumState2;
        GraphData graphData2 = (i3 & 4096) != 0 ? onboardingViewStateV2.f111041n : graphData;
        List list6 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? onboardingViewStateV2.f111042o : list3;
        boolean z12 = (i3 & 16384) != 0 ? onboardingViewStateV2.f111043p : z5;
        boolean z13 = (i3 & 32768) != 0 ? onboardingViewStateV2.f111044q : z6;
        OnboardingFlowVariant onboardingFlowVariant3 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? onboardingViewStateV2.f111045r : onboardingFlowVariant;
        if ((i3 & 131072) != 0) {
            onboardingFlowVariant2 = onboardingFlowVariant3;
            z8 = onboardingViewStateV2.f111046s;
        } else {
            z8 = z7;
            onboardingFlowVariant2 = onboardingFlowVariant3;
        }
        return onboardingViewStateV2.a(premiumState3, z9, z10, z11, num3, num4, j5, j6, list4, onboardingVariant2, viewModelState2, list5, graphData2, list6, z12, z13, onboardingFlowVariant2, z8);
    }

    private final boolean v(String str) {
        if (Intrinsics.areEqual(str, "blocking_test")) {
            return this.f111043p;
        }
        return true;
    }

    public final OnboardingViewStateV2 a(PremiumState premiumState, boolean z2, boolean z3, boolean z4, Integer num, Integer num2, long j3, long j4, List recommendedApps, OnboardingVariant onboardingVariant, ViewModelState appUsageState, List appsWebsList, GraphData graphData, List appData, boolean z5, boolean z6, OnboardingFlowVariant onboardingFlowVariant, boolean z7) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(recommendedApps, "recommendedApps");
        Intrinsics.checkNotNullParameter(onboardingVariant, "onboardingVariant");
        Intrinsics.checkNotNullParameter(appUsageState, "appUsageState");
        Intrinsics.checkNotNullParameter(appsWebsList, "appsWebsList");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(onboardingFlowVariant, "onboardingFlowVariant");
        return new OnboardingViewStateV2(premiumState, z2, z3, z4, num, num2, j3, j4, recommendedApps, onboardingVariant, appUsageState, appsWebsList, graphData, appData, z5, z6, onboardingFlowVariant, z7);
    }

    public final String c() {
        Object next;
        List<String> screenOrder = this.f111045r.getScreenOrder();
        int iIndexOf = screenOrder.indexOf("stats_permission");
        if (iIndexOf == -1) {
            return "app_block_can_help_you";
        }
        Iterator<T> it = screenOrder.subList(iIndexOf + 1, screenOrder.size()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String str = (String) next;
            if (!f111028v.contains(str) && v(str)) {
                break;
            }
        }
        String str2 = (String) next;
        return str2 == null ? "app_block_can_help_you" : str2;
    }

    public final List d() {
        return this.f111042o;
    }

    public final ViewModelState e() {
        return this.f111039l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnboardingViewStateV2)) {
            return false;
        }
        OnboardingViewStateV2 onboardingViewStateV2 = (OnboardingViewStateV2) obj;
        return Intrinsics.areEqual(this.f111029a, onboardingViewStateV2.f111029a) && this.f111030b == onboardingViewStateV2.f111030b && this.f111031c == onboardingViewStateV2.f111031c && this.f111032d == onboardingViewStateV2.f111032d && Intrinsics.areEqual(this.f111033f, onboardingViewStateV2.f111033f) && Intrinsics.areEqual(this.f111034g, onboardingViewStateV2.f111034g) && this.f111035h == onboardingViewStateV2.f111035h && this.f111036i == onboardingViewStateV2.f111036i && Intrinsics.areEqual(this.f111037j, onboardingViewStateV2.f111037j) && this.f111038k == onboardingViewStateV2.f111038k && Intrinsics.areEqual(this.f111039l, onboardingViewStateV2.f111039l) && Intrinsics.areEqual(this.f111040m, onboardingViewStateV2.f111040m) && Intrinsics.areEqual(this.f111041n, onboardingViewStateV2.f111041n) && Intrinsics.areEqual(this.f111042o, onboardingViewStateV2.f111042o) && this.f111043p == onboardingViewStateV2.f111043p && this.f111044q == onboardingViewStateV2.f111044q && this.f111045r == onboardingViewStateV2.f111045r && this.f111046s == onboardingViewStateV2.f111046s;
    }

    public final List f() {
        return this.f111040m;
    }

    public final Integer g() {
        return this.f111033f;
    }

    public final int h() {
        if (this.f111047t == null) {
            return 0;
        }
        return (int) Math.abs((1 - (this.f111035h / r0.intValue())) * 100);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f111029a.hashCode() * 31) + Boolean.hashCode(this.f111030b)) * 31) + Boolean.hashCode(this.f111031c)) * 31) + Boolean.hashCode(this.f111032d)) * 31;
        Integer num = this.f111033f;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f111034g;
        int iHashCode3 = (((((((((((((iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + Long.hashCode(this.f111035h)) * 31) + Long.hashCode(this.f111036i)) * 31) + this.f111037j.hashCode()) * 31) + this.f111038k.hashCode()) * 31) + this.f111039l.hashCode()) * 31) + this.f111040m.hashCode()) * 31;
        GraphData graphData = this.f111041n;
        return ((((((((((iHashCode3 + (graphData != null ? graphData.hashCode() : 0)) * 31) + this.f111042o.hashCode()) * 31) + Boolean.hashCode(this.f111043p)) * 31) + Boolean.hashCode(this.f111044q)) * 31) + this.f111045r.hashCode()) * 31) + Boolean.hashCode(this.f111046s);
    }

    public final long i() {
        return this.f111035h;
    }

    public final long j() {
        return this.f111036i;
    }

    public final boolean k() {
        if (this.f111047t != null) {
            if (this.f111035h < r0.intValue()) {
                return true;
            }
        }
        return false;
    }

    public final OnboardingFlowVariant l() {
        return this.f111045r;
    }

    public final OnboardingVariant m() {
        return this.f111038k;
    }

    public final boolean n() {
        return this.f111044q;
    }

    public final boolean o() {
        return this.f111030b;
    }

    public final Map p() {
        List list = this.f111042o;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            AppDistractionType appDistractionTypeA = AppDistractionType.Companion.a(((AggregatedItemRecord) obj).a());
            Object arrayList = linkedHashMap.get(appDistractionTypeA);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(appDistractionTypeA, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            AppDistractionType appDistractionType = (AppDistractionType) entry.getKey();
            Pair pairA = appDistractionType != null ? TuplesKt.a(appDistractionType, (List) entry.getValue()) : null;
            if (pairA != null) {
                arrayList2.add(pairA);
            }
        }
        Map map = MapsKt.toMap(arrayList2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry2 : map.entrySet()) {
            Object key = entry2.getKey();
            List listTake = CollectionsKt.take(CollectionsKt.sortedWith((List) entry2.getValue(), new Comparator() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2$_get_topAppsByDistractionType_$lambda$2$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    return ComparisonsKt.d(Integer.valueOf(((AggregatedItemRecord) obj3).c()), Integer.valueOf(((AggregatedItemRecord) obj2).c()));
                }
            }), 3);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTake, 10));
            Iterator it = listTake.iterator();
            while (it.hasNext()) {
                arrayList3.add(new TopApp(((AggregatedItemRecord) it.next()).e(), r5.c()));
            }
            linkedHashMap2.put(key, arrayList3);
        }
        return linkedHashMap2;
    }

    public final GraphData q() {
        return this.f111041n;
    }

    public final boolean r() {
        return this.f111046s;
    }

    public final boolean s() {
        return this.f111031c;
    }

    public final String t(String currentRoute) {
        Object next;
        Intrinsics.checkNotNullParameter(currentRoute, "currentRoute");
        List<String> screenOrder = this.f111045r.getScreenOrder();
        int iIndexOf = screenOrder.indexOf(currentRoute);
        if (iIndexOf == -1) {
            return "first_focus_splash";
        }
        Iterator<T> it = screenOrder.subList(iIndexOf + 1, screenOrder.size()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (v((String) next)) {
                break;
            }
        }
        String str = (String) next;
        return str == null ? "first_focus_splash" : str;
    }

    public String toString() {
        return "OnboardingViewStateV2(premiumState=" + this.f111029a + ", skipLogin=" + this.f111030b + ", isUserSignedIn=" + this.f111031c + ", showHearAboutUsScreen=" + this.f111032d + ", dailyHoursGuess=" + this.f111033f + ", dailyUnlocksGuess=" + this.f111034g + ", dailySeconds=" + this.f111035h + ", dailyUnlocks=" + this.f111036i + ", recommendedApps=" + this.f111037j + ", onboardingVariant=" + this.f111038k + ", appUsageState=" + this.f111039l + ", appsWebsList=" + this.f111040m + ", weeklyGraphData=" + this.f111041n + ", appData=" + this.f111042o + ", showOnboardingBlockingTest=" + this.f111043p + ", showOnboardingHardPaywall=" + this.f111044q + ", onboardingFlowVariant=" + this.f111045r + ", isRemoteConfigReady=" + this.f111046s + ")";
    }

    public final float u(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        int iIndexOf = this.f111045r.getScreenOrder().indexOf(route);
        if (iIndexOf == -1) {
            return 0.0f;
        }
        return iIndexOf / r0.size();
    }

    public final OnboardingAnswersDTO w() {
        Integer num = this.f111033f;
        int iIntValue = num != null ? num.intValue() : -1;
        Integer num2 = this.f111034g;
        return new OnboardingAnswersDTO(null, iIntValue, num2 != null ? num2.intValue() : -1, this.f111035h, this.f111036i, 1, null);
    }

    public /* synthetic */ OnboardingViewStateV2(PremiumState premiumState, boolean z2, boolean z3, boolean z4, Integer num, Integer num2, long j3, long j4, List list, OnboardingVariant onboardingVariant, ViewModelState viewModelState, List list2, GraphData graphData, List list3, boolean z5, boolean z6, OnboardingFlowVariant onboardingFlowVariant, boolean z7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(premiumState, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? false : z4, (i3 & 16) != 0 ? null : num, (i3 & 32) != 0 ? null : num2, (i3 & 64) != 0 ? 0L : j3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0 ? j4 : 0L, (i3 & Function.MAX_NARGS) != 0 ? CollectionsKt.emptyList() : list, (i3 & 512) != 0 ? OnboardingVariant.NoSkip : onboardingVariant, (i3 & 1024) != 0 ? Loading.f127895a : viewModelState, (i3 & 2048) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 4096) == 0 ? graphData : null, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? CollectionsKt.emptyList() : list3, (i3 & 16384) != 0 ? false : z5, (i3 & 32768) != 0 ? false : z6, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? OnboardingFlowVariant.Default : onboardingFlowVariant, (i3 & 131072) != 0 ? false : z7);
    }
}
