package cz.mobilesoft.coreblock.enums;

import android.text.format.DateUtils;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DayOfWeek;

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
public final class DayFlags {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DayFlags[] $VALUES;
    public static final Companion Companion;
    public static final DayFlags SATURDAY;
    public static final DayFlags SUNDAY;
    private static final List<DayFlags> WEEKDAYS;
    private static final List<DayFlags> WEEKENDS;
    private final DayOfWeek dayOfWeek;
    private int value;
    public static final DayFlags MONDAY = new DayFlags("MONDAY", 0, 1, DayOfWeek.MONDAY);
    public static final DayFlags TUESDAY = new DayFlags("TUESDAY", 1, 2, DayOfWeek.TUESDAY);
    public static final DayFlags WEDNESDAY = new DayFlags("WEDNESDAY", 2, 4, DayOfWeek.WEDNESDAY);
    public static final DayFlags THURSDAY = new DayFlags("THURSDAY", 3, 8, DayOfWeek.THURSDAY);
    public static final DayFlags FRIDAY = new DayFlags("FRIDAY", 4, 16, DayOfWeek.FRIDAY);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f96978a;

            static {
                int[] iArr = new int[DayFlags.values().length];
                try {
                    iArr[DayFlags.MONDAY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DayFlags.TUESDAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DayFlags.WEDNESDAY.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DayFlags.THURSDAY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[DayFlags.FRIDAY.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[DayFlags.SATURDAY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[DayFlags.SUNDAY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f96978a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            Iterator<DayFlags> it = DayFlags.getEntries().iterator();
            int value = 0;
            while (it.hasNext()) {
                value += it.next().getValue();
            }
            return value;
        }

        public final DayFlags b(DayOfWeek dayOfWeek) {
            DayFlags next;
            Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
            Iterator<DayFlags> it = DayFlags.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getDayOfWeek() == dayOfWeek) {
                    break;
                }
            }
            DayFlags dayFlags = next;
            return dayFlags == null ? DayFlags.MONDAY : dayFlags;
        }

        public final int c(DayFlags dayFlags) {
            switch (dayFlags == null ? -1 : WhenMappings.f96978a[dayFlags.ordinal()]) {
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 4;
                case 4:
                    return 5;
                case 5:
                    return 6;
                case 6:
                    return 7;
                case 7:
                    return 1;
                default:
                    return -1;
            }
        }

        public final DayFlags d() {
            DayFlags dayFlagsE = e(Calendar.getInstance().get(7));
            return dayFlagsE == null ? DayFlags.MONDAY : dayFlagsE;
        }

        public final DayFlags e(int i3) {
            switch (i3) {
                case 1:
                    return DayFlags.SUNDAY;
                case 2:
                    return DayFlags.MONDAY;
                case 3:
                    return DayFlags.TUESDAY;
                case 4:
                    return DayFlags.WEDNESDAY;
                case 5:
                    return DayFlags.THURSDAY;
                case 6:
                    return DayFlags.FRIDAY;
                case 7:
                    return DayFlags.SATURDAY;
                default:
                    return null;
            }
        }

        public final String f(DayFlags dayFlags) {
            int i3;
            int i4;
            if (DateHelper.o()) {
                i3 = 2;
                i4 = 3;
            } else {
                i3 = 0;
                i4 = 1;
            }
            String dayOfWeekString = DateUtils.getDayOfWeekString(c(dayFlags), 30);
            Intrinsics.checkNotNullExpressionValue(dayOfWeekString, "getDayOfWeekString(...)");
            String strSubstring = dayOfWeekString.substring(i3, i4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = strSubstring.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }

        public final String g(int i3, boolean z2) {
            StringBuilder sb = new StringBuilder();
            DayFlags[] dayFlagsArrA = DateHelper.a();
            Intrinsics.checkNotNull(dayFlagsArrA);
            for (DayFlags dayFlags : dayFlagsArrA) {
                if ((dayFlags.getValue() & i3) != 0) {
                    sb.append(sb.length() > 0 ? ", " : "");
                    sb.append(DateUtils.getDayOfWeekString(c(dayFlags), z2 ? 10 : 30));
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public final String h(int i3) {
            StringBuilder sb = new StringBuilder();
            DayFlags[] dayFlagsArrA = DateHelper.a();
            Intrinsics.checkNotNull(dayFlagsArrA);
            for (DayFlags dayFlags : dayFlagsArrA) {
                if ((dayFlags.getValue() & i3) != 0) {
                    String str = "";
                    sb.append(sb.length() > 0 ? ", " : "");
                    switch (c(dayFlags)) {
                        case 1:
                            str = "su";
                            break;
                        case 2:
                            str = "mo";
                            break;
                        case 3:
                            str = "tu";
                            break;
                        case 4:
                            str = "we";
                            break;
                        case 5:
                            str = "th";
                            break;
                        case 6:
                            str = "fr";
                            break;
                        case 7:
                            str = "sa";
                            break;
                    }
                    String lowerCase = str.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    sb.append(lowerCase);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[EDGE_INSN: B:50:0x0043->B:16:0x0043 BREAK  A[LOOP:1: B:8:0x0023->B:51:?]] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x007c A[EDGE_INSN: B:47:0x007c->B:31:0x007c BREAK  A[LOOP:0: B:23:0x005c->B:48:?]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String i(android.content.Context r7, int r8, boolean r9) {
            /*
                r6 = this;
                java.lang.String r9 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r9)
                int r9 = java.lang.Integer.bitCount(r8)
                java.util.List r0 = r6.l()
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                boolean r1 = r0 instanceof java.util.Collection
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L1f
                r1 = r0
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L1f
                goto L37
            L1f:
                java.util.Iterator r0 = r0.iterator()
            L23:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L37
                java.lang.Object r1 = r0.next()
                cz.mobilesoft.coreblock.enums.DayFlags r1 = (cz.mobilesoft.coreblock.enums.DayFlags) r1
                int r1 = r1.getValue()
                r1 = r1 & r8
                if (r1 <= 0) goto L43
                goto L23
            L37:
                java.util.List r0 = r6.l()
                int r0 = r0.size()
                if (r9 != r0) goto L43
                r0 = r3
                goto L44
            L43:
                r0 = r2
            L44:
                java.util.List r1 = r6.k()
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                boolean r4 = r1 instanceof java.util.Collection
                if (r4 == 0) goto L58
                r4 = r1
                java.util.Collection r4 = (java.util.Collection) r4
                boolean r4 = r4.isEmpty()
                if (r4 == 0) goto L58
                goto L70
            L58:
                java.util.Iterator r1 = r1.iterator()
            L5c:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L70
                java.lang.Object r4 = r1.next()
                cz.mobilesoft.coreblock.enums.DayFlags r4 = (cz.mobilesoft.coreblock.enums.DayFlags) r4
                int r4 = r4.getValue()
                r4 = r4 & r8
                if (r4 <= 0) goto L7c
                goto L5c
            L70:
                java.util.List r1 = r6.k()
                int r1 = r1.size()
                if (r9 != r1) goto L7c
                r1 = r3
                goto L7d
            L7c:
                r1 = r2
            L7d:
                kotlin.enums.EnumEntries r4 = cz.mobilesoft.coreblock.enums.DayFlags.getEntries()
                int r4 = r4.size()
                java.lang.String r5 = "getString(...)"
                if (r9 != r4) goto L93
                int r8 = cz.mobilesoft.coreblock.R.string.Gd
                java.lang.String r7 = r7.getString(r8)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
                return r7
            L93:
                if (r0 == 0) goto L9f
                int r8 = cz.mobilesoft.coreblock.R.string.oG
                java.lang.String r7 = r7.getString(r8)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
                return r7
            L9f:
                if (r1 == 0) goto Lab
                int r8 = cz.mobilesoft.coreblock.R.string.nG
                java.lang.String r7 = r7.getString(r8)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
                return r7
            Lab:
                if (r9 != r3) goto Lae
                r2 = r3
            Lae:
                java.lang.String r7 = r6.g(r8, r2)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.enums.DayFlags.Companion.i(android.content.Context, int, boolean):java.lang.String");
        }

        public final List j(int i3) {
            ArrayList arrayList = new ArrayList();
            for (DayFlags dayFlags : DayFlags.getEntries()) {
                if ((dayFlags.getValue() & i3) != 0) {
                    arrayList.add(dayFlags);
                }
            }
            return arrayList;
        }

        public final List k() {
            return DayFlags.WEEKDAYS;
        }

        public final List l() {
            return DayFlags.WEEKENDS;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ DayFlags[] $values() {
        return new DayFlags[]{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
    }

    static {
        DayFlags dayFlags = new DayFlags("SATURDAY", 5, 32, DayOfWeek.SATURDAY);
        SATURDAY = dayFlags;
        DayFlags dayFlags2 = new DayFlags("SUNDAY", 6, 64, DayOfWeek.SUNDAY);
        SUNDAY = dayFlags2;
        DayFlags[] dayFlagsArr$values = $values();
        $VALUES = dayFlagsArr$values;
        $ENTRIES = EnumEntriesKt.a(dayFlagsArr$values);
        Companion = new Companion(null);
        List<DayFlags> listListOf = CollectionsKt.listOf((Object[]) new DayFlags[]{dayFlags, dayFlags2});
        WEEKENDS = listListOf;
        WEEKDAYS = CollectionsKt.minus((Iterable) getEntries(), (Iterable) listListOf);
    }

    private DayFlags(String str, int i3, int i4, DayOfWeek dayOfWeek) {
        this.value = i4;
        this.dayOfWeek = dayOfWeek;
    }

    public static final int getAllDays() {
        return Companion.a();
    }

    @JvmStatic
    public static final DayFlags getDayByOrder(int i3) {
        return Companion.e(i3);
    }

    @JvmStatic
    public static final String getDayLetterByDay(DayFlags dayFlags) {
        return Companion.f(dayFlags);
    }

    @JvmStatic
    public static final String getDaysString(int i3, boolean z2) {
        return Companion.g(i3, z2);
    }

    public static EnumEntries<DayFlags> getEntries() {
        return $ENTRIES;
    }

    public static DayFlags valueOf(String str) {
        return (DayFlags) Enum.valueOf(DayFlags.class, str);
    }

    public static DayFlags[] values() {
        return (DayFlags[]) $VALUES.clone();
    }

    public final DayFlags addDays(int i3) {
        EnumEntries<DayFlags> entries = getEntries();
        int iOrdinal = ordinal() + i3;
        int size = getEntries().size();
        int i4 = iOrdinal % size;
        return entries.get(i4 + (size & (((i4 ^ size) & ((-i4) | i4)) >> 31)));
    }

    public final DayOfWeek getDayOfWeek() {
        return this.dayOfWeek;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int i3) {
        this.value = i3;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.value);
    }
}
