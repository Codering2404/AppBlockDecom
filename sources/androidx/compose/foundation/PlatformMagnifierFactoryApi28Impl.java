package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PlatformMagnifierFactoryApi28Impl implements PlatformMagnifierFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PlatformMagnifierFactoryApi28Impl f5109b = new PlatformMagnifierFactoryApi28Impl();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f5110c = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class PlatformMagnifierImpl implements PlatformMagnifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Magnifier f5111a;

        public PlatformMagnifierImpl(Magnifier magnifier) {
            this.f5111a = magnifier;
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        public long a() {
            return IntSize.c((((long) this.f5111a.getHeight()) & 4294967295L) | (((long) this.f5111a.getWidth()) << 32));
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        public void b(long j3, long j4, float f3) {
            this.f5111a.show(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        public void c() {
            this.f5111a.update();
        }

        public final Magnifier d() {
            return this.f5111a;
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        public void dismiss() {
            this.f5111a.dismiss();
        }
    }

    private PlatformMagnifierFactoryApi28Impl() {
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean b() {
        return f5110c;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public PlatformMagnifierImpl a(View view, boolean z2, long j3, float f3, float f4, boolean z3, Density density, float f5) {
        return new PlatformMagnifierImpl(new Magnifier(view));
    }
}
