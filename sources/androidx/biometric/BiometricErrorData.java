package androidx.biometric;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class BiometricErrorData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f2412b;

    BiometricErrorData(int i3, CharSequence charSequence) {
        this.f2411a = i3;
        this.f2412b = charSequence;
    }

    private static String a(CharSequence charSequence) {
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    private boolean d(CharSequence charSequence) {
        String strA = a(this.f2412b);
        String strA2 = a(charSequence);
        if (strA == null && strA2 == null) {
            return true;
        }
        return strA != null && strA.equals(strA2);
    }

    int b() {
        return this.f2411a;
    }

    CharSequence c() {
        return this.f2412b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BiometricErrorData) {
            BiometricErrorData biometricErrorData = (BiometricErrorData) obj;
            if (this.f2411a == biometricErrorData.f2411a && d(biometricErrorData.f2412b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2411a), a(this.f2412b)});
    }
}
