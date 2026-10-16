package androidx.biometric;

import android.security.identity.IdentityCredential;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class BiometricPrompt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class AuthenticationResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CryptoObject f2435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2436b;

        AuthenticationResult(CryptoObject cryptoObject, int i3) {
            this.f2435a = cryptoObject;
            this.f2436b = i3;
        }

        public int a() {
            return this.f2436b;
        }

        public CryptoObject b() {
            return this.f2435a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PromptInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f2441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f2442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CharSequence f2443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CharSequence f2444d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f2445e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f2446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f2447g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Builder {
        }

        public int a() {
            return this.f2447g;
        }

        public CharSequence b() {
            return this.f2443c;
        }

        public CharSequence c() {
            CharSequence charSequence = this.f2444d;
            return charSequence != null ? charSequence : "";
        }

        public CharSequence d() {
            return this.f2442b;
        }

        public CharSequence e() {
            return this.f2441a;
        }

        public boolean f() {
            return this.f2445e;
        }

        public boolean g() {
            return this.f2446f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ResetCallbackObserver implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f2448a;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void resetCallback() {
            if (this.f2448a.get() != null) {
                ((BiometricViewModel) this.f2448a.get()).a1();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CryptoObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Signature f2437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Cipher f2438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Mac f2439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final IdentityCredential f2440d;

        public CryptoObject(Signature signature) {
            this.f2437a = signature;
            this.f2438b = null;
            this.f2439c = null;
            this.f2440d = null;
        }

        public Cipher a() {
            return this.f2438b;
        }

        public IdentityCredential b() {
            return this.f2440d;
        }

        public Mac c() {
            return this.f2439c;
        }

        public Signature d() {
            return this.f2437a;
        }

        public CryptoObject(Cipher cipher) {
            this.f2437a = null;
            this.f2438b = cipher;
            this.f2439c = null;
            this.f2440d = null;
        }

        public CryptoObject(Mac mac) {
            this.f2437a = null;
            this.f2438b = null;
            this.f2439c = mac;
            this.f2440d = null;
        }

        public CryptoObject(IdentityCredential identityCredential) {
            this.f2437a = null;
            this.f2438b = null;
            this.f2439c = null;
            this.f2440d = identityCredential;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class AuthenticationCallback {
        public void b() {
        }

        public void c(AuthenticationResult authenticationResult) {
        }

        public void a(int i3, CharSequence charSequence) {
        }
    }
}
