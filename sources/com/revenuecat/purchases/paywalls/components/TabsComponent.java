package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@SerialName
@Metadata
@Serializable
public final class TabsComponent implements PaywallComponent {
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Border border;
    private final TabControl control;
    private final String defaultTabId;
    private final Padding margin;
    private final String name;
    private final List<ComponentOverride<PartialTabsComponent>> overrides;
    private final Padding padding;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final List<Tab> tabs;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.TabsComponent.TabControl", Reflection.b(TabControl.class), new KClass[]{Reflection.b(TabControl.Buttons.class), Reflection.b(TabControl.Toggle.class)}, new KSerializer[]{TabsComponent$TabControl$Buttons$$serializer.INSTANCE, TabsComponent$TabControl$Toggle$$serializer.INSTANCE}, new Annotation[0]), new ArrayListSerializer(TabsComponent$Tab$$serializer.INSTANCE), null, new ArrayListSerializer(ComponentOverride.Companion.serializer(PartialTabsComponent$$serializer.INSTANCE))};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TabsComponent> serializer() {
            return TabsComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Tab {
        public static final Companion Companion = new Companion(null);
        private final String id;
        private final String name;
        private final StackComponent stack;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Tab> serializer() {
                return TabsComponent$Tab$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ Tab(int i3, String str, String str2, StackComponent stackComponent, SerializationConstructorMarker serializationConstructorMarker) {
            if (5 != (i3 & 5)) {
                PluginExceptionsKt.b(i3, 5, TabsComponent$Tab$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            if ((i3 & 2) == 0) {
                this.name = null;
            } else {
                this.name = str2;
            }
            this.stack = stackComponent;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Tab tab, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.y(serialDescriptor, 0, tab.id);
            if (compositeEncoder.z(serialDescriptor, 1) || tab.name != null) {
                compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, tab.name);
            }
            compositeEncoder.C(serialDescriptor, 2, StackComponent$$serializer.INSTANCE, tab.stack);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Tab)) {
                return false;
            }
            Tab tab = (Tab) obj;
            return Intrinsics.areEqual(this.id, tab.id) && Intrinsics.areEqual(this.name, tab.name) && Intrinsics.areEqual(this.stack, tab.stack);
        }

        public final /* synthetic */ String getId() {
            return this.id;
        }

        public final /* synthetic */ String getName() {
            return this.name;
        }

        public final /* synthetic */ StackComponent getStack() {
            return this.stack;
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stack.hashCode();
        }

        public String toString() {
            return "Tab(id=" + this.id + ", name=" + this.name + ", stack=" + this.stack + ')';
        }

        public Tab(String id, String str, StackComponent stack) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(stack, "stack");
            this.id = id;
            this.name = str;
            this.stack = stack;
        }

        public /* synthetic */ Tab(String str, String str2, StackComponent stackComponent, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : str2, stackComponent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public interface TabControl {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        @SerialName
        public static final class Buttons implements TabControl {
            public static final Companion Companion = new Companion(null);
            private final StackComponent stack;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Buttons> serializer() {
                    return TabsComponent$TabControl$Buttons$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Buttons(int i3, StackComponent stackComponent, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, TabsComponent$TabControl$Buttons$$serializer.INSTANCE.getDescriptor());
                }
                this.stack = stackComponent;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Buttons) && Intrinsics.areEqual(this.stack, ((Buttons) obj).stack);
            }

            public final /* synthetic */ StackComponent getStack() {
                return this.stack;
            }

            public int hashCode() {
                return this.stack.hashCode();
            }

            public String toString() {
                return "Buttons(stack=" + this.stack + ')';
            }

            public Buttons(StackComponent stack) {
                Intrinsics.checkNotNullParameter(stack, "stack");
                this.stack = stack;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<TabControl> serializer() {
                return new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.TabsComponent.TabControl", Reflection.b(TabControl.class), new KClass[]{Reflection.b(Buttons.class), Reflection.b(Toggle.class)}, new KSerializer[]{TabsComponent$TabControl$Buttons$$serializer.INSTANCE, TabsComponent$TabControl$Toggle$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        @SerialName
        public static final class Toggle implements TabControl {
            public static final Companion Companion = new Companion(null);
            private final StackComponent stack;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Toggle> serializer() {
                    return TabsComponent$TabControl$Toggle$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            @Deprecated
            public /* synthetic */ Toggle(int i3, StackComponent stackComponent, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, TabsComponent$TabControl$Toggle$$serializer.INSTANCE.getDescriptor());
                }
                this.stack = stackComponent;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Toggle) && Intrinsics.areEqual(this.stack, ((Toggle) obj).stack);
            }

            public final /* synthetic */ StackComponent getStack() {
                return this.stack;
            }

            public int hashCode() {
                return this.stack.hashCode();
            }

            public String toString() {
                return "Toggle(stack=" + this.stack + ')';
            }

            public Toggle(StackComponent stack) {
                Intrinsics.checkNotNullParameter(stack, "stack");
                this.stack = stack;
            }
        }
    }

