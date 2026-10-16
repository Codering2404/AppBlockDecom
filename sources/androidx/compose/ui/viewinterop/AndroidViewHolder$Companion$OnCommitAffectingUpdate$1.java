package androidx.compose.ui.viewinterop;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class AndroidViewHolder$Companion$OnCommitAffectingUpdate$1 extends Lambda implements Function1<AndroidViewHolder, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AndroidViewHolder$Companion$OnCommitAffectingUpdate$1 f30078a = new AndroidViewHolder$Companion$OnCommitAffectingUpdate$1();

    AndroidViewHolder$Companion$OnCommitAffectingUpdate$1() {
        super(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function0 function0) {
        function0.invoke();
    }

    public final void d(AndroidViewHolder androidViewHolder) {
        Handler handler = androidViewHolder.getHandler();
        final Function0 function0 = androidViewHolder.f30069s;
        handler.post(new Runnable() { // from class: androidx.compose.ui.viewinterop.b
            @Override // java.lang.Runnable
            public final void run() {
                AndroidViewHolder$Companion$OnCommitAffectingUpdate$1.e(function0);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        d((AndroidViewHolder) obj);
        return Unit.f139807a;
    }
}
