package com.google.firebase.encoders.json;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ObjectEncoder f89134e = new ObjectEncoder() { // from class: com.google.firebase.encoders.json.a
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            JsonDataEncoderBuilder.c(obj, (ObjectEncoderContext) obj2);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ValueEncoder f89135f = new ValueEncoder() { // from class: com.google.firebase.encoders.json.b
        @Override // com.google.firebase.encoders.ValueEncoder
        public final void a(Object obj, Object obj2) {
            ((ValueEncoderContext) obj2).a((String) obj);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ValueEncoder f89136g = new ValueEncoder() { // from class: com.google.firebase.encoders.json.c
        @Override // com.google.firebase.encoders.ValueEncoder
        public final void a(Object obj, Object obj2) {
            ((ValueEncoderContext) obj2).g(((Boolean) obj).booleanValue());
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final TimestampEncoder f89137h = new TimestampEncoder();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f89138a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f89139b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObjectEncoder f89140c = f89134e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f89141d = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TimestampEncoder implements ValueEncoder<Date> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DateFormat f89143a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f89143a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private TimestampEncoder() {
        }

        @Override // com.google.firebase.encoders.ValueEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, ValueEncoderContext valueEncoderContext) {
            valueEncoderContext.a(f89143a.format(date));
        }
    }

    public JsonDataEncoderBuilder() {
        m(String.class, f89135f);
        m(Boolean.class, f89136g);
        m(Date.class, f89137h);
    }

    public static /* synthetic */ void c(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public DataEncoder i() {
        return new DataEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder.1
            @Override // com.google.firebase.encoders.DataEncoder
            public void a(Object obj, Writer writer) {
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, JsonDataEncoderBuilder.this.f89138a, JsonDataEncoderBuilder.this.f89139b, JsonDataEncoderBuilder.this.f89140c, JsonDataEncoderBuilder.this.f89141d);
                jsonValueObjectEncoderContext.k(obj, false);
                jsonValueObjectEncoderContext.u();
            }

            @Override // com.google.firebase.encoders.DataEncoder
            public String b(Object obj) {
                StringWriter stringWriter = new StringWriter();
                try {
                    a(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
    }

    public JsonDataEncoderBuilder j(Configurator configurator) {
        configurator.a(this);
        return this;
    }

    public JsonDataEncoderBuilder k(boolean z2) {
        this.f89141d = z2;
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public JsonDataEncoderBuilder a(Class cls, ObjectEncoder objectEncoder) {
        this.f89138a.put(cls, objectEncoder);
        this.f89139b.remove(cls);
        return this;
    }

    public JsonDataEncoderBuilder m(Class cls, ValueEncoder valueEncoder) {
        this.f89139b.put(cls, valueEncoder);
        this.f89138a.remove(cls);
        return this;
    }
}
