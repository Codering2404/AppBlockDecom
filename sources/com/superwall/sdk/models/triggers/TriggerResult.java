package com.superwall.sdk.models.triggers;

import com.superwall.sdk.models.serialization.ExceptionSerializer;
import com.superwall.sdk.models.triggers.TriggerResult;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public abstract class TriggerResult {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: i0.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TriggerResult._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) TriggerResult.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<TriggerResult> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Error extends TriggerResult {
        public static final Companion Companion = new Companion(null);
        private final Exception error;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Error> serializer() {
                return TriggerResult$Error$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(int i3, Exception exc, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, TriggerResult$Error$$serializer.INSTANCE.getDescriptor());
            }
            this.error = exc;
        }

        public static /* synthetic */ Error copy$default(Error error, Exception exc, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                exc = error.error;
            }
            return error.copy(exc);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Error error, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            TriggerResult.write$Self(error, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, ExceptionSerializer.INSTANCE, error.error);
        }

        public final Exception component1() {
            return this.error;
        }

        public final Error copy(Exception error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
        }

        public final Exception getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Exception error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Holdout extends TriggerResult {
        public static final Companion Companion = new Companion(null);
        private final Experiment experiment;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Holdout> serializer() {
                return TriggerResult$Holdout$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Holdout(int i3, Experiment experiment, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, TriggerResult$Holdout$$serializer.INSTANCE.getDescriptor());
            }
            this.experiment = experiment;
        }

        public static /* synthetic */ Holdout copy$default(Holdout holdout, Experiment experiment, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                experiment = holdout.experiment;
            }
            return holdout.copy(experiment);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Holdout holdout, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            TriggerResult.write$Self(holdout, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, Experiment$$serializer.INSTANCE, holdout.experiment);
        }

        public final Experiment component1() {
            return this.experiment;
        }

        public final Holdout copy(Experiment experiment) {
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            return new Holdout(experiment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Holdout) && Intrinsics.areEqual(this.experiment, ((Holdout) obj).experiment);
        }

        public final Experiment getExperiment() {
            return this.experiment;
        }

        public int hashCode() {
            return this.experiment.hashCode();
        }

        public String toString() {
            return "Holdout(experiment=" + this.experiment + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holdout(Experiment experiment) {
            super(null);
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            this.experiment = experiment;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class NoAudienceMatch extends TriggerResult {
        public static final NoAudienceMatch INSTANCE = new NoAudienceMatch();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: i0.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TriggerResult.NoAudienceMatch._init_$_anonymous_();
            }
        });

        private NoAudienceMatch() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.superwall.sdk.models.triggers.TriggerResult.NoAudienceMatch", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<NoAudienceMatch> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Paywall extends TriggerResult {
        public static final Companion Companion = new Companion(null);
        private final Experiment experiment;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Paywall> serializer() {
                return TriggerResult$Paywall$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Paywall(int i3, Experiment experiment, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, TriggerResult$Paywall$$serializer.INSTANCE.getDescriptor());
            }
            this.experiment = experiment;
        }

        public static /* synthetic */ Paywall copy$default(Paywall paywall, Experiment experiment, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                experiment = paywall.experiment;
            }
            return paywall.copy(experiment);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Paywall paywall, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            TriggerResult.write$Self(paywall, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, Experiment$$serializer.INSTANCE, paywall.experiment);
        }

        public final Experiment component1() {
            return this.experiment;
        }

        public final Paywall copy(Experiment experiment) {
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            return new Paywall(experiment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Paywall) && Intrinsics.areEqual(this.experiment, ((Paywall) obj).experiment);
        }

        public final Experiment getExperiment() {
            return this.experiment;
        }

        public int hashCode() {
            return this.experiment.hashCode();
        }

        public String toString() {
            return "Paywall(experiment=" + this.experiment + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paywall(Experiment experiment) {
            super(null);
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            this.experiment = experiment;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class PlacementNotFound extends TriggerResult {
        public static final PlacementNotFound INSTANCE = new PlacementNotFound();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: i0.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TriggerResult.PlacementNotFound._init_$_anonymous_();
            }
        });

        private PlacementNotFound() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.superwall.sdk.models.triggers.TriggerResult.PlacementNotFound", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<PlacementNotFound> serializer() {
            return get$cachedSerializer();
        }
    }

    public /* synthetic */ TriggerResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.superwall.sdk.models.triggers.TriggerResult", Reflection.b(TriggerResult.class), new KClass[]{Reflection.b(Error.class), Reflection.b(Holdout.class), Reflection.b(NoAudienceMatch.class), Reflection.b(Paywall.class), Reflection.b(PlacementNotFound.class)}, new KSerializer[]{TriggerResult$Error$$serializer.INSTANCE, TriggerResult$Holdout$$serializer.INSTANCE, new ObjectSerializer("com.superwall.sdk.models.triggers.TriggerResult.NoAudienceMatch", NoAudienceMatch.INSTANCE, new Annotation[0]), TriggerResult$Paywall$$serializer.INSTANCE, new ObjectSerializer("com.superwall.sdk.models.triggers.TriggerResult.PlacementNotFound", PlacementNotFound.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    private TriggerResult() {
    }

    public /* synthetic */ TriggerResult(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(TriggerResult triggerResult, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
