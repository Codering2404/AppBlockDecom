package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import com.facebook.ads.AdError;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;
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
public abstract class CredentialOption {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f34767h = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f34768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f34769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f34770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f34771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f34772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f34773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f34774g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CredentialOption a(String type, Bundle requestData, Bundle candidateQueryData, boolean z2, Set allowedProviders) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(requestData, "requestData");
            Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
            Intrinsics.checkNotNullParameter(allowedProviders, "allowedProviders");
            try {
                int iHashCode = type.hashCode();
                if (iHashCode != -1678407252) {
                    if (iHashCode != -543568185) {
                        if (iHashCode == -95037569 && type.equals("androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL")) {
                            String string = requestData.getString("androidx.credentials.BUNDLE_KEY_SUBTYPE");
                            if (string != null && string.hashCode() == -613058807 && string.equals("androidx.credentials.BUNDLE_VALUE_SUBTYPE_GET_PUBLIC_KEY_CREDENTIAL_OPTION")) {
                                return GetPublicKeyCredentialOption.f34817k.a(requestData, allowedProviders, candidateQueryData);
                            }
                            throw new FrameworkClassParsingException();
                        }
                    } else if (type.equals("android.credentials.TYPE_PASSWORD_CREDENTIAL")) {
                        return GetPasswordOption.f34815j.a(requestData, allowedProviders, candidateQueryData);
                    }
                } else if (type.equals("androidx.credentials.TYPE_DIGITAL_CREDENTIAL")) {
                    return GetDigitalCredentialOption.f34813j.a(requestData, candidateQueryData, z2, allowedProviders);
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                return new GetCustomCredentialOption(requestData, type, candidateQueryData, z2, requestData.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), allowedProviders, requestData.getInt("androidx.credentials.BUNDLE_KEY_TYPE_PRIORITY_VALUE", AdError.SERVER_ERROR_CODE));
            }
        }

        public final boolean b(Bundle data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return data.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface PriorityHints {
    }

    public CredentialOption(String type, Bundle requestData, Bundle candidateQueryData, boolean z2, boolean z3, Set allowedProviders, int i3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        Intrinsics.checkNotNullParameter(allowedProviders, "allowedProviders");
        this.f34768a = type;
        this.f34769b = requestData;
        this.f34770c = candidateQueryData;
        this.f34771d = z2;
        this.f34772e = z3;
        this.f34773f = allowedProviders;
        this.f34774g = i3;
        requestData.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z3);
        candidateQueryData.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z3);
        requestData.putInt("androidx.credentials.BUNDLE_KEY_TYPE_PRIORITY_VALUE", i3);
        candidateQueryData.putInt("androidx.credentials.BUNDLE_KEY_TYPE_PRIORITY_VALUE", i3);
    }

    public final Set a() {
        return this.f34773f;
    }

    public final Bundle b() {
        return this.f34770c;
    }

    public final Bundle c() {
        return this.f34769b;
    }

    public final String d() {
        return this.f34768a;
    }

    public final boolean e() {
        return this.f34772e;
    }

    public final boolean f() {
        return this.f34771d;
    }
}
