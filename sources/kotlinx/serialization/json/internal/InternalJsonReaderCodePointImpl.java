package kotlinx.serialization.json.internal;

import kotlin.Metadata;
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
@JsonFriendModuleApi
@Metadata
public abstract class InternalJsonReaderCodePointImpl implements InternalJsonReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Character f143079a;

    @Override // kotlinx.serialization.json.internal.InternalJsonReader
    public final int a(char[] buffer, int i3, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Character ch = this.f143079a;
        if (ch != null) {
            Intrinsics.checkNotNull(ch);
            buffer[i3] = ch.charValue();
            this.f143079a = null;
            i5 = 1;
        } else {
            i5 = 0;
        }
        while (i5 < i4 && !b()) {
            int iC = c();
            if (iC <= 65535) {
                buffer[i3 + i5] = (char) iC;
                i5++;
            } else {
                char c3 = (char) ((iC >>> 10) + 55232);
                char c4 = (char) ((iC & 1023) + 56320);
                buffer[i3 + i5] = c3;
                int i6 = i5 + 1;
                if (i6 < i4) {
                    buffer[i6 + i3] = c4;
                    i5 += 2;
                } else {
                    this.f143079a = Character.valueOf(c4);
                    i5 = i6;
                }
            }
        }
        if (i5 > 0) {
            return i5;
        }
        return -1;
    }

    public abstract boolean b();

    public abstract int c();
}
