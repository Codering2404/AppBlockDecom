package com.superwall.sdk.models.triggers;

import com.superwall.sdk.models.triggers.UnmatchedRule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class TriggerRuleOutcome {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TriggerRuleOutcome match$default(Companion companion, TriggerRule triggerRule, TriggerRuleOccurrence triggerRuleOccurrence, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                triggerRuleOccurrence = null;
            }
            return companion.match(triggerRule, triggerRuleOccurrence);
        }

        public final TriggerRuleOutcome match(TriggerRule rule, TriggerRuleOccurrence triggerRuleOccurrence) {
            Intrinsics.checkNotNullParameter(rule, "rule");
            return new Match(new MatchedItem(rule, triggerRuleOccurrence));
        }

        public final TriggerRuleOutcome noMatch(UnmatchedRule.Source source, String experimentId) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(experimentId, "experimentId");
            return new NoMatch(new UnmatchedRule(source, experimentId));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Match extends TriggerRuleOutcome {
        private final MatchedItem matchedItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Match(MatchedItem matchedItem) {
            super(null);
            Intrinsics.checkNotNullParameter(matchedItem, "matchedItem");
            this.matchedItem = matchedItem;
        }

        public static /* synthetic */ Match copy$default(Match match, MatchedItem matchedItem, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                matchedItem = match.matchedItem;
            }
            return match.copy(matchedItem);
        }

        public final MatchedItem component1() {
            return this.matchedItem;
        }

        public final Match copy(MatchedItem matchedItem) {
            Intrinsics.checkNotNullParameter(matchedItem, "matchedItem");
            return new Match(matchedItem);
        }

        @Override // com.superwall.sdk.models.triggers.TriggerRuleOutcome
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Match) && Intrinsics.areEqual(this.matchedItem, ((Match) obj).matchedItem);
        }

        public final MatchedItem getMatchedItem() {
            return this.matchedItem;
        }

        public int hashCode() {
            return this.matchedItem.hashCode();
        }

        public String toString() {
            return "Match(matchedItem=" + this.matchedItem + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoMatch extends TriggerRuleOutcome {
        private final UnmatchedRule unmatchedRule;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoMatch(UnmatchedRule unmatchedRule) {
            super(null);
            Intrinsics.checkNotNullParameter(unmatchedRule, "unmatchedRule");
            this.unmatchedRule = unmatchedRule;
        }

        public static /* synthetic */ NoMatch copy$default(NoMatch noMatch, UnmatchedRule unmatchedRule, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                unmatchedRule = noMatch.unmatchedRule;
            }
            return noMatch.copy(unmatchedRule);
        }

        public final UnmatchedRule component1() {
            return this.unmatchedRule;
        }

        public final NoMatch copy(UnmatchedRule unmatchedRule) {
            Intrinsics.checkNotNullParameter(unmatchedRule, "unmatchedRule");
            return new NoMatch(unmatchedRule);
        }

        @Override // com.superwall.sdk.models.triggers.TriggerRuleOutcome
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NoMatch) && Intrinsics.areEqual(this.unmatchedRule, ((NoMatch) obj).unmatchedRule);
        }

        public final UnmatchedRule getUnmatchedRule() {
            return this.unmatchedRule;
        }

        public int hashCode() {
            return this.unmatchedRule.hashCode();
        }

        public String toString() {
            return "NoMatch(unmatchedRule=" + this.unmatchedRule + ")";
        }
    }

    public /* synthetic */ TriggerRuleOutcome(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean equals(Object obj) {
        if ((this instanceof NoMatch) && (obj instanceof NoMatch)) {
            NoMatch noMatch = (NoMatch) this;
            NoMatch noMatch2 = (NoMatch) obj;
            return noMatch.getUnmatchedRule().getSource() == noMatch2.getUnmatchedRule().getSource() && Intrinsics.areEqual(noMatch.getUnmatchedRule().getExperimentId(), noMatch2.getUnmatchedRule().getExperimentId());
        }
        if ((this instanceof Match) && (obj instanceof Match)) {
            Match match = (Match) this;
            Match match2 = (Match) obj;
            if (Intrinsics.areEqual(match.getMatchedItem().getRule(), match2.getMatchedItem().getRule()) && Intrinsics.areEqual(match.getMatchedItem().getUnsavedOccurrence(), match2.getMatchedItem().getUnsavedOccurrence())) {
                return true;
            }
        }
        return false;
    }

    private TriggerRuleOutcome() {
    }
}