    @Deprecated
    public /* synthetic */ TabsComponent(int i3, String str, Boolean bool, Size size, Padding padding, Padding padding2, @SerialName ColorScheme colorScheme, Background background, Shape shape, Border border, Shadow shadow, TabControl tabControl, List list, @SerialName String str2, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3072 != (i3 & 3072)) {
            PluginExceptionsKt.b(i3, 3072, TabsComponent$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        if ((i3 & 2) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 4) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i3 & 8) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i3 & 16) == 0) {
            this.margin = Padding.Companion.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i3 & 32) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i3 & 64) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i3 & 512) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        this.control = tabControl;
        this.tabs = list;
        if ((i3 & 4096) == 0) {
            this.defaultTabId = null;
        } else {
            this.defaultTabId = str2;
        }
        this.overrides = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? CollectionsKt.emptyList() : list2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TabsComponent tabsComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (compositeEncoder.z(serialDescriptor, 0) || tabsComponent.name != null) {
            compositeEncoder.i(serialDescriptor, 0, StringSerializer.f142891a, tabsComponent.name);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || tabsComponent.visible != null) {
            compositeEncoder.i(serialDescriptor, 1, BooleanSerializer.f142767a, tabsComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || !Intrinsics.areEqual(tabsComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            compositeEncoder.C(serialDescriptor, 2, Size$$serializer.INSTANCE, tabsComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || !Intrinsics.areEqual(tabsComponent.padding, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 3, Padding$$serializer.INSTANCE, tabsComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || !Intrinsics.areEqual(tabsComponent.margin, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 4, Padding$$serializer.INSTANCE, tabsComponent.margin);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || tabsComponent.backgroundColor != null) {
            compositeEncoder.i(serialDescriptor, 5, ColorScheme$$serializer.INSTANCE, tabsComponent.backgroundColor);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || tabsComponent.background != null) {
            compositeEncoder.i(serialDescriptor, 6, BackgroundDeserializer.INSTANCE, tabsComponent.background);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || tabsComponent.shape != null) {
            compositeEncoder.i(serialDescriptor, 7, ShapeDeserializer.INSTANCE, tabsComponent.shape);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || tabsComponent.border != null) {
            compositeEncoder.i(serialDescriptor, 8, Border$$serializer.INSTANCE, tabsComponent.border);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || tabsComponent.shadow != null) {
            compositeEncoder.i(serialDescriptor, 9, Shadow$$serializer.INSTANCE, tabsComponent.shadow);
        }
        compositeEncoder.C(serialDescriptor, 10, kSerializerArr[10], tabsComponent.control);
        compositeEncoder.C(serialDescriptor, 11, kSerializerArr[11], tabsComponent.tabs);
        if (compositeEncoder.z(serialDescriptor, 12) || tabsComponent.defaultTabId != null) {
            compositeEncoder.i(serialDescriptor, 12, StringSerializer.f142891a, tabsComponent.defaultTabId);
        }
        if (!compositeEncoder.z(serialDescriptor, 13) && Intrinsics.areEqual(tabsComponent.overrides, CollectionsKt.emptyList())) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 13, kSerializerArr[13], tabsComponent.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabsComponent)) {
            return false;
        }
        TabsComponent tabsComponent = (TabsComponent) obj;
        return Intrinsics.areEqual(this.name, tabsComponent.name) && Intrinsics.areEqual(this.visible, tabsComponent.visible) && Intrinsics.areEqual(this.size, tabsComponent.size) && Intrinsics.areEqual(this.padding, tabsComponent.padding) && Intrinsics.areEqual(this.margin, tabsComponent.margin) && Intrinsics.areEqual(this.backgroundColor, tabsComponent.backgroundColor) && Intrinsics.areEqual(this.background, tabsComponent.background) && Intrinsics.areEqual(this.shape, tabsComponent.shape) && Intrinsics.areEqual(this.border, tabsComponent.border) && Intrinsics.areEqual(this.shadow, tabsComponent.shadow) && Intrinsics.areEqual(this.control, tabsComponent.control) && Intrinsics.areEqual(this.tabs, tabsComponent.tabs) && Intrinsics.areEqual(this.defaultTabId, tabsComponent.defaultTabId) && Intrinsics.areEqual(this.overrides, tabsComponent.overrides);
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ TabControl getControl() {
        return this.control;
    }

    public final /* synthetic */ String getDefaultTabId() {
        return this.defaultTabId;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Shadow getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ List getTabs() {
        return this.tabs;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (((((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode3 = (iHashCode2 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode4 = (iHashCode3 + (background == null ? 0 : background.hashCode())) * 31;
        Shape shape = this.shape;
        int iHashCode5 = (iHashCode4 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode6 = (iHashCode5 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode7 = (((((iHashCode6 + (shadow == null ? 0 : shadow.hashCode())) * 31) + this.control.hashCode()) * 31) + this.tabs.hashCode()) * 31;
        String str2 = this.defaultTabId;
        return ((iHashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "TabsComponent(name=" + this.name + ", visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", control=" + this.control + ", tabs=" + this.tabs + ", defaultTabId=" + this.defaultTabId + ", overrides=" + this.overrides + ')';
    }

    public TabsComponent(String str, Boolean bool, Size size, Padding padding, Padding margin, ColorScheme colorScheme, Background background, Shape shape, Border border, Shadow shadow, TabControl control, List<Tab> tabs, String str2, List<ComponentOverride<PartialTabsComponent>> overrides) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(control, "control");
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.name = str;
        this.visible = bool;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.control = control;
        this.tabs = tabs;
        this.defaultTabId = str2;
        this.overrides = overrides;
    }

    @SerialName
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDefaultTabId$annotations() {
    }

    public /* synthetic */ TabsComponent(String str, Boolean bool, Size size, Padding padding, Padding padding2, ColorScheme colorScheme, Background background, Shape shape, Border border, Shadow shadow, TabControl tabControl, List list, String str2, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i3 & 8) != 0 ? Padding.Companion.getZero() : padding, (i3 & 16) != 0 ? Padding.Companion.getZero() : padding2, (i3 & 32) != 0 ? null : colorScheme, (i3 & 64) != 0 ? null : background, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : shape, (i3 & Function.MAX_NARGS) != 0 ? null : border, (i3 & 512) != 0 ? null : shadow, tabControl, list, (i3 & 4096) != 0 ? null : str2, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
