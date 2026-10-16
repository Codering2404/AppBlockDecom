package cz.mobilesoft.coreblock.scene.selection.base.selectionscreens;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.selection.BlockingSelectScreenDialogsKt;
import cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewEvent;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.scene.selection.components.KeywordsHintKt;
import cz.mobilesoft.coreblock.scene.selection.hint.KeywordsLearnMoreActivity;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class BaseWebsiteSelectionScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(final Context context, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-969805508, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreen.<anonymous>.<anonymous>.<anonymous> (BaseWebsiteSelectionScreen.kt:134)");
            }
            Modifier modifierJ = PaddingKt.j(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(16), Dp.g(8));
            boolean zI = composer.I(context);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseWebsiteSelectionScreenKt.B(context);
                    }
                };
                composer.w(objG);
            }
            KeywordsHintKt.c(modifierJ, (Function0) objG, composer, 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Context context) {
        context.startActivity(KeywordsLearnMoreActivity.f119096f.a(context));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object C(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return entry.getKey();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void D(final java.lang.String r19, androidx.compose.ui.Modifier r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt.D(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String E(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    private static final boolean G(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(String str, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        D(str, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void J(cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation.BlockingType r22, java.lang.String r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt.J(cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation$BlockingType, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(WebsiteProfileRelation.BlockingType blockingType, String str, int i3, int i4, Composer composer, int i5) {
        J(blockingType, str, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void L(androidx.compose.ui.Modifier r16, final androidx.compose.material.ScaffoldState r17, final cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO r18, final kotlin.jvm.functions.Function1 r19, java.util.List r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt.L(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO, kotlin.jvm.functions.Function1, java.util.List, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(WebsiteStateDTO websiteStateDTO, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(500393429, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.WebsiteItem.<anonymous> (BaseWebsiteSelectionScreen.kt:275)");
            }
            J(websiteStateDTO.c().c(), websiteStateDTO.c().a(), composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Modifier modifier, ScaffoldState scaffoldState, WebsiteStateDTO websiteStateDTO, Function1 function1, List list, int i3, int i4, Composer composer, int i5) {
        L(modifier, scaffoldState, websiteStateDTO, function1, list, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void p(final BaseSelectionViewState.WebsiteKeywordsViewState viewState, WebsiteProfileRelation.BlockingType blockingType, Profile.BlockingMode blockingMode, final LazyListState lazyListState, final ScaffoldState scaffoldState, final Function1 onEvent, Composer composer, final int i3, final int i4) {
        int i5;
        final Function1 function1;
        Composer composer2;
        final Profile.BlockingMode blockingMode2;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        boolean z3;
        Profile.BlockingMode blockingMode3;
        MutableState mutableState4;
        final MutableState mutableState5;
        final MutableState mutableState6;
        final WebsiteProfileRelation.BlockingType blockingType2 = blockingType;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(blockingType2, "blockingType");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(1459673100);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(viewState) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.e(blockingType2.ordinal()) ? 32 : 16;
        }
        int i10 = i4 & 4;
        if (i10 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.e(blockingMode == null ? -1 : blockingMode.ordinal()) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(lazyListState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.Z(scaffoldState) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(onEvent) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            Profile.BlockingMode blockingMode4 = i10 != 0 ? Profile.BlockingMode.Blocklist : blockingMode;
            if (ComposerKt.M()) {
                ComposerKt.U(1459673100, i5, -1, "cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreen (BaseWebsiteSelectionScreen.kt:100)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(new TextFieldValue("", 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState7 = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState8 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState9 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG4);
            }
            MutableState mutableState10 = (MutableState) objG4;
            Object objG5 = composerK.G();
            final Profile.BlockingMode blockingMode5 = blockingMode4;
            if (objG5 == companion.a()) {
                objG5 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG5);
            }
            MutableState mutableState11 = (MutableState) objG5;
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                objG6 = new FocusRequester();
                composerK.w(objG6);
            }
            FocusRequester focusRequester = (FocusRequester) objG6;
            Object value = mutableState8.getValue();
            Object objG7 = composerK.G();
            if (objG7 == companion.a()) {
                objG7 = new BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$1$1(mutableState8, focusRequester, mutableState7, null);
                composerK.w(objG7);
            }
            EffectsKt.g(value, (Function2) objG7, composerK, 0);
            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
            int i11 = i5 & 112;
            int i12 = 458752 & i5;
            boolean zI = ((i5 & 896) == 256) | (i11 == 32) | composerK.I(viewState) | composerK.I(context) | ((57344 & i5) == 16384) | (i12 == 131072);
            Object objG8 = composerK.G();
            if (zI || objG8 == companion.a()) {
                mutableState = mutableState10;
                mutableState2 = mutableState11;
                mutableState3 = mutableState9;
                i6 = i5;
                i7 = i11;
                i8 = i12;
                i9 = 131072;
                z2 = false;
                z3 = true;
                Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseWebsiteSelectionScreenKt.z(blockingType2, viewState, blockingMode5, context, scaffoldState, onEvent, mutableState8, mutableState, mutableState2, mutableState7, mutableState3, (LazyListScope) obj);
                    }
                };
                blockingMode3 = blockingMode5;
                mutableState4 = mutableState8;
                composerK.w(function12);
                objG8 = function12;
            } else {
                blockingMode3 = blockingMode5;
                i7 = i11;
                i8 = i12;
                mutableState = mutableState10;
                mutableState4 = mutableState8;
                mutableState2 = mutableState11;
                mutableState3 = mutableState9;
                i9 = 131072;
                z2 = false;
                z3 = true;
                i6 = i5;
            }
            int i13 = ((i6 >> 6) & 112) | 6;
            MutableState mutableState12 = mutableState3;
            MutableState mutableState13 = mutableState2;
            final MutableState mutableState14 = mutableState;
            composer2 = composerK;
            int i14 = i6;
            int i15 = i9;
            function1 = onEvent;
            LazyDslKt.b(modifierF, lazyListState, null, false, null, null, null, false, null, (Function1) objG8, composer2, i13, 508);
            TextFieldValue textFieldValueQ = q(mutableState7);
            BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType = (BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType) mutableState13.getValue();
            if (keywordType == null) {
                keywordType = BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType.Domain;
            }
            BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType2 = keywordType;
            int i16 = i8;
            boolean z4 = i16 == i15 ? z3 : z2;
            Object objG9 = composer2.G();
            if (z4 || objG9 == companion.a()) {
                mutableState5 = mutableState7;
                mutableState6 = mutableState13;
                objG9 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseWebsiteSelectionScreenKt.r(mutableState14, function1, mutableState6, mutableState5);
                    }
                };
                composer2.w(objG9);
            } else {
                mutableState5 = mutableState7;
                mutableState6 = mutableState13;
            }
            Function0 function0 = (Function0) objG9;
            Object objG10 = composer2.G();
            if (objG10 == companion.a()) {
                objG10 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseWebsiteSelectionScreenKt.s(mutableState14, mutableState5);
                    }
                };
                composer2.w(objG10);
            }
            Function0 function02 = (Function0) objG10;
            Object objG11 = composer2.G();
            if (objG11 == companion.a()) {
                objG11 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseWebsiteSelectionScreenKt.t(mutableState5, (TextFieldValue) obj);
                    }
                };
                composer2.w(objG11);
            }
            Function1 function13 = (Function1) objG11;
            Object objG12 = composer2.G();
            if (objG12 == companion.a()) {
                objG12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseWebsiteSelectionScreenKt.u(mutableState6, (BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType) obj);
                    }
                };
                composer2.w(objG12);
            }
            Function1 function14 = (Function1) objG12;
            int i17 = i7;
            boolean zI2 = composer2.I(viewState) | (i17 == 32 ? z3 : z2);
            Object objG13 = composer2.G();
            if (zI2 || objG13 == companion.a()) {
                blockingType2 = blockingType;
                objG13 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(BaseWebsiteSelectionScreenKt.v(blockingType2, viewState, (String) obj));
                    }
                };
                composer2.w(objG13);
            } else {
                blockingType2 = blockingType;
            }
            BlockingSelectScreenDialogsKt.B(mutableState4, textFieldValueQ, focusRequester, keywordType2, function0, function02, function13, function14, blockingType2, (Function1) objG13, composer2, ((i14 << 21) & 234881024) | 14352774);
            boolean z5 = i16 == i15 ? z3 : z2;
            Object objG14 = composer2.G();
            if (z5 || objG14 == companion.a()) {
                objG14 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseWebsiteSelectionScreenKt.w(mutableState14, function1);
                    }
                };
                composer2.w(objG14);
            }
            BlockingSelectScreenDialogsKt.q(mutableState12, blockingType2, (Function0) objG14, composer2, i17 | 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            blockingMode2 = blockingMode3;
        } else {
            function1 = onEvent;
            composer2 = composerK;
            composer2.Q();
            blockingMode2 = blockingMode;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final WebsiteProfileRelation.BlockingType blockingType3 = blockingType2;
            final Function1 function15 = function1;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseWebsiteSelectionScreenKt.x(viewState, blockingType3, blockingMode2, lazyListState, scaffoldState, function15, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue q(MutableState mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(MutableState mutableState, Function1 function1, MutableState mutableState2, MutableState mutableState3) {
        WebsiteStateDTO websiteStateDTO = (WebsiteStateDTO) mutableState.getValue();
        if (websiteStateDTO != null) {
            function1.invoke(new BaseSelectionViewEvent.OnWebsiteOrKeywordChangeConfirmed(websiteStateDTO.c(), q(mutableState3).i(), mutableState2.getValue() == BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType.AnywhereInUrl));
            mutableState.setValue(null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState, MutableState mutableState2) {
        y(mutableState2, TextFieldValue.e(q(mutableState2), "", 0L, null, 6, null));
        mutableState.setValue(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState, TextFieldValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        y(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MutableState mutableState, BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(WebsiteProfileRelation.BlockingType blockingType, BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return blockingType == WebsiteProfileRelation.BlockingType.DOMAIN ? websiteKeywordsViewState.p(it) : websiteKeywordsViewState.n(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(MutableState mutableState, Function1 function1) {
        WebsiteStateDTO websiteStateDTO = (WebsiteStateDTO) mutableState.getValue();
        if (websiteStateDTO != null) {
            function1.invoke(new BaseSelectionViewEvent.OnWebsiteOrKeywordDeleted(websiteStateDTO.c()));
            mutableState.setValue(null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewState, WebsiteProfileRelation.BlockingType blockingType, Profile.BlockingMode blockingMode, LazyListState lazyListState, ScaffoldState scaffoldState, Function1 function1, int i3, int i4, Composer composer, int i5) {
        p(websiteKeywordsViewState, blockingType, blockingMode, lazyListState, scaffoldState, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(final WebsiteProfileRelation.BlockingType blockingType, final BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewState, Profile.BlockingMode blockingMode, final Context context, final ScaffoldState scaffoldState, final Function1 function1, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (blockingType == WebsiteProfileRelation.BlockingType.KEYWORD) {
            Set setEntrySet = websiteKeywordsViewState.l().entrySet();
            if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
                LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-969805508, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.d
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BaseWebsiteSelectionScreenKt.A(context, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, null);
            } else {
                Iterator it = setEntrySet.iterator();
                while (it.hasNext()) {
                    if (((WebsiteStateDTO) ((Map.Entry) it.next()).getValue()).c().c() == blockingType) {
                        break;
                    }
                }
                LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-969805508, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.d
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BaseWebsiteSelectionScreenKt.A(context, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, null);
            }
        }
        if (blockingMode != Profile.BlockingMode.Allowlist || blockingType != WebsiteProfileRelation.BlockingType.DOMAIN) {
            lazyListScope = LazyColumn;
            break;
        }
        Set<Map.Entry> setEntrySet2 = websiteKeywordsViewState.l().entrySet();
        if (!(setEntrySet2 instanceof Collection) || !setEntrySet2.isEmpty()) {
            for (Map.Entry entry : setEntrySet2) {
                if (((WebsiteStateDTO) entry.getValue()).c().c() == blockingType && !websiteKeywordsViewState.o(((WebsiteStateDTO) entry.getValue()).c())) {
                    lazyListScope = LazyColumn;
                    break;
                }
            }
        }
        LazyListScope.c(LazyColumn, null, null, ComposableSingletons$BaseWebsiteSelectionScreenKt.f118782a.d(), 3, null);
        lazyListScope = LazyColumn;
        List list = CollectionsKt.toList(websiteKeywordsViewState.l().entrySet());
        final ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Map.Entry entry2 = (Map.Entry) obj;
            if (((WebsiteStateDTO) entry2.getValue()).c().c() == blockingType && (blockingMode != Profile.BlockingMode.Allowlist || !websiteKeywordsViewState.o(((WebsiteStateDTO) entry2.getValue()).c()))) {
                arrayList.add(obj);
            }
        }
        final Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return BaseWebsiteSelectionScreenKt.C((Map.Entry) obj2);
            }
        };
        final BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$lambda$9$0$$inlined$items$default$1 baseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$lambda$9$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$lambda$9$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj2) {
                return null;
            }
        };
        lazyListScope.h(arrayList.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$lambda$9$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }

            public final Object invoke(int i3) {
                return function12.invoke(arrayList.get(i3));
            }
        }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$lambda$9$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }

            public final Object invoke(int i3) {
                return baseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$lambda$9$0$$inlined$items$default$1.invoke(arrayList.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$lambda$9$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) throws XmlPullParserException, IOException {
                invoke((LazyItemScope) obj2, ((Number) obj3).intValue(), (Composer) obj4, ((Number) obj5).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
                int i5;
                List listEmptyList;
                if ((i4 & 6) == 0) {
                    i5 = i4 | (composer.Z(lazyItemScope) ? 4 : 2);
                } else {
                    i5 = i4;
                }
                if ((i4 & 48) == 0) {
                    i5 |= composer.e(i3) ? 32 : 16;
                }
                if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                Map.Entry entry3 = (Map.Entry) arrayList.get(i3);
                composer.a0(1315281882);
                final WebsiteStateDTO websiteStateDTO = (WebsiteStateDTO) entry3.getValue();
                if (websiteKeywordsViewState.o(websiteStateDTO.c())) {
                    composer.a0(1427978325);
                    composer.U();
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    composer.a0(1315652920);
                    String strB = StringResources_androidKt.b(blockingType == WebsiteProfileRelation.BlockingType.DOMAIN ? R.string.Qc : R.string.Oc, composer, 0);
                    long jB = ComposeColorsKt.j(composer, 0).b();
                    ImageVector.Companion companion = ImageVector.f26323k;
                    ImageVector imageVectorB = VectorResources_androidKt.b(companion, R.drawable.W1, composer, 6);
                    boolean zD = websiteStateDTO.d();
                    Color colorN = Color.n(jB);
                    Boolean bool = Boolean.TRUE;
                    boolean zI = composer.I(websiteStateDTO);
                    Object objG = composer.G();
                    if (zI || objG == Composer.f23746a.a()) {
                        final MutableState mutableState6 = mutableState;
                        final MutableState mutableState7 = mutableState2;
                        final MutableState mutableState8 = mutableState3;
                        final MutableState mutableState9 = mutableState4;
                        Object obj2 = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$2$1$6$1$1
                            public final void c() {
                                MutableState mutableState10 = mutableState9;
                                BaseWebsiteSelectionScreenKt.y(mutableState10, TextFieldValue.e(BaseWebsiteSelectionScreenKt.q(mutableState10), websiteStateDTO.c().a(), 0L, null, 6, null));
                                mutableState6.setValue(Boolean.TRUE);
                                mutableState7.setValue(websiteStateDTO);
                                MutableState mutableState11 = mutableState8;
                                WebsiteDTO websiteDTOC = websiteStateDTO.c();
                                BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType = null;
                                if (websiteDTOC.c() != WebsiteProfileRelation.BlockingType.KEYWORD) {
                                    websiteDTOC = null;
                                }
                                if (websiteDTOC != null) {
                                    keywordType = websiteDTOC.d() ? BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType.AnywhereInUrl : BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType.Domain;
                                }
                                mutableState11.setValue(keywordType);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                c();
                                return Unit.f139807a;
                            }
                        };
                        composer.w(obj2);
                        objG = obj2;
                    }
                    ComposeDropdownItem composeDropdownItem = new ComposeDropdownItem(strB, colorN, null, zD, bool, null, imageVectorB, null, (Function0) objG, 164, null);
                    String strB2 = StringResources_androidKt.b(R.string.q9, composer, 0);
                    long jK = ComposeColorsKt.j(composer, 0).k();
                    ImageVector imageVectorB2 = VectorResources_androidKt.b(companion, R.drawable.P0, composer, 6);
                    boolean zD2 = websiteStateDTO.d();
                    Color colorN2 = Color.n(jK);
                    boolean zI2 = composer.I(websiteStateDTO);
                    Object objG2 = composer.G();
                    if (zI2 || objG2 == Composer.f23746a.a()) {
                        final MutableState mutableState10 = mutableState5;
                        final MutableState mutableState11 = mutableState2;
                        objG2 = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$2$1$6$2$1
                            public final void c() {
                                mutableState10.setValue(Boolean.TRUE);
                                mutableState11.setValue(websiteStateDTO);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                c();
                                return Unit.f139807a;
                            }
                        };
                        composer.w(objG2);
                    }
                    listEmptyList = CollectionsKt.listOf((Object[]) new ComposeDropdownItem[]{composeDropdownItem, new ComposeDropdownItem(strB2, colorN2, null, zD2, bool, null, imageVectorB2, null, (Function0) objG2, 164, null)});
                    composer.U();
                }
                List list2 = listEmptyList;
                ScaffoldState scaffoldState2 = scaffoldState;
                boolean Z = composer.Z(function1) | composer.I(websiteStateDTO);
                Object objG3 = composer.G();
                if (Z || objG3 == Composer.f23746a.a()) {
                    final Function1 function13 = function1;
                    objG3 = new Function1<Boolean, Unit>() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$2$1$6$3$1
                        public final void c(boolean z2) {
                            function13.invoke(new BaseSelectionViewEvent.OnWebsiteOrKeywordSelected(websiteStateDTO, z2));
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                            c(((Boolean) obj3).booleanValue());
                            return Unit.f139807a;
                        }
                    };
                    composer.w(objG3);
                }
                BaseWebsiteSelectionScreenKt.L(null, scaffoldState2, websiteStateDTO, (Function1) objG3, list2, composer, WebsiteStateDTO.f118099e << 6, 1);
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }
}
