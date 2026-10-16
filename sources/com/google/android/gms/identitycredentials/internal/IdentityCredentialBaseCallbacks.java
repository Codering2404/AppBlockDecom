package com.google.android.gms.identitycredentials.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.identitycredentials.ClearRegistryResponse;
import com.google.android.gms.identitycredentials.PendingGetCredentialHandle;
import com.google.android.gms.identitycredentials.PendingImportCredentialsHandle;
import com.google.android.gms.identitycredentials.RegisterExportResponse;
import com.google.android.gms.identitycredentials.RegistrationResponse;
import com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks;
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
public abstract class IdentityCredentialBaseCallbacks extends IIdentityCredentialCallbacks.Stub {
    @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
    public void I4(Status status, RegistrationResponse registrationResponse) {
        Intrinsics.checkNotNullParameter(status, "status");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
    public void V4(Status status, RegisterExportResponse registerExportResponse) {
        Intrinsics.checkNotNullParameter(status, "status");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
    public void j0(Status status, PendingImportCredentialsHandle pendingImportCredentialsHandle) {
        Intrinsics.checkNotNullParameter(status, "status");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
    public void l4(Status status, PendingGetCredentialHandle pendingGetCredentialHandle) {
        Intrinsics.checkNotNullParameter(status, "status");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
    public void q3(Status status, ClearRegistryResponse clearRegistryResponse) {
        Intrinsics.checkNotNullParameter(status, "status");
        throw new UnsupportedOperationException();
    }
}
