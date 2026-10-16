package androidx.compose.ui.text;

import androidx.collection.LruCache;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextLayoutCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache f28888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CacheTextLayoutInput f28889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextLayoutResult f28890c;

    public TextLayoutCache(int i3) {
        this.f28888a = i3 != 1 ? new LruCache(i3) : null;
    }

    public final TextLayoutResult a(TextLayoutInput textLayoutInput) {
        TextLayoutResult textLayoutResult;
        CacheTextLayoutInput cacheTextLayoutInput = new CacheTextLayoutInput(textLayoutInput);
        LruCache lruCache = this.f28888a;
        if (lruCache != null) {
            textLayoutResult = (TextLayoutResult) lruCache.get(cacheTextLayoutInput);
        } else {
            if (!Intrinsics.areEqual(this.f28889b, cacheTextLayoutInput)) {
                return null;
            }
            textLayoutResult = this.f28890c;
        }
        if (textLayoutResult == null || textLayoutResult.w().j().a()) {
            return null;
        }
        return textLayoutResult;
    }

    public final void b(TextLayoutInput textLayoutInput, TextLayoutResult textLayoutResult) {
        LruCache lruCache = this.f28888a;
        if (lruCache != null) {
            lruCache.put(new CacheTextLayoutInput(textLayoutInput), textLayoutResult);
        } else {
            this.f28889b = new CacheTextLayoutInput(textLayoutInput);
            this.f28890c = textLayoutResult;
        }
    }
}
