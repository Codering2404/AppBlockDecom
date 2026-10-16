package com.superwall.sdk.store.abstractions.product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.Period;

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
public final class SubscriptionPeriod {
    public static final Companion Companion = new Companion(null);
    private final int calculationScale;
    private final int outputScale;
    private final RoundingMode roundingMode;
    private final Unit unit;
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubscriptionPeriod from(String subscriptionPeriodString) {
            SubscriptionPeriod subscriptionPeriod;
            SubscriptionPeriod subscriptionPeriod2;
            Intrinsics.checkNotNullParameter(subscriptionPeriodString, "subscriptionPeriodString");
            try {
                Period periodO = Period.o(subscriptionPeriodString);
                int iQ = (((int) periodO.q()) * 30) + periodO.g();
                int i3 = iQ / 7;
                if (iQ % 7 > 0) {
                    subscriptionPeriod = new SubscriptionPeriod(iQ, Unit.day);
                } else if (i3 > 0) {
                    subscriptionPeriod = new SubscriptionPeriod(i3, Unit.week);
                } else {
                    if (periodO.q() > 0) {
                        subscriptionPeriod2 = new SubscriptionPeriod((int) periodO.q(), Unit.month);
                    } else if (periodO.i() > 0) {
                        subscriptionPeriod2 = new SubscriptionPeriod(periodO.i(), Unit.year);
                    } else {
                        subscriptionPeriod = null;
                    }
                    subscriptionPeriod = subscriptionPeriod2;
                }
                if (subscriptionPeriod != null) {
                    return subscriptionPeriod.normalized();
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Unit {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Unit[] $VALUES;
        public static final Unit day = new Unit("day", 0);
        public static final Unit week = new Unit("week", 1);
        public static final Unit month = new Unit("month", 2);
        public static final Unit year = new Unit("year", 3);

        private static final /* synthetic */ Unit[] $values() {
            return new Unit[]{day, week, month, year};
        }

        static {
            Unit[] unitArr$values = $values();
            $VALUES = unitArr$values;
            $ENTRIES = EnumEntriesKt.a(unitArr$values);
        }

        private Unit(String str, int i3) {
        }

        public static EnumEntries<Unit> getEntries() {
            return $ENTRIES;
        }

        public static Unit valueOf(String str) {
            return (Unit) Enum.valueOf(Unit.class, str);
        }

        public static Unit[] values() {
            return (Unit[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Unit.values().length];
            try {
                iArr[Unit.day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Unit.week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Unit.month.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Unit.year.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SubscriptionPeriod(int i3, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.value = i3;
        this.unit = unit;
        this.roundingMode = RoundingMode.DOWN;
        this.calculationScale = 7;
        this.outputScale = 2;
    }

    public static /* synthetic */ SubscriptionPeriod copy$default(SubscriptionPeriod subscriptionPeriod, int i3, Unit unit, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = subscriptionPeriod.value;
        }
        if ((i4 & 2) != 0) {
            unit = subscriptionPeriod.unit;
        }
        return subscriptionPeriod.copy(i3, unit);
    }

    public final int component1() {
        return this.value;
    }

    public final Unit component2() {
        return this.unit;
    }

    public final SubscriptionPeriod copy(int i3, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new SubscriptionPeriod(i3, unit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPeriod)) {
            return false;
        }
        SubscriptionPeriod subscriptionPeriod = (SubscriptionPeriod) obj;
        return this.value == subscriptionPeriod.value && this.unit == subscriptionPeriod.unit;
    }

    public final double getDaysPerUnit() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            return 1.0d;
        }
        if (i3 == 2) {
            return 7.0d;
        }
        if (i3 == 3) {
            return 30.0d;
        }
        if (i3 == 4) {
            return 365.0d;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final long getToMillis() {
        long j3 = 60;
        return ((long) (((double) this.value) * getDaysPerUnit())) * ((long) 24) * j3 * j3 * ((long) 1000);
    }

    public final Unit getUnit() {
        return this.unit;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (Integer.hashCode(this.value) * 31) + this.unit.hashCode();
    }

    public final SubscriptionPeriod normalized() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            int i4 = this.value;
            if (i4 % 30 == 0) {
                return copy(i4 / 30, Unit.month).normalized();
            }
            if (i4 % 7 == 0) {
                return copy(i4 / 7, Unit.week).normalized();
            }
            if (i4 % 360 == 0) {
                return copy(i4 / 360, Unit.year);
            }
        } else if (i3 == 3) {
            int i5 = this.value;
            if (i5 % 12 == 0) {
                return copy(i5 / 12, Unit.year);
            }
        }
        return this;
    }

    public final BigDecimal pricePerDay(BigDecimal price) {
        BigDecimal bigDecimal;
        Intrinsics.checkNotNullParameter(price, "price");
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            bigDecimal = BigDecimal.ONE;
        } else if (i3 == 2) {
            bigDecimal = new BigDecimal(7);
        } else if (i3 == 3) {
            bigDecimal = new BigDecimal(365).divide(new BigDecimal(12), this.calculationScale, this.roundingMode);
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            bigDecimal = new BigDecimal(365);
        }
        Intrinsics.checkNotNull(bigDecimal);
        BigDecimal bigDecimalMultiply = bigDecimal.multiply(new BigDecimal(this.value));
        Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, "multiply(...)");
        BigDecimal bigDecimalDivide = price.divide(bigDecimalMultiply, this.outputScale, this.roundingMode);
        Intrinsics.checkNotNullExpressionValue(bigDecimalDivide, "divide(...)");
        return bigDecimalDivide;
    }

    public final BigDecimal pricePerMonth(BigDecimal price) {
        BigDecimal bigDecimalDivide;
        Intrinsics.checkNotNullParameter(price, "price");
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            bigDecimalDivide = new BigDecimal(12).divide(new BigDecimal(365), this.calculationScale, this.roundingMode);
        } else if (i3 == 2) {
            bigDecimalDivide = new BigDecimal(12).divide(new BigDecimal(52), this.calculationScale, this.roundingMode);
        } else if (i3 == 3) {
            bigDecimalDivide = BigDecimal.ONE;
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            bigDecimalDivide = new BigDecimal(12);
        }
        Intrinsics.checkNotNull(bigDecimalDivide);
        BigDecimal bigDecimalMultiply = bigDecimalDivide.multiply(new BigDecimal(this.value));
        Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, "multiply(...)");
        BigDecimal bigDecimalDivide2 = price.divide(bigDecimalMultiply, this.outputScale, this.roundingMode);
        Intrinsics.checkNotNullExpressionValue(bigDecimalDivide2, "divide(...)");
        return bigDecimalDivide2;
    }

