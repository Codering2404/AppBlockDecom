package androidx.credentials;

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
public final class GetPasswordOption extends CredentialOption {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f34815j = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set f34816i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GetPasswordOption a(Bundle data, Set allowedProviders, Bundle candidateQueryData) {
            Set setEmptySet;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(allowedProviders, "allowedProviders");
            Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
            ArrayList<String> stringArrayList = data.getStringArrayList("androidx.credentials.BUNDLE_KEY_ALLOWED_USER_IDS");
            if (stringArrayList == null || (setEmptySet = CollectionsKt.toSet(stringArrayList)) == null) {
                setEmptySet = SetsKt.emptySet();
            }
            return new GetPasswordOption(setEmptySet, data.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), allowedProviders, data, candidateQueryData, data.getInt("androidx.credentials.BUNDLE_KEY_TYPE_PRIORITY_VALUE", 1000), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ GetPasswordOption(Set set, boolean z2, Set set2, Bundle bundle, Bundle bundle2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, z2, set2, bundle, bundle2, i3);
    }

    private GetPasswordOption(Set set, boolean z2, Set set2, Bundle bundle, Bundle bundle2, int i3) {
        super("android.credentials.TYPE_PASSWORD_CREDENTIAL", bundle, bundle2, false, z2, set2, i3);
        this.f34816i = set;
    }
}
