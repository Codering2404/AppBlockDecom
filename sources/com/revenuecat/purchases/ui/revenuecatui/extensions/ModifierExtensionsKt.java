package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class ModifierExtensionsKt {
    public static final <T> Modifier applyIfNotNull(Modifier modifier, T t2, Function2<? super Modifier, ? super T, ? extends Modifier> modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return t2 != null ? modifier.then((Modifier) modifier2.invoke(Modifier.b8, t2)) : modifier;
    }

    public static final Modifier conditional(Modifier modifier, boolean z2, Function1<? super Modifier, ? extends Modifier> modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return z2 ? modifier.then((Modifier) modifier2.invoke(Modifier.b8)) : modifier;
    }

    public static final <T, V> Modifier applyIfNotNull(Modifier modifier, T t2, V v2, Function3<? super Modifier, ? super T, ? super V, ? extends Modifier> modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return (t2 == null || v2 == null) ? modifier : modifier.then((Modifier) modifier2.invoke(Modifier.b8, t2, v2));
    }
}