    public final BigDecimal pricePerWeek(BigDecimal price) {
        BigDecimal bigDecimalDivide;
        Intrinsics.checkNotNullParameter(price, "price");
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            bigDecimalDivide = BigDecimal.ONE.divide(new BigDecimal(7), this.calculationScale, this.roundingMode);
        } else if (i3 == 2) {
            bigDecimalDivide = BigDecimal.ONE;
        } else if (i3 == 3) {
            bigDecimalDivide = new BigDecimal(52).divide(new BigDecimal(12), this.calculationScale, this.roundingMode);
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            bigDecimalDivide = new BigDecimal(52);
        }
        Intrinsics.checkNotNull(bigDecimalDivide);
        BigDecimal bigDecimalMultiply = bigDecimalDivide.multiply(new BigDecimal(this.value));
        Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, "multiply(...)");
        BigDecimal bigDecimalDivide2 = price.divide(bigDecimalMultiply, this.outputScale, this.roundingMode);
        Intrinsics.checkNotNullExpressionValue(bigDecimalDivide2, "divide(...)");
        return bigDecimalDivide2;
    }

    public final BigDecimal pricePerYear(BigDecimal price) {
        BigDecimal bigDecimalDivide;
        Intrinsics.checkNotNullParameter(price, "price");
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            bigDecimalDivide = BigDecimal.ONE.divide(new BigDecimal(365), this.calculationScale, this.roundingMode);
        } else if (i3 == 2) {
            bigDecimalDivide = BigDecimal.ONE.divide(new BigDecimal(52), this.calculationScale, this.roundingMode);
        } else if (i3 == 3) {
            bigDecimalDivide = BigDecimal.ONE.divide(new BigDecimal(12), this.calculationScale, this.roundingMode);
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            bigDecimalDivide = BigDecimal.ONE;
        }
        BigDecimal bigDecimalMultiply = bigDecimalDivide.multiply(new BigDecimal(this.value));
        Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, "multiply(...)");
        BigDecimal bigDecimalDivide2 = price.divide(bigDecimalMultiply, this.outputScale, this.roundingMode);
        Intrinsics.checkNotNullExpressionValue(bigDecimalDivide2, "divide(...)");
        return bigDecimalDivide2;
    }

    public final long toMillis() {
        int i3;
        int i4 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i4 == 1) {
            i3 = this.value;
        } else if (i4 == 2) {
            i3 = this.value * 7;
        } else if (i4 == 3) {
            i3 = this.value * 30;
        } else {
            if (i4 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            i3 = this.value * 365;
        }
        long j3 = 60;
        return ((long) i3) * 24 * j3 * j3 * ((long) 1000);
    }

    public final Period toPeriod() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i3 == 1) {
            Period periodK = Period.k(this.value);
            Intrinsics.checkNotNullExpressionValue(periodK, "ofDays(...)");
            return periodK;
        }
        if (i3 == 2) {
            Period periodM = Period.m(this.value);
            Intrinsics.checkNotNullExpressionValue(periodM, "ofWeeks(...)");
            return periodM;
        }
        if (i3 == 3) {
            Period periodL = Period.l(this.value);
            Intrinsics.checkNotNullExpressionValue(periodL, "ofMonths(...)");
            return periodL;
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        Period periodN = Period.n(this.value);
        Intrinsics.checkNotNullExpressionValue(periodN, "ofYears(...)");
        return periodN;
    }

    public String toString() {
        return "SubscriptionPeriod(value=" + this.value + ", unit=" + this.unit + ")";
    }
}
