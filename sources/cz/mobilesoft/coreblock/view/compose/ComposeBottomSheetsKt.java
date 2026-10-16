package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class ComposeBottomSheetsKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x016b  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(cz.mobilesoft.coreblock.view.compose.BottomSheetType r28, androidx.compose.ui.graphics.Shape r29, boolean r30, final kotlin.jvm.functions.Function4 r31, kotlin.jvm.functions.Function2 r32, kotlin.jvm.functions.Function0 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 579
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt.f(cz.mobilesoft.coreblock.view.compose.BottomSheetType, androidx.compose.ui.graphics.Shape, boolean, kotlin.jvm.functions.Function4, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(CoroutineScope coroutineScope, SheetState sheetState, Function0 function0) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ComposeBottomSheetsKt$AppBottomSheet$2$1$1(sheetState, function0, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function4 function4, SheetState sheetState, ColumnScope ModalBottomSheet, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ModalBottomSheet, "$this$ModalBottomSheet");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(ModalBottomSheet) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1825807738, i3, -1, "cz.mobilesoft.coreblock.view.compose.AppBottomSheet.<anonymous> (ComposeBottomSheets.kt:79)");
            }
            function4.invoke(ModalBottomSheet, sheetState, composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(BottomSheetType bottomSheetType, Shape shape, boolean z2, Function4 function4, Function2 function2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        f(bottomSheetType, shape, z2, function4, function2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void k(Composer composer, final int i3) {
        Composer composerK = composer.k(73470860);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(73470860, i3, -1, "cz.mobilesoft.coreblock.view.compose.CustomDragHandle (ComposeBottomSheets.kt:85)");
            }
            SurfaceKt.a(PaddingKt.m(Modifier.b8, 0.0f, Dp.g(12), 0.0f, 0.0f, 13, null), RoundedCornerShapeKt.d(Dp.g((float) 28.0d)), ComposeColorsKt.j(composerK, 0).s(), 0L, 0.0f, 0.0f, null, ComposableSingletons$ComposeBottomSheetsKt.f130356a.d(), composerK, 12582918, 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.b2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeBottomSheetsKt.l(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(int i3, Composer composer, int i4) {
        k(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
