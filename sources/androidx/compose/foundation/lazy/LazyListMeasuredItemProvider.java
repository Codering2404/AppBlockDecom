package androidx.compose.foundation.lazy;

import androidx.collection.IntList;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class LazyListMeasuredItemProvider implements LazyLayoutMeasuredItemProvider<LazyListMeasuredItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyListItemProvider f7549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyLayoutMeasureScope f7550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f7551c;

    public /* synthetic */ LazyListMeasuredItemProvider(long j3, boolean z2, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, z2, lazyListItemProvider, lazyLayoutMeasureScope);
    }

    public static /* synthetic */ LazyListMeasuredItem e(LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i3, long j3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAndMeasure-0kLqBqw");
        }
        if ((i4 & 2) != 0) {
            j3 = lazyListMeasuredItemProvider.f7551c;
        }
        return lazyListMeasuredItemProvider.d(i3, j3);
    }

    public abstract LazyListMeasuredItem b(int i3, Object obj, Object obj2, List list, long j3);

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public LazyListMeasuredItem a(int i3, int i4, int i5, long j3) {
        return d(i3, j3);
    }

    public final LazyListMeasuredItem d(int i3, long j3) {
        return b(i3, this.f7549a.d(i3), this.f7549a.f(i3), this.f7550b.m0(i3, j3), j3);
    }

    public final long f() {
        return this.f7551c;
    }

    public final IntList g() {
        return this.f7549a.e();
    }

    public final LazyLayoutKeyIndexMap h() {
        return this.f7549a.b();
    }

    private LazyListMeasuredItemProvider(long j3, boolean z2, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope) {
        this.f7549a = lazyListItemProvider;
        this.f7550b = lazyLayoutMeasureScope;
        this.f7551c = ConstraintsKt.b(0, z2 ? Constraints.l(j3) : Integer.MAX_VALUE, 0, z2 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : Constraints.k(j3), 5, null);
    }
}
