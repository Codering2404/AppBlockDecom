package androidx.credentials.provider;

import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
public final class SigningInfoCompat {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f35378g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f35379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f35380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection f35381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f35382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f35383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f35384f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SigningInfoCompat a(SigningInfo signingInfo) {
            List listEmptyList;
            Set setEmptySet;
            List listEmptyList2;
            Intrinsics.checkNotNullParameter(signingInfo, "signingInfo");
            Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
            if (apkContentsSigners == null || (listEmptyList = ArraysKt.filterNotNull(apkContentsSigners)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List list = listEmptyList;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 35 || (setEmptySet = signingInfo.getPublicKeys()) == null) {
                setEmptySet = SetsKt.emptySet();
            }
            Collection collection = setEmptySet;
            int schemeVersion = i3 >= 35 ? signingInfo.getSchemeVersion() : 0;
            Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
            if (signingCertificateHistory == null || (listEmptyList2 = ArraysKt.filterNotNull(signingCertificateHistory)) == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            return new SigningInfoCompat(listEmptyList2, list, collection, schemeVersion, signingInfo.hasPastSigningCertificates(), signingInfo.hasMultipleSigners());
        }

        private Companion() {
        }
    }

    public SigningInfoCompat(List signingCertificateHistory, List apkContentsSigners, Collection publicKeys, int i3, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(signingCertificateHistory, "signingCertificateHistory");
        Intrinsics.checkNotNullParameter(apkContentsSigners, "apkContentsSigners");
        Intrinsics.checkNotNullParameter(publicKeys, "publicKeys");
        this.f35379a = signingCertificateHistory;
        this.f35380b = apkContentsSigners;
        this.f35381c = publicKeys;
        this.f35382d = i3;
        this.f35383e = z2;
        this.f35384f = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SigningInfoCompat)) {
            return false;
        }
        SigningInfoCompat signingInfoCompat = (SigningInfoCompat) obj;
        return Intrinsics.areEqual(this.f35379a, signingInfoCompat.f35379a) && Intrinsics.areEqual(this.f35380b, signingInfoCompat.f35380b) && Intrinsics.areEqual(this.f35381c, signingInfoCompat.f35381c) && this.f35382d == signingInfoCompat.f35382d && this.f35383e == signingInfoCompat.f35383e && this.f35384f == signingInfoCompat.f35384f;
    }

    public int hashCode() {
        return (((((((((this.f35379a.hashCode() * 31) + this.f35380b.hashCode()) * 31) + this.f35381c.hashCode()) * 31) + this.f35382d) * 31) + Boolean.hashCode(this.f35383e)) * 31) + Boolean.hashCode(this.f35384f);
    }
}
