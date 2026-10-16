package androidx.compose.ui.res;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.Unit;

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
public final class ResourceIdCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableIntObjectMap f28385a = new MutableIntObjectMap(0, 1, null);

    public final void a() {
        synchronized (this) {
            this.f28385a.g();
            Unit unit = Unit.f139807a;
        }
    }

    public final TypedValue b(Resources resources, int i3) {
        TypedValue typedValue;
        synchronized (this) {
            typedValue = (TypedValue) this.f28385a.b(i3);
            if (typedValue == null) {
                typedValue = new TypedValue();
                resources.getValue(i3, typedValue, true);
                this.f28385a.n(i3, typedValue);
            }
        }
        return typedValue;
    }
}
