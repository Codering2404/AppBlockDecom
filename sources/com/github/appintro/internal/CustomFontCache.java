package com.github.appintro.internal;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import java.util.HashMap;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CustomFontCache {
    public static final CustomFontCache INSTANCE = new CustomFontCache();
    private static final String TAG = LogHelper.INSTANCE.makeLogTag(Reflection.b(CustomFontCache.class));
    private static final HashMap<String, Typeface> cache = new HashMap<>();

    private CustomFontCache() {
    }

    public final void getFont(Context ctx, String str, ResourcesCompat.FontCallback fontCallback) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(fontCallback, "fontCallback");
        if (str == null || str.length() == 0) {
            LogHelper.w$default(TAG, "Empty typeface path provided!", null, 4, null);
            return;
        }
        HashMap<String, Typeface> map = cache;
        Typeface typeface = map.get(str);
        if (typeface != null) {
            fontCallback.onFontRetrieved(typeface);
            return;
        }
        Typeface newTypeface = Typeface.createFromAsset(ctx.getAssets(), str);
        Intrinsics.checkNotNullExpressionValue(newTypeface, "newTypeface");
        map.put(str, newTypeface);
        fontCallback.onFontRetrieved(newTypeface);
    }
}
