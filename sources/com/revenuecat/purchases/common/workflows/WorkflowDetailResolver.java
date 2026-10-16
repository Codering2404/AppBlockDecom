package com.revenuecat.purchases.common.workflows;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class WorkflowDetailResolver {
    private final WorkflowCdnFetcher workflowCdnFetcher;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkflowResponseAction.values().length];
            try {
                iArr[WorkflowResponseAction.INLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkflowResponseAction.USE_CDN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowDetailResolver$resolve$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.common.workflows.WorkflowDetailResolver", f = "WorkflowDetailResolver.kt", l = {28}, m = "resolve")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WorkflowDetailResolver.this.resolve(null, this);
        }
    }

    public WorkflowDetailResolver(WorkflowCdnFetcher workflowCdnFetcher) {
        Intrinsics.checkNotNullParameter(workflowCdnFetcher, "workflowCdnFetcher");
        this.workflowCdnFetcher = workflowCdnFetcher;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object resolve(com.revenuecat.purchases.common.workflows.WorkflowDetailResponse r7, kotlin.coroutines.Continuation<? super com.revenuecat.purchases.common.workflows.WorkflowDataResult> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.revenuecat.purchases.common.workflows.WorkflowDetailResolver.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.revenuecat.purchases.common.workflows.WorkflowDetailResolver$resolve$1 r0 = (com.revenuecat.purchases.common.workflows.WorkflowDetailResolver.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.common.workflows.WorkflowDetailResolver$resolve$1 r0 = new com.revenuecat.purchases.common.workflows.WorkflowDetailResolver$resolve$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            com.revenuecat.purchases.common.workflows.WorkflowDetailResponse r7 = (com.revenuecat.purchases.common.workflows.WorkflowDetailResponse) r7
            kotlin.ResultKt.b(r8)
            goto L6b
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
            com.revenuecat.purchases.common.workflows.WorkflowResponseAction r8 = r7.getAction()
            int[] r2 = com.revenuecat.purchases.common.workflows.WorkflowDetailResolver.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r2[r8]
            if (r8 == r3) goto L82
            r2 = 2
            if (r8 != r2) goto L7c
            java.lang.String r8 = r7.getUrl()
            if (r8 == 0) goto L74
            java.lang.String r2 = r7.getHash()
            if (r2 == 0) goto L5d
            com.revenuecat.purchases.models.Checksum r4 = new com.revenuecat.purchases.models.Checksum
            com.revenuecat.purchases.models.Checksum$Algorithm r5 = com.revenuecat.purchases.models.Checksum.Algorithm.SHA256
            r4.<init>(r5, r2)
            goto L5e
        L5d:
            r4 = 0
        L5e:
            com.revenuecat.purchases.common.workflows.WorkflowCdnFetcher r2 = r6.workflowCdnFetcher
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r2.fetchCompiledWorkflowJson(r8, r4, r0)
            if (r8 != r1) goto L6b
            return r1
        L6b:
            java.lang.String r8 = (java.lang.String) r8
            com.revenuecat.purchases.common.workflows.WorkflowJsonParser r0 = com.revenuecat.purchases.common.workflows.WorkflowJsonParser.INSTANCE
            com.revenuecat.purchases.common.workflows.PublishedWorkflow r8 = r0.parsePublishedWorkflow(r8)
            goto L88
        L74:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "CDN workflow response missing url"
            r7.<init>(r8)
            throw r7
        L7c:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L82:
            com.revenuecat.purchases.common.workflows.PublishedWorkflow r8 = r7.getData()
            if (r8 == 0) goto L92
        L88:
            com.revenuecat.purchases.common.workflows.WorkflowDataResult r0 = new com.revenuecat.purchases.common.workflows.WorkflowDataResult
            java.util.Map r7 = r7.getEnrolledVariants()
            r0.<init>(r8, r7)
            return r0
        L92:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Inline workflow response missing data"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.workflows.WorkflowDetailResolver.resolve(com.revenuecat.purchases.common.workflows.WorkflowDetailResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
