package androidx.paging;

import com.google.android.gms.common.api.Api;
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
public final class PagingConfig {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f50305g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f50307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f50308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f50309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f50310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f50311f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PagingConfig(int i3, int i4, boolean z2, int i5, int i6, int i7) {
        this.f50306a = i3;
        this.f50307b = i4;
        this.f50308c = z2;
        this.f50309d = i5;
        this.f50310e = i6;
        this.f50311f = i7;
        if (!z2 && i4 == 0) {
            throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in PagingData, so either placeholders must be enabled, or prefetch distance must be > 0.");
        }
        if (i6 == Integer.MAX_VALUE || i6 >= (i4 * 2) + i3) {
            if (i7 != Integer.MIN_VALUE && i7 <= 0) {
                throw new IllegalArgumentException("jumpThreshold must be positive to enable jumps or COUNT_UNDEFINED to disable jumping.");
            }
            return;
        }
        throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + i3 + ", prefetchDist=" + i4 + ", maxSize=" + i6);
    }

    public /* synthetic */ PagingConfig(int i3, int i4, boolean z2, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i8 & 2) != 0 ? i3 : i4, (i8 & 4) != 0 ? true : z2, (i8 & 8) != 0 ? i3 * 3 : i5, (i8 & 16) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i6, (i8 & 32) != 0 ? Integer.MIN_VALUE : i7);
    }
}
