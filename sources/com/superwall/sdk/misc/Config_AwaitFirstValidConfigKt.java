package com.superwall.sdk.misc;

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
public final class Config_AwaitFirstValidConfigKt {

    /* JADX INFO: renamed from: com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt$awaitFirstValidConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt", f = "Config+AwaitFirstValidConfig.kt", l = {12}, m = "awaitFirstValidConfig")
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
            return Config_AwaitFirstValidConfigKt.awaitFirstValidConfig(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitFirstValidConfig(final kotlinx.coroutines.flow.Flow<? extends com.superwall.sdk.config.models.ConfigState> r4, kotlin.coroutines.Continuation<? super com.superwall.sdk.models.config.Config> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt$awaitFirstValidConfig$1 r0 = (com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt$awaitFirstValidConfig$1 r0 = new com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt$awaitFirstValidConfig$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L42
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r5)
            com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt$awaitFirstValidConfig$$inlined$filterIsInstance$1 r5 = new com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt$awaitFirstValidConfig$$inlined$filterIsInstance$1
            r5.<init>()
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            com.superwall.sdk.config.models.ConfigState$Retrieved r5 = (com.superwall.sdk.config.models.ConfigState.Retrieved) r5
            com.superwall.sdk.models.config.Config r4 = r5.getConfig()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt.awaitFirstValidConfig(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
