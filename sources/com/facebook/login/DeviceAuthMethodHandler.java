package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public class DeviceAuthMethodHandler extends LoginMethodHandler {
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private final String nameForLogging;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new Parcelable.Creator<DeviceAuthMethodHandler>() { // from class: com.facebook.login.DeviceAuthMethodHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceAuthMethodHandler createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new DeviceAuthMethodHandler(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceAuthMethodHandler[] newArray(int i3) {
            return new DeviceAuthMethodHandler[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
            try {
                if (DeviceAuthMethodHandler.backgroundExecutor == null) {
                    DeviceAuthMethodHandler.backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                }
                scheduledThreadPoolExecutor = DeviceAuthMethodHandler.backgroundExecutor;
                if (scheduledThreadPoolExecutor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundExecutor");
                    scheduledThreadPoolExecutor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
            return scheduledThreadPoolExecutor;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        this.nameForLogging = "device_auth";
    }

    @JvmStatic
    public static final synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        return Companion.getBackgroundExecutor();
    }

    private final void showDialog(LoginClient.Request request) {
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        DeviceAuthDialog deviceAuthDialogCreateDeviceAuthDialog = createDeviceAuthDialog();
        deviceAuthDialogCreateDeviceAuthDialog.show(activity.getSupportFragmentManager(), "login_with_facebook");
        deviceAuthDialogCreateDeviceAuthDialog.startLogin(request);
    }

    protected DeviceAuthDialog createDeviceAuthDialog() {
        return new DeviceAuthDialog();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public void onCancel() {
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createCancelResult(getLoginClient().getPendingRequest(), LoginMethodHandler.USER_CANCELED_LOG_IN_ERROR_MESSAGE));
    }

    public void onError(Exception ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, getLoginClient().getPendingRequest(), null, ex.getMessage(), null, 8, null));
    }

    public void onSuccess(String accessToken, String applicationId, String userId, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createTokenResult(getLoginClient().getPendingRequest(), new AccessToken(accessToken, applicationId, userId, collection, collection2, collection3, accessTokenSource, date, date2, date3, null, 1024, null)));
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        showDialog(request);
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.nameForLogging = "device_auth";
    }
}
