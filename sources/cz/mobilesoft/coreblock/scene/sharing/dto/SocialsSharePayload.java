package cz.mobilesoft.coreblock.scene.sharing.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
public final class SocialsSharePayload implements Parcelable {
    public static final Parcelable.Creator<SocialsSharePayload> CREATOR = new Creator();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f119374r = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PeriodType f119375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f119376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f119377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f119378d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f119379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f119380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f119381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f119382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f119383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Float f119384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Long f119385l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Boolean f119386m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f119387n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f119388o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f119389p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AppDistractionType f119390q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ColorfulBarSection implements Parcelable {
        public static final Parcelable.Creator<ColorfulBarSection> CREATOR = new Creator();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f119391c = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f119392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AppDistractionType f119393b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<ColorfulBarSection> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ColorfulBarSection createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ColorfulBarSection(parcel.readFloat(), AppDistractionType.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ColorfulBarSection[] newArray(int i3) {
                return new ColorfulBarSection[i3];
            }
        }

        public ColorfulBarSection(float f3, AppDistractionType appDistractionType) {
            Intrinsics.checkNotNullParameter(appDistractionType, "appDistractionType");
            this.f119392a = f3;
            this.f119393b = appDistractionType;
        }

        public final AppDistractionType c() {
            return this.f119393b;
        }

        public final float d() {
            return this.f119392a;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ColorfulBarSection)) {
                return false;
            }
            ColorfulBarSection colorfulBarSection = (ColorfulBarSection) obj;
            return Float.compare(this.f119392a, colorfulBarSection.f119392a) == 0 && this.f119393b == colorfulBarSection.f119393b;
        }

        public int hashCode() {
            return (Float.hashCode(this.f119392a) * 31) + this.f119393b.hashCode();
        }

        public String toString() {
            return "ColorfulBarSection(value=" + this.f119392a + ", appDistractionType=" + this.f119393b + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeFloat(this.f119392a);
            dest.writeString(this.f119393b.name());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ColorfulBarValue implements Parcelable {
        public static final Parcelable.Creator<ColorfulBarValue> CREATOR = new Creator();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f119394b = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f119395a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<ColorfulBarValue> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ColorfulBarValue createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i3 = parcel.readInt();
                ArrayList arrayList = new ArrayList(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    arrayList.add(ColorfulBarSection.CREATOR.createFromParcel(parcel));
                }
                return new ColorfulBarValue(arrayList);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ColorfulBarValue[] newArray(int i3) {
                return new ColorfulBarValue[i3];
            }
        }

        public ColorfulBarValue(List sections) {
            Intrinsics.checkNotNullParameter(sections, "sections");
            this.f119395a = sections;
        }

        public final List c() {
            return this.f119395a;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ColorfulBarValue) && Intrinsics.areEqual(this.f119395a, ((ColorfulBarValue) obj).f119395a);
        }

        public int hashCode() {
            return this.f119395a.hashCode();
        }

        public String toString() {
            return "ColorfulBarValue(sections=" + this.f119395a + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            List list = this.f119395a;
            dest.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ColorfulBarSection) it.next()).writeToParcel(dest, i3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<SocialsSharePayload> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SocialsSharePayload createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            PeriodType periodTypeValueOf = PeriodType.valueOf(parcel.readString());
            int i3 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList2.add(Float.valueOf(parcel.readFloat()));
            }
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i5 = parcel.readInt();
                arrayList = new ArrayList(i5);
                for (int i6 = 0; i6 != i5; i6++) {
                    arrayList.add(ColorfulBarValue.CREATOR.createFromParcel(parcel));
                }
            }
            return new SocialsSharePayload(periodTypeValueOf, arrayList2, arrayListCreateStringArrayList, arrayList, parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? AppDistractionType.valueOf(parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SocialsSharePayload[] newArray(int i3) {
            return new SocialsSharePayload[i3];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PeriodType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PeriodType[] $VALUES;
        public static final PeriodType Day = new PeriodType("Day", 0);
        public static final PeriodType Week = new PeriodType("Week", 1);
        public static final PeriodType Trend = new PeriodType("Trend", 2);
        public static final PeriodType WeeklyReport = new PeriodType("WeeklyReport", 3);

        private static final /* synthetic */ PeriodType[] $values() {
            return new PeriodType[]{Day, Week, Trend, WeeklyReport};
        }

        static {
            PeriodType[] periodTypeArr$values = $values();
            $VALUES = periodTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(periodTypeArr$values);
        }

        private PeriodType(String str, int i3) {
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
    }

    public SocialsSharePayload(PeriodType periodType, List barValues, List list, List list2, int i3, String formattedCurrentScreenTime, int i4, long j3, long j4, Float f3, Long l3, Boolean bool, String formattedTrendTime, String str, String str2, AppDistractionType appDistractionType) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(barValues, "barValues");
        Intrinsics.checkNotNullParameter(formattedCurrentScreenTime, "formattedCurrentScreenTime");
        Intrinsics.checkNotNullParameter(formattedTrendTime, "formattedTrendTime");
        this.f119375a = periodType;
        this.f119376b = barValues;
        this.f119377c = list;
        this.f119378d = list2;
        this.f119379f = i3;
        this.f119380g = formattedCurrentScreenTime;
        this.f119381h = i4;
        this.f119382i = j3;
        this.f119383j = j4;
        this.f119384k = f3;
        this.f119385l = l3;
        this.f119386m = bool;
        this.f119387n = formattedTrendTime;
        this.f119388o = str;
        this.f119389p = str2;
        this.f119390q = appDistractionType;
    }

    public final AppDistractionType c() {
        return this.f119390q;
    }

    public final List d() {
        return this.f119377c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final List e() {
        return this.f119376b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SocialsSharePayload)) {
            return false;
        }
        SocialsSharePayload socialsSharePayload = (SocialsSharePayload) obj;
        return this.f119375a == socialsSharePayload.f119375a && Intrinsics.areEqual(this.f119376b, socialsSharePayload.f119376b) && Intrinsics.areEqual(this.f119377c, socialsSharePayload.f119377c) && Intrinsics.areEqual(this.f119378d, socialsSharePayload.f119378d) && this.f119379f == socialsSharePayload.f119379f && Intrinsics.areEqual(this.f119380g, socialsSharePayload.f119380g) && this.f119381h == socialsSharePayload.f119381h && this.f119382i == socialsSharePayload.f119382i && this.f119383j == socialsSharePayload.f119383j && Intrinsics.areEqual((Object) this.f119384k, (Object) socialsSharePayload.f119384k) && Intrinsics.areEqual(this.f119385l, socialsSharePayload.f119385l) && Intrinsics.areEqual(this.f119386m, socialsSharePayload.f119386m) && Intrinsics.areEqual(this.f119387n, socialsSharePayload.f119387n) && Intrinsics.areEqual(this.f119388o, socialsSharePayload.f119388o) && Intrinsics.areEqual(this.f119389p, socialsSharePayload.f119389p) && this.f119390q == socialsSharePayload.f119390q;
    }

    public final List f() {
        return this.f119378d;
    }

    public final Long g() {
        return this.f119385l;
    }

    public final int h() {
        return this.f119381h;
    }

    public int hashCode() {
        int iHashCode = ((this.f119375a.hashCode() * 31) + this.f119376b.hashCode()) * 31;
        List list = this.f119377c;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List list2 = this.f119378d;
        int iHashCode3 = (((((((((((iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31) + Integer.hashCode(this.f119379f)) * 31) + this.f119380g.hashCode()) * 31) + Integer.hashCode(this.f119381h)) * 31) + Long.hashCode(this.f119382i)) * 31) + Long.hashCode(this.f119383j)) * 31;
        Float f3 = this.f119384k;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Long l3 = this.f119385l;
        int iHashCode5 = (iHashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Boolean bool = this.f119386m;
        int iHashCode6 = (((iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31) + this.f119387n.hashCode()) * 31;
        String str = this.f119388o;
        int iHashCode7 = (iHashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f119389p;
        int iHashCode8 = (iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        AppDistractionType appDistractionType = this.f119390q;
        return iHashCode8 + (appDistractionType != null ? appDistractionType.hashCode() : 0);
    }

    public final String i() {
        return this.f119380g;
    }

    public final String j() {
        return this.f119387n;
    }

    public final int k() {
        return this.f119379f;
    }

    public final long l() {
        return this.f119383j;
    }

    public final long m() {
        return this.f119382i;
    }

    public final PeriodType n() {
        return this.f119375a;
    }

    public final String o() {
        return this.f119389p;
    }

    public final String p() {
        return this.f119388o;
    }

    public final Float q() {
        return this.f119384k;
    }

    public final Boolean r() {
        return this.f119386m;
    }

    public String toString() {
        return "SocialsSharePayload(periodType=" + this.f119375a + ", barValues=" + this.f119376b + ", barLabels=" + this.f119377c + ", colorfulBarValues=" + this.f119378d + ", horizontalAxisCount=" + this.f119379f + ", formattedCurrentScreenTime=" + this.f119380g + ", distractionsPreventedCount=" + this.f119381h + ", intervalStartMillis=" + this.f119382i + ", intervalEndMillis=" + this.f119383j + ", weeklyDifferencePercentage=" + this.f119384k + ", dayDifferenceSeconds=" + this.f119385l + ", isTrendIncrease=" + this.f119386m + ", formattedTrendTime=" + this.f119387n + ", trendIntervalLabel=" + this.f119388o + ", trendAveragePerDayFormatted=" + this.f119389p + ", appDistractionTypeFilter=" + this.f119390q + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f119375a.name());
        List list = this.f119376b;
        dest.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dest.writeFloat(((Number) it.next()).floatValue());
        }
        dest.writeStringList(this.f119377c);
        List list2 = this.f119378d;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                ((ColorfulBarValue) it2.next()).writeToParcel(dest, i3);
            }
        }
        dest.writeInt(this.f119379f);
        dest.writeString(this.f119380g);
        dest.writeInt(this.f119381h);
        dest.writeLong(this.f119382i);
        dest.writeLong(this.f119383j);
        Float f3 = this.f119384k;
        if (f3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeFloat(f3.floatValue());
        }
        Long l3 = this.f119385l;
        if (l3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l3.longValue());
        }
        Boolean bool = this.f119386m;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.f119387n);
        dest.writeString(this.f119388o);
        dest.writeString(this.f119389p);
        AppDistractionType appDistractionType = this.f119390q;
        if (appDistractionType == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(appDistractionType.name());
        }
    }

    public /* synthetic */ SocialsSharePayload(PeriodType periodType, List list, List list2, List list3, int i3, String str, int i4, long j3, long j4, Float f3, Long l3, Boolean bool, String str2, String str3, String str4, AppDistractionType appDistractionType, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(periodType, list, (i5 & 4) != 0 ? null : list2, (i5 & 8) != 0 ? null : list3, (i5 & 16) != 0 ? 3 : i3, (i5 & 32) != 0 ? "" : str, (i5 & 64) != 0 ? 0 : i4, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0L : j3, (i5 & Function.MAX_NARGS) != 0 ? 0L : j4, (i5 & 512) != 0 ? null : f3, (i5 & 1024) != 0 ? null : l3, (i5 & 2048) != 0 ? null : bool, (i5 & 4096) != 0 ? "" : str2, (i5 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str3, (i5 & 16384) != 0 ? null : str4, (i5 & 32768) != 0 ? null : appDistractionType);
    }
}
