package cz.mobilesoft.coreblock.scene.dashboard.profile;

import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.rest.RestClient;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ProfileImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(BoxScope boxScope, boolean z2, AccountDetailViewState.ProfileImageState profileImageState, Function0 function0, int i3, int i4, Composer composer, int i5) {
        A(boxScope, z2, profileImageState, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(BoxScope boxScope, boolean z2, AccountDetailViewState.ProfileImageState profileImageState, Function0 function0, int i3, int i4, Composer composer, int i5) {
        A(boxScope, z2, profileImageState, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void D(final BoxScope boxScope, final Context context, final String str, final MutableState isCaching, Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        final Function0 function02;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(isCaching, "isCaching");
        Composer composerK = composer.k(-131182830);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(context) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(str) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(isCaching) ? 2048 : 1024;
        }
        int i6 = i4 & 8;
        if (i6 != 0) {
            i5 |= 24576;
        } else if ((i3 & 24576) == 0) {
            i5 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            Function0 function03 = i6 != 0 ? null : function0;
            if (ComposerKt.M()) {
                ComposerKt.U(-131182830, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.ServerImage (ProfileImage.kt:117)");
            }
            int i7 = i5 & 14;
            int i8 = i5 >> 3;
            n(boxScope, new ImageRequest.Builder(context).c(true).d(RestClient.f98457a.C(str == null ? "" : str)).a(), isCaching, function03, composerK, i7 | (i8 & 896) | (i8 & 7168), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function02 = function03;
        } else {
            composerK.Q();
            function02 = function0;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileImageKt.E(boxScope, context, str, isCaching, function02, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(BoxScope boxScope, Context context, String str, MutableState mutableState, Function0 function0, int i3, int i4, Composer composer, int i5) {
        D(boxScope, context, str, mutableState, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void n(final androidx.compose.foundation.layout.BoxScope r24, final coil.request.ImageRequest r25, final androidx.compose.runtime.MutableState r26, kotlin.jvm.functions.Function0 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileImageKt.n(androidx.compose.foundation.layout.BoxScope, coil.request.ImageRequest, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier o(final Function0 function0, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ClickableKt.f(applyIf, false, null, null, new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileImageKt.p(function0);
            }
        }, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(MutableState mutableState, AsyncImagePainter.State.Loading it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(MutableState mutableState, AsyncImagePainter.State.Success it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(BoxScope boxScope, ImageRequest imageRequest, MutableState mutableState, Function0 function0, int i3, int i4, Composer composer, int i5) {
        n(boxScope, imageRequest, mutableState, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void u(BoxScope boxScope, final Context context, final Uri localImageUri, MutableState isCaching, Function0 function0, Composer composer, final int i3) {
        int i4;
        BoxScope boxScope2;
        final Function0 function02;
        final MutableState mutableState;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(localImageUri, "localImageUri");
        Intrinsics.checkNotNullParameter(isCaching, "isCaching");
        Composer composerK = composer.k(1480715833);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(context) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(localImageUri) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(isCaching) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1480715833, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.LocalImage (ProfileImage.kt:96)");
            }
            int i5 = i4 & 14;
            int i6 = i4 >> 3;
            boxScope2 = boxScope;
            n(boxScope2, new ImageRequest.Builder(context).c(true).d(localImageUri).a(), isCaching, function0, composerK, i5 | (i6 & 896) | (i6 & 7168), 0);
            mutableState = isCaching;
            function02 = function0;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            boxScope2 = boxScope;
            function02 = function0;
            mutableState = isCaching;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final BoxScope boxScope3 = boxScope2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileImageKt.v(boxScope3, context, localImageUri, mutableState, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(BoxScope boxScope, Context context, Uri uri, MutableState mutableState, Function0 function0, int i3, Composer composer, int i4) {
        u(boxScope, context, uri, mutableState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void w(final BoxScope boxScope, final Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-1566300493);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                function0 = null;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1566300493, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.PlaceholderImage (ProfileImage.kt:165)");
            }
            VectorPainter vectorPainterH = VectorPainterKt.h(VectorResources_androidKt.b(ImageVector.f26323k, !DarkThemeKt.a(composerK, 0) ? R.drawable.w4 : R.drawable.x4, composerK, 6), composerK, 0);
            Modifier modifierA = ClipKt.a(SizeKt.v(boxScope.f(Modifier.b8, Alignment.f25072a.m()), Dp.g(100)), RoundedCornerShapeKt.g());
            boolean z2 = function0 != null;
            boolean z3 = (i5 & 112) == 32;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileImageKt.x(function0, (Modifier) obj);
                    }
                };
                composerK.w(objG);
            }
            ImageKt.a(vectorPainterH, "Profile image", ComposableExtKt.r(modifierA, z2, (Function1) objG), null, ContentScale.f27054a.a(), 0.0f, null, composerK, VectorPainter.f26531p | 24624, 104);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileImageKt.z(boxScope, function0, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier x(final Function0 function0, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ClickableKt.f(applyIf, false, null, null, new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileImageKt.y(function0);
            }
        }, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(BoxScope boxScope, Function0 function0, int i3, int i4, Composer composer, int i5) {
        w(boxScope, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void A(final androidx.compose.foundation.layout.BoxScope r15, boolean r16, final cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState.ProfileImageState r17, kotlin.jvm.functions.Function0 r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileImageKt.A(androidx.compose.foundation.layout.BoxScope, boolean, cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState$ProfileImageState, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
