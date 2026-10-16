package com.superwall.sdk.config;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.assignment.Assignment;
import com.superwall.sdk.models.assignment.ConfirmableAssignment;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.config.PreloadingDisabled;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.product.CrossplatformProduct;
import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.models.triggers.Trigger;
import com.superwall.sdk.models.triggers.TriggerRule;
import com.superwall.sdk.models.triggers.VariantOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

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
public final class ConfigLogic {
    public static final ConfigLogic INSTANCE = new ConfigLogic();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AssignmentOutcome {
        private final Map<String, Experiment.Variant> confirmed;
        private final Map<String, Experiment.Variant> unconfirmed;

        public AssignmentOutcome(Map<String, Experiment.Variant> confirmed, Map<String, Experiment.Variant> unconfirmed) {
            Intrinsics.checkNotNullParameter(confirmed, "confirmed");
            Intrinsics.checkNotNullParameter(unconfirmed, "unconfirmed");
            this.confirmed = confirmed;
            this.unconfirmed = unconfirmed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AssignmentOutcome copy$default(AssignmentOutcome assignmentOutcome, Map map, Map map2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = assignmentOutcome.confirmed;
            }
            if ((i3 & 2) != 0) {
                map2 = assignmentOutcome.unconfirmed;
            }
            return assignmentOutcome.copy(map, map2);
        }

        public final Map<String, Experiment.Variant> component1() {
            return this.confirmed;
        }

        public final Map<String, Experiment.Variant> component2() {
            return this.unconfirmed;
        }

        public final AssignmentOutcome copy(Map<String, Experiment.Variant> confirmed, Map<String, Experiment.Variant> unconfirmed) {
            Intrinsics.checkNotNullParameter(confirmed, "confirmed");
            Intrinsics.checkNotNullParameter(unconfirmed, "unconfirmed");
            return new AssignmentOutcome(confirmed, unconfirmed);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AssignmentOutcome)) {
                return false;
            }
            AssignmentOutcome assignmentOutcome = (AssignmentOutcome) obj;
            return Intrinsics.areEqual(this.confirmed, assignmentOutcome.confirmed) && Intrinsics.areEqual(this.unconfirmed, assignmentOutcome.unconfirmed);
        }

        public final Map<String, Experiment.Variant> getConfirmed() {
            return this.confirmed;
        }

        public final Map<String, Experiment.Variant> getUnconfirmed() {
            return this.unconfirmed;
        }

        public int hashCode() {
            return (this.confirmed.hashCode() * 31) + this.unconfirmed.hashCode();
        }

        public String toString() {
            return "AssignmentOutcome(confirmed=" + this.confirmed + ", unconfirmed=" + this.unconfirmed + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class TriggerRuleError extends Exception {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class InvalidState extends TriggerRuleError {
            public static final InvalidState INSTANCE = new InvalidState();

            private InvalidState() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NoVariantsFound extends TriggerRuleError {
            public static final NoVariantsFound INSTANCE = new NoVariantsFound();

            private NoVariantsFound() {
                super(null);
            }
        }

        public /* synthetic */ TriggerRuleError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TriggerRuleError() {
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.ConfigLogic$getAllActiveTreatmentPaywallIds$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.ConfigLogic", f = "ConfigLogic.kt", l = {254}, m = "getAllActiveTreatmentPaywallIds")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConfigLogic.this.getAllActiveTreatmentPaywallIds(null, null, null, null, this);
        }
    }

    private ConfigLogic() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Experiment.Variant chooseVariant$default(ConfigLogic configLogic, List list, Function1 function1, int i3, Object obj) throws TriggerRuleError {
        if ((i3 & 2) != 0) {
            function1 = new Function1() { // from class: com.superwall.sdk.config.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Integer.valueOf(ConfigLogic.chooseVariant$lambda$0((IntRange) obj2));
                }
            };
        }
        return configLogic.chooseVariant(list, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int chooseVariant$lambda$0(IntRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return RangesKt.w(it, Random.f140182a);
    }

    public final AssignmentOutcome chooseAssignments(Set<Trigger> fromTriggers, Map<String, Experiment.Variant> confirmedAssignments) {
        Intrinsics.checkNotNullParameter(fromTriggers, "fromTriggers");
        Intrinsics.checkNotNullParameter(confirmedAssignments, "confirmedAssignments");
        Map mutableMap = MapsKt.toMutableMap(confirmedAssignments);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<List<TriggerRule>> it = getRulesPerCampaign(fromTriggers).iterator();
        while (it.hasNext()) {
            for (TriggerRule triggerRule : it.next()) {
                List<VariantOption> variants = triggerRule.getExperiment().getVariants();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(variants, 10));
                Iterator<T> it2 = variants.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((VariantOption) it2.next()).getId());
                }
                Set set = CollectionsKt.toSet(arrayList);
                Experiment.Variant variant = (Experiment.Variant) mutableMap.get(triggerRule.getExperiment().getId());
                if (variant == null) {
                    try {
                        linkedHashMap.put(triggerRule.getExperiment().getId(), chooseVariant$default(this, triggerRule.getExperiment().getVariants(), null, 2, null));
                    } catch (TriggerRuleError unused) {
                    }
                } else if (!set.contains(variant.getId())) {
                    try {
                        linkedHashMap.put(triggerRule.getExperiment().getId(), chooseVariant$default(this, triggerRule.getExperiment().getVariants(), null, 2, null));
                        mutableMap.remove(triggerRule.getExperiment().getId());
                    } catch (TriggerRuleError unused2) {
                        mutableMap.remove(triggerRule.getExperiment().getId());
                    }
                }
            }
        }
        return new AssignmentOutcome(mutableMap, linkedHashMap);
    }

    public final Experiment.Variant chooseVariant(List<VariantOption> variants, Function1<? super IntRange, Integer> randomiser) throws TriggerRuleError {
        Intrinsics.checkNotNullParameter(variants, "variants");
        Intrinsics.checkNotNullParameter(randomiser, "randomiser");
        if (variants.isEmpty()) {
            throw TriggerRuleError.NoVariantsFound.INSTANCE;
        }
        if (variants.size() == 1) {
            VariantOption variantOption = (VariantOption) CollectionsKt.first((List) variants);
            return new Experiment.Variant(variantOption.getId(), variantOption.getType(), variantOption.getPaywallId());
        }
        Iterator<T> it = variants.iterator();
        int percentage = 0;
        int percentage2 = 0;
        while (it.hasNext()) {
            percentage2 += ((VariantOption) it.next()).getPercentage();
        }
        if (percentage2 == 0) {
            VariantOption variantOption2 = variants.get(((Number) randomiser.invoke(RangesKt.B(0, variants.size()))).intValue());
            return new Experiment.Variant(variantOption2.getId(), variantOption2.getType(), variantOption2.getPaywallId());
        }
        int iIntValue = ((Number) randomiser.invoke(RangesKt.B(0, percentage2))).intValue();
        for (VariantOption variantOption3 : variants) {
            percentage += variantOption3.getPercentage();
            if (iIntValue < percentage) {
                return new Experiment.Variant(variantOption3.getId(), variantOption3.getType(), variantOption3.getPaywallId());
            }
        }
        throw TriggerRuleError.InvalidState.INSTANCE;
    }

    public final Map<String, Set<Entitlement>> extractEntitlementsByProductId(List<ProductItem> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        List<ProductItem> list = from;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (ProductItem productItem : list) {
            Pair pairA = TuplesKt.a(productItem.getFullProductId(), productItem.getEntitlements());
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    public final Map<String, Set<Entitlement>> extractEntitlementsByProductIdFromCrossplatform(List<CrossplatformProduct> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        List<CrossplatformProduct> list = from;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (CrossplatformProduct crossplatformProduct : list) {
            Pair pairA = TuplesKt.a(crossplatformProduct.getFullProductId(), CollectionsKt.toSet(crossplatformProduct.getEntitlements()));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    public final Set<Trigger> filterTriggers(Set<Trigger> triggers, PreloadingDisabled preloadingDisabled) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Intrinsics.checkNotNullParameter(preloadingDisabled, "preloadingDisabled");
        if (preloadingDisabled.getAll()) {
            return SetsKt.emptySet();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : triggers) {
            if (!preloadingDisabled.getTriggers().contains(((Trigger) obj).getEventName())) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<String> getActiveTreatmentPaywallIds(Set<Trigger> forTriggers, Map<String, Experiment.Variant> confirmedAssignments, Map<String, Experiment.Variant> unconfirmedAssignments) {
        String paywallId;
        Intrinsics.checkNotNullParameter(forTriggers, "forTriggers");
        Intrinsics.checkNotNullParameter(confirmedAssignments, "confirmedAssignments");
        Intrinsics.checkNotNullParameter(unconfirmedAssignments, "unconfirmedAssignments");
        Map mapPlus = MapsKt.plus(confirmedAssignments, unconfirmedAssignments);
        Set<List<TriggerRule>> rulesPerCampaign = getRulesPerCampaign(forTriggers);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = rulesPerCampaign.iterator();
        while (it.hasNext()) {
            List list = (List) it.next();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((TriggerRule) it2.next()).getExperiment().getId());
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Experiment.Variant variant = (Experiment.Variant) mapPlus.get((String) obj);
            if (variant != null && variant.getType() == Experiment.Variant.VariantType.TREATMENT && (paywallId = variant.getPaywallId()) != null) {
                linkedHashSet.add(paywallId);
            }
        }
        return linkedHashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010d A[PHI: r1 r5 r7 r8 r9 r10 r11 r12 r13 r14 r15
      0x010d: PHI (r1v23 com.superwall.sdk.config.ConfigLogic$getAllActiveTreatmentPaywallIds$1) = 
      (r1v12 com.superwall.sdk.config.ConfigLogic$getAllActiveTreatmentPaywallIds$1)
      (r1v24 com.superwall.sdk.config.ConfigLogic$getAllActiveTreatmentPaywallIds$1)
     binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r5v8 com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating) = 
      (r5v5 com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating)
      (r5v9 com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating)
     binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r7v8 java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Experiment$Variant>) = 
      (r7v5 java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Experiment$Variant>)
      (r7v9 java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Experiment$Variant>)
     binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r8v5 java.util.Iterator) = (r8v3 java.util.Iterator), (r8v6 java.util.Iterator) binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r9v18 java.util.List) = (r9v3 java.util.List), (r9v19 java.util.List) binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r10v6 java.util.List) = (r10v3 java.util.List), (r10v7 java.util.List) binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r11v7 java.util.Iterator) = (r11v3 java.util.Iterator), (r11v8 java.util.Iterator) binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r12v8 java.util.Set) = (r12v5 java.util.Set), (r12v9 java.util.Set) binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r13v4 java.util.Set) = (r13v2 java.util.Set), (r13v5 java.util.Set) binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r14v11 java.util.Set) = (r14v3 java.util.Set), (r14v12 java.util.Set) binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r15v11 kotlin.jvm.internal.Ref$ObjectRef) = (r15v1 kotlin.jvm.internal.Ref$ObjectRef), (r15v12 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:28:0x00fc, B:35:0x013d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00fc -> B:29:0x010d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0138 -> B:34:0x013b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAllActiveTreatmentPaywallIds(java.util.Set<com.superwall.sdk.models.triggers.Trigger> r18, java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Experiment.Variant> r19, java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Experiment.Variant> r20, com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating r21, kotlin.coroutines.Continuation<? super java.util.Set<java.lang.String>> r22) {
        /*
            Method dump skipped, instruction units count: 651
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.ConfigLogic.getAllActiveTreatmentPaywallIds(java.util.Set, java.util.Map, java.util.Map, com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Set<List<TriggerRule>> getRulesPerCampaign(Set<Trigger> triggers) {
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Trigger trigger : triggers) {
            TriggerRule triggerRule = (TriggerRule) CollectionsKt.firstOrNull((List) trigger.getRules());
            if (triggerRule != null) {
                String groupId = triggerRule.getExperiment().getGroupId();
                if (!linkedHashSet.contains(groupId)) {
                    linkedHashSet.add(groupId);
                    linkedHashSet2.add(trigger.getRules());
                }
            }
        }
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.debug;
        LogScope logScope = LogScope.configManager;
        Logger.debug$default(logger, logLevel, logScope, "!!! groupedTriggerRules", (Map) null, (Throwable) null, 24, (Object) null);
        Logger.debug$default(logger, logLevel, logScope, linkedHashSet2.toString(), (Map) null, (Throwable) null, 24, (Object) null);
        return linkedHashSet2;
    }

    public final Paywall getStaticPaywall(String str, Config config, String deviceLocale) {
        String str2;
        Intrinsics.checkNotNullParameter(deviceLocale, "deviceLocale");
        Object obj = null;
        if (str == null || config == null || config.getLocales().contains(deviceLocale) || (str2 = (String) CollectionsKt.firstOrNull(StringsKt.V0(deviceLocale, new String[]{"_"}, false, 0, 6, null))) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(str2, "en") && config.getLocales().contains(str2)) {
            return null;
        }
        Iterator<T> it = config.getPaywalls().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((Paywall) next).getIdentifier(), str)) {
                obj = next;
                break;
            }
        }
        return (Paywall) obj;
    }

    public final Map<String, Trigger> getTriggersByEventName(Set<Trigger> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Set<Trigger> set = from;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
        for (Object obj : set) {
            linkedHashMap.put(((Trigger) obj).getEventName(), obj);
        }
        return linkedHashMap;
    }

    public final AssignmentOutcome move(ConfirmableAssignment newAssignment, Map<String, Experiment.Variant> unconfirmedAssignments, Map<String, Experiment.Variant> confirmedAssignments) {
        Intrinsics.checkNotNullParameter(newAssignment, "newAssignment");
        Intrinsics.checkNotNullParameter(unconfirmedAssignments, "unconfirmedAssignments");
        Intrinsics.checkNotNullParameter(confirmedAssignments, "confirmedAssignments");
        Map mutableMap = MapsKt.toMutableMap(confirmedAssignments);
        mutableMap.put(newAssignment.getExperimentId(), newAssignment.getVariant());
        Map mutableMap2 = MapsKt.toMutableMap(unconfirmedAssignments);
        mutableMap2.remove(newAssignment.getExperimentId());
        return new AssignmentOutcome(mutableMap, mutableMap2);
    }

    public final AssignmentOutcome transferAssignmentsFromServerToDisk(List<Assignment> assignments, Set<Trigger> triggers, Map<String, Experiment.Variant> confirmedAssignments, Map<String, Experiment.Variant> unconfirmedAssignments) {
        Object next;
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Intrinsics.checkNotNullParameter(confirmedAssignments, "confirmedAssignments");
        Intrinsics.checkNotNullParameter(unconfirmedAssignments, "unconfirmedAssignments");
        Map mutableMap = MapsKt.toMutableMap(confirmedAssignments);
        Map mutableMap2 = MapsKt.toMutableMap(unconfirmedAssignments);
        for (Assignment assignment : assignments) {
            Iterator<T> it = triggers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                List<TriggerRule> rules = ((Trigger) next).getRules();
                if (!(rules instanceof Collection) || !rules.isEmpty()) {
                    Iterator<T> it2 = rules.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.areEqual(((TriggerRule) it2.next()).getExperiment().getId(), assignment.getExperimentId())) {
                            break;
                        }
                    }
                }
            }
            Trigger trigger = (Trigger) next;
            if (trigger != null) {
                List<TriggerRule> rules2 = trigger.getRules();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it3 = rules2.iterator();
                while (it3.hasNext()) {
                    List<VariantOption> variants = ((TriggerRule) it3.next()).getExperiment().getVariants();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : variants) {
                        if (Intrinsics.areEqual(((VariantOption) obj).getId(), assignment.getVariantId())) {
                            arrayList2.add(obj);
                        }
                    }
                    CollectionsKt.addAll(arrayList, arrayList2);
                }
                VariantOption variantOption = (VariantOption) CollectionsKt.firstOrNull((List) arrayList);
                if (variantOption != null) {
                    mutableMap.put(assignment.getExperimentId(), variantOption.toVariant());
                    mutableMap2.remove(assignment.getExperimentId());
                }
            }
        }
        return new AssignmentOutcome(mutableMap, mutableMap2);
    }
}
