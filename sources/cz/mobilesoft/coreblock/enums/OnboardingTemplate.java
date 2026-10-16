package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OnboardingTemplate {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OnboardingTemplate[] $VALUES;
    public static final OnboardingTemplate Family;
    public static final OnboardingTemplate School;
    public static final OnboardingTemplate TimeForMyself;
    public static final OnboardingTemplate Work;
    private final String analyticsKey;
    private final Integer dayFlags;
    private final ScheduleEmoji emoji;
    private final Interval interval;
    private final int title;
    private final int titleRes;

    private static final /* synthetic */ OnboardingTemplate[] $values() {
        return new OnboardingTemplate[]{School, Work, TimeForMyself, Family};
    }

    static {
        int i3 = R.string.bv;
        DayFlags dayFlags = DayFlags.MONDAY;
        int value = dayFlags.getValue();
        DayFlags dayFlags2 = DayFlags.TUESDAY;
        int value2 = value | dayFlags2.getValue();
        DayFlags dayFlags3 = DayFlags.WEDNESDAY;
        int value3 = value2 | dayFlags3.getValue();
        DayFlags dayFlags4 = DayFlags.THURSDAY;
        int value4 = value3 | dayFlags4.getValue();
        DayFlags dayFlags5 = DayFlags.FRIDAY;
        Integer numValueOf = Integer.valueOf(value4 | dayFlags5.getValue());
        ScheduleEmoji scheduleEmoji = ScheduleEmoji.School;
        TimeUnit timeUnit = TimeUnit.HOURS;
        School = new OnboardingTemplate("School", 0, i3, numValueOf, scheduleEmoji, new Interval(0L, 0L, timeUnit.toMinutes(8L), timeUnit.toMinutes(14L), null, false, false, 113, null), "school", R.string.A7);
        Work = new OnboardingTemplate("Work", 1, R.string.mv, Integer.valueOf(dayFlags.getValue() | dayFlags2.getValue() | dayFlags3.getValue() | dayFlags4.getValue() | dayFlags5.getValue()), ScheduleEmoji.Laptop, new Interval(0L, 0L, timeUnit.toMinutes(9L), timeUnit.toMinutes(17L), null, false, false, 113, null), "work", R.string.B7);
        TimeForMyself = new OnboardingTemplate("TimeForMyself", 2, R.string.Wu, Integer.valueOf(dayFlags.getValue() | dayFlags2.getValue() | dayFlags3.getValue() | dayFlags4.getValue() | dayFlags5.getValue()), ScheduleEmoji.Cheesecake, new Interval(0L, 0L, timeUnit.toMinutes(17L), timeUnit.toMinutes(18L), null, false, false, 113, null), "time_for_myself", R.string.z7);
        Family = new OnboardingTemplate("Family", 3, R.string.Pu, Integer.valueOf(dayFlags.getValue() | dayFlags2.getValue() | dayFlags3.getValue() | dayFlags4.getValue() | dayFlags5.getValue()), ScheduleEmoji.Heart, new Interval(0L, 0L, timeUnit.toMinutes(15L), timeUnit.toMinutes(20L), null, false, false, 113, null), "family", R.string.y7);
        OnboardingTemplate[] onboardingTemplateArr$values = $values();
        $VALUES = onboardingTemplateArr$values;
        $ENTRIES = EnumEntriesKt.a(onboardingTemplateArr$values);
    }

    private OnboardingTemplate(String str, int i3, int i4, Integer num, ScheduleEmoji scheduleEmoji, Interval interval, String str2, int i5) {
        this.title = i4;
        this.dayFlags = num;
        this.emoji = scheduleEmoji;
        this.interval = interval;
        this.analyticsKey = str2;
        this.titleRes = i5;
    }

    public static EnumEntries<OnboardingTemplate> getEntries() {
        return $ENTRIES;
    }

    public static OnboardingTemplate valueOf(String str) {
        return (OnboardingTemplate) Enum.valueOf(OnboardingTemplate.class, str);
    }

    public static OnboardingTemplate[] values() {
        return (OnboardingTemplate[]) $VALUES.clone();
    }

    public final String getAnalyticsKey() {
        return this.analyticsKey;
    }

    public final Integer getDayFlags() {
        return this.dayFlags;
    }

    public final ScheduleEmoji getEmoji() {
        return this.emoji;
    }

    public final Interval getInterval() {
        return this.interval;
    }

    public final int getTitle() {
        return this.title;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* synthetic */ OnboardingTemplate(String str, int i3, int i4, Integer num, ScheduleEmoji scheduleEmoji, Interval interval, String str2, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        int i7;
        String str3;
        Interval interval2;
        num = (i6 & 2) != 0 ? null : num;
        if ((i6 & 8) != 0) {
            i7 = i5;
            str3 = str2;
            interval2 = null;
        } else {
            i7 = i5;
            str3 = str2;
            interval2 = interval;
        }
        this(str, i3, i4, num, scheduleEmoji, interval2, str3, i7);
    }
}
