package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class WindowInsetsConnection_androidKt$imeNestedScroll$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WindowInsetsConnection_androidKt$imeNestedScroll$2 f7177a = new WindowInsetsConnection_androidKt$imeNestedScroll$2();

    WindowInsetsConnection_androidKt$imeNestedScroll$2() {
        super(3);
    }

    public final Modifier c(Modifier modifier, Composer composer, int i3) {
        composer.a0(-369978792);
        if (ComposerKt.M()) {
            ComposerKt.U(-369978792, i3, -1, "androidx.compose.foundation.layout.imeNestedScroll.<anonymous> (WindowInsetsConnection.android.kt:76)");
        }
        Modifier modifierB = NestedScrollModifierKt.b(modifier, WindowInsetsConnection_androidKt.d(WindowInsetsHolder.f7180x.c(composer, 6).f(), WindowInsetsSides.f7284b.e(), composer, 48), null, 2, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierB;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
