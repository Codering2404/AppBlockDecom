package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesEaxParameters extends AeadParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f86080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f86081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Variant f86082d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class Variant {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Variant f86083b = new Variant("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Variant f86084c = new Variant("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Variant f86085d = new Variant("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86086a;

        private Variant(String str) {
            this.f86086a = str;
        }

        public String toString() {
            return this.f86086a;
        }
    }

    public int a() {
        return this.f86080b;
    }

    public int b() {
        return this.f86079a;
    }

    public int c() {
        return this.f86081c;
    }

    public Variant d() {
        return this.f86082d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesEaxParameters)) {
            return false;
        }
        AesEaxParameters aesEaxParameters = (AesEaxParameters) obj;
        return aesEaxParameters.b() == b() && aesEaxParameters.a() == a() && aesEaxParameters.c() == c() && aesEaxParameters.d() == d();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f86079a), Integer.valueOf(this.f86080b), Integer.valueOf(this.f86081c), this.f86082d);
    }

    public String toString() {
        return "AesEax Parameters (variant: " + this.f86082d + ", " + this.f86080b + "-byte IV, " + this.f86081c + "-byte tag, and " + this.f86079a + "-byte key)";
    }
}
