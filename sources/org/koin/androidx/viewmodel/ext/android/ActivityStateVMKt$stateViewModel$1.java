package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

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
public final class ActivityStateVMKt$stateViewModel$1 extends Lambda implements Function0<ViewModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ComponentActivity f145798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Qualifier f145799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f145800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f145801d;

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final ViewModel invoke() {
        ComponentActivity componentActivity = this.f145798a;
        Qualifier qualifier = this.f145799b;
        Function0 function0 = this.f145800c;
        Function0 function02 = this.f145801d;
        ViewModelStore viewModelStore = componentActivity.getViewModelStore();
        CreationExtras creationExtrasA = BundleExtKt.a((Bundle) function0.invoke(), componentActivity);
        if (creationExtrasA == null) {
            creationExtrasA = componentActivity.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(creationExtrasA, "this.defaultViewModelCreationExtras");
        }
        CreationExtras creationExtras = creationExtrasA;
        Scope scopeA = AndroidKoinScopeExtKt.a(componentActivity);
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass kClassB = Reflection.b(ViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
        return GetViewModelKt.b(kClassB, viewModelStore, null, creationExtras, qualifier, scopeA, function02, 4, null);
    }
}
