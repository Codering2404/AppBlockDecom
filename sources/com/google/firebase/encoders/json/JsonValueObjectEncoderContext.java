package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JsonValueObjectEncoderContext f89144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f89145b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JsonWriter f89146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f89147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f89148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ObjectEncoder f89149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f89150g;

    JsonValueObjectEncoderContext(Writer writer, Map map, Map map2, ObjectEncoder objectEncoder, boolean z2) {
        this.f89146c = new JsonWriter(writer);
        this.f89147d = map;
        this.f89148e = map2;
        this.f89149f = objectEncoder;
        this.f89150g = z2;
    }

    private boolean t(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private JsonValueObjectEncoderContext w(String str, Object obj) throws IOException {
        y();
        this.f89146c.name(str);
        if (obj != null) {
            return k(obj, false);
        }
        this.f89146c.nullValue();
        return this;
    }

    private JsonValueObjectEncoderContext x(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        y();
        this.f89146c.name(str);
        return k(obj, false);
    }

    private void y() throws IOException {
        if (!this.f89145b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.f89144a;
        if (jsonValueObjectEncoderContext != null) {
            jsonValueObjectEncoderContext.y();
            this.f89144a.f89145b = false;
            this.f89144a = null;
            this.f89146c.endObject();
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext b(FieldDescriptor fieldDescriptor, boolean z2) {
        return q(fieldDescriptor.b(), z2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext c(FieldDescriptor fieldDescriptor, long j3) {
        return o(fieldDescriptor.b(), j3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext d(FieldDescriptor fieldDescriptor, int i3) {
        return n(fieldDescriptor.b(), i3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext e(FieldDescriptor fieldDescriptor, double d3) {
        return m(fieldDescriptor.b(), d3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext f(FieldDescriptor fieldDescriptor, Object obj) {
        return p(fieldDescriptor.b(), obj);
    }

    public JsonValueObjectEncoderContext h(double d3) throws IOException {
        y();
        this.f89146c.value(d3);
        return this;
    }

    public JsonValueObjectEncoderContext i(int i3) throws IOException {
        y();
        this.f89146c.value(i3);
        return this;
    }

    public JsonValueObjectEncoderContext j(long j3) throws IOException {
        y();
        this.f89146c.value(j3);
        return this;
    }

    JsonValueObjectEncoderContext k(Object obj, boolean z2) {
        if (z2 && t(obj)) {
            throw new EncodingException(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.f89146c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f89146c.value((Number) obj);
            return this;
        }
        int i3 = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f89146c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    k(it.next(), false);
                }
                this.f89146c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f89146c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        p((String) key, entry.getValue());
                    } catch (ClassCastException e3) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e3);
                    }
                }
                this.f89146c.endObject();
                return this;
            }
            ObjectEncoder objectEncoder = (ObjectEncoder) this.f89147d.get(obj.getClass());
            if (objectEncoder != null) {
                return v(objectEncoder, obj, z2);
            }
            ValueEncoder valueEncoder = (ValueEncoder) this.f89148e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return v(this.f89149f, obj, z2);
            }
            if (obj instanceof NumberedEnum) {
                i(((NumberedEnum) obj).J());
                return this;
            }
            a(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return s((byte[]) obj);
        }
        this.f89146c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i3 < length) {
                this.f89146c.value(r6[i3]);
                i3++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i3 < length2) {
                j(jArr[i3]);
                i3++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i3 < length3) {
                this.f89146c.value(dArr[i3]);
                i3++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i3 < length4) {
                this.f89146c.value(zArr[i3]);
                i3++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                k(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                k(obj2, false);
            }
        }
        this.f89146c.endArray();
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public JsonValueObjectEncoderContext a(String str) throws IOException {
        y();
        this.f89146c.value(str);
        return this;
    }

    public JsonValueObjectEncoderContext m(String str, double d3) throws IOException {
        y();
        this.f89146c.name(str);
        return h(d3);
    }

    public JsonValueObjectEncoderContext n(String str, int i3) throws IOException {
        y();
        this.f89146c.name(str);
        return i(i3);
    }

    public JsonValueObjectEncoderContext o(String str, long j3) throws IOException {
        y();
        this.f89146c.name(str);
        return j(j3);
    }

    public JsonValueObjectEncoderContext p(String str, Object obj) {
        return this.f89150g ? x(str, obj) : w(str, obj);
    }

    public JsonValueObjectEncoderContext q(String str, boolean z2) throws IOException {
        y();
        this.f89146c.name(str);
        return g(z2);
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public JsonValueObjectEncoderContext g(boolean z2) throws IOException {
        y();
        this.f89146c.value(z2);
        return this;
    }

    public JsonValueObjectEncoderContext s(byte[] bArr) throws IOException {
        y();
        if (bArr == null) {
            this.f89146c.nullValue();
            return this;
        }
        this.f89146c.value(Base64.encodeToString(bArr, 2));
        return this;
    }

    void u() {
        y();
        this.f89146c.flush();
    }

    JsonValueObjectEncoderContext v(ObjectEncoder objectEncoder, Object obj, boolean z2) throws IOException {
        if (!z2) {
            this.f89146c.beginObject();
        }
        objectEncoder.a(obj, this);
        if (!z2) {
            this.f89146c.endObject();
        }
        return this;
    }
}
