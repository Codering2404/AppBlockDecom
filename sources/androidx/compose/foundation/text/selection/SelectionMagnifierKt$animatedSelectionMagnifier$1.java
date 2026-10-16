package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
final class SelectionMagnifierKt$animatedSelectionMagnifier$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function0 f11407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1 f11408b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionMagnifierKt$animatedSelectionMagnifier$1(Function0 function0, Function1 function1) {
        super(3);
        this.f11407a = function0;
        this.f11408b = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e(State state) {
        return ((Offset) state.getValue()).u();
    }

    public final Modifier d(Modifier modifier, Composer composer, int i3) {
        composer.a0(759876635);
        if (ComposerKt.M()) {
            ComposerKt.U(759876635, i3, -1, "androidx.compose.foundation.text.selection.animatedSelectionMagnifier.<anonymous> (SelectionMagnifier.kt:64)");
        }
        final State stateH = SelectionMagnifierKt.h(this.f11407a, composer, 0);
        Function1 function1 = this.f11408b;
        boolean Z = composer.Z(stateH);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$animatedSelectionMagnifier$1$1$1
                {
                    super(0);
                }

                public final long c() {
                    return SelectionMagnifierKt$animatedSelectionMagnifier$1.e(stateH);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.d(c());
                }
            };
            composer.w(objG);
        }
        Modifier modifier2 = (Modifier) function1.invoke((Function0) objG);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifier2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return d((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
