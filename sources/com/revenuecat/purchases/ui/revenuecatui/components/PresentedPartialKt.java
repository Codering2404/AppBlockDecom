package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementKt;

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
public final class PresentedPartialKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ComponentOverride.EqualityOperator.values().length];
            try {
                iArr[ComponentOverride.EqualityOperator.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ComponentOverride.EqualityOperator.NOT_EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ComponentOverride.ArrayOperator.values().length];
            try {
                iArr2[ComponentOverride.ArrayOperator.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ComponentOverride.ArrayOperator.NOT_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ScreenCondition.values().length];
            try {
                iArr3[ScreenCondition.COMPACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[ScreenCondition.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[ScreenCondition.EXPANDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final /* synthetic */ PresentedPartial buildPresentedPartial(List list, ScreenCondition windowSize, OfferEligibility offerEligibility, ComponentViewState state, ConditionContext conditionContext) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(windowSize, "windowSize");
        Intrinsics.checkNotNullParameter(offerEligibility, "offerEligibility");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(conditionContext, "conditionContext");
        Iterator it = list.iterator();
        PresentedPartial presentedPartialCombineOrReplace = null;
        while (it.hasNext()) {
            PresentedOverride presentedOverride = (PresentedOverride) it.next();
            if (shouldApply(presentedOverride, windowSize, offerEligibility, state, conditionContext)) {
                presentedPartialCombineOrReplace = combineOrReplace(presentedPartialCombineOrReplace, presentedOverride.getProperties());
            }
        }
        return presentedPartialCombineOrReplace;
    }

    public static /* synthetic */ PresentedPartial buildPresentedPartial$default(List list, ScreenCondition screenCondition, OfferEligibility offerEligibility, ComponentViewState componentViewState, ConditionContext conditionContext, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            conditionContext = new ConditionContext(null, MapsKt.emptyMap());
        }
        return buildPresentedPartial(list, screenCondition, offerEligibility, componentViewState, conditionContext);
    }

    private static final <T extends PresentedPartial<T>> T combineOrReplace(PresentedPartial<T> presentedPartial, T t2) {
        T t3;
        return (presentedPartial == null || (t3 = (T) presentedPartial.combine(t2)) == null) ? t2 : t3;
    }

    private static final boolean evaluate(ComponentOverride.Condition condition, ScreenCondition screenCondition, OfferEligibility offerEligibility, ComponentViewState componentViewState, ConditionContext conditionContext) {
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.Compact.INSTANCE) ? true : Intrinsics.areEqual(condition, ComponentOverride.Condition.Medium.INSTANCE) ? true : Intrinsics.areEqual(condition, ComponentOverride.Condition.Expanded.INSTANCE)) {
            return getApplicableConditions(screenCondition).contains(condition);
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.MultiplePhaseOffers.INSTANCE)) {
            return offerEligibility.getHasMultipleDiscountedPhases();
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.IntroOffer.INSTANCE)) {
            return offerEligibility.isIntroOffer();
        }
        if (condition instanceof ComponentOverride.Condition.IntroOfferRule) {
            return evaluate((ComponentOverride.Condition.IntroOfferRule) condition, offerEligibility);
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.Selected.INSTANCE)) {
            return componentViewState == ComponentViewState.SELECTED;
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.PromoOffer.INSTANCE)) {
            return offerEligibility.isPromoOffer();
        }
        if (condition instanceof ComponentOverride.Condition.PromoOfferRule) {
            return evaluate((ComponentOverride.Condition.PromoOfferRule) condition, offerEligibility);
        }
        if (condition instanceof ComponentOverride.Condition.SelectedPackage) {
            return evaluate((ComponentOverride.Condition.SelectedPackage) condition, conditionContext.getSelectedPackageId());
        }
        if (condition instanceof ComponentOverride.Condition.Variable) {
            return evaluate((ComponentOverride.Condition.Variable) condition, conditionContext.getCustomVariables());
        }
        if (Intrinsics.areEqual(condition, ComponentOverride.Condition.Unsupported.INSTANCE)) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Set<ComponentOverride.Condition> getApplicableConditions(ScreenCondition screenCondition) {
        int i3 = WhenMappings.$EnumSwitchMapping$2[screenCondition.ordinal()];
        if (i3 == 1) {
            return SetsKt.setOf(ComponentOverride.Condition.Compact.INSTANCE);
        }
        if (i3 == 2) {
            return SetsKt.setOf((Object[]) new ComponentOverride.Condition[]{ComponentOverride.Condition.Compact.INSTANCE, ComponentOverride.Condition.Medium.INSTANCE});
        }
        if (i3 == 3) {
            return SetsKt.setOf((Object[]) new ComponentOverride.Condition[]{ComponentOverride.Condition.Compact.INSTANCE, ComponentOverride.Condition.Medium.INSTANCE, ComponentOverride.Condition.Expanded.INSTANCE});
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean matchesValue(ComponentOverride.Condition.Variable variable, CustomVariableValue customVariableValue) {
        return variable.getValue().b() ? (customVariableValue instanceof CustomVariableValue.String) && Intrinsics.areEqual(((CustomVariableValue.String) customVariableValue).getValue(), variable.getValue().a()) : JsonElementKt.f(variable.getValue()) != null ? (customVariableValue instanceof CustomVariableValue.Boolean) && Intrinsics.areEqual(Boolean.valueOf(((CustomVariableValue.Boolean) customVariableValue).getValue()), JsonElementKt.f(variable.getValue())) : JsonElementKt.i(variable.getValue()) != null && (customVariableValue instanceof CustomVariableValue.Number) && Intrinsics.areEqual(((CustomVariableValue.Number) customVariableValue).getValue(), JsonElementKt.i(variable.getValue()));
    }

    private static final <T extends PresentedPartial<T>> boolean shouldApply(PresentedOverride<T> presentedOverride, ScreenCondition screenCondition, OfferEligibility offerEligibility, ComponentViewState componentViewState, ConditionContext conditionContext) {
        List conditions = presentedOverride.getConditions();
        if ((conditions instanceof Collection) && conditions.isEmpty()) {
            return true;
        }
        Iterator it = conditions.iterator();
        while (it.hasNext()) {
            if (!evaluate((ComponentOverride.Condition) it.next(), screenCondition, offerEligibility, componentViewState, conditionContext)) {
                return false;
            }
        }
        return true;
    }

    public static final /* synthetic */ Result toPresentedOverrides(List list, boolean z2, Function1 transform) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (z2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                List<ComponentOverride.Condition> conditions = ((ComponentOverride) obj).getConditions();
                if (!(conditions instanceof Collection) || !conditions.isEmpty()) {
                    for (ComponentOverride.Condition condition : conditions) {
                        if (condition.isRule() || (condition instanceof ComponentOverride.Condition.Unsupported)) {
                            break;
                        }
                    }
                }
                arrayList.add(obj);
            }
            list = arrayList;
        }
        List<ComponentOverride> list2 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ComponentOverride componentOverride : list2) {
            Result result = (Result) transform.invoke(componentOverride.getProperties());
            if (!(result instanceof Result.Success)) {
                if (result instanceof Result.Error) {
                    return new Result.Error(((NonEmptyList) ((Result.Error) result).getValue()).getHead());
                }
                throw new NoWhenBranchMatchedException();
            }
            arrayList2.add(new PresentedOverride(componentOverride.getConditions(), (PresentedPartial) ((Result.Success) result).getValue()));
        }
        return new Result.Success(arrayList2);
    }

    public static /* synthetic */ Result toPresentedOverrides$default(List list, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return toPresentedOverrides(list, z2, function1);
    }

    private static final boolean evaluate(ComponentOverride.Condition.IntroOfferRule introOfferRule, OfferEligibility offerEligibility) {
        boolean zIsIntroOffer = offerEligibility.isIntroOffer();
        int i3 = WhenMappings.$EnumSwitchMapping$0[introOfferRule.getOperator().ordinal()];
        if (i3 == 1) {
            return zIsIntroOffer == introOfferRule.getValue();
        }
        if (i3 == 2) {
            return zIsIntroOffer != introOfferRule.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean evaluate(ComponentOverride.Condition.PromoOfferRule promoOfferRule, OfferEligibility offerEligibility) {
        boolean zIsPromoOffer = offerEligibility.isPromoOffer();
        int i3 = WhenMappings.$EnumSwitchMapping$0[promoOfferRule.getOperator().ordinal()];
        if (i3 == 1) {
            return zIsPromoOffer == promoOfferRule.getValue();
        }
        if (i3 == 2) {
            return zIsPromoOffer != promoOfferRule.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean evaluate(ComponentOverride.Condition.SelectedPackage selectedPackage, String str) {
        if (str == null) {
            return false;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[selectedPackage.getOperator().ordinal()];
        if (i3 == 1) {
            return selectedPackage.getPackages().contains(str);
        }
        if (i3 == 2) {
            return !selectedPackage.getPackages().contains(str);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean evaluate(ComponentOverride.Condition.Variable variable, Map<String, ? extends CustomVariableValue> map) {
        CustomVariableValue customVariableValue = map.get(variable.getVariable());
        if (customVariableValue == null) {
            return variable.getOperator() == ComponentOverride.EqualityOperator.NOT_EQUALS;
        }
        boolean zMatchesValue = matchesValue(variable, customVariableValue);
        int i3 = WhenMappings.$EnumSwitchMapping$0[variable.getOperator().ordinal()];
        if (i3 == 1) {
            return zMatchesValue;
        }
        if (i3 == 2) {
            return !zMatchesValue;
        }
        throw new NoWhenBranchMatchedException();
    }
}
