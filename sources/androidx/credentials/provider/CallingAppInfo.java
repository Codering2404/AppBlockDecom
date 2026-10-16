package androidx.credentials.provider;

import android.content.pm.SigningInfo;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CallingAppInfo {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f35289e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f35291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SigningInfoCompat f35292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SigningInfo f35293d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CallingAppInfo a(String packageName, SigningInfo signingInfo, String str) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(signingInfo, "signingInfo");
            return new CallingAppInfo(packageName, signingInfo, str);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SignatureVerifier {
    }

    private CallingAppInfo(String str, String str2, SigningInfoCompat signingInfoCompat, SigningInfo signingInfo) {
        this.f35290a = str;
        this.f35291b = str2;
        this.f35292c = signingInfoCompat;
        Intrinsics.checkNotNull(signingInfo);
        this.f35293d = signingInfo;
        if (str.length() <= 0) {
            throw new IllegalArgumentException("packageName must not be empty");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallingAppInfo)) {
            return false;
        }
        CallingAppInfo callingAppInfo = (CallingAppInfo) obj;
        return Intrinsics.areEqual(this.f35290a, callingAppInfo.f35290a) && Intrinsics.areEqual(this.f35291b, callingAppInfo.f35291b) && Intrinsics.areEqual(this.f35292c, callingAppInfo.f35292c);
    }

    public int hashCode() {
        int iHashCode = this.f35290a.hashCode() * 31;
        String str = this.f35291b;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f35292c.hashCode();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallingAppInfo(String packageName, SigningInfo signingInfo, String str) {
        this(packageName, str, SigningInfoCompat.f35378g.a(signingInfo), signingInfo);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signingInfo, "signingInfo");
    }
}
