package com.superwall.sdk.models.triggers;

import com.facebook.appevents.AppEventsConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.config.ComputedPropertyRequest;
import com.superwall.sdk.models.config.ComputedPropertyRequest$$serializer;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.models.triggers.TriggerRule;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
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
public final class TriggerRule {
    private final List<ComputedPropertyRequest> computedPropertyRequests;
    private String experimentGroupId;
    private String experimentId;
    private final String expression;
    private final String expressionCEL;
    private final String expressionJs;
    private final TriggerRuleOccurrence occurrence;
    private final TriggerPreload preload;
    private List<VariantOption> variants;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(VariantOption$$serializer.INSTANCE), null, null, null, null, new ArrayListSerializer(ComputedPropertyRequest$$serializer.INSTANCE), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TriggerRule> serializer() {
            return TriggerRule$$serializer.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final TriggerRule stub() {
            List listListOf = CollectionsKt.listOf(new VariantOption(Experiment.Variant.VariantType.HOLDOUT, "3", 20, null));
            List listEmptyList = CollectionsKt.emptyList();
            TriggerPreloadBehavior triggerPreloadBehavior = TriggerPreloadBehavior.ALWAYS;
            String str = null;
            TriggerRuleOccurrence triggerRuleOccurrence = null;
            return new TriggerRule(AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", listListOf, (String) null, (String) (0 == true ? 1 : 0), str, triggerRuleOccurrence, listEmptyList, new TriggerPreload(triggerPreloadBehavior, null, 2, 0 == true ? 1 : 0), 32, (DefaultConstructorMarker) null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TriggerPreloadSerializer implements KSerializer<TriggerPreload> {
        public static final TriggerPreloadSerializer INSTANCE = new TriggerPreloadSerializer();
        private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("TriggerPreload", new SerialDescriptor[0], new Function1() { // from class: i0.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TriggerRule.TriggerPreloadSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            }
        });

        private TriggerPreloadSerializer() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            buildClassSerialDescriptor.a("behavior", StringSerializer.f142891a.getDescriptor(), CollectionsKt.emptyList(), false);
            buildClassSerialDescriptor.a("requiresReEvaluation", BooleanSerializer.f142767a.getDescriptor(), CollectionsKt.emptyList(), true);
            return Unit.f139807a;
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public TriggerPreload deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            CompositeDecoder compositeDecoderB = decoder.b(getDescriptor());
            TriggerPreloadBehavior triggerPreloadBehaviorValueOf = null;
            Boolean boolValueOf = null;
            while (true) {
                int iO = compositeDecoderB.o(getDescriptor());
                if (iO == -1) {
                    compositeDecoderB.c(getDescriptor());
                    if (triggerPreloadBehaviorValueOf != null) {
                        return Intrinsics.areEqual(boolValueOf, Boolean.TRUE) ? new TriggerPreload(TriggerPreloadBehavior.ALWAYS, boolValueOf) : new TriggerPreload(triggerPreloadBehaviorValueOf, boolValueOf);
                    }
                    throw new SerializationException("Behavior is missing");
                }
                if (iO == 0) {
                    String upperCase = compositeDecoderB.m(getDescriptor(), iO).toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    triggerPreloadBehaviorValueOf = TriggerPreloadBehavior.valueOf(upperCase);
                } else {
                    if (iO != 1) {
                        throw new SerializationException("Unknown index " + iO);
                    }
                    boolValueOf = Boolean.valueOf(compositeDecoderB.C(getDescriptor(), iO));
                }
            }
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, TriggerPreload value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            CompositeEncoder compositeEncoderB = encoder.b(getDescriptor());
            compositeEncoderB.y(getDescriptor(), 0, value.getBehavior().getRawValue());
            if (value.getRequiresReEvaluation() != null) {
                compositeEncoderB.x(getDescriptor(), 1, value.getRequiresReEvaluation().booleanValue());
            }
            compositeEncoderB.c(getDescriptor());
        }
    }

    public /* synthetic */ TriggerRule(int i3, String str, String str2, List list, String str3, String str4, String str5, TriggerRuleOccurrence triggerRuleOccurrence, List list2, TriggerPreload triggerPreload, SerializationConstructorMarker serializationConstructorMarker) {
        if (263 != (i3 & 263)) {
            PluginExceptionsKt.b(i3, 263, TriggerRule$$serializer.INSTANCE.getDescriptor());
        }
        this.experimentId = str;
        this.experimentGroupId = str2;
        this.variants = list;
        if ((i3 & 8) == 0) {
            this.expression = null;
        } else {
            this.expression = str3;
        }
        if ((i3 & 16) == 0) {
            this.expressionJs = null;
        } else {
            this.expressionJs = str4;
        }
        if ((i3 & 32) == 0) {
            this.expressionCEL = null;
        } else {
            this.expressionCEL = str5;
        }
        if ((i3 & 64) == 0) {
            this.occurrence = null;
        } else {
            this.occurrence = triggerRuleOccurrence;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.computedPropertyRequests = CollectionsKt.emptyList();
        } else {
            this.computedPropertyRequests = list2;
        }
        this.preload = triggerPreload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TriggerRule copy$default(TriggerRule triggerRule, String str, String str2, List list, String str3, String str4, String str5, TriggerRuleOccurrence triggerRuleOccurrence, List list2, TriggerPreload triggerPreload, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = triggerRule.experimentId;
        }
        if ((i3 & 2) != 0) {
            str2 = triggerRule.experimentGroupId;
        }
        if ((i3 & 4) != 0) {
            list = triggerRule.variants;
        }
        if ((i3 & 8) != 0) {
            str3 = triggerRule.expression;
        }
        if ((i3 & 16) != 0) {
            str4 = triggerRule.expressionJs;
        }
        if ((i3 & 32) != 0) {
            str5 = triggerRule.expressionCEL;
        }
        if ((i3 & 64) != 0) {
            triggerRuleOccurrence = triggerRule.occurrence;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            list2 = triggerRule.computedPropertyRequests;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            triggerPreload = triggerRule.preload;
        }
        List list3 = list2;
        TriggerPreload triggerPreload2 = triggerPreload;
        String str6 = str5;
        TriggerRuleOccurrence triggerRuleOccurrence2 = triggerRuleOccurrence;
        String str7 = str4;
        List list4 = list;
        return triggerRule.copy(str, str2, list4, str3, str7, str6, triggerRuleOccurrence2, list3, triggerPreload2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(TriggerRule triggerRule, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, triggerRule.experimentId);
        compositeEncoder.y(serialDescriptor, 1, triggerRule.experimentGroupId);
        compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], triggerRule.variants);
        if (compositeEncoder.z(serialDescriptor, 3) || triggerRule.expression != null) {
            compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, triggerRule.expression);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || triggerRule.expressionJs != null) {
            compositeEncoder.i(serialDescriptor, 4, StringSerializer.f142891a, triggerRule.expressionJs);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || triggerRule.expressionCEL != null) {
            compositeEncoder.i(serialDescriptor, 5, StringSerializer.f142891a, triggerRule.expressionCEL);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || triggerRule.occurrence != null) {
            compositeEncoder.i(serialDescriptor, 6, TriggerRuleOccurrence$$serializer.INSTANCE, triggerRule.occurrence);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || !Intrinsics.areEqual(triggerRule.computedPropertyRequests, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 7, kSerializerArr[7], triggerRule.computedPropertyRequests);
        }
        compositeEncoder.C(serialDescriptor, 8, TriggerPreloadSerializer.INSTANCE, triggerRule.preload);
    }

    public final String component1() {
        return this.experimentId;
    }

    public final String component2() {
        return this.experimentGroupId;
    }

    public final List<VariantOption> component3() {
        return this.variants;
    }

    public final String component4() {
        return this.expression;
    }

    public final String component5() {
        return this.expressionJs;
    }

    public final String component6() {
        return this.expressionCEL;
    }

    public final TriggerRuleOccurrence component7() {
        return this.occurrence;
    }

    public final List<ComputedPropertyRequest> component8() {
        return this.computedPropertyRequests;
    }

    public final TriggerPreload component9() {
        return this.preload;
    }

    public final TriggerRule copy(String experimentId, String experimentGroupId, List<VariantOption> variants, String str, String str2, String str3, TriggerRuleOccurrence triggerRuleOccurrence, List<ComputedPropertyRequest> computedPropertyRequests, TriggerPreload preload) {
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(experimentGroupId, "experimentGroupId");
        Intrinsics.checkNotNullParameter(variants, "variants");
        Intrinsics.checkNotNullParameter(computedPropertyRequests, "computedPropertyRequests");
        Intrinsics.checkNotNullParameter(preload, "preload");
        return new TriggerRule(experimentId, experimentGroupId, variants, str, str2, str3, triggerRuleOccurrence, computedPropertyRequests, preload);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TriggerRule)) {
            return false;
        }
        TriggerRule triggerRule = (TriggerRule) obj;
        return Intrinsics.areEqual(this.experimentId, triggerRule.experimentId) && Intrinsics.areEqual(this.experimentGroupId, triggerRule.experimentGroupId) && Intrinsics.areEqual(this.variants, triggerRule.variants) && Intrinsics.areEqual(this.expression, triggerRule.expression) && Intrinsics.areEqual(this.expressionJs, triggerRule.expressionJs) && Intrinsics.areEqual(this.expressionCEL, triggerRule.expressionCEL) && Intrinsics.areEqual(this.occurrence, triggerRule.occurrence) && Intrinsics.areEqual(this.computedPropertyRequests, triggerRule.computedPropertyRequests) && Intrinsics.areEqual(this.preload, triggerRule.preload);
    }

    public final List<ComputedPropertyRequest> getComputedPropertyRequests() {
        return this.computedPropertyRequests;
    }

    public final RawExperiment getExperiment() {
        return new RawExperiment(this.experimentId, this.experimentGroupId, this.variants);
    }

    public final String getExperimentGroupId() {
        return this.experimentGroupId;
    }

    public final String getExperimentId() {
        return this.experimentId;
    }

    public final String getExpression() {
        return this.expression;
    }

    public final String getExpressionCEL() {
        return this.expressionCEL;
    }

    public final String getExpressionJs() {
        return this.expressionJs;
    }

    public final TriggerRuleOccurrence getOccurrence() {
        return this.occurrence;
    }

    public final TriggerPreload getPreload() {
        return this.preload;
    }

    public final List<VariantOption> getVariants() {
        return this.variants;
    }

    public int hashCode() {
        int iHashCode = ((((this.experimentId.hashCode() * 31) + this.experimentGroupId.hashCode()) * 31) + this.variants.hashCode()) * 31;
        String str = this.expression;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.expressionJs;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.expressionCEL;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        TriggerRuleOccurrence triggerRuleOccurrence = this.occurrence;
        return ((((iHashCode4 + (triggerRuleOccurrence != null ? triggerRuleOccurrence.hashCode() : 0)) * 31) + this.computedPropertyRequests.hashCode()) * 31) + this.preload.hashCode();
    }

    public final void setExperimentGroupId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.experimentGroupId = str;
    }

    public final void setExperimentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.experimentId = str;
    }

    public final void setVariants(List<VariantOption> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.variants = list;
    }

    public String toString() {
        return "TriggerRule(experimentId=" + this.experimentId + ", experimentGroupId=" + this.experimentGroupId + ", variants=" + this.variants + ", expression=" + this.expression + ", expressionJs=" + this.expressionJs + ", expressionCEL=" + this.expressionCEL + ", occurrence=" + this.occurrence + ", computedPropertyRequests=" + this.computedPropertyRequests + ", preload=" + this.preload + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = TriggerPreloadSerializer.class)
    public static final class TriggerPreload {
        public static final Companion Companion = new Companion(null);
        private TriggerPreloadBehavior behavior;
        private final Boolean requiresReEvaluation;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TriggerPreload> serializer() {
                return TriggerPreloadSerializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public TriggerPreload(TriggerPreloadBehavior behavior, Boolean bool) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            this.behavior = behavior;
            this.requiresReEvaluation = bool;
        }

        public static /* synthetic */ TriggerPreload copy$default(TriggerPreload triggerPreload, TriggerPreloadBehavior triggerPreloadBehavior, Boolean bool, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                triggerPreloadBehavior = triggerPreload.behavior;
            }
            if ((i3 & 2) != 0) {
                bool = triggerPreload.requiresReEvaluation;
            }
            return triggerPreload.copy(triggerPreloadBehavior, bool);
        }

        public final TriggerPreloadBehavior component1() {
            return this.behavior;
        }

        public final Boolean component2() {
            return this.requiresReEvaluation;
        }

        public final TriggerPreload copy(TriggerPreloadBehavior behavior, Boolean bool) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            return new TriggerPreload(behavior, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TriggerPreload)) {
                return false;
            }
            TriggerPreload triggerPreload = (TriggerPreload) obj;
            return this.behavior == triggerPreload.behavior && Intrinsics.areEqual(this.requiresReEvaluation, triggerPreload.requiresReEvaluation);
        }

        public final TriggerPreloadBehavior getBehavior() {
            return this.behavior;
        }

        public final Boolean getRequiresReEvaluation() {
            return this.requiresReEvaluation;
        }

        public int hashCode() {
            int iHashCode = this.behavior.hashCode() * 31;
            Boolean bool = this.requiresReEvaluation;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public final void setBehavior(TriggerPreloadBehavior triggerPreloadBehavior) {
            Intrinsics.checkNotNullParameter(triggerPreloadBehavior, "<set-?>");
            this.behavior = triggerPreloadBehavior;
        }

        public String toString() {
            return "TriggerPreload(behavior=" + this.behavior + ", requiresReEvaluation=" + this.requiresReEvaluation + ")";
        }

        public /* synthetic */ TriggerPreload(TriggerPreloadBehavior triggerPreloadBehavior, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(triggerPreloadBehavior, (i3 & 2) != 0 ? null : bool);
        }
    }

    public TriggerRule(String experimentId, String experimentGroupId, List<VariantOption> variants, String str, String str2, String str3, TriggerRuleOccurrence triggerRuleOccurrence, List<ComputedPropertyRequest> computedPropertyRequests, TriggerPreload preload) {
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        Intrinsics.checkNotNullParameter(experimentGroupId, "experimentGroupId");
        Intrinsics.checkNotNullParameter(variants, "variants");
        Intrinsics.checkNotNullParameter(computedPropertyRequests, "computedPropertyRequests");
        Intrinsics.checkNotNullParameter(preload, "preload");
        this.experimentId = experimentId;
        this.experimentGroupId = experimentGroupId;
        this.variants = variants;
        this.expression = str;
        this.expressionJs = str2;
        this.expressionCEL = str3;
        this.occurrence = triggerRuleOccurrence;
        this.computedPropertyRequests = computedPropertyRequests;
        this.preload = preload;
    }

    public /* synthetic */ TriggerRule(String str, String str2, List list, String str3, String str4, String str5, TriggerRuleOccurrence triggerRuleOccurrence, List list2, TriggerPreload triggerPreload, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5, (i3 & 64) != 0 ? null : triggerRuleOccurrence, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? CollectionsKt.emptyList() : list2, triggerPreload);
    }

    @SerialName
    public static /* synthetic */ void getComputedPropertyRequests$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getExperimentGroupId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getExperimentId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getExpression$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getExpressionCEL$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getExpressionJs$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOccurrence$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPreload$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getVariants$annotations() {
    }
}
