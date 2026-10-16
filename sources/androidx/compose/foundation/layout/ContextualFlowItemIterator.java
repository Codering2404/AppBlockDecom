package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class ContextualFlowItemIterator implements Iterator<Measurable>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f6689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f6690c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6691d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6692f;

    public ContextualFlowItemIterator(int i3, Function2 function2) {
        this.f6688a = i3;
        this.f6689b = function2;
    }

    public static /* synthetic */ Measurable c(ContextualFlowItemIterator contextualFlowItemIterator, FlowLineInfo flowLineInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            flowLineInfo = new FlowLineInfo(0, 0, 0.0f, 0.0f, 15, null);
        }
        return contextualFlowItemIterator.b(flowLineInfo);
    }

    public final List a() {
        return this.f6690c;
    }

    public final Measurable b(FlowLineInfo flowLineInfo) {
        if (this.f6692f < a().size()) {
            Measurable measurable = (Measurable) a().get(this.f6692f);
            this.f6692f++;
            return measurable;
        }
        int i3 = this.f6691d;
        if (i3 >= this.f6688a) {
            throw new IndexOutOfBoundsException("No item returned at index call. Index: " + this.f6691d);
        }
        List list = (List) this.f6689b.invoke(Integer.valueOf(i3), flowLineInfo);
        this.f6691d++;
        if (list.isEmpty()) {
            return next();
        }
        Measurable measurable2 = (Measurable) CollectionsKt.first(list);
        this.f6690c.addAll(list);
        this.f6692f++;
        return measurable2;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Measurable next() {
        return c(this, null, 1, null);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f6692f < a().size() || this.f6691d < this.f6688a;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
