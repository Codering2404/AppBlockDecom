package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.DescriptorProtos;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaFeaturesProto {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GeneratedMessageLite.GeneratedExtension f36454a = GeneratedMessageLite.P(DescriptorProtos.FeatureSet.Y(), JavaFeatures.X(), JavaFeatures.X(), null, AdError.NO_FILL_ERROR_CODE, WireFormat.FieldType.f36698n, JavaFeatures.class);

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.JavaFeaturesProto$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36455a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f36455a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36455a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36455a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36455a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36455a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36455a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36455a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class JavaFeatures extends GeneratedMessageLite<JavaFeatures, Builder> implements JavaFeaturesOrBuilder {
        private static final JavaFeatures DEFAULT_INSTANCE;
        public static final int LEGACY_CLOSED_ENUM_FIELD_NUMBER = 1;
        private static volatile Parser<JavaFeatures> PARSER = null;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 2;
        private int bitField0_;
        private boolean legacyClosedEnum_;
        private int utf8Validation_;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<JavaFeatures, Builder> implements JavaFeaturesOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(JavaFeatures.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum Utf8Validation implements Internal.EnumLite {
            UTF8_VALIDATION_UNKNOWN(0),
            DEFAULT(1),
            VERIFY(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36459f = new Internal.EnumLiteMap<Utf8Validation>() { // from class: androidx.datastore.preferences.protobuf.JavaFeaturesProto.JavaFeatures.Utf8Validation.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Utf8Validation a(int i3) {
                    return Utf8Validation.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36461a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class Utf8ValidationVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36462a = new Utf8ValidationVerifier();

                private Utf8ValidationVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return Utf8Validation.a(i3) != null;
                }
            }

            Utf8Validation(int i3) {
                this.f36461a = i3;
            }

            public static Utf8Validation a(int i3) {
                if (i3 == 0) {
                    return UTF8_VALIDATION_UNKNOWN;
                }
                if (i3 == 1) {
                    return DEFAULT;
                }
                if (i3 != 2) {
                    return null;
                }
                return VERIFY;
            }

            public static Internal.EnumVerifier b() {
                return Utf8ValidationVerifier.f36462a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36461a;
            }
        }

        static {
            JavaFeatures javaFeatures = new JavaFeatures();
            DEFAULT_INSTANCE = javaFeatures;
            GeneratedMessageLite.S(JavaFeatures.class, javaFeatures);
        }

        private JavaFeatures() {
        }

        public static JavaFeatures X() {
            return DEFAULT_INSTANCE;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36455a[methodToInvoke.ordinal()]) {
                case 1:
                    return new JavaFeatures();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001", new Object[]{"bitField0_", "legacyClosedEnum_", "utf8Validation_", Utf8Validation.b()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<JavaFeatures> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (JavaFeatures.class) {
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
    public interface JavaFeaturesOrBuilder extends MessageLiteOrBuilder {
    }
}
