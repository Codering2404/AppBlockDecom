package com.superwall.sdk.paywall.presentation.rule_logic.cel.models;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
@Polymorphic
@Metadata
@Serializable
public interface PassableValue {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class BoolValue implements PassableValue {
        public static final Companion Companion = new Companion(null);
        private final boolean value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BoolValue> serializer() {
                return PassableValue$BoolValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ BoolValue(int i3, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PassableValue$BoolValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = z2;
        }

        public static /* synthetic */ BoolValue copy$default(BoolValue boolValue, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = boolValue.value;
            }
            return boolValue.copy(z2);
        }

        public final boolean component1() {
            return this.value;
        }

        public final BoolValue copy(boolean z2) {
            return new BoolValue(z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BoolValue) && this.value == ((BoolValue) obj).value;
        }

        public final boolean getValue() {
            return this.value;
        }

        public int hashCode() {
            return Boolean.hashCode(this.value);
        }

        public String toString() {
            return "BoolValue(value=" + this.value + ")";
        }

        public BoolValue(boolean z2) {
            this.value = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class BytesValue implements PassableValue {
        public static final Companion Companion = new Companion(null);
        private final byte[] value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BytesValue> serializer() {
                return PassableValue$BytesValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ BytesValue(int i3, byte[] bArr, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PassableValue$BytesValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = bArr;
        }

        public static /* synthetic */ BytesValue copy$default(BytesValue bytesValue, byte[] bArr, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                bArr = bytesValue.value;
            }
            return bytesValue.copy(bArr);
        }

        public final byte[] component1() {
            return this.value;
        }

        public final BytesValue copy(byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new BytesValue(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BytesValue) && Intrinsics.areEqual(this.value, ((BytesValue) obj).value);
        }

        public final byte[] getValue() {
            return this.value;
        }

        public int hashCode() {
            return Arrays.hashCode(this.value);
        }

        public String toString() {
            return "BytesValue(value=" + Arrays.toString(this.value) + ")";
        }

        public BytesValue(byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<PassableValue> serializer() {
            return new SealedClassSerializer("com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue", Reflection.b(PassableValue.class), new KClass[]{Reflection.b(BoolValue.class), Reflection.b(BytesValue.class), Reflection.b(FloatValue.class), Reflection.b(FunctionValue.class), Reflection.b(IntValue.class), Reflection.b(ListValue.class), Reflection.b(MapValue.class), Reflection.b(NullValue.class), Reflection.b(StringValue.class), Reflection.b(TimestampValue.class), Reflection.b(UIntValue.class)}, new KSerializer[]{PassableValue$BoolValue$$serializer.INSTANCE, PassableValue$BytesValue$$serializer.INSTANCE, PassableValue$FloatValue$$serializer.INSTANCE, PassableValue$FunctionValue$$serializer.INSTANCE, PassableValue$IntValue$$serializer.INSTANCE, PassableValue$ListValue$$serializer.INSTANCE, PassableValue$MapValue$$serializer.INSTANCE, new ObjectSerializer("Null", NullValue.INSTANCE, new Annotation[0]), PassableValue$StringValue$$serializer.INSTANCE, PassableValue$TimestampValue$$serializer.INSTANCE, PassableValue$UIntValue$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class FloatValue implements PassableValue {
        public static final Companion Companion = new Companion(null);
        private final double value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<FloatValue> serializer() {
                return PassableValue$FloatValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ FloatValue(int i3, double d3, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PassableValue$FloatValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = d3;
        }

        public static /* synthetic */ FloatValue copy$default(FloatValue floatValue, double d3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                d3 = floatValue.value;
            }
            return floatValue.copy(d3);
        }

        public final double component1() {
            return this.value;
        }

        public final FloatValue copy(double d3) {
            return new FloatValue(d3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FloatValue) && Double.compare(this.value, ((FloatValue) obj).value) == 0;
        }

        public final double getValue() {
            return this.value;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        public String toString() {
            return "FloatValue(value=" + this.value + ")";
        }

        public FloatValue(double d3) {
            this.value = d3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class FunctionValue implements PassableValue {
        private final PassableValue args;
        private final String value;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new PolymorphicSerializer(Reflection.b(PassableValue.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<FunctionValue> serializer() {
                return PassableValue$FunctionValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ FunctionValue(int i3, String str, PassableValue passableValue, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, PassableValue$FunctionValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = str;
            this.args = passableValue;
        }

        public static /* synthetic */ FunctionValue copy$default(FunctionValue functionValue, String str, PassableValue passableValue, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = functionValue.value;
            }
            if ((i3 & 2) != 0) {
                passableValue = functionValue.args;
            }
            return functionValue.copy(str, passableValue);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(FunctionValue functionValue, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.y(serialDescriptor, 0, functionValue.value);
            compositeEncoder.i(serialDescriptor, 1, kSerializerArr[1], functionValue.args);
        }

        public final String component1() {
            return this.value;
        }

        public final PassableValue component2() {
            return this.args;
        }

        public final FunctionValue copy(String value, PassableValue passableValue) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new FunctionValue(value, passableValue);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FunctionValue)) {
                return false;
            }
            FunctionValue functionValue = (FunctionValue) obj;
            return Intrinsics.areEqual(this.value, functionValue.value) && Intrinsics.areEqual(this.args, functionValue.args);
        }

        public final PassableValue getArgs() {
            return this.args;
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            int iHashCode = this.value.hashCode() * 31;
            PassableValue passableValue = this.args;
            return iHashCode + (passableValue == null ? 0 : passableValue.hashCode());
        }

        public String toString() {
            return "FunctionValue(value=" + this.value + ", args=" + this.args + ")";
        }

        public FunctionValue(String value, PassableValue passableValue) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
            this.args = passableValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class IntValue implements PassableValue {
        public static final Companion Companion = new Companion(null);
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<IntValue> serializer() {
                return PassableValue$IntValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ IntValue(int i3, int i4, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PassableValue$IntValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = i4;
        }

        public static /* synthetic */ IntValue copy$default(IntValue intValue, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = intValue.value;
            }
            return intValue.copy(i3);
        }

        public final int component1() {
            return this.value;
        }

        public final IntValue copy(int i3) {
            return new IntValue(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntValue) && this.value == ((IntValue) obj).value;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return Integer.hashCode(this.value);
        }

        public String toString() {
            return "IntValue(value=" + this.value + ")";
        }

        public IntValue(int i3) {
            this.value = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class ListValue implements PassableValue {
        private final List<PassableValue> value;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(new SealedClassSerializer("com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue", Reflection.b(PassableValue.class), new KClass[]{Reflection.b(BoolValue.class), Reflection.b(BytesValue.class), Reflection.b(FloatValue.class), Reflection.b(FunctionValue.class), Reflection.b(IntValue.class), Reflection.b(ListValue.class), Reflection.b(MapValue.class), Reflection.b(NullValue.class), Reflection.b(StringValue.class), Reflection.b(TimestampValue.class), Reflection.b(UIntValue.class)}, new KSerializer[]{PassableValue$BoolValue$$serializer.INSTANCE, PassableValue$BytesValue$$serializer.INSTANCE, PassableValue$FloatValue$$serializer.INSTANCE, PassableValue$FunctionValue$$serializer.INSTANCE, PassableValue$IntValue$$serializer.INSTANCE, PassableValue$ListValue$$serializer.INSTANCE, PassableValue$MapValue$$serializer.INSTANCE, new ObjectSerializer("Null", NullValue.INSTANCE, new Annotation[0]), PassableValue$StringValue$$serializer.INSTANCE, PassableValue$TimestampValue$$serializer.INSTANCE, PassableValue$UIntValue$$serializer.INSTANCE}, new Annotation[0]))};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ListValue> serializer() {
                return PassableValue$ListValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ListValue(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PassableValue$ListValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ListValue copy$default(ListValue listValue, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = listValue.value;
            }
            return listValue.copy(list);
        }

        public final List<PassableValue> component1() {
            return this.value;
        }

        public final ListValue copy(List<? extends PassableValue> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new ListValue(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ListValue) && Intrinsics.areEqual(this.value, ((ListValue) obj).value);
        }

        public final List<PassableValue> getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "ListValue(value=" + this.value + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ListValue(List<? extends PassableValue> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class MapValue implements PassableValue {
        private final Map<String, PassableValue> value;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(StringSerializer.f142891a, new SealedClassSerializer("com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue", Reflection.b(PassableValue.class), new KClass[]{Reflection.b(BoolValue.class), Reflection.b(BytesValue.class), Reflection.b(FloatValue.class), Reflection.b(FunctionValue.class), Reflection.b(IntValue.class), Reflection.b(ListValue.class), Reflection.b(MapValue.class), Reflection.b(NullValue.class), Reflection.b(StringValue.class), Reflection.b(TimestampValue.class), Reflection.b(UIntValue.class)}, new KSerializer[]{PassableValue$BoolValue$$serializer.INSTANCE, PassableValue$BytesValue$$serializer.INSTANCE, PassableValue$FloatValue$$serializer.INSTANCE, PassableValue$FunctionValue$$serializer.INSTANCE, PassableValue$IntValue$$serializer.INSTANCE, PassableValue$ListValue$$serializer.INSTANCE, PassableValue$MapValue$$serializer.INSTANCE, new ObjectSerializer("Null", NullValue.INSTANCE, new Annotation[0]), PassableValue$StringValue$$serializer.INSTANCE, PassableValue$TimestampValue$$serializer.INSTANCE, PassableValue$UIntValue$$serializer.INSTANCE}, new Annotation[0]))};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<MapValue> serializer() {
                return PassableValue$MapValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ MapValue(int i3, Map map, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PassableValue$MapValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MapValue copy$default(MapValue mapValue, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = mapValue.value;
            }
            return mapValue.copy(map);
        }

        public final Map<String, PassableValue> component1() {
            return this.value;
        }

        public final MapValue copy(Map<String, ? extends PassableValue> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new MapValue(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MapValue) && Intrinsics.areEqual(this.value, ((MapValue) obj).value);
        }

        public final Map<String, PassableValue> getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "MapValue(value=" + this.value + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MapValue(Map<String, ? extends PassableValue> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class NullValue implements PassableValue {
        public static final NullValue INSTANCE = new NullValue();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: com.superwall.sdk.paywall.presentation.rule_logic.cel.models.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PassableValue.NullValue._init_$_anonymous_();
            }
        });

        private NullValue() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("Null", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<NullValue> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class StringValue implements PassableValue {
        public static final Companion Companion = new Companion(null);
        private final String value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<StringValue> serializer() {
                return PassableValue$StringValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ StringValue(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PassableValue$StringValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = str;
        }

        public static /* synthetic */ StringValue copy$default(StringValue stringValue, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = stringValue.value;
            }
            return stringValue.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final StringValue copy(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new StringValue(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StringValue) && Intrinsics.areEqual(this.value, ((StringValue) obj).value);
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "StringValue(value=" + this.value + ")";
        }

        public StringValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class TimestampValue implements PassableValue {
        public static final Companion Companion = new Companion(null);
        private final long value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TimestampValue> serializer() {
                return PassableValue$TimestampValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ TimestampValue(int i3, long j3, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PassableValue$TimestampValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = j3;
        }

        public static /* synthetic */ TimestampValue copy$default(TimestampValue timestampValue, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = timestampValue.value;
            }
            return timestampValue.copy(j3);
        }

        public final long component1() {
            return this.value;
        }

        public final TimestampValue copy(long j3) {
            return new TimestampValue(j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TimestampValue) && this.value == ((TimestampValue) obj).value;
        }

        public final long getValue() {
            return this.value;
        }

        public int hashCode() {
            return Long.hashCode(this.value);
        }

        public String toString() {
            return "TimestampValue(value=" + this.value + ")";
        }

        public TimestampValue(long j3) {
            this.value = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class UIntValue implements PassableValue {
        public static final Companion Companion = new Companion(null);
        private final long value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<UIntValue> serializer() {
                return PassableValue$UIntValue$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ UIntValue(int i3, ULong uLong, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, uLong, serializationConstructorMarker);
        }

        /* JADX INFO: renamed from: copy-VKZWuLQ$default, reason: not valid java name */
        public static /* synthetic */ UIntValue m1328copyVKZWuLQ$default(UIntValue uIntValue, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = uIntValue.value;
            }
            return uIntValue.m1330copyVKZWuLQ(j3);
        }

        /* JADX INFO: renamed from: component1-s-VKNKU, reason: not valid java name */
        public final long m1329component1sVKNKU() {
            return this.value;
        }

        /* JADX INFO: renamed from: copy-VKZWuLQ, reason: not valid java name */
        public final UIntValue m1330copyVKZWuLQ(long j3) {
            return new UIntValue(j3, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UIntValue) && this.value == ((UIntValue) obj).value;
        }

        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: not valid java name */
        public final long m1331getValuesVKNKU() {
            return this.value;
        }

        public int hashCode() {
            return ULong.e(this.value);
        }

        public String toString() {
            return "UIntValue(value=" + ULong.f(this.value) + ")";
        }

        public /* synthetic */ UIntValue(long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3);
        }

        private /* synthetic */ UIntValue(int i3, ULong uLong, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PassableValue$UIntValue$$serializer.INSTANCE.getDescriptor());
            }
            this.value = uLong.g();
        }

        private UIntValue(long j3) {
            this.value = j3;
        }
    }
}
