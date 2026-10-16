package com.revenuecat.purchases.common.workflows;

import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable(with = WorkflowTriggerActionSerializer.class)
public abstract class WorkflowTriggerAction {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WorkflowTriggerAction> serializer() {
            return WorkflowTriggerActionSerializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Step extends WorkflowTriggerAction {
        public static final Companion Companion = new Companion(null);
        private final String stepId;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Step> serializer() {
                return WorkflowTriggerAction$Step$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Step(int i3, @SerialName String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, WorkflowTriggerAction$Step$$serializer.INSTANCE.getDescriptor());
            }
            this.stepId = str;
        }

        public static /* synthetic */ Step copy$default(Step step, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = step.stepId;
            }
            return step.copy(str);
        }

        public final String component1() {
            return this.stepId;
        }

        public final Step copy(String stepId) {
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            return new Step(stepId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Step) && Intrinsics.areEqual(this.stepId, ((Step) obj).stepId);
        }

        public final String getStepId() {
            return this.stepId;
        }

        public int hashCode() {
            return this.stepId.hashCode();
        }

        public String toString() {
            return "Step(stepId=" + this.stepId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Step(String stepId) {
            super(null);
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            this.stepId = stepId;
        }

        @SerialName
        public static /* synthetic */ void getStepId$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Unknown extends WorkflowTriggerAction {
        public static final Unknown INSTANCE = new Unknown();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowTriggerAction.Unknown.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Object> invoke() {
                return new ObjectSerializer("com.revenuecat.purchases.common.workflows.WorkflowTriggerAction.Unknown", Unknown.INSTANCE, new Annotation[0]);
            }
        });

        private Unknown() {
            super(null);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Unknown> serializer() {
            return get$cachedSerializer();
        }
    }

    public /* synthetic */ WorkflowTriggerAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WorkflowTriggerAction() {
    }
}
