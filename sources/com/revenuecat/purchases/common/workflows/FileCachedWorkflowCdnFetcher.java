package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.storage.FileRepository;
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
public final class FileCachedWorkflowCdnFetcher implements WorkflowCdnFetcher {
    private final FileRepository fileRepository;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher$fetchCompiledWorkflowJson$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher", f = "WorkflowCdnFetcher.kt", l = {30}, m = "fetchCompiledWorkflowJson")
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
            return FileCachedWorkflowCdnFetcher.this.fetchCompiledWorkflowJson(null, null, this);
        }
    }

    public FileCachedWorkflowCdnFetcher(FileRepository fileRepository) {
        Intrinsics.checkNotNullParameter(fileRepository, "fileRepository");
        this.fileRepository = fileRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.revenuecat.purchases.common.workflows.WorkflowCdnFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fetchCompiledWorkflowJson(java.lang.String r5, com.revenuecat.purchases.models.Checksum r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher$fetchCompiledWorkflowJson$1 r0 = (com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher$fetchCompiledWorkflowJson$1 r0 = new com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher$fetchCompiledWorkflowJson$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            java.net.URL r7 = new java.net.URL
            r7.<init>(r5)
            com.revenuecat.purchases.storage.FileRepository r5 = r4.fileRepository
            r0.label = r3
            java.lang.Object r7 = r5.generateOrGetCachedFileURL(r7, r6, r0)
            if (r7 != r1) goto L44
            return r1
        L44:
            java.net.URI r7 = (java.net.URI) r7
            java.io.File r5 = new java.io.File
            r5.<init>(r7)
            r6 = 0
            java.lang.String r5 = kotlin.io.FilesKt.g(r5, r6, r3, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher.fetchCompiledWorkflowJson(java.lang.String, com.revenuecat.purchases.models.Checksum, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
