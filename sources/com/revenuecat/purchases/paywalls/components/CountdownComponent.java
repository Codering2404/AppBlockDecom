package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.utils.serializers.ISO8601DateSerializer;
import java.lang.annotation.Annotation;
import java.util.Date;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
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
/* JADX INFO: loaded from: classes6.dex */
@SerialName
@Metadata
@Serializable
public final class CountdownComponent implements PaywallComponent {
    private final CountFrom countFrom;
    private final StackComponent countdownStack;
    private final StackComponent endStack;
    private final StackComponent fallback;
    private final CountdownStyle style;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, CountFrom.Companion.serializer(), null, null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CountdownComponent> serializer() {
            return CountdownComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public enum CountFrom {
        DAYS,
        HOURS,
        MINUTES;

        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.CountdownComponent.CountFrom.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return EnumsKt.a("com.revenuecat.purchases.paywalls.components.CountdownComponent.CountFrom", CountFrom.values(), new String[]{"days", "hours", "minutes"}, new Annotation[][]{null, null, null}, null);
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) CountFrom.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<CountFrom> serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class CountdownStyle {
        public static final Companion Companion = new Companion(null);
        private final Date date;
        private final String type;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CountdownStyle> serializer() {
                return CountdownComponent$CountdownStyle$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ CountdownStyle(int i3, String str, @Serializable(with = ISO8601DateSerializer.class) Date date, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, CountdownComponent$CountdownStyle$$serializer.INSTANCE.getDescriptor());
            }
            this.type = str;
            this.date = date;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CountdownStyle countdownStyle, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.y(serialDescriptor, 0, countdownStyle.type);
            compositeEncoder.C(serialDescriptor, 1, ISO8601DateSerializer.INSTANCE, countdownStyle.date);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CountdownStyle)) {
                return false;
            }
            CountdownStyle countdownStyle = (CountdownStyle) obj;
            return Intrinsics.areEqual(this.type, countdownStyle.type) && Intrinsics.areEqual(this.date, countdownStyle.date);
        }

        public final /* synthetic */ Date getDate() {
            return this.date;
        }

        public final /* synthetic */ String getType() {
            return this.type;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.date.hashCode();
        }

        public String toString() {
            return "CountdownStyle(type=" + this.type + ", date=" + this.date + ')';
        }

        public CountdownStyle(String type, Date date) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(date, "date");
            this.type = type;
            this.date = date;
        }

        @Serializable(with = ISO8601DateSerializer.class)
        public static /* synthetic */ void getDate$annotations() {
        }
    }

    @Deprecated
    public /* synthetic */ CountdownComponent(int i3, CountdownStyle countdownStyle, @SerialName CountFrom countFrom, @SerialName StackComponent stackComponent, @SerialName StackComponent stackComponent2, StackComponent stackComponent3, SerializationConstructorMarker serializationConstructorMarker) {
        if (5 != (i3 & 5)) {
            PluginExceptionsKt.b(i3, 5, CountdownComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.style = countdownStyle;
        if ((i3 & 2) == 0) {
            this.countFrom = CountFrom.DAYS;
        } else {
            this.countFrom = countFrom;
        }
        this.countdownStack = stackComponent;
        if ((i3 & 8) == 0) {
            this.endStack = null;
        } else {
            this.endStack = stackComponent2;
        }
        if ((i3 & 16) == 0) {
            this.fallback = null;
        } else {
            this.fallback = stackComponent3;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CountdownComponent countdownComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, CountdownComponent$CountdownStyle$$serializer.INSTANCE, countdownComponent.style);
        if (compositeEncoder.z(serialDescriptor, 1) || countdownComponent.countFrom != CountFrom.DAYS) {
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], countdownComponent.countFrom);
        }
        StackComponent$$serializer stackComponent$$serializer = StackComponent$$serializer.INSTANCE;
        compositeEncoder.C(serialDescriptor, 2, stackComponent$$serializer, countdownComponent.countdownStack);
        if (compositeEncoder.z(serialDescriptor, 3) || countdownComponent.endStack != null) {
            compositeEncoder.i(serialDescriptor, 3, stackComponent$$serializer, countdownComponent.endStack);
        }
        if (!compositeEncoder.z(serialDescriptor, 4) && countdownComponent.fallback == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 4, stackComponent$$serializer, countdownComponent.fallback);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountdownComponent)) {
            return false;
        }
        CountdownComponent countdownComponent = (CountdownComponent) obj;
        return Intrinsics.areEqual(this.style, countdownComponent.style) && this.countFrom == countdownComponent.countFrom && Intrinsics.areEqual(this.countdownStack, countdownComponent.countdownStack) && Intrinsics.areEqual(this.endStack, countdownComponent.endStack) && Intrinsics.areEqual(this.fallback, countdownComponent.fallback);
    }

    public final /* synthetic */ CountFrom getCountFrom() {
        return this.countFrom;
    }

    public final /* synthetic */ StackComponent getCountdownStack() {
        return this.countdownStack;
    }

    public final /* synthetic */ StackComponent getEndStack() {
        return this.endStack;
    }

    public final /* synthetic */ StackComponent getFallback() {
        return this.fallback;
    }

    public final /* synthetic */ CountdownStyle getStyle() {
        return this.style;
    }

    public int hashCode() {
        int iHashCode = ((((this.style.hashCode() * 31) + this.countFrom.hashCode()) * 31) + this.countdownStack.hashCode()) * 31;
        StackComponent stackComponent = this.endStack;
        int iHashCode2 = (iHashCode + (stackComponent == null ? 0 : stackComponent.hashCode())) * 31;
        StackComponent stackComponent2 = this.fallback;
        return iHashCode2 + (stackComponent2 != null ? stackComponent2.hashCode() : 0);
    }

    public String toString() {
        return "CountdownComponent(style=" + this.style + ", countFrom=" + this.countFrom + ", countdownStack=" + this.countdownStack + ", endStack=" + this.endStack + ", fallback=" + this.fallback + ')';
    }

    public CountdownComponent(CountdownStyle style, CountFrom countFrom, StackComponent countdownStack, StackComponent stackComponent, StackComponent stackComponent2) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(countdownStack, "countdownStack");
        this.style = style;
        this.countFrom = countFrom;
        this.countdownStack = countdownStack;
        this.endStack = stackComponent;
        this.fallback = stackComponent2;
    }

    public /* synthetic */ CountdownComponent(CountdownStyle countdownStyle, CountFrom countFrom, StackComponent stackComponent, StackComponent stackComponent2, StackComponent stackComponent3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(countdownStyle, (i3 & 2) != 0 ? CountFrom.DAYS : countFrom, stackComponent, (i3 & 8) != 0 ? null : stackComponent2, (i3 & 16) != 0 ? null : stackComponent3);
    }

    @SerialName
    public static /* synthetic */ void getCountFrom$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getCountdownStack$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEndStack$annotations() {
    }
}
