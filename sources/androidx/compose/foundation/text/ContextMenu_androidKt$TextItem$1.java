package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
public final class ContextMenu_androidKt$TextItem$1 extends Lambda implements Function2<Composer, Integer, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextContextMenuItems f9523a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextMenu_androidKt$TextItem$1(TextContextMenuItems textContextMenuItems) {
        super(2);
        this.f9523a = textContextMenuItems;
    }

    public final String c(Composer composer, int i3) {
        composer.a0(-1744780674);
        if (ComposerKt.M()) {
            ComposerKt.U(-1744780674, i3, -1, "androidx.compose.foundation.text.TextItem.<anonymous> (ContextMenu.android.kt:143)");
        }
        String strB = this.f9523a.b(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strB;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return c((Composer) obj, ((Number) obj2).intValue());
    }
}
