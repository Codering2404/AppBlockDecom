package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
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
final class MovableContentKt$movableContentOf$movableContent$4 extends Lambda implements Function3<Object[], Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function6 f23945a;

    public final void c(Object[] objArr, Composer composer, int i3) {
        if (!composer.r((i3 & 3) != 2, i3 & 1)) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1900160788, i3, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:133)");
        }
        this.f23945a.k(objArr[0], objArr[1], objArr[2], objArr[3], composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        c((Object[]) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.f139807a;
    }
}
