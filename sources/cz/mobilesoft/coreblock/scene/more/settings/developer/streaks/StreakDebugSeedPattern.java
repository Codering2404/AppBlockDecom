package cz.mobilesoft.coreblock.scene.more.settings.developer.streaks;

import cz.mobilesoft.coreblock.scene.streaks.StreakDates;
import cz.mobilesoft.coreblock.scene.streaks.StreakDay;
import cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus;
import cz.mobilesoft.coreblock.scene.streaks.StreakLine;
import cz.mobilesoft.coreblock.scene.streaks.StreakLineBuilder;
import cz.mobilesoft.coreblock.scene.streaks.StreakLossReason;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class StreakDebugSeedPattern {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StreakDebugSeedPattern f109420a = new StreakDebugSeedPattern();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f109421b = {',', ';', ' ', '\t', '\n', '-', '_'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f109422c = MapsKt.mapOf(TuplesKt.a('o', StreakDayStatus.OBTAINED), TuplesKt.a('r', StreakDayStatus.REST), TuplesKt.a('i', StreakDayStatus.INACTIVE), TuplesKt.a('l', StreakDayStatus.LOST));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f109423d = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Day {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocalDate f109424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StreakDayStatus f109425b;

        public Day(LocalDate date, StreakDayStatus status) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(status, "status");
            this.f109424a = date;
            this.f109425b = status;
        }

        public final LocalDate a() {
            return this.f109424a;
        }

        public final StreakDayStatus b() {
            return this.f109425b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Day)) {
                return false;
            }
            Day day = (Day) obj;
            return Intrinsics.areEqual(this.f109424a, day.f109424a) && this.f109425b == day.f109425b;
        }

        public int hashCode() {
            return (this.f109424a.hashCode() * 31) + this.f109425b.hashCode();
        }

        public String toString() {
            return "Day(date=" + this.f109424a + ", status=" + this.f109425b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Result {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Invalid implements Result {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f109426a;

            public Invalid(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                this.f109426a = message;
            }

            public final String a() {
                return this.f109426a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Invalid) && Intrinsics.areEqual(this.f109426a, ((Invalid) obj).f109426a);
            }

            public int hashCode() {
                return this.f109426a.hashCode();
            }

            public String toString() {
                return "Invalid(message=" + this.f109426a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Parsed implements Result {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f109427a;

            public Parsed(List statuses) {
                Intrinsics.checkNotNullParameter(statuses, "statuses");
                this.f109427a = statuses;
            }

            public final List a() {
                return this.f109427a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Parsed) && Intrinsics.areEqual(this.f109427a, ((Parsed) obj).f109427a);
            }

            public int hashCode() {
                return this.f109427a.hashCode();
            }

            public String toString() {
                return "Parsed(statuses=" + this.f109427a + ")";
            }
        }
    }

    private StreakDebugSeedPattern() {
    }

    public static /* synthetic */ String d(StreakDebugSeedPattern streakDebugSeedPattern, List list, LocalDate localDate, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            localDate = LocalDate.now();
            Intrinsics.checkNotNullExpressionValue(localDate, "now(...)");
        }
        return streakDebugSeedPattern.c(list, localDate);
    }

    private final String f(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            StreakDayStatus streakDayStatus = (StreakDayStatus) it.next();
            Pair pair = (Pair) CollectionsKt.lastOrNull((List) arrayList);
            if (pair == null || pair.e() != streakDayStatus) {
                arrayList.add(TuplesKt.a(streakDayStatus, 1));
            } else {
                arrayList.set(CollectionsKt.getLastIndex(arrayList), TuplesKt.a(streakDayStatus, Integer.valueOf(((Number) pair.f()).intValue() + 1)));
            }
        }
        return CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakDebugSeedPattern.g((Pair) obj);
            }
        }, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        StreakDayStatus streakDayStatus = (StreakDayStatus) pair.a();
        int iIntValue = ((Number) pair.b()).intValue();
        String lowerCase = streakDayStatus.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return iIntValue + " " + lowerCase;
    }

    public final List b(List statuses, LocalDate today) {
        Intrinsics.checkNotNullParameter(statuses, "statuses");
        Intrinsics.checkNotNullParameter(today, "today");
        List list = statuses;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LocalDate localDateMinusDays = today.minusDays(((long) i3) + 1);
            Intrinsics.checkNotNullExpressionValue(localDateMinusDays, "minusDays(...)");
            arrayList.add(new Day(localDateMinusDays, (StreakDayStatus) obj));
            i3 = i4;
        }
        return arrayList;
    }

    public final String c(List statuses, LocalDate today) {
        Object objPrevious;
        Intrinsics.checkNotNullParameter(statuses, "statuses");
        Intrinsics.checkNotNullParameter(today, "today");
        if (statuses.isEmpty()) {
            return "Nothing";
        }
        StreakLineBuilder streakLineBuilder = StreakLineBuilder.f120365a;
        List<Day> listB = b(statuses, today);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
        for (Day day : listB) {
            arrayList.add(new StreakDay(StreakDates.f120261a.c(day.a()), 0L, day.b(), StreakLossReason.NONE, null));
        }
        List listA = streakLineBuilder.a(arrayList);
        ListIterator listIterator = listA.listIterator(listA.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((StreakLine) objPrevious).d()) {
                break;
            }
        }
        StreakLine streakLine = (StreakLine) objPrevious;
        int iB = streakLine != null ? streakLine.b() : 0;
        String str = statuses.size() == 1 ? "day" : "days";
        return statuses.size() + " " + str + " · " + iB + " streak · " + f(statuses);
    }

    public final Result e(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String string = StringsKt.t1(input).toString();
        if (string.length() > 0) {
            for (int i3 = 0; i3 < string.length(); i3++) {
                if (Character.isDigit(string.charAt(i3))) {
                }
            }
            Integer numU = StringsKt.u(string);
            if (numU == null || numU.intValue() > 3650) {
                return new Result.Invalid("Enter at most 3650 days");
            }
            if (numU.intValue() == 0) {
                return new Result.Invalid("Enter at least one day");
            }
            int iIntValue = numU.intValue();
            ArrayList arrayList = new ArrayList(iIntValue);
            for (int i4 = 0; i4 < iIntValue; i4++) {
                arrayList.add(StreakDayStatus.OBTAINED);
            }
            return new Result.Parsed(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        int length = input.length();
        Integer numValueOf = null;
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = input.charAt(i5);
            if (!ArraysKt.contains(f109421b, cCharAt)) {
                if (Character.isDigit(cCharAt)) {
                    long jIntValue = (((long) (numValueOf != null ? numValueOf.intValue() : 0)) * ((long) 10)) + ((long) (cCharAt - '0'));
                    if (jIntValue > 3650) {
                        return new Result.Invalid("A repeat count may not exceed 3650");
                    }
                    numValueOf = Integer.valueOf((int) jIntValue);
                } else {
                    StreakDayStatus streakDayStatus = (StreakDayStatus) f109422c.get(Character.valueOf(Character.toLowerCase(cCharAt)));
                    if (streakDayStatus == null) {
                        return new Result.Invalid("Unexpected '" + cCharAt + "' at position " + (i5 + 1) + ". Use O, R, I or L.");
                    }
                    int iIntValue2 = numValueOf != null ? numValueOf.intValue() : 1;
                    if (iIntValue2 == 0) {
                        return new Result.Invalid("A repeat count of 0 does nothing — remove it or use 1");
                    }
                    if (arrayList2.size() + iIntValue2 > 3650) {
                        return new Result.Invalid("That is more than 3650 days");
                    }
                    for (int i6 = 0; i6 < iIntValue2; i6++) {
                        arrayList2.add(streakDayStatus);
                    }
                    numValueOf = null;
                }
            }
        }
        if (numValueOf == null) {
            return arrayList2.isEmpty() ? new Result.Invalid("Enter at least one day, for example 3o,l,3o") : new Result.Parsed(arrayList2);
        }
        return new Result.Invalid("'" + numValueOf + "' has no day letter after it");
    }
}
