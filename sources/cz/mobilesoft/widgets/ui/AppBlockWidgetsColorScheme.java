package cz.mobilesoft.widgets.ui;

import androidx.compose.ui.graphics.ColorKt;
import androidx.glance.color.ColorProviders;
import androidx.glance.color.ColorProvidersKt;
import androidx.glance.color.DayNightColorProvidersKt;
import androidx.glance.unit.FixedColorProvider;
import cz.mobilesoft.widgets.WidgetDataProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AppBlockWidgetsColorScheme {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppBlockWidgetsColorScheme f134214a = new AppBlockWidgetsColorScheme();

    private AppBlockWidgetsColorScheme() {
    }

    public final ColorProviders a(WidgetDataProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        FixedColorProvider fixedColorProvider = new FixedColorProvider(provider.d(WidgetDataProvider.WidgetColor.f134022c), null);
        FixedColorProvider fixedColorProvider2 = new FixedColorProvider(provider.d(WidgetDataProvider.WidgetColor.f134023d), null);
        FixedColorProvider fixedColorProvider3 = new FixedColorProvider(provider.d(WidgetDataProvider.WidgetColor.f134020a), null);
        WidgetDataProvider.WidgetColor widgetColor = WidgetDataProvider.WidgetColor.f134024f;
        FixedColorProvider fixedColorProvider4 = new FixedColorProvider(provider.d(widgetColor), null);
        FixedColorProvider fixedColorProvider5 = new FixedColorProvider(provider.d(WidgetDataProvider.WidgetColor.f134021b), null);
        FixedColorProvider fixedColorProvider6 = new FixedColorProvider(provider.d(widgetColor), null);
        return ColorProvidersKt.a(fixedColorProvider, DayNightColorProvidersKt.a(ColorKt.d(4280361252L), ColorKt.d(4280361252L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), fixedColorProvider2, DayNightColorProvidersKt.a(ColorKt.d(4280361252L), ColorKt.d(4280361252L)), DayNightColorProvidersKt.a(ColorKt.d(4281084974L), ColorKt.d(4281084974L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), new FixedColorProvider(provider.d(WidgetDataProvider.WidgetColor.f134025g), null), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4292885317L), ColorKt.d(4292885317L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4294967295L), ColorKt.d(4294967295L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), fixedColorProvider3, fixedColorProvider4, fixedColorProvider5, fixedColorProvider6, DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)), DayNightColorProvidersKt.a(ColorKt.d(4294939904L), ColorKt.d(4294939904L)));
    }
}
