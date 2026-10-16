package androidx.compose.ui.platform;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
public final class ComposeView extends AbstractComposeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f27963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f27964b;

    public ComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, int i3) {
        composer.a0(420213850);
        if (ComposerKt.M()) {
            ComposerKt.U(420213850, i3, -1, "androidx.compose.ui.platform.ComposeView.Content (ComposeView.android.kt:429)");
        }
        Function2 function2 = (Function2) this.f27963a.getValue();
        if (function2 == null) {
            composer.a0(358356153);
        } else {
            composer.a0(150107208);
            function2.invoke(composer, 0);
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return ComposeView.class.getName();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f27964b;
    }

    public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.f27964b = true;
        this.f27963a.setValue(function2);
        if (isAttachedToWindow()) {
            createComposition();
        }
    }

    public /* synthetic */ ComposeView(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }

    public ComposeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f27963a = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
    }

    protected static /* synthetic */ void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }
}
