package androidx.compose.foundation.lazy.grid;

import androidx.collection.IntList;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class LazyGridMeasuredItemProvider implements LazyLayoutMeasuredItemProvider<LazyGridMeasuredItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyGridItemProvider f7861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyLayoutMeasureScope f7862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7863c;

    public LazyGridMeasuredItemProvider(LazyGridItemProvider lazyGridItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i3) {
        this.f7861a = lazyGridItemProvider;
        this.f7862b = lazyLayoutMeasureScope;
        this.f7863c = i3;
    }

    public abstract LazyGridMeasuredItem b(int i3, Object obj, Object obj2, int i4, int i5, List list, long j3, int i6, int i7);

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public LazyGridMeasuredItem a(int i3, int i4, int i5, long j3) {
        return d(i3, j3, i4, i5, this.f7863c);
    }

    public final LazyGridMeasuredItem d(int i3, long j3, int i4, int i5, int i6) {
        int iM;
        Object objD = this.f7861a.d(i3);
        Object objF = this.f7861a.f(i3);
        List listM0 = this.f7862b.m0(i3, j3);
        if (Constraints.j(j3)) {
            iM = Constraints.n(j3);
        } else {
            if (!Constraints.i(j3)) {
                InlineClassHelperKt.a("does not have fixed height");
            }
            iM = Constraints.m(j3);
        }
        return b(i3, objD, objF, iM, i6, listM0, j3, i4, i5);
    }

    public final IntList e() {
        return this.f7861a.e();
    }

    public final LazyLayoutKeyIndexMap f() {
        return this.f7861a.b();
    }
}
