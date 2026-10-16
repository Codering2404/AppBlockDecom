package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface FocusProperties {
    default FocusRequester a() {
        return FocusRequester.f25519b.b();
    }

    default FocusRequester b() {
        return FocusRequester.f25519b.b();
    }

    default FocusRequester m() {
        return FocusRequester.f25519b.b();
    }

    default FocusRequester p() {
        return FocusRequester.f25519b.b();
    }

    default FocusRequester q() {
        return FocusRequester.f25519b.b();
    }

    default FocusRequester r() {
        return FocusRequester.f25519b.b();
    }

    default FocusRequester s() {
        return FocusRequester.f25519b.b();
    }

    void t(boolean z2);

    boolean v();

    default FocusRequester w() {
        return FocusRequester.f25519b.b();
    }

    default Function1 x() {
        return new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusProperties$onEnter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((FocusEnterExitScope) obj);
                return Unit.f139807a;
            }

            public final void c(FocusEnterExitScope focusEnterExitScope) {
            }
        };
    }

    default Function1 y() {
        return new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusProperties$onExit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((FocusEnterExitScope) obj);
                return Unit.f139807a;
            }

            public final void c(FocusEnterExitScope focusEnterExitScope) {
            }
        };
    }

    default void u(Function1 function1) {
    }

    default void z(Function1 function1) {
    }
}
