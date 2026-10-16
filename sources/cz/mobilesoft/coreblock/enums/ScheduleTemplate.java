package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelperKt;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class ScheduleTemplate {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScheduleTemplate[] $VALUES;
    public static final ScheduleTemplate AppLimit;
    public static final ScheduleTemplate AtHome;
    public static final ScheduleTemplate BackToSchool;
    public static final ScheduleTemplate BlackFriday;
    public static final Companion Companion;
    public static final ScheduleTemplate DigitalDetox;
    public static final ScheduleTemplate Focus;
    public static final ScheduleTemplate MindfulMorning;
    public static final ScheduleTemplate NewYear;
    public static final ScheduleTemplate SpringRefresh;
    public static final ScheduleTemplate StudyTime;
    public static final ScheduleTemplate SummerVacation;
    public static final ScheduleTemplate TimeForMyself;
    public static final ScheduleTemplate WindDown;
    private final String analyticsKey;
    private final int dayFlags;
    private final Integer description;
    private final ScheduleEmoji emoji;
    private final boolean hasLocation;
    private final Interval interval;
    private final Integer seasonalSubtitle;
    private final SeasonalTemplateColors seasonalTemplateColor;
    private final String seasonalTemplateId;
    private final Integer seasonalTitle;
    private final int stateIcon;
    private final int title;
    private final Long usageLimitInMinutes;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ScheduleTemplate a(String templateId) {
            ScheduleTemplate next;
            Intrinsics.checkNotNullParameter(templateId, "templateId");
            Iterator<ScheduleTemplate> it = ScheduleTemplate.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getSeasonalTemplateId(), templateId)) {
                    break;
                }
            }
            return next;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ScheduleTemplate[] $values() {
        return new ScheduleTemplate[]{BackToSchool, BlackFriday, NewYear, SpringRefresh, SummerVacation, Focus, AppLimit, TimeForMyself, AtHome, StudyTime, DigitalDetox, WindDown, MindfulMorning};
    }

    private ScheduleTemplate(String str, int i3, int i4, Integer num, int i5, int i6, ScheduleEmoji scheduleEmoji, Interval interval, Long l3, boolean z2, String str2, String str3, Integer num2, Integer num3, SeasonalTemplateColors seasonalTemplateColors) {
        this.title = i4;
        this.description = num;
        this.stateIcon = i5;
        this.dayFlags = i6;
        this.emoji = scheduleEmoji;
        this.interval = interval;
        this.usageLimitInMinutes = l3;
        this.hasLocation = z2;
        this.analyticsKey = str2;
        this.seasonalTemplateId = str3;
        this.seasonalTitle = num2;
        this.seasonalSubtitle = num3;
        this.seasonalTemplateColor = seasonalTemplateColors;
    }

    public static EnumEntries<ScheduleTemplate> getEntries() {
        return $ENTRIES;
    }

    public static ScheduleTemplate valueOf(String str) {
        return (ScheduleTemplate) Enum.valueOf(ScheduleTemplate.class, str);
    }

    public static ScheduleTemplate[] values() {
        return (ScheduleTemplate[]) $VALUES.clone();
    }

    public final String getAnalyticsKey() {
        return this.analyticsKey;
    }

    public final int getDayFlags() {
        return this.dayFlags;
    }

    public final Integer getDescription() {
        return this.description;
    }

    public final ScheduleEmoji getEmoji() {
        return this.emoji;
    }

    public final boolean getHasLocation() {
        return this.hasLocation;
    }

    public final Interval getInterval() {
        return this.interval;
    }

    public final Integer getSeasonalSubtitle() {
        return this.seasonalSubtitle;
    }

    public final SeasonalTemplateColors getSeasonalTemplateColor() {
        return this.seasonalTemplateColor;
    }

    public final String getSeasonalTemplateId() {
        return this.seasonalTemplateId;
    }

    public final Integer getSeasonalTitle() {
        return this.seasonalTitle;
    }

    public final int getStateIcon() {
        return this.stateIcon;
    }

    public final String getStateString(Context context) {
        String strD;
        String strP;
        Intrinsics.checkNotNullParameter(context, "context");
        String strI = DayFlags.Companion.i(context, this.dayFlags, false);
        if (strI == null) {
            strI = context.getResources().getString(R.string.Gd);
            Intrinsics.checkNotNullExpressionValue(strI, "getString(...)");
        }
        Long l3 = this.usageLimitInMinutes;
        if (l3 != null) {
            strD = context.getString(R.string.yk, l3);
        } else if (this.hasLocation) {
            strD = context.getString(R.string.Iq);
        } else {
            Interval interval = this.interval;
            strD = interval != null ? IntervalsHelperKt.d(CollectionsKt.listOf(interval), context) : null;
        }
        return (strD == null || (strP = StringHelperExtKt.p(strI, strD, ", ")) == null) ? strI : strP;
    }

    public final int getTitle() {
        return this.title;
    }

    public final Long getUsageLimitInMinutes() {
        return this.usageLimitInMinutes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i3 = R.string.Hu;
        int i4 = R.drawable.S4;
        DayFlags dayFlags = DayFlags.MONDAY;
        int value = dayFlags.getValue();
        DayFlags dayFlags2 = DayFlags.TUESDAY;
        int value2 = value | dayFlags2.getValue();
        DayFlags dayFlags3 = DayFlags.WEDNESDAY;
        int value3 = value2 | dayFlags3.getValue();
        DayFlags dayFlags4 = DayFlags.THURSDAY;
        int value4 = value3 | dayFlags4.getValue();
        DayFlags dayFlags5 = DayFlags.FRIDAY;
        int value5 = value4 | dayFlags5.getValue();
        ScheduleEmoji scheduleEmoji = ScheduleEmoji.School;
        TimeUnit timeUnit = TimeUnit.HOURS;
        Interval interval = new Interval(0L, 0L, timeUnit.toMinutes(8L), timeUnit.toMinutes(16L), null, false, false, 113, null);
        int i5 = R.string.Ju;
        int i6 = R.string.Iu;
        String str = "BackToSchool";
        int i7 = 0;
        Integer num = null;
        Long l3 = null;
        boolean z2 = false;
        String str2 = "back_to_school";
        String str3 = "back_to_school";
        BackToSchool = new ScheduleTemplate(str, i7, i3, num, i4, value5, scheduleEmoji, interval, l3, z2, str2, str3, Integer.valueOf(i5), Integer.valueOf(i6), SeasonalTemplateColors.Purple, 194, null);
        int i8 = R.string.Ku;
        DayFlags.Companion companion = DayFlags.Companion;
        int iA = companion.a();
        ScheduleEmoji scheduleEmoji2 = ScheduleEmoji.Discount;
        Interval interval2 = new Interval(0L, 0L, timeUnit.toMinutes(0L), timeUnit.toMinutes(24L), null, false, false, 113, null);
        int i9 = R.string.Mu;
        int i10 = R.string.Lu;
        SeasonalTemplateColors seasonalTemplateColors = SeasonalTemplateColors.Red;
        int i11 = 194;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z3 = false;
        BlackFriday = new ScheduleTemplate("BlackFriday", 1, i8, null, i4, iA, scheduleEmoji2, interval2, null, z3, "black_friday", "black_friday", Integer.valueOf(i9), Integer.valueOf(i10), seasonalTemplateColors, i11, defaultConstructorMarker);
        int i12 = R.string.Yu;
        int iA2 = companion.a();
        ScheduleEmoji scheduleEmoji3 = ScheduleEmoji.Confetti;
        Interval interval3 = new Interval(0L, 0L, timeUnit.toMinutes(0L), timeUnit.toMinutes(24L), null, false, false, 113, null);
        int i13 = R.string.av;
        int i14 = R.string.Zu;
        SeasonalTemplateColors seasonalTemplateColors2 = SeasonalTemplateColors.Blue;
        NewYear = new ScheduleTemplate("NewYear", 2, i12, null, i4, iA2, scheduleEmoji3, interval3, null, z3, "new_year", "new_year", Integer.valueOf(i13), Integer.valueOf(i14), seasonalTemplateColors2, i11, defaultConstructorMarker);
        int i15 = R.string.cv;
        int i16 = R.drawable.U4;
        int iA3 = companion.a();
        Interval interval4 = new Interval(0L, 0L, timeUnit.toMinutes(0L), timeUnit.toMinutes(24L), null, false, false, 113, null);
        ScheduleEmoji scheduleEmoji4 = ScheduleEmoji.Leaf;
        int i17 = R.string.ev;
        int i18 = R.string.dv;
        long j3 = 30L;
        String str4 = "SpringRefresh";
        int i19 = 3;
        Integer num2 = null;
        boolean z4 = false;
        String str5 = "spring_refresh";
        String str6 = "spring_refresh";
        SpringRefresh = new ScheduleTemplate(str4, i19, i15, num2, i16, iA3, scheduleEmoji4, interval4, j3, z4, str5, str6, Integer.valueOf(i17), Integer.valueOf(i18), SeasonalTemplateColors.Green, 130, null);
        int i20 = R.string.hv;
        int iA4 = companion.a();
        ScheduleEmoji scheduleEmoji5 = ScheduleEmoji.Beach;
        Interval interval5 = new Interval(0L, 0L, 0L, 1439L, null, false, false, 113, null);
        int i21 = R.string.jv;
        int i22 = R.string.iv;
        SeasonalTemplateColors seasonalTemplateColors3 = SeasonalTemplateColors.Orange;
        SummerVacation = new ScheduleTemplate("SummerVacation", 4, i20, null, i4, iA4, scheduleEmoji5, interval5, null, z3, "summer_vacation", "summer_vacation", Integer.valueOf(i21), Integer.valueOf(i22), seasonalTemplateColors3, i11, defaultConstructorMarker);
        int i23 = 7872;
        boolean z5 = false;
        String str7 = null;
        Integer num3 = null;
        Integer num4 = null;
        SeasonalTemplateColors seasonalTemplateColors4 = null;
        Focus = new ScheduleTemplate("Focus", 5, R.string.Qu, Integer.valueOf(R.string.Ru), i4, dayFlags.getValue() | dayFlags2.getValue() | dayFlags3.getValue() | dayFlags4.getValue() | dayFlags5.getValue(), ScheduleEmoji.Goal, new Interval(0L, 0L, timeUnit.toMinutes(8L), timeUnit.toMinutes(17L), null, false, false, 113, null), null, z5, "focus", str7, num3, num4, seasonalTemplateColors4, i23, defaultConstructorMarker);
        int i24 = R.string.Fu;
        int i25 = R.string.Gu;
        ScheduleEmoji scheduleEmoji6 = ScheduleEmoji.Hourglass;
        String str8 = "AppLimit";
        int i26 = 6;
        Object[] objArr = null == true ? 1 : 0;
        AppLimit = new ScheduleTemplate(str8, i26, i24, Integer.valueOf(i25), i16, companion.a(), scheduleEmoji6, new Interval(0L, 0L, timeUnit.toMinutes(0L), timeUnit.toMinutes(24L), null, false, false, 113, null), j3, false, "app_limit", null, objArr, null, null, 7808, null);
        TimeForMyself = new ScheduleTemplate(KqqtdetwHMIO.zYYIIRIYYtt, 7, R.string.Wu, Integer.valueOf(R.string.Xu), i4, dayFlags.getValue() | dayFlags2.getValue() | dayFlags3.getValue() | dayFlags4.getValue() | dayFlags5.getValue(), ScheduleEmoji.Cheesecake, new Interval(0L, 0L, timeUnit.toMinutes(17L), timeUnit.toMinutes(18L), null, false, false, 113, null), null, z5, "time_for_myself", str7, num3, num4, seasonalTemplateColors4, i23, defaultConstructorMarker);
        int i27 = R.string.Su;
        int i28 = R.string.Tu;
        int i29 = R.drawable.Q4;
        ScheduleEmoji scheduleEmoji7 = ScheduleEmoji.Home;
        String str9 = "AtHome";
        int i30 = 8;
        AtHome = new ScheduleTemplate(str9, i30, i27, Integer.valueOf(i28), i29, companion.a(), scheduleEmoji7, new Interval(0L, 0L, timeUnit.toMinutes(0L), timeUnit.toMinutes(24L), null, false, false, 113, null), null, true, "location", null, null, null, null, 7744, null);
        Long l4 = null;
        StudyTime = new ScheduleTemplate("StudyTime", 9, R.string.fv, Integer.valueOf(R.string.gv), i4, dayFlags.getValue() | dayFlags2.getValue() | dayFlags3.getValue() | dayFlags4.getValue() | dayFlags5.getValue(), ScheduleEmoji.Books, new Interval(0L, 0L, timeUnit.toMinutes(16L), timeUnit.toMinutes(21L), null, false, false, 113, null), l4, z5, "study", str7, num3, num4, seasonalTemplateColors4, i23, defaultConstructorMarker);
        DigitalDetox = new ScheduleTemplate("DigitalDetox", 10, R.string.Nu, Integer.valueOf(R.string.Ou), i4, DayFlags.SUNDAY.getValue(), ScheduleEmoji.Stones, new Interval(0L, 0L, 0L, 1439L, null, false, false, 113, null), l4, z5, "digital_detox", str7, num3, num4, seasonalTemplateColors4, i23, defaultConstructorMarker);
        WindDown = new ScheduleTemplate("WindDown", 11, R.string.kv, Integer.valueOf(R.string.lv), i4, companion.a(), ScheduleEmoji.Night, new Interval(0L, 0L, timeUnit.toMinutes(20L), 1439L, null, false, false, 113, null), l4, z5, "wind_down", str7, num3, num4, seasonalTemplateColors4, i23, defaultConstructorMarker);
        MindfulMorning = new ScheduleTemplate("MindfulMorning", 12, R.string.Uu, Integer.valueOf(R.string.Vu), i4, dayFlags.getValue() | dayFlags2.getValue() | dayFlags3.getValue() | dayFlags4.getValue() | dayFlags5.getValue(), scheduleEmoji4, new Interval(0L, 0L, timeUnit.toMinutes(6L), timeUnit.toMinutes(9L), null, false, false, 113, null), null, false, "morning", null, null, null, null, 7872, null);
        ScheduleTemplate[] scheduleTemplateArr$values = $values();
        $VALUES = scheduleTemplateArr$values;
        $ENTRIES = EnumEntriesKt.a(scheduleTemplateArr$values);
        Companion = new Companion(null);
    }

    /* synthetic */ ScheduleTemplate(String str, int i3, int i4, Integer num, int i5, int i6, ScheduleEmoji scheduleEmoji, Interval interval, Long l3, boolean z2, String str2, String str3, Integer num2, Integer num3, SeasonalTemplateColors seasonalTemplateColors, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, (i7 & 2) != 0 ? null : num, i5, i6, scheduleEmoji, interval, (i7 & 64) != 0 ? null : l3, (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z2, str2, (i7 & 512) != 0 ? null : str3, (i7 & 1024) != 0 ? null : num2, (i7 & 2048) != 0 ? null : num3, (i7 & 4096) != 0 ? null : seasonalTemplateColors);
    }
}
