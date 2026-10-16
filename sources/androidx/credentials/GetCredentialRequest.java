package androidx.credentials;

import android.content.ComponentName;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class GetCredentialRequest {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f34800f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f34801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f34802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f34803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ComponentName f34804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f34805e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f34806a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f34807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f34808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f34809d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ComponentName f34810e;

        public final Builder a(CredentialOption credentialOption) {
            Intrinsics.checkNotNullParameter(credentialOption, "credentialOption");
            this.f34806a.add(credentialOption);
            return this;
        }

        public final GetCredentialRequest b() {
            return new GetCredentialRequest(CollectionsKt.toList(this.f34806a), this.f34807b, this.f34808c, this.f34810e, this.f34809d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(GetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IDENTITY_DOC_UI", request.c());
            bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", request.e());
            bundle.putParcelable("androidx.credentials.BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME", request.d());
            return bundle;
        }

        private Companion() {
        }
    }

    public GetCredentialRequest(List credentialOptions, String str, boolean z2, ComponentName componentName, boolean z3) {
        Intrinsics.checkNotNullParameter(credentialOptions, "credentialOptions");
        this.f34801a = credentialOptions;
        this.f34802b = str;
        this.f34803c = z2;
        this.f34804d = componentName;
        this.f34805e = z3;
        if (credentialOptions.isEmpty()) {
            throw new IllegalArgumentException("credentialOptions should not be empty");
        }
        if (credentialOptions.size() > 1) {
            List list = credentialOptions;
            int i3 = 0;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if ((((CredentialOption) it.next()) instanceof GetDigitalCredentialOption) && (i3 = i3 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i3 > 0 && i3 != this.f34801a.size()) {
                throw new IllegalArgumentException("Digital Credential Option cannot be used with other credential option.");
            }
            Iterator it2 = this.f34801a.iterator();
            while (it2.hasNext()) {
                if (((CredentialOption) it2.next()) instanceof GetRestoreCredentialOption) {
                    throw new IllegalArgumentException("Only a single GetRestoreCredentialOption should be provided.");
                }
            }
        }
    }

    public final List a() {
        return this.f34801a;
    }

    public final String b() {
        return this.f34802b;
    }

    public final boolean c() {
        return this.f34803c;
    }

    public final ComponentName d() {
        return this.f34804d;
    }

    public final boolean e() {
        return this.f34805e;
    }
}
