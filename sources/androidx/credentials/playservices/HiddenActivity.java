package androidx.credentials.playservices;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.fido.Fido;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public class HiddenActivity extends Activity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f34942c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResultReceiver f34943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f34944b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void l() {
        Task taskAddOnFailureListener;
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) getIntent().getParcelableExtra("REQUEST_TYPE");
        final int intExtra = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
        if (beginSignInRequest != null) {
            Task taskBeginSignIn = Identity.b(this).beginSignIn(beginSignInRequest);
            final Function1<BeginSignInResult, Unit> function1 = new Function1<BeginSignInResult, Unit>() { // from class: androidx.credentials.playservices.HiddenActivity$handleBeginSignIn$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(BeginSignInResult beginSignInResult) {
                    try {
                        this.f34945a.f34944b = true;
                        this.f34945a.startIntentSenderForResult(beginSignInResult.M().getIntentSender(), intExtra, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e3) {
                        HiddenActivity hiddenActivity = this.f34945a;
                        ResultReceiver resultReceiver = hiddenActivity.f34943a;
                        Intrinsics.checkNotNull(resultReceiver);
                        hiddenActivity.y(resultReceiver, "GET_UNKNOWN", "During begin sign in, one tap ui intent sender failure: " + e3.getMessage());
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((BeginSignInResult) obj);
                    return Unit.f139807a;
                }
            };
            taskAddOnFailureListener = taskBeginSignIn.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.t
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.m(function1, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.u
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.n(this.f35224a, exc);
                }
            });
        } else {
            taskAddOnFailureListener = null;
        }
        if (taskAddOnFailureListener == null) {
            Log.i("HiddenActivity", "During begin sign in, params is null, nothing to launch for begin sign in");
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(HiddenActivity hiddenActivity, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        String str = ((e3 instanceof ApiException) && CredentialProviderBaseController.f35097b.d().contains(Integer.valueOf(((ApiException) e3).getStatusCode()))) ? "GET_INTERRUPTED" : "GET_NO_CREDENTIALS";
        ResultReceiver resultReceiver = hiddenActivity.f34943a;
        Intrinsics.checkNotNull(resultReceiver);
        hiddenActivity.y(resultReceiver, str, "During begin sign in, failure response from one tap: " + e3.getMessage());
    }

    private final void o() {
        Task taskAddOnFailureListener;
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) getIntent().getParcelableExtra("REQUEST_TYPE");
        final int intExtra = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
        if (savePasswordRequest != null) {
            Task taskSavePassword = Identity.a(this).savePassword(savePasswordRequest);
            final Function1<SavePasswordResult, Unit> function1 = new Function1<SavePasswordResult, Unit>() { // from class: androidx.credentials.playservices.HiddenActivity$handleCreatePassword$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(SavePasswordResult savePasswordResult) {
                    try {
                        this.f34947a.f34944b = true;
                        this.f34947a.startIntentSenderForResult(savePasswordResult.M().getIntentSender(), intExtra, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e3) {
                        HiddenActivity hiddenActivity = this.f34947a;
                        ResultReceiver resultReceiver = hiddenActivity.f34943a;
                        Intrinsics.checkNotNull(resultReceiver);
                        hiddenActivity.y(resultReceiver, "CREATE_UNKNOWN", "During save password, found UI intent sender failure: " + e3.getMessage());
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((SavePasswordResult) obj);
                    return Unit.f139807a;
                }
            };
            taskAddOnFailureListener = taskSavePassword.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.p
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.p(function1, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.q
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.q(this.f35220a, exc);
                }
            });
        } else {
            taskAddOnFailureListener = null;
        }
        if (taskAddOnFailureListener == null) {
            Log.i("HiddenActivity", "During save password, params is null, nothing to launch for create password");
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(HiddenActivity hiddenActivity, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        String str = ((e3 instanceof ApiException) && CredentialProviderBaseController.f35097b.d().contains(Integer.valueOf(((ApiException) e3).getStatusCode()))) ? "CREATE_INTERRUPTED" : "CREATE_UNKNOWN";
        ResultReceiver resultReceiver = hiddenActivity.f34943a;
        Intrinsics.checkNotNull(resultReceiver);
        hiddenActivity.y(resultReceiver, str, "During save password, found password failure response from one tap " + e3.getMessage());
    }

    private final void r() {
        Task taskAddOnFailureListener;
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) getIntent().getParcelableExtra("REQUEST_TYPE");
        final int intExtra = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
        if (publicKeyCredentialCreationOptions != null) {
            Task taskH = Fido.a(this).h(publicKeyCredentialCreationOptions);
            final Function1<PendingIntent, Unit> function1 = new Function1<PendingIntent, Unit>() { // from class: androidx.credentials.playservices.HiddenActivity$handleCreatePublicKeyCredential$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(PendingIntent result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    try {
                        this.f34949a.f34944b = true;
                        this.f34949a.startIntentSenderForResult(result.getIntentSender(), intExtra, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e3) {
                        HiddenActivity hiddenActivity = this.f34949a;
                        ResultReceiver resultReceiver = hiddenActivity.f34943a;
                        Intrinsics.checkNotNull(resultReceiver);
                        hiddenActivity.y(resultReceiver, "CREATE_UNKNOWN", "During public key credential, found IntentSender failure on public key creation: " + e3.getMessage());
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((PendingIntent) obj);
                    return Unit.f139807a;
                }
            };
            taskAddOnFailureListener = taskH.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.n
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.s(function1, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.o
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.t(this.f35218a, exc);
                }
            });
        } else {
            taskAddOnFailureListener = null;
        }
        if (taskAddOnFailureListener == null) {
            Log.w("HiddenActivity", "During create public key credential, request is null, so nothing to launch for public key credentials");
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(HiddenActivity hiddenActivity, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        String str = ((e3 instanceof ApiException) && CredentialProviderBaseController.f35097b.d().contains(Integer.valueOf(((ApiException) e3).getStatusCode()))) ? "CREATE_INTERRUPTED" : "CREATE_UNKNOWN";
        ResultReceiver resultReceiver = hiddenActivity.f34943a;
        Intrinsics.checkNotNull(resultReceiver);
        hiddenActivity.y(resultReceiver, str, "During create public key credential, fido registration failure: " + e3.getMessage());
    }

    private final void u() {
        Task taskAddOnFailureListener;
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) getIntent().getParcelableExtra("REQUEST_TYPE");
        final int intExtra = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
        if (getSignInIntentRequest != null) {
            Task signInIntent = Identity.b(this).getSignInIntent(getSignInIntentRequest);
            final Function1<PendingIntent, Unit> function1 = new Function1<PendingIntent, Unit>() { // from class: androidx.credentials.playservices.HiddenActivity$handleGetSignInIntent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(PendingIntent pendingIntent) {
                    try {
                        this.f34951a.f34944b = true;
                        this.f34951a.startIntentSenderForResult(pendingIntent.getIntentSender(), intExtra, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e3) {
                        HiddenActivity hiddenActivity = this.f34951a;
                        ResultReceiver resultReceiver = hiddenActivity.f34943a;
                        Intrinsics.checkNotNull(resultReceiver);
                        hiddenActivity.y(resultReceiver, "GET_UNKNOWN", "During get sign-in intent, one tap ui intent sender failure: " + e3.getMessage());
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((PendingIntent) obj);
                    return Unit.f139807a;
                }
            };
            taskAddOnFailureListener = signInIntent.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.r
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HiddenActivity.v(function1, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.s
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiddenActivity.w(this.f35222a, exc);
                }
            });
        } else {
            taskAddOnFailureListener = null;
        }
        if (taskAddOnFailureListener == null) {
            Log.i("HiddenActivity", "During get sign-in intent, params is null, nothing to launch for get sign-in intent");
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(HiddenActivity hiddenActivity, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        String str = ((e3 instanceof ApiException) && CredentialProviderBaseController.f35097b.d().contains(Integer.valueOf(((ApiException) e3).getStatusCode()))) ? "GET_INTERRUPTED" : "GET_NO_CREDENTIALS";
        ResultReceiver resultReceiver = hiddenActivity.f34943a;
        Intrinsics.checkNotNull(resultReceiver);
        hiddenActivity.y(resultReceiver, str, "During get sign-in intent, failure response from one tap: " + e3.getMessage());
    }

    private final void x(Bundle bundle) {
        if (bundle != null) {
            this.f34944b = bundle.getBoolean("androidx.credentials.playservices.AWAITING_RESULT", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(ResultReceiver resultReceiver, String str, String str2) {
        CredentialProviderBaseController.f35097b.e(resultReceiver, str, str2);
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        ResultReceiver resultReceiver = this.f34943a;
        if (resultReceiver != null) {
            CredentialProviderBaseController.f35097b.f(resultReceiver, i3, i4, intent);
        }
        this.f34944b = false;
        finish();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        String stringExtra = getIntent().getStringExtra("TYPE");
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("RESULT_RECEIVER");
        this.f34943a = resultReceiver;
        if (resultReceiver == null) {
            finish();
        }
        x(bundle);
        if (this.f34944b) {
            return;
        }
        if (stringExtra != null) {
            switch (stringExtra.hashCode()) {
                case -441061071:
                    if (stringExtra.equals("BEGIN_SIGN_IN")) {
                        l();
                        return;
                    }
                    break;
                case 15545322:
                    if (stringExtra.equals("CREATE_PUBLIC_KEY_CREDENTIAL")) {
                        r();
                        return;
                    }
                    break;
                case 1246634622:
                    if (stringExtra.equals("CREATE_PASSWORD")) {
                        o();
                        return;
                    }
                    break;
                case 1980564212:
                    if (stringExtra.equals("SIGN_IN_INTENT")) {
                        u();
                        return;
                    }
                    break;
            }
        }
        Log.w("HiddenActivity", "Activity handed an unsupported type");
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean("androidx.credentials.playservices.AWAITING_RESULT", this.f34944b);
        super.onSaveInstanceState(outState);
    }
}
