package kotlinx.collections.immutable;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.collections.immutable.internal.ListImplementation;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public interface ImmutableList<E> extends List<E>, ImmutableCollection<E>, KMappedMarker {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static ImmutableList a(ImmutableList immutableList, int i3, int i4) {
            Intrinsics.checkNotNullParameter(immutableList, "this");
            return new SubList(immutableList, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SubList<E> extends AbstractList<E> implements ImmutableList<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableList f140689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f140690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f140691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f140692d;

        public SubList(ImmutableList source, int i3, int i4) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f140689a = source;
            this.f140690b = i3;
            this.f140691c = i4;
            ListImplementation.c(i3, i4, source.size());
            this.f140692d = i4 - i3;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Object get(int i3) {
            ListImplementation.a(i3, this.f140692d);
            return this.f140689a.get(this.f140690b + i3);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f140692d;
        }

        @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
        public ImmutableList subList(int i3, int i4) {
            ListImplementation.c(i3, i4, this.f140692d);
            ImmutableList immutableList = this.f140689a;
            int i5 = this.f140690b;
            return new SubList(immutableList, i3 + i5, i5 + i4);
        }
    }

    @Override // java.util.List
    ImmutableList subList(int i3, int i4);
}
