package androidx.credentials.provider;

import android.content.ComponentName;
import android.credentials.CredentialOption;
import android.os.Bundle;
import androidx.credentials.CredentialOption;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class PendingIntentHandler$Api34Impl$Companion$retrieveProviderGetCredentialRequest$1 extends Lambda implements Function1<CredentialOption, androidx.credentials.CredentialOption> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PendingIntentHandler$Api34Impl$Companion$retrieveProviderGetCredentialRequest$1 f35356a = new PendingIntentHandler$Api34Impl$Companion$retrieveProviderGetCredentialRequest$1();

    PendingIntentHandler$Api34Impl$Companion$retrieveProviderGetCredentialRequest$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final androidx.credentials.CredentialOption invoke(CredentialOption credentialOption) {
        CredentialOption.Companion companion = androidx.credentials.CredentialOption.f34767h;
        String type = credentialOption.getType();
        Intrinsics.checkNotNullExpressionValue(type, "option.type");
        Bundle credentialRetrievalData = credentialOption.getCredentialRetrievalData();
        Intrinsics.checkNotNullExpressionValue(credentialRetrievalData, "option.credentialRetrievalData");
        Bundle candidateQueryData = credentialOption.getCandidateQueryData();
        Intrinsics.checkNotNullExpressionValue(candidateQueryData, "option.candidateQueryData");
        boolean zIsSystemProviderRequired = credentialOption.isSystemProviderRequired();
        Set<ComponentName> allowedProviders = credentialOption.getAllowedProviders();
        Intrinsics.checkNotNullExpressionValue(allowedProviders, "option.allowedProviders");
        return companion.a(type, credentialRetrievalData, candidateQueryData, zIsSystemProviderRequired, allowedProviders);
    }
}
