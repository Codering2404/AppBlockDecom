package cz.mobilesoft.coreblock.scene.sharing.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.sharing.ShareFormattingKt;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.images.screentime.ScreenTimeImageKt;
import cz.mobilesoft.coreblock.scene.sharing.images.screentime.TransparentScreenTimeImageKt;
import cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.TransparentUpsDownsImageKt;
import cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.UpsDownsImageKt;
import cz.mobilesoft.coreblock.scene.sharing.images.weekly_report.WeeklyReportImageKt;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SocialShareImageRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SocialShareImageRenderer f119502a = new SocialShareImageRenderer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Density f119503b = DensityKt.a(1.0f, 1.0f);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119504a;

        static {
            int[] iArr = new int[SocialShareTemplate.values().length];
            try {
                iArr[SocialShareTemplate.ScreenTimeSquare.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SocialShareTemplate.ScreenTimePortrait.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SocialShareTemplate.UpsDownsSquare.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SocialShareTemplate.UpsDownsPortrait.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SocialShareTemplate.ScreenTimeTransparent.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SocialShareTemplate.UpsDownsTransparent.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SocialShareTemplate.WeeklyReportPortrait.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f119504a = iArr;
        }
    }

    private SocialShareImageRenderer() {
    }

    private final void e(final SocialShareTemplate socialShareTemplate, final SocialsSharePayload socialsSharePayload, final String str, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-407913038);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(socialShareTemplate.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(socialsSharePayload) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(str) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-407913038, i4, -1, "cz.mobilesoft.coreblock.scene.sharing.render.SocialShareImageRenderer.SelectedShareImage (SocialShareImageRenderer.kt:123)");
            }
            switch (WhenMappings.f119504a[socialShareTemplate.ordinal()]) {
                case 1:
                    composerK.a0(-1162397856);
                    int i5 = i4 << 3;
                    ScreenTimeImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialShareTemplate, socialsSharePayload, str, ShareFormattingKt.a(socialsSharePayload), composerK, (i5 & 112) | 6 | (i5 & 896) | (i5 & 7168), 0);
                    composerK = composerK;
                    composerK.U();
                    break;
                case 2:
                    composerK.a0(-1162386432);
                    int i6 = i4 << 3;
                    ScreenTimeImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialShareTemplate, socialsSharePayload, str, ShareFormattingKt.a(socialsSharePayload), composerK, (i6 & 112) | 6 | (i6 & 896) | (i6 & 7168), 0);
                    composerK = composerK;
                    composerK.U();
                    break;
                case 3:
                    composerK.a0(-1162375220);
                    int i7 = i4 << 3;
                    UpsDownsImageKt.e(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialShareTemplate, socialsSharePayload, str, composerK, (i7 & 112) | 6 | (i7 & 896) | (i7 & 7168), 0);
                    composerK.U();
                    break;
                case 4:
                    composerK.a0(-1162366548);
                    int i8 = i4 << 3;
                    UpsDownsImageKt.e(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialShareTemplate, socialsSharePayload, str, composerK, (i8 & 112) | 6 | (i8 & 896) | (i8 & 7168), 0);
                    composerK.U();
                    break;
                case 5:
                    composerK.a0(-1162357744);
                    TransparentScreenTimeImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialsSharePayload, str, composerK, (i4 & 112) | 6 | (i4 & 896), 0);
                    composerK = composerK;
                    composerK.U();
                    break;
                case 6:
                    composerK.a0(-1162349874);
                    TransparentUpsDownsImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialsSharePayload, str, composerK, (i4 & 112) | 6 | (i4 & 896), 0);
                    composerK = composerK;
                    composerK.U();
                    break;
                case 7:
                    composerK.a0(-1162341959);
                    WeeklyReportImageKt.c(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialsSharePayload, str, ShareFormattingKt.a(socialsSharePayload), composerK, (i4 & 112) | 6 | (i4 & 896), 0);
                    composerK.U();
                    break;
                default:
                    composerK.a0(-1162398307);
                    composerK.U();
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.render.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialShareImageRenderer.f(this.f119584a, socialShareTemplate, socialsSharePayload, str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(SocialShareImageRenderer socialShareImageRenderer, SocialShareTemplate socialShareTemplate, SocialsSharePayload socialsSharePayload, String str, int i3, Composer composer, int i4) {
        socialShareImageRenderer.e(socialShareTemplate, socialsSharePayload, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ComposeView j(Context context, final SocialShareTemplate socialShareTemplate, final SocialsSharePayload socialsSharePayload, final String str) {
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setAlpha(0.0f);
        composeView.setLayoutParams(new FrameLayout.LayoutParams(socialShareTemplate.getFormat().getWidthPx(), socialShareTemplate.getFormat().getHeightPx()));
        composeView.setTranslationX(-10000.0f);
        composeView.setContent(ComposableLambdaKt.c(-1137337975, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.render.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SocialShareImageRenderer.k(socialShareTemplate, socialsSharePayload, str, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(final SocialShareTemplate socialShareTemplate, final SocialsSharePayload socialsSharePayload, final String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1137337975, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.render.SocialShareImageRenderer.createOffscreenComposeView.<anonymous>.<anonymous> (SocialShareImageRenderer.kt:93)");
            }
            CompositionLocalKt.b(CompositionLocalsKt.f().d(f119503b), ComposableLambdaKt.e(821382729, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.render.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialShareImageRenderer.l(socialShareTemplate, socialsSharePayload, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.f24012i | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final SocialShareTemplate socialShareTemplate, final SocialsSharePayload socialsSharePayload, final String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(821382729, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.render.SocialShareImageRenderer.createOffscreenComposeView.<anonymous>.<anonymous>.<anonymous> (SocialShareImageRenderer.kt:94)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(402778938, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.render.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialShareImageRenderer.m(socialShareTemplate, socialsSharePayload, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(SocialShareTemplate socialShareTemplate, SocialsSharePayload socialsSharePayload, String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(402778938, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.render.SocialShareImageRenderer.createOffscreenComposeView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SocialShareImageRenderer.kt:95)");
            }
            f119502a.e(socialShareTemplate, socialsSharePayload, str, composer, 3072);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final ComposeView composeView, final Function1 function1) {
        OneShotPreDrawListener.a(composeView, new Runnable() { // from class: cz.mobilesoft.coreblock.scene.sharing.render.SocialShareImageRenderer$renderComposeViewToBitmap$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                Object objB;
                Function1 function12 = function1;
                SocialShareImageRenderer socialShareImageRenderer = SocialShareImageRenderer.f119502a;
                try {
                    Result.Companion companion = Result.f139772b;
                    objB = Result.b(ViewKt.a(composeView, Bitmap.Config.ARGB_8888));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f139772b;
                    objB = Result.b(ResultKt.a(th));
                }
                function12.invoke(Result.a(objB));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup p(View view) {
        View rootView = view.getRootView();
        if (rootView instanceof ViewGroup) {
            return (ViewGroup) rootView;
        }
        return null;
    }

    public final Object o(Context context, View view, SocialShareTemplate socialShareTemplate, SocialsSharePayload socialsSharePayload, String str, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        SocialShareImageRenderer socialShareImageRenderer = f119502a;
        final ViewGroup viewGroupP = socialShareImageRenderer.p(view);
        if (viewGroupP == null) {
            Result.Companion companion = Result.f139772b;
            cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(new IllegalStateException("Root view is not a ViewGroup"))));
        } else {
            final ComposeView composeViewJ = socialShareImageRenderer.j(context, socialShareTemplate, socialsSharePayload, str);
            viewGroupP.addView(composeViewJ);
            cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: cz.mobilesoft.coreblock.scene.sharing.render.SocialShareImageRenderer$renderToBitmap$2$1
                public final void c(Throwable th) {
                    viewGroupP.removeView(composeViewJ);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((Throwable) obj);
                    return Unit.f139807a;
                }
            });
            socialShareImageRenderer.n(composeViewJ, new Function1<Result<? extends Bitmap>, Unit>() { // from class: cz.mobilesoft.coreblock.scene.sharing.render.SocialShareImageRenderer$renderToBitmap$2$2
                public final void c(Object obj) {
                    ViewGroup viewGroup = viewGroupP;
                    ComposeView composeView = composeViewJ;
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    if (Result.h(obj)) {
                        viewGroup.removeView(composeView);
                        cancellableContinuation.resumeWith(Result.b((Bitmap) obj));
                    }
                    ViewGroup viewGroup2 = viewGroupP;
                    ComposeView composeView2 = composeViewJ;
                    CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                    Throwable thE = Result.e(obj);
                    if (thE != null) {
                        viewGroup2.removeView(composeView2);
                        cancellableContinuation2.resumeWith(Result.b(ResultKt.a(thE)));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c(((Result) obj).j());
                    return Unit.f139807a;
                }
            });
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
