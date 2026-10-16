package com.google.crypto.tink.internal;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class KeyTypeManager<KeyProtoT extends MessageLite> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f86238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f86239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class f86240c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class KeyFactory<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f86241a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class KeyFormat<KeyFormatProtoT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f86242a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public KeyTemplate.OutputPrefixType f86243b;

            public KeyFormat(Object obj, KeyTemplate.OutputPrefixType outputPrefixType) {
                this.f86242a = obj;
                this.f86243b = outputPrefixType;
            }
        }

        public KeyFactory(Class cls) {
            this.f86241a = cls;
        }

        public Map a() {
            return Collections.EMPTY_MAP;
        }
    }

    protected KeyTypeManager(Class cls, PrimitiveFactory... primitiveFactoryArr) {
        this.f86238a = cls;
        HashMap map = new HashMap();
        for (PrimitiveFactory primitiveFactory : primitiveFactoryArr) {
            if (map.containsKey(primitiveFactory.a())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + primitiveFactory.a().getCanonicalName());
            }
            map.put(primitiveFactory.a(), primitiveFactory);
        }
        if (primitiveFactoryArr.length > 0) {
            this.f86240c = primitiveFactoryArr[0].a();
        } else {
            this.f86240c = Void.class;
        }
        this.f86239b = Collections.unmodifiableMap(map);
    }

    public TinkFipsUtil.AlgorithmFipsCompatibility a() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    public final Class b() {
        return this.f86240c;
    }

    public abstract String c();

    public KeyFactory d() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public final Set e() {
        return this.f86239b.keySet();
    }
}
