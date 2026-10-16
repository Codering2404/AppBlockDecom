package com.superwall.sdk.store.testmode.models;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable
public final class SuperwallProductSubscription {
    private final SuperwallSubscriptionPeriod period;
    private final int periodCount;
    private final Integer trialPeriodDays;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {SuperwallSubscriptionPeriod.Companion.serializer(), null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SuperwallProductSubscription> serializer() {
            return SuperwallProductSubscription$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SuperwallProductSubscription(int i3, SuperwallSubscriptionPeriod superwallSubscriptionPeriod, int i4, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, SuperwallProductSubscription$$serializer.INSTANCE.getDescriptor());
        }
        this.period = superwallSubscriptionPeriod;
        if ((i3 & 2) == 0) {
            this.periodCount = 1;
        } else {
            this.periodCount = i4;
        }
        if ((i3 & 4) == 0) {
            this.trialPeriodDays = null;
        } else {
            this.trialPeriodDays = num;
        }
    }

    public static /* synthetic */ SuperwallProductSubscription copy$default(SuperwallProductSubscription superwallProductSubscription, SuperwallSubscriptionPeriod superwallSubscriptionPeriod, int i3, Integer num, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            superwallSubscriptionPeriod = superwallProductSubscription.period;
        }
        if ((i4 & 2) != 0) {
            i3 = superwallProductSubscription.periodCount;
        }
        if ((i4 & 4) != 0) {
            num = superwallProductSubscription.trialPeriodDays;
        }
        return superwallProductSubscription.copy(superwallSubscriptionPeriod, i3, num);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(SuperwallProductSubscription superwallProductSubscription, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], superwallProductSubscription.period);
        if (compositeEncoder.z(serialDescriptor, 1) || superwallProductSubscription.periodCount != 1) {
            compositeEncoder.w(serialDescriptor, 1, superwallProductSubscription.periodCount);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && superwallProductSubscription.trialPeriodDays == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 2, IntSerializer.f142823a, superwallProductSubscription.trialPeriodDays);
    }

    public final SuperwallSubscriptionPeriod component1() {
        return this.period;
    }

    public final int component2() {
        return this.periodCount;
    }

    public final Integer component3() {
        return this.trialPeriodDays;
    }

    public final SuperwallProductSubscription copy(SuperwallSubscriptionPeriod period, int i3, Integer num) {
        Intrinsics.checkNotNullParameter(period, "period");
        return new SuperwallProductSubscription(period, i3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperwallProductSubscription)) {
            return false;
        }
        SuperwallProductSubscription superwallProductSubscription = (SuperwallProductSubscription) obj;
        return this.period == superwallProductSubscription.period && this.periodCount == superwallProductSubscription.periodCount && Intrinsics.areEqual(this.trialPeriodDays, superwallProductSubscription.trialPeriodDays);
    }

    public final SuperwallSubscriptionPeriod getPeriod() {
        return this.period;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final Integer getTrialPeriodDays() {
        return this.trialPeriodDays;
    }

    public int hashCode() {
        int iHashCode = ((this.period.hashCode() * 31) + Integer.hashCode(this.periodCount)) * 31;
        Integer num = this.trialPeriodDays;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "SuperwallProductSubscription(period=" + this.period + ", periodCount=" + this.periodCount + ", trialPeriodDays=" + this.trialPeriodDays + ")";
    }

    public SuperwallProductSubscription(SuperwallSubscriptionPeriod period, int i3, Integer num) {
        Intrinsics.checkNotNullParameter(period, "period");
        this.period = period;
        this.periodCount = i3;
        this.trialPeriodDays = num;
    }

    public /* synthetic */ SuperwallProductSubscription(SuperwallSubscriptionPeriod superwallSubscriptionPeriod, int i3, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(superwallSubscriptionPeriod, (i4 & 2) != 0 ? 1 : i3, (i4 & 4) != 0 ? null : num);
    }

    @SerialName
    public static /* synthetic */ void getPeriodCount$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTrialPeriodDays$annotations() {
    }
}
