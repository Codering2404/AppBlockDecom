package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class PagerLayoutIntervalContent extends LazyLayoutIntervalContent<PagerIntervalContent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function4 f8760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f8761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IntervalList f8763d;

    public PagerLayoutIntervalContent(Function4 function4, Function1 function1, int i3) {
        this.f8760a = function4;
        this.f8761b = function1;
        this.f8762c = i3;
        MutableIntervalList mutableIntervalList = new MutableIntervalList();
        mutableIntervalList.b(i3, new PagerIntervalContent(function1, function4));
        this.f8763d = mutableIntervalList;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public IntervalList j() {
        return this.f8763d;
    }
}
