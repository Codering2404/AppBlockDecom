package androidx.compose.ui.graphics.colorspace;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.graphics.colorspace.RenderIntent;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ConnectorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MutableIntObjectMap f26015a;

    static {
        ColorSpaces colorSpaces = ColorSpaces.f25979a;
        int iD = colorSpaces.G().d();
        int iD2 = colorSpaces.G().d();
        RenderIntent.Companion companion = RenderIntent.f26033b;
        DefaultConstructorMarker defaultConstructorMarker = null;
        f26015a = IntObjectMapKt.d(iD | (iD2 << 6) | (companion.b() << 12), Connector.f26005g.c(colorSpaces.G()), colorSpaces.G().d() | (colorSpaces.D().d() << 6) | (companion.b() << 12), new Connector(colorSpaces.G(), colorSpaces.D(), companion.b(), defaultConstructorMarker), colorSpaces.D().d() | (colorSpaces.G().d() << 6) | (companion.b() << 12), new Connector(colorSpaces.D(), colorSpaces.G(), companion.b(), defaultConstructorMarker));
    }

    public static final MutableIntObjectMap a() {
        return f26015a;
    }
}
