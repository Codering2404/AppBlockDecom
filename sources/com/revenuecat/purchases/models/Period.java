package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class Period implements Parcelable {
    private final String iso8601;
    private final Unit unit;
    private final int value;
    public static final Factory Factory = new Factory(null);
    public static final Parcelable.Creator<Period> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<Period> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Period createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Period(parcel.readInt(), Unit.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Period[] newArray(int i3) {
            return new Period[i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Period create(String iso8601) {
            Intrinsics.checkNotNullParameter(iso8601, "iso8601");
            Pair period = PeriodKt.toPeriod(iso8601);
            return new Period(((Number) period.e()).intValue(), (Unit) period.f(), iso8601);
        }

        private Factory() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Unit {
        DAY,
        WEEK,
        MONTH,
        YEAR,
        UNKNOWN
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Unit.values().length];
            try {
                iArr[Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Period(int i3, Unit unit, String iso8601) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(iso8601, "iso8601");
        this.value = i3;
        this.unit = unit;
        this.iso8601 = iso8601;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.value == period.value && this.unit == period.unit && Intrinsics.areEqual(this.iso8601, period.iso8601);
    }

    public final String getIso8601() {
        return this.iso8601;
    }

    public final Unit getUnit() {
        return this.unit;
    }

    public final int getValue() {
        return this.value;
    }

    public final double getValueInDays() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            return this.value;
        }
        if (i3 == 2) {
            return ((double) this.value) * 7.0d;
        }
        if (i3 == 3) {
            return ((double) this.value) * 30.0d;
        }
        if (i3 == 4) {
            return ((double) this.value) * 365.0d;
        }
        if (i3 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unknown period unit trying to get value in days: " + this.unit, null);
        return 0.0d;
    }

    public final double getValueInMonths() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            return ((double) this.value) / 30.0d;
        }
        if (i3 == 2) {
            return ((double) this.value) / 4.345238095238096d;
        }
        if (i3 == 3) {
            return this.value;
        }
        if (i3 == 4) {
            return ((double) this.value) * 12.0d;
        }
        if (i3 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unknown period unit trying to get value in months: " + this.unit, null);
        return 0.0d;
    }

    public final double getValueInWeeks() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            return ((double) this.value) / 7.0d;
        }
        if (i3 == 2) {
            return this.value;
        }
        if (i3 == 3) {
            return ((double) this.value) * 4.345238095238096d;
        }
        if (i3 == 4) {
            return ((double) this.value) * 52.142857142857146d;
        }
        if (i3 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unknown period unit trying to get value in weeks: " + this.unit, null);
        return 0.0d;
    }

    public final double getValueInYears() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            return ((double) this.value) / 365.0d;
        }
        if (i3 == 2) {
            return ((double) this.value) / 52.142857142857146d;
        }
        if (i3 == 3) {
            return ((double) this.value) / 12.0d;
        }
        if (i3 == 4) {
            return this.value;
        }
        if (i3 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unknown period unit trying to get value in years: " + this.unit, null);
        return 0.0d;
    }

    public int hashCode() {
        return (((this.value * 31) + this.unit.hashCode()) * 31) + this.iso8601.hashCode();
    }

    public String toString() {
        return "Period(value=" + this.value + ", unit=" + this.unit + ", iso8601=" + this.iso8601 + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.value);
        out.writeString(this.unit.name());
        out.writeString(this.iso8601);
    }

    public static /* synthetic */ void getValueInDays$annotations() {
    }

    public static /* synthetic */ void getValueInWeeks$annotations() {
    }

    public static /* synthetic */ void getValueInYears$annotations() {
    }
}
