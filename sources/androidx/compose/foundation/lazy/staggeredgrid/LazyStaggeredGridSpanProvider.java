package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LazyStaggeredGridSpanProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntervalList f8544a;

    public LazyStaggeredGridSpanProvider(IntervalList intervalList) {
        this.f8544a = intervalList;
    }

    public final boolean a(int i3) {
        if (i3 >= 0 && i3 < this.f8544a.getSize()) {
            IntervalList.Interval interval = this.f8544a.get(i3);
            Function1 function1B = ((LazyStaggeredGridInterval) interval.c()).b();
            int iB = i3 - interval.b();
            if (function1B != null && function1B.invoke(Integer.valueOf(iB)) == StaggeredGridItemSpan.f8600b.a()) {
                return true;
            }
        }
        return false;
    }
}
