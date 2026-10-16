package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public final class EditProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextFieldValue f29333a = new TextFieldValue(AnnotatedStringKt.e(), TextRange.f28921b.a(), (TextRange) null, (DefaultConstructorMarker) null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EditingBuffer f29334b = new EditingBuffer(this.f29333a.f(), this.f29333a.h(), null);

    private final String c(List list, final EditCommand editCommand) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while applying EditCommand batch to buffer (length=" + this.f29334b.h() + ", composition=" + this.f29334b.d() + ", selection=" + ((Object) TextRange.q(this.f29334b.i())) + "):");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        CollectionsKt___CollectionsKt.joinTo(list, sb, (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new Function1<EditCommand, CharSequence>() { // from class: androidx.compose.ui.text.input.EditProcessor$generateBatchErrorMessage$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(EditCommand editCommand2) {
                return (editCommand == editCommand2 ? " > " : "   ") + this.e(editCommand2);
            }
        });
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            StringBuilder sb = new StringBuilder();
            sb.append("CommitTextCommand(text.length=");
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            sb.append(commitTextCommand.c().length());
            sb.append(", newCursorPosition=");
            sb.append(commitTextCommand.b());
            sb.append(')');
            return sb.toString();
        }
        if (editCommand instanceof SetComposingTextCommand) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SetComposingTextCommand(text.length=");
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            sb2.append(setComposingTextCommand.c().length());
            sb2.append(", newCursorPosition=");
            sb2.append(setComposingTextCommand.b());
            sb2.append(')');
            return sb2.toString();
        }
        if (editCommand instanceof SetComposingRegionCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof DeleteSurroundingTextCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof DeleteSurroundingTextInCodePointsCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof SetSelectionCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof FinishComposingTextCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof BackspaceCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof MoveCursorCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof DeleteAllCommand) {
            return editCommand.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Unknown EditCommand: ");
        String strM = Reflection.b(editCommand.getClass()).m();
        if (strM == null) {
            strM = "{anonymous EditCommand}";
        }
        sb3.append(strM);
        return sb3.toString();
    }

    public final TextFieldValue b(List list) {
        EditCommand editCommand;
        EditCommand editCommand2 = null;
        try {
            int size = list.size();
            int i3 = 0;
            EditCommand editCommand3 = null;
            while (i3 < size) {
                try {
                    editCommand = (EditCommand) list.get(i3);
                } catch (Exception e3) {
                    e = e3;
                    editCommand2 = editCommand3;
                }
                try {
                    editCommand.a(this.f29334b);
                    i3++;
                    editCommand3 = editCommand;
                } catch (Exception e4) {
                    e = e4;
                    editCommand2 = editCommand;
                    throw new RuntimeException(c(list, editCommand2), e);
                }
            }
            AnnotatedString annotatedStringS = this.f29334b.s();
            long jI = this.f29334b.i();
            TextRange textRangeB = TextRange.b(jI);
            textRangeB.r();
            TextRange textRange = TextRange.m(this.f29333a.h()) ? null : textRangeB;
            TextFieldValue textFieldValue = new TextFieldValue(annotatedStringS, textRange != null ? textRange.r() : TextRangeKt.b(TextRange.k(jI), TextRange.l(jI)), this.f29334b.d(), (DefaultConstructorMarker) null);
            this.f29333a = textFieldValue;
            return textFieldValue;
        } catch (Exception e5) {
            e = e5;
        }
    }

    public final void d(TextFieldValue textFieldValue, TextInputSession textInputSession) {
        boolean zAreEqual = Intrinsics.areEqual(textFieldValue.g(), this.f29334b.d());
        boolean z2 = true;
        boolean z3 = false;
        if (!Intrinsics.areEqual(this.f29333a.f().k(), textFieldValue.f().k())) {
            this.f29334b = new EditingBuffer(textFieldValue.f(), textFieldValue.h(), null);
        } else if (TextRange.g(this.f29333a.h(), textFieldValue.h())) {
            z2 = false;
        } else {
            this.f29334b.p(TextRange.l(textFieldValue.h()), TextRange.k(textFieldValue.h()));
            z3 = true;
            z2 = false;
        }
        if (textFieldValue.g() == null) {
            this.f29334b.a();
        } else if (!TextRange.h(textFieldValue.g().r())) {
            this.f29334b.n(TextRange.l(textFieldValue.g().r()), TextRange.k(textFieldValue.g().r()));
        }
        if (z2 || (!z3 && !zAreEqual)) {
            this.f29334b.a();
            textFieldValue = TextFieldValue.d(textFieldValue, null, 0L, null, 3, null);
        }
        TextFieldValue textFieldValue2 = this.f29333a;
        this.f29333a = textFieldValue;
        if (textInputSession != null) {
            textInputSession.d(textFieldValue2, textFieldValue);
        }
    }

    public final TextFieldValue f() {
        return this.f29333a;
    }
}
