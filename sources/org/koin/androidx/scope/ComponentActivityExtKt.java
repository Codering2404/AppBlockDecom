package org.koin.androidx.scope;

import android.content.ComponentCallbacks;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeCallback;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ComponentActivityExtKt {
    public static final Scope a(final ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        if (!(componentActivity instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Activity should implement AndroidScopeComponent");
        }
        final Function0 function0 = null;
        ScopeHandlerViewModel scopeHandlerViewModel = (ScopeHandlerViewModel) new ViewModelLazy(Reflection.b(ScopeHandlerViewModel.class), new Function0<ViewModelStore>() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$createActivityRetainedScope$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$createActivityRetainedScope$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = componentActivity.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$createActivityRetainedScope$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }).getValue();
        if (scopeHandlerViewModel.getScope() == null) {
            scopeHandlerViewModel.y0(Koin.c(ComponentCallbackExtKt.a(componentActivity), KoinScopeComponentKt.c(componentActivity), KoinScopeComponentKt.d(componentActivity), null, 4, null));
        }
        Scope scope = scopeHandlerViewModel.getScope();
        Intrinsics.checkNotNull(scope);
        return scope;
    }

    public static final Scope b(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        if (!(componentActivity instanceof AndroidScopeComponent)) {
            throw new IllegalStateException("Activity should implement AndroidScopeComponent");
        }
        Scope scopeI = ComponentCallbackExtKt.a(componentActivity).i(KoinScopeComponentKt.c(componentActivity));
        return scopeI == null ? c(componentActivity, componentActivity) : scopeI;
    }

    public static final Scope c(ComponentCallbacks componentCallbacks, final LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(componentCallbacks, "<this>");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Scope scopeB = ComponentCallbackExtKt.a(componentCallbacks).b(KoinScopeComponentKt.c(componentCallbacks), KoinScopeComponentKt.d(componentCallbacks), componentCallbacks);
        scopeB.p(new ScopeCallback() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$createScopeForCurrentLifecycle$1
            @Override // org.koin.core.scope.ScopeCallback
            public void a(Scope scope) {
                Intrinsics.checkNotNullParameter(scope, "scope");
                LifecycleOwner lifecycleOwner = owner;
                Intrinsics.checkNotNull(lifecycleOwner, "null cannot be cast to non-null type org.koin.android.scope.AndroidScopeComponent");
                ((AndroidScopeComponent) lifecycleOwner).o();
            }
        });
        e(owner, scopeB);
        return scopeB;
    }

    public static final Scope d(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        return ComponentCallbackExtKt.a(componentActivity).i(KoinScopeComponentKt.c(componentActivity));
    }

    public static final void e(LifecycleOwner lifecycleOwner, final Scope scope) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: org.koin.androidx.scope.ComponentActivityExtKt$registerScopeForLifecycle$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                super.onDestroy(owner);
                scope.c();
            }
        });
    }
}
