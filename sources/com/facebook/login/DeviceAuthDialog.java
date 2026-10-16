package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.LoginClient;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
public class DeviceAuthDialog extends DialogFragment {
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
    private static final String REQUEST_STATE_KEY = "request_state";
    private final AtomicBoolean completed = new AtomicBoolean();
    private TextView confirmationCode;
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    private volatile RequestState currentRequestState;
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    private TextView instructions;
    private boolean isBeingDestroyed;
    private boolean isRetry;
    private View progressBar;
    private LoginClient.Request request;
    private volatile ScheduledFuture<?> scheduledPoll;
    public static final Companion Companion = new Companion(null);
    private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
    private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PermissionsLists handlePermissionResponse(JSONObject jSONObject) throws JSONException {
            String strOptString;
            JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                String permission = jSONObjectOptJSONObject.optString("permission");
                Intrinsics.checkNotNullExpressionValue(permission, "permission");
                if (permission.length() != 0 && !Intrinsics.areEqual(permission, "installed") && (strOptString = jSONObjectOptJSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) != null) {
                    int iHashCode = strOptString.hashCode();
                    if (iHashCode != -1309235419) {
                        if (iHashCode != 280295099) {
                            if (iHashCode == 568196142 && strOptString.equals("declined")) {
                                arrayList2.add(permission);
                            }
                        } else if (strOptString.equals("granted")) {
                            arrayList.add(permission);
                        }
                    } else if (strOptString.equals("expired")) {
                        arrayList3.add(permission);
                    }
                }
            }
            return new PermissionsLists(arrayList, arrayList2, arrayList3);
        }

        public final String getDEVICE_LOGIN_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_ENDPOINT;
        }

        public final String getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_STATUS_ENDPOINT;
        }

        public final int getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release() {
            return DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING;
        }

        private Companion() {
        }

        public static /* synthetic */ void getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations() {
        }

        public static /* synthetic */ void getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations() {
        }

        public static /* synthetic */ void getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class PermissionsLists {
        private List<String> declinedPermissions;
        private List<String> expiredPermissions;
        private List<String> grantedPermissions;

        public PermissionsLists(List<String> grantedPermissions, List<String> declinedPermissions, List<String> expiredPermissions) {
            Intrinsics.checkNotNullParameter(grantedPermissions, "grantedPermissions");
            Intrinsics.checkNotNullParameter(declinedPermissions, "declinedPermissions");
            Intrinsics.checkNotNullParameter(expiredPermissions, "expiredPermissions");
            this.grantedPermissions = grantedPermissions;
            this.declinedPermissions = declinedPermissions;
            this.expiredPermissions = expiredPermissions;
        }

        public final List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        public final List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }

        public final List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setDeclinedPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.declinedPermissions = list;
        }

        public final void setExpiredPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.expiredPermissions = list;
        }

        public final void setGrantedPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.grantedPermissions = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class RequestState implements Parcelable {
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        private String requestCode;
        private String userCode;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() { // from class: com.facebook.login.DeviceAuthDialog$RequestState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DeviceAuthDialog.RequestState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DeviceAuthDialog.RequestState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DeviceAuthDialog.RequestState[] newArray(int i3) {
                return new DeviceAuthDialog.RequestState[i3];
            }
        };

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public RequestState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final String getRequestCode() {
            return this.requestCode;
        }

        public final String getUserCode() {
            return this.userCode;
        }

        public final void setInterval(long j3) {
            this.interval = j3;
        }

        public final void setLastPoll(long j3) {
            this.lastPoll = j3;
        }

        public final void setRequestCode(String str) {
            this.requestCode = str;
        }

        public final void setUserCode(String str) {
            this.userCode = str;
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str2 = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
            this.authorizationUri = str2;
        }

        public final boolean withinLastRefreshWindow() {
            return this.lastPoll != 0 && (new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.authorizationUri);
            dest.writeString(this.userCode);
            dest.writeString(this.requestCode);
            dest.writeLong(this.interval);
            dest.writeLong(this.lastPoll);
        }

        protected RequestState(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _get_pollRequest_$lambda$5(DeviceAuthDialog this$0, GraphResponse response) {
        FacebookException facebookException;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this$0.completed.get()) {
            return;
        }
        FacebookRequestError error = response.getError();
        if (error == null) {
            try {
                JSONObject jSONObject = response.getJSONObject();
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String string = jSONObject.getString("access_token");
                Intrinsics.checkNotNullExpressionValue(string, "resultObject.getString(\"access_token\")");
                this$0.onSuccess(string, jSONObject.getLong(AccessToken.EXPIRES_IN_KEY), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                return;
            } catch (JSONException e3) {
                this$0.onError(new FacebookException(e3));
                return;
            }
        }
        int subErrorCode = error.getSubErrorCode();
        if (subErrorCode == LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING || subErrorCode == LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING) {
            this$0.schedulePoll();
            return;
        }
        if (subErrorCode == LOGIN_ERROR_SUBCODE_CODE_EXPIRED) {
            RequestState requestState = this$0.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            LoginClient.Request request = this$0.request;
            if (request != null) {
                this$0.startLogin(request);
                return;
            } else {
                this$0.onCancel();
                return;
            }
        }
        if (subErrorCode == LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED) {
            this$0.onCancel();
            return;
        }
        FacebookRequestError error2 = response.getError();
        if (error2 == null || (facebookException = error2.getException()) == null) {
            facebookException = new FacebookException();
        }
        this$0.onError(facebookException);
    }

    private final void completeLogin(String str, PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler != null) {
            deviceAuthMethodHandler.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsLists.getGrantedPermissions(), permissionsLists.getDeclinedPermissions(), permissionsLists.getExpiredPermissions(), AccessTokenSource.DEVICE_AUTH, date, null, date2);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final GraphRequest getPollRequest() {
        Bundle bundle = new Bundle();
        RequestState requestState = this.currentRequestState;
        bundle.putString("code", requestState != null ? requestState.getRequestCode() : null);
        bundle.putString("access_token", getApplicationAccessToken());
        return GraphRequest.Companion.newPostRequestWithBundle(null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, new GraphRequest.Callback() { // from class: com.facebook.login.g
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog._get_pollRequest_$lambda$5(this.f68200a, graphResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeContentView$lambda$2(DeviceAuthDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCancel();
    }

    private final void onSuccess(final String str, long j3, Long l3) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        Date date = null;
        Date date2 = j3 != 0 ? new Date(new Date().getTime() + (j3 * 1000)) : null;
        if ((l3 == null || l3.longValue() != 0) && l3 != null) {
            date = new Date(l3.longValue() * 1000);
        }
        final Date date3 = date;
        final Date date4 = date2;
        GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(new AccessToken(str, FacebookSdk.getApplicationId(), AppEventsConstants.EVENT_PARAM_VALUE_NO, null, null, null, null, date2, null, date3, null, 1024, null), "me", new GraphRequest.Callback() { // from class: com.facebook.login.e
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.onSuccess$lambda$10(this.f68195a, str, date4, date3, graphResponse);
            }
        });
        graphRequestNewGraphPathRequest.setHttpMethod(HttpMethod.GET);
        graphRequestNewGraphPathRequest.setParameters(bundle);
        graphRequestNewGraphPathRequest.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$10(DeviceAuthDialog this$0, String accessToken, Date date, Date date2, GraphResponse response) {
        DeviceAuthDialog deviceAuthDialog;
        JSONException jSONException;
        EnumSet<SmartLoginOption> smartLoginOptions;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(accessToken, "$accessToken");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this$0.completed.get()) {
            return;
        }
        FacebookRequestError error = response.getError();
        if (error != null) {
            FacebookException exception = error.getException();
            if (exception == null) {
                exception = new FacebookException();
            }
            this$0.onError(exception);
            return;
        }
        try {
            JSONObject jSONObject = response.getJSONObject();
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e3) {
                    jSONException = e3;
                    deviceAuthDialog = this$0;
                    deviceAuthDialog.onError(new FacebookException(jSONException));
                    return;
                }
            }
            String string = jSONObject.getString("id");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"id\")");
            PermissionsLists permissionsListsHandlePermissionResponse = Companion.handlePermissionResponse(jSONObject);
            String string2 = jSONObject.getString("name");
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"name\")");
            RequestState requestState = this$0.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (!Intrinsics.areEqual((appSettingsWithoutQuery == null || (smartLoginOptions = appSettingsWithoutQuery.getSmartLoginOptions()) == null) ? null : Boolean.valueOf(smartLoginOptions.contains(SmartLoginOption.RequireConfirm)), Boolean.TRUE) || this$0.isRetry) {
                this$0.completeLogin(string, permissionsListsHandlePermissionResponse, accessToken, date, date2);
            } else {
                this$0.isRetry = true;
                this$0.presentConfirmation(string, permissionsListsHandlePermissionResponse, accessToken, string2, date, date2);
            }
        } catch (JSONException e4) {
            deviceAuthDialog = this$0;
            jSONException = e4;
        }
    }

    private final void poll() {
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            requestState.setLastPoll(new Date().getTime());
        }
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
    }

    private final void presentConfirmation(final String str, final PermissionsLists permissionsLists, final String str2, String str3, final Date date, final Date date2) {
        String string = getResources().getString(com.facebook.common.R.string.com_facebook_smart_login_confirmation_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…login_confirmation_title)");
        String string2 = getResources().getString(com.facebook.common.R.string.com_facebook_smart_login_confirmation_continue_as);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…confirmation_continue_as)");
        String string3 = getResources().getString(com.facebook.common.R.string.com_facebook_smart_login_confirmation_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…ogin_confirmation_cancel)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str4 = String.format(string2, Arrays.copyOf(new Object[]{str3}, 1));
        Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(str4, new DialogInterface.OnClickListener() { // from class: com.facebook.login.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DeviceAuthDialog.presentConfirmation$lambda$6(this.f68188a, str, permissionsLists, str2, date, date2, dialogInterface, i3);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: com.facebook.login.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DeviceAuthDialog.presentConfirmation$lambda$8(this.f68194a, dialogInterface, i3);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentConfirmation$lambda$6(DeviceAuthDialog this$0, String userId, PermissionsLists permissions, String accessToken, Date date, Date date2, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(userId, "$userId");
        Intrinsics.checkNotNullParameter(permissions, "$permissions");
        Intrinsics.checkNotNullParameter(accessToken, "$accessToken");
        this$0.completeLogin(userId, permissions, accessToken, date, date2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentConfirmation$lambda$8(DeviceAuthDialog this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View viewInitializeContentView = this$0.initializeContentView(false);
        Dialog dialog = this$0.getDialog();
        if (dialog != null) {
            dialog.setContentView(viewInitializeContentView);
        }
        LoginClient.Request request = this$0.request;
        if (request != null) {
            this$0.startLogin(request);
        }
    }

    private final void schedulePoll() {
        RequestState requestState = this.currentRequestState;
        Long lValueOf = requestState != null ? Long.valueOf(requestState.getInterval()) : null;
        if (lValueOf != null) {
            this.scheduledPoll = DeviceAuthMethodHandler.Companion.getBackgroundExecutor().schedule(new Runnable() { // from class: com.facebook.login.f
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceAuthDialog.schedulePoll$lambda$3(this.f68199a);
                }
            }, lValueOf.longValue(), TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void schedulePoll$lambda$3(DeviceAuthDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.poll();
    }

    private final void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        TextView textView = this.confirmationCode;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationCode");
            textView = null;
        }
        textView.setText(requestState.getUserCode());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(requestState.getAuthorizationUri()));
        TextView textView2 = this.instructions;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instructions");
            textView2 = null;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bitmapDrawable, (Drawable) null, (Drawable) null);
        TextView textView3 = this.confirmationCode;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationCode");
            textView3 = null;
        }
        textView3.setVisibility(0);
        View view2 = this.progressBar;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            view = view2;
        }
        view.setVisibility(8);
        if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(requestState.getUserCode())) {
            new InternalAppEventsLogger(getContext()).logEventImplicitly(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE);
        }
        if (requestState.withinLastRefreshWindow()) {
            schedulePoll();
        } else {
            poll();
        }
    }

    public Map<String, String> additionalDeviceInfo() {
        return null;
    }

    public String getApplicationAccessToken() {
        return Validate.hasAppID() + '|' + Validate.hasClientToken();
    }

    protected int getLayoutResId(boolean z2) {
        return z2 ? com.facebook.common.R.layout.com_facebook_smart_device_dialog_fragment : com.facebook.common.R.layout.com_facebook_device_auth_dialog_fragment;
    }

    protected View initializeContentView(boolean z2) {
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "requireActivity().layoutInflater");
        TextView textView = null;
        View viewInflate = layoutInflater.inflate(getLayoutResId(z2), (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflater.inflate(getLayo…esId(isSmartLogin), null)");
        View viewFindViewById = viewInflate.findViewById(com.facebook.common.R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.progress_bar)");
        this.progressBar = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(com.facebook.common.R.id.confirmation_code);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.confirmationCode = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(com.facebook.common.R.id.cancel_button);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.Button");
        ((Button) viewFindViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceAuthDialog.initializeContentView$lambda$2(this.f68187a, view);
            }
        });
        View viewFindViewById4 = viewInflate.findViewById(com.facebook.common.R.id.com_facebook_device_auth_instructions);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewFindViewById4;
        this.instructions = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instructions");
        } else {
            textView = textView2;
        }
        textView.setText(Html.fromHtml(getString(com.facebook.common.R.string.com_facebook_device_auth_instructions)));
        return viewInflate;
    }

    protected boolean onBackButtonPressed() {
        return true;
    }

    protected void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.onCancel();
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        final int i3 = com.facebook.common.R.style.com_facebook_auth_dialog;
        Dialog dialog = new Dialog(fragmentActivityRequireActivity, i3) { // from class: com.facebook.login.DeviceAuthDialog$onCreateDialog$dialog$1
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (this.this$0.onBackButtonPressed()) {
                    super.onBackPressed();
                }
            }
        };
        dialog.setContentView(initializeContentView(DeviceRequestsHelper.isAvailable() && !this.isRetry));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        LoginClient loginClient;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, viewGroup, bundle);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.facebook.FacebookActivity");
        LoginFragment loginFragment = (LoginFragment) ((FacebookActivity) fragmentActivityRequireActivity).getCurrentFragment();
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) ((loginFragment == null || (loginClient = loginFragment.getLoginClient()) == null) ? null : loginClient.getCurrentHandler());
        if (bundle != null && (requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY)) != null) {
            setCurrentRequestState(requestState);
        }
        return viewOnCreateView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        GraphRequestAsyncTask graphRequestAsyncTask = this.currentGraphRequestPoll;
        if (graphRequestAsyncTask != null) {
            graphRequestAsyncTask.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = this.scheduledPoll;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.isBeingDestroyed) {
            return;
        }
        onCancel();
    }

    protected void onError(FacebookException ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.onError(ex);
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        if (this.currentRequestState != null) {
            outState.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
    }

    public void startLogin(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.getPermissions()));
        Utility.putNonEmptyString(bundle, ServerProtocol.DIALOG_PARAM_REDIRECT_URI, request.getDeviceRedirectUriString());
        Utility.putNonEmptyString(bundle, DeviceRequestsHelper.DEVICE_TARGET_USER_ID, request.getDeviceAuthTargetUserId());
        bundle.putString("access_token", getApplicationAccessToken());
        Map<String, String> mapAdditionalDeviceInfo = additionalDeviceInfo();
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo(mapAdditionalDeviceInfo != null ? MapsKt.toMutableMap(mapAdditionalDeviceInfo) : null));
        GraphRequest.Companion.newPostRequestWithBundle(null, DEVICE_LOGIN_ENDPOINT, bundle, new GraphRequest.Callback() { // from class: com.facebook.login.h
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.startLogin$lambda$1(this.f68201a, graphResponse);
            }
        }).executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLogin$lambda$1(DeviceAuthDialog deviceAuthDialog, GraphResponse response) {
        FacebookException facebookException;
        Intrinsics.checkNotNullParameter(deviceAuthDialog, wgbAZXYjrv.DzGBDIKizjWJiW);
        Intrinsics.checkNotNullParameter(response, "response");
        if (deviceAuthDialog.isBeingDestroyed) {
            return;
        }
        if (response.getError() != null) {
            FacebookRequestError error = response.getError();
            if (error == null || (facebookException = error.getException()) == null) {
                facebookException = new FacebookException();
            }
            deviceAuthDialog.onError(facebookException);
            return;
        }
        JSONObject jSONObject = response.getJSONObject();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        RequestState requestState = new RequestState();
        try {
            requestState.setUserCode(jSONObject.getString("user_code"));
            requestState.setRequestCode(jSONObject.getString("code"));
            requestState.setInterval(jSONObject.getLong("interval"));
            deviceAuthDialog.setCurrentRequestState(requestState);
        } catch (JSONException e3) {
            deviceAuthDialog.onError(new FacebookException(e3));
        }
    }
}
