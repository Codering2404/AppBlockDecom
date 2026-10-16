package com.google.firebase.encoders.proto;

import com.facebook.stetho.common.Utf8Charset;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.Protobuf;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ProtobufDataEncoderContext implements ObjectEncoderContext {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Charset f89160f = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final FieldDescriptor f89161g = FieldDescriptor.a("key").b(AtProtobuf.b().c(1).a()).a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final FieldDescriptor f89162h = FieldDescriptor.a("value").b(AtProtobuf.b().c(2).a()).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ObjectEncoder f89163i = new ObjectEncoder() { // from class: com.google.firebase.encoders.proto.a
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ProtobufDataEncoderContext.a((Map.Entry) obj, (ObjectEncoderContext) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OutputStream f89164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f89165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f89166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ObjectEncoder f89167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ProtobufValueEncoderContext f89168e = new ProtobufValueEncoderContext(this);

    /* JADX INFO: renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f89169a;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            f89169a = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f89169a[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f89169a[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    ProtobufDataEncoderContext(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.f89164a = outputStream;
        this.f89165b = map;
        this.f89166c = map2;
        this.f89167d = objectEncoder;
    }

    public static /* synthetic */ void a(Map.Entry entry, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.f(f89161g, entry.getKey());
        objectEncoderContext.f(f89162h, entry.getValue());
    }

    private static ByteBuffer p(int i3) {
        return ByteBuffer.allocate(i3).order(ByteOrder.LITTLE_ENDIAN);
    }

    private long q(ObjectEncoder objectEncoder, Object obj) throws IOException {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            OutputStream outputStream = this.f89164a;
            this.f89164a = lengthCountingOutputStream;
            try {
                objectEncoder.a(obj, this);
                this.f89164a = outputStream;
                long jA = lengthCountingOutputStream.a();
                lengthCountingOutputStream.close();
                return jA;
            } catch (Throwable th) {
                this.f89164a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private ProtobufDataEncoderContext r(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z2) throws IOException {
        long jQ = q(objectEncoder, obj);
        if (z2 && jQ == 0) {
            return this;
        }
        w((v(fieldDescriptor) << 3) | 2);
        x(jQ);
        objectEncoder.a(obj, this);
        return this;
    }

    private ProtobufDataEncoderContext s(ValueEncoder valueEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z2) {
        this.f89168e.c(fieldDescriptor, z2);
        valueEncoder.a(obj, this.f89168e);
        return this;
    }

    private static Protobuf u(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int v(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private void w(int i3) throws IOException {
        while ((i3 & (-128)) != 0) {
            this.f89164a.write((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            i3 >>>= 7;
        }
        this.f89164a.write(i3 & 127);
    }

    private void x(long j3) throws IOException {
        while (((-128) & j3) != 0) {
            this.f89164a.write((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            j3 >>>= 7;
        }
        this.f89164a.write(((int) j3) & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext e(FieldDescriptor fieldDescriptor, double d3) {
        return g(fieldDescriptor, d3, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext f(FieldDescriptor fieldDescriptor, Object obj) {
        return i(fieldDescriptor, obj, true);
    }

    ObjectEncoderContext g(FieldDescriptor fieldDescriptor, double d3, boolean z2) throws IOException {
        if (z2 && d3 == 0.0d) {
            return this;
        }
        w((v(fieldDescriptor) << 3) | 1);
        this.f89164a.write(p(8).putDouble(d3).array());
        return this;
    }

    ObjectEncoderContext h(FieldDescriptor fieldDescriptor, float f3, boolean z2) throws IOException {
        if (z2 && f3 == 0.0f) {
            return this;
        }
        w((v(fieldDescriptor) << 3) | 5);
        this.f89164a.write(p(4).putFloat(f3).array());
        return this;
    }

    ObjectEncoderContext i(FieldDescriptor fieldDescriptor, Object obj, boolean z2) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z2 || charSequence.length() != 0) {
                    w((v(fieldDescriptor) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f89160f);
                    w(bytes.length);
                    this.f89164a.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    i(fieldDescriptor, it.next(), false);
                }
            } else if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    r(f89163i, fieldDescriptor, (Map.Entry) it2.next(), false);
                }
            } else {
                if (obj instanceof Double) {
                    return g(fieldDescriptor, ((Double) obj).doubleValue(), z2);
                }
                if (obj instanceof Float) {
                    return h(fieldDescriptor, ((Float) obj).floatValue(), z2);
                }
                if (obj instanceof Number) {
                    return m(fieldDescriptor, ((Number) obj).longValue(), z2);
                }
                if (obj instanceof Boolean) {
                    return o(fieldDescriptor, ((Boolean) obj).booleanValue(), z2);
                }
                if (!(obj instanceof byte[])) {
                    ObjectEncoder objectEncoder = (ObjectEncoder) this.f89165b.get(obj.getClass());
                    if (objectEncoder != null) {
                        return r(objectEncoder, fieldDescriptor, obj, z2);
                    }
                    ValueEncoder valueEncoder = (ValueEncoder) this.f89166c.get(obj.getClass());
                    return valueEncoder != null ? s(valueEncoder, fieldDescriptor, obj, z2) : obj instanceof ProtoEnum ? d(fieldDescriptor, ((ProtoEnum) obj).J()) : obj instanceof Enum ? d(fieldDescriptor, ((Enum) obj).ordinal()) : r(this.f89167d, fieldDescriptor, obj, z2);
                }
                byte[] bArr = (byte[]) obj;
                if (!z2 || bArr.length != 0) {
                    w((v(fieldDescriptor) << 3) | 2);
                    w(bArr.length);
                    this.f89164a.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public ProtobufDataEncoderContext d(FieldDescriptor fieldDescriptor, int i3) {
        return k(fieldDescriptor, i3, true);
    }

    ProtobufDataEncoderContext k(FieldDescriptor fieldDescriptor, int i3, boolean z2) throws IOException {
        if (!z2 || i3 != 0) {
            Protobuf protobufU = u(fieldDescriptor);
            int i4 = AnonymousClass1.f89169a[protobufU.intEncoding().ordinal()];
            if (i4 == 1) {
                w(protobufU.tag() << 3);
                w(i3);
                return this;
            }
            if (i4 == 2) {
                w(protobufU.tag() << 3);
                w((i3 << 1) ^ (i3 >> 31));
                return this;
            }
            if (i4 == 3) {
                w((protobufU.tag() << 3) | 5);
                this.f89164a.write(p(4).putInt(i3).array());
                return this;
            }
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public ProtobufDataEncoderContext c(FieldDescriptor fieldDescriptor, long j3) {
        return m(fieldDescriptor, j3, true);
    }

    ProtobufDataEncoderContext m(FieldDescriptor fieldDescriptor, long j3, boolean z2) throws IOException {
        if (!z2 || j3 != 0) {
            Protobuf protobufU = u(fieldDescriptor);
            int i3 = AnonymousClass1.f89169a[protobufU.intEncoding().ordinal()];
            if (i3 == 1) {
                w(protobufU.tag() << 3);
                x(j3);
                return this;
            }
            if (i3 == 2) {
                w(protobufU.tag() << 3);
                x((j3 >> 63) ^ (j3 << 1));
                return this;
            }
            if (i3 == 3) {
                w((protobufU.tag() << 3) | 1);
                this.f89164a.write(p(8).putLong(j3).array());
                return this;
            }
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ProtobufDataEncoderContext b(FieldDescriptor fieldDescriptor, boolean z2) {
        return o(fieldDescriptor, z2, true);
    }

    ProtobufDataEncoderContext o(FieldDescriptor fieldDescriptor, boolean z2, boolean z3) {
        return k(fieldDescriptor, z2 ? 1 : 0, z3);
    }

    ProtobufDataEncoderContext t(Object obj) {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.f89165b.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }
}
