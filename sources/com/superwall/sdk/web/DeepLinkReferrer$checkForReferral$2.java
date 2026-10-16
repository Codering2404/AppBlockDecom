package com.superwall.sdk.web;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.ReferrerDetails;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "com.superwall.sdk.web.DeepLinkReferrer$checkForReferral$2", f = "DeepLinkReferrer.kt", l = {}, m = "invokeSuspend")
final class DeepLinkReferrer$checkForReferral$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ DeepLinkReferrer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeepLinkReferrer$checkForReferral$2(DeepLinkReferrer deepLinkReferrer, Continuation<? super DeepLinkReferrer$checkForReferral$2> continuation) {
        super(2, continuation);
        this.this$0 = deepLinkReferrer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepLinkReferrer$checkForReferral$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ReferrerDetails installReferrer;
        String installReferrer2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        while (true) {
            InstallReferrerClient referrerClient = this.this$0.getReferrerClient();
            if (referrerClient != null && referrerClient.isReady()) {
                break;
            }
        }
        InstallReferrerClient referrerClient2 = this.this$0.getReferrerClient();
        if (referrerClient2 == null || (installReferrer = referrerClient2.getInstallReferrer()) == null || (installReferrer2 = installReferrer.getInstallReferrer()) == null) {
            return null;
        }
        return installReferrer2.toString();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((DeepLinkReferrer$checkForReferral$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
