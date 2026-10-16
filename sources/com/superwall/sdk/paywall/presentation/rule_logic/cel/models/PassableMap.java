package com.superwall.sdk.paywall.presentation.rule_logic.cel.models;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import java.lang.annotation.Annotation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
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
@SerialName
@Metadata
@Serializable
public final class PassableMap {
    private final Map<String, PassableValue> map;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(StringSerializer.f142891a, new SealedClassSerializer("com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue", Reflection.b(PassableValue.class), new KClass[]{Reflection.b(PassableValue.BoolValue.class), Reflection.b(PassableValue.BytesValue.class), Reflection.b(PassableValue.FloatValue.class), Reflection.b(PassableValue.FunctionValue.class), Reflection.b(PassableValue.IntValue.class), Reflection.b(PassableValue.ListValue.class), Reflection.b(PassableValue.MapValue.class), Reflection.b(PassableValue.NullValue.class), Reflection.b(PassableValue.StringValue.class), Reflection.b(PassableValue.TimestampValue.class), Reflection.b(PassableValue.UIntValue.class)}, new KSerializer[]{PassableValue$BoolValue$$serializer.INSTANCE, PassableValue$BytesValue$$serializer.INSTANCE, PassableValue$FloatValue$$serializer.INSTANCE, PassableValue$FunctionValue$$serializer.INSTANCE, PassableValue$IntValue$$serializer.INSTANCE, PassableValue$ListValue$$serializer.INSTANCE, PassableValue$MapValue$$serializer.INSTANCE, new ObjectSerializer("Null", PassableValue.NullValue.INSTANCE, new Annotation[0]), PassableValue$StringValue$$serializer.INSTANCE, PassableValue$TimestampValue$$serializer.INSTANCE, PassableValue$UIntValue$$serializer.INSTANCE}, new Annotation[0]))};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PassableMap> serializer() {
            return PassableMap$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PassableMap(int i3, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, PassableMap$$serializer.INSTANCE.getDescriptor());
        }
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PassableMap copy$default(PassableMap passableMap, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = passableMap.map;
        }
        return passableMap.copy(map);
    }

    public final Map<String, PassableValue> component1() {
        return this.map;
    }

    public final PassableMap copy(Map<String, ? extends PassableValue> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new PassableMap(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PassableMap) && Intrinsics.areEqual(this.map, ((PassableMap) obj).map);
    }

    public final Map<String, PassableValue> getMap() {
        return this.map;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return "PassableMap(map=" + this.map + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PassableMap(Map<String, ? extends PassableValue> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    @SerialName
    public static /* synthetic */ void getMap$annotations() {
    }
}
