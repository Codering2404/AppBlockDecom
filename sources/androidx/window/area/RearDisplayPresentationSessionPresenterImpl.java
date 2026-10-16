package androidx.window.area;

import android.content.Context;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.WindowAreaComponent;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RearDisplayPresentationSessionPresenterImpl implements WindowAreaSessionPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowAreaComponent f54026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExtensionWindowAreaPresentation f54027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f54028c;

    public RearDisplayPresentationSessionPresenterImpl(WindowAreaComponent windowAreaComponent, ExtensionWindowAreaPresentation presentation) {
        Intrinsics.checkNotNullParameter(windowAreaComponent, "windowAreaComponent");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        this.f54026a = windowAreaComponent;
        this.f54027b = presentation;
        Context presentationContext = presentation.getPresentationContext();
        Intrinsics.checkNotNullExpressionValue(presentationContext, "presentation.presentationContext");
        this.f54028c = presentationContext;
    }
}
