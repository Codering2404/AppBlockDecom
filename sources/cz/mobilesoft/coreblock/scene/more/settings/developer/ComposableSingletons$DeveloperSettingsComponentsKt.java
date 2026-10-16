package cz.mobilesoft.coreblock.scene.more.settings.developer;

import androidx.compose.material.IconKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ClearKt;
import androidx.compose.material.icons.filled.SearchKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

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
public final class ComposableSingletons$DeveloperSettingsComponentsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$DeveloperSettingsComponentsKt f108249a = new ComposableSingletons$DeveloperSettingsComponentsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f108250b = ComposableLambdaKt.c(-1255589648, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsComponentsKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f108251c = ComposableLambdaKt.c(-1111750744, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsComponentsKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1111750744, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsComponentsKt.lambda$-1111750744.<anonymous> (DeveloperSettingsComponents.kt:102)");
            }
            IconKt.b(ClearKt.a(Icons.f15145a.a()), "Clear", null, ComposeColorsKt.j(composer, 0).O(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1255589648, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsComponentsKt.lambda$-1255589648.<anonymous> (DeveloperSettingsComponents.kt:90)");
            }
            IconKt.b(SearchKt.a(Icons.f15145a.a()), StringResources_androidKt.b(R.string.Dv, composer, 0), null, ComposeColorsKt.j(composer, 0).O(), composer, 0, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 c() {
        return f108251c;
    }

    public final Function2 d() {
        return f108250b;
    }
}
