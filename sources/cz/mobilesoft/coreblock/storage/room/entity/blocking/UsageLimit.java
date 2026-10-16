package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class UsageLimit implements Parcelable, Serializable {
    public static final Parcelable.Creator<UsageLimit> CREATOR = new Creator();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f126504j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PeriodType f126507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LimitType f126508d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f126509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f126510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f126511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f126512i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<UsageLimit> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UsageLimit createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UsageLimit(parcel.readLong(), parcel.readLong(), PeriodType.CREATOR.createFromParcel(parcel), LimitType.valueOf(parcel.readString()), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final UsageLimit[] newArray(int i3) {
            return new UsageLimit[i3];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LimitType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LimitType[] $VALUES;
        public static final Companion Companion;
        private static final Lazy<Map<Integer, LimitType>> allById$delegate;
        private final int freeCountLimit;
        private final int id;
        public static final LimitType TIME = new LimitType("TIME", 0, 0, Limit.USAGE_LIMIT.getLimitValue() * 60000);
        public static final LimitType LAUNCH_COUNT = new LimitType("LAUNCH_COUNT", 1, 1, Limit.LAUNCH_COUNT.getLimitValue());

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map a() {
                return (Map) LimitType.allById$delegate.getValue();
            }

            public final LimitType b(int i3) {
                LimitType limitType = (LimitType) a().get(Integer.valueOf(i3));
                return limitType == null ? LimitType.TIME : limitType;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final LimitType a(int i3) {
                return LimitType.Companion.b(i3);
            }

            public final int b(LimitType sourceType) {
                Intrinsics.checkNotNullParameter(sourceType, "sourceType");
                return sourceType.getId();
            }
        }

        private static final /* synthetic */ LimitType[] $values() {
            return new LimitType[]{TIME, LAUNCH_COUNT};
        }

        static {
            LimitType[] limitTypeArr$values = $values();
            $VALUES = limitTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(limitTypeArr$values);
            Companion = new Companion(null);
            allById$delegate = LazyKt.b(new Function0() { // from class: f2.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UsageLimit.LimitType.allById_delegate$lambda$0();
                }
            });
        }

        private LimitType(String str, int i3, int i4, int i5) {
            this.id = i4;
            this.freeCountLimit = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map allById_delegate$lambda$0() {
            EnumEntries<LimitType> entries = getEntries();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
            for (LimitType limitType : entries) {
                linkedHashMap.put(Integer.valueOf(limitType.id), limitType);
            }
            return linkedHashMap;
        }

        @JvmStatic
        public static final LimitType getById(int i3) {
            return Companion.b(i3);
        }

        public static EnumEntries<LimitType> getEntries() {
            return $ENTRIES;
        }

        public static LimitType valueOf(String str) {
            return (LimitType) Enum.valueOf(LimitType.class, str);
        }

        public static LimitType[] values() {
            return (LimitType[]) $VALUES.clone();
        }

        public final int getFreeCountLimit() {
            return this.freeCountLimit;
        }

        public final int getId() {
            return this.id;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PeriodType implements Parcelable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PeriodType[] $VALUES;
        public static final Parcelable.Creator<PeriodType> CREATOR;
        public static final Companion Companion;
        public static final PeriodType DAILY = new PeriodType("DAILY", 0, 0);
        public static final PeriodType HOURLY = new PeriodType("HOURLY", 1, 1);
        private static final Lazy<Map<Integer, PeriodType>> allById$delegate;
        private final int id;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map a() {
                return (Map) PeriodType.allById$delegate.getValue();
            }

            public final PeriodType b(int i3) {
                PeriodType periodType = (PeriodType) a().get(Integer.valueOf(i3));
                return periodType == null ? PeriodType.DAILY : periodType;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final PeriodType a(int i3) {
                return PeriodType.Companion.b(i3);
            }

            public final int b(PeriodType periodType) {
                Intrinsics.checkNotNullParameter(periodType, "periodType");
                return periodType.getId();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<PeriodType> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final PeriodType createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return PeriodType.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final PeriodType[] newArray(int i3) {
                return new PeriodType[i3];
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f126513a;

            static {
                int[] iArr = new int[PeriodType.values().length];
                try {
                    iArr[PeriodType.DAILY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PeriodType.HOURLY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f126513a = iArr;
            }
        }

        private static final /* synthetic */ PeriodType[] $values() {
            return new PeriodType[]{DAILY, HOURLY};
        }

        static {
            PeriodType[] periodTypeArr$values = $values();
            $VALUES = periodTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(periodTypeArr$values);
            Companion = new Companion(null);
            CREATOR = new Creator();
            allById$delegate = LazyKt.b(new Function0() { // from class: f2.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UsageLimit.PeriodType.allById_delegate$lambda$0();
                }
            });
        }

        private PeriodType(String str, int i3, int i4) {
            this.id = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map allById_delegate$lambda$0() {
            EnumEntries<PeriodType> entries = getEntries();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
            for (PeriodType periodType : entries) {
                linkedHashMap.put(Integer.valueOf(periodType.id), periodType);
            }
            return linkedHashMap;
        }

        @JvmStatic
        public static final PeriodType getById(int i3) {
            return Companion.b(i3);
        }

        public static EnumEntries<PeriodType> getEntries() {
            return $ENTRIES;
        }

        public static PeriodType valueOf(String str) {
            return (PeriodType) Enum.valueOf(PeriodType.class, str);
        }

        public static PeriodType[] values() {
            return (PeriodType[]) $VALUES.clone();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getDescriptionResId() {
            int i3 = WhenMappings.f126513a[ordinal()];
            if (i3 == 1) {
                return R.string.Hn;
            }
            if (i3 == 2) {
                return R.string.In;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final int getId() {
            return this.id;
        }

        public final int getPerPeriodRes() {
            int i3 = WhenMappings.f126513a[ordinal()];
            if (i3 == 1) {
                return R.string.Hn;
            }
            if (i3 == 2) {
                return R.string.In;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final int getTitleRes() {
            int i3 = WhenMappings.f126513a[ordinal()];
            if (i3 == 1) {
                return R.string.AD;
            }
            if (i3 == 2) {
                return R.string.DD;
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(name());
        }
    }

    public UsageLimit(long j3, long j4, PeriodType periodType, LimitType limitType, long j5, long j6, long j7, long j8) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(limitType, "limitType");
        this.f126505a = j3;
        this.f126506b = j4;
        this.f126507c = periodType;
        this.f126508d = limitType;
        this.f126509f = j5;
        this.f126510g = j6;
        this.f126511h = j7;
        this.f126512i = j8;
    }

    public final long c() {
        return this.f126506b;
    }

    public final long d() {
        return this.f126510g;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final long e() {
        return this.f126511h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsageLimit)) {
            return false;
        }
        UsageLimit usageLimit = (UsageLimit) obj;
        return this.f126505a == usageLimit.f126505a && this.f126506b == usageLimit.f126506b && this.f126507c == usageLimit.f126507c && this.f126508d == usageLimit.f126508d && this.f126509f == usageLimit.f126509f && this.f126510g == usageLimit.f126510g && this.f126511h == usageLimit.f126511h && this.f126512i == usageLimit.f126512i;
    }

    public final long f() {
        return this.f126510g;
    }

    public final long g() {
        return this.f126505a;
    }

    public final long h() {
        return this.f126509f;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.f126505a) * 31) + Long.hashCode(this.f126506b)) * 31) + this.f126507c.hashCode()) * 31) + this.f126508d.hashCode()) * 31) + Long.hashCode(this.f126509f)) * 31) + Long.hashCode(this.f126510g)) * 31) + Long.hashCode(this.f126511h)) * 31) + Long.hashCode(this.f126512i);
    }

    public final LimitType i() {
        return this.f126508d;
    }

    public final long j() {
        return this.f126512i;
    }

    public final PeriodType k() {
        return this.f126507c;
    }

    public final long l() {
        return this.f126506b;
    }

    public final long m() {
        return this.f126511h;
    }

    public final boolean n() {
        return this.f126508d == LimitType.LAUNCH_COUNT ? this.f126510g < ((long) Limit.LAUNCH_COUNT.getLimitValue()) : this.f126510g < ((long) Limit.USAGE_LIMIT.getLimitValue());
    }

    public final void o(long j3) {
        this.f126509f = j3;
    }

    public final void p(long j3) {
        this.f126511h = j3;
    }

    public String toString() {
        return "UsageLimit(id=" + this.f126505a + ", profileId=" + this.f126506b + ", periodType=" + this.f126507c + ", limitType=" + this.f126508d + ", lastResetTime=" + this.f126509f + ", allowedCount=" + this.f126510g + ", usedCount=" + this.f126511h + ", originalAllowedCount=" + this.f126512i + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, cJfnYMIyomoWf.ljiHPVKMbBw);
        parcel.writeLong(this.f126505a);
        parcel.writeLong(this.f126506b);
        this.f126507c.writeToParcel(parcel, i3);
        parcel.writeString(this.f126508d.name());
        parcel.writeLong(this.f126509f);
        parcel.writeLong(this.f126510g);
        parcel.writeLong(this.f126511h);
        parcel.writeLong(this.f126512i);
    }

    public /* synthetic */ UsageLimit(long j3, long j4, PeriodType periodType, LimitType limitType, long j5, long j6, long j7, long j8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, j4, periodType, limitType, j5, j6, j7, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0L : j8);
    }
}
