package com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELUnaryOp;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
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
@Polymorphic
@Metadata
@Serializable
@SerialName
public abstract class CELUnaryOp implements ToExprString {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.x
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CELUnaryOp._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) CELUnaryOp.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<CELUnaryOp> serializer() {
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
    public static final class DoubleMinus extends CELUnaryOp {
        public static final DoubleMinus INSTANCE = new DoubleMinus();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELUnaryOp.DoubleMinus._init_$_anonymous_();
            }
        });

        private DoubleMinus() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("DoubleMinus", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<DoubleMinus> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "--";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class DoubleNot extends CELUnaryOp {
        public static final DoubleNot INSTANCE = new DoubleNot();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELUnaryOp.DoubleNot._init_$_anonymous_();
            }
        });

        private DoubleNot() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("DoubleNot", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<DoubleNot> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "!!";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Minus extends CELUnaryOp {
        public static final Minus INSTANCE = new Minus();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELUnaryOp.Minus._init_$_anonymous_();
            }
        });

        private Minus() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("Minus", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Minus> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "-";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Not extends CELUnaryOp {
        public static final Not INSTANCE = new Not();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELUnaryOp.Not._init_$_anonymous_();
            }
        });

        private Not() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("Not", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Not> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "!";
        }
    }

    public /* synthetic */ CELUnaryOp(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("CELUnaryOp", Reflection.b(CELUnaryOp.class), new KClass[]{Reflection.b(DoubleMinus.class), Reflection.b(DoubleNot.class), Reflection.b(Minus.class), Reflection.b(Not.class)}, new KSerializer[]{new ObjectSerializer("DoubleMinus", DoubleMinus.INSTANCE, new Annotation[0]), new ObjectSerializer("DoubleNot", DoubleNot.INSTANCE, new Annotation[0]), new ObjectSerializer("Minus", Minus.INSTANCE, new Annotation[0]), new ObjectSerializer("Not", Not.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    private CELUnaryOp() {
    }

    public /* synthetic */ CELUnaryOp(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(CELUnaryOp cELUnaryOp, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
