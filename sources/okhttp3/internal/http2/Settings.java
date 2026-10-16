package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class Settings {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f144783c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f144784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f144785b = new int[10];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int a(int i3) {
        return this.f144785b[i3];
    }

    public final int b() {
        if ((this.f144784a & 2) != 0) {
            return this.f144785b[1];
        }
        return -1;
    }

    public final int c() {
        if ((this.f144784a & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            return this.f144785b[7];
        }
        return 65535;
    }

    public final int d() {
        return (this.f144784a & 16) != 0 ? this.f144785b[4] : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int e(int i3) {
        return (this.f144784a & 32) != 0 ? this.f144785b[5] : i3;
    }

    public final boolean f(int i3) {
        return ((1 << i3) & this.f144784a) != 0;
    }

    public final void g(Settings other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i3 = 0;
        while (i3 < 10) {
            int i4 = i3 + 1;
            if (other.f(i3)) {
                h(i3, other.a(i3));
            }
            i3 = i4;
        }
    }

    public final Settings h(int i3, int i4) {
        if (i3 >= 0) {
            int[] iArr = this.f144785b;
            if (i3 < iArr.length) {
                this.f144784a = (1 << i3) | this.f144784a;
                iArr[i3] = i4;
            }
        }
        return this;
    }

    public final int i() {
        return Integer.bitCount(this.f144784a);
    }
}
