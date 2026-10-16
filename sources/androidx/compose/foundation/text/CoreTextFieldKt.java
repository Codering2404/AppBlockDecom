package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

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
public final class CoreTextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x06ed  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x07da  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x07f0  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x07f2  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0803  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0805  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x081c  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x087c  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x089b  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x08a4  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x08c3  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x08c9  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x08cf  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0900  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0945  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0966  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x099a  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x09f7  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x09fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0a4a  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0a6d  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0a90  */
    /* JADX WARN: Removed duplicated region for block: B:497:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.ui.text.input.TextFieldValue r48, final kotlin.jvm.functions.Function1 r49, androidx.compose.ui.Modifier r50, androidx.compose.ui.text.TextStyle r51, androidx.compose.ui.text.input.VisualTransformation r52, kotlin.jvm.functions.Function1 r53, androidx.compose.foundation.interaction.MutableInteractionSource r54, androidx.compose.ui.graphics.Brush r55, boolean r56, int r57, int r58, androidx.compose.ui.text.input.ImeOptions r59, androidx.compose.foundation.text.KeyboardActions r60, boolean r61, boolean r62, kotlin.jvm.functions.Function3 r63, androidx.compose.foundation.text.TextFieldScrollerPosition r64, androidx.compose.runtime.Composer r65, final int r66, final int r67, final int r68) {
        /*
            Method dump skipped, instruction units count: 2728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.a(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.foundation.text.TextFieldScrollerPosition, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-20551815);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-20551815, i4, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:668)");
            }
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), true);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ContextMenu_androidKt.c(textFieldSelectionManager, function2, composerK, (i4 >> 3) & 126);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    CoreTextFieldKt.c(modifier, textFieldSelectionManager, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final TextFieldSelectionManager textFieldSelectionManager, final boolean z2, Composer composer, final int i3) {
        int i4;
        TextLayoutResultProxy textLayoutResultProxyL;
        TextLayoutResult textLayoutResultF;
        Composer composerK = composer.k(626339208);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(textFieldSelectionManager) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(626339208, i4, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1018)");
            }
            if (z2) {
                composerK.a0(-1290924834);
                LegacyTextFieldState legacyTextFieldStateP = textFieldSelectionManager.P();
                TextLayoutResult textLayoutResult = null;
                if (legacyTextFieldStateP != null && (textLayoutResultProxyL = legacyTextFieldStateP.l()) != null && (textLayoutResultF = textLayoutResultProxyL.f()) != null) {
                    LegacyTextFieldState legacyTextFieldStateP2 = textFieldSelectionManager.P();
                    if (!(legacyTextFieldStateP2 != null ? legacyTextFieldStateP2.B() : true)) {
                        textLayoutResult = textLayoutResultF;
                    }
                }
                if (textLayoutResult == null) {
                    composerK.a0(-1290601288);
                } else {
                    composerK.a0(-1290601287);
                    if (TextRange.h(textFieldSelectionManager.U().h())) {
                        composerK.a0(-1684179174);
                        composerK.U();
                    } else {
                        composerK.a0(-1685230508);
                        int iB = textFieldSelectionManager.N().b(TextRange.n(textFieldSelectionManager.U().h()));
                        int iB2 = textFieldSelectionManager.N().b(TextRange.i(textFieldSelectionManager.U().h()));
                        ResolvedTextDirection resolvedTextDirectionC = textLayoutResult.c(iB);
                        ResolvedTextDirection resolvedTextDirectionC2 = textLayoutResult.c(Math.max(iB2 - 1, 0));
                        LegacyTextFieldState legacyTextFieldStateP3 = textFieldSelectionManager.P();
                        if (legacyTextFieldStateP3 == null || !legacyTextFieldStateP3.w()) {
                            composerK.a0(-1684548198);
                            composerK.U();
                        } else {
                            composerK.a0(-1684812473);
                            TextFieldSelectionManagerKt.a(true, resolvedTextDirectionC, textFieldSelectionManager, composerK, ((i4 << 6) & 896) | 6);
                            composerK.U();
                        }
                        LegacyTextFieldState legacyTextFieldStateP4 = textFieldSelectionManager.P();
                        if (legacyTextFieldStateP4 == null || !legacyTextFieldStateP4.v()) {
                            composerK.a0(-1684200998);
                            composerK.U();
                        } else {
                            composerK.a0(-1684464312);
                            TextFieldSelectionManagerKt.a(false, resolvedTextDirectionC2, textFieldSelectionManager, composerK, ((i4 << 6) & 896) | 6);
                            composerK.U();
                        }
                        composerK.U();
                    }
                    LegacyTextFieldState legacyTextFieldStateP5 = textFieldSelectionManager.P();
                    if (legacyTextFieldStateP5 != null) {
                        if (textFieldSelectionManager.Y()) {
                            legacyTextFieldStateP5.O(false);
                        }
                        if (legacyTextFieldStateP5.f()) {
                            if (legacyTextFieldStateP5.u()) {
                                textFieldSelectionManager.t0();
                            } else {
                                textFieldSelectionManager.X();
                            }
                        }
                        Unit unit = Unit.f139807a;
                    }
                }
                composerK.U();
                composerK.U();
            } else {
                composerK.a0(651160447);
                composerK.U();
                textFieldSelectionManager.X();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    CoreTextFieldKt.d(textFieldSelectionManager, z2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void e(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i3) {
        int i4;
        AnnotatedString annotatedStringS;
        Composer composerK = composer.k(-1436003720);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(textFieldSelectionManager) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1436003720, i4, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1065)");
            }
            LegacyTextFieldState legacyTextFieldStateP = textFieldSelectionManager.P();
            if (legacyTextFieldStateP == null || !legacyTextFieldStateP.t() || (annotatedStringS = textFieldSelectionManager.S()) == null || annotatedStringS.length() <= 0) {
                composerK.a0(-288632802);
                composerK.U();
            } else {
                composerK.a0(-289940723);
                boolean Z = composerK.Z(textFieldSelectionManager);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = textFieldSelectionManager.t();
                    composerK.w(objG);
                }
                final TextDragObserver textDragObserver = (TextDragObserver) objG;
                final long jE = textFieldSelectionManager.E((Density) composerK.q(CompositionLocalsKt.f()));
                boolean zF = composerK.f(jE);
                Object objG2 = composerK.G();
                if (zF || objG2 == Composer.f23746a.a()) {
                    objG2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        public final long a() {
                            return jE;
                        }
                    };
                    composerK.w(objG2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) objG2;
                Modifier.Companion companion = Modifier.b8;
                boolean zI = composerK.I(textDragObserver) | composerK.I(textFieldSelectionManager);
                Object objG3 = composerK.G();
                if (zI || objG3 == Composer.f23746a.a()) {
                    objG3 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1

                        /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                        @Metadata
                        @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1", f = "CoreTextField.kt", l = {}, m = "invokeSuspend")
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            int f9676a;

                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                            private /* synthetic */ Object f9677b;

                            /* JADX INFO: renamed from: c, reason: collision with root package name */
                            final /* synthetic */ PointerInputScope f9678c;

                            /* JADX INFO: renamed from: d, reason: collision with root package name */
                            final /* synthetic */ TextDragObserver f9679d;

                            /* JADX INFO: renamed from: f, reason: collision with root package name */
                            final /* synthetic */ TextFieldSelectionManager f9680f;

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            @Metadata
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1", f = "CoreTextField.kt", l = {1078}, m = "invokeSuspend")
                            static final class C00231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                int f9681a;

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                final /* synthetic */ PointerInputScope f9682b;

                                /* JADX INFO: renamed from: c, reason: collision with root package name */
                                final /* synthetic */ TextDragObserver f9683c;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00231(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation continuation) {
                                    super(2, continuation);
                                    this.f9682b = pointerInputScope;
                                    this.f9683c = textDragObserver;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Object obj, Continuation continuation) {
                                    return new C00231(this.f9682b, this.f9683c, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) throws Throwable {
                                    Object objF = IntrinsicsKt.f();
                                    int i3 = this.f9681a;
                                    if (i3 == 0) {
                                        ResultKt.b(obj);
                                        PointerInputScope pointerInputScope = this.f9682b;
                                        TextDragObserver textDragObserver = this.f9683c;
                                        this.f9681a = 1;
                                        if (LongPressTextDragObserverKt.c(pointerInputScope, textDragObserver, this) == objF) {
                                            return objF;
                                        }
                                    } else {
                                        if (i3 != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.b(obj);
                                    }
                                    return Unit.f139807a;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                    return ((C00231) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                                }
                            }

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2, reason: invalid class name */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            /* JADX INFO: loaded from: classes2.dex */
                            @Metadata
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2", f = "CoreTextField.kt", l = {1081}, m = "invokeSuspend")
                            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                int f9684a;

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                final /* synthetic */ PointerInputScope f9685b;

                                /* JADX INFO: renamed from: c, reason: collision with root package name */
                                final /* synthetic */ TextFieldSelectionManager f9686c;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionManager textFieldSelectionManager, Continuation continuation) {
                                    super(2, continuation);
                                    this.f9685b = pointerInputScope;
                                    this.f9686c = textFieldSelectionManager;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Object obj, Continuation continuation) {
                                    return new AnonymousClass2(this.f9685b, this.f9686c, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) throws Throwable {
                                    Object objF = IntrinsicsKt.f();
                                    int i3 = this.f9684a;
                                    if (i3 != 0) {
                                        if (i3 == 1) {
                                            ResultKt.b(obj);
                                        } else {
                                            throw new IllegalStateException(SbbqvQlxi.tqMHoMJMgD);
                                        }
                                    } else {
                                        ResultKt.b(obj);
                                        PointerInputScope pointerInputScope = this.f9685b;
                                        final TextFieldSelectionManager textFieldSelectionManager = this.f9686c;
                                        Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle.2.1.1.2.1
                                            {
                                                super(1);
                                            }

                                            public final void c(long j3) {
                                                textFieldSelectionManager.t0();
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                c(((Offset) obj2).u());
                                                return Unit.f139807a;
                                            }
                                        };
                                        this.f9684a = 1;
                                        if (TapGestureDetectorKt.m(pointerInputScope, null, null, null, function1, this, 7, null) == objF) {
                                            return objF;
                                        }
                                    }
                                    return Unit.f139807a;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, TextFieldSelectionManager textFieldSelectionManager, Continuation continuation) {
                                super(2, continuation);
                                this.f9678c = pointerInputScope;
                                this.f9679d = textDragObserver;
                                this.f9680f = textFieldSelectionManager;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object obj, Continuation continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f9678c, this.f9679d, this.f9680f, continuation);
                                anonymousClass1.f9677b = obj;
                                return anonymousClass1;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) throws Throwable {
                                IntrinsicsKt.f();
                                if (this.f9676a != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj);
                                CoroutineScope coroutineScope = (CoroutineScope) this.f9677b;
                                CoroutineStart coroutineStart = CoroutineStart.f140919d;
                                BuildersKt__Builders_commonKt.d(coroutineScope, null, coroutineStart, new C00231(this.f9678c, this.f9679d, null), 1, null);
                                BuildersKt__Builders_commonKt.d(coroutineScope, null, coroutineStart, new AnonymousClass2(this.f9678c, this.f9680f, null), 1, null);
                                return Unit.f139807a;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                            Object objF = CoroutineScopeKt.f(new AnonymousClass1(pointerInputScope, textDragObserver, textFieldSelectionManager, null), continuation);
                            return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
                        }
                    };
                    composerK.w(objG3);
                }
                Modifier modifierD = SuspendingPointerInputFilterKt.d(companion, textDragObserver, (PointerInputEventHandler) objG3);
                boolean zF2 = composerK.f(jE);
                Object objG4 = composerK.G();
                if (zF2 || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            semanticsPropertyReceiver.a(SelectionHandlesKt.d(), new SelectionHandleInfo(Handle.f9697a, jE, SelectionHandleAnchor.f11376b, true, null));
                        }
                    };
                    composerK.w(objG4);
                }
                AndroidCursorHandle_androidKt.a(offsetProvider, SemanticsModifierKt.f(modifierD, false, (Function1) objG4, 1, null), 0L, composerK, 0, 4);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    CoreTextFieldKt.e(textFieldSelectionManager, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final Object l(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation continuation) {
        int iB = offsetMapping.b(TextRange.k(textFieldValue.h()));
        Object objB = bringIntoViewRequester.b(iB < textLayoutResult.l().j().length() ? textLayoutResult.d(iB) : iB != 0 ? textLayoutResult.d(iB - 1) : new Rect(0.0f, 0.0f, 1.0f, (int) (TextFieldDelegateKt.b(textDelegate.j(), textDelegate.a(), textDelegate.b(), null, 0, 24, null) & 4294967295L)), continuation);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession textInputSessionH = legacyTextFieldState.h();
        if (textInputSessionH != null) {
            TextFieldDelegate.f9925a.f(textInputSessionH, legacyTextFieldState.p(), legacyTextFieldState.o());
        }
        legacyTextFieldState.H(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState.l();
            if (textLayoutResultProxyL == null) {
                return;
            }
            TextInputSession textInputSessionH = legacyTextFieldState.h();
            if (textInputSessionH == null) {
                return;
            }
            LayoutCoordinates layoutCoordinatesK = legacyTextFieldState.k();
            if (layoutCoordinatesK == null) {
                return;
            }
            TextFieldDelegate.f9925a.e(textFieldValue, legacyTextFieldState.x(), textLayoutResultProxyL.f(), layoutCoordinatesK, textInputSessionH, legacyTextFieldState.f(), offsetMapping);
            Unit unit = Unit.f139807a;
        } finally {
            companion.m(snapshotD, snapshotE, function1G);
        }
    }

    private static final Modifier o(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.b(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean c(android.view.KeyEvent keyEvent) {
                boolean z2;
                if (legacyTextFieldState.e() == HandleState.f9703b && KeyEventHelpers_androidKt.a(keyEvent)) {
                    z2 = true;
                    TextFieldSelectionManager.w(textFieldSelectionManager, null, 1, null);
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((KeyEvent) obj).f());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        legacyTextFieldState.H(TextFieldDelegate.f9925a.h(textInputService, textFieldValue, legacyTextFieldState.p(), imeOptions, legacyTextFieldState.o(), legacyTextFieldState.n()));
        n(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    public static final void q(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z2) {
        SoftwareKeyboardController softwareKeyboardControllerJ;
        if (!legacyTextFieldState.f()) {
            FocusRequester.h(focusRequester, 0, 1, null);
        } else {
            if (!z2 || (softwareKeyboardControllerJ = legacyTextFieldState.j()) == null) {
                return;
            }
            softwareKeyboardControllerJ.show();
        }
    }
}
