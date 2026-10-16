package androidx.glance.appwidget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.unit.CheckedUncheckedColorProvider;
import androidx.glance.appwidget.unit.ResourceCheckableColorProvider;
import androidx.glance.color.DynamicThemeColorProviders;
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
public final class CheckboxDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CheckboxDefaults f37855a = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    public final CheckBoxColors a(Composer composer, int i3) {
        composer.F(-2123347125);
        if (ComposerKt.M()) {
            ComposerKt.U(-2123347125, i3, -1, "androidx.glance.appwidget.CheckboxDefaults.colors (CheckBox.kt:212)");
        }
        GlanceTheme glanceTheme = GlanceTheme.f37608a;
        int i4 = GlanceTheme.f37609b;
        CheckBoxColorsImpl checkBoxColorsImpl = new CheckBoxColorsImpl(Intrinsics.areEqual(glanceTheme.a(composer, i4), DynamicThemeColorProviders.B) ? new ResourceCheckableColorProvider(R.color.f38200a) : CheckedUncheckedColorProvider.f39380d.a("CheckBoxColors", glanceTheme.a(composer, i4).g(), glanceTheme.a(composer, i4).d()));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return checkBoxColorsImpl;
    }
}
