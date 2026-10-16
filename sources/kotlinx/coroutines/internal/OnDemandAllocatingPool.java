package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class OnDemandAllocatingPool<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142477b = AtomicIntegerFieldUpdater.newUpdater(OnDemandAllocatingPool.class, "controlState$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f142478a;
    private volatile /* synthetic */ int controlState$volatile;

    private final /* synthetic */ AtomicReferenceArray b() {
        return this.f142478a;
    }

    public final String c() {
        int i3 = f142477b.get(this);
        IntRange intRangeB = RangesKt.B(0, Integer.MAX_VALUE & i3);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB, 10));
        Iterator<Integer> it = intRangeB.iterator();
        while (it.hasNext()) {
            arrayList.add(b().get(((IntIterator) it).nextInt()));
        }
        return arrayList.toString() + ((i3 & Integer.MIN_VALUE) != 0 ? "[closed]" : "");
    }

    public String toString() {
        return "OnDemandAllocatingPool(" + c() + ')';
    }
}
