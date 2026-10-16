package org.koin.androidx.compose;

import kotlin.Metadata;

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
public final class ViewModelComposeExtKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.lifecycle.viewmodel.CreationExtras a(androidx.lifecycle.ViewModelStoreOwner r3, androidx.compose.runtime.Composer r4, int r5) {
        /*
            java.lang.String r0 = "viewModelStoreOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = -563811291(0xffffffffde64ec25, float:-4.1239E18)
            r4.F(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.M()
            if (r1 == 0) goto L17
            r1 = -1
            java.lang.String r2 = "org.koin.androidx.compose.defaultExtras (ViewModelComposeExt.kt:77)"
            androidx.compose.runtime.ComposerKt.U(r0, r5, r1, r2)
        L17:
            boolean r5 = r3 instanceof androidx.navigation.NavBackStackEntry
            if (r5 == 0) goto L33
            r5 = r3
            androidx.navigation.NavBackStackEntry r5 = (androidx.navigation.NavBackStackEntry) r5
            android.os.Bundle r0 = r5.b()
            if (r0 == 0) goto L33
            android.os.Bundle r5 = r5.b()
            if (r5 == 0) goto L30
            androidx.lifecycle.viewmodel.CreationExtras r3 = org.koin.androidx.viewmodel.ext.android.BundleExtKt.a(r5, r3)
            if (r3 != 0) goto L45
        L30:
            androidx.lifecycle.viewmodel.CreationExtras$Empty r3 = androidx.lifecycle.viewmodel.CreationExtras.Empty.f40230c
            goto L45
        L33:
            boolean r5 = r3 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory
            if (r5 == 0) goto L43
            androidx.lifecycle.HasDefaultViewModelProviderFactory r3 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r3
            androidx.lifecycle.viewmodel.CreationExtras r3 = r3.getDefaultViewModelCreationExtras()
            java.lang.String r5 = "{\n        viewModelStore…ModelCreationExtras\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            goto L45
        L43:
            androidx.lifecycle.viewmodel.CreationExtras$Empty r3 = androidx.lifecycle.viewmodel.CreationExtras.Empty.f40230c
        L45:
            boolean r5 = androidx.compose.runtime.ComposerKt.M()
            if (r5 == 0) goto L4e
            androidx.compose.runtime.ComposerKt.T()
        L4e:
            r4.Y()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.androidx.compose.ViewModelComposeExtKt.a(androidx.lifecycle.ViewModelStoreOwner, androidx.compose.runtime.Composer, int):androidx.lifecycle.viewmodel.CreationExtras");
    }
}
