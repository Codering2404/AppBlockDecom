package com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELRelationOp;
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
public abstract class CELRelationOp implements ToExprString {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CELRelationOp._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) CELRelationOp.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<CELRelationOp> serializer() {
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
    public static final class Equals extends CELRelationOp {
        public static final Equals INSTANCE = new Equals();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELRelationOp.Equals._init_$_anonymous_();
            }
        });

        private Equals() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("Equals", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Equals> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "==";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class GreaterThan extends CELRelationOp {
        public static final GreaterThan INSTANCE = new GreaterThan();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELRelationOp.GreaterThan._init_$_anonymous_();
            }
        });

        private GreaterThan() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("GreaterThan", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<GreaterThan> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return ">";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class GreaterThanEq extends CELRelationOp {
        public static final GreaterThanEq INSTANCE = new GreaterThanEq();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELRelationOp.GreaterThanEq._init_$_anonymous_();
            }
        });

        private GreaterThanEq() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("GreaterThanEq", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<GreaterThanEq> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return ">=";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class In extends CELRelationOp {
        public static final In INSTANCE = new In();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELRelationOp.In._init_$_anonymous_();
            }
        });

        private In() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("In", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<In> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "in";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class LessThan extends CELRelationOp {
        public static final LessThan INSTANCE = new LessThan();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELRelationOp.LessThan._init_$_anonymous_();
            }
        });

        private LessThan() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("LessThan", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<LessThan> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "<";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class LessThanEq extends CELRelationOp {
        public static final LessThanEq INSTANCE = new LessThanEq();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELRelationOp.LessThanEq._init_$_anonymous_();
            }
        });

        private LessThanEq() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("LessThanEq", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<LessThanEq> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "<=";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class NotEquals extends CELRelationOp {
        public static final NotEquals INSTANCE = new NotEquals();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CELRelationOp.NotEquals._init_$_anonymous_();
            }
        });

        private NotEquals() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("NotEquals", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<NotEquals> serializer() {
            return get$cachedSerializer();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "!=";
        }
    }

    public /* synthetic */ CELRelationOp(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("CELRelationOp", Reflection.b(CELRelationOp.class), new KClass[]{Reflection.b(Equals.class), Reflection.b(GreaterThan.class), Reflection.b(GreaterThanEq.class), Reflection.b(In.class), Reflection.b(LessThan.class), Reflection.b(LessThanEq.class), Reflection.b(NotEquals.class)}, new KSerializer[]{new ObjectSerializer("Equals", Equals.INSTANCE, new Annotation[0]), new ObjectSerializer("GreaterThan", GreaterThan.INSTANCE, new Annotation[0]), new ObjectSerializer("GreaterThanEq", GreaterThanEq.INSTANCE, new Annotation[0]), new ObjectSerializer("In", In.INSTANCE, new Annotation[0]), new ObjectSerializer("LessThan", LessThan.INSTANCE, new Annotation[0]), new ObjectSerializer("LessThanEq", LessThanEq.INSTANCE, new Annotation[0]), new ObjectSerializer("NotEquals", NotEquals.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    private CELRelationOp() {
    }

    public /* synthetic */ CELRelationOp(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(CELRelationOp cELRelationOp, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
