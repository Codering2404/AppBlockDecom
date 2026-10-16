package androidx.credentials;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import java.util.ArrayList;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CredentialProviderFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f34775e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f34776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f34777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CredentialProvider f34778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CredentialProvider f34779d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CredentialProviderFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f34776a = context;
    }

    private final List a(Context context) throws PackageManager.NameNotFoundException {
        String string;
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 132);
        ArrayList arrayList = new ArrayList();
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            Intrinsics.checkNotNull(serviceInfoArr);
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                Bundle bundle = serviceInfo.metaData;
                if (bundle != null && (string = bundle.getString("androidx.credentials.CREDENTIAL_PROVIDER_KEY")) != null) {
                    arrayList.add(string);
                }
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    public static /* synthetic */ CredentialProvider d(CredentialProviderFactory credentialProviderFactory, Object obj, boolean z2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return credentialProviderFactory.b(obj, z2);
    }

    private final CredentialProvider f() {
        if (!this.f34777b) {
            CredentialProviderFrameworkImpl credentialProviderFrameworkImpl = new CredentialProviderFrameworkImpl(this.f34776a);
            if (credentialProviderFrameworkImpl.isAvailableOnDevice()) {
                return credentialProviderFrameworkImpl;
            }
            return null;
        }
        CredentialProvider credentialProvider = this.f34778c;
        if (credentialProvider == null) {
            return null;
        }
        Intrinsics.checkNotNull(credentialProvider);
        if (credentialProvider.isAvailableOnDevice()) {
            return this.f34778c;
        }
        return null;
    }

    private final CredentialProvider g() throws PackageManager.NameNotFoundException {
        if (!this.f34777b) {
            List listA = a(this.f34776a);
            if (listA.isEmpty()) {
                return null;
            }
            return e(listA, this.f34776a);
        }
        CredentialProvider credentialProvider = this.f34779d;
        if (credentialProvider == null) {
            return null;
        }
        Intrinsics.checkNotNull(credentialProvider);
        if (credentialProvider.isAvailableOnDevice()) {
            return this.f34779d;
        }
        return null;
    }

    public final CredentialProvider b(Object request, boolean z2) {
        Intrinsics.checkNotNullParameter(request, "request");
        if ((request instanceof CreateRestoreCredentialRequest) || Intrinsics.areEqual(request, "androidx.credentials.TYPE_CLEAR_RESTORE_CREDENTIAL")) {
            return g();
        }
        if (request instanceof GetCredentialRequest) {
            for (CredentialOption credentialOption : ((GetCredentialRequest) request).a()) {
                if ((credentialOption instanceof GetRestoreCredentialOption) || (credentialOption instanceof GetDigitalCredentialOption)) {
                    return g();
                }
            }
        }
        return c(z2);
    }

    public final CredentialProvider c(boolean z2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 34) {
            CredentialProvider credentialProviderF = f();
            return (credentialProviderF == null && z2) ? g() : credentialProviderF;
        }
        if (i3 <= 33) {
            return g();
        }
        return null;
    }

    private final CredentialProvider e(List list, Context context) {
        Iterator it = list.iterator();
        CredentialProvider credentialProvider = null;
        while (it.hasNext()) {
            try {
                Object objNewInstance = Class.forName((String) it.next()).getConstructor(Context.class).newInstance(context);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.credentials.CredentialProvider");
                CredentialProvider credentialProvider2 = (CredentialProvider) objNewInstance;
                if (!credentialProvider2.isAvailableOnDevice()) {
                    continue;
                } else {
                    if (credentialProvider != null) {
                        Log.i("CredProviderFactory", jTYhJgqLBN.WePW);
                        return null;
                    }
                    credentialProvider = credentialProvider2;
                }
            } catch (Throwable unused) {
            }
        }
        return credentialProvider;
    }
}
