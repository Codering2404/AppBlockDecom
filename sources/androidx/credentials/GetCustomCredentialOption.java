package androidx.credentials;

import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class GetCustomCredentialOption extends CredentialOption {
    public /* synthetic */ GetCustomCredentialOption(Bundle bundle, String str, Bundle bundle2, boolean z2, boolean z3, Set set, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle, str, bundle2, z2, (i4 & 16) != 0 ? false : z3, (i4 & 32) != 0 ? SetsKt.emptySet() : set, (i4 & 64) != 0 ? 2000 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCustomCredentialOption(Bundle requestData, String type, Bundle candidateQueryData, boolean z2, boolean z3, Set allowedProviders, int i3) {
        super(type, requestData, candidateQueryData, z2, z3, allowedProviders, i3);
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        Intrinsics.checkNotNullParameter(allowedProviders, "allowedProviders");
        if (type.length() <= 0) {
            throw new IllegalArgumentException("type should not be empty");
        }
        if (i3 == 100) {
            throw new IllegalArgumentException("Custom types should not have passkey level priority.");
        }
    }

    public /* synthetic */ GetCustomCredentialOption(String str, Bundle bundle, Bundle bundle2, boolean z2, boolean z3, Set set, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle, bundle2, z2, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? SetsKt.emptySet() : set);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetCustomCredentialOption(String type, Bundle requestData, Bundle candidateQueryData, boolean z2, boolean z3, Set allowedProviders) {
        this(requestData, type, candidateQueryData, z2, z3, allowedProviders, 0, 64, null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        Intrinsics.checkNotNullParameter(allowedProviders, "allowedProviders");
    }
}
