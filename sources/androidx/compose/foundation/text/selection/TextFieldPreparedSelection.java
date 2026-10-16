package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class TextFieldPreparedSelection extends BaseTextPreparedSelection<TextFieldPreparedSelection> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextFieldValue f11516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final TextLayoutResultProxy f11517k;

    public TextFieldPreparedSelection(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy, TextPreparedSelectionState textPreparedSelectionState) {
        super(textFieldValue.f(), textFieldValue.h(), textLayoutResultProxy != null ? textLayoutResultProxy.f() : null, offsetMapping, textPreparedSelectionState, null);
        this.f11516j = textFieldValue;
        this.f11517k = textLayoutResultProxy;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a0(androidx.compose.foundation.text.TextLayoutResultProxy r9, int r10) {
        /*
            r8 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r9.c()
            if (r0 == 0) goto L15
            androidx.compose.ui.layout.LayoutCoordinates r1 = r9.b()
            r2 = 0
            if (r1 == 0) goto L13
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.LayoutCoordinates.R(r1, r0, r3, r4, r2)
        L13:
            if (r2 != 0) goto L1b
        L15:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.f25601e
            androidx.compose.ui.geometry.Rect r2 = r0.a()
        L1b:
            androidx.compose.ui.text.input.OffsetMapping r0 = r8.p()
            androidx.compose.ui.text.input.TextFieldValue r1 = r8.f11516j
            long r3 = r1.h()
            int r1 = androidx.compose.ui.text.TextRange.i(r3)
            int r0 = r0.b(r1)
            androidx.compose.ui.text.TextLayoutResult r1 = r9.f()
            androidx.compose.ui.geometry.Rect r0 = r1.e(r0)
            float r1 = r0.o()
            float r0 = r0.r()
            long r2 = r2.q()
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            int r2 = (int) r2
            float r2 = java.lang.Float.intBitsToFloat(r2)
            float r10 = (float) r10
            float r2 = r2 * r10
            float r0 = r0 + r2
            androidx.compose.ui.text.input.OffsetMapping r10 = r8.p()
            androidx.compose.ui.text.TextLayoutResult r9 = r9.f()
            int r1 = java.lang.Float.floatToRawIntBits(r1)
            long r1 = (long) r1
            int r0 = java.lang.Float.floatToRawIntBits(r0)
            long r6 = (long) r0
            r0 = 32
            long r0 = r1 << r0
            long r2 = r6 & r4
            long r0 = r0 | r2
            long r0 = androidx.compose.ui.geometry.Offset.e(r0)
            int r9 = r9.x(r0)
            int r9 = r10.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.a0(androidx.compose.foundation.text.TextLayoutResultProxy, int):int");
    }

    public final List Y(Function1 function1) {
        if (!TextRange.h(u())) {
            return CollectionsKt.listOf((Object[]) new EditCommand[]{new CommitTextCommand("", 0), new SetSelectionCommand(TextRange.l(u()), TextRange.l(u()))});
        }
        EditCommand editCommand = (EditCommand) function1.invoke(this);
        if (editCommand != null) {
            return CollectionsKt.listOf(editCommand);
        }
        return null;
    }

    public final TextFieldValue Z() {
        return TextFieldValue.d(this.f11516j, e(), u(), null, 4, null);
    }

    public final TextFieldPreparedSelection b0() {
        TextLayoutResultProxy textLayoutResultProxy;
        if (w().length() > 0 && (textLayoutResultProxy = this.f11517k) != null) {
            T(a0(textLayoutResultProxy, 1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final TextFieldPreparedSelection c0() {
        TextLayoutResultProxy textLayoutResultProxy;
        if (w().length() > 0 && (textLayoutResultProxy = this.f11517k) != null) {
            T(a0(textLayoutResultProxy, -1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }
}
