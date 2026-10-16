package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

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
public final class TextFieldSelectionManagerKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11577a;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.f9697a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.f9698b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.f9699c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11577a = iArr;
        }
    }

    public static final void a(final boolean z2, final ResolvedTextDirection resolvedTextDirection, final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1344558920);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(resolvedTextDirection) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(textFieldSelectionManager) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1344558920, i4, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:1029)");
            }
            int i5 = i4 & 14;
            boolean Z = (i5 == 4) | composerK.Z(textFieldSelectionManager);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = textFieldSelectionManager.W(z2);
                composerK.w(objG);
            }
            final TextDragObserver textDragObserver = (TextDragObserver) objG;
            boolean zI = composerK.I(textFieldSelectionManager) | (i5 == 4);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1
                    @Override // androidx.compose.foundation.text.selection.OffsetProvider
                    public final long a() {
                        return textFieldSelectionManager.K(z2);
                    }
                };
                composerK.w(objG2);
            }
            OffsetProvider offsetProvider = (OffsetProvider) objG2;
            boolean zM = TextRange.m(textFieldSelectionManager.U().h());
            float fJ = textFieldSelectionManager.J(z2);
            Modifier.Companion companion = Modifier.b8;
            boolean zI2 = composerK.I(textDragObserver);
            Object objG3 = composerK.G();
            if (zI2 || objG3 == Composer.f23746a.a()) {
                objG3 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$2$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                        Object objC = LongPressTextDragObserverKt.c(pointerInputScope, textDragObserver, continuation);
                        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
                    }
                };
                composerK.w(objG3);
            }
            AndroidSelectionHandles_androidKt.b(offsetProvider, z2, resolvedTextDirection, zM, 0L, fJ, SuspendingPointerInputFilterKt.d(companion, textDragObserver, (PointerInputEventHandler) objG3), composerK, (i4 << 3) & 1008, 16);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    TextFieldSelectionManagerKt.a(z2, resolvedTextDirection, textFieldSelectionManager, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final long b(TextFieldSelectionManager textFieldSelectionManager, long j3) {
        int iN;
        TextLayoutResultProxy textLayoutResultProxyL;
        TextDelegate textDelegateX;
        AnnotatedString annotatedStringK;
        Offset offsetD = textFieldSelectionManager.D();
        if (offsetD == null) {
            return Offset.f25596b.b();
        }
        long jU = offsetD.u();
        AnnotatedString annotatedStringS = textFieldSelectionManager.S();
        if (annotatedStringS == null || annotatedStringS.length() == 0) {
            return Offset.f25596b.b();
        }
        Handle handleF = textFieldSelectionManager.F();
        int i3 = handleF == null ? -1 : WhenMappings.f11577a[handleF.ordinal()];
        if (i3 == -1) {
            return Offset.f25596b.b();
        }
        if (i3 == 1 || i3 == 2) {
            iN = TextRange.n(textFieldSelectionManager.U().h());
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            iN = TextRange.i(textFieldSelectionManager.U().h());
        }
        LegacyTextFieldState legacyTextFieldStateP = textFieldSelectionManager.P();
        if (legacyTextFieldStateP == null || (textLayoutResultProxyL = legacyTextFieldStateP.l()) == null) {
            return Offset.f25596b.b();
        }
        LegacyTextFieldState legacyTextFieldStateP2 = textFieldSelectionManager.P();
        if (legacyTextFieldStateP2 == null || (textDelegateX = legacyTextFieldStateP2.x()) == null || (annotatedStringK = textDelegateX.k()) == null) {
            return Offset.f25596b.b();
        }
        int iP = RangesKt.p(textFieldSelectionManager.N().b(iN), 0, annotatedStringK.length());
        float fIntBitsToFloat = Float.intBitsToFloat((int) (textLayoutResultProxyL.j(jU) >> 32));
        TextLayoutResult textLayoutResultF = textLayoutResultProxyL.f();
        int iQ = textLayoutResultF.q(iP);
        float fS = textLayoutResultF.s(iQ);
        float fT = textLayoutResultF.t(iQ);
        float fO = RangesKt.o(fIntBitsToFloat, Math.min(fS, fT), Math.max(fS, fT));
        if (!IntSize.e(j3, IntSize.f29998b.a()) && Math.abs(fIntBitsToFloat - fO) > ((int) (j3 >> 32)) / 2) {
            return Offset.f25596b.b();
        }
        float fV = textLayoutResultF.v(iQ);
        return Offset.e((((long) Float.floatToRawIntBits(fO)) << 32) | (((long) Float.floatToRawIntBits(((textLayoutResultF.m(iQ) - fV) / 2) + fV)) & 4294967295L));
    }

    public static final boolean c(TextFieldSelectionManager textFieldSelectionManager, boolean z2) {
        LayoutCoordinates layoutCoordinatesK;
        Rect rectI;
        LegacyTextFieldState legacyTextFieldStateP = textFieldSelectionManager.P();
        if (legacyTextFieldStateP == null || (layoutCoordinatesK = legacyTextFieldStateP.k()) == null || (rectI = SelectionManagerKt.i(layoutCoordinatesK)) == null) {
            return false;
        }
        return SelectionManagerKt.d(rectI, textFieldSelectionManager.K(z2));
    }
}
