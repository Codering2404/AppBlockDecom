package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SignInHubActivity extends FragmentActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f71236g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f71237a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SignInConfiguration f71238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f71239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f71240d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Intent f71241f;

    private final void S() {
        getSupportLoaderManager().c(0, null, new zbw(this, null));
        f71236g = false;
    }

    private final void T(int i3) {
        Status status = new Status(i3);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f71236g = false;
    }

    private final void U(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.f71238b);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f71237a = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            T(17);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected final void onActivityResult(int i3, int i4, Intent intent) {
        if (this.f71237a) {
            return;
        }
        setResult(0);
        if (i3 != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.M() != null) {
                GoogleSignInAccount googleSignInAccountM = signInAccount.M();
                if (googleSignInAccountM == null) {
                    Log.e("AuthSignInClient", "Google account is null");
                    T(12500);
                    return;
                }
                zbn.a(this).c(this.f71238b.M(), googleSignInAccountM);
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccountM);
                this.f71239c = true;
                this.f71240d = i4;
                this.f71241f = intent;
                S();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                T(intExtra);
                return;
            }
        }
        T(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null) {
            Log.e("AuthSignInClient", "Null action");
            T(12500);
            return;
        }
        if (action.equals("com.google.android.gms.auth.NO_IMPL")) {
            Log.e("AuthSignInClient", "Action not implemented");
            T(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        if (bundleExtra == null) {
            Log.e("AuthSignInClient", "Activity started with no configuration.");
            setResult(0);
            finish();
            return;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.f71238b = signInConfiguration;
        if (bundle == null) {
            if (f71236g) {
                setResult(0);
                T(12502);
                return;
            } else {
                f71236g = true;
                U(action);
                return;
            }
        }
        boolean z2 = bundle.getBoolean("signingInGoogleApiClients");
        this.f71239c = z2;
        if (z2) {
            this.f71240d = bundle.getInt("signInResultCode");
            Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
            if (intent2 != null) {
                this.f71241f = intent2;
                S();
            } else {
                Log.e("AuthSignInClient", "Sign in result data cannot be null");
                setResult(0);
                finish();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        f71236g = false;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f71239c);
        if (this.f71239c) {
            bundle.putInt("signInResultCode", this.f71240d);
            bundle.putParcelable("signInResultData", this.f71241f);
        }
    }
}
