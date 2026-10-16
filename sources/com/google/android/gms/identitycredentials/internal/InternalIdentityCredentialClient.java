package com.google.android.gms.identitycredentials.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.identitycredentials.ClearRegistryRequest;
import com.google.android.gms.identitycredentials.ClearRegistryResponse;
import com.google.android.gms.identitycredentials.GetCredentialRequest;
import com.google.android.gms.identitycredentials.IdentityCredentialClient;
import com.google.android.gms.identitycredentials.PendingGetCredentialHandle;
import com.google.android.gms.identitycredentials.RegistrationRequest;
import com.google.android.gms.identitycredentials.RegistrationResponse;
import com.google.android.gms.internal.identity_credentials.zze;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class InternalIdentityCredentialClient extends GoogleApi<Api.ApiOptions.NoOptions> implements IdentityCredentialClient {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalIdentityCredentialClient(Context context) {
        super(context, InternalIdentityCredentialClientKt.f72852c, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ClearRegistryRequest request, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) {
        Intrinsics.checkNotNullParameter(request, "$request");
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).w4(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$clearRegistry$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void q3(Status status, ClearRegistryResponse clearRegistryResponse) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.b(status, clearRegistryResponse, taskCompletionSource);
            }
        }, request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GetCredentialRequest request, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) {
        Intrinsics.checkNotNullParameter(request, "$request");
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).M0(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$getCredential$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void l4(Status status, PendingGetCredentialHandle pendingGetCredentialHandle) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.b(status, pendingGetCredentialHandle, taskCompletionSource);
            }
        }, request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(RegistrationRequest request, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) {
        Intrinsics.checkNotNullParameter(request, "$request");
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).K0(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$registerCredentials$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void I4(Status status, RegistrationResponse registrationResponse) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.b(status, registrationResponse, taskCompletionSource);
            }
        }, request);
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task d(final GetCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task<TResult> taskDoRead = doRead(TaskApiCall.a().d(zze.zza).b(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                InternalIdentityCredentialClient.l(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).e(32701).a());
        Intrinsics.checkNotNullExpressionValue(taskDoRead, "doRead(...)");
        return taskDoRead;
    }
}
