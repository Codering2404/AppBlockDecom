package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.StaticLayout;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public StaticLayout a(StaticLayoutParams staticLayoutParams) {
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(staticLayoutParams.r(), staticLayoutParams.q(), staticLayoutParams.e(), staticLayoutParams.o(), staticLayoutParams.u());
        builderObtain.setTextDirection(staticLayoutParams.s());
        builderObtain.setAlignment(staticLayoutParams.a());
        builderObtain.setMaxLines(staticLayoutParams.n());
        builderObtain.setEllipsize(staticLayoutParams.c());
        builderObtain.setEllipsizedWidth(staticLayoutParams.d());
        builderObtain.setLineSpacing(staticLayoutParams.l(), staticLayoutParams.m());
        builderObtain.setIncludePad(staticLayoutParams.g());
        builderObtain.setBreakStrategy(staticLayoutParams.b());
        builderObtain.setHyphenationFrequency(staticLayoutParams.f());
        builderObtain.setIndents(staticLayoutParams.i(), staticLayoutParams.p());
        int i3 = Build.VERSION.SDK_INT;
        StaticLayoutFactory26.a(builderObtain, staticLayoutParams.h());
        StaticLayoutFactory28.a(builderObtain, staticLayoutParams.t());
        if (i3 >= 33) {
            StaticLayoutFactory33.b(builderObtain, staticLayoutParams.j(), staticLayoutParams.k());
        }
        if (i3 >= 35) {
            StaticLayoutFactory35.a(builderObtain);
        }
        return builderObtain.build();
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public boolean b(StaticLayout staticLayout, boolean z2) {
        return Build.VERSION.SDK_INT >= 33 ? StaticLayoutFactory33.a(staticLayout) : z2;
    }
}
