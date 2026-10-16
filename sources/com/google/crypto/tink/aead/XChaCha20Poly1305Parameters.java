package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class XChaCha20Poly1305Parameters extends AeadParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Variant f86137a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    public static final class Variant {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Variant f86138b = new Variant("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Variant f86139c = new Variant("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Variant f86140d = new Variant("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f86141a;

        private Variant(String str) {
            this.f86141a = str;
        }

        public String toString() {
            return this.f86141a;
        }
    }

    public Variant a() {
        return this.f86137a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof XChaCha20Poly1305Parameters) && ((XChaCha20Poly1305Parameters) obj).a() == a();
    }

    public int hashCode() {
        return Objects.hashCode(this.f86137a);
    }

    public String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + this.f86137a + ")";
    }
}
