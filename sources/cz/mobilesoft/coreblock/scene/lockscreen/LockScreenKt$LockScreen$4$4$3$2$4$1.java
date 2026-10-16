package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
final class LockScreenKt$LockScreen$4$4$3$2$4$1 implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1 f105409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f105410b;

    LockScreenKt$LockScreen$4$4$3$2$4$1(Function1 function1, MutableState mutableState) {
        this.f105409a = function1;
        this.f105410b = mutableState;
    }

    public final void c() {
        if (LockScreenKt.f0(this.f105410b)) {
            this.f105409a.invoke(LockViewEvent.LockScreenCloseButtonClickEvent.f105467a);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        c();
        return Unit.f139807a;
    }
}
