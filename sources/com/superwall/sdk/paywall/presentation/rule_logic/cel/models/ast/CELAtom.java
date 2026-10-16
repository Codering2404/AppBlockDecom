package com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELAtom;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.ULongSerializer;

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
public abstract class CELAtom implements ToExprString {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CELAtom._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Bool extends CELAtom {
        public static final Companion Companion = new Companion(null);
        private final boolean value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Bool> serializer() {
                return CELAtom$Bool$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Bool(int i3, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELAtom$Bool$$serializer.INSTANCE.getDescriptor());
            }
            this.value = z2;
        }

        public static /* synthetic */ Bool copy$default(Bool bool, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = bool.value;
            }
            return bool.copy(z2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Bool bool, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELAtom.write$Self(bool, compositeEncoder, serialDescriptor);
            compositeEncoder.x(serialDescriptor, 0, bool.value);
        }

        public final boolean component1() {
            return this.value;
        }

        public final Bool copy(boolean z2) {
            return new Bool(z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Bool) && this.value == ((Bool) obj).value;
        }

        public final boolean getValue() {
            return this.value;
        }

        public int hashCode() {
            return Boolean.hashCode(this.value);
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public java.lang.String toExprString() {
            return java.lang.String.valueOf(this.value);
        }

        public java.lang.String toString() {
            return "Bool(value=" + this.value + ")";
        }

        public Bool(boolean z2) {
            super(null);
            this.value = z2;
        }

        @SerialName
        public static /* synthetic */ void getValue$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Bytes extends CELAtom {
        public static final Companion Companion = new Companion(null);
        private final byte[] value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Bytes> serializer() {
                return CELAtom$Bytes$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Bytes(int i3, byte[] bArr, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELAtom$Bytes$$serializer.INSTANCE.getDescriptor());
            }
            this.value = bArr;
        }

        public static /* synthetic */ Bytes copy$default(Bytes bytes, byte[] bArr, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                bArr = bytes.value;
            }
            return bytes.copy(bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toExprString$lambda$0(byte b3) {
            java.lang.String str = java.lang.String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b3)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Bytes bytes, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELAtom.write$Self(bytes, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, ByteArraySerializer.f142771c, bytes.value);
        }

        public final byte[] component1() {
            return this.value;
        }

        public final Bytes copy(byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Bytes(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(Bytes.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELAtom.Bytes");
            return Arrays.equals(this.value, ((Bytes) obj).value);
        }

        public final byte[] getValue() {
            return this.value;
        }

        public int hashCode() {
            return Arrays.hashCode(this.value);
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public java.lang.String toExprString() {
            return "b\"" + ArraysKt.joinToString$default(this.value, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: j0.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CELAtom.Bytes.toExprString$lambda$0(((Byte) obj).byteValue());
                }
            }, 30, (Object) null) + "\"";
        }

        public java.lang.String toString() {
            return "Bytes(value=" + Arrays.toString(this.value) + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bytes(byte[] value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @SerialName
        public static /* synthetic */ void getValue$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) CELAtom.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<CELAtom> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Float extends CELAtom {
        public static final Companion Companion = new Companion(null);
        private final double value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Float> serializer() {
                return CELAtom$Float$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Float(int i3, double d3, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELAtom$Float$$serializer.INSTANCE.getDescriptor());
            }
            this.value = d3;
        }

        public static /* synthetic */ Float copy$default(Float r02, double d3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                d3 = r02.value;
            }
            return r02.copy(d3);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Float r3, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELAtom.write$Self(r3, compositeEncoder, serialDescriptor);
            compositeEncoder.E(serialDescriptor, 0, r3.value);
        }

        public final double component1() {
            return this.value;
        }

        public final Float copy(double d3) {
            return new Float(d3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Float) && Double.compare(this.value, ((Float) obj).value) == 0;
        }

        public final double getValue() {
            return this.value;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public java.lang.String toExprString() {
            return java.lang.String.valueOf(this.value);
        }

        public java.lang.String toString() {
            return "Float(value=" + this.value + ")";
        }

        public Float(double d3) {
            super(null);
            this.value = d3;
        }

        @SerialName
        public static /* synthetic */ void getValue$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Int extends CELAtom {
        public static final Companion Companion = new Companion(null);
        private final long value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Int> serializer() {
                return CELAtom$Int$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Int(int i3, long j3, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELAtom$Int$$serializer.INSTANCE.getDescriptor());
            }
            this.value = j3;
        }

        public static /* synthetic */ Int copy$default(Int r02, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = r02.value;
            }
            return r02.copy(j3);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Int r3, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELAtom.write$Self(r3, compositeEncoder, serialDescriptor);
            compositeEncoder.F(serialDescriptor, 0, r3.value);
        }

        public final long component1() {
            return this.value;
        }

        public final Int copy(long j3) {
            return new Int(j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Int) && this.value == ((Int) obj).value;
        }

        public final long getValue() {
            return this.value;
        }

        public int hashCode() {
            return Long.hashCode(this.value);
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public java.lang.String toExprString() {
            return java.lang.String.valueOf(this.value);
        }

        public java.lang.String toString() {
            return "Int(value=" + this.value + ")";
        }

        public Int(long j3) {
            super(null);
            this.value = j3;
        }

        @SerialName
        public static /* synthetic */ void getValue$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Null extends CELAtom {
        public static final Null INSTANCE = new Null();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELAtom.Null._init_$_anonymous_();
            }
        });

        private Null() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("Null", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Null> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public java.lang.String toExprString() {
            return "null";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class String extends CELAtom {
        public static final Companion Companion = new Companion(null);
        private final java.lang.String value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<String> serializer() {
                return CELAtom$String$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ String(int i3, java.lang.String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELAtom$String$$serializer.INSTANCE.getDescriptor());
            }
            this.value = str;
        }

        public static /* synthetic */ String copy$default(String string, java.lang.String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = string.value;
            }
            return string.copy(str);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(String string, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELAtom.write$Self(string, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, string.value);
        }

        public final java.lang.String component1() {
            return this.value;
        }

        public final String copy(java.lang.String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new String(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof String) && Intrinsics.areEqual(this.value, ((String) obj).value);
        }

        public final java.lang.String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public java.lang.String toExprString() {
            return "\"" + this.value + "\"";
        }

        public java.lang.String toString() {
            return "String(value=" + this.value + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public String(java.lang.String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @SerialName
        public static /* synthetic */ void getValue$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class UInt extends CELAtom {
        public static final Companion Companion = new Companion(null);
        private final long value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<UInt> serializer() {
                return CELAtom$UInt$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ UInt(int i3, ULong uLong, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, uLong, serializationConstructorMarker);
        }

        /* JADX INFO: renamed from: copy-VKZWuLQ$default, reason: not valid java name */
        public static /* synthetic */ UInt m1332copyVKZWuLQ$default(UInt uInt, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = uInt.value;
            }
            return uInt.m1335copyVKZWuLQ(j3);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(UInt uInt, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELAtom.write$Self(uInt, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, ULongSerializer.f142914a, ULong.a(uInt.value));
        }

        /* JADX INFO: renamed from: component1-s-VKNKU, reason: not valid java name */
        public final long m1334component1sVKNKU() {
            return this.value;
        }

        /* JADX INFO: renamed from: copy-VKZWuLQ, reason: not valid java name */
        public final UInt m1335copyVKZWuLQ(long j3) {
            return new UInt(j3, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UInt) && this.value == ((UInt) obj).value;
        }

        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: not valid java name */
        public final long m1336getValuesVKNKU() {
            return this.value;
        }

        public int hashCode() {
            return ULong.e(this.value);
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public java.lang.String toExprString() {
            return ULong.f(this.value) + "u";
        }

        public java.lang.String toString() {
            return "UInt(value=" + ULong.f(this.value) + ")";
        }

        public /* synthetic */ UInt(long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private /* synthetic */ UInt(int i3, ULong uLong, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELAtom$UInt$$serializer.INSTANCE.getDescriptor());
            }
            this.value = uLong.g();
        }

        private UInt(long j3) {
            super(null);
            this.value = j3;
        }

        @SerialName
        /* JADX INFO: renamed from: getValue-s-VKNKU$annotations, reason: not valid java name */
        public static /* synthetic */ void m1333getValuesVKNKU$annotations() {
        }
    }

    public /* synthetic */ CELAtom(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("CELAtom", Reflection.b(CELAtom.class), new KClass[]{Reflection.b(Bool.class), Reflection.b(Bytes.class), Reflection.b(Float.class), Reflection.b(Int.class), Reflection.b(Null.class), Reflection.b(String.class), Reflection.b(UInt.class)}, new KSerializer[]{CELAtom$Bool$$serializer.INSTANCE, CELAtom$Bytes$$serializer.INSTANCE, CELAtom$Float$$serializer.INSTANCE, CELAtom$Int$$serializer.INSTANCE, new ObjectSerializer("Null", Null.INSTANCE, new Annotation[0]), CELAtom$String$$serializer.INSTANCE, CELAtom$UInt$$serializer.INSTANCE}, new Annotation[0]);
    }

    private CELAtom() {
    }

    public /* synthetic */ CELAtom(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(CELAtom cELAtom, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
