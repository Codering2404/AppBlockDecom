package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.MessageLiteOrBuilder;
import androidx.datastore.preferences.protobuf.Parser;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.glance.session.ecY.lisODU;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PreferencesProto {

    /* JADX INFO: renamed from: androidx.datastore.preferences.PreferencesProto$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35918a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f35918a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35918a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35918a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35918a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35918a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35918a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35918a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PreferenceMap extends GeneratedMessageLite<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
        private static final PreferenceMap DEFAULT_INSTANCE;
        private static volatile Parser<PreferenceMap> PARSER = null;
        public static final int PREFERENCES_FIELD_NUMBER = 1;
        private MapFieldLite<String, Value> preferences_ = MapFieldLite.e();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<PreferenceMap, Builder> implements PreferenceMapOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder K(String str, Value value) {
                str.getClass();
                value.getClass();
                z();
                ((PreferenceMap) this.f36396b).Y().put(str, value);
                return this;
            }

            private Builder() {
                super(PreferenceMap.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class PreferencesDefaultEntryHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final MapEntryLite f35919a = MapEntryLite.d(WireFormat.FieldType.f36696l, "", WireFormat.FieldType.f36698n, Value.h0());
        }

        static {
            PreferenceMap preferenceMap = new PreferenceMap();
            DEFAULT_INSTANCE = preferenceMap;
            GeneratedMessageLite.S(PreferenceMap.class, preferenceMap);
        }

        private PreferenceMap() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map Y() {
            return a0();
        }

        private MapFieldLite a0() {
            if (!this.preferences_.j()) {
                this.preferences_ = this.preferences_.o();
            }
            return this.preferences_;
        }

        private MapFieldLite b0() {
            return this.preferences_;
        }

        public static Builder c0() {
            return (Builder) DEFAULT_INSTANCE.w();
        }

        public static PreferenceMap d0(InputStream inputStream) {
            return (PreferenceMap) GeneratedMessageLite.Q(DEFAULT_INSTANCE, inputStream);
        }

        public Map Z() {
            return Collections.unmodifiableMap(b0());
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f35918a[methodToInvoke.ordinal()]) {
                case 1:
                    return new PreferenceMap();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", PreferencesDefaultEntryHolder.f35919a});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PreferenceMap> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PreferenceMap.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PreferenceMapOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class StringSet extends GeneratedMessageLite<StringSet, Builder> implements StringSetOrBuilder {
        private static final StringSet DEFAULT_INSTANCE;
        private static volatile Parser<StringSet> PARSER = null;
        public static final int STRINGS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<String> strings_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<StringSet, Builder> implements StringSetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder K(Iterable iterable) {
                z();
                ((StringSet) this.f36396b).Y(iterable);
                return this;
            }

            private Builder() {
                super(StringSet.DEFAULT_INSTANCE);
            }
        }

        static {
            StringSet stringSet = new StringSet();
            DEFAULT_INSTANCE = stringSet;
            GeneratedMessageLite.S(StringSet.class, stringSet);
        }

        private StringSet() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y(Iterable iterable) {
            Z();
            AbstractMessageLite.d(iterable, this.strings_);
        }

        private void Z() {
            Internal.ProtobufList<String> protobufList = this.strings_;
            if (protobufList.m()) {
                return;
            }
            this.strings_ = GeneratedMessageLite.L(protobufList);
        }

        public static StringSet a0() {
            return DEFAULT_INSTANCE;
        }

        public static Builder c0() {
            return (Builder) DEFAULT_INSTANCE.w();
        }

        public List b0() {
            return this.strings_;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f35918a[methodToInvoke.ordinal()]) {
                case 1:
                    return new StringSet();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StringSet> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StringSet.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface StringSetOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
        public static final int BOOLEAN_FIELD_NUMBER = 1;
        public static final int BYTES_FIELD_NUMBER = 8;
        private static final Value DEFAULT_INSTANCE;
        public static final int DOUBLE_FIELD_NUMBER = 7;
        public static final int FLOAT_FIELD_NUMBER = 2;
        public static final int INTEGER_FIELD_NUMBER = 3;
        public static final int LONG_FIELD_NUMBER = 4;
        private static volatile Parser<Value> PARSER = null;
        public static final int STRING_FIELD_NUMBER = 5;
        public static final int STRING_SET_FIELD_NUMBER = 6;
        private int valueCase_ = 0;
        private Object value_;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder K(boolean z2) {
                z();
                ((Value) this.f36396b).q0(z2);
                return this;
            }

            public Builder L(ByteString byteString) {
                z();
                ((Value) this.f36396b).r0(byteString);
                return this;
            }

            public Builder M(double d3) {
                z();
                ((Value) this.f36396b).s0(d3);
                return this;
            }

            public Builder N(float f3) {
                z();
                ((Value) this.f36396b).t0(f3);
                return this;
            }

            public Builder O(int i3) {
                z();
                ((Value) this.f36396b).u0(i3);
                return this;
            }

            public Builder P(long j3) {
                z();
                ((Value) this.f36396b).v0(j3);
                return this;
            }

            public Builder Q(String str) {
                z();
                ((Value) this.f36396b).w0(str);
                return this;
            }

            public Builder R(StringSet.Builder builder) {
                z();
                ((Value) this.f36396b).x0((StringSet) builder.build());
                return this;
            }

            private Builder() {
                super(Value.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        public enum ValueCase {
            BOOLEAN(1),
            FLOAT(2),
            INTEGER(3),
            LONG(4),
            STRING(5),
            STRING_SET(6),
            DOUBLE(7),
            BYTES(8),
            VALUE_NOT_SET(0);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f35930a;

            ValueCase(int i3) {
                this.f35930a = i3;
            }

            public static ValueCase b(int i3) {
                switch (i3) {
                    case 0:
                        return VALUE_NOT_SET;
                    case 1:
                        return BOOLEAN;
                    case 2:
                        return FLOAT;
                    case 3:
                        return INTEGER;
                    case 4:
                        return LONG;
                    case 5:
                        return STRING;
                    case 6:
                        return STRING_SET;
                    case 7:
                        return DOUBLE;
                    case 8:
                        return BYTES;
                    default:
                        return null;
                }
            }
        }

        static {
            Value value = new Value();
            DEFAULT_INSTANCE = value;
            GeneratedMessageLite.S(Value.class, value);
        }

        private Value() {
        }

        public static Value h0() {
            return DEFAULT_INSTANCE;
        }

        public static Builder p0() {
            return (Builder) DEFAULT_INSTANCE.w();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(boolean z2) {
            this.valueCase_ = 1;
            this.value_ = Boolean.valueOf(z2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(ByteString byteString) {
            byteString.getClass();
            this.valueCase_ = 8;
            this.value_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(double d3) {
            this.valueCase_ = 7;
            this.value_ = Double.valueOf(d3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(float f3) {
            this.valueCase_ = 2;
            this.value_ = Float.valueOf(f3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(int i3) {
            this.valueCase_ = 3;
            this.value_ = Integer.valueOf(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(long j3) {
            this.valueCase_ = 4;
            this.value_ = Long.valueOf(j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(String str) {
            str.getClass();
            this.valueCase_ = 5;
            this.value_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(StringSet stringSet) {
            stringSet.getClass();
            this.value_ = stringSet;
            this.valueCase_ = 6;
        }

        public boolean f0() {
            if (this.valueCase_ == 1) {
                return ((Boolean) this.value_).booleanValue();
            }
            return false;
        }

        public ByteString g0() {
            return this.valueCase_ == 8 ? (ByteString) this.value_ : ByteString.f36020b;
        }

        public double i0() {
            if (this.valueCase_ == 7) {
                return ((Double) this.value_).doubleValue();
            }
            return 0.0d;
        }

        public float j0() {
            if (this.valueCase_ == 2) {
                return ((Float) this.value_).floatValue();
            }
            return 0.0f;
        }

        public int k0() {
            if (this.valueCase_ == 3) {
                return ((Integer) this.value_).intValue();
            }
            return 0;
        }

        public long l0() {
            if (this.valueCase_ == 4) {
                return ((Long) this.value_).longValue();
            }
            return 0L;
        }

        public StringSet n0() {
            return this.valueCase_ == 6 ? (StringSet) this.value_ : StringSet.a0();
        }

        public ValueCase o0() {
            return ValueCase.b(this.valueCase_);
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f35918a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Value();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", StringSet.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Value> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Value.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public String m0() {
            return this.valueCase_ == 5 ? (String) this.value_ : lisODU.khCdgribh;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ValueOrBuilder extends MessageLiteOrBuilder {
    }
}
