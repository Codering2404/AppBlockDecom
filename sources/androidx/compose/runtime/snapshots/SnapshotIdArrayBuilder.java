package androidx.compose.runtime.snapshots;

import androidx.collection.MutableLongList;
import java.util.Arrays;
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
public final class SnapshotIdArrayBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableLongList f24930a;

    public SnapshotIdArrayBuilder(long[] jArr) {
        MutableLongList mutableLongList;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            mutableLongList = new MutableLongList(jArrCopyOf.length);
            mutableLongList.e(mutableLongList.f2921b, jArrCopyOf);
        } else {
            mutableLongList = new MutableLongList(0, 1, null);
        }
        this.f24930a = mutableLongList;
    }

    public final void a(long j3) {
        this.f24930a.d(j3);
    }

    public final long[] b() {
        MutableLongList mutableLongList = this.f24930a;
        int i3 = mutableLongList.f2921b;
        if (i3 == 0) {
            return null;
        }
        long[] jArr = new long[i3];
        long[] jArr2 = mutableLongList.f2920a;
        for (int i4 = 0; i4 < i3; i4++) {
            jArr[i4] = jArr2[i4];
        }
        return jArr;
    }
}
