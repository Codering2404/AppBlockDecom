package androidx.compose.runtime;

import java.util.List;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MovableContentStateReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MovableContent f23956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f23957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ControlledComposition f23958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SlotTable f23959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Anchor f23960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f23961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PersistentCompositionLocalMap f23962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f23963h;

    public MovableContentStateReference(MovableContent movableContent, Object obj, ControlledComposition controlledComposition, SlotTable slotTable, Anchor anchor, List list, PersistentCompositionLocalMap persistentCompositionLocalMap, List list2) {
        this.f23956a = movableContent;
        this.f23957b = obj;
        this.f23958c = controlledComposition;
        this.f23959d = slotTable;
        this.f23960e = anchor;
        this.f23961f = list;
        this.f23962g = persistentCompositionLocalMap;
        this.f23963h = list2;
    }

    public final Anchor a() {
        return this.f23960e;
    }

    public final ControlledComposition b() {
        return this.f23958c;
    }

    public final MovableContent c() {
        return this.f23956a;
    }

    public final List d() {
        return this.f23961f;
    }

    public final PersistentCompositionLocalMap e() {
        return this.f23962g;
    }

    public final List f() {
        return this.f23963h;
    }

    public final Object g() {
        return this.f23957b;
    }

    public final SlotTable h() {
        return this.f23959d;
    }

    public final void i(List list) {
        this.f23961f = list;
    }
}
