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

/* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$clickableWithIndicationIfNeeded$1, reason: invalid class name */
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
public final class ClickableKt$combinedClickableXVZzFYc$$inlined$clickableWithIndicationIfNeeded$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Indication f4814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f4815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Role f4817d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f4818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f4819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function0 f4820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function0 f4821i;

    public final Modifier c(Modifier modifier, Composer composer, int i3) {
        composer.a0(-1525724089);
        if (ComposerKt.M()) {
            ComposerKt.U(-1525724089, i3, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:473)");
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = InteractionSourceKt.a();
            composer.w(objG);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
        Modifier modifierThen = IndicationKt.b(Modifier.b8, mutableInteractionSource, this.f4814a).then(new CombinedClickableElement(mutableInteractionSource, null, this.f4815b, this.f4816c, this.f4817d, this.f4818f, this.f4819g, this.f4820h, this.f4821i, true, null));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierThen;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
