package androidx.paging;

import androidx.paging.PagedList;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RecordingCallback extends PagedList.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f50526b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f50527a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.paging.PagedList.Callback
    public void a(int i3, int i4) {
        this.f50527a.add(0);
        this.f50527a.add(Integer.valueOf(i3));
        this.f50527a.add(Integer.valueOf(i4));
    }

    @Override // androidx.paging.PagedList.Callback
    public void b(int i3, int i4) {
        this.f50527a.add(1);
        this.f50527a.add(Integer.valueOf(i3));
        this.f50527a.add(Integer.valueOf(i4));
    }

    @Override // androidx.paging.PagedList.Callback
    public void c(int i3, int i4) {
        this.f50527a.add(2);
        this.f50527a.add(Integer.valueOf(i3));
        this.f50527a.add(Integer.valueOf(i4));
    }
}
