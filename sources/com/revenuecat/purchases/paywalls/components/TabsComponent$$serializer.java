package com.revenuecat.purchases.paywalls.components;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
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
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Deprecated
public final class TabsComponent$$serializer implements GeneratedSerializer<TabsComponent> {
    public static final TabsComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TabsComponent$$serializer tabsComponent$$serializer = new TabsComponent$$serializer();
        INSTANCE = tabsComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("tabs", tabsComponent$$serializer, 14);
        pluginGeneratedSerialDescriptor.p("name", true);
        pluginGeneratedSerialDescriptor.p("visible", true);
        pluginGeneratedSerialDescriptor.p("size", true);
        pluginGeneratedSerialDescriptor.p("padding", true);
        pluginGeneratedSerialDescriptor.p("margin", true);
        pluginGeneratedSerialDescriptor.p("background_color", true);
        pluginGeneratedSerialDescriptor.p("background", true);
        pluginGeneratedSerialDescriptor.p("shape", true);
        pluginGeneratedSerialDescriptor.p("border", true);
        pluginGeneratedSerialDescriptor.p("shadow", true);
        pluginGeneratedSerialDescriptor.p("control", false);
        pluginGeneratedSerialDescriptor.p("tabs", false);
        pluginGeneratedSerialDescriptor.p("default_tab_id", true);
        pluginGeneratedSerialDescriptor.p("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TabsComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = TabsComponent.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        KSerializer<?> kSerializerU = BuiltinSerializersKt.u(stringSerializer);
        KSerializer<?> kSerializerU2 = BuiltinSerializersKt.u(BooleanSerializer.f142767a);
        KSerializer<?> kSerializerU3 = BuiltinSerializersKt.u(ColorScheme$$serializer.INSTANCE);
        KSerializer<?> kSerializerU4 = BuiltinSerializersKt.u(BackgroundDeserializer.INSTANCE);
        KSerializer<?> kSerializerU5 = BuiltinSerializersKt.u(ShapeDeserializer.INSTANCE);
        KSerializer<?> kSerializerU6 = BuiltinSerializersKt.u(Border$$serializer.INSTANCE);
        KSerializer<?> kSerializerU7 = BuiltinSerializersKt.u(Shadow$$serializer.INSTANCE);
        KSerializer<?> kSerializer = kSerializerArr[10];
        KSerializer<?> kSerializer2 = kSerializerArr[11];
        KSerializer<?> kSerializerU8 = BuiltinSerializersKt.u(stringSerializer);
        KSerializer<?> kSerializer3 = kSerializerArr[13];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new KSerializer[]{kSerializerU, kSerializerU2, Size$$serializer.INSTANCE, padding$$serializer, padding$$serializer, kSerializerU3, kSerializerU4, kSerializerU5, kSerializerU6, kSerializerU7, kSerializer, kSerializer2, kSerializerU8, kSerializer3};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TabsComponent deserialize(Decoder decoder) {
        int i3;
        String str;
        List list;
        Shadow shadow;
        Border border;
        Shape shape;
        ColorScheme colorScheme;
        TabsComponent.TabControl tabControl;
        Background background;
        Padding padding;
        Padding padding2;
        String str2;
        List list2;
        Size size;
        Boolean bool;
        Size size2;
        List list3;
        String str3;
        Boolean bool2;
        List list4;
        Boolean bool3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = TabsComponent.$childSerializers;
        if (compositeDecoderB.p()) {
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str4 = (String) compositeDecoderB.n(descriptor2, 0, stringSerializer, null);
            Boolean bool4 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, null);
            Size size3 = (Size) compositeDecoderB.y(descriptor2, 2, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) compositeDecoderB.y(descriptor2, 3, padding$$serializer, null);
            Padding padding4 = (Padding) compositeDecoderB.y(descriptor2, 4, padding$$serializer, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderB.n(descriptor2, 6, BackgroundDeserializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderB.n(descriptor2, 7, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderB.n(descriptor2, 8, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderB.n(descriptor2, 9, Shadow$$serializer.INSTANCE, null);
            TabsComponent.TabControl tabControl2 = (TabsComponent.TabControl) compositeDecoderB.y(descriptor2, 10, kSerializerArr[10], null);
            i3 = 16383;
            list = (List) compositeDecoderB.y(descriptor2, 11, kSerializerArr[11], null);
            str2 = (String) compositeDecoderB.n(descriptor2, 12, stringSerializer, null);
            list2 = (List) compositeDecoderB.y(descriptor2, 13, kSerializerArr[13], null);
            shadow = shadow2;
            shape = shape2;
            background = background2;
            colorScheme = colorScheme2;
            padding2 = padding3;
            border = border2;
            padding = padding4;
            size = size3;
            bool = bool4;
            str = str4;
            tabControl = tabControl2;
        } else {
            int i4 = 13;
            boolean z2 = true;
            List list5 = null;
            List list6 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            Shape shape3 = null;
            ColorScheme colorScheme3 = null;
            TabsComponent.TabControl tabControl3 = null;
            Background background3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            Boolean bool5 = null;
            String str5 = null;
            String str6 = null;
            i3 = 0;
            Size size4 = null;
            while (z2) {
                int i5 = i4;
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        size2 = size4;
                        list3 = list5;
                        str3 = str6;
                        bool2 = bool5;
                        z2 = false;
                        list5 = list3;
                        bool5 = bool2;
                        i4 = 13;
                        str6 = str3;
                        size4 = size2;
                        break;
                    case 0:
                        size2 = size4;
                        list3 = list5;
                        String str7 = str6;
                        bool2 = bool5;
                        str3 = (String) compositeDecoderB.n(descriptor2, 0, StringSerializer.f142891a, str7);
                        i3 |= 1;
                        list5 = list3;
                        bool5 = bool2;
                        i4 = 13;
                        str6 = str3;
                        size4 = size2;
                        break;
                    case 1:
                        List list7 = list5;
                        i3 |= 2;
                        size4 = size4;
                        i4 = 13;
                        bool5 = (Boolean) compositeDecoderB.n(descriptor2, 1, BooleanSerializer.f142767a, bool5);
                        list5 = list7;
                        break;
                    case 2:
                        list4 = list5;
                        bool3 = bool5;
                        size4 = (Size) compositeDecoderB.y(descriptor2, 2, Size$$serializer.INSTANCE, size4);
                        i3 |= 4;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 3:
                        list4 = list5;
                        bool3 = bool5;
                        padding6 = (Padding) compositeDecoderB.y(descriptor2, 3, Padding$$serializer.INSTANCE, padding6);
                        i3 |= 8;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 4:
                        list4 = list5;
                        bool3 = bool5;
                        padding5 = (Padding) compositeDecoderB.y(descriptor2, 4, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 16;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 5:
                        list4 = list5;
                        bool3 = bool5;
                        colorScheme3 = (ColorScheme) compositeDecoderB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i3 |= 32;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 6:
                        list4 = list5;
                        bool3 = bool5;
                        background3 = (Background) compositeDecoderB.n(descriptor2, 6, BackgroundDeserializer.INSTANCE, background3);
                        i3 |= 64;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 7:
                        list4 = list5;
                        bool3 = bool5;
                        shape3 = (Shape) compositeDecoderB.n(descriptor2, 7, ShapeDeserializer.INSTANCE, shape3);
                        i3 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 8:
                        list4 = list5;
                        bool3 = bool5;
                        border3 = (Border) compositeDecoderB.n(descriptor2, 8, Border$$serializer.INSTANCE, border3);
                        i3 |= Function.MAX_NARGS;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 9:
                        list4 = list5;
                        bool3 = bool5;
                        shadow3 = (Shadow) compositeDecoderB.n(descriptor2, 9, Shadow$$serializer.INSTANCE, shadow3);
                        i3 |= 512;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 10:
                        list4 = list5;
                        bool3 = bool5;
                        tabControl3 = (TabsComponent.TabControl) compositeDecoderB.y(descriptor2, 10, kSerializerArr[10], tabControl3);
                        i3 |= 1024;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 11:
                        list4 = list5;
                        bool3 = bool5;
                        list6 = (List) compositeDecoderB.y(descriptor2, 11, kSerializerArr[11], list6);
                        i3 |= 2048;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 12:
                        bool3 = bool5;
                        list4 = list5;
                        str5 = (String) compositeDecoderB.n(descriptor2, 12, StringSerializer.f142891a, str5);
                        i3 |= 4096;
                        list5 = list4;
                        bool5 = bool3;
                        i4 = 13;
                        break;
                    case 13:
                        list5 = (List) compositeDecoderB.y(descriptor2, i5, kSerializerArr[i5], list5);
                        i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        i4 = i5;
                        bool5 = bool5;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            Size size5 = size4;
            str = str6;
            list = list6;
            shadow = shadow3;
            border = border3;
            shape = shape3;
            colorScheme = colorScheme3;
            tabControl = tabControl3;
            background = background3;
            padding = padding5;
            padding2 = padding6;
            str2 = str5;
            list2 = list5;
            size = size5;
            bool = bool5;
        }
        int i6 = i3;
        compositeDecoderB.c(descriptor2);
        return new TabsComponent(i6, str, bool, size, padding2, padding, colorScheme, background, shape, border, shadow, tabControl, list, str2, list2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TabsComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        TabsComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
