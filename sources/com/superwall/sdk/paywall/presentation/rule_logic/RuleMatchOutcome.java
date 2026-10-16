package com.superwall.sdk.paywall.presentation.rule_logic;

import com.superwall.sdk.models.triggers.MatchedItem;
import com.superwall.sdk.models.triggers.UnmatchedRule;
import java.util.List;
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
public abstract class RuleMatchOutcome {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Matched extends RuleMatchOutcome {
        private final MatchedItem item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Matched(MatchedItem item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public static /* synthetic */ Matched copy$default(Matched matched, MatchedItem matchedItem, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                matchedItem = matched.item;
            }
            return matched.copy(matchedItem);
        }

        public final MatchedItem component1() {
            return this.item;
        }

        public final Matched copy(MatchedItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new Matched(item);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Matched) && Intrinsics.areEqual(this.item, ((Matched) obj).item);
        }

        public final MatchedItem getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "Matched(item=" + this.item + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoMatchingRules extends RuleMatchOutcome {
        private final List<UnmatchedRule> unmatchedRules;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoMatchingRules(List<UnmatchedRule> unmatchedRules) {
            super(null);
            Intrinsics.checkNotNullParameter(unmatchedRules, "unmatchedRules");
            this.unmatchedRules = unmatchedRules;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NoMatchingRules copy$default(NoMatchingRules noMatchingRules, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = noMatchingRules.unmatchedRules;
            }
            return noMatchingRules.copy(list);
        }

        public final List<UnmatchedRule> component1() {
            return this.unmatchedRules;
        }

        public final NoMatchingRules copy(List<UnmatchedRule> unmatchedRules) {
            Intrinsics.checkNotNullParameter(unmatchedRules, "unmatchedRules");
            return new NoMatchingRules(unmatchedRules);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NoMatchingRules) && Intrinsics.areEqual(this.unmatchedRules, ((NoMatchingRules) obj).unmatchedRules);
        }

        public final List<UnmatchedRule> getUnmatchedRules() {
            return this.unmatchedRules;
        }

        public int hashCode() {
            return this.unmatchedRules.hashCode();
        }

        public String toString() {
            return "NoMatchingRules(unmatchedRules=" + this.unmatchedRules + ")";
        }
    }

    public /* synthetic */ RuleMatchOutcome(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RuleMatchOutcome() {
    }
}
