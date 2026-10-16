package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.TouchBoundsExpansionKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class StylusHandwritingKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f10108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f10109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final DpTouchBoundsExpansion f10110c;

    static {
        float fG = Dp.g(40);
        f10108a = fG;
        float fG2 = Dp.g(10);
        f10109b = fG2;
        f10110c = TouchBoundsExpansionKt.a(fG2, fG, fG2, fG);
    }

    public static final DpTouchBoundsExpansion a() {
        return f10110c;
    }

    public static final Modifier b(Modifier modifier, boolean z2, boolean z3, Function0 function0) {
        if (!z2 || !StylusHandwriting_androidKt.a()) {
            return modifier;
        }
        if (z3) {
            modifier = PointerIconKt.c(modifier, TextPointerIcon_androidKt.a(), false, f10110c);
        }
        return modifier.then(new StylusHandwritingElement(function0));
    }
}
