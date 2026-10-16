package androidx.compose.material;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class MapDraggableAnchors<T> implements DraggableAnchors<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f13090a;

    public MapDraggableAnchors(Map map) {
        this.f13090a = map;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public Object a(float f3, boolean z2) {
        T next;
        Iterator<T> it = this.f13090a.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float fFloatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
                float f4 = z2 ? fFloatValue - f3 : f3 - fFloatValue;
                if (f4 < 0.0f) {
                    f4 = Float.POSITIVE_INFINITY;
                }
                do {
                    T next2 = it.next();
                    float fFloatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                    float f5 = z2 ? fFloatValue2 - f3 : f3 - fFloatValue2;
                    if (f5 < 0.0f) {
                        f5 = Float.POSITIVE_INFINITY;
                    }
                    if (Float.compare(f4, f5) > 0) {
                        next = next2;
                        f4 = f5;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return entry.getKey();
        }
        return null;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public Object b(float f3) {
        T next;
        Iterator<T> it = this.f13090a.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float fAbs = Math.abs(f3 - ((Number) ((Map.Entry) next).getValue()).floatValue());
                do {
                    T next2 = it.next();
                    float fAbs2 = Math.abs(f3 - ((Number) ((Map.Entry) next2).getValue()).floatValue());
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return entry.getKey();
        }
        return null;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float c(Object obj) {
        Float f3 = (Float) this.f13090a.get(obj);
        if (f3 != null) {
            return f3.floatValue();
        }
        return Float.NaN;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public boolean d(Object obj) {
        return this.f13090a.containsKey(obj);
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float e() {
        Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) this.f13090a.values());
        if (fMinOrNull != null) {
            return fMinOrNull.floatValue();
        }
        return Float.NaN;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapDraggableAnchors) {
            return Intrinsics.areEqual(this.f13090a, ((MapDraggableAnchors) obj).f13090a);
        }
        return false;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float f() {
        Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) this.f13090a.values());
        if (fMaxOrNull != null) {
            return fMaxOrNull.floatValue();
        }
        return Float.NaN;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public int getSize() {
        return this.f13090a.size();
    }

    public int hashCode() {
        return this.f13090a.hashCode() * 31;
    }

    public String toString() {
        return "MapDraggableAnchors(" + this.f13090a + ')';
    }
}
