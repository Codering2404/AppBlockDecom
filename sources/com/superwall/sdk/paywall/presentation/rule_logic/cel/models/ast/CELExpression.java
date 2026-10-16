package com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast;

import androidx.appcompat.app.jE.vxrlPPpdv;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
public abstract class CELExpression implements CELNode, ToExprString {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: j0.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CELExpression._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class And extends CELExpression {
        private final CELExpression left;
        private final CELExpression right;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<And> serializer() {
                return CELExpression$And$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ And(int i3, CELExpression cELExpression, CELExpression cELExpression2, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, CELExpression$And$$serializer.INSTANCE.getDescriptor());
            }
            this.left = cELExpression;
            this.right = cELExpression2;
        }

        public static /* synthetic */ And copy$default(And and, CELExpression cELExpression, CELExpression cELExpression2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELExpression = and.left;
            }
            if ((i3 & 2) != 0) {
                cELExpression2 = and.right;
            }
            return and.copy(cELExpression, cELExpression2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(And and, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(and, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], and.left);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], and.right);
        }

        public final CELExpression component1() {
            return this.left;
        }

        public final CELExpression component2() {
            return this.right;
        }

        public final And copy(CELExpression left, CELExpression right) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            return new And(left, right);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof And)) {
                return false;
            }
            And and = (And) obj;
            return Intrinsics.areEqual(this.left, and.left) && Intrinsics.areEqual(this.right, and.right);
        }

        public final CELExpression getLeft() {
            return this.left;
        }

        public final CELExpression getRight() {
            return this.right;
        }

        public int hashCode() {
            return (this.left.hashCode() * 31) + this.right.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return (CELExpression) transform.invoke(new And(this.left.mapAll(transform), this.right.mapAll(transform)));
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "(" + this.left.toExprString() + " && " + this.right.toExprString() + ")";
        }

        public String toString() {
            return "And(left=" + this.left + ", right=" + this.right + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public And(CELExpression left, CELExpression right) {
            super(null);
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            this.left = left;
            this.right = right;
        }

        @SerialName
        public static /* synthetic */ void getLeft$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getRight$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Arithmetic extends CELExpression {
        private final CELExpression left;
        private final CELArithmeticOp op;
        private final CELExpression right;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELArithmeticOp.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Arithmetic> serializer() {
                return CELExpression$Arithmetic$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Arithmetic(int i3, CELExpression cELExpression, CELArithmeticOp cELArithmeticOp, CELExpression cELExpression2, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (7 != (i3 & 7)) {
                PluginExceptionsKt.b(i3, 7, CELExpression$Arithmetic$$serializer.INSTANCE.getDescriptor());
            }
            this.left = cELExpression;
            this.op = cELArithmeticOp;
            this.right = cELExpression2;
        }

        public static /* synthetic */ Arithmetic copy$default(Arithmetic arithmetic, CELExpression cELExpression, CELArithmeticOp cELArithmeticOp, CELExpression cELExpression2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELExpression = arithmetic.left;
            }
            if ((i3 & 2) != 0) {
                cELArithmeticOp = arithmetic.op;
            }
            if ((i3 & 4) != 0) {
                cELExpression2 = arithmetic.right;
            }
            return arithmetic.copy(cELExpression, cELArithmeticOp, cELExpression2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Arithmetic arithmetic, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(arithmetic, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], arithmetic.left);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], arithmetic.op);
            compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], arithmetic.right);
        }

        public final CELExpression component1() {
            return this.left;
        }

        public final CELArithmeticOp component2() {
            return this.op;
        }

        public final CELExpression component3() {
            return this.right;
        }

        public final Arithmetic copy(CELExpression left, CELArithmeticOp op, CELExpression right) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(right, "right");
            return new Arithmetic(left, op, right);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Arithmetic)) {
                return false;
            }
            Arithmetic arithmetic = (Arithmetic) obj;
            return Intrinsics.areEqual(this.left, arithmetic.left) && Intrinsics.areEqual(this.op, arithmetic.op) && Intrinsics.areEqual(this.right, arithmetic.right);
        }

        public final CELExpression getLeft() {
            return this.left;
        }

        public final CELArithmeticOp getOp() {
            return this.op;
        }

        public final CELExpression getRight() {
            return this.right;
        }

        public int hashCode() {
            return (((this.left.hashCode() * 31) + this.op.hashCode()) * 31) + this.right.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return (CELExpression) transform.invoke(new Arithmetic(this.left.mapAll(transform), this.op, this.right.mapAll(transform)));
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "(" + this.left.toExprString() + " " + this.op.toExprString() + " " + this.right.toExprString() + ")";
        }

        public String toString() {
            return "Arithmetic(left=" + this.left + ", op=" + this.op + ", right=" + this.right + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Arithmetic(CELExpression left, CELArithmeticOp op, CELExpression right) {
            super(null);
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(right, "right");
            this.left = left;
            this.op = op;
            this.right = right;
        }

        @SerialName
        public static /* synthetic */ void getLeft$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOp$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getRight$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Atom extends CELExpression {
        private final CELAtom value;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {CELAtom.Companion.serializer()};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Atom> serializer() {
                return CELExpression$Atom$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Atom(int i3, CELAtom cELAtom, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELExpression$Atom$$serializer.INSTANCE.getDescriptor());
            }
            this.value = cELAtom;
        }

        public static /* synthetic */ Atom copy$default(Atom atom, CELAtom cELAtom, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELAtom = atom.value;
            }
            return atom.copy(cELAtom);
        }

        @SerialName
        public static /* synthetic */ void getValue$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Atom atom, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(atom, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], atom.value);
        }

        public final CELAtom component1() {
            return this.value;
        }

        public final Atom copy(CELAtom value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Atom(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Atom) && Intrinsics.areEqual(this.value, ((Atom) obj).value);
        }

        public final CELAtom getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return this.value.toExprString();
        }

        public String toString() {
            return "Atom(value=" + this.value + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Atom(CELAtom value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> function1) {
            Intrinsics.checkNotNullParameter(function1, vxrlPPpdv.ItiIxjb);
            return (CELExpression) function1.invoke(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) CELExpression.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<CELExpression> serializer() {
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
    public static final class FunctionCall extends CELExpression {
        private final java.util.List<CELExpression> arguments;
        private final CELExpression function;
        private final CELExpression receiver;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0]), new ArrayListSerializer(CELExpression.Companion.serializer())};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<FunctionCall> serializer() {
                return CELExpression$FunctionCall$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FunctionCall(int i3, CELExpression cELExpression, CELExpression cELExpression2, java.util.List list, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (7 != (i3 & 7)) {
                PluginExceptionsKt.b(i3, 7, CELExpression$FunctionCall$$serializer.INSTANCE.getDescriptor());
            }
            this.function = cELExpression;
            this.receiver = cELExpression2;
            this.arguments = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FunctionCall copy$default(FunctionCall functionCall, CELExpression cELExpression, CELExpression cELExpression2, java.util.List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELExpression = functionCall.function;
            }
            if ((i3 & 2) != 0) {
                cELExpression2 = functionCall.receiver;
            }
            if ((i3 & 4) != 0) {
                list = functionCall.arguments;
            }
            return functionCall.copy(cELExpression, cELExpression2, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toExprString$lambda$1(CELExpression it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.toExprString();
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(FunctionCall functionCall, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(functionCall, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], functionCall.function);
            compositeEncoder.i(serialDescriptor, 1, kSerializerArr[1], functionCall.receiver);
            compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], functionCall.arguments);
        }

        public final CELExpression component1() {
            return this.function;
        }

        public final CELExpression component2() {
            return this.receiver;
        }

        public final java.util.List<CELExpression> component3() {
            return this.arguments;
        }

        public final FunctionCall copy(CELExpression function, CELExpression cELExpression, java.util.List<? extends CELExpression> arguments) {
            Intrinsics.checkNotNullParameter(function, "function");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            return new FunctionCall(function, cELExpression, arguments);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FunctionCall)) {
                return false;
            }
            FunctionCall functionCall = (FunctionCall) obj;
            return Intrinsics.areEqual(this.function, functionCall.function) && Intrinsics.areEqual(this.receiver, functionCall.receiver) && Intrinsics.areEqual(this.arguments, functionCall.arguments);
        }

        public final java.util.List<CELExpression> getArguments() {
            return this.arguments;
        }

        public final CELExpression getFunction() {
            return this.function;
        }

        public final CELExpression getReceiver() {
            return this.receiver;
        }

        public int hashCode() {
            int iHashCode = this.function.hashCode() * 31;
            CELExpression cELExpression = this.receiver;
            return ((iHashCode + (cELExpression == null ? 0 : cELExpression.hashCode())) * 31) + this.arguments.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            CELExpression cELExpressionMapAll = this.function.mapAll(transform);
            CELExpression cELExpression = this.receiver;
            CELExpression cELExpressionMapAll2 = cELExpression != null ? cELExpression.mapAll(transform) : null;
            java.util.List<CELExpression> list = this.arguments;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((CELExpression) it.next()).mapAll(transform));
            }
            return (CELExpression) transform.invoke(new FunctionCall(cELExpressionMapAll, cELExpressionMapAll2, arrayList));
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toExprString() {
            /*
                r11 = this;
                com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression r0 = r11.receiver
                if (r0 == 0) goto L1d
                java.lang.String r0 = r0.toExprString()
                if (r0 == 0) goto L1d
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "."
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                if (r0 != 0) goto L1f
            L1d:
                java.lang.String r0 = ""
            L1f:
                java.util.List<com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression> r1 = r11.arguments
                r2 = r1
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                j0.k r8 = new j0.k
                r8.<init>()
                r9 = 30
                r10 = 0
                java.lang.String r3 = ", "
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                java.lang.String r1 = kotlin.collections.CollectionsKt.joinToString$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression r2 = r11.function
                java.lang.String r2 = r2.toExprString()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                r3.append(r2)
                java.lang.String r0 = "("
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = ")"
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression.FunctionCall.toExprString():java.lang.String");
        }

        public String toString() {
            return "FunctionCall(function=" + this.function + ", receiver=" + this.receiver + ", arguments=" + this.arguments + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FunctionCall(CELExpression function, CELExpression cELExpression, java.util.List<? extends CELExpression> arguments) {
            super(null);
            Intrinsics.checkNotNullParameter(function, "function");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            this.function = function;
            this.receiver = cELExpression;
            this.arguments = arguments;
        }

        @SerialName
        public static /* synthetic */ void getArguments$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getFunction$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getReceiver$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Ident extends CELExpression {
        public static final Companion Companion = new Companion(null);
        private final String name;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Ident> serializer() {
                return CELExpression$Ident$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Ident(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELExpression$Ident$$serializer.INSTANCE.getDescriptor());
            }
            this.name = str;
        }

        public static /* synthetic */ Ident copy$default(Ident ident, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = ident.name;
            }
            return ident.copy(str);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Ident ident, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(ident, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, ident.name);
        }

        public final String component1() {
            return this.name;
        }

        public final Ident copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Ident(name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ident) && Intrinsics.areEqual(this.name, ((Ident) obj).name);
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return (CELExpression) transform.invoke(this);
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return this.name;
        }

        public String toString() {
            return "Ident(name=" + this.name + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ident(String name) {
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
    @Serializable
    @SerialName
    public static final class List extends CELExpression {
        private final java.util.List<CELExpression> elements;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(CELExpression.Companion.serializer())};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<List> serializer() {
                return CELExpression$List$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ List(int i3, java.util.List list, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELExpression$List$$serializer.INSTANCE.getDescriptor());
            }
            this.elements = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List copy$default(List list, java.util.List list2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list2 = list.elements;
            }
            return list.copy(list2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toExprString$lambda$1(CELExpression it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.toExprString();
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(List list, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(list, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], list.elements);
        }

        public final java.util.List<CELExpression> component1() {
            return this.elements;
        }

        public final List copy(java.util.List<? extends CELExpression> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return new List(elements);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof List) && Intrinsics.areEqual(this.elements, ((List) obj).elements);
        }

        public final java.util.List<CELExpression> getElements() {
            return this.elements;
        }

        public int hashCode() {
            return this.elements.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            java.util.List<CELExpression> list = this.elements;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((CELExpression) it.next()).mapAll(transform));
            }
            return (CELExpression) transform.invoke(new List(arrayList));
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "[" + CollectionsKt.joinToString$default(this.elements, ", ", null, null, 0, null, new Function1() { // from class: j0.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CELExpression.List.toExprString$lambda$1((CELExpression) obj);
                }
            }, 30, null) + "]";
        }

        public String toString() {
            return "List(elements=" + this.elements + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public List(java.util.List<? extends CELExpression> elements) {
            super(null);
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.elements = elements;
        }

        @SerialName
        public static /* synthetic */ void getElements$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Map extends CELExpression {
        private static final KSerializer<Object>[] $childSerializers;
        public static final Companion Companion = new Companion(null);
        private final java.util.List<Pair<CELExpression, CELExpression>> entries;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Map> serializer() {
                return CELExpression$Map$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            Companion companion = CELExpression.Companion;
            $childSerializers = new KSerializer[]{new ArrayListSerializer(new PairSerializer(companion.serializer(), companion.serializer()))};
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Map(int i3, java.util.List list, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CELExpression$Map$$serializer.INSTANCE.getDescriptor());
            }
            this.entries = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Map copy$default(Map map, java.util.List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = map.entries;
            }
            return map.copy(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toExprString$lambda$1(Pair pair) {
            Intrinsics.checkNotNullParameter(pair, "<destruct>");
            CELExpression cELExpression = (CELExpression) pair.a();
            CELExpression cELExpression2 = (CELExpression) pair.b();
            return cELExpression.toExprString() + ": " + cELExpression2.toExprString();
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Map map, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(map, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], map.entries);
        }

        public final java.util.List<Pair<CELExpression, CELExpression>> component1() {
            return this.entries;
        }

        public final Map copy(java.util.List<? extends Pair<? extends CELExpression, ? extends CELExpression>> entries) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            return new Map(entries);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Map) && Intrinsics.areEqual(this.entries, ((Map) obj).entries);
        }

        public final java.util.List<Pair<CELExpression, CELExpression>> getEntries() {
            return this.entries;
        }

        public int hashCode() {
            return this.entries.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            java.util.List<Pair<CELExpression, CELExpression>> list = this.entries;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                arrayList.add(TuplesKt.a(((CELExpression) pair.a()).mapAll(transform), ((CELExpression) pair.b()).mapAll(transform)));
            }
            return (CELExpression) transform.invoke(new Map(arrayList));
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "{" + CollectionsKt.joinToString$default(this.entries, ", ", null, null, 0, null, new Function1() { // from class: j0.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CELExpression.Map.toExprString$lambda$1((Pair) obj);
                }
            }, 30, null) + "}";
        }

        public String toString() {
            return "Map(entries=" + this.entries + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Map(java.util.List<? extends Pair<? extends CELExpression, ? extends CELExpression>> entries) {
            super(null);
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.entries = entries;
        }

        @SerialName
        public static /* synthetic */ void getEntries$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Member extends CELExpression {
        private final CELExpression expr;
        private final CELMember member;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELMember.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Member> serializer() {
                return CELExpression$Member$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Member(int i3, CELExpression cELExpression, CELMember cELMember, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, CELExpression$Member$$serializer.INSTANCE.getDescriptor());
            }
            this.expr = cELExpression;
            this.member = cELMember;
        }

        public static /* synthetic */ Member copy$default(Member member, CELExpression cELExpression, CELMember cELMember, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELExpression = member.expr;
            }
            if ((i3 & 2) != 0) {
                cELMember = member.member;
            }
            return member.copy(cELExpression, cELMember);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Member member, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(member, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], member.expr);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], member.member);
        }

        public final CELExpression component1() {
            return this.expr;
        }

        public final CELMember component2() {
            return this.member;
        }

        public final Member copy(CELExpression expr, CELMember member) {
            Intrinsics.checkNotNullParameter(expr, "expr");
            Intrinsics.checkNotNullParameter(member, "member");
            return new Member(expr, member);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Member)) {
                return false;
            }
            Member member = (Member) obj;
            return Intrinsics.areEqual(this.expr, member.expr) && Intrinsics.areEqual(this.member, member.member);
        }

        public final CELExpression getExpr() {
            return this.expr;
        }

        public final CELMember getMember() {
            return this.member;
        }

        public int hashCode() {
            return (this.expr.hashCode() * 31) + this.member.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return (CELExpression) transform.invoke(new Member(this.expr.mapAll(transform), this.member));
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return this.expr.toExprString() + this.member.toExprString();
        }

        public String toString() {
            return "Member(expr=" + this.expr + ", member=" + this.member + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Member(CELExpression expr, CELMember member) {
            super(null);
            Intrinsics.checkNotNullParameter(expr, "expr");
            Intrinsics.checkNotNullParameter(member, "member");
            this.expr = expr;
            this.member = member;
        }

        @SerialName
        public static /* synthetic */ void getExpr$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getMember$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Or extends CELExpression {
        private final CELExpression left;
        private final CELExpression right;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Or> serializer() {
                return CELExpression$Or$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Or(int i3, CELExpression cELExpression, CELExpression cELExpression2, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, CELExpression$Or$$serializer.INSTANCE.getDescriptor());
            }
            this.left = cELExpression;
            this.right = cELExpression2;
        }

        public static /* synthetic */ Or copy$default(Or or, CELExpression cELExpression, CELExpression cELExpression2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELExpression = or.left;
            }
            if ((i3 & 2) != 0) {
                cELExpression2 = or.right;
            }
            return or.copy(cELExpression, cELExpression2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Or or, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(or, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], or.left);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], or.right);
        }

        public final CELExpression component1() {
            return this.left;
        }

        public final CELExpression component2() {
            return this.right;
        }

        public final Or copy(CELExpression left, CELExpression right) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            return new Or(left, right);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Or)) {
                return false;
            }
            Or or = (Or) obj;
            return Intrinsics.areEqual(this.left, or.left) && Intrinsics.areEqual(this.right, or.right);
        }

        public final CELExpression getLeft() {
            return this.left;
        }

        public final CELExpression getRight() {
            return this.right;
        }

        public int hashCode() {
            return (this.left.hashCode() * 31) + this.right.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return (CELExpression) transform.invoke(new Or(this.left.mapAll(transform), this.right.mapAll(transform)));
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "(" + this.left.toExprString() + " || " + this.right.toExprString() + ")";
        }

        public String toString() {
            return "Or(left=" + this.left + ", right=" + this.right + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Or(CELExpression left, CELExpression right) {
            super(null);
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            this.left = left;
            this.right = right;
        }

        @SerialName
        public static /* synthetic */ void getLeft$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getRight$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Relation extends CELExpression {
        private final CELExpression left;
        private final CELRelationOp op;
        private final CELExpression right;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELRelationOp.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Relation> serializer() {
                return CELExpression$Relation$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Relation(int i3, CELExpression cELExpression, CELRelationOp cELRelationOp, CELExpression cELExpression2, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (7 != (i3 & 7)) {
                PluginExceptionsKt.b(i3, 7, CELExpression$Relation$$serializer.INSTANCE.getDescriptor());
            }
            this.left = cELExpression;
            this.op = cELRelationOp;
            this.right = cELExpression2;
        }

        public static /* synthetic */ Relation copy$default(Relation relation, CELExpression cELExpression, CELRelationOp cELRelationOp, CELExpression cELExpression2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELExpression = relation.left;
            }
            if ((i3 & 2) != 0) {
                cELRelationOp = relation.op;
            }
            if ((i3 & 4) != 0) {
                cELExpression2 = relation.right;
            }
            return relation.copy(cELExpression, cELRelationOp, cELExpression2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Relation relation, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(relation, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], relation.left);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], relation.op);
            compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], relation.right);
        }

        public final CELExpression component1() {
            return this.left;
        }

        public final CELRelationOp component2() {
            return this.op;
        }

        public final CELExpression component3() {
            return this.right;
        }

        public final Relation copy(CELExpression left, CELRelationOp op, CELExpression right) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(right, "right");
            return new Relation(left, op, right);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Relation)) {
                return false;
            }
            Relation relation = (Relation) obj;
            return Intrinsics.areEqual(this.left, relation.left) && Intrinsics.areEqual(this.op, relation.op) && Intrinsics.areEqual(this.right, relation.right);
        }

        public final CELExpression getLeft() {
            return this.left;
        }

        public final CELRelationOp getOp() {
            return this.op;
        }

        public final CELExpression getRight() {
            return this.right;
        }

        public int hashCode() {
            return (((this.left.hashCode() * 31) + this.op.hashCode()) * 31) + this.right.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return (CELExpression) transform.invoke(new Relation(this.left.mapAll(transform), this.op, this.right.mapAll(transform)));
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "(" + this.left.toExprString() + " " + this.op.toExprString() + " " + this.right.toExprString() + ")";
        }

        public String toString() {
            return "Relation(left=" + this.left + ", op=" + this.op + ", right=" + this.right + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Relation(CELExpression left, CELRelationOp op, CELExpression right) {
            super(null);
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(right, "right");
            this.left = left;
            this.op = op;
            this.right = right;
        }

        @SerialName
        public static /* synthetic */ void getLeft$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOp$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getRight$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Ternary extends CELExpression {
        private final CELExpression condition;
        private final CELExpression falseExpr;
        private final CELExpression trueExpr;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Ternary> serializer() {
                return CELExpression$Ternary$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Ternary(int i3, CELExpression cELExpression, CELExpression cELExpression2, CELExpression cELExpression3, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (7 != (i3 & 7)) {
                PluginExceptionsKt.b(i3, 7, CELExpression$Ternary$$serializer.INSTANCE.getDescriptor());
            }
            this.condition = cELExpression;
            this.trueExpr = cELExpression2;
            this.falseExpr = cELExpression3;
        }

        public static /* synthetic */ Ternary copy$default(Ternary ternary, CELExpression cELExpression, CELExpression cELExpression2, CELExpression cELExpression3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELExpression = ternary.condition;
            }
            if ((i3 & 2) != 0) {
                cELExpression2 = ternary.trueExpr;
            }
            if ((i3 & 4) != 0) {
                cELExpression3 = ternary.falseExpr;
            }
            return ternary.copy(cELExpression, cELExpression2, cELExpression3);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Ternary ternary, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(ternary, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], ternary.condition);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], ternary.trueExpr);
            compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], ternary.falseExpr);
        }

        public final CELExpression component1() {
            return this.condition;
        }

        public final CELExpression component2() {
            return this.trueExpr;
        }

        public final CELExpression component3() {
            return this.falseExpr;
        }

        public final Ternary copy(CELExpression condition, CELExpression trueExpr, CELExpression falseExpr) {
            Intrinsics.checkNotNullParameter(condition, "condition");
            Intrinsics.checkNotNullParameter(trueExpr, "trueExpr");
            Intrinsics.checkNotNullParameter(falseExpr, "falseExpr");
            return new Ternary(condition, trueExpr, falseExpr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ternary)) {
                return false;
            }
            Ternary ternary = (Ternary) obj;
            return Intrinsics.areEqual(this.condition, ternary.condition) && Intrinsics.areEqual(this.trueExpr, ternary.trueExpr) && Intrinsics.areEqual(this.falseExpr, ternary.falseExpr);
        }

        public final CELExpression getCondition() {
            return this.condition;
        }

        public final CELExpression getFalseExpr() {
            return this.falseExpr;
        }

        public final CELExpression getTrueExpr() {
            return this.trueExpr;
        }

        public int hashCode() {
            return (((this.condition.hashCode() * 31) + this.trueExpr.hashCode()) * 31) + this.falseExpr.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return (CELExpression) transform.invoke(new Ternary(this.condition.mapAll(transform), this.trueExpr.mapAll(transform), this.falseExpr.mapAll(transform)));
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return "(" + this.condition.toExprString() + " ? " + this.trueExpr.toExprString() + " : " + this.falseExpr.toExprString() + ")";
        }

        public String toString() {
            return "Ternary(condition=" + this.condition + ", trueExpr=" + this.trueExpr + ", falseExpr=" + this.falseExpr + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ternary(CELExpression condition, CELExpression trueExpr, CELExpression falseExpr) {
            super(null);
            Intrinsics.checkNotNullParameter(condition, "condition");
            Intrinsics.checkNotNullParameter(trueExpr, "trueExpr");
            Intrinsics.checkNotNullParameter(falseExpr, "falseExpr");
            this.condition = condition;
            this.trueExpr = trueExpr;
            this.falseExpr = falseExpr;
        }

        @SerialName
        public static /* synthetic */ void getCondition$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getFalseExpr$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTrueExpr$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Unary extends CELExpression {
        private final CELExpression expr;
        private final CELUnaryOp op;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new PolymorphicSerializer(Reflection.b(CELUnaryOp.class), new Annotation[0]), new PolymorphicSerializer(Reflection.b(CELExpression.class), new Annotation[0])};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Unary> serializer() {
                return CELExpression$Unary$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Unary(int i3, CELUnaryOp cELUnaryOp, CELExpression cELExpression, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, CELExpression$Unary$$serializer.INSTANCE.getDescriptor());
            }
            this.op = cELUnaryOp;
            this.expr = cELExpression;
        }

        public static /* synthetic */ Unary copy$default(Unary unary, CELUnaryOp cELUnaryOp, CELExpression cELExpression, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cELUnaryOp = unary.op;
            }
            if ((i3 & 2) != 0) {
                cELExpression = unary.expr;
            }
            return unary.copy(cELUnaryOp, cELExpression);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Unary unary, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            CELExpression.write$Self(unary, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], unary.op);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], unary.expr);
        }

        public final CELUnaryOp component1() {
            return this.op;
        }

        public final CELExpression component2() {
            return this.expr;
        }

        public final Unary copy(CELUnaryOp op, CELExpression expr) {
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(expr, "expr");
            return new Unary(op, expr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Unary)) {
                return false;
            }
            Unary unary = (Unary) obj;
            return Intrinsics.areEqual(this.op, unary.op) && Intrinsics.areEqual(this.expr, unary.expr);
        }

        public final CELExpression getExpr() {
            return this.expr;
        }

        public final CELUnaryOp getOp() {
            return this.op;
        }

        public int hashCode() {
            return (this.op.hashCode() * 31) + this.expr.hashCode();
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELNode
        public CELExpression mapAll(Function1<? super CELExpression, ? extends CELExpression> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return (CELExpression) transform.invoke(new Unary(this.op, this.expr.mapAll(transform)));
        }

        @Override // com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.ToExprString
        public String toExprString() {
            return this.op.toExprString() + "(" + this.expr.toExprString() + ")";
        }

        public String toString() {
            return "Unary(op=" + this.op + ", expr=" + this.expr + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unary(CELUnaryOp op, CELExpression expr) {
            super(null);
            Intrinsics.checkNotNullParameter(op, "op");
            Intrinsics.checkNotNullParameter(expr, "expr");
            this.op = op;
            this.expr = expr;
        }

        @SerialName
        public static /* synthetic */ void getExpr$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOp$annotations() {
        }
    }

    public /* synthetic */ CELExpression(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("CELExpression", Reflection.b(CELExpression.class), new KClass[]{Reflection.b(And.class), Reflection.b(Arithmetic.class), Reflection.b(Atom.class), Reflection.b(FunctionCall.class), Reflection.b(Ident.class), Reflection.b(List.class), Reflection.b(Map.class), Reflection.b(Member.class), Reflection.b(Or.class), Reflection.b(Relation.class), Reflection.b(Ternary.class), Reflection.b(Unary.class)}, new KSerializer[]{CELExpression$And$$serializer.INSTANCE, CELExpression$Arithmetic$$serializer.INSTANCE, CELExpression$Atom$$serializer.INSTANCE, CELExpression$FunctionCall$$serializer.INSTANCE, CELExpression$Ident$$serializer.INSTANCE, CELExpression$List$$serializer.INSTANCE, CELExpression$Map$$serializer.INSTANCE, CELExpression$Member$$serializer.INSTANCE, CELExpression$Or$$serializer.INSTANCE, CELExpression$Relation$$serializer.INSTANCE, CELExpression$Ternary$$serializer.INSTANCE, CELExpression$Unary$$serializer.INSTANCE}, new Annotation[0]);
    }

    private CELExpression() {
    }

    public /* synthetic */ CELExpression(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(CELExpression cELExpression, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
