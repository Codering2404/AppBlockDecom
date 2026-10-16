package androidx.compose.runtime.saveable;

import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
final class SaveableHolder<T> implements SaverScope, RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Saver f24853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SaveableStateRegistry f24854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f24856d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object[] f24857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SaveableStateRegistry.Entry f24858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function0 f24859h = new Function0<Object>() { // from class: androidx.compose.runtime.saveable.SaveableHolder$valueProvider$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Saver saver = this.f24860a.f24853a;
            SaveableHolder saveableHolder = this.f24860a;
            Object obj = saveableHolder.f24856d;
            if (obj != null) {
                return saver.a(saveableHolder, obj);
            }
            throw new IllegalArgumentException("Value should be initialized");
        }
    };

    public SaveableHolder(Saver saver, SaveableStateRegistry saveableStateRegistry, String str, Object obj, Object[] objArr) {
        this.f24853a = saver;
        this.f24854b = saveableStateRegistry;
        this.f24855c = str;
        this.f24856d = obj;
        this.f24857f = objArr;
    }

    private final void h() {
        SaveableStateRegistry saveableStateRegistry = this.f24854b;
        if (this.f24858g == null) {
            if (saveableStateRegistry != null) {
                RememberSaveableKt.f(saveableStateRegistry, this.f24859h.invoke());
                this.f24858g = saveableStateRegistry.b(this.f24855c, this.f24859h);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("entry(" + this.f24858g + ") is not null").toString());
    }

    @Override // androidx.compose.runtime.saveable.SaverScope
    public boolean a(Object obj) {
        SaveableStateRegistry saveableStateRegistry = this.f24854b;
        return saveableStateRegistry == null || saveableStateRegistry.a(obj);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        h();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
        SaveableStateRegistry.Entry entry = this.f24858g;
        if (entry != null) {
            entry.a();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        SaveableStateRegistry.Entry entry = this.f24858g;
        if (entry != null) {
            entry.a();
        }
    }

    public final Object g(Object[] objArr) {
        if (Arrays.equals(objArr, this.f24857f)) {
            return this.f24856d;
        }
        return null;
    }

    public final void i(Saver saver, SaveableStateRegistry saveableStateRegistry, String str, Object obj, Object[] objArr) {
        boolean z2;
        boolean z3 = true;
        if (this.f24854b != saveableStateRegistry) {
            this.f24854b = saveableStateRegistry;
            z2 = true;
        } else {
            z2 = false;
        }
        if (Intrinsics.areEqual(this.f24855c, str)) {
            z3 = z2;
        } else {
            this.f24855c = str;
        }
        this.f24853a = saver;
        this.f24856d = obj;
        this.f24857f = objArr;
        SaveableStateRegistry.Entry entry = this.f24858g;
        if (entry == null || !z3) {
            return;
        }
        if (entry != null) {
            entry.a();
        }
        this.f24858g = null;
        h();
    }
}
