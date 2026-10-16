package androidx.compose.ui.input.key;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
public final class KeyEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.view.KeyEvent f26730a;

    private /* synthetic */ KeyEvent(android.view.KeyEvent keyEvent) {
        this.f26730a = keyEvent;
    }

    public static final /* synthetic */ KeyEvent a(android.view.KeyEvent keyEvent) {
        return new KeyEvent(keyEvent);
    }

    public static boolean c(android.view.KeyEvent keyEvent, Object obj) {
        return (obj instanceof KeyEvent) && Intrinsics.areEqual(keyEvent, ((KeyEvent) obj).f());
    }

    public static int d(android.view.KeyEvent keyEvent) {
        return keyEvent.hashCode();
    }

    public static String e(android.view.KeyEvent keyEvent) {
        return "KeyEvent(nativeKeyEvent=" + keyEvent + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f26730a, obj);
    }

    public final /* synthetic */ android.view.KeyEvent f() {
        return this.f26730a;
    }

    public int hashCode() {
        return d(this.f26730a);
    }

    public String toString() {
        return e(this.f26730a);
    }

    public static android.view.KeyEvent b(android.view.KeyEvent keyEvent) {
        return keyEvent;
    }
}
