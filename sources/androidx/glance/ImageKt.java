package androidx.glance;

import androidx.glance.GlanceModifier;
import androidx.glance.semantics.SemanticsConfiguration;
import androidx.glance.semantics.SemanticsModifier;
import androidx.glance.semantics.SemanticsProperties;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

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
public final class ImageKt {
    /* JADX WARN: Removed duplicated region for block: B:61:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0155 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.glance.ImageProvider r12, final java.lang.String r13, androidx.glance.GlanceModifier r14, int r15, androidx.glance.ColorFilter r16, androidx.compose.runtime.Composer r17, final int r18, final int r19) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.ImageKt.a(androidx.glance.ImageProvider, java.lang.String, androidx.glance.GlanceModifier, int, androidx.glance.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ImageProvider b(int i3) {
        return new AndroidResourceImageProvider(i3);
    }

    public static final boolean c(EmittableImage emittableImage) {
        List list;
        String str = null;
        SemanticsModifier semanticsModifier = (SemanticsModifier) emittableImage.a().foldIn(null, new Function2<SemanticsModifier, GlanceModifier.Element, SemanticsModifier>() { // from class: androidx.glance.ImageKt$isDecorative$$inlined$findModifier$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof SemanticsModifier ? element : obj;
            }
        });
        SemanticsConfiguration semanticsConfigurationB = semanticsModifier != null ? semanticsModifier.b() : null;
        if (semanticsConfigurationB != null && (list = (List) semanticsConfigurationB.c(SemanticsProperties.f39517a.a())) != null) {
            str = (String) list.get(0);
        }
        return str == null || str.length() == 0;
    }
}
