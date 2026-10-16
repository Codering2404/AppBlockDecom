package androidx.biometric;

import androidx.biometric.BiometricPrompt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AuthenticatorUtils {
    static int a(BiometricPrompt.PromptInfo promptInfo, BiometricPrompt.CryptoObject cryptoObject) {
        if (promptInfo.a() != 0) {
            return promptInfo.a();
        }
        int i3 = cryptoObject != null ? 15 : 255;
        return promptInfo.g() ? 32768 | i3 : i3;
    }

    static boolean b(int i3) {
        return (i3 & 32768) != 0;
    }

    static boolean c(int i3) {
        return (i3 & 32767) != 0;
    }
}
