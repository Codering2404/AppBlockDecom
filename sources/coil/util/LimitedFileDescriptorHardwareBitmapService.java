package coil.util;

import coil.size.Dimension;
import coil.size.Size;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
final class LimitedFileDescriptorHardwareBitmapService implements HardwareBitmapService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f56238b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Logger f56239a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // coil.util.HardwareBitmapService
    public boolean a(Size size) {
        Dimension dimensionD = size.d();
        boolean z2 = dimensionD instanceof Dimension.Pixels;
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if ((z2 ? ((Dimension.Pixels) dimensionD).f56163a : Integer.MAX_VALUE) <= 100) {
            return false;
        }
        Dimension dimensionC = size.c();
        if (dimensionC instanceof Dimension.Pixels) {
            i3 = ((Dimension.Pixels) dimensionC).f56163a;
        }
        return i3 > 100;
    }

    @Override // coil.util.HardwareBitmapService
    public boolean b() {
        return FileDescriptorCounter.f56227a.b(this.f56239a);
    }
}
