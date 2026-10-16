package com.facebook.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.common.R;
import com.facebook.internal.WebDialog;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginTargetApp;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
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
public class WebDialog extends Dialog {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = -872415232;
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_THEME = R.style.com_facebook_activity_theme;
    private static final String DISPLAY_TOUCH = "touch";
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5d;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;
    private static final String PLATFORM_DIALOG_PATH_REGEX = "^/(v\\d+\\.\\d+/)??dialog/.*";
    private static InitCallback initCallback;
    private static volatile int webDialogTheme;
    private FrameLayout contentFrameLayout;
    private ImageView crossImageView;
    private String expectedRedirectUrl;
    private boolean isDetached;
    private boolean isListenerCalled;
    private boolean isPageFinished;
    private OnCompleteListener onCompleteListener;
    private ProgressDialog spinner;
    private UploadStagingResourcesTask uploadTask;
    private String url;
    private WebView webView;
    private WindowManager.LayoutParams windowParams;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int getWebDialogTheme() {
            Validate.sdkInitialized();
            return WebDialog.webDialogTheme;
        }

        @JvmStatic
        protected final void initDefaultTheme(Context context) {
            if (context == null) {
                return;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                if ((applicationInfo != null ? applicationInfo.metaData : null) != null && WebDialog.webDialogTheme == 0) {
                    setWebDialogTheme(applicationInfo.metaData.getInt(FacebookSdk.WEB_DIALOG_THEME));
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }

        @JvmStatic
        public final WebDialog newInstance(Context context, String str, Bundle bundle, int i3, OnCompleteListener onCompleteListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, str, bundle, i3, LoginTargetApp.FACEBOOK, onCompleteListener, null);
        }

        @JvmStatic
        public final void setInitCallback(InitCallback initCallback) {
            WebDialog.initCallback = initCallback;
        }

        @JvmStatic
        public final void setWebDialogTheme(int i3) {
            if (i3 == 0) {
                i3 = WebDialog.DEFAULT_THEME;
            }
            WebDialog.webDialogTheme = i3;
        }

        private Companion() {
        }

        @JvmStatic
        public final WebDialog newInstance(Context context, String str, Bundle bundle, int i3, LoginTargetApp targetApp, OnCompleteListener onCompleteListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(targetApp, "targetApp");
            WebDialog.initDefaultTheme(context);
            return new WebDialog(context, str, bundle, i3, targetApp, onCompleteListener, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class DialogWebViewClient extends WebViewClient {
        public DialogWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            ProgressDialog progressDialog;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            if (!WebDialog.this.isDetached && (progressDialog = WebDialog.this.spinner) != null) {
                progressDialog.dismiss();
            }
            FrameLayout frameLayout = WebDialog.this.contentFrameLayout;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(0);
            }
            WebView webView = WebDialog.this.getWebView();
            if (webView != null) {
                webView.setVisibility(0);
            }
            ImageView imageView = WebDialog.this.crossImageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            WebDialog.this.isPageFinished = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap bitmap) {
            ProgressDialog progressDialog;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            Utility.logd(WebDialog.LOG_TAG, "Webview loading URL: " + url);
            super.onPageStarted(view, url, bitmap);
            if (WebDialog.this.isDetached || (progressDialog = WebDialog.this.spinner) == null) {
                return;
            }
            progressDialog.show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int i3, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
            super.onReceivedError(view, i3, description, failingUrl);
            WebDialog.this.sendErrorToListener(new FacebookDialogException(description, i3, failingUrl));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(error, "error");
            super.onReceivedSslError(view, handler, error);
            handler.cancel();
            WebDialog.this.sendErrorToListener(new FacebookDialogException(null, -11, null));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            int i3;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            Utility.logd(WebDialog.LOG_TAG, "Redirect URL: " + url);
            Uri uri = Uri.parse(url);
            boolean z2 = uri.getPath() != null && Pattern.matches(WebDialog.PLATFORM_DIALOG_PATH_REGEX, uri.getPath());
            if (!StringsKt.U(url, WebDialog.this.expectedRedirectUrl, false, 2, null)) {
                if (StringsKt.U(url, ServerProtocol.DIALOG_CANCEL_URI, false, 2, null)) {
                    WebDialog.this.cancel();
                    return true;
                }
                if (!z2 && !StringsKt.a0(url, "touch", false, 2, null)) {
                    try {
                        WebDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                        return true;
                    } catch (ActivityNotFoundException unused) {
                    }
                }
                return false;
            }
            Bundle responseUri = WebDialog.this.parseResponseUri(url);
            String string = responseUri.getString("error");
            if (string == null) {
                string = responseUri.getString("error_type");
            }
            String string2 = responseUri.getString(FacebookRequestError.ERROR_MSG_KEY);
            if (string2 == null) {
                string2 = responseUri.getString("error_message");
            }
            if (string2 == null) {
                string2 = responseUri.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
            }
            String string3 = responseUri.getString("error_code");
            if (string3 == null || Utility.isNullOrEmpty(string3)) {
                i3 = -1;
            } else {
                try {
                    i3 = Integer.parseInt(string3);
                } catch (NumberFormatException unused2) {
                    i3 = -1;
                }
            }
            if (Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i3 == -1) {
                WebDialog.this.sendSuccessToListener(responseUri);
            } else if ((string == null || !(Intrinsics.areEqual(string, "access_denied") || Intrinsics.areEqual(string, "OAuthAccessDeniedException"))) && i3 != WebDialog.API_EC_DIALOG_CANCEL) {
                WebDialog.this.sendErrorToListener(new FacebookServiceException(new FacebookRequestError(i3, string, string2), string2));
            } else {
                WebDialog.this.cancel();
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface InitCallback {
        void onInit(WebView webView);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnCompleteListener {
        void onComplete(Bundle bundle, FacebookException facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class UploadStagingResourcesTask extends AsyncTask<Void, Void, String[]> {
        private final String action;
        private Exception[] exceptions;
        private final Bundle parameters;
        final /* synthetic */ WebDialog this$0;

        public UploadStagingResourcesTask(WebDialog webDialog, String action, Bundle parameters) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.this$0 = webDialog;
            this.action = action;
            this.parameters = parameters;
            this.exceptions = new Exception[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void doInBackground$lambda$0(String[] results, int i3, UploadStagingResourcesTask this$0, CountDownLatch latch, GraphResponse response) {
            FacebookRequestError error;
            String str;
            Intrinsics.checkNotNullParameter(results, "$results");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(latch, "$latch");
            Intrinsics.checkNotNullParameter(response, "response");
            try {
                error = response.getError();
                str = "Error staging photo.";
            } catch (Exception e3) {
                this$0.exceptions[i3] = e3;
            }
            if (error != null) {
                String errorMessage = error.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                throw new FacebookGraphResponseException(response, str);
            }
            JSONObject jSONObject = response.getJSONObject();
            if (jSONObject == null) {
                throw new FacebookException("Error staging photo.");
            }
            String strOptString = jSONObject.optString(ShareConstants.MEDIA_URI);
            if (strOptString == null) {
                throw new FacebookException("Error staging photo.");
            }
            results[i3] = strOptString;
            latch.countDown();
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ String[] doInBackground(Void[] voidArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return doInBackground2(voidArr);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(String[] strArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                onPostExecute2(strArr);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected String[] doInBackground2(Void... p02) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(p02, "p0");
                String[] stringArray = this.parameters.getStringArray(ShareConstants.WEB_DIALOG_PARAM_MEDIA);
                if (stringArray == null) {
                    return null;
                }
                final String[] strArr = new String[stringArray.length];
                this.exceptions = new Exception[stringArray.length];
                final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
                try {
                    int length = stringArray.length;
                    for (final int i3 = 0; i3 < length; i3++) {
                        if (isCancelled()) {
                            Iterator it = concurrentLinkedQueue.iterator();
                            while (it.hasNext()) {
                                ((GraphRequestAsyncTask) it.next()).cancel(true);
                            }
                            return null;
                        }
                        Uri uri = Uri.parse(stringArray[i3]);
                        if (Utility.isWebUri(uri)) {
                            strArr[i3] = uri.toString();
                            countDownLatch.countDown();
                        } else {
                            GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.internal.v
                                @Override // com.facebook.GraphRequest.Callback
                                public final void onCompleted(GraphResponse graphResponse) {
                                    WebDialog.UploadStagingResourcesTask.doInBackground$lambda$0(strArr, i3, this, countDownLatch, graphResponse);
                                }
                            };
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            concurrentLinkedQueue.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(currentAccessToken, uri, callback).executeAsync());
                        }
                    }
                    countDownLatch.await();
                    return strArr;
                } catch (Exception unused) {
                    Iterator it2 = concurrentLinkedQueue.iterator();
                    while (it2.hasNext()) {
                        ((GraphRequestAsyncTask) it2.next()).cancel(true);
                    }
                    return null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(String[] strArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                ProgressDialog progressDialog = this.this$0.spinner;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                for (Exception exc : this.exceptions) {
                    if (exc != null) {
                        this.this$0.sendErrorToListener(exc);
                        return;
                    }
                }
                if (strArr == null) {
                    this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                    return;
                }
                List listAsList = ArraysKt.asList(strArr);
                if (listAsList.contains(null)) {
                    this.this$0.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                    return;
                }
                Utility.putJSONValueInBundle(this.parameters, ShareConstants.WEB_DIALOG_PARAM_MEDIA, new JSONArray((Collection) listAsList));
                this.this$0.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + this.action, this.parameters).toString();
                ImageView imageView = this.this$0.crossImageView;
                if (imageView == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                this.this$0.setUpWebView((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.values().length];
            try {
                iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ WebDialog(Context context, String str, Bundle bundle, int i3, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, bundle, i3, loginTargetApp, onCompleteListener);
    }

    private final void createCrossImage() {
        ImageView imageView = new ImageView(getContext());
        this.crossImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.internal.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebDialog.createCrossImage$lambda$5(this.f68176a, view);
            }
        });
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.com_facebook_close);
        ImageView imageView2 = this.crossImageView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
        ImageView imageView3 = this.crossImageView;
        if (imageView3 == null) {
            return;
        }
        imageView3.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCrossImage$lambda$5(WebDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancel();
    }

    private final int getScaledSize(int i3, float f3, int i4, int i5) {
        int i6 = (int) (i3 / f3);
        return (int) (((double) i3) * (i6 <= i4 ? 1.0d : i6 >= i5 ? 0.5d : ((((double) (i5 - i6)) / ((double) (i5 - i4))) * MIN_SCALE_FACTOR) + MIN_SCALE_FACTOR));
    }

    @JvmStatic
    public static final int getWebDialogTheme() {
        return Companion.getWebDialogTheme();
    }

    @JvmStatic
    protected static final void initDefaultTheme(Context context) {
        Companion.initDefaultTheme(context);
    }

    @JvmStatic
    public static final WebDialog newInstance(Context context, String str, Bundle bundle, int i3, OnCompleteListener onCompleteListener) {
        return Companion.newInstance(context, str, bundle, i3, onCompleteListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(WebDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancel();
    }

    @JvmStatic
    public static final void setInitCallback(InitCallback initCallback2) {
        Companion.setInitCallback(initCallback2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpWebView(int i3) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        WebView webView = new WebView(getContext()) { // from class: com.facebook.internal.WebDialog.setUpWebView.1
            @Override // android.webkit.WebView, android.view.View
            public void onWindowFocusChanged(boolean z2) {
                try {
                    super.onWindowFocusChanged(z2);
                } catch (NullPointerException unused) {
                }
            }
        };
        this.webView = webView;
        InitCallback initCallback2 = initCallback;
        if (initCallback2 != null) {
            initCallback2.onInit(webView);
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setVerticalScrollBarEnabled(false);
        }
        WebView webView3 = this.webView;
        if (webView3 != null) {
            webView3.setHorizontalScrollBarEnabled(false);
        }
        WebView webView4 = this.webView;
        if (webView4 != null) {
            webView4.setWebViewClient(new DialogWebViewClient());
        }
        WebView webView5 = this.webView;
        WebSettings settings = webView5 != null ? webView5.getSettings() : null;
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        WebView webView6 = this.webView;
        if (webView6 != null) {
            String str = this.url;
            if (str == null) {
                throw new IllegalStateException("Required value was null.");
            }
            webView6.loadUrl(str);
        }
        WebView webView7 = this.webView;
        if (webView7 != null) {
            webView7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        WebView webView8 = this.webView;
        if (webView8 != null) {
            webView8.setVisibility(4);
        }
        WebView webView9 = this.webView;
        WebSettings settings2 = webView9 != null ? webView9.getSettings() : null;
        if (settings2 != null) {
            settings2.setSavePassword(false);
        }
        WebView webView10 = this.webView;
        WebSettings settings3 = webView10 != null ? webView10.getSettings() : null;
        if (settings3 != null) {
            settings3.setSaveFormData(false);
        }
        WebView webView11 = this.webView;
        if (webView11 != null) {
            webView11.setFocusable(true);
        }
        WebView webView12 = this.webView;
        if (webView12 != null) {
            webView12.setFocusableInTouchMode(true);
        }
        WebView webView13 = this.webView;
        if (webView13 != null) {
            webView13.setOnTouchListener(new View.OnTouchListener() { // from class: com.facebook.internal.s
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return WebDialog.setUpWebView$lambda$7(view, motionEvent);
                }
            });
        }
        linearLayout.setPadding(i3, i3, i3, i3);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(BACKGROUND_GRAY);
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(linearLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setUpWebView$lambda$7(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    @JvmStatic
    public static final void setWebDialogTheme(int i3) {
        Companion.setWebDialogTheme(i3);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.onCompleteListener == null || this.isListenerCalled) {
            return;
        }
        sendErrorToListener(new FacebookOperationCanceledException());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView = this.webView;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.isDetached && (progressDialog = this.spinner) != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.dismiss();
    }

    public final OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    protected final WebView getWebView() {
        return this.webView;
    }

    protected final boolean isListenerCalled() {
        return this.isListenerCalled;
    }

    protected final boolean isPageFinished() {
        return this.isPageFinished;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        Window window;
        WindowManager.LayoutParams attributes;
        this.isDetached = false;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (Utility.mustFixWindowParamsForAutofill(context) && (layoutParams = this.windowParams) != null) {
            if ((layoutParams != null ? layoutParams.token : null) == null) {
                if (layoutParams != null) {
                    Activity ownerActivity = getOwnerActivity();
                    layoutParams.token = (ownerActivity == null || (window = ownerActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Set token on onAttachedToWindow(): ");
                WindowManager.LayoutParams layoutParams2 = this.windowParams;
                sb.append(layoutParams2 != null ? layoutParams2.token : null);
                Utility.logd(LOG_TAG, sb.toString());
            }
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.spinner = progressDialog;
        progressDialog.requestWindowFeature(1);
        ProgressDialog progressDialog2 = this.spinner;
        if (progressDialog2 != null) {
            progressDialog2.setMessage(getContext().getString(R.string.com_facebook_loading));
        }
        ProgressDialog progressDialog3 = this.spinner;
        if (progressDialog3 != null) {
            progressDialog3.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog4 = this.spinner;
        if (progressDialog4 != null) {
            progressDialog4.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.internal.u
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    WebDialog.onCreate$lambda$4(this.f68177a, dialogInterface);
                }
            });
        }
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        resize();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        createCrossImage();
        if (this.url != null) {
            ImageView imageView = this.crossImageView;
            if (imageView == null) {
                throw new IllegalStateException("Required value was null.");
            }
            setUpWebView((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        }
        FrameLayout frameLayout2 = this.contentFrameLayout;
        if (frameLayout2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        setContentView(frameLayout2);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (i3 == 4) {
            WebView webView = this.webView;
            if (webView != null && webView != null && webView.canGoBack()) {
                WebView webView2 = this.webView;
                if (webView2 != null) {
                    webView2.goBack();
                }
                return true;
            }
            cancel();
        }
        return super.onKeyDown(i3, event);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            if ((uploadStagingResourcesTask != null ? uploadStagingResourcesTask.getStatus() : null) == AsyncTask.Status.PENDING) {
                UploadStagingResourcesTask uploadStagingResourcesTask2 = this.uploadTask;
                if (uploadStagingResourcesTask2 != null) {
                    uploadStagingResourcesTask2.execute(new Void[0]);
                }
                ProgressDialog progressDialog = this.spinner;
                if (progressDialog != null) {
                    progressDialog.show();
                    return;
                }
                return;
            }
        }
        resize();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            uploadStagingResourcesTask.cancel(true);
            ProgressDialog progressDialog = this.spinner;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.token == null) {
            this.windowParams = params;
        }
        super.onWindowAttributesChanged(params);
    }

    public Bundle parseResponseUri(String str) {
        Uri uri = Uri.parse(str);
        Bundle urlQueryString = Utility.parseUrlQueryString(uri.getQuery());
        urlQueryString.putAll(Utility.parseUrlQueryString(uri.getFragment()));
        return urlQueryString;
    }

    public final void resize() {
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        int i5 = i3 < i4 ? i3 : i4;
        if (i3 < i4) {
            i3 = i4;
        }
        int iMin = Math.min(getScaledSize(i5, displayMetrics.density, NO_PADDING_SCREEN_WIDTH, 800), displayMetrics.widthPixels);
        int iMin2 = Math.min(getScaledSize(i3, displayMetrics.density, 800, MAX_PADDING_SCREEN_HEIGHT), displayMetrics.heightPixels);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(iMin, iMin2);
        }
    }

    protected final void sendErrorToListener(Throwable th) {
        if (this.onCompleteListener == null || this.isListenerCalled) {
            return;
        }
        this.isListenerCalled = true;
        FacebookException facebookException = th instanceof FacebookException ? (FacebookException) th : new FacebookException(th);
        OnCompleteListener onCompleteListener = this.onCompleteListener;
        if (onCompleteListener != null) {
            onCompleteListener.onComplete(null, facebookException);
        }
        dismiss();
    }

    protected final void sendSuccessToListener(Bundle bundle) {
        OnCompleteListener onCompleteListener = this.onCompleteListener;
        if (onCompleteListener == null || this.isListenerCalled) {
            return;
        }
        this.isListenerCalled = true;
        if (onCompleteListener != null) {
            onCompleteListener.onComplete(bundle, null);
        }
        dismiss();
    }

    protected final void setExpectedRedirectUrl(String expectedRedirectUrl) {
        Intrinsics.checkNotNullParameter(expectedRedirectUrl, "expectedRedirectUrl");
        this.expectedRedirectUrl = expectedRedirectUrl;
    }

    public final void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    protected WebDialog(Context context, String url) {
        this(context, url, Companion.getWebDialogTheme());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @JvmStatic
    public static final WebDialog newInstance(Context context, String str, Bundle bundle, int i3, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener) {
        return Companion.newInstance(context, str, bundle, i3, loginTargetApp, onCompleteListener);
    }

    private WebDialog(Context context, String str, int i3) {
        super(context, i3 == 0 ? Companion.getWebDialogTheme() : i3);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.url = str;
    }

    private WebDialog(Context context, String str, Bundle bundle, int i3, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener) {
        Uri uriBuildUri;
        super(context, i3 == 0 ? Companion.getWebDialogTheme() : i3);
        String str2 = ServerProtocol.DIALOG_REDIRECT_URI;
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        bundle = bundle == null ? new Bundle() : bundle;
        str2 = Utility.isChromeOS(context) ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : str2;
        this.expectedRedirectUrl = str2;
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str2);
        bundle.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, "touch");
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str3 = String.format(Locale.ROOT, "android-%s", Arrays.copyOf(new Object[]{FacebookSdk.getSdkVersion()}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
        bundle.putString("sdk", str3);
        this.onCompleteListener = onCompleteListener;
        if (Intrinsics.areEqual(str, "share") && bundle.containsKey(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
            this.uploadTask = new UploadStagingResourcesTask(this, str, bundle);
            return;
        }
        if (WhenMappings.$EnumSwitchMapping$0[loginTargetApp.ordinal()] == 1) {
            uriBuildUri = Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle);
        } else {
            uriBuildUri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle);
        }
        this.url = uriBuildUri.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Builder {
        private AccessToken accessToken;
        private String action;
        private String applicationId;
        private Context context;
        private OnCompleteListener listener;
        private Bundle parameters;
        private int theme;

        public Builder(Context context, String action, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(action, "action");
            AccessToken.Companion companion = AccessToken.Companion;
            this.accessToken = companion.getCurrentAccessToken();
            if (!companion.isCurrentAccessTokenActive()) {
                String metadataApplicationId = Utility.getMetadataApplicationId(context);
                if (metadataApplicationId == null) {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
                this.applicationId = metadataApplicationId;
            }
            finishInit(context, action, bundle);
        }

        private final void finishInit(Context context, String str, Bundle bundle) {
            this.context = context;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
            } else {
                this.parameters = new Bundle();
            }
        }

        public WebDialog build() {
            AccessToken accessToken = this.accessToken;
            if (accessToken != null) {
                Bundle bundle = this.parameters;
                if (bundle != null) {
                    bundle.putString("app_id", accessToken != null ? accessToken.getApplicationId() : null);
                }
                Bundle bundle2 = this.parameters;
                if (bundle2 != null) {
                    AccessToken accessToken2 = this.accessToken;
                    bundle2.putString("access_token", accessToken2 != null ? accessToken2.getToken() : null);
                }
            } else {
                Bundle bundle3 = this.parameters;
                if (bundle3 != null) {
                    bundle3.putString("app_id", this.applicationId);
                }
            }
            Companion companion = WebDialog.Companion;
            Context context = this.context;
            if (context != null) {
                return companion.newInstance(context, this.action, this.parameters, this.theme, this.listener);
            }
            throw new IllegalStateException("Required value was null.");
        }

        public final String getApplicationId() {
            return this.applicationId;
        }

        public final Context getContext() {
            return this.context;
        }

        public final OnCompleteListener getListener() {
            return this.listener;
        }

        public final Bundle getParameters() {
            return this.parameters;
        }

        public final int getTheme() {
            return this.theme;
        }

        public final Builder setOnCompleteListener(OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        public final Builder setTheme(int i3) {
            this.theme = i3;
            return this;
        }

        public Builder(Context context, String str, String action, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(action, "action");
            this.applicationId = Validate.notNullOrEmpty(str == null ? Utility.getMetadataApplicationId(context) : str, "applicationId");
            finishInit(context, action, bundle);
        }
    }
}
