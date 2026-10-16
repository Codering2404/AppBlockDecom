package androidx.credentials.provider;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BeginGetPasswordOption extends BeginGetCredentialOption {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f35274f = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f35275e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BeginGetPasswordOption a(Bundle data, String id) {
            Set setEmptySet;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(id, "id");
            ArrayList<String> stringArrayList = data.getStringArrayList("androidx.credentials.BUNDLE_KEY_ALLOWED_USER_IDS");
            if (stringArrayList == null || (setEmptySet = CollectionsKt.toSet(stringArrayList)) == null) {
                setEmptySet = SetsKt.emptySet();
            }
            return new BeginGetPasswordOption(setEmptySet, data, id);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeginGetPasswordOption(Set allowedUserIds, Bundle candidateQueryData, String id) {
        super(id, "android.credentials.TYPE_PASSWORD_CREDENTIAL", candidateQueryData);
        Intrinsics.checkNotNullParameter(allowedUserIds, "allowedUserIds");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        Intrinsics.checkNotNullParameter(id, "id");
        this.f35275e = allowedUserIds;
    }
}
