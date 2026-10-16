package com.superwall.sdk.paywall.view;

import android.view.View;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
public interface ViewStorage {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static List<View> all(ViewStorage viewStorage) {
            Collection<View> collectionValues = viewStorage.getViews().values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            return CollectionsKt.toList(collectionValues);
        }

        public static Set<String> keys(ViewStorage viewStorage) {
            Set<String> setKeySet = viewStorage.getViews().keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            return setKeySet;
        }

        public static void removeView(ViewStorage viewStorage, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            viewStorage.getViews().remove(key);
        }

        public static View retrieveView(ViewStorage viewStorage, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return viewStorage.getViews().get(key);
        }

        public static void storeView(ViewStorage viewStorage, String key, View view) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(view, "view");
            viewStorage.getViews().put(key, view);
        }
    }

    List<View> all();

    ConcurrentHashMap<String, View> getViews();

    Set<String> keys();

    void removeView(String str);

    View retrieveView(String str);

    void storeView(String str, View view);
}
