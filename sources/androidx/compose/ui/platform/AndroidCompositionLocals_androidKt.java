package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.compose.ui.res.ResourceIdCache;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AndroidCompositionLocals_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27832a = CompositionLocalKt.e(null, new Function0<Configuration>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalConfiguration$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Configuration invoke() {
            AndroidCompositionLocals_androidKt.k("LocalConfiguration");
            throw new KotlinNothingValueException();
        }
    }, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27833b = CompositionLocalKt.g(new Function0<Context>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalContext$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Context invoke() {
            AndroidCompositionLocals_androidKt.k("LocalContext");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27834c = CompositionLocalKt.g(new Function0<ImageVectorCache>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalImageVectorCache$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ImageVectorCache invoke() {
            AndroidCompositionLocals_androidKt.k("LocalImageVectorCache");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27835d = CompositionLocalKt.g(new Function0<ResourceIdCache>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalResourceIdCache$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ResourceIdCache invoke() {
            AndroidCompositionLocals_androidKt.k("LocalResourceIdCache");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27836e = CompositionLocalKt.g(new Function0<SavedStateRegistryOwner>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalSavedStateRegistryOwner$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final SavedStateRegistryOwner invoke() {
            AndroidCompositionLocals_androidKt.k("LocalSavedStateRegistryOwner");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27837f = CompositionLocalKt.g(new Function0<View>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalView$1
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            AndroidCompositionLocals_androidKt.k("LocalView");
            throw new KotlinNothingValueException();
        }
    });

    public static final void a(final AndroidComposeView androidComposeView, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1396852028);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(androidComposeView) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1396852028, i4, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:76)");
            }
            Context context = androidComposeView.getContext();
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(new Configuration(context.getResources().getConfiguration()), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1
                    {
                        super(1);
                    }

                    public final void c(Configuration configuration) {
                        AndroidCompositionLocals_androidKt.c(mutableState, new Configuration(configuration));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((Configuration) obj);
                        return Unit.f139807a;
                    }
                };
                composerK.w(objG2);
            }
            androidComposeView.setConfigurationChangeObserver((Function1) objG2);
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new AndroidUriHandler(context);
                composerK.w(objG3);
            }
            final AndroidUriHandler androidUriHandler = (AndroidUriHandler) objG3;
            AndroidComposeView.ViewTreeOwners viewTreeOwners = androidComposeView.getViewTreeOwners();
            if (viewTreeOwners == null) {
                throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
            }
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = DisposableSaveableStateRegistry_androidKt.b(androidComposeView, viewTreeOwners.b());
                composerK.w(objG4);
            }
            final DisposableSaveableStateRegistry disposableSaveableStateRegistry = (DisposableSaveableStateRegistry) objG4;
            Unit unit = Unit.f139807a;
            boolean zI = composerK.I(disposableSaveableStateRegistry);
            Object objG5 = composerK.G();
            if (zI || objG5 == companion.a()) {
                objG5 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final DisposableSaveableStateRegistry disposableSaveableStateRegistry2 = disposableSaveableStateRegistry;
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                disposableSaveableStateRegistry2.c();
                            }
                        };
                    }
                };
                composerK.w(objG5);
            }
            EffectsKt.c(unit, (Function1) objG5, composerK, 6);
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                objG6 = HapticDefaults.f28095a.a(context) ? new DefaultHapticFeedback(androidComposeView.getView()) : new NoHapticFeedback();
                composerK.w(objG6);
            }
            CompositionLocalKt.c(new ProvidedValue[]{f27832a.d(b(mutableState)), f27833b.d(context), LocalLifecycleOwnerKt.c().d(viewTreeOwners.a()), f27836e.d(viewTreeOwners.b()), SaveableStateRegistryKt.e().d(disposableSaveableStateRegistry), f27837f.d(androidComposeView.getView()), f27834c.d(l(context, b(mutableState), composerK, 0)), f27835d.d(m(context, composerK, 0)), CompositionLocalsKt.o().d(Boolean.valueOf(((Boolean) composerK.q(CompositionLocalsKt.p())).booleanValue() | androidComposeView.getScrollCaptureInProgress$ui_release())), CompositionLocalsKt.k().d((HapticFeedback) objG6)}, ComposableLambdaKt.e(1471621628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3
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
                    if (!composer2.r((i5 & 3) != 2, i5 & 1)) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1471621628, i5, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals.<anonymous> (AndroidCompositionLocals.android.kt:121)");
                    }
                    CompositionLocalsKt.a(androidComposeView, androidUriHandler, function2, composer2, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$4
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
                    AndroidCompositionLocals_androidKt.a(androidComposeView, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final Configuration b(MutableState mutableState) {
        return (Configuration) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableState mutableState, Configuration configuration) {
        mutableState.setValue(configuration);
    }

    public static final ProvidableCompositionLocal f() {
        return f27832a;
    }

    public static final ProvidableCompositionLocal g() {
        return f27833b;
    }

    public static final ProvidableCompositionLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return LocalLifecycleOwnerKt.c();
    }

    public static final ProvidableCompositionLocal<SavedStateRegistryOwner> getLocalSavedStateRegistryOwner() {
        return f27836e;
    }

    public static final ProvidableCompositionLocal h() {
        return f27834c;
    }

    public static final ProvidableCompositionLocal i() {
        return f27835d;
    }

    public static final ProvidableCompositionLocal j() {
        return f27837f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void k(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    private static final ImageVectorCache l(final Context context, Configuration configuration, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-485908294, i3, -1, "androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:157)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new ImageVectorCache();
            composer.w(objG);
        }
        final ImageVectorCache imageVectorCache = (ImageVectorCache) objG;
        Object objG2 = composer.G();
        Object obj = objG2;
        if (objG2 == companion.a()) {
            Configuration configuration2 = new Configuration();
            if (configuration != null) {
                configuration2.setTo(configuration);
            }
            composer.w(configuration2);
            obj = configuration2;
        }
        final Configuration configuration3 = (Configuration) obj;
        Object objG3 = composer.G();
        if (objG3 == companion.a()) {
            objG3 = new ComponentCallbacks2() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration4) {
                    imageVectorCache.c(configuration3.updateFrom(configuration4));
                    configuration3.setTo(configuration4);
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                    imageVectorCache.a();
                }

                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(int i4) {
                    imageVectorCache.a();
                }
            };
            composer.w(objG3);
        }
        final AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 = (AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1) objG3;
        boolean zI = composer.I(context);
        Object objG4 = composer.G();
        if (zI || objG4 == companion.a()) {
            objG4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    context.getApplicationContext().registerComponentCallbacks(androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1);
                    final Context context2 = context;
                    final AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$12 = androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1;
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            context2.getApplicationContext().unregisterComponentCallbacks(androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$12);
                        }
                    };
                }
            };
            composer.w(objG4);
        }
        EffectsKt.c(imageVectorCache, (Function1) objG4, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return imageVectorCache;
    }

    private static final ResourceIdCache m(final Context context, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1348507246, i3, -1, "androidx.compose.ui.platform.obtainResourceIdCache (AndroidCompositionLocals.android.kt:127)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new ResourceIdCache();
            composer.w(objG);
        }
        final ResourceIdCache resourceIdCache = (ResourceIdCache) objG;
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = new ComponentCallbacks2() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration) {
                    resourceIdCache.a();
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                    resourceIdCache.a();
                }

                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(int i4) {
                    resourceIdCache.a();
                }
            };
            composer.w(objG2);
        }
        final AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1 = (AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1) objG2;
        boolean zI = composer.I(context);
        Object objG3 = composer.G();
        if (zI || objG3 == companion.a()) {
            objG3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainResourceIdCache$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    context.getApplicationContext().registerComponentCallbacks(androidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1);
                    final Context context2 = context;
                    final AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$12 = androidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1;
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainResourceIdCache$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            context2.getApplicationContext().unregisterComponentCallbacks(androidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$12);
                        }
                    };
                }
            };
            composer.w(objG3);
        }
        EffectsKt.c(resourceIdCache, (Function1) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return resourceIdCache;
    }
}
