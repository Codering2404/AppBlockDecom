package com.superwall.sdk.paywall.presentation.rule_logic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
public final class UtilsKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt$tryToMatchOccurrence$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt", f = "utils.kt", l = {17}, m = "tryToMatchOccurrence")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.tryToMatchOccurrence(null, null, false, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object tryToMatchOccurrence(com.superwall.sdk.models.triggers.TriggerRule r8, com.superwall.sdk.storage.core_data.CoreDataManager r9, boolean r10, kotlin.coroutines.Continuation<? super com.superwall.sdk.models.triggers.TriggerRuleOutcome> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt$tryToMatchOccurrence$1 r0 = (com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt$tryToMatchOccurrence$1 r0 = new com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt$tryToMatchOccurrence$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.L$1
            com.superwall.sdk.models.triggers.TriggerRuleOccurrence r8 = (com.superwall.sdk.models.triggers.TriggerRuleOccurrence) r8
            java.lang.Object r9 = r0.L$0
            com.superwall.sdk.models.triggers.TriggerRule r9 = (com.superwall.sdk.models.triggers.TriggerRule) r9
            kotlin.ResultKt.b(r11)
            goto L53
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.ResultKt.b(r11)
            if (r10 == 0) goto L91
            com.superwall.sdk.models.triggers.TriggerRuleOccurrence r10 = r8.getOccurrence()
            if (r10 == 0) goto L78
            r0.L$0 = r8
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r11 = r9.countTriggerRuleOccurrences(r10, r0)
            if (r11 != r1) goto L51
            return r1
        L51:
            r9 = r8
            r8 = r10
        L53:
            java.lang.Number r11 = (java.lang.Number) r11
            int r10 = r11.intValue()
            int r10 = r10 + r3
            int r11 = r8.getMaxCount()
            if (r10 > r11) goto L67
            com.superwall.sdk.models.triggers.TriggerRuleOutcome$Companion r10 = com.superwall.sdk.models.triggers.TriggerRuleOutcome.Companion
            com.superwall.sdk.models.triggers.TriggerRuleOutcome r8 = r10.match(r9, r8)
            return r8
        L67:
            com.superwall.sdk.models.triggers.TriggerRuleOutcome$Companion r8 = com.superwall.sdk.models.triggers.TriggerRuleOutcome.Companion
            com.superwall.sdk.models.triggers.UnmatchedRule$Source r10 = com.superwall.sdk.models.triggers.UnmatchedRule.Source.OCCURRENCE
            com.superwall.sdk.models.triggers.RawExperiment r9 = r9.getExperiment()
            java.lang.String r9 = r9.getId()
            com.superwall.sdk.models.triggers.TriggerRuleOutcome r8 = r8.noMatch(r10, r9)
            return r8
        L78:
            com.superwall.sdk.logger.Logger r0 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r1 = com.superwall.sdk.logger.LogLevel.debug
            com.superwall.sdk.logger.LogScope r2 = com.superwall.sdk.logger.LogScope.paywallPresentation
            r6 = 24
            r7 = 0
            java.lang.String r3 = "No occurrence parameter found for trigger rule."
            r4 = 0
            r5 = 0
            com.superwall.sdk.logger.Logger.debug$default(r0, r1, r2, r3, r4, r5, r6, r7)
            com.superwall.sdk.models.triggers.TriggerRuleOutcome$Companion r9 = com.superwall.sdk.models.triggers.TriggerRuleOutcome.Companion
            r10 = 2
            r11 = 0
            com.superwall.sdk.models.triggers.TriggerRuleOutcome r8 = com.superwall.sdk.models.triggers.TriggerRuleOutcome.Companion.match$default(r9, r8, r11, r10, r11)
            return r8
        L91:
            com.superwall.sdk.models.triggers.TriggerRuleOutcome$Companion r9 = com.superwall.sdk.models.triggers.TriggerRuleOutcome.Companion
            com.superwall.sdk.models.triggers.UnmatchedRule$Source r10 = com.superwall.sdk.models.triggers.UnmatchedRule.Source.EXPRESSION
            com.superwall.sdk.models.triggers.RawExperiment r8 = r8.getExperiment()
            java.lang.String r8 = r8.getId()
            com.superwall.sdk.models.triggers.TriggerRuleOutcome r8 = r9.noMatch(r10, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.UtilsKt.tryToMatchOccurrence(com.superwall.sdk.models.triggers.TriggerRule, com.superwall.sdk.storage.core_data.CoreDataManager, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
