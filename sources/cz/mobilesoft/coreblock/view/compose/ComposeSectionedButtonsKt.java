package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

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
public final class ComposeSectionedButtonsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier e(final Function0 function0, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ClickableKt.f(applyIf, false, null, null, new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.d8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ComposeSectionedButtonsKt.f(function0);
            }
        }, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Modifier modifier, long j3, Shape shape, boolean z2, Function0 function0, Function3 function3, int i3, int i4, Composer composer, int i5) {
        d(modifier, j3, shape, z2, function0, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(androidx.compose.ui.Modifier r28, long r29, androidx.compose.ui.graphics.Shape r31, boolean r32, kotlin.jvm.functions.Function0 r33, final kotlin.jvm.functions.Function3 r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeSectionedButtonsKt.d(androidx.compose.ui.Modifier, long, androidx.compose.ui.graphics.Shape, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
