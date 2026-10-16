package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesGcmParameters extends AeadParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f86095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f86096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Variant f86097d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class Variant {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Variant f86098b = new Variant("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Variant f86099c = new Variant("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Variant f86100d = new Variant("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86101a;

        private Variant(String str) {
            this.f86101a = str;
        }

        public String toString() {
            return this.f86101a;
        }
    }

    public int a() {
        return this.f86095b;
    }

    public int b() {
        return this.f86094a;
    }

    public int c() {
        return this.f86096c;
    }

    public Variant d() {
        return this.f86097d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesGcmParameters)) {
            return false;
        }
        AesGcmParameters aesGcmParameters = (AesGcmParameters) obj;
        return aesGcmParameters.b() == b() && aesGcmParameters.a() == a() && aesGcmParameters.c() == c() && aesGcmParameters.d() == d();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f86094a), Integer.valueOf(this.f86095b), Integer.valueOf(this.f86096c), this.f86097d);
    }

    public String toString() {
        return "AesGcm Parameters (variant: " + this.f86097d + ", " + this.f86095b + "-byte IV, " + this.f86096c + "-byte tag, and " + this.f86094a + "-byte key)";
    }
}
