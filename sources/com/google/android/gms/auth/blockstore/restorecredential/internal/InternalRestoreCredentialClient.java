package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.blockstore.restorecredential.ClearRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialResponse;
import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialResponse;
import com.google.android.gms.auth.blockstore.restorecredential.RestoreCredentialClient;
import com.google.android.gms.auth.blockstore.restorecredential.internal.IClearRestoreCredentialCallback;
import com.google.android.gms.auth.blockstore.restorecredential.internal.ICreateRestoreCredentialCallback;
import com.google.android.gms.auth.blockstore.restorecredential.internal.IGetRestoreCredentialCallback;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth_blockstore.zzab;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class InternalRestoreCredentialClient extends GoogleApi<Api.ApiOptions.NoOptions> implements RestoreCredentialClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f71302a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.ClientKey f71303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final InternalRestoreCredentialClient$Companion$clientBuilder$1 f71304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Api f71305d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient$Companion$clientBuilder$1, com.google.android.gms.common.api.Api$AbstractClientBuilder] */
    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f71303b = clientKey;
        ?? r12 = new Api.AbstractClientBuilder<RestoreCredentialClientImpl, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient$Companion$clientBuilder$1
            @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public RestoreCredentialClientImpl buildClient(Context context, Looper looper, ClientSettings commonSettings, Api.ApiOptions.NoOptions apiOptions, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(looper, "looper");
                Intrinsics.checkNotNullParameter(commonSettings, "commonSettings");
                Intrinsics.checkNotNullParameter(apiOptions, "apiOptions");
                Intrinsics.checkNotNullParameter(connectedListener, "connectedListener");
                Intrinsics.checkNotNullParameter(connectionFailedListener, "connectionFailedListener");
                return new RestoreCredentialClientImpl(context, looper, commonSettings, connectedListener, connectionFailedListener);
            }
        };
        f71304c = r12;
        f71305d = new Api("RestoreCredential.API", r12, clientKey);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalRestoreCredentialClient(Context context) {
        super(context, f71305d, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ClearRestoreCredentialRequest request, RestoreCredentialClientImpl restoreCredentialClientImpl, final TaskCompletionSource taskCompletionSource) {
        Intrinsics.checkNotNullParameter(request, "$request");
        ((IRestoreCredentialService) restoreCredentialClientImpl.getService()).S2(request, new IClearRestoreCredentialCallback.Stub() { // from class: com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient$clearRestoreCredential$1$callback$1
            @Override // com.google.android.gms.auth.blockstore.restorecredential.internal.IClearRestoreCredentialCallback
            public void O4(Status status, boolean z2) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.b(status, Boolean.valueOf(z2), taskCompletionSource);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(CreateRestoreCredentialRequest request, RestoreCredentialClientImpl restoreCredentialClientImpl, final TaskCompletionSource taskCompletionSource) {
        Intrinsics.checkNotNullParameter(request, "$request");
        ((IRestoreCredentialService) restoreCredentialClientImpl.getService()).m2(request, new ICreateRestoreCredentialCallback.Stub() { // from class: com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient$createRestoreCredential$1$callback$1
            @Override // com.google.android.gms.auth.blockstore.restorecredential.internal.ICreateRestoreCredentialCallback
            public void u2(Status status, CreateRestoreCredentialResponse response) {
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(response, "response");
                TaskUtil.b(status, response, taskCompletionSource);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GetRestoreCredentialRequest request, RestoreCredentialClientImpl restoreCredentialClientImpl, final TaskCompletionSource taskCompletionSource) {
        Intrinsics.checkNotNullParameter(request, "$request");
        ((IRestoreCredentialService) restoreCredentialClientImpl.getService()).a0(request, new IGetRestoreCredentialCallback.Stub() { // from class: com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient$getRestoreCredential$1$callback$1
            @Override // com.google.android.gms.auth.blockstore.restorecredential.internal.IGetRestoreCredentialCallback
            public void J0(Status status, GetRestoreCredentialResponse response) {
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(response, "response");
                TaskUtil.b(status, response, taskCompletionSource);
            }
        });
    }

    @Override // com.google.android.gms.auth.blockstore.restorecredential.RestoreCredentialClient
    public Task a(final ClearRestoreCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task<TResult> taskDoRead = doRead(TaskApiCall.a().d(zzab.zzi).b(new RemoteCall() { // from class: com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                InternalRestoreCredentialClient.k(request, (RestoreCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).e(1694).a());
        Intrinsics.checkNotNullExpressionValue(taskDoRead, "doRead(...)");
        return taskDoRead;
    }

    @Override // com.google.android.gms.auth.blockstore.restorecredential.RestoreCredentialClient
    public Task c(final GetRestoreCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task<TResult> taskDoRead = doRead(TaskApiCall.a().d(zzab.zzk).b(new RemoteCall() { // from class: com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                InternalRestoreCredentialClient.m(request, (RestoreCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).e(1695).a());
        Intrinsics.checkNotNullExpressionValue(taskDoRead, "doRead(...)");
        return taskDoRead;
    }

    @Override // com.google.android.gms.auth.blockstore.restorecredential.RestoreCredentialClient
    public Task e(final CreateRestoreCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task<TResult> taskDoRead = doRead(TaskApiCall.a().d(zzab.zzj).b(new RemoteCall() { // from class: com.google.android.gms.auth.blockstore.restorecredential.internal.InternalRestoreCredentialClient$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                InternalRestoreCredentialClient.l(request, (RestoreCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).e(1693).a());
        Intrinsics.checkNotNullExpressionValue(taskDoRead, "doRead(...)");
        return taskDoRead;
    }
}
