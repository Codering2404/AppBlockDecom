package androidx.compose.ui.text.input;

import androidx.compose.animation.core.h;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
@Deprecated
@Metadata
public class TextInputService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlatformTextInputService f29426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference f29427b = new AtomicReference(null);

    public TextInputService(PlatformTextInputService platformTextInputService) {
        this.f29426a = platformTextInputService;
    }

    public final TextInputSession a() {
        return (TextInputSession) this.f29427b.get();
    }

    public final void b() {
        this.f29426a.c();
    }

    public final void c() {
        if (a() != null) {
            this.f29426a.e();
        }
    }

    public TextInputSession d(TextFieldValue textFieldValue, ImeOptions imeOptions, Function1 function1, Function1 function12) {
        this.f29426a.f(textFieldValue, imeOptions, function1, function12);
        TextInputSession textInputSession = new TextInputSession(this, this.f29426a);
        this.f29427b.set(textInputSession);
        return textInputSession;
    }

    public final void e() {
        this.f29426a.a();
        this.f29427b.set(new TextInputSession(this, this.f29426a));
    }

    public final void f() {
        this.f29427b.set(null);
        this.f29426a.b();
    }

    public void g(TextInputSession textInputSession) {
        if (h.a(this.f29427b, textInputSession, null)) {
            this.f29426a.b();
        }
    }
}
