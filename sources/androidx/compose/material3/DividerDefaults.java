package androidx.compose.material3;

import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

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
public final class DividerDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DividerDefaults f17464a = new DividerDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f17465b = DividerTokens.f22491a.b();

    private DividerDefaults() {
    }

    public final long a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(77461041, i3, -1, "androidx.compose.material3.DividerDefaults.<get-color> (Divider.kt:118)");
        }
        long jI = ColorSchemeKt.i(DividerTokens.f22491a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final float b() {
        return f17465b;
    }
}
