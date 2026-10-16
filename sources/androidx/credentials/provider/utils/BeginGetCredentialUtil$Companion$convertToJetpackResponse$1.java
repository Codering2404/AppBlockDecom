package androidx.credentials.provider.utils;

import android.app.slice.Slice;
import android.service.credentials.CredentialEntry;
import androidx.credentials.provider.CredentialEntry;
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
final class BeginGetCredentialUtil$Companion$convertToJetpackResponse$1 extends Lambda implements Function1<CredentialEntry, androidx.credentials.provider.CredentialEntry> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BeginGetCredentialUtil$Companion$convertToJetpackResponse$1 f35391a = new BeginGetCredentialUtil$Companion$convertToJetpackResponse$1();

    BeginGetCredentialUtil$Companion$convertToJetpackResponse$1() {
        super(1);
    }

    public final androidx.credentials.provider.CredentialEntry c(CredentialEntry credentialEntry) {
        CredentialEntry.Companion companion = androidx.credentials.provider.CredentialEntry.f35307g;
        Slice slice = credentialEntry.getSlice();
        Intrinsics.checkNotNullExpressionValue(slice, "entry.slice");
        return companion.a(slice);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return c(h0.a(obj));
    }
}
