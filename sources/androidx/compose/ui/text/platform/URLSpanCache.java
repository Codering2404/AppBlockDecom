package androidx.compose.ui.text.platform;

import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.UrlAnnotation;
import java.util.WeakHashMap;
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
public final class URLSpanCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap f29526a = new WeakHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakHashMap f29527b = new WeakHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakHashMap f29528c = new WeakHashMap();

    public final ClickableSpan a(AnnotatedString.Range range) {
        WeakHashMap weakHashMap = this.f29528c;
        Object composeClickableSpan = weakHashMap.get(range);
        if (composeClickableSpan == null) {
            composeClickableSpan = new ComposeClickableSpan((LinkAnnotation) range.g());
            weakHashMap.put(range, composeClickableSpan);
        }
        return (ClickableSpan) composeClickableSpan;
    }

    public final URLSpan b(AnnotatedString.Range range) {
        WeakHashMap weakHashMap = this.f29527b;
        Object uRLSpan = weakHashMap.get(range);
        if (uRLSpan == null) {
            uRLSpan = new URLSpan(((LinkAnnotation.Url) range.g()).c());
            weakHashMap.put(range, uRLSpan);
        }
        return (URLSpan) uRLSpan;
    }

    public final URLSpan c(UrlAnnotation urlAnnotation) {
        WeakHashMap weakHashMap = this.f29526a;
        Object uRLSpan = weakHashMap.get(urlAnnotation);
        if (uRLSpan == null) {
            uRLSpan = new URLSpan(urlAnnotation.a());
            weakHashMap.put(urlAnnotation, uRLSpan);
        }
        return (URLSpan) uRLSpan;
    }
}
