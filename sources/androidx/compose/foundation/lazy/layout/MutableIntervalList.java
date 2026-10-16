package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.collection.MutableVector;
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
public final class MutableIntervalList<T> implements IntervalList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableVector f8250a = new MutableVector(new IntervalList.Interval[16], 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IntervalList.Interval f8252c;

    private final boolean c(IntervalList.Interval interval, int i3) {
        return i3 < interval.b() + interval.a() && interval.b() <= i3;
    }

    private final IntervalList.Interval d(int i3) {
        IntervalList.Interval interval = this.f8252c;
        if (interval != null && c(interval, i3)) {
            return interval;
        }
        MutableVector mutableVector = this.f8250a;
        IntervalList.Interval interval2 = (IntervalList.Interval) mutableVector.f24389a[IntervalListKt.b(mutableVector, i3)];
        this.f8252c = interval2;
        return interval2;
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public void a(int i3, int i4, Function1 function1) {
        if (i3 < 0 || i3 >= getSize()) {
            InlineClassHelperKt.e("Index " + i3 + ", size " + getSize());
        }
        if (i4 < 0 || i4 >= getSize()) {
            InlineClassHelperKt.e("Index " + i4 + ", size " + getSize());
        }
        if (!(i4 >= i3)) {
            InlineClassHelperKt.a("toIndex (" + i4 + ") should be not smaller than fromIndex (" + i3 + ')');
        }
        int iB = IntervalListKt.b(this.f8250a, i3);
        int iB2 = ((IntervalList.Interval) this.f8250a.f24389a[iB]).b();
        while (iB2 <= i4) {
            IntervalList.Interval interval = (IntervalList.Interval) this.f8250a.f24389a[iB];
            function1.invoke(interval);
            iB2 += interval.a();
            iB++;
        }
    }

    public final void b(int i3, Object obj) {
        if (!(i3 >= 0)) {
            InlineClassHelperKt.a("size should be >=0");
        }
        if (i3 == 0) {
            return;
        }
        IntervalList.Interval interval = new IntervalList.Interval(getSize(), i3, obj);
        this.f8251b = getSize() + i3;
        this.f8250a.b(interval);
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public IntervalList.Interval get(int i3) {
        if (i3 < 0 || i3 >= getSize()) {
            InlineClassHelperKt.e("Index " + i3 + ", size " + getSize());
        }
        return d(i3);
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public int getSize() {
        return this.f8251b;
    }
}
