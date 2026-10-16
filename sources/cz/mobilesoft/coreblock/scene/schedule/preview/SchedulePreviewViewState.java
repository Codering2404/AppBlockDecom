package cz.mobilesoft.coreblock.scene.schedule.preview;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.dto.AddressHolder;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfigurationKt;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntity;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelper;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelperKt;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableSet;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

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
public final class SchedulePreviewViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileWithConfiguration f117578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProfileViewDTO f117579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f117580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f117581d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f117582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f117583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final PremiumState f117584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f117585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f117586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f117587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f117588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f117589m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f117590n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f117591o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final List f117592p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ScheduleViewState.MainCardSummaryData f117593q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final long f117594r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BlockingOption {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f117595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f117596b;

        public BlockingOption(int i3, int i4) {
            this.f117595a = i3;
            this.f117596b = i4;
        }

        public final int a() {
            return this.f117595a;
        }

        public final int b() {
            return this.f117596b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BlockingOption)) {
                return false;
            }
            BlockingOption blockingOption = (BlockingOption) obj;
            return this.f117595a == blockingOption.f117595a && this.f117596b == blockingOption.f117596b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f117595a) * 31) + Integer.hashCode(this.f117596b);
        }

        public String toString() {
            return "BlockingOption(iconRes=" + this.f117595a + ", titleResId=" + this.f117596b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f117597a = EnumEntriesKt.a(DayOfWeek.values());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class UsageLimitAggregate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f117607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f117608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final UsageLimit.PeriodType f117609c;

        public UsageLimitAggregate(long j3, long j4, UsageLimit.PeriodType periodType) {
            Intrinsics.checkNotNullParameter(periodType, "periodType");
            this.f117607a = j3;
            this.f117608b = j4;
            this.f117609c = periodType;
        }

        public final long a() {
            return this.f117607a;
        }

        public final UsageLimit.PeriodType b() {
            return this.f117609c;
        }

        public final long c() {
            return this.f117608b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UsageLimitAggregate)) {
                return false;
            }
            UsageLimitAggregate usageLimitAggregate = (UsageLimitAggregate) obj;
            return this.f117607a == usageLimitAggregate.f117607a && this.f117608b == usageLimitAggregate.f117608b && this.f117609c == usageLimitAggregate.f117609c;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f117607a) * 31) + Long.hashCode(this.f117608b)) * 31) + this.f117609c.hashCode();
        }

        public String toString() {
            return "UsageLimitAggregate(allowed=" + this.f117607a + ", used=" + this.f117608b + ", periodType=" + this.f117609c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f117610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f117611b;

        static {
            int[] iArr = new int[UsageLimit.PeriodType.values().length];
            try {
                iArr[UsageLimit.PeriodType.DAILY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f117610a = iArr;
            int[] iArr2 = new int[ProfileType.values().length];
            try {
                iArr2[ProfileType.COMBINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[ProfileType.TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ProfileType.LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProfileType.WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProfileType.USAGE_LIMIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ProfileType.LAUNCH_COUNT.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            f117611b = iArr2;
        }
    }

    public SchedulePreviewViewState(ProfileWithConfiguration profileWithConfiguration, ProfileViewDTO profileViewDTO, boolean z2, boolean z3, boolean z4, boolean z5, PremiumState premiumState, boolean z6, long j3, long j4, List pauseHistoryList, List allApplications, boolean z7, long j5, List aggregatedAppDataForSummary, ScheduleViewState.MainCardSummaryData mainCardSummaryData) {
        Profile profileP;
        ScheduleEmoji scheduleEmojiQ;
        ScheduleEmoji.EmojiColor color;
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(pauseHistoryList, "pauseHistoryList");
        Intrinsics.checkNotNullParameter(allApplications, "allApplications");
        Intrinsics.checkNotNullParameter(aggregatedAppDataForSummary, "aggregatedAppDataForSummary");
        this.f117578a = profileWithConfiguration;
        this.f117579b = profileViewDTO;
        this.f117580c = z2;
        this.f117581d = z3;
        this.f117582f = z4;
        this.f117583g = z5;
        this.f117584h = premiumState;
        this.f117585i = z6;
        this.f117586j = j3;
        this.f117587k = j4;
        this.f117588l = pauseHistoryList;
        this.f117589m = allApplications;
        this.f117590n = z7;
        this.f117591o = j5;
        this.f117592p = aggregatedAppDataForSummary;
        this.f117593q = mainCardSummaryData;
        this.f117594r = ((profileWithConfiguration == null || (profileP = profileWithConfiguration.p()) == null || (scheduleEmojiQ = profileP.q()) == null || (color = scheduleEmojiQ.getColor()) == null) ? ScheduleEmoji.EmojiColor.DeepPurple : color).m1358getColor0d7_KjU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(int i3, IntervalDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.b() > ((long) i3);
    }

    private final long O() {
        Calendar calendar = Calendar.getInstance();
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        calendar.setTimeInMillis(timeHelperExt.f());
        calendar.add(11, 1);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 1);
        return calendar.getTimeInMillis() - timeHelperExt.f();
    }

    public static /* synthetic */ int Q(SchedulePreviewViewState schedulePreviewViewState, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.c();
        }
        return schedulePreviewViewState.P(j3);
    }

    private final Long R(long j3) {
        Profile profileP;
        ProfileWithConfiguration profileWithConfiguration = this.f117578a;
        if (profileWithConfiguration != null && (profileP = profileWithConfiguration.p()) != null) {
            long jS = profileP.s();
            if (1 <= jS && jS < j3) {
                long millis = TimeUnit.MINUTES.toMillis(1L);
                long j4 = j3 - jS;
                Long lValueOf = Long.valueOf((((millis / ((long) 2)) + j4) / millis) * millis);
                long jLongValue = lValueOf.longValue();
                if (jLongValue > 0) {
                    long millis2 = TimeUnit.SECONDS.toMillis(2L);
                    long j5 = jLongValue - j4;
                    if (0 <= j5 && j5 <= millis2) {
                        return lValueOf;
                    }
                }
            }
        }
        return null;
    }

    private final UsageLimitAggregate b(ProfileWithConfiguration profileWithConfiguration, UsageLimit.LimitType limitType) {
        UsageLimit.PeriodType periodTypeK;
        List listR = profileWithConfiguration.r();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((UsageLimit) obj).i() == limitType) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        long jF = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            jF += ((UsageLimit) obj2).f();
        }
        int size2 = arrayList.size();
        long jM = 0;
        while (i3 < size2) {
            Object obj3 = arrayList.get(i3);
            i3++;
            jM += ((UsageLimit) obj3).m();
        }
        UsageLimit usageLimit = (UsageLimit) CollectionsKt.firstOrNull((List) arrayList);
        if (usageLimit == null || (periodTypeK = usageLimit.k()) == null) {
            periodTypeK = UsageLimit.PeriodType.DAILY;
        }
        return new UsageLimitAggregate(jF, jM, periodTypeK);
    }

    private final MainCardPreviewData c(Context context) {
        return new MainCardPreviewData("", context.getString(R.string.V7) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, CollectionsKt.listOf(""), 0, 0, null, false, null, true, 240, null);
    }

    private final MainCardPreviewData d(Context context) {
        String string = context.getString(R.string.f95863z);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new MainCardPreviewData(string, "", CollectionsKt.emptyList(), 0, 0, null, false, null, false, 496, null);
    }

    private final List e(IntervalDTO intervalDTO, long j3) {
        Context contextG = LockieApplication.g();
        Intrinsics.checkNotNull(contextG);
        return CollectionsKt.listOf((Object[]) new String[]{IntervalsHelper.a(contextG, intervalDTO.b()), IntervalsHelper.a(contextG, j3)});
    }

    private final MainCardPreviewData g(Context context) {
        IntervalDTO intervalDTOT;
        ProfileWithConfiguration profileWithConfiguration = this.f117578a;
        if (profileWithConfiguration == null || (intervalDTOT = t(profileWithConfiguration)) == null) {
            return null;
        }
        List listE = e(intervalDTOT, s(intervalDTOT));
        String string = context.getString(R.string.Iq);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new MainCardPreviewData(string, StringHelperExtKt.g((AddressHolder) CollectionsKt.first(profileWithConfiguration.k())), listE, 0, 0, null, false, null, false, 496, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [int] */
    /* JADX WARN: Type inference failed for: r19v2 */
    private final MainCardPreviewData h(Context context) {
        String strJ;
        String strF;
        ?? r19;
        ProfileViewDTO profileViewDTO = this.f117579b;
        if (profileViewDTO == null || !profileViewDTO.z()) {
            return null;
        }
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        long jF = timeHelperExt.f();
        long jA = profileViewDTO.l().a();
        long jG = RangesKt.g(jA - jF, 0L);
        boolean zAreEqual = Intrinsics.areEqual(Instant.ofEpochMilli(jA).atZone(ZoneId.systemDefault()).toLocalDate(), Instant.ofEpochMilli(jF).atZone(ZoneId.systemDefault()).toLocalDate());
        String string = "";
        float fO = 0.0f;
        if (this.f117588l.isEmpty()) {
            Context contextG = LockieApplication.g();
            Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
            strJ = TimeHelperExt.j(timeHelperExt, contextG, jA, true, false, 8, null);
            strF = "";
            r19 = 0;
        } else {
            SchedulePauseHistoryEntity schedulePauseHistoryEntity = (SchedulePauseHistoryEntity) CollectionsKt.last(this.f117588l);
            fO = RangesKt.o(jG / (((long) schedulePauseHistoryEntity.b()) * 1000), 0.0f, 1.0f);
            if (zAreEqual) {
                strJ = DateHelper.e(TimeUnit.MILLISECONDS.toSeconds(jG));
                Intrinsics.checkNotNull(strJ);
            } else {
                Context contextG2 = LockieApplication.g();
                Intrinsics.checkNotNullExpressionValue(contextG2, "getContext(...)");
                strJ = TimeHelperExt.j(timeHelperExt, contextG2, jA, true, false, 8, null);
            }
            strF = DateHelperExtKt.f(schedulePauseHistoryEntity.b(), false, false, false, 14, null);
            r19 = zAreEqual;
        }
        if (!this.f117579b.B()) {
            string = context.getString(R.string.Bn);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        String str = string;
        if (this.f117579b.B()) {
            strJ = context.getString(R.string.kc);
        }
        String str2 = strJ;
        Intrinsics.checkNotNull(str2);
        return new MainCardPreviewData(str, str2, CollectionsKt.listOf((Object[]) new String[]{LockieApplication.g().getString(R.string.Oj, 0), strF}), r19, 0, Float.valueOf(fO), false, null, false, 464, null);
    }

    private final MainCardPreviewData i(Context context) {
        MainCardPreviewData mainCardPreviewDataH = h(context);
        return (mainCardPreviewDataH == null && (mainCardPreviewDataH = j(context)) == null && (mainCardPreviewDataH = l(context)) == null) ? d(context) : mainCardPreviewDataH;
    }

    private final MainCardPreviewData j(Context context) {
        ProfileType profileTypeZ = z();
        switch (profileTypeZ == null ? -1 : WhenMappings.f117611b[profileTypeZ.ordinal()]) {
            case 1:
                return c(context);
            case 2:
                return m(context);
            case 3:
                return g(context);
            case 4:
                return o(context);
            case 5:
                return n(context);
            case 6:
                return f(context);
            default:
                return null;
        }
    }

    private final String k(Context context, long j3, UsageLimit.PeriodType periodType) {
        if (j3 > 0) {
            String string = context.getString(periodType.getDescriptionResId());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return StringHelperExtKt.e(string);
        }
        if (WhenMappings.f117610a[periodType.ordinal()] == 1) {
            String string2 = context.getString(R.string.As);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        String string3 = context.getString(R.string.zs, DateHelperExtKt.f(TimeUnit.MILLISECONDS.toSeconds(O()), false, false, false, 14, null));
        Intrinsics.checkNotNull(string3);
        return string3;
    }

    private final MainCardPreviewData l(Context context) {
        Long lM;
        ProfileViewDTO profileViewDTO = this.f117579b;
        if (profileViewDTO == null || (lM = profileViewDTO.M()) == null) {
            return null;
        }
        long jLongValue = lM.longValue();
        long jG = RangesKt.g(jLongValue - TimeHelperExt.f128663a.f(), 0L);
        Long lR = R(jLongValue);
        String string = context.getString(R.string.ps);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        String strF = DateHelperExtKt.f(timeUnit.toSeconds(jG), true, true, false, 8, null);
        String string2 = context.getString(R.string.Oj, 0);
        String strF2 = lR != null ? DateHelperExtKt.f(timeUnit.toSeconds(lR.longValue()), false, false, false, 14, null) : null;
        if (strF2 == null) {
            strF2 = "";
        }
        return new MainCardPreviewData(string, strF, CollectionsKt.listOf((Object[]) new String[]{string2, strF2}), lR != null ? 1 : 0, 0, Float.valueOf(lR != null ? RangesKt.o(jG / lR.longValue(), 0.0f, 1.0f) : 0.0f), false, null, false, 464, null);
    }

    private final MainCardPreviewData m(Context context) {
        List listListOf;
        String strA;
        ProfileWithConfiguration profileWithConfiguration = this.f117578a;
        if (profileWithConfiguration == null) {
            return null;
        }
        List listJ = DayFlags.Companion.j(profileWithConfiguration.p().p());
        IntervalDTO intervalDTOT = t(profileWithConfiguration);
        if (intervalDTOT == null) {
            return null;
        }
        long jS = s(intervalDTOT);
        if (listJ.size() == 7 && intervalDTOT.g()) {
            String string = context.getString(R.string.f95863z);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = context.getString(R.string.gl);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return new MainCardPreviewData(string, string2, CollectionsKt.emptyList(), 0, 0, null, false, null, false, 496, null);
        }
        Context contextG = LockieApplication.g();
        Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
        String strA2 = IntervalsHelper.a(contextG, jS);
        boolean z2 = listJ.size() > 1 && IntervalsHelperKt.k(intervalDTOT);
        if (z2) {
            List list = listJ;
            listListOf = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String strF = ((DayFlags) it.next()).getDayOfWeek().f(TextStyle.SHORT_STANDALONE, Locale.getDefault());
                Intrinsics.checkNotNullExpressionValue(strF, "getDisplayName(...)");
                listListOf.add(StringHelperExtKt.c(StringsKt.B1(strF, 3)));
            }
        } else {
            Context contextG2 = LockieApplication.g();
            Intrinsics.checkNotNullExpressionValue(contextG2, "getContext(...)");
            String strA3 = IntervalsHelper.a(contextG2, intervalDTOT.b());
            if (intervalDTOT.b() > intervalDTOT.a()) {
                String string3 = context.getString(R.string.TD);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                strA2 = StringHelperExtKt.q(string3, strA2, null, 2, null);
            }
            listListOf = CollectionsKt.listOf((Object[]) new String[]{strA3, strA2});
        }
        List list2 = listListOf;
        String string4 = IntervalsHelperKt.k(intervalDTOT) ? context.getString(R.string.f95863z) : context.getString(R.string.J, "");
        Intrinsics.checkNotNull(string4);
        if (IntervalsHelperKt.k(intervalDTOT)) {
            strA = context.getString(R.string.f95827o0);
        } else {
            Context contextG3 = LockieApplication.g();
            Intrinsics.checkNotNullExpressionValue(contextG3, "getContext(...)");
            strA = IntervalsHelper.a(contextG3, intervalDTOT.a());
        }
        String str = strA;
        Intrinsics.checkNotNull(str);
        float fP = p(intervalDTOT);
        return new MainCardPreviewData(string4, str, list2, z2 ? listJ.size() : 1, listJ.indexOf(DayFlags.Companion.d()), Float.valueOf(fP), z2, null, false, 384, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState.MainCardPreviewData o(android.content.Context r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r2 = r0.f117578a
            r3 = 0
            if (r2 != 0) goto La
            return r3
        La:
            cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO r2 = r0.t(r2)
            if (r2 != 0) goto L11
            return r3
        L11:
            long r3 = r0.s(r2)
            java.util.List r8 = r0.e(r2, r3)
            android.content.Context r2 = cz.mobilesoft.coreblock.LockieApplication.g()
            java.lang.String r3 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r2 = cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.w(r2)
            int r3 = cz.mobilesoft.coreblock.R.string.Mq
            java.lang.String r6 = r1.getString(r3)
            java.lang.String r4 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            if (r2 == 0) goto L4c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "\""
            r5.append(r7)
            r5.append(r2)
            r5.append(r7)
            java.lang.String r2 = r5.toString()
            if (r2 != 0) goto L4a
            goto L4c
        L4a:
            r7 = r2
            goto L54
        L4c:
            java.lang.String r2 = r1.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            goto L4a
        L54:
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState$MainCardPreviewData r5 = new cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState$MainCardPreviewData
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 496(0x1f0, float:6.95E-43)
            r16 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState.o(android.content.Context):cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState$MainCardPreviewData");
    }

    private final long s(IntervalDTO intervalDTO) {
        if (IntervalsHelperKt.k(intervalDTO)) {
            return 1439L;
        }
        return intervalDTO.a();
    }

    public final boolean A() {
        return this.f117590n;
    }

    public final String B(Context context, ProfileWithConfiguration profileWithConfiguration) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profileWithConfiguration, "profileWithConfiguration");
        EnumEntries enumEntries = EntriesMappings.f117597a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : enumEntries) {
            if ((DayFlags.Companion.b((DayOfWeek) obj).getValue() & profileWithConfiguration.p().p()) != 0) {
                arrayList.add(obj);
            }
        }
        ImmutableSet immutableSetJ = ExtensionsKt.j(arrayList);
        List<Interval> listN = IntervalsHelperKt.n(profileWithConfiguration.l());
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listN, 10));
        for (Interval interval : listN) {
            arrayList2.add(new IntervalDTO(interval.b(), interval.a(), null, null, 12, null));
        }
        ImmutableList immutableListH = ExtensionsKt.h(arrayList2);
        List listL = profileWithConfiguration.l();
        boolean z2 = false;
        if (!(listL instanceof Collection) || !listL.isEmpty()) {
            Iterator it = listL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (IntervalsHelperKt.k((Interval) it.next())) {
                    z2 = true;
                    break;
                }
            }
        }
        Configuration configuration = new Configuration(immutableSetJ, null, immutableListH, z2, false, 18, null);
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(TimeHelperExt.c()), ZoneId.systemDefault());
        DayOfWeek dayOfWeekL = DayOfWeek.l(localDateTimeOfInstant.getDayOfWeek().getValue());
        Intrinsics.checkNotNullExpressionValue(dayOfWeekL, "of(...)");
        if (!configuration.k().contains(dayOfWeekL)) {
            String string = context.getString(R.string.hl);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = context.getString(R.string.SD);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return StringHelperExtKt.q(string, StringHelperExtKt.e(string2), null, 2, null);
        }
        final int hour = (localDateTimeOfInstant.getHour() * 60) + localDateTimeOfInstant.getMinute();
        Iterator it2 = SequencesKt.A(CollectionsKt.asSequence(configuration.e()), new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.v2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(SchedulePreviewViewState.C(hour, (IntervalDTO) obj2));
            }
        }).iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                long jB = ((IntervalDTO) next).b();
                do {
                    Object next2 = it2.next();
                    long jB2 = ((IntervalDTO) next2).b();
                    if (jB > jB2) {
                        next = next2;
                        jB = jB2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        IntervalDTO intervalDTO = (IntervalDTO) next;
        if (intervalDTO != null) {
            String string3 = context.getString(R.string.dA, DateHelper.c(Long.valueOf(TimeUnit.MINUTES.toSeconds(intervalDTO.b() - ((long) hour)))));
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        String string4 = context.getString(R.string.hl);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = context.getString(R.string.SD);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        return StringHelperExtKt.q(string4, StringHelperExtKt.e(string5), null, 2, null);
    }

    public final List D() {
        return this.f117588l;
    }

    public final PremiumState E() {
        return this.f117584h;
    }

    public final boolean F() {
        return this.f117582f;
    }

    public final boolean G() {
        return this.f117583g;
    }

    public final ProfileViewDTO H() {
        return this.f117579b;
    }

    public final ProfileWithConfiguration I() {
        return this.f117578a;
    }

    public final long J() {
        return this.f117586j;
    }

    public final ScheduleViewState.MainCardSummaryData K() {
        return this.f117593q;
    }

    public final boolean L() {
        return this.f117580c;
    }

    public final boolean M() {
        return this.f117581d;
    }

    public final boolean N() {
        return this.f117585i;
    }

    public final int P(long j3) {
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(j3), ZoneId.systemDefault());
        return (localDateTimeOfInstant.getHour() * 60) + localDateTimeOfInstant.getMinute();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchedulePreviewViewState)) {
            return false;
        }
        SchedulePreviewViewState schedulePreviewViewState = (SchedulePreviewViewState) obj;
        return Intrinsics.areEqual(this.f117578a, schedulePreviewViewState.f117578a) && Intrinsics.areEqual(this.f117579b, schedulePreviewViewState.f117579b) && this.f117580c == schedulePreviewViewState.f117580c && this.f117581d == schedulePreviewViewState.f117581d && this.f117582f == schedulePreviewViewState.f117582f && this.f117583g == schedulePreviewViewState.f117583g && Intrinsics.areEqual(this.f117584h, schedulePreviewViewState.f117584h) && this.f117585i == schedulePreviewViewState.f117585i && this.f117586j == schedulePreviewViewState.f117586j && this.f117587k == schedulePreviewViewState.f117587k && Intrinsics.areEqual(this.f117588l, schedulePreviewViewState.f117588l) && Intrinsics.areEqual(this.f117589m, schedulePreviewViewState.f117589m) && this.f117590n == schedulePreviewViewState.f117590n && this.f117591o == schedulePreviewViewState.f117591o && Intrinsics.areEqual(this.f117592p, schedulePreviewViewState.f117592p) && Intrinsics.areEqual(this.f117593q, schedulePreviewViewState.f117593q);
    }

    public final MainCardPreviewData f(Context context) {
        UsageLimitAggregate usageLimitAggregateB;
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        ProfileWithConfiguration profileWithConfiguration = this.f117578a;
        if (profileWithConfiguration == null || (usageLimitAggregateB = b(profileWithConfiguration, UsageLimit.LimitType.LAUNCH_COUNT)) == null) {
            return null;
        }
        long jA = usageLimitAggregateB.a() - usageLimitAggregateB.c();
        String strK = k(context, jA, usageLimitAggregateB.b());
        String string2 = jA > 0 ? context.getString(R.string.ps) : context.getString(R.string.Bi);
        Intrinsics.checkNotNull(string2);
        if (jA > 0) {
            int i3 = (int) jA;
            string = context.getResources().getQuantityString(R.plurals.f95752m, i3, Integer.valueOf(i3));
        } else {
            string = context.getString(R.string.q3);
        }
        String str = string;
        Intrinsics.checkNotNull(str);
        boolean zD = ComparableExtKt.d(Integer.valueOf((int) usageLimitAggregateB.a()), 15);
        return new MainCardPreviewData(string2, str, CollectionsKt.listOf((Object[]) new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(usageLimitAggregateB.a())}), zD ? (int) usageLimitAggregateB.a() : 1, zD ? ((int) jA) - 1 : jA <= 0 ? -1 : 0, Float.valueOf(zD ? 1.0f : RangesKt.o(jA / usageLimitAggregateB.a(), 0.0f, 1.0f)), false, strK, false, 320, null);
    }

    public int hashCode() {
        ProfileWithConfiguration profileWithConfiguration = this.f117578a;
        int iHashCode = (profileWithConfiguration == null ? 0 : profileWithConfiguration.hashCode()) * 31;
        ProfileViewDTO profileViewDTO = this.f117579b;
        int iHashCode2 = (((((((((((((((((((((((((((iHashCode + (profileViewDTO == null ? 0 : profileViewDTO.hashCode())) * 31) + Boolean.hashCode(this.f117580c)) * 31) + Boolean.hashCode(this.f117581d)) * 31) + Boolean.hashCode(this.f117582f)) * 31) + Boolean.hashCode(this.f117583g)) * 31) + this.f117584h.hashCode()) * 31) + Boolean.hashCode(this.f117585i)) * 31) + Long.hashCode(this.f117586j)) * 31) + Long.hashCode(this.f117587k)) * 31) + this.f117588l.hashCode()) * 31) + this.f117589m.hashCode()) * 31) + Boolean.hashCode(this.f117590n)) * 31) + Long.hashCode(this.f117591o)) * 31) + this.f117592p.hashCode()) * 31;
        ScheduleViewState.MainCardSummaryData mainCardSummaryData = this.f117593q;
        return iHashCode2 + (mainCardSummaryData != null ? mainCardSummaryData.hashCode() : 0);
    }

    public final MainCardPreviewData n(Context context) {
        UsageLimitAggregate usageLimitAggregateB;
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        ProfileWithConfiguration profileWithConfiguration = this.f117578a;
        if (profileWithConfiguration == null || (usageLimitAggregateB = b(profileWithConfiguration, UsageLimit.LimitType.TIME)) == null) {
            return null;
        }
        long jA = usageLimitAggregateB.a() - usageLimitAggregateB.c();
        if (jA > 0) {
            string = DateHelperExtKt.f(TimeUnit.MILLISECONDS.toSeconds(jA), true, true, false, 8, null);
        } else {
            string = context.getString(R.string.q3);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        String str = string;
        String strK = k(context, jA, usageLimitAggregateB.b());
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{DateHelperExtKt.f(0L, false, false, false, 14, null), DateHelperExtKt.f(TimeUnit.MILLISECONDS.toSeconds(usageLimitAggregateB.a()), false, false, false, 14, null)});
        float fO = usageLimitAggregateB.a() != 0 ? RangesKt.o(jA / usageLimitAggregateB.a(), 0.0f, 1.0f) : 0.0f;
        int i3 = jA <= 0 ? -1 : 0;
        String string2 = context.getString(jA > 0 ? R.string.ps : R.string.JF);
        Intrinsics.checkNotNull(string2);
        return new MainCardPreviewData(string2, str, listListOf, 1, i3, Float.valueOf(fO), false, strK, false, 320, null);
    }

    public final float p(IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        int iQ = Q(this, 0L, 1, null);
        long jB = interval.b();
        if (jB <= interval.a()) {
            return (((long) RangesKt.p(iQ, (int) jB, (int) r3)) - jB) / RangesKt.g(r3 - jB, 1L);
        }
        long j3 = ((long) 1440) - jB;
        return RangesKt.o((iQ >= jB ? r7 - jB : r7 + j3) / (r3 + j3), 0.0f, 1.0f);
    }

    public final SchedulePreviewViewState q(ProfileWithConfiguration profileWithConfiguration, ProfileViewDTO profileViewDTO, boolean z2, boolean z3, boolean z4, boolean z5, PremiumState premiumState, boolean z6, long j3, long j4, List pauseHistoryList, List allApplications, boolean z7, long j5, List aggregatedAppDataForSummary, ScheduleViewState.MainCardSummaryData mainCardSummaryData) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(pauseHistoryList, "pauseHistoryList");
        Intrinsics.checkNotNullParameter(allApplications, "allApplications");
        Intrinsics.checkNotNullParameter(aggregatedAppDataForSummary, "aggregatedAppDataForSummary");
        return new SchedulePreviewViewState(profileWithConfiguration, profileViewDTO, z2, z3, z4, z5, premiumState, z6, j3, j4, pauseHistoryList, allApplications, z7, j5, aggregatedAppDataForSummary, mainCardSummaryData);
    }

    public final IntervalDTO t(ProfileWithConfiguration profileWithConfiguration) {
        Intrinsics.checkNotNullParameter(profileWithConfiguration, "profileWithConfiguration");
        Configuration configurationD = ProfileWithConfigurationKt.d(profileWithConfiguration);
        return configurationD.d(configurationD.e());
    }

    public final List u() {
        return this.f117592p;
    }

    public final List v() {
        return this.f117589m;
    }

    public final long w() {
        return this.f117591o;
    }

    public final long x() {
        return this.f117594r;
    }

    public final MainCardPreviewData y(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return i(context);
    }

    public final ProfileType z() {
        Object next;
        Profile profileP;
        ProfileType.Companion companion = ProfileType.Companion;
        ProfileWithConfiguration profileWithConfiguration = this.f117578a;
        List listB = companion.b((profileWithConfiguration == null || (profileP = profileWithConfiguration.p()) == null) ? 0 : profileP.E());
        if (listB.isEmpty()) {
            return null;
        }
        List list = listB;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ProfileType) obj) != ProfileType.TIME) {
                arrayList.add(obj);
            }
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ProfileType) next) == ProfileType.TIME) {
                break;
            }
        }
        ProfileType profileType = (ProfileType) next;
        if (arrayList.size() > 1) {
            return ProfileType.COMBINED;
        }
        if (arrayList.isEmpty() && profileType != null) {
            return profileType;
        }
        if (arrayList.size() != 1 || profileType == null) {
            return null;
        }
        return (ProfileType) CollectionsKt.firstOrNull((List) arrayList);
    }

    public String toString() {
        return "SchedulePreviewViewState(profileWithConfiguration=" + this.f117578a + ", profileViewDTO=" + this.f117579b + ", isLockedNotByStrictMode=" + this.f117580c + ", isPauseEnabled=" + this.f117581d + ", profileCreatingAllowed=" + this.f117582f + ", profileEnablingAllowed=" + this.f117583g + ", premiumState=" + this.f117584h + ", isStrictModeActive=" + this.f117585i + ", remainingPausedTime=" + this.f117586j + ", remainingTemporaryActiveTime=" + this.f117587k + ", pauseHistoryList=" + this.f117588l + ", allApplications=" + this.f117589m + FptyjHFU.Rmh + this.f117590n + ", cooldownEndTime=" + this.f117591o + ", aggregatedAppDataForSummary=" + this.f117592p + ", summaryMainCardData=" + this.f117593q + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MainCardPreviewData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f117598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f117599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f117600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f117601d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f117602e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Float f117603f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f117604g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f117605h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f117606i;

        public MainCardPreviewData(String title, String subtitle, List labels, int i3, int i4, Float f3, boolean z2, String str, boolean z3) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics.checkNotNullParameter(labels, "labels");
            this.f117598a = title;
            this.f117599b = subtitle;
            this.f117600c = labels;
            this.f117601d = i3;
            this.f117602e = i4;
            this.f117603f = f3;
            this.f117604g = z2;
            this.f117605h = str;
            this.f117606i = z3;
        }

        public final int a() {
            return this.f117602e;
        }

        public final boolean b() {
            return this.f117604g;
        }

        public final List c() {
            return this.f117600c;
        }

        public final Float d() {
            return this.f117603f;
        }

        public final int e() {
            return this.f117601d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MainCardPreviewData)) {
                return false;
            }
            MainCardPreviewData mainCardPreviewData = (MainCardPreviewData) obj;
            return Intrinsics.areEqual(this.f117598a, mainCardPreviewData.f117598a) && Intrinsics.areEqual(this.f117599b, mainCardPreviewData.f117599b) && Intrinsics.areEqual(this.f117600c, mainCardPreviewData.f117600c) && this.f117601d == mainCardPreviewData.f117601d && this.f117602e == mainCardPreviewData.f117602e && Intrinsics.areEqual((Object) this.f117603f, (Object) mainCardPreviewData.f117603f) && this.f117604g == mainCardPreviewData.f117604g && Intrinsics.areEqual(this.f117605h, mainCardPreviewData.f117605h) && this.f117606i == mainCardPreviewData.f117606i;
        }

        public final String f() {
            return this.f117599b;
        }

        public final String g() {
            return this.f117605h;
        }

        public final String h() {
            return this.f117598a;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.f117598a.hashCode() * 31) + this.f117599b.hashCode()) * 31) + this.f117600c.hashCode()) * 31) + Integer.hashCode(this.f117601d)) * 31) + Integer.hashCode(this.f117602e)) * 31;
            Float f3 = this.f117603f;
            int iHashCode2 = (((iHashCode + (f3 == null ? 0 : f3.hashCode())) * 31) + Boolean.hashCode(this.f117604g)) * 31;
            String str = this.f117605h;
            return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.f117606i);
        }

        public final boolean i() {
            return this.f117606i;
        }

        public String toString() {
            return "MainCardPreviewData(title=" + this.f117598a + ", subtitle=" + this.f117599b + ", labels=" + this.f117600c + ", sessionsCount=" + this.f117601d + ", activeIndex=" + this.f117602e + ", progressFraction=" + this.f117603f + ", areLabelsCentered=" + this.f117604g + ", timeDescription=" + this.f117605h + ", isCombineProfile=" + this.f117606i + ")";
        }

        public /* synthetic */ MainCardPreviewData(String str, String str2, List list, int i3, int i4, Float f3, boolean z2, String str3, boolean z3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, list, i3, (i5 & 16) != 0 ? 0 : i4, (i5 & 32) != 0 ? null : f3, (i5 & 64) != 0 ? false : z2, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str3, (i5 & Function.MAX_NARGS) != 0 ? false : z3);
        }
    }

    public /* synthetic */ SchedulePreviewViewState(ProfileWithConfiguration profileWithConfiguration, ProfileViewDTO profileViewDTO, boolean z2, boolean z3, boolean z4, boolean z5, PremiumState premiumState, boolean z6, long j3, long j4, List list, List list2, boolean z7, long j5, List list3, ScheduleViewState.MainCardSummaryData mainCardSummaryData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : profileWithConfiguration, (i3 & 2) != 0 ? null : profileViewDTO, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? false : z3, (i3 & 16) != 0 ? false : z4, (i3 & 32) != 0 ? false : z5, (i3 & 64) != 0 ? PremiumState.None.INSTANCE : premiumState, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z6, (i3 & Function.MAX_NARGS) != 0 ? 0L : j3, (i3 & 512) != 0 ? 0L : j4, (i3 & 1024) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2048) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 4096) != 0 ? false : z7, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0L : j5, (i3 & 16384) != 0 ? CollectionsKt.emptyList() : list3, (i3 & 32768) != 0 ? null : mainCardSummaryData);
    }
}
