package com.google.android.gms.identitycredentials.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
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
public final class InternalIdentityCredentialClientKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey f72850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final InternalIdentityCredentialClientKt$clientBuilder$1 f72851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Api f72852c;

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.common.api.Api$AbstractClientBuilder, com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClientKt$clientBuilder$1] */
    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f72850a = clientKey;
        ?? r12 = new Api.AbstractClientBuilder<IdentityCredentialClientImpl, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClientKt$clientBuilder$1
            @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public IdentityCredentialClientImpl buildClient(Context context, Looper looper, ClientSettings commonSettings, Api.ApiOptions.NoOptions apiOptions, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(looper, "looper");
                Intrinsics.checkNotNullParameter(commonSettings, "commonSettings");
                Intrinsics.checkNotNullParameter(apiOptions, "apiOptions");
                Intrinsics.checkNotNullParameter(connectedListener, "connectedListener");
                Intrinsics.checkNotNullParameter(connectionFailedListener, "connectionFailedListener");
                return new IdentityCredentialClientImpl(context, looper, commonSettings, connectedListener, connectionFailedListener);
            }
        };
        f72851b = r12;
        f72852c = new Api("IdentityCredentials.API", r12, clientKey);
    }
}
