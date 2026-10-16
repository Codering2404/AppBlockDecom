package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
final class ClickableKt$combinedClickable$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f4807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Role f4809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4810d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f4811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f4812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function0 f4813h;

    public final Modifier c(Modifier modifier, Composer composer, int i3) {
        MutableInteractionSource mutableInteractionSource;
        composer.a0(1969174843);
        if (ComposerKt.M()) {
            ComposerKt.U(1969174843, i3, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:312)");
        }
        Indication indication = (Indication) composer.q(IndicationKt.a());
        if (indication instanceof IndicationNodeFactory) {
            composer.a0(-1724200443);
            composer.U();
            mutableInteractionSource = null;
        } else {
            composer.a0(-1724067825);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = InteractionSourceKt.a();
                composer.w(objG);
            }
            mutableInteractionSource = (MutableInteractionSource) objG;
            composer.U();
        }
        Modifier modifierG = ClickableKt.g(Modifier.b8, mutableInteractionSource, indication, this.f4807a, this.f4808b, this.f4809c, this.f4810d, this.f4811f, this.f4812g, true, this.f4813h);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierG;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
