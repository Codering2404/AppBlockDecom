package com.revenuecat.purchases.ui.revenuecatui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelFactory;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ContextExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallResourceProviderKt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt;
import com.revenuecat.purchases.ui.revenuecatui.utils.URLOpener;
import com.revenuecat.purchases.ui.revenuecatui.utils.URLOpeningMethod;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InternalPaywallKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaywallTemplate.values().length];
            try {
                iArr[PaywallTemplate.TEMPLATE_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_5.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_7.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ButtonComponent.UrlMethod.values().length];
            try {
                iArr2[ButtonComponent.UrlMethod.IN_APP_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ButtonComponent.UrlMethod.EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ButtonComponent.UrlMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ButtonComponent.UrlMethod.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void InternalPaywall(final com.revenuecat.purchases.ui.revenuecatui.PaywallOptions r19, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall(com.revenuecat.purchases.ui.revenuecatui.PaywallOptions, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InternalPaywall$lambda$3$lambda$2(PaywallViewModel paywallViewModel, PaywallComponentInteractionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        paywallViewModel.trackComponentInteraction(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LoadedPaywall(final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Legacy r21, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel r22, final boolean r23, androidx.compose.runtime.Composer r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 1018
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.LoadedPaywall(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Legacy, com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel, boolean, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TemplatePaywall(PaywallState.Loaded.Legacy legacy, PaywallViewModel paywallViewModel, Composer composer, final int i3) {
        int i4;
        final PaywallState.Loaded.Legacy legacy2;
        final PaywallViewModel paywallViewModel2;
        Composer composerK = composer.k(-1883481085);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paywallViewModel) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            legacy2 = legacy;
            paywallViewModel2 = paywallViewModel;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1883481085, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.TemplatePaywall (InternalPaywall.kt:279)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[legacy.getTemplateConfiguration().getTemplate().ordinal()]) {
                case 1:
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    composerK.a0(-820372898);
                    Template1Kt.Template1(legacy2, paywallViewModel2, composerK, i4 & 126);
                    composerK.U();
                    break;
                case 2:
                    composerK.a0(-820370146);
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    Template2Kt.Template2(legacy2, paywallViewModel2, null, composerK, i4 & 126, 4);
                    composerK.U();
                    break;
                case 3:
                    composerK.a0(-820367394);
                    Template3Kt.Template3(legacy, paywallViewModel, composerK, i4 & 126);
                    composerK.U();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                case 4:
                    composerK.a0(-820364642);
                    Template4Kt.Template4(legacy, paywallViewModel, composerK, i4 & 126);
                    composerK.U();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                case 5:
                    composerK.a0(-820361890);
                    Template5Kt.Template5(legacy, paywallViewModel, composerK, i4 & 126);
                    composerK.U();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                case 6:
                    composerK.a0(-820359138);
                    Template7Kt.Template7(legacy, paywallViewModel, composerK, i4 & 126);
                    composerK.U();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                default:
                    composerK.a0(338721619);
                    composerK.U();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.TemplatePaywall.1
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
                    InternalPaywallKt.TemplatePaywall(legacy2, paywallViewModel2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final Configuration configurationWithOverriddenLocale(PaywallState.Loaded.Legacy legacy, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(761546839, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.configurationWithOverriddenLocale (InternalPaywall.kt:323)");
        }
        Configuration configuration = new Configuration((Configuration) composer.q(AndroidCompositionLocals_androidKt.f()));
        configuration.setLocale(legacy.getTemplateConfiguration().getLocale());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return configuration;
    }

    private static final Context contextWithConfiguration(PaywallState.Loaded.Legacy legacy, Configuration configuration, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2083869389, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.contextWithConfiguration (InternalPaywall.kt:314)");
        }
        Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        if (contextCreateConfigurationContext != null) {
            context = contextCreateConfigurationContext;
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return context;
    }

    public static final PaywallViewModel getPaywallViewModel(PaywallOptions options, Function1<? super CustomerInfo, Boolean> function1, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(options, "options");
        composer.a0(-1725540891);
        Function1<? super CustomerInfo, Boolean> function12 = (i4 & 2) != 0 ? null : function1;
        if (ComposerKt.M()) {
            ComposerKt.U(-1725540891, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.getPaywallViewModel (InternalPaywall.kt:295)");
        }
        Context applicationContext = ((Context) composer.q(AndroidCompositionLocals_androidKt.g())).getApplicationContext();
        String strValueOf = String.valueOf(options.hashCode());
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        PaywallViewModelFactory paywallViewModelFactory = new PaywallViewModelFactory(PaywallResourceProviderKt.toResourceProvider(applicationContext), options, MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b), DarkThemeKt.a(composer, 0), function12, HelperFunctionsKt.isInPreviewMode(composer, 0));
        composer.F(1729797275);
        ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composer, 6);
        if (viewModelStoreOwnerC == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
        }
        ViewModel viewModelB = ViewModelKt.b(Reflection.b(PaywallViewModelImpl.class), viewModelStoreOwnerC, strValueOf, paywallViewModelFactory, viewModelStoreOwnerC instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwnerC).getDefaultViewModelCreationExtras() : CreationExtras.Empty.f40230c, composer, 0, 0);
        composer.Y();
        PaywallViewModelImpl paywallViewModelImpl = (PaywallViewModelImpl) viewModelB;
        paywallViewModelImpl.updateOptions(options);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return paywallViewModelImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleUrlDestination(Context context, String str, ButtonComponent.UrlMethod urlMethod) {
        URLOpeningMethod uRLOpeningMethod;
        int i3 = WhenMappings.$EnumSwitchMapping$1[urlMethod.ordinal()];
        if (i3 == 1) {
            uRLOpeningMethod = URLOpeningMethod.IN_APP_BROWSER;
        } else if (i3 == 2) {
            uRLOpeningMethod = URLOpeningMethod.EXTERNAL_BROWSER;
        } else {
            if (i3 != 3) {
                if (i3 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.INSTANCE.e("Ignoring button click with unknown open method for URL: '" + str + "'. This is a bug in the SDK.");
                return;
            }
            uRLOpeningMethod = URLOpeningMethod.DEEP_LINK;
        }
        URLOpener.INSTANCE.openURL$revenuecatui_defaultsBc8Release(context, str, uRLOpeningMethod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<PaywallAction.External, Continuation<? super Unit>, Object> rememberPaywallActionHandler(PaywallViewModel paywallViewModel, Composer composer, int i3) {
        composer.a0(-1933557776);
        if (ComposerKt.M()) {
            ComposerKt.U(-1933557776, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.rememberPaywallActionHandler (InternalPaywall.kt:331)");
        }
        Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        Activity activity = ContextExtensionsKt.getActivity(context);
        composer.a0(-1197093373);
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(paywallViewModel)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new InternalPaywallKt$rememberPaywallActionHandler$1$1(paywallViewModel, activity, context, null);
            composer.w(objG);
        }
        Function2<PaywallAction.External, Continuation<? super Unit>, Object> function2 = (Function2) objG;
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return function2;
    }

    /* JADX INFO: renamed from: screenModeBackground-mxwnekA, reason: not valid java name */
    private static final Modifier m672screenModeBackgroundmxwnekA(Modifier modifier, boolean z2, final long j3) {
        return ModifierExtensionsKt.conditional(ModifierExtensionsKt.conditional(modifier, z2, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$screenModeBackground$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Modifier invoke(Modifier conditional) {
                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                return BackgroundKt.d(SizeKt.d(Modifier.b8, 0.0f, 1, null), j3, null, 2, null);
            }
        }), !z2, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$screenModeBackground$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Modifier invoke(Modifier conditional) {
                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                Modifier.Companion companion = Modifier.b8;
                UIConstant uIConstant = UIConstant.INSTANCE;
                return BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.f(uIConstant.m689getDefaultCornerRadiusD9Ej5fM(), uIConstant.m689getDefaultCornerRadiusD9Ej5fM(), 0.0f, 0.0f, 12, null)), j3, null, 2, null);
            }
        });
    }
}
