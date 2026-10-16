package com.google.crypto.tink.internal;

import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SerializationRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f86278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f86279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f86280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f86281d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ParserIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f86286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bytes f86287b;

        public boolean equals(Object obj) {
            if (!(obj instanceof ParserIndex)) {
                return false;
            }
            ParserIndex parserIndex = (ParserIndex) obj;
            return parserIndex.f86286a.equals(this.f86286a) && parserIndex.f86287b.equals(this.f86287b);
        }

        public int hashCode() {
            return Objects.hash(this.f86286a, this.f86287b);
        }

        public String toString() {
            return this.f86286a.getSimpleName() + ", object identifier: " + this.f86287b;
        }

        private ParserIndex(Class cls, Bytes bytes) {
            this.f86286a = cls;
            this.f86287b = bytes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SerializerIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f86288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class f86289b;

        public boolean equals(Object obj) {
            if (!(obj instanceof SerializerIndex)) {
                return false;
            }
            SerializerIndex serializerIndex = (SerializerIndex) obj;
            return serializerIndex.f86288a.equals(this.f86288a) && serializerIndex.f86289b.equals(this.f86289b);
        }

        public int hashCode() {
            return Objects.hash(this.f86288a, this.f86289b);
        }

        public String toString() {
            return this.f86288a.getSimpleName() + " with serialization type: " + this.f86289b.getSimpleName();
        }

        private SerializerIndex(Class cls, Class cls2) {
            this.f86288a = cls;
            this.f86289b = cls2;
        }
    }

    private SerializationRegistry(Builder builder) {
        this.f86278a = new HashMap(builder.f86282a);
        this.f86279b = new HashMap(builder.f86283b);
        this.f86280c = new HashMap(builder.f86284c);
        this.f86281d = new HashMap(builder.f86285d);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f86282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f86283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f86284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map f86285d;

        public Builder() {
            this.f86282a = new HashMap();
            this.f86283b = new HashMap();
            this.f86284c = new HashMap();
            this.f86285d = new HashMap();
        }

        SerializationRegistry e() {
            return new SerializationRegistry(this);
        }

        public Builder f(KeyParser keyParser) throws GeneralSecurityException {
            ParserIndex parserIndex = new ParserIndex(keyParser.c(), keyParser.b());
            if (!this.f86283b.containsKey(parserIndex)) {
                this.f86283b.put(parserIndex, keyParser);
                return this;
            }
            KeyParser keyParser2 = (KeyParser) this.f86283b.get(parserIndex);
            if (keyParser2.equals(keyParser) && keyParser.equals(keyParser2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + parserIndex);
        }

        public Builder g(KeySerializer keySerializer) throws GeneralSecurityException {
            SerializerIndex serializerIndex = new SerializerIndex(keySerializer.b(), keySerializer.c());
            if (!this.f86282a.containsKey(serializerIndex)) {
                this.f86282a.put(serializerIndex, keySerializer);
                return this;
            }
            KeySerializer keySerializer2 = (KeySerializer) this.f86282a.get(serializerIndex);
            if (keySerializer2.equals(keySerializer) && keySerializer.equals(keySerializer2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + serializerIndex);
        }

        public Builder h(ParametersParser parametersParser) throws GeneralSecurityException {
            ParserIndex parserIndex = new ParserIndex(parametersParser.c(), parametersParser.b());
            if (!this.f86285d.containsKey(parserIndex)) {
                this.f86285d.put(parserIndex, parametersParser);
                return this;
            }
            ParametersParser parametersParser2 = (ParametersParser) this.f86285d.get(parserIndex);
            if (parametersParser2.equals(parametersParser) && parametersParser.equals(parametersParser2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + parserIndex);
        }

        public Builder i(ParametersSerializer parametersSerializer) throws GeneralSecurityException {
            SerializerIndex serializerIndex = new SerializerIndex(parametersSerializer.b(), parametersSerializer.c());
            if (!this.f86284c.containsKey(serializerIndex)) {
                this.f86284c.put(serializerIndex, parametersSerializer);
                return this;
            }
            ParametersSerializer parametersSerializer2 = (ParametersSerializer) this.f86284c.get(serializerIndex);
            if (parametersSerializer2.equals(parametersSerializer) && parametersSerializer.equals(parametersSerializer2)) {
                return this;
            }
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + serializerIndex);
        }

        public Builder(SerializationRegistry serializationRegistry) {
            this.f86282a = new HashMap(serializationRegistry.f86278a);
            this.f86283b = new HashMap(serializationRegistry.f86279b);
            this.f86284c = new HashMap(serializationRegistry.f86280c);
            this.f86285d = new HashMap(serializationRegistry.f86281d);
        }
    }
}
