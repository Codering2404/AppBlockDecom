package com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELMember;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
import kotlinx.serialization.internal.PairSerializer;
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
@SerialName
public abstract class CELMember implements ToExprString {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.n
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CELMember._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Attribute extends CELMember {
        public static final Companion Companion = new Companion(null);
        private final String name;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Attribute> serializer() {
                return CELMember$Attribute$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Attribute(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELMember$Attribute$$serializer.INSTANCE.getDescriptor());
            }
            this.name = str;
        }

        public static /* synthetic */ Attribute copy$default(Attribute attribute, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = attribute.name;
            }
            return attribute.copy(str);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Attribute attribute, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELMember.write$Self(attribute, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, attribute.name);
        }

        public final String component1() {
            return this.name;
        }

        public final Attribute copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Attribute(name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Attribute) && Intrinsics.areEqual(this.name, ((Attribute) obj).name);
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "." + this.name;
        }

        public String toString() {
            return "Attribute(name=" + this.name + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Attribute(String name) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        @SerialName
        public static /* synthetic */ void getName$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) CELMember.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<CELMember> serializer() {
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
    public static final class Fields extends CELMember {
        private final List<Pair<String, CELExpression>> fields;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(new PairSerializer(StringSerializer.f142891a, CELExpression.Companion.serializer()))};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Fields> serializer() {
                return CELMember$Fields$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Fields(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELMember$Fields$$serializer.INSTANCE.getDescriptor());
            }
            this.fields = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Fields copy$default(Fields fields, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = fields.fields;
            }
            return fields.copy(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toExprString$lambda$0(Pair pair) {
            Intrinsics.checkNotNullParameter(pair, "<destruct>");
            return ((String) pair.a()) + ": " + ((CELExpression) pair.b()).toExprString();
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Fields fields, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELMember.write$Self(fields, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], fields.fields);
        }

        public final List<Pair<String, CELExpression>> component1() {
            return this.fields;
        }

        public final Fields copy(List<? extends Pair<String, ? extends CELExpression>> fields) {
            Intrinsics.checkNotNullParameter(fields, "fields");
            return new Fields(fields);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Fields) && Intrinsics.areEqual(this.fields, ((Fields) obj).fields);
        }

        public final List<Pair<String, CELExpression>> getFields() {
            return this.fields;
        }

        public int hashCode() {
            return this.fields.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "{" + CollectionsKt.joinToString$default(this.fields, ", ", null, null, 0, null, new Function1() { // from class: j0.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CELMember.Fields.toExprString$lambda$0((Pair) obj);
                }
            }, 30, null) + "}";
        }

        public String toString() {
            return "Fields(fields=" + this.fields + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Fields(List<? extends Pair<String, ? extends CELExpression>> fields) {
            super(null);
            Intrinsics.checkNotNullParameter(fields, "fields");
            this.fields = fields;
        }

        @SerialName
        public static /* synthetic */ void getFields$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Index extends CELMember {
        private final CELExpression expr;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Index> serializer() {
                return CELMember$Index$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Index(int i3, CELExpression cELExpression, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELMember$Index$$serializer.INSTANCE.getDescriptor());
            }
            this.expr = cELExpression;
        }

        public static /* synthetic */ Index copy$default(Index index, CELExpression cELExpression, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELExpression = index.expr;
            }
            return index.copy(cELExpression);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Index index, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELMember.write$Self(index, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], index.expr);
        }

        public final CELExpression component1() {
            return this.expr;
        }

        public final Index copy(CELExpression expr) {
            Intrinsics.checkNotNullParameter(expr, "expr");
            return new Index(expr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Index) && Intrinsics.areEqual(this.expr, ((Index) obj).expr);
        }

        public final CELExpression getExpr() {
            return this.expr;
        }

        public int hashCode() {
            return this.expr.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "[" + this.expr.toExprString() + "]";
        }

        public String toString() {
            return "Index(expr=" + this.expr + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Index(CELExpression expr) {
            super(null);
            Intrinsics.checkNotNullParameter(expr, "expr");
            this.expr = expr;
        }

        @SerialName
        public static /* synthetic */ void getExpr$annotations() {
        }
    }

    public /* synthetic */ CELMember(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("CELMember", Reflection.b(CELMember.class), new KClass[]{Reflection.b(Attribute.class), Reflection.b(Fields.class), Reflection.b(Index.class)}, new KSerializer[]{CELMember$Attribute$$serializer.INSTANCE, CELMember$Fields$$serializer.INSTANCE, CELMember$Index$$serializer.INSTANCE}, new Annotation[0]);
    }

    private CELMember() {
    }

    public /* synthetic */ CELMember(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(CELMember cELMember, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
