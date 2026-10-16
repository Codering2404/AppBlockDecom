package androidx.glance.appwidget.proto;

import androidx.glance.appwidget.protobuf.AbstractMessageLite;
import androidx.glance.appwidget.protobuf.GeneratedMessageLite;
import androidx.glance.appwidget.protobuf.Internal;
import androidx.glance.appwidget.protobuf.MessageLiteOrBuilder;
import androidx.glance.appwidget.protobuf.Parser;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LayoutProto {

    /* JADX INFO: renamed from: androidx.glance.appwidget.proto.LayoutProto$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f38698a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f38698a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38698a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38698a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38698a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38698a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38698a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38698a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ContentScale implements Internal.EnumLite {
        UNSPECIFIED_CONTENT_SCALE(0),
        FIT(1),
        CROP(2),
        FILL_BOUNDS(3),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Internal.EnumLiteMap f38704h = new Internal.EnumLiteMap<ContentScale>() { // from class: androidx.glance.appwidget.proto.LayoutProto.ContentScale.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ContentScale a(int i3) {
                return ContentScale.b(i3);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38706a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class ContentScaleVerifier implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f38707a = new ContentScaleVerifier();

            private ContentScaleVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean a(int i3) {
                return ContentScale.b(i3) != null;
            }
        }

        ContentScale(int i3) {
            this.f38706a = i3;
        }

        public static ContentScale b(int i3) {
            if (i3 == 0) {
                return UNSPECIFIED_CONTENT_SCALE;
            }
            if (i3 == 1) {
                return FIT;
            }
            if (i3 == 2) {
                return CROP;
            }
            if (i3 != 3) {
                return null;
            }
            return FILL_BOUNDS;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int J() {
            if (this != UNRECOGNIZED) {
                return this.f38706a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum DimensionType implements Internal.EnumLite {
        UNKNOWN_DIMENSION_TYPE(0),
        EXACT(1),
        WRAP(2),
        FILL(3),
        EXPAND(4),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final Internal.EnumLiteMap f38714i = new Internal.EnumLiteMap<DimensionType>() { // from class: androidx.glance.appwidget.proto.LayoutProto.DimensionType.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public DimensionType a(int i3) {
                return DimensionType.b(i3);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38716a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class DimensionTypeVerifier implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f38717a = new DimensionTypeVerifier();

            private DimensionTypeVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean a(int i3) {
                return DimensionType.b(i3) != null;
            }
        }

        DimensionType(int i3) {
            this.f38716a = i3;
        }

        public static DimensionType b(int i3) {
            if (i3 == 0) {
                return UNKNOWN_DIMENSION_TYPE;
            }
            if (i3 == 1) {
                return EXACT;
            }
            if (i3 == 2) {
                return WRAP;
            }
            if (i3 == 3) {
                return FILL;
            }
            if (i3 != 4) {
                return null;
            }
            return EXPAND;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int J() {
            if (this != UNRECOGNIZED) {
                return this.f38716a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum HorizontalAlignment implements Internal.EnumLite {
        UNSPECIFIED_HORIZONTAL_ALIGNMENT(0),
        START(1),
        CENTER_HORIZONTALLY(2),
        END(3),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Internal.EnumLiteMap f38723h = new Internal.EnumLiteMap<HorizontalAlignment>() { // from class: androidx.glance.appwidget.proto.LayoutProto.HorizontalAlignment.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public HorizontalAlignment a(int i3) {
                return HorizontalAlignment.b(i3);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38725a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class HorizontalAlignmentVerifier implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f38726a = new HorizontalAlignmentVerifier();

            private HorizontalAlignmentVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean a(int i3) {
                return HorizontalAlignment.b(i3) != null;
            }
        }

        HorizontalAlignment(int i3) {
            this.f38725a = i3;
        }

        public static HorizontalAlignment b(int i3) {
            if (i3 == 0) {
                return UNSPECIFIED_HORIZONTAL_ALIGNMENT;
            }
            if (i3 == 1) {
                return START;
            }
            if (i3 == 2) {
                return CENTER_HORIZONTALLY;
            }
            if (i3 != 3) {
                return null;
            }
            return END;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int J() {
            if (this != UNRECOGNIZED) {
                return this.f38725a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LayoutConfig extends GeneratedMessageLite<LayoutConfig, Builder> implements LayoutConfigOrBuilder {
        private static final LayoutConfig DEFAULT_INSTANCE;
        public static final int LAYOUT_FIELD_NUMBER = 1;
        public static final int NEXT_INDEX_FIELD_NUMBER = 2;
        private static volatile Parser<LayoutConfig> PARSER;
        private Internal.ProtobufList<LayoutDefinition> layout_ = GeneratedMessageLite.A();
        private int nextIndex_;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<LayoutConfig, Builder> implements LayoutConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder K(LayoutDefinition.Builder builder) {
                z();
                ((LayoutConfig) this.f39054b).X((LayoutDefinition) builder.build());
                return this;
            }

            public Builder L() {
                z();
                ((LayoutConfig) this.f39054b).Y();
                return this;
            }

            public int M() {
                return ((LayoutConfig) this.f39054b).c0();
            }

            public Builder N(int i3) {
                z();
                ((LayoutConfig) this.f39054b).e0(i3);
                return this;
            }

            private Builder() {
                super(LayoutConfig.DEFAULT_INSTANCE);
            }
        }

        static {
            LayoutConfig layoutConfig = new LayoutConfig();
            DEFAULT_INSTANCE = layoutConfig;
            GeneratedMessageLite.Q(LayoutConfig.class, layoutConfig);
        }

        private LayoutConfig() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X(LayoutDefinition layoutDefinition) {
            layoutDefinition.getClass();
            Z();
            this.layout_.add(layoutDefinition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y() {
            this.layout_ = GeneratedMessageLite.A();
        }

        private void Z() {
            Internal.ProtobufList<LayoutDefinition> protobufList = this.layout_;
            if (protobufList.m()) {
                return;
            }
            this.layout_ = GeneratedMessageLite.K(protobufList);
        }

        public static LayoutConfig a0() {
            return DEFAULT_INSTANCE;
        }

        public static LayoutConfig d0(InputStream inputStream) {
            return (LayoutConfig) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e0(int i3) {
            this.nextIndex_ = i3;
        }

        public List b0() {
            return this.layout_;
        }

        public int c0() {
            return this.nextIndex_;
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f38698a[methodToInvoke.ordinal()]) {
                case 1:
                    return new LayoutConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"layout_", LayoutDefinition.class, "nextIndex_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LayoutConfig> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LayoutConfig.class) {
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
    public interface LayoutConfigOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LayoutDefinition extends GeneratedMessageLite<LayoutDefinition, Builder> implements LayoutDefinitionOrBuilder {
        private static final LayoutDefinition DEFAULT_INSTANCE;
        public static final int LAYOUT_FIELD_NUMBER = 1;
        public static final int LAYOUT_INDEX_FIELD_NUMBER = 2;
        private static volatile Parser<LayoutDefinition> PARSER;
        private int layoutIndex_;
        private LayoutNode layout_;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<LayoutDefinition, Builder> implements LayoutDefinitionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder K(LayoutNode layoutNode) {
                z();
                ((LayoutDefinition) this.f39054b).Z(layoutNode);
                return this;
            }

            public Builder L(int i3) {
                z();
                ((LayoutDefinition) this.f39054b).a0(i3);
                return this;
            }

            private Builder() {
                super(LayoutDefinition.DEFAULT_INSTANCE);
            }
        }

        static {
            LayoutDefinition layoutDefinition = new LayoutDefinition();
            DEFAULT_INSTANCE = layoutDefinition;
            GeneratedMessageLite.Q(LayoutDefinition.class, layoutDefinition);
        }

        private LayoutDefinition() {
        }

        public static Builder Y() {
            return (Builder) DEFAULT_INSTANCE.w();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z(LayoutNode layoutNode) {
            layoutNode.getClass();
            this.layout_ = layoutNode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a0(int i3) {
            this.layoutIndex_ = i3;
        }

        public LayoutNode W() {
            LayoutNode layoutNode = this.layout_;
            return layoutNode == null ? LayoutNode.g0() : layoutNode;
        }

        public int X() {
            return this.layoutIndex_;
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f38698a[methodToInvoke.ordinal()]) {
                case 1:
                    return new LayoutDefinition();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u0004", new Object[]{"layout_", "layoutIndex_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LayoutDefinition> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LayoutDefinition.class) {
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
    public interface LayoutDefinitionOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LayoutNode extends GeneratedMessageLite<LayoutNode, Builder> implements LayoutNodeOrBuilder {
        public static final int CHILDREN_FIELD_NUMBER = 7;
        private static final LayoutNode DEFAULT_INSTANCE;
        public static final int HASACTION_FIELD_NUMBER = 9;
        public static final int HAS_IMAGE_DESCRIPTION_FIELD_NUMBER = 10;
        public static final int HEIGHT_FIELD_NUMBER = 3;
        public static final int HORIZONTAL_ALIGNMENT_FIELD_NUMBER = 4;
        public static final int IDENTITY_FIELD_NUMBER = 8;
        public static final int IMAGE_SCALE_FIELD_NUMBER = 6;
        private static volatile Parser<LayoutNode> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VERTICAL_ALIGNMENT_FIELD_NUMBER = 5;
        public static final int WIDTH_FIELD_NUMBER = 2;
        private Internal.ProtobufList<LayoutNode> children_ = GeneratedMessageLite.A();
        private boolean hasAction_;
        private boolean hasImageDescription_;
        private int height_;
        private int horizontalAlignment_;
        private int identity_;
        private int imageScale_;
        private int type_;
        private int verticalAlignment_;
        private int width_;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Builder extends GeneratedMessageLite.Builder<LayoutNode, Builder> implements LayoutNodeOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder K(Iterable iterable) {
                z();
                ((LayoutNode) this.f39054b).e0(iterable);
                return this;
            }

            public Builder L(boolean z2) {
                z();
                ((LayoutNode) this.f39054b).i0(z2);
                return this;
            }

            public Builder M(boolean z2) {
                z();
                ((LayoutNode) this.f39054b).j0(z2);
                return this;
            }

            public Builder N(DimensionType dimensionType) {
                z();
                ((LayoutNode) this.f39054b).k0(dimensionType);
                return this;
            }

            public Builder O(HorizontalAlignment horizontalAlignment) {
                z();
                ((LayoutNode) this.f39054b).l0(horizontalAlignment);
                return this;
            }

            public Builder P(NodeIdentity nodeIdentity) {
                z();
                ((LayoutNode) this.f39054b).m0(nodeIdentity);
                return this;
            }

            public Builder Q(ContentScale contentScale) {
                z();
                ((LayoutNode) this.f39054b).n0(contentScale);
                return this;
            }

            public Builder R(LayoutType layoutType) {
                z();
                ((LayoutNode) this.f39054b).o0(layoutType);
                return this;
            }

            public Builder S(VerticalAlignment verticalAlignment) {
                z();
                ((LayoutNode) this.f39054b).p0(verticalAlignment);
                return this;
            }

            public Builder U(DimensionType dimensionType) {
                z();
                ((LayoutNode) this.f39054b).q0(dimensionType);
                return this;
            }

            private Builder() {
                super(LayoutNode.DEFAULT_INSTANCE);
            }
        }

        static {
            LayoutNode layoutNode = new LayoutNode();
            DEFAULT_INSTANCE = layoutNode;
            GeneratedMessageLite.Q(LayoutNode.class, layoutNode);
        }

        private LayoutNode() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e0(Iterable iterable) {
            f0();
            AbstractMessageLite.d(iterable, this.children_);
        }

        private void f0() {
            Internal.ProtobufList<LayoutNode> protobufList = this.children_;
            if (protobufList.m()) {
                return;
            }
            this.children_ = GeneratedMessageLite.K(protobufList);
        }

        public static LayoutNode g0() {
            return DEFAULT_INSTANCE;
        }

        public static Builder h0() {
            return (Builder) DEFAULT_INSTANCE.w();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i0(boolean z2) {
            this.hasAction_ = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j0(boolean z2) {
            this.hasImageDescription_ = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0(DimensionType dimensionType) {
            this.height_ = dimensionType.J();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(HorizontalAlignment horizontalAlignment) {
            this.horizontalAlignment_ = horizontalAlignment.J();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(NodeIdentity nodeIdentity) {
            this.identity_ = nodeIdentity.J();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(ContentScale contentScale) {
            this.imageScale_ = contentScale.J();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(LayoutType layoutType) {
            this.type_ = layoutType.J();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(VerticalAlignment verticalAlignment) {
            this.verticalAlignment_ = verticalAlignment.J();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(DimensionType dimensionType) {
            this.width_ = dimensionType.J();
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite
        protected final Object z(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f38698a[methodToInvoke.ordinal()]) {
                case 1:
                    return new LayoutNode();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\f\u0004\f\u0005\f\u0006\f\u0007\u001b\b\f\t\u0007\n\u0007", new Object[]{"type_", "width_", "height_", "horizontalAlignment_", "verticalAlignment_", "imageScale_", "children_", LayoutNode.class, "identity_", "hasAction_", "hasImageDescription_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LayoutNode> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LayoutNode.class) {
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
    public interface LayoutNodeOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LayoutType implements Internal.EnumLite {
        UNKNOWN_TYPE(0),
        ROW(1),
        COLUMN(2),
        BOX(3),
        TEXT(4),
        LAZY_COLUMN(5),
        LIST_ITEM(6),
        CHECK_BOX(7),
        BUTTON(8),
        SPACER(9),
        SWITCH(10),
        ANDROID_REMOTE_VIEWS(11),
        REMOTE_VIEWS_ROOT(12),
        IMAGE(13),
        LINEAR_PROGRESS_INDICATOR(14),
        CIRCULAR_PROGRESS_INDICATOR(15),
        LAZY_VERTICAL_GRID(16),
        VERTICAL_GRID_ITEM(17),
        RADIO_GROUP(18),
        RADIO_BUTTON(19),
        RADIO_ROW(20),
        RADIO_COLUMN(21),
        SIZE_BOX(22),
        UNRECOGNIZED(-1);

        private static final Internal.EnumLiteMap A = new Internal.EnumLiteMap<LayoutType>() { // from class: androidx.glance.appwidget.proto.LayoutProto.LayoutType.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutType a(int i3) {
                return LayoutType.b(i3);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38751a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class LayoutTypeVerifier implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f38752a = new LayoutTypeVerifier();

            private LayoutTypeVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean a(int i3) {
                return LayoutType.b(i3) != null;
            }
        }

        LayoutType(int i3) {
            this.f38751a = i3;
        }

        public static LayoutType b(int i3) {
            switch (i3) {
                case 0:
                    return UNKNOWN_TYPE;
                case 1:
                    return ROW;
                case 2:
                    return COLUMN;
                case 3:
                    return BOX;
                case 4:
                    return TEXT;
                case 5:
                    return LAZY_COLUMN;
                case 6:
                    return LIST_ITEM;
                case 7:
                    return CHECK_BOX;
                case 8:
                    return BUTTON;
                case 9:
                    return SPACER;
                case 10:
                    return SWITCH;
                case 11:
                    return ANDROID_REMOTE_VIEWS;
                case 12:
                    return REMOTE_VIEWS_ROOT;
                case 13:
                    return IMAGE;
                case 14:
                    return LINEAR_PROGRESS_INDICATOR;
                case 15:
                    return CIRCULAR_PROGRESS_INDICATOR;
                case 16:
                    return LAZY_VERTICAL_GRID;
                case 17:
                    return VERTICAL_GRID_ITEM;
                case 18:
                    return RADIO_GROUP;
                case 19:
                    return RADIO_BUTTON;
                case 20:
                    return RADIO_ROW;
                case 21:
                    return RADIO_COLUMN;
                case 22:
                    return SIZE_BOX;
                default:
                    return null;
            }
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int J() {
            if (this != UNRECOGNIZED) {
                return this.f38751a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum NodeIdentity implements Internal.EnumLite {
        DEFAULT_IDENTITY(0),
        BACKGROUND_NODE(1),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Internal.EnumLiteMap f38756f = new Internal.EnumLiteMap<NodeIdentity>() { // from class: androidx.glance.appwidget.proto.LayoutProto.NodeIdentity.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public NodeIdentity a(int i3) {
                return NodeIdentity.b(i3);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38758a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class NodeIdentityVerifier implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f38759a = new NodeIdentityVerifier();

            private NodeIdentityVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean a(int i3) {
                return NodeIdentity.b(i3) != null;
            }
        }

        NodeIdentity(int i3) {
            this.f38758a = i3;
        }

        public static NodeIdentity b(int i3) {
            if (i3 == 0) {
                return DEFAULT_IDENTITY;
            }
            if (i3 != 1) {
                return null;
            }
            return BACKGROUND_NODE;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int J() {
            if (this != UNRECOGNIZED) {
                return this.f38758a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum VerticalAlignment implements Internal.EnumLite {
        UNSPECIFIED_VERTICAL_ALIGNMENT(0),
        TOP(1),
        CENTER_VERTICALLY(2),
        BOTTOM(3),
        UNRECOGNIZED(-1);


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Internal.EnumLiteMap f38765h = new Internal.EnumLiteMap<VerticalAlignment>() { // from class: androidx.glance.appwidget.proto.LayoutProto.VerticalAlignment.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public VerticalAlignment a(int i3) {
                return VerticalAlignment.b(i3);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38767a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class VerticalAlignmentVerifier implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f38768a = new VerticalAlignmentVerifier();

            private VerticalAlignmentVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean a(int i3) {
                return VerticalAlignment.b(i3) != null;
            }
        }

        VerticalAlignment(int i3) {
            this.f38767a = i3;
        }

        public static VerticalAlignment b(int i3) {
            if (i3 == 0) {
                return UNSPECIFIED_VERTICAL_ALIGNMENT;
            }
            if (i3 == 1) {
                return TOP;
            }
            if (i3 == 2) {
                return CENTER_VERTICALLY;
            }
            if (i3 != 3) {
                return null;
            }
            return BOTTOM;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int J() {
            if (this != UNRECOGNIZED) {
                return this.f38767a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }
}
