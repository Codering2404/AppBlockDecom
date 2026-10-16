package androidx.compose.runtime.internal;

import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Set;
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
public final class PausedCompositionRemembers implements RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f24811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableVector f24812b = new MutableVector(new RememberObserverHolder[16], 0);

    public PausedCompositionRemembers(Set set) {
        this.f24811a = set;
    }

    public final MutableVector a() {
        return this.f24812b;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        MutableVector mutableVector = this.f24812b;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            RememberObserver rememberObserverB = ((RememberObserverHolder) objArr[i3]).b();
            this.f24811a.remove(rememberObserverB);
            rememberObserverB.c();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
    }
}
