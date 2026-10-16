package com.superwall.sdk.paywall.presentation.rule_logic.cel;

import com.superwall.sdk.models.config.ComputedPropertyRequest;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.InPeriod;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import com.superwall.sdk.storage.core_data.CoreDataManager;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class SuperscriptExposedFunction {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SuperscriptExposedFunction from(String name, List<? extends PassableValue> args) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(args, "args");
            if (Intrinsics.areEqual(name, Names.MINUTES_SINCE.getRawName())) {
                Object objFirst = CollectionsKt.first((List<? extends Object>) args);
                Intrinsics.checkNotNull(objFirst, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.StringValue");
                return new MinutesSince(((PassableValue.StringValue) objFirst).getValue());
            }
            if (Intrinsics.areEqual(name, Names.HOURS_SINCE.getRawName())) {
                Object objFirst2 = CollectionsKt.first((List<? extends Object>) args);
                Intrinsics.checkNotNull(objFirst2, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.StringValue");
                return new HoursSince(((PassableValue.StringValue) objFirst2).getValue());
            }
            if (Intrinsics.areEqual(name, Names.DAYS_SINCE.getRawName())) {
                Object objFirst3 = CollectionsKt.first((List<? extends Object>) args);
                Intrinsics.checkNotNull(objFirst3, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.StringValue");
                return new DaysSince(((PassableValue.StringValue) objFirst3).getValue());
            }
            if (Intrinsics.areEqual(name, Names.MONTHS_SINCE.getRawName())) {
                Object objFirst4 = CollectionsKt.first((List<? extends Object>) args);
                Intrinsics.checkNotNull(objFirst4, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.StringValue");
                return new MonthsSince(((PassableValue.StringValue) objFirst4).getValue());
            }
            if (Intrinsics.areEqual(name, Names.PLACEMENTS_IN_HOUR.getRawName())) {
                Object objFirst5 = CollectionsKt.first((List<? extends Object>) args);
                Intrinsics.checkNotNull(objFirst5, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.StringValue");
                return new PlacementCount(((PassableValue.StringValue) objFirst5).getValue(), InPeriod.Period.HOUR);
            }
            if (Intrinsics.areEqual(name, Names.PLACEMENTS_IN_DAY.getRawName())) {
                Object objFirst6 = CollectionsKt.first((List<? extends Object>) args);
                Intrinsics.checkNotNull(objFirst6, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.StringValue");
                return new PlacementCount(((PassableValue.StringValue) objFirst6).getValue(), InPeriod.Period.DAY);
            }
            if (Intrinsics.areEqual(name, Names.PLACEMENTS_IN_WEEK.getRawName())) {
                Object objFirst7 = CollectionsKt.first((List<? extends Object>) args);
                Intrinsics.checkNotNull(objFirst7, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.StringValue");
                return new PlacementCount(((PassableValue.StringValue) objFirst7).getValue(), InPeriod.Period.WEEK);
            }
            if (Intrinsics.areEqual(name, Names.PLACEMENTS_IN_MONTH.getRawName())) {
                Object objFirst8 = CollectionsKt.first((List<? extends Object>) args);
                Intrinsics.checkNotNull(objFirst8, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.StringValue");
                return new PlacementCount(((PassableValue.StringValue) objFirst8).getValue(), InPeriod.Period.MONTH);
            }
            if (Intrinsics.areEqual(name, Names.PLACEMENTS_SINCE_INSTALL.getRawName())) {
                Object objFirst9 = CollectionsKt.first((List<? extends Object>) args);
                Intrinsics.checkNotNull(objFirst9, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue.StringValue");
                return new PlacementCount(((PassableValue.StringValue) objFirst9).getValue(), InPeriod.Period.INSTALL);
            }
            if (Intrinsics.areEqual(name, Names.REVIEW_REQUESTS_IN_HOUR.getRawName())) {
                return new ReviewRequestCount(InPeriod.Period.HOUR);
            }
            if (Intrinsics.areEqual(name, Names.REVIEW_REQUESTS_IN_DAY.getRawName())) {
                return new ReviewRequestCount(InPeriod.Period.DAY);
            }
            if (Intrinsics.areEqual(name, Names.REVIEW_REQUESTS_IN_WEEK.getRawName())) {
                return new ReviewRequestCount(InPeriod.Period.WEEK);
            }
            if (Intrinsics.areEqual(name, Names.REVIEW_REQUESTS_IN_MONTH.getRawName())) {
                return new ReviewRequestCount(InPeriod.Period.MONTH);
            }
            if (Intrinsics.areEqual(name, Names.REVIEW_REQUESTS_IN_YEAR.getRawName())) {
                return new ReviewRequestCount(InPeriod.Period.YEAR);
            }
            if (Intrinsics.areEqual(name, Names.REVIEW_REQUESTS_TOTAL.getRawName())) {
                return new ReviewRequestCount(InPeriod.Period.INSTALL);
            }
            if (Intrinsics.areEqual(name, Names.REQUEST_REVIEW.getRawName())) {
                return RequestReview.INSTANCE;
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DaysSince extends SuperscriptExposedFunction implements TimeSince {
        private final String event;
        private final ComputedPropertyRequest.ComputedPropertyRequestType propertyRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DaysSince(String event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
            this.propertyRequest = ComputedPropertyRequest.ComputedPropertyRequestType.DAYS_SINCE;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public String getEvent() {
            return this.event;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public ComputedPropertyRequest.ComputedPropertyRequestType getPropertyRequest() {
            return this.propertyRequest;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public Object invoke(CoreDataManager coreDataManager, Continuation<? super Integer> continuation) {
            return TimeSince.DefaultImpls.invoke(this, coreDataManager, continuation);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HoursSince extends SuperscriptExposedFunction implements TimeSince {
        private final String event;
        private final ComputedPropertyRequest.ComputedPropertyRequestType propertyRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HoursSince(String event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
            this.propertyRequest = ComputedPropertyRequest.ComputedPropertyRequestType.HOURS_SINCE;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public String getEvent() {
            return this.event;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public ComputedPropertyRequest.ComputedPropertyRequestType getPropertyRequest() {
            return this.propertyRequest;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public Object invoke(CoreDataManager coreDataManager, Continuation<? super Integer> continuation) {
            return TimeSince.DefaultImpls.invoke(this, coreDataManager, continuation);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MinutesSince extends SuperscriptExposedFunction implements TimeSince {
        private final String event;
        private final ComputedPropertyRequest.ComputedPropertyRequestType propertyRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MinutesSince(String event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
            this.propertyRequest = ComputedPropertyRequest.ComputedPropertyRequestType.MINUTES_SINCE;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public String getEvent() {
            return this.event;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public ComputedPropertyRequest.ComputedPropertyRequestType getPropertyRequest() {
            return this.propertyRequest;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public Object invoke(CoreDataManager coreDataManager, Continuation<? super Integer> continuation) {
            return TimeSince.DefaultImpls.invoke(this, coreDataManager, continuation);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MonthsSince extends SuperscriptExposedFunction implements TimeSince {
        private final String event;
        private final ComputedPropertyRequest.ComputedPropertyRequestType propertyRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MonthsSince(String event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
            this.propertyRequest = ComputedPropertyRequest.ComputedPropertyRequestType.MONTHS_SINCE;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public String getEvent() {
            return this.event;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public ComputedPropertyRequest.ComputedPropertyRequestType getPropertyRequest() {
            return this.propertyRequest;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince
        public Object invoke(CoreDataManager coreDataManager, Continuation<? super Integer> continuation) {
            return TimeSince.DefaultImpls.invoke(this, coreDataManager, continuation);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Names {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Names[] $VALUES;
        private final String rawName;
        public static final Names MINUTES_SINCE = new Names("MINUTES_SINCE", 0, "minutesSince");
        public static final Names HOURS_SINCE = new Names("HOURS_SINCE", 1, "hoursSince");
        public static final Names DAYS_SINCE = new Names("DAYS_SINCE", 2, "daysSince");
        public static final Names MONTHS_SINCE = new Names("MONTHS_SINCE", 3, "monthsSince");
        public static final Names PLACEMENTS_IN_HOUR = new Names("PLACEMENTS_IN_HOUR", 4, "placementsInHour");
        public static final Names PLACEMENTS_IN_DAY = new Names("PLACEMENTS_IN_DAY", 5, "placementsInDay");
        public static final Names PLACEMENTS_IN_WEEK = new Names("PLACEMENTS_IN_WEEK", 6, "placementsInWeek");
        public static final Names PLACEMENTS_IN_MONTH = new Names("PLACEMENTS_IN_MONTH", 7, "placementsInMonth");
        public static final Names PLACEMENTS_SINCE_INSTALL = new Names("PLACEMENTS_SINCE_INSTALL", 8, "placementsSinceInstall");
        public static final Names REVIEW_REQUESTS_IN_HOUR = new Names("REVIEW_REQUESTS_IN_HOUR", 9, "reviewRequestsInHour");
        public static final Names REVIEW_REQUESTS_IN_DAY = new Names("REVIEW_REQUESTS_IN_DAY", 10, "reviewRequestsInDay");
        public static final Names REVIEW_REQUESTS_IN_WEEK = new Names("REVIEW_REQUESTS_IN_WEEK", 11, "reviewRequestsInWeek");
        public static final Names REVIEW_REQUESTS_IN_MONTH = new Names("REVIEW_REQUESTS_IN_MONTH", 12, "reviewRequestsInMonth");
        public static final Names REVIEW_REQUESTS_IN_YEAR = new Names("REVIEW_REQUESTS_IN_YEAR", 13, "reviewRequestsInYear");
        public static final Names REVIEW_REQUESTS_TOTAL = new Names("REVIEW_REQUESTS_TOTAL", 14, "reviewRequestsSinceInstall");
        public static final Names REQUEST_REVIEW = new Names("REQUEST_REVIEW", 15, "requestReview");

        private static final /* synthetic */ Names[] $values() {
            return new Names[]{MINUTES_SINCE, HOURS_SINCE, DAYS_SINCE, MONTHS_SINCE, PLACEMENTS_IN_HOUR, PLACEMENTS_IN_DAY, PLACEMENTS_IN_WEEK, PLACEMENTS_IN_MONTH, PLACEMENTS_SINCE_INSTALL, REVIEW_REQUESTS_IN_HOUR, REVIEW_REQUESTS_IN_DAY, REVIEW_REQUESTS_IN_WEEK, REVIEW_REQUESTS_IN_MONTH, REVIEW_REQUESTS_IN_YEAR, REVIEW_REQUESTS_TOTAL, REQUEST_REVIEW};
        }

        static {
            Names[] namesArr$values = $values();
            $VALUES = namesArr$values;
            $ENTRIES = EnumEntriesKt.a(namesArr$values);
        }

        private Names(String str, int i3, String str2) {
            this.rawName = str2;
        }

        public static EnumEntries<Names> getEntries() {
            return $ENTRIES;
        }

        public static Names valueOf(String str) {
            return (Names) Enum.valueOf(Names.class, str);
        }

        public static Names[] values() {
            return (Names[]) $VALUES.clone();
        }

        public final String getRawName() {
            return this.rawName;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PlacementCount extends SuperscriptExposedFunction {
        private final String event;
        private final InPeriod.Period period;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[InPeriod.Period.values().length];
                try {
                    iArr[InPeriod.Period.HOUR.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[InPeriod.Period.DAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[InPeriod.Period.WEEK.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[InPeriod.Period.MONTH.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[InPeriod.Period.INSTALL.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlacementCount(String event, InPeriod.Period period) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(period, "period");
            this.event = event;
            this.period = period;
        }

        public final String getEvent() {
            return this.event;
        }

        public final InPeriod.Period getPeriod() {
            return this.period;
        }

        public final Object invoke(CoreDataManager coreDataManager, Continuation<? super Integer> continuation) {
            Date time;
            Date date = new Date();
            InPeriod.Period period = this.period;
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            if (iArr[period.ordinal()] == 5) {
                time = new Date(0L);
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int i3 = iArr[this.period.ordinal()];
                if (i3 == 1) {
                    calendar.add(10, -1);
                } else if (i3 == 2) {
                    calendar.add(6, -1);
                } else if (i3 == 3) {
                    calendar.add(3, -1);
                } else {
                    if (i3 != 4) {
                        return null;
                    }
                    calendar.add(2, -1);
                }
                time = calendar.getTime();
            }
            String str = this.event;
            Intrinsics.checkNotNull(time);
            return coreDataManager.countEventsByNameInPeriod(str, time, date, continuation);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestReview extends SuperscriptExposedFunction {
        public static final RequestReview INSTANCE = new RequestReview();

        private RequestReview() {
            super(null);
        }

        public final Object invoke(CoreDataManager coreDataManager, Continuation<? super Boolean> continuation) {
            return Boxing.a(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReviewRequestCount extends SuperscriptExposedFunction {
        private final InPeriod.Period period;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[InPeriod.Period.values().length];
                try {
                    iArr[InPeriod.Period.HOUR.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[InPeriod.Period.DAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[InPeriod.Period.WEEK.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[InPeriod.Period.MONTH.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[InPeriod.Period.YEAR.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[InPeriod.Period.INSTALL.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReviewRequestCount(InPeriod.Period period) {
            super(null);
            Intrinsics.checkNotNullParameter(period, "period");
            this.period = period;
        }

        public final InPeriod.Period getPeriod() {
            return this.period;
        }

        public final Object invoke(CoreDataManager coreDataManager, Continuation<? super Integer> continuation) {
            Date time;
            Date date = new Date();
            InPeriod.Period period = this.period;
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            if (iArr[period.ordinal()] == 6) {
                time = new Date(0L);
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int i3 = iArr[this.period.ordinal()];
                if (i3 == 1) {
                    calendar.add(10, -1);
                } else if (i3 == 2) {
                    calendar.add(6, -1);
                } else if (i3 == 3) {
                    calendar.add(3, -1);
                } else if (i3 == 4) {
                    calendar.add(2, -1);
                } else {
                    if (i3 != 5) {
                        return null;
                    }
                    calendar.add(1, -1);
                }
                time = calendar.getTime();
            }
            Intrinsics.checkNotNull(time);
            return coreDataManager.countEventsByNameInPeriod("review_requested", time, date, continuation);
        }
    }

    public /* synthetic */ SuperscriptExposedFunction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SuperscriptExposedFunction() {
    }
}
