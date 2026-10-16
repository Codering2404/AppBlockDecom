package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
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
final class ViewModelLazyKt$getLazyViewModelForClass$1 extends Lambda implements Function0<ViewModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function0 f145849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewModelStoreOwner f145850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ KClass f145851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ViewModelStore f145852d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f145853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Qualifier f145854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Scope f145855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function0 f145856i;

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final ViewModel invoke() {
        CreationExtras creationExtrasA;
        Bundle bundle;
        Function0 function0 = this.f145849a;
        if (function0 == null || (bundle = (Bundle) function0.invoke()) == null || (creationExtrasA = BundleExtKt.a(bundle, this.f145850b)) == null) {
            creationExtrasA = CreationExtras.Empty.f40230c;
        }
        return GetViewModelKt.a(this.f145851c, this.f145852d, this.f145853f, creationExtrasA, this.f145854g, this.f145855h, this.f145856i);
    }
}
