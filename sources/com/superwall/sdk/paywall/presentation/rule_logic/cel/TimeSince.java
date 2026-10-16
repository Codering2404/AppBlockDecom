package com.superwall.sdk.paywall.presentation.rule_logic.cel;

import com.superwall.sdk.models.config.ComputedPropertyRequest;
import com.superwall.sdk.storage.core_data.CoreDataManager;
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
public interface TimeSince {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object invoke(com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince r4, com.superwall.sdk.storage.core_data.CoreDataManager r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) throws java.lang.Throwable {
            /*
                boolean r0 = r6 instanceof com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r6
                com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince$invoke$1 r0 = (com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince$invoke$1 r0 = new com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince$invoke$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.b(r6)
                goto L4b
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                kotlin.ResultKt.b(r6)
                com.superwall.sdk.models.config.ComputedPropertyRequest r6 = new com.superwall.sdk.models.config.ComputedPropertyRequest
                com.superwall.sdk.models.config.ComputedPropertyRequest$ComputedPropertyRequestType r2 = r4.getPropertyRequest()
                java.lang.String r4 = r4.getEvent()
                r6.<init>(r2, r4)
                r0.label = r3
                r4 = 0
                java.lang.Object r6 = r5.getComputedPropertySinceEvent(r4, r6, r0)
                if (r6 != r1) goto L4b
                return r1
            L4b:
                java.lang.Integer r6 = (java.lang.Integer) r6
                if (r6 == 0) goto L54
                int r4 = r6.intValue()
                goto L55
            L54:
                r4 = 0
            L55:
                java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.d(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince.DefaultImpls.invoke(com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince, com.superwall.sdk.storage.core_data.CoreDataManager, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.rule_logic.cel.TimeSince$DefaultImpls", f = "SuperscriptExposedFunction.kt", l = {203}, m = "invoke")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultImpls.invoke(null, null, this);
        }
    }

    String getEvent();

    ComputedPropertyRequest.ComputedPropertyRequestType getPropertyRequest();

    Object invoke(CoreDataManager coreDataManager, Continuation<? super Integer> continuation);
}
