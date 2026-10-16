package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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
public final class AndroidTextToolbar implements TextToolbar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f27882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ActionMode f27883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextActionModeCallback f27884c = new TextActionModeCallback(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidTextToolbar$textActionModeCallback$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m251invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m251invoke() {
            this.f27886a.f27883b = null;
        }
    }, null, null, null, null, null, null, 126, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextToolbarStatus f27885d = TextToolbarStatus.f28213b;

    public AndroidTextToolbar(View view) {
        this.f27882a = view;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void a() {
        this.f27885d = TextToolbarStatus.f28213b;
        ActionMode actionMode = this.f27883b;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.f27883b = null;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void b(Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04) {
        d(rect, function0, function02, function03, function04, null);
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void d(Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05) {
        this.f27884c.m(rect);
        this.f27884c.i(function0);
        this.f27884c.j(function03);
        this.f27884c.k(function02);
        this.f27884c.l(function04);
        this.f27884c.h(function05);
        ActionMode actionMode = this.f27883b;
        if (actionMode == null) {
            this.f27885d = TextToolbarStatus.f28212a;
            this.f27883b = TextToolbarHelperMethods.f28211a.a(this.f27882a, new FloatingTextActionModeCallback(this.f27884c), 1);
        } else if (actionMode != null) {
            actionMode.invalidate();
        }
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public TextToolbarStatus getStatus() {
        return this.f27885d;
    }
}
