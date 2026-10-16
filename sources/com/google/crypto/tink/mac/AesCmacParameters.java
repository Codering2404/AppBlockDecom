package com.google.crypto.tink.mac;

import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesCmacParameters extends MacParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f86328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f86329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Variant f86330c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class Variant {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Variant f86331b = new Variant("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Variant f86332c = new Variant("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Variant f86333d = new Variant("LEGACY");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Variant f86334e = new Variant("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86335a;

        private Variant(String str) {
            this.f86335a = str;
        }

        public String toString() {
            return this.f86335a;
        }
    }

    public int a() {
        return this.f86329b;
    }

    public int b() {
        return this.f86328a;
    }

    public int c() {
        Variant variant = this.f86330c;
        if (variant == Variant.f86334e) {
            return a();
        }
        if (variant != Variant.f86331b && variant != Variant.f86332c && variant != Variant.f86333d) {
            throw new IllegalStateException("Unknown variant");
        }
        int iA = a();
        return iA + 5;
    }

    public Variant d() {
        return this.f86330c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesCmacParameters)) {
            return false;
        }
        AesCmacParameters aesCmacParameters = (AesCmacParameters) obj;
        return aesCmacParameters.b() == b() && aesCmacParameters.c() == c() && aesCmacParameters.d() == d();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f86328a), Integer.valueOf(this.f86329b), this.f86330c);
    }

    public String toString() {
        return "AES-CMAC Parameters (variant: " + this.f86330c + ", " + this.f86329b + "-byte tags, and " + this.f86328a + "-byte key)";
    }
}
