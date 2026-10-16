package com.facebook.login;

import android.net.Uri;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DeviceLoginManager extends LoginManager {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<DeviceLoginManager> instance$delegate = LazyKt.b(new Function0<DeviceLoginManager>() { // from class: com.facebook.login.DeviceLoginManager$Companion$instance$2
        @Override // kotlin.jvm.functions.Function0
        public final DeviceLoginManager invoke() {
            return new DeviceLoginManager();
        }
    });
    private String deviceAuthTargetUserId;
    private Uri deviceRedirectUri;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeviceLoginManager getInstance() {
            return (DeviceLoginManager) DeviceLoginManager.access$getInstance$delegate$cp().getValue();
        }

        private Companion() {
        }
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        if (CrashShieldHandler.isObjectCrashing(DeviceLoginManager.class)) {
            return null;
        }
        try {
            return instance$delegate;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceLoginManager.class);
            return null;
        }
    }

    @Override // com.facebook.login.LoginManager
    protected LoginClient.Request createLoginRequest(Collection<String> collection) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LoginClient.Request requestCreateLoginRequest = super.createLoginRequest(collection);
            Uri uri = this.deviceRedirectUri;
            if (uri != null) {
                requestCreateLoginRequest.setDeviceRedirectUriString(uri.toString());
            }
            String str = this.deviceAuthTargetUserId;
            if (str != null) {
                requestCreateLoginRequest.setDeviceAuthTargetUserId(str);
            }
            return requestCreateLoginRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getDeviceAuthTargetUserId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceAuthTargetUserId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final Uri getDeviceRedirectUri() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceRedirectUri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final void setDeviceAuthTargetUserId(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.deviceAuthTargetUserId = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void setDeviceRedirectUri(Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.deviceRedirectUri = uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
