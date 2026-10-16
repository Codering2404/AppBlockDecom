package org.koin.androidx.viewmodel.ext.android;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.koin.core.qualifier.Qualifier;

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
final class FragmentSharedStateVMKt$sharedStateViewModel$4 extends Lambda implements Function0<ViewModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f145822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Qualifier f145823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f145824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f145825d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ KClass f145826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f145827g;

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final ViewModel invoke() {
        return FragmentSharedStateVMKt.a(this.f145822a, this.f145823b, this.f145824c, this.f145825d, this.f145826f, this.f145827g);
    }
}
