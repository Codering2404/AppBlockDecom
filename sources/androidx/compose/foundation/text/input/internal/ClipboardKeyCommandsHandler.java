package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class ClipboardKeyCommandsHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f10247a;

    public static boolean b(Function1 function1, Object obj) {
        return (obj instanceof ClipboardKeyCommandsHandler) && Intrinsics.areEqual(function1, ((ClipboardKeyCommandsHandler) obj).e());
    }

    public static int c(Function1 function1) {
        return function1.hashCode();
    }

    public static String d(Function1 function1) {
        return "ClipboardKeyCommandsHandler(handler=" + function1 + ')';
    }

    public final /* synthetic */ Function1 e() {
        return this.f10247a;
    }

    public boolean equals(Object obj) {
        return b(this.f10247a, obj);
    }

    public int hashCode() {
        return c(this.f10247a);
    }

    public String toString() {
        return d(this.f10247a);
    }

    public static Function1 a(Function1 function1) {
        return function1;
    }
}
