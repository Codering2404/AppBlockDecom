package androidx.savedstate;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class SavedStateRegistryController {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f53001c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SavedStateRegistryImpl f53002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SavedStateRegistry f53003b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(SavedStateRegistryOwner savedStateRegistryOwner) {
            savedStateRegistryOwner.getLifecycle().addObserver(new Recreator(savedStateRegistryOwner));
            return Unit.f139807a;
        }

        public final SavedStateRegistryController b(final SavedStateRegistryOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            return new SavedStateRegistryController(new SavedStateRegistryImpl(owner, new Function0() { // from class: androidx.savedstate.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SavedStateRegistryController.Companion.c(owner);
                }
            }), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryImpl savedStateRegistryImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(savedStateRegistryImpl);
    }

    public static final SavedStateRegistryController a(SavedStateRegistryOwner savedStateRegistryOwner) {
        return f53001c.b(savedStateRegistryOwner);
    }

    public final SavedStateRegistry b() {
        return this.f53003b;
    }

    public final void c() {
        this.f53002a.f();
    }

    public final void d(Bundle bundle) {
        this.f53002a.h(bundle);
    }

    public final void e(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        this.f53002a.i(outBundle);
    }

    private SavedStateRegistryController(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.f53002a = savedStateRegistryImpl;
        this.f53003b = new SavedStateRegistry(savedStateRegistryImpl);
    }
}
