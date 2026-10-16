package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.compose.runtime.collection.MultiValueMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
final class NestedContentMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableScatterMap f23964a = MultiValueMap.e(null, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableScatterMap f23965b = MultiValueMap.e(null, 1, null);

    public final void a(MovableContent movableContent, NestedMovableContent nestedMovableContent) {
        MultiValueMap.a(this.f23964a, movableContent, nestedMovableContent);
        MultiValueMap.a(this.f23965b, nestedMovableContent.a(), movableContent);
    }

    public final void b() {
        MultiValueMap.c(this.f23964a);
        MultiValueMap.c(this.f23965b);
    }

    public final boolean c(MovableContent movableContent) {
        return MultiValueMap.f(this.f23964a, movableContent);
    }

    public final NestedMovableContent d(MovableContent movableContent) {
        NestedMovableContent nestedMovableContent = (NestedMovableContent) MultiValueMap.m(this.f23964a, movableContent);
        if (MultiValueMap.j(this.f23964a)) {
            MultiValueMap.c(this.f23965b);
        }
        return nestedMovableContent;
    }

    public final void e(final MovableContentStateReference movableContentStateReference) {
        Object objE = this.f23965b.e(movableContentStateReference);
        if (objE != null) {
            if (!(objE instanceof MutableObjectList)) {
                Intrinsics.checkNotNull(objE, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                MultiValueMap.n(this.f23964a, (MovableContent) objE, new Function1<NestedMovableContent, Boolean>() { // from class: androidx.compose.runtime.NestedContentMap$usedContainer$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(NestedMovableContent nestedMovableContent) {
                        return Boolean.valueOf(Intrinsics.areEqual(nestedMovableContent.a(), movableContentStateReference));
                    }
                });
                return;
            }
            ObjectList objectList = (ObjectList) objE;
            Object[] objArr = objectList.f3081a;
            int i3 = objectList.f3082b;
            for (int i4 = 0; i4 < i3; i4++) {
                Object obj = objArr[i4];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                MultiValueMap.n(this.f23964a, (MovableContent) obj, new Function1<NestedMovableContent, Boolean>() { // from class: androidx.compose.runtime.NestedContentMap$usedContainer$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(NestedMovableContent nestedMovableContent) {
                        return Boolean.valueOf(Intrinsics.areEqual(nestedMovableContent.a(), movableContentStateReference));
                    }
                });
            }
        }
    }
}
