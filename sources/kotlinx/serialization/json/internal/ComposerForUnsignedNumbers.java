package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ComposerForUnsignedNumbers extends Composer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f143075c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(InternalJsonWriter writer, boolean z2) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.f143075c = z2;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void e(byte b3) {
        boolean z2 = this.f143075c;
        String strE = UByte.e(UByte.b(b3));
        if (z2) {
            n(strE);
        } else {
            k(strE);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void i(int i3) {
        boolean z2 = this.f143075c;
        String unsignedString = Integer.toUnsignedString(UInt.b(i3));
        if (z2) {
            n(unsignedString);
        } else {
            k(unsignedString);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void j(long j3) {
        boolean z2 = this.f143075c;
        String unsignedString = Long.toUnsignedString(ULong.b(j3));
        if (z2) {
            n(unsignedString);
        } else {
            k(unsignedString);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void l(short s2) {
        boolean z2 = this.f143075c;
        String strE = UShort.e(UShort.b(s2));
        if (z2) {
            n(strE);
        } else {
            k(strE);
        }
    }
}
