package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesGcmSivParameters extends AeadParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Variant f86110b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class Variant {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Variant f86111b = new Variant("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Variant f86112c = new Variant("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Variant f86113d = new Variant("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86114a;

        private Variant(String str) {
            this.f86114a = str;
        }

        public String toString() {
            return this.f86114a;
        }
    }

    public int a() {
        return this.f86109a;
    }

    public Variant b() {
        return this.f86110b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesGcmSivParameters)) {
            return false;
        }
        AesGcmSivParameters aesGcmSivParameters = (AesGcmSivParameters) obj;
        return aesGcmSivParameters.a() == a() && aesGcmSivParameters.b() == b();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f86109a), this.f86110b);
    }

    public String toString() {
        return "AesGcmSiv Parameters (variant: " + this.f86110b + ", " + this.f86109a + "-byte key)";
    }
}
