package androidx.glance.appwidget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.unit.CheckedUncheckedColorProvider;
import androidx.glance.appwidget.unit.ResourceCheckableColorProvider;
import androidx.glance.color.DynamicThemeColorProviders;
import androidx.glance.unit.ColorProvider;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SwitchDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SwitchDefaults f38458a = new SwitchDefaults();

    private SwitchDefaults() {
    }

    public final SwitchColors a(Composer composer, int i3) {
        Composer composer2;
        SwitchColors switchColorsB;
        composer.F(494460634);
        if (ComposerKt.M()) {
            ComposerKt.U(494460634, i3, -1, "androidx.glance.appwidget.SwitchDefaults.colors (Switch.kt:182)");
        }
        GlanceTheme glanceTheme = GlanceTheme.f37608a;
        int i4 = GlanceTheme.f37609b;
        if (Intrinsics.areEqual(glanceTheme.a(composer, i4), DynamicThemeColorProviders.B)) {
            switchColorsB = new SwitchColorsImpl(new ResourceCheckableColorProvider(R.color.f38202c), new ResourceCheckableColorProvider(R.color.f38203d));
            composer2 = composer;
        } else {
            composer2 = composer;
            switchColorsB = b(glanceTheme.a(composer, i4).c(), glanceTheme.a(composer, i4).f(), glanceTheme.a(composer, i4).g(), glanceTheme.a(composer, i4).k(), composer2, ((i3 << 12) & 57344) | 4680);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer2.Y();
        return switchColorsB;
    }

    public final SwitchColors b(ColorProvider colorProvider, ColorProvider colorProvider2, ColorProvider colorProvider3, ColorProvider colorProvider4, Composer composer, int i3) {
        composer.F(-1578571870);
        if (ComposerKt.M()) {
            ComposerKt.U(-1578571870, i3, -1, "androidx.glance.appwidget.SwitchDefaults.colors (Switch.kt:156)");
        }
        CheckedUncheckedColorProvider.Companion companion = CheckedUncheckedColorProvider.f39380d;
        SwitchColorsImpl switchColorsImpl = new SwitchColorsImpl(companion.a("SwitchColors", colorProvider, colorProvider2), companion.a("SwitchColors", colorProvider3, colorProvider4));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return switchColorsImpl;
    }
}
