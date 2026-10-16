package androidx.compose.ui.res;

import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ImageVectorCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f28380a = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ImageVectorEntry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImageVector f28381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f28382b;

        public ImageVectorEntry(ImageVector imageVector, int i3) {
            this.f28381a = imageVector;
            this.f28382b = i3;
        }

        public final int a() {
            return this.f28382b;
        }

        public final ImageVector b() {
            return this.f28381a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImageVectorEntry)) {
                return false;
            }
            ImageVectorEntry imageVectorEntry = (ImageVectorEntry) obj;
            return Intrinsics.areEqual(this.f28381a, imageVectorEntry.f28381a) && this.f28382b == imageVectorEntry.f28382b;
        }

        public int hashCode() {
            return (this.f28381a.hashCode() * 31) + Integer.hashCode(this.f28382b);
        }

        public String toString() {
            return "ImageVectorEntry(imageVector=" + this.f28381a + ", configFlags=" + this.f28382b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources.Theme f28383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f28384b;

        public Key(Resources.Theme theme, int i3) {
            this.f28383a = theme;
            this.f28384b = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.areEqual(this.f28383a, key.f28383a) && this.f28384b == key.f28384b;
        }

        public int hashCode() {
            return (this.f28383a.hashCode() * 31) + Integer.hashCode(this.f28384b);
        }

        public String toString() {
            return "Key(theme=" + this.f28383a + ", id=" + this.f28384b + ')';
        }
    }

    public final void a() {
        this.f28380a.clear();
    }

    public final ImageVectorEntry b(Key key) {
        WeakReference weakReference = (WeakReference) this.f28380a.get(key);
        if (weakReference != null) {
            return (ImageVectorEntry) weakReference.get();
        }
        return null;
    }

    public final void c(int i3) {
        Iterator it = this.f28380a.entrySet().iterator();
        while (it.hasNext()) {
            ImageVectorEntry imageVectorEntry = (ImageVectorEntry) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
            if (imageVectorEntry == null || Configuration.needNewResources(i3, imageVectorEntry.a())) {
                it.remove();
            }
        }
    }

    public final void d(Key key, ImageVectorEntry imageVectorEntry) {
        this.f28380a.put(key, new WeakReference(imageVectorEntry));
    }
}
