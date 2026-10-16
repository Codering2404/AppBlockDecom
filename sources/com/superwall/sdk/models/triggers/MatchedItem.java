package com.superwall.sdk.models.triggers;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MatchedItem {
    private final TriggerRule rule;
    private final TriggerRuleOccurrence unsavedOccurrence;

    public MatchedItem(TriggerRule rule, TriggerRuleOccurrence triggerRuleOccurrence) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        this.rule = rule;
        this.unsavedOccurrence = triggerRuleOccurrence;
    }

    public static /* synthetic */ MatchedItem copy$default(MatchedItem matchedItem, TriggerRule triggerRule, TriggerRuleOccurrence triggerRuleOccurrence, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            triggerRule = matchedItem.rule;
        }
        if ((i3 & 2) != 0) {
            triggerRuleOccurrence = matchedItem.unsavedOccurrence;
        }
        return matchedItem.copy(triggerRule, triggerRuleOccurrence);
    }

    public final TriggerRule component1() {
        return this.rule;
    }

    public final TriggerRuleOccurrence component2() {
        return this.unsavedOccurrence;
    }

    public final MatchedItem copy(TriggerRule rule, TriggerRuleOccurrence triggerRuleOccurrence) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        return new MatchedItem(rule, triggerRuleOccurrence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchedItem)) {
            return false;
        }
        MatchedItem matchedItem = (MatchedItem) obj;
        return Intrinsics.areEqual(this.rule, matchedItem.rule) && Intrinsics.areEqual(this.unsavedOccurrence, matchedItem.unsavedOccurrence);
    }

    public final TriggerRule getRule() {
        return this.rule;
    }

    public final TriggerRuleOccurrence getUnsavedOccurrence() {
        return this.unsavedOccurrence;
    }

    public int hashCode() {
        int iHashCode = this.rule.hashCode() * 31;
        TriggerRuleOccurrence triggerRuleOccurrence = this.unsavedOccurrence;
        return iHashCode + (triggerRuleOccurrence == null ? 0 : triggerRuleOccurrence.hashCode());
    }

    public String toString() {
        return "MatchedItem(rule=" + this.rule + ", unsavedOccurrence=" + this.unsavedOccurrence + ")";
    }

    public /* synthetic */ MatchedItem(TriggerRule triggerRule, TriggerRuleOccurrence triggerRuleOccurrence, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(triggerRule, (i3 & 2) != 0 ? null : triggerRuleOccurrence);
    }
}
