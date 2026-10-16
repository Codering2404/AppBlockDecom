package com.google.crypto.tink.internal;

import com.google.crypto.tink.PrimitiveWrapper;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class PrimitiveRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f86269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f86270b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PrimitiveConstructorIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f86273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class f86274b;

        public boolean equals(Object obj) {
            if (!(obj instanceof PrimitiveConstructorIndex)) {
                return false;
            }
            PrimitiveConstructorIndex primitiveConstructorIndex = (PrimitiveConstructorIndex) obj;
            return primitiveConstructorIndex.f86273a.equals(this.f86273a) && primitiveConstructorIndex.f86274b.equals(this.f86274b);
        }

        public int hashCode() {
            return Objects.hash(this.f86273a, this.f86274b);
        }

        public String toString() {
            return this.f86273a.getSimpleName() + " with primitive type: " + this.f86274b.getSimpleName();
        }

        private PrimitiveConstructorIndex(Class cls, Class cls2) {
            this.f86273a = cls;
            this.f86274b = cls2;
        }
    }

    private PrimitiveRegistry(Builder builder) {
        this.f86269a = new HashMap(builder.f86271a);
        this.f86270b = new HashMap(builder.f86272b);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f86271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f86272b;

        public Builder() {
            this.f86271a = new HashMap();
            this.f86272b = new HashMap();
        }

        PrimitiveRegistry c() {
            return new PrimitiveRegistry(this);
        }

        public Builder d(PrimitiveConstructor primitiveConstructor) throws GeneralSecurityException {
            if (primitiveConstructor == null) {
                throw new NullPointerException("primitive constructor must be non-null");
            }
            PrimitiveConstructorIndex primitiveConstructorIndex = new PrimitiveConstructorIndex(primitiveConstructor.b(), primitiveConstructor.c());
            if (!this.f86271a.containsKey(primitiveConstructorIndex)) {
                this.f86271a.put(primitiveConstructorIndex, primitiveConstructor);
                return this;
            }
            PrimitiveConstructor primitiveConstructor2 = (PrimitiveConstructor) this.f86271a.get(primitiveConstructorIndex);
            if (primitiveConstructor2.equals(primitiveConstructor) && primitiveConstructor.equals(primitiveConstructor2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + primitiveConstructorIndex);
        }

        public Builder e(PrimitiveWrapper primitiveWrapper) throws GeneralSecurityException {
            if (primitiveWrapper == null) {
                throw new NullPointerException("wrapper must be non-null");
            }
            Class clsA = primitiveWrapper.a();
            if (!this.f86272b.containsKey(clsA)) {
                this.f86272b.put(clsA, primitiveWrapper);
                return this;
            }
            PrimitiveWrapper primitiveWrapper2 = (PrimitiveWrapper) this.f86272b.get(clsA);
            if (primitiveWrapper2.equals(primitiveWrapper) && primitiveWrapper.equals(primitiveWrapper2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + clsA);
        }

        public Builder(PrimitiveRegistry primitiveRegistry) {
            this.f86271a = new HashMap(primitiveRegistry.f86269a);
            this.f86272b = new HashMap(primitiveRegistry.f86270b);
        }
    }
}
