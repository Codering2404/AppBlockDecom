package androidx.datastore.preferences.protobuf;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.facebook.ads.AdError;
import com.google.android.gms.common.api.Api;
import com.google.common.cache.LSNn.vfptEEmYY;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorProtos {

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.DescriptorProtos$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36124a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f36124a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36124a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36124a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36124a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36124a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36124a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36124a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class DescriptorProto extends GeneratedMessageLite<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
        private static final DescriptorProto DEFAULT_INSTANCE;
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int ONEOF_DECL_FIELD_NUMBER = 8;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static volatile Parser<DescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 10;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
        private int bitField0_;
        private MessageOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<FieldDescriptorProto> field_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<DescriptorProto> nestedType_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<ExtensionRange> extensionRange_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<OneofDescriptorProto> oneofDecl_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<ReservedRange> reservedRange_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DescriptorProto.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class ExtensionRange extends GeneratedMessageLite<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
            private static final ExtensionRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            public static final int OPTIONS_FIELD_NUMBER = 3;
            private static volatile Parser<ExtensionRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized = 2;
            private ExtensionRangeOptions options_;
            private int start_;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class Builder extends GeneratedMessageLite.Builder<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(ExtensionRange.DEFAULT_INSTANCE);
                }
            }

            static {
                ExtensionRange extensionRange = new ExtensionRange();
                DEFAULT_INSTANCE = extensionRange;
                GeneratedMessageLite.S(ExtensionRange.class, extensionRange);
            }

            private ExtensionRange() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ExtensionRange();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "start_", "end_", "options_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ExtensionRange> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ExtensionRange.class) {
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
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface ExtensionRangeOrBuilder extends MessageLiteOrBuilder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class ReservedRange extends GeneratedMessageLite<ReservedRange, Builder> implements ReservedRangeOrBuilder {
            private static final ReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<ReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class Builder extends GeneratedMessageLite.Builder<ReservedRange, Builder> implements ReservedRangeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(ReservedRange.DEFAULT_INSTANCE);
                }
            }

            static {
                ReservedRange reservedRange = new ReservedRange();
                DEFAULT_INSTANCE = reservedRange;
                GeneratedMessageLite.S(ReservedRange.class, reservedRange);
            }

            private ReservedRange() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ReservedRange();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ReservedRange> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ReservedRange.class) {
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
        public interface ReservedRangeOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            DescriptorProto descriptorProto = new DescriptorProto();
            DEFAULT_INSTANCE = descriptorProto;
            GeneratedMessageLite.S(DescriptorProto.class, descriptorProto);
        }

        private DescriptorProto() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DescriptorProto();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\b\u0007\u0001ဈ\u0000\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0001\bЛ\t\u001b\n\u001a", new Object[]{"bitField0_", "name_", "field_", FieldDescriptorProto.class, "nestedType_", DescriptorProto.class, "enumType_", EnumDescriptorProto.class, "extensionRange_", ExtensionRange.class, "extension_", FieldDescriptorProto.class, "options_", "oneofDecl_", OneofDescriptorProto.class, "reservedRange_", ReservedRange.class, "reservedName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DescriptorProto.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Edition implements Internal.EnumLite {
        EDITION_UNKNOWN(0),
        EDITION_LEGACY(900),
        EDITION_PROTO2(998),
        EDITION_PROTO3(999),
        EDITION_2023(1000),
        EDITION_2024(AdError.NO_FILL_ERROR_CODE),
        EDITION_1_TEST_ONLY(1),
        EDITION_2_TEST_ONLY(2),
        EDITION_99997_TEST_ONLY(99997),
        EDITION_99998_TEST_ONLY(99998),
        EDITION_99999_TEST_ONLY(99999),
        EDITION_MAX(Api.BaseClientBuilder.API_PRIORITY_OTHER);


        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final Internal.EnumLiteMap f36137o = new Internal.EnumLiteMap<Edition>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.Edition.1
            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Edition a(int i3) {
                return Edition.a(i3);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36139a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class EditionVerifier implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f36140a = new EditionVerifier();

            private EditionVerifier() {
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
            public boolean a(int i3) {
                return Edition.a(i3) != null;
            }
        }

        Edition(int i3) {
            this.f36139a = i3;
        }

        public static Edition a(int i3) {
            if (i3 == 0) {
                return EDITION_UNKNOWN;
            }
            if (i3 == 1) {
                return EDITION_1_TEST_ONLY;
            }
            if (i3 == 2) {
                return EDITION_2_TEST_ONLY;
            }
            if (i3 == 900) {
                return EDITION_LEGACY;
            }
            if (i3 == Integer.MAX_VALUE) {
                return EDITION_MAX;
            }
            switch (i3) {
                case 998:
                    return EDITION_PROTO2;
                case 999:
                    return EDITION_PROTO3;
                case 1000:
                    return EDITION_2023;
                case AdError.NO_FILL_ERROR_CODE /* 1001 */:
                    return EDITION_2024;
                default:
                    switch (i3) {
                        case 99997:
                            return EDITION_99997_TEST_ONLY;
                        case 99998:
                            return EDITION_99998_TEST_ONLY;
                        case 99999:
                            return EDITION_99999_TEST_ONLY;
                        default:
                            return null;
                    }
            }
        }

        public static Internal.EnumVerifier b() {
            return EditionVerifier.f36140a;
        }

        @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
        public final int J() {
            return this.f36139a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EnumDescriptorProto extends GeneratedMessageLite<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
        private static final EnumDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumDescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 5;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private EnumOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<EnumValueDescriptorProto> value_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<EnumReservedRange> reservedRange_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(EnumDescriptorProto.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class EnumReservedRange extends GeneratedMessageLite<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
            private static final EnumReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<EnumReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class Builder extends GeneratedMessageLite.Builder<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(EnumReservedRange.DEFAULT_INSTANCE);
                }
            }

            static {
                EnumReservedRange enumReservedRange = new EnumReservedRange();
                DEFAULT_INSTANCE = enumReservedRange;
                GeneratedMessageLite.S(EnumReservedRange.class, enumReservedRange);
            }

            private EnumReservedRange() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new EnumReservedRange();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<EnumReservedRange> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (EnumReservedRange.class) {
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
        public interface EnumReservedRangeOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto();
            DEFAULT_INSTANCE = enumDescriptorProto;
            GeneratedMessageLite.S(EnumDescriptorProto.class, enumDescriptorProto);
        }

        private EnumDescriptorProto() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumDescriptorProto();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001\u0004\u001b\u0005\u001a", new Object[]{"bitField0_", "name_", "value_", EnumValueDescriptorProto.class, "options_", "reservedRange_", EnumReservedRange.class, "reservedName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EnumDescriptorProto.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EnumDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EnumOptions extends GeneratedMessageLite.ExtendableMessage<EnumOptions, Builder> implements EnumOptionsOrBuilder {
        public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
        private static final EnumOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int DEPRECATED_LEGACY_JSON_FIELD_CONFLICTS_FIELD_NUMBER = 6;
        public static final int FEATURES_FIELD_NUMBER = 7;
        private static volatile Parser<EnumOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private boolean allowAlias_;
        private int bitField0_;
        private boolean deprecatedLegacyJsonFieldConflicts_;
        private boolean deprecated_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(EnumOptions.DEFAULT_INSTANCE);
            }
        }

        static {
            EnumOptions enumOptions = new EnumOptions();
            DEFAULT_INSTANCE = enumOptions;
            GeneratedMessageLite.S(EnumOptions.class, enumOptions);
        }

        private EnumOptions() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0002ϧ\u0005\u0000\u0001\u0002\u0002ဇ\u0000\u0003ဇ\u0001\u0006ဇ\u0002\u0007ᐉ\u0003ϧЛ", new Object[]{"bitField0_", "allowAlias_", "deprecated_", "deprecatedLegacyJsonFieldConflicts_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EnumOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EnumOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumOptions, EnumOptions.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EnumValueDescriptorProto extends GeneratedMessageLite<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
        private static final EnumValueDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumValueDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private int number_;
        private EnumValueOptions options_;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(EnumValueDescriptorProto.DEFAULT_INSTANCE);
            }
        }

        static {
            EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto();
            DEFAULT_INSTANCE = enumValueDescriptorProto;
            GeneratedMessageLite.S(EnumValueDescriptorProto.class, enumValueDescriptorProto);
        }

        private EnumValueDescriptorProto() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueDescriptorProto();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "name_", "number_", "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumValueDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EnumValueDescriptorProto.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EnumValueDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class EnumValueOptions extends GeneratedMessageLite.ExtendableMessage<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
        public static final int DEBUG_REDACT_FIELD_NUMBER = 3;
        private static final EnumValueOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 1;
        public static final int FEATURES_FIELD_NUMBER = 2;
        public static final int FEATURE_SUPPORT_FIELD_NUMBER = 4;
        private static volatile Parser<EnumValueOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean debugRedact_;
        private boolean deprecated_;
        private FieldOptions.FeatureSupport featureSupport_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(EnumValueOptions.DEFAULT_INSTANCE);
            }
        }

        static {
            EnumValueOptions enumValueOptions = new EnumValueOptions();
            DEFAULT_INSTANCE = enumValueOptions;
            GeneratedMessageLite.S(EnumValueOptions.class, enumValueOptions);
        }

        private EnumValueOptions() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဉ\u0003ϧЛ", new Object[]{muQRKXGtpOhe.JbQWFoOHjPjW, "deprecated_", "features_", "debugRedact_", "featureSupport_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumValueOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EnumValueOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EnumValueOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumValueOptions, EnumValueOptions.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ExtensionRangeOptions extends GeneratedMessageLite.ExtendableMessage<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
        public static final int DECLARATION_FIELD_NUMBER = 2;
        private static final ExtensionRangeOptions DEFAULT_INSTANCE;
        public static final int FEATURES_FIELD_NUMBER = 50;
        private static volatile Parser<ExtensionRangeOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int VERIFICATION_FIELD_NUMBER = 3;
        private int bitField0_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<Declaration> declaration_ = GeneratedMessageLite.B();
        private int verification_ = 1;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ExtensionRangeOptions.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Declaration extends GeneratedMessageLite<Declaration, Builder> implements DeclarationOrBuilder {
            private static final Declaration DEFAULT_INSTANCE;
            public static final int FULL_NAME_FIELD_NUMBER = 2;
            public static final int NUMBER_FIELD_NUMBER = 1;
            private static volatile Parser<Declaration> PARSER = null;
            public static final int REPEATED_FIELD_NUMBER = 6;
            public static final int RESERVED_FIELD_NUMBER = 5;
            public static final int TYPE_FIELD_NUMBER = 3;
            private int bitField0_;
            private int number_;
            private boolean repeated_;
            private boolean reserved_;
            private String fullName_ = "";
            private String type_ = "";

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class Builder extends GeneratedMessageLite.Builder<Declaration, Builder> implements DeclarationOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Declaration.DEFAULT_INSTANCE);
                }
            }

            static {
                Declaration declaration = new Declaration();
                DEFAULT_INSTANCE = declaration;
                GeneratedMessageLite.S(Declaration.class, declaration);
            }

            private Declaration() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Declaration();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0005ဇ\u0003\u0006ဇ\u0004", new Object[]{"bitField0_", "number_", "fullName_", "type_", "reserved_", "repeated_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Declaration> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Declaration.class) {
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
        public interface DeclarationOrBuilder extends MessageLiteOrBuilder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum VerificationState implements Internal.EnumLite {
            DECLARATION(0),
            UNVERIFIED(1);


            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36143d = new Internal.EnumLiteMap<VerificationState>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.ExtensionRangeOptions.VerificationState.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public VerificationState a(int i3) {
                    return VerificationState.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36145a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class VerificationStateVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36146a = new VerificationStateVerifier();

                private VerificationStateVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return VerificationState.a(i3) != null;
                }
            }

            VerificationState(int i3) {
                this.f36145a = i3;
            }

            public static VerificationState a(int i3) {
                if (i3 == 0) {
                    return DECLARATION;
                }
                if (i3 != 1) {
                    return null;
                }
                return UNVERIFIED;
            }

            public static Internal.EnumVerifier b() {
                return VerificationStateVerifier.f36146a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36145a;
            }
        }

        static {
            ExtensionRangeOptions extensionRangeOptions = new ExtensionRangeOptions();
            DEFAULT_INSTANCE = extensionRangeOptions;
            GeneratedMessageLite.S(ExtensionRangeOptions.class, extensionRangeOptions);
        }

        private ExtensionRangeOptions() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExtensionRangeOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0002ϧ\u0004\u0000\u0002\u0002\u0002\u001b\u0003᠌\u00012ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "declaration_", Declaration.class, "verification_", VerificationState.b(), "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExtensionRangeOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ExtensionRangeOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ExtensionRangeOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ExtensionRangeOptions, ExtensionRangeOptions.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FeatureSet extends GeneratedMessageLite.ExtendableMessage<FeatureSet, Builder> implements FeatureSetOrBuilder {
        private static final FeatureSet DEFAULT_INSTANCE;
        public static final int ENUM_TYPE_FIELD_NUMBER = 2;
        public static final int FIELD_PRESENCE_FIELD_NUMBER = 1;
        public static final int JSON_FORMAT_FIELD_NUMBER = 6;
        public static final int MESSAGE_ENCODING_FIELD_NUMBER = 5;
        private static volatile Parser<FeatureSet> PARSER = null;
        public static final int REPEATED_FIELD_ENCODING_FIELD_NUMBER = 3;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 4;
        private int bitField0_;
        private int enumType_;
        private int fieldPresence_;
        private int jsonFormat_;
        private byte memoizedIsInitialized = 2;
        private int messageEncoding_;
        private int repeatedFieldEncoding_;
        private int utf8Validation_;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FeatureSet, Builder> implements FeatureSetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(FeatureSet.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum EnumType implements Internal.EnumLite {
            ENUM_TYPE_UNKNOWN(0),
            OPEN(1),
            CLOSED(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36150f = new Internal.EnumLiteMap<EnumType>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FeatureSet.EnumType.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumType a(int i3) {
                    return EnumType.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36152a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class EnumTypeVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36153a = new EnumTypeVerifier();

                private EnumTypeVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return EnumType.a(i3) != null;
                }
            }

            EnumType(int i3) {
                this.f36152a = i3;
            }

            public static EnumType a(int i3) {
                if (i3 == 0) {
                    return ENUM_TYPE_UNKNOWN;
                }
                if (i3 == 1) {
                    return OPEN;
                }
                if (i3 != 2) {
                    return null;
                }
                return CLOSED;
            }

            public static Internal.EnumVerifier b() {
                return EnumTypeVerifier.f36153a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36152a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum FieldPresence implements Internal.EnumLite {
            FIELD_PRESENCE_UNKNOWN(0),
            EXPLICIT(1),
            IMPLICIT(2),
            LEGACY_REQUIRED(3);


            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36158g = new Internal.EnumLiteMap<FieldPresence>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FeatureSet.FieldPresence.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public FieldPresence a(int i3) {
                    return FieldPresence.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36160a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class FieldPresenceVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36161a = new FieldPresenceVerifier();

                private FieldPresenceVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return FieldPresence.a(i3) != null;
                }
            }

            FieldPresence(int i3) {
                this.f36160a = i3;
            }

            public static FieldPresence a(int i3) {
                if (i3 == 0) {
                    return FIELD_PRESENCE_UNKNOWN;
                }
                if (i3 == 1) {
                    return EXPLICIT;
                }
                if (i3 == 2) {
                    return IMPLICIT;
                }
                if (i3 != 3) {
                    return null;
                }
                return LEGACY_REQUIRED;
            }

            public static Internal.EnumVerifier b() {
                return FieldPresenceVerifier.f36161a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36160a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum JsonFormat implements Internal.EnumLite {
            JSON_FORMAT_UNKNOWN(0),
            ALLOW(1),
            LEGACY_BEST_EFFORT(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36165f = new Internal.EnumLiteMap<JsonFormat>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FeatureSet.JsonFormat.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public JsonFormat a(int i3) {
                    return JsonFormat.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36167a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class JsonFormatVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36168a = new JsonFormatVerifier();

                private JsonFormatVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return JsonFormat.a(i3) != null;
                }
            }

            JsonFormat(int i3) {
                this.f36167a = i3;
            }

            public static JsonFormat a(int i3) {
                if (i3 == 0) {
                    return JSON_FORMAT_UNKNOWN;
                }
                if (i3 == 1) {
                    return ALLOW;
                }
                if (i3 != 2) {
                    return null;
                }
                return LEGACY_BEST_EFFORT;
            }

            public static Internal.EnumVerifier b() {
                return JsonFormatVerifier.f36168a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36167a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum MessageEncoding implements Internal.EnumLite {
            MESSAGE_ENCODING_UNKNOWN(0),
            LENGTH_PREFIXED(1),
            DELIMITED(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36172f = new Internal.EnumLiteMap<MessageEncoding>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FeatureSet.MessageEncoding.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public MessageEncoding a(int i3) {
                    return MessageEncoding.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36174a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class MessageEncodingVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36175a = new MessageEncodingVerifier();

                private MessageEncodingVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return MessageEncoding.a(i3) != null;
                }
            }

            MessageEncoding(int i3) {
                this.f36174a = i3;
            }

            public static MessageEncoding a(int i3) {
                if (i3 == 0) {
                    return MESSAGE_ENCODING_UNKNOWN;
                }
                if (i3 == 1) {
                    return LENGTH_PREFIXED;
                }
                if (i3 != 2) {
                    return null;
                }
                return DELIMITED;
            }

            public static Internal.EnumVerifier b() {
                return MessageEncodingVerifier.f36175a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36174a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum RepeatedFieldEncoding implements Internal.EnumLite {
            REPEATED_FIELD_ENCODING_UNKNOWN(0),
            PACKED(1),
            EXPANDED(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36179f = new Internal.EnumLiteMap<RepeatedFieldEncoding>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FeatureSet.RepeatedFieldEncoding.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public RepeatedFieldEncoding a(int i3) {
                    return RepeatedFieldEncoding.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36181a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class RepeatedFieldEncodingVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36182a = new RepeatedFieldEncodingVerifier();

                private RepeatedFieldEncodingVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return RepeatedFieldEncoding.a(i3) != null;
                }
            }

            RepeatedFieldEncoding(int i3) {
                this.f36181a = i3;
            }

            public static RepeatedFieldEncoding a(int i3) {
                if (i3 == 0) {
                    return REPEATED_FIELD_ENCODING_UNKNOWN;
                }
                if (i3 == 1) {
                    return PACKED;
                }
                if (i3 != 2) {
                    return null;
                }
                return EXPANDED;
            }

            public static Internal.EnumVerifier b() {
                return RepeatedFieldEncodingVerifier.f36182a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36181a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum Utf8Validation implements Internal.EnumLite {
            UTF8_VALIDATION_UNKNOWN(0),
            VERIFY(2),
            NONE(3);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36186f = new Internal.EnumLiteMap<Utf8Validation>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FeatureSet.Utf8Validation.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Utf8Validation a(int i3) {
                    return Utf8Validation.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36188a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class Utf8ValidationVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36189a = new Utf8ValidationVerifier();

                private Utf8ValidationVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return Utf8Validation.a(i3) != null;
                }
            }

            Utf8Validation(int i3) {
                this.f36188a = i3;
            }

            public static Utf8Validation a(int i3) {
                if (i3 == 0) {
                    return UTF8_VALIDATION_UNKNOWN;
                }
                if (i3 == 2) {
                    return VERIFY;
                }
                if (i3 != 3) {
                    return null;
                }
                return NONE;
            }

            public static Internal.EnumVerifier b() {
                return Utf8ValidationVerifier.f36189a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36188a;
            }
        }

        static {
            FeatureSet featureSet = new FeatureSet();
            DEFAULT_INSTANCE = featureSet;
            GeneratedMessageLite.S(FeatureSet.class, featureSet);
        }

        private FeatureSet() {
        }

        public static FeatureSet Y() {
            return DEFAULT_INSTANCE;
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FeatureSet();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005", new Object[]{"bitField0_", "fieldPresence_", FieldPresence.b(), "enumType_", EnumType.b(), "repeatedFieldEncoding_", RepeatedFieldEncoding.b(), "utf8Validation_", Utf8Validation.b(), "messageEncoding_", MessageEncoding.b(), "jsonFormat_", JsonFormat.b()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FeatureSet> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FeatureSet.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FeatureSetDefaults extends GeneratedMessageLite<FeatureSetDefaults, Builder> implements FeatureSetDefaultsOrBuilder {
        public static final int DEFAULTS_FIELD_NUMBER = 1;
        private static final FeatureSetDefaults DEFAULT_INSTANCE;
        public static final int MAXIMUM_EDITION_FIELD_NUMBER = 5;
        public static final int MINIMUM_EDITION_FIELD_NUMBER = 4;
        private static volatile Parser<FeatureSetDefaults> PARSER;
        private int bitField0_;
        private int maximumEdition_;
        private int minimumEdition_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<FeatureSetEditionDefault> defaults_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<FeatureSetDefaults, Builder> implements FeatureSetDefaultsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(FeatureSetDefaults.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class FeatureSetEditionDefault extends GeneratedMessageLite<FeatureSetEditionDefault, Builder> implements FeatureSetEditionDefaultOrBuilder {
            private static final FeatureSetEditionDefault DEFAULT_INSTANCE;
            public static final int EDITION_FIELD_NUMBER = 3;
            public static final int FIXED_FEATURES_FIELD_NUMBER = 5;
            public static final int OVERRIDABLE_FEATURES_FIELD_NUMBER = 4;
            private static volatile Parser<FeatureSetEditionDefault> PARSER;
            private int bitField0_;
            private int edition_;
            private FeatureSet fixedFeatures_;
            private byte memoizedIsInitialized = 2;
            private FeatureSet overridableFeatures_;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class Builder extends GeneratedMessageLite.Builder<FeatureSetEditionDefault, Builder> implements FeatureSetEditionDefaultOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(FeatureSetEditionDefault.DEFAULT_INSTANCE);
                }
            }

            static {
                FeatureSetEditionDefault featureSetEditionDefault = new FeatureSetEditionDefault();
                DEFAULT_INSTANCE = featureSetEditionDefault;
                GeneratedMessageLite.S(FeatureSetEditionDefault.class, featureSetEditionDefault);
            }

            private FeatureSetEditionDefault() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new FeatureSetEditionDefault();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0003\u0005\u0003\u0000\u0000\u0002\u0003᠌\u0000\u0004ᐉ\u0001\u0005ᐉ\u0002", new Object[]{"bitField0_", "edition_", Edition.b(), "overridableFeatures_", "fixedFeatures_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<FeatureSetEditionDefault> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (FeatureSetEditionDefault.class) {
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
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface FeatureSetEditionDefaultOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            FeatureSetDefaults featureSetDefaults = new FeatureSetDefaults();
            DEFAULT_INSTANCE = featureSetDefaults;
            GeneratedMessageLite.S(FeatureSetDefaults.class, featureSetDefaults);
        }

        private FeatureSetDefaults() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FeatureSetDefaults();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0005\u0003\u0000\u0001\u0001\u0001Л\u0004᠌\u0000\u0005᠌\u0001", new Object[]{"bitField0_", "defaults_", FeatureSetEditionDefault.class, "minimumEdition_", Edition.b(), "maximumEdition_", Edition.b()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FeatureSetDefaults> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FeatureSetDefaults.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FeatureSetDefaultsOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FeatureSetOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FeatureSet, FeatureSet.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FieldDescriptorProto extends GeneratedMessageLite<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
        private static final FieldDescriptorProto DEFAULT_INSTANCE;
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int JSON_NAME_FIELD_NUMBER = 10;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        private static volatile Parser<FieldDescriptorProto> PARSER = null;
        public static final int PROTO3_OPTIONAL_FIELD_NUMBER = 17;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private int bitField0_;
        private int number_;
        private int oneofIndex_;
        private FieldOptions options_;
        private boolean proto3Optional_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private int label_ = 1;
        private int type_ = 1;
        private String typeName_ = "";
        private String extendee_ = "";
        private String defaultValue_ = "";
        private String jsonName_ = "";

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(FieldDescriptorProto.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes2.dex */
        public enum Label implements Internal.EnumLite {
            LABEL_OPTIONAL(1),
            LABEL_REPEATED(3),
            f36192d(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36193f = new Internal.EnumLiteMap<Label>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FieldDescriptorProto.Label.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Label a(int i3) {
                    return Label.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36195a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            /* JADX INFO: loaded from: classes3.dex */
            private static final class LabelVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36196a = new LabelVerifier();

                private LabelVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return Label.a(i3) != null;
                }
            }

            Label(int i3) {
                this.f36195a = i3;
            }

            public static Label a(int i3) {
                if (i3 == 1) {
                    return LABEL_OPTIONAL;
                }
                if (i3 == 2) {
                    return f36192d;
                }
                if (i3 != 3) {
                    return null;
                }
                return LABEL_REPEATED;
            }

            public static Internal.EnumVerifier b() {
                return LabelVerifier.f36196a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36195a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum Type implements Internal.EnumLite {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);


            /* JADX INFO: renamed from: u, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36215u = new Internal.EnumLiteMap<Type>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FieldDescriptorProto.Type.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Type a(int i3) {
                    return Type.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36217a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class TypeVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36218a = new TypeVerifier();

                private TypeVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return Type.a(i3) != null;
                }
            }

            Type(int i3) {
                this.f36217a = i3;
            }

            public static Type a(int i3) {
                switch (i3) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static Internal.EnumVerifier b() {
                return TypeVerifier.f36218a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36217a;
            }
        }

        static {
            FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto();
            DEFAULT_INSTANCE = fieldDescriptorProto;
            GeneratedMessageLite.S(FieldDescriptorProto.class, fieldDescriptorProto);
        }

        private FieldDescriptorProto() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldDescriptorProto();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u0011\u000b\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0005\u0003င\u0001\u0004᠌\u0002\u0005᠌\u0003\u0006ဈ\u0004\u0007ဈ\u0006\bᐉ\t\tင\u0007\nဈ\b\u0011ဇ\n", new Object[]{"bitField0_", "name_", "extendee_", "number_", "label_", Label.b(), "type_", Type.b(), "typeName_", "defaultValue_", "options_", "oneofIndex_", "jsonName_", "proto3Optional_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FieldDescriptorProto.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FieldDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FieldOptions extends GeneratedMessageLite.ExtendableMessage<FieldOptions, Builder> implements FieldOptionsOrBuilder {
        public static final int CTYPE_FIELD_NUMBER = 1;
        public static final int DEBUG_REDACT_FIELD_NUMBER = 16;
        private static final FieldOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int EDITION_DEFAULTS_FIELD_NUMBER = 20;
        public static final int FEATURES_FIELD_NUMBER = 21;
        public static final int FEATURE_SUPPORT_FIELD_NUMBER = 22;
        public static final int JSTYPE_FIELD_NUMBER = 6;
        public static final int LAZY_FIELD_NUMBER = 5;
        public static final int PACKED_FIELD_NUMBER = 2;
        private static volatile Parser<FieldOptions> PARSER = null;
        public static final int RETENTION_FIELD_NUMBER = 17;
        public static final int TARGETS_FIELD_NUMBER = 19;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int UNVERIFIED_LAZY_FIELD_NUMBER = 15;
        public static final int WEAK_FIELD_NUMBER = 10;
        private static final Internal.IntListAdapter.IntConverter<OptionTargetType> targets_converter_ = new Internal.IntListAdapter.IntConverter<OptionTargetType>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FieldOptions.1
            @Override // androidx.datastore.preferences.protobuf.Internal.IntListAdapter.IntConverter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public OptionTargetType a(int i3) {
                OptionTargetType optionTargetTypeA = OptionTargetType.a(i3);
                return optionTargetTypeA == null ? OptionTargetType.TARGET_TYPE_UNKNOWN : optionTargetTypeA;
            }
        };
        private int bitField0_;
        private int ctype_;
        private boolean debugRedact_;
        private boolean deprecated_;
        private FeatureSupport featureSupport_;
        private FeatureSet features_;
        private int jstype_;
        private boolean lazy_;
        private boolean packed_;
        private int retention_;
        private boolean unverifiedLazy_;
        private boolean weak_;
        private byte memoizedIsInitialized = 2;
        private Internal.IntList targets_ = GeneratedMessageLite.A();
        private Internal.ProtobufList<EditionDefault> editionDefaults_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(FieldOptions.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum CType implements Internal.EnumLite {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36222f = new Internal.EnumLiteMap<CType>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FieldOptions.CType.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public CType a(int i3) {
                    return CType.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36224a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class CTypeVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36225a = new CTypeVerifier();

                private CTypeVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return CType.a(i3) != null;
                }
            }

            CType(int i3) {
                this.f36224a = i3;
            }

            public static CType a(int i3) {
                if (i3 == 0) {
                    return STRING;
                }
                if (i3 == 1) {
                    return CORD;
                }
                if (i3 != 2) {
                    return null;
                }
                return STRING_PIECE;
            }

            public static Internal.EnumVerifier b() {
                return CTypeVerifier.f36225a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36224a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class EditionDefault extends GeneratedMessageLite<EditionDefault, Builder> implements EditionDefaultOrBuilder {
            private static final EditionDefault DEFAULT_INSTANCE;
            public static final int EDITION_FIELD_NUMBER = 3;
            private static volatile Parser<EditionDefault> PARSER = null;
            public static final int VALUE_FIELD_NUMBER = 2;
            private int bitField0_;
            private int edition_;
            private String value_ = "";

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class Builder extends GeneratedMessageLite.Builder<EditionDefault, Builder> implements EditionDefaultOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(EditionDefault.DEFAULT_INSTANCE);
                }
            }

            static {
                EditionDefault editionDefault = new EditionDefault();
                DEFAULT_INSTANCE = editionDefault;
                GeneratedMessageLite.S(EditionDefault.class, editionDefault);
            }

            private EditionDefault() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new EditionDefault();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002ဈ\u0001\u0003᠌\u0000", new Object[]{"bitField0_", "value_", "edition_", Edition.b()});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<EditionDefault> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (EditionDefault.class) {
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
        public interface EditionDefaultOrBuilder extends MessageLiteOrBuilder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class FeatureSupport extends GeneratedMessageLite<FeatureSupport, Builder> implements FeatureSupportOrBuilder {
            private static final FeatureSupport DEFAULT_INSTANCE;
            public static final int DEPRECATION_WARNING_FIELD_NUMBER = 3;
            public static final int EDITION_DEPRECATED_FIELD_NUMBER = 2;
            public static final int EDITION_INTRODUCED_FIELD_NUMBER = 1;
            public static final int EDITION_REMOVED_FIELD_NUMBER = 4;
            private static volatile Parser<FeatureSupport> PARSER;
            private int bitField0_;
            private String deprecationWarning_ = "";
            private int editionDeprecated_;
            private int editionIntroduced_;
            private int editionRemoved_;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class Builder extends GeneratedMessageLite.Builder<FeatureSupport, Builder> implements FeatureSupportOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(FeatureSupport.DEFAULT_INSTANCE);
                }
            }

            static {
                FeatureSupport featureSupport = new FeatureSupport();
                DEFAULT_INSTANCE = featureSupport;
                GeneratedMessageLite.S(FeatureSupport.class, featureSupport);
            }

            private FeatureSupport() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new FeatureSupport();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"bitField0_", "editionIntroduced_", Edition.b(), "editionDeprecated_", Edition.b(), "deprecationWarning_", "editionRemoved_", Edition.b()});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<FeatureSupport> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (FeatureSupport.class) {
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
        public interface FeatureSupportOrBuilder extends MessageLiteOrBuilder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum JSType implements Internal.EnumLite {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36229f = new Internal.EnumLiteMap<JSType>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FieldOptions.JSType.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public JSType a(int i3) {
                    return JSType.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36231a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class JSTypeVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36232a = new JSTypeVerifier();

                private JSTypeVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return JSType.a(i3) != null;
                }
            }

            JSType(int i3) {
                this.f36231a = i3;
            }

            public static JSType a(int i3) {
                if (i3 == 0) {
                    return JS_NORMAL;
                }
                if (i3 == 1) {
                    return JS_STRING;
                }
                if (i3 != 2) {
                    return null;
                }
                return JS_NUMBER;
            }

            public static Internal.EnumVerifier b() {
                return JSTypeVerifier.f36232a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36231a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum OptionRetention implements Internal.EnumLite {
            RETENTION_UNKNOWN(0),
            RETENTION_RUNTIME(1),
            RETENTION_SOURCE(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36236f = new Internal.EnumLiteMap<OptionRetention>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FieldOptions.OptionRetention.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public OptionRetention a(int i3) {
                    return OptionRetention.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36238a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class OptionRetentionVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36239a = new OptionRetentionVerifier();

                private OptionRetentionVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return OptionRetention.a(i3) != null;
                }
            }

            OptionRetention(int i3) {
                this.f36238a = i3;
            }

            public static OptionRetention a(int i3) {
                if (i3 == 0) {
                    return RETENTION_UNKNOWN;
                }
                if (i3 == 1) {
                    return RETENTION_RUNTIME;
                }
                if (i3 != 2) {
                    return null;
                }
                return RETENTION_SOURCE;
            }

            public static Internal.EnumVerifier b() {
                return OptionRetentionVerifier.f36239a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36238a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum OptionTargetType implements Internal.EnumLite {
            TARGET_TYPE_UNKNOWN(0),
            TARGET_TYPE_FILE(1),
            TARGET_TYPE_EXTENSION_RANGE(2),
            TARGET_TYPE_MESSAGE(3),
            TARGET_TYPE_FIELD(4),
            TARGET_TYPE_ONEOF(5),
            TARGET_TYPE_ENUM(6),
            TARGET_TYPE_ENUM_ENTRY(7),
            TARGET_TYPE_SERVICE(8),
            TARGET_TYPE_METHOD(9);


            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36250m = new Internal.EnumLiteMap<OptionTargetType>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FieldOptions.OptionTargetType.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public OptionTargetType a(int i3) {
                    return OptionTargetType.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36252a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class OptionTargetTypeVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36253a = new OptionTargetTypeVerifier();

                private OptionTargetTypeVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return OptionTargetType.a(i3) != null;
                }
            }

            OptionTargetType(int i3) {
                this.f36252a = i3;
            }

            public static OptionTargetType a(int i3) {
                switch (i3) {
                    case 0:
                        return TARGET_TYPE_UNKNOWN;
                    case 1:
                        return TARGET_TYPE_FILE;
                    case 2:
                        return TARGET_TYPE_EXTENSION_RANGE;
                    case 3:
                        return TARGET_TYPE_MESSAGE;
                    case 4:
                        return TARGET_TYPE_FIELD;
                    case 5:
                        return TARGET_TYPE_ONEOF;
                    case 6:
                        return TARGET_TYPE_ENUM;
                    case 7:
                        return TARGET_TYPE_ENUM_ENTRY;
                    case 8:
                        return TARGET_TYPE_SERVICE;
                    case 9:
                        return TARGET_TYPE_METHOD;
                    default:
                        return null;
                }
            }

            public static Internal.EnumVerifier b() {
                return OptionTargetTypeVerifier.f36253a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36252a;
            }
        }

        static {
            FieldOptions fieldOptions = new FieldOptions();
            DEFAULT_INSTANCE = fieldOptions;
            GeneratedMessageLite.S(FieldOptions.class, fieldOptions);
        }

        private FieldOptions() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u000e\u0000\u0001\u0001ϧ\u000e\u0000\u0003\u0002\u0001᠌\u0000\u0002ဇ\u0001\u0003ဇ\u0005\u0005ဇ\u0003\u0006᠌\u0002\nဇ\u0006\u000fဇ\u0004\u0010ဇ\u0007\u0011᠌\b\u0013ࠞ\u0014\u001b\u0015ᐉ\t\u0016ဉ\nϧЛ", new Object[]{"bitField0_", "ctype_", CType.b(), "packed_", "deprecated_", "lazy_", "jstype_", JSType.b(), "weak_", "unverifiedLazy_", "debugRedact_", "retention_", OptionRetention.b(), "targets_", OptionTargetType.b(), "editionDefaults_", EditionDefault.class, "features_", "featureSupport_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FieldOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FieldOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FieldOptions, FieldOptions.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FileDescriptorProto extends GeneratedMessageLite<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
        private static final FileDescriptorProto DEFAULT_INSTANCE;
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int EDITION_FIELD_NUMBER = 14;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        private static volatile Parser<FileDescriptorProto> PARSER = null;
        public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        public static final int SYNTAX_FIELD_NUMBER = 12;
        public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
        private int bitField0_;
        private int edition_;
        private FileOptions options_;
        private SourceCodeInfo sourceCodeInfo_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private String package_ = "";
        private Internal.ProtobufList<String> dependency_ = GeneratedMessageLite.B();
        private Internal.IntList publicDependency_ = GeneratedMessageLite.A();
        private Internal.IntList weakDependency_ = GeneratedMessageLite.A();
        private Internal.ProtobufList<DescriptorProto> messageType_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<ServiceDescriptorProto> service_ = GeneratedMessageLite.B();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = GeneratedMessageLite.B();
        private String syntax_ = "";

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(FileDescriptorProto.DEFAULT_INSTANCE);
            }
        }

        static {
            FileDescriptorProto fileDescriptorProto = new FileDescriptorProto();
            DEFAULT_INSTANCE = fileDescriptorProto;
            GeneratedMessageLite.S(FileDescriptorProto.class, fileDescriptorProto);
        }

        private FileDescriptorProto() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorProto();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\r\u0000\u0001\u0001\u000e\r\u0000\u0007\u0005\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004Л\u0005Л\u0006Л\u0007Л\bᐉ\u0002\tဉ\u0003\n\u0016\u000b\u0016\fဈ\u0004\u000e᠌\u0005", new Object[]{"bitField0_", "name_", "package_", "dependency_", "messageType_", DescriptorProto.class, "enumType_", EnumDescriptorProto.class, "service_", ServiceDescriptorProto.class, "extension_", FieldDescriptorProto.class, "options_", "sourceCodeInfo_", "publicDependency_", "weakDependency_", "syntax_", "edition_", Edition.b()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FileDescriptorProto.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FileDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FileDescriptorSet extends GeneratedMessageLite<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
        private static final FileDescriptorSet DEFAULT_INSTANCE;
        public static final int FILE_FIELD_NUMBER = 1;
        private static volatile Parser<FileDescriptorSet> PARSER;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<FileDescriptorProto> file_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(FileDescriptorSet.DEFAULT_INSTANCE);
            }
        }

        static {
            FileDescriptorSet fileDescriptorSet = new FileDescriptorSet();
            DEFAULT_INSTANCE = fileDescriptorSet;
            GeneratedMessageLite.S(FileDescriptorSet.class, fileDescriptorSet);
        }

        private FileDescriptorSet() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorSet();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"file_", FileDescriptorProto.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileDescriptorSet> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FileDescriptorSet.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FileDescriptorSetOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FileOptions extends GeneratedMessageLite.ExtendableMessage<FileOptions, Builder> implements FileOptionsOrBuilder {
        public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
        private static final FileOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 23;
        public static final int FEATURES_FIELD_NUMBER = 50;
        public static final int GO_PACKAGE_FIELD_NUMBER = 11;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
        public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        private static volatile Parser<FileOptions> PARSER = null;
        public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
        public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
        public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
        public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean ccGenericServices_;
        private boolean deprecated_;
        private FeatureSet features_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private boolean javaStringCheckUtf8_;
        private boolean pyGenericServices_;
        private byte memoizedIsInitialized = 2;
        private String javaPackage_ = "";
        private String javaOuterClassname_ = "";
        private int optimizeFor_ = 1;
        private String goPackage_ = "";
        private boolean ccEnableArenas_ = true;
        private String objcClassPrefix_ = "";
        private String csharpNamespace_ = "";
        private String swiftPrefix_ = "";
        private String phpClassPrefix_ = "";
        private String phpNamespace_ = "";
        private String phpMetadataNamespace_ = "";
        private String rubyPackage_ = "";
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(FileOptions.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum OptimizeMode implements Internal.EnumLite {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36257f = new Internal.EnumLiteMap<OptimizeMode>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.FileOptions.OptimizeMode.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public OptimizeMode a(int i3) {
                    return OptimizeMode.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36259a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class OptimizeModeVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36260a = new OptimizeModeVerifier();

                private OptimizeModeVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return OptimizeMode.a(i3) != null;
                }
            }

            OptimizeMode(int i3) {
                this.f36259a = i3;
            }

            public static OptimizeMode a(int i3) {
                if (i3 == 1) {
                    return SPEED;
                }
                if (i3 == 2) {
                    return CODE_SIZE;
                }
                if (i3 != 3) {
                    return null;
                }
                return LITE_RUNTIME;
            }

            public static Internal.EnumVerifier b() {
                return OptimizeModeVerifier.f36260a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36259a;
            }
        }

        static {
            FileOptions fileOptions = new FileOptions();
            DEFAULT_INSTANCE = fileOptions;
            GeneratedMessageLite.S(FileOptions.class, fileOptions);
        }

        private FileOptions() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0015\u0000\u0001\u0001ϧ\u0015\u0000\u0001\u0002\u0001ဈ\u0000\bဈ\u0001\t᠌\u0005\nဇ\u0002\u000bဈ\u0006\u0010ဇ\u0007\u0011ဇ\b\u0012ဇ\t\u0014ဇ\u0003\u0017ဇ\n\u001bဇ\u0004\u001fဇ\u000b$ဈ\f%ဈ\r'ဈ\u000e(ဈ\u000f)ဈ\u0010,ဈ\u0011-ဈ\u00122ᐉ\u0013ϧЛ", new Object[]{"bitField0_", "javaPackage_", "javaOuterClassname_", "optimizeFor_", OptimizeMode.b(), "javaMultipleFiles_", "goPackage_", "ccGenericServices_", "javaGenericServices_", "pyGenericServices_", "javaGenerateEqualsAndHash_", "deprecated_", "javaStringCheckUtf8_", "ccEnableArenas_", "objcClassPrefix_", "csharpNamespace_", "swiftPrefix_", "phpClassPrefix_", "phpNamespace_", "phpMetadataNamespace_", "rubyPackage_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FileOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FileOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FileOptions, FileOptions.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class GeneratedCodeInfo extends GeneratedMessageLite<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 1;
        private static final GeneratedCodeInfo DEFAULT_INSTANCE;
        private static volatile Parser<GeneratedCodeInfo> PARSER;
        private Internal.ProtobufList<Annotation> annotation_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Annotation extends GeneratedMessageLite<Annotation, Builder> implements AnnotationOrBuilder {
            public static final int BEGIN_FIELD_NUMBER = 3;
            private static final Annotation DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 4;
            private static volatile Parser<Annotation> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SEMANTIC_FIELD_NUMBER = 5;
            public static final int SOURCE_FILE_FIELD_NUMBER = 2;
            private int begin_;
            private int bitField0_;
            private int end_;
            private int semantic_;
            private int pathMemoizedSerializedSize = -1;
            private Internal.IntList path_ = GeneratedMessageLite.A();
            private String sourceFile_ = "";

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            /* JADX INFO: loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Annotation.DEFAULT_INSTANCE);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            /* JADX INFO: loaded from: classes3.dex */
            public enum Semantic implements Internal.EnumLite {
                NONE(0),
                SET(1),
                ALIAS(2);


                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private static final Internal.EnumLiteMap f36264f = new Internal.EnumLiteMap<Semantic>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation.Semantic.1
                    @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public Semantic a(int i3) {
                        return Semantic.a(i3);
                    }
                };

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final int f36266a;

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                private static final class SemanticVerifier implements Internal.EnumVerifier {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    static final Internal.EnumVerifier f36267a = new SemanticVerifier();

                    private SemanticVerifier() {
                    }

                    @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                    public boolean a(int i3) {
                        return Semantic.a(i3) != null;
                    }
                }

                Semantic(int i3) {
                    this.f36266a = i3;
                }

                public static Semantic a(int i3) {
                    if (i3 == 0) {
                        return NONE;
                    }
                    if (i3 == 1) {
                        return SET;
                    }
                    if (i3 != 2) {
                        return null;
                    }
                    return ALIAS;
                }

                public static Internal.EnumVerifier b() {
                    return SemanticVerifier.f36267a;
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
                public final int J() {
                    return this.f36266a;
                }
            }

            static {
                Annotation annotation = new Annotation();
                DEFAULT_INSTANCE = annotation;
                GeneratedMessageLite.S(Annotation.class, annotation);
            }

            private Annotation() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Annotation();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001'\u0002ဈ\u0000\u0003င\u0001\u0004င\u0002\u0005᠌\u0003", new Object[]{"bitField0_", "path_", "sourceFile_", "begin_", "end_", vfptEEmYY.oCLTfqcdcxUp, Semantic.b()});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Annotation> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Annotation.class) {
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
        /* JADX INFO: loaded from: classes3.dex */
        public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(GeneratedCodeInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            GeneratedCodeInfo generatedCodeInfo = new GeneratedCodeInfo();
            DEFAULT_INSTANCE = generatedCodeInfo;
            GeneratedMessageLite.S(GeneratedCodeInfo.class, generatedCodeInfo);
        }

        private GeneratedCodeInfo() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new GeneratedCodeInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{jTYhJgqLBN.CjGi, Annotation.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GeneratedCodeInfo> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (GeneratedCodeInfo.class) {
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
    public interface GeneratedCodeInfoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class MessageOptions extends GeneratedMessageLite.ExtendableMessage<MessageOptions, Builder> implements MessageOptionsOrBuilder {
        private static final MessageOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int DEPRECATED_LEGACY_JSON_FIELD_CONFLICTS_FIELD_NUMBER = 11;
        public static final int FEATURES_FIELD_NUMBER = 12;
        public static final int MAP_ENTRY_FIELD_NUMBER = 7;
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        private static volatile Parser<MessageOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecatedLegacyJsonFieldConflicts_;
        private boolean deprecated_;
        private FeatureSet features_;
        private boolean mapEntry_;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(MessageOptions.DEFAULT_INSTANCE);
            }
        }

        static {
            MessageOptions messageOptions = new MessageOptions();
            DEFAULT_INSTANCE = messageOptions;
            GeneratedMessageLite.S(MessageOptions.class, messageOptions);
        }

        private MessageOptions() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MessageOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001ϧ\u0007\u0000\u0001\u0002\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\u000bဇ\u0004\fᐉ\u0005ϧЛ", new Object[]{"bitField0_", "messageSetWireFormat_", "noStandardDescriptorAccessor_", "deprecated_", "mapEntry_", "deprecatedLegacyJsonFieldConflicts_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MessageOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MessageOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface MessageOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MessageOptions, MessageOptions.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class MethodDescriptorProto extends GeneratedMessageLite<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
        public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
        private static final MethodDescriptorProto DEFAULT_INSTANCE;
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static volatile Parser<MethodDescriptorProto> PARSER = null;
        public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
        private int bitField0_;
        private boolean clientStreaming_;
        private MethodOptions options_;
        private boolean serverStreaming_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private String inputType_ = "";
        private String outputType_ = "";

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(MethodDescriptorProto.DEFAULT_INSTANCE);
            }
        }

        static {
            MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto();
            DEFAULT_INSTANCE = methodDescriptorProto;
            GeneratedMessageLite.S(MethodDescriptorProto.class, methodDescriptorProto);
        }

        private MethodDescriptorProto() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodDescriptorProto();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ᐉ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "name_", "inputType_", "outputType_", "options_", "clientStreaming_", "serverStreaming_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MethodDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MethodDescriptorProto.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface MethodDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class MethodOptions extends GeneratedMessageLite.ExtendableMessage<MethodOptions, Builder> implements MethodOptionsOrBuilder {
        private static final MethodOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int FEATURES_FIELD_NUMBER = 35;
        public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
        private static volatile Parser<MethodOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private FeatureSet features_;
        private int idempotencyLevel_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(MethodOptions.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum IdempotencyLevel implements Internal.EnumLite {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);


            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final Internal.EnumLiteMap f36271f = new Internal.EnumLiteMap<IdempotencyLevel>() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel.1
                @Override // androidx.datastore.preferences.protobuf.Internal.EnumLiteMap
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public IdempotencyLevel a(int i3) {
                    return IdempotencyLevel.a(i3);
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f36273a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static final class IdempotencyLevelVerifier implements Internal.EnumVerifier {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final Internal.EnumVerifier f36274a = new IdempotencyLevelVerifier();

                private IdempotencyLevelVerifier() {
                }

                @Override // androidx.datastore.preferences.protobuf.Internal.EnumVerifier
                public boolean a(int i3) {
                    return IdempotencyLevel.a(i3) != null;
                }
            }

            IdempotencyLevel(int i3) {
                this.f36273a = i3;
            }

            public static IdempotencyLevel a(int i3) {
                if (i3 == 0) {
                    return IDEMPOTENCY_UNKNOWN;
                }
                if (i3 == 1) {
                    return NO_SIDE_EFFECTS;
                }
                if (i3 != 2) {
                    return null;
                }
                return IDEMPOTENT;
            }

            public static Internal.EnumVerifier b() {
                return IdempotencyLevelVerifier.f36274a;
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.EnumLite
            public final int J() {
                return this.f36273a;
            }
        }

        static {
            MethodOptions methodOptions = new MethodOptions();
            DEFAULT_INSTANCE = methodOptions;
            GeneratedMessageLite.S(MethodOptions.class, methodOptions);
        }

        private MethodOptions() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001!ϧ\u0004\u0000\u0001\u0002!ဇ\u0000\"᠌\u0001#ᐉ\u0002ϧЛ", new Object[]{"bitField0_", "deprecated_", "idempotencyLevel_", IdempotencyLevel.b(), "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MethodOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MethodOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface MethodOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MethodOptions, MethodOptions.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class OneofDescriptorProto extends GeneratedMessageLite<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
        private static final OneofDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 2;
        private static volatile Parser<OneofDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private OneofOptions options_;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(OneofDescriptorProto.DEFAULT_INSTANCE);
            }
        }

        static {
            OneofDescriptorProto oneofDescriptorProto = new OneofDescriptorProto();
            DEFAULT_INSTANCE = oneofDescriptorProto;
            GeneratedMessageLite.S(OneofDescriptorProto.class, oneofDescriptorProto);
        }

        private OneofDescriptorProto() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofDescriptorProto();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "name_", "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OneofDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (OneofDescriptorProto.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OneofDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class OneofOptions extends GeneratedMessageLite.ExtendableMessage<OneofOptions, Builder> implements OneofOptionsOrBuilder {
        private static final OneofOptions DEFAULT_INSTANCE;
        public static final int FEATURES_FIELD_NUMBER = 1;
        private static volatile Parser<OneofOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<OneofOptions, Builder> implements OneofOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(OneofOptions.DEFAULT_INSTANCE);
            }
        }

        static {
            OneofOptions oneofOptions = new OneofOptions();
            DEFAULT_INSTANCE = oneofOptions;
            GeneratedMessageLite.S(OneofOptions.class, oneofOptions);
        }

        private OneofOptions() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001ϧ\u0002\u0000\u0001\u0002\u0001ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OneofOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (OneofOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OneofOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<OneofOptions, OneofOptions.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ServiceDescriptorProto extends GeneratedMessageLite<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
        private static final ServiceDescriptorProto DEFAULT_INSTANCE;
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<ServiceDescriptorProto> PARSER;
        private int bitField0_;
        private ServiceOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<MethodDescriptorProto> method_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ServiceDescriptorProto.DEFAULT_INSTANCE);
            }
        }

        static {
            ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto();
            DEFAULT_INSTANCE = serviceDescriptorProto;
            GeneratedMessageLite.S(ServiceDescriptorProto.class, serviceDescriptorProto);
        }

        private ServiceDescriptorProto() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceDescriptorProto();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001", new Object[]{"bitField0_", "name_", "method_", MethodDescriptorProto.class, "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ServiceDescriptorProto> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ServiceDescriptorProto.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ServiceDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ServiceOptions extends GeneratedMessageLite.ExtendableMessage<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
        private static final ServiceOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int FEATURES_FIELD_NUMBER = 34;
        private static volatile Parser<ServiceOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private FeatureSet features_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ServiceOptions.DEFAULT_INSTANCE);
            }
        }

        static {
            ServiceOptions serviceOptions = new ServiceOptions();
            DEFAULT_INSTANCE = serviceOptions;
            GeneratedMessageLite.S(ServiceOptions.class, serviceOptions);
        }

        private ServiceOptions() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001!ϧ\u0003\u0000\u0001\u0002!ဇ\u0001\"ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "deprecated_", "features_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ServiceOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ServiceOptions.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ServiceOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ServiceOptions, ServiceOptions.Builder> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SourceCodeInfo extends GeneratedMessageLite<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
        private static final SourceCodeInfo DEFAULT_INSTANCE;
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static volatile Parser<SourceCodeInfo> PARSER;
        private Internal.ProtobufList<Location> location_ = GeneratedMessageLite.B();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SourceCodeInfo.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Location extends GeneratedMessageLite<Location, Builder> implements LocationOrBuilder {
            private static final Location DEFAULT_INSTANCE;
            public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
            public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
            private static volatile Parser<Location> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
            private int bitField0_;
            private int pathMemoizedSerializedSize = -1;
            private int spanMemoizedSerializedSize = -1;
            private Internal.IntList path_ = GeneratedMessageLite.A();
            private Internal.IntList span_ = GeneratedMessageLite.A();
            private String leadingComments_ = "";
            private String trailingComments_ = "";
            private Internal.ProtobufList<String> leadingDetachedComments_ = GeneratedMessageLite.B();

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class Builder extends GeneratedMessageLite.Builder<Location, Builder> implements LocationOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Location.DEFAULT_INSTANCE);
                }
            }

            static {
                Location location = new Location();
                DEFAULT_INSTANCE = location;
                GeneratedMessageLite.S(Location.class, location);
            }

            private Location() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Location();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0003\u0000\u0001'\u0002'\u0003ဈ\u0000\u0004ဈ\u0001\u0006\u001a", new Object[]{"bitField0_", "path_", "span_", "leadingComments_", "trailingComments_", "leadingDetachedComments_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Location> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Location.class) {
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
        public interface LocationOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            SourceCodeInfo sourceCodeInfo = new SourceCodeInfo();
            DEFAULT_INSTANCE = sourceCodeInfo;
            GeneratedMessageLite.S(SourceCodeInfo.class, sourceCodeInfo);
        }

        private SourceCodeInfo() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new SourceCodeInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"location_", Location.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SourceCodeInfo> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SourceCodeInfo.class) {
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
    public interface SourceCodeInfoOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UninterpretedOption extends GeneratedMessageLite<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        private static final UninterpretedOption DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        private static volatile Parser<UninterpretedOption> PARSER = null;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private int bitField0_;
        private double doubleValue_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<NamePart> name_ = GeneratedMessageLite.B();
        private String identifierValue_ = "";
        private ByteString stringValue_ = ByteString.f36020b;
        private String aggregateValue_ = "";

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(UninterpretedOption.DEFAULT_INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class NamePart extends GeneratedMessageLite<NamePart, Builder> implements NamePartOrBuilder {
            private static final NamePart DEFAULT_INSTANCE;
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static volatile Parser<NamePart> PARSER;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized = 2;
            private String namePart_ = "";

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            public static final class Builder extends GeneratedMessageLite.Builder<NamePart, Builder> implements NamePartOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(NamePart.DEFAULT_INSTANCE);
                }
            }

            static {
                NamePart namePart = new NamePart();
                DEFAULT_INSTANCE = namePart;
                GeneratedMessageLite.S(NamePart.class, namePart);
            }

            private NamePart() {
            }

            @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
            protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new NamePart();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"bitField0_", "namePart_", "isExtension_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<NamePart> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (NamePart.class) {
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
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface NamePartOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            UninterpretedOption uninterpretedOption = new UninterpretedOption();
            DEFAULT_INSTANCE = uninterpretedOption;
            GeneratedMessageLite.S(UninterpretedOption.class, uninterpretedOption);
        }

        private UninterpretedOption() {
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f36124a[methodToInvoke.ordinal()]) {
                case 1:
                    return new UninterpretedOption();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.N(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"bitField0_", "name_", NamePart.class, "identifierValue_", "positiveIntValue_", "negativeIntValue_", "doubleValue_", "stringValue_", "aggregateValue_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UninterpretedOption> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (UninterpretedOption.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface UninterpretedOptionOrBuilder extends MessageLiteOrBuilder {
    }
}
