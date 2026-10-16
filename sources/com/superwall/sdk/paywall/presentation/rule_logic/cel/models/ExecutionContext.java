package com.superwall.sdk.paywall.presentation.rule_logic.cel.models;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
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
@Metadata
@Serializable
public final class ExecutionContext {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final Map<String, List<PassableValue>> computed;
    private final Map<String, List<PassableValue>> device;
    private final String expression;
    private final PassableMap variables;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ExecutionContext> serializer() {
            return ExecutionContext$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        KClass kClassB = Reflection.b(PassableValue.class);
        KClass[] kClassArr = {Reflection.b(PassableValue.BoolValue.class), Reflection.b(PassableValue.BytesValue.class), Reflection.b(PassableValue.FloatValue.class), Reflection.b(PassableValue.FunctionValue.class), Reflection.b(PassableValue.IntValue.class), Reflection.b(PassableValue.ListValue.class), Reflection.b(PassableValue.MapValue.class), Reflection.b(PassableValue.NullValue.class), Reflection.b(PassableValue.StringValue.class), Reflection.b(PassableValue.TimestampValue.class), Reflection.b(PassableValue.UIntValue.class)};
        PassableValue$BoolValue$$serializer passableValue$BoolValue$$serializer = PassableValue$BoolValue$$serializer.INSTANCE;
        PassableValue$BytesValue$$serializer passableValue$BytesValue$$serializer = PassableValue$BytesValue$$serializer.INSTANCE;
        PassableValue$FloatValue$$serializer passableValue$FloatValue$$serializer = PassableValue$FloatValue$$serializer.INSTANCE;
        PassableValue$FunctionValue$$serializer passableValue$FunctionValue$$serializer = PassableValue$FunctionValue$$serializer.INSTANCE;
        PassableValue$IntValue$$serializer passableValue$IntValue$$serializer = PassableValue$IntValue$$serializer.INSTANCE;
        PassableValue$ListValue$$serializer passableValue$ListValue$$serializer = PassableValue$ListValue$$serializer.INSTANCE;
        PassableValue$MapValue$$serializer passableValue$MapValue$$serializer = PassableValue$MapValue$$serializer.INSTANCE;
        PassableValue.NullValue nullValue = PassableValue.NullValue.INSTANCE;
        ObjectSerializer objectSerializer = new ObjectSerializer("Null", nullValue, new Annotation[0]);
        PassableValue$StringValue$$serializer passableValue$StringValue$$serializer = PassableValue$StringValue$$serializer.INSTANCE;
        PassableValue$TimestampValue$$serializer passableValue$TimestampValue$$serializer = PassableValue$TimestampValue$$serializer.INSTANCE;
        PassableValue$UIntValue$$serializer passableValue$UIntValue$$serializer = PassableValue$UIntValue$$serializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, new LinkedHashMapSerializer(stringSerializer, new ArrayListSerializer(new SealedClassSerializer("com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue", kClassB, kClassArr, new KSerializer[]{passableValue$BoolValue$$serializer, passableValue$BytesValue$$serializer, passableValue$FloatValue$$serializer, passableValue$FunctionValue$$serializer, passableValue$IntValue$$serializer, passableValue$ListValue$$serializer, passableValue$MapValue$$serializer, objectSerializer, passableValue$StringValue$$serializer, passableValue$TimestampValue$$serializer, passableValue$UIntValue$$serializer}, new Annotation[0]))), new LinkedHashMapSerializer(stringSerializer, new ArrayListSerializer(new SealedClassSerializer("com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue", Reflection.b(PassableValue.class), new KClass[]{Reflection.b(PassableValue.BoolValue.class), Reflection.b(PassableValue.BytesValue.class), Reflection.b(PassableValue.FloatValue.class), Reflection.b(PassableValue.FunctionValue.class), Reflection.b(PassableValue.IntValue.class), Reflection.b(PassableValue.ListValue.class), Reflection.b(PassableValue.MapValue.class), Reflection.b(PassableValue.NullValue.class), Reflection.b(PassableValue.StringValue.class), Reflection.b(PassableValue.TimestampValue.class), Reflection.b(PassableValue.UIntValue.class)}, new KSerializer[]{passableValue$BoolValue$$serializer, passableValue$BytesValue$$serializer, passableValue$FloatValue$$serializer, passableValue$FunctionValue$$serializer, passableValue$IntValue$$serializer, passableValue$ListValue$$serializer, passableValue$MapValue$$serializer, new ObjectSerializer("Null", nullValue, new Annotation[0]), passableValue$StringValue$$serializer, passableValue$TimestampValue$$serializer, passableValue$UIntValue$$serializer}, new Annotation[0])))};
    }

    public /* synthetic */ ExecutionContext(int i3, PassableMap passableMap, String str, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i3 & 15)) {
            PluginExceptionsKt.b(i3, 15, ExecutionContext$$serializer.INSTANCE.getDescriptor());
        }
        this.variables = passableMap;
        this.expression = str;
        this.computed = map;
        this.device = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExecutionContext copy$default(ExecutionContext executionContext, PassableMap passableMap, String str, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            passableMap = executionContext.variables;
        }
        if ((i3 & 2) != 0) {
            str = executionContext.expression;
        }
        if ((i3 & 4) != 0) {
            map = executionContext.computed;
        }
        if ((i3 & 8) != 0) {
            map2 = executionContext.device;
        }
        return executionContext.copy(passableMap, str, map, map2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(ExecutionContext executionContext, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, PassableMap$$serializer.INSTANCE, executionContext.variables);
        compositeEncoder.y(serialDescriptor, 1, executionContext.expression);
        compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], executionContext.computed);
        compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], executionContext.device);
    }

    public final PassableMap component1() {
        return this.variables;
    }

    public final String component2() {
        return this.expression;
    }

    public final Map<String, List<PassableValue>> component3() {
        return this.computed;
    }

    public final Map<String, List<PassableValue>> component4() {
        return this.device;
    }

    public final ExecutionContext copy(PassableMap variables, String expression, Map<String, ? extends List<? extends PassableValue>> computed, Map<String, ? extends List<? extends PassableValue>> device) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(computed, "computed");
        Intrinsics.checkNotNullParameter(device, "device");
        return new ExecutionContext(variables, expression, computed, device);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExecutionContext)) {
            return false;
        }
        ExecutionContext executionContext = (ExecutionContext) obj;
        return Intrinsics.areEqual(this.variables, executionContext.variables) && Intrinsics.areEqual(this.expression, executionContext.expression) && Intrinsics.areEqual(this.computed, executionContext.computed) && Intrinsics.areEqual(this.device, executionContext.device);
    }

    public final Map<String, List<PassableValue>> getComputed() {
        return this.computed;
    }

    public final Map<String, List<PassableValue>> getDevice() {
        return this.device;
    }

    public final String getExpression() {
        return this.expression;
    }

    public final PassableMap getVariables() {
        return this.variables;
    }

    public int hashCode() {
        return (((((this.variables.hashCode() * 31) + this.expression.hashCode()) * 31) + this.computed.hashCode()) * 31) + this.device.hashCode();
    }

    public String toString() {
        return "ExecutionContext(variables=" + this.variables + ", expression=" + this.expression + ", computed=" + this.computed + ", device=" + this.device + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExecutionContext(PassableMap variables, String expression, Map<String, ? extends List<? extends PassableValue>> computed, Map<String, ? extends List<? extends PassableValue>> device) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(computed, "computed");
        Intrinsics.checkNotNullParameter(device, "device");
        this.variables = variables;
        this.expression = expression;
        this.computed = computed;
        this.device = device;
    }

    @SerialName
    public static /* synthetic */ void getComputed$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDevice$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getExpression$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getVariables$annotations() {
    }
}
