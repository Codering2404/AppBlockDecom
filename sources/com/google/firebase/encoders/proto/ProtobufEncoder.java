package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ProtobufEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f89170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f89171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ObjectEncoder f89172c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder implements EncoderConfig<Builder> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ObjectEncoder f89173d = new ObjectEncoder() { // from class: com.google.firebase.encoders.proto.b
            @Override // com.google.firebase.encoders.ObjectEncoder
            public final void a(Object obj, Object obj2) {
                ProtobufEncoder.Builder.b(obj, (ObjectEncoderContext) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f89174a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f89175b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ObjectEncoder f89176c = f89173d;

        public static /* synthetic */ void b(Object obj, ObjectEncoderContext objectEncoderContext) {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public ProtobufEncoder c() {
            return new ProtobufEncoder(new HashMap(this.f89174a), new HashMap(this.f89175b), this.f89176c);
        }

        public Builder d(Configurator configurator) {
            configurator.a(this);
            return this;
        }

        @Override // com.google.firebase.encoders.config.EncoderConfig
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Builder a(Class cls, ObjectEncoder objectEncoder) {
            this.f89174a.put(cls, objectEncoder);
            this.f89175b.remove(cls);
            return this;
        }
    }

    ProtobufEncoder(Map map, Map map2, ObjectEncoder objectEncoder) {
        this.f89170a = map;
        this.f89171b = map2;
        this.f89172c = objectEncoder;
    }

    public static Builder a() {
        return new Builder();
    }

    public void b(Object obj, OutputStream outputStream) {
        new ProtobufDataEncoderContext(outputStream, this.f89170a, this.f89171b, this.f89172c).t(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
