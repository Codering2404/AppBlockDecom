package androidx.compose.ui.tooling.data;

import androidx.compose.ui.unit.IntRect;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class Group {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f29915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SourceLocation f29917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f29918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final IntRect f29919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Collection f29920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Collection f29921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f29922h;

    public /* synthetic */ Group(Object obj, String str, SourceLocation sourceLocation, Object obj2, IntRect intRect, Collection collection, Collection collection2, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, sourceLocation, obj2, intRect, collection, collection2, z2);
    }

    public final IntRect a() {
        return this.f29919e;
    }

    public final Collection b() {
        return this.f29921g;
    }

    public final Collection c() {
        return this.f29920f;
    }

    public final SourceLocation d() {
        return this.f29917c;
    }

    public List e() {
        return CollectionsKt.emptyList();
    }

    public final String f() {
        return this.f29916b;
    }

    private Group(Object obj, String str, SourceLocation sourceLocation, Object obj2, IntRect intRect, Collection collection, Collection collection2, boolean z2) {
        this.f29915a = obj;
        this.f29916b = str;
        this.f29917c = sourceLocation;
        this.f29918d = obj2;
        this.f29919e = intRect;
        this.f29920f = collection;
        this.f29921g = collection2;
        this.f29922h = z2;
    }
}
