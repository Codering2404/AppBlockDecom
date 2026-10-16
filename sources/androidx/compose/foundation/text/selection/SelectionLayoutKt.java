package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SelectionLayoutKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11399a;

        static {
            int[] iArr = new int[Direction.values().length];
            try {
                iArr[Direction.f11217a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.f11218b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.f11219c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11399a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ResolvedTextDirection b(TextLayoutResult textLayoutResult, int i3) {
        return e(textLayoutResult, i3) ? textLayoutResult.y(i3) : textLayoutResult.c(i3);
    }

    public static final SelectionLayout c(TextLayoutResult textLayoutResult, int i3, int i4, int i5, long j3, boolean z2, boolean z3) {
        return new SingleSelectionLayout(z3, 1, 1, z2 ? null : new Selection(new Selection.AnchorInfo(b(textLayoutResult, TextRange.n(j3)), TextRange.n(j3), 1L), new Selection.AnchorInfo(b(textLayoutResult, TextRange.i(j3)), TextRange.i(j3), 1L), TextRange.m(j3)), new SelectableInfo(1L, 1, i3, i4, i5, textLayoutResult));
    }

    public static final boolean d(Selection selection, SelectionLayout selectionLayout) {
        if (selection == null || selectionLayout == null) {
            return true;
        }
        if (selection.e().e() == selection.c().e()) {
            return selection.e().d() == selection.c().d();
        }
        if ((selection.d() ? selection.e() : selection.c()).d() != 0) {
            return false;
        }
        if (selectionLayout.c().l() != (selection.d() ? selection.c() : selection.e()).d()) {
            return false;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.f140137a = true;
        selectionLayout.f(new Function1<SelectableInfo, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionLayoutKt$isCollapsed$1
            {
                super(1);
            }

            public final void c(SelectableInfo selectableInfo) {
                if (selectableInfo.c().length() > 0) {
                    booleanRef.f140137a = false;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((SelectableInfo) obj);
                return Unit.f139807a;
            }
        });
        return booleanRef.f140137a;
    }

    private static final boolean e(TextLayoutResult textLayoutResult, int i3) {
        if (textLayoutResult.l().j().length() != 0) {
            int iQ = textLayoutResult.q(i3);
            if (i3 != 0 && iQ == textLayoutResult.q(i3 - 1)) {
                return false;
            }
            if (i3 != textLayoutResult.l().j().length() && iQ == textLayoutResult.q(i3 + 1)) {
                return false;
            }
        }
        return true;
    }

    public static final Direction f(Direction direction, Direction direction2) {
        int[] iArr = WhenMappings.f11399a;
        int i3 = iArr[direction2.ordinal()];
        if (i3 == 1) {
            return Direction.f11217a;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                return Direction.f11219c;
            }
            throw new NoWhenBranchMatchedException();
        }
        int i4 = iArr[direction.ordinal()];
        if (i4 == 1) {
            return Direction.f11217a;
        }
        if (i4 == 2) {
            return Direction.f11218b;
        }
        if (i4 == 3) {
            return Direction.f11219c;
        }
        throw new NoWhenBranchMatchedException();
    }
}
