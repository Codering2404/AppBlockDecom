package com.superwall.sdk.models.paywall;

import com.superwall.sdk.models.paywall.PaywallPresentationStyle;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public abstract class PaywallPresentationStyle {
    private final String rawValue;
    public static final Companion Companion = new Companion(null);
    private static final Modal MODAL = Modal.INSTANCE;
    private static final Fullscreen FULLSCREEN = Fullscreen.INSTANCE;
    private static final FullscreenNoAnimation FULLSCREEN_NO_ANIMATION = FullscreenNoAnimation.INSTANCE;
    private static final Push PUSH = Push.INSTANCE;
    private static final Drawer.Companion DRAWER = Drawer.Companion;
    private static final None NONE = None.INSTANCE;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: g0.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PaywallPresentationStyle._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) PaywallPresentationStyle.$cachedSerializer$delegate.getValue();
        }

        public final PaywallPresentationStyle fromIntentString(Json json, String value) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(value, "value");
            json.a();
            return (PaywallPresentationStyle) json.d(PaywallPresentationStyle.Companion.serializer(), value);
        }

        public final Drawer.Companion getDRAWER() {
            return PaywallPresentationStyle.DRAWER;
        }

        public final Fullscreen getFULLSCREEN() {
            return PaywallPresentationStyle.FULLSCREEN;
        }

        public final FullscreenNoAnimation getFULLSCREEN_NO_ANIMATION() {
            return PaywallPresentationStyle.FULLSCREEN_NO_ANIMATION;
        }

        public final Modal getMODAL() {
            return PaywallPresentationStyle.MODAL;
        }

        public final None getNONE() {
            return PaywallPresentationStyle.NONE;
        }

        public final Push getPUSH() {
            return PaywallPresentationStyle.PUSH;
        }

        public final KSerializer<PaywallPresentationStyle> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }

        @Deprecated
        public static /* synthetic */ void getDRAWER$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getFULLSCREEN$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getFULLSCREEN_NO_ANIMATION$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getMODAL$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getNONE$annotations() {
        }

        @Deprecated
        public static /* synthetic */ void getPUSH$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Drawer extends PaywallPresentationStyle {
        public static final Companion Companion = new Companion(null);
        private final double cornerRadius;
        private final double height;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Drawer> serializer() {
                return PaywallPresentationStyle$Drawer$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Drawer(int i3, double d3, double d4, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, PaywallPresentationStyle$Drawer$$serializer.INSTANCE.getDescriptor());
            }
            this.height = d3;
            this.cornerRadius = d4;
        }

        public static /* synthetic */ Drawer copy$default(Drawer drawer, double d3, double d4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                d3 = drawer.height;
            }
            if ((i3 & 2) != 0) {
                d4 = drawer.cornerRadius;
            }
            return drawer.copy(d3, d4);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Drawer drawer, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            PaywallPresentationStyle.write$Self(drawer, compositeEncoder, serialDescriptor);
            compositeEncoder.E(serialDescriptor, 0, drawer.height);
            compositeEncoder.E(serialDescriptor, 1, drawer.cornerRadius);
        }

        public final double component1() {
            return this.height;
        }

        public final double component2() {
            return this.cornerRadius;
        }

        public final Drawer copy(double d3, double d4) {
            return new Drawer(d3, d4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Drawer)) {
                return false;
            }
            Drawer drawer = (Drawer) obj;
            return Double.compare(this.height, drawer.height) == 0 && Double.compare(this.cornerRadius, drawer.cornerRadius) == 0;
        }

        public final double getCornerRadius() {
            return this.cornerRadius;
        }

        public final double getHeight() {
            return this.height;
        }

        public int hashCode() {
            return (Double.hashCode(this.height) * 31) + Double.hashCode(this.cornerRadius);
        }

        public String toString() {
            return "Drawer(height=" + this.height + ", cornerRadius=" + this.cornerRadius + ")";
        }

        public Drawer(double d3, double d4) {
            super("DRAWER", (DefaultConstructorMarker) null);
            this.height = d3;
            this.cornerRadius = d4;
        }

        @SerialName
        public static /* synthetic */ void getCornerRadius$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getHeight$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Fullscreen extends PaywallPresentationStyle {
        public static final Fullscreen INSTANCE = new Fullscreen();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: g0.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallPresentationStyle.Fullscreen._init_$_anonymous_();
            }
        });

        private Fullscreen() {
            super("FULLSCREEN", (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("FULLSCREEN", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Fullscreen);
        }

        public int hashCode() {
            return 2026411310;
        }

        public final KSerializer<Fullscreen> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "Fullscreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class FullscreenNoAnimation extends PaywallPresentationStyle {
        public static final FullscreenNoAnimation INSTANCE = new FullscreenNoAnimation();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: g0.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallPresentationStyle.FullscreenNoAnimation._init_$_anonymous_();
            }
        });

        private FullscreenNoAnimation() {
            super("NO_ANIMATION", (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("NO_ANIMATION", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof FullscreenNoAnimation);
        }

        public int hashCode() {
            return -2063089483;
        }

        public final KSerializer<FullscreenNoAnimation> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "FullscreenNoAnimation";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Modal extends PaywallPresentationStyle {
        public static final Modal INSTANCE = new Modal();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: g0.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallPresentationStyle.Modal._init_$_anonymous_();
            }
        });

        private Modal() {
            super("MODAL", (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("MODAL", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Modal);
        }

        public int hashCode() {
            return -2049473190;
        }

        public final KSerializer<Modal> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "Modal";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class None extends PaywallPresentationStyle {
        public static final None INSTANCE = new None();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: g0.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallPresentationStyle.None._init_$_anonymous_();
            }
        });

        private None() {
            super("NONE", (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("NONE", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof None);
        }

        public int hashCode() {
            return -204629269;
        }

        public final KSerializer<None> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "None";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Popup extends PaywallPresentationStyle {
        public static final Companion Companion = new Companion(null);
        private final double cornerRadius;
        private final double height;
        private final double width;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Popup> serializer() {
                return PaywallPresentationStyle$Popup$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Popup(int i3, double d3, double d4, double d5, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (7 != (i3 & 7)) {
                PluginExceptionsKt.b(i3, 7, PaywallPresentationStyle$Popup$$serializer.INSTANCE.getDescriptor());
            }
            this.height = d3;
            this.width = d4;
            this.cornerRadius = d5;
        }

        public static /* synthetic */ Popup copy$default(Popup popup, double d3, double d4, double d5, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                d3 = popup.height;
            }
            double d6 = d3;
            if ((i3 & 2) != 0) {
                d4 = popup.width;
            }
            double d7 = d4;
            if ((i3 & 4) != 0) {
                d5 = popup.cornerRadius;
            }
            return popup.copy(d6, d7, d5);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Popup popup, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            PaywallPresentationStyle.write$Self(popup, compositeEncoder, serialDescriptor);
            compositeEncoder.E(serialDescriptor, 0, popup.height);
            compositeEncoder.E(serialDescriptor, 1, popup.width);
            compositeEncoder.E(serialDescriptor, 2, popup.cornerRadius);
        }

        public final double component1() {
            return this.height;
        }

        public final double component2() {
            return this.width;
        }

        public final double component3() {
            return this.cornerRadius;
        }

        public final Popup copy(double d3, double d4, double d5) {
            return new Popup(d3, d4, d5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Popup)) {
                return false;
            }
            Popup popup = (Popup) obj;
            return Double.compare(this.height, popup.height) == 0 && Double.compare(this.width, popup.width) == 0 && Double.compare(this.cornerRadius, popup.cornerRadius) == 0;
        }

        public final double getCornerRadius() {
            return this.cornerRadius;
        }

        public final double getHeight() {
            return this.height;
        }

        public final double getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((Double.hashCode(this.height) * 31) + Double.hashCode(this.width)) * 31) + Double.hashCode(this.cornerRadius);
        }

        public String toString() {
            return "Popup(height=" + this.height + ", width=" + this.width + ", cornerRadius=" + this.cornerRadius + ")";
        }

        public Popup(double d3, double d4, double d5) {
            super("POPUP", (DefaultConstructorMarker) null);
            this.height = d3;
            this.width = d4;
            this.cornerRadius = d5;
        }

        @SerialName
        public static /* synthetic */ void getCornerRadius$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getHeight$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getWidth$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Push extends PaywallPresentationStyle {
        public static final Push INSTANCE = new Push();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: g0.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallPresentationStyle.Push._init_$_anonymous_();
            }
        });

        private Push() {
            super("PUSH", (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("PUSH", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Push);
        }

        public int hashCode() {
            return -204563763;
        }

        public final KSerializer<Push> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "Push";
        }
    }

    public /* synthetic */ PaywallPresentationStyle(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.superwall.sdk.models.paywall.PaywallPresentationStyle", Reflection.b(PaywallPresentationStyle.class), new KClass[]{Reflection.b(Drawer.class), Reflection.b(Fullscreen.class), Reflection.b(FullscreenNoAnimation.class), Reflection.b(Modal.class), Reflection.b(None.class), Reflection.b(Popup.class), Reflection.b(Push.class)}, new KSerializer[]{PaywallPresentationStyle$Drawer$$serializer.INSTANCE, new ObjectSerializer("FULLSCREEN", Fullscreen.INSTANCE, new Annotation[0]), new ObjectSerializer("NO_ANIMATION", FullscreenNoAnimation.INSTANCE, new Annotation[0]), new ObjectSerializer("MODAL", Modal.INSTANCE, new Annotation[0]), new ObjectSerializer("NONE", None.INSTANCE, new Annotation[0]), PaywallPresentationStyle$Popup$$serializer.INSTANCE, new ObjectSerializer("PUSH", Push.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public final String toIntentString(Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        json.a();
        return json.b(Companion.serializer(), this);
    }

    public /* synthetic */ PaywallPresentationStyle(int i3, SerializationConstructorMarker serializationConstructorMarker) {
        this.rawValue = "";
    }

    private PaywallPresentationStyle(String str) {
        this.rawValue = str;
    }

    public /* synthetic */ PaywallPresentationStyle(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (DefaultConstructorMarker) null);
    }

    @Transient
    public static /* synthetic */ void getRawValue$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(PaywallPresentationStyle paywallPresentationStyle, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
