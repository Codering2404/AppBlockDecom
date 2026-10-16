package cz.mobilesoft.coreblock.scene.selection.components;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO;
import cz.mobilesoft.coreblock.scene.selection.SubAppStateDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class ApplicationItemKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final android.graphics.drawable.Drawable r30, boolean r31, java.lang.Integer r32, boolean r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 1013
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.components.ApplicationItemKt.k(android.graphics.drawable.Drawable, boolean, java.lang.Integer, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Drawable drawable, boolean z2, Integer num, boolean z3, int i3, int i4, Composer composer, int i5) {
        k(drawable, z2, num, z3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void m(Modifier modifier, final ScaffoldState scaffoldState, final ApplicationStateDTO item, final Function1 onClicked, final boolean z2, Profile.BlockingMode blockingMode, Function2 function2, PremiumState premiumState, List list, Composer composer, final int i3, final int i4) {
        int i5;
        Function2 function22;
        Profile.BlockingMode blockingMode2;
        final Modifier modifier2;
        final PremiumState premiumState2;
        final List list2;
        final Function2 function23;
        String strB;
        Function2 function24;
        final Function2 function25;
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onClicked, "onClicked");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Composer composerK = composer.k(-562228736);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= (i3 & 512) == 0 ? composerK.Z(item) : composerK.I(item) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(onClicked) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.e(blockingMode.ordinal()) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i7 = i4 & 64;
        if (i7 != 0) {
            i5 |= 1572864;
            function22 = function2;
        } else {
            function22 = function2;
            if ((i3 & 1572864) == 0) {
                i5 |= composerK.I(function22) ? 1048576 : 524288;
            }
        }
        int i8 = i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i8 != 0) {
            i5 |= 12582912;
        } else if ((i3 & 12582912) == 0) {
            i5 |= composerK.Z(premiumState) ? 8388608 : 4194304;
        }
        int i9 = i4 & Function.MAX_NARGS;
        if (i9 != 0) {
            i5 |= 100663296;
        } else if ((i3 & 100663296) == 0) {
            i5 |= composerK.I(list) ? 67108864 : 33554432;
        }
        if (composerK.r((i5 & 38347923) != 38347922, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier;
            if (i7 != 0) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ApplicationItemKt.n((SubAppStateDTO) obj, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composerK.w(objG);
                }
                function22 = (Function2) objG;
            }
            PremiumState premiumState3 = i8 != 0 ? PremiumState.None.INSTANCE : premiumState;
            List listEmptyList = i9 != 0 ? CollectionsKt.emptyList() : list;
            if (ComposerKt.M()) {
                ComposerKt.U(-562228736, i5, -1, "cz.mobilesoft.coreblock.scene.selection.components.ApplicationItem (ApplicationItem.kt:95)");
            }
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = new AppIconCache();
                composerK.w(objG2);
            }
            AppIconCache appIconCache = (AppIconCache) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(new ColorDrawable(Color.z(Color.f25715b.j())), null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState = (MutableState) objG3;
            if (((Boolean) composerK.q(InspectionModeKt.a())).booleanValue()) {
                composerK.a0(1012457250);
            } else {
                composerK.a0(1016829149);
                String strF = item.c().f();
                boolean z3 = (i5 & 896) == 256 || ((i5 & 512) != 0 && composerK.I(item));
                Object objG4 = composerK.G();
                if (z3 || objG4 == companion.a()) {
                    objG4 = new ApplicationItemKt$ApplicationItem$2$1(appIconCache, item, mutableState, null);
                    composerK.w(objG4);
                }
                EffectsKt.g(strF, (Function2) objG4, composerK, 0);
            }
            composerK.U();
            Modifier modifierM = PaddingKt.m(Modifier.b8, z2 ? Dp.g(28) : Dp.g(0), 0.0f, 0.0f, 0.0f, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Modifier modifier4 = modifier3;
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strD = item.c().d();
            boolean zH = item.c().h();
            boolean zG = item.c().g();
            if (item.c().i()) {
                composerK.a0(1619667775);
                strB = StringResources_androidKt.b(R.string.ZE, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(-1329861049);
                composerK.U();
                strB = null;
            }
            int i10 = i5 & 14;
            int i11 = i5 & 112;
            int i12 = i5;
            blockingMode2 = blockingMode;
            Function2 function26 = function22;
            s(modifier4, scaffoldState, strD, strB, zH, zG, listEmptyList, onClicked, false, false, ComposableLambdaKt.e(-1764126408, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ApplicationItemKt.o(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i5 & 126) | ((i5 >> 6) & 3670016) | ((i5 << 12) & 29360128), 6, 768);
            List list3 = listEmptyList;
            if (blockingMode2 == Profile.BlockingMode.Blocklist) {
                composerK.a0(-1334970963);
                for (final SubAppStateDTO subAppStateDTO : item.d()) {
                    String strB2 = StringResources_androidKt.b(subAppStateDTO.c().getTitle(), composerK, 0);
                    boolean zE = subAppStateDTO.e();
                    boolean z4 = !item.c().h() && subAppStateDTO.d();
                    boolean zI = composerK.I(subAppStateDTO) | ((i12 & 3670016) == 1048576);
                    Object objG5 = composerK.G();
                    if (zI || objG5 == Composer.f23746a.a()) {
                        function25 = function26;
                        objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.components.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ApplicationItemKt.p(function25, subAppStateDTO, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerK.w(objG5);
                    } else {
                        function25 = function26;
                    }
                    s(modifier4, scaffoldState, strB2, null, zE, z4, null, (Function1) objG5, true, !premiumState3.g(), ComposableLambdaKt.e(1611377141, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.j
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ApplicationItemKt.q(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerK, 54), composerK, i10 | 100663296 | i11, 6, 72);
                    function26 = function25;
                }
                function24 = function26;
            } else {
                function24 = function26;
                composerK.a0(-1334970964);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
            premiumState2 = premiumState3;
            list2 = list3;
            function23 = function24;
        } else {
            blockingMode2 = blockingMode;
            composerK.Q();
            modifier2 = modifier;
            premiumState2 = premiumState;
            list2 = list;
            function23 = function22;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Profile.BlockingMode blockingMode3 = blockingMode2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ApplicationItemKt.r(modifier2, scaffoldState, item, onClicked, z2, blockingMode3, function23, premiumState2, list2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(SubAppStateDTO subAppStateDTO, boolean z2) {
        Intrinsics.checkNotNullParameter(subAppStateDTO, "<unused var>");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1764126408, i3, -1, "cz.mobilesoft.coreblock.scene.selection.components.ApplicationItem.<anonymous>.<anonymous> (ApplicationItem.kt:116)");
            }
            k((Drawable) mutableState.getValue(), false, null, false, composer, 0, 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function2 function2, SubAppStateDTO subAppStateDTO, boolean z2) {
        function2.invoke(subAppStateDTO, Boolean.valueOf(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1611377141, i3, -1, "cz.mobilesoft.coreblock.scene.selection.components.ApplicationItem.<anonymous>.<anonymous> (ApplicationItem.kt:132)");
            }
            k((Drawable) mutableState.getValue(), true, null, false, composer, 48, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Modifier modifier, ScaffoldState scaffoldState, ApplicationStateDTO applicationStateDTO, Function1 function1, boolean z2, Profile.BlockingMode blockingMode, Function2 function2, PremiumState premiumState, List list, int i3, int i4, Composer composer, int i5) {
        m(modifier, scaffoldState, applicationStateDTO, function1, z2, blockingMode, function2, premiumState, list, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:239:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void s(final androidx.compose.ui.Modifier r51, final androidx.compose.material.ScaffoldState r52, final java.lang.String r53, java.lang.String r54, final boolean r55, boolean r56, java.util.List r57, final kotlin.jvm.functions.Function1 r58, boolean r59, boolean r60, final kotlin.jvm.functions.Function2 r61, androidx.compose.runtime.Composer r62, final int r63, final int r64, final int r65) {
        /*
            Method dump skipped, instruction units count: 1798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.components.ApplicationItemKt.s(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, java.lang.String, java.lang.String, boolean, boolean, java.util.List, kotlin.jvm.functions.Function1, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1, boolean z2) {
        function1.invoke(Boolean.valueOf(!z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Modifier modifier, ScaffoldState scaffoldState, String str, String str2, boolean z2, boolean z3, List list, Function1 function1, boolean z4, boolean z5, Function2 function2, int i3, int i4, int i5, Composer composer, int i6) {
        s(modifier, scaffoldState, str, str2, z2, z3, list, function1, z4, z5, function2, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }
}
