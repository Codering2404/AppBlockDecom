package androidx.core.util;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

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
public final class LruCacheKt$lruCache$4 extends LruCache<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function2 f34337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1 f34338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function4 f34339c;

    @Override // android.util.LruCache
    protected Object create(Object obj) {
        return this.f34338b.invoke(obj);
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z2, Object obj, Object obj2, Object obj3) {
        this.f34339c.invoke(Boolean.valueOf(z2), obj, obj2, obj3);
    }

    @Override // android.util.LruCache
    protected int sizeOf(Object obj, Object obj2) {
        return ((Number) this.f34337a.invoke(obj, obj2)).intValue();
    }
}
